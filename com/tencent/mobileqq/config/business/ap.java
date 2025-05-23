package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    private a f202516a;

    /* renamed from: b, reason: collision with root package name */
    private String f202517b;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements com.tencent.mobileqq.config.n<String> {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<b> f202518a = new ArrayList<>();

        /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[Catch: JSONException -> 0x00a7, TryCatch #0 {JSONException -> 0x00a7, blocks: (B:7:0x0019, B:10:0x002a, B:12:0x0030, B:14:0x005c, B:16:0x0064, B:21:0x0088, B:23:0x008d, B:25:0x006f, B:27:0x0075, B:30:0x0090, B:32:0x0096), top: B:6:0x0019 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008d A[SYNTHETIC] */
        @Override // com.tencent.mobileqq.config.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onParse(String str) {
            boolean z16;
            this.f202518a.clear();
            if (TextUtils.isEmpty(str)) {
                QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config content is empty");
                return;
            }
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("random_list");
                if (optJSONArray != null) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        b bVar = new b();
                        bVar.f202519a = jSONObject.optString("nick", "");
                        bVar.f202520b = jSONObject.optString("headid", "");
                        bVar.f202521c = jSONObject.optString("url", "");
                        if (!TextUtils.isEmpty(bVar.f202519a) && !TextUtils.isEmpty(bVar.f202520b) && !TextUtils.isEmpty(bVar.f202521c)) {
                            z16 = true;
                            if (!z16) {
                                this.f202518a.add(bVar);
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("OpenSdkRandomConfig", 2, "OpenVirtual.random.config.parse.find invalid,index=", Integer.valueOf(i3));
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("OpenSdkRandomConfig", 2, "OpenVirtual.random.config.parse=", toString());
                }
            } catch (JSONException e16) {
                QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config.getException.", e16);
            }
        }

        public String toString() {
            if (this.f202518a.size() > 0) {
                return this.f202518a.toString();
            }
            return "";
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f202519a;

        /* renamed from: b, reason: collision with root package name */
        public String f202520b;

        /* renamed from: c, reason: collision with root package name */
        public String f202521c;

        public String toString() {
            return "{nickName:" + this.f202519a + ",headID:" + this.f202520b + ",headURL:" + this.f202521c + "}";
        }
    }

    public ap() {
        this.f202517b = "";
        this.f202516a = new a();
    }

    public a a() {
        return this.f202516a;
    }

    public ap(String str, a aVar) {
        this.f202517b = str;
        this.f202516a = aVar;
    }
}
