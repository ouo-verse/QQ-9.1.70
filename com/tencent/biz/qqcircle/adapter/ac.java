package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.beans.QFSReplyExtraBean;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentAdDescItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentDefaultItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentFeedbackItemView;
import com.tencent.biz.qqcircle.comment.QFSCommentShareAdItemView;
import com.tencent.biz.qqcircle.comment.QFSFastCommentItemView;
import com.tencent.biz.qqcircle.comment.QFSMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QFSReplyItemView;
import com.tencent.biz.qqcircle.comment.animation.QFSMoreReplyAnimation;
import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QFSReplyListEvent;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ac extends com.tencent.biz.qqcircle.bizparts.a<QFSCommentItemInfo> implements SimpleEventReceiver {
    private static final int F = com.tencent.biz.qqcircle.f.n();
    private static final int G = com.tencent.biz.qqcircle.f.p();
    private FeedCloudMeta$StFeed C;
    private int D;
    private int E;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.widgets.comment.c f82613m;

    public ac(Bundle bundle) {
        super(bundle);
        this.E = 0;
    }

    private void A0(QFSReplyListEvent qFSReplyListEvent) {
        QFSReplyExtraBean extraBean;
        if (qFSReplyListEvent == null || qFSReplyListEvent.getContextHashCode() != hashCode() || (extraBean = qFSReplyListEvent.getExtraBean()) == null) {
            return;
        }
        QFSCommentItemInfo circleCommentItemInfo = extraBean.getCircleCommentItemInfo();
        QFSReplyItemInfo qCircleReplyItemInfo = extraBean.getQCircleReplyItemInfo();
        int replyPosition = extraBean.getReplyPosition();
        qCircleReplyItemInfo.type = 6;
        if (!qFSReplyListEvent.isLoadSuccess()) {
            R0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ac.this.J0();
                }
            });
            return;
        }
        List<FeedCloudMeta$StReply> list = qFSReplyListEvent.getRsp().vecReply.get();
        if (list == null) {
            R0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ac.this.K0();
                }
            });
            return;
        }
        s0(circleCommentItemInfo.comment.f398447id.get(), list);
        circleCommentItemInfo.comment.vecReply.addAll(list);
        if (qFSReplyListEvent.getRsp().isFinish.get() == 1) {
            QLog.d("QFSCommentItemBlock", 1, "load reply finish. ");
            FeedCloudMeta$StComment feedCloudMeta$StComment = circleCommentItemInfo.comment;
            feedCloudMeta$StComment.replyCount.set(feedCloudMeta$StComment.vecReply.size());
        }
        W0(extraBean.getView(), replyPosition, true);
    }

    private void B0(QCircleCommentPraiseUpdateEvent qCircleCommentPraiseUpdateEvent) {
        QFSReplyItemInfo y06;
        int i3 = qCircleCommentPraiseUpdateEvent.mType;
        if (i3 == 1) {
            QFSCommentItemInfo t06 = t0(qCircleCommentPraiseUpdateEvent.mCommentId);
            if (t06 != null && t06.comment != null) {
                if (QCirclePluginUtil.isOwner(this.C.poster.get())) {
                    t06.comment.likeInfo.ownerStatus.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                }
                t06.comment.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
                t06.comment.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
                return;
            }
            return;
        }
        if (i3 == 2 && (y06 = y0(qCircleCommentPraiseUpdateEvent.mCommentId, qCircleCommentPraiseUpdateEvent.mReplyId)) != null && y06.reply != null) {
            if (QCirclePluginUtil.isOwner(this.C.poster.get())) {
                y06.reply.likeInfo.ownerStatus.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            }
            y06.reply.likeInfo.status.set(qCircleCommentPraiseUpdateEvent.mPraisedStatus);
            y06.reply.likeInfo.count.set(qCircleCommentPraiseUpdateEvent.mPraisedNum);
        }
    }

    private boolean C0(QFSCommentItemInfo qFSCommentItemInfo) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null && feedCloudMeta$StComment.cmt_block_type.get() == 1) {
            return true;
        }
        return false;
    }

    private boolean D0(QFSCommentItemInfo qFSCommentItemInfo) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), "ad_fake_desc_comment_id")) {
            return true;
        }
        return false;
    }

    private boolean E0(QFSCommentItemInfo qFSCommentItemInfo) {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), "feedback_card_id")) {
            return true;
        }
        return false;
    }

    private boolean F0() {
        if (RFSafeListUtils.isEmpty(this.mDataList) || ((QFSCommentItemInfo) this.mDataList.get(0)).comment == null || ((QFSCommentItemInfo) this.mDataList.get(0)).comment.typeFlag.get() != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(int i3) {
        notifyItemChanged(i3 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(int i3, List list) {
        notifyItemRangeInserted(i3 + 1, list.size());
        if (getRecyclerView() != null) {
            VideoReport.traversePage(getRecyclerView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        notifyItemChanged(getItemCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        notifyItemChanged(getItemCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(boolean z16) {
        notifyLoadingComplete(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(int i3, Runnable runnable) {
        R0(i3 - 1, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(int i3, int i16, int i17) {
        notifyItemChanged(i3 + 1);
        notifyItemRangeRemoved(i16, i17);
    }

    private long O0(int i3) {
        if (F0()) {
            return (i3 * 10) + 1;
        }
        return i3;
    }

    private void R0(final int i3, final Runnable runnable) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        ac.this.M0(i3, runnable);
                    }
                }, 20L);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        QLog.i("QFSCommentItemBlock", 1, "safeNotify return count = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (getRecyclerView() != null && getRecyclerView().getItemAnimator() == null) {
            getRecyclerView().setItemAnimator(new QFSMoreReplyAnimation());
        }
    }

    private boolean r0(QFSCommentItemInfo qFSCommentItemInfo, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        for (QFSReplyItemInfo qFSReplyItemInfo : qFSCommentItemInfo.replyItemList) {
            if (qFSReplyItemInfo.type == 5 && TextUtils.equals(qFSReplyItemInfo.reply.f398460id.get(), feedCloudMeta$StReply.f398460id.get())) {
                return true;
            }
        }
        return false;
    }

    private void s0(String str, List<FeedCloudMeta$StReply> list) {
        List<String> D = QFSCommentHelper.L().D(QFSCommentHelper.L().C(this.C.f398449id.get(), str));
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

    private QFSCommentItemInfo t0(String str) {
        List<E> list = this.mDataList;
        if (list == 0) {
            return null;
        }
        for (E e16 : list) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = e16.comment;
            if (feedCloudMeta$StComment != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), str)) {
                return e16;
            }
        }
        return null;
    }

    private int u0(int i3) {
        List<MultiViewBlock> list;
        if (getBlockMerger() != null) {
            list = getBlockMerger().getDataList();
        } else {
            list = null;
        }
        if (list != null && list.size() > 0) {
            i3 = getGlobalPosition(i3);
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                int itemCount = list.get(i16).getItemCount();
                if (i3 <= itemCount) {
                    return i16;
                }
                i3 = Math.max(i3 - itemCount, 0);
            }
        }
        return i3;
    }

    private long v0(int i3) {
        int i16;
        if (i3 >= getItemCount()) {
            return super.getItemId(i3);
        }
        if (i3 == 0) {
            return O0(((QFSCommentItemInfo) this.mDataList.get(0)).hashCode());
        }
        List<E> list = this.mDataList;
        if (list != 0 && !list.isEmpty() && !RFSafeListUtils.isEmpty(((QFSCommentItemInfo) this.mDataList.get(0)).replyItemList) && i3 - 1 < ((QFSCommentItemInfo) this.mDataList.get(0)).replyItemList.size()) {
            return O0(((QFSCommentItemInfo) this.mDataList.get(0)).replyItemList.get(i16).hashCode());
        }
        return super.getItemId(i3);
    }

    private List<QFSReplyItemInfo> w0(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < qFSCommentItemInfo.comment.vecReply.size(); i16++) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = qFSCommentItemInfo.comment.vecReply.get(i16);
            if (!r0(qFSCommentItemInfo, feedCloudMeta$StReply) && arrayList.size() < i3) {
                arrayList.add(new QFSReplyItemInfo(5, feedCloudMeta$StReply));
            }
        }
        return arrayList;
    }

    private int x0(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            return 0;
        }
        return feedCloudMeta$StComment.replyCount.get();
    }

    private QFSReplyItemInfo y0(String str, String str2) {
        List<QFSReplyItemInfo> list;
        List<E> list2 = this.mDataList;
        if (list2 == 0) {
            return null;
        }
        for (E e16 : list2) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = e16.comment;
            if (feedCloudMeta$StComment != null && TextUtils.equals(feedCloudMeta$StComment.f398447id.get(), str) && (list = e16.replyItemList) != null) {
                for (QFSReplyItemInfo qFSReplyItemInfo : list) {
                    FeedCloudMeta$StReply feedCloudMeta$StReply = qFSReplyItemInfo.reply;
                    if (feedCloudMeta$StReply != null && TextUtils.equals(feedCloudMeta$StReply.f398460id.get(), str2)) {
                        return qFSReplyItemInfo;
                    }
                }
            }
        }
        return null;
    }

    private void z0(QFSCommentItemInfo qFSCommentItemInfo, QFSReplyItemInfo qFSReplyItemInfo, final List<QFSReplyItemInfo> list, final int i3) {
        int i16;
        boolean z16;
        int size = list.size();
        FeedCloudMeta$StComment feedCloudMeta$StComment = qFSCommentItemInfo.comment;
        if (feedCloudMeta$StComment == null) {
            i16 = 0;
        } else {
            i16 = feedCloudMeta$StComment.replyCount.get();
        }
        int i17 = i16 - (size + i3);
        if (i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qFSReplyItemInfo.type = 7;
            qFSReplyItemInfo.moreNum = 0;
        } else {
            qFSReplyItemInfo.type = 6;
            qFSReplyItemInfo.moreNum = i17;
        }
        qFSCommentItemInfo.replyItemList.addAll(i3, list);
        R0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.w
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.H0(i3);
            }
        });
        R0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.x
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.I0(i3, list);
            }
        });
    }

    public void Q0(final boolean z16) {
        R0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.y
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.L0(z16);
            }
        });
    }

    public void S0(int i3) {
        this.D = i3;
    }

    public void T0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.C = feedCloudMeta$StFeed;
    }

    public void U0(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.f82613m = cVar;
    }

    public void V0(final int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && !list.isEmpty()) {
            int i16 = 0;
            QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(0);
            if (qFSCommentItemInfo.replyItemList.size() > i3 && qFSCommentItemInfo.replyItemList.get(i3).type == 7) {
                Iterator<QFSReplyItemInfo> it = qFSCommentItemInfo.replyItemList.iterator();
                final int i17 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    QFSReplyItemInfo next = it.next();
                    if (i16 < this.E) {
                        i16++;
                    } else if (next.type == 7) {
                        next.type = 6;
                        next.moreNum = x0(qFSCommentItemInfo.comment) - (qFSCommentItemInfo.replyItemList.size() - 1);
                        break;
                    } else {
                        it.remove();
                        i17++;
                    }
                }
                final int i18 = i16 + 1;
                QLog.d("QFSCommentItemBlock", 1, "[showLessReply] replyPos: " + i3 + "startRemoveIdx: " + i18 + "itemCount: " + i17);
                R0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        ac.this.N0(i3, i18, i17);
                    }
                });
            }
        }
    }

    public void W0(View view, int i3, boolean z16) {
        int min;
        List<E> list = this.mDataList;
        if (list != 0 && !list.isEmpty()) {
            QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(0);
            if (qFSCommentItemInfo.replyItemList.size() > i3 && qFSCommentItemInfo.replyItemList.get(i3).type == 6) {
                int i16 = F;
                if (i3 >= i16) {
                    min = Math.min(G, qFSCommentItemInfo.replyItemList.get(i3).moreNum);
                } else {
                    min = Math.min(i16 - i3, qFSCommentItemInfo.replyItemList.get(i3).moreNum);
                }
                List<QFSReplyItemInfo> w06 = w0(qFSCommentItemInfo, min);
                QFSReplyItemInfo qFSReplyItemInfo = qFSCommentItemInfo.replyItemList.get(qFSCommentItemInfo.replyItemList.size() - 1);
                if (!z16 && (w06.isEmpty() || w06.size() < min)) {
                    qFSReplyItemInfo.type = 8;
                    QFSReplyExtraBean qFSReplyExtraBean = new QFSReplyExtraBean(qFSCommentItemInfo, qFSReplyItemInfo, i3);
                    qFSReplyExtraBean.setView(view);
                    com.tencent.biz.qqcircle.comment.h.G().L(hashCode(), this.C, qFSCommentItemInfo.comment, qFSReplyExtraBean);
                    return;
                }
                z0(qFSCommentItemInfo, qFSReplyItemInfo, w06, i3);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSReplyListEvent.class);
        arrayList.add(QCircleCommentPraiseUpdateEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getFixedViewTypeOffset() {
        return 200000;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list == 0 || list.isEmpty()) {
            return 0;
        }
        QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(0);
        List<QFSReplyItemInfo> list2 = qFSCommentItemInfo.replyItemList;
        if (list2 == null || list2.isEmpty()) {
            return 1;
        }
        return 1 + qFSCommentItemInfo.replyItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return v0(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        int i16;
        if (i3 >= getItemCount()) {
            return super.getItemViewType(i3);
        }
        if (i3 == 0) {
            if (!RFSafeListUtils.isEmpty(this.mDataList) && D0((QFSCommentItemInfo) this.mDataList.get(0))) {
                return 9;
            }
            if (!RFSafeListUtils.isEmpty(this.mDataList) && E0((QFSCommentItemInfo) this.mDataList.get(0))) {
                return 10;
            }
            if (!RFSafeListUtils.isEmpty(this.mDataList) && C0((QFSCommentItemInfo) this.mDataList.get(0))) {
                return 3;
            }
            if (!RFSafeListUtils.isEmpty(this.mDataList) && ((QFSCommentItemInfo) this.mDataList.get(0)).type != 0) {
                return ((QFSCommentItemInfo) this.mDataList.get(0)).type;
            }
            return 4;
        }
        List<E> list = this.mDataList;
        if (list != 0 && !list.isEmpty() && !RFSafeListUtils.isEmpty(((QFSCommentItemInfo) this.mDataList.get(0)).replyItemList) && i3 - 1 < ((QFSCommentItemInfo) this.mDataList.get(0)).replyItemList.size()) {
            return ((QFSCommentItemInfo) this.mDataList.get(0)).replyItemList.get(i16).type;
        }
        return super.getItemViewType(i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 100;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && !list.isEmpty()) {
            QFSCommentItemInfo qFSCommentItemInfo = (QFSCommentItemInfo) this.mDataList.get(0);
            if (viewHolder instanceof i20.a) {
                ((i20.a) viewHolder).l(u0(i3), qFSCommentItemInfo, this.C);
                return;
            }
            if (viewHolder instanceof i20.b) {
                ((i20.b) viewHolder).m(u0(i3), this.C, qFSCommentItemInfo, this.f82613m, false);
                return;
            }
            if (viewHolder instanceof i20.d) {
                ((i20.d) viewHolder).l(i3, this.C, qFSCommentItemInfo, this.f82613m);
                return;
            }
            if (viewHolder instanceof i20.c) {
                ((i20.c) viewHolder).l(i3, this.C, qFSCommentItemInfo, this.f82613m);
                return;
            }
            if (viewHolder instanceof i20.f) {
                ((i20.f) viewHolder).l(i3, this.C, qFSCommentItemInfo, this.f82613m);
                return;
            }
            if (viewHolder instanceof i20.g) {
                int i16 = i3 - 1;
                ((i20.g) viewHolder).l(qFSCommentItemInfo.replyItemList.get(i16), this.C, i16, qFSCommentItemInfo.comment, this.D, this.f82613m);
            } else if (viewHolder instanceof i20.h) {
                int i17 = i3 - 1;
                ((i20.h) viewHolder).l(qFSCommentItemInfo.replyItemList.get(i17), this.C, i17, qFSCommentItemInfo.comment, this.D, new a(i17));
            } else if (viewHolder instanceof i20.e) {
                ((i20.e) viewHolder).l(this.C);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 9) {
            QFSCommentAdDescItemView qFSCommentAdDescItemView = new QFSCommentAdDescItemView(viewGroup.getContext());
            qFSCommentAdDescItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return new i20.a(qFSCommentAdDescItemView);
        }
        if (i3 == 2) {
            QFSFastCommentItemView qFSFastCommentItemView = new QFSFastCommentItemView(viewGroup.getContext());
            qFSFastCommentItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            qFSFastCommentItemView.setReportBean(getReportBean());
            qFSFastCommentItemView.setVisibility(8);
            return new i20.c(qFSFastCommentItemView);
        }
        if (i3 == 3) {
            QFSCommentShareAdItemView qFSCommentShareAdItemView = new QFSCommentShareAdItemView(viewGroup.getContext());
            qFSCommentShareAdItemView.setReportBean(getReportBean());
            return new i20.f(qFSCommentShareAdItemView);
        }
        if (i3 == 4) {
            QFSCommentDefaultItemView qFSCommentDefaultItemView = new QFSCommentDefaultItemView(viewGroup.getContext());
            qFSCommentDefaultItemView.setReportBean(getReportBean());
            return new i20.b(qFSCommentDefaultItemView, viewGroup);
        }
        if (i3 == 5) {
            QFSReplyItemView qFSReplyItemView = new QFSReplyItemView(viewGroup.getContext());
            qFSReplyItemView.setParentView(viewGroup);
            qFSReplyItemView.setReportBean(this.mReportBean);
            return new i20.g(qFSReplyItemView, viewGroup);
        }
        if (i3 != 6 && i3 != 8 && i3 != 7) {
            if (i3 == 10) {
                QFSCommentFeedbackItemView qFSCommentFeedbackItemView = new QFSCommentFeedbackItemView(viewGroup.getContext());
                qFSCommentFeedbackItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                return new i20.e(qFSCommentFeedbackItemView);
            }
            QFSCommentDefaultItemView qFSCommentDefaultItemView2 = new QFSCommentDefaultItemView(viewGroup.getContext());
            qFSCommentDefaultItemView2.setReportBean(getReportBean());
            return new i20.b(qFSCommentDefaultItemView2, viewGroup);
        }
        QFSMoreReplyItemView qFSMoreReplyItemView = new QFSMoreReplyItemView(viewGroup.getContext());
        qFSMoreReplyItemView.setParentView(viewGroup);
        return new i20.h(qFSMoreReplyItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSReplyListEvent) {
            A0((QFSReplyListEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleCommentPraiseUpdateEvent) {
            B0((QCircleCommentPraiseUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List<QFSCommentItemInfo> list) {
        if (!RFSafeListUtils.isEmpty(list) && list.get(0).comment != null) {
            this.E = list.get(0).comment.vecReply.size();
        }
        super.setDatas(list);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements com.tencent.biz.qqcircle.widgets.comment.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f82614d;

        a(int i3) {
            this.f82614d = i3;
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.c
        public void onClick(View view, int i3, int i16, Object obj) {
            if (fb0.a.a("_loadMoreReply")) {
                QLog.d("QFSCommentItemBlock", 1, "_loadMoreReply");
                return;
            }
            if (i3 == 10) {
                ac.this.q0();
                ac.this.W0(view, this.f82614d, false);
            } else if (i3 == 11) {
                ac.this.V0(this.f82614d);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.c
        public void onLongClick(View view, int i3, int i16, Object obj) {
        }
    }
}
