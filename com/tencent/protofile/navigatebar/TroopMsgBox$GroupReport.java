package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$GroupReport extends MessageMicro<TroopMsgBox$GroupReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"group_id", "msg_seq", CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0L, 0L, 0L, ByteStringMicro.EMPTY}, TroopMsgBox$GroupReport.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field err_code = PBField.initUInt64(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
