package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class QFSCommentPublishFeedAttrBean {
    public static final String COMMENT_PIC_PUBLISH_TYPE = "comment_pic";
    private static final String IMAGE_PUBLISH_TYPE = "image";
    private static final String TAG = "QFSCommentPublishFeedAttrBean";
    private static final String VIDEO_PUBLISH_TYPE = "video";
    public String coverPath;
    public String draftId;
    public String feedId;
    public int postType;
    public String publishContent;
    public int publishType;
    public String taskId;

    public static QFSCommentPublishFeedAttrBean getAttrBean(Map<String, String> map) {
        QFSCommentPublishFeedAttrBean qFSCommentPublishFeedAttrBean = new QFSCommentPublishFeedAttrBean();
        if (map != null && !map.isEmpty()) {
            try {
                qFSCommentPublishFeedAttrBean.draftId = map.get(QCircleScheme.AttrQQPublish.COMMENT_DRAFT_ID);
                qFSCommentPublishFeedAttrBean.feedId = map.get(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_ID);
                qFSCommentPublishFeedAttrBean.taskId = map.get(QQWinkConstants.WINK_PUBLISH_PARAM_TASK_ID);
                qFSCommentPublishFeedAttrBean.publishContent = map.get(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT);
                qFSCommentPublishFeedAttrBean.coverPath = map.get(QQWinkConstants.WINK_PUBLISH_PARAM_COVER_PATH);
                String str = map.get(QQWinkConstants.WINK_PUBLISH_TYPE);
                if (TextUtils.equals("image", str)) {
                    qFSCommentPublishFeedAttrBean.publishType = 2;
                } else if (TextUtils.equals("video", str)) {
                    qFSCommentPublishFeedAttrBean.publishType = 3;
                }
                String str2 = map.get(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        qFSCommentPublishFeedAttrBean.postType = Integer.parseInt(str2);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "postType parse fail e:" + e16.toString());
                    }
                }
            } catch (Exception e17) {
                QLog.e(TAG, 1, "attr parse fail e:" + e17.toString());
            }
        }
        return qFSCommentPublishFeedAttrBean;
    }

    @NotNull
    public String toString() {
        return "QFSCommentPublishFeedAttrBean{draftId='" + this.draftId + "', feedId='" + this.feedId + "', taskId=" + this.taskId + ", publishContent='" + this.publishContent + "', publishType='" + this.publishType + "', postType=" + this.postType + '}';
    }
}
