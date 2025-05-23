package com.tencent.mobileqq.aio.factory;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tencent.aio.api.refreshLoad.HeadFooterViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/b;", "Lcom/tencent/aio/api/refreshLoad/HeadFooterViewHolder;", "Landroid/view/View;", "b", "", "l", "i", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lmqq/util/WeakReference;", "Landroid/graphics/drawable/AnimationDrawable;", "d", "Lmqq/util/WeakReference;", "loadingDrawable", "", "type", "<init>", "(ILandroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
final class b extends HeadFooterViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<AnimationDrawable> loadingDrawable;

    public b(int i3, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) context);
        } else {
            this.context = context;
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.HeadFooterViewHolder
    @NotNull
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FrameLayout frameLayout = new FrameLayout(this.context);
        com.tencent.aio.base.tool.b bVar = com.tencent.aio.base.tool.b.f69219a;
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        FrameLayout.LayoutParams a16 = bVar.a(context, -1, 45);
        a16.gravity = 80;
        frameLayout.setLayoutParams(a16);
        ImageView imageView = new ImageView(this.context);
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), R.drawable.f160544jr);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        imageView.setImageDrawable(animationDrawable);
        this.loadingDrawable = new WeakReference<>(animationDrawable);
        FrameLayout.LayoutParams a17 = bVar.a(this.context, 24, 24);
        a17.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(imageView, a17);
        return frameLayout;
    }

    @Override // com.tencent.aio.api.refreshLoad.HeadFooterViewHolder
    public void i() {
        AnimationDrawable animationDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.i();
        WeakReference<AnimationDrawable> weakReference = this.loadingDrawable;
        if (weakReference != null && (animationDrawable = weakReference.get()) != null) {
            animationDrawable.stop();
        }
    }

    @Override // com.tencent.aio.api.refreshLoad.HeadFooterViewHolder
    public void l() {
        AnimationDrawable animationDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.l();
        WeakReference<AnimationDrawable> weakReference = this.loadingDrawable;
        if (weakReference != null && (animationDrawable = weakReference.get()) != null) {
            animationDrawable.start();
        }
    }
}
