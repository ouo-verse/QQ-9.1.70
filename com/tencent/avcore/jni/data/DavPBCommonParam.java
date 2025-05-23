package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public final class DavPBCommonParam {
    static IPatchRedirector $redirector_;

    /* loaded from: classes3.dex */
    public static final class CommonParam extends MessageMicro<CommonParam> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"invite_scene", "invite_trace_id"}, new Object[]{0, ""}, CommonParam.class);
        public final PBUInt32Field invite_scene = PBField.initUInt32(0);
        public final PBStringField invite_trace_id = PBField.initString("");
    }

    DavPBCommonParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
