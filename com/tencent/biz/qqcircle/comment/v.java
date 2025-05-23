package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedDraftBean;
import com.tencent.biz.qqcircle.beans.QFSFeedCommentInfo;
import com.tencent.biz.qqcircle.utils.QFSCommentHelper;
import com.tencent.biz.qqcircle.widgets.QCirclePublishCallbackHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.biz.qqcircle.widgets.a f83980a;

    /* renamed from: b, reason: collision with root package name */
    private Context f83981b;

    /* renamed from: c, reason: collision with root package name */
    private QCircleInitBean f83982c;

    public v(Context context, QCircleInitBean qCircleInitBean) {
        this.f83981b = context;
        this.f83982c = qCircleInitBean;
    }

    private String b() {
        return "QFSCommentPublishFeedManager";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NotNull TaskInfo taskInfo, String str, long j3) {
        int hashCode;
        int hashCode2;
        Bundle transParams = taskInfo.getTransParams();
        if (transParams == null) {
            QLog.e(b(), 1, "[handlePublishFeedSuccess] transBundle == null");
            return;
        }
        String string = transParams.getString(QCircleScheme.AttrQQPublish.COMMENT_DRAFT_ID, "");
        QLog.d(b(), 1, "[handlePublishFeedSuccess] draftId = " + string);
        QFSCommentPublishFeedDraftBean N = QFSCommentHelper.L().N(string);
        QFSCommentHelper.L().t();
        if (N == null) {
            QLog.e(b(), 1, "[handlePublishFeedSuccess] draftBean == null");
            return;
        }
        QFSFeedCommentInfo feedCommentInfo = N.getFeedCommentInfo();
        if (feedCommentInfo == null) {
            QLog.e(b(), 1, "[handlePublishFeedSuccess] commentInfo == null");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = feedCommentInfo.mFeed;
        if (feedCloudMeta$StFeed == null) {
            QLog.e(b(), 1, "[handlePublishFeedSuccess] targetFeed == null");
            return;
        }
        if (N.getPostType() == 1) {
            FeedCloudMeta$StComment fakeComment = N.getFakeComment();
            if (fakeComment == null) {
                QLog.e(b(), 1, "[handlePublishFeedSuccess] fakeComment == null");
                return;
            }
            if (QFSCommentHelper.L().W(fakeComment.f398447id.get())) {
                QLog.e(b(), 1, "[handlePublishFeedSuccess] has send");
                return;
            }
            QFSCommentHelper.L().n(fakeComment.f398447id.get());
            fakeComment.commentFeed.f398450id.set(str);
            fakeComment.commentFeed.createTime.set(j3);
            if (!fakeComment.commentFeed.poster.has()) {
                fakeComment.commentFeed.poster.set(QCirclePluginGlobalInfo.m());
            }
            h G = h.G();
            Context context = this.f83981b;
            if (context == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = context.hashCode();
            }
            G.o(hashCode2, feedCloudMeta$StFeed, fakeComment, true, true, this.f83982c);
            return;
        }
        if (N.getPostType() == 2 || N.getPostType() == 3) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = feedCommentInfo.mComment;
            if (feedCloudMeta$StComment == null) {
                QLog.e(b(), 1, "[handlePublishFeedSuccess] targetComment == null");
                return;
            }
            FeedCloudMeta$StReply fakeReply = N.getFakeReply();
            if (fakeReply == null) {
                QLog.e(b(), 1, "[handlePublishFeedSuccess] fakeReply == null");
                return;
            }
            if (QFSCommentHelper.L().W(fakeReply.f398460id.get())) {
                QLog.e(b(), 1, "[handlePublishFeedSuccess] has send");
                return;
            }
            QFSCommentHelper.L().n(fakeReply.f398460id.get());
            fakeReply.replyFeed.f398450id.set(str);
            fakeReply.replyFeed.createTime.set(j3);
            if (!fakeReply.replyFeed.poster.has()) {
                fakeReply.replyFeed.poster.set(QCirclePluginGlobalInfo.m());
            }
            h G2 = h.G();
            Context context2 = this.f83981b;
            if (context2 == null) {
                hashCode = 0;
            } else {
                hashCode = context2.hashCode();
            }
            G2.m(hashCode, feedCloudMeta$StFeed, feedCloudMeta$StComment, fakeReply, true, this.f83982c);
        }
    }

    public void d() {
        if (this.f83980a == null) {
            this.f83980a = new a();
        }
        QCirclePublishCallbackHelper.f93064a.i(this.f83980a, true);
    }

    public void e() {
        com.tencent.biz.qqcircle.widgets.a aVar = this.f83980a;
        if (aVar != null) {
            QCirclePublishCallbackHelper.f93064a.v(aVar);
        }
        this.f83981b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends com.tencent.biz.qqcircle.widgets.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onTaskStateChanged(@NotNull TaskInfo taskInfo) {
            if (taskInfo.isFinish() && taskInfo.isSuccess()) {
                v.this.c(taskInfo, taskInfo.getFeedId(), taskInfo.getFeedTime());
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.a
        public void onProgressChanged(@NotNull TaskInfo taskInfo) {
        }
    }
}
