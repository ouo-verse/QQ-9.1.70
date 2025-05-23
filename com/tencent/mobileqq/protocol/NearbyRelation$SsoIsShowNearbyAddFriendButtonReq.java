package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyRelation$SsoIsShowNearbyAddFriendButtonReq extends MessageMicro<NearbyRelation$SsoIsShowNearbyAddFriendButtonReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"to_tiny_id"}, new Object[]{0L}, NearbyRelation$SsoIsShowNearbyAddFriendButtonReq.class);
    public final PBUInt64Field to_tiny_id = PBField.initUInt64(0);
}
