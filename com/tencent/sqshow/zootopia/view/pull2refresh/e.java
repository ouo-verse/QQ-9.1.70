package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.widget.p;
import com.tencent.widget.pull2refresh.anim.DefaultAnimManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/e;", "Lcom/tencent/widget/pull2refresh/anim/DefaultAnimManager;", "Landroid/view/ViewGroup;", "root", "Landroid/view/View;", "getRefreshView", "", Element.ELEMENT_NAME_DISTANCE, "touchMode", "", "onTouchPullDistance", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager$OnRefreshPullDistanceListener;", "listener", "setRefreshPullDistanceListener", "resId", "b", "", "needNight", "c", "a", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager$OnRefreshPullDistanceListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends DefaultAnimManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IAnimManager.OnRefreshPullDistanceListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        p pVar = this.mTopRefresh;
        ZootopiaPullRefreshHeader zootopiaPullRefreshHeader = pVar instanceof ZootopiaPullRefreshHeader ? (ZootopiaPullRefreshHeader) pVar : null;
        if (zootopiaPullRefreshHeader != null) {
            zootopiaPullRefreshHeader.n();
        }
    }

    public final void b(int resId) {
        p pVar = this.mTopRefresh;
        ZootopiaPullRefreshHeader zootopiaPullRefreshHeader = pVar instanceof ZootopiaPullRefreshHeader ? (ZootopiaPullRefreshHeader) pVar : null;
        if (zootopiaPullRefreshHeader != null) {
            zootopiaPullRefreshHeader.setBackgroundResource(resId);
        }
    }

    public final void c(boolean needNight) {
        p pVar = this.mTopRefresh;
        ZootopiaPullRefreshHeader zootopiaPullRefreshHeader = pVar instanceof ZootopiaPullRefreshHeader ? (ZootopiaPullRefreshHeader) pVar : null;
        if (zootopiaPullRefreshHeader != null) {
            zootopiaPullRefreshHeader.setHeaderNightStyle(needNight);
        }
    }

    @Override // com.tencent.widget.pull2refresh.anim.DefaultAnimManager, com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public View getRefreshView(ViewGroup root) {
        if (this.mTopRefresh == null) {
            Context mContext = this.mContext;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            this.mTopRefresh = new ZootopiaPullRefreshHeader(mContext, null, 0, 6, null);
        }
        Object obj = this.mTopRefresh;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
        return (View) obj;
    }

    @Override // com.tencent.widget.pull2refresh.anim.DefaultAnimManager, com.tencent.widget.pull2refresh.anim.IPullRefreshAnim
    public void onTouchPullDistance(int distance, int touchMode) {
        super.onTouchPullDistance(distance, touchMode);
        IAnimManager.OnRefreshPullDistanceListener onRefreshPullDistanceListener = this.listener;
        if (onRefreshPullDistanceListener != null) {
            onRefreshPullDistanceListener.onPullDistance(distance, touchMode);
        }
        p pVar = this.mTopRefresh;
        Intrinsics.checkNotNull(pVar, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshHeader");
        ((ZootopiaPullRefreshHeader) pVar).setLottieProgress(Math.abs(distance));
    }

    @Override // com.tencent.widget.pull2refresh.anim.DefaultAnimManager, com.tencent.widget.pull2refresh.anim.IAnimManager
    public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener listener) {
        this.listener = listener;
    }
}
