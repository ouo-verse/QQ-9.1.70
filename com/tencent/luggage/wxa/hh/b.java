package com.tencent.luggage.wxa.hh;

import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.hh.c;
import com.tencent.luggage.wxa.n9.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.n9.a f127183a;

    /* renamed from: b, reason: collision with root package name */
    public Set f127184b = new HashSet();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC6506a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.n9.a.InterfaceC6506a
        public void a() {
            b.this.f127183a.a(null);
            b.this.b();
        }
    }

    public final void c() {
        synchronized (this.f127184b) {
            Iterator it = this.f127184b.iterator();
            while (it.hasNext()) {
                ((c.b) it.next()).onPause();
            }
        }
    }

    public final void e() {
        synchronized (this.f127184b) {
            Iterator it = this.f127184b.iterator();
            while (it.hasNext()) {
                ((c.b) it.next()).onStart();
            }
        }
    }

    public final void f() {
        synchronized (this.f127184b) {
            Iterator it = this.f127184b.iterator();
            while (it.hasNext()) {
                ((c.b) it.next()).onStop();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public void onDestroy() {
        release();
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public g pause() {
        com.tencent.luggage.wxa.n9.a aVar = this.f127183a;
        if (aVar == null) {
            return new g("fail to pause, may be not start", new Object[0]);
        }
        boolean pause = aVar.pause();
        w.d("MicaoMsg.DefaultLuggageVoicePlayer", "pause:%s isOk:%b", Boolean.valueOf(pause));
        if (!pause) {
            w.d("MicaoMsg.DefaultLuggageVoicePlayer", "pause fail");
            return new g("fail to pause, may be not start", new Object[0]);
        }
        c();
        return g.f127194d;
    }

    public final void release() {
        com.tencent.luggage.wxa.n9.a aVar = this.f127183a;
        if (aVar != null) {
            aVar.release();
            this.f127183a = null;
        }
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public g stop() {
        com.tencent.luggage.wxa.n9.a aVar = this.f127183a;
        if (aVar == null) {
            return new g("fail to stop, may be not start", new Object[0]);
        }
        boolean stop = aVar.stop();
        w.d("MicaoMsg.DefaultLuggageVoicePlayer", "stop isOk:%b", Boolean.valueOf(stop));
        if (!stop) {
            w.d("MicaoMsg.DefaultLuggageVoicePlayer", "stop fail");
            return new g("fail to stop, may be not start", new Object[0]);
        }
        this.f127183a.a(null);
        release();
        f();
        return g.f127194d;
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public void a(c.b bVar) {
        synchronized (this.f127184b) {
            this.f127184b.remove(bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public g b(String str) {
        if (w0.c(str)) {
            w.b("MicaoMsg.DefaultLuggageVoicePlayer", "filePath is null");
            return new g("filePath is null", new Object[0]);
        }
        if (!x.d(str)) {
            w.b("MicaoMsg.DefaultLuggageVoicePlayer", "file is not exist");
            return new g("file is not exist", new Object[0]);
        }
        release();
        com.tencent.luggage.wxa.n9.a a16 = com.tencent.luggage.wxa.n9.b.a(str);
        this.f127183a = a16;
        a16.a(new a());
        boolean b16 = this.f127183a.b(str);
        w.d("MicaoMsg.DefaultLuggageVoicePlayer", "play:%s isOk:%b", str, Boolean.valueOf(b16));
        if (!b16) {
            w.d("MicaoMsg.DefaultLuggageVoicePlayer", "play fail");
            return new g("fail to start, may be already start", new Object[0]);
        }
        e();
        return g.f127194d;
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public void b(c.b bVar) {
        synchronized (this.f127184b) {
            this.f127184b.add(bVar);
        }
    }

    public final void b() {
        synchronized (this.f127184b) {
            Iterator it = this.f127184b.iterator();
            while (it.hasNext()) {
                ((c.b) it.next()).b();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public void onBackground() {
    }

    @Override // com.tencent.luggage.wxa.hh.c
    public void onForeground() {
    }
}
