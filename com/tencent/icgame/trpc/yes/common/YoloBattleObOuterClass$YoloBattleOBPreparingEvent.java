package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes7.dex */
public final class YoloBattleObOuterClass$YoloBattleOBPreparingEvent extends MessageMicro<YoloBattleObOuterClass$YoloBattleOBPreparingEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"status", "ob_url"}, new Object[]{0, ""}, YoloBattleObOuterClass$YoloBattleOBPreparingEvent.class);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField ob_url = PBField.initString("");
}
