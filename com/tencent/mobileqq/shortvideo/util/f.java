package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoArtResourceMgr;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.t;
import com.tencent.mobileqq.shortvideo.w;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f288252a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f288253b;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f288254c;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f288255d;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f288256e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f288257f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f288258g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f288259h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f288260i;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f288261j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f288262k;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f288263a = {"libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so"};

        static /* bridge */ /* synthetic */ boolean a() {
            return b();
        }

        private static boolean b() {
            boolean fileExists;
            boolean fileExists2;
            String d16 = f.d();
            synchronized (f.f288252a) {
                fileExists = FileUtils.fileExists(d16 + SoLoader.SV_SO_QMCF);
                fileExists2 = FileUtils.fileExists(d16 + f288263a[2]);
            }
            if (QLog.isColorLevel()) {
                QLog.i("SVAF_SoLoad", 2, String.format("isArtFilterSoExist, qmcfso[%s], snpeso[%s]", Boolean.valueOf(fileExists), Boolean.valueOf(fileExists2)));
            }
            return fileExists;
        }
    }

    static {
        com.tencent.sveffects.a.b();
        f288252a = new Object();
        f288253b = AppConstants.SDCARD_PATH + "early";
        f288254c = new String[]{"qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700"};
        f288255d = new String[]{"qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665"};
        f288256e = new String[]{"qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700"};
        f288257f = false;
        f288258g = false;
        f288259h = false;
        f288260i = false;
        f288261j = false;
        f288262k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        File file = new File(f288253b);
        if (!file.exists()) {
            return;
        }
        String str = file.getAbsolutePath() + File.separator;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            String[] strArr = f288254c;
            if (i16 >= strArr.length) {
                break;
            }
            File file2 = new File(str + strArr[i16]);
            if (file2.exists()) {
                file2.delete();
            }
            i16++;
        }
        int i17 = 0;
        while (true) {
            String[] strArr2 = f288255d;
            if (i17 >= strArr2.length) {
                break;
            }
            File file3 = new File(str + strArr2[i17]);
            if (file3.exists()) {
                file3.delete();
            }
            i17++;
        }
        while (true) {
            String[] strArr3 = f288256e;
            if (i3 < strArr3.length) {
                File file4 = new File(str + strArr3[i3]);
                if (file4.exists()) {
                    file4.delete();
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public static String d() {
        String d16 = ShortVideoArtResourceMgr.d();
        if (d16.equals("artfilter000_0")) {
            VideoEnvironment.LogDownLoad("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
            return null;
        }
        return ShortVideoArtResourceMgr.c() + d16 + File.separator;
    }

    public static String e() {
        return ((IAEPath) QRoute.api(IAEPath.class)).getPendantBasePath();
    }

    public static int f() {
        int i3;
        if (l()) {
            if (g()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PtvFilterSoLoad", 2, "getQmcfSoState:" + i3);
        }
        return i3;
    }

    public static boolean g() {
        return a.a();
    }

    public static boolean h() {
        boolean z16;
        if (f288258g) {
            return f288260i;
        }
        boolean z17 = !t.f();
        boolean isPortraitSwitchOpen = ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isPortraitSwitchOpen();
        if (z17 && isPortraitSwitchOpen) {
            z16 = true;
        } else {
            z16 = false;
        }
        f288260i = z16;
        f288258g = true;
        if (QLog.isColorLevel()) {
            QLog.i("PtvFilterSoLoad", 2, "isSupportPortarit sdkSupport:true, whiteList:" + z17 + ", switchOpen:" + isPortraitSwitchOpen);
        }
        return f288260i;
    }

    public static boolean i() {
        boolean isAEBaseSoReady = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEBaseSoReady();
        boolean isShortVideoSoLibLoaded = VideoEnvironment.isShortVideoSoLibLoaded();
        if (isAEBaseSoReady && isShortVideoSoLibLoaded) {
            return true;
        }
        return false;
    }

    public static synchronized boolean j(QQAppInterface qQAppInterface, Context context) {
        boolean k3;
        synchronized (f.class) {
            k3 = k(qQAppInterface, context, null);
        }
        return k3;
    }

    public static synchronized boolean k(QQAppInterface qQAppInterface, Context context, com.tencent.aelight.camera.download.api.a aVar) {
        boolean z16;
        synchronized (f.class) {
            boolean m3 = m();
            z16 = false;
            if (m3) {
                ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, aVar, false);
                ((IAEResDownload) QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, aVar, false);
                w.f(qQAppInterface);
                z16 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraResExist();
            } else if (aVar != null) {
                aVar.onAEDownloadFinish(AEResInfo.AE_RES_BASE_PACKAGE, null, false, -1);
            }
            if (QLog.isColorLevel()) {
                QLog.i("PtuResCheck", 2, "startDownloadFilterSo, soExist[" + z16 + "], support[" + m3 + "]");
            }
        }
        return z16;
    }

    public static boolean l() {
        if (!QmcfManager.getInstance().isQmcfSupported()) {
            return false;
        }
        return true;
    }

    public static boolean m() {
        boolean z16;
        Class<?> cls;
        if (!((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(com.tencent.aelight.camera.constants.a.f69009w) && !((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isNotSupportFilterBasedSdk()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        boolean isBeautySupported = AVCoreSystemInfo.isBeautySupported();
        try {
            cls = Class.forName("android.opengl.EGL14");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (isBeautySupported && cls != null) {
            return true;
        }
        return false;
    }
}
