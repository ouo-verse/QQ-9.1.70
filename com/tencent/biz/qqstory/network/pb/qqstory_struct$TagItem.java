package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$TagItem extends MessageMicro<qqstory_struct$TagItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"base_info", "join_count", "wording"}, new Object[]{null, 0, ""}, qqstory_struct$TagItem.class);
    public qqstory_struct$TagInfoBase base_info = new MessageMicro<qqstory_struct$TagInfoBase>() { // from class: com.tencent.biz.qqstory.network.pb.qqstory_struct$TagInfoBase
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"tag_id", "tag_name", "tag_desc", "tag_type"}, new Object[]{0L, "", "", 0}, qqstory_struct$TagInfoBase.class);
        public final PBUInt64Field tag_id = PBField.initUInt64(0);
        public final PBStringField tag_name = PBField.initString("");
        public final PBStringField tag_desc = PBField.initString("");
        public final PBUInt32Field tag_type = PBField.initUInt32(0);
    };
    public final PBUInt32Field join_count = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
}
