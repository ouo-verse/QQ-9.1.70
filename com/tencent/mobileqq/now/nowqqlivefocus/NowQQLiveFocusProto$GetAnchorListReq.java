package com.tencent.mobileqq.now.nowqqlivefocus;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$GetAnchorListReq extends MessageMicro<NowQQLiveFocusProto$GetAnchorListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uin", "source", "roomid", WidgetCacheConstellationData.NUM}, new Object[]{0L, 0, 0, 0}, NowQQLiveFocusProto$GetAnchorListReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
}
