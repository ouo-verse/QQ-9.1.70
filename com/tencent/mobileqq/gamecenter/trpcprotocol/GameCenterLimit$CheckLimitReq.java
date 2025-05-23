package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterLimit$CheckLimitReq extends MessageMicro<GameCenterLimit$CheckLimitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "strategy_id"}, new Object[]{"", 0}, GameCenterLimit$CheckLimitReq.class);
    public final PBStringField gid = PBField.initString("");
    public final PBInt32Field strategy_id = PBField.initInt32(0);
}
