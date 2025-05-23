package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class richtext$Video extends MessageMicro<richtext$Video> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50}, new String[]{"url", "title", "summary", "pic", "type", "realurl"}, new Object[]{"", "", "", "", 0, ""}, richtext$Video.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField realurl = PBField.initString("");
}
