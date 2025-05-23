package com.tencent.tmassistantbase.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class NetworkMonitorReceiver extends BroadcastReceiver {
    protected static final int MSG_DELAY_TIME = 3500;
    protected static final int MSG_resumeDownloadTime = 67;
    protected static final String TAG = "NetworkMonitorReceiver";
    protected static NetworkMonitorReceiver mInstance;
    protected static Handler mNetworkChangedHandler;
    protected boolean isRegisterReceiver = false;
    ArrayList<INetworkChangedObserver> mObs = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<NetworkMonitorReceiver> f380426a;

        public a(NetworkMonitorReceiver networkMonitorReceiver) {
            this.f380426a = new WeakReference<>(networkMonitorReceiver);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            NetworkMonitorReceiver networkMonitorReceiver = this.f380426a.get();
            if (message.what == 67 && networkMonitorReceiver != null) {
                networkMonitorReceiver.notifyNetworkChanged();
            }
        }
    }

    public static synchronized NetworkMonitorReceiver getInstance() {
        NetworkMonitorReceiver networkMonitorReceiver;
        synchronized (NetworkMonitorReceiver.class) {
            if (mInstance == null) {
                mInstance = new NetworkMonitorReceiver();
            }
            networkMonitorReceiver = mInstance;
        }
        return networkMonitorReceiver;
    }

    public void addNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        if (!this.mObs.contains(iNetworkChangedObserver) && iNetworkChangedObserver != null) {
            this.mObs.add(iNetworkChangedObserver);
        }
    }

    public void notifyNetworkChanged() {
        ArrayList<INetworkChangedObserver> arrayList = this.mObs;
        if (arrayList != null) {
            Iterator<INetworkChangedObserver> it = arrayList.iterator();
            while (it.hasNext()) {
                INetworkChangedObserver next = it.next();
                if (next != null) {
                    next.onNetworkChanged();
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (mNetworkChangedHandler == null) {
            mNetworkChangedHandler = new a(this);
        }
        mNetworkChangedHandler.removeMessages(67);
        Message obtain = Message.obtain();
        obtain.what = 67;
        mNetworkChangedHandler.sendMessageDelayed(obtain, 3500L);
    }

    public void registerReceiver() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(this, intentFilter);
            this.isRegisterReceiver = true;
        } catch (Throwable th5) {
            this.isRegisterReceiver = false;
            th5.printStackTrace();
        }
    }

    public void removeNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        if (iNetworkChangedObserver != null) {
            this.mObs.remove(iNetworkChangedObserver);
        }
    }

    public void unregisterReceiver() {
        Context context;
        if (mInstance == null || (context = GlobalUtil.getInstance().getContext()) == null) {
            return;
        }
        try {
            if (this.isRegisterReceiver) {
                context.unregisterReceiver(this);
                this.isRegisterReceiver = false;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
