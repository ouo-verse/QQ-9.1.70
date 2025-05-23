package com.tencent.mobileqq.search.config;

import ap2.e;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/config/SearchOptConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lap2/e;", "b", "", "content", "c", "<init>", "()V", "d", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchOptConfigParser extends BaseConfigParser<e> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e defaultConfig() {
        return new e();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        e eVar = new e();
        try {
            if (content.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                String str = new String(content, UTF_8);
                eVar = e.INSTANCE.a(str);
                QLog.i("SearchOptConfigParser", 1, "parse, configString=" + str + ", config=" + eVar + ", config.hash=" + eVar.hashCode());
            } else {
                QLog.i("SearchOptConfigParser", 1, "parse, configString is empty");
            }
        } catch (Exception e16) {
            QLog.e("SearchOptConfigParser", 1, "parse, Exception=" + e16);
        }
        QLog.i("SearchOptConfigParser", 1, "parse, defaultConfig=" + eVar + ", config.hash=" + eVar.hashCode());
        return eVar;
    }
}
