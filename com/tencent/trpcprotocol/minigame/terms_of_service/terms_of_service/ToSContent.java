package com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ToSContent extends MessageMicro<ToSContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"title", "text", "links"}, new Object[]{"", "", null}, ToSContent.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public final PBRepeatMessageField<ToSLink> links = PBField.initRepeatMessage(ToSLink.class);
}
