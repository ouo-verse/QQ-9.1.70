package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ServerApi$RspUpdateDownCountRecmd extends MessageMicro<ServerApi$RspUpdateDownCountRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"err_info", "download_num"}, new Object[]{null, 0}, ServerApi$RspUpdateDownCountRecmd.class);
    public ServerApi$ErrorInfo err_info = new ServerApi$ErrorInfo();
    public final PBUInt32Field download_num = PBField.initUInt32(0);
}
