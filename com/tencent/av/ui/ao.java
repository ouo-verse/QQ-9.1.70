package com.tencent.av.ui;

import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ao {

    /* renamed from: d, reason: collision with root package name */
    public static String f75372d = "VoiceChangeData";

    /* renamed from: e, reason: collision with root package name */
    private static ao f75373e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f75374a = false;

    /* renamed from: b, reason: collision with root package name */
    private a[] f75375b = null;

    /* renamed from: c, reason: collision with root package name */
    private Object f75376c = new Object();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f75377a;

        /* renamed from: b, reason: collision with root package name */
        public String f75378b;

        /* renamed from: c, reason: collision with root package name */
        public String f75379c;

        /* renamed from: d, reason: collision with root package name */
        public int f75380d;

        /* renamed from: e, reason: collision with root package name */
        public int f75381e;
    }

    ao() {
    }

    public static ao a() {
        if (f75373e == null) {
            synchronized (ao.class) {
                if (f75373e == null) {
                    f75373e = new ao();
                }
            }
        }
        return f75373e;
    }

    public a[] b() {
        if (this.f75375b == null) {
            c(QAVConfig.e(172).f448490b);
        }
        if (this.f75375b == null && !this.f75374a) {
            ap.c("0X8007EFD", "");
            this.f75374a = true;
        }
        return this.f75375b;
    }

    protected void c(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.f75376c) {
            this.f75375b = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("voices")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("voices");
                    AVCoreLog.printAllUserLog(f75372d, "parseConfig|voices size= " + jSONArray.length());
                    this.f75375b = new a[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        a aVar = new a();
                        aVar.f75377a = jSONObject2.getString("name");
                        aVar.f75378b = jSONObject2.getString("icon1");
                        aVar.f75379c = jSONObject2.getString("icon2");
                        aVar.f75380d = Integer.parseInt(jSONObject2.getString("type"));
                        aVar.f75381e = Integer.parseInt(jSONObject2.getString("vip_level"));
                        this.f75375b[i3] = aVar;
                    }
                }
            } catch (JSONException e16) {
                QLog.w(f75372d, 1, "parseConfig, JSONException, \ncontent[" + str + "]", e16);
                this.f75375b = null;
            }
        }
    }
}
