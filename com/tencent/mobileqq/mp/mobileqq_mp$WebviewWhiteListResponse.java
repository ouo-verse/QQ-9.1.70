package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$WebviewWhiteListResponse extends MessageMicro<mobileqq_mp$WebviewWhiteListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"ret_info", "version", "data", "gziped_data"}, new Object[]{null, "", "", ByteStringMicro.EMPTY}, mobileqq_mp$WebviewWhiteListResponse.class);
    public RetInfo ret_info = new RetInfo();
    public final PBStringField version = PBField.initString("");
    public final PBStringField data = PBField.initString("");
    public final PBBytesField gziped_data = PBField.initBytes(ByteStringMicro.EMPTY);

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class RetInfo extends MessageMicro<RetInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_info"}, new Object[]{0, ""}, RetInfo.class);
        public final PBUInt32Field ret_code = PBField.initUInt32(0);
        public final PBStringField err_info = PBField.initString("");
    }
}
