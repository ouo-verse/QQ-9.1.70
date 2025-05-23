package com.tencent.luggage.wxa.kg;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 581;
    private static final String NAME = "hideVirtualBottomNavigationBar";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f131973a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131974b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f131973a = dVar;
            this.f131974b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f131973a, this.f131974b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kg.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnSystemUiVisibilityChangeListenerC6384b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Window f131976a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f131977b;

        public ViewOnSystemUiVisibilityChangeListenerC6384b(Window window, int i3) {
            this.f131976a = window;
            this.f131977b = i3;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            if ((i3 & 4) == 0) {
                this.f131976a.getDecorView().setSystemUiVisibility(this.f131977b);
            }
        }
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar) {
        Activity h16 = com.tencent.luggage.wxa.po.b.h(dVar.getContext());
        if (h16 == null) {
            w.d("JsApiHideVirtualBottomNavigationBar", "null == activity");
            return;
        }
        Window window = h16.getWindow();
        if (window == null) {
            w.d("JsApiHideVirtualBottomNavigationBar", "null == window");
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 512 | 2 | 4096 | 256;
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC6384b(window, systemUiVisibility));
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
        w.d("JsApiHideVirtualBottomNavigationBar", "hide");
        b(dVar);
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
