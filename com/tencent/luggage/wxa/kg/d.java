package com.tencent.luggage.wxa.kg;

import android.app.Activity;
import android.view.Window;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "showVirtualBottomNavigationBar";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131980a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131981b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f131980a = dVar;
            this.f131981b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f131980a, this.f131981b);
        }
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar) {
        Activity h16 = com.tencent.luggage.wxa.po.b.h(dVar.getContext());
        if (h16 == null) {
            w.d("JsApiShowVirtualBottomNavigationBar", "null == activity");
            return;
        }
        Window window = h16.getWindow();
        if (window == null) {
            w.d("JsApiShowVirtualBottomNavigationBar", "null == window");
            return;
        }
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-513) & (-3) & (-4097) & (-257));
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a(dVar, i3);
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        if (!c0.b()) {
            c0.a(new a(dVar, i3));
            return;
        }
        w.d("JsApiShowVirtualBottomNavigationBar", "show");
        b(dVar);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
