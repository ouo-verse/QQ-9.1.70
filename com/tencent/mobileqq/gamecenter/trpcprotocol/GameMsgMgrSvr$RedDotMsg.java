package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$RedDotMsg extends MessageMicro<GameMsgMgrSvr$RedDotMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"item_id", "icon", "title", "jump_url", "scene_id", "algid", "request_id", "btn_text"}, new Object[]{"", "", "", "", "", "", "", ""}, GameMsgMgrSvr$RedDotMsg.class);
    public final PBStringField item_id = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField scene_id = PBField.initString("");
    public final PBStringField algid = PBField.initString("");
    public final PBStringField request_id = PBField.initString("");
    public final PBStringField btn_text = PBField.initString("");
}
