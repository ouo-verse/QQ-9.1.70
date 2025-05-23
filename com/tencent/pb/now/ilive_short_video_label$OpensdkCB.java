package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$OpensdkCB extends MessageMicro<ilive_short_video_label$OpensdkCB> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fileid;
    public final PBBytesField bytes_format;
    public final PBBytesField bytes_json;
    public final PBBytesField bytes_streamid;
    public final PBBytesField bytes_videoid;
    public final PBBytesField bytes_videourl;
    public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 98}, new String[]{"uint32_start_time", "uint32_end_time", "bytes_streamid", "bytes_fileid", "bytes_videoid", "bytes_videourl", "bytes_format", "bytes_json"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ilive_short_video_label$OpensdkCB.class);
    }

    public ilive_short_video_label$OpensdkCB() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_streamid = PBField.initBytes(byteStringMicro);
        this.bytes_fileid = PBField.initBytes(byteStringMicro);
        this.bytes_videoid = PBField.initBytes(byteStringMicro);
        this.bytes_videourl = PBField.initBytes(byteStringMicro);
        this.bytes_format = PBField.initBytes(byteStringMicro);
        this.bytes_json = PBField.initBytes(byteStringMicro);
    }
}
