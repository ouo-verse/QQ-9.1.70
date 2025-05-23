package iz3;

import com.tencent.rdelivery.data.RDeliveryData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Liz3/f;", "", "", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "taskDataMap", "", "onSuccess", "", "reason", "onFail", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public interface f {
    void onFail(@NotNull String reason);

    void onSuccess(@NotNull Map<Long, RDeliveryData> taskDataMap);
}
