package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$HasRealNameInfoRsp extends MessageMicro<ECRealNameSvr$HasRealNameInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"has_real_name_info"}, new Object[]{Boolean.FALSE}, ECRealNameSvr$HasRealNameInfoRsp.class);
    public final PBBoolField has_real_name_info = PBField.initBool(false);
}
