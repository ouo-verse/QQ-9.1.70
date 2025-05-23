package com.tencent.trpcprotocol.qqva.kuikly.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class VasProfileCard$ProfileCardData extends MessageMicro<VasProfileCard$ProfileCardData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"uin", "background_id", "color_screen_id"}, new Object[]{"", 0, 0}, VasProfileCard$ProfileCardData.class);
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field background_id = PBField.initInt32(0);
    public final PBInt32Field color_screen_id = PBField.initInt32(0);
}
