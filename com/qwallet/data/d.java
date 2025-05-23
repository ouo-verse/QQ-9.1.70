package com.qwallet.data;

import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Belt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0007BI\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0007\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/qwallet/data/d;", "", "other", "", "equals", "", "hashCode", "a", "I", "b", "()I", "id", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "name", "e", "url", "d", "getShowCount", "showCount", "type", "Lcom/qwallet/data/QWalletHomeDateRange;", "f", "Lcom/qwallet/data/QWalletHomeDateRange;", "()Lcom/qwallet/data/QWalletHomeDateRange;", "dateRange", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILcom/qwallet/data/QWalletHomeDateRange;)V", "g", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int showCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QWalletHomeDateRange dateRange;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/qwallet/data/d$a;", "", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Belt;", "belt", "Lcom/qwallet/data/d;", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.data.d$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a(@NotNull QWalletHomePage$Belt belt) {
            Intrinsics.checkNotNullParameter(belt, "belt");
            return new d(belt.f41688id.get(), belt.name.get(), belt.url.get(), belt.show_count.get(), belt.type.get(), QWalletHomeDateRange.a(belt.range.get()));
        }

        Companion() {
        }
    }

    public d() {
        this(0, null, null, 0, 0, null, 63, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final QWalletHomeDateRange getDateRange() {
        return this.dateRange;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(d.class, other.getClass())) {
            return false;
        }
        d dVar = (d) other;
        if (this.id == dVar.id && Intrinsics.areEqual(this.name, dVar.name) && Intrinsics.areEqual(this.url, dVar.url) && this.showCount == dVar.showCount && this.type == dVar.type && Intrinsics.areEqual(this.dateRange, dVar.dateRange)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.id), this.name, this.url, Integer.valueOf(this.showCount), Integer.valueOf(this.type), this.dateRange);
    }

    public d(int i3, @Nullable String str, @Nullable String str2, int i16, int i17, @Nullable QWalletHomeDateRange qWalletHomeDateRange) {
        this.id = i3;
        this.name = str;
        this.url = str2;
        this.showCount = i16;
        this.type = i17;
        this.dateRange = qWalletHomeDateRange;
    }

    public /* synthetic */ d(int i3, String str, String str2, int i16, int i17, QWalletHomeDateRange qWalletHomeDateRange, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? null : str, (i18 & 4) != 0 ? null : str2, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) == 0 ? i17 : 0, (i18 & 32) != 0 ? null : qWalletHomeDateRange);
    }
}
