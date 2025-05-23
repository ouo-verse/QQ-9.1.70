package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.QWSoterConstans;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$GetCreatorADReq extends MessageMicro<CreatorReader$GetCreatorADReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 42, 50, 56, 66}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "user_info", "device_info", "client_mod", "creative_ids", "job_ids", "ids"}, new Object[]{0, null, null, "", "", 0L, null}, CreatorReader$GetCreatorADReq.class);
    public final PBEnumField busi_type = PBField.initEnum(0);
    public qq_ad_get.QQAdGet.UserInfo user_info = new qq_ad_get.QQAdGet.UserInfo();
    public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
    public final PBStringField client_mod = PBField.initString("");
    public final PBRepeatField<String> creative_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Long> job_ids = PBField.initRepeat(PBInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<CreatorReader$IDInfo> ids = PBField.initRepeatMessage(CreatorReader$IDInfo.class);
}
