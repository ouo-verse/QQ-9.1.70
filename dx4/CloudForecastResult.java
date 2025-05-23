package dx4;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Ldx4/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "actionId", "b", "getForecastDuration", "forecastDuration", "<init>", "(II)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: dx4.c, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class CloudForecastResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int actionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int forecastDuration;

    public CloudForecastResult(int i3, int i16) {
        this.actionId = i3;
        this.forecastDuration = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof CloudForecastResult) {
                CloudForecastResult cloudForecastResult = (CloudForecastResult) other;
                if (this.actionId != cloudForecastResult.actionId || this.forecastDuration != cloudForecastResult.forecastDuration) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.actionId * 31) + this.forecastDuration;
    }

    @NotNull
    public String toString() {
        return "CloudForecastResult(actionId=" + this.actionId + ", forecastDuration=" + this.forecastDuration + ")";
    }
}
