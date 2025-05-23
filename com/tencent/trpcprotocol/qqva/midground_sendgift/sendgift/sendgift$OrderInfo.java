package com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sendgift$OrderInfo extends MessageMicro<sendgift$OrderInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"sender", "recver", "gift_id", AlbumCacheData.CREATE_TIME, "polaris_services"}, new Object[]{null, null, 0L, 0L, ""}, sendgift$OrderInfo.class);
    public sendgift$Token sender = new sendgift$Token();
    public sendgift$Token recver = new sendgift$Token();
    public final PBInt64Field gift_id = PBField.initInt64(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBStringField polaris_services = PBField.initString("");
}
