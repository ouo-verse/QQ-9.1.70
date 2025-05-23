package com.tencent.mobileqq.splashad.processor;

import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.em;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.widget.ScaleVideoView;
import fd0.a;
import java.io.File;
import mqq.app.AppActivity;

/* loaded from: classes18.dex */
public class VasThemeSplashV2Processor implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ScaleVideoView f288849a;

    public VasThemeSplashV2Processor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void i(c.a aVar) {
        aVar.b(new com.tencent.mobileqq.splash.c(null) { // from class: com.tencent.mobileqq.splashad.processor.VasThemeSplashV2Processor.1
            static IPatchRedirector $redirector_;

            {
                super(r5);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VasThemeSplashV2Processor.this, r5);
                }
            }

            @Override // com.tencent.mobileqq.splash.c
            public void a(c.a aVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar2);
                }
            }

            @Override // com.tencent.mobileqq.splash.c
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                this.f288710a = true;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    VasThemeSplashV2Processor.this.k();
                } else if (VasThemeSplashV2Processor.this.f288849a != null) {
                    VasThemeSplashV2Processor.this.f288849a.post(new Runnable() { // from class: com.tencent.mobileqq.splashad.processor.VasThemeSplashV2Processor.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                VasThemeSplashV2Processor.this.k();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.splash.c
            public void c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }
        });
    }

    private ScaleVideoView j(ViewGroup viewGroup, String str) {
        final ScaleVideoView scaleVideoView = new ScaleVideoView(viewGroup.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        viewGroup.addView(scaleVideoView, layoutParams);
        scaleVideoView.setOnPreparedListener(new a.e() { // from class: com.tencent.mobileqq.splashad.processor.j
            @Override // fd0.a.e
            public final void a(fd0.a aVar) {
                VasThemeSplashV2Processor.o(aVar);
            }
        });
        scaleVideoView.setOnErrorListener(new a.c() { // from class: com.tencent.mobileqq.splashad.processor.k
            @Override // fd0.a.c
            public final boolean d(fd0.a aVar, int i3, int i16) {
                boolean p16;
                p16 = VasThemeSplashV2Processor.p(aVar, i3, i16);
                return p16;
            }
        });
        scaleVideoView.setOnCompletionListener(new a.b() { // from class: com.tencent.mobileqq.splashad.processor.l
            @Override // fd0.a.b
            public final void b(fd0.a aVar) {
                VasThemeSplashV2Processor.q(ScaleVideoView.this, aVar);
            }
        });
        scaleVideoView.T = true;
        scaleVideoView.setVideoPath(str);
        scaleVideoView.start();
        return scaleVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            if (this.f288849a != null) {
                QLog.d("VasThemeSplashProcessorv2", 1, "destroyVideoView stopPlayback");
                this.f288849a.k();
                this.f288849a = null;
            }
        } catch (Throwable th5) {
            QLog.e("VasThemeSplashProcessorv2", 1, "destroyVideoView error", th5);
            if (this.f288849a != null) {
                this.f288849a = null;
            }
        }
    }

    private static String l() {
        String string = em.b().a().getString("theme_root", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String str = File.separator;
        if (!string.endsWith(str)) {
            string = string + str;
        }
        return string + "drawable-xxhdpi/skin_theme_splash.png";
    }

    private static String m() {
        String string = em.b().a().getString("theme_root", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String str = File.separator;
        if (!string.endsWith(str)) {
            string = string + str;
        }
        return string + "raw/" + ThemeConstants.THEME_ANIMATION_SPLASH_VIDEO;
    }

    private boolean n() {
        return QQTheme.isNowThemeIsSuperTheme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(fd0.a aVar) {
        aVar.setVolume(0.0f, 0.0f);
        aVar.setLooping(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean p(fd0.a aVar, int i3, int i16) {
        QLog.d("VasThemeSplashProcessorv2", 1, "videoView on error what=" + i3 + ",extra=" + i16);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(ScaleVideoView scaleVideoView, fd0.a aVar) {
        QLog.d("VasThemeSplashProcessorv2", 1, "videoView play finished");
        scaleVideoView.pause();
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean b(AppActivity appActivity, SplashWidget splashWidget, c.a aVar, com.tencent.mobileqq.splash.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appActivity, splashWidget, aVar, aVar2)).booleanValue();
        }
        boolean n3 = n();
        ImageView b16 = splashWidget.b();
        if (!n3) {
            QLog.d("VasThemeSplashProcessorv2", 1, "skip  VasThemeSplash isHardwareAccelerated=" + b16.isHardwareAccelerated());
            return false;
        }
        try {
            appActivity.getWindow().addFlags(67108864);
        } catch (Exception e16) {
            QLog.d("VasThemeSplashProcessorv2", 1, "set status bar transparent error : ", e16);
        }
        String m3 = m();
        String l3 = l();
        if (!TextUtils.isEmpty(m3) && new File(m3).exists()) {
            this.f288849a = j((ViewGroup) b16.getParent(), m3);
        } else {
            if (TextUtils.isEmpty(l3) || !new File(l3).exists()) {
                return false;
            }
            try {
                b16.setImageDrawable(new BitmapDrawable(l3));
                b16.setScaleType(ImageView.ScaleType.CENTER_CROP);
                b16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } catch (Throwable th5) {
                QLog.d("VasThemeSplashProcessorv2", 1, "set static bg error : ", th5);
            }
        }
        i(aVar);
        QLog.d("VasThemeSplashProcessorv2", 1, "will showing vas theme splash bg.");
        return true;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public Integer getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "VasThemeSplashProcessor";
    }
}
