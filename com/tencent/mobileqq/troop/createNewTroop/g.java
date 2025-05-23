package com.tencent.mobileqq.troop.createNewTroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/createNewTroop/g;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "extras", "", "c", "b", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f294743a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28383);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f294743a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Bundle a() {
        return BundleKt.bundleOf(TuplesKt.to(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 0), TuplesKt.to(ISelectMemberActivityConstants.PARAM_MAX, 99), TuplesKt.to("create_source", 0));
    }

    private final void b(Activity activity, Bundle extras) {
        Bundle a16 = a();
        if (extras != null) {
            a16.putAll(extras);
        }
        if (Intrinsics.areEqual("", a16.getString("createScene")) && AppSetting.t(activity)) {
            com.tencent.mobileqq.pad.b c16 = new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.standard).c(R.anim.f154476ii, R.anim.f154480ae, R.anim.f154476ii, R.anim.f154480ae);
            a16.putInt(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, 1);
            i.e(activity, a16, NewTroopCreateFragmentV2.class, c16.a());
        } else {
            Intent intent = new Intent();
            intent.putExtras(a16);
            activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) NewTroopCreateFragmentV2.class, 1300);
        }
    }

    @JvmStatic
    public static final void c(@NotNull Activity activity, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        f294743a.b(activity, extras);
        MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopCreateService.class, "");
    }
}
