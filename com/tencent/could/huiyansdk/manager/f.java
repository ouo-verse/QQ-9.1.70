package com.tencent.could.huiyansdk.manager;

import android.graphics.ColorMatrixColorFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.entity.CameraRiskChangeInfo;
import com.tencent.could.huiyansdk.entity.CameraRiskParamConfig;
import com.tencent.could.huiyansdk.entity.RiskDemoImage;
import com.tencent.could.huiyansdk.enums.RiskCameraType;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Integer> f100163a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f100164b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f100165c;

    /* renamed from: d, reason: collision with root package name */
    public int f100166d;

    /* renamed from: e, reason: collision with root package name */
    public int f100167e;

    /* renamed from: f, reason: collision with root package name */
    public HandlerThread f100168f;

    /* renamed from: g, reason: collision with root package name */
    public volatile Handler f100169g;

    /* renamed from: h, reason: collision with root package name */
    public WeakReference<CameraHolder> f100170h;

    /* renamed from: i, reason: collision with root package name */
    public RiskCameraType f100171i;

    /* renamed from: j, reason: collision with root package name */
    public int f100172j;

    /* renamed from: k, reason: collision with root package name */
    public volatile int f100173k;

    /* renamed from: l, reason: collision with root package name */
    public Map<RiskCameraType, RiskDemoImage> f100174l;

    /* renamed from: m, reason: collision with root package name */
    public b f100175m;

    /* renamed from: n, reason: collision with root package name */
    public List<String> f100176n;

    /* renamed from: o, reason: collision with root package name */
    public ColorMatrixColorFilter f100177o;

    /* renamed from: p, reason: collision with root package name */
    public ColorMatrixColorFilter[] f100178p;

    /* renamed from: q, reason: collision with root package name */
    public int f100179q;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final f f100180a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17343);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100180a = new f();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f100164b = false;
        this.f100165c = false;
        this.f100172j = 0;
        this.f100173k = 0;
        this.f100177o = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f100178p = new ColorMatrixColorFilter[]{new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 230.0f, 0.0f, 0.0f, 0.0f, 0.0f, 53.0f, 0.0f, 0.0f, 0.0f, 0.0f, 135.0f, 0.0f, 0.0f, 0.0f, 0.0f, 242.0f}), new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 31.0f, 0.0f, 0.0f, 0.0f, 0.0f, 191.0f, 0.0f, 0.0f, 0.0f, 0.0f, 70.0f, 0.0f, 0.0f, 0.0f, 0.0f, 242.0f}), new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 55.0f, 0.0f, 0.0f, 0.0f, 0.0f, 30.0f, 0.0f, 0.0f, 0.0f, 0.0f, 200.0f, 0.0f, 0.0f, 0.0f, 0.0f, 242.0f})};
        this.f100179q = 0;
        this.f100174l = new HashMap();
        this.f100176n = new ArrayList();
    }

    public static String a(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? "" : "incandescent" : "fluorescent" : "warm-fluorescent" : "daylight" : "cloudy-daylight" : "auto";
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Map<String, Integer> map = this.f100163a;
        if (map != null) {
            map.clear();
        }
        if (this.f100169g != null) {
            this.f100169g.removeMessages(1500);
            this.f100169g.removeCallbacksAndMessages(null);
            this.f100169g = null;
        }
        HandlerThread handlerThread = this.f100168f;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.f100168f.quitSafely();
        }
        if (this.f100175m != null) {
            this.f100175m = null;
        }
    }

    public void a(CameraHolder cameraHolder, CameraRiskChangeInfo cameraRiskChangeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cameraHolder, (Object) cameraRiskChangeInfo);
            return;
        }
        if (cameraHolder == null) {
            k.a.f100197a.a(2, "CameraRiskManager", "changeCameraExposureInfo camera is null");
            return;
        }
        String str = cameraRiskChangeInfo.getExposure() + "";
        Map<String, Integer> map = this.f100163a;
        if (map != null && map.containsKey(str)) {
            try {
                k.a.f100197a.a(1, "CameraRiskManager", "cameraExposure:" + str + " zoom " + cameraRiskChangeInfo.getZoomValue() + " whiteBalance " + cameraRiskChangeInfo.getWhiteBalance());
                int intValue = this.f100163a.get(str).intValue();
                HashMap hashMap = new HashMap();
                hashMap.put(CameraHolder.PARAMETER_EXPOSURE_COMPENSATION, Integer.valueOf(intValue));
                hashMap.put(CameraHolder.PARAMETER_ZOOM_VALUE, Integer.valueOf(cameraRiskChangeInfo.getZoomValue()));
                hashMap.put(CameraHolder.PARAMETER_WHITE_BALANCE, cameraRiskChangeInfo.getWhiteBalance());
                cameraHolder.setEventChangeCameraParameter(hashMap);
                return;
            } catch (RuntimeException e16) {
                k.a.f100197a.a(2, "CameraRiskManager", "changeCameraExposureInfo:" + e16.getLocalizedMessage());
                return;
            }
        }
        k.a.f100197a.a(2, "CameraRiskManager", "IndexMap is null or not hava containsKey");
    }

    public void a(CameraHolder cameraHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cameraHolder, i3);
            return;
        }
        CameraRiskParamConfig cameraRiskParamConfig = HuiYanSdkImp.getInstance().getCameraRiskParamConfig();
        if (cameraRiskParamConfig == null) {
            k.a.f100197a.a(1, "CameraRiskManager", "cameraRiskParamConfig is null");
            b bVar = this.f100175m;
            if (bVar != null) {
                ((com.tencent.could.huiyansdk.fragments.i) bVar).a(i3);
                return;
            }
            return;
        }
        int stage = cameraRiskParamConfig.getStage();
        if (stage == 0) {
            k.a.f100197a.a(1, "CameraRiskManager", "cameraRiskParamConfig.getStage() is 0");
            b bVar2 = this.f100175m;
            if (bVar2 != null) {
                ((com.tencent.could.huiyansdk.fragments.i) bVar2).a(i3);
                return;
            }
            return;
        }
        if (i3 == 1) {
            this.f100176n.clear();
        }
        if (stage == 1 && i3 == 2) {
            k.a.f100197a.a(2, "CameraRiskManager", "stage = start and current type = reflect");
            b bVar3 = this.f100175m;
            if (bVar3 != null) {
                ((com.tencent.could.huiyansdk.fragments.i) bVar3).a(i3);
                return;
            }
            return;
        }
        if (stage == 2 && i3 == 1) {
            k.a.f100197a.a(2, "CameraRiskManager", "stage = reflect and current type = start");
            b bVar4 = this.f100175m;
            if (bVar4 != null) {
                ((com.tencent.could.huiyansdk.fragments.i) bVar4).a(i3);
                return;
            }
            return;
        }
        k kVar = k.a.f100197a;
        kVar.a(1, "CameraRiskManager", "change want delay " + i3);
        this.f100173k = i3;
        CameraRiskChangeInfo a16 = a();
        if (a16 == null) {
            kVar.a(2, "CameraRiskManager", "cameraRiskChangeInfo is null");
            b bVar5 = this.f100175m;
            if (bVar5 != null) {
                ((com.tencent.could.huiyansdk.fragments.i) bVar5).a(i3);
                return;
            }
            return;
        }
        a(cameraHolder, a16);
        if (this.f100169g != null) {
            Message obtainMessage = this.f100169g.obtainMessage();
            obtainMessage.what = 2000;
            this.f100169g.sendMessageDelayed(obtainMessage, a16.getDelay());
            if (i3 == 2) {
                Message obtainMessage2 = this.f100169g.obtainMessage();
                obtainMessage2.what = 1500;
                this.f100169g.sendMessageDelayed(obtainMessage2, 500L);
                return;
            }
            return;
        }
        kVar.a(2, "CameraRiskManager", "startCameraCheckByType handler is null!");
        b bVar6 = this.f100175m;
        if (bVar6 != null) {
            ((com.tencent.could.huiyansdk.fragments.i) bVar6).a(i3);
        }
    }

    public final TwoTuple<Integer, Integer> a(List<Integer> list, int i3) {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TwoTuple) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, i3);
        }
        int i16 = 100;
        int i17 = 999;
        int i18 = 0;
        for (int i19 = 0; i19 < list.size() && (intValue = list.get(i19).intValue()) <= 200; i19++) {
            int i26 = intValue - i3;
            if (Math.abs(i26) < i17) {
                i17 = Math.abs(i26);
                i16 = intValue;
                i18 = i19;
            }
        }
        return new TwoTuple<>(Integer.valueOf(i16), Integer.valueOf(i18));
    }

    public final float a(HashMap<Float, Integer> hashMap, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, this, hashMap, Float.valueOf(f16))).floatValue();
        }
        float f17 = 0.0f;
        if (Math.abs(f16 - (-10.0f)) < 1.0E-6f) {
            return 0.0f;
        }
        float f18 = 99.0f;
        for (Map.Entry<Float, Integer> entry : hashMap.entrySet()) {
            float floatValue = entry.getKey().floatValue();
            float abs = Math.abs(floatValue - f16);
            if (abs < f18) {
                i3 = entry.getValue().intValue();
                f17 = floatValue;
                f18 = abs;
            }
        }
        if (i3 != 0) {
            this.f100163a.put(f16 + "", Integer.valueOf(i3));
        }
        return f17;
    }

    public RiskCameraType[] a(CameraRiskChangeInfo cameraRiskChangeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RiskCameraType[]) iPatchRedirector.redirect((short) 7, (Object) this, (Object) cameraRiskChangeInfo);
        }
        ArrayList arrayList = new ArrayList(2);
        if (cameraRiskChangeInfo.getNetZoom() != -1) {
            arrayList.add(RiskCameraType.ZOOM);
        }
        if (!"".equals(cameraRiskChangeInfo.getWhiteBalance())) {
            arrayList.add(RiskCameraType.WHITE_BALANCE);
        }
        if (Math.abs(cameraRiskChangeInfo.getExposure() - (-10.0f)) >= 1.0E-6f) {
            arrayList.add(RiskCameraType.EXPOSURE);
        }
        if (arrayList.size() == 0) {
            k.a.f100197a.a(1, "CameraRiskManager", "arrayList size is 0\uff01");
            return null;
        }
        int size = arrayList.size() + 1;
        RiskCameraType[] riskCameraTypeArr = new RiskCameraType[size];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            riskCameraTypeArr[i3] = (RiskCameraType) arrayList.get(i3);
        }
        riskCameraTypeArr[arrayList.size()] = RiskCameraType.BASE;
        k.a.f100197a.a(1, "CameraRiskManager", "print riskCameraTypes:");
        for (int i16 = 0; i16 < size; i16++) {
            RiskCameraType riskCameraType = riskCameraTypeArr[i16];
            k.a.f100197a.a(1, "CameraRiskManager", "riskCameraType:" + riskCameraType.name());
        }
        return riskCameraTypeArr;
    }

    public final CameraRiskChangeInfo a() {
        CameraRiskChangeInfo cameraRiskChangeStageReflect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CameraRiskChangeInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        CameraRiskParamConfig cameraRiskParamConfig = HuiYanSdkImp.getInstance().getCameraRiskParamConfig();
        if (cameraRiskParamConfig == null) {
            k.a.f100197a.a(1, "CameraRiskManager", "do not have cameraRiskParamConfig");
            return null;
        }
        k kVar = k.a.f100197a;
        kVar.a(1, "CameraRiskManager", "cameraRiskChangeInfo currentStageType:" + this.f100173k);
        if (this.f100173k == 1) {
            cameraRiskChangeStageReflect = cameraRiskParamConfig.getCameraRiskChangeStageStart();
        } else {
            cameraRiskChangeStageReflect = cameraRiskParamConfig.getCameraRiskChangeStageReflect();
        }
        if (cameraRiskChangeStageReflect == null) {
            kVar.a(1, "CameraRiskManager", "do not have cameraRiskChangeInfoOlder");
            return null;
        }
        RiskCameraType[] riskCameraType = cameraRiskChangeStageReflect.getRiskCameraType();
        if (riskCameraType != null && riskCameraType.length != 0) {
            int i3 = this.f100172j;
            if (i3 > riskCameraType.length - 1) {
                kVar.a(2, "CameraRiskManager", "riskIndex > riskCameraType.length - 1");
                return null;
            }
            RiskCameraType riskCameraType2 = riskCameraType[i3];
            this.f100171i = riskCameraType2;
            kVar.a(1, "CameraRiskManager", "currentType:" + riskCameraType2);
            this.f100172j = this.f100172j + 1;
            CameraRiskChangeInfo cameraRiskChangeInfo = new CameraRiskChangeInfo();
            cameraRiskChangeInfo.setDelay(cameraRiskChangeStageReflect.getDelay());
            int ordinal = riskCameraType2.ordinal();
            if (ordinal == 0) {
                cameraRiskChangeInfo.setWhiteBalance("daylight");
                cameraRiskChangeInfo.setExposure(0.0f);
                cameraRiskChangeInfo.setZoomValue(0);
                return cameraRiskChangeInfo;
            }
            if (ordinal == 1) {
                cameraRiskChangeInfo.setExposure(cameraRiskChangeStageReflect.getExposure());
                cameraRiskChangeInfo.setWhiteBalance("daylight");
                cameraRiskChangeInfo.setZoomValue(0);
                return cameraRiskChangeInfo;
            }
            if (ordinal == 2) {
                cameraRiskChangeInfo.setZoomValue(cameraRiskChangeStageReflect.getZoomValue());
                cameraRiskChangeInfo.setWhiteBalance("daylight");
                cameraRiskChangeInfo.setExposure(0.0f);
                return cameraRiskChangeInfo;
            }
            if (ordinal != 3) {
                return cameraRiskChangeInfo;
            }
            cameraRiskChangeInfo.setWhiteBalance(cameraRiskChangeStageReflect.getWhiteBalance());
            cameraRiskChangeInfo.setExposure(0.0f);
            cameraRiskChangeInfo.setZoomValue(0);
            return cameraRiskChangeInfo;
        }
        kVar.a(1, "CameraRiskManager", "do not have riskCameraType or riskCameraType is null");
        return null;
    }
}
