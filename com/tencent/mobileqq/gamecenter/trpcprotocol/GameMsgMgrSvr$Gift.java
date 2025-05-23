package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$Gift extends MessageMicro<GameMsgMgrSvr$Gift> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "game_icon", "icons", "title", "receive_url"}, new Object[]{"", "", "", "", ""}, GameMsgMgrSvr$Gift.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField game_icon = PBField.initString("");
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField title = PBField.initString("");
    public final PBStringField receive_url = PBField.initString("");
}
