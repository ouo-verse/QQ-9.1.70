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
public final class TroopMsgBox$GetRsp extends MessageMicro<TroopMsgBox$GetRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie;
    public final PBUInt64Field err_code = PBField.initUInt64(0);
    public final PBBytesField err_msg;
    public final PBRepeatMessageField<TroopMsgBox$GroupEvent> group_events;

    static {
        String[] strArr = {CheckForwardServlet.KEY_ERR_CODE, "err_msg", "group_events", "cookie"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, strArr, new Object[]{0L, byteStringMicro, null, byteStringMicro}, TroopMsgBox$GetRsp.class);
    }

    public TroopMsgBox$GetRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.err_msg = PBField.initBytes(byteStringMicro);
        this.group_events = PBField.initRepeatMessage(TroopMsgBox$GroupEvent.class);
        this.cookie = PBField.initBytes(byteStringMicro);
    }
}
