package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.a.o;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class g implements TBSOneOnlineService {

    /* renamed from: a, reason: collision with root package name */
    j f375036a;

    /* renamed from: b, reason: collision with root package name */
    private i f375037b;

    public g(i iVar) {
        this.f375037b = iVar;
    }

    @Override // com.tencent.tbs.one.TBSOneOnlineService
    public final void cancelUpdate() {
        com.tencent.tbs.one.impl.a.g.a("[%s] Canceling update", this.f375037b.f375049b);
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.e.g.2
            @Override // java.lang.Runnable
            public final void run() {
                g.a(g.this);
            }
        });
    }

    @Override // com.tencent.tbs.one.TBSOneOnlineService
    public final void update(final Bundle bundle, final TBSOneCallback<Void> tBSOneCallback) {
        String str = this.f375037b.f375049b;
        com.tencent.tbs.one.impl.a.g.a("[%s] [OnlineServiceImpl] Updating", str);
        if (this.f375037b.h()) {
            com.tencent.tbs.one.impl.a.g.a("[%s] No need to update because the last update has not applied", str);
            if (tBSOneCallback != null) {
                tBSOneCallback.onCompleted(null);
                return;
            }
            return;
        }
        o.b(new Runnable() { // from class: com.tencent.tbs.one.impl.e.g.1
            @Override // java.lang.Runnable
            public final void run() {
                g.a(g.this, bundle, tBSOneCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar) {
        this.f375036a = null;
        kVar.a();
    }

    static /* synthetic */ void a(g gVar, Bundle bundle, final TBSOneCallback tBSOneCallback) {
        j jVar = gVar.f375036a;
        if (jVar == null) {
            final i iVar = gVar.f375037b;
            String str = iVar.f375049b;
            final k i3 = iVar.i();
            if (i3 == null) {
                if (tBSOneCallback != null) {
                    tBSOneCallback.onError(502, "Failed to acquire update lock");
                    return;
                }
                return;
            } else {
                if (iVar.h()) {
                    com.tencent.tbs.one.impl.a.g.a("[%s] No need to update because another process has updated", str);
                    if (tBSOneCallback != null) {
                        tBSOneCallback.onCompleted(null);
                    }
                    gVar.a(i3);
                    return;
                }
                File g16 = iVar.g();
                if (!g16.exists()) {
                    com.tencent.tbs.one.impl.a.d.b(g16);
                }
                j jVar2 = new j(iVar, bundle);
                gVar.f375036a = jVar2;
                jVar2.a((m) new com.tencent.tbs.one.impl.common.c<Void>() { // from class: com.tencent.tbs.one.impl.e.g.3
                    @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                    public final /* synthetic */ void a(Object obj) {
                        Void r36 = (Void) obj;
                        File g17 = iVar.g();
                        if (g17.exists()) {
                            com.tencent.tbs.one.impl.a.d.c(g17);
                        }
                        g.this.a(i3);
                        tBSOneCallback.onCompleted(r36);
                    }

                    @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                    public final void a(int i16, int i17) {
                        tBSOneCallback.onProgressChanged(i16, i17);
                    }

                    @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
                    public final void a(int i16, String str2, Throwable th5) {
                        com.tencent.tbs.one.impl.common.d dVar = iVar.f375062o;
                        com.tencent.tbs.one.impl.common.h.b("TBSOneError", i16).g(dVar != null ? dVar.f374824b : -1).a();
                        g.this.a(i3);
                        tBSOneCallback.onError(i16, str2);
                    }
                });
                return;
            }
        }
        jVar.a((m) new com.tencent.tbs.one.impl.common.c<Void>() { // from class: com.tencent.tbs.one.impl.e.g.4
            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
            public final /* synthetic */ void a(Object obj) {
                tBSOneCallback.onCompleted((Void) obj);
            }

            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
            public final void a(int i16, int i17) {
                tBSOneCallback.onProgressChanged(i16, i17);
            }

            @Override // com.tencent.tbs.one.impl.common.c, com.tencent.tbs.one.impl.a.m
            public final void a(int i16, String str2, Throwable th5) {
                tBSOneCallback.onError(i16, str2);
            }
        });
    }

    static /* synthetic */ void a(g gVar) {
        j jVar = gVar.f375036a;
        if (jVar != null) {
            jVar.b();
        }
    }
}
