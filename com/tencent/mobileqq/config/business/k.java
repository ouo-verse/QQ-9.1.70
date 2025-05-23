package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class k implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private a f202663d;

    /* renamed from: e, reason: collision with root package name */
    private String f202664e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements com.tencent.mobileqq.config.n<String> {

        /* renamed from: a, reason: collision with root package name */
        public int f202665a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f202666b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f202667c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f202668d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f202669e = "";

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<Integer> f202670f = new ArrayList<>();

        @Override // com.tencent.mobileqq.config.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onParse(String str) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("EmoticonQBoxConfBean", 1, "EmoticonQBox config content is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("packageIDs");
                this.f202665a = jSONObject.optInt("enable");
                this.f202666b = jSONObject.optString("message");
                this.f202667c = jSONObject.optString("cancelText");
                this.f202668d = jSONObject.optString("confirmText");
                this.f202669e = jSONObject.optString("defaultScheme");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.f202670f.add(Integer.valueOf(optJSONArray.optInt(i3)));
                    }
                }
                QLog.i("EmoticonQBoxConfBean", 1, "EmoticonQBoxConfBean: onParse: " + toString());
            } catch (JSONException e16) {
                QLog.e("EmoticonQBoxConfBean", 1, "EmoticonQBox config parse exception", e16);
            }
        }

        public String toString() {
            String obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("EmotionQBoxConfigContent: { [enable: ");
            sb5.append(this.f202665a);
            sb5.append("],[message: ");
            sb5.append(this.f202666b);
            sb5.append("],[cancelText: ");
            sb5.append(this.f202667c);
            sb5.append("],[confirmText: ");
            sb5.append(this.f202668d);
            sb5.append("],[defaultSchema: ");
            sb5.append(this.f202669e);
            sb5.append("],[packageIDs: ");
            ArrayList<Integer> arrayList = this.f202670f;
            if (arrayList == null) {
                obj = null;
            } else {
                obj = arrayList.toString();
            }
            sb5.append(obj);
            sb5.append("],}");
            return sb5.toString();
        }
    }

    public k() {
        this.f202664e = "";
        this.f202663d = new a();
    }

    public a a() {
        return this.f202663d;
    }

    public boolean b() {
        ArrayList<Integer> arrayList;
        a aVar = this.f202663d;
        if (aVar != null && (arrayList = aVar.f202670f) != null && arrayList.size() > 0) {
            return false;
        }
        return true;
    }

    public k(String str, a aVar) {
        this.f202664e = str;
        this.f202663d = aVar;
    }
}
