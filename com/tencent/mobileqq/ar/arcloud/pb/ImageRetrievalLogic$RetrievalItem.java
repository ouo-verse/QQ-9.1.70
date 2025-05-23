package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ImageRetrievalLogic$RetrievalItem extends MessageMicro<ImageRetrievalLogic$RetrievalItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 25, 34, 42, 48, 58, 64, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 834, 840, 850}, new String[]{"iClass", "sClass", "dProb", "sItemID", "stLabel", "iSource", "sPicUrl", "iAutoJump", "sTitle", "sWiki", "sJumpUrl", "sCdbRes", "iNeedCheckLBS", "sImageId"}, new Object[]{0, "", Double.valueOf(0.0d), "", null, 0, "", 0, "", "", "", ByteStringMicro.EMPTY, 0, ""}, ImageRetrievalLogic$RetrievalItem.class);
    public final PBInt32Field iClass = PBField.initInt32(0);
    public final PBStringField sClass = PBField.initString("");
    public final PBDoubleField dProb = PBField.initDouble(0.0d);
    public final PBStringField sItemID = PBField.initString("");
    public ImageRetrievalLogic$LabelSource stLabel = new ImageRetrievalLogic$LabelSource();
    public final PBInt32Field iSource = PBField.initInt32(0);
    public final PBStringField sPicUrl = PBField.initString("");
    public final PBInt32Field iAutoJump = PBField.initInt32(0);
    public final PBStringField sTitle = PBField.initString("");
    public final PBStringField sWiki = PBField.initString("");
    public final PBStringField sJumpUrl = PBField.initString("");
    public final PBBytesField sCdbRes = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field iNeedCheckLBS = PBField.initInt32(0);
    public final PBStringField sImageId = PBField.initString("");
}
