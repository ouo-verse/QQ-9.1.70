package com.tencent.thumbplayer.core.downloadproxy.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.util.ITPDataTransportLog;
import com.tencent.thumbplayer.core.datatransport.util.TPDataTransportLogFactory;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;

/* loaded from: classes26.dex */
public class TPSystemBroadcastReceiver extends BroadcastReceiver {
    private int mLastNetworkState;
    private final ITPDataTransportLog mLogger;

    public TPSystemBroadcastReceiver() {
        ITPDataTransportLog logger = TPDataTransportLogFactory.getInstance().getLogger("TPSystemBroadcastReceiver");
        this.mLogger = logger;
        this.mLastNetworkState = -1;
        logger.i("construct");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        final String action = intent.getAction();
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action) && !IECScreenReceiver.ACTION_SCREEN_OFF.equals(action) && !IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
            return;
        }
        TVKThreadUtil.postRunnableInCustomThread(new Runnable() { // from class: com.tencent.thumbplayer.core.downloadproxy.jni.TPSystemBroadcastReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                        int netWorkState = TPDLProxyUtils.getNetWorkState(context);
                        TPSystemBroadcastReceiver.this.mLogger.i("network state update, last state:" + TPSystemBroadcastReceiver.this.mLastNetworkState + ", new state:" + netWorkState);
                        if (netWorkState != 1 && netWorkState != 2) {
                            TPSystemBroadcastReceiver.this.mLastNetworkState = 0;
                            TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, String.valueOf(0));
                        } else if (TPSystemBroadcastReceiver.this.mLastNetworkState != netWorkState) {
                            TPSystemBroadcastReceiver.this.mLastNetworkState = netWorkState;
                            TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_NETWORK_STATE, String.valueOf(netWorkState));
                        }
                    } else if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(action)) {
                        TPSystemBroadcastReceiver.this.mLogger.i("screen off");
                        TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE, String.valueOf(2));
                    } else if (IECScreenReceiver.ACTION_SCREEN_ON.equals(action)) {
                        TPSystemBroadcastReceiver.this.mLogger.i("screen on");
                        TPDownloadProxyNative.getInstance().setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE, String.valueOf(3));
                    }
                } catch (Throwable th5) {
                    TPSystemBroadcastReceiver.this.mLogger.e("onReceive failed, error:" + th5);
                }
            }
        });
    }
}
