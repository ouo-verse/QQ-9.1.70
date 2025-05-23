package com.tencent.tedger.reshub;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.api.ResHubParams;
import com.tencent.rdelivery.reshub.api.TargetType;
import com.tencent.rdelivery.reshub.api.f;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.core.j;
import com.tencent.rdelivery.reshub.net.ResHubDefaultDownloadImpl;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import iz3.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ResHubHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile ResHubHelper f375279d;

    /* renamed from: a, reason: collision with root package name */
    private i f375280a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f375281b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<com.tencent.tedgecontext.a> f375282c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements IRReport {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResHubHelper.this);
            }
        }

        @Override // com.tencent.raft.standard.report.IRReport
        public boolean report(BaseEvent baseEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseEvent)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.raft.standard.report.IRReport
        public boolean reportToBeacon(String str, BaseEvent baseEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) baseEvent)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResHubHelper.this);
            }
        }

        @Override // iz3.e, iz3.m
        public void a(@NotNull List<RDeliveryData> list, @NotNull List<RDeliveryData> list2, @NotNull List<RDeliveryData> list3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, list, list2, list3);
                return;
            }
            com.tencent.tedgecontext.a aVar = (com.tencent.tedgecontext.a) ResHubHelper.this.f375282c.get();
            if (aVar != null && aVar.l() != null) {
                aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "getResHub onSuccess " + list2.size());
                ResHubHelper.this.f375281b = true;
            }
        }

        @Override // iz3.m
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.tedgecontext.a aVar = (com.tencent.tedgecontext.a) ResHubHelper.this.f375282c.get();
            if (aVar != null && aVar.l() != null) {
                aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "getResHub onFail " + str);
            }
        }

        @Override // iz3.e
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.tedgecontext.a aVar = (com.tencent.tedgecontext.a) ResHubHelper.this.f375282c.get();
            if (aVar != null && aVar.l() != null) {
                aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "getResHub onSuccess");
            }
            ResHubHelper.this.f375281b = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResHubHelper.this);
            }
        }

        @Override // com.tencent.rdelivery.reshub.api.f
        public boolean a(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.rdelivery.reshub.api.f
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.rdelivery.reshub.api.f
        public void c(@NonNull String str, @NonNull Runnable runnable, @NonNull Runnable runnable2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, runnable, runnable2);
            }
        }
    }

    public ResHubHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375281b = false;
        }
    }

    public static ResHubHelper d() {
        if (f375279d == null) {
            synchronized (ResHubHelper.class) {
                if (f375279d == null) {
                    f375279d = new ResHubHelper();
                }
            }
        }
        return f375279d;
    }

    private ResHubParams e(com.tencent.tedgecontext.a aVar) {
        return new ResHubParams(aVar.b(), aVar.i(), true, aVar.j().a(), true, false, "store", new HashMap(), RDeliverySetting.UpdateStrategy.PERIODIC.getValue() | RDeliverySetting.UpdateStrategy.START_UP.getValue(), TVKEventId.PLAYER_STATE_SWITCHDEF_START, !aVar.r(), Boolean.TRUE);
    }

    public void f(com.tencent.tedgecontext.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f375282c = new WeakReference<>(aVar);
        j jVar = j.L;
        if (jVar.Q()) {
            if (aVar != null && aVar.l() != null) {
                aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "ResHubCenter is already initialized");
            }
            if (this.f375280a != null) {
                return;
            }
            this.f375280a = jVar.a(ShiplyImpl.APP_ID, ShiplyImpl.APP_KEY, TargetType.AndroidApp, TPReportKeys.Common.COMMON_ONLINE, new b(), new c(), null);
            return;
        }
        if (aVar != null && aVar.l() != null) {
            aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "ResHubCenter is not initialized");
        }
    }

    public void g(com.tencent.tedgecontext.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null && aVar.f() != null) {
            if (this.f375280a != null) {
                if (aVar.l() != null) {
                    aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "iResHub is already initialized");
                    return;
                }
                return;
            }
            i g16 = aVar.d().g();
            if (g16 != null) {
                this.f375280a = g16;
                this.f375281b = true;
            } else {
                j jVar = j.L;
                jVar.N(aVar.f(), e(aVar), new ResHubDefaultDownloadImpl(), new com.tencent.rdelivery.dependencyimpl.c(aVar.f()), new a());
                jVar.W(new com.tencent.rdelivery.reshub.core.f());
                jVar.Y(new com.tencent.rdelivery.dependencyimpl.e());
            }
        }
    }

    public void h(com.tencent.tedgecontext.a aVar, String str, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aVar, str, hVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        i iVar = this.f375280a;
        if (iVar != null && this.f375281b) {
            iVar.j(str, hVar, false);
            return;
        }
        if (!this.f375281b) {
            new Handler().postDelayed(new Runnable(str, hVar) { // from class: com.tencent.tedger.reshub.ResHubHelper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f375283d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ h f375284e;

                {
                    this.f375283d = str;
                    this.f375284e = hVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ResHubHelper.this, str, hVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ResHubHelper.this.f375280a.j(this.f375283d, this.f375284e, false);
                    }
                }
            }, 1000L);
            return;
        }
        if (aVar.l() != null) {
            aVar.l().d("TEdgeResHubHelper", aVar.l().a(), "iResHub is null" + this.f375280a + " isResHubReady " + this.f375281b);
        }
    }
}
