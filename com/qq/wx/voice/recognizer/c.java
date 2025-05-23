package com.qq.wx.voice.recognizer;

import android.media.AudioRecord;
import com.qq.wx.voice.util.Common;
import com.qq.wx.voice.util.ErrorCode;
import com.qq.wx.voice.util.LogTool;
import com.qq.wx.voice.vad.EVad;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f41056a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f41057b = false;

    /* renamed from: c, reason: collision with root package name */
    private AudioRecord f41058c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f41059d = 16;

    /* renamed from: e, reason: collision with root package name */
    private int f41060e = 2;

    /* renamed from: f, reason: collision with root package name */
    private EVad f41061f = new EVad();

    /* renamed from: g, reason: collision with root package name */
    private InnerAudioList f41062g = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(InnerAudioList innerAudioList) {
        this.f41062g = innerAudioList;
        AudioRecord audioRecord = this.f41058c;
        if (audioRecord != null) {
            audioRecord.release();
            this.f41058c = null;
        }
        try {
            InfoRecorder.f40988b = AudioRecord.getMinBufferSize(InfoRecorder.f40987a, this.f41059d, this.f41060e);
            AudioRecord audioRecord2 = new AudioRecord(1, InfoRecorder.f40987a, this.f41059d, this.f41060e, InfoRecorder.f40988b);
            this.f41058c = audioRecord2;
            if (audioRecord2.getState() != 1) {
                InfoRecognizer.f40972b.b(-301);
                return -1;
            }
            this.f41056a = true;
            this.f41057b = true;
            return 0;
        } catch (Exception e16) {
            InfoRecognizer.f40972b.b(-301);
            e16.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.f41056a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        AudioRecord audioRecord = this.f41058c;
        if (audioRecord != null) {
            audioRecord.release();
            this.f41058c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void d() {
        notify();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0194 A[EDGE_INSN: B:67:0x0194->B:65:0x0194 BREAK  A[LOOP:1: B:59:0x0171->B:66:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021f A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z16;
        InfoRecognizer.f40972b.a(VoiceRecordState.Start);
        AudioRecord audioRecord = this.f41058c;
        if (audioRecord == null) {
            InfoRecognizer.f40972b.b(-302);
            return;
        }
        try {
            AudioMonitor.startRecording(audioRecord);
            InfoRecognizer.f40972b.a(VoiceRecordState.Recording);
            if (this.f41061f.Init(InfoRecorder.f40987a, InfoRecorder.f40989c, InfoRecorder.f40991e, InfoRecorder.f40992f, InfoRecorder.f40993g) != 0) {
                InfoRecognizer.f40972b.b(-304);
                return;
            }
            LinkedList linkedList = new LinkedList();
            int i3 = InfoRecorder.f40994h / InfoRecorder.f40988b;
            LogTool.d("preAudioMax = " + i3);
            int i16 = 1;
            int i17 = 0;
            boolean z17 = true;
            int i18 = 0;
            boolean z18 = false;
            int i19 = 3;
            while (true) {
                if (!this.f41056a) {
                    break;
                }
                int i26 = InfoRecorder.f40988b;
                byte[] bArr = new byte[i26];
                int read = this.f41058c.read(bArr, i17, i26);
                if (read == -3) {
                    InfoRecognizer.f40972b.b(10131);
                    break;
                }
                if (read == -2) {
                    InfoRecognizer.f40972b.b(10132);
                    break;
                }
                if (read != InfoRecorder.f40988b) {
                    InfoRecognizer.f40972b.b(-303);
                    break;
                }
                i18 += read;
                if (InfoRecorder.f40990d > 0) {
                    LogTool.d("timeOffset = " + i18 + " timeOut = " + (((InfoRecorder.f40987a << i16) * InfoRecorder.f40990d) / 1000));
                    if (z17) {
                        z16 = z17;
                        if (i18 > ((InfoRecorder.f40987a << i16) * InfoRecorder.f40990d) / 1000) {
                            InfoRecognizer.f40972b.b(ErrorCode.WX_VOICE_RECORD_ERROR_TIME_OUT);
                            break;
                        }
                        InfoRecognizer.f40972b.a(Common.calculateVolumn(bArr, read));
                        if (!this.f41057b) {
                            InfoRecognizer.f40972b.a(VoiceRecordState.Complete);
                            if (!z18) {
                                a aVar = new a(null, InnerAudioState.cancel);
                                aVar.f41038c = i18;
                                if (!this.f41062g.a(aVar)) {
                                    InfoRecognizer.f40972b.b(-305);
                                }
                            } else if (z18) {
                                LogTool.d("speaking stop");
                                a aVar2 = new a(bArr, InnerAudioState.stop);
                                aVar2.f41038c = i18;
                                if (!this.f41062g.a(aVar2)) {
                                    InfoRecognizer.f40972b.b(-305);
                                }
                            }
                        }
                        int AddData = this.f41061f.AddData(bArr, read);
                        if (!z18 && AddData == 2 && i19 == 3) {
                            LogTool.d("speaking start: preAudio size = " + linkedList.size());
                            if (!linkedList.isEmpty()) {
                                a aVar3 = new a((byte[]) linkedList.removeFirst(), InnerAudioState.begin);
                                aVar3.f41038c = i18;
                                if (!this.f41062g.a(aVar3)) {
                                    InfoRecognizer.f40972b.b(-305);
                                    break;
                                }
                            }
                            while (true) {
                                if (!linkedList.isEmpty()) {
                                    break;
                                }
                                a aVar4 = new a((byte[]) linkedList.removeFirst(), InnerAudioState.middle);
                                aVar4.f41038c = i18;
                                if (!this.f41062g.a(aVar4)) {
                                    InfoRecognizer.f40972b.b(-305);
                                    break;
                                }
                            }
                            z18 = true;
                            z16 = false;
                        }
                        if (z18) {
                            if (AddData == 3 && i19 == 2) {
                                if (!InfoRecognizer.f40976f) {
                                    InfoRecognizer.f40972b.a(VoiceRecordState.Complete);
                                }
                                LogTool.d("speaking stop");
                                linkedList.clear();
                                if (!InfoRecognizer.f40976f) {
                                    a aVar5 = new a(bArr, InnerAudioState.stop);
                                    aVar5.f41038c = i18;
                                    if (!this.f41062g.a(aVar5)) {
                                        InfoRecognizer.f40972b.b(-305);
                                    }
                                } else {
                                    a aVar6 = new a(bArr, InnerAudioState.end);
                                    aVar6.f41038c = i18;
                                    if (!this.f41062g.a(aVar6)) {
                                        InfoRecognizer.f40972b.b(-305);
                                        break;
                                    }
                                    z18 = false;
                                }
                            } else {
                                a aVar7 = new a(bArr, InnerAudioState.middle);
                                aVar7.f41038c = i18;
                                if (!this.f41062g.a(aVar7)) {
                                    InfoRecognizer.f40972b.b(-305);
                                    break;
                                }
                            }
                        }
                        linkedList.add(bArr);
                        if (linkedList.size() <= i3) {
                            linkedList.removeFirst();
                        }
                        i19 = AddData;
                        z17 = z16;
                        i16 = 1;
                        i17 = 0;
                    }
                }
                z16 = z17;
                InfoRecognizer.f40972b.a(Common.calculateVolumn(bArr, read));
                if (!this.f41057b) {
                }
                int AddData2 = this.f41061f.AddData(bArr, read);
                if (!z18) {
                    LogTool.d("speaking start: preAudio size = " + linkedList.size());
                    if (!linkedList.isEmpty()) {
                    }
                    while (true) {
                        if (!linkedList.isEmpty()) {
                        }
                    }
                    z18 = true;
                    z16 = false;
                }
                if (z18) {
                }
                linkedList.add(bArr);
                if (linkedList.size() <= i3) {
                }
                i19 = AddData2;
                z17 = z16;
                i16 = 1;
                i17 = 0;
            }
            this.f41061f.Release();
            try {
                this.f41058c.stop();
                this.f41058c.release();
                this.f41058c = null;
            } catch (IllegalStateException unused) {
                InfoRecognizer.f40972b.b(-306);
            }
        } catch (IllegalStateException unused2) {
            InfoRecognizer.f40972b.b(-302);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.f41057b = false;
    }
}
