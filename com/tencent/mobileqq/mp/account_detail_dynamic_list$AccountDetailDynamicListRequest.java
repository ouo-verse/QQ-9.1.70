package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class account_detail_dynamic_list$AccountDetailDynamicListRequest extends MessageMicro<account_detail_dynamic_list$AccountDetailDynamicListRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"versionInfo", IPublicAccountBrowser.KEY_PUB_UIN, "last_msg_id", "msg_cnt"}, new Object[]{"", 0L, 0L, 0}, account_detail_dynamic_list$AccountDetailDynamicListRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt64Field last_msg_id = PBField.initUInt64(0);
    public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
}
