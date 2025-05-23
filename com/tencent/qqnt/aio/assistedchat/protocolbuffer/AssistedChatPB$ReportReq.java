package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes23.dex */
public final class AssistedChatPB$ReportReq extends MessageMicro<AssistedChatPB$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"peer_user", "scene", "report_event", "festival_id"}, new Object[]{null, 0, 0, 0}, AssistedChatPB$ReportReq.class);
    public AssistedChatPB$PeerUser peer_user = new AssistedChatPB$PeerUser();
    public final PBEnumField scene = PBField.initEnum(0);
    public final PBEnumField report_event = PBField.initEnum(0);
    public final PBUInt32Field festival_id = PBField.initUInt32(0);
}
