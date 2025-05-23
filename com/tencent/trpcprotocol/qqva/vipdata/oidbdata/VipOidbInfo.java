package com.tencent.trpcprotocol.qqva.vipdata.oidbdata;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VipOidbInfo extends MessageMicro<VipOidbInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField is_vip = PBField.initBool(false);
    public final PBBoolField is_svip = PBField.initBool(false);
    public final PBBoolField is_yearvip = PBField.initBool(false);
    public final PBBoolField is_bigvip = PBField.initBool(false);
    public final PBBoolField is_bigyearvip = PBField.initBool(false);
    public final PBInt32Field vip_level = PBField.initInt32(0);
    public final PBInt32Field bigvip_level = PBField.initInt32(0);

    static {
        String[] strArr = {WidgetCacheQzoneVipData.ISVIP, "is_svip", "is_yearvip", "is_bigvip", "is_bigyearvip", "vip_level", "bigvip_level"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, strArr, new Object[]{bool, bool, bool, bool, bool, 0, 0}, VipOidbInfo.class);
    }
}
