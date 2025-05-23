package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAtElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProEmojiElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGroupElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProImageElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProParagraph;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopicElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProURLElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProVideoElem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\"\u0010#J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0002j\b\u0012\u0004\u0012\u00020\u0018`\u0004R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/j;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/c;", "Lkotlin/collections/ArrayList;", "richSpans", "", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/a;", "currentItem", "Landroid/text/SpannableStringBuilder;", "currentSpan", "previousItem", "previousSpan", "", "d", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "parseParam", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "b", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProParagraph;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProParagraph;", "paragraph", "", "I", "pIndex", "Ljava/util/ArrayList;", "feedItems", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProParagraph;ILcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProParagraph paragraph;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int pIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a> feedItems;

    public j(@NotNull GProParagraph paragraph, int i3, @NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        this.paragraph = paragraph;
        this.pIndex = i3;
        this.feedItems = new ArrayList<>();
        e(stFeed);
    }

    private final boolean c() {
        Iterator<a> it = this.feedItems.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof k) {
                return true;
            }
        }
        return false;
    }

    private final boolean d(a currentItem, SpannableStringBuilder currentSpan, a previousItem, SpannableStringBuilder previousSpan) {
        boolean z16;
        if (!com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.g(previousSpan) && !com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.n(currentSpan)) {
            if (currentItem.e()) {
                return true;
            }
            if (previousItem != null && previousItem.e()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final void f(ArrayList<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> richSpans) {
        if (richSpans.isEmpty()) {
            return;
        }
        if (richSpans.size() == 1 && !c()) {
            Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it = richSpans.iterator();
            while (it.hasNext()) {
                it.next().t(3);
            }
            return;
        }
        Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it5 = richSpans.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c next = it5.next();
            if (next.i() instanceof BaseLongFeedViewAdapter) {
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g i3 = next.i();
                Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.BaseLongFeedViewAdapter");
                if (((BaseLongFeedViewAdapter) i3).l()) {
                    next.t(3);
                }
            }
            next.t(1);
        }
    }

    @NotNull
    public final ArrayList<IFeedDetailDataParser.MediaInfo> a() {
        IFeedDetailDataParser.MediaInfo mediaInfo;
        ArrayList<IFeedDetailDataParser.MediaInfo> arrayList = new ArrayList<>();
        Iterator<a> it = this.feedItems.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof b) {
                b bVar = (b) next;
                if (bVar.a() && (mediaInfo = bVar.getMediaInfo()) != null) {
                    arrayList.add(mediaInfo);
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final LongFeedUIData b(@NotNull LongFeedParseParam parseParam) {
        Intrinsics.checkNotNullParameter(parseParam, "parseParam");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> arrayList = new ArrayList<>();
        Iterator<a> it = this.feedItems.iterator();
        a aVar = null;
        com.tencent.aio.widget.textView.view.b bVar = null;
        boolean z16 = false;
        while (it.hasNext()) {
            a item = it.next();
            LongFeedUIData i3 = item.i(parseParam);
            Intrinsics.checkNotNullExpressionValue(item, "item");
            if (d(item, i3.getSpannable(), aVar, spannableStringBuilder)) {
                spannableStringBuilder.append(" ");
            }
            spannableStringBuilder.append((CharSequence) i3.getSpannable());
            arrayList.addAll(i3.b());
            if (i3.getTouchMovementMethod() != null) {
                bVar = i3.getTouchMovementMethod();
            }
            if (i3.getHasItalicText()) {
                z16 = true;
            }
            aVar = item;
        }
        int i16 = this.paragraph.props.alignment;
        if (i16 == 1) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, spannableStringBuilder.length(), 33);
        } else if (i16 == 2) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE), 0, spannableStringBuilder.length(), 33);
        }
        f(arrayList);
        return new LongFeedUIData(spannableStringBuilder, arrayList, bVar, z16);
    }

    public final void e(@NotNull GProStFeed stFeed) {
        a kVar;
        a cVar;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Iterator<GProElem> it = this.paragraph.elems.iterator();
        int i3 = 0;
        while (true) {
            int i16 = i3;
            if (it.hasNext()) {
                i3 = i16 + 1;
                GProElem next = it.next();
                switch (next.type) {
                    case 1:
                        GProTextElem gProTextElem = next.text;
                        Intrinsics.checkNotNullExpressionValue(gProTextElem, "elem.text");
                        kVar = new k(gProTextElem, i16, this.pIndex);
                        break;
                    case 2:
                        GProImageElem gProImageElem = next.image;
                        Intrinsics.checkNotNullExpressionValue(gProImageElem, "elem.image");
                        kVar = new g(gProImageElem, i16, this.pIndex);
                        break;
                    case 3:
                        GProVideoElem gProVideoElem = next.video;
                        Intrinsics.checkNotNullExpressionValue(gProVideoElem, "elem.video");
                        kVar = new o(gProVideoElem, i16, this.pIndex);
                        break;
                    case 4:
                        GProURLElem gProURLElem = next.url;
                        Intrinsics.checkNotNullExpressionValue(gProURLElem, "elem.url");
                        kVar = new n(gProURLElem, i16, this.pIndex);
                        break;
                    case 5:
                        GProEmojiElem gProEmojiElem = next.emoji;
                        Intrinsics.checkNotNullExpressionValue(gProEmojiElem, "elem.emoji");
                        kVar = new e(gProEmojiElem, i16, this.pIndex);
                        break;
                    case 6:
                        GProAtElem gProAtElem = next.f359287at;
                        Intrinsics.checkNotNullExpressionValue(gProAtElem, "elem.at");
                        cVar = new c(gProAtElem, String.valueOf(stFeed.channelInfo.sign.channelId), String.valueOf(stFeed.channelInfo.sign.guildId), i16, this.pIndex);
                        break;
                    case 7:
                        GProChannelElem gProChannelElem = next.channel;
                        Intrinsics.checkNotNullExpressionValue(gProChannelElem, "elem.channel");
                        kVar = new d(gProChannelElem, i16, this.pIndex);
                        break;
                    case 8:
                        GProTopicElem gProTopicElem = next.topic;
                        Intrinsics.checkNotNullExpressionValue(gProTopicElem, "elem.topic");
                        kVar = new l(gProTopicElem, i16, this.pIndex, String.valueOf(stFeed.channelInfo.sign.guildId));
                        break;
                    case 9:
                        GProGroupElem gProGroupElem = next.group;
                        Intrinsics.checkNotNullExpressionValue(gProGroupElem, "elem.group");
                        kVar = new f(gProGroupElem, i16, this.pIndex);
                        break;
                    case 10:
                        cVar = new i(i16, this.pIndex);
                        break;
                    default:
                        cVar = null;
                        break;
                }
                cVar = kVar;
                if (cVar != null) {
                    this.feedItems.add(cVar);
                }
            } else {
                return;
            }
        }
    }
}
