package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ImgRetrievalResult extends MessageMicro<ARCloudRecogCustomPb$ImgRetrievalResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"errorcode", "errormsg", "msg_ir_logic_rsp", "jd_search_rsp"}, new Object[]{0, "", null, null}, ARCloudRecogCustomPb$ImgRetrievalResult.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public ImageRetrievalLogic$IRLogicRsp msg_ir_logic_rsp = new ImageRetrievalLogic$IRLogicRsp();
    public JDSearch$JdSearchRsp jd_search_rsp = new JDSearch$JdSearchRsp();
}
