package com.tencent.mobileqq.troop.honor.config;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<a> f297517d;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, a> f297518e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f297519f;

    /* renamed from: h, reason: collision with root package name */
    public int f297520h;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f297517d = new SparseArray<>();
        this.f297518e = new ConcurrentHashMap<>();
        this.f297520h = 3;
        e();
    }

    private void e() {
        a aVar = new a(1, "\u9f99\u738b", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_dragonking_0_small.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_dragonking_0_big.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_dragonking_1_big.png", 1);
        a aVar2 = new a(2, "\u7fa4\u804a\u4e4b\u706b", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_groupflame1_0_small.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_groupflame1_0_big.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_groupflame1_1_big.png", 3);
        a aVar3 = new a(3, "\u7fa4\u804a\u70bd\u7130", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_groupflame2_0_small.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_groupflame2_0_big.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_groupflame2_1_big.png", 4);
        new a(6, "\u5feb\u4e50\u6e90\u6cc9", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_happysourse_0_small.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_happysourse_0_big.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_happysourse_1_big.png", 6);
        a aVar4 = new a(7, "\u5b66\u672f\u65b0\u661f", "https://sola.gtimg.cn/aoi/sola/20200515140645_j0X6gbuHNP.png", "https://sola.gtimg.cn/aoi/sola/20200515140645_j0X6gbuHNP.png", "https://sola.gtimg.cn/aoi/sola/20200515140645_j0X6gbuHNP.png", 7);
        a aVar5 = new a(8, "\u9876\u5c16\u5b66\u9738", "https://sola.gtimg.cn/aoi/sola/20200515140639_0CtWOpfVzK.png", "https://sola.gtimg.cn/aoi/sola/20200515140639_0CtWOpfVzK.png", "https://sola.gtimg.cn/aoi/sola/20200515140639_0CtWOpfVzK.png", 8);
        a aVar6 = new a(9, "\u81f3\u5c0a\u5b66\u795e", "https://sola.gtimg.cn/aoi/sola/20200515140628_P8UEYBjMBT.png", "https://sola.gtimg.cn/aoi/sola/20200515140628_P8UEYBjMBT.png", "https://sola.gtimg.cn/aoi/sola/20200515140628_P8UEYBjMBT.png", 9);
        a aVar7 = new a(10, "\u4e00\u7b14\u5f53\u5148", "https://sola.gtimg.cn/aoi/sola/20200515140654_4r94tSCdaB.png", "https://sola.gtimg.cn/aoi/sola/20200515140654_4r94tSCdaB.png", "https://sola.gtimg.cn/aoi/sola/20200515140654_4r94tSCdaB.png", 10);
        a aVar8 = new a(13, "\u58d5\u793c\u7687\u51a0", "https://sola.gtimg.cn/aoi/sola/20200930154050_juZOAMg7pt.png", "https://sola.gtimg.cn/aoi/sola/20200930154050_juZOAMg7pt.png", "https://sola.gtimg.cn/aoi/sola/20200930154050_juZOAMg7pt.png", 12);
        a aVar9 = new a(14, "\u5584\u8d22\u798f\u7984\u5bff", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_caishen_0_small.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_caishen_0_big.png", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/qqgroup/9165/qecommerce_group_caishen_1_big.png", 2);
        a(aVar);
        a(aVar2);
        a(aVar3);
        a(aVar4);
        a(aVar5);
        a(aVar6);
        a(aVar7);
        a(aVar8);
        a(aVar9);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b f(String str) {
        int i3;
        JSONObject jSONObject;
        b bVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SparseArray<a> sparseArray = new SparseArray<>();
        int i16 = 3;
        boolean z16 = false;
        try {
            jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("globalOpen", 0);
        } catch (JSONException e16) {
            e = e16;
            i3 = 0;
        }
        try {
            i16 = jSONObject.optInt("maxNumberOfAIOIcon", 3);
            JSONArray optJSONArray = jSONObject.optJSONArray("honors");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i17 = 0; i17 < optJSONArray.length(); i17++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i17);
                    int optInt = jSONObject2.optInt("id");
                    String optString = jSONObject2.optString("iconUrl");
                    String optString2 = jSONObject2.optString("bigIconUrl", optString);
                    String optString3 = jSONObject2.optString("greyBigIconUrl", optString);
                    String string = jSONObject2.getString("name");
                    int i18 = jSONObject2.getInt("priority");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                        sparseArray.append(optInt, new a(optInt, string, optString, optString2, optString3, i18));
                    }
                }
            }
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            if (sparseArray.size() <= 0) {
            }
            if (QLog.isColorLevel()) {
            }
            return bVar;
        }
        if (sparseArray.size() <= 0) {
            bVar = new b();
            bVar.f297517d = sparseArray;
            if (i3 == 1) {
                z16 = true;
            }
            bVar.f297519f = z16;
            bVar.f297520h = i16;
        } else {
            QLog.d("TroopHonor.config", 1, "parse honor size is empty!");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopHonor.config", 2, "parse content: " + str + " \n " + bVar);
        }
        return bVar;
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        SparseArray<a> sparseArray = this.f297517d;
        if (sparseArray != null) {
            sparseArray.put(aVar.f297511d, aVar);
        }
    }

    public a b(int i3, int i16) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        ConcurrentHashMap<Integer, a> concurrentHashMap = this.f297518e;
        if (concurrentHashMap == null) {
            return null;
        }
        a aVar2 = concurrentHashMap.get(Integer.valueOf(i3));
        if (aVar2 == null && (aVar = this.f297517d.get(i3)) != null) {
            a aVar3 = new a(aVar.f297511d, aVar.f297512e, com.tencent.mobileqq.troop.honor.util.a.g(i3, i16), aVar.f297514h, aVar.f297515i, aVar.f297516m);
            this.f297518e.put(Integer.valueOf(i3), aVar3);
            return aVar3;
        }
        return aVar2;
    }

    public a c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        SparseArray<a> sparseArray = this.f297517d;
        if (sparseArray != null) {
            return sparseArray.get(i3);
        }
        return null;
    }

    public List<a> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f297517d.size(); i3++) {
            arrayList.add(this.f297517d.valueAt(i3));
        }
        return arrayList;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "TroopHonorConfig{mHonorMap=" + this.f297517d + ", isSupport=" + this.f297519f + '}';
    }
}
