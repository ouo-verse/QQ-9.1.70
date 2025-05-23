package com.tencent.luggage.wxa.i9;

import android.os.Environment;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import java.io.FileNotFoundException;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: e, reason: collision with root package name */
    public static g f129657e;

    /* renamed from: f, reason: collision with root package name */
    public static Object f129658f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f129659a;

    /* renamed from: b, reason: collision with root package name */
    public String f129660b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f129661c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f129662d = true;

    public g() {
        e();
    }

    public static void a() {
        new v(d()).d();
        c().b();
    }

    public static g c() {
        if (f129657e == null) {
            synchronized (f129658f) {
                if (f129657e == null) {
                    f129657e = new g();
                }
            }
        }
        return f129657e;
    }

    public static String d() {
        v vVar = new v(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (!vVar.e()) {
            vVar.w();
        }
        return vVar + "/mix_audio_pcm.pcm";
    }

    public void b() {
        if (!this.f129661c) {
            return;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.ExportMixAudioPcmFile", "finishProcess");
        try {
            OutputStream outputStream = this.f129659a;
            if (outputStream != null) {
                outputStream.flush();
                this.f129659a.close();
                this.f129659a = null;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.ExportMixAudioPcmFile", e16, "finishProcess", new Object[0]);
        }
        this.f129661c = false;
    }

    public void e() {
        if (this.f129661c) {
            return;
        }
        this.f129661c = true;
        String d16 = d();
        this.f129660b = d16;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", d16);
        new v(this.f129660b).d();
        try {
            this.f129659a = x.b(com.tencent.luggage.wxa.m9.a.c(this.f129660b));
        } catch (FileNotFoundException e16) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.ExportMixAudioPcmFile", e16, "new FileOutputStream", new Object[0]);
        } catch (Exception e17) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.ExportMixAudioPcmFile", e17, "new FileOutputStream", new Object[0]);
        }
    }
}
