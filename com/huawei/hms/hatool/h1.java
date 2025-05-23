package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h1 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    private List<b1> f37125a;

    /* renamed from: b, reason: collision with root package name */
    private k0 f37126b;

    /* renamed from: c, reason: collision with root package name */
    private t0 f37127c;

    /* renamed from: d, reason: collision with root package name */
    private o1 f37128d;

    /* renamed from: e, reason: collision with root package name */
    private String f37129e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f37130f;

    public h1(String str) {
        this.f37130f = str;
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        String str;
        List<b1> list = this.f37125a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f37126b == null || this.f37127c == null || this.f37128d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f37126b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a16 = this.f37128d.a();
            a16.put(Constants.Service.PROPERTIES, this.f37127c.a());
            try {
                a16.put("events_global_properties", new JSONObject(this.f37129e));
            } catch (JSONException unused) {
                a16.put("events_global_properties", this.f37129e);
            }
            jSONObject2.put("events_common", a16);
            JSONArray jSONArray = new JSONArray();
            Iterator<b1> it = this.f37125a.iterator();
            while (it.hasNext()) {
                JSONObject a17 = it.next().a();
                if (a17 != null) {
                    jSONArray.mo162put(a17);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(LinkReportConstant$GlobalKey.EVENTS, jSONArray);
            try {
                String a18 = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f37130f);
                if (TextUtils.isEmpty(a18)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", a18);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f37126b = k0Var;
    }

    public void a(l lVar) {
        this.f37128d = lVar;
    }

    public void a(t0 t0Var) {
        this.f37127c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f37129e = str;
        }
    }

    public void a(List<b1> list) {
        this.f37125a = list;
    }
}
