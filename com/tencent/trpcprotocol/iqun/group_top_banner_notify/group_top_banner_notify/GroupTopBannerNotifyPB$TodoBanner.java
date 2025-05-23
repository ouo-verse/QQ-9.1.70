package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$TodoBanner extends MessageMicro<GroupTopBannerNotifyPB$TodoBanner> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField red_text = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBBoolField is_exposure = PBField.initBool(false);
    public final PBBoolField is_complete = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40}, new String[]{"red_text", "text", "url", "is_exposure", "is_complete"}, new Object[]{"", "", "", bool, bool}, GroupTopBannerNotifyPB$TodoBanner.class);
    }
}
