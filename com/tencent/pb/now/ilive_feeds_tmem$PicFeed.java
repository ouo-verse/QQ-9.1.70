package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$PicFeed extends MessageMicro<ilive_feeds_tmem$PicFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField desc;
    public final PBBytesField feed_md5;
    public final PBRepeatMessageField<ilive_feeds_tmem$PicInfo> infos;
    public final PBRepeatField<ByteStringMicro> topic = PBField.initRepeat(PBBytesField.__repeatHelper__);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"topic", "desc", "infos", "feed_md5"}, new Object[]{byteStringMicro, byteStringMicro, null, byteStringMicro}, ilive_feeds_tmem$PicFeed.class);
    }

    public ilive_feeds_tmem$PicFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.desc = PBField.initBytes(byteStringMicro);
        this.infos = PBField.initRepeatMessage(ilive_feeds_tmem$PicInfo.class);
        this.feed_md5 = PBField.initBytes(byteStringMicro);
    }
}
