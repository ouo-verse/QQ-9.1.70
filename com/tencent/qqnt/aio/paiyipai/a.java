package com.tencent.qqnt.aio.paiyipai;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R(\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/paiyipai/a;", "Landroid/view/GestureDetector;", "Landroid/view/View;", "a", "Landroid/view/View;", "mView", "view", "()Landroid/view/View;", "b", "(Landroid/view/View;)V", "Landroid/content/Context;", "context", "Landroid/view/GestureDetector$OnGestureListener;", "listener", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends GestureDetector {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mView;

    public a(@Nullable Context context, @Nullable GestureDetector.OnGestureListener onGestureListener, @Nullable Handler handler) {
        super(context, onGestureListener, handler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, onGestureListener, handler);
        }
    }

    @Nullable
    public final View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mView;
    }

    public final void b(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            this.mView = view;
        }
    }
}
