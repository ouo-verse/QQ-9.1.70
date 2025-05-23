package com.tencent.mobileqq.qui.immersive.color;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.immersive.color.IColorFetcher;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.qui.quiblurview.QQNativeBlurView;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f276889a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50642);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f276889a = null;
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean b() {
        if (f276889a == null) {
            f276889a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("blur_view_color_fetcher_use_overlay", true));
        }
        return f276889a.booleanValue();
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable)).booleanValue();
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.a, com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public Pair<Boolean, Integer> getColor(View view, IColorFetcher.Area area) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) area);
        }
        if (b()) {
            if (view instanceof QQBlurView) {
                drawable = ((QQBlurView) view).s();
            } else if (view instanceof QQNativeBlurView) {
                drawable = ((QQNativeBlurView) view).g();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                return super.getColor(drawable, area);
            }
        }
        return super.getColor(view, area);
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? (view instanceof QQBlurView) || (view instanceof QQNativeBlurView) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
    }
}
