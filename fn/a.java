package fn;

import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.tencent.richframework.data.idata.IDataConverter;
import qzonemoment.QZMomentMeta$StFeed;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements IDataConverter<QZMFeedCommentInfo> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QZMFeedCommentInfo cloneConvertData(QZMFeedCommentInfo qZMFeedCommentInfo) {
        return new QZMFeedCommentInfo(qZMFeedCommentInfo.mFeed, qZMFeedCommentInfo.mTotalCommentCount);
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(QZMFeedCommentInfo qZMFeedCommentInfo) {
        QZMomentMeta$StFeed qZMomentMeta$StFeed;
        if (qZMFeedCommentInfo != null && (qZMomentMeta$StFeed = qZMFeedCommentInfo.mFeed) != null) {
            return qZMomentMeta$StFeed.f430362id.get();
        }
        return "";
    }

    private void d(QZMFeedCommentInfo qZMFeedCommentInfo, QZMFeedCommentInfo qZMFeedCommentInfo2) {
        if (qZMFeedCommentInfo == null || qZMFeedCommentInfo2 == null) {
            return;
        }
        qZMFeedCommentInfo.mTotalCommentCount = qZMFeedCommentInfo2.mTotalCommentCount;
        qZMFeedCommentInfo.mPermissionText = qZMFeedCommentInfo2.mPermissionText;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(QZMFeedCommentInfo qZMFeedCommentInfo, QZMFeedCommentInfo qZMFeedCommentInfo2) {
        if (qZMFeedCommentInfo == null || qZMFeedCommentInfo2 == null) {
            return;
        }
        d(qZMFeedCommentInfo, qZMFeedCommentInfo2);
    }
}
