package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$TagInfo extends MessageMicro<giftMidgroundPanel$TagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48}, new String[]{"id", "name", "icon_url", c.G, "service", AlbumCacheData.CREATE_TIME}, new Object[]{0, "", "", 0, "", 0L}, giftMidgroundPanel$TagInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f381631id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBEnumField pos = PBField.initEnum(0);
    public final PBStringField service = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
}
