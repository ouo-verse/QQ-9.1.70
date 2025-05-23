package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$OperateContentReq extends MessageMicro<GameMsgMgrSvr$OperateContentReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField opt_type = PBField.initEnum(0);
    public final PBBoolField need_gift = PBField.initBool(false);
    public final PBBoolField need_red_dot_msg = PBField.initBool(false);
    public GameMsgMgrSvr$RedDotMsg red_dot_msg = new GameMsgMgrSvr$RedDotMsg();

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"opt_type", "need_gift", "need_red_dot_msg", "red_dot_msg"}, new Object[]{0, bool, bool, null}, GameMsgMgrSvr$OperateContentReq.class);
    }
}
