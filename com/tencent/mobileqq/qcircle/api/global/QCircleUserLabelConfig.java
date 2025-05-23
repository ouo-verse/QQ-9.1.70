package com.tencent.mobileqq.qcircle.api.global;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import qqcircle.QQCircleEnvHub$GetUserFullEnvRsp;
import qqcircle.QQCircleEnvHub$UserInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleUserLabelConfig {
    public static final QCircleUserLabelConfig INSTANCE = new QCircleUserLabelConfig();
    private static final String TAG = "com.tencent.mobileqq.qcircle.api.global.QCircleUserLabelConfig";
    private boolean canPublishCommentExpression;
    private String commentExpressionText;
    private int mLabel;
    private boolean canShowGifEmoji = false;
    private boolean isEDaxia = false;

    QCircleUserLabelConfig() {
    }

    public boolean getCanPublishEmoji() {
        if (this.canPublishCommentExpression && QzoneConfig.enableUserPublishEmoji()) {
            return true;
        }
        return false;
    }

    public boolean getCanShowGifEmoji() {
        return this.canShowGifEmoji;
    }

    public String getCommentExpressionText() {
        return this.commentExpressionText;
    }

    public boolean getIsEDaxia() {
        return this.isEDaxia;
    }

    public int getLabel() {
        return this.mLabel;
    }

    public void setIsEDaxia(boolean z16) {
        this.isEDaxia = z16;
    }

    public void updateLabel(QQCircleEnvHub$GetUserFullEnvRsp qQCircleEnvHub$GetUserFullEnvRsp) {
        QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo;
        if (qQCircleEnvHub$GetUserFullEnvRsp != null && (qQCircleEnvHub$UserInfo = qQCircleEnvHub$GetUserFullEnvRsp.userInfo) != null) {
            QQCircleEnvHub$UserInfo qQCircleEnvHub$UserInfo2 = qQCircleEnvHub$UserInfo.get();
            this.mLabel = qQCircleEnvHub$UserInfo2.isFunnyKing.get() ? 1 : 0;
            String str = TAG;
            QLog.d(str, 4, "set user label value: " + this.mLabel);
            this.canPublishCommentExpression = qQCircleEnvHub$UserInfo2.canPublishCommentExpression.get();
            QLog.d(str, 4, "can user publish emoji: " + this.canPublishCommentExpression);
            this.canShowGifEmoji = qQCircleEnvHub$UserInfo2.canPublishGIFExpression.get();
            QLog.d(str, 4, "can user publish gif emoji: " + this.canShowGifEmoji);
            this.commentExpressionText = qQCircleEnvHub$UserInfo2.commentExpressionText.get();
            QLog.d(str, 4, "commentExpressionText: " + this.commentExpressionText);
            this.isEDaxia = false;
            return;
        }
        QLog.w(TAG, 1, "userFullEnvRsp is null or userInfo is null");
    }
}
