package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$PeerUser extends MessageMicro<AssistedChatPB$PeerUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"biz_type", "peer_uid", "peer_tiny_id"}, new Object[]{0, "", 0L}, AssistedChatPB$PeerUser.class);
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBStringField peer_uid = PBField.initString("");
    public final PBUInt64Field peer_tiny_id = PBField.initUInt64(0);
}
