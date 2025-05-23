package com.tencent.pb.vipdata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class userdata$splendidInfo extends MessageMicro<userdata$splendidInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField isSplendidface = PBField.initBool(false);
    public final PBInt64Field nvalue = PBField.initInt64(0);
    public final PBBoolField isSplendidsummarycard = PBField.initBool(false);
    public final PBInt32Field avatar_type = PBField.initInt32(0);
    public final PBInt32Field face_itemid = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"isSplendidface", "nvalue", "isSplendidsummarycard", "avatar_type", "face_itemid"}, new Object[]{bool, 0L, bool, 0, 0}, userdata$splendidInfo.class);
    }
}
