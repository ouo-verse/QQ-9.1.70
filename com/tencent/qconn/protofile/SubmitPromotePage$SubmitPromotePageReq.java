package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* loaded from: classes22.dex */
public final class SubmitPromotePage$SubmitPromotePageReq extends MessageMicro<SubmitPromotePage$SubmitPromotePageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"app", "login_sig", "version", "source", "proxy_req", SessionDbHelper.SESSION_ID, "signature", "submit_result"}, new Object[]{null, null, null, null, null, null, ByteStringMicro.EMPTY, null}, SubmitPromotePage$SubmitPromotePageReq.class);
    public OpenSdkRecCommon$AppReqInfo app = new OpenSdkRecCommon$AppReqInfo();
    public appType$LoginSig login_sig = new appType$LoginSig();
    public OpenSdkRecCommon$VersionInfo version = new OpenSdkRecCommon$VersionInfo();
    public OpenSdkRecCommon$LoginSourceInfo source = new OpenSdkRecCommon$LoginSourceInfo();
    public OpenSdkRecCommon$ProxyRequest proxy_req = new OpenSdkRecCommon$ProxyRequest();
    public OpenSdkRecCommon$Session session = new OpenSdkRecCommon$Session();
    public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<SubmitPromotePage$SubmitResultItem> submit_result = PBField.initRepeatMessage(SubmitPromotePage$SubmitResultItem.class);
}
