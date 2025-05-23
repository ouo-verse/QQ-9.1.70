package com.tencent.mobileqq.guild.widget.navigation.chatlist;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.ab;
import vp1.cf;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/GuildNavigationBarAnimationController;", "Landroidx/lifecycle/LifecycleObserver;", "", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "progress", "b", "Lvp1/cf;", "d", "Lvp1/cf;", "binding", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lvp1/ab;", "f", "Lvp1/ab;", "titleBinding", "Landroid/view/View;", h.F, "Landroid/view/View;", "a", "()Landroid/view/View;", "memberInfoView", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNavigationBarAnimationController implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cf binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab titleBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View memberInfoView;

    private final View a() {
        View view = this.memberInfoView;
        if (view != null) {
            return view;
        }
        if (this.titleBinding.f442147h.getParent() == null) {
            View findViewById = this.titleBinding.getRoot().findViewById(R.id.zxb);
            if (findViewById != null) {
                findViewById.setTranslationX(this.titleBinding.f442147h.getTranslationX());
                findViewById.setTranslationY(this.titleBinding.f442147h.getTranslationY());
                this.memberInfoView = findViewById;
            }
            return this.memberInfoView;
        }
        return null;
    }

    private final void c() {
        this.lifecycleOwner.getLifecycle().removeObserver(this);
    }

    public final void b(float progress) {
        float f16 = progress / 100;
        this.binding.e().setAlpha(f16);
        float width = (this.binding.e().getWidth() / 3) * (1 - f16);
        this.titleBinding.f442141b.setTranslationX(width);
        View a16 = a();
        if (a16 == null) {
            a16 = this.titleBinding.f442147h;
        }
        a16.setTranslationX(width);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        c();
    }
}
