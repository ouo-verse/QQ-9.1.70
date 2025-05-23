package com.tencent.mobileqq.perf.memory.dump;

import android.text.format.Time;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.upload.cos.PerfCosUploader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/dump/c;", "", "", "e", "d", "Lkotlin/Pair;", "", "", "f", "c", "Ljava/lang/Object;", "b", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Landroid/text/format/Time;", "Landroid/text/format/Time;", "mLogStartTime", "mLogEndTime", "Ljava/lang/String;", "mZipLogPath", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f257726a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Time mLogStartTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Time mLogEndTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mZipLogPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/perf/memory/dump/c$a", "Lcom/tencent/mobileqq/testassister/ShareAppLogHelper$d;", "", "path", "", "a", "", "code", "onWarning", "onError", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements ShareAppLogHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShareAppLogHelper f257731a;

        a(ShareAppLogHelper shareAppLogHelper) {
            this.f257731a = shareAppLogHelper;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) shareAppLogHelper);
            }
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void a(@Nullable String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (c.lock) {
                    c.mZipLogPath = path;
                    c.lock.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) path);
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void onError(int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                synchronized (c.lock) {
                    c.lock.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, code);
        }

        @Override // com.tencent.mobileqq.testassister.ShareAppLogHelper.d
        public void onWarning(int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                Object obj = c.lock;
                ShareAppLogHelper shareAppLogHelper = this.f257731a;
                synchronized (obj) {
                    shareAppLogHelper.E(false);
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, code);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257726a = new c();
            lock = new Object();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d() {
        ShareAppLogHelper shareAppLogHelper = new ShareAppLogHelper(BaseApplication.context);
        shareAppLogHelper.A(new a(shareAppLogHelper));
        shareAppLogHelper.p(mLogStartTime, mLogEndTime, true, com.tencent.mobileqq.perf.memory.dump.a.f257721a.a());
    }

    private final void e() {
        String format;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH", Locale.CHINA);
        Calendar calendar = Calendar.getInstance();
        String format2 = simpleDateFormat.format(calendar.getTime());
        if (calendar.get(12) > 30) {
            format = format2;
        } else {
            calendar.add(11, -1);
            format = simpleDateFormat.format(calendar.getTime());
        }
        mLogStartTime = ShareAppLogHelper.r(format, "-");
        mLogEndTime = ShareAppLogHelper.r(format2, "-");
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e();
        if (mLogStartTime != null && mLogEndTime != null) {
            Object obj = lock;
            synchronized (obj) {
                f257726a.d();
                LockMethodProxy.wait(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
        return mZipLogPath;
    }

    @NotNull
    public final Pair<String, Long> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String c16 = c();
        if (c16 != null && new File(c16).exists()) {
            long length = new File(c16).length();
            if (length > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                QLog.d("LogDump", 1, "dump log fail, over size limit, fileSize:" + length);
                FileUtils.deleteFile(c16);
                return new Pair<>(null, Long.valueOf(length));
            }
            String str = "logs_zip_" + com.tencent.mobileqq.perf.memory.dump.a.f257721a.b().format(new Date());
            QLog.d("LogDump", 1, "dump log complete, fileSize:" + length + "\uff0c logUUid:" + str);
            String d16 = PerfCosUploader.d(PerfCosUploader.f258269a, PerfCosUploader.BucketType.QLOG, c16, str, false, 8, null);
            FileUtils.deleteFile(c16);
            return new Pair<>(d16, Long.valueOf(length));
        }
        QLog.d("LogDump", 1, "dump log fail, return");
        return new Pair<>(null, 0L);
    }
}
