package com.tencent.mobileqq.splashad.processor;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.splash.c;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017JI\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0003*\u0004\u0018\u00010\t0\tH\u0096\u0001J\u0018\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\r0\rH\u0096\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\n \u0003*\u0004\u0018\u00010\u00100\u0010H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000bH\u0096\u0001\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/splashad/processor/h;", "Lcom/tencent/mobileqq/splashad/processor/d;", "Lmqq/app/AppActivity;", "kotlin.jvm.PlatformType", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/splashad/SplashWidget;", "splashWidget", "Lcom/tencent/mobileqq/splash/c$a;", "listener", "Lcom/tencent/mobileqq/splash/a;", "splashPreloadCallback", "", "b", "", "getBizType", "()Ljava/lang/Integer;", "", "getTag", "a", "isWarmStartUp", "", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ d f288875a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/splashad/processor/h$a;", "", "Landroid/graphics/drawable/Drawable;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.splashad.processor.h$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @Nullable
        public final Drawable a() {
            boolean endsWith$default;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String resPath = ThemeVipBehavior.getVipThemeResPath();
            if (!TextUtils.isEmpty(resPath)) {
                Intrinsics.checkNotNullExpressionValue(resPath, "resPath");
                String separator = File.separator;
                Intrinsics.checkNotNullExpressionValue(separator, "separator");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(resPath, separator, false, 2, null);
                if (!endsWith$default) {
                    resPath = resPath + separator;
                }
                if (QQTheme.isNowThemeIsNight()) {
                    str = resPath + "skin_theme_splash_dark.png";
                } else {
                    str = resPath + "skin_theme_splash.png";
                }
                if (new File(str).exists()) {
                    return new BitmapDrawable(str);
                }
            }
            return null;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60520);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        d iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        if (VasNormalToggle.THEME_SPLASH_V2_ENABLE.isEnable(true)) {
            iVar = new VasThemeSplashV2Processor();
        } else {
            iVar = new i();
        }
        this.f288875a = iVar;
    }

    @JvmStatic
    @Nullable
    public static final Drawable d() {
        return INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f288875a.a();
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public boolean b(AppActivity activity, SplashWidget splashWidget, c.a listener, com.tencent.mobileqq.splash.a splashPreloadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, activity, splashWidget, listener, splashPreloadCallback)).booleanValue();
        }
        return this.f288875a.b(activity, splashWidget, listener, splashPreloadCallback);
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public void c(boolean isWarmStartUp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isWarmStartUp);
        } else {
            this.f288875a.c(isWarmStartUp);
        }
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public Integer getBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f288875a.getBizType();
    }

    @Override // com.tencent.mobileqq.splashad.processor.d
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f288875a.getTag();
    }
}
