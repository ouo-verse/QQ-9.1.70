package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUIProfileConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/activity/ec;", "", "", "d", "", "c", "Landroid/content/res/Resources;", PM.BASE, "b", "Landroid/view/LayoutInflater;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/content/res/QUIProfileResources;", "Landroid/content/res/QUIProfileResources;", "quiResources", "Landroid/content/res/QUIProfileLayoutInflater;", "Landroid/content/res/QUIProfileLayoutInflater;", "quiLayoutInflater", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setColorPalette", "<init>", "(Landroid/content/Context;)V", "e", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class ec {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIProfileResources quiResources;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIProfileLayoutInflater quiLayoutInflater;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean setColorPalette;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/ec$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.ec$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ec(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
            this.setColorPalette = new AtomicBoolean(false);
        }
    }

    private final boolean c() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !QQTheme.isNowThemeIsNight() && !QQTheme.isDefaultTheme() && !Intrinsics.areEqual("2971", QQTheme.getCurrentThemeId())) {
            return true;
        }
        return false;
    }

    private final void d() {
        if (this.setColorPalette.getAndSet(true)) {
            return;
        }
        be0.a.b("login").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
    }

    @NotNull
    public final LayoutInflater a(@NotNull LayoutInflater base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LayoutInflater) iPatchRedirector.redirect((short) 4, (Object) this, (Object) base);
        }
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileLayoutInflater qUIProfileLayoutInflater = this.quiLayoutInflater;
        if (qUIProfileLayoutInflater != null) {
            return qUIProfileLayoutInflater;
        }
        if (c()) {
            QLog.i("LoginQUIProfileResources", 1, "use profile layout inflater " + this.context.getClass().getName());
            this.quiLayoutInflater = new QUIProfileLayoutInflater(base, this.context, "login");
            d();
            QUIProfileLayoutInflater qUIProfileLayoutInflater2 = this.quiLayoutInflater;
            Intrinsics.checkNotNull(qUIProfileLayoutInflater2);
            return qUIProfileLayoutInflater2;
        }
        return base;
    }

    @NotNull
    public final Resources b(@NotNull Resources base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Resources) iPatchRedirector.redirect((short) 3, (Object) this, (Object) base);
        }
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileResources qUIProfileResources = this.quiResources;
        if (qUIProfileResources != null) {
            return qUIProfileResources;
        }
        if (c()) {
            QLog.i("LoginQUIProfileResources", 1, "use profile resources " + this.context.getClass().getName());
            this.quiResources = new QUIProfileResources(base, this.context, "login");
            d();
            QUIProfileResources qUIProfileResources2 = this.quiResources;
            Intrinsics.checkNotNull(qUIProfileResources2);
            return qUIProfileResources2;
        }
        return base;
    }
}
