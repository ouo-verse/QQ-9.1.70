package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextAtContent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/c;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAtElem;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAtElem;", "atElem", "", "b", "Ljava/lang/String;", "channelId", "c", "guildId", "", "d", "I", "getIndex", "()I", "index", "getParagraphIndex", "paragraphIndex", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAtElem;Ljava/lang/String;Ljava/lang/String;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProAtElem atElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    public c(@NotNull GProAtElem atElem, @NotNull String channelId, @NotNull String guildId, int i3, int i16) {
        Intrinsics.checkNotNullParameter(atElem, "atElem");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.atElem = atElem;
        this.channelId = channelId;
        this.guildId = guildId;
        this.index = i3;
        this.paragraphIndex = i16;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h
    public int b() {
        return a.C7760a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    public boolean e() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a
    @NotNull
    public LongFeedUIData i(@NotNull LongFeedParseParam parseParam) {
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        String str = this.channelId;
        String str2 = this.guildId;
        GProStRichTextAtContent gProStRichTextAtContent = this.atElem.atContent;
        int i3 = gProStRichTextAtContent.type;
        String str3 = gProStRichTextAtContent.user.nick;
        Intrinsics.checkNotNullExpressionValue(str3, "atElem.atContent.user.nick");
        String str4 = this.atElem.atContent.user.idd;
        Intrinsics.checkNotNullExpressionValue(str4, "atElem.atContent.user.idd");
        String str5 = this.atElem.atContent.roleGroupId.name;
        Intrinsics.checkNotNullExpressionValue(str5, "atElem.atContent.roleGroupId.name");
        String str6 = this.atElem.atContent.guildInfo.name;
        Intrinsics.checkNotNullExpressionValue(str6, "atElem.atContent.guildInfo.name");
        IParseRichTextConfig<GProElem> g16 = parseParam.g();
        Boolean bool = Boolean.TRUE;
        return new LongFeedUIData(spannableStringBuilder, new ArrayList(), feedRichTextContentParser.h(str, str2, i3, str3, str4, str5, str6, spannableStringBuilder, g16, new Pair<>(bool, bool)), false, 8, null);
    }
}
