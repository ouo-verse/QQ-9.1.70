package hw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.parse.IVRParamsParser;
import com.tencent.qqlive.ona.protocol.jce.AdVRReportItem;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdVRReportList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    public static IVRParamsParser<String, String> a(Object obj) {
        if (obj instanceof AdOrderItem) {
            return new b((AdOrderItem) obj);
        }
        if (obj instanceof com.tencent.qqlive.ona.protocol.jce.AdOrderItem) {
            return new a((com.tencent.qqlive.ona.protocol.jce.AdOrderItem) obj);
        }
        if (obj instanceof Map) {
            return b((Map) obj);
        }
        return new e();
    }

    private static IVRParamsParser<String, String> b(Map map) {
        Iterator it;
        if (map.values() != null && (it = map.values().iterator()) != null && it.hasNext()) {
            Object next = it.next();
            if (next instanceof AdVRReportItem) {
                return new g(map);
            }
            if (next instanceof AdVRReportList) {
                return new h(map);
            }
        }
        return new e();
    }
}
