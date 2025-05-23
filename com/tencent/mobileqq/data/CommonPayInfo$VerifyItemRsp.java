package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* loaded from: classes10.dex */
public final class CommonPayInfo$VerifyItemRsp extends MessageMicro<CommonPayInfo$VerifyItemRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58}, new String[]{"code", "msg", "info", "payMode", "picInfo", "monthInfo", "verifiedInfo"}, new Object[]{0, "", "", 0, null, null, ""}, CommonPayInfo$VerifyItemRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f203070msg = PBField.initString("");
    public final PBStringField info = PBField.initString("");
    public final PBEnumField payMode = PBField.initEnum(0);
    public CommonPayInfo$PicInfo picInfo = new MessageMicro<CommonPayInfo$PicInfo>() { // from class: com.tencent.mobileqq.data.CommonPayInfo$PicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74}, new String[]{"totalPrice", "itemName", "itemDesc", QZoneJsConstants.KEY_HIGH_FIVE_URL, "patternInfo", "midasCouponInfo", "settlementType", "reportExtraInfo", "reportBusiness"}, new Object[]{0, "", "", "", "", "", 0, "", ""}, CommonPayInfo$PicInfo.class);
        public final PBInt32Field totalPrice = PBField.initInt32(0);
        public final PBStringField itemName = PBField.initString("");
        public final PBStringField itemDesc = PBField.initString("");
        public final PBStringField itemUrl = PBField.initString("");
        public final PBStringField patternInfo = PBField.initString("");
        public final PBStringField midasCouponInfo = PBField.initString("");
        public final PBEnumField settlementType = PBField.initEnum(0);
        public final PBStringField reportExtraInfo = PBField.initString("");
        public final PBStringField reportBusiness = PBField.initString("");
    };
    public CommonPayInfo$MonthInfo monthInfo = new MessageMicro<CommonPayInfo$MonthInfo>() { // from class: com.tencent.mobileqq.data.CommonPayInfo$MonthInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"monthVipType", "discountType", "monthMode", "monthNum", "patternInfo", "reportExtraInfo"}, new Object[]{0, 0, 0, 0, "", ""}, CommonPayInfo$MonthInfo.class);
        public final PBEnumField monthVipType = PBField.initEnum(0);
        public final PBEnumField discountType = PBField.initEnum(0);
        public final PBEnumField monthMode = PBField.initEnum(0);
        public final PBInt32Field monthNum = PBField.initInt32(0);
        public final PBStringField patternInfo = PBField.initString("");
        public final PBStringField reportExtraInfo = PBField.initString("");
    };
    public final PBStringField verifiedInfo = PBField.initString("");
}
