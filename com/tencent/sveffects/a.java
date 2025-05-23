package com.tencent.sveffects;

import android.hardware.SensorEventListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.BeautyResource;
import com.tencent.mobileqq.shortvideo.resource.GestureGameResource;
import com.tencent.mobileqq.shortvideo.resource.GestureResource;
import com.tencent.mobileqq.shortvideo.resource.LowLightResource;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final String f374008a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f374009b;

    /* compiled from: P */
    /* renamed from: com.tencent.sveffects.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9877a implements AVFilterResource {
        static IPatchRedirector $redirector_;

        public C9877a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.AVFilterResource
        public String getFilterResPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ((ICaptureVideoFilterManager) QRoute.api(ICaptureVideoFilterManager.class)).getQQFilterResPath();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b implements ArtFilterResource {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.ArtFilterResource
        public String getCommonPrefix() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return ((IVideoFilterTools) QRoute.api(IVideoFilterTools.class)).getCommonPrefix();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.ArtFilterResource
        public String getFilterResPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ((ICaptureVideoFilterManager) QRoute.api(ICaptureVideoFilterManager.class)).getQQFilterResPath();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.ArtFilterResource
        public String getModelPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "";
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.ArtFilterResource
        public String getReshapePath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "";
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.ArtFilterResource
        public String getSoPathDir() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return com.tencent.mobileqq.shortvideo.util.f.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c implements BeautyResource {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.BeautyResource
        public String getBeautyFilePath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return a.f374008a;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class d implements DpcSwitcher {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.sveffects.DpcSwitcher
        public float getBeatyRate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).getBeatyRate();
        }

        @Override // com.tencent.sveffects.DpcSwitcher
        public boolean isBeautySwitchOpen() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isBeautySwitchOpen();
        }

        @Override // com.tencent.sveffects.DpcSwitcher
        public boolean isDeNoiseSwitchOpen() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isDeNoiseSwitchOpen();
        }

        @Override // com.tencent.sveffects.DpcSwitcher
        public boolean isPortraitSwitchOpen() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return com.tencent.mobileqq.shortvideo.util.f.h();
        }

        @Override // com.tencent.sveffects.DpcSwitcher
        public boolean isSvafSwitchOpen() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isSvafSwitchOpen();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class e implements GestureGameResource {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureGameResource
        public String getGameModelPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return com.tencent.mobileqq.shortvideo.gesture.d.c();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureGameResource
        public boolean isGestureGameEnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return com.tencent.mobileqq.shortvideo.gesture.a.c().e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class f implements GestureResource {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static String f374010a;

        /* renamed from: b, reason: collision with root package name */
        public static String f374011b;

        /* renamed from: c, reason: collision with root package name */
        public static String f374012c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f374013d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77603);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            f374010a = "5";
            f374011b = "200";
            f374012c = "20";
            f374013d = false;
        }

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public String getGestureGapFrame() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return f374010a;
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public String getGestureGapTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return f374011b;
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public boolean getGestureShouldUpload() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return f374013d;
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public String getGestureThreadColdTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return f374012c;
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public String getModelPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return com.tencent.mobileqq.shortvideo.gesture.d.d();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public String getSoPathDir() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return com.tencent.mobileqq.shortvideo.gesture.d.e();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.GestureResource
        public boolean isGestureEnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return com.tencent.mobileqq.shortvideo.gesture.a.c().e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class g implements Logger {
        static IPatchRedirector $redirector_;

        public g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.sveffects.Logger
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            } else {
                ms.a.a(str, str2);
            }
        }

        @Override // com.tencent.sveffects.Logger
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ms.a.c(str, str2);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.sveffects.Logger
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            } else {
                ms.a.f(str, str2);
            }
        }

        @Override // com.tencent.sveffects.Logger
        public boolean isEnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return QLog.isColorLevel();
        }

        @Override // com.tencent.sveffects.Logger
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else {
                ms.a.i(str, str2);
            }
        }

        @Override // com.tencent.sveffects.Logger
        public void e(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                ms.a.e(str, th5);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) th5);
            }
        }

        @Override // com.tencent.sveffects.Logger
        public void e(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                ms.a.d(str, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 5, this, str, str2, th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class h implements LowLightResource {
        static IPatchRedirector $redirector_;

        public h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.LowLightResource
        public String getLowLightDir() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return AppConstants.SDCARD_PATH;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class i implements PtuFilterResource {
        static IPatchRedirector $redirector_;

        public i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.PtuFilterResource
        public boolean checkPendantVersionOK() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return ((IAEResUtil) QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE);
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.PtuFilterResource
        public String getPortraitPathDir() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return getSoPathDir();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.PtuFilterResource
        public String getSoPathDir() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class j implements Reporter {
        static IPatchRedirector $redirector_;

        public j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.sveffects.Reporter
        public void reportToBeacon(String str, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap);
            } else {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, z16, j3, j16, hashMap, "");
            }
        }

        @Override // com.tencent.sveffects.Reporter
        public void reportToCompass(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, String str8) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), str5, str6, str7, str8);
            } else {
                ReportController.o(null, str, str2, "", str3, str4, i3, i16, str5, str6, str7, str8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class k implements Resources {
        static IPatchRedirector $redirector_;

        public k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public SpecialAVFilterResource getAVFilterResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (SpecialAVFilterResource) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return new m();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public ArtFilterResource getArtFilterResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ArtFilterResource) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new b();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public AVFilterResource getAvFilterResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AVFilterResource) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new C9877a();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public BeautyResource getBeautyResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BeautyResource) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new c();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public GestureResource getGestureResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (GestureResource) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return new f();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public LowLightResource getLowLightResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (LowLightResource) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new h();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public PtuFilterResource getPtuFilterResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (PtuFilterResource) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new i();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public SensorResource getSensorResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (SensorResource) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return new l();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.Resources
        public GestureGameResource geteGestureGameResource() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (GestureGameResource) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return new e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class l implements SensorResource {
        static IPatchRedirector $redirector_;

        public l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SensorResource
        public boolean checkSensorEnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return iu.a.c().d();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SensorResource
        public boolean getCameraIsFront() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return iu.a.c().b();
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SensorResource
        public int getRotation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SensorResource
        public void registerListener(SensorEventListener sensorEventListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) sensorEventListener);
            } else {
                iu.a.c().e(sensorEventListener);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SensorResource
        public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack cameraChangedCallBack) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) cameraChangedCallBack);
            } else {
                iu.a.c().f(cameraChangedCallBack);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SensorResource
        public void unregisterListener(SensorEventListener sensorEventListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) sensorEventListener);
            } else {
                iu.a.c().i(sensorEventListener);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class m implements SpecialAVFilterResource {
        static IPatchRedirector $redirector_;

        public m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource
        public String getMusicResPath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return com.tencent.biz.qqstory.utils.d.q();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.mobileqq.activity.richmedia.g.f185853a);
        sb5.append("/qav");
        String str = File.separator;
        sb5.append(str);
        sb5.append("beauty");
        sb5.append(str);
        f374008a = sb5.toString();
        f374009b = false;
    }

    public static synchronized void b() {
        synchronized (a.class) {
            if (f374009b) {
                return;
            }
            SdkContext.getInstance().init("QQ", BaseApplication.getContext(), new d(), new k(), new g(), new j());
            f374009b = true;
        }
    }
}
