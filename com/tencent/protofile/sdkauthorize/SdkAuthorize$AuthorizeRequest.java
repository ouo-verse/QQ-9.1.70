package com.tencent.protofile.sdkauthorize;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qconn.protofile.appType$LoginSig;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkAuthorize$AuthorizeRequest extends MessageMicro<SdkAuthorize$AuthorizeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 122, 128, 138, 144, 152, 160, 170, 178, 522, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, new String[]{CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE, CommonConstant.ReqAccessTokenParam.CLIENT_ID, "openapi", AdParam.PF, "need_pay", "sign", "sdkv", "sdkp", "time", "qqv", "os", "passData", "skey", "vkey", "sid", "app_type", "appUniqueIdentifier", ISchemeApi.KEY_REFERER, "vID", "needUniversalLink", "bundleid_from_app", "universal_link_from_app", "login_sig", "url_encoded_data"}, new Object[]{"", 0L, 0, "", 0, "", "", "", 0L, "", "", "", "", "", "", 0, "", 1, 0L, Boolean.FALSE, "", "", null, ""}, SdkAuthorize$AuthorizeRequest.class);
    public final PBStringField response_type = PBField.initString("");
    public final PBInt64Field client_id = PBField.initInt64(0);
    public final PBRepeatField<Integer> openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342205pf = PBField.initString("");
    public final PBSInt32Field need_pay = PBField.initSInt32(0);
    public final PBStringField sign = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBStringField qqv = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342204os = PBField.initString("");
    public final PBStringField passData = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBStringField vkey = PBField.initString("");
    public final PBStringField sid = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBUInt64Field vID = PBField.initUInt64(0);
    public final PBBoolField needUniversalLink = PBField.initBool(false);
    public final PBStringField bundleid_from_app = PBField.initString("");
    public final PBStringField universal_link_from_app = PBField.initString("");
    public appType$LoginSig login_sig = new appType$LoginSig();
    public final PBStringField url_encoded_data = PBField.initString("");
}
