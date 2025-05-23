package com.tencent.trpcprotocol.miniapp.shenzhen_smart_city_support.shenzhen_smart_city_support;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class shenzhenSmartCitySupport$CheckAlphaUserRsp extends MessageMicro<shenzhenSmartCitySupport$CheckAlphaUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_alpha_user"}, new Object[]{Boolean.FALSE}, shenzhenSmartCitySupport$CheckAlphaUserRsp.class);
    public final PBBoolField is_alpha_user = PBField.initBool(false);
}
