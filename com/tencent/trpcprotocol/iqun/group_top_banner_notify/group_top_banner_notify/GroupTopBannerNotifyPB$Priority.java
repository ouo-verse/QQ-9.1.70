package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$Priority extends MessageMicro<GroupTopBannerNotifyPB$Priority> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{PictureConst.KEY_CATEGORY_TYPE, "priority"}, new Object[]{0, 0}, GroupTopBannerNotifyPB$Priority.class);
    public final PBUInt32Field category_type = PBField.initUInt32(0);
    public final PBUInt32Field priority = PBField.initUInt32(0);
}
