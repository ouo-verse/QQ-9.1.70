package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$GameDetail extends MessageMicro<GameMsgMgrSvr$GameDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appid", "name", "icon", "switch_info"}, new Object[]{"", "", "", null}, GameMsgMgrSvr$GameDetail.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public GameMsgMgrSvr$SwitchInfo switch_info = new GameMsgMgrSvr$SwitchInfo();
}
