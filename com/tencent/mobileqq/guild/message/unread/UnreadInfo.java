package com.tencent.mobileqq.guild.message.unread;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0003-BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u00a2\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001cR\u001b\u0010\"\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b$\u0010\u001cR\u001b\u0010'\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b&\u0010#R\u001b\u0010)\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\u001e\u0010(R\u001b\u0010*\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b\u0017\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "", "", "a", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "guildId", "b", "channelId", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$UnreadType;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "detailCountMap", "d", h.F, "relatedToMeString", "I", "g", "()I", "relatedToMeCnt", "f", "Lkotlin/Lazy;", "j", "totalCount", "isStrongUnread", "()Z", "i", "showCount", "k", "isShowStrongUnread", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "guildShowCount", "guildAllShowCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;I)V", "UnreadType", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class UnreadInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<UnreadType, a> detailCountMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String relatedToMeString;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int relatedToMeCnt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy totalCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isStrongUnread;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy showCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isShowStrongUnread;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildShowCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildAllShowCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$UnreadType;", "", "(Ljava/lang/String;I)V", "TYPE_GUILD_ALL", "TYPE_GUILD_SHOW", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum UnreadType {
        TYPE_GUILD_ALL,
        TYPE_GUILD_SHOW
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \f2\u00020\u0001:\u0001\nB%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "", "", "b", "", "toString", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "isStrongUnread", "I", "()I", "count", "c", "unreadType", "<init>", "(ZII)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isStrongUnread;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int count;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int unreadType;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0007\u001a\u00020\u00062*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a$a;", "", "", "Lkotlin/Pair;", "", "unread", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "a", "([Lkotlin/Pair;)Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "DATONG_TYPE_GRAY", "I", "DATONG_TYPE_RED", "DATONG_TYPE_RED_POINT", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.message.unread.UnreadInfo$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
            @NotNull
            public final a a(@NotNull Pair<Integer, Integer>... unread) {
                boolean z16;
                int lastIndex;
                Intrinsics.checkNotNullParameter(unread, "unread");
                if (unread.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    Pair<Integer, Integer> pair = unread[0];
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(unread);
                    ?? it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        Pair<Integer, Integer> pair2 = unread[it.nextInt()];
                        pair = TuplesKt.to(Integer.valueOf(pair.getFirst().intValue() + pair2.getFirst().intValue()), Integer.valueOf(pair.getSecond().intValue() + pair2.getSecond().intValue()));
                    }
                    if (pair.getFirst().intValue() > 0) {
                        return new a(true, pair.getFirst().intValue(), 0, 4, null);
                    }
                    return new a(false, pair.getSecond().intValue(), 0, 4, null);
                }
                throw new UnsupportedOperationException("Empty array can't be reduced.");
            }

            Companion() {
            }
        }

        public a() {
            this(false, 0, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final int b() {
            if (this.count == 0) {
                return 0;
            }
            boolean z16 = this.isStrongUnread;
            if (z16) {
                return 2;
            }
            if (!z16) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }

        /* renamed from: c, reason: from getter */
        public final int getUnreadType() {
            return this.unreadType;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsStrongUnread() {
            return this.isStrongUnread;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.isStrongUnread == aVar.isStrongUnread && this.count == aVar.count && this.unreadType == aVar.unreadType) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.isStrongUnread;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.count) * 31) + this.unreadType;
        }

        @NotNull
        public String toString() {
            return "(type: " + this.unreadType + ",count: " + this.count + ')';
        }

        public a(boolean z16, int i3, int i16) {
            this.isStrongUnread = z16;
            this.count = i3;
            this.unreadType = i16;
        }

        public /* synthetic */ a(boolean z16, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? false : z16, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16);
        }
    }

    public UnreadInfo(@NotNull String guildId, @NotNull String channelId, @NotNull Map<UnreadType, a> detailCountMap, @NotNull String relatedToMeString, int i3) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(detailCountMap, "detailCountMap");
        Intrinsics.checkNotNullParameter(relatedToMeString, "relatedToMeString");
        this.guildId = guildId;
        this.channelId = channelId;
        this.detailCountMap = detailCountMap;
        this.relatedToMeString = relatedToMeString;
        this.relatedToMeCnt = i3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.message.unread.UnreadInfo$totalCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                UnreadInfo.a aVar = UnreadInfo.this.c().get(UnreadInfo.UnreadType.TYPE_GUILD_ALL);
                return Integer.valueOf(aVar != null ? aVar.getCount() : 0);
            }
        });
        this.totalCount = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.message.unread.UnreadInfo$isStrongUnread$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                UnreadInfo.a aVar = UnreadInfo.this.c().get(UnreadInfo.UnreadType.TYPE_GUILD_ALL);
                return Boolean.valueOf(aVar != null ? aVar.getIsStrongUnread() : false);
            }
        });
        this.isStrongUnread = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.message.unread.UnreadInfo$showCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                UnreadInfo.a aVar = UnreadInfo.this.c().get(UnreadInfo.UnreadType.TYPE_GUILD_SHOW);
                return Integer.valueOf(aVar != null ? aVar.getCount() : 0);
            }
        });
        this.showCount = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.message.unread.UnreadInfo$isShowStrongUnread$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                UnreadInfo.a aVar = UnreadInfo.this.c().get(UnreadInfo.UnreadType.TYPE_GUILD_SHOW);
                return Boolean.valueOf(aVar != null ? aVar.getIsStrongUnread() : false);
            }
        });
        this.isShowStrongUnread = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.message.unread.UnreadInfo$guildShowCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UnreadInfo.a invoke() {
                UnreadInfo.a aVar = UnreadInfo.this.c().get(UnreadInfo.UnreadType.TYPE_GUILD_SHOW);
                return aVar == null ? new UnreadInfo.a(false, 0, 0, 4, null) : aVar;
            }
        });
        this.guildShowCount = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.message.unread.UnreadInfo$guildAllShowCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UnreadInfo.a invoke() {
                UnreadInfo.a aVar = UnreadInfo.this.c().get(UnreadInfo.UnreadType.TYPE_GUILD_ALL);
                return aVar == null ? new UnreadInfo.a(false, 0, 0) : aVar;
            }
        });
        this.guildAllShowCount = lazy6;
    }

    @NotNull
    public final String a() {
        if (j() > 0) {
            return "unread=" + j();
        }
        return "allRead";
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final Map<UnreadType, a> c() {
        return this.detailCountMap;
    }

    @NotNull
    public final a d() {
        return (a) this.guildAllShowCount.getValue();
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnreadInfo)) {
            return false;
        }
        UnreadInfo unreadInfo = (UnreadInfo) other;
        if (Intrinsics.areEqual(this.guildId, unreadInfo.guildId) && Intrinsics.areEqual(this.channelId, unreadInfo.channelId) && Intrinsics.areEqual(this.detailCountMap, unreadInfo.detailCountMap) && Intrinsics.areEqual(this.relatedToMeString, unreadInfo.relatedToMeString) && this.relatedToMeCnt == unreadInfo.relatedToMeCnt) {
            return true;
        }
        return false;
    }

    @NotNull
    public final a f() {
        return (a) this.guildShowCount.getValue();
    }

    /* renamed from: g, reason: from getter */
    public final int getRelatedToMeCnt() {
        return this.relatedToMeCnt;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getRelatedToMeString() {
        return this.relatedToMeString;
    }

    public int hashCode() {
        return (((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.detailCountMap.hashCode()) * 31) + this.relatedToMeString.hashCode()) * 31) + this.relatedToMeCnt;
    }

    public final int i() {
        return ((Number) this.showCount.getValue()).intValue();
    }

    public final int j() {
        return ((Number) this.totalCount.getValue()).intValue();
    }

    public final boolean k() {
        return ((Boolean) this.isShowStrongUnread.getValue()).booleanValue();
    }

    @NotNull
    public String toString() {
        boolean z16;
        if (this.channelId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "c(" + this.guildId + ',' + this.channelId + ":(all" + this.detailCountMap.get(UnreadType.TYPE_GUILD_ALL) + ", show" + this.detailCountMap.get(UnreadType.TYPE_GUILD_SHOW) + ')';
        }
        return "g(" + this.guildId + ':' + this.detailCountMap.get(UnreadType.TYPE_GUILD_SHOW) + ')';
    }

    public /* synthetic */ UnreadInfo(String str, String str2, Map map, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? new LinkedHashMap() : map, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? 0 : i3);
    }
}
