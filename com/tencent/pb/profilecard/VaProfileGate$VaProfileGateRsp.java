package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$VaProfileGateRsp extends MessageMicro<VaProfileGate$VaProfileGateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 106, 114, 122, 130, 138}, new String[]{"iRetCode", "sRetMsg", "stPrivilegeRsp", "stGiftRsp", "rpt_task_item", "rpt_oidb_flag", "st_vip_care", "lhLogoLv", "qid_info", "qq_value", "splendid_info", "gxh_using", "card_info", "get_clm_tip_rsp", "privilege_show_rsp", "big_vip_badge_item", "vip_medal_item"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null}, VaProfileGate$VaProfileGateRsp.class);
    public final PBInt32Field iRetCode = PBField.initInt32(0);
    public final PBBytesField sRetMsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public VaProfileGate$PrivilegeBaseInfoRsp stPrivilegeRsp = new VaProfileGate$PrivilegeBaseInfoRsp();
    public VaProfileGate$GetGiftListRsp stGiftRsp = new VaProfileGate$GetGiftListRsp();
    public final PBRepeatMessageField<VaProfileGate$CommTaskInfo> rpt_task_item = PBField.initRepeatMessage(VaProfileGate$CommTaskInfo.class);
    public final PBRepeatMessageField<VaProfileGate$OidbFlagInfo> rpt_oidb_flag = PBField.initRepeatMessage(VaProfileGate$OidbFlagInfo.class);
    public VaProfileGate$GetVipCareRsp st_vip_care = new MessageMicro<VaProfileGate$GetVipCareRsp>() { // from class: com.tencent.pb.profilecard.VaProfileGate$GetVipCareRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_buss", "uint32_notice"}, new Object[]{0, 0}, VaProfileGate$GetVipCareRsp.class);
        public final PBUInt32Field uint32_buss = PBField.initUInt32(0);
        public final PBUInt32Field uint32_notice = PBField.initUInt32(0);
    };
    public final PBInt32Field lhLogoLv = PBField.initInt32(0);
    public VaProfileGate$QidInfoItem qid_info = new VaProfileGate$QidInfoItem();
    public VaProfileGate$QQValueInfoItem qq_value = new VaProfileGate$QQValueInfoItem();
    public VaProfileGate$GetSplendidRsp splendid_info = new VaProfileGate$GetSplendidRsp();
    public VaProfileGate$GetGxhUsingRsp gxh_using = new VaProfileGate$GetGxhUsingRsp();
    public VaProfileGate$GetCardRsp card_info = new VaProfileGate$GetCardRsp();
    public VaProfileGate$GetClmTipRsp get_clm_tip_rsp = new VaProfileGate$GetClmTipRsp();
    public VaProfileGate$PrivilegeShowRsp privilege_show_rsp = new VaProfileGate$PrivilegeShowRsp();
    public VaProfileGate$BigVipBadgeItem big_vip_badge_item = new VaProfileGate$BigVipBadgeItem();
    public VaProfileGate$VipMedalItem vip_medal_item = new VaProfileGate$VipMedalItem();
}
