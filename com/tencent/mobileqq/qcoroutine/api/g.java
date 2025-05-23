package com.tencent.mobileqq.qcoroutine.api;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.theme.ThemeConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b \u0010!B#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b \u0010\"R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/api/g;", "Lcom/tencent/mobileqq/qcoroutine/api/d;", "", "g", "Ljava/lang/String;", "j", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "groupId", "Ljava/lang/ref/WeakReference;", "Ljava/lang/Runnable;", tl.h.F, "Ljava/lang/ref/WeakReference;", "l", "()Ljava/lang/ref/WeakReference;", "setRunnableWrap", "(Ljava/lang/ref/WeakReference;)V", "runnableWrap", "i", "Ljava/lang/Runnable;", "k", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "runnable", ThemeConstants.THEME_DIY_BG_NAME_SUFFIX, "Lcom/tencent/mobileqq/qcoroutine/api/i;", "_type", "", "_canAutoRetrieve", "_runnable", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;ZLjava/lang/Runnable;)V", "(Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;Ljava/lang/Runnable;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public class g extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String groupId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Runnable> runnableWrap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable runnable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull String _name, @NotNull i _type, boolean z16, @Nullable Runnable runnable) {
        super(_name, _type, z16);
        Intrinsics.checkNotNullParameter(_name, "_name");
        Intrinsics.checkNotNullParameter(_type, "_type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, _name, _type, Boolean.valueOf(z16), runnable);
        } else if (runnable != null) {
            if (b()) {
                this.runnableWrap = new WeakReference<>(runnable);
            } else {
                this.runnable = runnable;
            }
        }
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.groupId;
    }

    @Nullable
    public final Runnable k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Runnable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.runnable;
    }

    @Nullable
    public final WeakReference<Runnable> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (WeakReference) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.runnableWrap;
    }

    public final void m(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.groupId = str;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(@NotNull String _name, @NotNull i _type, @Nullable Runnable runnable) {
        this(_name, _type, true, runnable);
        Intrinsics.checkNotNullParameter(_name, "_name");
        Intrinsics.checkNotNullParameter(_type, "_type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, _name, _type, runnable);
    }
}
