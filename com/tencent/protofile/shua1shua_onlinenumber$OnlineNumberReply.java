package com.tencent.protofile;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class shua1shua_onlinenumber$OnlineNumberReply extends MessageMicro<shua1shua_onlinenumber$OnlineNumberReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"ret", "msg", WidgetCacheConstellationData.NUM, WidgetCacheConstellationData.INTERVAL}, new Object[]{0, "", 0, 0}, shua1shua_onlinenumber$OnlineNumberReply.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f342211msg = PBField.initString("");
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field interval = PBField.initUInt32(0);
}
