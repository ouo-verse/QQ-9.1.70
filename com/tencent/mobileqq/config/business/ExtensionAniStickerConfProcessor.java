package com.tencent.mobileqq.config.business;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class ExtensionAniStickerConfProcessor extends BaseConfigParser<oa1.c> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public oa1.c defaultConfig() {
        return new oa1.c();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable oa1.c cVar) {
        super.doOnConfigUpdate(cVar);
        if (QLog.isDevelopLevel()) {
            QLog.d("ExtensionAniStickerConfigParser", 4, "doOnConfigUpdate");
        }
        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(Arrays.asList(6, 7));
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public oa1.c parse(@NonNull byte[] bArr) {
        return oa1.c.a(new String(bArr, StandardCharsets.UTF_8));
    }
}
