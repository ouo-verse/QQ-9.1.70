package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.tav.core.AssetExtension;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$GroupGiftItem extends MessageMicro<giftList$GroupGiftItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 56, 66, 74, 82}, new String[]{"giftId", "giftName", "giftType", "price", AssetExtension.SCENE_THUMBNAIL, "backgroundImage", "dynamiclevel", "sendAnimation", "arkBgImage", "sendIosAnimation"}, new Object[]{0, "", 0, 0, "", "", 0, "", "", ""}, giftList$GroupGiftItem.class);
    public final PBUInt32Field giftId = PBField.initUInt32(0);
    public final PBStringField giftName = PBField.initString("");
    public final PBEnumField giftType = PBField.initEnum(0);
    public final PBUInt32Field price = PBField.initUInt32(0);
    public final PBStringField thumbnail = PBField.initString("");
    public final PBStringField backgroundImage = PBField.initString("");
    public final PBEnumField dynamiclevel = PBField.initEnum(0);
    public final PBStringField sendAnimation = PBField.initString("");
    public final PBStringField arkBgImage = PBField.initString("");
    public final PBStringField sendIosAnimation = PBField.initString("");
}
