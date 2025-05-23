package com.tencent.pb.mqqcomic;

import android.net.http.Headers;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class MqqComicHeadPb$ComicRspHead extends MessageMicro<MqqComicHeadPb$ComicRspHead> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cmd;
    public final PBBytesField debugMsg;
    public final PBStringField etag;
    public final PBInt32Field maxCacheSec;
    public final PBInt32Field reportRate;
    public final PBInt32Field retCode = PBField.initInt32(0);
    public final PBBytesField retMsg;
    public final PBInt64Field uin;

    static {
        String[] strArr = {"retCode", "retMsg", "debugMsg", "maxCacheSec", Headers.ETAG, "cmd", "uin", "reportRate"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 64}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, 0, "", "", 0L, 0}, MqqComicHeadPb$ComicRspHead.class);
    }

    public MqqComicHeadPb$ComicRspHead() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.retMsg = PBField.initBytes(byteStringMicro);
        this.debugMsg = PBField.initBytes(byteStringMicro);
        this.maxCacheSec = PBField.initInt32(0);
        this.etag = PBField.initString("");
        this.cmd = PBField.initString("");
        this.uin = PBField.initInt64(0L);
        this.reportRate = PBField.initInt32(0);
    }
}
