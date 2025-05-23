package com.qzone.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.util.AbiUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;

/* loaded from: classes37.dex */
public class P2VUtil {

    /* renamed from: e, reason: collision with root package name */
    private static P2VUtil f59739e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f59740f = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_P2V_FUN_ENABLE, 1);

    /* renamed from: g, reason: collision with root package name */
    private static final String f59741g = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_P2V_BLACK_LIST, QzoneConfig.DEFAULT_P2V_FUN_BLACK_LIST);

    /* renamed from: h, reason: collision with root package name */
    private static final long f59742h = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_P2V_STORAGE_LIMIT, 62914560L);

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f59743i = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_P2V_NEED_ORIGINAL, true);

    /* renamed from: j, reason: collision with root package name */
    private static int f59744j = -1;

    /* renamed from: a, reason: collision with root package name */
    private long f59745a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f59746b = null;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f59747c = false;

    /* renamed from: d, reason: collision with root package name */
    private long f59748d;

    public P2VUtil() {
        this.f59745a = -1L;
        if (this.f59745a == -1) {
            this.f59745a = ((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).getTotalMem() / 1024;
        }
    }

    private static void b() {
        String str = Build.CPU_ABI;
        if (str.contains(AbiUtil.ARM)) {
            f59744j = 1;
            return;
        }
        if (str.contains(ResourceAttributes.HostArchValues.X86)) {
            f59744j = 2;
        } else if (str.contains("mips")) {
            f59744j = 3;
        } else {
            f59744j = 0;
        }
    }

    private static long c() {
        try {
            return CacheManager.getSDCardRemain();
        } catch (Exception e16) {
            QLog.e("P2VUtil", 1, "Get Free Space Failed", e16);
            return 0L;
        }
    }

    public static P2VUtil d() {
        if (f59739e == null) {
            synchronized (P2VUtil.class) {
                if (f59739e == null) {
                    f59739e = new P2VUtil();
                }
            }
        }
        return f59739e;
    }

    public static QZoneVideoCommonUtils.VideoSupport e() {
        if (f59744j < 0) {
            b();
        }
        if (QLog.isColorLevel()) {
            QLog.i("P2VUtil", 2, "getP2VSupport() mCpuFamily=" + f59744j);
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_P2V_SUPPORTED_CPU_FAMILY, 2);
        int i3 = f59744j;
        if (((i3 >= 0 ? 1 << i3 : 1) & config) == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("P2VUtil", 2, "getP2VSupport() serverCpuFamily=" + config + " mCpuFamily=" + f59744j);
            }
            return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
        }
        if (!((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 1)) {
            return QZoneVideoCommonUtils.VideoSupport.HardwareLimited;
        }
        int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_MIN_SDK, 21);
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < config2) {
            if (QLog.isColorLevel()) {
                QLog.i("P2VUtil", 2, "getRecordSupport() localSdkVersion=" + i16 + " serverSdkVersion=" + config2);
            }
            return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
        }
        if (!CacheManager.isExternalAvailable()) {
            if (QLog.isColorLevel()) {
                QLog.i("P2VUtil", 2, "getRecordSupport() sdcard !mounted");
            }
            return QZoneVideoCommonUtils.VideoSupport.NoExternalBanned;
        }
        long c16 = c();
        long j3 = f59742h;
        if (c16 < j3) {
            if (QLog.isColorLevel()) {
                QLog.i("P2VUtil", 2, "getRecordSupport() sdCardFreeSpace=" + c16 + " STORAGE_LIMIT=" + j3);
            }
            return QZoneVideoCommonUtils.VideoSupport.ExternalSpaceBanned;
        }
        return QZoneVideoCommonUtils.VideoSupport.Available;
    }

    private boolean f(String str) {
        try {
            String model = DeviceInfoMonitor.getModel();
            if (model != null && model.length() != 0) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("P2VUtil", 2, "buildModel is '" + model + "'");
                }
                if (str != null && str.length() != 0) {
                    if (("," + str + ",").contains("," + model + ",")) {
                        QZLog.i("P2VUtil", 1, "\u547d\u4e2d\u7981\u6b62\u7167\u7247\u5408\u6210\u89c6\u9891\u9ed1\u540d\u5355\u7b56\u7565");
                        return true;
                    }
                }
                return false;
            }
            QZLog.i("P2VUtil", 1, "buildModel is empty, hide P2V .\u547d\u4e2d\u7981\u6b62\u7167\u7247\u5408\u6210\u89c6\u9891\u7b56\u7565");
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    private void k(final Context context) {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_IS_CAN_PRELOAD_PEAK, 1) == 1) {
            if (System.currentTimeMillis() - this.f59748d <= QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PRELOAD_PEAK_DURATION, 180000L)) {
                return;
            }
            this.f59748d = System.currentTimeMillis();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.PreLoadThread).post(new Runnable() { // from class: com.qzone.util.P2VUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    if (P2VUtil.this.i(context)) {
                        return;
                    }
                    ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(context);
                }
            });
        }
    }

    public boolean g() {
        if (LocalMultiProcConfig.getBool("isNeedCloseP2VFunc", false) || f59740f == 0) {
            return false;
        }
        String str = f59741g;
        if (str != null && !str.equals(this.f59746b)) {
            this.f59747c = !f(str);
            this.f59746b = str;
        }
        if (!this.f59747c) {
            return false;
        }
        QZoneVideoCommonUtils.VideoSupport e16 = e();
        if (e16 != null) {
            this.f59747c = e16.isAvailable();
        }
        return this.f59747c;
    }

    public boolean h() {
        return f59743i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:peak".equals(it.next().processName)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            QZLog.e("P2VUtil", 1, "getProcessInfos fail ", e16);
        }
        return false;
    }

    public void j(Context context) {
        if (context != null) {
            k(context);
        }
    }
}
