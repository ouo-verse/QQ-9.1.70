package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class PendantMarket$TipsInfo extends MessageMicro<PendantMarket$TipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 72, 82}, new String[]{"valid", "ret", "type", "title_wording", "wording", "right_btn_wording", "left_btn_wording", AppConstants.VIPKey.KEY_FOR_VIP_TYPE, "vip_month", "url"}, new Object[]{Boolean.FALSE, 0, 0, "", "", "", "", "", 0, ""}, PendantMarket$TipsInfo.class);
    public final PBBoolField valid = PBField.initBool(false);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField title_wording = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
    public final PBStringField right_btn_wording = PBField.initString("");
    public final PBStringField left_btn_wording = PBField.initString("");
    public final PBStringField vip_type = PBField.initString("");
    public final PBUInt32Field vip_month = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
}
