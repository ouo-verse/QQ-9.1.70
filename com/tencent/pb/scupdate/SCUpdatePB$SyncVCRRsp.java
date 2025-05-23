package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tenpay.sdk.util.JSONConstant;

/* loaded from: classes22.dex */
public final class SCUpdatePB$SyncVCRRsp extends MessageMicro<SCUpdatePB$SyncVCRRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 56}, new String[]{"seq", "vcr_list", JSONConstant.KEY_CONTINUE_FLAG, "preload", "report", "sync_switch", "environment"}, new Object[]{0L, null, 0, null, null, 0, 0}, SCUpdatePB$SyncVCRRsp.class);
    public final PBInt64Field seq = PBField.initInt64(0);
    public final PBRepeatMessageField<SCUpdatePB$VCR> vcr_list = PBField.initRepeatMessage(SCUpdatePB$VCR.class);
    public final PBInt32Field continue_flag = PBField.initInt32(0);
    public SCUpdatePB$SCPreload preload = new SCUpdatePB$SCPreload();
    public SCUpdatePB$SCReport report = new SCUpdatePB$SCReport();
    public final PBUInt32Field sync_switch = PBField.initUInt32(0);
    public final PBUInt32Field environment = PBField.initUInt32(0);
}
