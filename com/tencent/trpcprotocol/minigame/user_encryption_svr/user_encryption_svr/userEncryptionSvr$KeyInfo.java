package com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userEncryptionSvr$KeyInfo extends MessageMicro<userEncryptionSvr$KeyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"encrypt_key", "iv", "version", "expire_in", AlbumCacheData.CREATE_TIME}, new Object[]{"", "", 0L, 0L, 0L}, userEncryptionSvr$KeyInfo.class);
    public final PBStringField encrypt_key = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f381589iv = PBField.initString("");
    public final PBInt64Field version = PBField.initInt64(0);
    public final PBInt64Field expire_in = PBField.initInt64(0);
    public final PBInt64Field create_time = PBField.initInt64(0);
}
