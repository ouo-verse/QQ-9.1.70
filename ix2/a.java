package ix2;

import android.text.TextUtils;
import com.squareup.wire.AnyMessage;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.tvideo.protocol.pb.AdFeedInfo;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import feedcloud.FeedCloudMeta$StFeed;
import gw2.b;
import java.util.List;
import java.util.Map;
import jy2.g;
import pw2.p;
import tvideo.Ads;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f408916a = false;

    /* renamed from: b, reason: collision with root package name */
    private final int f408917b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f408918c;

    /* renamed from: d, reason: collision with root package name */
    private int f408919d;

    private String a(String str, AdOrderItem adOrderItem) {
        if (adOrderItem != null && adOrderItem.vr_report_dict != null) {
            Map<String, String> b16 = b.b(adOrderItem);
            if (TextUtils.isEmpty(str)) {
                str = b16.get(VRReportDefine$ReportParam.AD_MOD_ID);
            }
            return ("mod_id=" + str) + "&mod_idx=" + b16.get(VRReportDefine$ReportParam.AD_MOD_IDX);
        }
        return "";
    }

    private String b(List<FeedCloudMeta$StFeed> list) {
        AnyMessage anyMessage;
        AdFeedInfo adFeedInfo;
        this.f408919d = 0;
        String str = "";
        if (list == null) {
            return "";
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(i3);
            Ads p16 = g.p(feedCloudMeta$StFeed);
            if (p16 != null && (anyMessage = p16.ad_feed_info) != null && (adFeedInfo = (AdFeedInfo) p.c(AdFeedInfo.class, anyMessage)) != null) {
                String a16 = a(feedCloudMeta$StFeed.f398449id.get(), adFeedInfo.order_item);
                this.f408919d++;
                if (TextUtils.isEmpty(str)) {
                    str = a16;
                } else {
                    str = str + "#" + a16;
                }
            }
        }
        return str;
    }

    public void c(nw2.a aVar, Map<String, Object> map) {
        this.f408918c = aVar.d();
        nw2.b.c(aVar, map);
    }

    public void d(nw2.a aVar, Map<String, Object> map) {
        aVar.k(this.f408918c);
        nw2.b.d(aVar, map);
    }

    public void e(List<FeedCloudMeta$StFeed> list, Map<String, String> map, Map<String, Object> map2) {
        int i3;
        String b16 = b(list);
        nw2.a aVar = new nw2.a();
        nw2.a l3 = aVar.k(this.f408918c).g(this.f408919d).h(b16).m(map).l(this.f408916a);
        if (TextUtils.isEmpty(b16)) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        l3.j(i3);
        nw2.b.d(aVar, map2);
    }
}
