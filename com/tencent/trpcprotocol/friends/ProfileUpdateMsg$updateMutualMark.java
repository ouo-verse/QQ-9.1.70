package com.tencent.trpcprotocol.friends;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes10.dex */
public final class ProfileUpdateMsg$updateMutualMark extends MessageMicro<ProfileUpdateMsg$updateMutualMark> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field markFlag = PBField.initUInt64(0);
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
    public final PBFloatField count = PBField.initFloat(0.0f);
    public final PBUInt64Field continueDays = PBField.initUInt64(0);
    public final PBUInt64Field lastActionTime = PBField.initUInt64(0);
    public final PBUInt64Field iconStatus = PBField.initUInt64(0);
    public final PBUInt64Field subLevel = PBField.initUInt64(0);
    public final PBUInt64Field iconStatusEndTime = PBField.initUInt64(0);
    public final PBUInt32Field closeFlag = PBField.initUInt32(0);
    public ProfileUpdateMsg$ResourceInfo resourceInfo = new MessageMicro<ProfileUpdateMsg$ResourceInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$ResourceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{164810, 164818, 164826, 164834, 164840, 164850, 164858}, new String[]{"iconDynamicUrl", "iconStaticUrl", "iconCartoonUrl", "iconCartoonMd5", "playCartoon", "iconName", "grayUrl"}, new Object[]{"", "", "", "", 0, "", ""}, ProfileUpdateMsg$ResourceInfo.class);
        public final PBStringField iconDynamicUrl = PBField.initString("");
        public final PBStringField iconStaticUrl = PBField.initString("");
        public final PBStringField iconCartoonUrl = PBField.initString("");
        public final PBStringField iconCartoonMd5 = PBField.initString("");
        public final PBStringField iconName = PBField.initString("");
        public final PBUInt32Field playCartoon = PBField.initUInt32(0);
        public final PBStringField grayUrl = PBField.initString("");
    };
    public ProfileUpdateMsg$ResourceInfo gradeResourceInfo = new MessageMicro<ProfileUpdateMsg$ResourceInfo>() { // from class: com.tencent.trpcprotocol.friends.ProfileUpdateMsg$ResourceInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{164810, 164818, 164826, 164834, 164840, 164850, 164858}, new String[]{"iconDynamicUrl", "iconStaticUrl", "iconCartoonUrl", "iconCartoonMd5", "playCartoon", "iconName", "grayUrl"}, new Object[]{"", "", "", "", 0, "", ""}, ProfileUpdateMsg$ResourceInfo.class);
        public final PBStringField iconDynamicUrl = PBField.initString("");
        public final PBStringField iconStaticUrl = PBField.initString("");
        public final PBStringField iconCartoonUrl = PBField.initString("");
        public final PBStringField iconCartoonMd5 = PBField.initString("");
        public final PBStringField iconName = PBField.initString("");
        public final PBUInt32Field playCartoon = PBField.initUInt32(0);
        public final PBStringField grayUrl = PBField.initString("");
    };
    public final PBStringField minVersion = PBField.initString("");
    public final PBStringField maxVersion = PBField.initString("");
    public final PBStringField iconUrl = PBField.initString("");
    public final PBUInt32Field markVersion = PBField.initUInt32(0);
    public final PBUInt64Field lightUpTime = PBField.initUInt64(0);
    public final PBBoolField isWearing = PBField.initBool(false);
    public final PBStringField iconFormat = PBField.initString("");
    public final PBUInt32Field orderNum = PBField.initUInt32(0);
    public final PBUInt64Field lastChangTime = PBField.initUInt64(0);
    public final PBBoolField hasRemindInContact = PBField.initBool(false);
    public final PBUInt64Field remindAnimStartTime = PBField.initUInt64(0);
    public final PBStringField strCluster = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{248008, 248016, 248024, 248037, 248040, 248048, 248056, 248064, 248072, 248080, 248090, 248098, 248106, 248114, 248122, 248128, 248136, 248144, 248154, 248160, 248168, 248176, 248184, 248194}, new String[]{"markFlag", "type", "level", "count", "continueDays", "lastActionTime", "iconStatus", "subLevel", "iconStatusEndTime", "closeFlag", "resourceInfo", "gradeResourceInfo", "minVersion", "maxVersion", "iconUrl", "markVersion", "lightUpTime", "isWearing", "iconFormat", "orderNum", "lastChangTime", "hasRemindInContact", "remindAnimStartTime", "strCluster"}, new Object[]{0L, 0L, 0L, Float.valueOf(0.0f), 0L, 0L, 0L, 0L, 0L, 0, null, null, "", "", "", 0, 0L, bool, "", 0, 0L, bool, 0L, ""}, ProfileUpdateMsg$updateMutualMark.class);
    }
}
