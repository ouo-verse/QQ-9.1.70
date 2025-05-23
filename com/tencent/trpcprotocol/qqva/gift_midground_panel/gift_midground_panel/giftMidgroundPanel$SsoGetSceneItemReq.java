package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SsoGetSceneItemReq extends MessageMicro<giftMidgroundPanel$SsoGetSceneItemReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 42}, new String[]{"business_id", "id", VRReportDefine$ReportParam.SCENE_TYPE, "persionalise_info"}, new Object[]{"", "", 0, null}, giftMidgroundPanel$SsoGetSceneItemReq.class);
    public final PBStringField business_id = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381628id = PBField.initString("");
    public final PBEnumField scene_type = PBField.initEnum(0);
    public giftMidgroundPanel$Personalise persionalise_info = new giftMidgroundPanel$Personalise();
}
