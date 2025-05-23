package com.tencent.mobileqq.app.richtext;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes11.dex */
public interface IRichTextAndMsgViaProvider {
    Object[] getRichTextAndMsgViaFromMessageRecord(AppInterface appInterface, MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext, int i3);
}
