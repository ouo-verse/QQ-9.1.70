package com.tencent.qqnt.ntrelation.protocol.onLineStatus;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class StatSvcStatSong$SongInfo extends MessageMicro<StatSvcStatSong$SongInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_singer_name;
    public final PBBytesField bytes_song_id;
    public final PBBytesField bytes_song_name;
    public final PBUInt32Field uint32_pause_remaining_time;
    public final PBUInt32Field uint32_song_play_time;
    public final PBUInt32Field uint32_song_type;
    public final PBUInt32Field uint32_source_type;
    public final PBUInt64Field uint64_end_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 32, 42, 48, 56, 64, 72}, new String[]{"bytes_song_id", "bytes_song_name", "uint32_song_type", "bytes_singer_name", "uint64_end_time", "uint32_source_type", "uint32_pause_remaining_time", "uint32_song_play_time"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, 0L, 0, 0, 0}, StatSvcStatSong$SongInfo.class);
    }

    public StatSvcStatSong$SongInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_song_id = PBField.initBytes(byteStringMicro);
        this.bytes_song_name = PBField.initBytes(byteStringMicro);
        this.uint32_song_type = PBField.initUInt32(0);
        this.bytes_singer_name = PBField.initBytes(byteStringMicro);
        this.uint64_end_time = PBField.initUInt64(0L);
        this.uint32_source_type = PBField.initUInt32(0);
        this.uint32_pause_remaining_time = PBField.initUInt32(0);
        this.uint32_song_play_time = PBField.initUInt32(0);
    }
}
