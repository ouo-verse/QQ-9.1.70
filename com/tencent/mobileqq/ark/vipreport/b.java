package com.tencent.mobileqq.ark.vipreport;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f199672a;

    /* renamed from: b, reason: collision with root package name */
    public String f199673b;

    /* renamed from: c, reason: collision with root package name */
    public String f199674c;

    /* renamed from: d, reason: collision with root package name */
    public String f199675d;

    /* renamed from: e, reason: collision with root package name */
    public String f199676e;

    /* renamed from: f, reason: collision with root package name */
    public String f199677f;

    /* renamed from: g, reason: collision with root package name */
    public String f199678g;

    /* renamed from: h, reason: collision with root package name */
    public long f199679h;

    /* renamed from: i, reason: collision with root package name */
    public long f199680i;

    /* renamed from: j, reason: collision with root package name */
    public long f199681j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<a> f199682k;

    public JSONObject a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject jSONObject = new JSONObject();
        try {
            String str7 = "";
            if (TextUtils.isEmpty(this.f199672a)) {
                str = "";
            } else {
                str = this.f199672a;
            }
            jSONObject.put("uin", str);
            if (TextUtils.isEmpty(this.f199673b)) {
                str2 = "";
            } else {
                str2 = this.f199673b;
            }
            jSONObject.put("phone", str2);
            if (TextUtils.isEmpty(this.f199674c)) {
                str3 = "";
            } else {
                str3 = this.f199674c;
            }
            jSONObject.put("os", str3);
            if (TextUtils.isEmpty(this.f199675d)) {
                str4 = "";
            } else {
                str4 = this.f199675d;
            }
            jSONObject.put("qqver", str4);
            if (TextUtils.isEmpty(this.f199676e)) {
                str5 = "";
            } else {
                str5 = this.f199676e;
            }
            jSONObject.put("scene", str5);
            if (TextUtils.isEmpty(this.f199677f)) {
                str6 = "";
            } else {
                str6 = this.f199677f;
            }
            jSONObject.put("startEvt", str6);
            if (!TextUtils.isEmpty(this.f199678g)) {
                str7 = this.f199678g;
            }
            jSONObject.put("endEvt", str7);
            jSONObject.put("startTime", this.f199679h);
            jSONObject.put("endTime", this.f199680i);
            jSONObject.put("costTime", this.f199681j);
            JSONArray jSONArray = new JSONArray();
            if (this.f199682k != null) {
                for (int i3 = 0; i3 < this.f199682k.size(); i3++) {
                    jSONArray.put(i3, this.f199682k.get(i3).a());
                }
            }
            jSONObject.put("evtlist", jSONArray);
        } catch (JSONException e16) {
            QLog.e("ArkVipReportScene", 1, "getJsonObject()", e16);
        }
        return jSONObject;
    }
}
