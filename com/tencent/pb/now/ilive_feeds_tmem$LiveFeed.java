package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$LiveFeed extends MessageMicro<ilive_feeds_tmem$LiveFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField desc;
    public ilive_feeds_tmem$KInfo k_info;
    public final PBBytesField pic_url;
    public final PBUInt32Field room_type;
    public final PBUInt32Field roomid;
    public final PBRepeatField<ByteStringMicro> topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField vid;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 58}, new String[]{"topic", "desc", "roomid", "pic_url", "vid", "room_type", "k_info"}, new Object[]{byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, null}, ilive_feeds_tmem$LiveFeed.class);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.pb.now.ilive_feeds_tmem$KInfo] */
    public ilive_feeds_tmem$LiveFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.desc = PBField.initBytes(byteStringMicro);
        this.roomid = PBField.initUInt32(0);
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.vid = PBField.initBytes(byteStringMicro);
        this.room_type = PBField.initUInt32(0);
        this.k_info = new MessageMicro<ilive_feeds_tmem$KInfo>() { // from class: com.tencent.pb.now.ilive_feeds_tmem$KInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"song_name"}, new Object[]{ByteStringMicro.EMPTY}, ilive_feeds_tmem$KInfo.class);
            public final PBBytesField song_name = PBField.initBytes(ByteStringMicro.EMPTY);
        };
    }
}
