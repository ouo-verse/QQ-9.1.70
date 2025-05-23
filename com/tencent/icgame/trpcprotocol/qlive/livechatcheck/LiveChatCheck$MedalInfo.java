package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$MedalInfo extends MessageMicro<LiveChatCheck$MedalInfo> {
    public static final int CREATE_TIME_FIELD_NUMBER = 15;
    public static final int MEDAL_DESC_FIELD_NUMBER = 8;
    public static final int MEDAL_END_TIME_FIELD_NUMBER = 6;
    public static final int MEDAL_FACE_BIGGER_FIELD_NUMBER = 10;
    public static final int MEDAL_FACE_SMALL_FIELD_NUMBER = 3;
    public static final int MEDAL_ID_FIELD_NUMBER = 1;
    public static final int MEDAL_INDEX_FIELD_NUMBER = 12;
    public static final int MEDAL_LEVEL_FIELD_NUMBER = 13;
    public static final int MEDAL_NAME_FIELD_NUMBER = 2;
    public static final int MEDAL_POINT_FIELD_NUMBER = 14;
    public static final int MEDAL_PRIORITY_LEVEL_FIELD_NUMBER = 7;
    public static final int MEDAL_START_TIME_FIELD_NUMBER = 5;
    public static final int MEDAL_TYPE_FIELD_NUMBER = 4;
    public static final int MEDAL_URL_FIELD_NUMBER = 9;
    public static final int MEDAL_VERSION_FIELD_NUMBER = 11;
    public static final int UPDATE_TIME_FIELD_NUMBER = 16;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time;
    public final PBBytesField medal_desc;
    public final PBUInt64Field medal_end_time;
    public final PBBytesField medal_face_bigger;
    public final PBBytesField medal_face_small;
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBUInt32Field medal_index;
    public final PBUInt32Field medal_level;
    public final PBBytesField medal_name;
    public final PBUInt32Field medal_point;
    public final PBUInt32Field medal_priority_level;
    public final PBUInt64Field medal_start_time;
    public final PBUInt32Field medal_type;
    public final PBBytesField medal_url;
    public final PBUInt32Field medal_version;
    public final PBUInt64Field update_time;

    static {
        String[] strArr = {"medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_priority_level", "medal_desc", "medal_url", "medal_face_bigger", "medal_version", "medal_index", "medal_level", "medal_point", AlbumCacheData.CREATE_TIME, "update_time"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0L, 0L}, LiveChatCheck$MedalInfo.class);
    }

    public LiveChatCheck$MedalInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.medal_name = PBField.initBytes(byteStringMicro);
        this.medal_face_small = PBField.initBytes(byteStringMicro);
        this.medal_type = PBField.initUInt32(0);
        this.medal_start_time = PBField.initUInt64(0L);
        this.medal_end_time = PBField.initUInt64(0L);
        this.medal_priority_level = PBField.initUInt32(0);
        this.medal_desc = PBField.initBytes(byteStringMicro);
        this.medal_url = PBField.initBytes(byteStringMicro);
        this.medal_face_bigger = PBField.initBytes(byteStringMicro);
        this.medal_version = PBField.initUInt32(0);
        this.medal_index = PBField.initUInt32(0);
        this.medal_level = PBField.initUInt32(0);
        this.medal_point = PBField.initUInt32(0);
        this.create_time = PBField.initUInt64(0L);
        this.update_time = PBField.initUInt64(0L);
    }
}
