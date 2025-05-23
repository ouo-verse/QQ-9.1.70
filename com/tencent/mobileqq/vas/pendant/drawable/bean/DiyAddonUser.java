package com.tencent.mobileqq.vas.pendant.drawable.bean;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class DiyAddonUser {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class UserDiyInfo extends MessageMicro<UserDiyInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uin", "curid", "frameid", "stickerinfo", "updatets"}, new Object[]{0L, 0, 0, null, 0L}, UserDiyInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBInt32Field curid = PBField.initInt32(0);
        public final PBUInt32Field frameid = PBField.initUInt32(0);
        public final PBRepeatMessageField<UserStickerInfo> stickerinfo = PBField.initRepeatMessage(UserStickerInfo.class);
        public final PBUInt64Field updatets = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class UserStickerInfo extends MessageMicro<UserStickerInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56}, new String[]{"type", "stickerid", "angle", "text", "fontid", "fontcolor", "fonttype"}, new Object[]{0, 0, 0, "", 0, "", 0}, UserStickerInfo.class);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt32Field stickerid = PBField.initUInt32(0);
        public final PBUInt32Field angle = PBField.initUInt32(0);
        public final PBStringField text = PBField.initString("");
        public final PBUInt32Field fontid = PBField.initUInt32(0);
        public final PBStringField fontcolor = PBField.initString("");
        public final PBUInt32Field fonttype = PBField.initUInt32(0);
    }

    DiyAddonUser() {
    }
}
