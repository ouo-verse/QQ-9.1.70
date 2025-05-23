package com.tencent.qmethod.monitor.ext.download;

import android.os.Handler;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.network.c;
import com.tencent.qmethod.monitor.network.e;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import or3.c;
import or3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\f\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/download/Reporter;", "", "Lcom/tencent/qmethod/monitor/ext/download/a;", "info", "", "d", "", "", "e", h.F, "Lorg/json/JSONObject;", "g", "f", "", "a", "Ljava/util/List;", "reportKeyList", "b", "Ljava/lang/Object;", "SAMPLE_LOCK", "Landroid/os/Handler;", "c", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class Reporter {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy handler;

    /* renamed from: d, reason: collision with root package name */
    public static final Reporter f343628d = new Reporter();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final List<String> reportKeyList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Object SAMPLE_LOCK = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qmethod/monitor/ext/download/Reporter$a", "Lcom/tencent/qmethod/monitor/network/c;", "", "responseJson", "", "onSuccess", "", "errorCode", "errorMsg", "onFailure", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f343629a;

        a(DownloadInfo downloadInfo) {
            this.f343629a = downloadInfo;
        }

        @Override // com.tencent.qmethod.monitor.network.c
        public void onFailure(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            Reporter.f343628d.h(this.f343629a);
        }

        @Override // com.tencent.qmethod.monitor.network.c
        public void onSuccess(@NotNull String responseJson) {
            Intrinsics.checkParameterIsNotNull(responseJson, "responseJson");
            Reporter reporter = Reporter.f343628d;
            if (!reporter.e(responseJson)) {
                reporter.h(this.f343629a);
                return;
            }
            DownloadInfo downloadInfo = this.f343629a;
            downloadInfo.v(false);
            reporter.h(downloadInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qmethod/monitor/ext/download/Reporter$b", "Lor3/c$a;", "", "dbId", "", "onSuccess", "errorCode", "", "errorMsg", "a", "onCached", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b implements c.a {
        b() {
        }

        @Override // or3.c.a
        public void a(int errorCode, @NotNull String errorMsg, int dbId) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            o.a("DownloadReporter", "errorCode:" + errorCode + ", errorMsg=" + errorMsg + ", dbId=" + dbId);
        }

        @Override // or3.c.a
        public void onCached() {
            o.a("DownloadReporter", "dbId=onCached");
        }

        @Override // or3.c.a
        public void onSuccess(int dbId) {
            o.a("DownloadReporter", "dbId=" + dbId);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<Handler>() { // from class: com.tencent.qmethod.monitor.ext.download.Reporter$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(ThreadManager.f343506c.b());
            }
        });
        handler = lazy;
    }

    Reporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(DownloadInfo info) {
        com.tencent.qmethod.monitor.network.b bVar = com.tencent.qmethod.monitor.network.b.f343747b;
        String str = e.f343757e.a() + "api/v1/download/monitor/Check";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", com.tencent.qmethod.monitor.a.f343451h.g().getAppId());
        NetworkUtil networkUtil = NetworkUtil.f343513c;
        String jSONObject2 = f343628d.f(new JSONObject(), info).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().putAttribut\u2026rtParams(info).toString()");
        jSONObject.put("data", networkUtil.a(jSONObject2));
        com.tencent.qmethod.monitor.network.b.b(bVar, str, jSONObject, new a(info), null, 0, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r2.optInt("stop_upload_pic", 0) == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(@Nullable String str) {
        boolean z16;
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("code", -1) == 0) {
            }
            z17 = false;
            return z17;
        } catch (Throwable th5) {
            o.c("DownloadReporter", th5 + ": response parameter json error");
            return false;
        }
    }

    private final JSONObject f(@NotNull JSONObject jSONObject, DownloadInfo downloadInfo) {
        jSONObject.put("native_ui", downloadInfo.getNativeUI());
        jSONObject.put("check_time", downloadInfo.getCheckTime());
        jSONObject.put("download_btn", downloadInfo.getDownloadBtn() ? 1 : 0);
        jSONObject.put(TuxDialogBundleKey.WEB_URL, downloadInfo.getWebUrl());
        jSONObject.put("apk_url", downloadInfo.getApkURL());
        jSONObject.put("apk_ver_name", downloadInfo.getApkVerName());
        jSONObject.put("apk_ver_code", downloadInfo.getApkVerCode());
        jSONObject.put("apk_pkg", downloadInfo.getApkPkg());
        jSONObject.put("apk_is_game", downloadInfo.getIsGame());
        jSONObject.put("app_author", downloadInfo.getAppAuthor());
        jSONObject.put("app_ver", downloadInfo.getAppVersion());
        jSONObject.put("app_name", downloadInfo.getAppName());
        jSONObject.put("app_privacy", downloadInfo.getAppPrivacy());
        jSONObject.put("app_perm", downloadInfo.getAppPermission());
        jSONObject.put("game_cp", downloadInfo.getGameCP());
        return jSONObject;
    }

    private final void g(@NotNull JSONObject jSONObject, DownloadInfo downloadInfo) {
        byte[] screenCapture;
        NetworkUtil networkUtil = NetworkUtil.f343513c;
        String jSONObject2 = f(new JSONObject(), downloadInfo).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().putAttribut\u2026rtParams(info).toString()");
        jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, networkUtil.a(jSONObject2));
        if (downloadInfo.getNeedCapture() && (screenCapture = downloadInfo.getScreenCapture()) != null) {
            jSONObject.put(ReportDataBuilder.KEY_BODY, networkUtil.b(screenCapture));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(DownloadInfo info) {
        if (!com.tencent.qmethod.monitor.a.f343451h.h()) {
            return;
        }
        JSONObject e16 = pr3.b.f427061b.e("compliance", "download_monitor", System.currentTimeMillis() / 1000);
        try {
            f343628d.g(e16, info);
            d.f423470e.a(new ReportData(e16, true), new b());
        } catch (InvalidParameterException e17) {
            o.d("DownloadReporter", "report error:", e17);
        }
    }
}
