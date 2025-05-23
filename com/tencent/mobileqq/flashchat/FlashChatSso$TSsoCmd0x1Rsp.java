package com.tencent.mobileqq.flashchat;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class FlashChatSso$TSsoCmd0x1Rsp extends MessageMicro<FlashChatSso$TSsoCmd0x1Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{null}, FlashChatSso$TSsoCmd0x1Rsp.class);
    public final PBRepeatMessageField<FlashChatSso$TItem> item = PBField.initRepeatMessage(FlashChatSso$TItem.class);
}
