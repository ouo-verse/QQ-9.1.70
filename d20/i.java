package d20;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.widget.u;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.q;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends a {
    private String e(String str) {
        if (TextUtils.equals(str, WSPublicAccReport.SOP_NAME_VIDEO_PLAY) || !TextUtils.equals(str, "feeds")) {
            return "vertical_layer_collection";
        }
        return "vertical_layer_collection_of_card";
    }

    private void f(Context context, Map<String, String> map, Object obj) {
        String str;
        ArrayList arrayList = new ArrayList();
        stSimpleMetaFeed a16 = q.a(map.get("feeds"));
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            str = bundle.getString(u.COLUMN_TAB_ID);
            stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) bundle.getSerializable("feed_info");
            if (stsimplemetafeed != null) {
                a16 = stsimplemetafeed;
            }
        } else {
            str = "";
        }
        if (a16 != null) {
            arrayList.add(a16);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("ext_data", this.f392671a);
        a.b.c(new k(context, e(this.f392673c), this.f392673c).M(0).D(map.get("cid")).I(map.get("feed_id")).J(arrayList).U(str).A(TextUtils.equals("1", map.get("panel_show"))).B(TextUtils.equals(this.f392672b, "miniapp")).F(bundle2));
    }

    @Override // d20.a
    protected boolean b(Context context, Map<String, String> map, Object obj) {
        f(context, map, obj);
        return true;
    }
}
