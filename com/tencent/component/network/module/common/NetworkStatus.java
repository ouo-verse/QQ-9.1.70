package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NetworkStatus {
    private static volatile NetworkStatus sInstance;
    private final Context mContext;
    private NetworkUtils.DNS mDNS;

    NetworkStatus(Context context) {
        this.mContext = context.getApplicationContext();
        init();
    }

    public static NetworkStatus getInstance(Context context) {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (NetworkStatus.class) {
            if (sInstance != null) {
                return sInstance;
            }
            NetworkStatus networkStatus = new NetworkStatus(context);
            sInstance = networkStatus;
            return networkStatus;
        }
    }

    private void init() {
        refreshDNS();
        this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.component.network.module.common.NetworkStatus.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: com.tencent.component.network.module.common.NetworkStatus.1.1
                        @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
                        public Object run(ThreadPool.JobContext jobContext) {
                            NetworkStatus.this.refreshDNS();
                            return null;
                        }
                    });
                }
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void refreshDNS() {
        this.mDNS = NetworkUtils.getDNS(this.mContext);
    }

    public NetworkUtils.DNS getDNS() {
        return this.mDNS;
    }
}
