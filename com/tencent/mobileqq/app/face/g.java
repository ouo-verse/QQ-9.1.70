package com.tencent.mobileqq.app.face;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.h;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.core.a;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g extends com.tencent.qqnt.avatar.core.a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a extends com.tencent.qqnt.avatar.layer.d<Drawable> {
        static IPatchRedirector $redirector_;

        public a(@NonNull com.tencent.qqnt.avatar.bean.a aVar, Drawable drawable, @Nullable com.tencent.qqnt.avatar.layer.c cVar, @Nullable com.tencent.qqnt.avatar.meta.info.a[] aVarArr) {
            super(aVar, drawable, cVar, aVarArr);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, drawable, cVar, aVarArr);
            }
        }
    }

    public g() {
        super(4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private com.tencent.qqnt.avatar.meta.info.a k(com.tencent.mobileqq.proavatar.a aVar, h hVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("bigUrl", hVar.f195585l);
        return new com.tencent.qqnt.avatar.meta.info.a(aVar.d(), hVar.f195584k, 0L, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(com.tencent.qqnt.avatar.bean.a aVar) {
        QLog.i("DynamicDrawableResourceFetcher", 1, aVar.d() + " cancel load");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(com.tencent.qqnt.avatar.bean.a aVar) {
        QLog.i("DynamicDrawableResourceFetcher", 1, aVar.d() + " cancel load");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(com.tencent.qqnt.avatar.bean.a aVar) {
        QLog.i("DynamicDrawableResourceFetcher", 1, aVar.d() + " cancel load");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(final h hVar, com.tencent.mobileqq.proavatar.a aVar, com.tencent.qqnt.avatar.bean.a aVar2, a.InterfaceC9507a interfaceC9507a, int i3, Drawable drawable, String str) {
        boolean z16 = true;
        if (i3 == 1) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.face.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.this.b(true, null);
                }
            }, 16, null, false, 12000L);
            return;
        }
        QLog.d("DynamicDrawableResourceFetcher", 2, "onResult code: " + i3 + ", result: " + drawable + ", msg: " + str);
        a aVar3 = null;
        if (drawable != null) {
            aVar3 = new a(aVar2, drawable, null, new com.tencent.qqnt.avatar.meta.info.a[]{k(aVar, hVar)});
        }
        if (aVar3 == null) {
            z16 = false;
        }
        interfaceC9507a.a(new com.tencent.qqnt.avatar.fetch.d(aVar2, z16, aVar3, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(com.tencent.qqnt.avatar.bean.a aVar, h hVar) {
        QLog.i("DynamicDrawableResourceFetcher", 1, aVar.d() + " cancel load");
        hVar.j(null);
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @NonNull
    public com.tencent.qqnt.avatar.fetch.b a(@NonNull Context context, @NonNull final com.tencent.qqnt.avatar.bean.a aVar, @NonNull final a.InterfaceC9507a interfaceC9507a, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.fetch.b) iPatchRedirector.redirect((short) 2, this, context, aVar, interfaceC9507a, Boolean.valueOf(z16));
        }
        if (!((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).isEnableMp4Avatar()) {
            interfaceC9507a.a(new com.tencent.qqnt.avatar.fetch.d(aVar, false, null, "forbid mp4 avatar"));
            return new com.tencent.qqnt.avatar.fetch.b() { // from class: com.tencent.mobileqq.app.face.a
                @Override // com.tencent.qqnt.avatar.fetch.b
                public final void cancel() {
                    g.l(com.tencent.qqnt.avatar.bean.a.this);
                }
            };
        }
        if (!(aVar instanceof com.tencent.mobileqq.proavatar.a)) {
            interfaceC9507a.a(new com.tencent.qqnt.avatar.fetch.d(aVar, false, null, "baseAvatarBean is wrong"));
            return new com.tencent.qqnt.avatar.fetch.b() { // from class: com.tencent.mobileqq.app.face.b
                @Override // com.tencent.qqnt.avatar.fetch.b
                public final void cancel() {
                    g.m(com.tencent.qqnt.avatar.bean.a.this);
                }
            };
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            interfaceC9507a.a(new com.tencent.qqnt.avatar.fetch.d(aVar, false, null, "get AppInterface null"));
            return new com.tencent.qqnt.avatar.fetch.b() { // from class: com.tencent.mobileqq.app.face.c
                @Override // com.tencent.qqnt.avatar.fetch.b
                public final void cancel() {
                    g.n(com.tencent.qqnt.avatar.bean.a.this);
                }
            };
        }
        final com.tencent.mobileqq.proavatar.a aVar2 = (com.tencent.mobileqq.proavatar.a) aVar;
        int f16 = aVar2.f();
        final h hVar = new h();
        hVar.c((AppInterface) peekAppRuntime, new ColorDrawable(0), aVar.a(), 200, aVar.c(), aVar.e(), 3, true, f16, z16, false, false, null, false);
        hVar.f195594u = new WeakReference<>(hVar);
        hVar.j(new h.a() { // from class: com.tencent.mobileqq.app.face.d
            @Override // com.tencent.mobileqq.app.face.h.a
            public final void a(int i3, Drawable drawable, String str) {
                g.this.p(hVar, aVar2, aVar, interfaceC9507a, i3, drawable, str);
            }
        });
        hVar.b(true, null);
        return new com.tencent.qqnt.avatar.fetch.b() { // from class: com.tencent.mobileqq.app.face.e
            @Override // com.tencent.qqnt.avatar.fetch.b
            public final void cancel() {
                g.q(com.tencent.qqnt.avatar.bean.a.this, hVar);
            }
        };
    }

    @Override // com.tencent.qqnt.avatar.core.a
    @Nullable
    public com.tencent.qqnt.avatar.fetch.d c(@NonNull com.tencent.qqnt.avatar.bean.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.fetch.d) iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16));
        }
        return null;
    }
}
