package com.tencent.now.linkpkanchorplay.guide;

import an3.a;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/guide/VideoCutGuidePage;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "landscape", "", "z0", "d", "Z", "getLandscape", "()Z", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "bgImageView", "Landroid/content/Context;", "context", "<init>", "(ZLandroid/content/Context;)V", "f", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class VideoCutGuidePage extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean landscape;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView bgImageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCutGuidePage(boolean z16, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.landscape = z16;
        if (z16) {
            View.inflate(context, R.layout.h_w, this);
        } else {
            View.inflate(context, R.layout.h_x, this);
        }
        View findViewById = findViewById(R.id.f1173771_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_cut_image)");
        this.bgImageView = (ImageView) findViewById;
        z0(z16);
    }

    private final void z0(boolean landscape) {
        View findViewById = findViewById(R.id.f1173771_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.video_cut_image)");
        ImageView imageView = (ImageView) findViewById;
        this.bgImageView = imageView;
        if (landscape) {
            c.b(imageView, a.INSTANCE.c());
        } else {
            c.b(imageView, a.INSTANCE.d());
        }
    }
}
