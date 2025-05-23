package com.tencent.mobileqq.config.business.sigtopic;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.n;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private C7476a f202824a;

    /* renamed from: b, reason: collision with root package name */
    private String f202825b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.config.business.sigtopic.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7476a implements n<String> {

        /* renamed from: a, reason: collision with root package name */
        private String f202826a = "place_holder";

        /* renamed from: b, reason: collision with root package name */
        private String f202827b = "data";

        /* renamed from: c, reason: collision with root package name */
        private String f202828c = "topic_id";

        /* renamed from: d, reason: collision with root package name */
        private String f202829d = "topic_name";

        /* renamed from: e, reason: collision with root package name */
        public String f202830e = "";

        /* renamed from: f, reason: collision with root package name */
        public ArrayList<b> f202831f = new ArrayList<>();

        @Override // com.tencent.mobileqq.config.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onParse(String str) {
            boolean z16;
            this.f202831f.clear();
            if (TextUtils.isEmpty(str)) {
                QLog.e("SigTopicConfig", 1, "SigTopic config content is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray(this.f202827b);
                this.f202830e = jSONObject.optString(this.f202826a, HardCodeUtil.qqStr(R.string.f172720tk4));
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        b bVar = new b();
                        bVar.f202832a = jSONObject2.optInt(this.f202828c);
                        String optString = jSONObject2.optString(this.f202829d);
                        bVar.f202833b = optString;
                        if (TextUtils.isEmpty(optString)) {
                            if (QLog.isColorLevel()) {
                                QLog.e("SigTopicConfig", 2, "SigTopic config parse has invalid item,index=", Integer.valueOf(i3));
                            }
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            this.f202831f.add(bVar);
                        }
                    }
                }
            } catch (JSONException e16) {
                QLog.e("SigTopicConfig", 1, "SigTopic config parse exception", e16);
            }
        }

        public String toString() {
            if (this.f202831f.size() > 0) {
                return "recommend title is " + this.f202830e + ", " + this.f202831f.toString();
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f202832a;

        /* renamed from: b, reason: collision with root package name */
        public String f202833b;

        @NotNull
        public String toString() {
            return "{topicId: " + this.f202832a + ",topicName: " + this.f202833b + "}";
        }
    }

    public a() {
        this.f202825b = "";
        this.f202824a = new C7476a();
    }

    public C7476a a() {
        return this.f202824a;
    }

    public boolean b() {
        ArrayList<b> arrayList;
        C7476a c7476a = this.f202824a;
        if (c7476a != null && (arrayList = c7476a.f202831f) != null && arrayList.size() > 0) {
            return false;
        }
        return true;
    }

    public a(String str, C7476a c7476a) {
        this.f202825b = str;
        this.f202824a = c7476a;
    }
}
