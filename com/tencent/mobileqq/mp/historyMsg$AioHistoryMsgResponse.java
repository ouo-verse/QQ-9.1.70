package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class historyMsg$AioHistoryMsgResponse extends MessageMicro<historyMsg$AioHistoryMsgResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ret_info", IPublicAccountBrowser.KEY_PUB_UIN, "msg_infos"}, new Object[]{null, 0L, ByteStringMicro.EMPTY}, historyMsg$AioHistoryMsgResponse.class);
    public historyMsg$RetInfo ret_info = new historyMsg$RetInfo();
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBRepeatField<ByteStringMicro> msg_infos = PBField.initRepeat(PBBytesField.__repeatHelper__);
}
