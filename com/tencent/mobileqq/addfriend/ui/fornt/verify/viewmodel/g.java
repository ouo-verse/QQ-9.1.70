package com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel;

import android.app.Activity;
import android.content.SharedPreferences;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", "Landroidx/lifecycle/ViewModel;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isTroop", "", "L1", "", "N1", "msg", "O1", "M1", "<init>", "()V", "i", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g$a;", "", "", "LAST_ADD_FRIEND_VERIFY", "Ljava/lang/String;", "LAST_ADD_TROOP_VERFITY", "LAST_VERIFY_MSG", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24145);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String L1(@Nullable Activity activity, boolean isTroop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, activity, Boolean.valueOf(isTroop));
        }
        if (activity == null || MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return null;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences("last_verify_msg", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "activity.getSharedPrefer\u2026SG, Context.MODE_PRIVATE)");
        if (isTroop) {
            return sharedPreferences.getString("last_add_troop_verfity_" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), null);
        }
        return sharedPreferences.getString("last_add_friend_verify_" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), null);
    }

    public final boolean M1(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity)).booleanValue();
        }
        if (activity == null || MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return false;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences("last_verify_msg", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "activity.getSharedPrefer\u2026SG, Context.MODE_PRIVATE)");
        return sharedPreferences.getBoolean("add_friend_verify_msg_modify_flag" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), false);
    }

    public final void N1(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        if (activity != null && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences("last_verify_msg", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "activity.getSharedPrefer\u2026SG, Context.MODE_PRIVATE)");
            sharedPreferences.edit().putBoolean("add_friend_verify_msg_modify_flag" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), true);
            sharedPreferences.edit().apply();
        }
    }

    public final void O1(@NotNull Activity activity, @Nullable String msg2, boolean isTroop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, msg2, Boolean.valueOf(isTroop));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        SharedPreferences sharedPreferences = activity.getSharedPreferences("last_verify_msg", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "activity.getSharedPrefer\u2026SG, Context.MODE_PRIVATE)");
        if (isTroop) {
            sharedPreferences.edit().putString("last_add_troop_verfity_" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), msg2).commit();
            return;
        }
        sharedPreferences.edit().putString("last_add_friend_verify_" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), msg2).commit();
    }
}
