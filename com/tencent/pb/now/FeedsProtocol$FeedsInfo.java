package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class FeedsProtocol$FeedsInfo extends MessageMicro<FeedsProtocol$FeedsInfo> {
    public static final int LIVE_AGGREGATE = 1;
    public static final int LIVE_ANCHOR = 4;
    public static final int MINE_FEED = 5;
    public static final int SHORT_VIDEO = 3;
    public static final int VIDEO_LIST = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedsProtocol$UserInfo anchor_info;
    public final PBBytesField content;
    public final PBBytesField feed_id;
    public FeedsProtocol$FeedPreLoadInfo feed_preload;

    /* renamed from: id, reason: collision with root package name */
    public final PBBytesField f342129id;
    public final PBUInt32Field is_new;
    public final PBBytesField jump_url;
    public final PBBytesField native_jump_url;
    public FeedsProtocol$UserInfo publish_info;
    public final PBBytesField room_img_url;
    public final PBUInt32Field short_video_num;
    public final PBUInt32Field type;
    public final PBUInt64Field update_time;
    public FeedsProtocol$UserInfo user_info;
    public final PBUInt32Field view_times;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 48, 58, 64, 74, 80, 90, 98, 106, 114, 122}, new String[]{"id", "type", "user_info", "view_times", "room_img_url", "update_time", "content", "short_video_num", "jump_url", "is_new", "feed_id", "publish_info", "anchor_info", "feed_preload", "native_jump_url"}, new Object[]{byteStringMicro, 0, null, 0, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, null, null, null, byteStringMicro}, FeedsProtocol$FeedsInfo.class);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.tencent.pb.now.FeedsProtocol$FeedPreLoadInfo] */
    public FeedsProtocol$FeedsInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.f342129id = PBField.initBytes(byteStringMicro);
        this.type = PBField.initUInt32(0);
        this.user_info = new FeedsProtocol$UserInfo();
        this.view_times = PBField.initUInt32(0);
        this.room_img_url = PBField.initBytes(byteStringMicro);
        this.update_time = PBField.initUInt64(0L);
        this.content = PBField.initBytes(byteStringMicro);
        this.short_video_num = PBField.initUInt32(0);
        this.jump_url = PBField.initBytes(byteStringMicro);
        this.is_new = PBField.initUInt32(0);
        this.feed_id = PBField.initBytes(byteStringMicro);
        this.publish_info = new FeedsProtocol$UserInfo();
        this.anchor_info = new FeedsProtocol$UserInfo();
        this.feed_preload = new MessageMicro<FeedsProtocol$FeedPreLoadInfo>() { // from class: com.tencent.pb.now.FeedsProtocol$FeedPreLoadInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField doodle_pic_url;
            public final PBBytesField file_id;
            public final PBBytesField pic_url;
            public final PBBytesField video_url;

            static {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"pic_url", "video_url", "doodle_pic_url", "file_id"}, new Object[]{byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2}, FeedsProtocol$FeedPreLoadInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.pic_url = PBField.initBytes(byteStringMicro2);
                this.video_url = PBField.initBytes(byteStringMicro2);
                this.doodle_pic_url = PBField.initBytes(byteStringMicro2);
                this.file_id = PBField.initBytes(byteStringMicro2);
            }
        };
        this.native_jump_url = PBField.initBytes(byteStringMicro);
    }
}
