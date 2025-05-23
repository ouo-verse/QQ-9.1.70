package com.tencent.biz.subscribe.baseUI;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ExtraTypeInfo implements Serializable {
    public static final String KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO = "key_subscribe_intent_extra_type_info";
    public static final int PAGE_TYPE_H5_DEFAULT = 8000;
    public static final int PAGE_TYPE_H5_PIC_TEXT = 8001;
    public static final int PAGE_TYPE_H5_YOUZAN_DETAIL = 8002;
    public static final int PAGE_TYPE_SUBSCRIBE_FOLLOW = 7003;
    public static final int PAGE_TYPE_SUBSCRIBE_MULTI_PIC_TEXT = 7001;
    public static final int PAGE_TYPE_SUBSCRIBE_PERSONAL = 7002;
    public static final int PAGE_TYPE_SUBSCRIBE_PERSONAL_DRAFT = 7005;
    public static final int PAGE_TYPE_SUBSCRIBE_RECOMMEND = 7004;
    public static final int PAGE_TYPE_SUBSCRIBE_VIDEO = 7000;
    public static final int SOURCE_TYPE_COLOR_NOTE = 9003;
    public static final int SOURCE_TYPE_DEFAULT = 0;
    public static final int SOURCE_TYPE_FROM_MSG_TAB = 9004;
    public static final int SOURCE_TYPE_FROM_SEARCH = 9005;
    public static final int SOURCE_TYPE_IS_MINI_PROJECT = 9001;
    public static final int SOURCE_TYPE_QZONE = 9002;
    public String commentId;
    public int mDataPosition;
    public int pageType;
    public String replyId;
    public int sourceType;
    public String userId;

    public ExtraTypeInfo() {
    }

    public String getCommentId() {
        return this.commentId;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setReplyId(String str) {
        this.replyId = str;
    }

    public ExtraTypeInfo(int i3) {
        this.pageType = i3;
    }

    public ExtraTypeInfo(int i3, int i16) {
        this.pageType = i3;
        this.sourceType = i16;
    }
}
