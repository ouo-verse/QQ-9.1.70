package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class account_detail_dynamic_list$AccountDetailDynamicListResponse extends MessageMicro<account_detail_dynamic_list$AccountDetailDynamicListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"ret_info", IPublicAccountBrowser.KEY_PUB_UIN, "last_msg_id", "msg_cnt", "msg_infos"}, new Object[]{null, 0L, 0L, 0, ByteStringMicro.EMPTY}, account_detail_dynamic_list$AccountDetailDynamicListResponse.class);
    public account_detail_dynamic_list$RetInfo ret_info = new account_detail_dynamic_list$RetInfo();
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt64Field last_msg_id = PBField.initUInt64(0);
    public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> msg_infos = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
