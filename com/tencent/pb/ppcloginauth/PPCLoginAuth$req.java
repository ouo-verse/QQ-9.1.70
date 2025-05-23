package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PPCLoginAuth$req extends MessageMicro<PPCLoginAuth$req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"comm", "reqcmd_0x01", "reqcmd_0x02"}, new Object[]{null, null, null}, PPCLoginAuth$req.class);
    public PPCLoginAuth$plat_info comm = new PPCLoginAuth$plat_info();
    public PPCLoginAuth$comering_req reqcmd_0x01 = new PPCLoginAuth$comering_req();
    public PPCLoginAuth$backgound_req reqcmd_0x02 = new MessageMicro<PPCLoginAuth$backgound_req>() { // from class: com.tencent.pb.ppcloginauth.PPCLoginAuth$backgound_req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"id"}, new Object[]{""}, PPCLoginAuth$backgound_req.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBRepeatField<String> f342168id = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
