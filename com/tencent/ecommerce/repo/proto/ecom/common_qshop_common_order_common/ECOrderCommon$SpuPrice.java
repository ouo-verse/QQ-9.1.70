package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes31.dex */
public final class ECOrderCommon$SpuPrice extends MessageMicro<ECOrderCommon$SpuPrice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{Element.ELEMENT_NAME_MIN, "max", TtmlNode.ATTR_TTS_ORIGIN}, new Object[]{0L, 0L, 0L}, ECOrderCommon$SpuPrice.class);
    public final PBInt64Field min = PBField.initInt64(0);
    public final PBInt64Field max = PBField.initInt64(0);
    public final PBInt64Field origin = PBField.initInt64(0);
}
