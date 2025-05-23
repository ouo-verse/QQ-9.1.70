package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;

/* loaded from: classes22.dex */
public final class preAuth$PreAuthRequest extends MessageMicro<preAuth$PreAuthRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 82, 90, 96, 106, 160, 168, 178, 184, 402, 522, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, new String[]{"appid", "sdkp", "sdkv", "icons", "qqv", "os", "scope", "skey", "md5time", "sign", "app_type", "channel_source", "appUniqueIdentifier", ISchemeApi.KEY_REFERER, "proxy_req", "login_sig", "url_encoded_data"}, new Object[]{0L, "", "", "", "", "", "", "", 0L, "", 0, 0L, "", 1, null, null, ""}, preAuth$PreAuthRequest.class);
    public final PBInt64Field appid = PBField.initInt64(0);
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField qqv = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342475os = PBField.initString("");
    public final PBStringField scope = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBInt64Field md5time = PBField.initInt64(0);
    public final PBStringField sign = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBInt64Field channel_source = PBField.initInt64(0);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public OpenSdkRecCommon$ProxyRequest proxy_req = new OpenSdkRecCommon$ProxyRequest();
    public appType$LoginSig login_sig = new appType$LoginSig();
    public final PBStringField url_encoded_data = PBField.initString("");
}
