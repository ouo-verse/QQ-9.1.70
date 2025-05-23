package com.qzone.reborn.albumx.qzone.widgetview;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzone.base.view.QZoneAlbumxLoadingProgressView;
import com.qzone.reborn.albumx.qzone.widgetview.QZoneAlbumxLoadingPercentProgressView;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import ie0.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import xe.b;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b(\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/widgetview/QZoneAlbumxLoadingPercentProgressView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "Landroid/graphics/drawable/LayerDrawable;", "p0", "", "q0", "", "scale", "setDurationScale", "n0", "release", "", "getLayoutId", "objData", c.G, "bindData", "Lcom/qzone/reborn/albumx/qzone/base/view/QZoneAlbumxLoadingProgressView;", "e", "Lcom/qzone/reborn/albumx/qzone/base/view/QZoneAlbumxLoadingProgressView;", "mLoadingView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mPercentTv", h.F, "mPercentTokenTv", "Landroid/animation/AnimatorSet;", "i", "Landroid/animation/AnimatorSet;", "mAnimatorSet", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mHasStartAnim", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "durationScale", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumxLoadingPercentProgressView extends QZoneBaseWidgetView<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private float durationScale;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QZoneAlbumxLoadingProgressView mLoadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView mPercentTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final TextView mPercentTokenTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AnimatorSet mAnimatorSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mHasStartAnim;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLoadingPercentProgressView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mok);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_albumx_loading_pv)");
        QZoneAlbumxLoadingProgressView qZoneAlbumxLoadingProgressView = (QZoneAlbumxLoadingProgressView) findViewById;
        this.mLoadingView = qZoneAlbumxLoadingProgressView;
        View findViewById2 = findViewById(R.id.mpt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_albumx_percent_tv)");
        TextView textView = (TextView) findViewById2;
        this.mPercentTv = textView;
        View findViewById3 = findViewById(R.id.mps);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_albumx_percent_token_tv)");
        TextView textView2 = (TextView) findViewById3;
        this.mPercentTokenTv = textView2;
        qZoneAlbumxLoadingProgressView.setBackground(p0());
        i.f(textView);
        i.f(textView2);
        this.durationScale = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(QZoneAlbumxLoadingPercentProgressView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((valueAnimator != null ? valueAnimator.getAnimatedValue() : null) instanceof Float) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            this$0.mLoadingView.setProgress(floatValue);
            this$0.mPercentTv.setText(String.valueOf((int) floatValue));
        }
    }

    private final LayerDrawable p0() {
        int i3 = QQTheme.isNowThemeIsNightForQzone() ? 1002 : 1001;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.f14207c));
        bitmapDrawable.setTint(a.f().g(getContext(), R.color.qui_common_bg_bottom_light, i3));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(a.f().g(getContext(), R.color.qui_common_bg_bottom_standard, i3));
        gradientDrawable.setCornerRadius(ar.e(139.0f));
        Unit unit = Unit.INSTANCE;
        return new LayerDrawable(new Drawable[]{gradientDrawable, bitmapDrawable});
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128944q;
    }

    public final void n0() {
        if (this.mHasStartAnim) {
            return;
        }
        this.mHasStartAnim = true;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ra.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QZoneAlbumxLoadingPercentProgressView.o0(QZoneAlbumxLoadingPercentProgressView.this, valueAnimator);
            }
        };
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 70.0f).setDuration(((float) 6000) * this.durationScale);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(animatorUpdateListener);
        ValueAnimator duration2 = ValueAnimator.ofFloat(70.0f, 90.0f).setDuration(((float) 5000) * this.durationScale);
        duration2.setInterpolator(new LinearInterpolator());
        duration2.addUpdateListener(animatorUpdateListener);
        ValueAnimator duration3 = ValueAnimator.ofFloat(90.0f, 99.0f).setDuration(((float) 10000) * this.durationScale);
        duration3.setInterpolator(new LinearInterpolator());
        duration3.addUpdateListener(animatorUpdateListener);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        animatorSet.playSequentially(duration, duration2, duration3);
        AnimatorSet animatorSet2 = this.mAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public final void q0() {
        try {
            n0();
        } catch (Throwable th5) {
            b.f447841a.d(th5);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        try {
            AnimatorSet animatorSet = this.mAnimatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Throwable th5) {
            b.f447841a.d(th5);
        }
    }

    public final void setDurationScale(float scale) {
        this.durationScale = scale;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumxLoadingPercentProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View findViewById = findViewById(R.id.mok);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qzone_albumx_loading_pv)");
        QZoneAlbumxLoadingProgressView qZoneAlbumxLoadingProgressView = (QZoneAlbumxLoadingProgressView) findViewById;
        this.mLoadingView = qZoneAlbumxLoadingProgressView;
        View findViewById2 = findViewById(R.id.mpt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qzone_albumx_percent_tv)");
        TextView textView = (TextView) findViewById2;
        this.mPercentTv = textView;
        View findViewById3 = findViewById(R.id.mps);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qzone_albumx_percent_token_tv)");
        TextView textView2 = (TextView) findViewById3;
        this.mPercentTokenTv = textView2;
        qZoneAlbumxLoadingProgressView.setBackground(p0());
        i.f(textView);
        i.f(textView2);
        this.durationScale = 1.0f;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
    }
}
