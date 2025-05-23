package com.tencent.luggage.wxa.rh;

import android.app.Activity;
import android.content.Context;
import android.util.Size;
import android.view.Surface;
import androidx.core.app.ActivityCompat;
import com.tencent.luggage.wxa.h6.k;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.re.e;
import com.tencent.luggage.wxa.re.h;
import com.tencent.luggage.wxa.rj.q;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.n0;
import com.tencent.luggage.wxa.xd.f;
import com.tencent.luggage.wxa.xd.g;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.rh.a implements com.tencent.luggage.wxa.ph.d {
    private static final int CTRL_INDEX = 806;
    public static final String NAME = "insertXWebCamera";

    /* renamed from: a, reason: collision with root package name */
    public boolean f139740a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f139741a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f139742b;

        public a(WeakReference weakReference, f fVar) {
            this.f139741a = weakReference;
            this.f139742b = fVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            com.tencent.luggage.wxa.re.e eVar;
            WeakReference weakReference = this.f139741a;
            if (weakReference != null && (eVar = (com.tencent.luggage.wxa.re.e) weakReference.get()) != null) {
                this.f139742b.a((g.d) eVar);
                this.f139742b.b((g.b) eVar);
                this.f139742b.b((g.c) eVar);
                com.tencent.luggage.wxa.re.a.b().b(eVar.getCameraId());
            }
            com.tencent.luggage.wxa.ic.e.b(this.f139742b.getAppId(), this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6686b implements com.tencent.luggage.wxa.re.b {
        public C6686b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f139745a;

        public c(f fVar) {
            this.f139745a = fVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements ActivityCompat.OnRequestPermissionsResultCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f139747a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.re.e f139748b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f139749c;

        public d(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.re.e eVar, e eVar2) {
            this.f139747a = dVar;
            this.f139748b = eVar;
            this.f139749c = eVar2;
        }

        @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
        public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
            if (i3 == 16) {
                if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                    com.tencent.luggage.wxa.re.a.b().a(true);
                    b.this.a(this.f139747a, this.f139748b, this.f139749c);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("cameraId", Integer.valueOf(this.f139748b.getCameraId()));
                new h().setContext(this.f139747a).setData(new JSONObject(hashMap).toString()).dispatch();
                com.tencent.luggage.wxa.re.a.b().a(false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a();
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.luggage.wxa.re.f a(f fVar, com.tencent.luggage.wxa.re.f fVar2, JSONObject jSONObject, Surface surface) {
        int i3;
        this.f139740a = false;
        Context context = fVar.getContext();
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("mode", "normal");
        String optString2 = jSONObject.optString("devicePosition", "back");
        String optString3 = jSONObject.optString("flash", "auto");
        int b16 = b(jSONObject.optString("size"));
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        String optString4 = jSONObject.optString("resolution");
        fVar2.setAppId(fVar.getAppId());
        fVar2.setPage(fVar);
        fVar2.setCameraId(optInt);
        fVar2.setMode(optString);
        fVar2.a(optString2, true);
        fVar2.setFlash(optString3);
        fVar2.setFrameLimitSize(b16);
        fVar2.setNeedOutput(optBoolean);
        fVar2.setResolution(optString4);
        fVar2.setCustomSurface(surface);
        fVar2.setPageOrientation(fVar.d());
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a16 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "width", 0);
        int a17 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "height", 0);
        if (a16 != 0 && a17 != 0) {
            fVar2.a(a16, a17, true);
        }
        if (fVar instanceof v) {
            int[] a18 = n0.a((i) fVar);
            fVar2.setDisplayScreenSize(new Size(a18[0], a18[1]));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray == null) {
            i3 = 0;
        } else {
            if (optJSONArray.length() == 4) {
                w.d("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
                fVar2.a(com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(0)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(1)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(2)), com.tencent.luggage.wxa.tk.g.a(optJSONArray.optInt(3)));
                i3 = 0;
                fVar2.setScanFreq(jSONObject.optInt("scanFreq"));
                fVar2.setPreviewCenterCrop(jSONObject.optBoolean("centerCrop"));
                Object[] objArr = new Object[5];
                objArr[i3] = Integer.valueOf(optInt);
                objArr[1] = optString2;
                objArr[2] = optString3;
                objArr[3] = Integer.valueOf(a16);
                objArr[4] = Integer.valueOf(a17);
                w.a("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", objArr);
                fVar2.getView().setContentDescription(context.getString(!"normal".equals(optString) ? R.string.ywb : R.string.ywc));
                return fVar2;
            }
            i3 = 0;
        }
        fVar2.a(i3, i3, a16, a17);
        fVar2.setScanFreq(jSONObject.optInt("scanFreq"));
        fVar2.setPreviewCenterCrop(jSONObject.optBoolean("centerCrop"));
        Object[] objArr2 = new Object[5];
        objArr2[i3] = Integer.valueOf(optInt);
        objArr2[1] = optString2;
        objArr2[2] = optString3;
        objArr2[3] = Integer.valueOf(a16);
        objArr2[4] = Integer.valueOf(a17);
        w.a("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", objArr2);
        fVar2.getView().setContentDescription(context.getString(!"normal".equals(optString) ? R.string.ywb : R.string.ywc));
        return fVar2;
    }

    public void a(f fVar, com.tencent.luggage.wxa.re.e eVar, e eVar2) {
        w.d("MicroMsg.JsApiInsertXWebCamera", "onInsertViewWithAsyncCallback");
        if (eVar == null) {
            w.f("MicroMsg.JsApiInsertXWebCamera", "onInsertView failed, cameraView is null");
            return;
        }
        a((com.tencent.luggage.wxa.xd.d) fVar, eVar, eVar2);
        com.tencent.luggage.wxa.re.a.b().a(eVar.getCameraId(), eVar);
        fVar.b((g.d) eVar);
        fVar.a((g.b) eVar);
        fVar.a((g.c) eVar);
        com.tencent.luggage.wxa.ic.e.a(fVar.getAppId(), new a(new WeakReference(eVar), fVar));
        eVar.setOutPutCallBack(new C6686b());
        eVar.setCameraLife(new c(fVar));
    }

    public final boolean a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.re.e eVar, e eVar2) {
        q.c(String.valueOf(dVar.getAppId()), new d(dVar, eVar, eVar2));
        Activity activity = (Activity) dVar.getContext();
        if (activity == null) {
            return false;
        }
        com.tencent.luggage.wxa.re.a.b().b(k.a(activity, dVar, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE));
        boolean a16 = k.a(activity, dVar, QQPermissionConstants.Permission.CAMERA, 16, "", "");
        com.tencent.luggage.wxa.re.a.b().a(a16);
        if (!a16) {
            return false;
        }
        q.a(dVar.getAppId());
        if (!this.f139740a) {
            if (eVar2 != null) {
                eVar2.a();
            }
            eVar.a();
            this.f139740a = true;
        }
        return true;
    }
}
