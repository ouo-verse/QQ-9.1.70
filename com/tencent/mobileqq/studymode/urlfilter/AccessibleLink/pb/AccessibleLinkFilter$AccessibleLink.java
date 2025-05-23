package com.tencent.mobileqq.studymode.urlfilter.AccessibleLink.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccessibleLinkFilter$AccessibleLink extends MessageMicro<AccessibleLinkFilter$AccessibleLink> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{"", 0L}, AccessibleLinkFilter$AccessibleLink.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt64Field expire_time = PBField.initInt64(0);
}
