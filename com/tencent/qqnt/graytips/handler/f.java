package com.tencent.qqnt.graytips.handler;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IPaiYiPaiApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/graytips/handler/f;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "Lorg/json/JSONObject;", "b", "jsonObject", "a", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f implements b {
    static IPatchRedirector $redirector_;

    public f() {
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
        return new com.tencent.qqnt.graytips.action.i();
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public JSONObject b(@NotNull com.tencent.qqnt.graytips.action.f actionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionInfo);
        }
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
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
        if (!(actionInfo instanceof com.tencent.qqnt.graytips.action.i)) {
            return;
        }
        ((IPaiYiPaiApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPaiYiPaiApi.class)).jumpToWeb(context);
    }
}
