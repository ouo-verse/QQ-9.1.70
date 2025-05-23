package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$GetWidgetReq extends MessageMicro<QQWidgetSvr$GetWidgetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"source"}, new Object[]{0}, QQWidgetSvr$GetWidgetReq.class);
    public final PBEnumField source = PBField.initEnum(0);
}
