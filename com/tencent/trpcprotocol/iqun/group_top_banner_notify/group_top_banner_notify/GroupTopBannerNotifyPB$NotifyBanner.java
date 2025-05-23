package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$NotifyBanner extends MessageMicro<GroupTopBannerNotifyPB$NotifyBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text", "url"}, new Object[]{"", ""}, GroupTopBannerNotifyPB$NotifyBanner.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
