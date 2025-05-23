package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$TagTab extends MessageMicro<userInfo$TagTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"tag_type", "tag_type_name", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{0, "", null}, userInfo$TagTab.class);
    public final PBUInt32Field tag_type = PBField.initUInt32(0);
    public final PBStringField tag_type_name = PBField.initString("");
    public final PBRepeatMessageField<userInfo$Tag> tags = PBField.initRepeatMessage(userInfo$Tag.class);
}
