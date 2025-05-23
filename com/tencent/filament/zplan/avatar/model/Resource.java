package com.tencent.filament.zplan.avatar.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/b;", "", "", "f", "", "a", "b", "c", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "Z", "d", "()Z", "downloadFromNet", "getHit304", "hit304", "<init>", "(Ljava/lang/String;ZZ)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.avatar.model.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class Resource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean downloadFromNet;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hit304;

    public Resource() {
        this(null, false, false, 7, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDownloadFromNet() {
        return this.downloadFromNet;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHit304() {
        return this.hit304;
    }

    public final boolean d() {
        return this.downloadFromNet;
    }

    @NotNull
    public final String e() {
        return this.path;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Resource) {
                Resource resource = (Resource) other;
                if (!Intrinsics.areEqual(this.path, resource.path) || this.downloadFromNet != resource.downloadFromNet || this.hit304 != resource.hit304) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean f() {
        if (!this.downloadFromNet && !this.hit304) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.path;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i16 = i3 * 31;
        boolean z16 = this.downloadFromNet;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        boolean z17 = this.hit304;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "Resource(path=" + this.path + ", downloadFromNet=" + this.downloadFromNet + ", hit304=" + this.hit304 + ")";
    }

    public Resource(@NotNull String path, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.downloadFromNet = z16;
        this.hit304 = z17;
    }

    public /* synthetic */ Resource(String str, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? false : z16, (i3 & 4) != 0 ? false : z17);
    }
}
