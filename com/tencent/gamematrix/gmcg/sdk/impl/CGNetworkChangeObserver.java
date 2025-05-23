package com.tencent.gamematrix.gmcg.sdk.impl;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.gamematrix.gmcg.api.GmCgSdkNetworkChangeListener;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGNetworkUtil;
import com.tencent.gamematrix.gmcg.sdk.netdetect.CGNetDetectionManager;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNetworkChangeObserver {
    public static final int NETWORK_TYPE_MOBILE = 1;
    public static final int NETWORK_TYPE_NO_CONNECT = 0;
    public static final int NETWORK_TYPE_WIFI = 2;
    private static final String TAG = "CGNetworkChangeObserver";
    public static int mGmCgActivityNetWorkType;
    private static GmCgSdkNetworkChangeListener mNetworkChangeLister;
    private static int sNetworkType;
    private Context mAppContext;
    private CGNetworkConnectionChangeReceiver mNetworkConnectionChangeReceiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CGNetworkConnectionChangeReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (NetworkMonitor.getType(activeNetworkInfo) != CGNetworkChangeObserver.sNetworkType) {
                    int unused = CGNetworkChangeObserver.sNetworkType = NetworkMonitor.getType(activeNetworkInfo);
                    CGNetDetectionManager.get().clearCacheNetDelayDetection();
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (type != 0) {
                        if (type != 1) {
                            CGLog.i("CGNetworkChangeObserver,switch to unknow net");
                            CGNetworkChangeObserver.mGmCgActivityNetWorkType = 0;
                        } else {
                            CGLog.i("CGNetworkChangeObserver,switch to network wifi");
                            CGNetworkChangeObserver.mGmCgActivityNetWorkType = 1;
                        }
                    } else {
                        CGLog.i("CGNetworkChangeObserver,switch to network mobile");
                        CGNetworkChangeObserver.mGmCgActivityNetWorkType = 2;
                    }
                }
                if (CGNetworkChangeObserver.mNetworkChangeLister != null) {
                    CGLog.i("CGNetworkChangeObserver,send network type to outside " + CGNetworkChangeObserver.mGmCgActivityNetWorkType);
                    CGNetworkChangeObserver.mNetworkChangeLister.onNetworkTypeChange(CGNetworkChangeObserver.mGmCgActivityNetWorkType);
                    return;
                }
                return;
            }
            CGLog.i("CGNetworkChangeObserver,switch to no network***");
            if (CGNetworkChangeObserver.mNetworkChangeLister != null) {
                CGLog.i("CGNetworkChangeObserver,send network type to outside");
                CGNetworkChangeObserver.mNetworkChangeLister.onNetworkTypeChange(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class INNER {

        @SuppressLint({"StaticFieldLeak"})
        static CGNetworkChangeObserver INSTANCE = new CGNetworkChangeObserver();

        INNER() {
        }
    }

    private void checkNetworkType() {
        if (CGNetworkUtil.isNetworkConnected(this.mAppContext)) {
            sNetworkType = 0;
        } else if (CGNetworkUtil.isMobileConnected(this.mAppContext)) {
            sNetworkType = 1;
        } else {
            sNetworkType = 2;
        }
    }

    public static CGNetworkChangeObserver get() {
        return INNER.INSTANCE;
    }

    public CGNetworkChangeObserver create(Context context) {
        this.mAppContext = context;
        return this;
    }

    public void register() {
        checkNetworkType();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (this.mNetworkConnectionChangeReceiver == null) {
            this.mNetworkConnectionChangeReceiver = new CGNetworkConnectionChangeReceiver();
        }
        unregister();
        try {
            this.mAppContext.registerReceiver(this.mNetworkConnectionChangeReceiver, intentFilter);
        } catch (Exception unused) {
        }
    }

    public void setNetworkTypeListener(GmCgSdkNetworkChangeListener gmCgSdkNetworkChangeListener) {
        mNetworkChangeLister = gmCgSdkNetworkChangeListener;
    }

    public void unregister() {
        CGNetworkConnectionChangeReceiver cGNetworkConnectionChangeReceiver = this.mNetworkConnectionChangeReceiver;
        if (cGNetworkConnectionChangeReceiver != null) {
            try {
                this.mAppContext.unregisterReceiver(cGNetworkConnectionChangeReceiver);
            } catch (Exception unused) {
            }
        }
    }

    CGNetworkChangeObserver() {
    }
}
