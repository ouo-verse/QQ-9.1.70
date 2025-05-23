package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$VersionInfo extends MessageMicro<giftMidgroundPanel$VersionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"user_id", "msg", AlbumCacheData.CREATE_TIME}, new Object[]{"", "", 0L}, giftMidgroundPanel$VersionInfo.class);
    public final PBStringField user_id = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381632msg = PBField.initString("");
    public final PBInt64Field create_time = PBField.initInt64(0);
}
