package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class YTOpenBase$StorePerson extends MessageMicro<YTOpenBase$StorePerson> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"person_id", "person_name", "face_ids", "group_ids", "tag"}, new Object[]{"", "", "", "", ""}, YTOpenBase$StorePerson.class);
    public final PBRepeatField<String> face_ids;
    public final PBRepeatField<String> group_ids;
    public final PBStringField person_id = PBField.initString("");
    public final PBStringField person_name = PBField.initString("");
    public final PBStringField tag;

    public YTOpenBase$StorePerson() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.face_ids = PBField.initRepeat(pBStringField);
        this.group_ids = PBField.initRepeat(pBStringField);
        this.tag = PBField.initString("");
    }
}
