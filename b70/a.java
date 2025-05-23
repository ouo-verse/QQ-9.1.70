package b70;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import cooperation.qqcircle.report.QCircleReportBean;
import e30.b;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static QFSCommentInfo a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleReportBean qCircleReportBean, QCircleExtraTypeInfo qCircleExtraTypeInfo, int i3, boolean z16) {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = new b(feedCloudMeta$StFeed);
        qFSCommentInfo.mFeed = feedCloudMeta$StFeed;
        qFSCommentInfo.mReportBean = qCircleReportBean;
        qFSCommentInfo.mRelocationScrollType = 100;
        qFSCommentInfo.mExtraTypeInfo = qCircleExtraTypeInfo;
        qCircleExtraTypeInfo.mDataPosition = i3;
        qFSCommentInfo.mIsShowEmotion = z16;
        return qFSCommentInfo;
    }
}
