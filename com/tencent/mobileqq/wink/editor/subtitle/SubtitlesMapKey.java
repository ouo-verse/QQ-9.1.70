package com.tencent.mobileqq.wink.editor.subtitle;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "Ljava/io/Serializable;", "path", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getPath", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class SubtitlesMapKey implements Serializable {

    @NotNull
    private final String id;

    @NotNull
    private final String path;

    public SubtitlesMapKey(@NotNull String path, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(id5, "id");
        this.path = path;
        this.id = id5;
    }

    public static /* synthetic */ SubtitlesMapKey copy$default(SubtitlesMapKey subtitlesMapKey, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = subtitlesMapKey.path;
        }
        if ((i3 & 2) != 0) {
            str2 = subtitlesMapKey.id;
        }
        return subtitlesMapKey.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final SubtitlesMapKey copy(@NotNull String path, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(id5, "id");
        return new SubtitlesMapKey(path, id5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r0 != (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(@Nullable Object other) {
        int indexOf$default;
        int indexOf$default2;
        if (other != null && (other instanceof SubtitlesMapKey)) {
            SubtitlesMapKey subtitlesMapKey = (SubtitlesMapKey) other;
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) subtitlesMapKey.id, this.id, 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) this.id, subtitlesMapKey.id, 0, false, 6, (Object) null);
            }
            if (Intrinsics.areEqual(subtitlesMapKey.path, this.path)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    @NotNull
    public String toString() {
        return "path = " + this.path + " id = " + this.id;
    }
}
