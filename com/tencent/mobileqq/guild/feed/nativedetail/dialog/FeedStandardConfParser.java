package com.tencent.mobileqq.guild.feed.nativedetail.dialog;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ul1.a;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/dialog/FeedStandardConfParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lul1/a;", "", "content", "c", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedStandardConfParser extends BaseConfigParser<a> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        String string = BaseApplication.context.getResources().getString(R.string.f170933zy0);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_standard_dialog_content)");
        return new a(string);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        a.Companion companion = a.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return companion.a(new String(content, UTF_8));
    }
}
