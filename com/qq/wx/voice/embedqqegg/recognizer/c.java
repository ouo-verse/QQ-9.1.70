package com.qq.wx.voice.embedqqegg.recognizer;

import android.content.Context;
import com.qq.wx.voice.embedqqegg.util.Common;
import com.qq.wx.voice.embedqqegg.util.LogTool;
import com.qq.wx.voice.embedqqegg.vad.EVad;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40943a = false;

    /* renamed from: b, reason: collision with root package name */
    private ByteArrayOutputStream f40944b = new ByteArrayOutputStream();

    /* renamed from: c, reason: collision with root package name */
    private EVad f40945c = new EVad();

    /* renamed from: d, reason: collision with root package name */
    private boolean f40946d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f40947e = 3;

    /* renamed from: f, reason: collision with root package name */
    private int f40948f = 3;

    /* renamed from: g, reason: collision with root package name */
    private LinkedList f40949g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    private int f40950h = InfoRecorder.f40926g / InfoRecorder.f40921b;

    /* renamed from: i, reason: collision with root package name */
    private int f40951i = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f40952j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f40953k = true;

    /* renamed from: l, reason: collision with root package name */
    private InnerAudioList f40954l = new InnerAudioList();

    /* renamed from: m, reason: collision with root package name */
    private InnerSender f40955m = new InnerSender();

    /* renamed from: n, reason: collision with root package name */
    private Thread f40956n = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(VoiceRecognizerListener voiceRecognizerListener) {
        InfoRecognizer.f40913d.f40958b = voiceRecognizerListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        if (this.f40956n != null) {
            InnerSender innerSender = this.f40955m;
            if (innerSender != null) {
                innerSender.b();
                this.f40955m.d();
            }
            Thread thread = this.f40956n;
            if (thread != null) {
                try {
                    thread.join();
                    this.f40956n = null;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (this.f40943a) {
            a();
            this.f40955m.c();
            this.f40945c.Release();
            InfoRecognizer.f40911b = null;
            InfoRecognizer.f40912c = null;
            this.f40943a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d() {
        d dVar = InfoRecognizer.f40913d;
        if (dVar.f40958b == null) {
            return -1;
        }
        if (!this.f40943a) {
            dVar.b(-101);
            return -1;
        }
        dVar.a();
        InfoRecognizer.f40913d.a(VoiceRecordState.Start);
        Thread thread = this.f40956n;
        if (thread != null && thread.isAlive()) {
            this.f40955m.b();
            this.f40955m.d();
            try {
                this.f40956n.join();
                this.f40956n = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.f40955m.a(this.f40954l);
        this.f40954l.a();
        this.f40944b.reset();
        this.f40955m.a(this.f40954l);
        this.f40945c.Reset();
        this.f40946d = false;
        this.f40947e = 3;
        this.f40948f = 3;
        this.f40949g.clear();
        this.f40950h = InfoRecorder.f40926g / InfoRecorder.f40921b;
        this.f40951i = 0;
        this.f40952j = true;
        this.f40953k = false;
        LogTool.d("preAudioMax = " + this.f40950h);
        BaseThread baseThread = new BaseThread(this.f40955m);
        this.f40956n = baseThread;
        baseThread.start();
        InfoRecognizer.f40913d.a(VoiceRecordState.Recording);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Context context) {
        d dVar = InfoRecognizer.f40913d;
        if (dVar.f40958b == null) {
            return -1;
        }
        dVar.f40957a = this;
        if (this.f40943a) {
            return 0;
        }
        try {
            if (InfoRecognizer.f40911b == null) {
                System.loadLibrary("wxvoiceembedqqegg");
            } else {
                LogTool.d("init by soWXVoiceEmbedPath: " + InfoRecognizer.f40911b);
                if (!new File(InfoRecognizer.f40911b).exists()) {
                    LogTool.d("no found: " + InfoRecognizer.f40911b);
                }
                System.load(InfoRecognizer.f40911b);
            }
            InfoRecognizer.f40910a = context;
            if (this.f40955m.a() < 0) {
                return -1;
            }
            if (this.f40945c.Init(InfoRecorder.f40920a, InfoRecorder.f40922c, InfoRecorder.f40923d, InfoRecorder.f40924e, InfoRecorder.f40925f) != 0) {
                InfoRecognizer.f40913d.b(-304);
                return -1;
            }
            this.f40943a = true;
            return 0;
        } catch (Exception unused) {
            InfoRecognizer.f40911b = null;
            InfoRecognizer.f40912c = null;
            InfoRecognizer.f40913d.b(-103);
            return -1;
        } catch (UnsatisfiedLinkError unused2) {
            InfoRecognizer.f40911b = null;
            InfoRecognizer.f40912c = null;
            InfoRecognizer.f40913d.b(-103);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int c(int i3) {
        if (i3 < 0 || i3 > 100) {
            return -1;
        }
        InfoRecognizer.f40914e = i3;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(boolean z16) {
        InfoRecognizer.f40916g = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(boolean z16) {
        InfoRecognizer.f40917h = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(int i3) {
        return this.f40955m.setKeywordSetIndex(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Context context, String str, String str2) {
        InfoRecognizer.f40911b = str;
        InfoRecognizer.f40912c = str2;
        return a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        if (this.f40956n != null) {
            InfoRecognizer.f40913d.a(VoiceRecordState.Canceling);
            InnerSender innerSender = this.f40955m;
            if (innerSender != null) {
                innerSender.b();
                this.f40955m.d();
            }
            Thread thread = this.f40956n;
            if (thread != null) {
                try {
                    thread.join();
                    this.f40956n = null;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            InfoRecognizer.f40913d.a(VoiceRecordState.Canceled);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(byte[] bArr, int i3, int i16, boolean z16) {
        int i17;
        LogTool.d("append Data: len = " + i16 + " isComplete = " + z16);
        if (this.f40953k) {
            return 0;
        }
        if (bArr != null) {
            this.f40944b.write(bArr, i3, i16);
            try {
                this.f40944b.flush();
            } catch (IOException e16) {
                e16.printStackTrace();
                return -1;
            }
        }
        byte[] byteArray = this.f40944b.toByteArray();
        if (InfoRecognizer.f40918i) {
            int i18 = InfoRecorder.f40921b;
            i17 = 0;
            while (true) {
                if (byteArray.length - i17 <= i18) {
                    break;
                }
                int i19 = InfoRecorder.f40921b;
                byte[] bArr2 = new byte[i19];
                System.arraycopy(byteArray, i17, bArr2, 0, i18);
                i17 += i18;
                if (this.f40951i == 0) {
                    int i26 = 0;
                    for (int i27 = 0; i27 < i19 && bArr2[i27] == 0; i27++) {
                        i26++;
                    }
                    if (i26 > i19 / 2) {
                        continue;
                    }
                }
                this.f40951i += i18;
                InfoRecognizer.f40913d.a(Common.calculateVolumn(bArr2, i18));
                int AddData = this.f40945c.AddData(bArr2, i18);
                this.f40947e = AddData;
                if (!this.f40946d && AddData == 2 && this.f40948f == 3) {
                    this.f40946d = true;
                    LogTool.d("speaking start: preAudio size = " + this.f40949g.size());
                    if (!this.f40949g.isEmpty()) {
                        if (!this.f40954l.a(new b((byte[]) this.f40949g.removeFirst(), InnerAudioState.begin))) {
                            InfoRecognizer.f40913d.b(-305);
                            break;
                        }
                    }
                    while (true) {
                        if (this.f40949g.isEmpty()) {
                            break;
                        }
                        if (!this.f40954l.a(new b((byte[]) this.f40949g.removeFirst(), InnerAudioState.middle))) {
                            InfoRecognizer.f40913d.b(-305);
                            break;
                        }
                    }
                }
                if (this.f40946d) {
                    if (this.f40947e == 3 && this.f40948f == 2) {
                        if (!InfoRecognizer.f40915f) {
                            InfoRecognizer.f40913d.a(VoiceRecordState.Complete);
                        }
                        this.f40946d = false;
                        LogTool.d("speaking stop");
                        this.f40949g.clear();
                        if (!InfoRecognizer.f40915f) {
                            if (!this.f40954l.a(new b(bArr2, InnerAudioState.stop))) {
                                InfoRecognizer.f40913d.b(-305);
                            } else {
                                this.f40953k = true;
                                return 0;
                            }
                        } else if (!this.f40954l.a(new b(bArr2, InnerAudioState.end))) {
                            InfoRecognizer.f40913d.b(-305);
                            break;
                        }
                    } else if (!this.f40954l.a(new b(bArr2, InnerAudioState.middle))) {
                        InfoRecognizer.f40913d.b(-305);
                        break;
                    }
                }
                this.f40948f = this.f40947e;
                this.f40949g.add(bArr2);
                if (this.f40949g.size() > this.f40950h) {
                    this.f40949g.removeFirst();
                }
            }
            if (z16) {
                InfoRecognizer.f40913d.a(VoiceRecordState.Complete);
                this.f40953k = true;
                boolean z17 = this.f40946d;
                if (!z17) {
                    if (this.f40954l.a(new b(null, InnerAudioState.cancel))) {
                        return 0;
                    }
                    InfoRecognizer.f40913d.b(-305);
                    return -1;
                }
                if (z17) {
                    this.f40946d = false;
                    LogTool.d("speaking stop");
                    byte[] bArr3 = new byte[byteArray.length - i17];
                    System.arraycopy(byteArray, i17, bArr3, 0, byteArray.length - i17);
                    if (this.f40954l.a(new b(bArr3, InnerAudioState.stop))) {
                        return 0;
                    }
                    InfoRecognizer.f40913d.b(-305);
                    return -1;
                }
            }
        } else {
            i17 = 0;
        }
        if (!InfoRecognizer.f40918i) {
            int i28 = InfoRecorder.f40921b;
            while (true) {
                if (byteArray.length - i17 <= i28) {
                    break;
                }
                byte[] bArr4 = new byte[InfoRecorder.f40921b];
                System.arraycopy(byteArray, i17, bArr4, 0, i28);
                i17 += i28;
                this.f40951i += i28;
                InfoRecognizer.f40913d.a(Common.calculateVolumn(bArr4, i28));
                b bVar = new b(bArr4, this.f40952j ? InnerAudioState.begin : InnerAudioState.middle);
                this.f40952j = false;
                if (!this.f40954l.a(bVar)) {
                    InfoRecognizer.f40913d.b(-305);
                    break;
                }
            }
            if (z16) {
                InfoRecognizer.f40913d.a(VoiceRecordState.Complete);
                this.f40953k = true;
                byte[] bArr5 = new byte[byteArray.length - i17];
                System.arraycopy(byteArray, i17, bArr5, 0, byteArray.length - i17);
                if (!this.f40954l.a(new b(bArr5, InnerAudioState.stop))) {
                    InfoRecognizer.f40913d.b(-305);
                    return -1;
                }
            }
        }
        this.f40944b.reset();
        this.f40944b.write(byteArray, i17, byteArray.length - i17);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(int i3) {
        InfoRecorder.f40922c = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(boolean z16) {
        InfoRecognizer.f40915f = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(SDKVersion sDKVersion) {
        return this.f40955m.a(sDKVersion);
    }
}
