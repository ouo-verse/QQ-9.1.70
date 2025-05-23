package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat;

import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentWithStyle;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProParagraph;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qj1.e;
import qj1.l;
import qj1.m;
import qj1.r;
import qj1.t;
import qj1.v;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0017\u0010\u0011\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/compat/FeedDetailMainDisplayableParser;", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser;", "", "Lcom/tencent/mobileqq/guild/api/IFeedDetailDataParser$MediaInfo;", "getMediaInfoList", "", "getFeedId", "", "getContentData", "getTitleData", "getGuildId", "getChannelId", "getAnchorUid", "getAnchorNick", "", "getCreateTime", "Lvk1/b;", "feed", "Lvk1/b;", "getFeed", "()Lvk1/b;", "mediaInfos$delegate", "Lkotlin/Lazy;", "a", "()Ljava/util/List;", "mediaInfos", "<init>", "(Lvk1/b;)V", "Companion", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailMainDisplayableParser implements IFeedDetailDataParser {
    public static final int EMOJI_SIZE = 13;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;

    @NotNull
    private final vk1.b feed;

    /* renamed from: mediaInfos$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaInfos;

    public FeedDetailMainDisplayableParser(@NotNull vk1.b feed) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends IFeedDetailDataParser.MediaInfo>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser$mediaInfos$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends IFeedDetailDataParser.MediaInfo> invoke() {
                IFeedDetailDataParser.MediaInfo mediaInfo;
                String a16;
                m a17;
                String a18;
                GProContentWithStyle gProContentWithStyle;
                if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(FeedDetailMainDisplayableParser.this.getFeed().getFeedType())) {
                    Object a19 = FeedDetailMainDisplayableParser.this.getFeed().a();
                    ArrayList<GProParagraph> arrayList = null;
                    GProStFeed gProStFeed = a19 instanceof GProStFeed ? (GProStFeed) a19 : null;
                    if (gProStFeed != null && (gProContentWithStyle = gProStFeed.contentWithStyle) != null) {
                        arrayList = gProContentWithStyle.paragraphs;
                    }
                    if (!(arrayList == null || arrayList.isEmpty())) {
                        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.b.f221426a;
                        Object a26 = FeedDetailMainDisplayableParser.this.getFeed().a();
                        Intrinsics.checkNotNull(a26, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
                        return bVar.b((GProStFeed) a26);
                    }
                }
                List<l> c16 = FeedDetailMainDisplayableParser.this.getFeed().c();
                LinkedList linkedList = new LinkedList();
                for (l lVar : c16) {
                    if (lVar.getType() != 1 && lVar.getType() != 3) {
                        v e16 = new MediaRawDataAdapterFactory().e(lVar.a());
                        mediaInfo = new IFeedDetailDataParser.MediaInfo((e16 == null || (a17 = e16.a()) == null || (a18 = a17.a(3)) == null) ? "" : a18, 1, e16 != null ? e16.getDurationMs() : 0L, lVar.getWidth(), lVar.getHeight(), 0, 32, null);
                    } else {
                        m d16 = new MediaRawDataAdapterFactory().d(lVar.a());
                        mediaInfo = new IFeedDetailDataParser.MediaInfo((d16 == null || (a16 = d16.a(3)) == null) ? "" : a16, 0, 0L, lVar.getWidth(), lVar.getHeight(), 0, 32, null);
                    }
                    linkedList.add(mediaInfo);
                }
                for (r rVar : FeedDetailMainDisplayableParser.this.getFeed().H()) {
                    linkedList.add(new IFeedDetailDataParser.MediaInfo(rVar.getCover(), 1, rVar.getDuration() * 1000, 0.0f, 0.0f, 0, 32, null));
                }
                for (t tVar : FeedDetailMainDisplayableParser.this.getFeed().h()) {
                    linkedList.add(new IFeedDetailDataParser.MediaInfo(tVar.getCoverUrl(), 1, tVar.getDuration() * 1000, 0.0f, 0.0f, tVar.getUrlType()));
                }
                return linkedList;
            }
        });
        this.mediaInfos = lazy;
    }

    private final List<IFeedDetailDataParser.MediaInfo> a() {
        return (List) this.mediaInfos.getValue();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getAnchorNick() {
        String L = this.feed.L();
        if (L == null) {
            return "";
        }
        return L;
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getAnchorUid() {
        return this.feed.r();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getChannelId() {
        return String.valueOf(this.feed.getChannelId());
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public CharSequence getContentData() {
        List listOf;
        vk1.b bVar = this.feed;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 7, 8, 9});
        return (CharSequence) e.a.a(bVar, null, listOf, 13, null, 9, null).getFirst();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    public long getCreateTime() {
        return this.feed.getCreateTime();
    }

    @NotNull
    public final vk1.b getFeed() {
        return this.feed;
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getFeedId() {
        return this.feed.getFeedId();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public String getGuildId() {
        return String.valueOf(this.feed.getGuildId());
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public List<IFeedDetailDataParser.MediaInfo> getMediaInfoList() {
        return a();
    }

    @Override // com.tencent.mobileqq.guild.api.IFeedDetailDataParser
    @NotNull
    public CharSequence getTitleData() {
        return this.feed.v();
    }
}
