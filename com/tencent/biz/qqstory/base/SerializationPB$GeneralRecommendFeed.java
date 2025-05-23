package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes5.dex */
public final class SerializationPB$GeneralRecommendFeed extends MessageMicro<SerializationPB$GeneralRecommendFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"video_list_feed", "blurb", "recommend_id", "title_wording"}, new Object[]{null, "", 0L, ByteStringMicro.EMPTY}, SerializationPB$GeneralRecommendFeed.class);
    public SerializationPB$VideoListFeed video_list_feed = new SerializationPB$VideoListFeed();
    public final PBStringField blurb = PBField.initString("");
    public final PBUInt64Field recommend_id = PBField.initUInt64(0);
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
