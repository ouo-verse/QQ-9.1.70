package com.tencent.biz.qqcircle.beans;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAvatarLayerBean extends QCircleInitBean {
    private static final String TAG = "QCircleAvatarLayerBean";
    private transient FeedCloudMeta$StUser mCacheUser;
    private boolean mNeedPreload;
    private byte[] mUser;

    public QCircleAvatarLayerBean(FeedCloudMeta$StUser feedCloudMeta$StUser, boolean z16) {
        if (feedCloudMeta$StUser != null) {
            this.mUser = feedCloudMeta$StUser.toByteArray();
        }
        this.mNeedPreload = z16;
    }

    @Override // com.tencent.biz.qqcircle.beans.QCircleInitBean
    public FeedCloudMeta$StUser getUser() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.mCacheUser;
        if (feedCloudMeta$StUser != null) {
            return feedCloudMeta$StUser;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = new FeedCloudMeta$StUser();
        try {
            byte[] bArr = this.mUser;
            if (bArr != null && bArr.length > 0) {
                feedCloudMeta$StUser2.mergeFrom(bArr);
                this.mCacheUser = feedCloudMeta$StUser2;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[getUser] error:" + e16);
        }
        return this.mCacheUser;
    }

    public boolean needPreload() {
        return this.mNeedPreload;
    }
}
