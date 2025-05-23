package com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ToSLink extends MessageMicro<ToSLink> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"link_text", "url"}, new Object[]{"", ""}, ToSLink.class);
    public final PBStringField link_text = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
