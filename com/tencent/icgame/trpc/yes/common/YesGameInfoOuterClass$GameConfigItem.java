package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$GameConfigItem extends MessageMicro<YesGameInfoOuterClass$GameConfigItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"title", "kv", "type", "index"}, new Object[]{"", null, 0, 0}, YesGameInfoOuterClass$GameConfigItem.class);
    public final PBStringField title = PBField.initString("");

    /* renamed from: kv, reason: collision with root package name */
    public final PBRepeatMessageField<YesGameInfoOuterClass$GameConfigKV> f116211kv = PBField.initRepeatMessage(YesGameInfoOuterClass$GameConfigKV.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field index = PBField.initInt32(0);
}
