package com.tencent.mobileqq.springhb.kuikly;

import android.content.Intent;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.vaswebviewplugin.SpringHbJsPlugin;
import com.tencent.qphone.base.util.QLog;
import i01.a;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0015\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J5\u0010\r\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/springhb/kuikly/SpringKuiklyModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "a", "d", "i", "g", "method", "call", "<init>", "()V", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringKuiklyModule extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/springhb/kuikly/SpringKuiklyModule$Companion;", "", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "a", "", "MODULE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull b renderExport) {
            Intrinsics.checkNotNullParameter(renderExport, "renderExport");
            renderExport.a("SpringKuiklyModule", new Function0<a>() { // from class: com.tencent.mobileqq.springhb.kuikly.SpringKuiklyModule$Companion$registerExternalModule$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    return new SpringKuiklyModule();
                }
            });
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/kuikly/SpringKuiklyModule$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "isVisible", "Z", "a", "()Z", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.kuikly.SpringKuiklyModule$a, reason: from toString */
    /* loaded from: classes18.dex */
    public static final /* data */ class ShowPauseBubbleReq {

        @SerializedName("isVisible")
        private final boolean isVisible;

        /* renamed from: a, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ShowPauseBubbleReq) && this.isVisible == ((ShowPauseBubbleReq) other).isVisible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isVisible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "ShowPauseBubbleReq(isVisible=" + this.isVisible + ")";
        }
    }

    private final void a(Function1<Object, Unit> callback) {
        QLog.d("SpringKuiklyModule", 1, "js\u8c03\u8bd5\uff0ccloseVideo");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent(SpringHbJsPlugin.ACTION_SPRING_CLOSE_VIDEO));
        if (callback != null) {
            callback.invoke("{'result':'\u89c6\u9891\u5173\u95ed\u6210\u529f'}");
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        ISpringHbReportApi iSpringHbReportApi;
        if (params == null) {
            QLog.e("SpringKuiklyModule", 1, "launchReport params is null");
            if (callback != null) {
                callback.invoke("{'result' : 'data is empty'}");
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.webReport(jSONObject, 2);
            }
            if (callback != null) {
                callback.invoke("{'result' : 'success'}");
            }
        } catch (JSONException e16) {
            QLog.e("SpringKuiklyModule", 1, "launchReport params to json is error", e16);
            if (callback != null) {
                callback.invoke("{'result': 'data parse error'}");
            }
        }
    }

    private final void i(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            QLog.e("SpringKuiklyModule", 1, "launchReport params is null");
            if (callback != null) {
                callback.invoke("{'result' : 'data is empty'}");
                return;
            }
            return;
        }
        try {
            QLog.d("SpringKuiklyModule", 1, "showPauseBubble: isVisible = " + ((ShowPauseBubbleReq) new Gson().fromJson(params, ShowPauseBubbleReq.class)).getIsVisible());
            if (callback != null) {
                callback.invoke("{'result' : 'success'}");
            }
        } catch (JsonSyntaxException e16) {
            QLog.e("SpringKuiklyModule", 1, "showPauseBubble params to json is error", e16);
            if (callback != null) {
                callback.invoke("{'result': 'data parse error'}");
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2070199965:
                if (method.equals("closeVideo")) {
                    a(callback);
                    return Unit.INSTANCE;
                }
                QLog.e("SpringKuiklyModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case -338957642:
                if (method.equals("showPack")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                QLog.e("SpringKuiklyModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case -119803163:
                if (method.equals("showPauseBubble")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                QLog.e("SpringKuiklyModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case 3091780:
                if (method.equals("draw")) {
                    c(params, callback);
                    return Unit.INSTANCE;
                }
                QLog.e("SpringKuiklyModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            case 1930886910:
                if (method.equals("reportData")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                QLog.e("SpringKuiklyModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
            default:
                QLog.e("SpringKuiklyModule", 1, "unknown method: " + method);
                return super.call(method, params, callback);
        }
    }

    private final void c(String params, Function1<Object, Unit> callback) {
    }

    private final void g(String params, Function1<Object, Unit> callback) {
    }
}
