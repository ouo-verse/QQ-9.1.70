package com.tencent.biz.qqcircle.comment.wrapper;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeedAbstract;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends QFSCommentBaseFeedView<QFSCommentItemInfo> {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.wrapper.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class ViewOnClickListenerC0858a implements View.OnClickListener {
        ViewOnClickListenerC0858a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a aVar = a.this;
            T t16 = aVar.f84073b;
            if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null && ((QFSCommentItemInfo) t16).comment.commentFeed != null) {
                FeedCloudMeta$StFeedAbstract feedCloudMeta$StFeedAbstract = ((QFSCommentItemInfo) t16).comment.commentFeed.get();
                if (feedCloudMeta$StFeedAbstract == null) {
                    QLog.e(a.this.v(), 1, "[onClick] stFeedAbstract == null");
                } else {
                    String str = ((QFSCommentItemInfo) a.this.f84073b).comment.f398447id.get();
                    if (QFSCommentHelper.c0(str)) {
                        QLog.e(a.this.v(), 1, "[onClick] fake comment");
                        a.this.w();
                    } else {
                        a aVar2 = a.this;
                        QCircleLayerBean u16 = aVar2.u(feedCloudMeta$StFeedAbstract, aVar2.f84075d, str, "");
                        if (u16 != null) {
                            com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), u16);
                        }
                    }
                }
            } else {
                QLog.e(aVar.v(), 1, "[onClick] commentFeed == null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public a(@NonNull View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public String s(QFSCommentItemInfo qFSCommentItemInfo) {
        T t16 = this.f84073b;
        if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null) {
            return ((QFSCommentItemInfo) t16).comment.f398447id.get();
        }
        return null;
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
            T t16 = this.f84073b;
            if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null) {
                QLog.d(v(), 1, "[deleteCommentOrReply] fakeId:" + s((QFSCommentItemInfo) this.f84073b));
                com.tencent.biz.qqcircle.comment.h.G().v(this.f84072a.getContext().hashCode(), this.f84075d, ((QFSCommentItemInfo) this.f84073b).comment, 0, true);
                return;
            }
            QLog.e(v(), 1, "[deleteCommentOrReply] comment == null");
            return;
        }
        QLog.e(v(), 1, "[deleteCommentOrReply] context == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected FeedCloudMeta$StFeedAbstract q() {
        T t16 = this.f84073b;
        if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null && ((QFSCommentItemInfo) t16).comment.commentFeed != null && ((QFSCommentItemInfo) t16).comment.commentFeed.has()) {
            return ((QFSCommentItemInfo) this.f84073b).comment.commentFeed.get();
        }
        return null;
    }

    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected View.OnClickListener t() {
        if (this.f84090s == null) {
            this.f84090s = new ViewOnClickListenerC0858a();
        }
        return this.f84090s;
    }

    @Override // com.tencent.biz.qqcircle.comment.wrapper.QFSCommentBaseFeedView
    protected String v() {
        return "QFSCommentFeedView";
    }
}
