package com.tencent.luggage.wxa.ri;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.qi.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends c {

    /* renamed from: i, reason: collision with root package name */
    public byte[] f139765i;

    /* renamed from: j, reason: collision with root package name */
    public OutputStream f139766j;

    /* renamed from: h, reason: collision with root package name */
    public String f139764h = "";

    /* renamed from: k, reason: collision with root package name */
    public int f139767k = 2;

    @Override // com.tencent.luggage.wxa.ri.d
    public boolean a(String str, int i3, int i16, int i17) {
        w.d("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        this.f139764h = str;
        this.f139767k = i16;
        int init = Mp3EncodeJni.init(i3, i16, i3, i17 / 1000, 5);
        w.d("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", Integer.valueOf(init));
        if (init == -1) {
            i.a(17);
            return false;
        }
        w.d("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", Integer.valueOf(Mp3EncodeJni.getVersion()));
        try {
            this.f139766j = x.o(str);
            return true;
        } catch (FileNotFoundException e16) {
            w.a("MicroMsg.Record.MP3AudioEncoder", e16, "init", new Object[0]);
            i.a(18);
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void close() {
        w.d("MicroMsg.Record.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        OutputStream outputStream = this.f139766j;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e16) {
                w.a("MicroMsg.Record.MP3AudioEncoder", e16, "close", new Object[0]);
                i.a(20);
            }
            this.f139766j = null;
        }
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public void flush() {
        byte[] bArr;
        w.d("MicroMsg.Record.MP3AudioEncoder", HippyQQPagView.FunctionName.FLUSH);
        if (this.f139766j != null && (bArr = this.f139765i) != null) {
            int flush = Mp3EncodeJni.flush(bArr);
            if (flush > 0) {
                try {
                    this.f139766j.write(this.f139765i, 0, flush);
                    a(this.f139765i, flush, true);
                    return;
                } catch (IOException e16) {
                    w.a("MicroMsg.Record.MP3AudioEncoder", e16, "flush write", new Object[0]);
                    i.a(20);
                    return;
                }
            }
            w.b("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", Integer.valueOf(flush));
            return;
        }
        w.b("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
    }

    @Override // com.tencent.luggage.wxa.ri.d
    public boolean a(boolean z16, byte[] bArr, int i3) {
        int i16 = this.f139760d;
        if (i16 <= 0) {
            w.b("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", Integer.valueOf(i16));
            return false;
        }
        if (this.f139766j == null) {
            w.b("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
            return false;
        }
        if (this.f139765i == null) {
            int i17 = (int) ((i16 * r3 * 1.25d) + 7200.0d);
            w.d("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", Integer.valueOf(this.f139767k), Integer.valueOf(this.f139760d), Integer.valueOf(i17));
            this.f139765i = new byte[i17];
        }
        short[] a16 = com.tencent.luggage.wxa.qi.g.a(bArr, i3);
        int encode = Mp3EncodeJni.encode(a16, a16, i3 / 2, this.f139765i);
        w.a("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", Integer.valueOf(i3), Integer.valueOf(a16.length), Integer.valueOf(encode));
        if (encode > 0) {
            w.a("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", Integer.valueOf(encode), Integer.valueOf(i3));
            try {
                this.f139766j.write(this.f139765i, 0, encode);
                a(this.f139765i, encode, false);
                return true;
            } catch (IOException e16) {
                w.a("MicroMsg.Record.MP3AudioEncoder", e16, "encode write", new Object[0]);
                i.a(20);
            }
        } else {
            w.b("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", Integer.valueOf(encode));
        }
        return false;
    }
}
