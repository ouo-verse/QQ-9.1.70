package com.tencent.mobileqq.guild.quicksearch.model;

import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\u0011\u0010&\"\u0004\b'\u0010(R$\u0010.\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010+\u001a\u0004\b\u0006\u0010,\"\u0004\b$\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/c;", "", "", "toString", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchFeedGroupInfo;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "g", "(Ljava/util/List;)V", "channelFilterList", "Lzg1/a;", "d", "i", "feedList", "c", "getHighLightWords", "k", "highLightWords", "", "J", "getFeedTotal", "()J", "j", "(J)V", "feedTotal", "", "e", "Z", "()Z", "l", "(Z)V", "noMoreFeed", "", "f", "[B", "()[B", h.F, "([B)V", "feedCookie", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildSearchAISearchInfo;)V", "aiSearchInfo", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends IGProGuildSearchFeedGroupInfo> channelFilterList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends zg1.a> feedList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> highLightWords;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long feedTotal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean noMoreFeed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] feedCookie;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildSearchAISearchInfo aiSearchInfo;

    public c() {
        List<? extends IGProGuildSearchFeedGroupInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.channelFilterList = emptyList;
        this.feedList = new ArrayList();
        this.highLightWords = new ArrayList();
        this.noMoreFeed = true;
        this.feedCookie = new byte[0];
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final IGProGuildSearchAISearchInfo getAiSearchInfo() {
        return this.aiSearchInfo;
    }

    @NotNull
    public final List<IGProGuildSearchFeedGroupInfo> b() {
        return this.channelFilterList;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final byte[] getFeedCookie() {
        return this.feedCookie;
    }

    @NotNull
    public final List<zg1.a> d() {
        return this.feedList;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getNoMoreFeed() {
        return this.noMoreFeed;
    }

    public final void f(@Nullable IGProGuildSearchAISearchInfo iGProGuildSearchAISearchInfo) {
        this.aiSearchInfo = iGProGuildSearchAISearchInfo;
    }

    public final void g(@NotNull List<? extends IGProGuildSearchFeedGroupInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.channelFilterList = list;
    }

    public final void h(@Nullable byte[] bArr) {
        this.feedCookie = bArr;
    }

    public final void i(@NotNull List<? extends zg1.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.feedList = list;
    }

    public final void j(long j3) {
        this.feedTotal = j3;
    }

    public final void k(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.highLightWords = list;
    }

    public final void l(boolean z16) {
        this.noMoreFeed = z16;
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        Integer num;
        boolean z16;
        int size = this.channelFilterList.size();
        int size2 = this.feedList.size();
        List<String> list = this.highLightWords;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ay.a((String) it.next()));
        }
        long j3 = this.feedTotal;
        boolean z17 = this.noMoreFeed;
        byte[] bArr = this.feedCookie;
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        } else {
            num = null;
        }
        if (this.aiSearchInfo == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return "QuickSearchModel(channelFilterList=" + size + ", feedList=" + size2 + ", highLightWords=" + arrayList + ", feedTotal=" + j3 + ", noMoreFeed=" + z17 + ", feedCookie=" + num + ", aiSearchInfo.isNull=" + z16 + ")";
    }
}
