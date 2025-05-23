package com.tencent.trpcprotocol.qqstranger.common.tag;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class TagPB$TagTab extends MessageMicro<TagPB$TagTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"tag_type", "tag_type_name", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "tag_type_icon"}, new Object[]{0, "", null, ""}, TagPB$TagTab.class);
    public final PBUInt32Field tag_type = PBField.initUInt32(0);
    public final PBStringField tag_type_name = PBField.initString("");
    public final PBRepeatMessageField<TagPB$Tag> tags = PBField.initRepeatMessage(TagPB$Tag.class);
    public final PBStringField tag_type_icon = PBField.initString("");
}
