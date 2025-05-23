package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SceneItem extends MessageMicro<giftMidgroundPanel$SceneItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{"id", "name", "items", VRReportDefine$ReportParam.SCENE_TYPE, "info", "scene_infos"}, new Object[]{"", "", null, 0, null, null}, giftMidgroundPanel$SceneItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381625id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<giftMidgroundPanel$TabItem> items = PBField.initRepeatMessage(giftMidgroundPanel$TabItem.class);
    public final PBEnumField scene_type = PBField.initEnum(0);
    public giftMidgroundPanel$Personalise info = new giftMidgroundPanel$Personalise();
    public final PBRepeatMessageField<giftMidgroundPanel$MapFieldEntry> scene_infos = PBField.initRepeatMessage(giftMidgroundPanel$MapFieldEntry.class);
}
