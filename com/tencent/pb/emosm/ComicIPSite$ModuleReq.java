package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ComicIPSite$ModuleReq extends MessageMicro<ComicIPSite$ModuleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"platform", "mqqver", "uin", "moduleInfo", "sub_cmd"}, new Object[]{0L, "", 0L, null, 0}, ComicIPSite$ModuleReq.class);
    public final PBInt64Field platform = PBField.initInt64(0);
    public final PBStringField mqqver = PBField.initString("");
    public final PBInt64Field uin = PBField.initInt64(0);
    public ComicIPSite$ModuleInfo moduleInfo = new ComicIPSite$ModuleInfo();
    public final PBInt32Field sub_cmd = PBField.initInt32(0);
}
