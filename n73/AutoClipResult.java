package n73;

import com.tencent.videocut.model.MediaClip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Ln73/a;", "", "", "isSuccess", "", "tipString", "", "Lcom/tencent/videocut/model/MediaClip;", "clipList", "a", "toString", "", "hashCode", "other", "equals", "Z", "e", "()Z", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "Ljava/util/List;", "()Ljava/util/List;", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: n73.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class AutoClipResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tipString;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MediaClip> clipList;

    /* JADX WARN: Multi-variable type inference failed */
    public AutoClipResult(boolean z16, @NotNull String tipString, @NotNull List<? extends MediaClip> clipList) {
        Intrinsics.checkNotNullParameter(tipString, "tipString");
        Intrinsics.checkNotNullParameter(clipList, "clipList");
        this.isSuccess = z16;
        this.tipString = tipString;
        this.clipList = clipList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoClipResult b(AutoClipResult autoClipResult, boolean z16, String str, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = autoClipResult.isSuccess;
        }
        if ((i3 & 2) != 0) {
            str = autoClipResult.tipString;
        }
        if ((i3 & 4) != 0) {
            list = autoClipResult.clipList;
        }
        return autoClipResult.a(z16, str, list);
    }

    @NotNull
    public final AutoClipResult a(boolean isSuccess, @NotNull String tipString, @NotNull List<? extends MediaClip> clipList) {
        Intrinsics.checkNotNullParameter(tipString, "tipString");
        Intrinsics.checkNotNullParameter(clipList, "clipList");
        return new AutoClipResult(isSuccess, tipString, clipList);
    }

    @NotNull
    public final List<MediaClip> c() {
        return this.clipList;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTipString() {
        return this.tipString;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoClipResult)) {
            return false;
        }
        AutoClipResult autoClipResult = (AutoClipResult) other;
        if (this.isSuccess == autoClipResult.isSuccess && Intrinsics.areEqual(this.tipString, autoClipResult.tipString) && Intrinsics.areEqual(this.clipList, autoClipResult.clipList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSuccess;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.tipString.hashCode()) * 31) + this.clipList.hashCode();
    }

    @NotNull
    public String toString() {
        return "AutoClipResult(isSuccess=" + this.isSuccess + ", tipString=" + this.tipString + ", clipList=" + this.clipList + ")";
    }
}
