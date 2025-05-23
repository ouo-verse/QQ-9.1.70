package com.tencent.mobileqq.pb.qwallet;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayGatewayProto$ProxyRsp extends MessageMicro<PayGatewayProto$ProxyRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField err;
    public final PBBytesField payload;
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBRepeatMessageField<PayGatewayProto$TransInfo> trans;

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f257463ts;

    static {
        String[] strArr = {"retcode", "retmsg", "payload", "ts", "trans", NotificationCompat.CATEGORY_ERROR};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, strArr, new Object[]{0, "", byteStringMicro, 0L, null, byteStringMicro}, PayGatewayProto$ProxyRsp.class);
    }

    public PayGatewayProto$ProxyRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.payload = PBField.initBytes(byteStringMicro);
        this.f257463ts = PBField.initInt64(0L);
        this.trans = PBField.initRepeatMessage(PayGatewayProto$TransInfo.class);
        this.err = PBField.initBytes(byteStringMicro);
    }
}
