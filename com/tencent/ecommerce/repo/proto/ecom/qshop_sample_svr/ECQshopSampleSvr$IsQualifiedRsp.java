package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$IsQualifiedRsp extends MessageMicro<ECQshopSampleSvr$IsQualifiedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"qualified", "toast", "token"}, new Object[]{Boolean.FALSE, null, ""}, ECQshopSampleSvr$IsQualifiedRsp.class);
    public final PBBoolField qualified = PBField.initBool(false);
    public ECQshopSampleSvr$Toast toast = new MessageMicro<ECQshopSampleSvr$Toast>() { // from class: com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr.ECQshopSampleSvr$Toast
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"toast_title", "toast_text", "ref_link"}, new Object[]{"", "", ""}, ECQshopSampleSvr$Toast.class);
        public final PBStringField toast_title = PBField.initString("");
        public final PBStringField toast_text = PBField.initString("");
        public final PBStringField ref_link = PBField.initString("");
    };
    public final PBStringField token = PBField.initString("");
}
