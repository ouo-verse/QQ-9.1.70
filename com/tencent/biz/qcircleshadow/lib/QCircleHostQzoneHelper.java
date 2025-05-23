package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.qcircle.api.IDbCacheService;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneShareApi;
import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleHostQzoneHelper {
    public static final String QCIRCLE_UNREADCOUND = "qzone_unreadcount";
    private static final String TAG = "QCircleHostQzoneHelper";

    public static String QZONE_SHARE_IMAGES() {
        return "images";
    }

    public static String QZONE_SHARE_SUMMERY() {
        return "summary";
    }

    public static void cleanQCirclePush() {
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COM);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCIE_LIKE);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_SECRET);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_PUSH);
            qQNotificationManager.cancel(TAG, NotificationUtil.Constants.NOTIFY_ID_QCIRCLE_COMMEN);
        }
        clearQCircleUnreadCount();
    }

    public static void clearQCircleUnreadCount() {
        LocalMultiProcConfig.putInt("qzone_unreadcount3000532", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000533", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000534", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000535", 0);
        LocalMultiProcConfig.putInt("qzone_unreadcount3000536", 0);
    }

    public static void closeDbCacheService() {
        ((IDbCacheService) QRoute.api(IDbCacheService.class)).close();
    }

    public static boolean getBool(String str, boolean z16) {
        return LocalMultiProcConfig.getBool(str, z16);
    }

    public static IDBManagerWrapper getCacheManager(Class<? extends IDBCacheDataWrapper> cls, long j3, String str) {
        return ((IDbCacheService) QRoute.api(IDbCacheService.class)).getCacheManager(cls, j3, str);
    }

    public static int getInt(String str, int i3) {
        return LocalMultiProcConfig.getInt(str, i3);
    }

    public static int getInt4Uin(String str, int i3, long j3) {
        return LocalMultiProcConfig.getInt4Uin(str, i3, j3);
    }

    public static long getLong(String str, long j3) {
        return LocalMultiProcConfig.getLong(str, j3);
    }

    public static void jumpToQzoneShare(String str, Context context, Bundle bundle, DialogInterface.OnDismissListener onDismissListener, int i3) {
        ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(str, context, bundle, onDismissListener, i3);
    }

    public static void putLong(String str, long j3) {
        LocalMultiProcConfig.putLong(str, j3);
    }
}
