package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKSDKMgr;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.util.concurrent.TimeUnit;

/* loaded from: classes23.dex */
public class TVKPlayerBroadcastReceiver {
    private static final TVKPlayerBroadcastReceiver INSTANCE = new TVKPlayerBroadcastReceiver();
    private static final String TAG = "TVKPlayerBroadcastReceiver";
    private static final long UPDATE_STABLE_NETWORK_INFO_PERIOD_MS = 5000;
    private boolean mIsInitialized = false;
    private final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerBroadcastReceiver.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TVKPlayerBroadcastReceiver.this.onNetworkChangeActionIfNeeded(context, intent);
            TVKPlayerBroadcastReceiver.this.onHdmiChangeActionIfNeeded(context, intent);
            TVKPlayerBroadcastReceiver.this.onHeadsetChangeActionIfNeeded(context, intent);
        }
    };

    public static TVKPlayerBroadcastReceiver getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerReceiver$0(IntentFilter intentFilter) {
        TVKCommParams.getApplicationContext().registerReceiver(this.mBroadcastReceiver, intentFilter, null, new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper()));
        TVKNetworkConnectionListener.getInstance().registerNetworkConnectivity(TVKCommParams.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerReceiver$1() {
        TVKNetworkUtils.updateNetworkInfo(TVKCommParams.getApplicationContext());
        TVKHeadsetObserver.getInstance().updateHeadsetStatusByDetection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHdmiChangeActionIfNeeded(@Nullable Context context, @Nullable Intent intent) {
        if (context != null && intent != null) {
            if ("android.media.action.HDMI_AUDIO_PLUG".equals(intent.getAction())) {
                TVKHDMIObserver.getInstance().updateHdmiStatus(intent);
            }
        } else {
            TVKLogUtil.e(TAG, "onHdmiChangeActionIfNeeded failed, context:" + context + ", intent:" + intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHeadsetChangeActionIfNeeded(@Nullable Context context, @Nullable Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.HEADSET_PLUG".equals(action) || "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                TVKHeadsetObserver.getInstance().updateHeadsetStatusByBroadcast(intent);
                return;
            }
            return;
        }
        TVKLogUtil.e(TAG, "onHeadsetChangeActionIfNeeded failed, context:" + context + ", intent:" + intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetworkChangeActionIfNeeded(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || !TVKSDKMgr.isAppForground) {
                return;
            }
            TVKNetworkUtils.updateNetworkInfo(context);
            TVKLogUtil.i(TAG, "onNetworkChange, networkAvailable:" + TVKNetworkUtils.isNetworkAvailable() + ", networkType:" + TVKNetworkUtils.getNetworkType() + ", ipStackType:" + TVKNetworkUtils.getIPStackType());
            TVKGlobalEventNotifier.getInstance().postGlobalEvent(100003, 0, 0, context);
            return;
        }
        TVKLogUtil.e(TAG, "onNetworkChangeAction failed, context:" + context + ", intent:" + intent);
    }

    private void registerReceiver() {
        final IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (TVKMediaPlayerConfig.PlayerConfig.enable_hdmi_observing) {
            intentFilter.addAction("android.media.action.HDMI_AUDIO_PLUG");
        }
        if (TVKMediaPlayerConfig.PlayerConfig.enable_headset_observing) {
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                TVKCommParams.getApplicationContext().registerReceiver(this.mBroadcastReceiver, intentFilter, null, new Handler(TVKThreadPool.getInstance().obtainSharedHandlerThread().getLooper()));
                TVKNetworkConnectionListener.getInstance().registerNetworkConnectivity(TVKCommParams.getApplicationContext());
            } else {
                TVKThreadPool.getInstance().postRunnableOnMainThread(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVKPlayerBroadcastReceiver.this.lambda$registerReceiver$0(intentFilter);
                    }
                });
            }
            TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.f
                @Override // java.lang.Runnable
                public final void run() {
                    TVKPlayerBroadcastReceiver.lambda$registerReceiver$1();
                }
            }, 0L, 5000L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            TVKLogUtil.e(TAG, "register broadcast occur exception");
        }
        TVKLogUtil.i(TAG, "register broadcast receivers");
    }

    public synchronized void initReceivers() {
        if (this.mIsInitialized) {
            return;
        }
        registerReceiver();
        this.mIsInitialized = true;
    }
}
