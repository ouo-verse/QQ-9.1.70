package com.tencent.protofile.sdkauthorize;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qconn.protofile.appType$LoginSig;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkAuthorize$GetAuthApiListRequest extends MessageMicro<SdkAuthorize$GetAuthApiListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74, 80, 90, 96, 106, 112, 522, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "scope", AdParam.PF, "sign", "sdkv", "sdkp", "time", "qqv", "os", "need_pay", "skey", "app_type", "appUniqueIdentifier", ISchemeApi.KEY_REFERER, "login_sig", "url_encoded_data"}, new Object[]{0L, "", "", "", "", "", 0L, "", "", 0, "", 0, "", 1, null, ""}, SdkAuthorize$GetAuthApiListRequest.class);
    public final PBInt64Field client_id = PBField.initInt64(0);
    public final PBStringField scope = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342209pf = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBInt64Field time = PBField.initInt64(0);
    public final PBStringField qqv = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342208os = PBField.initString("");
    public final PBSInt32Field need_pay = PBField.initSInt32(0);
    public final PBStringField skey = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public appType$LoginSig login_sig = new appType$LoginSig();
    public final PBStringField url_encoded_data = PBField.initString("");
}
