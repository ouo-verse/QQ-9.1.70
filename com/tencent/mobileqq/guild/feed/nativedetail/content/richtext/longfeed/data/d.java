package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextChannelContent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "i", "", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProChannelElem;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProChannelElem;", "channelElem", "", "b", "I", "getIndex", "()I", "index", "c", "getParagraphIndex", "paragraphIndex", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProChannelElem;II)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProChannelElem channelElem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int paragraphIndex;

    public d(@NotNull GProChannelElem channelElem, int i3, int i16) {
        Intrinsics.checkNotNullParameter(channelElem, "channelElem");
        this.channelElem = channelElem;
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
        Integer num;
        String str;
        Long l3;
        Long l16;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelInfo gProStChannelInfo2;
        GProStChannelSign gProStChannelSign;
        GProStChannelInfo gProStChannelInfo3;
        GProStChannelSign gProStChannelSign2;
        GProStChannelInfo gProStChannelInfo4;
        GProStChannelInfo gProStChannelInfo5;
        GProStChannelSign gProStChannelSign3;
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        GProStRichTextChannelContent gProStRichTextChannelContent = this.channelElem.channelContent;
        Boolean bool = null;
        if (gProStRichTextChannelContent != null && (gProStChannelInfo5 = gProStRichTextChannelContent.channelInfo) != null && (gProStChannelSign3 = gProStChannelInfo5.sign) != null) {
            num = Integer.valueOf(gProStChannelSign3.channelType);
        } else {
            num = null;
        }
        GProStRichTextChannelContent gProStRichTextChannelContent2 = this.channelElem.channelContent;
        if (gProStRichTextChannelContent2 != null && (gProStChannelInfo4 = gProStRichTextChannelContent2.channelInfo) != null) {
            str = gProStChannelInfo4.name;
        } else {
            str = null;
        }
        if (gProStRichTextChannelContent2 != null && (gProStChannelInfo3 = gProStRichTextChannelContent2.channelInfo) != null && (gProStChannelSign2 = gProStChannelInfo3.sign) != null) {
            l3 = Long.valueOf(gProStChannelSign2.channelId);
        } else {
            l3 = null;
        }
        String valueOf = String.valueOf(l3);
        GProStRichTextChannelContent gProStRichTextChannelContent3 = this.channelElem.channelContent;
        if (gProStRichTextChannelContent3 != null && (gProStChannelInfo2 = gProStRichTextChannelContent3.channelInfo) != null && (gProStChannelSign = gProStChannelInfo2.sign) != null) {
            l16 = Long.valueOf(gProStChannelSign.guildId);
        } else {
            l16 = null;
        }
        String valueOf2 = String.valueOf(l16);
        GProStRichTextChannelContent gProStRichTextChannelContent4 = this.channelElem.channelContent;
        if (gProStRichTextChannelContent4 != null && (gProStChannelInfo = gProStRichTextChannelContent4.channelInfo) != null) {
            bool = Boolean.valueOf(gProStChannelInfo.isSquare);
        }
        JumpGuildParam.JoinInfoParam joinInfoParam = parseParam.getJoinInfoParam();
        IParseRichTextConfig<GProElem> g16 = parseParam.g();
        Boolean bool2 = Boolean.TRUE;
        return new LongFeedUIData(spannableStringBuilder, new ArrayList(), feedRichTextContentParser.i(num, str, valueOf, valueOf2, bool, joinInfoParam, spannableStringBuilder, g16, new Pair<>(bool2, bool2)), false, 8, null);
    }
}
