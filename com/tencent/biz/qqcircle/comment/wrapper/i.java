package com.tencent.biz.qqcircle.comment.wrapper;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeedAbstract;
import feedcloud.FeedCloudMeta$StReply;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends QFSCommentBaseFeedView<QFSReplyItemInfo> {

    /* renamed from: u, reason: collision with root package name */
    private FeedCloudMeta$StComment f84153u;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i iVar = i.this;
            T t16 = iVar.f84073b;
            if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null && ((QFSReplyItemInfo) t16).reply.replyFeed != null) {
                if (iVar.f84153u == null) {
                    QLog.e(i.this.v(), 1, "[onClick] mComment == null");
                } else {
                    String str = ((QFSReplyItemInfo) i.this.f84073b).reply.f398460id.get();
                    if (QFSCommentHelper.c0(str)) {
                        QLog.e(i.this.v(), 1, "[onClick] fake reply");
                        i.this.w();
                    } else {
                        FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract = ((QFSReplyItemInfo) i.this.f84073b).reply.replyFeed.get();
                        i iVar2 = i.this;
                        QCircleLayerBean u16 = iVar2.u(feedCloudMeta$StFeedAbstract, iVar2.f84075d, iVar2.f84153u.f398447id.get(), str);
                        if (u16 != null) {
                            com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), u16);
                        }
                    }
                }
            } else {
                QLog.e(iVar.v(), 1, "[onClick] replyFeed == null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public i(@NonNull @NotNull View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public String s(QFSReplyItemInfo qFSReplyItemInfo) {
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        if (qFSReplyItemInfo != null && (feedCloudMeta$StReply = qFSReplyItemInfo.reply) != null) {
            return feedCloudMeta$StReply.f398460id.get();
        }
        return null;
    }

    public void S(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.f84153u = feedCloudMeta$StComment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected void m() {
        View view = this.f84072a;
        if (view != null && view.getContext() != null) {
            if (this.f84075d == null) {
                QLog.e(v(), 1, "[deleteCommentOrReply] mFeed == null");
                return;
            }
            if (this.f84153u == null) {
                QLog.e(v(), 1, "[deleteCommentOrReply] mComment == null");
                return;
            }
            T t16 = this.f84073b;
            if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null) {
                QLog.d(v(), 1, "[deleteCommentOrReply] fakeId:" + s((QFSReplyItemInfo) this.f84073b));
                com.tencent.biz.qqcircle.comment.h.G().u(this.f84072a.getContext().hashCode(), this.f84075d, this.f84153u, ((QFSReplyItemInfo) this.f84073b).reply, 0, true);
                return;
            }
            QLog.e(v(), 1, "[deleteCommentOrReply] reply == null");
            return;
        }
        QLog.e(v(), 1, "[deleteCommentOrReply] context == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected FeedCloudMeta$StFeedAbstract q() {
        T t16 = this.f84073b;
        if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null && ((QFSReplyItemInfo) t16).reply.replyFeed != null && ((QFSReplyItemInfo) t16).reply.replyFeed.has()) {
            return ((QFSReplyItemInfo) this.f84073b).reply.replyFeed.get();
        }
        return null;
    }

    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected View.OnClickListener t() {
        if (this.f84090s == null) {
            this.f84090s = new a();
        }
        return this.f84090s;
    }

    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected String v() {
        return "QFSReplyFeedView";
    }
}
