package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YoutuOcr$Language extends MessageMicro<YoutuOcr$Language> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{IjkMediaMeta.IJKM_KEY_LANGUAGE, "language_desc"}, new Object[]{"", ""}, YoutuOcr$Language.class);
    public final PBStringField language = PBField.initString("");
    public final PBStringField language_desc = PBField.initString("");
}
