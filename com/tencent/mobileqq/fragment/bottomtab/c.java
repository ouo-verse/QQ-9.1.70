package com.tencent.mobileqq.fragment.bottomtab;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinEngine;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f211377a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f211378b;

    public c() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsDefault = ThemeUtil.isNowThemeIsDefault(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        if (!QQTheme.isBaseDIYTheme() && !QQTheme.isNowThemeIsDIY()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f211377a = z16;
        this.f211378b = (isNowThemeIsDefault || isNowThemeIsSimple || isNowThemeIsNight || z16) ? false : true;
    }

    private int b(com.tencent.mobileqq.activity.home.impl.c cVar) {
        if (SimpleModeHelper.B()) {
            return cVar.f();
        }
        if (!this.f211378b && !this.f211377a) {
            if (TabDragAnimationView.t() && !QQTheme.isDefaultTheme()) {
                return cVar.c();
            }
            return cVar.d();
        }
        if (SkinEngine.getInstances().checkResExist(cVar.t())) {
            return cVar.t();
        }
        return cVar.d();
    }

    public PreviewItem a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PreviewItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByKey = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByKey(str);
        if (frameInfoByKey == null) {
            return null;
        }
        if ("GUILD".equals(str)) {
            return new PreviewItem(b(frameInfoByKey), frameInfoByKey.h(), str, this);
        }
        if (TabDataHelper.TAB_NEW_WORLD.equals(str)) {
            return new PreviewItem(b(frameInfoByKey), uq3.c.O3(), str, this);
        }
        return new PreviewItem(b(frameInfoByKey), BaseApplication.getContext().getString(frameInfoByKey.p()), str, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f211378b;
    }
}
