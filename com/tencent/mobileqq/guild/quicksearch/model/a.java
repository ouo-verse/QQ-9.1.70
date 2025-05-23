package com.tencent.mobileqq.guild.quicksearch.model;

import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.quicksearch.searchbox.SearchBarExtData;
import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.cq;
import com.tencent.mobileqq.qqguildsdk.data.genc.cr;
import com.tencent.mobileqq.qqguildsdk.data.genc.cs;
import com.tencent.mobileqq.qqguildsdk.data.genc.ct;
import com.tencent.mobileqq.troop.utils.bg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b-\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0001\u0003Bg\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b>\u0010?J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016Jp\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u00c6\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0013H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b*\u00101\"\u0004\b2\u00103R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/model/a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/cr;", "a", "", "g", "", "toString", "", "guildId", "keyWord", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "searchExtInfo", "", "cookie", "", "channelIds", "Lkotlin/Pair;", "timeRange", "", "rankType", "b", "(Ljava/lang/Long;Ljava/lang/String;Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;[BLjava/util/List;Lkotlin/Pair;I)Lcom/tencent/mobileqq/guild/quicksearch/model/a;", "hashCode", "other", "equals", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "setGuildId", "(Ljava/lang/Long;)V", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "c", "Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "f", "()Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;", "l", "(Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;)V", "d", "[B", "getCookie", "()[B", "i", "([B)V", "Ljava/util/List;", "()Ljava/util/List;", h.F, "(Ljava/util/List;)V", "Lkotlin/Pair;", "getTimeRange", "()Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lkotlin/Pair;)V", "I", "getRankType", "()I", "k", "(I)V", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lcom/tencent/mobileqq/guild/quicksearch/searchbox/SearchBarExtData;[BLjava/util/List;Lkotlin/Pair;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String keyWord;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SearchBarExtData searchExtInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] cookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> channelIds;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Pair<String, String> timeRange;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int rankType;

    public a() {
        this(null, null, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ a c(a aVar, Long l3, String str, SearchBarExtData searchBarExtData, byte[] bArr, List list, Pair pair, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            l3 = aVar.guildId;
        }
        if ((i16 & 2) != 0) {
            str = aVar.keyWord;
        }
        String str2 = str;
        if ((i16 & 4) != 0) {
            searchBarExtData = aVar.searchExtInfo;
        }
        SearchBarExtData searchBarExtData2 = searchBarExtData;
        if ((i16 & 8) != 0) {
            bArr = aVar.cookie;
        }
        byte[] bArr2 = bArr;
        if ((i16 & 16) != 0) {
            list = aVar.channelIds;
        }
        List list2 = list;
        if ((i16 & 32) != 0) {
            pair = aVar.timeRange;
        }
        Pair pair2 = pair;
        if ((i16 & 64) != 0) {
            i3 = aVar.rankType;
        }
        return aVar.b(l3, str2, searchBarExtData2, bArr2, list2, pair2, i3);
    }

    @NotNull
    public final cr a() {
        Long longOrNull;
        long j3;
        ArrayList<cq> arrayListOf;
        ArrayList<Long> arrayListOf2;
        ArrayList<cq> arrayListOf3;
        String selfTinyId = ((IGPSService) ch.R0(IGPSService.class)).getSelfTinyId();
        cr crVar = new cr();
        Intrinsics.checkNotNullExpressionValue(selfTinyId, "selfTinyId");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(selfTinyId);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        crVar.l(j3);
        Long l3 = this.guildId;
        if (l3 != null) {
            j16 = l3.longValue();
        }
        crVar.i(j16);
        crVar.j(this.keyWord);
        byte[] bArr = this.cookie;
        if (bArr != null) {
            crVar.h(bArr);
        }
        ct ctVar = new ct();
        ctVar.d(2);
        crVar.k(ctVar);
        cs csVar = new cs();
        csVar.e(bg.f302144a.n(this.channelIds));
        csVar.g(this.rankType);
        SearchBarExtData searchBarExtData = this.searchExtInfo;
        if (searchBarExtData instanceof SearchBarExtData.DateExtData) {
            cq cqVar = new cq();
            SearchBarExtData.DateExtData dateExtData = (SearchBarExtData.DateExtData) searchBarExtData;
            cqVar.d(dateExtData.b());
            cqVar.c(dateExtData.b());
            Unit unit = Unit.INSTANCE;
            arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(cqVar);
            csVar.h(arrayListOf3);
        } else {
            Pair<String, String> pair = this.timeRange;
            if (pair != null) {
                cq cqVar2 = new cq();
                cqVar2.d(pair.getFirst());
                cqVar2.c(pair.getSecond());
                Unit unit2 = Unit.INSTANCE;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(cqVar2);
                csVar.h(arrayListOf);
            }
        }
        if (searchBarExtData instanceof SearchBarExtData.GuildMemberExtData) {
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(MiscKt.l(((SearchBarExtData.GuildMemberExtData) searchBarExtData).getTinyId())));
            csVar.f(arrayListOf2);
        }
        crVar.g(csVar);
        return crVar;
    }

    @NotNull
    public final a b(@Nullable Long guildId, @NotNull String keyWord, @Nullable SearchBarExtData searchExtInfo, @Nullable byte[] cookie, @NotNull List<Long> channelIds, @Nullable Pair<String, String> timeRange, int rankType) {
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        return new a(guildId, keyWord, searchExtInfo, cookie, channelIds, timeRange, rankType);
    }

    @NotNull
    public final List<Long> d() {
        return this.channelIds;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getKeyWord() {
        return this.keyWord;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.guildId, aVar.guildId) && Intrinsics.areEqual(this.keyWord, aVar.keyWord) && Intrinsics.areEqual(this.searchExtInfo, aVar.searchExtInfo) && Intrinsics.areEqual(this.cookie, aVar.cookie) && Intrinsics.areEqual(this.channelIds, aVar.channelIds) && Intrinsics.areEqual(this.timeRange, aVar.timeRange) && this.rankType == aVar.rankType) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final SearchBarExtData getSearchExtInfo() {
        return this.searchExtInfo;
    }

    public final boolean g() {
        if ((!this.channelIds.isEmpty()) || this.timeRange != null) {
            return true;
        }
        return false;
    }

    public final void h(@NotNull List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.channelIds = list;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        Long l3 = this.guildId;
        int i3 = 0;
        if (l3 == null) {
            hashCode = 0;
        } else {
            hashCode = l3.hashCode();
        }
        int hashCode4 = ((hashCode * 31) + this.keyWord.hashCode()) * 31;
        SearchBarExtData searchBarExtData = this.searchExtInfo;
        if (searchBarExtData == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = searchBarExtData.hashCode();
        }
        int i16 = (hashCode4 + hashCode2) * 31;
        byte[] bArr = this.cookie;
        if (bArr == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = Arrays.hashCode(bArr);
        }
        int hashCode5 = (((i16 + hashCode3) * 31) + this.channelIds.hashCode()) * 31;
        Pair<String, String> pair = this.timeRange;
        if (pair != null) {
            i3 = pair.hashCode();
        }
        return ((hashCode5 + i3) * 31) + this.rankType;
    }

    public final void i(@Nullable byte[] bArr) {
        this.cookie = bArr;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyWord = str;
    }

    public final void k(int i3) {
        this.rankType = i3;
    }

    public final void l(@Nullable SearchBarExtData searchBarExtData) {
        this.searchExtInfo = searchBarExtData;
    }

    public final void m(@Nullable Pair<String, String> pair) {
        this.timeRange = pair;
    }

    @NotNull
    public String toString() {
        Integer num;
        Long l3 = this.guildId;
        String a16 = ay.a(this.keyWord);
        SearchBarExtData searchBarExtData = this.searchExtInfo;
        byte[] bArr = this.cookie;
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        } else {
            num = null;
        }
        return "GuildQuickSearchParam(guildId=" + l3 + ", keyWord='" + a16 + "', searchMemberInfo=" + searchBarExtData + ", cookie=" + num + ", channelIds=" + this.channelIds + ", timeRange=" + this.timeRange + ")";
    }

    public a(@Nullable Long l3, @NotNull String keyWord, @Nullable SearchBarExtData searchBarExtData, @Nullable byte[] bArr, @NotNull List<Long> channelIds, @Nullable Pair<String, String> pair, int i3) {
        Intrinsics.checkNotNullParameter(keyWord, "keyWord");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        this.guildId = l3;
        this.keyWord = keyWord;
        this.searchExtInfo = searchBarExtData;
        this.cookie = bArr;
        this.channelIds = channelIds;
        this.timeRange = pair;
        this.rankType = i3;
    }

    public /* synthetic */ a(Long l3, String str, SearchBarExtData searchBarExtData, byte[] bArr, List list, Pair pair, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : l3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? null : searchBarExtData, (i16 & 8) != 0 ? null : bArr, (i16 & 16) != 0 ? new ArrayList() : list, (i16 & 32) == 0 ? pair : null, (i16 & 64) != 0 ? QuickSearchSortType.SMART.getRankType() : i3);
    }
}
