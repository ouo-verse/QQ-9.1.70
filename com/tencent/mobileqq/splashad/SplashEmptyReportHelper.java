package com.tencent.mobileqq.splashad;

import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/splashad/SplashEmptyReportHelper;", "", "", "isHotStart", "hasExposureChance", "", "errorCode", "", "d", "b", "Z", "mIsHotStart", "c", "mHasExposureChance", "I", "mErrorCode", "<init>", "()V", "SplashEmptyReportCode", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SplashEmptyReportHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SplashEmptyReportHelper f288736a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsHotStart;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean mHasExposureChance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int mErrorCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/splashad/SplashEmptyReportHelper$SplashEmptyReportCode;", "", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes18.dex */
    public @interface SplashEmptyReportCode {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int HARD_WARE_LIMIT = 1000;
        public static final int SPLASH_LIMIT_EXCEED = 1002;
        public static final int TIAN_SHU_SPLASH_SHOW = 1001;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/splashad/SplashEmptyReportHelper$SplashEmptyReportCode$a;", "", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.splashad.SplashEmptyReportHelper$SplashEmptyReportCode$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f288740a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60495);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f288740a = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(60498), (Class<?>) SplashEmptyReportCode.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f288740a;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f288736a = new SplashEmptyReportHelper();
        }
    }

    SplashEmptyReportHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        Object obj;
        int roundToInt;
        ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportSplashEmptyOrder(mIsHotStart, mHasExposureChance, mErrorCode);
        HashMap hashMap = new HashMap();
        String str = "1";
        if (mIsHotStart) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("ext2", obj);
        if (!mHasExposureChance) {
            str = "0";
        }
        hashMap.put("ext3", str);
        hashMap.put("ext4", String.valueOf(mErrorCode));
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.floor(1000 * Math.random()));
        if (roundToInt == 500) {
            ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("ams", "splash", GlobalUtil.DEF_STRING, hashMap);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (mErrorCode == 1000) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.splashad.m
                @Override // java.lang.Runnable
                public final void run() {
                    SplashEmptyReportHelper.c();
                }
            }, 16, null, false);
        }
    }

    public final void d(boolean isHotStart, boolean hasExposureChance, int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isHotStart), Boolean.valueOf(hasExposureChance), Integer.valueOf(errorCode));
            return;
        }
        mErrorCode = errorCode;
        mIsHotStart = isHotStart;
        mHasExposureChance = hasExposureChance;
    }
}
