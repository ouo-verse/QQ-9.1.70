package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$QueryTopBannerInfoReq extends MessageMicro<GroupTopBannerNotifyPB$QueryTopBannerInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"biz_type", "msg_id", "group_id"}, new Object[]{0, ByteStringMicro.EMPTY, 0L}, GroupTopBannerNotifyPB$QueryTopBannerInfoReq.class);
    public final PBUInt32Field biz_type = PBField.initUInt32(0);
    public final PBBytesField msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
}
