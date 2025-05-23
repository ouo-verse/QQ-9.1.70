package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$RoomState extends MessageMicro<ilive_short_video_label$RoomState> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_m3u8_path;
    public final PBBytesField bytes_sdk_fileid;
    public final PBBytesField bytes_sdk_json;
    public final PBBytesField bytes_sdk_videourl;
    public final PBBytesField bytes_vid;
    public final PBInt32Field int32_transcode_result;
    public final PBRepeatMessageField<ilive_short_video_label$OpensdkCB> rpt_extra_cb;
    public final PBUInt32Field uint32_callbacktime;
    public final PBUInt32Field uint32_hlsState;
    public final PBUInt32Field uint32_indeletewhitelist;
    public final PBUInt32Field uint32_inuinwhitelist;
    public final PBUInt32Field uint32_is_hls;
    public final PBUInt32Field uint32_mp4State;
    public final PBUInt32Field uint32_sdk_starttime;
    public final PBUInt32Field uint32_sdk_stoptime;
    public final PBUInt32Field uint32_starttime;
    public final PBUInt32Field uint32_stoptime;
    public final PBUInt32Field uint32_viddeletedbyuser;
    public final PBUInt64Field uint64_anchor = PBField.initUInt64(0);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_roomid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subroomid = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 72, 82, 88, 96, 104, 112, 120, 128, 138, 146, 152, 160, 178, 186}, new String[]{"uint64_anchor", "uint32_state", "uint32_roomid", "uint32_subroomid", "bytes_vid", "uint32_starttime", "uint32_stoptime", "uint32_callbacktime", "uint32_is_hls", "bytes_m3u8_path", "int32_transcode_result", "uint32_mp4State", "uint32_hlsState", "uint32_inuinwhitelist", "uint32_indeletewhitelist", "uint32_viddeletedbyuser", "bytes_sdk_fileid", "bytes_sdk_videourl", "uint32_sdk_starttime", "uint32_sdk_stoptime", "bytes_sdk_json", "rpt_extra_cb"}, new Object[]{0L, 0, 0, 0, byteStringMicro, 0, 0, 0, 0, byteStringMicro, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, null}, ilive_short_video_label$RoomState.class);
    }

    public ilive_short_video_label$RoomState() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_vid = PBField.initBytes(byteStringMicro);
        this.uint32_starttime = PBField.initUInt32(0);
        this.uint32_stoptime = PBField.initUInt32(0);
        this.uint32_callbacktime = PBField.initUInt32(0);
        this.uint32_is_hls = PBField.initUInt32(0);
        this.bytes_m3u8_path = PBField.initBytes(byteStringMicro);
        this.int32_transcode_result = PBField.initInt32(0);
        this.uint32_mp4State = PBField.initUInt32(0);
        this.uint32_hlsState = PBField.initUInt32(0);
        this.uint32_inuinwhitelist = PBField.initUInt32(0);
        this.uint32_indeletewhitelist = PBField.initUInt32(0);
        this.uint32_viddeletedbyuser = PBField.initUInt32(0);
        this.bytes_sdk_fileid = PBField.initBytes(byteStringMicro);
        this.bytes_sdk_videourl = PBField.initBytes(byteStringMicro);
        this.uint32_sdk_starttime = PBField.initUInt32(0);
        this.uint32_sdk_stoptime = PBField.initUInt32(0);
        this.bytes_sdk_json = PBField.initBytes(byteStringMicro);
        this.rpt_extra_cb = PBField.initRepeatMessage(ilive_short_video_label$OpensdkCB.class);
    }
}
