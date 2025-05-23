package com.qq.e.comm.plugin.tangramsplash.interactive.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.h;
import com.qq.e.comm.plugin.k.k;
import com.qq.e.comm.plugin.tangramsplash.interactive.a.d;
import com.qq.e.comm.plugin.tangramsplash.interactive.c;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.widget.cny2025.twist.CNYTwistView;
import com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends d {

    /* renamed from: ah, reason: collision with root package name */
    private CNYTwistView f40172ah;

    /* renamed from: ai, reason: collision with root package name */
    private Bitmap f40173ai;

    /* renamed from: aj, reason: collision with root package name */
    private Bitmap f40174aj;

    /* renamed from: ak, reason: collision with root package name */
    private File f40175ak;

    /* renamed from: al, reason: collision with root package name */
    private volatile boolean f40176al;

    public b(r rVar, c cVar) {
        super(rVar, cVar);
    }

    private void B() {
        String j3;
        String k3;
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            if (!a(this.f40173ai)) {
                GDTLogger.e("AuraIconTwistAd: buildWidget, invalid mLeftIconBitmap: " + this.f40173ai);
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidLeftIconBitmap");
                return;
            }
            if (!a(this.f40174aj)) {
                GDTLogger.e("AuraIconTwistAd: buildWidget, invalid mRightIconBitmap: " + this.f40174aj);
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidRightIconBitmap");
                return;
            }
            CNYTwistView cNYTwistView = new CNYTwistView(GDTADManager.getInstance().getAppContext(), com.qq.e.comm.plugin.j.c.a("auraTwistUseHighRate", 1, 1));
            this.f40172ah = cNYTwistView;
            cNYTwistView.setInteractListener(new ICNYTwistViewListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.b.1
                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onBackInteractProgress(float f16, int i3) {
                    GDTLogger.d("AuraIconTwistAd: onBackInteractProgress, rotation = " + f16 + ", currentProgress = " + i3);
                }

                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onInteractProgress(float f16, int i3) {
                    GDTLogger.d("AuraIconTwistAd: onInteractProgress, rotation = " + f16 + ", currentProgress = " + i3);
                }

                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onInteractResult(boolean z16) {
                    GDTLogger.i("AuraIconTwistAd: onInteractResult, isSuccess = " + z16);
                    if (!z16) {
                        b.this.g();
                    }
                }

                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onInteractStart() {
                    GDTLogger.i("AuraIconTwistAd: onInteractStart");
                    b.this.e();
                    ((d) b.this).f40158ag = true;
                }

                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onInteractSuccessAnimationEnd() {
                    GDTLogger.i("AuraIconTwistAd: onInteractSuccessAnimationEnd");
                    b.this.D();
                    b.this.f40176al = true;
                }

                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onInteractSuccessAnimationStart() {
                    GDTLogger.i("AuraIconTwistAd: onInteractSuccessAnimationStart");
                }

                @Override // com.tencent.ams.fusion.widget.cny2025.twist.ICNYTwistViewListener
                public void onSensorError() {
                    GDTLogger.i("AuraIconTwistAd: onSensorError");
                    b.this.l();
                }
            });
            if (TextUtils.isEmpty(interactiveInfo.j())) {
                j3 = "\u626d\u8f6c\u624b\u673a";
            } else {
                j3 = interactiveInfo.j();
            }
            this.f40172ah.setTitle(j3);
            if (TextUtils.isEmpty(interactiveInfo.k())) {
                k3 = "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
            } else {
                k3 = interactiveInfo.k();
            }
            this.f40172ah.setSubtitle(k3);
            this.f40172ah.setTargetAngle(interactiveInfo.l());
            this.f40172ah.setReverseAngle(interactiveInfo.B());
            this.f40172ah.setIcons(this.f40173ai, this.f40174aj);
            File file = this.f40175ak;
            if (file != null && file.exists()) {
                this.f40172ah.setCollisionApng(file.getAbsolutePath());
                return;
            } else {
                GDTLogger.e("AuraIconTwistAd: buildWidget, invalid apngFile");
                return;
            }
        }
        GDTLogger.e("AuraIconTwistAd: buildWidget, adInfo or interactiveInfo null");
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidParams");
    }

    private void C() {
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.b.2
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.i("AuraIconTwistAd: showWidget, enable = " + z16);
                CNYTwistView cNYTwistView = b.this.f40172ah;
                if (cNYTwistView == null) {
                    GDTLogger.e("AuraIconTwistAd: showWidget, cnyTwistView is null");
                    return;
                }
                if (z16) {
                    b.this.h();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z;
                    if (bVar != null) {
                        try {
                            bVar.a(cNYTwistView, layoutParams);
                            cNYTwistView.start();
                            return;
                        } catch (Throwable th5) {
                            GDTLogger.e("AuraIconTwistAd: showWidget error", th5);
                            return;
                        }
                    }
                    return;
                }
                cNYTwistView.setEnabled(false);
                cNYTwistView.stop();
                cNYTwistView.setVisibility(8);
                b bVar2 = b.this;
                bVar2.a(((d) bVar2).f40158ag);
                GDTLogger.i("AuraIconTwistAd: showWidget, view is not enable");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.f();
                    InteractiveInfo interactiveInfo = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).f40115aa;
                    if (interactiveInfo != null && interactiveInfo.r()) {
                        com.qq.e.comm.plugin.tangramsplash.d.f.a(500L);
                    }
                    com.qq.e.comm.plugin.tangramsplash.interactive.b bVar = ((com.qq.e.comm.plugin.tangramsplash.interactive.a) b.this).Z;
                    if (bVar != null) {
                        bVar.a(true);
                    } else {
                        GDTLogger.e("AuraIconTwistAd: mInteractiveLifeListener is null");
                    }
                } catch (Throwable th5) {
                    GDTLogger.e("AuraIconTwistAd: clickTrigger error", th5);
                }
            }
        });
    }

    private boolean E() {
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (interactiveInfo != null && interactiveInfo.n() == com.qq.e.comm.plugin.tangramsplash.interactive.a.W) {
            return true;
        }
        return false;
    }

    private boolean F() {
        if (this.f40176al && com.qq.e.comm.plugin.j.c.a("forbidPauseResumeOnInteractFinished", 1, 1)) {
            return true;
        }
        return false;
    }

    private void G() {
        try {
            CNYTwistView cNYTwistView = this.f40172ah;
            if (cNYTwistView != null) {
                cNYTwistView.stop();
            }
        } catch (Throwable th5) {
            GDTLogger.e("AuraIconTwistAd:  stopWidget error:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        try {
            G();
            final CNYTwistView cNYTwistView = this.f40172ah;
            if (cNYTwistView != null) {
                cNYTwistView.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.b.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        cNYTwistView.setVisibility(8);
                        cNYTwistView.setInteractListener(null);
                    }
                });
            }
        } catch (Throwable th5) {
            GDTLogger.e("AuraIconTwistAd: clear error:", th5);
        }
        super.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void q() {
        G();
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
        CNYTwistView cNYTwistView = this.f40172ah;
        if (cNYTwistView == null) {
            GDTLogger.e("AuraIconTwistAd: notifyAppEnterBackground, cnyTwistView is null");
            return;
        }
        if (!z16) {
            GDTLogger.i("AuraIconTwistAd: notifyAppEnterBackground, allowBackgroundSensorListen");
        } else if (F()) {
            GDTLogger.i("AuraIconTwistAd: notifyAppEnterBackground, interact had been successful and animation finished, ignore pause interact widget");
        } else {
            cNYTwistView.pause();
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
        CNYTwistView cNYTwistView = this.f40172ah;
        if (cNYTwistView == null) {
            GDTLogger.e("AuraIconTwistAd: notifyAppEnterForeground, cnyTwistView is null");
            return;
        }
        if (!z16) {
            GDTLogger.i("AuraIconTwistAd: notifyAppEnterForeground, allowBackgroundSensorListen");
        } else if (F()) {
            GDTLogger.i("AuraIconTwistAd: notifyAppEnterBackground, interact had been successful and animation finished, ignore resume interact widget");
        } else {
            cNYTwistView.resume();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.d, com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        if (rVar != null && interactiveInfo != null) {
            if (!a(rVar, interactiveInfo)) {
                GDTLogger.e("AuraIconTwistAd: checkNeedShowInteractiveView, icons don't exist, don't show interactive view");
                return false;
            }
            if (E()) {
                GDTLogger.i("AuraIconTwistAd: checkNeedShowInteractiveView, without easter page, just show interactive view");
                return true;
            }
            if (!A()) {
                GDTLogger.i("AuraIconTwistAd: checkNeedShowInteractiveView, easter egg switch is off, just show interactive view");
                c("ignoreByWuji");
                return true;
            }
            File b16 = at.b(rVar.s(), e.d(rVar));
            if (b16 != null && b16.exists()) {
                b(b16.getAbsolutePath());
                c("none");
            } else {
                GDTLogger.e("AuraIconTwistAd:  indexHtmlFile not exist");
                c("invalidEasterEgg");
            }
            return true;
        }
        GDTLogger.e("AuraIconTwistAd: checkNeedShowInteractiveView, adInfo or interactiveInfo is null, don't show interactive view");
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
                GDTLogger.e("AuraIconTwistAd: isMaterialExist, posId is null or empty");
                return false;
            }
            String K = interactiveInfo.K();
            if (TextUtils.isEmpty(K)) {
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidIconZipUrl");
                GDTLogger.e("AuraIconTwistAd: isMaterialExist, iconZipUrl is null or empty");
                return false;
            }
            File a16 = at.a(s16, K);
            if (a16 != null && a16.exists()) {
                File a17 = at.a(3, s16, K);
                if (a17 != null && a17.exists()) {
                    GDTLogger.e("AuraIconTwistAd: isMaterialExist, hasn't finish unzip");
                    com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "iconUnzip");
                    return false;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(a16.getAbsolutePath());
                String str = File.separator;
                sb5.append(str);
                sb5.append("1.png");
                String sb6 = sb5.toString();
                GDTLogger.i("AuraIconTwistAd: isMaterialExist, leftIconPath = " + sb6);
                File file = new File(sb6);
                if (!file.exists()) {
                    GDTLogger.e("AuraIconTwistAd: isMaterialExist, leftIconFile doesn't exist");
                    com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidLeftIcon");
                    return false;
                }
                String str2 = a16.getAbsolutePath() + str + "2.png";
                GDTLogger.i("AuraIconTwistAd: isMaterialExist, rightIconPath = " + str2);
                File file2 = new File(str2);
                if (!file2.exists()) {
                    GDTLogger.e("AuraIconTwistAd: isMaterialExist, rightIconFile doesn't exist");
                    com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidRightIcon");
                    return false;
                }
                this.f40173ai = h.a(file, (ImageView) null);
                this.f40174aj = h.a(file2, (ImageView) null);
                String L = interactiveInfo.L();
                if (TextUtils.isEmpty(L)) {
                    GDTLogger.i("AuraIconTwistAd: isMaterialExist, collisionAnimationUrl from backend is null or empty, ignore check apng");
                    return true;
                }
                File a18 = k.a(1, rVar.s(), L);
                this.f40175ak = a18;
                if (a18 != null && a18.exists()) {
                    return true;
                }
                GDTLogger.e("AuraIconTwistAd: isMaterialExist, invalid apngFile");
                com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidCollisionApng");
                return false;
            }
            GDTLogger.e("AuraIconTwistAd: isMaterialExist, invalid iconsDir");
            com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "iconDirInexist");
            return false;
        }
        GDTLogger.e("AuraIconTwistAd: isMaterialExist, adInfo or interactiveInfo is null");
        com.qq.e.comm.plugin.tangramsplash.report.a.a(d(), "invalidParams");
        return false;
    }

    private boolean a(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }
}
