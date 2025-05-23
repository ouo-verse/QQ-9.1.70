package com.tencent.luggage.wxa.z2;

import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f146215a = new AtomicReference();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z2.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class RunnableC6968a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f146216a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f146217b;

        public RunnableC6968a(WeakReference weakReference, int i3) {
            this.f146216a = weakReference;
            this.f146217b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = (String) a.f146215a.get();
            if (w0.c(str)) {
                try {
                    str = w0.a(z.c().getAssets().open("wxa_library/address"));
                    if (!w0.c(str)) {
                        a.f146215a.set(str);
                    }
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.JsApiGetRegionData", e16, "read address from assets", new Object[0]);
                }
            }
            v vVar = (v) this.f146216a.get();
            if (vVar != null && vVar.isRunning()) {
                HashMap hashMap = new HashMap(1);
                hashMap.put("data", str);
                vVar.a(this.f146217b, a.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.co.a.a(new RunnableC6968a(new WeakReference(vVar), i3), "LuggageJsApiGetRegionData");
    }
}
