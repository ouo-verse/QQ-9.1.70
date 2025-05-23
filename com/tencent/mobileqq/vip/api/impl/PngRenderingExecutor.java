package com.tencent.mobileqq.vip.api.impl;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u001c\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/PngRenderingExecutor;", "", "Ljava/lang/Runnable;", "runnable", "", "delay", "", "e", "f", "Landroid/graphics/drawable/Drawable;", "drawable", "a", "", ReportConstant.COSTREPORT_PREFIX, "d", "Ljava/lang/Exception;", "b", "<init>", "()V", "UpdateDrawableRunnable", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PngRenderingExecutor {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/PngRenderingExecutor$UpdateDrawableRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Landroid/graphics/drawable/Drawable;", "d", "Lmqq/util/WeakReference;", "getWd", "()Lmqq/util/WeakReference;", "wd", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class UpdateDrawableRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Drawable> wd;

        public UpdateDrawableRunnable(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable);
            } else {
                this.wd = new WeakReference<>(drawable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Drawable drawable = this.wd.get();
            if (drawable != null) {
                drawable.invalidateSelf();
            }
        }
    }

    public PngRenderingExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void c(PngRenderingExecutor pngRenderingExecutor, String str, Exception exc, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            exc = null;
        }
        pngRenderingExecutor.b(str, exc);
    }

    public final void a(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new UpdateDrawableRunnable(drawable));
        }
    }

    @JvmOverloads
    public final void b(@NotNull String s16, @Nullable Exception e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) s16, (Object) e16);
        } else {
            Intrinsics.checkNotNullParameter(s16, "s");
            Log.e("AvifSequence", s16, e16);
        }
    }

    public final void d(@NotNull String s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) s16);
        } else {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }

    public final void e(@Nullable Runnable runnable, long delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, runnable, Long.valueOf(delay));
        } else {
            ThreadManagerV2.executeDelay(runnable, 16, null, false, delay);
        }
    }

    public final void f(@Nullable Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        } else {
            ThreadManagerV2.removeJobFromThreadPool(runnable, 16);
        }
    }
}
