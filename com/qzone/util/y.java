package com.qzone.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static int f59847a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static final String f59848b = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_UPLOAD_MIDDLE_DEVICE, QzoneConfig.DEFAULT_WHITE_LIST_MIDDLE);

    /* renamed from: c, reason: collision with root package name */
    private static final String f59849c = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_UPLOAD_LOW_DEVICE, QzoneConfig.DEFAULT_WHITE_LIST_LOW);

    private static int a() {
        if (g()) {
            return e(2);
        }
        if (f()) {
            return e(3);
        }
        return -1;
    }

    public static int b() {
        if (f59847a == -1) {
            try {
                f59847a = d(c());
            } catch (Throwable th5) {
                QZLog.e("PhotoUploadUtil", "getMaxPhotoCnt", th5);
                f59847a = 99;
            }
        }
        return f59847a;
    }

    public static int c() {
        int a16 = a();
        if (a16 > 0) {
            return a16;
        }
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(3, 2)) {
            return e(1);
        }
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(2, 1)) {
            return e(2);
        }
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 0)) {
            return e(3);
        }
        return 99;
    }

    public static int d(int i3) {
        long sDCardAvailableSize = cu.e() ? ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getSDCardAvailableSize() / 1024 : -1L;
        if (sDCardAvailableSize == -1) {
            sDCardAvailableSize = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getSystemAvailableSize() / 1024;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("PhotoUploadUtil", 2, "available storage for PhotoUpload is " + sDCardAvailableSize + "MB");
        }
        if (sDCardAvailableSize > 1024) {
            if (i3 > 800) {
                return 800;
            }
            return i3;
        }
        if (sDCardAvailableSize > 600) {
            if (i3 > 500) {
                return 500;
            }
            return i3;
        }
        if (sDCardAvailableSize <= 360 || i3 <= 300) {
            return i3;
        }
        return 300;
    }

    public static int e(int i3) {
        if (QZLog.isColorLevel()) {
            QZLog.d("PhotoUploadUtil", 2, "My Phone is Tier " + i3);
        }
        if (i3 == 1) {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_UPLOAD_TIER_1_MAX_NUM, 500);
        }
        if (i3 == 2) {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_UPLOAD_TIER_2_MAX_NUM, 200);
        }
        if (i3 != 3) {
            QZLog.w("PhotoUploadUtil", "#getMaxUploadPhotoNumByTier unsupported tier.");
            return -1;
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_UPLOAD_TIER_3_MAX_NUM, 99);
    }

    private static boolean f() {
        return f59849c.contains(DeviceInfoMonitor.getModel());
    }

    private static boolean g() {
        return f59848b.contains(DeviceInfoMonitor.getModel());
    }
}
