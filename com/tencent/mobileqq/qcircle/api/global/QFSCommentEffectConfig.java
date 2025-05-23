package com.tencent.mobileqq.qcircle.api.global;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import qqcircle.QQCircleEnvHub$CommentEffectInfo;
import uq3.k;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSCommentEffectConfig {
    private static final String TAG = "QFSCommentEffectConfig";
    private static QQCircleEnvHub$CommentEffectInfo sCommentEffectInfo;

    public static QQCircleEnvHub$CommentEffectInfo getCommentEffectInfo() {
        byte[] d16;
        if (sCommentEffectInfo == null && (d16 = k.b().d(TAG, null)) != null) {
            QQCircleEnvHub$CommentEffectInfo qQCircleEnvHub$CommentEffectInfo = new QQCircleEnvHub$CommentEffectInfo();
            sCommentEffectInfo = qQCircleEnvHub$CommentEffectInfo;
            try {
                qQCircleEnvHub$CommentEffectInfo.mergeFrom(d16);
            } catch (Exception e16) {
                RFWLog.d(TAG, RFWLog.USR, "getCommentEffectInfo:", e16);
            }
        }
        return sCommentEffectInfo;
    }

    public static void saveCommentEffectInfo(QQCircleEnvHub$CommentEffectInfo qQCircleEnvHub$CommentEffectInfo) {
        if (sCommentEffectInfo == null) {
            sCommentEffectInfo = qQCircleEnvHub$CommentEffectInfo;
            RFWLog.d(TAG, RFWLog.USR, "saveCommentEffectInfo");
            k.b().k(TAG, qQCircleEnvHub$CommentEffectInfo.toByteArray());
        }
    }
}
