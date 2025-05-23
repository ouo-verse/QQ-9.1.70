package com.tencent.trpcprotocol.qqva.vipdata.userdata;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class userdata$NumberItem extends MessageMicro<userdata$NumberItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"number_itemid", "number_idx", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME}, new Object[]{0, 0, null}, userdata$NumberItem.class);
    public final PBInt32Field number_itemid = PBField.initInt32(0);
    public final PBInt32Field number_idx = PBField.initInt32(0);
    public userdata$Item item = new MessageMicro<userdata$Item>() { // from class: com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$Item
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "itemid"}, new Object[]{0, 0}, userdata$Item.class);
        public final PBInt32Field appid = PBField.initInt32(0);
        public final PBInt32Field itemid = PBField.initInt32(0);
    };
}
