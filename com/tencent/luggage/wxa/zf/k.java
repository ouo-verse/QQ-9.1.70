package com.tencent.luggage.wxa.zf;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zl.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandTimePickerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class k extends e {

    /* renamed from: i, reason: collision with root package name */
    public int f146610i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f146611j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f146612k = Integer.MAX_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f146613l = Integer.MAX_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f146614m = -1;
    public int C = -1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements c.i {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.zl.c.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(boolean z16, String str) {
            k.this.a(z16, str);
        }
    }

    @Override // com.tencent.luggage.wxa.zf.e
    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(DownloaderConstant.KEY_RANGE);
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("start");
            String optString2 = optJSONObject.optString("end");
            int[] a16 = com.tencent.luggage.wxa.zl.f.a(optString);
            if (a16 != null) {
                this.f146610i = a16[0];
                this.f146611j = a16[1];
            }
            int[] a17 = com.tencent.luggage.wxa.zl.f.a(optString2);
            if (a17 != null) {
                this.f146612k = a17[0];
                this.f146613l = a17[1];
            }
        }
        this.f146610i = Math.max(this.f146610i, 0);
        this.f146611j = Math.max(this.f146611j, 0);
        this.f146612k = Math.min(this.f146612k, 23);
        this.f146613l = Math.min(this.f146613l, 59);
        int[] a18 = com.tencent.luggage.wxa.zl.f.a(jSONObject.optString("current"));
        if (a18 != null) {
            this.f146614m = a18[0];
            this.C = a18[1];
        }
        a(new a());
    }

    public final void e() {
        AppBrandTimePickerV2 appBrandTimePickerV2 = (AppBrandTimePickerV2) b(AppBrandTimePickerV2.class);
        if (appBrandTimePickerV2 == null) {
            a("fail cant init view");
            return;
        }
        com.tencent.luggage.wxa.zl.a b16 = b();
        appBrandTimePickerV2.setMinTime(this.f146610i, this.f146611j);
        appBrandTimePickerV2.setMaxTime(this.f146612k, this.f146613l);
        appBrandTimePickerV2.init(this.f146614m, this.C);
        b16.setOnResultListener(new b());
        b16.setHeader(this.f146583g);
        b16.j();
    }

    @Override // com.tencent.luggage.wxa.zf.e
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    public final void a(boolean z16, String str) {
        if (b() != null) {
            b().d();
        }
        if (!z16) {
            a("fail cancel", (Map) null);
        } else {
            if (w0.c(str)) {
                a("fail", (Map) null);
                return;
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("value", str);
            a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
        }
    }
}
