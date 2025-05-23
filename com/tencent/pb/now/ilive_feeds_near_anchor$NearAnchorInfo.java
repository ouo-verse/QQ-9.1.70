package com.tencent.pb.now;

import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_near_anchor$NearAnchorInfo extends MessageMicro<ilive_feeds_near_anchor$NearAnchorInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field anchor_type;
    public final PBBytesField city;
    public final PBBytesField cover_url;
    public final PBUInt32Field create_time;
    public final PBStringField jump_qqlive_url;
    public final PBUInt32Field jump_type;
    public final PBBytesField lable_url;
    public final PBBytesField medal_face;
    public final PBUInt32Field pic_time;
    public final PBBytesField room_name;
    public final PBUInt32Field start_time;
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt32Field root_roomid = PBField.initUInt32(0);
    public final PBUInt32Field sub_roomid = PBField.initUInt32(0);
    public final PBDoubleField distance = PBField.initDouble(0.0d);

    static {
        String[] strArr = {"uid", "root_roomid", "sub_roomid", Element.ELEMENT_NAME_DISTANCE, AudienceReportConst.ROOM_NAME, "cover_url", AlbumCacheData.CREATE_TIME, "city", "start_time", "medal_face", "pic_time", "anchor_type", "lable_url", "jump_type", "jump_qqlive_url"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 33, 42, 50, 56, 66, 72, 82, 88, 96, 106, 112, 802}, strArr, new Object[]{0L, 0, 0, Double.valueOf(0.0d), byteStringMicro, byteStringMicro, 0, byteStringMicro, 0, byteStringMicro, 0, 0, byteStringMicro, 0, ""}, ilive_feeds_near_anchor$NearAnchorInfo.class);
    }

    public ilive_feeds_near_anchor$NearAnchorInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.room_name = PBField.initBytes(byteStringMicro);
        this.cover_url = PBField.initBytes(byteStringMicro);
        this.create_time = PBField.initUInt32(0);
        this.city = PBField.initBytes(byteStringMicro);
        this.start_time = PBField.initUInt32(0);
        this.medal_face = PBField.initBytes(byteStringMicro);
        this.pic_time = PBField.initUInt32(0);
        this.anchor_type = PBField.initUInt32(0);
        this.lable_url = PBField.initBytes(byteStringMicro);
        this.jump_type = PBField.initUInt32(0);
        this.jump_qqlive_url = PBField.initString("");
    }
}
