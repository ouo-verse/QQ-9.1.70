package com.tencent.gdtad.basics.config;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import km0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/gdtad/basics/config/AmsSplashAdConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lkm0/c;", "", "bytes", "c", "b", "<init>", "()V", "d", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AmsSplashAdConfigParser extends BaseConfigParser<c> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c defaultConfig() {
        return new c();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c parse(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        c cVar = new c();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(bytes, UTF_8);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD)");
        from.encodeString(cVar.getCONTENT_KEY(), str);
        QLog.d("AmsSplashAdConfigParser", 1, "configs parse\uff1a" + str);
        return cVar.i(str);
    }
}
