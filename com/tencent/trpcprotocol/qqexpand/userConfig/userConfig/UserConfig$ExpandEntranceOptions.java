package com.tencent.trpcprotocol.qqexpand.userConfig.userConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$ExpandEntranceOptions extends MessageMicro<UserConfig$ExpandEntranceOptions> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"IsAllowDisplayEntrance", "entrance_des"}, new Object[]{Boolean.FALSE, ""}, UserConfig$ExpandEntranceOptions.class);
    public final PBBoolField IsAllowDisplayEntrance = PBField.initBool(false);
    public final PBStringField entrance_des = PBField.initString("");
}
