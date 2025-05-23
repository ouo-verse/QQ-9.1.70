package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class JDSearch$JdSearchRsp extends MessageMicro<JDSearch$JdSearchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"jd_search_errorcode", "jd_search_errormsg", "jd_search_detail"}, new Object[]{0, "", null}, JDSearch$JdSearchRsp.class);
    public final PBInt32Field jd_search_errorcode = PBField.initInt32(0);
    public final PBStringField jd_search_errormsg = PBField.initString("");
    public JDSearch$JdSearchDetail jd_search_detail = new JDSearch$JdSearchDetail();
}
