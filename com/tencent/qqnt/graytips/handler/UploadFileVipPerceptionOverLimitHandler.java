package com.tencent.qqnt.graytips.handler;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/graytips/handler/UploadFileVipPerceptionOverLimitHandler;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "Lorg/json/JSONObject;", "b", "jsonObject", "a", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class UploadFileVipPerceptionOverLimitHandler implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/graytips/handler/UploadFileVipPerceptionOverLimitHandler$a;", "", "", "HIPPY_PAY_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.handler.UploadFileVipPerceptionOverLimitHandler$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30791);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public UploadFileVipPerceptionOverLimitHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public com.tencent.qqnt.graytips.action.f a(@NotNull JSONObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.graytips.action.f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jsonObject);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String hippyPayUrl = jsonObject.optString("hippy_pay_url", "mqqapi://kuikly/open?aid=mios.n.gw.gn_aiplus&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAzIn0%3D&version=1&kr_turbo_display=svip&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=svip&business_type=svip&half_pay=1&modal_mode=1&month=1&policy_id=aiplus");
        Intrinsics.checkNotNullExpressionValue(hippyPayUrl, "hippyPayUrl");
        return new n(hippyPayUrl);
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public JSONObject b(@NotNull com.tencent.qqnt.graytips.action.f actionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionInfo);
        }
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (actionInfo instanceof n) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hippy_pay_url", ((n) actionInfo).a());
            return jSONObject;
        }
        return new JSONObject();
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(@NotNull AppRuntime app, @NotNull Context context, @NotNull com.tencent.qqnt.graytips.action.f actionInfo, @Nullable gv3.a aioAbility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, context, actionInfo, aioAbility);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        if (!(actionInfo instanceof n)) {
            return;
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(((n) actionInfo).a()));
        if (context instanceof Application) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        QLog.i("UploadFileVipPerceptionOverLimitHandler", 1, "start pay");
    }
}
