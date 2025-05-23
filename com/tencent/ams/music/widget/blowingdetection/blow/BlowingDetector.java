package com.tencent.ams.music.widget.blowingdetection.blow;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.ams.music.widget.blowingdetection.BlowingDetectionNative;
import com.tencent.ams.music.widget.blowingdetection.blow.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BlowingDetector {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<Byte> f71632a;

    /* renamed from: b, reason: collision with root package name */
    private c f71633b;

    /* renamed from: c, reason: collision with root package name */
    private final int f71634c;

    /* renamed from: d, reason: collision with root package name */
    private final float f71635d;

    /* renamed from: e, reason: collision with root package name */
    private final int f71636e;

    /* renamed from: f, reason: collision with root package name */
    private BlowingDetectionRecorder f71637f;

    /* renamed from: g, reason: collision with root package name */
    private final HandlerThread f71638g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f71639h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f71640i;

    /* renamed from: j, reason: collision with root package name */
    private long f71641j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicBoolean f71642k;

    /* renamed from: l, reason: collision with root package name */
    private final AtomicBoolean f71643l;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements a.InterfaceC0699a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlowingDetector.this);
            }
        }

        @Override // com.tencent.ams.music.widget.blowingdetection.blow.a.InterfaceC0699a
        public void a(byte[] bArr, int i3) {
            Message obtainMessage;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr, i3);
                return;
            }
            if (BlowingDetector.this.f71639h != null && !BlowingDetector.this.f71642k.get() && (obtainMessage = BlowingDetector.this.f71639h.obtainMessage()) != null) {
                obtainMessage.what = 1;
                obtainMessage.obj = bArr;
                obtainMessage.arg1 = i3;
                obtainMessage.sendToTarget();
            }
        }

        @Override // com.tencent.ams.music.widget.blowingdetection.blow.a.InterfaceC0699a
        public void onError(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            } else if (BlowingDetector.this.f71633b != null) {
                BlowingDetector.this.f71633b.onDetectError(i3, i16, str);
            }
        }

        @Override // com.tencent.ams.music.widget.blowingdetection.blow.a.InterfaceC0699a
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (BlowingDetector.this.f71633b != null) {
                BlowingDetector.this.f71633b.onDetectStart();
            }
        }

        @Override // com.tencent.ams.music.widget.blowingdetection.blow.a.InterfaceC0699a
        public void onStop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (BlowingDetector.this.f71633b != null) {
                BlowingDetector.this.f71633b.onDetectStop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        static IPatchRedirector $redirector_;

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlowingDetector.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message != null && (message.obj instanceof byte[]) && !BlowingDetector.this.f71642k.get()) {
                synchronized (BlowingDetector.this.f71640i) {
                    byte[] bArr = (byte[]) message.obj;
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < bArr.length; i3++) {
                        if (BlowingDetector.this.f71632a.size() > 0) {
                            if (BlowingDetector.this.f71632a.size() < 1024) {
                                BlowingDetector.this.f71632a.add(Byte.valueOf(bArr[i3]));
                            } else if (BlowingDetector.this.f71632a.size() == 1024) {
                                byte[] bArr2 = new byte[BlowingDetector.this.f71632a.size()];
                                for (int i16 = 0; i16 < BlowingDetector.this.f71632a.size(); i16++) {
                                    bArr2[i16] = ((Byte) BlowingDetector.this.f71632a.get(i16)).byteValue();
                                }
                                BlowingDetector.this.j(bArr2);
                                BlowingDetector.this.f71632a.clear();
                                arrayList.add(Byte.valueOf(bArr[i3]));
                            } else {
                                BlowingDetector.this.f71632a.clear();
                            }
                        } else {
                            arrayList.add(Byte.valueOf(bArr[i3]));
                            if (arrayList.size() == 1024) {
                                byte[] bArr3 = new byte[arrayList.size()];
                                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                                    bArr3[i17] = ((Byte) arrayList.get(i17)).byteValue();
                                }
                                BlowingDetector.this.j(bArr3);
                                arrayList.clear();
                            }
                        }
                    }
                    BlowingDetector.this.f71632a.addAll(arrayList);
                    arrayList.clear();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface c {
        void onDetectError(int i3, int i16, String str);

        void onDetectResult(boolean z16);

        void onDetectStart();

        void onDetectStop();

        void onSoInit();
    }

    public BlowingDetector(int i3, int i16, int i17, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), cVar);
            return;
        }
        this.f71632a = new CopyOnWriteArrayList<>();
        this.f71637f = null;
        this.f71638g = new BaseHandlerThread("blowingDetectThread");
        this.f71639h = null;
        this.f71640i = new Object();
        this.f71641j = -1L;
        this.f71642k = new AtomicBoolean(false);
        this.f71643l = new AtomicBoolean(false);
        this.f71633b = cVar;
        this.f71634c = i3;
        this.f71635d = i16 / 100.0f;
        this.f71636e = i17;
        i();
    }

    private void h() {
        this.f71638g.start();
        this.f71639h = new b(this.f71638g.getLooper());
    }

    private void i() {
        new BaseThread(new Runnable() { // from class: com.tencent.ams.music.widget.blowingdetection.blow.BlowingDetector.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BlowingDetector.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                System.loadLibrary("tma_blowing_sound_detection");
                BlowingDetector.this.f71643l.set(true);
                if (BlowingDetector.this.f71633b != null) {
                    BlowingDetector.this.f71633b.onSoInit();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(byte[] bArr) {
        boolean z16;
        if (this.f71642k.get()) {
            return;
        }
        long blowingDetection = BlowingDetectionNative.blowingDetection(this.f71641j, bArr, 512);
        c cVar = this.f71633b;
        if (cVar != null) {
            if (blowingDetection > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar.onDetectResult(z16);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f71642k.set(true);
        BlowingDetectionRecorder blowingDetectionRecorder = this.f71637f;
        if (blowingDetectionRecorder != null) {
            blowingDetectionRecorder.c();
        }
        if (this.f71643l.get()) {
            BlowingDetectionNative.release(this.f71641j);
        }
        HandlerThread handlerThread = this.f71638g;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f71638g.interrupt();
        }
        this.f71633b = null;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!this.f71643l.get()) {
            c cVar = this.f71633b;
            if (cVar != null) {
                cVar.onDetectError(6, -1, "detector is released");
                return;
            }
            return;
        }
        if (this.f71642k.get()) {
            c cVar2 = this.f71633b;
            if (cVar2 != null) {
                cVar2.onDetectError(5, -1, "detector is released");
                return;
            }
            return;
        }
        if (this.f71637f == null) {
            this.f71637f = new BlowingDetectionRecorder(this.f71634c, 16, 2);
            h();
            this.f71641j = BlowingDetectionNative.init(this.f71634c, this.f71635d, this.f71636e);
            this.f71637f.b(new a());
        }
        this.f71637f.d();
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Handler handler = this.f71639h;
        if (handler != null) {
            handler.removeMessages(1);
        }
        BlowingDetectionRecorder blowingDetectionRecorder = this.f71637f;
        if (blowingDetectionRecorder != null) {
            blowingDetectionRecorder.e();
        }
    }
}
