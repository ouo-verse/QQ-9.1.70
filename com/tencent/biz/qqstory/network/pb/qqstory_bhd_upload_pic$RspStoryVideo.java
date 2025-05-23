package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_bhd_upload_pic$RspStoryVideo extends MessageMicro<qqstory_bhd_upload_pic$RspStoryVideo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cdn_url;
    public final PBBytesField file_id;
    public final PBBytesField file_key;

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f94084msg;
    public final PBUInt32Field retcode = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"retcode", "msg", "cdn_url", "file_key", "file_id"}, new Object[]{0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, qqstory_bhd_upload_pic$RspStoryVideo.class);
    }

    public qqstory_bhd_upload_pic$RspStoryVideo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f94084msg = PBField.initBytes(byteStringMicro);
        this.cdn_url = PBField.initBytes(byteStringMicro);
        this.file_key = PBField.initBytes(byteStringMicro);
        this.file_id = PBField.initBytes(byteStringMicro);
    }
}
