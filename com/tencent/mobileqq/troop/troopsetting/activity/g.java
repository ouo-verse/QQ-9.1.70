package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/activity/g;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extras", "", "visitorType", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f301063a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f301063a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@NotNull Context context, @NotNull Bundle extras, int visitorType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intent intent = new Intent();
        intent.putExtras(extras);
        intent.putExtra(ITroopUtilsApi.VISTOR_TYPE, visitorType);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (AppSetting.t(context)) {
            i.e(context, intent.getExtras(), TroopSettingFragmentV2.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
        } else {
            QPublicFragmentActivity.start(context, intent, TroopSettingFragmentV2.class);
        }
    }
}
