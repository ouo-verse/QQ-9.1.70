package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ServerApi$ReqDownloadCheckRecmd extends MessageMicro<ServerApi$ReqDownloadCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"uin", "source", "platform", "pkg_name", ZPlanPublishSource.FROM_SCHEME, "url", "extra_info", "ref_source"}, new Object[]{0L, "", "", "", "", "", "", ""}, ServerApi$ReqDownloadCheckRecmd.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField source = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField scheme = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
    public final PBStringField ref_source = PBField.initString("");
}
