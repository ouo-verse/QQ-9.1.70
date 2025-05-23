package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$VaProfileGateReq extends MessageMicro<VaProfileGate$VaProfileGateReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uCmd", "stPrivilegeReq", "stGiftReq", "rpt_task_item", "rpt_oidb_flag", "st_vip_care", "qqvalue_ext_info", "get_clm_tip_req"}, new Object[]{0, null, null, null, null, null, null, null}, VaProfileGate$VaProfileGateReq.class);
    public final PBUInt32Field uCmd = PBField.initUInt32(0);
    public VaProfileGate$PrivilegeBaseInfoReq stPrivilegeReq = new VaProfileGate$PrivilegeBaseInfoReq();
    public VaProfileGate$GetGiftListReq stGiftReq = new VaProfileGate$GetGiftListReq();
    public final PBRepeatMessageField<VaProfileGate$CommTaskInfo> rpt_task_item = PBField.initRepeatMessage(VaProfileGate$CommTaskInfo.class);
    public final PBRepeatMessageField<VaProfileGate$OidbFlagInfo> rpt_oidb_flag = PBField.initRepeatMessage(VaProfileGate$OidbFlagInfo.class);
    public VaProfileGate$GetVipCareReq st_vip_care = new MessageMicro<VaProfileGate$GetVipCareReq>() { // from class: com.tencent.pb.profilecard.VaProfileGate$GetVipCareReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_uin"}, new Object[]{0L}, VaProfileGate$GetVipCareReq.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    };
    public final PBRepeatMessageField<VaProfileGate$QQValueExtInfo> qqvalue_ext_info = PBField.initRepeatMessage(VaProfileGate$QQValueExtInfo.class);
    public VaProfileGate$GetClmTipReq get_clm_tip_req = new VaProfileGate$GetClmTipReq();
}
