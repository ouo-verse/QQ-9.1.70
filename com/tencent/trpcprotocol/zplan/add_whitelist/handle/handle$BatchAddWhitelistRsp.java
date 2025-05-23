package com.tencent.trpcprotocol.zplan.add_whitelist.handle;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class handle$BatchAddWhitelistRsp extends MessageMicro<handle$BatchAddWhitelistRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"errcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG}, new Object[]{0, ""}, handle$BatchAddWhitelistRsp.class);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBStringField errmsg = PBField.initString("");
}
