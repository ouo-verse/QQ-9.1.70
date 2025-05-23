package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tl.h;

/* loaded from: classes5.dex */
public final class qqstory_bhd_upload_pic$RspStoryPic extends MessageMicro<qqstory_bhd_upload_pic$RspStoryPic> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: h, reason: collision with root package name */
    public final PBUInt32Field f94081h;

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f94082msg;
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBBytesField url;

    /* renamed from: w, reason: collision with root package name */
    public final PBUInt32Field f94083w;

    static {
        String[] strArr = {"retcode", "url", "w", h.F, "msg"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, strArr, new Object[]{0, byteStringMicro, 0, 0, byteStringMicro}, qqstory_bhd_upload_pic$RspStoryPic.class);
    }

    public qqstory_bhd_upload_pic$RspStoryPic() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.url = PBField.initBytes(byteStringMicro);
        this.f94083w = PBField.initUInt32(0);
        this.f94081h = PBField.initUInt32(0);
        this.f94082msg = PBField.initBytes(byteStringMicro);
    }
}
