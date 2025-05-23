package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class oidb_0xdea$GetBarrageListReqBody extends MessageMicro<oidb_0xdea$GetBarrageListReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"uint64_group_code", "uint64_barrage_seq", "uint32_last_update_time", "uint32_start_index", "uint32_barrage_count", "uint32_video_start_time", "uint32_video_end_time", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "terminal"}, new Object[]{0L, 0L, 0, 0, 0, 0, 0, 1, 0}, oidb_0xdea$GetBarrageListReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_barrage_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_barrage_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_end_time = PBField.initUInt32(0);
    public final PBEnumField entrance = PBField.initEnum(1);
    public final PBEnumField terminal = PBField.initEnum(0);
}
