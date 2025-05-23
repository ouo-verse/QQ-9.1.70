package com.tencent.av.ui.funchat.record;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f75850a;

    /* renamed from: b, reason: collision with root package name */
    private int f75851b;

    /* renamed from: c, reason: collision with root package name */
    private int f75852c;

    /* renamed from: d, reason: collision with root package name */
    private int f75853d;

    /* renamed from: e, reason: collision with root package name */
    private int f75854e;

    /* renamed from: f, reason: collision with root package name */
    private int f75855f;

    /* renamed from: g, reason: collision with root package name */
    private String f75856g;

    /* renamed from: h, reason: collision with root package name */
    private BufferedOutputStream f75857h;

    /* renamed from: i, reason: collision with root package name */
    private MediaExtractor f75858i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec f75859j;

    /* renamed from: k, reason: collision with root package name */
    private MediaFormat f75860k;

    /* renamed from: l, reason: collision with root package name */
    private MediaCodec.BufferInfo f75861l = new MediaCodec.BufferInfo();

    /* renamed from: m, reason: collision with root package name */
    private boolean f75862m;

    /* renamed from: n, reason: collision with root package name */
    private InterfaceC0762a f75863n;

    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.funchat.record.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0762a {
        void onError(int i3);

        void onFinish(String str);

        void onStart(String str);
    }

    public a(int i3, int i16, int i17) {
        this.f75850a = i3;
        this.f75851b = i16;
        this.f75852c = i17;
    }

    private void b() {
        ByteBuffer[] inputBuffers = this.f75859j.getInputBuffers();
        while (true) {
            int dequeueInputBuffer = this.f75859j.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                int readSampleData = this.f75858i.readSampleData(byteBuffer, 0);
                if (readSampleData < 0) {
                    this.f75862m = true;
                    this.f75859j.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 0);
                    break;
                } else {
                    this.f75859j.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, 0L, 0);
                    this.f75858i.advance();
                }
            } else if (dequeueInputBuffer == -1) {
                break;
            }
        }
        ByteBuffer[] outputBuffers = this.f75859j.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f75859j.dequeueOutputBuffer(this.f75861l, 10000L);
            if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                byte[] bArr = new byte[this.f75861l.size];
                byteBuffer2.get(bArr);
                byteBuffer2.clear();
                this.f75859j.releaseOutputBuffer(dequeueOutputBuffer, false);
                e(bArr);
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f75859j.getOutputFormat();
                if (QLog.isColorLevel()) {
                    QLog.d("AudioFileDecoder", 2, "encoder output format changed: " + outputFormat);
                }
            } else {
                return;
            }
        }
    }

    private void c() {
        MediaCodec mediaCodec = this.f75859j;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f75859j.release();
            this.f75859j = null;
        }
        MediaExtractor mediaExtractor = this.f75858i;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.f75858i = null;
        }
        try {
            BufferedOutputStream bufferedOutputStream = this.f75857h;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
                this.f75857h.close();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioFileDecoder", 2, String.format("decode successful, save to %s, size: %sK", this.f75856g, Long.valueOf(new File(this.f75856g).length() / 1024)));
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private void e(byte[] bArr) {
        int i3;
        int i16;
        int i17;
        if (bArr != null && bArr.length != 0 && (i3 = this.f75853d) != 0 && (i16 = this.f75854e) != 0 && (i17 = this.f75855f) != 0) {
            byte[] a16 = c.a(bArr, i3, i16, i17, this.f75850a, this.f75851b, this.f75852c);
            try {
                this.f75857h.write(a16, 0, a16.length);
            } catch (IOException e16) {
                QLog.e("AudioFileDecoder", 1, "writeFile exception", e16);
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        r9.f75860k = r5;
        r9.f75858i.selectTrack(r0);
        r0 = android.media.MediaCodec.createDecoderByType(r6);
        r9.f75859j = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0067, code lost:
    
        r0.configure(r5, (android.view.Surface) null, (android.media.MediaCrypto) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x006b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x006c, code lost:
    
        r5 = r9.f75863n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x006e, code lost:
    
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0070, code lost:
    
        r5.onError(-5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0074, code lost:
    
        com.tencent.qphone.base.util.QLog.e("AudioFileDecoder", 1, "decode configure exception:" + r0, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2) {
        InterfaceC0762a interfaceC0762a;
        this.f75856g = str2;
        File file = new File(str);
        boolean z16 = false;
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioFileDecoder", 2, String.format("audio file %s is not exist", str));
            }
            InterfaceC0762a interfaceC0762a2 = this.f75863n;
            if (interfaceC0762a2 != null) {
                interfaceC0762a2.onError(-2);
                return;
            }
            return;
        }
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f75858i = mediaExtractor;
            mediaExtractor.setDataSource(str);
            int i3 = 0;
            while (true) {
                if (i3 >= this.f75858i.getTrackCount()) {
                    break;
                }
                MediaFormat trackFormat = this.f75858i.getTrackFormat(i3);
                String string = trackFormat.getString("mime");
                if (string.startsWith("audio")) {
                    break;
                } else {
                    i3++;
                }
            }
            if (this.f75859j == null) {
                QLog.e("AudioFileDecoder", 1, "init audioCodec fail");
                InterfaceC0762a interfaceC0762a3 = this.f75863n;
                if (interfaceC0762a3 != null) {
                    interfaceC0762a3.onError(-1);
                    return;
                }
                return;
            }
            this.f75853d = this.f75860k.getInteger("sample-rate");
            this.f75855f = this.f75860k.getInteger("channel-count");
            this.f75854e = 16;
            if (QLog.isColorLevel()) {
                QLog.d("AudioFileDecoder", 2, String.format("decode audio sampleRate: %s, channelCount: %s, bitDeepth: %s", Integer.valueOf(this.f75853d), Integer.valueOf(this.f75855f), Integer.valueOf(this.f75854e)));
            }
            try {
                this.f75857h = new BufferedOutputStream(new FileOutputStream(this.f75856g));
            } catch (IOException e16) {
                QLog.e("AudioFileDecoder", 1, "decode io exception:" + e16, e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioFileDecoder", 2, String.format("start decode file %s, size: %sK", str, Long.valueOf(file.length() / 1024)));
            }
            try {
                this.f75859j.start();
                InterfaceC0762a interfaceC0762a4 = this.f75863n;
                if (interfaceC0762a4 != null) {
                    interfaceC0762a4.onStart(str);
                }
                this.f75862m = false;
                while (!this.f75862m) {
                    try {
                        b();
                    } catch (Throwable th5) {
                        QLog.e("AudioFileDecoder", 1, "decode frame exception:" + th5, th5);
                        if (this.f75863n != null) {
                            this.f75863n.onError(-6);
                        }
                    }
                }
                z16 = true;
                c();
                if (z16 && (interfaceC0762a = this.f75863n) != null) {
                    interfaceC0762a.onFinish(this.f75856g);
                }
            } catch (Exception e17) {
                QLog.e("AudioFileDecoder", 1, "decode start exception:" + e17, e17);
                InterfaceC0762a interfaceC0762a5 = this.f75863n;
                if (interfaceC0762a5 != null) {
                    interfaceC0762a5.onError(-4);
                }
            }
        } catch (IOException e18) {
            e18.printStackTrace();
            InterfaceC0762a interfaceC0762a6 = this.f75863n;
            if (interfaceC0762a6 != null) {
                interfaceC0762a6.onError(-3);
            }
        }
    }

    public void d(InterfaceC0762a interfaceC0762a) {
        this.f75863n = interfaceC0762a;
    }
}
