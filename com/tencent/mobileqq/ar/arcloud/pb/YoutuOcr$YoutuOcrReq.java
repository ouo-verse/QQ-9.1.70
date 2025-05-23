package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YoutuOcr$YoutuOcrReq extends MessageMicro<YoutuOcr$YoutuOcrReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin32_timeout_ms", IjkMediaMeta.IJKM_KEY_LANGUAGE}, new Object[]{0, ""}, YoutuOcr$YoutuOcrReq.class);
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
    public final PBStringField language = PBField.initString("");
}
