package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$MaterialResource extends MessageMicro<giftMidgroundPanel$MaterialResource> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"animations", "images", "res_url_prefix"}, new Object[]{null, null, ""}, giftMidgroundPanel$MaterialResource.class);
    public final PBRepeatMessageField<giftMidgroundPanel$MapFieldEntry> animations = PBField.initRepeatMessage(giftMidgroundPanel$MapFieldEntry.class);
    public final PBRepeatMessageField<giftMidgroundPanel$MapFieldEntry> images = PBField.initRepeatMessage(giftMidgroundPanel$MapFieldEntry.class);
    public final PBStringField res_url_prefix = PBField.initString("");
}
