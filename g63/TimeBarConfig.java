package g63;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lg63/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "()F", "maxSpace", "b", "minSpace", "<init>", "(FF)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: g63.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class TimeBarConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float maxSpace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float minSpace;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TimeBarConfig() {
        this(r2, r2, 3, null);
        float f16 = 0.0f;
    }

    /* renamed from: a, reason: from getter */
    public final float getMaxSpace() {
        return this.maxSpace;
    }

    /* renamed from: b, reason: from getter */
    public final float getMinSpace() {
        return this.minSpace;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeBarConfig)) {
            return false;
        }
        TimeBarConfig timeBarConfig = (TimeBarConfig) other;
        if (Float.compare(this.maxSpace, timeBarConfig.maxSpace) == 0 && Float.compare(this.minSpace, timeBarConfig.minSpace) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.maxSpace) * 31) + Float.floatToIntBits(this.minSpace);
    }

    @NotNull
    public String toString() {
        return "TimeBarConfig(maxSpace=" + this.maxSpace + ", minSpace=" + this.minSpace + ")";
    }

    public TimeBarConfig(float f16, float f17) {
        this.maxSpace = f16;
        this.minSpace = f17;
    }

    public /* synthetic */ TimeBarConfig(float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 48.0f : f16, (i3 & 2) != 0 ? 24.0f : f17);
    }
}
