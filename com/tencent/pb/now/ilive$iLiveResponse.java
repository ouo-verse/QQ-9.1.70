package com.tencent.pb.now;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive$iLiveResponse extends MessageMicro<ilive$iLiveResponse> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField binary_body;
    public final PBUInt32Field client_type;

    /* renamed from: ex, reason: collision with root package name */
    public final PBBytesField f342141ex;
    public final PBUInt32Field flag;
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt32Field subcmd = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");

    static {
        String[] strArr = {"version", "cmd", "subcmd", "seq", "uid", CheckForwardServlet.KEY_ERR_CODE, "err_msg", "binary_body", "ex", AudienceReportConst.CLIENT_TYPE, "flag"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 74, 80, 88}, strArr, new Object[]{0, 0, 0, 0L, 0L, 0, "", byteStringMicro, byteStringMicro, 0, 0}, ilive$iLiveResponse.class);
    }

    public ilive$iLiveResponse() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.binary_body = PBField.initBytes(byteStringMicro);
        this.f342141ex = PBField.initBytes(byteStringMicro);
        this.client_type = PBField.initUInt32(0);
        this.flag = PBField.initUInt32(0);
    }
}
