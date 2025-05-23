package com.tencent.biz.qqcircle.widgets.pymk;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.utils.ab;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qc0.e;
import qc0.j;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends QCircleRecommendBaseAdapter implements SimpleEventReceiver {
    private int H;
    private ua0.a I;
    private QCircleFeedReportScroller J;
    private QCircleReportBean K;
    protected boolean L = false;
    protected boolean M = false;
    private int N = 0;
    private RecyclerView P;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.widgets.pymk.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0939a {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.left = cx.a(12.5f);
            rect.right = cx.a(12.5f);
        }
    }

    private void D0(QCircleAddblackUpdateEvent qCircleAddblackUpdateEvent) {
        if (qCircleAddblackUpdateEvent.blackstate == 1) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 4, "add black event receive");
            QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = new QQCircleDitto$StItemInfo();
            qQCircleDitto$StItemInfo.f429300id.set(qCircleAddblackUpdateEvent.mUserId);
            l0(qQCircleDitto$StItemInfo, 1);
        }
    }

    private void E0() {
        RecyclerView.LayoutManager layoutManager;
        Object tag;
        RecyclerView recyclerView = this.P;
        if (recyclerView == null) {
            layoutManager = null;
        } else {
            layoutManager = recyclerView.getLayoutManager();
        }
        if (!(layoutManager instanceof LinearLayoutManager)) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateVisibleItePageId] update visible item page id fail, not equals linear layout manager.");
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition < findLastVisibleItemPosition + 1; findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition == null) {
                tag = null;
            } else {
                tag = findViewByPosition.getTag();
            }
            if (tag instanceof qc0.a) {
                K0((qc0.a) tag);
            }
        }
    }

    private void F0() {
        if (this.E == null) {
            return;
        }
        if (this.I == null) {
            this.I = new ua0.a();
        }
        this.I.p(this.E);
        I0();
    }

    private void H0() {
        if (this.I == null) {
            ua0.a aVar = new ua0.a();
            this.I = aVar;
            aVar.p(this.E);
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateCardReportHelperValue] new create a report helper.");
        }
        QCircleFeedReportScroller qCircleFeedReportScroller = this.J;
        if (qCircleFeedReportScroller != null) {
            qCircleFeedReportScroller.F(this.I);
        }
        this.I.d(this.C, this.D);
        int i3 = this.N;
        if (i3 != -1) {
            this.I.o(i3);
        }
    }

    private void I0() {
        ua0.a aVar;
        QCircleFeedReportScroller qCircleFeedReportScroller = this.J;
        if (qCircleFeedReportScroller == null || (aVar = this.I) == null) {
            return;
        }
        qCircleFeedReportScroller.F(aVar);
    }

    private void J0(int i3, QCircleRecommendBaseAdapter.a aVar) {
        List<QQCircleDitto$StItemInfo> list = this.f82588m;
        if (list == null) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateItemViewMargin] data == null.");
        } else if (i3 > 0 && i3 == list.size() - 1) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) aVar.itemView.getLayoutParams();
            aVar.itemView.setLayoutParams(layoutParams);
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = 0;
        }
    }

    private void K0(QCircleRecommendBaseAdapter.a aVar) {
        int i3 = this.N;
        if (i3 == -1) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updatePageId] page id is: ", -1, ", not change.");
        } else if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[updatePageId] item holder should not be null.");
        } else {
            aVar.r(i3);
        }
    }

    private void L0(RecyclerView recyclerView) {
        ua0.a aVar = this.I;
        if (aVar == null) {
            QLog.w("PYMK-QCirclePYMKRecommendAdapter", 1, "[updateRecyclerDetached] card report helper should not be null.");
            return;
        }
        recyclerView.removeOnScrollListener(aVar);
        QCircleFeedReportScroller qCircleFeedReportScroller = this.J;
        if (qCircleFeedReportScroller != null) {
            qCircleFeedReportScroller.U(this.I);
        }
        this.I.k();
    }

    private QCircleRecommendBaseAdapter.a r0(int i3, ViewGroup viewGroup) {
        if (this.M) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false));
        }
        return new qc0.a(LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false));
    }

    private int s0() {
        if (this.L) {
            return R.layout.gjz;
        }
        j jVar = j.f428831a;
        if (jVar.e()) {
            return R.layout.f168745gq0;
        }
        if (jVar.f()) {
            return R.layout.f168746gq1;
        }
        return R.layout.gpz;
    }

    private void t0(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        if (qCircleFollowUpdateEvent == null) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[handleFollowUpdateState] event should not be null.");
            return;
        }
        if (QCirclePluginUtil.isFollow(qCircleFollowUpdateEvent.mFollowStatus) && !j.f428831a.d()) {
            String str = qCircleFollowUpdateEvent.mUserId;
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 4, "[handleFollowUpdateState] remove uid: ", str);
            QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = new QQCircleDitto$StItemInfo();
            qQCircleDitto$StItemInfo.f429300id.set(str);
            l0(qQCircleDitto$StItemInfo, 1);
        }
    }

    private void u0(List<QQCircleDitto$StItemInfo> list) {
        if (this.f82588m == null) {
            QLog.w("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyDataChange] data should not be null.");
            return;
        }
        if (this.F == null) {
            QLog.w("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyDataChange] widget should not be null.");
            return;
        }
        List<QQCircleDitto$StItemInfo> b16 = ab.b(list);
        this.f82588m.clear();
        this.f82588m.addAll(b16);
        int i3 = 0;
        QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyDataChange] pymk recommend list size: ", Integer.valueOf(list.size()));
        QCircleBaseWidgetView qCircleBaseWidgetView = this.F;
        if (this.f82588m.isEmpty()) {
            i3 = 8;
        }
        qCircleBaseWidgetView.setVisibility(i3);
        m0();
    }

    private void v0(RecyclerView.ViewHolder viewHolder) {
        ua0.a aVar = this.I;
        if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[notifyReportHelperAttached] card report helper should not be null.");
        } else if (viewHolder instanceof qc0.a) {
            aVar.l((qc0.a) viewHolder);
        }
    }

    public void A0(int i3) {
        this.N = i3;
        E0();
    }

    public void B0(boolean z16) {
        this.L = z16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        arrayList.add(QCircleAddblackUpdateEvent.class);
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f82588m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.H;
    }

    @Override // com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter
    public boolean j0() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        F0();
        ua0.a aVar = this.I;
        if (aVar == null) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[onAttachedToRecyclerView] card report helper should not be null.");
        } else {
            recyclerView.addOnScrollListener(aVar);
            this.P = recyclerView;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.f82588m.size() > i3 && (viewHolder instanceof QCircleRecommendBaseAdapter.a)) {
            QCircleRecommendBaseAdapter.a aVar = (QCircleRecommendBaseAdapter.a) viewHolder;
            K0(aVar);
            aVar.p(this);
            aVar.s(this.C);
            aVar.t(this.D);
            aVar.u(this.K);
            aVar.q(this.f82588m.get(i3), i3, this.H);
            J0(i3, aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        L0(recyclerView);
        this.P = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            t0((QCircleFollowUpdateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleAddblackUpdateEvent) {
            D0((QCircleAddblackUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        v0(viewHolder);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.K = qCircleReportBean;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w0, reason: merged with bridge method [inline-methods] */
    public QCircleRecommendBaseAdapter.a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return r0(s0(), viewGroup);
    }

    public void x0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, List<QQCircleDitto$StItemInfo> list, int i16) {
        if (feedCloudMeta$StFeed == null) {
            QLog.d("PYMK-QCirclePYMKRecommendAdapter", 1, "[setDatas] feed should not be null.");
            return;
        }
        this.C = feedCloudMeta$StFeed;
        this.D = i3;
        this.H = i16;
        H0();
        u0(list);
    }

    public void y0(QCircleFeedReportScroller qCircleFeedReportScroller) {
        this.J = qCircleFeedReportScroller;
        I0();
    }

    public void z0(boolean z16) {
        this.M = z16;
    }

    public void C0(InterfaceC0939a interfaceC0939a) {
    }
}
