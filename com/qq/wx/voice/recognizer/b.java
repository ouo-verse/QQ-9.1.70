package com.qq.wx.voice.recognizer;

import android.content.Context;
import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.ErrorCode;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.vad.EVad;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes3.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f41039a = false;

    /* renamed from: b, reason: collision with root package name */
    private ByteArrayOutputStream f41040b = new ByteArrayOutputStream();

    /* renamed from: c, reason: collision with root package name */
    private EVad f41041c = new EVad();

    /* renamed from: d, reason: collision with root package name */
    private boolean f41042d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f41043e = 3;

    /* renamed from: f, reason: collision with root package name */
    private int f41044f = 3;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41045g = true;

    /* renamed from: h, reason: collision with root package name */
    private LinkedList f41046h = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    private int f41047i = InfoRecorder.f40994h / InfoRecorder.f40988b;

    /* renamed from: j, reason: collision with root package name */
    private int f41048j = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f41049k = true;

    /* renamed from: l, reason: collision with root package name */
    private boolean f41050l = true;

    /* renamed from: m, reason: collision with root package name */
    private InnerAudioList f41051m = new InnerAudioList();

    /* renamed from: n, reason: collision with root package name */
    private c f41052n = new c();

    /* renamed from: o, reason: collision with root package name */
    private Thread f41053o = null;

    /* renamed from: p, reason: collision with root package name */
    private InnerSender f41054p = new InnerSender();

    /* renamed from: q, reason: collision with root package name */
    private Thread f41055q = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(VoiceRecognizerListener voiceRecognizerListener) {
        InfoRecognizer.f40972b.f41064b = voiceRecognizerListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(boolean z16) {
        InfoRecognizer.a(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void g(boolean z16) {
        InfoRecognizer.f40986p = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void h(boolean z16) {
        InfoRecognizer.f40978h = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void i(boolean z16) {
        InfoRecognizer.f40979i = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(Context context, String str) {
        d dVar = InfoRecognizer.f40972b;
        if (dVar.f41064b == null) {
            return -1;
        }
        dVar.f41063a = this;
        if (this.f41039a) {
            return 0;
        }
        InfoRecognizer.f40971a = str;
        InfoRecognizer.f40973c.init(context);
        InfoRecognizer.f40974d.init(context);
        InfoRecognizer.f40975e.init(context);
        if (this.f41041c.Init(InfoRecorder.f40987a, InfoRecorder.f40989c, InfoRecorder.f40991e, InfoRecorder.f40992f, InfoRecorder.f40993g) != 0) {
            InfoRecognizer.f40972b.b(-304);
            return -1;
        }
        this.f41039a = true;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.f41053o == null && this.f41055q == null) {
            return;
        }
        InfoRecognizer.f40972b.a(VoiceRecordState.Canceling);
        c cVar = this.f41052n;
        if (cVar != null) {
            cVar.b();
            this.f41052n.d();
        }
        Thread thread = this.f41053o;
        if (thread != null) {
            try {
                thread.join();
                this.f41053o = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        InnerSender innerSender = this.f41054p;
        if (innerSender != null) {
            innerSender.a();
            this.f41054p.b();
        }
        Thread thread2 = this.f41055q;
        if (thread2 != null) {
            try {
                thread2.join();
                this.f41055q = null;
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        InfoRecognizer.f40972b.a(VoiceRecordState.Canceled);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        if (this.f41039a) {
            c();
            this.f41052n.c();
            this.f41041c.Release();
            this.f41039a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int e() {
        d dVar = InfoRecognizer.f40972b;
        if (dVar.f41064b == null) {
            return -1;
        }
        if (!this.f41039a) {
            dVar.b(-101);
            return -1;
        }
        dVar.a();
        InfoRecognizer.f40972b.a(VoiceRecordState.Start);
        Thread thread = this.f41055q;
        if (thread != null && thread.isAlive()) {
            this.f41054p.a();
            this.f41054p.b();
            try {
                this.f41055q.join();
                this.f41055q = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        InnerAudioList innerAudioList = new InnerAudioList();
        this.f41051m = innerAudioList;
        innerAudioList.a();
        this.f41040b.reset();
        this.f41054p.a(this.f41051m);
        this.f41041c.Reset();
        this.f41042d = false;
        this.f41043e = 3;
        this.f41044f = 3;
        this.f41045g = true;
        this.f41046h.clear();
        this.f41047i = InfoRecorder.f40994h / InfoRecorder.f40988b;
        this.f41048j = 0;
        this.f41049k = true;
        this.f41050l = false;
        LogTool.d("preAudioMax = " + this.f41047i);
        BaseThread baseThread = new BaseThread(this.f41054p);
        this.f41055q = baseThread;
        baseThread.start();
        InfoRecognizer.f40972b.a(VoiceRecordState.Recording);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f() {
        InfoRecognizer.f40986p = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Context context, String str) {
        d dVar = InfoRecognizer.f40972b;
        if (dVar.f41064b == null) {
            return -1;
        }
        dVar.f41063a = this;
        if (this.f41039a) {
            return 0;
        }
        try {
            System.loadLibrary("WXVoice");
            InfoRecognizer.f40971a = str;
            InfoRecognizer.f40973c.init(context);
            InfoRecognizer.f40974d.init(context);
            InfoRecognizer.f40975e.init(context);
            if (this.f41041c.Init(InfoRecorder.f40987a, InfoRecorder.f40989c, InfoRecorder.f40991e, InfoRecorder.f40992f, InfoRecorder.f40993g) != 0) {
                InfoRecognizer.f40972b.b(-304);
                return -1;
            }
            this.f41039a = true;
            return 0;
        } catch (Exception unused) {
            InfoRecognizer.f40972b.b(-103);
            return -1;
        } catch (UnsatisfiedLinkError unused2) {
            InfoRecognizer.f40972b.b(-103);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(int i3) {
        InfoHttp.f40965b = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(boolean z16) {
        InfoRecognizer.f40976f = z16;
        if (z16) {
            InfoRecorder.f40992f = 500;
            InfoRecorder.f40993g = ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
            InfoRecorder.f40994h = 20000;
        } else {
            InfoRecorder.f40992f = 300;
            InfoRecorder.f40993g = 225;
            InfoRecorder.f40994h = 10000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.f41053o != null) {
            c cVar = this.f41052n;
            if (cVar != null) {
                cVar.a();
                this.f41052n.d();
            }
            try {
                this.f41053o.join();
                this.f41053o = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(int i3) {
        InfoHttp.f40968e = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a() {
        d dVar = InfoRecognizer.f40972b;
        if (dVar.f41064b == null) {
            return -1;
        }
        if (!this.f41039a) {
            dVar.b(-101);
            return -1;
        }
        Thread thread = this.f41053o;
        if (thread != null && thread.isAlive()) {
            InfoRecognizer.f40972b.b(-102);
            return -1;
        }
        InfoRecognizer.f40972b.a();
        if (this.f41052n.a(this.f41051m) < 0) {
            return -1;
        }
        Thread thread2 = this.f41055q;
        if (thread2 != null && thread2.isAlive()) {
            this.f41054p.a();
            this.f41054p.b();
            try {
                this.f41055q.join();
                this.f41055q = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.f41054p.a(this.f41051m);
        this.f41051m.a();
        BaseThread baseThread = new BaseThread(this.f41054p);
        this.f41055q = baseThread;
        baseThread.start();
        BaseThread baseThread2 = new BaseThread(this.f41052n);
        this.f41053o = baseThread2;
        baseThread2.start();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(boolean z16) {
        if (z16) {
            InfoHttp.f40969f = 1;
        } else {
            InfoHttp.f40969f = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(boolean z16) {
        InfoRecognizer.f40981k = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(int i3) {
        InfoRecorder.f40990d = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(String str) {
        InfoRecognizer.f40985o = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(int i3) {
        InfoHttp.f40966c = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(boolean z16) {
        InfoRecognizer.f40977g = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:123:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013b A[EDGE_INSN: B:95:0x013b->B:96:0x013b BREAK  A[LOOP:3: B:88:0x0110->B:94:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(byte[] bArr, int i3, int i16, boolean z16) {
        int i17;
        int i18;
        if (this.f41050l) {
            return 0;
        }
        if (bArr != null) {
            this.f41040b.write(bArr, i3, i16);
            try {
                this.f41040b.flush();
            } catch (IOException e16) {
                e16.printStackTrace();
                return -1;
            }
        }
        byte[] byteArray = this.f41040b.toByteArray();
        if (InfoRecognizer.f40980j) {
            int i19 = InfoRecorder.f40988b;
            i17 = 0;
            while (byteArray.length - i17 > i19) {
                int i26 = InfoRecorder.f40988b;
                byte[] bArr2 = new byte[i26];
                System.arraycopy(byteArray, i17, bArr2, 0, i19);
                int i27 = i17 + i19;
                if (this.f41048j == 0) {
                    int i28 = 0;
                    for (int i29 = 0; i29 < i26 && bArr2[i29] == 0; i29++) {
                        i28++;
                    }
                    if (i28 > i26 / 2) {
                        i18 = i27;
                        i17 = i18;
                    }
                }
                this.f41048j += i19;
                if (InfoRecorder.f40990d > 0) {
                    LogTool.d("timeOffset = " + this.f41048j + " timeOut = " + (((InfoRecorder.f40987a << 1) * InfoRecorder.f40990d) / 1000));
                    if (this.f41045g) {
                        i18 = i27;
                        if (this.f41048j > ((InfoRecorder.f40987a << 1) * InfoRecorder.f40990d) / 1000) {
                            InfoRecognizer.f40972b.b(ErrorCode.WX_VOICE_RECORD_ERROR_TIME_OUT);
                            i17 = i18;
                            break;
                        }
                        InfoRecognizer.f40972b.a(Common.calculateVolumn(bArr2, i19));
                        int AddData = this.f41041c.AddData(bArr2, i19);
                        this.f41043e = AddData;
                        if (!this.f41042d && AddData == 2 && this.f41044f == 3) {
                            this.f41042d = true;
                            this.f41045g = false;
                            LogTool.d("speaking start: preAudio size = " + this.f41046h.size());
                            if (!this.f41046h.isEmpty()) {
                                a aVar = new a((byte[]) this.f41046h.removeFirst(), InnerAudioState.begin);
                                aVar.f41038c = this.f41048j;
                                if (!this.f41051m.a(aVar)) {
                                    InfoRecognizer.f40972b.b(-305);
                                    i17 = i18;
                                    break;
                                }
                            }
                            while (true) {
                                if (!this.f41046h.isEmpty()) {
                                    break;
                                }
                                a aVar2 = new a((byte[]) this.f41046h.removeFirst(), InnerAudioState.middle);
                                aVar2.f41038c = this.f41048j;
                                if (!this.f41051m.a(aVar2)) {
                                    InfoRecognizer.f40972b.b(-305);
                                    break;
                                }
                            }
                        }
                        if (this.f41042d) {
                            if (this.f41043e == 3 && this.f41044f == 2) {
                                if (!InfoRecognizer.f40976f) {
                                    InfoRecognizer.f40972b.a(VoiceRecordState.Complete);
                                }
                                this.f41042d = false;
                                LogTool.d("speaking stop");
                                this.f41046h.clear();
                                if (!InfoRecognizer.f40976f) {
                                    a aVar3 = new a(bArr2, InnerAudioState.stop);
                                    aVar3.f41038c = this.f41048j;
                                    if (!this.f41051m.a(aVar3)) {
                                        InfoRecognizer.f40972b.b(-305);
                                    } else {
                                        this.f41050l = true;
                                        return 0;
                                    }
                                } else {
                                    a aVar4 = new a(bArr2, InnerAudioState.end);
                                    aVar4.f41038c = this.f41048j;
                                    if (!this.f41051m.a(aVar4)) {
                                        InfoRecognizer.f40972b.b(-305);
                                    }
                                }
                                i17 = i18;
                                break;
                            }
                            a aVar5 = new a(bArr2, InnerAudioState.middle);
                            aVar5.f41038c = this.f41048j;
                            if (!this.f41051m.a(aVar5)) {
                                InfoRecognizer.f40972b.b(-305);
                                i17 = i18;
                                break;
                            }
                        }
                        this.f41044f = this.f41043e;
                        this.f41046h.add(bArr2);
                        if (this.f41046h.size() <= this.f41047i) {
                            this.f41046h.removeFirst();
                        }
                        i17 = i18;
                    }
                }
                i18 = i27;
                InfoRecognizer.f40972b.a(Common.calculateVolumn(bArr2, i19));
                int AddData2 = this.f41041c.AddData(bArr2, i19);
                this.f41043e = AddData2;
                if (!this.f41042d) {
                    this.f41042d = true;
                    this.f41045g = false;
                    LogTool.d("speaking start: preAudio size = " + this.f41046h.size());
                    if (!this.f41046h.isEmpty()) {
                    }
                    while (true) {
                        if (!this.f41046h.isEmpty()) {
                        }
                    }
                }
                if (this.f41042d) {
                }
                this.f41044f = this.f41043e;
                this.f41046h.add(bArr2);
                if (this.f41046h.size() <= this.f41047i) {
                }
                i17 = i18;
            }
            if (z16) {
                InfoRecognizer.f40972b.a(VoiceRecordState.Complete);
                this.f41050l = true;
                boolean z17 = this.f41042d;
                if (!z17) {
                    if (this.f41051m.a(new a(null, InnerAudioState.cancel))) {
                        return 0;
                    }
                    InfoRecognizer.f40972b.b(-305);
                    return -1;
                }
                if (z17) {
                    this.f41042d = false;
                    LogTool.d("speaking stop");
                    byte[] bArr3 = new byte[byteArray.length - i17];
                    System.arraycopy(byteArray, i17, bArr3, 0, byteArray.length - i17);
                    a aVar6 = new a(bArr3, InnerAudioState.stop);
                    aVar6.f41038c = this.f41048j;
                    if (this.f41051m.a(aVar6)) {
                        return 0;
                    }
                    InfoRecognizer.f40972b.b(-305);
                    return -1;
                }
            }
        } else {
            i17 = 0;
        }
        if (!InfoRecognizer.f40980j) {
            int i36 = InfoRecorder.f40988b;
            while (true) {
                if (byteArray.length - i17 <= i36) {
                    break;
                }
                byte[] bArr4 = new byte[InfoRecorder.f40988b];
                System.arraycopy(byteArray, i17, bArr4, 0, i36);
                i17 += i36;
                this.f41048j += i36;
                InfoRecognizer.f40972b.a(Common.calculateVolumn(bArr4, i36));
                a aVar7 = new a(bArr4, this.f41049k ? InnerAudioState.begin : InnerAudioState.middle);
                this.f41049k = false;
                if (!this.f41051m.a(aVar7)) {
                    InfoRecognizer.f40972b.b(-305);
                    break;
                }
            }
            if (z16) {
                InfoRecognizer.f40972b.a(VoiceRecordState.Complete);
                this.f41050l = true;
                byte[] bArr5 = new byte[byteArray.length - i17];
                System.arraycopy(byteArray, i17, bArr5, 0, byteArray.length - i17);
                if (!this.f41051m.a(new a(bArr5, InnerAudioState.stop))) {
                    InfoRecognizer.f40972b.b(-305);
                    return -1;
                }
            }
        }
        this.f41040b.reset();
        this.f41040b.write(byteArray, i17, byteArray.length - i17);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(int i3) {
        InfoRecorder.f40989c = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z16) {
        InfoRecognizer.f40980j = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str) {
        if (str != null) {
            InfoHttp.f40967d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(byte[] bArr) {
        this.f41054p.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Context context, String str, String str2) {
        d dVar = InfoRecognizer.f40972b;
        if (dVar.f41064b == null) {
            return -1;
        }
        dVar.f41063a = this;
        if (this.f41039a) {
            return 0;
        }
        try {
            System.load(str2);
            InfoRecognizer.f40971a = str;
            InfoRecognizer.f40973c.init(context);
            InfoRecognizer.f40974d.init(context);
            InfoRecognizer.f40975e.init(context);
            if (this.f41041c.Init(InfoRecorder.f40987a, InfoRecorder.f40989c, InfoRecorder.f40991e, InfoRecorder.f40992f, InfoRecorder.f40993g) != 0) {
                InfoRecognizer.f40972b.b(-304);
                return -1;
            }
            this.f41039a = true;
            return 0;
        } catch (Exception unused) {
            InfoRecognizer.f40972b.b(-103);
            return -1;
        } catch (UnsatisfiedLinkError unused2) {
            InfoRecognizer.f40972b.b(-103);
            return -1;
        }
    }
}
