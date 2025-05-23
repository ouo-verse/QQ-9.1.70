package com.tencent.mobileqq.quiprofile;

import android.content.Context;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QUIProfileResources;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/quiprofile/a;", "", "Landroid/content/Context;", "context", "Landroid/content/res/Resources;", PM.BASE, "Landroid/content/res/QUIProfileResources;", "c", "Landroid/view/LayoutInflater;", "Landroid/content/res/QUIProfileLayoutInflater;", "b", "d", "a", "Lbe0/a;", "kotlin.jvm.PlatformType", "e", "", "Ljava/lang/String;", "quiProfileId", "Landroid/content/res/QUIProfileResources;", "quiResources", "Landroid/content/res/QUIProfileLayoutInflater;", "quiLayoutInflater", "<init>", "(Ljava/lang/String;)V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String quiProfileId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIProfileResources quiResources;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIProfileLayoutInflater quiLayoutInflater;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/quiprofile/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.quiprofile.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String quiProfileId) {
        Intrinsics.checkNotNullParameter(quiProfileId, "quiProfileId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) quiProfileId);
        } else {
            this.quiProfileId = quiProfileId;
        }
    }

    private final QUIProfileLayoutInflater b(Context context, LayoutInflater base) {
        return new QUIProfileLayoutInflater(base, context, this.quiProfileId);
    }

    private final QUIProfileResources c(Context context, Resources base) {
        return new QUIProfileResources(base, context, this.quiProfileId);
    }

    @NotNull
    public final LayoutInflater a(@NotNull Context context, @NotNull LayoutInflater base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LayoutInflater) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) base);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(base, "base");
        if (QLog.isColorLevel()) {
            QLog.d("QPublicQUIProfileTheme", 2, "getLayoutInflater: ");
        }
        QUIProfileLayoutInflater qUIProfileLayoutInflater = this.quiLayoutInflater;
        if (qUIProfileLayoutInflater == null) {
            QUIProfileLayoutInflater b16 = b(context, base);
            this.quiLayoutInflater = b16;
            return b16;
        }
        return qUIProfileLayoutInflater;
    }

    @NotNull
    public final Resources d(@NotNull Context context, @NotNull Resources base) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Resources) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) base);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(base, "base");
        QUIProfileResources qUIProfileResources = this.quiResources;
        if (qUIProfileResources == null) {
            QUIProfileResources c16 = c(context, base);
            this.quiResources = c16;
            return c16;
        }
        return qUIProfileResources;
    }

    public final be0.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (be0.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return be0.a.b(this.quiProfileId);
    }
}
