package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class MessageOuterClass$AnchorPremadesTeamMsg extends MessageMicro<MessageOuterClass$AnchorPremadesTeamMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"team_id"}, new Object[]{0L}, MessageOuterClass$AnchorPremadesTeamMsg.class);
    public final PBUInt64Field team_id = PBField.initUInt64(0);
}
