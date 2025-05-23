package com.tencent.mobileqq.splashad.processor;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.em;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i implements d {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.a f288876d;

        a(c.a aVar) {
            this.f288876d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QLog.d("VasThemeSplashProcessorv1", 1, "onSkipClick");
                ThemeVipBehavior.updateNextShowVipSplash();
                VasCommonReporter.getTheme().setValue3("vip_splash").setNum1(2L).report(false);
                this.f288876d.a(0L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.splash.c {
        static IPatchRedirector $redirector_;

        b(Object obj) {
            super(obj);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, obj);
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void a(c.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f288710a = true;
            }
        }

        @Override // com.tencent.mobileqq.splash.c
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(c.a aVar) {
        aVar.b(new b(null));
    }

    private void e(ViewGroup viewGroup, c.a aVar) {
        if (!ThemeVipBehavior.couldShowVipSplashSkip()) {
            return;
        }
        TextView textView = new TextView(viewGroup.getContext());
        textView.setBackgroundResource(R.drawable.b4x);
        textView.setGravity(17);
        textView.setText(HardCodeUtil.qqStr(R.string.tnb));
        textView.setTextColor(-1);
        textView.setTextSize(15.0f);
        textView.setOnClickListener(new a(aVar));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(72.0f), ViewUtils.dpToPx(27.0f));
        layoutParams.gravity = 53;
        layoutParams.topMargin = ViewUtils.dpToPx(30.0f);
        layoutParams.rightMargin = ViewUtils.dpToPx(20.0f);
        viewGroup.addView(textView, layoutParams);
    }

    private static Drawable f() {
        Drawable h16 = h();
        if (DeviceInfoUtils.isLowPerfDevice()) {
            return h16;
        }
        return g(h16);
    }

    private static Drawable g(Drawable drawable) {
        String string = em.b().a().getString("theme_root", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String str = File.separator;
        if (!string.endsWith(str)) {
            string = string + str;
        }
        return ThemeBackground.getGLDrawableDrawable(new File(string + "raw/" + ThemeConstants.THEME_ANIMATION_SPLASH_VIDEO).getAbsolutePath(), drawable);
    }

    private static Drawable h() {
        String string = em.b().a().getString("theme_root", null);
        if (!TextUtils.isEmpty(string)) {
            String str = File.separator;
            if (!string.endsWith(str)) {
                string = string + str;
            }
            String str2 = string + "drawable-xxhdpi/skin_theme_splash.png";
            if (new File(str2).exists()) {
                return new BitmapDrawable(str2);
            }
        }
        return null;
    }

    private static Drawable i() {
        Drawable k3 = k();
        if (!DeviceInfoUtils.isLowPerfDevice() && Build.VERSION.SDK_INT > 28 && VasToggle.FEATURE_THEME_VIP_SPLASH.getInt(0) <= 0) {
            return j(k3);
        }
        return h.d();
    }

    private static Drawable j(Drawable drawable) {
        String vipThemeResPath = ThemeVipBehavior.getVipThemeResPath();
        if (!TextUtils.isEmpty(vipThemeResPath)) {
            String str = File.separator;
            if (!vipThemeResPath.endsWith(str)) {
                vipThemeResPath = vipThemeResPath + str;
            }
            return ThemeBackground.getGLDrawableDrawable(new File(vipThemeResPath + ThemeConstants.THEME_ANIMATION_SPLASH_VIDEO).getAbsolutePath(), drawable);
        }
        return null;
    }

    public static Drawable k() {
        String vipThemeResPath = ThemeVipBehavior.getVipThemeResPath();
        if (!TextUtils.isEmpty(vipThemeResPath)) {
            String str = File.separator;
            if (!vipThemeResPath.endsWith(str)) {
                vipThemeResPath = vipThemeResPath + str;
            }
            String str2 = vipThemeResPath + "qq_skin_splash_static.png";
            if (new File(str2).exists()) {
                return new BitmapDrawable(str2);
            }
            return null;
        }
        return null;
    }

    private boolean l() {
        return QQTheme.isNowThemeIsSuperTheme();
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
        Drawable i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appActivity, splashWidget, aVar, aVar2)).booleanValue();
        }
        boolean l3 = l();
        if (!ThemeVipBehavior.enableVipSplash() && !l3) {
            return false;
        }
        try {
            appActivity.getWindow().addFlags(67108864);
        } catch (Exception e16) {
            QLog.d("VasThemeSplashProcessorv1", 1, "set status bar transparent error : ", e16);
        }
        ImageView b16 = splashWidget.b();
        if (l3) {
            i3 = f();
        } else {
            i3 = i();
        }
        if (i3 == null) {
            return false;
        }
        if (!l3) {
            e((ViewGroup) b16.getParent(), aVar);
            VasCommonReporter.getTheme().setValue3("vip_splash").setNum1(1L).report(false);
        }
        splashWidget.setSplashDrawable(i3, false);
        try {
            ViewGroup.LayoutParams layoutParams = b16.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            b16.setLayoutParams(layoutParams);
            b16.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        d(aVar);
        QLog.d("VasThemeSplashProcessorv1", 1, "will showing vas theme splash bg.");
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
