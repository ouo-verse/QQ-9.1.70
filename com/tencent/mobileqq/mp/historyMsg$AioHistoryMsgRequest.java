package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class historyMsg$AioHistoryMsgRequest extends MessageMicro<historyMsg$AioHistoryMsgRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "msg_id", "msg_cnt"}, new Object[]{0L, 0L, 0}, historyMsg$AioHistoryMsgRequest.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt64Field msg_id = PBField.initUInt64(0);
    public final PBUInt32Field msg_cnt = PBField.initUInt32(0);
}
