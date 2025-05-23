package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEmojiElem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/e;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProEmojiElem;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProEmojiElem;", "emojiElem", "", "b", "I", "getIndex", "()I", "index", "c", "getParagraphIndex", "paragraphIndex", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProEmojiElem;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProEmojiElem emojiElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    public e(@NotNull GProEmojiElem emojiElem, int i3, int i16) {
        Intrinsics.checkNotNullParameter(emojiElem, "emojiElem");
        this.emojiElem = emojiElem;
        this.index = i3;
        this.paragraphIndex = i16;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    public int b() {
        return a.C7760a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    public boolean e() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    @NotNull
    public LongFeedUIData i(@NotNull LongFeedParseParam parseParam) {
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        String str = this.emojiElem.emojiContent.idd;
        Intrinsics.checkNotNullExpressionValue(str, "emojiElem.emojiContent.idd");
        String str2 = this.emojiElem.emojiContent.type;
        Intrinsics.checkNotNullExpressionValue(str2, "emojiElem.emojiContent.type");
        return new LongFeedUIData(FeedRichTextContentParser.o(feedRichTextContentParser, str, str2, parseParam.g().getF221022d(), parseParam.g().h(), null, 16, null), new ArrayList(), null, false, 8, null);
    }
}
