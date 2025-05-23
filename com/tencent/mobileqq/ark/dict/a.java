package com.tencent.mobileqq.ark.dict;

import android.text.TextUtils;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.ark.dict.b;
import com.tencent.mobileqq.config.n;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends c implements n<String> {

    /* renamed from: g, reason: collision with root package name */
    protected String f199437g = "";

    private static d b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.f199447a = jSONObject.optInt("type", -1);
        dVar.f199451e = jSONObject.optString("md5", null);
        dVar.f199449c = jSONObject.optString("url", null);
        dVar.f199448b = jSONObject.optString("name", null);
        dVar.f199450d = jSONObject.optString(IECDtReport.ACTION_IDENTIFIER, null);
        if (!dVar.b()) {
            QLog.i("AIDictConfig", 1, "getDictInfoFromJSON, invalid dict info");
            return null;
        }
        com.tencent.mobileqq.ark.util.e.b("AIDictConfig", 1, "onParse getDictInfoFromJSON  info.type=" + dVar.f199447a + ", info.md5=" + dVar.f199451e + ", info.url=" + dVar.f199449c + ",  info.name =" + dVar.f199448b + ",  info.identifier =" + dVar.f199450d);
        JSONObject optJSONObject = jSONObject.optJSONObject("diff");
        if (optJSONObject != null) {
            dVar.f199452f = optJSONObject.optString("url");
            dVar.f199453g = optJSONObject.optString("diff-md5");
            dVar.f199454h = optJSONObject.optString("source-md5");
            if (!dVar.a()) {
                dVar.c();
            }
            com.tencent.mobileqq.ark.util.e.b("AIDictConfig", 1, "onParse getDictInfoFromJSON info.diffURL=" + dVar.f199452f + ", info.diffMD5=" + dVar.f199453g + ", info.diffSourceMD5=" + dVar.f199454h);
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.ark.dict.c
    public String a() {
        return this.f199437g;
    }

    @Override // com.tencent.mobileqq.config.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onParse(String str) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            QLog.i("AIDictConfig", 1, "onParse,fileOrRes is null");
            return;
        }
        this.f199437g = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f199442b = jSONObject.optString("environment");
            this.f199441a = jSONObject.optString("timestamp");
            this.f199443c = jSONObject.optString("ark_dict_init");
            this.f199444d = jSONObject.optString("netType", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("conditional_dict_list");
            if (optJSONArray != null) {
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("condition");
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("dict");
                        if (optJSONObject2 != null && optJSONObject3 != null) {
                            b bVar = new b();
                            b.a aVar = new b.a();
                            aVar.f199440a = optJSONObject2.optString("date", "");
                            bVar.f199439b = aVar;
                            c cVar = new c();
                            cVar.f199442b = optJSONObject3.optString("environment");
                            cVar.f199441a = optJSONObject3.optString("timestamp");
                            cVar.f199443c = optJSONObject3.optString("ark_dict_init");
                            cVar.f199444d = optJSONObject3.optString("netType", "");
                            jSONArray = optJSONArray;
                            com.tencent.mobileqq.ark.util.e.b("AIDictConfig", 1, "onParse conditional_dict_list tDict.environment=" + cVar.f199442b + ", tDict.mTimestamp =" + cVar.f199441a + ", tDict.mArkDictInit =" + cVar.f199443c + ", tDict.mNetType =" + cVar.f199444d + ", tCondition.mData =" + aVar.f199440a);
                            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("word_dict_list");
                            if (optJSONArray2 != null) {
                                ArrayList<d> arrayList = new ArrayList<>();
                                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i16);
                                    if (optJSONObject4 != null) {
                                        arrayList.add(b(optJSONObject4));
                                    }
                                }
                                cVar.f199445e = arrayList;
                            }
                            bVar.f199438a = cVar;
                            this.f199446f.add(bVar);
                            i3++;
                            optJSONArray = jSONArray;
                        }
                    }
                    jSONArray = optJSONArray;
                    i3++;
                    optJSONArray = jSONArray;
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("word_dict_list");
            if (optJSONArray3 != null) {
                this.f199445e = new ArrayList<>();
                for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i17);
                    if (optJSONObject5 != null) {
                        this.f199445e.add(b(optJSONObject5));
                    }
                }
            }
            com.tencent.mobileqq.ark.util.e.a("AIDictConfig", 1, "mWordDictList list size =", Integer.valueOf(this.f199445e.size()));
        } catch (JSONException e16) {
            QLog.e("AIDictConfig", 1, "onParse error e = ", e16);
        }
    }
}
