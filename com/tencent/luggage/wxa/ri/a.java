package com.tencent.luggage.wxa.ri;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.qi.i;
import com.tencent.luggage.wxa.t9.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends c {

    /* renamed from: j, reason: collision with root package name */
    public r f139753j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec.BufferInfo f139754k;

    /* renamed from: h, reason: collision with root package name */
    public int f139751h = 2;

    /* renamed from: i, reason: collision with root package name */
    public String f139752i = "";

    /* renamed from: l, reason: collision with root package name */
    public final int f139755l = 100;

    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004b  */
    @Override // com.tencent.luggage.wxa.ri.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i3, int i16, int i17) {
        char c16;
        w.d("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        this.f139752i = str;
        try {
            a(i3, i16, i17);
            c16 = 0;
        } catch (IOException e16) {
            w.a("MicroMsg.Record.AACAudioEncoder", e16, "initCodec", new Object[0]);
            c16 = '\uffff';
            if (c16 == '\uffff') {
            }
        } catch (Exception e17) {
            w.a("MicroMsg.Record.AACAudioEncoder", e17, "initCodec", new Object[0]);
            c16 = '\uffff';
            if (c16 == '\uffff') {
            }
        }
        if (c16 == '\uffff') {
            w.d("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
            i.a(21);
            return false;
        }
        w.d("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i16, i3, this.f139751h) == 0) {
            w.d("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            return true;
        }
        w.d("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        i.a(22);
        return false;
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void close() {
        w.d("MicroMsg.Record.AACAudioEncoder", "close");
        r rVar = this.f139753j;
        if (rVar != null) {
            rVar.g();
            this.f139753j.d();
            this.f139753j = null;
        }
        M4aAudioFormatJni.closeM4aFile();
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void flush() {
        w.d("MicroMsg.Record.AACAudioEncoder", HippyQQPagView.FunctionName.FLUSH);
        a(new byte[0], 0, true);
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public boolean a(boolean z16, byte[] bArr, int i3) {
        if (bArr == null) {
            w.b("MicroMsg.Record.AACAudioEncoder", "pcm is null");
            return false;
        }
        if (this.f139753j != null) {
            a(z16, bArr);
            return true;
        }
        w.b("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
        return false;
    }

    public final void a(int i3, int i16, int i17) {
        w.d("MicroMsg.Record.AACAudioEncoder", "initCodec");
        this.f139754k = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.f139757a, i3, i16);
        createAudioFormat.setInteger("bitrate", i17);
        createAudioFormat.setInteger("aac-profile", this.f139751h);
        r b16 = r.b(this.f139757a);
        this.f139753j = b16;
        b16.a(createAudioFormat, null, null, 1);
        this.f139753j.f();
        w.d("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
    }

    public final void a(boolean z16, byte[] bArr) {
        w.d("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", Boolean.valueOf(z16));
        ByteBuffer[] a16 = this.f139753j.a();
        ByteBuffer[] b16 = this.f139753j.b();
        int a17 = this.f139753j.a(100L);
        if (a17 >= 0) {
            ByteBuffer byteBuffer = a16[a17];
            byteBuffer.clear();
            byteBuffer.put(bArr);
            byteBuffer.position(0);
            byteBuffer.limit(bArr.length);
            w.d("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", Integer.valueOf(a17), Integer.valueOf(bArr.length));
            if (z16) {
                this.f139753j.a(a17, 0, bArr.length, System.nanoTime(), 4);
            } else {
                this.f139753j.a(a17, 0, bArr.length, System.nanoTime(), 0);
            }
        } else {
            w.b("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", Integer.valueOf(a17));
        }
        while (true) {
            int a18 = this.f139753j.a(this.f139754k, 100L);
            if (a18 == -1) {
                w.a("MicroMsg.Record.AACAudioEncoder", "no output available, break");
                return;
            }
            if (a18 == -3) {
                w.b("MicroMsg.Record.AACAudioEncoder", "output buff change");
                b16 = this.f139753j.b();
            } else if (a18 == -2) {
                w.b("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: " + this.f139753j.c());
            } else if (a18 < 0) {
                w.b("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", Integer.valueOf(a18));
            } else {
                w.d("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", Integer.valueOf(a18));
                ByteBuffer byteBuffer2 = b16[a18];
                if (byteBuffer2 != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f139754k;
                    if ((bufferInfo.flags & 2) != 0) {
                        w.b("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i3 = bufferInfo.size;
                        byte[] bArr2 = new byte[i3];
                        byteBuffer2.get(bArr2, 0, i3);
                        a(bArr2, i3);
                    }
                    this.f139753j.a(a18, false);
                    if ((this.f139754k.flags & 4) != 0) {
                        if (!z16) {
                            w.f("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
                            return;
                        } else {
                            w.b("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException("outputBuffer " + a18 + " was null");
                }
            }
        }
    }

    public final boolean a(byte[] bArr, int i3) {
        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr, i3);
        a(bArr, i3, false);
        if (writeAudioBuff == 0) {
            w.d("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
            return true;
        }
        w.d("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
        return false;
    }
}
