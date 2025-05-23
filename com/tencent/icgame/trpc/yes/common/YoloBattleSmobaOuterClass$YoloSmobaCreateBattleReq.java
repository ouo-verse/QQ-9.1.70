package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaCreateBattleReq extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaCreateBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"smoba_config", "check_valid"}, new Object[]{null, Boolean.FALSE}, YoloBattleSmobaOuterClass$YoloSmobaCreateBattleReq.class);
    public YoloBattleSmobaOuterClass$YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass$YoloSmobaBattleConfig();
    public final PBBoolField check_valid = PBField.initBool(false);
}
