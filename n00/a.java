package n00;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.q;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* compiled from: P */
    /* renamed from: n00.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static class C10816a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f417913a = new a();
    }

    a() {
    }

    public static a a() {
        return C10816a.f417913a;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "_ct=" + System.currentTimeMillis();
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str + ContainerUtils.FIELD_DELIMITER + str2;
        }
        return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
    }

    private ArrayList<stSimpleMetaFeed> d(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return null;
        }
        String str = hashMap.get("feeds");
        String str2 = hashMap.get("scene");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            bb.W(str2);
        }
        x.b("WSMiniAppHelper", "\u5c0f\u7a0b\u5e8f\u4f20\u8fc7\u6765\u7684feed\uff1a " + str);
        ArrayList<stSimpleMetaFeed> arrayList = new ArrayList<>();
        stSimpleMetaFeed a16 = q.a(str);
        if (a16 != null) {
            arrayList.add(a16);
        }
        return arrayList;
    }

    public boolean b(Context context, HashMap<String, String> hashMap) {
        String str;
        String str2;
        String str3;
        stSimpleMetaPerson stsimplemetaperson;
        if (context == null || hashMap == null) {
            return false;
        }
        ArrayList<stSimpleMetaFeed> d16 = d(hashMap);
        if (d16 != null && d16.size() > 0 && (stsimplemetaperson = d16.get(0).poster) != null && TextUtils.equals(stsimplemetaperson.f25130id, bb.q())) {
            str = "mini_app_personal_main";
            str2 = "homepage_main";
        } else {
            str = "mini_app_personal_guest";
            str2 = "homepage_guest";
        }
        String str4 = hashMap.get("scenes_from");
        Bundle bundle = new Bundle();
        if ("share".equals(str4)) {
            v.b().f();
            v.b().e();
            bundle.putString("spid", hashMap.get("spid"));
            bundle.putString("share_collection_id", hashMap.get("collection_id"));
            bundle.putString("share_active_id", hashMap.get("active_id"));
            bundle.putString("scenes_channel_from", hashMap.get("share_scenes_from"));
            bundle.putString("web_test_id", hashMap.get("web_test_id"));
            if (d16 != null && d16.size() > 0) {
                str3 = d16.get(0).f25129id;
            } else {
                str3 = "";
            }
            bundle.putString("share_feed_id", str3);
            str = "share";
            str2 = str;
        }
        a.b.c(new k(context, str, str2).J(d16).B(!TextUtils.equals(hashMap.get(ISchemeApi.KEY_IOS_SRC_TYPE), "web")).F(bundle));
        WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_qq_scheme", bundle);
        return true;
    }
}
