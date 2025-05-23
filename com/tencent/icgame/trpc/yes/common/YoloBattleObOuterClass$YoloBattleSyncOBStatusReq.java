package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleObOuterClass$YoloBattleSyncOBStatusReq extends MessageMicro<YoloBattleObOuterClass$YoloBattleSyncOBStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"ob_id", "status", "status_desc", "device_id", "pic_url"}, new Object[]{0L, 0, "", "", ""}, YoloBattleObOuterClass$YoloBattleSyncOBStatusReq.class);
    public final PBInt64Field ob_id = PBField.initInt64(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField status_desc = PBField.initString("");
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField pic_url = PBField.initString("");
}
