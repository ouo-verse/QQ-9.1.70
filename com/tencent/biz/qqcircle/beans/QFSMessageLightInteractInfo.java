package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StLightInteractInfo;
import qqcircle.QQCircleFeedBase$StUnifiedTagPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageLightInteractInfo {
    public static final int ITEM_TYPE_PUSH_CARD = -300;
    public static final int ITEM_TYPE_PUSH_MORE = -100;
    public static final int ITEM_TYPE_SPILT_LINE = -1000;
    public static final int ITEM_TYPE_TOP_FANS_REMINDER_NUM = -200;
    private String mFansReminderNum;
    private FeedCloudMeta$StLightInteractInfo mStLightInteractInfo;
    private QQCircleFeedBase$StUnifiedTagPageData mStUnifiedTagPageData;
    private int mType;

    public QFSMessageLightInteractInfo(int i3) {
        this.mType = i3;
    }

    public static QFSMessageLightInteractInfo obtainDivider() {
        return new QFSMessageLightInteractInfo(-1000);
    }

    public static QFSMessageLightInteractInfo obtainFansReminder(String str) {
        QFSMessageLightInteractInfo qFSMessageLightInteractInfo = new QFSMessageLightInteractInfo(-200);
        qFSMessageLightInteractInfo.setFansReminderNum(str);
        return qFSMessageLightInteractInfo;
    }

    public String getFansReminderNum() {
        return this.mFansReminderNum;
    }

    public FeedCloudMeta$StLightInteractInfo getStLightInteractInfo() {
        return this.mStLightInteractInfo;
    }

    public QQCircleFeedBase$StUnifiedTagPageData getStUnifiedTagPageData() {
        return this.mStUnifiedTagPageData;
    }

    public int getType() {
        return this.mType;
    }

    public void setFansReminderNum(String str) {
        this.mFansReminderNum = str;
    }

    public void setStLightInteractInfo(FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo) {
        this.mStLightInteractInfo = feedCloudMeta$StLightInteractInfo;
    }

    public void setStUnifiedTagPageData(QQCircleFeedBase$StUnifiedTagPageData qQCircleFeedBase$StUnifiedTagPageData) {
        this.mStUnifiedTagPageData = qQCircleFeedBase$StUnifiedTagPageData;
    }
}
