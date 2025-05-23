package com.tencent.trpcprotocol.zplan.user_info_ext.user_info_ext;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.trpcprotocol.zplan.user_info.set_pb.setPb$ReqBody;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userInfoExt$DCBackImageReq extends MessageMicro<userInfoExt$DCBackImageReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"dc_back_images", "user_info", "handle_type"}, new Object[]{null, null, 0}, userInfoExt$DCBackImageReq.class);
    public userInfoExt$DCBackImages dc_back_images = new userInfoExt$DCBackImages();
    public setPb$ReqBody user_info = new setPb$ReqBody();
    public final PBEnumField handle_type = PBField.initEnum(0);
}
