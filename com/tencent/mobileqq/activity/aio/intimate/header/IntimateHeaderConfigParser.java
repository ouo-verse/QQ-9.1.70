package com.tencent.mobileqq.activity.aio.intimate.header;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.activity.aio.intimate.header.h;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/h;", "b", "", "content", "c", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimateHeaderConfigParser extends BaseConfigParser<h> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h defaultConfig() {
        return new h();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        h.Companion companion = h.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        h a16 = companion.a(new String(content, UTF_8));
        QLog.d("IntimateHeaderConfigParser", 1, "configs parse\uff1a" + a16);
        return a16;
    }
}
