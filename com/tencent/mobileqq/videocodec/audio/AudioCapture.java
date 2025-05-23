package com.tencent.mobileqq.videocodec.audio;

import android.app.Activity;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.a;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AudioCapture implements a.b {
    static IPatchRedirector $redirector_;
    public static int E;
    public static int F;
    private Thread A;
    private final Object B;
    private Handler C;
    private final Runnable D;

    /* renamed from: a, reason: collision with root package name */
    public int f312469a;

    /* renamed from: b, reason: collision with root package name */
    public int f312470b;

    /* renamed from: c, reason: collision with root package name */
    public AudioRecord f312471c;

    /* renamed from: d, reason: collision with root package name */
    private String f312472d;

    /* renamed from: e, reason: collision with root package name */
    byte[] f312473e;

    /* renamed from: f, reason: collision with root package name */
    int f312474f;

    /* renamed from: g, reason: collision with root package name */
    public int f312475g;

    /* renamed from: h, reason: collision with root package name */
    byte[] f312476h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f312477i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f312478j;

    /* renamed from: k, reason: collision with root package name */
    public volatile int f312479k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f312480l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f312481m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f312482n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f312483o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f312484p;

    /* renamed from: q, reason: collision with root package name */
    public com.tencent.mobileqq.videocodec.audio.a f312485q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f312486r;

    /* renamed from: s, reason: collision with root package name */
    com.tencent.mobileqq.videocodec.mediacodec.recorder.a f312487s;

    /* renamed from: t, reason: collision with root package name */
    private String f312488t;

    /* renamed from: u, reason: collision with root package name */
    private int f312489u;

    /* renamed from: v, reason: collision with root package name */
    private int f312490v;

    /* renamed from: w, reason: collision with root package name */
    private int f312491w;

    /* renamed from: x, reason: collision with root package name */
    private int f312492x;

    /* renamed from: y, reason: collision with root package name */
    public b f312493y;

    /* renamed from: z, reason: collision with root package name */
    private RecordRunnable f312494z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class RecordRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f312497d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f312498e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f312499f;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f312500h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f312501i;

        /* renamed from: m, reason: collision with root package name */
        final Object f312502m;

        public RecordRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioCapture.this);
                return;
            }
            this.f312500h = false;
            this.f312502m = new Object();
            this.f312501i = !AudioCapture.this.f312482n;
        }

        /* JADX WARN: Code restructure failed: missing block: B:121:0x0294, code lost:
        
            com.tencent.qphone.base.util.QLog.w("AudioCapture", 1, "RecordRunnable exit, error param, mAudioRecord:" + r11.this$0.f312471c + ", mRecBuffer:" + r11.this$0.f312473e);
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x02bd, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            byte[] bArr;
            byte[] bArr2;
            int i3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AudioCapture", 2, "RecordRunnable run");
            }
            this.f312498e = false;
            this.f312499f = false;
            AudioCapture.this.A();
            Process.setThreadPriority(-19);
            while (true) {
                if (this.f312500h && !AudioCapture.this.f312483o && !AudioCapture.this.f312484p) {
                    break;
                }
                if (this.f312498e) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AudioCapture", 2, "RecordRunnable exit before record");
                        return;
                    }
                    return;
                }
                if (this.f312501i) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AudioCapture", 2, "RecordRunnable pause");
                    }
                    synchronized (this.f312502m) {
                        try {
                            if (this.f312501i) {
                                LockMethodProxy.wait(this.f312502m);
                            }
                        } catch (Exception e16) {
                            QLog.e("AudioCapture", 1, "RecordRunnable wait exception:", e16);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AudioCapture", 2, "RecordRunnable resume, startrecord:" + this.f312500h + " interrupt:" + this.f312498e + " pause:" + this.f312501i);
                    }
                } else {
                    AudioCapture audioCapture = AudioCapture.this;
                    AudioRecord audioRecord = audioCapture.f312471c;
                    if (audioRecord != null && (bArr = audioCapture.f312473e) != null) {
                        int read = audioRecord.read(bArr, 0, audioCapture.f312474f);
                        AudioCapture audioCapture2 = AudioCapture.this;
                        b bVar = audioCapture2.f312493y;
                        if (bVar != null) {
                            bVar.onAudioFrames(audioCapture2.f312473e, 0, read);
                        }
                        if (this.f312500h && (AudioCapture.this.f312483o || AudioCapture.this.f312484p)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioCapture", 2, "RecordRunnable mIsVoiceRecognizerStat: ", Boolean.valueOf(AudioCapture.this.f312483o), ", mNeedVoiceDecibel: ", Boolean.valueOf(AudioCapture.this.f312484p), "start record");
            }
            QLog.i("AudioCapture", 1, "RecordRunnable record run");
            this.f312497d = true;
            AudioCapture.this.f312485q = new com.tencent.mobileqq.videocodec.audio.a(AudioCapture.this.f312472d);
            AudioCapture.this.f312485q.d();
            int i17 = 0;
            while (true) {
                try {
                    if ((this.f312497d || AudioCapture.this.f312483o || AudioCapture.this.f312484p) && !this.f312498e) {
                        AudioCapture audioCapture3 = AudioCapture.this;
                        AudioRecord audioRecord2 = audioCapture3.f312471c;
                        if (audioRecord2 != null && (bArr2 = audioCapture3.f312473e) != null && audioCapture3.f312476h != null) {
                            int i18 = audioCapture3.f312474f;
                            int i19 = audioCapture3.f312475g;
                            if (i18 >= i19) {
                                if (audioRecord2 != null && bArr2 != null) {
                                    i3 = audioRecord2.read(bArr2, 0, i19);
                                } else {
                                    i3 = 0;
                                }
                                AudioCapture.this.x(i3);
                                AudioCapture audioCapture4 = AudioCapture.this;
                                audioCapture4.Q(audioCapture4.f312473e, i3);
                            } else {
                                if (audioRecord2 != null && bArr2 != null) {
                                    i16 = audioRecord2.read(bArr2, 0, i18);
                                } else {
                                    i16 = 0;
                                }
                                AudioCapture.this.x(i16);
                                if (i16 > 0) {
                                    int i26 = i17 + i16;
                                    AudioCapture audioCapture5 = AudioCapture.this;
                                    int i27 = audioCapture5.f312475g;
                                    if (i26 > i27) {
                                        System.arraycopy(audioCapture5.f312473e, 0, audioCapture5.f312476h, i17, i27 - i17);
                                        AudioCapture audioCapture6 = AudioCapture.this;
                                        audioCapture6.Q(audioCapture6.f312476h, audioCapture6.f312475g);
                                        AudioCapture audioCapture7 = AudioCapture.this;
                                        int i28 = audioCapture7.f312475g - i17;
                                        int i29 = i16 - i28;
                                        System.arraycopy(audioCapture7.f312473e, i28, audioCapture7.f312476h, 0, i29);
                                        i17 = i29;
                                    } else {
                                        System.arraycopy(audioCapture5.f312473e, 0, audioCapture5.f312476h, i17, i16);
                                        i17 = i26;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e17) {
                    QLog.e("AudioCapture", 1, "audio, run exception: ", e17);
                    AudioCapture.this.f312485q.a();
                    return;
                }
            }
            AudioCapture.this.f312485q.a();
            com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = AudioCapture.this.f312487s;
            if (aVar != null) {
                aVar.i();
            }
            if (QLog.isColorLevel()) {
                QLog.e("AudioCapture", 2, "audio, run out, isRecording:", Boolean.valueOf(this.f312497d), " mIsVoiceRecognizerStat:", Boolean.valueOf(AudioCapture.this.f312483o), ", mNeedVoiceDecibel: ", Boolean.valueOf(AudioCapture.this.f312484p), ", isQuickInterrupt: ", Boolean.valueOf(this.f312499f));
            }
            ms.a.f("AudioCapture", "exit recording, isRecording:" + this.f312497d + " listener:" + AudioCapture.this.f312493y + " isQuickInterrupt:" + this.f312499f);
            if (!this.f312497d || this.f312499f) {
                AudioCapture audioCapture8 = AudioCapture.this;
                audioCapture8.R(audioCapture8.f312476h, i17);
                AudioCapture audioCapture9 = AudioCapture.this;
                b bVar2 = audioCapture9.f312493y;
                if (bVar2 != null) {
                    bVar2.onAudioCaptured(audioCapture9.f312485q.c());
                }
            }
            AudioCapture.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioCapture.this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QLog.e("AudioCapture", 1, "openMic checkPermission user grant");
            AudioCapture.this.E();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
            } else {
                super.onDenied(list, list2);
                QLog.e("AudioCapture", 1, "openMic checkPermission user denied");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onAudioCaptured(String str);

        void onAudioChangeCaptured(String str);

        void onAudioError(int i3);

        void onAudioFrames(byte[] bArr, int i3, int i16);

        void onAudioInit();

        void onAudioUnInit();

        void onEncodeAudioCaptured(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            E = 16384;
            F = 4;
        }
    }

    public AudioCapture(String str, int i3, int i16, int i17, int i18, b bVar, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), bVar, handler);
            return;
        }
        this.f312473e = null;
        this.f312474f = 0;
        this.f312475g = 0;
        this.f312476h = null;
        this.f312477i = false;
        this.f312478j = true;
        this.f312479k = 0;
        this.f312482n = false;
        this.f312483o = false;
        this.f312484p = true;
        this.f312486r = false;
        this.B = new Object();
        this.D = new Runnable() { // from class: com.tencent.mobileqq.videocodec.audio.AudioCapture.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioCapture.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AudioRecord audioRecord;
                Thread thread;
                RecordRunnable recordRunnable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    synchronized (AudioCapture.this.B) {
                        AudioCapture audioCapture = AudioCapture.this;
                        audioRecord = audioCapture.f312471c;
                        thread = audioCapture.A;
                        recordRunnable = AudioCapture.this.f312494z;
                        AudioCapture audioCapture2 = AudioCapture.this;
                        audioCapture2.f312471c = null;
                        audioCapture2.A = null;
                        AudioCapture.this.f312494z = null;
                    }
                    if (audioRecord != null) {
                        AudioCapture.this.f312483o = false;
                        AudioCapture.this.f312484p = false;
                        AudioCapture.P(recordRunnable, thread);
                        try {
                            b bVar2 = AudioCapture.this.f312493y;
                            if (bVar2 != null) {
                                bVar2.onAudioUnInit();
                            }
                            audioRecord.stop();
                        } catch (Exception e16) {
                            QLog.e("AudioCapture", 1, "[closeMicRunnable] stop record, exc=" + e16);
                            b bVar3 = AudioCapture.this.f312493y;
                            if (bVar3 != null) {
                                bVar3.onAudioError(-5);
                            }
                        }
                        try {
                            audioRecord.release();
                        } catch (Exception e17) {
                            QLog.e("AudioCapture", 1, "[closeMicRunnable] release record, exc=" + e17);
                            if (AudioCapture.this.f312493y != null) {
                                AudioCapture.this.f312493y.onAudioError(-5);
                            }
                        }
                        QLog.i("AudioCapture", 1, "closeMic, finished, audioRecord=" + audioRecord.hashCode());
                        return;
                    }
                    QLog.i("AudioCapture", 1, "[closeMicRunnable] audio record is null, this=" + hashCode());
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.f312472d = str;
        this.f312489u = i3;
        this.f312490v = i16;
        this.f312491w = i17;
        this.f312492x = i18;
        this.f312493y = bVar;
        this.C = handler;
        if (handler == null) {
            this.C = new Handler(ThreadManagerV2.getSubThreadLooper());
        }
        this.f312469a = 0;
        this.f312470b = 0;
        this.f312480l = false;
        this.f312481m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean A() {
        if (this.f312477i) {
            return true;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(this.f312490v, CodecParam.mAudioChannel, CodecParam.mAudioFormat);
        this.f312474f = minBufferSize;
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.f312473e = new byte[minBufferSize];
            int i3 = E;
            int i16 = F;
            if (minBufferSize > i3 / i16) {
                i3 = minBufferSize * i16;
            }
            this.f312475g = i3;
            this.f312476h = new byte[i3];
            this.f312477i = true;
            return true;
        }
        QLog.e("AudioCapture", 1, "getMinBufferSize error. mRecBufSize = " + this.f312474f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "[realOpenMic] this=" + hashCode());
        }
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.videocodec.audio.AudioCapture.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AudioCapture.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    AudioCapture audioCapture = AudioCapture.this;
                    if (audioCapture.f312471c == null) {
                        audioCapture.A();
                        AudioCapture.this.f312471c = new AudioRecord(AudioCapture.this.f312489u, AudioCapture.this.f312490v, AudioCapture.this.f312491w, AudioCapture.this.f312492x, AudioCapture.this.f312474f);
                        QLog.i("AudioCapture", 1, "[openMic] finish initializing audio record, this=" + hashCode() + ", mAudioRecord=" + AudioCapture.this.f312471c);
                        try {
                            AudioMonitor.startRecording(AudioCapture.this.f312471c);
                            AudioCapture.this.M(true);
                            b bVar = AudioCapture.this.f312493y;
                            if (bVar != null) {
                                bVar.onAudioInit();
                            }
                            if (AudioCapture.this.f312471c.getState() == 0) {
                                QLog.e("AudioCapture", 1, "openMic,audio state:" + AudioCapture.this.f312471c.getState());
                                b bVar2 = AudioCapture.this.f312493y;
                                if (bVar2 != null) {
                                    bVar2.onAudioError(-4);
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (IllegalStateException e16) {
                            QLog.e("AudioCapture", 1, "start recording, exc=" + e16);
                            try {
                                AudioCapture.this.f312471c.release();
                            } catch (Exception e17) {
                                QLog.w("AudioCapture", 1, "[openMic] release audio record, exc=" + e17);
                            }
                            b bVar3 = AudioCapture.this.f312493y;
                            if (bVar3 != null) {
                                bVar3.onAudioError(-4);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.i("AudioCapture", 1, "[openMic] mAudioRecord != null, return");
                } catch (Exception e18) {
                    QLog.e("AudioCapture", 1, "openMic, exc=" + e18);
                    b bVar4 = AudioCapture.this.f312493y;
                    if (bVar4 != null) {
                        bVar4.onAudioError(-4);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void G() {
        this.f312474f = 0;
        this.f312473e = null;
        this.f312475g = 0;
        this.f312476h = null;
        this.f312477i = false;
        this.f312469a = 0;
        this.f312470b = 0;
        this.f312481m = false;
    }

    private static void I(RecordRunnable recordRunnable) {
        if (recordRunnable != null) {
            recordRunnable.f312501i = false;
            synchronized (recordRunnable.f312502m) {
                recordRunnable.f312502m.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(RecordRunnable recordRunnable, Thread thread) {
        QLog.i("AudioCapture", 1, "[stopRecordThread] runnable=" + recordRunnable);
        if (recordRunnable != null) {
            recordRunnable.f312498e = true;
            recordRunnable.f312497d = false;
        }
        if (thread != null) {
            try {
                try {
                    QLog.i("AudioCapture", 1, "[startCaptureThread] join record thread");
                    thread.interrupt();
                    thread.join();
                } catch (InterruptedException e16) {
                    QLog.i("AudioCapture", 1, "[startCaptureThread] failed to join, exc=" + e16);
                }
            } finally {
                QLog.i("AudioCapture", 1, "[startCaptureThread] record thread exited");
            }
        }
    }

    private static void w(RecordRunnable recordRunnable, Thread thread) {
        ThreadManagerV2.excute(new Runnable(thread) { // from class: com.tencent.mobileqq.videocodec.audio.AudioCapture.2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Thread f312496e;

            {
                this.f312496e = thread;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecordRunnable.this, (Object) thread);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AudioCapture.P(RecordRunnable.this, this.f312496e);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, false);
    }

    public void B(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "[openMic] this=" + hashCode());
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA, QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO));
        if (qQPermission != null) {
            if (qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
                E();
            } else {
                qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new a());
            }
        }
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "audio pause");
        }
        RecordRunnable recordRunnable = this.f312494z;
        if (recordRunnable != null) {
            recordRunnable.f312501i = true;
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "audio queueResume");
        }
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.videocodec.audio.AudioCapture.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioCapture.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    AudioCapture.this.H();
                }
            }
        });
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.f312493y = null;
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "audio resume");
        }
        I(this.f312494z);
    }

    public void J(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
        } else {
            this.f312486r = z16;
            this.f312488t = str;
        }
    }

    public void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.f312484p = z16;
        }
    }

    public void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f312483o = z16;
        }
    }

    public void M(boolean z16) {
        Thread thread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "startCaptureThread, force:" + z16);
        }
        synchronized (this.B) {
            if (!z16) {
                if (this.f312494z != null && (thread = this.A) != null && thread.isAlive()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AudioCapture", 2, "startCaptureThread, thread is working.");
                    }
                    return;
                }
            }
            w(this.f312494z, this.A);
            RecordRunnable recordRunnable = new RecordRunnable();
            this.f312494z = recordRunnable;
            Thread newFreeThread = ThreadManagerV2.newFreeThread(recordRunnable, "audio_capture", 5);
            this.A = newFreeThread;
            newFreeThread.start();
            if (this.f312486r && this.f312487s == null) {
                com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = new com.tencent.mobileqq.videocodec.mediacodec.recorder.a();
                this.f312487s = aVar;
                aVar.l(this.f312490v);
                this.f312487s.k(this);
            }
        }
    }

    public void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("AudioCapture", 1, "[startRecord] recordRunnable=" + this.f312494z);
        this.C.post(new Runnable() { // from class: com.tencent.mobileqq.videocodec.audio.AudioCapture.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioCapture.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    synchronized (AudioCapture.this.B) {
                        if (AudioCapture.this.f312494z == null) {
                            AudioCapture.this.M(true);
                        }
                        if (AudioCapture.this.f312494z != null) {
                            AudioCapture.this.f312494z.f312500h = true;
                        }
                        AudioCapture.this.H();
                        AudioCapture audioCapture = AudioCapture.this;
                        com.tencent.mobileqq.videocodec.mediacodec.recorder.a aVar = audioCapture.f312487s;
                        if (aVar != null) {
                            aVar.h(audioCapture.f312488t);
                        }
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        synchronized (this.B) {
            if (this.f312494z != null) {
                QLog.i("AudioCapture", 1, "audio, stopRecord, isRecording:" + this.f312494z.f312497d + ", mIsVoiceRecognizerStat:" + this.f312483o + ", recordRunnable:" + this.f312494z + ", stack:" + QLog.getStackTraceString(new RuntimeException("stopRecord")));
                this.f312483o = false;
                this.f312484p = false;
                this.f312494z.f312498e = true;
                this.f312494z.f312499f = true;
                this.f312494z.f312497d = false;
                this.A.interrupt();
                this.f312494z = null;
            }
            this.f312482n = false;
        }
    }

    public void Q(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bArr, i3);
            return;
        }
        if (bArr != null && i3 > 0 && i3 <= bArr.length) {
            com.tencent.mobileqq.videocodec.audio.a aVar = this.f312485q;
            if (aVar != null) {
                aVar.e(bArr, 0, i3);
            } else if (QLog.isColorLevel()) {
                QLog.d("AudioCapture", 2, "AudioCapture[writeDataToAudioNewCache]: mAudioDataCache=null");
            }
            if (this.f312487s != null) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                this.f312487s.f(bArr2, 0L);
            }
            b bVar = this.f312493y;
            if (bVar != null) {
                bVar.onAudioFrames(bArr, 0, i3);
            }
        }
    }

    public void R(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bArr, i3);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.a.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        b bVar = this.f312493y;
        if (bVar != null) {
            bVar.onAudioError(-6);
        }
    }

    @Override // com.tencent.mobileqq.videocodec.mediacodec.recorder.a.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        b bVar = this.f312493y;
        if (bVar != null) {
            bVar.onEncodeAudioCaptured(this.f312488t);
        }
    }

    void x(int i3) {
        if (i3 == -3) {
            this.f312478j = false;
            this.f312479k = -1;
            return;
        }
        if (i3 == 0) {
            int i16 = this.f312469a;
            if (i16 < 5) {
                this.f312469a = i16 + 1;
                return;
            }
            this.f312478j = false;
            this.f312479k = -2;
            if (QLog.isColorLevel()) {
                QLog.e("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA_LENGTH]: result=" + i3 + " mAudioInvalidCount=" + this.f312469a);
                return;
            }
            return;
        }
        this.f312469a = 0;
        if (!this.f312480l) {
            this.f312480l = true;
            this.f312481m = false;
            this.f312470b++;
            if (QLog.isColorLevel()) {
                QLog.d("AudioCapture", 2, "checkAudioPrivilage[ERR_AUDIO_INVALID_DATA]: result=" + i3 + " mAudioInvalidData=" + this.f312470b);
            }
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AudioCapture", 2, "closeMic, this=" + hashCode() + ", mAudioRecord=" + this.f312471c);
        }
        this.C.post(this.D);
    }

    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f312490v;
    }
}
