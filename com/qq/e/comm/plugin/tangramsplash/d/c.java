package com.qq.e.comm.plugin.tangramsplash.d;

import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<com.qq.e.comm.plugin.tangramsplash.f> f39868a;

    /* renamed from: b, reason: collision with root package name */
    private r f39869b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39870c;

    public c(com.qq.e.comm.plugin.tangramsplash.f fVar, r rVar, boolean z16) {
        this.f39868a = new WeakReference<>(fVar);
        this.f39869b = rVar;
        this.f39870c = z16;
    }

    private void a() {
        ADListener a16;
        WeakReference<com.qq.e.comm.plugin.tangramsplash.f> weakReference = this.f39868a;
        com.qq.e.comm.plugin.tangramsplash.f fVar = weakReference != null ? weakReference.get() : null;
        if (fVar == null) {
            GDTLogger.e("splashAdView is null in splashClickListener");
            return;
        }
        fVar.t();
        if (SDKStatus.getSDKVersionCode() >= 360 && (a16 = fVar.a()) != null) {
            a16.onADEvent(new ADEvent(10));
        }
        fVar.f(15);
        fVar.g();
    }

    private void b() {
        WeakReference<com.qq.e.comm.plugin.tangramsplash.f> weakReference = this.f39868a;
        if (weakReference != null && weakReference.get() != null) {
            com.qq.e.comm.plugin.tangramsplash.f fVar = this.f39868a.get();
            if (fVar != null && fVar.m()) {
                fVar.p();
                fVar.n();
                fVar.o();
                fVar.e(true);
                return;
            }
            return;
        }
        GDTLogger.e("splashAdView is null in splashClickListener");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        WeakReference<com.qq.e.comm.plugin.tangramsplash.f> weakReference = this.f39868a;
        if (weakReference != null && weakReference.get() != null && view != null) {
            com.qq.e.comm.plugin.tangramsplash.f fVar = this.f39868a.get();
            if (fVar != null) {
                if (view.getId() == 7) {
                    fVar.q();
                }
                if (view.getId() != 7 && view.getId() != 15 && view.getId() != 16) {
                    if (view.getId() == 2) {
                        a(view);
                        if (SDKStatus.getSDKVersionCode() >= 390 && this.f39869b.cc() && com.qq.e.comm.plugin.tangramsplash.video.d.b() && fVar.m()) {
                            b();
                        } else {
                            fVar.e(view.getId());
                            fVar.g();
                        }
                    } else if (view.getId() != 17 && view.getId() != 22) {
                        if (view.getId() == 18) {
                            a();
                        } else if ((this.f39869b.bJ() != null && this.f39869b.bJ().h() > 1 && this.f39869b.bJ().n() != com.qq.e.comm.plugin.tangramsplash.interactive.a.H && this.f39869b.bJ().n() != com.qq.e.comm.plugin.tangramsplash.interactive.a.J) || this.f39869b.bS()) {
                            b(view);
                        }
                    } else {
                        a(view);
                        fVar.e(view.getId());
                        fVar.g();
                    }
                } else {
                    fVar.h(view);
                }
            }
        } else {
            GDTLogger.e("splashAdView is null in splashClickListener");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void a(View view) {
        WeakReference<com.qq.e.comm.plugin.tangramsplash.f> weakReference = this.f39868a;
        if (weakReference != null && weakReference.get() != null && view != null) {
            com.qq.e.comm.plugin.tangramsplash.f fVar = this.f39868a.get();
            if (fVar == null) {
                return;
            }
            ADListener a16 = fVar.a();
            if (a16 != null) {
                a16.onADEvent(new ADEvent(8));
            }
            GDTLogger.d("splash finish by 'click timer' with normal");
            fVar.g(false);
            if (view.getId() == 2 || view.getId() == 22) {
                fVar.f(11);
                fVar.h(true);
                return;
            }
            return;
        }
        GDTLogger.e("splashAdView is null in splashClickListener");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    private void b(View view) {
        switch (view.getId()) {
            case 9:
                this.f39868a.get().r();
                this.f39868a.get().h(view);
                return;
            case 10:
                if (this.f39869b.bJ().h() == 2) {
                    String s16 = this.f39869b.s();
                    r rVar = this.f39869b;
                    com.qq.e.comm.plugin.tangramsplash.report.c.b(1310348, s16, rVar, rVar.bJ().n(), this.f39870c);
                } else if (this.f39869b.bJ().h() == 3) {
                    String s17 = this.f39869b.s();
                    r rVar2 = this.f39869b;
                    com.qq.e.comm.plugin.tangramsplash.report.c.b(1310353, s17, rVar2, rVar2.bJ().n(), this.f39870c);
                }
                this.f39868a.get().h(view);
                return;
            case 11:
            default:
                this.f39868a.get().h(view);
                return;
            case 12:
                this.f39868a.get().x();
                return;
            case 13:
                return;
        }
    }
}
