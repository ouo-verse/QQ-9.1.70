package com.tencent.state.square.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/data/RecordSource;", "", "path", "", "md5", "(Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getPath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class RecordSource {

    @NotNull
    private final String md5;

    @NotNull
    private final String path;

    public RecordSource(@NotNull String path, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.path = path;
        this.md5 = md5;
    }

    public static /* synthetic */ RecordSource copy$default(RecordSource recordSource, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = recordSource.path;
        }
        if ((i3 & 2) != 0) {
            str2 = recordSource.md5;
        }
        return recordSource.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final RecordSource copy(@NotNull String path, @NotNull String md5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new RecordSource(path, md5);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof RecordSource) {
                RecordSource recordSource = (RecordSource) other;
                if (!Intrinsics.areEqual(this.path, recordSource.path) || !Intrinsics.areEqual(this.md5, recordSource.md5)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getMd5() {
        return this.md5;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        int i3;
        String str = this.path;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.md5;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "RecordSource(path=" + this.path + ", md5=" + this.md5 + ")";
    }

    public /* synthetic */ RecordSource(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, str2);
    }
}
