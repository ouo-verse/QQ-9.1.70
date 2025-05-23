package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes23.dex */
public final class AssistedChatPB$GradeReq extends MessageMicro<AssistedChatPB$GradeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"peer_user", "scene", "result", "dialogs"}, new Object[]{null, 0, 0, null}, AssistedChatPB$GradeReq.class);
    public AssistedChatPB$PeerUser peer_user = new AssistedChatPB$PeerUser();
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBRepeatMessageField<AssistedChatPB$Dialog> dialogs = PBField.initRepeatMessage(AssistedChatPB$Dialog.class);
}
