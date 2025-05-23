package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderInfo$DeviceInfo extends MessageMicro<ECOrderInfo$DeviceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 80, 90, 162, 170, 242, 250, 802}, new String[]{"app_version", "os", "device_id", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "qimei36", "network", "ip", "terminal_id", AudienceReportConst.TERMINAL_TYPE, "manufacturer", "device_brand_and_model", "ext"}, new Object[]{"", 0, "", "", "", 0, "", "", "", "", "", null}, ECOrderInfo$DeviceInfo.class);
    public final PBStringField app_version = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBInt32Field f105240os = PBField.initInt32(0);
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField qimei = PBField.initString("");
    public final PBStringField qimei36 = PBField.initString("");
    public final PBInt32Field network = PBField.initInt32(0);

    /* renamed from: ip, reason: collision with root package name */
    public final PBStringField f105239ip = PBField.initString("");
    public final PBStringField terminal_id = PBField.initString("");
    public final PBStringField terminal_type = PBField.initString("");
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField device_brand_and_model = PBField.initString("");
    public final PBRepeatMessageField<ECOrderInfo$Entry> ext = PBField.initRepeatMessage(ECOrderInfo$Entry.class);
}
