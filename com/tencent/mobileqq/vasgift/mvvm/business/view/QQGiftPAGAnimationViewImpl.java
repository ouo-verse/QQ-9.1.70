package com.tencent.mobileqq.vasgift.mvvm.business.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.util.VasPadUtils;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.mobileqq.vasgift.utils.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* loaded from: classes20.dex */
public class QQGiftPAGAnimationViewImpl implements sh2.a {

    /* renamed from: g, reason: collision with root package name */
    public static com.tencent.mobileqq.vasgift.utils.b f311895g = new com.tencent.mobileqq.vasgift.utils.b();

    /* renamed from: b, reason: collision with root package name */
    private PAGView f311897b;

    /* renamed from: c, reason: collision with root package name */
    private View f311898c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f311899d;

    /* renamed from: a, reason: collision with root package name */
    private qh2.a f311896a = null;

    /* renamed from: e, reason: collision with root package name */
    private String f311900e = "";

    /* renamed from: f, reason: collision with root package name */
    private boolean f311901f = ar.b("anzaihuang", "2024-04-18", "vas_gift_pag_play_config").isEnable(true);

    public QQGiftPAGAnimationViewImpl(Context context) {
        this.f311899d = context;
        j();
    }

    private void h(PAGFile pAGFile) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f311897b;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            view = this.f311898c;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                view = null;
                layoutParams = null;
            }
        }
        if (layoutParams != null && layoutParams.height == -2 && layoutParams.width == -2) {
            float width = pAGFile.width();
            float height = pAGFile.height();
            if (width != 0.0f && height != 0.0f) {
                layoutParams.width = -1;
                layoutParams.height = (int) ((ImmersiveUtils.getScreenWidth() * height) / width);
                view.setLayoutParams(layoutParams);
            } else {
                QLog.e("QQGiftPAGAnimationViewImpl", 1, "adjustLayout width::" + width + " height::" + height);
            }
        }
    }

    private void i() {
        View view = this.f311898c;
        if (view != null && view.getParent() != null) {
            QLog.i("QQGiftPAGAnimationViewImpl", 1, "change placeHolderView to PagView currentPath is " + this.f311900e);
            ViewGroup viewGroup = (ViewGroup) this.f311898c.getParent();
            ViewGroup.LayoutParams layoutParams = this.f311898c.getLayoutParams();
            viewGroup.removeView(this.f311898c);
            viewGroup.addView(this.f311897b, layoutParams);
            this.f311898c = null;
            if (!TextUtils.isEmpty(this.f311900e)) {
                c(this.f311900e);
            }
        }
    }

    private void j() {
        if (f311895g.a()) {
            k();
        } else {
            QLog.i("QQGiftPAGAnimationViewImpl", 1, "pag is not loaded waiting loading");
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        PAGView pAGView = new PAGView(this.f311899d);
        this.f311897b = pAGView;
        pAGView.setScaleMode(3);
        this.f311897b.addListener(new a());
        i();
    }

    private void l() {
        f311895g.b(this.f311899d, new b.InterfaceC8940b() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl.2
            @Override // com.tencent.mobileqq.vasgift.utils.b.InterfaceC8940b
            public void onComplete(boolean z16) {
                if (z16) {
                    QLog.i("QQGiftPAGAnimationViewImpl", 1, "loadPag success");
                    ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QQGiftPAGAnimationViewImpl.this.k();
                        }
                    });
                } else {
                    QLog.e("QQGiftPAGAnimationViewImpl", 1, "loadPag failed");
                }
            }
        });
    }

    @Override // sh2.a
    public FrameLayout.LayoutParams a(com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (aVar.f264911b >= 1 && aVar.f264924o == 1) {
            layoutParams.gravity = 80;
            return layoutParams;
        }
        if (aVar.f264930u) {
            aVar.f264924o = 3;
        }
        int i3 = aVar.f264924o;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (VasPadUtils.INSTANCE.isPadLandscape(this.f311899d)) {
                        layoutParams.width = (int) (ImmersiveUtils.getScreenWidth() * (ImmersiveUtils.getScreenWidth() / ImmersiveUtils.getScreenHeight()));
                        layoutParams.height = ImmersiveUtils.getScreenWidth();
                        layoutParams.gravity = 1;
                        layoutParams.bottomMargin = ImmersiveUtils.dpToPx(100.0f);
                    } else {
                        layoutParams.width = -1;
                        layoutParams.height = -1;
                    }
                }
            } else {
                layoutParams.width = -1;
                layoutParams.height = (int) (ImmersiveUtils.getScreenWidth() * 1.2d);
                layoutParams.gravity = 80;
            }
        } else {
            layoutParams.width = ImmersiveUtils.dpToPx(250.0f);
            layoutParams.height = ImmersiveUtils.dpToPx(550.0f);
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = ImmersiveUtils.dpToPx(100.0f);
        }
        return layoutParams;
    }

    @Override // sh2.a
    public void b(qh2.a aVar) {
        this.f311896a = aVar;
    }

    @Override // sh2.a
    public synchronized void c(String str) {
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_VIEW_IMPL_PLAY, "pag");
        if (this.f311897b != null) {
            PAGFile Load = PagViewMonitor.Load(str);
            if (Load == null) {
                qh2.a aVar = this.f311896a;
                if (aVar != null) {
                    aVar.onAnimationEnd();
                }
                QLog.e("QQGiftPAGAnimationViewImpl", 1, "playAnimation play error , path:" + str);
                return;
            }
            h(Load);
            this.f311897b.setComposition(Load);
            this.f311897b.setProgress(0.0d);
            this.f311897b.play();
            if (!this.f311897b.isAttachedToWindow()) {
                qh2.a aVar2 = this.f311896a;
                if (aVar2 != null) {
                    aVar2.onAnimationEnd();
                }
                QLog.e("QQGiftPAGAnimationViewImpl", 1, "playAnimation play error , path:" + str);
            }
        } else {
            this.f311900e = str;
        }
    }

    @Override // sh2.a
    public View d() {
        PAGView pAGView = this.f311897b;
        if (pAGView == null) {
            if (this.f311898c == null) {
                this.f311898c = new View(this.f311899d);
            }
            QLog.i("QQGiftPAGAnimationViewImpl", 1, "waiting loadPag so return placeholderView");
            return this.f311898c;
        }
        return pAGView;
    }

    @Override // sh2.a
    public synchronized void stop() {
        PAGView pAGView = this.f311897b;
        if (pAGView != null && pAGView.isPlaying()) {
            this.f311897b.stop();
        } else {
            this.f311900e = "";
            qh2.a aVar = this.f311896a;
            if (aVar != null) {
                aVar.onAnimationEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements PAGView.PAGViewListener {
        a() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
            QLog.i("QQGiftPAGAnimationViewImpl", 1, "PAGViewListener onAnimationCancel");
            if (QQGiftPAGAnimationViewImpl.this.f311896a != null) {
                QQGiftPAGAnimationViewImpl.this.f311896a.onAnimationEnd();
            }
            if (!QQGiftPAGAnimationViewImpl.this.f311901f && !pAGView.isPlaying()) {
                pAGView.setComposition(null);
                pAGView.flush();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            QLog.i("QQGiftPAGAnimationViewImpl", 1, "PAGViewListener onAnimationEnd");
            if (QQGiftPAGAnimationViewImpl.this.f311896a != null) {
                QQGiftPAGAnimationViewImpl.this.f311896a.onAnimationEnd();
            }
            if (!QQGiftPAGAnimationViewImpl.this.f311901f && !pAGView.isPlaying()) {
                pAGView.setComposition(null);
                pAGView.flush();
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pAGView) {
            if (QQGiftPAGAnimationViewImpl.this.f311896a != null) {
                QQGiftPAGAnimationViewImpl.this.f311896a.onAnimationStart();
            }
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.GIFT_VIEW_IMPL_PLAY_START, "pag");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pAGView) {
        }
    }
}
