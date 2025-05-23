package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSReplyExtraBean;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentBaseItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentDefaultItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentFeedDescItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentShareAdItemView;
import com.tencent.biz.qqcircle.comment.QFSFastCommentItemView;
import com.tencent.biz.qqcircle.events.QCircleCommentStateChangeEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSReplyListEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSChangePgidEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentBlock extends com.tencent.biz.qqcircle.bizparts.a<QFSCommentItemInfo> implements SimpleEventReceiver {
    public static final String I = com.tencent.biz.qqcircle.utils.h.a(R.string.f181813es);
    private static final int J = com.tencent.biz.qqcircle.f.n();
    private static final int K = com.tencent.biz.qqcircle.f.p();
    private com.tencent.biz.qqcircle.widgets.comment.c C;
    private FeedCloudMeta$StFeed D;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> E;
    private final HashMap<String, Integer> F;
    private int G;
    private HashMap<Integer, String> H;

    /* renamed from: m, reason: collision with root package name */
    private boolean f82590m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f82596d;

        a(LinearLayoutManager linearLayoutManager) {
            this.f82596d = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && QFSCommentBlock.this.getItemCount() > 0) {
                QFSCommentBlock.this.W0(this.f82596d);
                VideoReport.traversePage(recyclerView);
            } else if (i3 == 1 && QFSCommentBlock.this.getItemCount() > 0) {
                QFSCommentBlock.this.F0(this.f82596d);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (QFSCommentBlock.this.f82590m) {
                QFSCommentBlock.this.X0(this.f82596d);
                QFSCommentBlock.this.f82590m = false;
            }
        }
    }

    public QFSCommentBlock(Bundle bundle) {
        super(bundle);
        this.f82590m = true;
        this.F = new HashMap<>();
        this.G = J;
        this.H = new HashMap<>();
    }

    private void C0(String str, QFSCommentItemInfo qFSCommentItemInfo) {
        String str2;
        for (int i3 = 0; i3 < qFSCommentItemInfo.replyItemList.size(); i3++) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.replyItemList.get(i3).reply;
            if (feedCloudMeta$StReply != null && str.equals(feedCloudMeta$StReply.f398460id.get())) {
                FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
                if (feedCloudMeta$StComment != null) {
                    str2 = feedCloudMeta$StComment.f398447id.get();
                } else {
                    str2 = "";
                }
                qFSCommentItemInfo.removeReplyItemInfo(str, O0(str2));
                return;
            }
        }
    }

    private void D0(QFSCommentItemInfo qFSCommentItemInfo) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        int i3;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null) {
            if (N0(qFSCommentItemInfo.comment) <= O0(feedCloudMeta$StComment.f398447id.get())) {
                for (int i16 = 0; i16 < qFSCommentItemInfo.replyItemList.size(); i16++) {
                    QFSReplyItemInfo qFSReplyItemInfo = qFSCommentItemInfo.replyItemList.get(i16);
                    if (qFSReplyItemInfo != null && ((i3 = qFSReplyItemInfo.type) == 6 || i3 == 7)) {
                        qFSCommentItemInfo.replyItemList.remove(i16);
                        return;
                    }
                }
            }
        }
    }

    private void E0(String str, QFSCommentItemInfo qFSCommentItemInfo) {
        for (int i3 = 0; i3 < qFSCommentItemInfo.comment.vecReply.get().size(); i3++) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.comment.vecReply.get(i3);
            if (feedCloudMeta$StReply != null && str.equals(feedCloudMeta$StReply.f398460id.get())) {
                qFSCommentItemInfo.comment.vecReply.remove(i3);
                qFSCommentItemInfo.comment.replyCount.set(qFSCommentItemInfo.comment.replyCount.get() - 1);
                return;
            }
        }
    }

    private void H0(String str, List<FeedCloudMeta$StReply> list) {
        List<String> D = QFSCommentHelper.L().D(QFSCommentHelper.L().C(this.D.f398449id.get(), str));
        if (RFSafeListUtils.isEmpty(D)) {
            return;
        }
        Iterator<FeedCloudMeta$StReply> it = list.iterator();
        while (it.hasNext()) {
            FeedCloudMeta$StReply next = it.next();
            Iterator<String> it5 = D.iterator();
            while (true) {
                if (it5.hasNext()) {
                    if (TextUtils.equals(next.f398460id.get(), it5.next())) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    private int J0() {
        if (Q0() != null) {
            return 1;
        }
        return 0;
    }

    private List<QFSReplyItemInfo> L0(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < qFSCommentItemInfo.comment.vecReply.size(); i16++) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.comment.vecReply.get(i16);
            if (!y0(qFSCommentItemInfo, feedCloudMeta$StReply) && arrayList.size() < i3) {
                arrayList.add(new QFSReplyItemInfo(5, feedCloudMeta$StReply));
            }
        }
        return arrayList;
    }

    private int O0(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || !this.F.containsKey(str) || (num = this.F.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    private void R0(View view, QFSCommentItemInfo qFSCommentItemInfo, QFSReplyItemInfo qFSReplyItemInfo, final List<QFSReplyItemInfo> list, final int i3) {
        int size = list.size();
        boolean z16 = true;
        if (size != 0) {
            if (qFSCommentItemInfo.replyItemList.get(i3).moreNum <= size) {
                size = qFSCommentItemInfo.replyItemList.get(i3).moreNum;
            } else {
                z16 = false;
            }
        }
        if (z16) {
            qFSReplyItemInfo.type = 7;
            qFSReplyItemInfo.moreNum = 0;
        } else {
            qFSReplyItemInfo.moreNum -= size;
        }
        qFSCommentItemInfo.replyItemList.addAll(i3, list);
        if (view != null) {
            com.tencent.biz.qqcircle.comment.af.u(view, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.adapter.t
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    QFSCommentBlock.Y0(i3, list, (com.tencent.biz.qqcircle.comment.animation.a) obj);
                }
            });
        }
    }

    private void U0(QFSReplyListEvent qFSReplyListEvent) {
        QFSReplyExtraBean extraBean;
        if (qFSReplyListEvent == null || qFSReplyListEvent.getContextHashCode() != hashCode() || (extraBean = qFSReplyListEvent.getExtraBean()) == null) {
            return;
        }
        QFSCommentItemInfo circleCommentItemInfo = extraBean.getCircleCommentItemInfo();
        QFSReplyItemInfo qCircleReplyItemInfo = extraBean.getQCircleReplyItemInfo();
        int replyPosition = extraBean.getReplyPosition();
        qCircleReplyItemInfo.type = 6;
        if (!qFSReplyListEvent.isLoadSuccess()) {
            e1(false);
            return;
        }
        List<FeedCloudMeta$StReply> list = qFSReplyListEvent.getRsp().vecReply.get();
        if (list == null) {
            e1(false);
            return;
        }
        H0(circleCommentItemInfo.comment.f398447id.get(), list);
        circleCommentItemInfo.comment.vecReply.addAll(list);
        ArrayList arrayList = new ArrayList();
        Iterator<FeedCloudMeta$StReply> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new QFSReplyItemInfo(5, it.next()));
        }
        if (qFSReplyListEvent.getRsp().isFinish.get() == 1) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = circleCommentItemInfo.comment;
            feedCloudMeta$StComment.replyCount.set(feedCloudMeta$StComment.vecReply.size());
            D0(circleCommentItemInfo);
        }
        o1(extraBean.getView(), circleCommentItemInfo, replyPosition, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y0(int i3, List list, com.tencent.biz.qqcircle.comment.animation.a aVar) {
        RecyclerView.Adapter adapter = aVar.i().getAdapter();
        if (adapter instanceof QFSCommentReplyAdapter) {
            ((QFSCommentReplyAdapter) adapter).o0(i3, list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z0(int i3, com.tencent.biz.qqcircle.comment.animation.a aVar) {
        RecyclerView.Adapter adapter = aVar.i().getAdapter();
        if (adapter instanceof QFSCommentReplyAdapter) {
            ((QFSCommentReplyAdapter) adapter).n0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setItemAnimator(new EnhanceItemAnimator());
        if (!(this.mRecyclerView.getItemAnimator() instanceof SimpleItemAnimator)) {
            return;
        }
        ((SimpleItemAnimator) this.mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    private void d1(final int i3) {
        g1(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentBlock.4
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentBlock.this.a1();
                QFSCommentBlock.this.notifyItemChanged(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(final boolean z16) {
        g1(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentBlock.2
            @Override // java.lang.Runnable
            public void run() {
                if (z16) {
                    QFSCommentBlock.this.z0();
                }
                QFSCommentBlock.this.notifyDataSetChanged();
            }
        });
    }

    private void f1(final int i3) {
        g1(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentBlock.3
            @Override // java.lang.Runnable
            public void run() {
                if (i3 != 0) {
                    QFSCommentBlock.this.a1();
                }
                QFSCommentBlock.this.notifyItemRemoved(i3);
                QFSCommentBlock qFSCommentBlock = QFSCommentBlock.this;
                qFSCommentBlock.notifyItemRangeChanged(i3, ((BaseListViewAdapter) qFSCommentBlock).mDataList.size() - i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(final int i3, final Runnable runnable) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentBlock.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSCommentBlock.this.g1(i3 - 1, runnable);
                    }
                }, 20L);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        RFWLog.i("QFSCommentBlock", RFWLog.USR, "safeNotify return count = " + i3);
    }

    private List<QFSCommentItemInfo> q1(List<FeedCloudMeta$StComment> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (FeedCloudMeta$StComment feedCloudMeta$StComment : list) {
            QFSCommentItemInfo qFSCommentItemInfo = new QFSCommentItemInfo(feedCloudMeta$StComment);
            int size = feedCloudMeta$StComment.vecReply.size();
            this.F.put(feedCloudMeta$StComment.f398447id.get(), Integer.valueOf(size));
            for (int i3 = 0; i3 < size; i3++) {
                qFSCommentItemInfo.addReplyItemInfo(5, feedCloudMeta$StComment.vecReply.get(i3));
            }
            if (size < N0(feedCloudMeta$StComment)) {
                qFSCommentItemInfo.addReplyItemInfo(6, N0(feedCloudMeta$StComment) - size);
            }
            arrayList.add(qFSCommentItemInfo);
        }
        return arrayList;
    }

    private boolean y0(QFSCommentItemInfo qFSCommentItemInfo, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        for (QFSReplyItemInfo qFSReplyItemInfo : qFSCommentItemInfo.replyItemList) {
            if (qFSReplyItemInfo != null && qFSReplyItemInfo.type == 5 && TextUtils.equals(qFSReplyItemInfo.reply.f398460id.get(), feedCloudMeta$StReply.f398460id.get())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setItemAnimator(null);
    }

    public void A0(View view) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVATAR_IF_DIFF, 1);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public void B0(View view) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVATAR_IF_DIFF, 0);
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public void F0(LinearLayoutManager linearLayoutManager) {
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= linearLayoutManager.findLastVisibleItemPosition(); findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition instanceof QFSCommentBaseItemView) {
                if (this.H.containsKey(Integer.valueOf(findFirstVisibleItemPosition)) && this.H.get(Integer.valueOf(findFirstVisibleItemPosition)) != null && this.H.get(Integer.valueOf(findFirstVisibleItemPosition)).equals("true")) {
                    ((QFSCommentBaseItemView) findViewByPosition).u0();
                } else {
                    ((QFSCommentBaseItemView) findViewByPosition).p0();
                }
            }
        }
    }

    public QFSCommentItemInfo I0() {
        int J0;
        if (RFSafeListUtils.isEmpty(this.mDataList) || (J0 = J0()) >= this.mDataList.size()) {
            return null;
        }
        QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(J0);
        if (qFSCommentItemInfo.type != 2) {
            return null;
        }
        return qFSCommentItemInfo;
    }

    public String K0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.D;
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        return feedCloudMeta$StFeed.f398449id.get();
    }

    public int M0() {
        int itemCount = getItemCount();
        if (x0()) {
            itemCount--;
        }
        if (w0()) {
            return itemCount - 1;
        }
        return itemCount;
    }

    public int N0(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return 0;
        }
        return feedCloudMeta$StComment.replyCount.get();
    }

    public QFSCommentItemInfo Q0() {
        if (RFSafeListUtils.isEmpty(this.mDataList)) {
            return null;
        }
        QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(0);
        if (qFSCommentItemInfo.type != 1) {
            return null;
        }
        return qFSCommentItemInfo;
    }

    public void S0(QCircleCommentStateChangeEvent qCircleCommentStateChangeEvent) {
        qCircleCommentStateChangeEvent.isDragging();
    }

    public void T0(QCirclePanelStateEvent qCirclePanelStateEvent) {
        if (qCirclePanelStateEvent.getPanelType() == 0 && qCirclePanelStateEvent.isShowing()) {
            return;
        }
        HashMap<Integer, String> hashMap = this.H;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f82590m = true;
    }

    public void V0(QFSChangePgidEvent qFSChangePgidEvent) {
        "pg_xsj_profile_page".equals(qFSChangePgidEvent.getDtPgId());
    }

    public void W0(LinearLayoutManager linearLayoutManager) {
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= linearLayoutManager.findLastVisibleItemPosition(); findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition instanceof QFSCommentBaseItemView) {
                k1(findViewByPosition, findFirstVisibleItemPosition);
            }
        }
    }

    public void X0(LinearLayoutManager linearLayoutManager) {
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= linearLayoutManager.findLastVisibleItemPosition(); findFirstVisibleItemPosition++) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition instanceof QFSCommentBaseItemView) {
                l1(findViewByPosition, findFirstVisibleItemPosition);
            }
        }
    }

    public void addData(List<FeedCloudMeta$StComment> list) {
        List<E> list2 = this.mDataList;
        list2.addAll(list2.size(), q1(list));
        e1(true);
    }

    public void b1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.mDataList.size()) {
                if (((QFSCommentItemInfo) this.mDataList.get(i3)).comment.f398447id.get().equals(str)) {
                    this.mDataList.remove(i3);
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            f1(i3);
        }
    }

    public void c1(String str, String str2) {
        List<QFSReplyItemInfo> list;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i3 = 0;
            while (true) {
                if (i3 < this.mDataList.size()) {
                    QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(i3);
                    if (str.equals(qFSCommentItemInfo.comment.f398447id.get()) && (list = qFSCommentItemInfo.replyItemList) != null && list.size() > 0) {
                        E0(str2, qFSCommentItemInfo);
                        C0(str2, qFSCommentItemInfo);
                        D0(qFSCommentItemInfo);
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                d1(i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void clearData() {
        this.mDataList.clear();
        e1(true);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(QCircleCommentStateChangeEvent.class);
        arrayList.add(QFSChangePgidEvent.class);
        arrayList.add(QFSReplyListEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(i3);
            if (qFSCommentItemInfo.comment.cmt_block_type.get() == 1) {
                return 3;
            }
            int i16 = qFSCommentItemInfo.type;
            if (i16 == 1) {
                return 1;
            }
            if (i16 == 2) {
                return 2;
            }
            if (qFSCommentItemInfo.comment.dittocomment.dittoId.get() == 29) {
                return 29;
            }
        }
        return super.getItemViewType(i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSCommentBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 3;
    }

    public void h1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, List<FeedCloudMeta$StComment> list) {
        this.D = feedCloudMeta$StFeed;
        this.mDataList.clear();
        this.mDataList.addAll(q1(list));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentBlock.5
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentBlock.this.e1(true);
                VideoReport.traversePage(((BaseListViewAdapter) QFSCommentBlock.this).mRecyclerView);
            }
        });
    }

    public void i1(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.C = cVar;
    }

    public void j1(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.E = aVar;
    }

    public void k1(View view, int i3) {
        if (this.H.containsKey(Integer.valueOf(i3)) && this.H.get(Integer.valueOf(i3)).equals("true")) {
            ((QFSCommentBaseItemView) view).u0();
            return;
        }
        QFSCommentBaseItemView qFSCommentBaseItemView = (QFSCommentBaseItemView) view;
        if (qFSCommentBaseItemView.r0()) {
            qFSCommentBaseItemView.v0();
            A0(qFSCommentBaseItemView.q0());
            this.H.put(Integer.valueOf(i3), "true");
        } else {
            qFSCommentBaseItemView.p0();
            B0(qFSCommentBaseItemView.q0());
        }
    }

    public void l1(View view, int i3) {
        QFSCommentBaseItemView qFSCommentBaseItemView = (QFSCommentBaseItemView) view;
        if (qFSCommentBaseItemView.r0()) {
            qFSCommentBaseItemView.v0();
            this.H.put(Integer.valueOf(i3), "true");
            A0(qFSCommentBaseItemView.q0());
            return;
        }
        qFSCommentBaseItemView.p0();
    }

    public void m1(int i3, int i16) {
        if (this.mDataList.size() <= i3) {
            return;
        }
        QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(i3);
        if (qFSCommentItemInfo.replyItemList.size() > i16 && qFSCommentItemInfo.replyItemList.get(i16).type == 7) {
            Iterator<QFSReplyItemInfo> it = qFSCommentItemInfo.replyItemList.iterator();
            int O0 = O0(qFSCommentItemInfo.comment.f398447id.get());
            int i17 = 0;
            while (it.hasNext()) {
                QFSReplyItemInfo next = it.next();
                if (i17 < O0) {
                    i17++;
                } else {
                    if (next.type == 7) {
                        next.type = 6;
                        next.moreNum = N0(qFSCommentItemInfo.comment) - (qFSCommentItemInfo.replyItemList.size() - 1);
                        return;
                    }
                    it.remove();
                }
            }
        }
    }

    public void n1(View view, int i3, int i16) {
        if (this.mDataList.size() <= i3) {
            return;
        }
        o1(view, (QFSCommentItemInfo) this.mDataList.get(i3), i16, false);
    }

    public void o1(View view, QFSCommentItemInfo qFSCommentItemInfo, final int i3, boolean z16) {
        List<QFSReplyItemInfo> list;
        if (qFSCommentItemInfo != null && (list = qFSCommentItemInfo.replyItemList) != null && list.size() > i3 && qFSCommentItemInfo.replyItemList.get(i3).type == 6) {
            int i16 = J;
            if (i3 >= i16) {
                this.G = Math.min(K, qFSCommentItemInfo.replyItemList.get(i3).moreNum);
            } else {
                this.G = Math.min(i16 - i3, qFSCommentItemInfo.replyItemList.get(i3).moreNum);
            }
            List<QFSReplyItemInfo> L0 = L0(qFSCommentItemInfo, this.G);
            QFSReplyItemInfo qFSReplyItemInfo = qFSCommentItemInfo.replyItemList.get(qFSCommentItemInfo.replyItemList.size() - 1);
            if (!z16 && (L0.isEmpty() || L0.size() < this.G)) {
                qFSReplyItemInfo.type = 8;
                QFSReplyExtraBean qFSReplyExtraBean = new QFSReplyExtraBean(qFSCommentItemInfo, qFSReplyItemInfo, i3);
                qFSReplyExtraBean.setView(view);
                com.tencent.biz.qqcircle.comment.h.G().L(hashCode(), this.D, qFSCommentItemInfo.comment, qFSReplyExtraBean);
                if (view != null) {
                    com.tencent.biz.qqcircle.comment.af.u(view, new OnPromiseResolved() { // from class: com.tencent.biz.qqcircle.adapter.s
                        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                        public final void onDone(Object obj) {
                            QFSCommentBlock.Z0(i3, (com.tencent.biz.qqcircle.comment.animation.a) obj);
                        }
                    });
                    return;
                }
                return;
            }
            R0(view, qFSCommentItemInfo, qFSReplyItemInfo, L0, i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        SimpleEventBus.getInstance().registerReceiver(this);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.addOnScrollListener(new a((LinearLayoutManager) layoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            if (viewHolder instanceof i20.b) {
                ((i20.b) viewHolder).l(i3, this.D, (QFSCommentItemInfo) this.mDataList.get(i3), this.C);
                return;
            }
            if (viewHolder instanceof i20.d) {
                ((i20.d) viewHolder).l(i3, this.D, (QFSCommentItemInfo) this.mDataList.get(i3), this.C);
            } else if (viewHolder instanceof i20.c) {
                ((i20.c) viewHolder).l(i3, this.D, (QFSCommentItemInfo) this.mDataList.get(i3), this.C);
            } else if (viewHolder instanceof i20.f) {
                ((i20.f) viewHolder).l(i3, this.D, (QFSCommentItemInfo) this.mDataList.get(i3), this.C);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            QFSCommentFeedDescItemView qFSCommentFeedDescItemView = new QFSCommentFeedDescItemView(viewGroup.getContext());
            qFSCommentFeedDescItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            qFSCommentFeedDescItemView.setReportBean(getReportBean());
            return new i20.d(qFSCommentFeedDescItemView);
        }
        if (i3 == 2) {
            QFSFastCommentItemView qFSFastCommentItemView = new QFSFastCommentItemView(viewGroup.getContext());
            qFSFastCommentItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            qFSFastCommentItemView.setReportBean(getReportBean());
            return new i20.c(qFSFastCommentItemView);
        }
        if (i3 == 3) {
            QFSCommentShareAdItemView qFSCommentShareAdItemView = new QFSCommentShareAdItemView(viewGroup.getContext());
            qFSCommentShareAdItemView.setReportBean(getReportBean());
            return new i20.f(qFSCommentShareAdItemView);
        }
        QFSCommentDefaultItemView qFSCommentDefaultItemView = new QFSCommentDefaultItemView(viewGroup.getContext());
        qFSCommentDefaultItemView.setReportBean(getReportBean());
        return new i20.b(qFSCommentDefaultItemView, viewGroup);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        HashMap<Integer, String> hashMap = this.H;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f82590m = true;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCirclePanelStateEvent) {
            T0((QCirclePanelStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSChangePgidEvent) {
            V0((QFSChangePgidEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleCommentStateChangeEvent) {
            S0((QCircleCommentStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSReplyListEvent) {
            U0((QFSReplyListEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
    }

    public void p1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        if (this.mDataList.size() > 0) {
            if (this.mDataList.get(0) != null && ((QFSCommentItemInfo) this.mDataList.get(0)).comment.typeFlag.get() == 1) {
                ((QFSCommentItemInfo) this.mDataList.get(0)).comment.typeFlag.set(0);
            }
            QFSCommentItemInfo qFSCommentItemInfo = null;
            for (E e16 : this.mDataList) {
                if (e16.comment.f398447id.get().equals(str)) {
                    e16.comment.typeFlag.set(1);
                    qFSCommentItemInfo = e16;
                } else {
                    linkedList.add(e16);
                }
            }
            if (qFSCommentItemInfo != null) {
                linkedList.add(0, qFSCommentItemInfo);
            }
            this.mDataList.clear();
            e1(false);
            this.mDataList.addAll(new ArrayList(linkedList));
        }
        e1(false);
    }

    public void r1(String str, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.mDataList.size()) {
                if (str.equals(((QFSCommentItemInfo) this.mDataList.get(i3)).comment.f398447id.get())) {
                    this.mDataList.set(i3, new QFSCommentItemInfo(feedCloudMeta$StComment));
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            d1(i3);
        }
    }

    public void s0(int i3, FeedCloudMeta$StComment feedCloudMeta$StComment, com.tencent.biz.qqcircle.comment.effect.d dVar) {
        if (feedCloudMeta$StComment != null && i3 <= this.mDataList.size()) {
            this.mDataList.add(i3, new QFSCommentItemInfo(feedCloudMeta$StComment, dVar));
        }
        e1(false);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i3);
        }
    }

    public void s1(String str, String str2, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.mDataList.size()) {
                    break;
                }
                QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(i3);
                if (str.equals(qFSCommentItemInfo.comment.f398447id.get())) {
                    for (int size = qFSCommentItemInfo.comment.vecReply.get().size() - 1; size >= 0; size--) {
                        if (str2.equals(qFSCommentItemInfo.comment.vecReply.get(size).f398460id.get())) {
                            qFSCommentItemInfo.comment.vecReply.get().set(size, feedCloudMeta$StReply);
                            qFSCommentItemInfo.updateReplyItemInfo(str2, feedCloudMeta$StReply);
                            break;
                        }
                    }
                } else {
                    i3++;
                }
            }
            i3 = -1;
            if (i3 != -1) {
                d1(i3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public void t0(FeedCloudMeta$StComment feedCloudMeta$StComment, com.tencent.biz.qqcircle.comment.effect.d dVar) {
        ?? x06 = x0();
        if (this.mDataList.size() > x06 && ((QFSCommentItemInfo) this.mDataList.get(x06 == true ? 1 : 0)).comment.typeFlag.get() == 1) {
            s0((x06 == true ? 1 : 0) + 1, feedCloudMeta$StComment, dVar);
        } else {
            s0(x06 == true ? 1 : 0, feedCloudMeta$StComment, dVar);
        }
    }

    public void u0(String str, String str2, FeedCloudMeta$StReply feedCloudMeta$StReply, com.tencent.biz.qqcircle.comment.effect.d dVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.mDataList.size()) {
                QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(i3);
                if (str.equals(qFSCommentItemInfo.comment.f398447id.get())) {
                    qFSCommentItemInfo.addFakeReply(str2, feedCloudMeta$StReply, dVar);
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            d1(i3);
        }
    }

    public void v0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator it = this.mDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) it.next();
            if (str.equals(qFSCommentItemInfo.comment.f398447id.get())) {
                qFSCommentItemInfo.comment.typeFlag.set(0);
                break;
            }
        }
        e1(false);
    }

    public boolean w0() {
        if (I0() != null) {
            return true;
        }
        return false;
    }

    public boolean x0() {
        if (Q0() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        if (this.mReportBean != null) {
            return QCircleReportBean.getReportBean(getLogTag(), this.mReportBean);
        }
        if (this.E != null) {
            return QCircleReportBean.getReportBean(getLogTag(), this.E.getReportBean());
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
