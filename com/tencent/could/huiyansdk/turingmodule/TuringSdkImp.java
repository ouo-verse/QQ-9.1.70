package com.tencent.could.huiyansdk.turingmodule;

import android.content.Context;
import android.hardware.Camera;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.entity.TuringResultCacheEntity;
import com.tencent.could.huiyansdk.exception.CallbackErrorCode;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.turing.b;
import com.tencent.could.huiyansdk.turing.c;
import com.tencent.could.huiyansdk.turing.d;
import com.tencent.could.huiyansdk.turing.f;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.could.huiyansdk.view.CameraDateGatherView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingcam.SignResult;
import com.tencent.turingcam.TuringCallback;
import com.tencent.turingcam.TuringFaceBuilder;
import com.tencent.turingcam.TuringFaceDefender;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TuringSdkImp extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f100289b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f100290c;

    /* renamed from: d, reason: collision with root package name */
    public String f100291d;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements TuringCallback {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TuringSdkImp.this);
            }
        }

        @Override // com.tencent.turingcam.TuringCallback
        public void onException(Throwable th5) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) th5);
                return;
            }
            c cVar = TuringSdkImp.this.f100269a;
            if (cVar != null) {
                d dVar = (d) cVar;
                if (th5 != null) {
                    str = th5.getLocalizedMessage();
                } else {
                    str = "onException throwable is null!";
                }
                TuringResultCacheEntity turingResultCacheEntity = dVar.f100270a.f100277f;
                if (turingResultCacheEntity != null) {
                    turingResultCacheEntity.setTuringEnvErrorStr(str);
                }
                if (!dVar.f100270a.f100283l) {
                    dVar.f100270a.d();
                    dVar.f100270a.getClass();
                    HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "GetTuringTokenError", str);
                    k kVar = k.a.f100197a;
                    kVar.a(2, "TuringSdkHelper", "turing face throwable: " + str);
                    if (!dVar.f100270a.f100287p) {
                        f.b(dVar.f100270a);
                    } else {
                        kVar.a(2, "TuringSdkHelper", " error this is turing frame image risk!");
                    }
                }
            }
        }

        @Override // com.tencent.turingcam.TuringCallback
        public void onFinish(long j3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), bArr);
                return;
            }
            c cVar = TuringSdkImp.this.f100269a;
            if (cVar != null) {
                ((d) cVar).a(j3, bArr);
            }
        }

        @Override // com.tencent.turingcam.TuringCallback
        public void onFinishFrameCheck(long j3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), bArr);
                return;
            }
            c cVar = TuringSdkImp.this.f100269a;
            if (cVar != null) {
                d dVar = (d) cVar;
                dVar.f100270a.f100276e = true;
                TuringResultCacheEntity turingResultCacheEntity = dVar.f100270a.f100277f;
                HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "GetTuringFrameCheckOnFinish", "");
                String encodeToString = Base64.encodeToString(bArr, 2);
                TuringResultCacheEntity turingResultCacheEntity2 = dVar.f100270a.f100277f;
                if (turingResultCacheEntity2 != null) {
                    turingResultCacheEntity2.setTuringFrameResult(encodeToString);
                }
                if (!TextUtils.isEmpty(encodeToString)) {
                    HuiYanSdkImp.getInstance().doOnStreamRiskDataSuccess(encodeToString);
                }
            }
        }

        @Override // com.tencent.turingcam.TuringCallback
        public void onPreviewAvailable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            c cVar = TuringSdkImp.this.f100269a;
            if (cVar != null) {
                Log.e("TuringSdkHelper", "onPreviewAvailable!");
                com.tencent.could.huiyansdk.turing.a a16 = f.a(((d) cVar).f100270a);
                if (a16 != null) {
                    a16.b();
                }
            }
        }

        @Override // com.tencent.turingcam.TuringCallback
        public void onPreviewDestroyed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            c cVar = TuringSdkImp.this.f100269a;
            if (cVar != null) {
                d dVar = (d) cVar;
                dVar.f100270a.f100274c = true;
                Log.e("TuringSdkHelper", "onPreviewDestroyed!");
                com.tencent.could.huiyansdk.turing.a a16 = f.a(dVar.f100270a);
                if (a16 != null) {
                    a16.a();
                }
            }
        }
    }

    public TuringSdkImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100289b = false;
        this.f100290c = false;
        this.f100291d = "";
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void a(final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.turingmodule.a
                @Override // java.lang.Runnable
                public final void run() {
                    TuringSdkImp.this.b(context);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public JSONObject b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? TuringFaceDefender.getDeviceInfo(HuiYanBaseApi.b.f100031a.a()) : (JSONObject) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return TuringFaceDefender.getSDKVersion();
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            TuringFaceDefender.setCallback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        k.a.f100197a.a(1, "TuringSdkImp", "turing is open hardware: true");
        int init = TuringFaceDefender.init(TuringFaceBuilder.build().setIsHardwareAcceleration(true).setHostUrl("https://sdk.faceid.qq.com/api/turing_new").setContext(context));
        if (init == 0) {
            this.f100290c = true;
            this.f100291d = "";
            return;
        }
        this.f100290c = false;
        this.f100291d = "turing init error code: " + init;
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        } else if (this.f100289b) {
            TuringFaceDefender.processFrame(bArr);
        }
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public int a(View view, CameraHolder cameraHolder, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, view, cameraHolder, str)).intValue();
        }
        if (view == null) {
            k.a.f100197a.a(2, "TuringSdkImp", "camera view is null");
            return CallbackErrorCode.HY_INNER_CAMERA_VIEW_IS_NULL;
        }
        TuringFaceDefender.setCallback(new a());
        Camera currentCamera = cameraHolder.getCurrentCamera();
        if (view instanceof CameraDateGatherView) {
            TuringFaceDefender.setPreviewDisplay(currentCamera, (CameraDateGatherView) view);
        }
        if (TextUtils.isEmpty(str)) {
            TuringFaceDefender.start(currentCamera, "");
            return 0;
        }
        TuringFaceDefender.start(currentCamera, str);
        return 0;
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (TextUtils.isEmpty(str)) {
            Log.e("TuringSdkImp", "needTuringFrameCheck param is null");
        } else {
            this.f100289b = true;
            TuringFaceDefender.startFrameCheck(str);
        }
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public String a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
        long activeSign = TuringFaceDefender.activeSign(str);
        if (activeSign == 0) {
            SignResult signData = TuringFaceDefender.signData(str2);
            if (signData != null && signData.code == 0) {
                return signData.signMsg;
            }
            if (signData == null) {
                return "error signResult is null";
            }
            return "error signResult code: " + signData.code;
        }
        return "error result: " + activeSign;
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f100290c ? "" : this.f100291d : (String) iPatchRedirector.redirect((short) 9, (Object) this);
    }
}
