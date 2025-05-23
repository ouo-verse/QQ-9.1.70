package com.tencent.luggage.wxa.re;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.rj.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends com.tencent.luggage.wxa.ee.b {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";

    /* renamed from: b, reason: collision with root package name */
    public static d f139602b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f139603a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139604a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139605b;

        public a(WeakReference weakReference, WeakReference weakReference2) {
            this.f139604a = weakReference;
            this.f139605b = weakReference2;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            e eVar = (e) this.f139604a.get();
            com.tencent.luggage.wxa.xd.f fVar = (com.tencent.luggage.wxa.xd.f) this.f139605b.get();
            if (eVar != null && fVar != null) {
                fVar.a((g.d) eVar);
                fVar.b((g.b) eVar);
                fVar.b((g.c) eVar);
                com.tencent.luggage.wxa.re.a.b().b(eVar.getCameraId());
                com.tencent.luggage.wxa.ic.e.b(fVar.getAppId(), this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.re.b {
        public b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements ActivityCompat.OnRequestPermissionsResultCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139608a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139609b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ee.j f139610c;

        public c(WeakReference weakReference, WeakReference weakReference2, com.tencent.luggage.wxa.ee.j jVar) {
            this.f139608a = weakReference;
            this.f139609b = weakReference2;
            this.f139610c = jVar;
        }

        @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
        public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
            e eVar = (e) this.f139608a.get();
            com.tencent.luggage.wxa.xd.d dVar = (com.tencent.luggage.wxa.xd.d) this.f139609b.get();
            if (i3 == 16) {
                if (iArr != null && iArr.length > 0 && iArr[0] == 0 && eVar != null && dVar != null) {
                    com.tencent.luggage.wxa.re.a.b().a(true);
                    j.this.a(dVar, eVar, this.f139610c);
                    return;
                }
                HashMap hashMap = new HashMap();
                if (eVar != null) {
                    hashMap.put("cameraId", Integer.valueOf(eVar.getCameraId()));
                } else {
                    w.f("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
                }
                if (dVar != null) {
                    new h().setContext(dVar).setData(new JSONObject(hashMap).toString()).dispatch();
                } else {
                    w.f("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
                }
                com.tencent.luggage.wxa.re.a.b().a(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        e a(Context context);
    }

    public static int b(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals("medium")) {
                    c16 = 0;
                    break;
                }
                break;
            case 102742843:
                if (str.equals(NtFaceConstant.LARGE)) {
                    c16 = 1;
                    break;
                }
                break;
            case 109548807:
                if (str.equals(NtFaceConstant.SMALL)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 480;
            case 1:
                return 720;
            case 2:
            default:
                return 288;
        }
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.ee.b
    public View inflateView(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject) {
        char c16;
        int i3;
        int[] a16;
        this.f139603a = false;
        Context context = fVar.getContext();
        e a17 = f139602b.a(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("mode", "normal");
        String optString2 = jSONObject.optString("devicePosition", "back");
        String optString3 = jSONObject.optString("flash", "auto");
        int b16 = b(jSONObject.optString("size"));
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        String optString4 = jSONObject.optString("resolution", "medium");
        a17.setAppId(fVar.getAppId());
        a17.setPage(fVar);
        a17.setCameraId(optInt);
        a17.setMode(optString);
        a17.a(optString2, true);
        a17.setFlash(optString3);
        a17.setFrameLimitSize(b16);
        a17.setNeedOutput(optBoolean);
        a17.setResolution(optString4);
        a17.setPageOrientation(fVar.d());
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a18 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "width", 0);
        int a19 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "height", 0);
        if (a18 != 0 && a19 != 0) {
            a17.a(a18, a19, true);
        }
        com.tencent.luggage.wxa.re.d dVar = (com.tencent.luggage.wxa.re.d) fVar.b(com.tencent.luggage.wxa.re.d.class);
        if (dVar != null && (a16 = dVar.a(fVar)) != null && a16.length == 2 && a16[0] > 0 && a16[1] > 0) {
            a17.setDisplayScreenSize(new Size(a16[0], a16[1]));
            w.d("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", Integer.valueOf(a16[0]), Integer.valueOf(a16[1]));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray != null && optJSONArray.length() == 4) {
            w.d("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            a17.a(com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(0)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(1)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(2)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(3)));
            c16 = 0;
        } else {
            c16 = 0;
            a17.a(0, 0, a18, a19);
        }
        a17.setScanFreq(jSONObject.optInt("scanFreq"));
        boolean optBoolean2 = jSONObject.optBoolean("centerCrop");
        a17.setPreviewCenterCrop(optBoolean2);
        Object[] objArr = new Object[6];
        objArr[c16] = Integer.valueOf(optInt);
        objArr[1] = optString2;
        objArr[2] = optString3;
        objArr[3] = Integer.valueOf(a18);
        objArr[4] = Integer.valueOf(a19);
        objArr[5] = Boolean.valueOf(optBoolean2);
        w.a("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d, centerCrop: %b", objArr);
        View view = a17.getView();
        if ("normal".equals(optString)) {
            i3 = R.string.ywb;
        } else {
            i3 = R.string.ywc;
        }
        view.setContentDescription(context.getString(i3));
        return new com.tencent.luggage.wxa.ye.b(context, (View) a17);
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public boolean isAsyncCallback() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.ee.b
    public void onInsertViewWithAsyncCallback(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, com.tencent.luggage.wxa.ee.j jVar) {
        w.d("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i3));
        e eVar = (e) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        if (eVar == null) {
            w.b("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", Integer.valueOf(i3));
            jVar.a(makeReturnJson("fail:internal error"));
            return;
        }
        WeakReference weakReference = new WeakReference(eVar);
        WeakReference weakReference2 = new WeakReference(fVar);
        a(fVar, eVar, jVar);
        com.tencent.luggage.wxa.re.a.b().a(eVar.getCameraId(), eVar);
        fVar.b((g.d) eVar);
        fVar.a((g.b) eVar);
        fVar.a((g.c) eVar);
        com.tencent.luggage.wxa.ic.e.a(fVar.getAppId(), new a(weakReference, weakReference2));
        eVar.setOutPutCallBack(new b());
    }

    public static void a(d dVar) {
        f139602b = dVar;
    }

    public final boolean a(com.tencent.luggage.wxa.xd.d dVar, e eVar, com.tencent.luggage.wxa.ee.j jVar) {
        q.c(String.valueOf(dVar.getAppId()), new c(new WeakReference(eVar), new WeakReference(dVar), jVar));
        Activity activity = (Activity) dVar.getContext();
        if (activity == null) {
            return false;
        }
        com.tencent.luggage.wxa.re.a.b().b(com.tencent.luggage.wxa.h6.k.a(activity, dVar, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE));
        boolean a16 = com.tencent.luggage.wxa.h6.k.a(activity, dVar, QQPermissionConstants.Permission.CAMERA, 16, "", "");
        com.tencent.luggage.wxa.re.a.b().a(a16);
        if (!a16) {
            return false;
        }
        q.a(dVar.getAppId());
        if (!this.f139603a) {
            jVar.a(makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            eVar.a();
            this.f139603a = true;
        }
        return true;
    }
}
