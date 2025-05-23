package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$QueryUserInfoRsp extends MessageMicro<sgame_qgroup_datacard$QueryUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17, 24, 32, 40, 58, 66, 74, 82, 90}, new String[]{"grade", "seasonWinRate", "gamesTotal", "mvpTotal", "bestOccupation", "bestHeroList", "encrptOpenId", "partition", "platid", GdtGetUserInfoHandler.KEY_AREA}, new Object[]{0, Double.valueOf(0.0d), 0L, 0L, 0, null, "", "", "", ""}, sgame_qgroup_datacard$QueryUserInfoRsp.class);
    public final PBEnumField grade = PBField.initEnum(0);
    public final PBDoubleField seasonWinRate = PBField.initDouble(0.0d);
    public final PBInt64Field gamesTotal = PBField.initInt64(0);
    public final PBInt64Field mvpTotal = PBField.initInt64(0);
    public final PBEnumField bestOccupation = PBField.initEnum(0);
    public final PBRepeatMessageField<sgame_qgroup_datacard$UserHeroInfo> bestHeroList = PBField.initRepeatMessage(sgame_qgroup_datacard$UserHeroInfo.class);
    public final PBStringField encrptOpenId = PBField.initString("");
    public final PBStringField partition = PBField.initString("");
    public final PBStringField platid = PBField.initString("");
    public final PBStringField area = PBField.initString("");
}
