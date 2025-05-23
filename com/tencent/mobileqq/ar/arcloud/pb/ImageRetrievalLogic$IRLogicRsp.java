package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ImageRetrievalLogic$IRLogicRsp extends MessageMicro<ImageRetrievalLogic$IRLogicRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"iRetCode", "sMsg", "vClassInfo", "iBusiness", IPublicAccountDetailReportUtil.KEY_SEARCH, "stBBox"}, new Object[]{0, "", null, 0, "", null}, ImageRetrievalLogic$IRLogicRsp.class);
    public final PBInt32Field iRetCode = PBField.initInt32(0);
    public final PBStringField sMsg = PBField.initString("");
    public final PBRepeatMessageField<ImageRetrievalLogic$RetrievalClassInfo> vClassInfo = PBField.initRepeatMessage(ImageRetrievalLogic$RetrievalClassInfo.class);
    public final PBInt32Field iBusiness = PBField.initInt32(0);
    public final PBStringField sKey = PBField.initString("");
    public ImageRetrievalComm$OD_BBox stBBox = new ImageRetrievalComm$OD_BBox();
}
