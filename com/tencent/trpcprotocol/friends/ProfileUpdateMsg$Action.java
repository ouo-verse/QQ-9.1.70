package com.tencent.trpcprotocol.friends;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes10.dex */
public final class ProfileUpdateMsg$Action extends MessageMicro<ProfileUpdateMsg$Action> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"add_catgory", "del_catgory", "update_catgory", "add_buddy", "del_buddy"}, new Object[]{null, null, null, null, null}, ProfileUpdateMsg$Action.class);
    public ProfileUpdateMsg$CatgoryInfo add_catgory = new MessageMicro<ProfileUpdateMsg$CatgoryInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$CatgoryInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{200056, 200066, 200072}, new String[]{"catgory_id", "catgory_name", "sort_id"}, new Object[]{0, "", 0}, ProfileUpdateMsg$CatgoryInfo.class);
        public final PBUInt32Field catgory_id = PBField.initUInt32(0);
        public final PBStringField catgory_name = PBField.initString("");
        public final PBUInt32Field sort_id = PBField.initUInt32(0);
    };
    public ProfileUpdateMsg$CatgoryInfo del_catgory = new MessageMicro<ProfileUpdateMsg$CatgoryInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$CatgoryInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{200056, 200066, 200072}, new String[]{"catgory_id", "catgory_name", "sort_id"}, new Object[]{0, "", 0}, ProfileUpdateMsg$CatgoryInfo.class);
        public final PBUInt32Field catgory_id = PBField.initUInt32(0);
        public final PBStringField catgory_name = PBField.initString("");
        public final PBUInt32Field sort_id = PBField.initUInt32(0);
    };
    public ProfileUpdateMsg$CatgoryInfo update_catgory = new MessageMicro<ProfileUpdateMsg$CatgoryInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$CatgoryInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{200056, 200066, 200072}, new String[]{"catgory_id", "catgory_name", "sort_id"}, new Object[]{0, "", 0}, ProfileUpdateMsg$CatgoryInfo.class);
        public final PBUInt32Field catgory_id = PBField.initUInt32(0);
        public final PBStringField catgory_name = PBField.initString("");
        public final PBUInt32Field sort_id = PBField.initUInt32(0);
    };
    public ProfileUpdateMsg$Buddy add_buddy = new MessageMicro<ProfileUpdateMsg$Buddy>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$Buddy
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8002}, new String[]{"uid"}, new Object[]{""}, ProfileUpdateMsg$Buddy.class);
        public final PBStringField uid = PBField.initString("");
    };
    public ProfileUpdateMsg$Buddy del_buddy = new MessageMicro<ProfileUpdateMsg$Buddy>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$Buddy
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8002}, new String[]{"uid"}, new Object[]{""}, ProfileUpdateMsg$Buddy.class);
        public final PBStringField uid = PBField.initString("");
    };
}
