package com.tencent.pb.now;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_tmem$ChangFeed extends MessageMicro<ilive_feeds_tmem$ChangFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ilive_feeds_tmem$Chang> chang = PBField.initRepeatMessage(ilive_feeds_tmem$Chang.class);
    public final PBBytesField desc;
    public final PBUInt32Field hight;
    public final PBBytesField pic_url;
    public ilive_feeds_tmem$Chang replay;
    public final PBUInt32Field roomid;
    public final PBUInt32Field short_video_num;
    public final PBBytesField vid;
    public final PBUInt32Field view_num;
    public final PBUInt32Field width;

    static {
        String[] strArr = {"chang", "pic_url", "vid", "width", "hight", "replay", "desc", "short_video_num", "roomid", QCircleSchemeAttr.Detail.VIEW_NUM};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 58, 64, 72, 80}, strArr, new Object[]{null, byteStringMicro, byteStringMicro, 0, 0, null, byteStringMicro, 0, 0, 0}, ilive_feeds_tmem$ChangFeed.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.pb.now.ilive_feeds_tmem$Chang] */
    public ilive_feeds_tmem$ChangFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pic_url = PBField.initBytes(byteStringMicro);
        this.vid = PBField.initBytes(byteStringMicro);
        this.width = PBField.initUInt32(0);
        this.hight = PBField.initUInt32(0);
        this.replay = new MessageMicro<ilive_feeds_tmem$Chang>() { // from class: com.tencent.pb.now.ilive_feeds_tmem$Chang
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"id", "change_type", AlbumCacheData.CREATE_TIME}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, ilive_feeds_tmem$Chang.class);

            /* renamed from: id, reason: collision with root package name */
            public final PBBytesField f342145id = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field change_type = PBField.initUInt32(0);
            public final PBUInt32Field create_time = PBField.initUInt32(0);
        };
        this.desc = PBField.initBytes(byteStringMicro);
        this.short_video_num = PBField.initUInt32(0);
        this.roomid = PBField.initUInt32(0);
        this.view_num = PBField.initUInt32(0);
    }
}
