package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgGreeting$QueryAIOGreetInfoRsp extends MessageMicro<GameMsgGreeting$QueryAIOGreetInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"greetType", "nextGreetTime"}, new Object[]{0, 0L}, GameMsgGreeting$QueryAIOGreetInfoRsp.class);
    public final PBInt32Field greetType = PBField.initInt32(0);
    public final PBInt64Field nextGreetTime = PBField.initInt64(0);
}
