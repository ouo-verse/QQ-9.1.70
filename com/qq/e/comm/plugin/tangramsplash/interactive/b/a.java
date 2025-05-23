package com.qq.e.comm.plugin.tangramsplash.interactive.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.cny2025.flip.FrameAnimFlipView;
import com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: ah, reason: collision with root package name */
    private FrameAnimFlipView f40164ah;

    /* renamed from: ai, reason: collision with root package name */
    private String f40165ai;

    /* renamed from: aj, reason: collision with root package name */
    private volatile boolean f40166aj;

    public a(r rVar, c cVar) {
        super(rVar, cVar);
    }

    private void B() {
        String j3;
        String k3;
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            if (TextUtils.isEmpty(interactiveInfo.j())) {
                j3 = "\u7ffb\u8f6c\u624b\u673a";
            } else {
                j3 = interactiveInfo.j();
            }
            if (TextUtils.isEmpty(interactiveInfo.k())) {
                k3 = "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
            } else {
                k3 = interactiveInfo.k();
            }
            int C = interactiveInfo.C();
            int D = interactiveInfo.D();
            int cf5 = rVar.cf();
            GDTLogger.i("AuraIconFlipAd: buildWidget, title = " + j3 + ", desc = " + k3 + ", flipTriggerAngle = " + C + ", flipTriggerBackAngle = " + D + ", componentBeginTime = " + cf5);
            FrameAnimFlipView frameAnimFlipView = new FrameAnimFlipView(GDTADManager.getInstance().getAppContext());
            this.f40164ah = frameAnimFlipView;
            frameAnimFlipView.setTitleText(j3);
            this.f40164ah.setSubTitleText(k3);
            this.f40164ah.setTargetRotationThreshold((float) C);
            this.f40164ah.setReverseRotationThreshold((float) D);
            this.f40164ah.setDelayShowDuration(cf5);
            this.f40164ah.setIconPath(this.f40165ai);
            GDTLogger.i("AuraIconFlipAd: mIconDirPath = " + this.f40165ai);
            this.f40164ah.setInteractiveListener(new IFlipInteractiveListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.a.1
                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onBackInteractProgress(float f16) {
                    GDTLogger.e("AuraIconFlipAd: onBackInteractProgress, angle = " + f16);
                }

                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onInteractProgress(float f16) {
                    GDTLogger.e("onInteractProgress, angle = " + f16);
                }

                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onInteractResult(int i3, boolean z16) {
                    GDTLogger.i("AuraIconFlipAd: onInteractResult, mode = " + i3 + ", isSuccess = " + z16);
                    if (z16) {
                        a.this.D();
                        a.this.f40166aj = true;
                    } else {
                        a.this.g();
                    }
                }

                @Override // com.tencent.ams.fusion.widget.flip.IFlipInteractiveListener
                public void onInteractStart(int i3) {
                    GDTLogger.i("AuraIconFlipAd: onInteractStart, mode = " + i3);
                    a.this.e();
                    ((d) a.this).f40158ag = true;
                }
            });
            return;
        }
        GDTLogger.e("AuraIconFlipAd: buildWidget, adInfo or interactiveInfo null");
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidParams");
    }

    private void C() {
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.a.2
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.i("AuraIconFlipAd: showWidget, enable = " + z16);
                FrameAnimFlipView frameAnimFlipView = a.this.f40164ah;
                if (frameAnimFlipView == null) {
                    GDTLogger.e("AuraIconFlipAd: showWidget, frameAnimFlipView is null");
                    return;
                }
                if (z16) {
                    a.this.h();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(frameAnimFlipView, layoutParams);
                            frameAnimFlipView.start();
                            return;
                        } catch (Throwable th5) {
                            GDTLogger.e("AuraIconFlipAd: showWidget error", th5);
                            com.qq.e.comm.plugin.tangramsplash.report.a.b(a.this.d(), "otherException");
                            return;
                        }
                    }
                    return;
                }
                frameAnimFlipView.setEnabled(false);
                frameAnimFlipView.stop();
                frameAnimFlipView.setVisibility(8);
                a aVar = a.this;
                aVar.a(((d) aVar).f40158ag);
                GDTLogger.i("AuraIconFlipAd: showWidget, view is not enable");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f();
                    InteractiveInfo interactiveInfo = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).f40115aa;
                    if (interactiveInfo != null && interactiveInfo.r()) {
                        com.qq.e.comm.plugin.tangramsplash.d.f.a(500L);
                    }
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) a.this).Z;
                    if (bVar != null) {
                        bVar.a(true);
                    } else {
                        GDTLogger.e("AuraIconFlipAd: mInteractiveLifeListener is null");
                    }
                } catch (Throwable th5) {
                    GDTLogger.e("AuraIconFlipAd: clickTrigger error", th5);
                }
            }
        });
    }

    private boolean E() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && interactiveInfo.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.U) {
            return true;
        }
        return false;
    }

    private boolean F() {
        if (this.f40166aj && com.qq.e.comm.plugin.j.c.a("forbidPauseResumeOnInteractFinished", 1, 1)) {
            return true;
        }
        return false;
    }

    private void G() {
        try {
            FrameAnimFlipView frameAnimFlipView = this.f40164ah;
            if (frameAnimFlipView != null) {
                frameAnimFlipView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("AuraIconFlipAd:  stopWidget error:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        try {
            G();
            final FrameAnimFlipView frameAnimFlipView = this.f40164ah;
            if (frameAnimFlipView != null) {
                frameAnimFlipView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        frameAnimFlipView.setVisibility(8);
                        frameAnimFlipView.setInteractiveListener(null);
                    }
                });
            }
        } catch (Throwable th5) {
            GDTLogger.e("AuraIconFlipAd: clear error:", th5);
        }
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void s() {
        super.s();
        j();
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void w() {
        boolean z16;
        super.w();
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        FrameAnimFlipView frameAnimFlipView = this.f40164ah;
        if (frameAnimFlipView == null) {
            GDTLogger.e("AuraIconFlipAd: notifyAppEnterBackground, frameAnimFlipView is null");
            return;
        }
        if (!z16) {
            GDTLogger.i("AuraIconFlipAd: notifyAppEnterForeground, allowBackgroundSensorListen");
        } else if (F()) {
            GDTLogger.i("AuraIconFlipAd: notifyAppEnterForeground, interact had been successful and animation finished, ignore pause interact widget");
        } else {
            frameAnimFlipView.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void x() {
        boolean z16;
        super.x();
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        FrameAnimFlipView frameAnimFlipView = this.f40164ah;
        if (frameAnimFlipView == null) {
            GDTLogger.e("AuraIconFlipAd: notifyAppEnterForeground, frameAnimFlipView is null");
            return;
        }
        if (!z16) {
            GDTLogger.i("AuraIconFlipAd: notifyAppEnterForeground, allowBackgroundSensorListen");
        } else if (F()) {
            GDTLogger.i("AuraIconFlipAd: notifyAppEnterBackground, interact had been successful and animation finished, ignore resume interact widget");
        } else {
            GDTLogger.i("AuraIconFlipAd: notifyAppEnterForeground, resume");
            frameAnimFlipView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            if (!a(rVar, interactiveInfo)) {
                GDTLogger.e("AuraIconFlipAd: checkNeedShowInteractiveView, icons don't exist, don't show interactive view");
                return false;
            }
            if (E()) {
                GDTLogger.i("AuraIconFlipAd: checkNeedShowInteractiveView, without easter page, just show interactive view");
                c("ignoreByWuji");
                return true;
            }
            if (!A()) {
                GDTLogger.i("AuraIconFlipAd: checkNeedShowInteractiveView, easter egg switch is off, just show interactive view");
                return true;
            }
            File b16 = at.b(rVar.s(), e.d(rVar));
            if (b16 != null && b16.exists()) {
                b(b16.getAbsolutePath());
                c("none");
            } else {
                GDTLogger.e("AuraIconFlipAd:  indexHtmlFile not exist");
                c("invalidEasterEgg");
            }
            return true;
        }
        GDTLogger.e("AuraIconFlipAd: checkNeedShowInteractiveView, adInfo or interactiveInfo is null, don't show interactive view");
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidParams");
        return false;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        B();
        C();
    }

    private boolean a(r rVar, InteractiveInfo interactiveInfo) {
        if (rVar != null && interactiveInfo != null) {
            String s16 = rVar.s();
            if (TextUtils.isEmpty(s16)) {
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidPosId");
                GDTLogger.e("AuraIconFlipAd: isIconsExist, posId is null or empty");
                return false;
            }
            String K = interactiveInfo.K();
            if (TextUtils.isEmpty(K)) {
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidIconZipUrl");
                GDTLogger.e("AuraIconFlipAd: isMaterialExist, iconZipUrl is null or empty");
                return false;
            }
            File a16 = at.a(s16, K);
            if (a16 != null && a16.exists()) {
                File[] listFiles = a16.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    File a17 = at.a(3, s16, K);
                    if (a17 != null && a17.exists()) {
                        GDTLogger.e("AuraIconFlipAd: isMaterialExist, hasn't finish unzip");
                        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "iconUnzip");
                        return false;
                    }
                    this.f40165ai = a16.getAbsolutePath();
                    com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "none");
                    return true;
                }
                GDTLogger.e("AuraIconFlipAd: isMaterialExist, iconsDir is empty");
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "iconDirEmpty");
                return false;
            }
            GDTLogger.e("AuraIconFlipAd: isMaterialExist, invalid iconsDir");
            com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "iconDirInexist");
            return false;
        }
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidParams");
        GDTLogger.e("AuraIconFlipAd: isIconsExist, adInfo or interactiveInfo is null");
        return false;
    }
}
