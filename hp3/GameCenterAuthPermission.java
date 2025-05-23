package hp3;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lhp3/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getType", "()I", "type", "b", "getRange", DownloaderConstant.KEY_RANGE, "c", "Ljava/lang/String;", "()Ljava/lang/String;", "title", "d", "rangeStr", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hp3.c, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class GameCenterAuthPermission {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int range;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String rangeStr;

    public GameCenterAuthPermission(int i3, int i16, @Nullable String str, @Nullable String str2) {
        this.type = i3;
        this.range = i16;
        this.title = str;
        this.rangeStr = str2;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getRangeStr() {
        return this.rangeStr;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameCenterAuthPermission)) {
            return false;
        }
        GameCenterAuthPermission gameCenterAuthPermission = (GameCenterAuthPermission) other;
        if (this.type == gameCenterAuthPermission.type && this.range == gameCenterAuthPermission.range && Intrinsics.areEqual(this.title, gameCenterAuthPermission.title) && Intrinsics.areEqual(this.rangeStr, gameCenterAuthPermission.rangeStr)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((this.type * 31) + this.range) * 31;
        String str = this.title;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        String str2 = this.rangeStr;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "GameCenterAuthPermission(type=" + this.type + ", range=" + this.range + ", title=" + this.title + ", rangeStr=" + this.rangeStr + ")";
    }
}
