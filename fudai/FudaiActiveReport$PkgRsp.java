package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FudaiActiveReport$PkgRsp extends MessageMicro<FudaiActiveReport$PkgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret", "err_msg", "batch_size"}, new Object[]{0, "", 0}, FudaiActiveReport$PkgRsp.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field batch_size = PBField.initUInt32(0);
}
