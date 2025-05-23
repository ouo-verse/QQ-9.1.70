package com.tencent.weclip;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.inference.WinkInferenceResManager;
import com.tencent.mobileqq.wink.inference.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weclip.weyamnet.b;
import com.tencent.weclip.weyamnet.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WEYamnet {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f384451a;

    /* renamed from: b, reason: collision with root package name */
    private int f384452b;

    /* renamed from: c, reason: collision with root package name */
    private float f384453c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f384454d;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f384455a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f384456b;

        a(long j3, c cVar) {
            this.f384455a = j3;
            this.f384456b = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WEYamnet.this, Long.valueOf(j3), cVar);
            }
        }

        @Override // com.tencent.weclip.weyamnet.b
        public boolean a(float[] fArr, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fArr, i3)).booleanValue();
            }
            WEYamnet wEYamnet = WEYamnet.this;
            if (wEYamnet.predictionFromFeatures(wEYamnet.f384451a, fArr)[WEYamnet.this.f384452b] > WEYamnet.this.f384453c) {
                QLog.i("WEYamnet", 1, "processingAndReturnShouldStop index: " + i3 + " hasMusic cost\uff1a" + (System.currentTimeMillis() - this.f384455a));
                this.f384456b.a(true, i3);
                return true;
            }
            if (i3 != 20) {
                return false;
            }
            QLog.i("WEYamnet", 1, "processingAndReturnShouldStop noMusic cost\uff1a" + (System.currentTimeMillis() - this.f384455a));
            this.f384456b.a(false, i3);
            return true;
        }

        @Override // com.tencent.weclip.weyamnet.b
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            QLog.i("WEYamnet", 1, "processingAndReturnShouldStop noMoreData cost\uff1a" + (System.currentTimeMillis() - this.f384455a));
            this.f384456b.a(false, -1);
        }
    }

    public WEYamnet() {
        int i3;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f384452b = 132;
        this.f384453c = 0.2f;
        this.f384454d = false;
        f();
        if (this.f384454d) {
            this.f384451a = nativeCreate(b.c.WEYAMNET_PARAM_PATH, b.c.WEYAMNET_BIN_PATH);
            WinkInferenceResManager winkInferenceResManager = WinkInferenceResManager.f322940a;
            Object obj = winkInferenceResManager.C().get("music_indexes");
            if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
            } else {
                i3 = this.f384452b;
            }
            this.f384452b = i3;
            Object obj2 = winkInferenceResManager.C().get("music_threshold");
            if (obj2 instanceof Float) {
                f16 = ((Float) obj2).floatValue();
            } else {
                f16 = this.f384453c;
            }
            this.f384453c = f16;
        }
    }

    private void f() {
        try {
            System.load(b.a.NCNN_SO_PATH);
            System.load(b.a.OMP_SO_PATH);
            System.load(b.a.CRYPTO_SO_PATH);
            System.load(b.a.SSL_SO_PATH);
            System.load(b.c.WEYAMNET_SO_PATH);
            this.f384454d = true;
        } catch (Throwable th5) {
            QLog.e("WEYamnet", 1, "loadSo error " + th5);
            this.f384454d = false;
            WinkInferenceResManager.f322940a.r();
        }
    }

    private native long nativeCreate(String str, String str2);

    private native void nativeDestroy(long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native float[] predictionFromFeatures(long j3, float[] fArr);

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f384454d;
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long j3 = this.f384451a;
        if (j3 != 0) {
            nativeDestroy(j3);
            this.f384451a = 0L;
        }
        super.finalize();
    }

    public void g(String str, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) cVar);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f384451a == 0) {
            cVar.a(false, -1);
            return;
        }
        QLog.i("WEYamnet", 1, "start check Bgm: " + str);
        com.tencent.weclip.weyamnet.a.a(str, new a(currentTimeMillis, cVar));
    }
}
