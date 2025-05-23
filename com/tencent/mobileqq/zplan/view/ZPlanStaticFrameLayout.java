package com.tencent.mobileqq.zplan.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/ZPlanStaticFrameLayout;", "Lcom/tencent/mobileqq/zplan/view/AbsZPlanStaticFrameLayout;", "Landroid/widget/ImageView;", "a", "Landroid/widget/FrameLayout;", "b", "d", "Landroid/widget/ImageView;", "avatarIv", "e", "Landroid/widget/FrameLayout;", "backgroundContainer", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanStaticFrameLayout extends AbsZPlanStaticFrameLayout {

    /* renamed from: h, reason: collision with root package name */
    private static final int f335920h = ImmersiveUtils.getScreenHeight() / 2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ImageView avatarIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final FrameLayout backgroundContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanStaticFrameLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, f335920h));
        frameLayout.setBackground(new ColorDrawable(-1));
        this.backgroundContainer = frameLayout;
        addView(frameLayout);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.avatarIv = imageView;
        addView(imageView);
    }

    @Override // com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout
    /* renamed from: a, reason: from getter */
    public ImageView getAvatarIv() {
        return this.avatarIv;
    }

    @Override // com.tencent.mobileqq.zplan.view.AbsZPlanStaticFrameLayout
    /* renamed from: b, reason: from getter */
    public FrameLayout getBackgroundContainer() {
        return this.backgroundContainer;
    }
}
