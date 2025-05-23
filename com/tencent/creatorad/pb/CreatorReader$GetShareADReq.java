package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tenpay.sdk.util.QWSoterConstans;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class CreatorReader$GetShareADReq extends MessageMicro<CreatorReader$GetShareADReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "tickets", "user_info", "device_info", "client_mod"}, new Object[]{0, "", null, null, ""}, CreatorReader$GetShareADReq.class);
    public final PBEnumField busi_type = PBField.initEnum(0);
    public final PBRepeatField<String> tickets = PBField.initRepeat(PBStringField.__repeatHelper__);
    public qq_ad_get.QQAdGet.UserInfo user_info = new qq_ad_get.QQAdGet.UserInfo();
    public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
    public final PBStringField client_mod = PBField.initString("");
}
