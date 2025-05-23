package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$Content extends MessageMicro<ConfigurationService$Content> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82}, new String[]{"task_id", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "content"}, new Object[]{0, 0, ByteStringMicro.EMPTY}, ConfigurationService$Content.class);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field compress = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
}
