package com.tencent.sqshow.zootopia.avatar.loading.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import d84.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/anim/ZPlanLoadingAnimView;", "Landroid/widget/FrameLayout;", "", "d", "c", "e", "f", "Ld84/c;", "Ld84/c;", "mAnimHelper", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mOuterImageView", "mInnerImageView", "Landroid/animation/ValueAnimator;", h.F, "Landroid/animation/ValueAnimator;", "mInnerAnim", "Lcom/tencent/image/URLDrawable;", "i", "Lcom/tencent/image/URLDrawable;", "mOuterApngDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanLoadingAnimView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c mAnimHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView mOuterImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView mInnerImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mInnerAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private URLDrawable mOuterApngDrawable;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/avatar/loading/anim/ZPlanLoadingAnimView$b", "Ld84/c$a;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements c.a {
        b() {
        }

        @Override // d84.c.a
        public void a(URLDrawable drawable) {
            QLog.i("ZPlanLoadingAnimView_", 1, "loadFinish drawable:" + drawable);
            ZPlanLoadingAnimView.this.mOuterApngDrawable = drawable;
            ZPlanLoadingAnimView.this.mOuterImageView.setImageDrawable(drawable);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingAnimView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void d() {
        QLog.i("ZPlanLoadingAnimView_", 1, "begin getApngDrawable");
        this.mAnimHelper.c(new b());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mInnerImageView, BasicAnimation.KeyPath.ROTATION, 0.0f, -359.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(5000L);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        this.mInnerAnim = ofFloat;
    }

    public final void c() {
        ValueAnimator valueAnimator = this.mInnerAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void e() {
        ValueAnimator valueAnimator = this.mInnerAnim;
        URLDrawable uRLDrawable = this.mOuterApngDrawable;
        QLog.i("ZPlanLoadingAnimView_", 1, "pauseAnim mInnerAnim:" + valueAnimator + ", currDrawable:" + (uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null));
        ValueAnimator valueAnimator2 = this.mInnerAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.pause();
        }
        URLDrawable uRLDrawable2 = this.mOuterApngDrawable;
        Object currDrawable = uRLDrawable2 != null ? uRLDrawable2.getCurrDrawable() : null;
        ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
        if (apngDrawable != null) {
            apngDrawable.pause();
        }
    }

    public final void f() {
        ValueAnimator valueAnimator = this.mInnerAnim;
        URLDrawable uRLDrawable = this.mOuterApngDrawable;
        QLog.i("ZPlanLoadingAnimView_", 1, "resumeAnim mInnerAnim:" + valueAnimator + ", currDrawable:" + (uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null));
        ValueAnimator valueAnimator2 = this.mInnerAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.resume();
        }
        URLDrawable uRLDrawable2 = this.mOuterApngDrawable;
        Object currDrawable = uRLDrawable2 != null ? uRLDrawable2.getCurrDrawable() : null;
        ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
        if (apngDrawable != null) {
            apngDrawable.resume();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanLoadingAnimView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingAnimView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnimHelper = new c(context);
        LayoutInflater.from(context).inflate(R.layout.dd6, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.qat);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.outerIgv)");
        this.mOuterImageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f163424q21);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.innerIgv)");
        this.mInnerImageView = (ImageView) findViewById2;
        d();
    }
}
