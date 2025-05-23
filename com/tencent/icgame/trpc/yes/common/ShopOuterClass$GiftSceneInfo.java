package com.tencent.icgame.trpc.yes.common;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$GiftSceneInfo extends MessageMicro<ShopOuterClass$GiftSceneInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"scene", QCircleSchemeAttr.CoverFeed.SOURCE_TYPE}, new Object[]{1, 1}, ShopOuterClass$GiftSceneInfo.class);
    public final PBEnumField scene = PBField.initEnum(1);
    public final PBEnumField source_type = PBField.initEnum(1);
}
