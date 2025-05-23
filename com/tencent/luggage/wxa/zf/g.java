package com.tencent.luggage.wxa.zf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.zl.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class g extends com.tencent.luggage.wxa.zf.a {
    private static final int CTRL_INDEX = 257;
    private static final String NAME = "showMultiPickerView";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends k0 {
        private static final int CTRL_INDEX = 259;
        private static final String NAME = "onMultiPickerViewChange";

        public b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class c extends e implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        public final AtomicReference f146586i;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.super.d();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zf.g$c$c, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6984c implements c.i {
            public C6984c() {
            }

            @Override // com.tencent.luggage.wxa.zl.c.i
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(boolean z16, int[] iArr) {
                c.this.b().d();
                if (!z16) {
                    c.this.a("fail cancel");
                    return;
                }
                if (iArr != null && iArr.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 : iArr) {
                        jSONArray.put(i3);
                    }
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("current", jSONArray);
                    c.this.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
                    return;
                }
                c.this.a("fail error result");
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class d implements c.j {
            public d() {
            }

            @Override // com.tencent.luggage.wxa.zl.c.j
            public void a(int[] iArr) {
                int i3 = iArr[0];
                int i16 = iArr[1];
                b bVar = new b();
                HashMap hashMap = new HashMap(2);
                hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                hashMap.put("column", Integer.valueOf(i3));
                hashMap.put("current", Integer.valueOf(i16));
                bVar.setData(hashMap);
                c.this.a(bVar);
            }
        }

        public c() {
            this.f146586i = new AtomicReference();
        }

        @Override // com.tencent.luggage.wxa.zf.e
        public void b(JSONObject jSONObject) {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) b(AppBrandMultiOptionsPicker.class);
            if (appBrandMultiOptionsPicker == null) {
                a("fail cant init view");
                return;
            }
            AppBrandMultiOptionsPicker.c[] cVarArr = (AppBrandMultiOptionsPicker.c[]) this.f146586i.get();
            if (cVarArr != null && cVarArr.length > 0) {
                appBrandMultiOptionsPicker.a(cVarArr);
                b().setOnResultListener(new C6984c());
                b().setOnValueUpdateListener(new d());
                b().j();
                return;
            }
            a("fail error data");
        }

        @Override // com.tencent.luggage.wxa.zf.e
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray != null && optJSONArray2 != null && optJSONArray.length() == optJSONArray2.length()) {
                if (optJSONArray.length() <= 0) {
                    a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    w.d("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
                    a(new a());
                    return;
                }
                try {
                    AppBrandMultiOptionsPicker.c[] cVarArr = new AppBrandMultiOptionsPicker.c[optJSONArray.length()];
                    boolean z16 = true;
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONArray jSONArray = optJSONArray.getJSONArray(i3);
                        cVarArr[i3] = g.c(jSONArray, optJSONArray2.getInt(i3));
                        z16 &= jSONArray.length() <= 0;
                    }
                    if (z16) {
                        a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        w.d("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                        a(new b());
                        return;
                    } else {
                        this.f146586i.set(cVarArr);
                        a((Runnable) this);
                        return;
                    }
                } catch (Exception e16) {
                    w.a("MicroMsg.JsApiShowMultiPickerView", e16, "opt params", new Object[0]);
                    a("fail:invalid data");
                    return;
                }
            }
            a("fail:invalid data");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends e implements Runnable {

        /* renamed from: i, reason: collision with root package name */
        public final AtomicReference f146592i;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.d();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.super.d();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class c implements c.i {
            public c() {
            }

            @Override // com.tencent.luggage.wxa.zl.c.i
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(boolean z16, int[] iArr) {
                d.this.b().d();
                if (!z16) {
                    d.this.a("fail cancel");
                    return;
                }
                if (iArr != null && iArr.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 : iArr) {
                        jSONArray.put(i3);
                    }
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("current", jSONArray);
                    d.this.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
                    return;
                }
                d.this.a("fail error result");
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zf.g$d$d, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6985d implements c.j {
            public C6985d() {
            }

            @Override // com.tencent.luggage.wxa.zl.c.j
            public void a(int[] iArr) {
                int i3 = iArr[0];
                int i16 = iArr[1];
                b bVar = new b();
                HashMap hashMap = new HashMap(2);
                hashMap.put("errMsg", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                hashMap.put("column", Integer.valueOf(i3));
                hashMap.put("current", Integer.valueOf(i16));
                bVar.setData(hashMap);
                d.this.a(bVar);
            }
        }

        public d() {
            this.f146592i = new AtomicReference();
        }

        @Override // com.tencent.luggage.wxa.zf.e
        public void b(JSONObject jSONObject) {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppBrandMultiOptionsPickerV2 appBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2) b(AppBrandMultiOptionsPickerV2.class);
            if (appBrandMultiOptionsPickerV2 == null) {
                a("fail cant init view");
                return;
            }
            AppBrandMultiOptionsPickerV2.b[] bVarArr = (AppBrandMultiOptionsPickerV2.b[]) this.f146592i.get();
            if (bVarArr != null && bVarArr.length > 0) {
                appBrandMultiOptionsPickerV2.a(bVarArr);
                b().setOnResultListener(new c());
                b().setOnValueUpdateListener(new C6985d());
                b().setHeader(this.f146583g);
                b().j();
                return;
            }
            a("fail error data");
        }

        @Override // com.tencent.luggage.wxa.zf.e
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray != null && optJSONArray2 != null && optJSONArray.length() == optJSONArray2.length()) {
                if (optJSONArray.length() <= 0) {
                    a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                    w.d("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
                    a(new a());
                    return;
                }
                try {
                    AppBrandMultiOptionsPickerV2.b[] bVarArr = new AppBrandMultiOptionsPickerV2.b[optJSONArray.length()];
                    boolean z16 = true;
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONArray jSONArray = optJSONArray.getJSONArray(i3);
                        bVarArr[i3] = g.d(jSONArray, optJSONArray2.getInt(i3));
                        z16 &= jSONArray.length() <= 0;
                    }
                    if (z16) {
                        a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                        w.d("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
                        a(new b());
                        return;
                    } else {
                        this.f146592i.set(bVarArr);
                        a((Runnable) this);
                        return;
                    }
                } catch (Exception e16) {
                    w.a("MicroMsg.JsApiShowMultiPickerView", e16, "opt params", new Object[0]);
                    a("fail:invalid data");
                    return;
                }
            }
            a("fail:invalid data");
        }
    }

    public static AppBrandMultiOptionsPicker.c c(JSONArray jSONArray, int i3) {
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i16 = 0; i16 < length; i16++) {
            strArr[i16] = jSONArray.getString(i16);
        }
        return new AppBrandMultiOptionsPicker.c(strArr, i3);
    }

    public static AppBrandMultiOptionsPickerV2.b d(JSONArray jSONArray, int i3) {
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i16 = 0; i16 < length; i16++) {
            strArr[i16] = jSONArray.getString(i16);
        }
        return new AppBrandMultiOptionsPickerV2.b(strArr, i3);
    }

    @Override // com.tencent.luggage.wxa.zf.a, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    public void invoke(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, int i3) {
        if (e()) {
            new d().a(this, fVar, jSONObject, i3, e());
        } else {
            new c().a(this, fVar, jSONObject, i3, e());
        }
    }
}
