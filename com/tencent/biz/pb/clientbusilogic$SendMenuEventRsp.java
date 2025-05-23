package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$SendMenuEventRsp extends MessageMicro<clientbusilogic$SendMenuEventRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"detail"}, new Object[]{null}, clientbusilogic$SendMenuEventRsp.class);
    public Detail detail = new Detail();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Detail extends MessageMicro<Detail> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ret_info", "menu_seq_no"}, new Object[]{null, 0}, Detail.class);
        public clientbusilogic$RetInfo ret_info = new clientbusilogic$RetInfo();
        public final PBUInt32Field menu_seq_no = PBField.initUInt32(0);
    }
}
