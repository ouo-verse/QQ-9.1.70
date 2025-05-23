package com.tencent.luggage.wxa.re;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.re.l;
import com.tencent.luggage.wxa.rj.q;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends com.tencent.luggage.wxa.ee.e {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    /* renamed from: a, reason: collision with root package name */
    public Runnable f139612a;

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null or nil"));
        } else {
            c0.a(new a(jSONObject, dVar, i3));
        }
    }

    public final boolean a(final com.tencent.luggage.wxa.xd.d dVar, final JSONObject jSONObject, final int i3) {
        q.c(String.valueOf(dVar.getAppId()), new ActivityCompat.OnRequestPermissionsResultCallback() { // from class: a41.a
            @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
            public final void onRequestPermissionsResult(int i16, String[] strArr, int[] iArr) {
                l.this.a(dVar, jSONObject, i3, i16, strArr, iArr);
            }
        });
        boolean a16 = com.tencent.luggage.wxa.h6.k.a((Activity) dVar.getContext(), dVar, QQPermissionConstants.Permission.RECORD_AUDIO, 18, "", "");
        com.tencent.luggage.wxa.re.a.b().c(a16);
        if (!a16) {
            com.tencent.luggage.wxa.re.a.b().d(true);
            return false;
        }
        q.a(dVar.getAppId());
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f139613a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f139614b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f139615c;

        public a(JSONObject jSONObject, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f139613a = jSONObject;
            this.f139614b = dVar;
            this.f139615c = i3;
        }

        public static /* synthetic */ void a(JSONObject jSONObject, e eVar) {
            eVar.setCompressRecord(jSONObject.optBoolean("compressed"));
            eVar.b();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0090, code lost:
        
            if (r1.equals("listenFrameChange") == false) goto L8;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int optInt = this.f139613a.optInt("cameraId");
            String optString = this.f139613a.optString("type");
            boolean optBoolean = this.f139613a.optBoolean("selfieMirror", true);
            boolean optBoolean2 = this.f139613a.optBoolean("muted", false);
            char c16 = 3;
            w.d("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s muted=%b", Integer.valueOf(optInt), optString, Boolean.valueOf(optBoolean2));
            final e a16 = com.tencent.luggage.wxa.re.a.b().a(optInt);
            if (a16 == null) {
                this.f139614b.a(this.f139615c, l.this.makeReturnJson("fail:no such camera"));
                return;
            }
            a16.setOperateCallBack(new C6684a());
            optString.hashCode();
            switch (optString.hashCode()) {
                case -2144140699:
                    if (optString.equals("closeFrameChange")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1909077165:
                    if (optString.equals("startRecord")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1391995149:
                    if (optString.equals("stopRecord")) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -374265034:
                    break;
                case 1484838379:
                    if (optString.equals("takePhoto")) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1985172309:
                    if (optString.equals("setZoom")) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                    a16.e();
                    this.f139614b.a(this.f139615c, l.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                    return;
                case 1:
                    if (!optBoolean2 && !l.this.a(this.f139614b, this.f139613a, this.f139615c)) {
                        return;
                    }
                    a16.a(optBoolean, optBoolean2);
                    if (l.this.f139612a != null) {
                        w.d("MicroMsg.JsApiOperateCamera", "found stop record runnable");
                        l.this.f139612a.run();
                        l.this.f139612a = null;
                        return;
                    }
                    return;
                case 2:
                    l lVar = l.this;
                    final JSONObject jSONObject = this.f139613a;
                    lVar.f139612a = new Runnable() { // from class: a41.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            l.a.a(JSONObject.this, a16);
                        }
                    };
                    if (!com.tencent.luggage.wxa.re.a.b().f()) {
                        w.d("MicroMsg.JsApiOperateCamera", "stop record immediately");
                        l.this.f139612a.run();
                        l.this.f139612a = null;
                        return;
                    }
                    w.d("MicroMsg.JsApiOperateCamera", "stop record, bug is requesting microphone permission");
                    return;
                case 3:
                    a16.a(this.f139614b, this.f139613a.optString("size"));
                    return;
                case 4:
                    a16.setQuality(this.f139613a.optString(CustomImageProps.QUALITY, "high"));
                    a16.b(optBoolean);
                    return;
                case 5:
                    float a17 = a16.a((float) this.f139613a.optDouble("zoom"));
                    if (a17 < 1.0f) {
                        this.f139614b.a(this.f139615c, l.this.makeReturnJson("fail: zoom multiple not support"));
                        return;
                    }
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("zoom", Float.valueOf(a17));
                    this.f139614b.a(this.f139615c, l.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                    return;
                default:
                    w.h("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", optString);
                    this.f139614b.a(this.f139615c, l.this.makeReturnJson("fail:operateType not supported"));
                    return;
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.re.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6684a implements c {
            public C6684a() {
            }

            @Override // com.tencent.luggage.wxa.re.c
            public void a(int i3, String str, String str2, int i16, int i17) {
                if (i3 == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempImagePath", str);
                    hashMap.put("width", Integer.valueOf(i16));
                    hashMap.put("height", Integer.valueOf(i17));
                    a aVar = a.this;
                    aVar.f139614b.a(aVar.f139615c, l.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                    return;
                }
                a aVar2 = a.this;
                aVar2.f139614b.a(aVar2.f139615c, l.this.makeReturnJson("fail:" + str2));
            }

            @Override // com.tencent.luggage.wxa.re.c
            public void a(int i3, String str) {
                if (i3 == 0) {
                    a aVar = a.this;
                    aVar.f139614b.a(aVar.f139615c, l.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                    return;
                }
                a aVar2 = a.this;
                aVar2.f139614b.a(aVar2.f139615c, l.this.makeReturnJson("fail:" + str));
            }

            @Override // com.tencent.luggage.wxa.re.c
            public void a(int i3, String str, String str2, String str3, int i16, long j3, int i17, int i18) {
                w.a("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s,duration %d,size %d,width %d,height %d", Integer.valueOf(i3), str2, str3, Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i17), Integer.valueOf(i18));
                if (i3 == 0) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("tempThumbPath", str2);
                    hashMap.put("tempVideoPath", str3);
                    hashMap.put("duration", Integer.valueOf(i16));
                    hashMap.put("size", Long.valueOf(j3));
                    hashMap.put("height", Integer.valueOf(i18));
                    hashMap.put("width", Integer.valueOf(i17));
                    a aVar = a.this;
                    aVar.f139614b.a(aVar.f139615c, l.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                    return;
                }
                a aVar2 = a.this;
                aVar2.f139614b.a(aVar2.f139615c, l.this.makeReturnJson("fail:" + str));
            }

            @Override // com.tencent.luggage.wxa.re.c
            public void a(String str, int i3, int i16, int i17) {
                if (!w0.c(str)) {
                    a aVar = a.this;
                    aVar.f139614b.a(aVar.f139615c, l.this.makeReturnJson("fail:" + str));
                    return;
                }
                w.a("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                HashMap hashMap = new HashMap();
                hashMap.put("bufferId", Integer.valueOf(i3));
                hashMap.put("width", Integer.valueOf(i16));
                hashMap.put("height", Integer.valueOf(i17));
                a aVar2 = a.this;
                aVar2.f139614b.a(aVar2.f139615c, l.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, int i16, String[] strArr, int[] iArr) {
        if (i16 == 18) {
            if (iArr != null && iArr.length > 0 && iArr[0] == 0) {
                com.tencent.luggage.wxa.re.a.b().c(true);
                invoke(dVar, jSONObject, i3);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("cameraId", Integer.valueOf(jSONObject.optInt("cameraId")));
                h hVar = new h();
                hVar.setData(new JSONObject(hashMap).toString());
                com.tencent.luggage.wxa.xd.f componentView = getComponentView(dVar, null);
                if (componentView != null) {
                    componentView.a(hVar, (int[]) null);
                }
                com.tencent.luggage.wxa.re.a.b().c(false);
                this.f139612a = null;
            }
            com.tencent.luggage.wxa.re.a.b().d(false);
            q.a(dVar.getAppId());
        }
    }
}
