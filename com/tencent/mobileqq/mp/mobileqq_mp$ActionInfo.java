package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ActionInfo extends MessageMicro<mobileqq_mp$ActionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, PublicAccountMessageUtilImpl.ITEM_I_ACTION_DATA, PublicAccountMessageUtilImpl.ITEM_A_ACTION_DATA, "appid"}, new Object[]{"", "", "", 0}, mobileqq_mp$ActionInfo.class);
    public final PBStringField actionData = PBField.initString("");
    public final PBStringField i_actionData = PBField.initString("");
    public final PBStringField a_actionData = PBField.initString("");
    public final PBUInt32Field appid = PBField.initUInt32(0);
}
