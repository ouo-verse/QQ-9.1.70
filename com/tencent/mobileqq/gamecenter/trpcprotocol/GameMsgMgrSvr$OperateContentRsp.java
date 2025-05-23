package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$OperateContentRsp extends MessageMicro<GameMsgMgrSvr$OperateContentRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QCircleDaTongConstant.ElementParamValue.GIFT, "red_dot_msg"}, new Object[]{null, null}, GameMsgMgrSvr$OperateContentRsp.class);
    public GameMsgMgrSvr$GetGameGiftListRsp gift = new GameMsgMgrSvr$GetGameGiftListRsp();
    public GameMsgMgrSvr$RedDotMsg red_dot_msg = new GameMsgMgrSvr$RedDotMsg();
}
