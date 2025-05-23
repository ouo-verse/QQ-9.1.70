package com.tencent.protofile.navigatebar;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMsgBox$GetGroupEventsRsp extends MessageMicro<TroopMsgBox$GetGroupEventsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "groups"}, new Object[]{0L, ByteStringMicro.EMPTY, null}, TroopMsgBox$GetGroupEventsRsp.class);
    public final PBUInt64Field err_code = PBField.initUInt64(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<TroopMsgBox$Group> groups = PBField.initRepeatMessage(TroopMsgBox$Group.class);
}
