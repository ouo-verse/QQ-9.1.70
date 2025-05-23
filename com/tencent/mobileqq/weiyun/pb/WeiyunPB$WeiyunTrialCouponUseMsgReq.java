package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes20.dex */
public final class WeiyunPB$WeiyunTrialCouponUseMsgReq extends MessageMicro<WeiyunPB$WeiyunTrialCouponUseMsgReq> {
    public static final int BUSINESS_ID_FIELD_NUMBER = 10;
    public static final int FILE_ITEM_FIELD_NUMBER = 50;
    public static final int USE_NUM_FIELD_NUMBER = 20;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 160, 402}, new String[]{"business_id", "use_num", "file_item"}, new Object[]{"", 1, null}, WeiyunPB$WeiyunTrialCouponUseMsgReq.class);
    public final PBStringField business_id = PBField.initString("");
    public final PBInt32Field use_num = PBField.initInt32(1);
    public WeiyunPB$FileItem file_item = new WeiyunPB$FileItem();
}
