package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data;

import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.parser.LongFeedTextParser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u00072\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0013\u0010\rR6\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "", "", "patternId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", tl.h.F, "Ljava/util/LinkedList;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "a", "Ljava/util/LinkedList;", "f", "()Ljava/util/LinkedList;", "textContents", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextURLContent;", "b", "g", "thirdVideos", "e", "tencentDocs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "k", "(Ljava/util/ArrayList;)V", "images", "videos", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "channelId", "getGuildId", "j", "guildId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedInfo {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<LongFeedTextParser> f221428i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<GProStRichTextContent> textContents = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<GProStRichTextURLContent> thirdVideos = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<GProStRichTextURLContent> tencentDocs = new LinkedList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<GProStImage> images;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<GProStVideo> videos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String channelId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo$a;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/LongFeedInfo;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedTextParser;", "textParser$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/parser/LongFeedTextParser;", "textParser", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final LongFeedTextParser b() {
            return (LongFeedTextParser) LongFeedInfo.f221428i.getValue();
        }

        @NotNull
        public final LongFeedInfo a(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            LongFeedInfo longFeedInfo = new LongFeedInfo();
            Iterator<GProStRichTextContent> it = stFeed.contents.contents.iterator();
            while (it.hasNext()) {
                GProStRichTextContent next = it.next();
                int i3 = next.urlContent.type;
                if (i3 == 3) {
                    longFeedInfo.e().offer(next.urlContent);
                } else if (i3 == 1) {
                    longFeedInfo.g().offer(next.urlContent);
                } else if (b().matchTextType(next.type)) {
                    longFeedInfo.f().offer(next);
                }
            }
            longFeedInfo.i(String.valueOf(stFeed.channelInfo.sign.channelId));
            longFeedInfo.j(String.valueOf(stFeed.channelInfo.sign.guildId));
            longFeedInfo.k(stFeed.images);
            longFeedInfo.videos = stFeed.videos;
            return longFeedInfo;
        }

        Companion() {
        }
    }

    static {
        Lazy<LongFeedTextParser> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LongFeedTextParser>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedInfo$Companion$textParser$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LongFeedTextParser invoke() {
                return new LongFeedTextParser();
            }
        });
        f221428i = lazy;
    }

    @Nullable
    public final GProStImage c(@NotNull String patternId) {
        Intrinsics.checkNotNullParameter(patternId, "patternId");
        ArrayList<GProStImage> arrayList = this.images;
        if (arrayList != null) {
            Iterator<GProStImage> it = arrayList.iterator();
            while (it.hasNext()) {
                GProStImage next = it.next();
                if (Intrinsics.areEqual(next.patternId, patternId)) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final ArrayList<GProStImage> d() {
        return this.images;
    }

    @NotNull
    public final LinkedList<GProStRichTextURLContent> e() {
        return this.tencentDocs;
    }

    @NotNull
    public final LinkedList<GProStRichTextContent> f() {
        return this.textContents;
    }

    @NotNull
    public final LinkedList<GProStRichTextURLContent> g() {
        return this.thirdVideos;
    }

    @Nullable
    public final GProStVideo h(@NotNull String patternId) {
        Intrinsics.checkNotNullParameter(patternId, "patternId");
        ArrayList<GProStVideo> arrayList = this.videos;
        if (arrayList != null) {
            Iterator<GProStVideo> it = arrayList.iterator();
            while (it.hasNext()) {
                GProStVideo next = it.next();
                if (Intrinsics.areEqual(next.patternId, patternId)) {
                    return next;
                }
            }
            return null;
        }
        return null;
    }

    public final void i(@Nullable String str) {
        this.channelId = str;
    }

    public final void j(@Nullable String str) {
        this.guildId = str;
    }

    public final void k(@Nullable ArrayList<GProStImage> arrayList) {
        this.images = arrayList;
    }
}
