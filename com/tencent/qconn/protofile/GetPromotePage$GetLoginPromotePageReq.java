package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* loaded from: classes22.dex */
public final class GetPromotePage$GetLoginPromotePageReq extends MessageMicro<GetPromotePage$GetLoginPromotePageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"app", "login_sig", "version", "source", "proxy_req", SessionDbHelper.SESSION_ID, "user_trait"}, new Object[]{null, null, null, null, null, null, null}, GetPromotePage$GetLoginPromotePageReq.class);
    public OpenSdkRecCommon$AppReqInfo app = new OpenSdkRecCommon$AppReqInfo();
    public appType$LoginSig login_sig = new appType$LoginSig();
    public OpenSdkRecCommon$VersionInfo version = new OpenSdkRecCommon$VersionInfo();
    public OpenSdkRecCommon$LoginSourceInfo source = new OpenSdkRecCommon$LoginSourceInfo();
    public OpenSdkRecCommon$ProxyRequest proxy_req = new OpenSdkRecCommon$ProxyRequest();
    public OpenSdkRecCommon$Session session = new OpenSdkRecCommon$Session();
    public OpenSdkRecCommon$UserTraitInfo user_trait = new OpenSdkRecCommon$UserTraitInfo();
}
