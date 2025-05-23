package com.tencent.qqnt.ntrelation.protocol.onLineStatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class StatSvcStatSong$ReqBody extends MessageMicro<StatSvcStatSong$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_need_convert = PBField.initBool(false);
    public final PBBoolField bool_pause_flag;
    public final PBBytesField bytes_singer_name;
    public final PBBytesField bytes_song_id;
    public final PBBytesField bytes_song_name;
    public final PBUInt32Field uint32_remaining_time;
    public final PBUInt32Field uint32_song_play_time;
    public final PBUInt32Field uint32_song_type;
    public final PBUInt32Field uint32_source_type;

    static {
        Boolean bool = Boolean.FALSE;
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56, 64, 72}, new String[]{"bool_need_convert", "bytes_song_id", "bytes_song_name", "uint32_song_type", "bytes_singer_name", "uint32_remaining_time", "uint32_source_type", "bool_pause_flag", "uint32_song_play_time"}, new Object[]{bool, byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, 0, bool, 0}, StatSvcStatSong$ReqBody.class);
    }

    public StatSvcStatSong$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_song_id = PBField.initBytes(byteStringMicro);
        this.bytes_song_name = PBField.initBytes(byteStringMicro);
        this.uint32_song_type = PBField.initUInt32(0);
        this.bytes_singer_name = PBField.initBytes(byteStringMicro);
        this.uint32_remaining_time = PBField.initUInt32(0);
        this.uint32_source_type = PBField.initUInt32(0);
        this.bool_pause_flag = PBField.initBool(false);
        this.uint32_song_play_time = PBField.initUInt32(0);
    }
}
