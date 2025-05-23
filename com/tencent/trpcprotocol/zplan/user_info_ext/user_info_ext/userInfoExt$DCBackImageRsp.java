package com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userInfoExt$DCBackImageRsp extends MessageMicro<userInfoExt$DCBackImageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"all_images", "select_images", "xiaowo_photograph_schema"}, new Object[]{null, null, ""}, userInfoExt$DCBackImageRsp.class);
    public userInfoExt$DCBackImages all_images = new userInfoExt$DCBackImages();
    public userInfoExt$DCBackImage select_images = new userInfoExt$DCBackImage();
    public final PBStringField xiaowo_photograph_schema = PBField.initString("");
}
