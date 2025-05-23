package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* loaded from: classes22.dex */
public final class GetPromotePage$GetLoginPromotePageRsp extends MessageMicro<GetPromotePage$GetLoginPromotePageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"result", "appid", "promote_info", SessionDbHelper.SESSION_ID, "signature"}, new Object[]{null, 0L, null, null, ByteStringMicro.EMPTY}, GetPromotePage$GetLoginPromotePageRsp.class);
    public OpenSdkRecCommon$Result result = new OpenSdkRecCommon$Result();
    public final PBInt64Field appid = PBField.initInt64(0);
    public OpenSdkRecCommon$PromoteInfo promote_info = new OpenSdkRecCommon$PromoteInfo();
    public OpenSdkRecCommon$Session session = new OpenSdkRecCommon$Session();
    public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
}
