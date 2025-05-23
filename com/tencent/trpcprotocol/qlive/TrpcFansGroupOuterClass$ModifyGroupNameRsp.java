package com.tencent.trpcprotocol.qlive;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class TrpcFansGroupOuterClass$ModifyGroupNameRsp extends MessageMicro<TrpcFansGroupOuterClass$ModifyGroupNameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, ""}, TrpcFansGroupOuterClass$ModifyGroupNameRsp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
}
