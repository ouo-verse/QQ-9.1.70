package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/bt;", "", "", "a", "b", "c", "d", "e", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "expContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "expAnimImageView", "expAnimBkgImageView", "<init>", "(Landroid/widget/FrameLayout;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class bt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout expContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView expAnimImageView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ImageView expAnimBkgImageView;

    public bt(@NotNull FrameLayout expContainer) {
        Intrinsics.checkNotNullParameter(expContainer, "expContainer");
        this.expContainer = expContainer;
        a();
    }

    private final void a() {
        View findViewById = this.expContainer.findViewById(R.id.vgr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "expContainer.findViewByI\u2026click_exp_anim_image_bkg)");
        this.expAnimBkgImageView = (ImageView) findViewById;
        View findViewById2 = this.expContainer.findViewById(R.id.vgq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "expContainer.findViewByI\u2026een_click_exp_anim_image)");
        this.expAnimImageView = (ImageView) findViewById2;
    }

    public final void b() {
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("QFSFeedChildAdFullClickAnimController", "https://amsweb-cdn-gz-1258344696.file.myqcloud.com/PACD_PM/full_screen_click_mode/icon_full_screen_3.png");
        ImageView imageView = this.expAnimImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimImageView");
            imageView = null;
        }
        imageView.setImageDrawable(apngURLDrawable);
    }

    public final void c() {
        this.expContainer.setVisibility(8);
        ImageView imageView = this.expAnimImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimImageView");
            imageView = null;
        }
        imageView.setImageBitmap(null);
        ImageView imageView2 = this.expAnimBkgImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView2 = null;
        }
        imageView2.setAlpha(1.0f);
        ImageView imageView3 = this.expAnimBkgImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView3 = null;
        }
        imageView3.setImageBitmap(null);
    }

    public final void d() {
        this.expContainer.setVisibility(0);
    }

    public final void e() {
        this.expContainer.setVisibility(8);
    }
}
