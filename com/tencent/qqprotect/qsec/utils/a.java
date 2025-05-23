package com.tencent.qqprotect.qsec.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.UpdateType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqprotect.qsec.api.IO3AssistantRobotApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqprotect/qsec/utils/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqprotect/qsec/api/a;", "userAccountInfo", "Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi$a;", "openCallback", "", "c", "b", "", "code", "", "msg", "a", "Lcom/tencent/qqprotect/qsec/api/IO3AssistantRobotApi$a;", "<init>", "()V", "qqprotect-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f363534a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static IO3AssistantRobotApi.a openCallback;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17710);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f363534a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(int code, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, code, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        IO3AssistantRobotApi.a aVar = openCallback;
        if (aVar != null) {
            aVar.onFailed(code, msg2);
        }
        openCallback = null;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        IO3AssistantRobotApi.a aVar = openCallback;
        if (aVar != null) {
            aVar.onSuccess();
        }
        openCallback = null;
    }

    public final void c(@NotNull Context context, @NotNull com.tencent.qqprotect.qsec.api.a userAccountInfo, @NotNull IO3AssistantRobotApi.a openCallback2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, userAccountInfo, openCallback2);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userAccountInfo, "userAccountInfo");
        Intrinsics.checkNotNullParameter(openCallback2, "openCallback");
        KuiklyLaunchParams kuiklyLaunchParams = new KuiklyLaunchParams();
        kuiklyLaunchParams.setDynamicMode(true);
        kuiklyLaunchParams.setPageName("FindPwdRobotPage");
        kuiklyLaunchParams.setModal(true);
        Map<String, Object> extMap = kuiklyLaunchParams.getExtMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uin", userAccountInfo.c());
        jSONObject.put("uinToken", userAccountInfo.d());
        jSONObject.put("email", userAccountInfo.a());
        jSONObject.put("src", userAccountInfo.b());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026src)\n        }.toString()");
        extMap.put("robotModel", jSONObject2);
        kuiklyLaunchParams.setResId("find_pwd_robot");
        kuiklyLaunchParams.setUpdateType(UpdateType.TYPE_USE_LOCAL_PRIORITY);
        kuiklyLaunchParams.setProcessName("local");
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, kuiklyLaunchParams);
        openCallback = openCallback2;
    }
}
