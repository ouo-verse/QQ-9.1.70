package com.tencent.mobileqq.splashad.processor;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.splashad.config.ThemeSplashHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ds;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.io.InputStream;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int d() {
        String b16 = com.tencent.mobileqq.splashad.config.c.a().b();
        if ("simple".equals(b16)) {
            return 1;
        }
        if ("elder".equals(b16)) {
            return 4;
        }
        if ("study".equals(b16)) {
            return 3;
        }
        return 2;
    }

    private Drawable e(AppActivity appActivity) {
        InputStream inputStream;
        try {
            inputStream = appActivity.getAssets().open(com.tencent.mobileqq.splash.f.f288712a.b());
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            return new BitmapDrawable(appActivity.getResources(), inputStream);
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e("SetSplash", 1, "logo drawable open:", th);
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (Throwable th7) {
                    QLog.e("SetSplash", 1, "logo drawable close:", th7);
                    return null;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th8) {
                        QLog.e("SetSplash", 1, "logo drawable close:", th8);
                    }
                }
            }
        }
    }

    private Drawable f(AppActivity appActivity) {
        InputStream inputStream;
        try {
            inputStream = appActivity.getAssets().open(com.tencent.mobileqq.splash.f.f288712a.d());
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
        try {
            return new BitmapDrawable(appActivity.getResources(), inputStream);
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e("SetSplash", 1, "main drawable open:", th);
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (Throwable th7) {
                    QLog.e("SetSplash", 1, "main drawable close:", th7);
                    return null;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th8) {
                        QLog.e("SetSplash", 1, "main drawable close:", th8);
                    }
                }
            }
        }
    }

    private void g(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
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
        Drawable drawable;
        Drawable f16;
        Drawable e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appActivity, splashWidget, aVar, aVar2)).booleanValue();
        }
        if (ds.d(0, 1000) <= 0) {
            ReportController.o(null, "CliOper", "", "", "0X800C399", "0X800C399", d(), 0, "", "", "", "");
        }
        try {
            appActivity.getWindow().addFlags(67108864);
        } catch (Exception e17) {
            QLog.d(getTag(), 1, "set status bar transparent error on config splash : ", e17);
        }
        Drawable drawable2 = null;
        if (ThemeVipBehavior.enableVipSplash()) {
            drawable = h.d();
            if (drawable != null) {
                splashWidget.setSplashDrawable(drawable, false);
                try {
                    g(splashWidget.b());
                    QLog.d(getTag(), 1, "set vipSplash and overWriteLayoutParamsWhenVas");
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } else {
            drawable = null;
        }
        if (drawable == null) {
            ThemeSplashHelper.b m3 = ThemeSplashHelper.m(appActivity.getResources());
            if (m3 != null && (f16 = m3.f288760a) != null) {
                e16 = m3.f288761b;
            } else {
                f16 = f(appActivity);
                e16 = e(appActivity);
            }
            if (f16 != null) {
                splashWidget.setSplashDrawable(f16, true);
            }
            drawable2 = e16;
        }
        if (drawable2 != null) {
            splashWidget.setLogoDrawable(drawable2);
        }
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        ImageView a16 = splashWidget.a();
        RFWNavigationBarImmersiveHelper.ImmersiveType immersiveType = RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE;
        bVar.a(a16, immersiveType);
        bVar.a(splashWidget.b(), immersiveType);
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
        return 0;
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "DefaultSplash";
    }
}
