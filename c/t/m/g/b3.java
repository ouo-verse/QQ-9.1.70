package c.t.m.g;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class b3 {

    /* renamed from: a, reason: collision with root package name */
    public int f29512a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<TencentPoi> f29513b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public g3 f29514c;

    public b3() {
    }

    public static b3 a(b3 b3Var) {
        if (b3Var == null) {
            return null;
        }
        b3 b3Var2 = new b3();
        b3Var2.f29512a = b3Var.f29512a;
        b3Var2.f29514c = g3.a(b3Var.f29514c);
        Iterator<TencentPoi> it = b3Var.f29513b.iterator();
        while (it.hasNext()) {
            b3Var2.f29513b.add(new f3(it.next()));
        }
        return b3Var2;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("DetailsData{");
        sb5.append("subnation=");
        sb5.append(this.f29514c);
        sb5.append(",");
        sb5.append("poilist=[");
        Iterator<TencentPoi> it = this.f29513b.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append(",");
        }
        sb5.append("]");
        sb5.append("}");
        return sb5.toString();
    }

    public b3(JSONObject jSONObject) throws JSONException {
        this.f29512a = jSONObject.optInt("stat");
        if (jSONObject.has("subnation")) {
            this.f29514c = new g3(jSONObject.optJSONObject("subnation"));
        } else if (jSONObject.has(ForwardMiniChooseFriendOption.RESULT_LIST)) {
            this.f29514c = a(jSONObject.optJSONArray(ForwardMiniChooseFriendOption.RESULT_LIST));
        } else {
            this.f29514c = g3.f29696m;
            o3.a("DetailsData", "DetailsData: unknown json " + jSONObject.toString());
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("poilist");
        if (optJSONArray != null) {
            try {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    this.f29513b.add(new f3(optJSONArray.getJSONObject(i3)));
                }
            } catch (JSONException e16) {
                o3.a("DetailsData", "json error", e16);
            }
        }
    }

    public final g3 a(@Nullable JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        g3 a16 = g3.a(g3.f29696m);
        int length = jSONArray.length();
        if (length > 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            a16.f29697a = optJSONObject.optString(DomainData.DOMAIN_NAME);
            a16.f29700d = optJSONObject.optString("p");
            a16.f29701e = optJSONObject.optString("c");
            a16.f29702f = optJSONObject.optString("d");
            a16.f29699c = optJSONObject.optString("adcode");
        }
        if (length > 1) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(1);
            a16.f29708l.putString("addrdesp.name", optJSONObject2.optString("address_name"));
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("landmark");
            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("second_landmark");
            if (optJSONObject3 != null) {
                a16.f29708l.putParcelable("addrdesp.landmark", new a3(optJSONObject3));
            }
            if (optJSONObject4 != null) {
                a16.f29708l.putParcelable("addrdesp.second_landmark", new a3(optJSONObject4));
            }
        }
        if (length > 2) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i3 = 2; i3 < length; i3++) {
                a3 a3Var = new a3(jSONArray.optJSONObject(i3));
                arrayList.add(a3Var);
                if (NowProxyConstants.AccountInfoKey.ST.equals(a3Var.f29480b)) {
                    a16.f29705i = a3Var.f29479a;
                } else if ("ST_NO".equals(a3Var.f29480b)) {
                    a16.f29706j = a3Var.f29479a;
                }
            }
            a16.f29708l.putParcelableArrayList("addrdesp.results", arrayList);
        }
        return a16;
    }
}
