package com.tencent.biz.qqcircle.tedgers2.bean.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;

/* loaded from: classes5.dex */
public final class TEdgeUserProfile$UserProfile extends MessageMicro<TEdgeUserProfile$UserProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82, 88, 98, 106, 114, 122, 130}, new String[]{"age", "attributes", "city_level", "gender", "phone_brand", "phone_system", "long_interest", "short_interest"}, new Object[]{0, null, 0, "", "", "", "", ""}, TEdgeUserProfile$UserProfile.class);
    public final PBRepeatField<String> long_interest;
    public final PBRepeatField<String> short_interest;
    public final PBInt32Field age = PBField.initInt32(0);
    public final PBRepeatMessageField<TEdgeCommon$MapEntry> attributes = PBField.initRepeatMessage(TEdgeCommon$MapEntry.class);
    public final PBInt32Field city_level = PBField.initInt32(0);
    public final PBStringField gender = PBField.initString("");
    public final PBStringField phone_brand = PBField.initString("");
    public final PBStringField phone_system = PBField.initString("");

    public TEdgeUserProfile$UserProfile() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.long_interest = PBField.initRepeat(pBStringField);
        this.short_interest = PBField.initRepeat(pBStringField);
    }
}
