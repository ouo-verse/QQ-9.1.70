package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$OrderUIData extends MessageMicro<ECQshopSampleSvr$OrderUIData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public ECQshopSampleSvr$ShowInfo show_info = new ECQshopSampleSvr$ShowInfo();
    public final PBBoolField allow_cancel_order = PBField.initBool(false);
    public final PBBoolField allow_sign_confirm = PBField.initBool(false);
    public final PBBoolField allow_logistics_detail = PBField.initBool(false);
    public final PBBoolField allow_fulfil_detail = PBField.initBool(false);
    public final PBBoolField allow_abort_order = PBField.initBool(false);
    public final PBBoolField allow_add_window = PBField.initBool(false);
    public final PBBoolField allow_in_window = PBField.initBool(false);
    public final PBBoolField allow_cancel_abort = PBField.initBool(false);
    public final PBBoolField allow_modify_address = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"show_info", "allow_cancel_order", "allow_sign_confirm", "allow_logistics_detail", "allow_fulfil_detail", "allow_abort_order", "allow_add_window", "allow_in_window", "allow_cancel_abort", "allow_modify_address"}, new Object[]{null, bool, bool, bool, bool, bool, bool, bool, bool, bool}, ECQshopSampleSvr$OrderUIData.class);
    }
}
