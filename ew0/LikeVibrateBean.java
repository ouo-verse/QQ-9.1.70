package ew0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lew0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "duration", "J", "b", "()J", "amplitude", "I", "a", "()I", "<init>", "(JI)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ew0.c, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class LikeVibrateBean {

    @SerializedName("amplitude")
    private final int amplitude;

    @SerializedName("duration")
    private final long duration;

    public LikeVibrateBean() {
        this(0L, 0, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAmplitude() {
        return this.amplitude;
    }

    /* renamed from: b, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeVibrateBean)) {
            return false;
        }
        LikeVibrateBean likeVibrateBean = (LikeVibrateBean) other;
        if (this.duration == likeVibrateBean.duration && this.amplitude == likeVibrateBean.amplitude) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.duration) * 31) + this.amplitude;
    }

    @NotNull
    public String toString() {
        return "LikeVibrateBean(duration=" + this.duration + ", amplitude=" + this.amplitude + ")";
    }

    public LikeVibrateBean(long j3, int i3) {
        this.duration = j3;
        this.amplitude = i3;
    }

    public /* synthetic */ LikeVibrateBean(long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 20L : j3, (i16 & 2) != 0 ? -1 : i3);
    }
}
