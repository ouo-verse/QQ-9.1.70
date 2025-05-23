package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QCircleRecommendBaseAdapter extends RecyclerView.Adapter {
    protected FeedCloudMeta$StFeed C;
    protected int D;
    protected RecyclerView E;
    protected QCircleBaseWidgetView F;
    protected QQCircleDitto$StItemContainer G;

    /* renamed from: m, reason: collision with root package name */
    protected List<QQCircleDitto$StItemInfo> f82588m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder implements com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {
        protected Object E;
        protected int F;
        protected int G;
        protected FeedCloudMeta$StFeed H;
        protected int I;
        protected QCircleRecommendBaseAdapter J;
        protected int K;
        protected QCircleReportBean L;

        public a(View view) {
            super(view);
        }

        public QQCircleDitto$StItemInfo l() {
            return (QQCircleDitto$StItemInfo) this.E;
        }

        public int m() {
            return this.F;
        }

        @Override // com.tencent.biz.qqcircle.richframework.part.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public QCircleReportBean getReportBean() {
            return this.L;
        }

        public void p(QCircleRecommendBaseAdapter qCircleRecommendBaseAdapter) {
            this.J = qCircleRecommendBaseAdapter;
        }

        public void q(Object obj, int i3, int i16) {
            this.E = obj;
            this.F = i3;
            this.G = i16;
        }

        public void r(int i3) {
            this.K = i3;
        }

        public void s(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.H = feedCloudMeta$StFeed;
        }

        public void t(int i3) {
            this.I = i3;
        }

        public void u(QCircleReportBean qCircleReportBean) {
            this.L = qCircleReportBean;
        }
    }

    private int i0(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(new Point());
        int[] iArr = new int[2];
        ((Activity) context).getWindow().getDecorView().getLocationOnScreen(iArr);
        return iArr[0];
    }

    private void n0(int i3) {
        int i16;
        QLog.i("QCircleRecommendBaseAdapter", 1, "scrollToScreenLeft removeIndex : " + i3);
        RecyclerView recyclerView = this.E;
        if (recyclerView != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            View findViewByPosition = ((LinearLayoutManager) this.E.getLayoutManager()).findViewByPosition(i3);
            if (findViewByPosition == null) {
                QLog.i("QCircleRecommendBaseAdapter", 1, "scrollToScreenLeft findViewByPosition  view == null");
                return;
            }
            int[] iArr = new int[2];
            findViewByPosition.getLocationOnScreen(iArr);
            if (bz.l() && TransitionHelper.isFolderScreenOpenMode(findViewByPosition.getContext())) {
                i16 = i0(findViewByPosition.getContext());
            } else {
                i16 = 0;
            }
            final int i17 = iArr[0] - i16;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) findViewByPosition.getLayoutParams();
            int width = findViewByPosition.getWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            QLog.i("QCircleRecommendBaseAdapter", 1, "scrollToScreenLeft locationX = " + iArr[0] + "  , viewWidth = " + width + ", currentScreenLocationX = " + i17);
            if (i17 < width) {
                return;
            }
            this.E.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    QCircleRecommendBaseAdapter.this.E.smoothScrollBy(i17, 0);
                }
            }, 370L);
            return;
        }
        QLog.i("QCircleRecommendBaseAdapter", 1, "scrollToScreenLeft mRecycleView or LinearLayoutManager == null");
    }

    public boolean j0() {
        return false;
    }

    protected void k0(int i3) {
        if (this.C != null && this.G != null) {
            FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed = new FeedCloudMeta$StDittoFeed();
            feedCloudMeta$StDittoFeed.dittoId.set(i3);
            this.G.items.set(this.f82588m);
            feedCloudMeta$StDittoFeed.dittoData.set(ByteStringMicro.copyFrom(QCirclePluginUtil.deepCopyContainer(this.G).toByteArray()));
            this.C.dittoFeed.set(feedCloudMeta$StDittoFeed);
        }
    }

    public void l0(Object obj, int i3) {
        if (obj instanceof QQCircleDitto$StItemInfo) {
            String str = ((QQCircleDitto$StItemInfo) obj).f429300id.get();
            int i16 = 0;
            while (true) {
                if (i16 < this.f82588m.size()) {
                    QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.f82588m.get(i16);
                    if ((qQCircleDitto$StItemInfo instanceof QQCircleDitto$StItemInfo) && qQCircleDitto$StItemInfo.f429300id.get().equals(str)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 >= 0) {
                if (i3 == 1) {
                    n0(i16);
                }
                this.f82588m.remove(i16);
                QLog.d("QCircleTagPageRecommendWidget", 1, "remove data is " + i16);
                notifyItemRemoved(i16);
                k0(i3);
                if (this.f82588m.size() <= 0 && !j0()) {
                    this.F.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m0() {
        RecyclerView recyclerView = this.E;
        if (recyclerView == null) {
            QLog.d("QCircleRecommendBaseAdapter", 1, "[safeNotify] recycle view should not be null.");
        } else if (recyclerView.isComputingLayout()) {
            this.E.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleRecommendBaseAdapter.this.notifyDataSetChanged();
                }
            }, 500L);
        } else {
            notifyDataSetChanged();
        }
    }

    public void o0(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        this.G = qQCircleDitto$StItemContainer;
    }

    public void p0(RecyclerView recyclerView) {
        this.E = recyclerView;
    }

    public void q0(QCircleBaseWidgetView qCircleBaseWidgetView) {
        this.F = qCircleBaseWidgetView;
    }
}
