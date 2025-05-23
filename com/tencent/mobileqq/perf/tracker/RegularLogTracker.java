package com.tencent.mobileqq.perf.tracker;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.terrible.b;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.RegularLogTracker;
import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/perf/tracker/RegularLogTracker;", "", "", "g", "", "i", "", "needDelay", "d", "terribleTimeStamp", "j", tl.h.F, "", "b", "I", "terribleLogFrequencyThreshold", "", "c", "Ljava/lang/String;", "logZipPath", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mRunnable", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class RegularLogTracker {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RegularLogTracker f258208a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int terribleLogFrequencyThreshold;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String logZipPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable mRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/perf/tracker/RegularLogTracker$a", "Lcom/tencent/mobileqq/perf/terrible/b$b;", "Lcom/tencent/mobileqq/perf/terrible/a;", "oneSecondData", "", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements b.InterfaceC8212b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.terrible.b.InterfaceC8212b
        public void a(@NotNull com.tencent.mobileqq.perf.terrible.a oneSecondData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oneSecondData);
                return;
            }
            Intrinsics.checkNotNullParameter(oneSecondData, "oneSecondData");
            if (oneSecondData.f() > RegularLogTracker.terribleLogFrequencyThreshold) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                from.encodeInt("terrible_occur_count_in_last_hour", from.decodeInt("terrible_occur_count_in_last_hour", 0) + 1).encodeLong("terrible_occur_count_timestamp", System.currentTimeMillis());
                QLog.w("RegularLogTracker[NoPublicDetector]", 1, "last one second log is too frequency, count = " + oneSecondData.f());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/perf/tracker/RegularLogTracker$b", "Lcom/tencent/mobileqq/testassister/ShareAppLogHelper$d;", "", "path", "", "a", "", "code", "onWarning", "onError", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements ShareAppLogHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f258212a;

        b(String str) {
            this.f258212a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(String str, String str2) {
            String str3;
            SimpleAccount firstSimpleAccount;
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (firstSimpleAccount = mobileQQ.getFirstSimpleAccount()) != null) {
                str3 = firstSimpleAccount.getUin();
            } else {
                str3 = null;
            }
            String valueOf = String.valueOf(str3);
            if (str == null) {
                return;
            }
            QLog.i("RegularLogTracker[NoPublicDetector]", 1, "collect log success. start upload.");
            String c16 = PerfCosUploader.f258269a.c(PerfCosUploader.BucketType.QLOG, str, "highLog_" + valueOf + util.base64_pad_url + str2, true);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("upload finished. log url:");
            sb5.append(c16);
            QLog.i("RegularLogTracker[NoPublicDetector]", 1, sb5.toString());
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void a(@Nullable final String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
            } else {
                final String str = this.f258212a;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.tracker.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        RegularLogTracker.b.c(path, str);
                    }
                }, 128, null, true);
            }
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void onError(int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, code);
            }
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void onWarning(int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, code);
            }
        }
    }

    static {
        String str;
        File externalFilesDir;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f258208a = new RegularLogTracker();
        terribleLogFrequencyThreshold = QQPerfConfigLoader.f257603a.b().b().b() / 10;
        StringBuilder sb5 = new StringBuilder();
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null && (externalFilesDir = baseApplication.getExternalFilesDir("perf")) != null) {
            str = externalFilesDir.getAbsolutePath();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(File.separator);
        sb5.append("highLog.zip");
        logZipPath = sb5.toString();
        mRunnable = new Runnable() { // from class: com.tencent.mobileqq.perf.tracker.RegularLogTracker$mRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                long g16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                RegularLogTracker regularLogTracker = RegularLogTracker.f258208a;
                RegularLogTracker.e(regularLogTracker, false, 1, null);
                QQPerfHandlerThreadManager.Companion companion = QQPerfHandlerThreadManager.INSTANCE;
                g16 = regularLogTracker.g();
                companion.b(this, g16);
            }
        };
    }

    RegularLogTracker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d(boolean needDelay) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int decodeInt = from.decodeInt("terrible_occur_count_in_last_hour", 0);
        from.encodeInt("terrible_occur_count_in_last_hour", 0);
        if (decodeInt > 60) {
            try {
                QLog.i("RegularLogTracker[NoPublicDetector]", 1, "start report.");
                final long decodeLong = from.decodeLong("terrible_occur_count_timestamp", System.currentTimeMillis());
                if (needDelay) {
                    QQPerfHandlerThreadManager.INSTANCE.b(new Runnable() { // from class: com.tencent.mobileqq.perf.tracker.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            RegularLogTracker.f(decodeLong);
                        }
                    }, MiniBoxNoticeInfo.MIN_5);
                } else {
                    j(decodeLong);
                }
            } catch (Throwable th5) {
                QLog.e("RegularLogTracker[NoPublicDetector]", 1, "zipAndReportLog error.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(RegularLogTracker regularLogTracker, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        regularLogTracker.d(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j3) {
        f258208a.j(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long g() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 1);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() - System.currentTimeMillis();
    }

    private final void i() {
        Date date = new Date(QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong("terrible_occur_count_timestamp", System.currentTimeMillis()));
        Date date2 = new Date();
        if (date.getHours() == date2.getHours() && date.getDay() == date2.getDay() && date.getMonth() == date2.getMonth()) {
            return;
        }
        d(true);
    }

    private final void j(long terribleTimeStamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH", Locale.CHINA);
        String format = simpleDateFormat.format(new Date(terribleTimeStamp));
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 1);
        String format2 = simpleDateFormat.format(calendar.getTime());
        ShareAppLogHelper shareAppLogHelper = new ShareAppLogHelper(BaseApplication.context);
        shareAppLogHelper.A(new b(format));
        shareAppLogHelper.p(ShareAppLogHelper.r(format, "-"), ShareAppLogHelper.r(format2, "-"), false, logZipPath);
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        i();
        QLog.i("RegularLogTracker[NoPublicDetector]", 2, "start success.");
        com.tencent.mobileqq.perf.terrible.b.f258047a.t(new a());
        QQPerfHandlerThreadManager.INSTANCE.b(mRunnable, g());
    }
}
