package com.tencent.pb.ppcloginauth;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PPCLoginAuth$rsp extends MessageMicro<PPCLoginAuth$rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "rspcmd_0x01", "rspcmd_0x02"}, new Object[]{0L, "", null, null}, PPCLoginAuth$rsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public PPCLoginAuth$comering_rsp rspcmd_0x01 = new PPCLoginAuth$comering_rsp();
    public PPCLoginAuth$backgound_rsp rspcmd_0x02 = new MessageMicro<PPCLoginAuth$backgound_rsp>() { // from class: com.tencent.pb.ppcloginauth.PPCLoginAuth$backgound_rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, PPCLoginAuth$backgound_rsp.class);
        public final PBRepeatField<Integer> ret = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    };
}
