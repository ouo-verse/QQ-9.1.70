package com.tencent.sqshow.zootopia.card.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.immersive.refresh.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n74.bd;
import o84.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001\u0019B%\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u00a2\u0006\u0004\b+\u0010,B\u0019\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u00a2\u0006\u0004\b+\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\rH\u0016R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/refresh/RefreshHeaderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/qqcircle/immersive/refresh/b;", "", "b", "", "b0", "B", "Landroid/view/View;", "getRefreshView", "Lcom/tencent/biz/qqcircle/immersive/refresh/QFSPullRefreshLayout;", "qfsPullRefreshLayout", "U", "", "hasMoreData", BdhLogUtil.LogTag.Tag_Conn, "", "percent", "D", ReportConstant.COSTREPORT_PREFIX, "isAnimOut", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lo84/a;", "d", "Lo84/a;", "a", "()Lo84/a;", "setRefreshViewStatusListener", "(Lo84/a;)V", "refreshViewStatusListener", "Ln74/bd;", "e", "Ln74/bd;", "getBinding", "()Ln74/bd;", "setBinding", "(Ln74/bd;)V", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Lo84/a;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RefreshHeaderView extends FrameLayout implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public a refreshViewStatusListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private bd binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshHeaderView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        bd g16 = bd.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }

    private final void b() {
        this.binding.f418820d.setNeedNightStyle(true);
        this.binding.f418820d.j();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public int B() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void U(QFSPullRefreshLayout qfsPullRefreshLayout) {
        this.binding.f418819c.setText("\u5237\u65b0\u4e2d");
        this.binding.f418820d.k();
        invalidate();
        a().a(false);
        QLog.d("RefreshHeaderView", 1, "onStart");
    }

    public final a a() {
        a aVar = this.refreshViewStatusListener;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refreshViewStatusListener");
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void s(QFSPullRefreshLayout qfsPullRefreshLayout) {
        this.binding.f418819c.setText("\u52aa\u529b\u5237\u65b0\u4e2d");
        this.binding.f418820d.setVisibility(0);
        invalidate();
        a().b(false);
        QLog.d("RefreshHeaderView", 1, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
    }

    public final void setBinding(bd bdVar) {
        Intrinsics.checkNotNullParameter(bdVar, "<set-?>");
        this.binding = bdVar;
    }

    public final void setRefreshViewStatusListener(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.refreshViewStatusListener = aVar;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void C(QFSPullRefreshLayout qfsPullRefreshLayout, boolean hasMoreData) {
        QLog.d("RefreshHeaderView", 1, "onComplete");
        this.binding.f418819c.setVisibility(8);
        this.binding.f418820d.l();
        this.binding.f418820d.setVisibility(8);
        invalidate();
        a().onComplete(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RefreshHeaderView(Context context, a refreshViewStatusListener) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(refreshViewStatusListener, "refreshViewStatusListener");
        setRefreshViewStatusListener(refreshViewStatusListener);
        b();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public int b0() {
        return ViewUtils.dip2px(48.0f);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void D(QFSPullRefreshLayout qfsPullRefreshLayout, float percent) {
        if (percent >= 1.0f) {
            this.binding.f418819c.setText("\u91ca\u653e\u5237\u65b0");
        } else {
            this.binding.f418819c.setText("\u5237\u65b0\u4e2d");
        }
        if (percent < 0.5d) {
            setVisibility(8);
        } else {
            this.binding.f418819c.setAlpha((percent - 0.5f) * 2);
            setVisibility(0);
            this.binding.f418819c.setVisibility(0);
            this.binding.f418820d.setVisibility(0);
        }
        invalidate();
        a().c(false, percent);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void A(float percent, boolean isAnimOut) {
    }
}
