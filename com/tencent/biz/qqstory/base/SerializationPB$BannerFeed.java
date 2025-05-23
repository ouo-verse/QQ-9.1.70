package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* loaded from: classes5.dex */
public final class SerializationPB$BannerFeed extends MessageMicro<SerializationPB$BannerFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88, 96, 106}, new String[]{"commet_like_feed", "share_info_title", "share_info_icon", "share_info_content", "share_info_jump_url", "blurb", QZoneDTLoginReporter.SCHEMA, "content", "cover_url", "height", "width", "recommend_id", "title_wording"}, new Object[]{null, "", "", "", "", "", "", "", "", 0, 0, 0L, ByteStringMicro.EMPTY}, SerializationPB$BannerFeed.class);
    public SerializationPB$CommentLikeFeed commet_like_feed = new SerializationPB$CommentLikeFeed();
    public final PBStringField share_info_title = PBField.initString("");
    public final PBStringField share_info_icon = PBField.initString("");
    public final PBStringField share_info_content = PBField.initString("");
    public final PBStringField share_info_jump_url = PBField.initString("");
    public final PBStringField blurb = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBStringField cover_url = PBField.initString("");
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0);
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
