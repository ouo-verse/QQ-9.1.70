package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f124209a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f124210b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124211c;

        public a(WeakReference weakReference, int i3, int i16) {
            this.f124209a = weakReference;
            this.f124210b = i3;
            this.f124211c = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            v vVar = (v) this.f124209a.get();
            if (vVar == null) {
                return;
            }
            if (vVar.k0() != null) {
                vVar.k0().d();
            }
            if (r.b(vVar, this.f124210b)) {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            } else {
                str = "fail";
            }
            vVar.a(this.f124211c, e.this.makeReturnJson(str));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        try {
            l.a(new a(new WeakReference(vVar), jSONObject.getInt("inputId"), i3));
        } catch (JSONException unused) {
            vVar.a(i3, makeReturnJson("fail:invalid data"));
        }
    }
}
