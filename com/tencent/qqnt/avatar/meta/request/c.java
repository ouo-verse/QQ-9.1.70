package com.tencent.qqnt.avatar.meta.request;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.util.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0006B%\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/request/c;", "T", "", "Landroid/content/Context;", "b", "Lcom/tencent/qqnt/avatar/meta/a;", "a", "Lcom/tencent/qqnt/avatar/meta/a;", "()Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "Lcom/tencent/qqnt/avatar/meta/request/a;", "Lcom/tencent/qqnt/avatar/meta/request/a;", "c", "()Lcom/tencent/qqnt/avatar/meta/request/a;", "loadTarget", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "weakContext", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/avatar/meta/a;Lcom/tencent/qqnt/avatar/meta/request/a;)V", "d", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.a avatarBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a<T> loadTarget;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> weakContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/request/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.request.c$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40244);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull Context context, @NotNull com.tencent.qqnt.avatar.meta.a avatarBean, @NotNull a<T> loadTarget) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(loadTarget, "loadTarget");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, avatarBean, loadTarget);
            return;
        }
        this.avatarBean = avatarBean;
        this.loadTarget = loadTarget;
        this.weakContext = new WeakReference<>(context);
    }

    @NotNull
    public final com.tencent.qqnt.avatar.meta.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.meta.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.avatarBean;
    }

    @Nullable
    public final Context b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Context) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Context context = this.weakContext.get();
        if (context == null) {
            d.d(d.f352991a, "LoadRequest", "getContext return null", null, 4, null);
        }
        return context;
    }

    @NotNull
    public final a<T> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.loadTarget;
    }
}
