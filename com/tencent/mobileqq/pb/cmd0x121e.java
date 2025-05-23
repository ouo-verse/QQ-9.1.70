package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class cmd0x121e {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x121eRequest extends MessageMicro<Cmd0x121eRequest> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"event", "open_msg"}, new Object[]{0, ""}, Cmd0x121eRequest.class);
        public final PBInt32Field event = PBField.initInt32(0);
        public final PBStringField open_msg = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class Cmd0x121eResponse extends MessageMicro<Cmd0x121eResponse> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"issue"}, new Object[]{Boolean.FALSE}, Cmd0x121eResponse.class);
        public final PBBoolField issue = PBField.initBool(false);
    }

    cmd0x121e() {
    }
}
