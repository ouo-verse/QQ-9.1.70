package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.widget.p;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001?B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0006\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J0\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0012\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'J\u0006\u0010*\u001a\u00020\u0003R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0016\u00104\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00103R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010+R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010+\u00a8\u0006@"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/widget/p;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "pullType", "setPullType", "", "lastTime", "i", "d", tl.h.F, RemoteProxy.KEY_RESULT_TYPE, "l", "", "tip", "c", "Landroid/view/View;", "b", "g", "k", "clrPull", "clrRelease", "clrUpdate", "clrResult", "clrTime", "setTextColor", "resId", "setHeaderBgRes", "clrBg", "setHeaderBgColor", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "setHeaderBgDrawable", "", "progress", "setLottieProgress", "", "needNight", "setHeaderNightStyle", DomainData.DOMAIN_NAME, "I", "mPullType", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaRefreshView;", "e", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaRefreshView;", "mRefreshView", "f", "mState", "Z", "mIsRefreshing", "mStartLottieScrollY", "mRefreshMinScrollY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaPullRefreshHeader extends FrameLayout implements p {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mPullType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaRefreshView mRefreshView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRefreshing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mStartLottieScrollY;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mRefreshMinScrollY;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaPullRefreshHeader(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void m() {
        this.mRefreshView = (ZootopiaRefreshView) LayoutInflater.from(getContext()).inflate(R.layout.d8f, (ViewGroup) this, true).findViewById(R.id.r1g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZootopiaPullRefreshHeader this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ZootopiaRefreshView zootopiaRefreshView = this$0.mRefreshView;
        if (zootopiaRefreshView != null) {
            zootopiaRefreshView.setScaleY(floatValue);
        }
        ZootopiaRefreshView zootopiaRefreshView2 = this$0.mRefreshView;
        if (zootopiaRefreshView2 == null) {
            return;
        }
        zootopiaRefreshView2.setScaleX(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ZootopiaPullRefreshHeader this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaRefreshView zootopiaRefreshView = this$0.mRefreshView;
        if (zootopiaRefreshView != null) {
            zootopiaRefreshView.setVisibility(4);
        }
        ZootopiaRefreshView zootopiaRefreshView2 = this$0.mRefreshView;
        if (zootopiaRefreshView2 != null) {
            zootopiaRefreshView2.setProgress(0.0f);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void h(long lastTime) {
        ZootopiaRefreshView zootopiaRefreshView;
        QLog.e("ZootopiaPullRefreshHeader", 1, "showUpdateMessage");
        this.mIsRefreshing = true;
        ZootopiaRefreshView zootopiaRefreshView2 = this.mRefreshView;
        if (!(zootopiaRefreshView2 != null && zootopiaRefreshView2.getVisibility() == 0) && (zootopiaRefreshView = this.mRefreshView) != null) {
            zootopiaRefreshView.setVisibility(0);
            zootopiaRefreshView.setScaleX(1.0f);
            zootopiaRefreshView.setScaleY(1.0f);
        }
        ZootopiaRefreshView zootopiaRefreshView3 = this.mRefreshView;
        if (zootopiaRefreshView3 != null) {
            zootopiaRefreshView3.k();
        }
        this.mState = 3;
    }

    @Override // com.tencent.mobileqq.widget.p
    public long k() {
        return 500L;
    }

    public final void n() {
        ZootopiaRefreshView zootopiaRefreshView = this.mRefreshView;
        if (zootopiaRefreshView != null) {
            zootopiaRefreshView.j();
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgColor(int clrBg) {
        setBackgroundColor(clrBg);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgDrawable(Drawable bgDrawable) {
        setBackground(bgDrawable);
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setHeaderBgRes(int resId) {
        setBackgroundResource(resId);
    }

    public final void setHeaderNightStyle(boolean needNight) {
        ZootopiaRefreshView zootopiaRefreshView = this.mRefreshView;
        if (zootopiaRefreshView == null) {
            return;
        }
        zootopiaRefreshView.setNeedNightStyle(needNight);
    }

    public final void setLottieProgress(float progress) {
        float f16 = ((progress - this.mStartLottieScrollY) / (this.mRefreshMinScrollY - r0)) / 2.0f;
        ZootopiaRefreshView zootopiaRefreshView = this.mRefreshView;
        if (zootopiaRefreshView != null) {
            zootopiaRefreshView.setVisibility(f16 >= 0.0f ? 0 : 4);
        }
        if (f16 < 0.0f) {
            return;
        }
        if (f16 > 0.5f) {
            f16 = 0.5f;
        }
        float f17 = ((6 * f16) / 5) + 0.4f;
        ZootopiaRefreshView zootopiaRefreshView2 = this.mRefreshView;
        if (zootopiaRefreshView2 != null) {
            zootopiaRefreshView2.setProgress(f16);
        }
        ZootopiaRefreshView zootopiaRefreshView3 = this.mRefreshView;
        if (zootopiaRefreshView3 != null) {
            zootopiaRefreshView3.setScaleY(f17);
        }
        ZootopiaRefreshView zootopiaRefreshView4 = this.mRefreshView;
        if (zootopiaRefreshView4 != null) {
            zootopiaRefreshView4.setScaleX(f17);
        }
        this.mState = 1;
    }

    public void setPullType(int pullType) {
        if (this.mPullType != pullType) {
            this.mPullType = pullType;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaPullRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void o() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZootopiaPullRefreshHeader.p(ZootopiaPullRefreshHeader.this, valueAnimator);
            }
        });
        ofFloat.start();
        postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.d
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaPullRefreshHeader.q(ZootopiaPullRefreshHeader.this);
            }
        }, 100L);
        this.mState = 2;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void c(int resultType, String tip) {
        QLog.e("ZootopiaPullRefreshHeader", 1, "showResult");
        o();
        ZootopiaRefreshView zootopiaRefreshView = this.mRefreshView;
        if (zootopiaRefreshView != null) {
            zootopiaRefreshView.m(null);
        }
    }

    @Override // com.tencent.mobileqq.widget.p
    public void l(int resultType) {
        QLog.e("ZootopiaPullRefreshHeader", 1, "showResult");
        o();
        ZootopiaRefreshView zootopiaRefreshView = this.mRefreshView;
        if (zootopiaRefreshView != null) {
            zootopiaRefreshView.m(null);
        }
    }

    public /* synthetic */ ZootopiaPullRefreshHeader(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaPullRefreshHeader(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        m();
        this.mStartLottieScrollY = ViewUtils.dpToPx(26.0f);
        this.mRefreshMinScrollY = ViewUtils.dpToPx(60.0f);
    }

    @Override // com.tencent.mobileqq.widget.p
    public View b() {
        return this;
    }

    @Override // com.tencent.mobileqq.widget.p
    public void g() {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void d(long lastTime) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void i(long lastTime) {
    }

    @Override // com.tencent.mobileqq.widget.p
    public void setTextColor(int clrPull, int clrRelease, int clrUpdate, int clrResult, int clrTime) {
    }
}
