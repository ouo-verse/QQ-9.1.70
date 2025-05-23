package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleObOuterClass$YoloBattleGetOBStatusRsp extends MessageMicro<YoloBattleObOuterClass$YoloBattleGetOBStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48}, new String[]{"msg", "url", "status_desc", "status", "pic_url", "game_matrix_ret"}, new Object[]{"", "", "", 0, "", 0L}, YoloBattleObOuterClass$YoloBattleGetOBStatusRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f116213msg = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField status_desc = PBField.initString("");
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField pic_url = PBField.initString("");
    public final PBInt64Field game_matrix_ret = PBField.initInt64(0);
}
