package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$QueryBindRsp extends MessageMicro<BindBank$QueryBindRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"bind_status", IPreloadServiceProxy.KEY_RESINFO, "card_tail", "bind_serial", "bind_time"}, new Object[]{0, "", "", "", 0L}, BindBank$QueryBindRsp.class);
    public final PBEnumField bind_status = PBField.initEnum(0);
    public final PBStringField res_info = PBField.initString("");
    public final PBStringField card_tail = PBField.initString("");
    public final PBStringField bind_serial = PBField.initString("");
    public final PBInt64Field bind_time = PBField.initInt64(0);
}
