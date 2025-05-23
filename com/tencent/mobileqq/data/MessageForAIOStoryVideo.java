package com.tencent.mobileqq.data;

import NS_QQ_STORY_META.META$StImage;
import NS_QQ_STORY_META.META$StStoryFeed;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForAIOStoryVideo extends ChatMessage {
    public static final String MSG_STORY_FEED_CREATE_TIME = "createtime";
    public static final String MSG_STORY_FEED_KEY_COVER = "cover";
    public static final String MSG_STORY_FEED_KEY_DESC = "desc";
    public static final String TAG = "MessageForAIOStoryVideo";
    public String text = "";
    public String cover = "";
    public long createtime = 0;
    public META$StStoryFeed mStStoryFeed = new META$StStoryFeed();

    public MessageForAIOStoryVideo() {
        this.msgtype = MessageRecord.MSG_TYPE_AIO_FOR_STORY_VIDEO;
        this.mNeedTimeStamp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        try {
            if (!TextUtils.isEmpty(this.f203106msg)) {
                byte[] decode = Base64.decode(this.f203106msg, 0);
                META$StStoryFeed mETA$StStoryFeed = this.mStStoryFeed;
                if (mETA$StStoryFeed != null) {
                    mETA$StStoryFeed.mergeFrom(decode);
                    META$StImage mETA$StImage = this.mStStoryFeed.coverImage;
                    if (mETA$StImage != null) {
                        this.cover = mETA$StImage.url.get();
                    }
                    this.createtime = this.mStStoryFeed.createTime.get();
                }
            }
        } catch (Exception unused) {
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, "doParseForMessageForAIOStoryVideo:" + this.f203106msg);
            }
        }
    }
}
