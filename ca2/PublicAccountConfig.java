package ca2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\n\u000fB3\u0012\n\u0010\u000e\u001a\u00060\u0004j\u0002`\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001b\u0010\u000e\u001a\u00060\u0004j\u0002`\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000f\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\n\u0010\u001e\u00a8\u0006\""}, d2 = {"Lca2/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/nearbypro/api/data/AppID;", "a", "I", "getAppId", "()I", "appId", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "getName", "name", "Lca2/c$b;", "d", "Lca2/c$b;", "()Lca2/c$b;", "followModal", "Lca2/c$a;", "e", "Lca2/c$a;", "()Lca2/c$a;", "followBar", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lca2/c$b;Lca2/c$a;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ca2.c, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class PublicAccountConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FollowModalConfig followModal;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final FollowBarConfig followBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\r\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lca2/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "enable", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "c", "icon", "", "Ljava/util/Map;", "()Ljava/util/Map;", "showIntervalS", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ca2.c$a, reason: from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class FollowBarConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String icon;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Map<Integer, Integer> showIntervalS;

        public FollowBarConfig(boolean z16, @NotNull String title, @NotNull String icon, @NotNull Map<Integer, Integer> showIntervalS) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(showIntervalS, "showIntervalS");
            this.enable = z16;
            this.title = title;
            this.icon = icon;
            this.showIntervalS = showIntervalS;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        @NotNull
        public final Map<Integer, Integer> c() {
            return this.showIntervalS;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FollowBarConfig)) {
                return false;
            }
            FollowBarConfig followBarConfig = (FollowBarConfig) other;
            if (this.enable == followBarConfig.enable && Intrinsics.areEqual(this.title, followBarConfig.title) && Intrinsics.areEqual(this.icon, followBarConfig.icon) && Intrinsics.areEqual(this.showIntervalS, followBarConfig.showIntervalS)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((((r06 * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.showIntervalS.hashCode();
        }

        @NotNull
        public String toString() {
            return "FollowBarConfig(enable=" + this.enable + ", title=" + this.title + ", icon=" + this.icon + ", showIntervalS=" + this.showIntervalS + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\r\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lca2/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "enable", "b", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getPosterUrl", "posterUrl", "", "d", "J", "()J", "showIntervalS", "<init>", "(ZLjava/lang/String;Ljava/lang/String;J)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ca2.c$b, reason: from toString */
    /* loaded from: classes15.dex */
    public static final /* data */ class FollowModalConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String posterUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long showIntervalS;

        public FollowModalConfig(boolean z16, @NotNull String title, @NotNull String posterUrl, long j3) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(posterUrl, "posterUrl");
            this.enable = z16;
            this.title = title;
            this.posterUrl = posterUrl;
            this.showIntervalS = j3;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        /* renamed from: b, reason: from getter */
        public final long getShowIntervalS() {
            return this.showIntervalS;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FollowModalConfig)) {
                return false;
            }
            FollowModalConfig followModalConfig = (FollowModalConfig) other;
            if (this.enable == followModalConfig.enable && Intrinsics.areEqual(this.title, followModalConfig.title) && Intrinsics.areEqual(this.posterUrl, followModalConfig.posterUrl) && this.showIntervalS == followModalConfig.showIntervalS) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((((r06 * 31) + this.title.hashCode()) * 31) + this.posterUrl.hashCode()) * 31) + androidx.fragment.app.a.a(this.showIntervalS);
        }

        @NotNull
        public String toString() {
            return "FollowModalConfig(enable=" + this.enable + ", title=" + this.title + ", posterUrl=" + this.posterUrl + ", showIntervalS=" + this.showIntervalS + ")";
        }
    }

    public PublicAccountConfig(int i3, @NotNull String uin, @NotNull String name, @NotNull FollowModalConfig followModal, @NotNull FollowBarConfig followBar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(followModal, "followModal");
        Intrinsics.checkNotNullParameter(followBar, "followBar");
        this.appId = i3;
        this.uin = uin;
        this.name = name;
        this.followModal = followModal;
        this.followBar = followBar;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final FollowBarConfig getFollowBar() {
        return this.followBar;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final FollowModalConfig getFollowModal() {
        return this.followModal;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublicAccountConfig)) {
            return false;
        }
        PublicAccountConfig publicAccountConfig = (PublicAccountConfig) other;
        if (this.appId == publicAccountConfig.appId && Intrinsics.areEqual(this.uin, publicAccountConfig.uin) && Intrinsics.areEqual(this.name, publicAccountConfig.name) && Intrinsics.areEqual(this.followModal, publicAccountConfig.followModal) && Intrinsics.areEqual(this.followBar, publicAccountConfig.followBar)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.appId * 31) + this.uin.hashCode()) * 31) + this.name.hashCode()) * 31) + this.followModal.hashCode()) * 31) + this.followBar.hashCode();
    }

    @NotNull
    public String toString() {
        return "PublicAccountConfig(appId=" + this.appId + ", uin=" + this.uin + ", name=" + this.name + ", followModal=" + this.followModal + ", followBar=" + this.followBar + ")";
    }
}
