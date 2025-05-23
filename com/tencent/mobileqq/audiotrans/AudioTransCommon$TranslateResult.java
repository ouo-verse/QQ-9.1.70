package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransCommon$TranslateResult extends MessageMicro<AudioTransCommon$TranslateResult> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_src_text;
    public final PBBytesField bytes_tar_text;
    public final PBInt32Field int32_end_seq = PBField.initInt32(0);
    public final PBInt32Field int32_start_seq = PBField.initInt32(0);
    public final PBInt32Field int32_status;
    public final PBInt32Field int32_type;
    public final PBUInt32Field uint32_rel_ts;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56}, new String[]{"int32_end_seq", "int32_start_seq", "bytes_src_text", "bytes_tar_text", "int32_status", "int32_type", "uint32_rel_ts"}, new Object[]{0, 0, byteStringMicro, byteStringMicro, 0, 0, 0}, AudioTransCommon$TranslateResult.class);
    }

    public AudioTransCommon$TranslateResult() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_src_text = PBField.initBytes(byteStringMicro);
        this.bytes_tar_text = PBField.initBytes(byteStringMicro);
        this.int32_status = PBField.initInt32(0);
        this.int32_type = PBField.initInt32(0);
        this.uint32_rel_ts = PBField.initUInt32(0);
    }
}
