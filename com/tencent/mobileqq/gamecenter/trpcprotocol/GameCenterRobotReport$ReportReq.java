package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterRobotReport$ReportReq extends MessageMicro<GameCenterRobotReport$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{WadlReportBuilder.TableElem.OPER_ID, "oper_module", "game_appid", WadlReportBuilder.TableElem.SQ_VERSION, "domain", "exts", WadlReportBuilder.TableElem.GAMECENTER_SRC}, new Object[]{"", "", "", "", "", null, ""}, GameCenterRobotReport$ReportReq.class);
    public final PBStringField oper_id = PBField.initString("");
    public final PBStringField oper_module = PBField.initString("");
    public final PBStringField game_appid = PBField.initString("");
    public final PBStringField sq_ver = PBField.initString("");
    public final PBStringField domain = PBField.initString("");
    public final PBRepeatMessageField<GameCenterRobotReport$ExtParam> exts = PBField.initRepeatMessage(GameCenterRobotReport$ExtParam.class);
    public final PBStringField gamecenter_src = PBField.initString("");
}
