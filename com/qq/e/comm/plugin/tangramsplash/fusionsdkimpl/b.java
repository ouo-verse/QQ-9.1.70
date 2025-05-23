package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl;

import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.c.f;
import com.qq.e.comm.plugin.base.ad.model.l;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.tangramsplash.selector.c;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.service.splash.data.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a f40009a;

    /* renamed from: b, reason: collision with root package name */
    private c.b f40010b;

    /* renamed from: c, reason: collision with root package name */
    private long f40011c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i3, int i16);

        void a(e eVar);
    }

    public e a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            a aVar = this.f40009a;
            if (aVar != null) {
                aVar.a(-100, -3);
            }
            return null;
        }
        if (jSONObject.optInt("ret") != 0) {
            a aVar2 = this.f40009a;
            if (aVar2 != null) {
                aVar2.a(-100, -2);
            }
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            a aVar3 = this.f40009a;
            if (aVar3 != null) {
                aVar3.a(-101, -3);
            }
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.f40010b.f40335b);
        if (optJSONObject2 == null) {
            a aVar4 = this.f40009a;
            if (aVar4 != null) {
                aVar4.a(-102, -4);
            }
            return null;
        }
        int optInt = optJSONObject2.optInt("ret");
        if (optInt != 0) {
            a aVar5 = this.f40009a;
            if (aVar5 != null) {
                aVar5.a(-103, -5);
            }
            return null;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            l lVar = new l(this.f40010b.f40335b, com.qq.e.comm.plugin.base.ad.b.SPLASH, (com.qq.e.comm.plugin.base.ad.definition.a) null);
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                f.a(optJSONArray.optJSONObject(i3), lVar, this.f40010b.f40336c);
            }
            c.b bVar = this.f40010b;
            List<r> a16 = a(optInt, optJSONObject, optJSONArray, new r(bVar.f40334a, bVar.f40335b, bVar.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH), optJSONArray.length());
            com.tencent.ams.fusion.service.splash.data.b.b bVar2 = new com.tencent.ams.fusion.service.splash.data.b.b();
            bVar2.f70521a = a16;
            a aVar6 = this.f40009a;
            if (aVar6 != null) {
                aVar6.a(bVar2);
            }
            return bVar2;
        }
        a aVar7 = this.f40009a;
        if (aVar7 != null) {
            aVar7.a(-104, -6);
        }
        return null;
    }

    private List<r> a(int i3, JSONObject jSONObject, JSONArray jSONArray, r rVar, int i16) {
        ArrayList arrayList = new ArrayList();
        for (int i17 = 0; i17 < i16; i17++) {
            if (i17 == 0) {
                try {
                    rVar.e(jSONArray.getJSONObject(i17));
                    r a16 = a(rVar);
                    if (a16 != null) {
                        arrayList.add(a16);
                    } else {
                        arrayList.add(rVar);
                    }
                } catch (JSONException e16) {
                    GDTLogger.e("parse error : ", e16);
                    au.a(this.f40010b.f40335b, com.qq.e.comm.plugin.base.ad.b.SPLASH.b(), System.currentTimeMillis() - this.f40011c, 1310231, 200, e16.getMessage(), i3, jSONObject.toString());
                }
            }
            if (i17 == 1) {
                c.b bVar = this.f40010b;
                r rVar2 = new r(bVar.f40334a, bVar.f40335b, bVar.f40336c, com.qq.e.comm.plugin.base.ad.b.SPLASH);
                rVar2.e(jSONArray.getJSONObject(i17));
                r a17 = a(rVar2);
                if (a17 != null) {
                    arrayList.add(a17);
                } else if (com.qq.e.comm.plugin.j.c.a("realTimeSecondOrderCheckUoid", 1, 1)) {
                    arrayList.add(rVar2);
                }
            }
        }
        return arrayList;
    }

    private r a(r rVar) {
        if (rVar != null && !rVar.bk()) {
            List<r> list = com.qq.e.comm.plugin.tangramsplash.selector.c.f40320a;
            String bn5 = rVar.bn();
            if (list != null && list.size() > 0 && !TextUtils.isEmpty(bn5)) {
                for (r rVar2 : list) {
                    if (bn5.equals(rVar2.bn())) {
                        GDTLogger.d("FusionAd: \u540e\u53f0\u4e0b\u53d1\u7684uOid\u547d\u4e2d\u672c\u5730\u5217\u8868");
                        rVar2.b(rVar);
                        rVar2.A(rVar.bo());
                        return rVar2;
                    }
                }
            }
        }
        return null;
    }

    public void a(a aVar) {
        this.f40009a = aVar;
    }

    public void a(long j3) {
        this.f40011c = j3;
    }

    public void a(c.b bVar) {
        this.f40010b = bVar;
    }
}
