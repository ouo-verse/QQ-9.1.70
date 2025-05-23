package com.tencent.ams.dynamicwidget;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.view.video.VideoLoader;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bd\u0010eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010'\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\u0003\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010D\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010G\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u00100\u001a\u0004\bE\u00102\"\u0004\bF\u00104R\"\u0010J\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u00100\u001a\u0004\bH\u00102\"\u0004\bI\u00104R\"\u0010L\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00100\u001a\u0004\b7\u00102\"\u0004\bK\u00104R\"\u0010S\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\b)\u0010P\"\u0004\bQ\u0010RR\"\u0010V\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u00100\u001a\u0004\b>\u00102\"\u0004\bU\u00104R\"\u0010Y\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u00100\u001a\u0004\bN\u00102\"\u0004\bX\u00104R$\u0010\\\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010O\u001a\u0004\b\u0013\u0010P\"\u0004\b[\u0010RR$\u0010_\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b\u000b\u0010P\"\u0004\b^\u0010RR\"\u0010c\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u00100\u001a\u0004\ba\u00102\"\u0004\bb\u00104\u00a8\u0006f"}, d2 = {"Lcom/tencent/ams/dynamicwidget/c;", "", "", "a", UserInfo.SEX_FEMALE, "getOutDensityScale", "()F", "setOutDensityScale", "(F)V", "outDensityScale", "", "b", "I", "getPreWarmTimeout", "()I", "setPreWarmTimeout", "(I)V", "preWarmTimeout", "Lcom/tencent/ams/mosaic/f$c;", "c", "Lcom/tencent/ams/mosaic/f$c;", "d", "()Lcom/tencent/ams/mosaic/f$c;", "setImageLoader", "(Lcom/tencent/ams/mosaic/f$c;)V", "imageLoader", "Lcom/tencent/ams/dsdk/view/video/VideoLoader;", "Lcom/tencent/ams/dsdk/view/video/VideoLoader;", "g", "()Lcom/tencent/ams/dsdk/view/video/VideoLoader;", "setVideoLoader", "(Lcom/tencent/ams/dsdk/view/video/VideoLoader;)V", "videoLoader", "Lcom/tencent/ams/dynamicwidget/g;", "e", "Lcom/tencent/ams/dynamicwidget/g;", "()Lcom/tencent/ams/dynamicwidget/g;", "setOutAbilities", "(Lcom/tencent/ams/dynamicwidget/g;)V", "outAbilities", "Lcom/tencent/ams/dynamicwidget/a;", "f", "Lcom/tencent/ams/dynamicwidget/a;", "()Lcom/tencent/ams/dynamicwidget/a;", "setAppConfigGetter", "(Lcom/tencent/ams/dynamicwidget/a;)V", "appConfigGetter", "", "Z", "l", "()Z", "setRequiredTemplate", "(Z)V", "isRequiredTemplate", "", h.F, "J", "getRenderTimeout", "()J", "setRenderTimeout", "(J)V", "renderTimeout", "i", "Ljava/lang/Integer;", "getServiceType", "()Ljava/lang/Integer;", "setServiceType", "(Ljava/lang/Integer;)V", "serviceType", "j", "setLandingPageDowngradeNative", "isLandingPageDowngradeNative", "k", "setLandingPageUseXJBundle", "isLandingPageUseXJBundle", "setDarkMode", "isDarkMode", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "()Ljava/lang/String;", "setThemeColor", "(Ljava/lang/String;)V", "themeColor", DomainData.DOMAIN_NAME, "setDebug", "isDebug", "o", "setUnitTest", "isUnitTest", "p", "setDebugVendorFilePath", "debugVendorFilePath", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setDebugVendorAssertPath", "debugVendorAssertPath", "r", "getEnableLandingPageCheckBundleVersion", "setEnableLandingPageCheckBundleVersion", "enableLandingPageCheckBundleVersion", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static float outDensityScale;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int preWarmTimeout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static f.c imageLoader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static VideoLoader videoLoader;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static g outAbilities;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a appConfigGetter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean isRequiredTemplate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long renderTimeout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Integer serviceType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean isLandingPageDowngradeNative;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isLandingPageUseXJBundle;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static boolean isDarkMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String themeColor;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static boolean isDebug;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean isUnitTest;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String debugVendorFilePath;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String debugVendorAssertPath;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static boolean enableLandingPageCheckBundleVersion;

    /* renamed from: s, reason: collision with root package name */
    public static final c f70185s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15958);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 60)) {
            redirector.redirect((short) 60);
            return;
        }
        f70185s = new c();
        outDensityScale = 1.0f;
        preWarmTimeout = 100;
        isRequiredTemplate = true;
        renderTimeout = 1000L;
        serviceType = 7;
        themeColor = "#FF3377FF";
        enableLandingPageCheckBundleVersion = true;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
        }
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (a) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return appConfigGetter;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (String) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return debugVendorAssertPath;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return debugVendorFilePath;
    }

    @Nullable
    public final f.c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (f.c) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return imageLoader;
    }

    @Nullable
    public final g e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (g) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return outAbilities;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return themeColor;
    }

    @Nullable
    public final VideoLoader g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (VideoLoader) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return videoLoader;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        return isDarkMode;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return isDebug;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        return isLandingPageDowngradeNative;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return isLandingPageUseXJBundle;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return isRequiredTemplate;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        return isUnitTest;
    }
}
