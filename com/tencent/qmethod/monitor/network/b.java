package com.tencent.qmethod.monitor.network;

import android.os.Handler;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qmethod/monitor/network/b;", "", "", "url", "Lorg/json/JSONObject;", "params", "Lcom/tencent/qmethod/monitor/network/c;", "response", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "timeoutTime", "", "a", "Landroid/os/Handler;", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handler", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f343747b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Handler handler = new Handler(ThreadManager.f343506c.a());

    b() {
    }

    public static /* synthetic */ void b(b bVar, String str, JSONObject jSONObject, c cVar, String str2, int i3, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i16 & 16) != 0) {
            i3 = 30000;
        }
        bVar.a(str, jSONObject, cVar, str3, i3);
    }

    public final void a(@NotNull String url, @NotNull JSONObject params, @NotNull c response, @NotNull String requestId, int timeoutTime) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(response, "response");
        Intrinsics.checkParameterIsNotNull(requestId, "requestId");
        handler.post(new JsonUploadRunnable(new URL(url), params, response, requestId, timeoutTime));
    }
}
