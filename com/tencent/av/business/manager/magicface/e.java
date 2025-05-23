package com.tencent.av.business.manager.magicface;

import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private MagicfaceBaseDecoder f73375a;

    /* renamed from: b, reason: collision with root package name */
    private SoundPoolUtil f73376b;

    /* renamed from: c, reason: collision with root package name */
    String f73377c;

    /* renamed from: d, reason: collision with root package name */
    String f73378d;

    /* renamed from: e, reason: collision with root package name */
    c f73379e;

    /* renamed from: f, reason: collision with root package name */
    MagicfaceBaseDecoder.b f73380f;

    /* renamed from: g, reason: collision with root package name */
    MagicfaceBaseDecoder.a f73381g;

    /* renamed from: h, reason: collision with root package name */
    MagicfaceBaseDecoder.a f73382h;

    /* renamed from: i, reason: collision with root package name */
    MagicfaceBaseDecoder.a f73383i = new a();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements MagicfaceBaseDecoder.a {
        a() {
        }

        @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
        public void a(long j3, String str) {
            AVCoreLog.printColorLog("AVMagicfacePlayer", "play audio end. id = " + str);
            e eVar = e.this;
            eVar.f(eVar.f73377c);
        }

        @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
        public void b(long j3, String str, int i3) {
            c cVar;
            QLog.w("AVMagicfacePlayer", 1, "onEndMagicPlay, id[" + str + "], reason[" + i3 + "], seq[" + j3 + "]");
            MagicfaceBaseDecoder.a aVar = e.this.f73382h;
            if (aVar != null) {
                aVar.b(j3, str, i3);
            }
            synchronized (e.this) {
                e eVar = e.this;
                String str2 = eVar.f73378d;
                if (str2 != null && (cVar = eVar.f73379e) != null) {
                    eVar.c(j3, str2, cVar, eVar.f73380f, eVar.f73381g);
                }
            }
        }

        @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
        public void c(long j3, String str) {
            AVCoreLog.printColorLog("AVMagicfacePlayer", "play video begin." + str);
            MagicfaceBaseDecoder.a aVar = e.this.f73382h;
            if (aVar != null) {
                aVar.c(j3, str);
            }
        }

        @Override // com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.a
        public void e(long j3, String str, boolean z16) {
            AVCoreLog.printColorLog("AVMagicfacePlayer", "play audio begin. id = " + str + ", repeat = " + z16);
            if (z16) {
                e eVar = e.this;
                eVar.d(eVar.f73377c, 100);
            } else {
                e eVar2 = e.this;
                eVar2.d(eVar2.f73377c, 1);
            }
        }
    }

    public e() {
        a();
    }

    public void a() {
        if (this.f73375a == null) {
            if (ah.r0()) {
                this.f73375a = new d();
                AVCoreLog.printErrorLog("AVMagicfacePlayer", "initDecoder| use [MagicfaceNormalDecoder]");
            } else {
                this.f73375a = new d();
                AVCoreLog.printErrorLog("AVMagicfacePlayer", "initDecoder|use [MagicfaceNormalDecoder]");
            }
        }
    }

    public boolean b() {
        return this.f73375a.f73355d;
    }

    public void c(long j3, String str, c cVar, MagicfaceBaseDecoder.b bVar, MagicfaceBaseDecoder.a aVar) {
        if (this.f73375a.f73355d) {
            synchronized (this) {
                this.f73378d = str;
                this.f73379e = cVar;
                this.f73380f = bVar;
                this.f73381g = aVar;
            }
            this.f73375a.k();
            return;
        }
        QLog.w("AVMagicfacePlayer", 1, "playMagicface, srcPath[" + str + "], seq[" + j3 + "]");
        synchronized (this) {
            this.f73377c = str + "audio" + File.separator + cVar.f73370d.src;
            this.f73382h = aVar;
            this.f73378d = null;
            this.f73379e = null;
            this.f73380f = null;
            this.f73381g = null;
        }
        String str2 = cVar.f73370d.src;
        if (str2 != null && !str2.equals("") && this.f73376b == null) {
            this.f73376b = new SoundPoolUtil();
        }
        this.f73375a.i(str);
        this.f73375a.g(cVar);
        this.f73375a.h(bVar);
        this.f73375a.f(this.f73383i);
        this.f73375a.j();
    }

    public void d(String str, int i3) {
        AVCoreLog.printColorLog("AVMagicfacePlayer", "playSound soundSrc = " + str + ", loop = " + i3);
        SoundPoolUtil soundPoolUtil = this.f73376b;
        if (soundPoolUtil != null) {
            soundPoolUtil.a(str, i3, 0);
        }
    }

    public void e() {
        synchronized (this) {
            this.f73378d = null;
            this.f73379e = null;
            this.f73380f = null;
            this.f73381g = null;
        }
        this.f73375a.k();
    }

    public void f(String str) {
        SoundPoolUtil soundPoolUtil = this.f73376b;
        if (soundPoolUtil != null) {
            soundPoolUtil.d(str);
        }
    }
}
