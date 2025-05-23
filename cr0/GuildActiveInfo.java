package cr0;

import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000bB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcr0/a;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "Lcr0/a$a;", "a", "Lcr0/a$a;", "c", "()Lcr0/a$a;", "f", "(Lcr0/a$a;)V", "uniqueKey", "b", "I", "()I", "setType", "(I)V", "type", "Z", "()Z", "e", "(Z)V", "bActive", "<init>", "(Lcr0/a$a;IZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cr0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildActiveInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private UniqueKey uniqueKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean bActive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcr0/a$a;", "", "", "b", "", "c", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "getKey", VasCommonJsbProxy.JSON_KEY_SET_KEY, "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cr0.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class UniqueKey {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String key;

        public UniqueKey() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final boolean b() {
            return Intrinsics.areEqual(this.id, "0");
        }

        public final void c() {
            this.id = "0";
            this.key = "";
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UniqueKey)) {
                return false;
            }
            UniqueKey uniqueKey = (UniqueKey) other;
            if (Intrinsics.areEqual(this.id, uniqueKey.id) && Intrinsics.areEqual(this.key, uniqueKey.key)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "UniqueKey(id=" + this.id + ", key=" + this.key + ")";
        }

        public UniqueKey(@NotNull String id5, @NotNull String key) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(key, "key");
            this.id = id5;
            this.key = key;
        }

        public /* synthetic */ UniqueKey(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "0" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    public GuildActiveInfo() {
        this(null, 0, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getBActive() {
        return this.bActive;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final UniqueKey getUniqueKey() {
        return this.uniqueKey;
    }

    public final boolean d() {
        UniqueKey uniqueKey = this.uniqueKey;
        if (uniqueKey != null && !uniqueKey.b() && this.type != 0) {
            return false;
        }
        return true;
    }

    public final void e(boolean z16) {
        this.bActive = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildActiveInfo)) {
            return false;
        }
        GuildActiveInfo guildActiveInfo = (GuildActiveInfo) other;
        if (Intrinsics.areEqual(this.uniqueKey, guildActiveInfo.uniqueKey) && this.type == guildActiveInfo.type && this.bActive == guildActiveInfo.bActive) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull UniqueKey uniqueKey) {
        Intrinsics.checkNotNullParameter(uniqueKey, "<set-?>");
        this.uniqueKey = uniqueKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.uniqueKey.hashCode() * 31) + this.type) * 31;
        boolean z16 = this.bActive;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "GuildActiveInfo(uniqueKey=" + this.uniqueKey + ", type=" + this.type + ", bActive=" + this.bActive + ")";
    }

    public GuildActiveInfo(@NotNull UniqueKey uniqueKey, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        this.uniqueKey = uniqueKey;
        this.type = i3;
        this.bActive = z16;
    }

    public /* synthetic */ GuildActiveInfo(UniqueKey uniqueKey, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new UniqueKey(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0) : uniqueKey, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? false : z16);
    }
}
