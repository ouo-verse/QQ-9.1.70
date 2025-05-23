package d20;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi.WSOpenHomeThenVideoParams;
import com.tencent.biz.pubaccount.weishi.l;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.q;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends a {
    private void e(Context context, String str, String str2, String str3) {
        String str4 = this.f392673c;
        if (str4 == null) {
            str4 = "";
        }
        a.C0826a.a(new l(context, 1, str4).l(new WSOpenHomeThenVideoParams(str, str2, new WSAutoShowCommentParams(str3), str4)).j(str));
    }

    private void f(Context context, Map<String, String> map) {
        String str;
        String str2;
        String str3 = map.get("feed_id");
        String str4 = map.get("feeds");
        if (TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", str3);
            str4 = new JSONObject(hashMap).toString();
        }
        boolean equals = "1".equals(map.get("is_pre_open_home"));
        Bundle bundle = new Bundle();
        bundle.putString("ext_data", this.f392671a);
        bundle.putString("scenes_channel_from", this.f392674d);
        bundle.putString("share_feed_id", str3);
        bundle.putString("scheme_src_type", this.f392672b);
        WSPublicAccReport wSPublicAccReport = WSPublicAccReport.getInstance();
        if (equals) {
            str = "from_open_home_then_video";
        } else {
            str = "from_qq_scheme";
        }
        wSPublicAccReport.enterPublicAccReport(null, 2, str, bundle);
        if (equals) {
            e(context, str3, str4, map.get("ext"));
            return;
        }
        stSimpleMetaFeed a16 = q.a(str4);
        ArrayList arrayList = new ArrayList();
        if (a16 != null) {
            arrayList.add(a16);
        }
        if (TextUtils.equals(map.get("scenes_from"), "weishi_share_trendstab")) {
            str2 = "msg_feed";
        } else {
            str2 = "qq_scheme_open_player";
        }
        a.b.c(new k(context, str2, this.f392673c).J(arrayList).B(TextUtils.equals(this.f392672b, "miniapp")).F(bundle).O(2).z(new WSAutoShowCommentParams(map.get("ext"))));
    }

    @Override // d20.a
    protected boolean b(Context context, Map<String, String> map, Object obj) {
        f(context, map);
        return true;
    }
}
