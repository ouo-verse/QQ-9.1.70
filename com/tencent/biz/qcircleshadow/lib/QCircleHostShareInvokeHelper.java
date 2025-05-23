package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Bitmap;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostShareInvokeHelper {
    public static void addWxShareObserver(QCircleWXShareListener qCircleWXShareListener) {
        QCircleListenerProxyManager.getInstance().addQCircleWXShareListener(qCircleWXShareListener);
    }

    public static boolean isWXInstalled() {
        return QCircleServiceImpl.getWXShareHelper().isWXInstalled();
    }

    public static boolean isWXSupportApi() {
        return QCircleServiceImpl.getWXShareHelper().isWXsupportApi();
    }

    public static void removeWxShareObserver(QCircleWXShareListener qCircleWXShareListener) {
        QCircleListenerProxyManager.getInstance().removeQCircleWXShareListener(qCircleWXShareListener);
    }

    public static void shareQCircleToWX(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        QCircleServiceImpl.getWXShareHelper().shareQcircleToWX(str, str2, bitmap, str3, str4, i3);
    }
}
