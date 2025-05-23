package lp1;

import android.os.Bundle;
import com.tencent.mobileqq.guild.util.ay;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u000f\u0010\u001e\u00a8\u0006\""}, d2 = {"Llp1/c;", "", "", "f", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "categoryId", "b", "I", "d", "()I", "type", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "getUrl", "url", "e", "urlType", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extra", "<init>", "(JILjava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lp1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SubTabData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long categoryId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int urlType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle extra;

    public SubTabData(long j3, int i3, @NotNull String name, @Nullable String str, int i16, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.categoryId = j3;
        this.type = i3;
        this.name = name;
        this.url = str;
        this.urlType = i16;
        this.extra = extra;
    }

    /* renamed from: a, reason: from getter */
    public final long getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: e, reason: from getter */
    public final int getUrlType() {
        return this.urlType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubTabData)) {
            return false;
        }
        SubTabData subTabData = (SubTabData) other;
        if (this.categoryId == subTabData.categoryId && this.type == subTabData.type && Intrinsics.areEqual(this.name, subTabData.name) && Intrinsics.areEqual(this.url, subTabData.url) && this.urlType == subTabData.urlType && Intrinsics.areEqual(this.extra, subTabData.extra)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        int i3 = this.type;
        if (i3 != 1) {
            if (i3 != 99) {
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((((androidx.fragment.app.a.a(this.categoryId) * 31) + this.type) * 31) + this.name.hashCode()) * 31;
        String str = this.url;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((a16 + hashCode) * 31) + this.urlType) * 31) + this.extra.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubTabData(categoryId=" + this.categoryId + ", type=" + this.type + ", name='" + ay.a(this.name) + "')";
    }

    public /* synthetic */ SubTabData(long j3, int i3, String str, String str2, int i16, Bundle bundle, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, str, (i17 & 8) != 0 ? null : str2, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? new Bundle() : bundle);
    }
}
