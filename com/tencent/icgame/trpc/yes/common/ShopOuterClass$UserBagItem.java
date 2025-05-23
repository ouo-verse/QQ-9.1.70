package com.tencent.icgame.trpc.yes.common;

import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$UserBagItem extends MessageMicro<ShopOuterClass$UserBagItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"props_id", WidgetCacheConstellationData.NUM, VasQQSettingMeImpl.EXPIRE_TIME, AlbumCacheData.CREATE_TIME}, new Object[]{0, 0, 0, 0}, ShopOuterClass$UserBagItem.class);
    public final PBInt32Field props_id = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
}
