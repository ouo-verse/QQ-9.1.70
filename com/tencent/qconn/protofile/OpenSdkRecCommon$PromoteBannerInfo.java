package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class OpenSdkRecCommon$PromoteBannerInfo extends MessageMicro<OpenSdkRecCommon$PromoteBannerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"icon_url", "prompt_word", "prompt_title"}, new Object[]{"", "", ""}, OpenSdkRecCommon$PromoteBannerInfo.class);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField prompt_word = PBField.initString("");
    public final PBStringField prompt_title = PBField.initString("");
}
