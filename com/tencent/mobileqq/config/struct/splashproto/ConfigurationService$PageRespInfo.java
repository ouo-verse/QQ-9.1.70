package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;

/* loaded from: classes10.dex */
public final class ConfigurationService$PageRespInfo extends MessageMicro<ConfigurationService$PageRespInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 64, 74}, new String[]{"task_id", "version", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "total_size", "page_size", "md5", "report", "next_offset", "cookies"}, new Object[]{0, 0, 0, 0, 0, "", 0, -1, ByteStringMicro.EMPTY}, ConfigurationService$PageRespInfo.class);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field compress = PBField.initUInt32(0);
    public final PBUInt32Field total_size = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBStringField md5 = PBField.initString("");
    public final PBUInt32Field report = PBField.initUInt32(0);
    public final PBInt32Field next_offset = PBField.initInt32(-1);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
}
