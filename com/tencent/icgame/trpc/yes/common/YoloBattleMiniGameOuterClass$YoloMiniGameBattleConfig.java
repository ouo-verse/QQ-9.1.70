package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig extends MessageMicro<YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"game_id", "mode_id", "version"}, new Object[]{0, 0, ""}, YoloBattleMiniGameOuterClass$YoloMiniGameBattleConfig.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBInt32Field mode_id = PBField.initInt32(0);
    public final PBStringField version = PBField.initString("");
}
