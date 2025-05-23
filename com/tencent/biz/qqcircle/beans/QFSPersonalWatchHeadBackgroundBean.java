package com.tencent.biz.qqcircle.beans;

import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase$HeaderInfo;

/* loaded from: classes4.dex */
public class QFSPersonalWatchHeadBackgroundBean extends QCircleInitBean {
    private static final String TAG = "QFSPersonalWatchHeadBackgroundBean";
    private transient QQCircleFeedBase$HeaderInfo mCacheHeadInfo;
    private byte[] mHeaderInfoArray;

    public QFSPersonalWatchHeadBackgroundBean(QQCircleFeedBase$HeaderInfo qQCircleFeedBase$HeaderInfo) {
        this.mHeaderInfoArray = qQCircleFeedBase$HeaderInfo.toByteArray();
    }

    public QQCircleFeedBase$HeaderInfo getHeaderInfo() {
        QQCircleFeedBase$HeaderInfo qQCircleFeedBase$HeaderInfo = this.mCacheHeadInfo;
        if (qQCircleFeedBase$HeaderInfo != null && qQCircleFeedBase$HeaderInfo.has()) {
            return this.mCacheHeadInfo;
        }
        QQCircleFeedBase$HeaderInfo qQCircleFeedBase$HeaderInfo2 = new QQCircleFeedBase$HeaderInfo();
        try {
            qQCircleFeedBase$HeaderInfo2.mergeFrom(this.mHeaderInfoArray);
            this.mCacheHeadInfo = qQCircleFeedBase$HeaderInfo2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getHeaderInfo exception", e16.toString());
        }
        return qQCircleFeedBase$HeaderInfo2;
    }
}
