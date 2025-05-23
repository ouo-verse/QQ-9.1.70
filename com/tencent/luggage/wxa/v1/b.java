package com.tencent.luggage.wxa.v1;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f142940a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f142941b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean[] f142942c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f142943d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f142944e;

        public a(l lVar, int[] iArr, boolean[] zArr, int i3, View view) {
            this.f142940a = lVar;
            this.f142941b = iArr;
            this.f142942c = zArr;
            this.f142943d = i3;
            this.f142944e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] a16 = n0.a((i) this.f142940a);
            int i3 = a16[0];
            int[] iArr = this.f142941b;
            if (i3 != iArr[0] && a16[1] != iArr[1]) {
                w.d("MicroMsg.JsApiSetDeviceOrientation", "setDeviceOrientation layout done width[%d]  height[%d]", Integer.valueOf(i3), Integer.valueOf(a16[1]));
                this.f142942c[0] = true;
                this.f142940a.a(this.f142943d, b.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                this.f142944e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(final l lVar, JSONObject jSONObject, final int i3) {
        if (jSONObject == null) {
            lVar.a(i3, makeReturnJson("fail"));
            return;
        }
        try {
            com.tencent.luggage.wxa.wj.e orientationHandler = lVar.D().getOrientationHandler();
            if (orientationHandler != null) {
                e.b a16 = e.b.a(jSONObject.optString("value", null));
                if (a16 == null) {
                    lVar.a(i3, makeReturnJson("fail:invalid data"));
                    return;
                }
                if (lVar.getRuntime() != null && lVar.getRuntime().L() != null) {
                    com.tencent.luggage.wxa.mj.e eVar = (com.tencent.luggage.wxa.mj.e) lVar.J().f(com.tencent.luggage.wxa.mj.e.class);
                    if (eVar != null) {
                        eVar.a(jSONObject.optString("value", null));
                        com.tencent.luggage.wxa.wj.c D = lVar.D();
                        Activity j3 = D instanceof WindowAndroidActivityImpl ? ((WindowAndroidActivityImpl) D).j() : null;
                        if (j3 == null) {
                            orientationHandler.a(a16, new e.a() { // from class: h41.b
                                @Override // com.tencent.luggage.wxa.wj.e.a
                                public final void a(e.b bVar, boolean z16) {
                                    com.tencent.luggage.wxa.v1.b.this.a(lVar, i3, bVar, z16);
                                }
                            });
                            return;
                        }
                        View decorView = j3.getWindow() != null ? j3.getWindow().getDecorView() : null;
                        if (decorView != null && decorView.getViewTreeObserver().isAlive()) {
                            final boolean[] zArr = {false};
                            final a aVar = new a(lVar, n0.a((i) lVar), zArr, i3, decorView);
                            decorView.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
                            final View view = decorView;
                            orientationHandler.a(a16, new e.a() { // from class: h41.c
                                @Override // com.tencent.luggage.wxa.wj.e.a
                                public final void a(e.b bVar, boolean z16) {
                                    com.tencent.luggage.wxa.v1.b.this.a(view, aVar, lVar, i3, zArr, bVar, z16);
                                }
                            });
                            return;
                        }
                        lVar.a(i3, makeReturnJson("fail: no decorView"));
                        return;
                    }
                    lVar.a(i3, makeReturnJson("fail: extension not found"));
                    return;
                }
                lVar.a(i3, makeReturnJson("fail"));
                return;
            }
            throw new NullPointerException();
        } catch (NullPointerException e16) {
            w.a("MicroMsg.JsApiSetDeviceOrientation", e16, "require WindowOrientationHandler NPE", new Object[0]);
            lVar.a(i3, makeReturnJson("fail:internal error"));
        }
    }

    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(l lVar, int i3, e.b bVar, boolean z16) {
        if (z16) {
            lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        } else {
            lVar.a(i3, makeReturnJson("fail"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final View view, final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, final l lVar, final int i3, final boolean[] zArr, e.b bVar, boolean z16) {
        if (!z16) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            lVar.a(i3, makeReturnJson("fail: requestDeviceOrientation fail"));
        } else {
            h.f146825d.c(new Runnable() { // from class: h41.a
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.luggage.wxa.v1.b.this.a(zArr, lVar, i3, view, onGlobalLayoutListener);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean[] zArr, l lVar, int i3, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (zArr[0]) {
            return;
        }
        w.d("MicroMsg.JsApiSetDeviceOrientation", "setDeviceOrientation layout timeout");
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
        e();
    }
}
