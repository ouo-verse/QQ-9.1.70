package com.tencent.mobileqq.gamecenter.qa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameStrategyQAAuth$GetJoinAnswerRequirementReply extends MessageMicro<GameStrategyQAAuth$GetJoinAnswerRequirementReply> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField can_join_answer = PBField.initBool(false);
    public final PBStringField req_doc = PBField.initString("");
    public final PBStringField join_title = PBField.initString("");
    public final PBBoolField can_join_qgroup = PBField.initBool(false);
    public final PBStringField success_auth_doc = PBField.initString("");

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42}, new String[]{"can_join_answer", "req_doc", "join_title", "can_join_qgroup", "success_auth_doc"}, new Object[]{bool, "", "", bool, ""}, GameStrategyQAAuth$GetJoinAnswerRequirementReply.class);
    }
}
