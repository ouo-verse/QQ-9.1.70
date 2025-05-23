package com.tencent.pb.vipdata;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class userdata$NumberItem extends MessageMicro<userdata$NumberItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"number_itemid", "number_idx", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{0, 0, null}, userdata$NumberItem.class);
    public final PBInt32Field number_itemid = PBField.initInt32(0);
    public final PBInt32Field number_idx = PBField.initInt32(0);
    public userdata$Item item = new userdata$Item();
}
