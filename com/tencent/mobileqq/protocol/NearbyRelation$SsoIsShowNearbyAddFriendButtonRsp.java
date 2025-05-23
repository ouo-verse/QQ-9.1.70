package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyRelation$SsoIsShowNearbyAddFriendButtonRsp extends MessageMicro<NearbyRelation$SsoIsShowNearbyAddFriendButtonRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret_code", "ret_msg", "is_show"}, new Object[]{0, "", Boolean.FALSE}, NearbyRelation$SsoIsShowNearbyAddFriendButtonRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField is_show = PBField.initBool(false);
}
