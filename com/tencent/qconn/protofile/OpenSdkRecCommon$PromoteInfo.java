package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$PromoteInfo extends MessageMicro<OpenSdkRecCommon$PromoteInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"banner", "groups"}, new Object[]{null, null}, OpenSdkRecCommon$PromoteInfo.class);
    public OpenSdkRecCommon$PromoteBannerInfo banner = new OpenSdkRecCommon$PromoteBannerInfo();
    public final PBRepeatMessageField<OpenSdkRecCommon$PromoteGroupView> groups = PBField.initRepeatMessage(OpenSdkRecCommon$PromoteGroupView.class);
}
