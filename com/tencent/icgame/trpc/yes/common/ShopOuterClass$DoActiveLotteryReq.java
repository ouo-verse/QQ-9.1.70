package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$DoActiveLotteryReq extends MessageMicro<ShopOuterClass$DoActiveLotteryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"active_id", "lottery_id", "game_role_info", VRReportDefine$ReportParam.SCENE_TYPE}, new Object[]{0, 0, null, 0}, ShopOuterClass$DoActiveLotteryReq.class);
    public final PBInt32Field active_id = PBField.initInt32(0);
    public final PBInt32Field lottery_id = PBField.initInt32(0);
    public GameDataServerOuterClass$GameRoleId game_role_info = new GameDataServerOuterClass$GameRoleId();
    public final PBEnumField scene_type = PBField.initEnum(0);
}
