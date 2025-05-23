package c63;

import com.tencent.videocut.model.MediaClip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lc63/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/videocut/model/MediaClip;", "a", "Ljava/util/List;", "()Ljava/util/List;", "result", "", "b", "J", "()J", "targetTime", "<init>", "(Ljava/util/List;J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: c63.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkClipOpCalcResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<MediaClip> result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long targetTime;

    /* JADX WARN: Multi-variable type inference failed */
    public WinkClipOpCalcResult(@NotNull List<? extends MediaClip> result, long j3) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.targetTime = j3;
    }

    @NotNull
    public final List<MediaClip> a() {
        return this.result;
    }

    /* renamed from: b, reason: from getter */
    public final long getTargetTime() {
        return this.targetTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkClipOpCalcResult)) {
            return false;
        }
        WinkClipOpCalcResult winkClipOpCalcResult = (WinkClipOpCalcResult) other;
        if (Intrinsics.areEqual(this.result, winkClipOpCalcResult.result) && this.targetTime == winkClipOpCalcResult.targetTime) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.result.hashCode() * 31) + androidx.fragment.app.a.a(this.targetTime);
    }

    @NotNull
    public String toString() {
        return "WinkClipOpCalcResult(result=" + this.result + ", targetTime=" + this.targetTime + ")";
    }
}
