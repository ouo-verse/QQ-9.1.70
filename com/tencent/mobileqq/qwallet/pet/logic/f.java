package com.tencent.mobileqq.qwallet.pet.logic;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.qwallet.pet.data.PetStateManager;
import com.tencent.mobileqq.qwallet.pet.data.i;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n \u0015*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/logic/f;", "", "Lcom/tencent/mobileqq/qwallet/pet/data/i;", "sceneInfo", "", "f", "", "isOffsetUp", "g", "d", "Landroid/view/View;", "a", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/graphics/drawable/ColorDrawable;", "b", "Landroid/graphics/drawable/ColorDrawable;", "colorBgDrawable", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "c", "Landroid/widget/ImageView;", "bgView", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "surfaceViewContainer", "", "e", "I", "offsetUpPx", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "backgroundObserver", "offsetUpObserver", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "fragment", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;Landroid/view/View;)V", h.F, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ColorDrawable colorBgDrawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ImageView bgView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout surfaceViewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int offsetUpPx;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<i> backgroundObserver;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> offsetUpObserver;

    public f(@NotNull QWalletPetFragment fragment, @NotNull View rootView) {
        ColorDrawable colorDrawable;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        if (QQTheme.isNowThemeIsNight()) {
            colorDrawable = new ColorDrawable(ResourcesCompat.getColor(fragment.getResource(), R.color.black, null));
        } else {
            colorDrawable = new ColorDrawable(ResourcesCompat.getColor(fragment.getResource(), R.color.f158017al3, null));
        }
        this.colorBgDrawable = colorDrawable;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f243008r);
        this.bgView = imageView;
        this.surfaceViewContainer = (FrameLayout) rootView.findViewById(R.id.f242808p);
        this.offsetUpPx = x.c(rootView.getContext(), 110.0f);
        Observer<i> observer = new Observer() { // from class: com.tencent.mobileqq.qwallet.pet.logic.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.c(f.this, (i) obj);
            }
        };
        this.backgroundObserver = observer;
        Observer<Boolean> observer2 = new Observer() { // from class: com.tencent.mobileqq.qwallet.pet.logic.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.e(f.this, (Boolean) obj);
            }
        };
        this.offsetUpObserver = observer2;
        imageView.setImageDrawable(colorDrawable);
        PetStateManager petStateManager = PetStateManager.f278740a;
        petStateManager.t().observe(fragment.getViewLifecycleOwner(), observer);
        petStateManager.w().observe(fragment.getViewLifecycleOwner(), observer2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(f this$0, i iVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(f this$0, Boolean isOffsetUp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isOffsetUp, "isOffsetUp");
        this$0.g(isOffsetUp.booleanValue());
    }

    private final void f(i sceneInfo) {
        URLDrawable drawable;
        Drawable drawable2 = this.bgView.getDrawable();
        if (drawable2 == null) {
            drawable2 = this.colorBgDrawable;
        }
        if (sceneInfo == null) {
            this.bgView.setImageDrawable(drawable2);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable2;
        obtain.mFailedDrawable = drawable2;
        if (sceneInfo.getDownloadDetail().e()) {
            drawable = URLDrawable.getFileDrawable(sceneInfo.getDownloadDetail().getDownloadedPath(), obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "{\n            URLDrawabl\u2026rawableOptions)\n        }");
        } else {
            drawable = URLDrawable.getDrawable(sceneInfo.getDownloadDetail().getDownloadUrl(), obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "{\n            URLDrawabl\u2026rawableOptions)\n        }");
        }
        this.bgView.setImageDrawable(drawable);
    }

    private final void g(boolean isOffsetUp) {
        int i3;
        if (isOffsetUp) {
            i3 = this.offsetUpPx;
        } else {
            i3 = 0;
        }
        this.bgView.setScrollY(i3);
        this.surfaceViewContainer.setScrollY(i3);
    }

    public final void d() {
        i value = PetStateManager.f278740a.t().getValue();
        if (value != null) {
            f(value);
        }
    }
}
