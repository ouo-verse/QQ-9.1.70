package bi0;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lbi0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "data", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: bi0.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECHREvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String eventName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final JSONObject data;

    public ECHREvent(@NotNull String str, @NotNull JSONObject jSONObject) {
        this.eventName = str;
        this.data = jSONObject;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final JSONObject getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECHREvent) {
                ECHREvent eCHREvent = (ECHREvent) other;
                if (!Intrinsics.areEqual(this.eventName, eCHREvent.eventName) || !Intrinsics.areEqual(this.data, eCHREvent.data)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        String str = this.eventName;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            i16 = jSONObject.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "ECHREvent(eventName=" + this.eventName + ", data=" + this.data + ")";
    }
}
