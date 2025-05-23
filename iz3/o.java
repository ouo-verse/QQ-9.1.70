package iz3;

import com.tencent.rdelivery.data.RDeliveryData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class o {
    public static void a(p pVar, List list) {
        RDeliveryData rDeliveryData;
        if (!list.isEmpty()) {
            rDeliveryData = (RDeliveryData) list.get(0);
        } else {
            rDeliveryData = null;
        }
        pVar.b(rDeliveryData);
    }
}
