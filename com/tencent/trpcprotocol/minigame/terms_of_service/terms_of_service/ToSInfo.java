package com.tencent.trpcprotocol.minigame.terms_of_service.terms_of_service;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ToSInfo extends MessageMicro<ToSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"appid", "version_num", "is_signed", "content"}, new Object[]{"", "", Boolean.FALSE, null}, ToSInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField version_num = PBField.initString("");
    public final PBBoolField is_signed = PBField.initBool(false);
    public ToSContent content = new ToSContent();
}
