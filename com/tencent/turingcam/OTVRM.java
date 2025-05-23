package com.tencent.turingcam;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.CFgXs;
import com.tencent.turingcam.DO0IX;
import com.tencent.turingcam.JD1Ej;
import com.tencent.turingcam.a2zkO;
import com.tencent.turingcam.spXPg;
import com.tencent.turingcam.tLlmS;
import com.tencent.turingcam.view.TuringPreviewDisplay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OTVRM {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private static final String f381976j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f381977k;

    /* renamed from: l, reason: collision with root package name */
    private static final String f381978l;

    /* renamed from: m, reason: collision with root package name */
    private static final String f381979m;

    /* renamed from: n, reason: collision with root package name */
    private static final String f381980n;

    /* renamed from: o, reason: collision with root package name */
    private static final String f381981o;

    /* renamed from: p, reason: collision with root package name */
    private static final String f381982p;

    /* renamed from: q, reason: collision with root package name */
    private static final String f381983q;

    /* renamed from: r, reason: collision with root package name */
    private static final String f381984r;

    /* renamed from: s, reason: collision with root package name */
    private static final String f381985s;

    /* renamed from: t, reason: collision with root package name */
    private static final String f381986t;

    /* renamed from: u, reason: collision with root package name */
    private static final String f381987u;

    /* renamed from: v, reason: collision with root package name */
    private static final String f381988v;

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f381989w = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f381990a;

    /* renamed from: b, reason: collision with root package name */
    private z5VDt f381991b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Camera> f381992c;

    /* renamed from: d, reason: collision with root package name */
    private B9LVG f381993d;

    /* renamed from: e, reason: collision with root package name */
    private kwCJn f381994e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<View> f381995f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f381996g;

    /* renamed from: h, reason: collision with root package name */
    private TuringFaceBuilder f381997h;

    /* renamed from: i, reason: collision with root package name */
    public long f381998i;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface B9LVG {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Bi3eT {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final OTVRM f381999a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17929);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f381999a = new OTVRM(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ShGzN implements CFgXs.spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera f382000a;

        public ShGzN(Camera camera2) {
            this.f382000a = camera2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OTVRM.this, (Object) camera2);
            }
        }

        @Override // com.tencent.turingcam.CFgXs.spXPg
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            OTVRM.a(OTVRM.this, this.f382000a, surfaceTexture, null);
            if (OTVRM.this.f381993d != null) {
                ((vqARY) OTVRM.this.f381993d).f382409a.onPreviewAvailable();
            }
        }

        @Override // com.tencent.turingcam.CFgXs.spXPg
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceTexture)).booleanValue();
            }
            if (OTVRM.this.f381993d != null) {
                ((vqARY) OTVRM.this.f381993d).f382409a.onPreviewDestroyed();
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class SkEpO implements SurfaceHolder.Callback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera f382002a;

        public SkEpO(Camera camera2) {
            this.f382002a = camera2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OTVRM.this, (Object) camera2);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) surfaceHolder);
                return;
            }
            OTVRM.a(OTVRM.this, this.f382002a, null, surfaceHolder);
            if (OTVRM.this.f381993d != null) {
                ((vqARY) OTVRM.this.f381993d).f382409a.onPreviewAvailable();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceHolder);
            } else if (OTVRM.this.f381993d != null) {
                ((vqARY) OTVRM.this.f381993d).f382409a.onPreviewDestroyed();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class kwCJn {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f382004a;

        /* renamed from: b, reason: collision with root package name */
        public int f382005b;

        /* renamed from: c, reason: collision with root package name */
        public EQsUZ f382006c;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f382007d;

        /* renamed from: e, reason: collision with root package name */
        public Map<String, String> f382008e;

        /* renamed from: f, reason: collision with root package name */
        public byte[] f382009f;

        public kwCJn() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f382005b = 0;
            EQsUZ eQsUZ = new EQsUZ();
            this.f382006c = eQsUZ;
            eQsUZ.f381792a = new ArrayList<>();
            this.f382006c.f381793b = new HashMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class wmqhz implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringPreviewDisplay f382011a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f382012b;

        public wmqhz(OTVRM otvrm, TuringPreviewDisplay turingPreviewDisplay, View view) {
            this.f382011a = turingPreviewDisplay;
            this.f382012b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, otvrm, turingPreviewDisplay, view);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f382011a.addView(this.f382012b, -1, -1);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f381976j = FxCVY.b("3spd2H8hHma4H18EjYTzWg==");
        f381977k = FxCVY.b("DSv7X69YcoK1PCJvm8ce5osrHNM=");
        f381978l = FxCVY.b("PRCBC9ulqKi8tK1vJSfQ3CVEfaa9uZL8xNsqSA==");
        f381979m = FxCVY.b("ZhC44TH2gipmEmDqkN11sw==");
        f381980n = FxCVY.b("GPJOXui0b6GBvil8JLG3bY/zgr9DbLPt");
        f381981o = FxCVY.b("53GWiqTfPF5HGxYjWLrd0U4Oll+oAajp");
        f381982p = FxCVY.b("tnBzhxxR/b+gYqxoICYmA1lN0tEjYYXvb1msZQ==");
        f381983q = FxCVY.b("W31u13O9REtolI1/zQ62pl5cse0Shhs4WEu3fuJwapA=");
        f381984r = FxCVY.b("WsIxLAQ7292izcD9D2+F/C1r56ivVsc57/Qy2Wr+k/4=");
        f381985s = FxCVY.b("o/iwVRB+2t0oXTAhYo0k6w==");
        f381986t = FxCVY.b("KcCXRJxp6EimxG2q");
        f381987u = FxCVY.b("a2FVQCISY/nIQ4G7CuAwVA==");
        f381988v = FxCVY.b("afZBwBKcjnW/Ud571mrZNg==");
    }

    public /* synthetic */ OTVRM(spXPg spxpg) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) spxpg);
    }

    public static void a(OTVRM otvrm, String str) {
        otvrm.getClass();
        G2SZT.b().a();
        long currentTimeMillis = System.currentTimeMillis();
        WeakReference<Camera> weakReference = otvrm.f381992c;
        Camera camera2 = weakReference != null ? weakReference.get() : null;
        JD1Ej.SkEpO b16 = JD1Ej.a().b();
        String str2 = b16.f381868a == 0 ? b16.f381869b : "";
        CvowV cvowV = new CvowV();
        cvowV.f381754a = "";
        cvowV.f381755b = new ArrayList<>();
        cvowV.f381756c = JD1Ej.a().a(str);
        cvowV.f381758e = otvrm.a();
        cvowV.f381759f = str2;
        HashMap hashMap = new HashMap();
        cvowV.f381757d = hashMap;
        HashMap hashMap2 = new HashMap();
        if (camera2 != null) {
            Camera.Parameters parameters = camera2.getParameters();
            StringBuilder sb5 = new StringBuilder();
            G1g37.a(parameters, f381983q, G1g37.a(parameters, f381982p, G1g37.a(parameters, f381981o, G1g37.a(parameters, f381980n, G1g37.a(parameters, f381979m, G1g37.a(parameters, f381978l, G1g37.a(parameters, f381977k, sb5, ";"), ";"), ";"), ";"), ";"), ";"), ";").append(parameters.get(f381984r));
            hashMap2.put(f381976j, sb5.toString());
        }
        hashMap2.toString();
        hashMap.putAll(hashMap2);
        cvowV.f381760g = 2;
        if (!TextUtils.isEmpty(str)) {
            cvowV.f381757d.put("token", str);
        }
        QjsR0 qjsR0 = new QjsR0(128);
        cvowV.a(qjsR0);
        a2zkO.spXPg spxpg = (a2zkO.spXPg) a2zkO.a(103, qjsR0.a());
        spxpg.f382129a.getClass();
        byte[] bArr = spxpg.f382129a.f382425a;
        B9LVG b9lvg = otvrm.f381993d;
        if (b9lvg != null) {
            ((vqARY) b9lvg).f382409a.onFinish(0L, bArr);
        }
        G2SZT.b().a("upload_code", 0L);
        G2SZT.b().a("upload_cost", System.currentTimeMillis() - currentTimeMillis);
    }

    public static void b(OTVRM otvrm, String str) {
        otvrm.getClass();
        mvP1o mvp1o = new mvP1o();
        byte[] b16 = b(str);
        if (b16 != null && a(b16, mvp1o)) {
            if (TextUtils.isEmpty(mvp1o.f382310a)) {
                B9LVG b9lvg = otvrm.f381993d;
                if (b9lvg != null) {
                    ((vqARY) b9lvg).f382409a.onFinishFrameCheck(-601001L, null);
                    return;
                }
                return;
            }
            kwCJn kwcjn = new kwCJn();
            otvrm.f381994e = kwcjn;
            kwcjn.f382004a = mvp1o.f382310a;
            kwcjn.f382007d = mvp1o.f382311b;
            kwcjn.f382008e = mvp1o.f382312c;
            kwcjn.f382005b = 1;
            kwcjn.f382009f = b16;
            WeakReference<View> weakReference = otvrm.f381995f;
            View view = weakReference == null ? null : weakReference.get();
            Camera camera2 = otvrm.f381992c.get();
            int i3 = DO0IX.f381772l;
            DO0IX.spXPg a16 = new DO0IX.spXPg().a(otvrm.f381994e.f382008e).a(view).a(camera2);
            Iterator<String> it = otvrm.f381994e.f382007d.iterator();
            while (it.hasNext()) {
                com.tencent.turingcam.spXPg a17 = X7aJM.a(it.next());
                if (a17 == null) {
                    it.remove();
                } else if (a17.a(a16) != 0) {
                    it.remove();
                }
            }
            if (otvrm.f381994e.f382007d.isEmpty()) {
                B9LVG b9lvg2 = otvrm.f381993d;
                if (b9lvg2 != null) {
                    ((vqARY) b9lvg2).f382409a.onFinishFrameCheck(-601003L, null);
                    return;
                }
                return;
            }
            otvrm.f381994e.f382005b = 6;
            return;
        }
        B9LVG b9lvg3 = otvrm.f381993d;
        if (b9lvg3 != null) {
            ((vqARY) b9lvg3).f382409a.onFinishFrameCheck(-601001L, null);
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = str;
        this.f381991b.a(this.f381990a, obtain);
    }

    OTVRM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381996g = false;
            this.f381998i = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class spXPg implements akdmq {
        static IPatchRedirector $redirector_;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OTVRM.this);
            }
        }

        @Override // com.tencent.turingcam.akdmq
        public void a(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 3) {
                OTVRM.a(OTVRM.this, (spXPg.C10028spXPg) message.obj);
                return;
            }
            if (i3 == 4) {
                OTVRM.a(OTVRM.this);
                return;
            }
            if (i3 == 5) {
                Object obj = message.obj;
                OTVRM.a(OTVRM.this, obj != null ? (String) obj : "");
            } else {
                if (i3 != 6) {
                    return;
                }
                OTVRM.b(OTVRM.this, (String) message.obj);
            }
        }

        @Override // com.tencent.turingcam.akdmq
        public void a(Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) th5);
            } else if (OTVRM.this.f381993d != null) {
                ((vqARY) OTVRM.this.f381993d).f382409a.onException(th5);
            }
        }
    }

    private static byte[] b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArr = new byte[16];
            System.arraycopy("CAJ8e5fqgUND9TZYE0kF".getBytes("UTF-8"), 0, bArr, 0, 16);
            return Uq36s.a(FLlEM.a(str), bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(OTVRM otvrm, Camera camera2, SurfaceTexture surfaceTexture, SurfaceHolder surfaceHolder) {
        otvrm.getClass();
        if (camera2 != null) {
            try {
                if (surfaceTexture != null) {
                    camera2.setPreviewTexture(surfaceTexture);
                } else if (surfaceHolder != null) {
                    camera2.setPreviewDisplay(surfaceHolder);
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public int a(TuringFaceBuilder turingFaceBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) turingFaceBuilder)).intValue();
        }
        if (!this.f381996g) {
            this.f381997h = turingFaceBuilder;
            z5VDt z5vdt = new z5VDt();
            this.f381991b = z5vdt;
            this.f381990a = z5vdt.a(new spXPg());
            long currentTimeMillis = System.currentTimeMillis();
            G2SZT.b().a(this.f381997h.getContext());
            this.f381996g = true;
            G2SZT.b().a("init_cost", System.currentTimeMillis() - currentTimeMillis);
            G2SZT.b().a("init_code", 0L);
            Log.i("turingfacecheck", "TuringFaceSDK: V2.3.0,B7,7WCF54SWX5H87QEV,youtu(debug=false,log=false,env=false)");
        }
        return JD1Ej.a().a(this.f381997h);
    }

    public void a(B9LVG b9lvg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f381993d = b9lvg;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) b9lvg);
        }
    }

    public void a(Camera camera2, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) camera2, (Object) str);
            return;
        }
        if (camera2 != null) {
            this.f381992c = new WeakReference<>(camera2);
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = str;
        this.f381991b.a(this.f381990a, obtain);
    }

    public void a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            return;
        }
        spXPg.C10028spXPg c10028spXPg = new spXPg.C10028spXPg();
        c10028spXPg.f382372a = System.currentTimeMillis();
        c10028spXPg.f382373b = bArr;
        Message obtain = Message.obtain();
        obtain.obj = c10028spXPg;
        obtain.what = 3;
        this.f381991b.a(this.f381990a, obtain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Camera camera2, TuringPreviewDisplay turingPreviewDisplay) {
        Bwfl9 bwfl9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) camera2, (Object) turingPreviewDisplay);
            return;
        }
        this.f381997h.isHardwareAcceleration();
        TuringFaceBuilder turingFaceBuilder = this.f381997h;
        if (turingFaceBuilder != null && turingFaceBuilder.isHardwareAcceleration() && HOiEc.a()) {
            CFgXs cFgXs = new CFgXs(turingPreviewDisplay.getContext(), null);
            cFgXs.a(new ShGzN(camera2));
            bwfl9 = cFgXs;
        } else {
            Bwfl9 bwfl92 = new Bwfl9(turingPreviewDisplay.getContext(), null);
            bwfl92.getHolder().addCallback(new SkEpO(camera2));
            bwfl9 = bwfl92;
        }
        this.f381995f = new WeakReference<>(bwfl9);
        turingPreviewDisplay.post(new wmqhz(this, turingPreviewDisplay, bwfl9));
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00e3, code lost:
    
        if (r5 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x010a, code lost:
    
        if (r8 != 0) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(String str) {
        long j3;
        tLlmS.SkEpO skEpO;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).longValue();
        }
        mvP1o mvp1o = new mvP1o();
        byte[] b16 = b(str);
        if (b16 == null || !a(b16, mvp1o) || TextUtils.isEmpty(mvp1o.f382313d)) {
            return -801001L;
        }
        JD1Ej a16 = JD1Ej.a();
        String str2 = mvp1o.f382313d;
        a16.getClass();
        HashMap<String, tLlmS.SkEpO> hashMap = tLlmS.f382377a;
        if (TextUtils.isEmpty(str2)) {
            j3 = -80000;
        } else {
            String[] split = str2.split(":", 2);
            if (split.length >= 2) {
                boolean z16 = false;
                String str3 = split[0];
                if (!TextUtils.isEmpty(str3)) {
                    synchronized (hashMap) {
                        skEpO = hashMap.get(str3);
                    }
                    if (skEpO == null) {
                        AtomicBoolean atomicBoolean = tLlmS.f382378b;
                        if (!atomicBoolean.get()) {
                            synchronized (atomicBoolean) {
                                if (!atomicBoolean.get()) {
                                    String b17 = tLlmS.b();
                                    atomicBoolean.set(true);
                                    if (!TextUtils.isEmpty(b17)) {
                                        HashMap hashMap2 = new HashMap();
                                        StringTokenizer stringTokenizer = new StringTokenizer(b17, ",");
                                        while (stringTokenizer.hasMoreTokens()) {
                                            tLlmS.SkEpO a17 = tLlmS.SkEpO.a(stringTokenizer.nextToken());
                                            if (a17 != null) {
                                                hashMap2.put(String.valueOf(com.tencent.turingcam.B9LVG.a(a17.f382384b.getBytes())), a17);
                                            }
                                        }
                                        if (!hashMap2.isEmpty()) {
                                            HashMap<String, tLlmS.SkEpO> hashMap3 = tLlmS.f382377a;
                                            synchronized (hashMap3) {
                                                hashMap3.putAll(hashMap2);
                                            }
                                        }
                                    }
                                }
                                z16 = true;
                            }
                        }
                        if (z16) {
                            synchronized (hashMap) {
                                skEpO = hashMap.get(str3);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(skEpO.f382384b)) {
                        AtomicReference<BfUKf> atomicReference = tLlmS.f382380d;
                        synchronized (atomicReference) {
                            BfUKf bfUKf = atomicReference.get();
                            if (bfUKf != null) {
                                long j16 = bfUKf.f381727b;
                                long j17 = skEpO.f382383a;
                                if (j16 >= j17) {
                                }
                            }
                            atomicReference.set(new BfUKf(skEpO.f382384b, skEpO.f382383a, str2));
                            XStYH.a(atomicReference.get());
                        }
                        j3 = 0;
                    }
                    j3 = -80002;
                }
            }
            j3 = -80001;
        }
        if (j3 != 0) {
            return j3 - 800000;
        }
        return 0L;
    }

    public static void a(OTVRM otvrm, spXPg.C10028spXPg c10028spXPg) {
        kwCJn kwcjn = otvrm.f381994e;
        if (kwcjn != null) {
            int i3 = kwcjn.f382005b;
            if (i3 == 6 || i3 == 2 || i3 == 3) {
                otvrm.f381998i = System.currentTimeMillis();
                otvrm.f381994e.f382005b = 3;
                otvrm.f381991b.a(otvrm.f381990a, 4);
                otvrm.f381991b.a(otvrm.f381990a, 4, 10000L);
                Camera camera2 = otvrm.f381992c.get();
                if (camera2 == null) {
                    B9LVG b9lvg = otvrm.f381993d;
                    if (b9lvg != null) {
                        ((vqARY) b9lvg).f382409a.onFinishFrameCheck(-301001L, null);
                    }
                    G2SZT.b().a("process_code", -301001L);
                    return;
                }
                kwCJn kwcjn2 = otvrm.f381994e;
                EQsUZ eQsUZ = kwcjn2.f382006c;
                Iterator<String> it = kwcjn2.f382007d.iterator();
                while (it.hasNext()) {
                    com.tencent.turingcam.spXPg a16 = X7aJM.a(it.next());
                    if (a16 != null && a16.a(c10028spXPg, camera2, eQsUZ)) {
                        it.remove();
                    }
                }
                if (otvrm.f381994e.f382007d.isEmpty()) {
                    otvrm.f381991b.a(otvrm.f381990a, 4);
                    otvrm.f381994e.f382005b = 4;
                    G2SZT.b().a("process_code", 0L);
                    G2SZT.b().a("process_cost", System.currentTimeMillis() - otvrm.f381998i);
                    long currentTimeMillis = System.currentTimeMillis();
                    XnM3A xnM3A = new XnM3A();
                    xnM3A.f382098a = otvrm.f381994e.f382004a;
                    ArrayList<uAnWx> arrayList = new ArrayList<>();
                    xnM3A.f382099b = arrayList;
                    arrayList.addAll(otvrm.f381994e.f382006c.f381792a);
                    xnM3A.f382100c = otvrm.f381994e.f382009f;
                    xnM3A.f382101d = otvrm.a();
                    QjsR0 qjsR0 = new QjsR0(128);
                    xnM3A.a(qjsR0);
                    a2zkO.spXPg spxpg = (a2zkO.spXPg) a2zkO.a(104, qjsR0.a());
                    spxpg.f382129a.getClass();
                    byte[] bArr = spxpg.f382129a.f382425a;
                    B9LVG b9lvg2 = otvrm.f381993d;
                    if (b9lvg2 != null) {
                        ((vqARY) b9lvg2).f382409a.onFinishFrameCheck(0L, bArr);
                    }
                    G2SZT.b().a("upload_code", 0L);
                    G2SZT.b().a("upload_cost", System.currentTimeMillis() - currentTimeMillis);
                }
            }
        }
    }

    public static void a(OTVRM otvrm) {
        otvrm.f381994e.f382005b = 4;
        B9LVG b9lvg = otvrm.f381993d;
        if (b9lvg != null) {
            ((vqARY) b9lvg).f382409a.onFinish(-301005L, null);
        }
    }

    private sUvea a() {
        sUvea suvea = new sUvea();
        suvea.f382361a = 2;
        suvea.f382363c = JD1Ej.f381866d;
        suvea.f382362b = Build.BRAND;
        suvea.f382364d = Build.VERSION.RELEASE;
        suvea.f382365e = "2.3.0";
        suvea.f382367g = "7WCF54SWX5H87QEV";
        suvea.f382366f = String.valueOf(108158);
        suvea.f382368h = this.f381997h.getContext().getPackageName();
        suvea.f382369i = String.valueOf(this.f381997h.getChannel() != 0 ? this.f381997h.getChannel() : 108098);
        return suvea;
    }

    private static boolean a(byte[] bArr, mvP1o mvp1o) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
            mvp1o.f382310a = jSONObject.getString(f381985s);
            JSONArray jSONArray = jSONObject.getJSONArray(f381986t);
            mvp1o.f382311b = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                mvp1o.f382311b.add(jSONArray.getString(i3));
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(f381987u);
            Iterator keys = jSONObject2.keys();
            mvp1o.f382312c = new HashMap();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                mvp1o.f382312c.put(str, jSONObject2.getString(str));
            }
            mvp1o.f382313d = jSONObject.optString(f381988v, "");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
