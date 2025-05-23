package com.qzone.album.business.albumcomponent;

import android.content.Context;
import android.os.Handler;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.util.d;
import com.qzone.module.Module;
import g4.c;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumComponentModule extends Module<c, g4.b> {

    /* renamed from: a, reason: collision with root package name */
    private c f42057a = new a();

    /* renamed from: b, reason: collision with root package name */
    private g4.b f42058b = new b();

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g4.b getServiceInterface() {
        return this.f42058b;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c getUiInterface() {
        return this.f42057a;
    }

    @Override // com.qzone.module.Proxy
    public String getModuleClassName() {
        return null;
    }

    @Override // com.qzone.module.Module
    public String getName() {
        return "AlbumComponentModule";
    }

    @Override // com.qzone.module.Module
    public int getVersion() {
        return 0;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements g4.b {
        b() {
        }

        @Override // g4.b
        public void a(long j3, Handler handler, String str, int i3, HashMap<String, String> hashMap) {
            com.qzone.album.base.Service.a.W().j1(j3, str, i3, hashMap, new a(handler));
        }

        @Override // g4.b
        public void b(long j3, Handler handler, int i3, HashMap<String, String> hashMap) {
            com.qzone.album.base.Service.a.W().a0(j3, i3, hashMap, new C0310b(handler));
        }

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements AbsCompatRequest.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Handler f42061a;

            a(Handler handler) {
                this.f42061a = handler;
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                sVar.setWhat(999914);
                sVar.sendToHandler(this.f42061a);
            }
        }

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.albumcomponent.AlbumComponentModule$b$b, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0310b implements AbsCompatRequest.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Handler f42063a;

            C0310b(Handler handler) {
                this.f42063a = handler;
            }

            @Override // com.qzone.album.protocol.AbsCompatRequest.a
            public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
                sVar.setWhat(999916);
                sVar.sendToHandler(this.f42063a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements c {
        a() {
        }

        @Override // g4.c
        public void a(Context context) {
            d.b().h(context);
        }

        @Override // g4.c
        public void b(String str, Long l3, String str2) {
            d.g(str, l3.longValue(), str2);
        }

        @Override // g4.c
        public void c() {
            d.b().a();
        }

        @Override // g4.c
        public void destroy() {
        }
    }
}
