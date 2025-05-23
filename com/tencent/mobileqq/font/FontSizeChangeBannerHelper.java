package com.tencent.mobileqq.font;

import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.app.utils.i;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/font/FontSizeChangeBannerHelper;", "", "", "c", "Landroid/content/Context;", "context", "a", "b", "", "Z", "isSwitch", "<init>", "()V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FontSizeChangeBannerHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FontSizeChangeBannerHelper f210540a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean isSwitch;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25006);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f210540a = new FontSizeChangeBannerHelper();
            isSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("font_116690704", true);
        }
    }

    FontSizeChangeBannerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isSwitch) {
            return;
        }
        i iVar = i.f196664a;
        if (!iVar.d(context)) {
            return;
        }
        boolean p16 = BannerManager.l().p();
        QLog.d("FontSizeChangeBannerHelper", 1, "[checkShowFontSizeChangedBanner] notify show font size changed banner. isInit=" + p16);
        if (p16) {
            iVar.g(context, false);
            BannerManager.l().O(d.f200255h, 2, Message.obtain());
        }
    }

    public final void b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("FontSizeChangeBannerHelper", 1, "[hideFontSizeChangedBanner] call");
        i.f196664a.g(context, false);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            i.f196664a.h(FontSizeChangeBannerHelper$setSizeChangeCallback$1.INSTANCE);
        }
    }
}
