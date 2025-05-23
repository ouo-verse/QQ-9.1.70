package com.tencent.qconn.protofile;

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
import com.tencent.state.map.MapItemKt;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class auth$AuthRequest extends MessageMicro<auth$AuthRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 90, 98, 120, 130, 152, 160, 168, 176, 242, 248, 320, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 338, 402, 482, 522, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, new String[]{CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE, "appid", "openapi", AdParam.PF, "sdkp", "sdkv", "qqv", "os", "skey", "pass_data", "md5time", "sign", "vid", "app_type", "need_paytoken", "channel_source", "app_unique_identifier", ISchemeApi.KEY_REFERER, "need_universal_link", "bundleid_from_app", "universal_link_from_app", "proxy_auth_req", "state", "login_sig", "url_encoded_data"}, new Object[]{0, 0L, 0, "", "", "", "", "", "", "", 0L, "", 0L, 0, 0, 0L, "", 1, Boolean.FALSE, "", "", null, "", null, ""}, auth$AuthRequest.class);
    public final PBEnumField response_type = PBField.initEnum(0);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBRepeatField<Integer> openapi = PBField.initRepeat(PBUInt32Field.__repeatHelper__);

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342468pf = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342467os = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBStringField pass_data = PBField.initString("");
    public final PBInt64Field md5time = PBField.initInt64(0);
    public final PBStringField sign = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBSInt32Field need_paytoken = PBField.initSInt32(0);
    public final PBInt64Field channel_source = PBField.initInt64(0);
    public final PBStringField app_unique_identifier = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBUInt64Field vid = PBField.initUInt64(0);
    public final PBBoolField need_universal_link = PBField.initBool(false);
    public final PBStringField bundleid_from_app = PBField.initString("");
    public final PBStringField universal_link_from_app = PBField.initString("");
    public OpenSdkRecCommon$ProxyRequest proxy_auth_req = new OpenSdkRecCommon$ProxyRequest();
    public final PBStringField state = PBField.initString("");
    public appType$LoginSig login_sig = new appType$LoginSig();
    public final PBStringField url_encoded_data = PBField.initString("");
}
