package com.tencent.biz.qqcircle.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.QFSMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QFSReplyItemView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentReplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private FeedCloudMeta$StComment C;
    private List<QFSReplyItemInfo> D;
    private QCircleReportBean E;
    private com.tencent.biz.qqcircle.widgets.comment.c F;
    private int G;
    private RecyclerView H;

    /* renamed from: m, reason: collision with root package name */
    private FeedCloudMeta$StFeed f82598m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a extends RecyclerView.ViewHolder {
        a(BaseWidgetView baseWidgetView) {
            super(baseWidgetView);
        }

        public void l(QFSReplyItemInfo qFSReplyItemInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3, int i16, com.tencent.biz.qqcircle.widgets.comment.c cVar) {
            View view = this.itemView;
            if (view instanceof QFSReplyItemView) {
                ((QFSReplyItemView) view).setPreData(feedCloudMeta$StFeed, feedCloudMeta$StComment, i3);
                ((QFSReplyItemView) this.itemView).setOnCommentElementClickListener(cVar);
                ((QFSReplyItemView) this.itemView).bindData(qFSReplyItemInfo, i16);
            } else if (view instanceof QFSMoreReplyItemView) {
                ((QFSMoreReplyItemView) view).setPreData(feedCloudMeta$StFeed, feedCloudMeta$StComment, i3);
                ((QFSMoreReplyItemView) this.itemView).setOnCommentElementClickListener(cVar);
                ((QFSMoreReplyItemView) this.itemView).bindData(qFSReplyItemInfo, i16);
            }
        }
    }

    public QFSCommentReplyAdapter() {
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(final int i3, final Runnable runnable) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.H) != null) {
            if (recyclerView.isComputingLayout()) {
                this.H.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter.6
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSCommentReplyAdapter.this.q0(i3 - 1, runnable);
                    }
                }, 20L);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        RFWLog.i("QFSCommentReplyAdapter", RFWLog.USR, "safeNotify return count = " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<QFSReplyItemInfo> list = this.D;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        List<QFSReplyItemInfo> list = this.D;
        if (list != null && list.size() > i3) {
            return this.D.get(i3).type;
        }
        return 0;
    }

    public void k0(final View view, final QFSReplyItemInfo qFSReplyItemInfo, final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                int i17;
                String str;
                try {
                    FeedCloudMeta$StReply feedCloudMeta$StReply = qFSReplyItemInfo.reply;
                    if (feedCloudMeta$StReply == null) {
                        return;
                    }
                    Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                    buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                    int i18 = 0;
                    if (feedCloudMeta$StReply.typeFlag2.get() == 4) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_BURN, Integer.valueOf(i16));
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_ID, feedCloudMeta$StReply.f398460id.get());
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_LIKE_NUM, Integer.valueOf(feedCloudMeta$StReply.likeInfo.count.get()));
                    buildElementParams.put("xsj_target_qq", feedCloudMeta$StReply.postUser.f398463id.get());
                    if (QFSCommentReplyAdapter.this.f82598m != null && QFSCommentReplyAdapter.this.f82598m.poster != null) {
                        buildElementParams.put("xsj_feed_id", QFSCommentReplyAdapter.this.f82598m.f398449id.get());
                        if (QFSCommentReplyAdapter.this.f82598m.poster != null) {
                            str = QFSCommentReplyAdapter.this.f82598m.poster.f398463id.get();
                        } else {
                            str = "";
                        }
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, str);
                    }
                    buildElementParams.put("xsj_index", Integer.valueOf(i3 + 1));
                    if (feedCloudMeta$StReply.postUser.label.get() == 1) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COMMENT_IF_GENGWANG, Integer.valueOf(i17));
                    if (feedCloudMeta$StReply.postUser.is_e_da_xia.get()) {
                        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USR_LOGO, QCircleDaTongConstant.ElementParamValue.XSJ_QQ_HERO);
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_REPLY, 1);
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_TYPE, QFSCommentReportHelper.p(feedCloudMeta$StReply));
                    if (feedCloudMeta$StReply.expressionInfo.expression_src.get() == 10002) {
                        i18 = 1;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_COMMENT_ASSOCIATE_EMOJI, Integer.valueOf(i18));
                    VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_COMMENT);
                    VideoReport.setElementReuseIdentifier(view, feedCloudMeta$StReply.f398460id.get());
                    VideoReport.setElementParams(view, buildElementParams);
                    VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                    VideoReport.reportEvent("imp", view, null);
                } catch (Exception e16) {
                    QLog.e("QFSCommentReplyAdapter", 1, e16.getMessage(), e16);
                }
            }
        });
    }

    public List<QFSReplyItemInfo> l0() {
        return this.D;
    }

    public void m0() {
        q0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentReplyAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public void n0(final int i3) {
        q0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentReplyAdapter.this.notifyItemChanged(i3);
            }
        });
    }

    public void o0(final int i3, final int i16) {
        q0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentReplyAdapter.this.notifyItemRangeInserted(i3, i16);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.H = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<QFSReplyItemInfo> list = this.D;
        if (list != null && list.size() > i3) {
            ((a) viewHolder).l(this.D.get(i3), this.f82598m, this.C, this.G, i3, this.F);
            k0(viewHolder.itemView, this.D.get(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 5) {
            QFSReplyItemView qFSReplyItemView = new QFSReplyItemView(viewGroup.getContext());
            qFSReplyItemView.setParentView(viewGroup);
            qFSReplyItemView.setReportBean(this.E);
            return new a(qFSReplyItemView);
        }
        QFSMoreReplyItemView qFSMoreReplyItemView = new QFSMoreReplyItemView(viewGroup.getContext());
        qFSMoreReplyItemView.setParentView(viewGroup);
        return new a(qFSMoreReplyItemView);
    }

    public void p0(final int i3, final int i16) {
        q0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.QFSCommentReplyAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                QFSCommentReplyAdapter.this.notifyItemRangeRemoved(i3, i16);
            }
        });
    }

    public void r0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, List<QFSReplyItemInfo> list, int i3) {
        this.f82598m = feedCloudMeta$StFeed;
        this.C = feedCloudMeta$StComment;
        this.D = list;
        this.G = i3;
    }

    public void s0(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.F = cVar;
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.E = qCircleReportBean;
    }
}
