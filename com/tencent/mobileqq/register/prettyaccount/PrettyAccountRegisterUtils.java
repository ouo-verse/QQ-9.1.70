package com.tencent.mobileqq.register.prettyaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.vas.VasTabFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountRegisterUtils;", "", "Lcom/tencent/mobileqq/register/prettyaccount/PrettyAccountABTestExp;", "f", "", "g", "Landroid/content/Intent;", "intent", "d", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAbTestInit", "", "Lkotlin/Lazy;", "e", "()Z", "prettyAccountEntrySwitch", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PrettyAccountRegisterUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PrettyAccountRegisterUtils f280539a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean isAbTestInit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy prettyAccountEntrySwitch;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f280542a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27180);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[VasTabFactory.ABTest.values().length];
            try {
                iArr[VasTabFactory.ABTest.B.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VasTabFactory.ABTest.C.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f280542a = iArr;
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27191);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f280539a = new PrettyAccountRegisterUtils();
        isAbTestInit = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(PrettyAccountRegisterUtils$prettyAccountEntrySwitch$2.INSTANCE);
        prettyAccountEntrySwitch = lazy;
    }

    PrettyAccountRegisterUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e() {
        Object value = prettyAccountEntrySwitch.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-prettyAccountEntrySwitch>(...)");
        return ((Boolean) value).booleanValue();
    }

    private final PrettyAccountABTestExp f() {
        PrettyAccountABTestExp prettyAccountABTestExp;
        VasTabFactory.ABTest a16 = t13.a.f435305a.a();
        int i3 = a.f280542a[a16.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                prettyAccountABTestExp = PrettyAccountABTestExp.EXP_DEF;
            } else {
                prettyAccountABTestExp = PrettyAccountABTestExp.EXP_2;
            }
        } else {
            prettyAccountABTestExp = PrettyAccountABTestExp.EXP_1;
        }
        QLog.i("PrettyAccountRegisterUtils", 1, "getPrettyAccountRegisterAbTest vas: " + a16 + ", exp: " + prettyAccountABTestExp);
        return prettyAccountABTestExp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        String c16;
        if (isAbTestInit.compareAndSet(false, true) && (c16 = o.c()) != null) {
            String upperCase = c16.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
            ABTestController.getInstance().doInit1504(upperCase);
        }
    }

    @NotNull
    public final Drawable b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(context, R.color.qui_common_border_standard));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_light));
        gradientDrawable2.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(context, R.color.qui_common_border_standard));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    @NotNull
    public final PrettyAccountABTestExp c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PrettyAccountABTestExp) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f();
    }

    @NotNull
    public final PrettyAccountABTestExp d(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PrettyAccountABTestExp) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        if (!e()) {
            return PrettyAccountABTestExp.EXP_DEF;
        }
        if (intent == null) {
            return PrettyAccountABTestExp.EXP_DEF;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_is_from_gateway_register", false);
        QLog.d("PrettyAccountRegisterUtils", 4, "getPhoneRegisterPageAbTest fromGateway: " + booleanExtra + " ");
        if (booleanExtra) {
            return PrettyAccountABTestExp.EXP_DEF;
        }
        return f();
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.register.prettyaccount.d
                @Override // java.lang.Runnable
                public final void run() {
                    PrettyAccountRegisterUtils.h();
                }
            }, 240, null, false);
        }
    }

    public final void i(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.i("PrettyAccountRegisterUtils", 1, "launchPrettyAccountRegisterPage");
        t13.a.f435305a.b(activity);
    }
}
