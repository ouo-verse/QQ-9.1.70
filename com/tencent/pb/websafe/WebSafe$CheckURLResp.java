package com.tencent.pb.websafe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class WebSafe$CheckURLResp extends MessageMicro<WebSafe$CheckURLResp> {
    public static final int RESULT_FIELD_NUMBER = 2;
    public static final int RETCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"retcode", "result"}, new Object[]{0, 0}, WebSafe$CheckURLResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
