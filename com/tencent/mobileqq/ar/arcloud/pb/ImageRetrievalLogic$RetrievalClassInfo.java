package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ImageRetrievalLogic$RetrievalClassInfo extends MessageMicro<ImageRetrievalLogic$RetrievalClassInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 25, 34, 40}, new String[]{"iClass", "sClass", "dClassProb", "vItem", "iStatus"}, new Object[]{0, "", Double.valueOf(0.0d), null, 0}, ImageRetrievalLogic$RetrievalClassInfo.class);
    public final PBInt32Field iClass = PBField.initInt32(0);
    public final PBStringField sClass = PBField.initString("");
    public final PBDoubleField dClassProb = PBField.initDouble(0.0d);
    public final PBRepeatMessageField<ImageRetrievalLogic$RetrievalItem> vItem = PBField.initRepeatMessage(ImageRetrievalLogic$RetrievalItem.class);
    public final PBInt32Field iStatus = PBField.initInt32(0);
}
