package fr0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tBG\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0013\u0012\b\b\u0002\u0010!\u001a\u00020\u0013\u0012\b\b\u0002\u0010%\u001a\u00020\u0013\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R\"\u0010%\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019\u00a8\u0006("}, d2 = {"Lfr0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "b", "setChannelId", "channelId", "Lfr0/a$a;", "c", "Lfr0/a$a;", "getShowUnreadCnt", "()Lfr0/a$a;", "setShowUnreadCnt", "(Lfr0/a$a;)V", "showUnreadCnt", "d", "setAllUnreadCnt", "allUnreadCnt", "e", "getAtmeUnreadCnt", "setAtmeUnreadCnt", "atmeUnreadCnt", "f", "getAtallUnreadCnt", "setAtallUnreadCnt", "atallUnreadCnt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lfr0/a$a;Lfr0/a$a;Lfr0/a$a;Lfr0/a$a;)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C10335a showUnreadCnt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C10335a allUnreadCnt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C10335a atmeUnreadCnt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C10335a atallUnreadCnt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lfr0/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getType", "()I", "type", "b", "cnt", "<init>", "(II)V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fr0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final /* data */ class C10335a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int cnt;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C10335a() {
            this(r2, r2, 3, null);
            int i3 = 0;
        }

        /* renamed from: a, reason: from getter */
        public final int getCnt() {
            return this.cnt;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof C10335a)) {
                return false;
            }
            C10335a c10335a = (C10335a) other;
            if (this.type == c10335a.type && this.cnt == c10335a.cnt) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.type * 31) + this.cnt;
        }

        @NotNull
        public String toString() {
            return "UnreadInfo{type = " + this.type + ", cnt = " + this.cnt + "}";
        }

        public C10335a(int i3, int i16) {
            this.type = i3;
            this.cnt = i16;
        }

        public /* synthetic */ C10335a(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
        }
    }

    public a() {
        this(null, null, null, null, null, null, 63, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final C10335a getAllUnreadCnt() {
        return this.allUnreadCnt;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.guildId, aVar.guildId) && Intrinsics.areEqual(this.channelId, aVar.channelId) && Intrinsics.areEqual(this.showUnreadCnt, aVar.showUnreadCnt) && Intrinsics.areEqual(this.allUnreadCnt, aVar.allUnreadCnt) && Intrinsics.areEqual(this.atmeUnreadCnt, aVar.atmeUnreadCnt) && Intrinsics.areEqual(this.atallUnreadCnt, aVar.atallUnreadCnt)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.guildId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.channelId;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((((((((i16 + i3) * 31) + this.showUnreadCnt.hashCode()) * 31) + this.allUnreadCnt.hashCode()) * 31) + this.atmeUnreadCnt.hashCode()) * 31) + this.atallUnreadCnt.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelUnreadCntInfo{showUnreadCnt = " + this.showUnreadCnt + ", allUnreadCnt = " + this.allUnreadCnt + ", atmeUnreadCnt = " + this.atmeUnreadCnt + ", atallUnreadCnt = " + this.atallUnreadCnt + "}";
    }

    public a(@Nullable String str, @Nullable String str2, @NotNull C10335a showUnreadCnt, @NotNull C10335a allUnreadCnt, @NotNull C10335a atmeUnreadCnt, @NotNull C10335a atallUnreadCnt) {
        Intrinsics.checkNotNullParameter(showUnreadCnt, "showUnreadCnt");
        Intrinsics.checkNotNullParameter(allUnreadCnt, "allUnreadCnt");
        Intrinsics.checkNotNullParameter(atmeUnreadCnt, "atmeUnreadCnt");
        Intrinsics.checkNotNullParameter(atallUnreadCnt, "atallUnreadCnt");
        this.guildId = str;
        this.channelId = str2;
        this.showUnreadCnt = showUnreadCnt;
        this.allUnreadCnt = allUnreadCnt;
        this.atmeUnreadCnt = atmeUnreadCnt;
        this.atallUnreadCnt = atallUnreadCnt;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(String str, String str2, C10335a c10335a, C10335a c10335a2, C10335a c10335a3, C10335a c10335a4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r14, r1, (i3 & 4) != 0 ? new C10335a(r2, r2, r8, r0) : c10335a, (i3 & 8) != 0 ? new C10335a(r2, r2, r8, r0) : c10335a2, (i3 & 16) != 0 ? new C10335a(r2, r2, r8, r0) : c10335a3, (i3 & 32) != 0 ? new C10335a(r2, r2, r8, r0) : c10335a4);
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        String str3 = (i3 & 1) != 0 ? null : str;
        String str4 = (i3 & 2) != 0 ? null : str2;
        int i16 = 3;
        int i17 = 0;
    }
}
