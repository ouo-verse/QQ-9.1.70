package com.tencent.qqnt.http.api;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.beacon.NTBeaconReport;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJH\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0002R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/http/api/i;", "", "", "tag", "", "isSucc", "", "errorCode", "httpCode", "", "fileSize", "taskCostTime", "url", "errMsg", "", "c", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "b", "a", "Ljava/util/Random;", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "<init>", "()V", "http_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f356996a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Random random;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42561);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f356996a = new i();
            random = new Random();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(String tag, boolean isSucc, int errorCode, int httpCode, long fileSize, long taskCostTime, String url, String errMsg) {
        String str;
        if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion() || taskCostTime <= 0 || random.nextInt(10000) > 0) {
            return;
        }
        String a16 = a();
        HashMap hashMap = new HashMap();
        if (isSucc) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("REPORT_KEY_SUCC", str);
        hashMap.put("REPORT_KEY_ERROR_CODE", String.valueOf(errorCode));
        hashMap.put("REPORT_KEY_HTTP_CODE", String.valueOf(httpCode));
        hashMap.put("REPORT_KEY_FILE_SIZE", String.valueOf(fileSize));
        hashMap.put("REPORT_KEY_TASK_COST_TIME", String.valueOf(taskCostTime));
        if (a16 != null) {
            hashMap.put("REPORT_KEY_UIN", a16);
        }
        if (!isSucc) {
            hashMap.put("REPORT_KEY_URL", url);
            hashMap.put("REPORT_KEY_ERROR_MSG", errMsg);
        }
        NTBeaconReport.h(a16, tag, hashMap);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            str = waitAppRuntime.getAccount();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void b(@NotNull b task, @NotNull m result, long taskCostTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, task, result, Long.valueOf(taskCostTime));
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!task.z()) {
            boolean e16 = result.e();
            int a16 = result.a();
            Integer c16 = result.c();
            if (c16 != null) {
                i3 = c16.intValue();
            }
            int i16 = i3;
            long e17 = task.s().e();
            String x16 = task.x();
            String b16 = result.b();
            if (b16 == null) {
                b16 = "";
            }
            c("NT_HTTP_REPORT_TAG", e16, a16, i16, e17, taskCostTime, x16, b16);
        }
    }
}
