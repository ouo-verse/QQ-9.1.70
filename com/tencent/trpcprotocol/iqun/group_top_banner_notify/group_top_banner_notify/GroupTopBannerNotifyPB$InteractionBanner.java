package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$InteractionBanner extends MessageMicro<GroupTopBannerNotifyPB$InteractionBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 88, 98, 162}, new String[]{"is_multi", "url", QCircleAlphaUserReporter.KEY_USER, "single_group_text", "multi_group_text"}, new Object[]{Boolean.FALSE, "", 0L, "", ""}, GroupTopBannerNotifyPB$InteractionBanner.class);
    public final PBBoolField is_multi = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBUInt64Field user = PBField.initUInt64(0);
    public final PBStringField single_group_text = PBField.initString("");
    public final PBStringField multi_group_text = PBField.initString("");
}
