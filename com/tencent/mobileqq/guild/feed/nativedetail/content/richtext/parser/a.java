package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0005"}, d2 = {"T", "", "contents", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/b;", "a", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @Nullable
    public static final <T> b<T> a(@NotNull List<? extends T> contents) {
        Object first;
        Intrinsics.checkNotNullParameter(contents, "contents");
        if (!contents.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) contents);
            if (first instanceof GProStRichTextContent) {
                GProStRichTextIContentParser gProStRichTextIContentParser = GProStRichTextIContentParser.f221623a;
                Intrinsics.checkNotNull(gProStRichTextIContentParser, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IContentParserStrategy<T of com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.ContentParserStrategyKt.getRichTextParserStrategyFor>");
                return gProStRichTextIContentParser;
            }
            if (!(first instanceof IGProMVPRichTextContent)) {
                return null;
            }
            GProMVPRichTextIContentParser gProMVPRichTextIContentParser = GProMVPRichTextIContentParser.f221622a;
            Intrinsics.checkNotNull(gProMVPRichTextIContentParser, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IContentParserStrategy<T of com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.ContentParserStrategyKt.getRichTextParserStrategyFor>");
            return gProMVPRichTextIContentParser;
        }
        return null;
    }
}
