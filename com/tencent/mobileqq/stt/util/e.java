package com.tencent.mobileqq.stt.util;

import android.content.Context;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.mobileqq.stt.util.d;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
class e extends OutputStream implements d.a {
    static IPatchRedirector $redirector_;
    private final byte[] C;
    private int D;
    private int E;
    private int F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private final d f290881d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f290882e;

    /* renamed from: f, reason: collision with root package name */
    private final String f290883f;

    /* renamed from: h, reason: collision with root package name */
    private final OutputStream f290884h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.qqaudio.audioprocessor.b f290885i;

    /* renamed from: m, reason: collision with root package name */
    a f290886m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onComplete(int i3, int i16);
    }

    public e(@NonNull Context context, @NonNull String str, @NonNull FileOutputStream fileOutputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, fileOutputStream);
            return;
        }
        this.f290881d = new d();
        this.C = new byte[2048];
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.f290882e = context;
        this.f290883f = str;
        this.f290884h = fileOutputStream;
    }

    private void d() throws IOException {
        a();
        int i3 = this.D;
        if (i3 == 0) {
            return;
        }
        this.F += i3;
        c.a a16 = this.f290885i.a(this.C, 0, i3);
        this.D = 0;
        if (a16 != null && a16.f262210c != null && a16.f262208a > 0) {
            if (this.G == 0) {
                byte[] a17 = RecordParams.a(1, this.E);
                this.f290884h.write(a17, 0, a17.length);
            }
            int i16 = this.G;
            int i17 = a16.f262208a;
            this.G = i16 + i17;
            this.f290884h.write(a16.f262210c, a16.f262209b, i17);
        }
    }

    void a() throws IOException {
        if (this.f290885i == null) {
            int k3 = this.f290881d.k();
            this.E = k3;
            if (k3 != 0) {
                com.tencent.mobileqq.qqaudio.audioprocessor.b bVar = new com.tencent.mobileqq.qqaudio.audioprocessor.b();
                this.f290885i = bVar;
                bVar.c(new SilkCodecWrapper(this.f290882e));
                this.f290885i.b(this.E, 16000, 1);
                return;
            }
            throw new IOException("sample rate is 0");
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.close();
        d();
        this.f290884h.close();
        this.f290885i.release();
        if (QLog.isColorLevel()) {
            QLog.i("SilkOutputStream", 2, "SilkOutputStream, SUCCESS, sample-rate=" + this.E + ", input-size=" + this.F + ", output-size=" + this.G);
        }
    }

    public MediaFormat e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MediaFormat) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f290881d.g();
    }

    public void f(@NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f290886m = aVar;
            this.f290881d.n(this.f290883f, this, this);
        }
    }

    @Override // com.tencent.mobileqq.stt.util.d.a
    public void onComplete(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.f290886m.onComplete(i3, this.f290881d.h());
        }
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        byte[] bArr = this.C;
        int i16 = this.D;
        int i17 = i16 + 1;
        this.D = i17;
        bArr[i16] = (byte) i3;
        if (i17 >= bArr.length) {
            d();
        }
    }
}
