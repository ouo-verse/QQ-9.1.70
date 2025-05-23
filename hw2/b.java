package hw2;

import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdVRReportList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
class b extends d {

    /* renamed from: b, reason: collision with root package name */
    private AdOrderItem f406506b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AdOrderItem adOrderItem) {
        this.f406506b = adOrderItem;
    }

    @Override // hw2.d
    protected Map<Integer, AdVRReportList> c() {
        AdOrderItem adOrderItem = this.f406506b;
        if (adOrderItem != null) {
            return adOrderItem.vr_report_dict;
        }
        return null;
    }
}
