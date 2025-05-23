package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CommonOuterClass$StoreGroupDataList extends MessageMicro<CommonOuterClass$StoreGroupDataList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"group_data_list"}, new Object[]{null}, CommonOuterClass$StoreGroupDataList.class);
    public final PBRepeatMessageField<CommonOuterClass$GroupData> group_data_list = PBField.initRepeatMessage(CommonOuterClass$GroupData.class);
}
