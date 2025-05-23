package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$SwitchInfo extends MessageMicro<GameMsgMgrSvr$SwitchInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"sync_switch", "qq_block_switch", "mutex_switch"}, new Object[]{0, 0, 0}, GameMsgMgrSvr$SwitchInfo.class);
    public final PBInt32Field sync_switch = PBField.initInt32(0);
    public final PBInt32Field qq_block_switch = PBField.initInt32(0);
    public final PBInt32Field mutex_switch = PBField.initInt32(0);
}
