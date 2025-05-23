package com.tencent.mobileqq.studymode.urlfilter.AccessibleLink.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccessibleLinkFilter$AccessibleLinks extends MessageMicro<AccessibleLinkFilter$AccessibleLinks> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"links"}, new Object[]{null}, AccessibleLinkFilter$AccessibleLinks.class);
    public final PBRepeatMessageField<AccessibleLinkFilter$AccessibleLink> links = PBField.initRepeatMessage(AccessibleLinkFilter$AccessibleLink.class);
}
