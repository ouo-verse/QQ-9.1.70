package hw2;

import com.tencent.tvideo.protocol.pb.AdVRReportList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h extends d {

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, AdVRReportList> f406510b;

    public h(Map<Integer, AdVRReportList> map) {
        this.f406510b = map;
    }

    @Override // hw2.d
    protected Map<Integer, AdVRReportList> c() {
        return this.f406510b;
    }
}
