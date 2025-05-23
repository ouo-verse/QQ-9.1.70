package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTopicContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopicElem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/l;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopicElem;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopicElem;", "topicElem", "", "b", "I", "getIndex", "()I", "index", "c", "getParagraphIndex", "paragraphIndex", "", "d", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProTopicElem;IILjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProTopicElem topicElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    public l(@NotNull GProTopicElem topicElem, int i3, int i16, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(topicElem, "topicElem");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.topicElem = topicElem;
        this.index = i3;
        this.paragraphIndex = i16;
        this.guildId = guildId;
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
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        Long valueOf = Long.valueOf(this.topicElem.topicContent.topicId);
        GProStRichTextTopicContent gProStRichTextTopicContent = this.topicElem.topicContent;
        String str = gProStRichTextTopicContent.topicName;
        String str2 = this.guildId;
        Integer valueOf2 = Integer.valueOf(gProStRichTextTopicContent.showStatus);
        IParseRichTextConfig<GProElem> g16 = parseParam.g();
        Boolean bool = Boolean.TRUE;
        return new LongFeedUIData(spannableStringBuilder, new ArrayList(), feedRichTextContentParser.u(valueOf, str, str2, valueOf2, spannableStringBuilder, g16, new Pair<>(bool, bool)), false, 8, null);
    }
}
