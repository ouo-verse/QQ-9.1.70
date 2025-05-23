package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class CommonReq extends MessageMicro<CommonReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64}, new String[]{"qqVersion", "manufacturer", "model", "osVersionCode", "totalMemory", "cpuCoreCount", "lastPreDownloadTime", WadlProxyConsts.LAST_UPDATE_TIME}, new Object[]{"", "", "", 0, 0, 0, 0L, 0L}, CommonReq.class);
    public final PBStringField qqVersion = PBField.initString("");
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBInt32Field osVersionCode = PBField.initInt32(0);
    public final PBInt32Field totalMemory = PBField.initInt32(0);
    public final PBInt32Field cpuCoreCount = PBField.initInt32(0);
    public final PBInt64Field lastPreDownloadTime = PBField.initInt64(0);
    public final PBInt64Field lastUpdateTime = PBField.initInt64(0);
}
