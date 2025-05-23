package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes5.dex */
public final class SerializationPB$StoryAlbum extends MessageMicro<SerializationPB$StoryAlbum> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"geo_hash_list", "pic_list"}, new Object[]{"", null}, SerializationPB$StoryAlbum.class);
    public final PBRepeatField<String> geo_hash_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<SerializationPB$PicInfo> pic_list = PBField.initRepeatMessage(SerializationPB$PicInfo.class);
}
