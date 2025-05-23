package com.tencent.trpcprotocol.qqstranger.official_assistant.official_assistant;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class OfficialAssistant$Message extends MessageMicro<OfficialAssistant$Message> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"msg_id", RemoteMessageConst.MSGTYPE, "msg_body", AlbumCacheData.CREATE_TIME, QCircleSchemeAttr.CoverFeed.SOURCE_TYPE}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0L, 0}, OfficialAssistant$Message.class);
    public final PBUInt64Field msg_id = PBField.initUInt64(0);
    public final PBEnumField message_type = PBField.initEnum(0);
    public final PBBytesField msg_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBInt32Field source_type = PBField.initInt32(0);
}
