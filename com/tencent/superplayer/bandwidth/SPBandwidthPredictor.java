package com.tencent.superplayer.bandwidth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.NetworkUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class SPBandwidthPredictor implements ISPBandwidthPredictor, Handler.Callback, b {
    public static final String CONFIG_ENABLE_SAMPLE_FILTER = "enable_sample_filter";
    public static final String CONFIG_RESET_TIME_SECOND_FOR_WIFI = "reset_time_threshold_wifi";
    public static final String CONFIG_RESET_TIME_SECOND_FOR_XG = "reset_time_threshold_xg";
    private static final float DEFAULT_EXO_WEIGHT = 5.0f;
    private static final int DEFAULT_RESET_TIME_THRESHOLD_WIFI = 3600;
    private static final int DEFAULT_RESET_TIME_THRESHOLD_XG = 600;
    private static final long INTERVAL_SAMPLE = 1000;
    public static final boolean LOG = false;
    private static final long MAX_SAMPLE_THRESHOLD = 200;
    private static final int MSG_SAMPLE = 0;
    private static final int SAMPLE_EXPIRE_DURATION = 5;
    private static final String TAG = "BandwidthPredictor";
    private static volatile NetworkCallbackImpl networkCallback = null;
    private static volatile NetworkChangeReceiver networkChangeReceiver = null;
    private static final List<WeakReference<b>> networkListeners = new ArrayList();
    public static boolean sIsAppForeground = true;
    private final Context appContext;
    private ArrayList<IBandwidthObtainer> bandwidthObtainers;
    private ArrayList<AbstractPredictor> bandwidthPredictors;
    private Map<String, String> configMap;
    private long currentPrediction;
    private boolean forceEnableSampleFilter;
    private final Handler handler;
    private int idleTimes;
    private boolean idleing;
    private long lastBandwidth;
    private long lastRestTimeStamp;
    private StringBuilder logBuilder;
    private final c playerBandwidthObtainer;
    private long resetTimeThreshold;
    private long sampleThreshold;
    private int scene;

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* loaded from: classes26.dex */
    public static final class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        NetworkCallbackImpl() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@Nullable Network network) {
            SPBandwidthPredictor.dispatchNetworkChanged();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@Nullable Network network) {
            SPBandwidthPredictor.dispatchNetworkChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static final class NetworkChangeReceiver extends BroadcastReceiver {
        NetworkChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, @NonNull Intent intent) {
            SPBandwidthPredictor.dispatchNetworkChanged();
        }
    }

    public SPBandwidthPredictor(Context context) {
        this(context, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchNetworkChanged() {
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : new ArrayList(networkListeners)) {
            if (weakReference != null) {
                b bVar = (b) weakReference.get();
                if (bVar != null) {
                    bVar.onNetChanged();
                } else {
                    arrayList.add(weakReference);
                }
            }
        }
        LogUtil.d(TAG, "dispatchNetworkChanged: toRemoveList.size=" + arrayList.size());
        try {
            networkListeners.removeAll(arrayList);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private long getCurrentBandwidth() {
        Iterator<IBandwidthObtainer> it = this.bandwidthObtainers.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            IBandwidthObtainer next = it.next();
            long currentBandwidth = next.getCurrentBandwidth();
            j3 = Math.max(currentBandwidth, j3);
            StringBuilder sb5 = this.logBuilder;
            if (sb5 != null) {
                sb5.append("{obtainer=");
                sb5.append(next.getClass().getSimpleName());
                sb5.append(", bandwidth=");
                sb5.append(currentBandwidth);
                sb5.append("}, ");
            }
        }
        return j3;
    }

    private void predict() {
        Iterator<AbstractPredictor> it = this.bandwidthPredictors.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            AbstractPredictor next = it.next();
            j3 = Math.max(next.prediction, j3);
            StringBuilder sb5 = this.logBuilder;
            if (sb5 != null) {
                sb5.append("{predictor=");
                sb5.append(next);
                sb5.append(", currentPredition=");
                sb5.append(next.currentPredition);
                sb5.append(", prediction=");
                sb5.append(next.prediction);
                sb5.append("}, ");
            }
        }
        LogUtil.d(TAG, this.logBuilder.toString());
        if (!this.forceEnableSampleFilter && (!this.idleing || this.playerBandwidthObtainer.a() > 0)) {
            this.sampleThreshold = 0L;
        } else {
            this.sampleThreshold = Math.min(MAX_SAMPLE_THRESHOLD, ((float) j3) / 10.0f);
        }
        this.currentPrediction = j3;
    }

    private static void registerNetworkCallback(Context context) {
        if (networkCallback == null && networkChangeReceiver == null) {
            LogUtil.d(TAG, "registerNetworkCallback: ");
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    networkCallback = new NetworkCallbackImpl();
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), networkCallback);
                } else {
                    networkChangeReceiver = new NetworkChangeReceiver();
                    context.registerReceiver(networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            } catch (Exception e16) {
                LogUtil.e(TAG, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        LogUtil.d(TAG, "reset: ");
        this.lastRestTimeStamp = SystemClock.elapsedRealtime();
        Iterator<AbstractPredictor> it = this.bandwidthPredictors.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        if (NetworkUtil.isWifiConnected()) {
            this.resetTimeThreshold = CommonUtil.p(this.configMap.get(CONFIG_RESET_TIME_SECOND_FOR_WIFI), 3600) * 1000;
        } else {
            this.resetTimeThreshold = CommonUtil.p(this.configMap.get(CONFIG_RESET_TIME_SECOND_FOR_XG), 600) * 1000;
        }
    }

    private void sample() {
        long currentBandwidth = getCurrentBandwidth();
        long j3 = this.sampleThreshold;
        boolean z16 = false;
        if (currentBandwidth > j3) {
            this.idleTimes = 0;
            this.idleing = false;
            if (this.lastBandwidth > j3) {
                Iterator<AbstractPredictor> it = this.bandwidthPredictors.iterator();
                while (it.hasNext()) {
                    it.next().sample(this.lastBandwidth);
                }
            }
            this.lastBandwidth = currentBandwidth;
            return;
        }
        Iterator<AbstractPredictor> it5 = this.bandwidthPredictors.iterator();
        while (it5.hasNext()) {
            AbstractPredictor next = it5.next();
            long j16 = this.lastBandwidth;
            if (j16 > next.prediction) {
                next.sample(j16);
            }
        }
        this.lastBandwidth = 0L;
        this.idleTimes++;
        if (this.playerBandwidthObtainer.b() && this.currentPrediction > 0) {
            LogUtil.d(TAG, "player state error");
            reset();
            return;
        }
        if (this.idleTimes >= 5) {
            this.idleing = true;
            Iterator<AbstractPredictor> it6 = this.bandwidthPredictors.iterator();
            while (it6.hasNext()) {
                it6.next().onIdle();
            }
            if (SystemClock.elapsedRealtime() - this.lastRestTimeStamp > this.resetTimeThreshold) {
                z16 = true;
            }
            if (z16) {
                reset();
            }
        }
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public final long getCurrentPrediction() {
        return this.currentPrediction;
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public long getLastBandwidth() {
        return this.lastBandwidth;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@Nullable Message message) {
        if (message == null || message.what != 0) {
            return false;
        }
        if (sIsAppForeground) {
            StringBuilder sb5 = new StringBuilder();
            this.logBuilder = sb5;
            sb5.append("predict: ");
            sample();
            predict();
            this.logBuilder = null;
        }
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, 1000L);
        return true;
    }

    @Override // com.tencent.superplayer.bandwidth.b
    public void onNetChanged() {
        LogUtil.d(TAG, "onNetChanged: ");
        this.handler.post(new Runnable() { // from class: com.tencent.superplayer.bandwidth.SPBandwidthPredictor.1
            @Override // java.lang.Runnable
            public void run() {
                SPBandwidthPredictor.this.reset();
            }
        });
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public void start(Context context) {
        if (this.scene <= 0) {
            this.scene = context.hashCode();
            this.handler.removeMessages(0);
            this.handler.sendEmptyMessage(0);
        }
    }

    @Override // com.tencent.superplayer.api.ISPBandwidthPredictor
    public void stop(Context context) {
        if (context.hashCode() == this.scene) {
            this.handler.removeMessages(0);
            this.scene = 0;
        }
    }

    public SPBandwidthPredictor(Context context, @Nullable ArrayList<AbstractPredictor> arrayList, @Nullable ArrayList<IBandwidthObtainer> arrayList2, @Nullable Map<String, String> map) {
        this.idleTimes = 0;
        this.idleing = false;
        this.sampleThreshold = 0L;
        this.forceEnableSampleFilter = false;
        this.resetTimeThreshold = 600000L;
        this.lastRestTimeStamp = 0L;
        this.currentPrediction = 0L;
        this.lastBandwidth = 0L;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.configMap = map;
        this.handler = new Handler(ThreadUtil.getSubThreadLooper(), this);
        this.lastRestTimeStamp = SystemClock.elapsedRealtime();
        this.bandwidthPredictors = arrayList;
        this.bandwidthObtainers = arrayList2;
        c cVar = new c();
        this.playerBandwidthObtainer = cVar;
        if (this.bandwidthObtainers == null) {
            ArrayList<IBandwidthObtainer> arrayList3 = new ArrayList<>();
            this.bandwidthObtainers = arrayList3;
            arrayList3.add(new DefaultBandwidthObtainer());
            this.bandwidthObtainers.add(cVar);
        }
        if (this.bandwidthPredictors == null) {
            ArrayList<AbstractPredictor> arrayList4 = new ArrayList<>();
            this.bandwidthPredictors = arrayList4;
            arrayList4.add(new ExoPredictor(5.0f));
        }
        if (this.configMap == null) {
            this.configMap = new HashMap();
        }
        this.forceEnableSampleFilter = CommonUtil.p(this.configMap.get(CONFIG_ENABLE_SAMPLE_FILTER), 0) == 1;
        networkListeners.add(new WeakReference<>(this));
        registerNetworkCallback(applicationContext);
    }
}
