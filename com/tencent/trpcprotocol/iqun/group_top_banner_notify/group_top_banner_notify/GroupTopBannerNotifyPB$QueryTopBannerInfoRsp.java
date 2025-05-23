package com.tencent.trpcprotocol.iqun.group_top_banner_notify.group_top_banner_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class GroupTopBannerNotifyPB$QueryTopBannerInfoRsp extends MessageMicro<GroupTopBannerNotifyPB$QueryTopBannerInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field biz_type = PBField.initUInt32(0);
    public final PBUInt32Field banner_type = PBField.initUInt32(0);
    public final PBBoolField is_disappear = PBField.initBool(false);
    public final PBBoolField need_callback = PBField.initBool(false);
    public GroupTopBannerNotifyPB$GameTeamUpBanner team_up_banner = new GroupTopBannerNotifyPB$GameTeamUpBanner();
    public GroupTopBannerNotifyPB$TodoBanner to_do_banner = new GroupTopBannerNotifyPB$TodoBanner();
    public GroupTopBannerNotifyPB$InteractionBanner interaction_banner = new GroupTopBannerNotifyPB$InteractionBanner();
    public GroupTopBannerNotifyPB$NotifyBanner notify_banner = new GroupTopBannerNotifyPB$NotifyBanner();
    public GroupTopBannerNotifyPB$Priority banner_priority = new GroupTopBannerNotifyPB$Priority();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 90, 98, 106, 114, 322}, new String[]{"biz_type", "banner_type", "is_disappear", "need_callback", "team_up_banner", "to_do_banner", "interaction_banner", "notify_banner", "banner_priority"}, new Object[]{0, 0, bool, bool, null, null, null, null, null}, GroupTopBannerNotifyPB$QueryTopBannerInfoRsp.class);
    }
}
