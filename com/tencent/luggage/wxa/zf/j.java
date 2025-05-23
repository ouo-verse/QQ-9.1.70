package com.tencent.luggage.wxa.zf;

import android.view.View;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zl.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class j extends e {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.super.d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f146602a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f146603b;

        public b(String[] strArr, int i3) {
            this.f146602a = strArr;
            this.f146603b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a(this.f146602a, this.f146603b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.zl.a f146605a;

        public c(com.tencent.luggage.wxa.zl.a aVar) {
            this.f146605a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f146605a.getPicker() != null && (this.f146605a.getPicker() instanceof View)) {
                ((View) this.f146605a.getPicker()).requestLayout();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements c.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.zl.a f146607a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppBrandOptionsPickerV3 f146608b;

        public d(com.tencent.luggage.wxa.zl.a aVar, AppBrandOptionsPickerV3 appBrandOptionsPickerV3) {
            this.f146607a = aVar;
            this.f146608b = appBrandOptionsPickerV3;
        }

        @Override // com.tencent.luggage.wxa.zl.c.i
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(boolean z16, String str) {
            this.f146607a.d();
            if (!z16) {
                j.this.a("fail cancel", (Map) null);
                return;
            }
            HashMap hashMap = new HashMap(2);
            hashMap.put("value", this.f146608b.currentValue());
            hashMap.put("index", Integer.valueOf(this.f146608b.a()));
            j.this.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
        }
    }

    @Override // com.tencent.luggage.wxa.zf.e
    public void b(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
        int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            String[] strArr = new String[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    strArr[i3] = optJSONArray.getString(i3);
                } catch (Exception e16) {
                    w.b("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", w0.a((Throwable) e16));
                    a("fail", (Map) null);
                    return;
                }
            }
            a(new b(strArr, optInt));
            return;
        }
        w.d("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
        a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, (Map) null);
        a(new a());
    }

    @Override // com.tencent.luggage.wxa.zf.e
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    public final void a(String[] strArr, int i3) {
        AppBrandOptionsPickerV3 appBrandOptionsPickerV3 = (AppBrandOptionsPickerV3) b(AppBrandOptionsPickerV3.class);
        if (appBrandOptionsPickerV3 == null) {
            a("fail cant init view");
            return;
        }
        com.tencent.luggage.wxa.zl.a b16 = b();
        b16.post(new c(b16));
        appBrandOptionsPickerV3.c(i3);
        appBrandOptionsPickerV3.e();
        appBrandOptionsPickerV3.a(strArr);
        b16.setOnResultListener(new d(b16, appBrandOptionsPickerV3));
        b16.setHeader(this.f146583g);
        b16.j();
    }
}
