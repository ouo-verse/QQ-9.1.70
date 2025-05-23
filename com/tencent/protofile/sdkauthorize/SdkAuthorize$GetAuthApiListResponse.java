package com.tencent.protofile.sdkauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.appType$AuthItem;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkAuthorize$GetAuthApiListResponse extends MessageMicro<SdkAuthorize$GetAuthApiListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 64, 72, 82, 90}, new String[]{"ret", "msg", "oauth_host_nick", "oauth_host_uin", "oauth_app_name", "oauth_portrait_url", "authorized_form_list", "key_type", "redirect_time", "auth_response", "AuthorizedUnionText"}, new Object[]{0, "", "", 0L, "", "", null, 0, 0, null, ""}, SdkAuthorize$GetAuthApiListResponse.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342210msg = PBField.initString("");
    public final PBStringField oauth_host_nick = PBField.initString("");
    public final PBInt64Field oauth_host_uin = PBField.initInt64(0);
    public final PBStringField oauth_app_name = PBField.initString("");
    public final PBStringField oauth_portrait_url = PBField.initString("");
    public final PBRepeatMessageField<appType$AuthItem> authorized_form_list = PBField.initRepeatMessage(appType$AuthItem.class);
    public final PBUInt32Field key_type = PBField.initUInt32(0);
    public final PBUInt32Field redirect_time = PBField.initUInt32(0);
    public SdkAuthorize$AuthorizeResponse auth_response = new SdkAuthorize$AuthorizeResponse();
    public final PBStringField AuthorizedUnionText = PBField.initString("");
}
