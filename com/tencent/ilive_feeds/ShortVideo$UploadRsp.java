package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShortVideo$UploadRsp extends MessageMicro<ShortVideo$UploadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 98, 106}, new String[]{"retcode", "ver", "userip", "prov", "frontid", "frontip", "zoneid", "zoneip", "expiretime", "zonedomain", "userflag", "authkey", "err_msg"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, ByteStringMicro.EMPTY, ""}, ShortVideo$UploadRsp.class);
    public final PBBytesField authkey;
    public final PBStringField err_msg;
    public final PBUInt32Field expiretime;
    public final PBRepeatField<Integer> frontip;
    public final PBUInt32Field userflag;
    public final PBStringField zonedomain;
    public final PBUInt32Field zoneid;
    public final PBRepeatField<Integer> zoneip;
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBInt32Field ver = PBField.initInt32(0);
    public final PBUInt32Field userip = PBField.initUInt32(0);
    public final PBUInt32Field prov = PBField.initUInt32(0);
    public final PBUInt32Field frontid = PBField.initUInt32(0);

    public ShortVideo$UploadRsp() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.frontip = PBField.initRepeat(pBUInt32Field);
        this.zoneid = PBField.initUInt32(0);
        this.zoneip = PBField.initRepeat(pBUInt32Field);
        this.expiretime = PBField.initUInt32(0);
        this.zonedomain = PBField.initString("");
        this.userflag = PBField.initUInt32(0);
        this.authkey = PBField.initBytes(ByteStringMicro.EMPTY);
        this.err_msg = PBField.initString("");
    }
}
