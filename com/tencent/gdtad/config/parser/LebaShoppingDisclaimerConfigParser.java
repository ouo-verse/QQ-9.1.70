package com.tencent.gdtad.config.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.m;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/gdtad/config/parser/LebaShoppingDisclaimerConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/gdtad/config/data/m;", "b", "", "content", "c", "<init>", "()V", "d", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class LebaShoppingDisclaimerConfigParser extends BaseConfigParser<m> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f109161e = "LebaShoppingDisclaimerConfigParser";

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m defaultConfig() {
        return new m();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        m mVar = new m();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        QLog.d(f109161e, 1, "configs parse\uff1a" + content);
        return mVar.b(str);
    }
}
