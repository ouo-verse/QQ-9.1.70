package hw2;

import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdVRReportItem;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
class a extends c {

    /* renamed from: b, reason: collision with root package name */
    private AdOrderItem f406505b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdOrderItem adOrderItem) {
        this.f406505b = adOrderItem;
    }

    @Override // hw2.c
    protected Map<Integer, AdVRReportItem> c() {
        AdOrderItem adOrderItem = this.f406505b;
        if (adOrderItem != null) {
            return adOrderItem.vrReportMap;
        }
        return null;
    }
}
