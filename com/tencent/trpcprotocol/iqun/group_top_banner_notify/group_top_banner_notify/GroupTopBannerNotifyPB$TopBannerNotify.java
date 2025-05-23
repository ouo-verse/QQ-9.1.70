package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$TopBannerNotify extends MessageMicro<GroupTopBannerNotifyPB$TopBannerNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"biz_type", "msg_id"}, new Object[]{0, ByteStringMicro.EMPTY}, GroupTopBannerNotifyPB$TopBannerNotify.class);
    public final PBUInt32Field biz_type = PBField.initUInt32(0);
    public final PBBytesField msg_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
