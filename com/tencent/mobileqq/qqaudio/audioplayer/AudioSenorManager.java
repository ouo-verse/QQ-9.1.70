package com.tencent.mobileqq.qqaudio.audioplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AudioSenorManager extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: u, reason: collision with root package name */
    public static int f262132u;

    /* renamed from: a, reason: collision with root package name */
    private b f262133a;

    /* renamed from: b, reason: collision with root package name */
    private SensorManager f262134b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f262135c;

    /* renamed from: d, reason: collision with root package name */
    private Sensor f262136d;

    /* renamed from: e, reason: collision with root package name */
    private a f262137e;

    /* renamed from: f, reason: collision with root package name */
    private c f262138f;

    /* renamed from: g, reason: collision with root package name */
    boolean f262139g;

    /* renamed from: h, reason: collision with root package name */
    private float f262140h;

    /* renamed from: i, reason: collision with root package name */
    private float f262141i;

    /* renamed from: j, reason: collision with root package name */
    private float f262142j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f262143k;

    /* renamed from: l, reason: collision with root package name */
    private List<String> f262144l;

    /* renamed from: m, reason: collision with root package name */
    AppRuntime f262145m;

    /* renamed from: n, reason: collision with root package name */
    volatile boolean f262146n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f262147o;

    /* renamed from: p, reason: collision with root package name */
    float f262148p;

    /* renamed from: q, reason: collision with root package name */
    float f262149q;

    /* renamed from: r, reason: collision with root package name */
    float f262150r;

    /* renamed from: s, reason: collision with root package name */
    Runnable f262151s;

    /* renamed from: t, reason: collision with root package name */
    Runnable f262152t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements SensorEventListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioSenorManager.this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensor, i3);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
                return;
            }
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float f16 = fArr[0];
                float f17 = fArr[1];
                float f18 = fArr[2];
                if (AudioSenorManager.n()) {
                    f16 *= 10.0f;
                    f17 *= 10.0f;
                    f18 *= 10.0f;
                }
                AudioSenorManager audioSenorManager = AudioSenorManager.this;
                float f19 = audioSenorManager.f262148p;
                if (f19 != -999.0f || audioSenorManager.f262149q != -999.0f || audioSenorManager.f262150r != -999.0f) {
                    float abs = Math.abs(f19 - f16);
                    float abs2 = Math.abs(AudioSenorManager.this.f262149q - f17);
                    float abs3 = Math.abs(AudioSenorManager.this.f262150r - f18);
                    if (abs < AudioSenorManager.this.f262141i && abs2 < AudioSenorManager.this.f262141i && abs3 < AudioSenorManager.this.f262141i) {
                        if (abs < AudioSenorManager.this.f262142j && abs2 < AudioSenorManager.this.f262142j && abs3 < AudioSenorManager.this.f262142j) {
                            if (AudioSenorManager.this.f262139g && QLog.isColorLevel()) {
                                QLog.d("AudioPlayer_SenorManager", 2, "AccelerationListener$onSensorChanged stop moving | x=" + f16 + " | y = " + f17 + " | z = " + f18 + " | ax = " + abs + " | ay = " + abs2 + " | az = " + abs3 + " | value=" + AudioSenorManager.this.f262141i);
                            }
                            AudioSenorManager.this.f262139g = false;
                        }
                    } else {
                        if (!AudioSenorManager.this.f262139g && QLog.isColorLevel()) {
                            QLog.d("AudioPlayer_SenorManager", 2, "AccelerationListener$onSensorChanged moving | x=" + f16 + " | y = " + f17 + " | z = " + f18 + " | ax = " + abs + " | ay = " + abs2 + " | az = " + abs3 + " | value=" + AudioSenorManager.this.f262141i);
                        }
                        AudioSenorManager.this.f262139g = true;
                    }
                }
                AudioSenorManager audioSenorManager2 = AudioSenorManager.this;
                audioSenorManager2.f262148p = f16;
                audioSenorManager2.f262149q = f17;
                audioSenorManager2.f262150r = f18;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void onNearToEarStatusChanged(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements SensorEventListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioSenorManager.this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) sensor, i3);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r0v4 */
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) sensorEvent);
                return;
            }
            if (ah.n0()) {
                return;
            }
            ?? r06 = 0;
            if (sensorEvent.values[0] < AudioSenorManager.this.f262140h) {
                r06 = 1;
            }
            QLog.d("AudioPlayer_SenorManager", 2, "ProximityEventListener$onSensorChanged close =" + ((boolean) r06) + " | mIsMoving =" + AudioSenorManager.this.f262139g);
            if ((f.g() || r06 == 0 || AudioSenorManager.this.f262139g) && r06 != AudioSenorManager.this.f262143k) {
                AudioSenorManager.this.f262143k = r06;
                if (AudioSenorManager.this.f262133a != null) {
                    AudioSenorManager.this.f262133a.onNearToEarStatusChanged(r06);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37038);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f262132u = 1000;
        }
    }

    public AudioSenorManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.f262133a = null;
        this.f262139g = true;
        this.f262141i = 0.6f;
        this.f262142j = 0.02f;
        this.f262143k = 0;
        this.f262144l = new CopyOnWriteArrayList();
        this.f262146n = false;
        this.f262147o = false;
        this.f262151s = new Runnable() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioSenorManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (AudioSenorManager.this.f262135c != null) {
                    if (AudioSenorManager.this.f262136d != null) {
                        try {
                            SensorMonitor.registerListener(AudioSenorManager.this.f262134b, AudioSenorManager.this.f262137e, AudioSenorManager.this.f262136d, 3);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    try {
                        SensorMonitor.registerListener(AudioSenorManager.this.f262134b, AudioSenorManager.this.f262138f, AudioSenorManager.this.f262135c, 3);
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AudioPlayer_SenorManager", 2, "$requestPlay| mAccelerationSensro=" + AudioSenorManager.this.f262136d + " | mProximitySensor = " + AudioSenorManager.this.f262135c);
                }
            }
        };
        this.f262152t = new Runnable() { // from class: com.tencent.mobileqq.qqaudio.audioplayer.AudioSenorManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioSenorManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AudioSenorManager.this.f262134b.unregisterListener(AudioSenorManager.this.f262137e);
                    AudioSenorManager.this.f262134b.unregisterListener(AudioSenorManager.this.f262138f);
                }
            }
        };
        this.f262145m = appRuntime;
        BaseApplication app = appRuntime.getApp();
        this.f262134b = (SensorManager) app.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mqq.audiosenormanager.audio.start");
        intentFilter.addAction("mqq.audiosenormanager.audio.end");
        app.registerReceiver(this, intentFilter);
        this.f262146n = true;
    }

    private float l(Sensor sensor) {
        String model = DeviceInfoMonitor.getModel();
        if (!model.equals("ZTE U880s") && !model.equals("ZTE U807")) {
            if (!model.equals("Coolpad 5890") && !model.equals("Coolpad 5891") && !model.equals("Coolpad 8720L") && !model.equals("Coolpad 5879") && !model.equals("Coolpad 5891Q")) {
                if (!model.equals("HUAWEI Y320-T00") && !model.equals("Lenovo A658t") && !model.equals("Lenovo A788t")) {
                    if (model.equals("ME860")) {
                        return 99.0f;
                    }
                    if (!model.equals("ZTE U930HD") && !model.equals("ZTE-T U960s")) {
                        if (sensor != null) {
                            return sensor.getMaximumRange();
                        }
                        return 0.0f;
                    }
                    return 100.0f;
                }
                return 10.0f;
            }
            return 5.0f;
        }
        return 97.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e7 A[Catch: Exception -> 0x00f6, TryCatch #3 {Exception -> 0x00f6, blocks: (B:34:0x00d8, B:36:0x00e7, B:37:0x00ed), top: B:33:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m() {
        boolean z16;
        float f16;
        String featureValue;
        String[] split;
        String featureValue2 = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_audio_play.name(), null);
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SenorManager", 2, "MediaPlayerManager.initSensors | dpcConfig = " + featureValue2);
        }
        boolean z17 = false;
        if (!TextUtils.isEmpty(featureValue2) && featureValue2.length() > 1) {
            try {
                String[] split2 = featureValue2.split("\\|");
                if (!"1".equals(split2[0])) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                try {
                    f16 = Float.parseFloat(split2[1]);
                    try {
                        if (split2.length >= 5) {
                            this.f262141i = Float.parseFloat(split2[2]);
                            this.f262142j = Float.parseFloat(split2[3]);
                            f262132u = Integer.parseInt(split2[4]);
                        }
                    } catch (Exception e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                        }
                        if (f262132u < 0) {
                        }
                        if (this.f262141i > 0.0f) {
                        }
                        featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null);
                        if (QLog.isColorLevel()) {
                        }
                        if (!TextUtils.isEmpty(featureValue)) {
                        }
                        if (z17) {
                        }
                        this.f262135c = SensorMonitor.getDefaultSensor(this.f262134b, 8);
                        this.f262138f = new c();
                        if (f16 > 0.5f) {
                        }
                        this.f262147o = true;
                    }
                } catch (Exception e17) {
                    e = e17;
                    f16 = 0.0f;
                    if (QLog.isColorLevel()) {
                        QLog.d("AudioPlayer_SenorManager", 2, "parse dpc error", e);
                    }
                    if (f262132u < 0) {
                    }
                    if (this.f262141i > 0.0f) {
                    }
                    featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null);
                    if (QLog.isColorLevel()) {
                    }
                    if (!TextUtils.isEmpty(featureValue)) {
                        try {
                            split = featureValue.split("\\|");
                            if (!"-1".equals(split[4])) {
                            }
                            z17 = !"1".equals(split[5]);
                        } catch (Exception e18) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AudioPlayer_SenorManager", 2, "DPC config to UIN error.", e18);
                            }
                        }
                    }
                    if (z17) {
                    }
                    this.f262135c = SensorMonitor.getDefaultSensor(this.f262134b, 8);
                    this.f262138f = new c();
                    if (f16 > 0.5f) {
                    }
                    this.f262147o = true;
                }
            } catch (Exception e19) {
                e = e19;
                z16 = true;
            }
        } else {
            z16 = true;
            f16 = 0.0f;
        }
        if (f262132u < 0) {
            f262132u = 1000;
        }
        if (this.f262141i > 0.0f) {
            z17 = z16;
        }
        featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null);
        if (QLog.isColorLevel()) {
            QLog.d("AudioPlayer_SenorManager", 2, "DPC config to UIN | dpcConfig = " + featureValue);
        }
        if (!TextUtils.isEmpty(featureValue) && featureValue.length() > 1) {
            split = featureValue.split("\\|");
            if (!"-1".equals(split[4])) {
                f16 = Float.parseFloat(split[4]);
            }
            z17 = !"1".equals(split[5]);
        }
        if (z17) {
            this.f262136d = SensorMonitor.getDefaultSensor(this.f262134b, 1);
            this.f262137e = new a();
        }
        this.f262135c = SensorMonitor.getDefaultSensor(this.f262134b, 8);
        this.f262138f = new c();
        if (f16 > 0.5f) {
            this.f262140h = f16;
        } else {
            Sensor sensor = this.f262135c;
            if (sensor != null) {
                this.f262140h = l(sensor);
            }
        }
        this.f262147o = true;
    }

    public static boolean n() {
        return DeviceInfoMonitor.getModel().equals("ZTE U930");
    }

    private void p() {
        this.f262148p = -999.0f;
        this.f262149q = -999.0f;
        this.f262150r = -999.0f;
        this.f262139g = false;
    }

    private void r(String str) {
        if (!StringUtil.isEmpty(str)) {
            if (!this.f262144l.contains(str)) {
                this.f262144l.add(str);
            }
            p();
            ThreadManagerV2.removeJobFromThreadPool(this.f262152t, 16);
            ThreadManagerV2.excute(this.f262151s, 16, null, false);
        }
    }

    private void s(String str) {
        if (!StringUtil.isEmpty(str)) {
            if (this.f262144l.contains(str)) {
                List<String> list = this.f262144l;
                list.remove(list.indexOf(str));
            }
            if (this.f262144l.size() == 0 && this.f262143k != 0) {
                this.f262143k = 0;
                b bVar = this.f262133a;
                if (bVar != null) {
                    bVar.onNearToEarStatusChanged(this.f262143k);
                }
            }
        }
        ThreadManagerV2.removeJobFromThreadPool(this.f262151s, 16);
        ThreadManagerV2.excute(this.f262152t, 16, null, false);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f262145m != null) {
            if (this.f262146n) {
                try {
                    this.f262145m.getApp().unregisterReceiver(this);
                } catch (Throwable th5) {
                    QLog.w("AudioPlayer_SenorManager", 1, "unregisterReceiver: ", th5);
                }
                this.f262146n = false;
            }
            this.f262145m = null;
        }
        this.f262133a = null;
        this.f262144l.clear();
        ThreadManagerV2.removeJobFromThreadPool(this.f262152t, 16);
        ThreadManagerV2.removeJobFromThreadPool(this.f262151s, 16);
        this.f262134b.unregisterListener(this.f262137e);
        this.f262134b.unregisterListener(this.f262138f);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("audiosenormanager.playkey");
        if (action != null && action.equals("mqq.audiosenormanager.audio.start")) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_SenorManager", 2, "onReceive AUDIO_SENOR_START_NOTIFY key = " + stringExtra);
            }
            if (!this.f262147o) {
                m();
            }
            r(stringExtra);
            return;
        }
        if (action != null && action.equals("mqq.audiosenormanager.audio.end")) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPlayer_SenorManager", 2, "onReceive AUDIO_SENOR_END_NOTIFY key = " + stringExtra);
            }
            s(stringExtra);
        }
    }

    public void q(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        } else {
            this.f262133a = bVar;
        }
    }
}
