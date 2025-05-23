package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class SerializationPB$VideoListFeed extends MessageMicro<SerializationPB$VideoListFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField qim_sync_wording;
    public final PBBytesField ws_schema_main;
    public final PBBytesField ws_schema_memories;
    public SerializationPB$CommentLikeFeed commet_like_feed = new SerializationPB$CommentLikeFeed();
    public final PBStringField video_next_cookie = PBField.initString("");
    public final PBUInt32Field video_pull_type = PBField.initUInt32(0);
    public final PBUInt32Field is_video_end = PBField.initUInt32(0);
    public final PBUInt32Field is_contribute = PBField.initUInt32(0);
    public final PBUInt32Field video_seq = PBField.initUInt32(0);
    public final PBUInt32Field has_tag = PBField.initUInt32(0);
    public final PBUInt32Field has_public_video = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64, 74, 82, 90}, new String[]{"commet_like_feed", "video_next_cookie", "video_pull_type", "is_video_end", "is_contribute", "video_seq", "has_tag", "has_public_video", "qim_sync_wording", "ws_schema_main", "ws_schema_memories"}, new Object[]{null, "", 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro}, SerializationPB$VideoListFeed.class);
    }

    public SerializationPB$VideoListFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.qim_sync_wording = PBField.initBytes(byteStringMicro);
        this.ws_schema_main = PBField.initBytes(byteStringMicro);
        this.ws_schema_memories = PBField.initBytes(byteStringMicro);
    }
}
