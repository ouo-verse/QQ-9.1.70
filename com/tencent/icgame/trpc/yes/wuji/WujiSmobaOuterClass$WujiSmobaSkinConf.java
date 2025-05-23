package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiSmobaOuterClass$WujiSmobaSkinConf extends MessageMicro<WujiSmobaOuterClass$WujiSmobaSkinConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"id", "name", "hero_id", "small_icon"}, new Object[]{0, "", 0, ""}, WujiSmobaOuterClass$WujiSmobaSkinConf.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f116226id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field hero_id = PBField.initInt32(0);
    public final PBStringField small_icon = PBField.initString("");
}
