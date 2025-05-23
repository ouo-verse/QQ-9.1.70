package com.tencent.qqnt.avatar.impl.core;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010#\u001a\u00020\u001c\u0012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020$\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/avatar/impl/core/ViewBindTarget;", "Lcom/tencent/qqnt/avatar/impl/core/AbsAvatarLoader;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/qqnt/avatar/impl/core/a;", "Landroidx/lifecycle/LifecycleEventObserver;", "result", "", "l", "a", "", "toString", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", QCircleLpReportDc05507.KEY_CLEAR, "", "other", "", "equals", "", "hashCode", "Landroidx/lifecycle/Lifecycle;", "i", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "mViewHost", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "innerView", "Luv3/a;", DownloadInfo.spKey_Config, "<init>", "(Landroid/view/View;Luv3/a;Landroidx/lifecycle/Lifecycle;)V", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ViewBindTarget extends AbsAvatarLoader<Drawable> implements a, LifecycleEventObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lifecycle lifecycle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<View> mViewHost;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewBindTarget(@NotNull View innerView, @NotNull uv3.a<String, Drawable> config, @Nullable Lifecycle lifecycle) {
        super(config);
        Intrinsics.checkNotNullParameter(innerView, "innerView");
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, innerView, config, lifecycle);
            return;
        }
        this.lifecycle = lifecycle;
        this.mViewHost = new WeakReference<>(innerView);
        this.TAG = "ViewTargetImpl " + hashCode();
    }

    @Override // uv3.b
    public void a() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        WeakReference<View> weakReference = this.mViewHost;
        View view2 = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            clear();
            return;
        }
        WeakReference<View> weakReference2 = this.mViewHost;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        Intrinsics.checkNotNull(view2);
        Object tag = view2.getTag(R.id.zva);
        if ((tag instanceof ViewBindTarget) && !tag.equals(this)) {
            ((ViewBindTarget) tag).clear();
        }
        view2.setTag(R.id.zva, this);
    }

    @Override // com.tencent.qqnt.avatar.impl.core.a
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        vv3.a.a(this.TAG, "recycle--- " + this);
        h();
        WeakReference<View> weakReference = this.mViewHost;
        if (weakReference != null) {
            weakReference.clear();
        }
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
        k().f(null);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(ViewBindTarget.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.qqnt.avatar.impl.core.ViewBindTarget");
        if (Intrinsics.areEqual(this.mViewHost, ((ViewBindTarget) other).mViewHost)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int hashCode = j().hashCode() * 31;
        WeakReference<View> weakReference = this.mViewHost;
        if (weakReference != null) {
            i3 = weakReference.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    @Override // uv3.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull Drawable result) {
        View view;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        WeakReference<View> weakReference = this.mViewHost;
        View view3 = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view instanceof ImageView) {
            WeakReference<View> weakReference2 = this.mViewHost;
            if (weakReference2 != null) {
                view3 = weakReference2.get();
            }
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) view3).setImageDrawable(result);
            return;
        }
        WeakReference<View> weakReference3 = this.mViewHost;
        if (weakReference3 != null) {
            view2 = weakReference3.get();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            WeakReference<View> weakReference4 = this.mViewHost;
            if (weakReference4 != null) {
                view3 = weakReference4.get();
            }
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.view.View");
            view3.setBackground(result);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) source, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            clear();
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ViewLoadImpl(mViewHost=" + this.mViewHost + ")";
    }
}
