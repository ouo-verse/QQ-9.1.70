package com.tencent.pb.signature;

import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class SigActPb$ReqBody extends MessageMicro<SigActPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{"cmd", "seq", "plf", "req", "auth_req", "source"}, new Object[]{0, 0L, null, null, null, 0}, SigActPb$ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public SigActPb$Platform plf = new SigActPb$Platform();
    public SigActPb$SigactReq req = new MessageMicro<SigActPb$SigactReq>() { // from class: com.tencent.pb.signature.SigActPb$SigactReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin_disable", AdParam.ACTID, "acttype"}, new Object[]{0L, 0, 0}, SigActPb$SigactReq.class);
        public final PBUInt64Field uin_disable = PBField.initUInt64(0);
        public final PBInt32Field actid = PBField.initInt32(0);
        public final PBInt32Field acttype = PBField.initInt32(0);
    };
    public SigActPb$SigauthReq auth_req = new SigActPb$SigauthReq();
    public final PBUInt32Field source = PBField.initUInt32(0);
}
