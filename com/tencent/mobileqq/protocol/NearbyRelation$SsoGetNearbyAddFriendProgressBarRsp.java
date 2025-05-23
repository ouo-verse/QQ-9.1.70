package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes35.dex */
public final class NearbyRelation$SsoGetNearbyAddFriendProgressBarRsp extends MessageMicro<NearbyRelation$SsoGetNearbyAddFriendProgressBarRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 58}, new String[]{"ret_code", "ret_msg", "is_show", "sub_title", "max_len", "current_progress", "progress_bar_text"}, new Object[]{0, "", Boolean.FALSE, "", 0, 0, ""}, NearbyRelation$SsoGetNearbyAddFriendProgressBarRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField is_show = PBField.initBool(false);
    public final PBStringField sub_title = PBField.initString("");
    public final PBUInt32Field max_len = PBField.initUInt32(0);
    public final PBUInt32Field current_progress = PBField.initUInt32(0);
    public final PBStringField progress_bar_text = PBField.initString("");
}
