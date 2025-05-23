package com.tencent.qconn.protofile.fastauthorize;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ads.data.AdParam;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class FastAuthorize$AuthorizeRequest extends MessageMicro<FastAuthorize$AuthorizeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 42, 50, 58, 66, 74, 80, 90, 98, 106}, new String[]{"uin", CommonConstant.ReqAccessTokenParam.CLIENT_ID, AdParam.PF, "qqv", "sdkp", "skey", "vkey", "version", WadlProxyConsts.FLAGS, "os", "sid", "apk_sign"}, new Object[]{0L, 0L, "", "", "", "", "", "1.0", 0, "", "", ""}, FastAuthorize$AuthorizeRequest.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt64Field client_id = PBField.initInt64(0);

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f342472pf = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBStringField vkey = PBField.initString("");
    public final PBStringField version = PBField.initString("1.0");
    public final PBInt32Field flags = PBField.initInt32(0);

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f342471os = PBField.initString("");
    public final PBStringField sid = PBField.initString("");
    public final PBStringField apk_sign = PBField.initString("");
}
