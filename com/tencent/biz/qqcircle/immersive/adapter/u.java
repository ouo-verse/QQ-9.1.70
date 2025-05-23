package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.adapter.QCircleRecommendBaseAdapter;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTalentPeopleItemView;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class u extends QCircleRecommendBaseAdapter {
    public static final String[] M = {"https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_1.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_2.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_3.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_4.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_5.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_6.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_7.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_8.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_9.png", "https://downv6.qq.com/video_story/qcircle/feed/follow/qcircle_talent_people_rank_10.png"};
    private int H = 0;
    private RecyclerView I;
    private ua0.b J;
    private QCircleFeedReportScroller K;
    private QCircleReportBean L;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCircleRecommendBaseAdapter.a {
        public QFSMixFeedTalentPeopleItemView M;

        public a(QFSMixFeedTalentPeopleItemView qFSMixFeedTalentPeopleItemView) {
            super(qFSMixFeedTalentPeopleItemView);
            this.M = qFSMixFeedTalentPeopleItemView;
        }
    }

    private void A0(a aVar) {
        int i3 = this.H;
        if (i3 == -1) {
            QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "[updatePageId] page id is: ", -1, ", not change.");
        } else if (aVar == null) {
            QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "[updatePageId] item holder should not be null.");
        } else {
            aVar.r(i3);
        }
    }

    private void B0(RecyclerView recyclerView) {
        ua0.b bVar = this.J;
        if (bVar == null) {
            QLog.w("QFSMixFeedTalentPeopleViewAdapter", 1, "[updateRecyclerDetached] card report helper should not be null.");
            return;
        }
        recyclerView.removeOnScrollListener(bVar);
        QCircleFeedReportScroller qCircleFeedReportScroller = this.K;
        if (qCircleFeedReportScroller != null) {
            qCircleFeedReportScroller.U(this.J);
        }
        this.J.j();
    }

    private List<QQCircleDitto$StItemInfo> r0(List<QQCircleDitto$StItemInfo> list) {
        if (list.size() > 10) {
            return list.subList(0, 10);
        }
        return list;
    }

    private void s0(List<QQCircleDitto$StItemInfo> list) {
        List<QQCircleDitto$StItemInfo> list2 = this.f82588m;
        if (list2 == null) {
            QLog.w("QFSMixFeedTalentPeopleViewAdapter", 1, "[notifyDataChange] data should not be null.");
            return;
        }
        list2.clear();
        this.f82588m.addAll(r0(list));
        QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "[notifyDataChange] soaring list size: ", Integer.valueOf(list.size()));
        m0();
    }

    private void t0(RecyclerView.ViewHolder viewHolder) {
        ua0.b bVar = this.J;
        if (bVar == null) {
            QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "[notifyReportHelperAttached] card report helper should not be null.");
        } else if (viewHolder instanceof a) {
            bVar.k((a) viewHolder);
        }
    }

    private void x0() {
        RecyclerView.LayoutManager layoutManager;
        Object tag;
        RecyclerView recyclerView = this.I;
        if (recyclerView == null) {
            layoutManager = null;
        } else {
            layoutManager = recyclerView.getLayoutManager();
        }
        if (!(layoutManager instanceof LinearLayoutManager)) {
            QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "[updateVisibleItePageId] update visible item page id fail, not equals linear layout manager.");
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
            if (tag instanceof a) {
                A0((a) tag);
            }
        }
    }

    private void y0() {
        if (this.E == null) {
            return;
        }
        if (this.J == null) {
            this.J = new ua0.b();
        }
        this.J.o(this.E);
        z0();
    }

    private void z0() {
        ua0.b bVar;
        QCircleFeedReportScroller qCircleFeedReportScroller = this.K;
        if (qCircleFeedReportScroller == null || (bVar = this.J) == null) {
            return;
        }
        qCircleFeedReportScroller.F(bVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f82588m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        y0();
        ua0.b bVar = this.J;
        if (bVar == null) {
            QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "talent card report helper should not be null.");
        } else {
            recyclerView.addOnScrollListener(bVar);
            this.I = recyclerView;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.f82588m.size() > i3 && (viewHolder instanceof a)) {
            a aVar = (a) viewHolder;
            aVar.p(this);
            aVar.s(this.C);
            aVar.t(this.D);
            aVar.u(this.L);
            aVar.M.n0();
            aVar.M.setData(this.f82588m.get(i3), i3, M[i3]);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSMixFeedTalentPeopleItemView qFSMixFeedTalentPeopleItemView = new QFSMixFeedTalentPeopleItemView(viewGroup.getContext());
        qFSMixFeedTalentPeopleItemView.setParentView(viewGroup);
        return new a(qFSMixFeedTalentPeopleItemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        B0(recyclerView);
        this.I = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        t0(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        this.I = null;
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.L = qCircleReportBean;
    }

    public void u0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, List<QQCircleDitto$StItemInfo> list, int i16) {
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSMixFeedTalentPeopleViewAdapter", 1, "feed should not be null.");
            return;
        }
        this.C = feedCloudMeta$StFeed;
        this.D = i3;
        s0(list);
    }

    public void v0(QCircleFeedReportScroller qCircleFeedReportScroller) {
        this.K = qCircleFeedReportScroller;
        z0();
    }

    public void w0(int i3) {
        this.H = i3;
        x0();
        ua0.b bVar = this.J;
        if (bVar != null) {
            bVar.n(this.H);
        }
    }
}
