package com.tencent.sqshow.zootopia.card.view.refresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.refresh.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import n74.bc;
import o84.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001\bB%\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\t\u00a2\u0006\u0004\bL\u0010MB\u0019\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010B\u001a\u00020;\u00a2\u0006\u0004\bL\u0010NJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0007H\u0016R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\u00020\u00148\u0006X\u0086D\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010.\u001a\u00020\u00148\u0006X\u0086D\u00a2\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00101R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00109R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010CR\u0016\u0010F\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010#\u00a8\u0006P"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/refresh/RefreshFootView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/qqcircle/immersive/refresh/b;", "", "c", "Lcom/tencent/biz/qqcircle/immersive/refresh/QFSPullRefreshLayout;", "qfsPullRefreshLayout", "", "a", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "b0", "B", "Landroid/view/View;", "getRefreshView", "U", "hasMoreData", BdhLogUtil.LogTag.Tag_Conn, "", "percent", "D", ReportConstant.COSTREPORT_PREFIX, "isAnimOut", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ln74/bc;", "d", "Ln74/bc;", "getBinding", "()Ln74/bc;", "setBinding", "(Ln74/bc;)V", "binding", "e", "I", "getNUM_0", "()I", "NUM_0", "f", UserInfo.SEX_FEMALE, "getNUM_0F", "()F", "NUM_0F", h.F, "getNUM_1F", "NUM_1F", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTvLoadText", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mLoadMoreImage", "mTvLoadingText", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "mDefaultLogoDrawable", "Lo84/a;", "E", "Lo84/a;", "b", "()Lo84/a;", "setRefreshViewStatusListener", "(Lo84/a;)V", "refreshViewStatusListener", "Z", "isStartAnim", "G", "mMeasureHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Lo84/a;)V", "H", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RefreshFootView extends FrameLayout implements b {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTvLoadingText;

    /* renamed from: D, reason: from kotlin metadata */
    private Drawable mDefaultLogoDrawable;

    /* renamed from: E, reason: from kotlin metadata */
    public a refreshViewStatusListener;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isStartAnim;

    /* renamed from: G, reason: from kotlin metadata */
    private int mMeasureHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bc binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int NUM_0;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float NUM_0F;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float NUM_1F;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvLoadText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mLoadMoreImage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshFootView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bc g16 = bc.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        this.NUM_1F = 1.0f;
    }

    private final void c() {
        bc bcVar = this.binding;
        this.mTvLoadText = bcVar.f418815d;
        this.mTvLoadingText = bcVar.f418816e;
        this.mLoadMoreImage = bcVar.f418813b;
        this.mDefaultLogoDrawable = getResources().getDrawable(R.drawable.nal);
        this.isStartAnim = false;
        setVisibility(8);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void A(float percent, boolean isAnimOut) {
        float coerceAtMost;
        float coerceAtLeast;
        if (this.mMeasureHeight == this.NUM_0) {
            return;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.NUM_1F, percent);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.NUM_0F, coerceAtMost);
        int i3 = (int) (coerceAtLeast * this.mMeasureHeight);
        if (!isAnimOut) {
            i3 = this.NUM_0;
        }
        float f16 = i3;
        if (f16 == getTranslationY()) {
            return;
        }
        setTranslationY(f16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public int B() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void C(QFSPullRefreshLayout qfsPullRefreshLayout, boolean hasMoreData) {
        QLog.d("RefreshFootView", 1, "onComplete  hasMoreData = " + hasMoreData);
        b().onComplete(true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void D(QFSPullRefreshLayout qfsPullRefreshLayout, float percent) {
        if (a(qfsPullRefreshLayout)) {
            return;
        }
        QLog.d("RefreshFootView", 1, "[onPull] load more to pull state.");
        b().c(true, percent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void U(QFSPullRefreshLayout qfsPullRefreshLayout) {
        if (a(qfsPullRefreshLayout)) {
            return;
        }
        ImageView imageView = this.mLoadMoreImage;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(this.mDefaultLogoDrawable);
        b().a(true);
    }

    public final a b() {
        a aVar = this.refreshViewStatusListener;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshViewStatusListener");
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public int b0() {
        return 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mMeasureHeight = getMeasuredHeight();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void s(QFSPullRefreshLayout qfsPullRefreshLayout) {
        if (a(qfsPullRefreshLayout)) {
            return;
        }
        ImageView imageView = this.mLoadMoreImage;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView = this.mTvLoadingText;
        if (textView != null) {
            textView.setText("\u52aa\u529b\u5237\u65b0\u4e2d");
        }
        TextView textView2 = this.mTvLoadingText;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.mTvLoadText;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        invalidate();
        b().b(true);
    }

    public final void setBinding(bc bcVar) {
        Intrinsics.checkNotNullParameter(bcVar, "<set-?>");
        this.binding = bcVar;
    }

    public final void setRefreshViewStatusListener(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.refreshViewStatusListener = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefreshFootView(Context context, a refreshViewStatusListener) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(refreshViewStatusListener, "refreshViewStatusListener");
        setRefreshViewStatusListener(refreshViewStatusListener);
        c();
    }

    private final boolean a(QFSPullRefreshLayout qfsPullRefreshLayout) {
        if (qfsPullRefreshLayout == null || qfsPullRefreshLayout.K()) {
            return false;
        }
        QLog.d("RefreshFootView", 1, "checkSetIsFinishStatus  has no more data");
        TextView textView = this.mTvLoadText;
        if (textView != null) {
            textView.setText("\u6ca1\u6709\u66f4\u591a\u5566");
        }
        TextView textView2 = this.mTvLoadText;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        ImageView imageView = this.mLoadMoreImage;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView3 = this.mTvLoadingText;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        invalidate();
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public View getRefreshView() {
        return this;
    }
}
