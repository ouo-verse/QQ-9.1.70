package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$PromoteGroupView extends MessageMicro<OpenSdkRecCommon$PromoteGroupView> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"group_name", "items"}, new Object[]{"", null}, OpenSdkRecCommon$PromoteGroupView.class);
    public final PBStringField group_name = PBField.initString("");
    public final PBRepeatMessageField<OpenSdkRecCommon$PromoteViewItem> items = PBField.initRepeatMessage(OpenSdkRecCommon$PromoteViewItem.class);
}
