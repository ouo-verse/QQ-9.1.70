package com.qq.wx.voice.recognizer;

import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.vad.TRSilk;
import com.qq.wx.voice.vad.TRSilkException;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InnerSender implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f41018a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f41019b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private int f41020c = 2;

    /* renamed from: d, reason: collision with root package name */
    private int f41021d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f41022e = 1800000;

    /* renamed from: f, reason: collision with root package name */
    private a f41023f = null;

    /* renamed from: g, reason: collision with root package name */
    private LinkedList f41024g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    private LinkedList f41025h = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    private InnerHttp f41026i = null;

    /* renamed from: j, reason: collision with root package name */
    private long f41027j = 10000;

    /* renamed from: k, reason: collision with root package name */
    private InnerAudioList f41028k = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        byte[] f41029a;

        /* renamed from: b, reason: collision with root package name */
        int f41030b;

        /* renamed from: c, reason: collision with root package name */
        InnerAudioState f41031c;

        /* renamed from: d, reason: collision with root package name */
        int f41032d;

        a(byte[] bArr, int i3, InnerAudioState innerAudioState, int i16) {
            this.f41029a = null;
            this.f41030b = 0;
            InnerAudioState innerAudioState2 = InnerAudioState.begin;
            this.f41029a = bArr;
            this.f41030b = i3;
            this.f41031c = innerAudioState;
            this.f41032d = i16;
        }
    }

    private synchronized void c() {
        wait(100L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(InnerAudioList innerAudioList) {
        this.f41026i = new InnerHttp();
        this.f41028k = innerAudioList;
        this.f41024g.clear();
        this.f41025h.clear();
        InfoRecognizer.f40982l.reset();
        InfoRecognizer.f40983m.reset();
        this.f41018a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void b() {
        notify();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        TRSilk tRSilk = new TRSilk();
        tRSilk.silkInit();
        this.f41020c = Math.max(this.f41020c, this.f41019b / InfoRecorder.f40988b);
        LogTool.d("mMergeNum = " + this.f41020c);
        long j3 = -1L;
        while (true) {
            if (!this.f41018a) {
                break;
            }
            int i27 = 1;
            int i28 = 0;
            if (!this.f41026i.d() && !this.f41025h.isEmpty()) {
                a aVar = (a) this.f41025h.removeFirst();
                InnerAudioState innerAudioState = aVar.f41031c;
                if (innerAudioState == InnerAudioState.cancel) {
                    VoiceRecognizerResult voiceRecognizerResult = new VoiceRecognizerResult(true);
                    voiceRecognizerResult.isAllEnd = true;
                    InfoRecognizer.f40972b.a(voiceRecognizerResult);
                    this.f41018a = false;
                    break;
                }
                if (innerAudioState == InnerAudioState.begin) {
                    this.f41026i.a();
                    this.f41026i.a(aVar.f41032d);
                }
                if (aVar.f41031c == InnerAudioState.end) {
                    this.f41026i.b(aVar.f41032d);
                    i26 = 1;
                } else {
                    i26 = 0;
                }
                InnerAudioState innerAudioState2 = aVar.f41031c;
                InnerAudioState innerAudioState3 = InnerAudioState.stop;
                if (innerAudioState2 == innerAudioState3) {
                    this.f41026i.b(aVar.f41032d);
                    this.f41026i.c();
                } else {
                    i27 = i26;
                }
                this.f41026i.a(aVar.f41029a, aVar.f41030b, i27);
                long currentTimeMillis = System.currentTimeMillis();
                if (InfoRecognizer.f40984n) {
                    this.f41026i.e();
                } else {
                    new BaseThread(this.f41026i).start();
                }
                if (aVar.f41031c != InnerAudioState.middle) {
                    LogTool.d("offset = " + aVar.f41032d + " state = " + aVar.f41031c);
                }
                if (aVar.f41031c == innerAudioState3) {
                    this.f41018a = false;
                    break;
                }
                j3 = currentTimeMillis;
            } else {
                if (this.f41026i.d() && j3 != -1 && System.currentTimeMillis() - j3 > this.f41027j) {
                    InfoRecognizer.f40972b.b(-201);
                    this.f41018a = false;
                    break;
                }
                if (!this.f41024g.isEmpty()) {
                    if (this.f41024g.size() >= this.f41020c) {
                        i17 = 1;
                    } else {
                        i17 = 0;
                    }
                    int i29 = i17 | 0;
                    if (((a) this.f41024g.getFirst()).f41031c == InnerAudioState.cancel) {
                        i18 = 1;
                    } else {
                        i18 = 0;
                    }
                    int i36 = i29 | i18;
                    if (((a) this.f41024g.getLast()).f41031c == InnerAudioState.end) {
                        i19 = 1;
                    } else {
                        i19 = 0;
                    }
                    int i37 = i36 | i19;
                    if (((a) this.f41024g.getLast()).f41031c != InnerAudioState.stop) {
                        i27 = 0;
                    }
                    i3 = i37 | i27;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    if (((a) this.f41024g.getFirst()).f41031c == InnerAudioState.cancel) {
                        this.f41025h.add((a) this.f41024g.removeFirst());
                    } else {
                        InnerAudioState innerAudioState4 = InnerAudioState.middle;
                        InnerAudioState innerAudioState5 = ((a) this.f41024g.getFirst()).f41031c;
                        InnerAudioState innerAudioState6 = InnerAudioState.begin;
                        if (innerAudioState5 == innerAudioState6) {
                            i16 = ((a) this.f41024g.getFirst()).f41032d;
                        } else {
                            innerAudioState6 = innerAudioState4;
                            i16 = 0;
                        }
                        InnerAudioState innerAudioState7 = ((a) this.f41024g.getLast()).f41031c;
                        InnerAudioState innerAudioState8 = InnerAudioState.end;
                        if (innerAudioState7 == innerAudioState8) {
                            i16 = ((a) this.f41024g.getLast()).f41032d;
                            innerAudioState6 = innerAudioState8;
                        }
                        InnerAudioState innerAudioState9 = ((a) this.f41024g.getLast()).f41031c;
                        InnerAudioState innerAudioState10 = InnerAudioState.stop;
                        if (innerAudioState9 == innerAudioState10) {
                            i16 = ((a) this.f41024g.getLast()).f41032d;
                            innerAudioState6 = innerAudioState10;
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            while (!this.f41024g.isEmpty()) {
                                a aVar2 = (a) this.f41024g.removeFirst();
                                byteArrayOutputStream.write(aVar2.f41029a);
                                i28 += aVar2.f41030b;
                            }
                            byteArrayOutputStream.flush();
                            this.f41025h.add(new a(byteArrayOutputStream.toByteArray(), i28, innerAudioState6, i16));
                            byteArrayOutputStream.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    }
                    a aVar3 = this.f41023f;
                    if (aVar3 != null) {
                        this.f41024g.add(aVar3);
                        this.f41021d += this.f41023f.f41030b;
                        this.f41023f = null;
                    }
                } else {
                    com.qq.wx.voice.recognizer.a b16 = this.f41028k.b();
                    if (b16 != null) {
                        InnerAudioState innerAudioState11 = b16.f41037b;
                        if (innerAudioState11 == InnerAudioState.cancel) {
                            this.f41024g.add(new a(null, 0, innerAudioState11, b16.f41038c));
                        } else {
                            InnerAudioState innerAudioState12 = InnerAudioState.begin;
                            if (innerAudioState11 == innerAudioState12) {
                                tRSilk.silkRelease();
                                tRSilk.silkInit();
                                this.f41021d = 0;
                                this.f41023f = null;
                            }
                            byte[] a16 = a(tRSilk, b16);
                            InnerAudioState innerAudioState13 = b16.f41037b;
                            if (innerAudioState13 == InnerAudioState.middle && this.f41021d >= this.f41022e) {
                                this.f41024g.add(new a(a16, b16.f41036a.length, InnerAudioState.end, b16.f41038c));
                                tRSilk.silkRelease();
                                tRSilk.silkInit();
                                this.f41021d = 0;
                                this.f41023f = new a(a(tRSilk, b16), b16.f41036a.length, innerAudioState12, b16.f41038c);
                                LogTool.d("sentence is force cutted and rebegin");
                            } else {
                                this.f41024g.add(new a(a16, b16.f41036a.length, innerAudioState13, b16.f41038c));
                                this.f41021d += b16.f41036a.length;
                            }
                            try {
                                if (InfoRecognizer.f40977g || InfoRecognizer.f40978h) {
                                    InfoRecognizer.f40982l.write(b16.f41036a);
                                    if (b16.f41037b == innerAudioState12) {
                                        InfoRecognizer.f40982l.reset();
                                    }
                                    InnerAudioState innerAudioState14 = b16.f41037b;
                                    if (innerAudioState14 == InnerAudioState.end || innerAudioState14 == InnerAudioState.stop) {
                                        InfoRecognizer.f40982l.flush();
                                        if (InfoRecognizer.f40978h) {
                                            Common.saveFile(InfoRecognizer.f40982l.toByteArray(), "pcm");
                                        }
                                    }
                                }
                                if (InfoRecognizer.f40977g || InfoRecognizer.f40979i) {
                                    InfoRecognizer.f40983m.write(a16);
                                    if (b16.f41037b == innerAudioState12) {
                                        InfoRecognizer.f40983m.reset();
                                    }
                                    InnerAudioState innerAudioState15 = b16.f41037b;
                                    if (innerAudioState15 == InnerAudioState.end || innerAudioState15 == InnerAudioState.stop) {
                                        InfoRecognizer.f40983m.flush();
                                        if (InfoRecognizer.f40979i) {
                                            Common.saveFile(InfoRecognizer.f40983m.toByteArray(), "Silk");
                                        }
                                    }
                                }
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                    } else {
                        try {
                            c();
                        } catch (InterruptedException e18) {
                            e18.printStackTrace();
                        }
                    }
                }
            }
        }
        tRSilk.silkRelease();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        InnerHttp innerHttp = this.f41026i;
        if (innerHttp != null) {
            innerHttp.b();
        }
        this.f41018a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(byte[] bArr) {
        this.f41026i.a(bArr);
    }

    private static byte[] a(TRSilk tRSilk, com.qq.wx.voice.recognizer.a aVar) {
        byte[] bArr;
        if (!InfoRecognizer.f40981k) {
            return aVar.f41036a;
        }
        try {
            byte[] bArr2 = aVar.f41036a;
            bArr = tRSilk.silkEncode(bArr2, 0, bArr2.length);
        } catch (TRSilkException e16) {
            e16.printStackTrace();
            bArr = null;
        }
        return bArr == null ? new byte[0] : bArr;
    }
}
