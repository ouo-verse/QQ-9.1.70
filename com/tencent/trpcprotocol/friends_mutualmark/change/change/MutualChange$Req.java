package com.tencent.trpcprotocol.friends_mutualmark.change.change;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class MutualChange$Req extends MessageMicro<MutualChange$Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56}, new String[]{"uin", "id", "type", "new_info", "old_info", QCircleSchemeAttr.Detail.CURRENT_TIME, "without_gray_tip"}, new Object[]{0L, 0L, 0, null, null, 0L, 0}, MutualChange$Req.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f381295id = PBField.initUInt64(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public MutualChange$Info new_info = new MutualChange$Info();
    public MutualChange$Info old_info = new MutualChange$Info();
    public final PBInt64Field current_time = PBField.initInt64(0);
    public final PBInt32Field without_gray_tip = PBField.initInt32(0);
}
