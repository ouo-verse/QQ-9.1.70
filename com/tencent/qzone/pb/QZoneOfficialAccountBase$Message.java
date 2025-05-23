package com.tencent.qzone.pb;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$Message extends MessageMicro<QZoneOfficialAccountBase$Message> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"id", AlbumCacheData.CREATE_TIME, "inner_msg_list", RemoteMessageConst.MSGTYPE}, new Object[]{"", 0L, null, 0}, QZoneOfficialAccountBase$Message.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f364014id = PBField.initString("");
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBRepeatMessageField<QZoneOfficialAccountBase$InnerMessage> inner_msg_list = PBField.initRepeatMessage(QZoneOfficialAccountBase$InnerMessage.class);
    public final PBEnumField message_type = PBField.initEnum(0);
}
