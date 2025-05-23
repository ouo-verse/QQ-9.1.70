package pj3;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.utils.am;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import t74.r;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0002J.\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lpj3/b;", "Ldl0/b;", "", "url", "", "result", "", "timeCost", "", "errorCode", "errorMessage", "", "c", "", "header", "Lgl0/a;", "listener", "a", "Ljava/lang/String;", "tmpDir", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements dl0.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String tmpDir = am.f335779a.a() + "/tmp";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"pj3/b$b", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "c", "", "code", tl.h.F, "", "b", "J", "beginEnqueue", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pj3.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11022b extends ah {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long beginEnqueue;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f426329d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ gl0.a f426330e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11022b(String str, gl0.a aVar) {
            super(null, 1, null);
            this.f426329d = str;
            this.f426330e = aVar;
            this.beginEnqueue = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.c(task);
            b.d(b.this, this.f426329d, true, SystemClock.uptimeMillis() - this.beginEnqueue, task.getDownloadFailCode(), null, 16, null);
            this.f426330e.a(task.m(), 200, task.getHttpRspHeaderMap());
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.h(code, task);
            long uptimeMillis = SystemClock.uptimeMillis() - this.beginEnqueue;
            QLog.e("QQFilamentDownloadProxy", 1, "download onFailed, url=" + this.f426329d + ", failCode=" + task.getDownloadFailCode() + ", failInfo=" + task.getDownloadFailInfo());
            b.this.c(this.f426329d, false, uptimeMillis, task.getDownloadFailCode(), task.getDownloadFailInfo());
            if (code != 304 && code != 404) {
                this.f426330e.b("failInfo: " + task.getDownloadFailInfo() + ", failCode: " + task.getDownloadFailCode());
                return;
            }
            this.f426330e.a(null, code, task.getHttpRspHeaderMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String url, boolean result, long timeCost, int errorCode, String errorMessage) {
        Map mutableMapOf;
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getAccount();
        if (account == null) {
            account = "";
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("params_download_url", url), TuplesKt.to("params_download_ret", lx4.b.INSTANCE.a(result)), TuplesKt.to("params_download_duration", String.valueOf(timeCost)), TuplesKt.to("params_download_error_code", String.valueOf(errorCode)), TuplesKt.to("params_download_error_msg", errorMessage), TuplesKt.to("params_uin", account), TuplesKt.to("params_timestamp", String.valueOf(System.currentTimeMillis())));
        r.e(null, "zplanlite_download_res_native_app", mutableMapOf, 1, null);
    }

    @Override // dl0.b
    public void a(String url, Map<String, String> header, gl0.a listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String c16 = com.tencent.zplan.common.utils.d.c(url);
        long uptimeMillis = SystemClock.uptimeMillis();
        String str = this.tmpDir + "/" + c16;
        com.tencent.mobileqq.zplan.utils.h hVar = com.tencent.mobileqq.zplan.utils.h.f335824a;
        String c17 = hVar.c(url, str);
        boolean z16 = false;
        if (c17 != null) {
            if (c17.length() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            QLog.i("QQFilamentDownloadProxy", 1, "copy from asset onComplete " + str + ", [timecost=" + (SystemClock.uptimeMillis() - uptimeMillis) + "][url=" + url + "]");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = c17.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            listener.a(str, 200, hVar.b(lowerCase));
            return;
        }
        ZPlanFileDownloadUtil.f328039a.f(ZPlanFileCategory.FILAMENT.getValue(), url, this.tmpDir, c16, "", header, Boolean.TRUE, new C11022b(url, listener));
    }

    static /* synthetic */ void d(b bVar, String str, boolean z16, long j3, int i3, String str2, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            str2 = "";
        }
        bVar.c(str, z16, j3, i3, str2);
    }
}
