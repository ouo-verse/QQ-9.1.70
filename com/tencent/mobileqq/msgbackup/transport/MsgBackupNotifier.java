package com.tencent.mobileqq.msgbackup.transport;

import android.os.Looper;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupNotifier {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MsgBackup-Notifier";

    public MsgBackupNotifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String getFilePathFromURL(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "java getFilePathFromURL is called! url = " + str);
        }
        try {
            return MsgBackupTransportProcessor.u().j(str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getFilePathFromURL is error!", e16);
            return "";
        }
    }

    public void onHttpRequest(long j3, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2);
            return;
        }
        QLog.d(TAG, 1, "onHttpRequest ip = " + str + ", port = " + i3 + ", url = " + str2);
        a.b().a(new Runnable(j3, str, i3, str2) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.12
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f251292d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f251293e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f251294f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f251295h;

            {
                this.f251292d = j3;
                this.f251293e = str;
                this.f251294f = i3;
                this.f251295h = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Long.valueOf(j3), str, Integer.valueOf(i3), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().P(this.f251292d, this.f251293e, this.f251294f, this.f251295h);
                }
            }
        });
    }

    public void onLog(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) bArr2);
            return;
        }
        try {
            String str = new String(bArr, "UTF-8");
            QLog.d(TAG, 1, "-native-" + str, new String(bArr2, "UTF-8"));
        } catch (UnsupportedEncodingException e16) {
            QLog.e(TAG, 1, "-native", "native log encoding utf8 failed", e16);
        }
    }

    public void onRecvComplete(long j3, String str, int i3, String str2, byte[] bArr, int i16, int i17, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2, bArr, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16));
            return;
        }
        QLog.d(TAG, 1, "onRecvComplete fid = " + j3 + ", url = " + str + ", errCode = " + i3 + ", path = " + str2 + ", speedByteIn = " + i16 + ", speedByteOut = " + i17);
        a.b().a(new Runnable(j3, str, i3, str2, bArr, i16, i17, j16) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.11
            static IPatchRedirector $redirector_;
            final /* synthetic */ int C;
            final /* synthetic */ long D;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f251286d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f251287e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f251288f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f251289h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ byte[] f251290i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ int f251291m;

            {
                this.f251286d = j3;
                this.f251287e = str;
                this.f251288f = i3;
                this.f251289h = str2;
                this.f251290i = bArr;
                this.f251291m = i16;
                this.C = i17;
                this.D = j16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Long.valueOf(j3), str, Integer.valueOf(i3), str2, bArr, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().Q(this.f251286d, this.f251287e, this.f251288f, this.f251289h, this.f251290i, this.f251291m, this.C, this.D);
                }
            }
        });
    }

    public void onRecvMessage(String str, int i3, int i16, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Long.valueOf(j3));
            return;
        }
        QLog.d(TAG, 1, "onRecvMessage ip = " + str + ", port = " + i3 + ", cmd = " + i16 + ", data = " + str2 + ", cookie = " + j3);
        a.b().a(new Runnable(str, i3, i16, str2, j3) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f251320d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f251321e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f251322f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f251323h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f251324i;

            {
                this.f251320d = str;
                this.f251321e = i3;
                this.f251322f = i16;
                this.f251323h = str2;
                this.f251324i = j3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().R(this.f251320d, this.f251321e, this.f251322f, this.f251323h, this.f251324i);
                }
            }
        });
    }

    public void onRecvProgress(long j3, String str, long j16, long j17, int i3, long j18, int i16, int i17, long j19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Long.valueOf(j18), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j19));
            return;
        }
        QLog.d(TAG, 1, "onRecvProgress fid = " + j3 + ", url = " + str + ", uPos = " + j16 + ", totalLen = " + j17 + ", speed = " + i3 + ", incrementLen = " + j18 + ", speedByteIn = " + i16 + ", speedByteOut = " + i17);
        a.b().a(new Runnable(j3, j17, j18) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f251283d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f251284e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f251285f;

            {
                this.f251283d = j3;
                this.f251284e = j17;
                this.f251285f = j18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Long.valueOf(j3), Long.valueOf(j17), Long.valueOf(j18));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().S(this.f251283d, this.f251284e, this.f251285f);
                }
            }
        });
    }

    public void onRecvStart(long j3, String str, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        QLog.d(TAG, 1, "onRecvStart fid = " + j3 + ", url = " + str + ", dwResume = " + j16 + ", totalLen = " + j17 + ", context = " + j18);
        a.b().a(new Runnable(j3, str, j16, j17, j18) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f251325d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f251326e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f251327f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f251328h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f251329i;

            {
                this.f251325d = j3;
                this.f251326e = str;
                this.f251327f = j16;
                this.f251328h = j17;
                this.f251329i = j18;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().T(this.f251325d, this.f251326e, this.f251327f, this.f251328h, this.f251329i);
                }
            }
        });
    }

    public void onSendComplete(long j3, boolean z16, int i3, String str, int i16, int i17, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16));
            return;
        }
        QLog.d(TAG, 1, "onSendComplete fid = " + j3 + ", success = " + z16 + ", errCode = " + i3 + ", speedByteIn = " + i16 + ", speedByteOut = " + i17 + ", context = " + j16);
        a.b().a(new Runnable(j3, z16, i3, str, i16, i17, j16) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.14
            static IPatchRedirector $redirector_;
            final /* synthetic */ long C;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f251302d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f251303e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f251304f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f251305h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f251306i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ int f251307m;

            {
                this.f251302d = j3;
                this.f251303e = z16;
                this.f251304f = i3;
                this.f251305h = str;
                this.f251306i = i16;
                this.f251307m = i17;
                this.C = j16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().U(this.f251302d, this.f251303e, this.f251304f, this.f251305h, this.f251306i, this.f251307m, this.C);
                }
            }
        });
    }

    public void onSendMessage(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        QLog.d(TAG, 1, "onSendMessage success = " + z16 + ". cookie = " + j3 + ", context = " + j16);
        a.b().a(new Runnable(z16, j3, j16) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f251317d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f251318e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f251319f;

            {
                this.f251317d = z16;
                this.f251318e = j3;
                this.f251319f = j16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().V(this.f251317d, this.f251318e, this.f251319f);
                }
            }
        });
    }

    public void onSendProgress(long j3, String str, long j16, long j17, int i3, long j18, int i16, int i17, long j19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Long.valueOf(j18), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j19));
            return;
        }
        QLog.d(TAG, 1, "onSendProgress fid = " + j3 + ", path = " + str + ", uPos = " + j16 + ", totalLen = " + j17 + ", speed = " + i3 + ", incrementLen = " + j18 + ", speedByteIn = " + i16 + ", speedByteOut = " + i17);
        a.b().a(new Runnable(j3, str, j16, j17, i3, j18, i16, i17, j19) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.13
            static IPatchRedirector $redirector_;
            final /* synthetic */ int C;
            final /* synthetic */ int D;
            final /* synthetic */ long E;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f251296d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f251297e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f251298f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f251299h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f251300i;

            /* renamed from: m, reason: collision with root package name */
            final /* synthetic */ long f251301m;

            {
                this.f251296d = j3;
                this.f251297e = str;
                this.f251298f = j16;
                this.f251299h = j17;
                this.f251300i = i3;
                this.f251301m = j18;
                this.C = i16;
                this.D = i17;
                this.E = j19;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Long.valueOf(j18), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j19));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().W(this.f251296d, this.f251297e, this.f251298f, this.f251299h, this.f251300i, this.f251301m, this.C, this.D, this.E);
                }
            }
        });
    }

    public void onServoPortChanged(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d(TAG, 1, "onServoPortChanged ip = " + str + ", port = " + i3);
        a.b().a(new Runnable(str, i3) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f251314d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f251315e;

            {
                this.f251314d = str;
                this.f251315e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().X(this.f251314d, this.f251315e);
                }
            }
        });
    }

    public void onTcpConnStateChanged(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onTcpConnStateChanged state = ");
        sb5.append(i3);
        sb5.append(", isMain = ");
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d(TAG, 1, sb5.toString());
        a.b().a(new Runnable(i3) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f251316d;

            {
                this.f251316d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupNotifier.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().Y(this.f251316d);
                }
            }
        });
    }

    public void onUdpDetected(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        QLog.d(TAG, 1, "onUdpDetected success = " + z16);
        a.b().a(new Runnable(z16) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f251282d;

            {
                this.f251282d = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().Z(this.f251282d);
                }
            }
        });
    }

    public void onUdpPortChanged(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d(TAG, 1, "onUdpPortChanged ip = " + str + ", port = " + i3);
        a.b().a(new Runnable(str, i3) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f251308d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f251309e;

            {
                this.f251308d = str;
                this.f251309e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().a0(this.f251308d, this.f251309e);
                }
            }
        });
    }

    public void onVersoBind(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d(TAG, 1, "onVersoBind ip = " + str + ", port = " + i3);
        a.b().a(new Runnable(str, i3) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f251310d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f251311e;

            {
                this.f251310d = str;
                this.f251311e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().b0(this.f251310d, this.f251311e);
                }
            }
        });
    }

    public void onVersoPortChanged(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
            return;
        }
        QLog.d(TAG, 1, "onVersoPortChanged ip = " + str + ", port = " + i3);
        a.b().a(new Runnable(str, i3) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f251312d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f251313e;

            {
                this.f251312d = str;
                this.f251313e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupNotifier.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    MsgBackupManager.x().z().c0(this.f251312d, this.f251313e);
                }
            }
        });
    }
}
