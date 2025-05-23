package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ImageRetrievalLogic$IRLogicReq extends MessageMicro<ImageRetrievalLogic$IRLogicReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40}, new String[]{"stUserInfo", "iBusiness", "iScene", "vImage", "iModel"}, new Object[]{null, 0, 0, ByteStringMicro.EMPTY, 0}, ImageRetrievalLogic$IRLogicReq.class);
    public ImageRetrievalComm$IRUserInfo stUserInfo = new MessageMicro<ImageRetrievalComm$IRUserInfo>() { // from class: com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalComm$IRUserInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"sUid", "sUname"}, new Object[]{"", ""}, ImageRetrievalComm$IRUserInfo.class);
        public final PBStringField sUid = PBField.initString("");
        public final PBStringField sUname = PBField.initString("");
    };
    public final PBInt32Field iBusiness = PBField.initInt32(0);
    public final PBInt32Field iScene = PBField.initInt32(0);
    public final PBBytesField vImage = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field iModel = PBField.initInt32(0);
}
