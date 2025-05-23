package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class YoloBattlePartnerOuterClass$DelReadyPlayerReq extends MessageMicro<YoloBattlePartnerOuterClass$DelReadyPlayerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{"ready_uid"}, new Object[]{0L}, YoloBattlePartnerOuterClass$DelReadyPlayerReq.class);
    public final PBUInt64Field ready_uid = PBField.initUInt64(0);
}
