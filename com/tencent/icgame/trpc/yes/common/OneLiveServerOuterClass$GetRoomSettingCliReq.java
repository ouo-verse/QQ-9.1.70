package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OneLiveServerOuterClass$GetRoomSettingCliReq extends MessageMicro<OneLiveServerOuterClass$GetRoomSettingCliReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"AnchorID", "AppID"}, new Object[]{0L, 0L}, OneLiveServerOuterClass$GetRoomSettingCliReq.class);
    public final PBUInt64Field AnchorID = PBField.initUInt64(0);
    public final PBUInt64Field AppID = PBField.initUInt64(0);
}
