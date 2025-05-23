package com.tencent.mobileqq.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.qwallet.activity.MidasPayBridgeFragment;
import com.tencent.biz.TenpayActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment;
import com.tenpay.sdk.activity.GrapHbActivity;
import com.tenpay.sdk.activity.GrapMchHbActivity;
import com.tenpay.sdk.activity.GrapSpecifyHBActivity;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletToolFragmentActivity;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007J:\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0002J*\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00062\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/base/c;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragmentClass", "", "forceMainProcess", "", "e", "", "requestCode", h.F, "a", "c", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "b", "", "[Ljava/lang/Class;", "fragmentsInMainProcess", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final c f200277a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Class<? extends QWalletBaseFragment>[] fragmentsInMainProcess;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f200277a = new c();
            fragmentsInMainProcess = new Class[]{GrapHbActivity.class, GrapSpecifyHBActivity.class, GrapMchHbActivity.class, MidasPayBridgeFragment.class, GrabVoiceHbFragment.class};
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.mobileqq.fragment.QPublicBaseFragment] */
    private final void a(Intent intent, Context context) {
        QPublicFragmentActivity qPublicFragmentActivity;
        intent.putExtra(IQWalletHelper.EXTRA_LAUNCH_TIME, ql2.d.a());
        ?? r16 = 0;
        if (context instanceof QPublicFragmentActivity) {
            qPublicFragmentActivity = (QPublicFragmentActivity) context;
        } else {
            qPublicFragmentActivity = null;
        }
        if (qPublicFragmentActivity != null) {
            r16 = qPublicFragmentActivity.getFragment();
        }
        if (r16 != 0) {
            context = r16;
        }
        intent.putExtra(IQWalletHelper.EXTRA_FROM_ACTIVITY, context.getClass().getCanonicalName());
    }

    private final Class<? extends QPublicFragmentActivity> b(Class<? extends QWalletBaseFragment> fragmentClass, boolean forceMainProcess) {
        if (!c(fragmentClass) && !forceMainProcess) {
            return QWalletToolFragmentActivity.class;
        }
        return TenpayActivity.class;
    }

    private final boolean c(Class<? extends QWalletBaseFragment> fragmentClass) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(fragmentsInMainProcess, fragmentClass);
        return contains;
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@Nullable Context context, @NotNull Intent intent, @NotNull Class<? extends QWalletBaseFragment> fragmentClass) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        f(context, intent, fragmentClass, false, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(@Nullable Context context, @NotNull Intent intent, @NotNull Class<? extends QWalletBaseFragment> fragmentClass, boolean forceMainProcess) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        if (context == null) {
            return;
        }
        boolean z16 = context instanceof Activity;
        boolean z17 = context instanceof QWalletToolFragmentActivity;
        if (!intent.getBooleanExtra("no_start_for_result_for_api_go_to_view", false) && z16 && !z17) {
            h(context, intent, fragmentClass, 3001, forceMainProcess);
            return;
        }
        c cVar = f200277a;
        cVar.a(intent, context);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(context, intent, cVar.b(fragmentClass, forceMainProcess), fragmentClass);
    }

    public static /* synthetic */ void f(Context context, Intent intent, Class cls, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        e(context, intent, cls, z16);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends QWalletBaseFragment> fragmentClass, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        i(context, intent, fragmentClass, i3, false, 16, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends QWalletBaseFragment> fragmentClass, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        c cVar = f200277a;
        cVar.a(intent, context);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.f(context, intent, cVar.b(fragmentClass, z16), fragmentClass, i3);
    }

    public static /* synthetic */ void i(Context context, Intent intent, Class cls, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        h(context, intent, cls, i3, z16);
    }
}
