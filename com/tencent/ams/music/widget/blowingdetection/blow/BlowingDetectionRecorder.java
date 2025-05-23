package com.tencent.ams.music.widget.blowingdetection.blow;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.ams.music.widget.blowingdetection.blow.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class BlowingDetectionRecorder extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private final int f71620b;

    /* renamed from: c, reason: collision with root package name */
    private final int f71621c;

    /* renamed from: d, reason: collision with root package name */
    private final int f71622d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f71623e;

    /* renamed from: f, reason: collision with root package name */
    private HandlerThread f71624f;

    /* renamed from: g, reason: collision with root package name */
    private RecordRunnable f71625g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class RecordRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private com.tencent.ams.music.widget.blowingdetection.utils.a C;

        /* renamed from: d, reason: collision with root package name */
        private final a.InterfaceC0699a f71626d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f71627e;

        /* renamed from: f, reason: collision with root package name */
        private int f71628f;

        /* renamed from: h, reason: collision with root package name */
        private int f71629h;

        /* renamed from: i, reason: collision with root package name */
        private int f71630i;

        /* renamed from: m, reason: collision with root package name */
        private int f71631m;

        public RecordRunnable(int i3, int i16, int i17, a.InterfaceC0699a interfaceC0699a) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), interfaceC0699a);
                return;
            }
            this.f71627e = false;
            this.f71628f = i3;
            this.f71629h = i16;
            this.f71630i = i17;
            this.f71626d = interfaceC0699a;
            this.f71631m = AudioRecord.getMinBufferSize(i3, i16, i17);
            this.C = new com.tencent.ams.music.widget.blowingdetection.utils.a(this.f71631m * 10);
        }

        private void a(int i3, int i16, String str) {
            Log.i("BlowingDetectionRun", "[onError] action" + i3 + "code" + i16 + "msg" + str);
            a.InterfaceC0699a interfaceC0699a = this.f71626d;
            if (interfaceC0699a != null) {
                interfaceC0699a.onError(i3, i16, str);
            }
        }

        private void e() {
            Log.i("BlowingDetectionRun", "[onRecordStart]");
            a.InterfaceC0699a interfaceC0699a = this.f71626d;
            if (interfaceC0699a != null) {
                interfaceC0699a.onStart();
            }
        }

        private void f() {
            Log.i("BlowingDetectionRun", "[onRecordStop]");
            a.InterfaceC0699a interfaceC0699a = this.f71626d;
            if (interfaceC0699a != null) {
                interfaceC0699a.onStop();
            }
        }

        private void g(byte[] bArr, int i3) {
            a.InterfaceC0699a interfaceC0699a = this.f71626d;
            if (interfaceC0699a != null) {
                interfaceC0699a.a(bArr, i3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:75:? A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Log.i("BlowingDetectionRun", "[run] minBufferSize" + this.f71631m);
            boolean z16 = true;
            try {
                AudioRecord audioRecord = new AudioRecord(1, this.f71628f, this.f71629h, this.f71630i, this.f71631m);
                try {
                    try {
                        if (audioRecord.getState() != 1) {
                            Log.e("BlowingDetectionRun", "[run] init AudioRecorder: state=" + audioRecord.getState());
                            a(1, audioRecord.getState(), "Wrong init state: recorder.state}");
                            z16 = false;
                        } else {
                            try {
                                Log.i("BlowingDetectionRun", "[run] call startRecording start");
                                AudioMonitor.startRecording(audioRecord);
                                Log.i("BlowingDetectionRun", "[run] call startRecording end");
                                if (audioRecord.getRecordingState() != 3) {
                                    Log.e("BlowingDetectionRun", "[run] error recordingState= " + audioRecord.getRecordingState());
                                    a(2, audioRecord.getRecordingState(), "Wrong recording state: " + audioRecord.getRecordingState());
                                    this.f71627e = false;
                                    try {
                                        audioRecord.release();
                                    } catch (Exception e16) {
                                        Log.e("BlowingDetectionRun", "[run] release recorder exception: ", e16);
                                    }
                                    f();
                                    return;
                                }
                                e();
                                while (this.f71627e) {
                                    byte[] a16 = this.C.a(this.f71631m);
                                    int read = audioRecord.read(a16, 0, this.f71631m);
                                    if (read != -3) {
                                        if (read != -2) {
                                            if (read == 0) {
                                                a(3, -1, "Read size is zero");
                                            }
                                        } else {
                                            a(3, -2, "");
                                        }
                                    } else {
                                        a(3, -3, "");
                                    }
                                    g(a16, read);
                                }
                            } catch (Exception e17) {
                                e = e17;
                                Log.e("BlowingDetectionRun", "[run] recording exception: ", e);
                                a(4, -1, e.toString());
                                this.f71627e = false;
                                try {
                                    audioRecord.release();
                                } catch (Exception e18) {
                                    Log.e("BlowingDetectionRun", "[run] release recorder exception: ", e18);
                                }
                                if (!z16) {
                                    return;
                                }
                                f();
                            }
                        }
                        this.f71627e = false;
                        try {
                            audioRecord.release();
                        } catch (Exception e19) {
                            Log.e("BlowingDetectionRun", "[run] release recorder exception: ", e19);
                        }
                        if (!z16) {
                            return;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        z16 = false;
                    } catch (Throwable th5) {
                        th = th5;
                        z16 = false;
                        this.f71627e = false;
                        try {
                            audioRecord.release();
                        } catch (Exception e27) {
                            Log.e("BlowingDetectionRun", "[run] release recorder exception: ", e27);
                        }
                        if (!z16) {
                        }
                    }
                    f();
                } catch (Throwable th6) {
                    th = th6;
                    this.f71627e = false;
                    audioRecord.release();
                    if (!z16) {
                        f();
                        throw th;
                    }
                    throw th;
                }
            } catch (Exception e28) {
                Log.e("BlowingDetectionRun", "[run] init AudioRecorder exception: ", e28);
                a(1, -1, e28.toString());
            }
        }
    }

    public BlowingDetectionRecorder(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f71620b = i3;
        this.f71621c = i16;
        this.f71622d = i17;
    }

    @Override // com.tencent.ams.music.widget.blowingdetection.blow.a
    public /* bridge */ /* synthetic */ void b(a.InterfaceC0699a interfaceC0699a) {
        super.b(interfaceC0699a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Handler handler;
        b(null);
        e();
        RecordRunnable recordRunnable = this.f71625g;
        if (recordRunnable != null && (handler = this.f71623e) != null) {
            handler.removeCallbacks(recordRunnable);
        }
        HandlerThread handlerThread = this.f71624f;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f71624f.interrupt();
        }
        Log.i("BlowingDetection", "[release]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f71623e == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("BlowingDetectionRecorder-Thread");
            this.f71624f = baseHandlerThread;
            baseHandlerThread.start();
            this.f71623e = new Handler(this.f71624f.getLooper());
        }
        e();
        if (this.f71625g == null) {
            this.f71625g = new RecordRunnable(this.f71620b, this.f71621c, this.f71622d, a());
        }
        this.f71625g.f71627e = true;
        this.f71623e.post(this.f71625g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        Log.d("BlowingDetection", "stopRecord");
        RecordRunnable recordRunnable = this.f71625g;
        if (recordRunnable != null) {
            recordRunnable.f71627e = false;
        }
    }
}
