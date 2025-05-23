package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes23.dex */
public final class AssistedChatPB$Dialog extends MessageMicro<AssistedChatPB$Dialog> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"from", "context"}, new Object[]{0, null}, AssistedChatPB$Dialog.class);
    public final PBEnumField from = PBField.initEnum(0);
    public AssistedChatPB$Recommend context = new AssistedChatPB$Recommend();
}
