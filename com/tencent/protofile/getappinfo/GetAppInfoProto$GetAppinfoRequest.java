package com.tencent.protofile.getappinfo;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qconn.protofile.appType$LoginSig;

/* loaded from: classes22.dex */
public final class GetAppInfoProto$GetAppinfoRequest extends MessageMicro<GetAppInfoProto$GetAppinfoRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 514, 522}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "sdkp", "icons", "qqv", "os", "md5time", "signature", "need_ads", "app_type", "channel_source", ISchemeApi.KEY_REFERER, "appUniqueIdentifier", "skey", "login_sig"}, new Object[]{0L, "", "", "", "", 0L, "", 0, 0, 0L, 1, "", "", null}, GetAppInfoProto$GetAppinfoRequest.class);
    public final PBInt64Field client_id = PBField.initInt64(0);
    public final PBStringField sdkp = PBField.initString("");
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField qqv = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342196os = PBField.initString("");
    public final PBInt64Field md5time = PBField.initInt64(0);
    public final PBStringField signature = PBField.initString("");
    public final PBSInt32Field need_ads = PBField.initSInt32(0);
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBInt64Field channel_source = PBField.initInt64(0);
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public appType$LoginSig login_sig = new appType$LoginSig();
}
