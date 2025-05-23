package com.qzone.video.TVK_SDK.mediaplayer.vodcgi;

import com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a;
import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zo.a;
import zo.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c implements zo.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<WeakReference<a.InterfaceC11704a>> f59963a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f59964b;

        a(int i3) {
            this.f59964b = i3;
        }

        @Override // com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b
        public void b(int i3, int i16, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            if (aVar == null) {
                PlayerUtils.log(5, "VodInfoProcess.java@MediaPlayerMgr", "VideoInfo is null, onFailure() playId = " + i3 + "sdkErrorCode = " + i16);
                return;
            }
            PlayerUtils.log(5, "VodInfoProcess.java@MediaPlayerMgr", "request safe vid = " + aVar.C() + ", onFailure() playId = " + i3 + "sdkErrorCode = " + i16 + " cgiCode = " + aVar.h() + " cgiMsg = " + aVar.j());
            zo.b bVar = new zo.b();
            if (101 == i16 || 102 == i16) {
                bVar.v(aVar.h());
                bVar.o(aVar.j());
                bVar.p(aVar.k());
            } else if (105 == i16) {
                bVar.v(aVar.h());
                bVar.o(aVar.j());
            }
            c.this.e(this.f59964b, i16, bVar, aVar.C());
        }

        @Override // com.qzone.video.TVK_SDK.mediaplayer.vodcgi.b
        public void c(int i3, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
            if (aVar == null) {
                PlayerUtils.log(5, "VodInfoProcess.java@MediaPlayerMgr", "VideoInfo is null, onSuccess() playId = " + i3);
                return;
            }
            PlayerUtils.log(4, "VodInfoProcess.java@MediaPlayerMgr", "request safe vid = " + aVar.C() + ", onSuccess() playId = " + i3);
            c.this.e(this.f59964b, 0, c.this.f(aVar), aVar.C());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zo.b f(com.qzone.video.TVK_SDK.mediaplayer.vodcgi.a aVar) {
        zo.b bVar = new zo.b();
        bVar.l(aVar.u());
        bVar.w(aVar.A());
        bVar.q(aVar.m());
        bVar.n((int) aVar.i());
        bVar.u(aVar.w());
        bVar.s(aVar.t());
        bVar.t(aVar.v());
        bVar.j(aVar.e());
        bVar.k(aVar.g());
        bVar.u(aVar.w());
        bVar.r(aVar.r());
        ArrayList<a.b> q16 = aVar.q();
        if (q16 != null) {
            for (int i3 = 0; i3 < q16.size(); i3++) {
                b.a aVar2 = new b.a();
                aVar2.a(q16.get(i3).e());
                aVar2.b(q16.get(i3).c());
                if (1 == q16.get(i3).f()) {
                    bVar.m(aVar2);
                }
                bVar.a(aVar2);
            }
        }
        return bVar;
    }

    @Override // zo.a
    public synchronized void a(int i3, zo.d dVar) {
        new e(i3, dVar, new a(i3)).i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3, int i16, zo.b bVar, String str) {
        if (i16 == 0) {
            synchronized (this.f59963a) {
                if (this.f59963a.size() > 0) {
                    Iterator<WeakReference<a.InterfaceC11704a>> it = this.f59963a.iterator();
                    while (it.hasNext()) {
                        a.InterfaceC11704a interfaceC11704a = it.next().get();
                        if (interfaceC11704a != null) {
                            interfaceC11704a.b(i3, bVar, str);
                        }
                    }
                }
            }
            return;
        }
        synchronized (this.f59963a) {
            if (this.f59963a.size() > 0) {
                Iterator<WeakReference<a.InterfaceC11704a>> it5 = this.f59963a.iterator();
                while (it5.hasNext()) {
                    a.InterfaceC11704a interfaceC11704a2 = it5.next().get();
                    if (interfaceC11704a2 != null) {
                        interfaceC11704a2.a(i3, i16, bVar, str);
                    }
                }
            }
        }
    }

    @Override // zo.a
    public void b(a.InterfaceC11704a interfaceC11704a) {
        if (interfaceC11704a == null) {
            return;
        }
        synchronized (this.f59963a) {
            Iterator<WeakReference<a.InterfaceC11704a>> it = this.f59963a.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                a.InterfaceC11704a interfaceC11704a2 = it.next().get();
                if (interfaceC11704a2 == null) {
                    it.remove();
                } else if (interfaceC11704a2 == interfaceC11704a) {
                    z16 = true;
                }
            }
            if (!z16) {
                this.f59963a.add(new WeakReference<>(interfaceC11704a));
            }
        }
    }
}
