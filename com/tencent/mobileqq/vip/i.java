package com.tencent.mobileqq.vip;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i implements IGameCardManager {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IGameCardManager.b f313031d;

        a(IGameCardManager.b bVar) {
            this.f313031d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) i.this, (Object) bVar);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            } else {
                this.f313031d.b(uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else {
                this.f313031d.a(uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else {
                this.f313031d.c(uRLDrawable);
            }
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    private URLDrawable a(IGameCardManager.a aVar, IGameCardManager.b bVar, ApngOptions apngOptions) {
        URLDrawable apngURLDrawable;
        if (aVar == null || bVar == null || apngOptions == null || !c(aVar.f312738f)) {
            return null;
        }
        String cardResPath = getCardResPath(1, aVar.f312738f);
        if (TextUtils.isEmpty(cardResPath) || (apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(cardResPath, apngOptions, cardResPath)) == null) {
            return null;
        }
        bVar.c(apngURLDrawable);
        return apngURLDrawable;
    }

    @Nullable
    private URLDrawable b(boolean z16, IGameCardManager.a aVar, IGameCardManager.b bVar, ApngOptions apngOptions) {
        boolean z17;
        boolean z18;
        String str;
        AppRuntime app = VasUtil.getApp();
        if (app == null || aVar == null || bVar == null || apngOptions == null) {
            return null;
        }
        String str2 = VipGrayConfigHelper.getsInstance().namePlateOfKingUrl;
        boolean z19 = false;
        if (!TextUtils.isEmpty(aVar.f312734b) && app.getCurrentUin().equals(aVar.f312734b)) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z26 = app.getApp().getSharedPreferences(ProfileContants.SP_PLATE_OF_KING, 0).getBoolean("plate_of_king_display_switch_" + app.getCurrentUin(), true);
        if (!TextUtils.isEmpty(str2) && aVar.f312735c != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17) {
            if (z18 && (z26 || z16)) {
                z19 = true;
            }
            z18 = z19;
        }
        if (!z18) {
            return null;
        }
        if (aVar.f312736d == 0) {
            str = str2 + aVar.f312735c + ".png";
        } else {
            str = str2 + aVar.f312735c + "_" + aVar.f312736d + ".png";
        }
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("GameNameplateManager", str, apngOptions);
        if (apngURLDrawable == null) {
            return null;
        }
        if (apngURLDrawable.getStatus() != 1 && apngURLDrawable.getStatus() != 0) {
            bVar.d(apngURLDrawable);
        } else {
            bVar.c(apngURLDrawable);
        }
        return apngURLDrawable;
    }

    private boolean c(int i3) {
        return checkGameCardAble(false, i3);
    }

    private String d(String str) {
        Map<String, String> isEnabledWithDataSet;
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            return null;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all");
        if (!iFeatureRuntimeService.isFeatureSwitchEnable("gamecard_config_url") || (isEnabledWithDataSet = iFeatureRuntimeService.isEnabledWithDataSet("gamecard_config_url", "")) == null) {
            return null;
        }
        return isEnabledWithDataSet.get(str);
    }

    @Override // com.tencent.mobileqq.vip.IGameCardManager
    public boolean checkGameCardAble(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3))).booleanValue();
        }
        if (!z16 && i3 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("GameNameplateManager", 2, "new_game_card Switch close:" + i3);
            }
            return false;
        }
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) app.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("gamecard_config_url");
        if (QLog.isColorLevel()) {
            QLog.d("GameNameplateManager", 2, "new_game_card Switch " + isFeatureSwitchEnable);
        }
        return isFeatureSwitchEnable;
    }

    @Override // com.tencent.mobileqq.vip.IGameCardManager
    public String getCardResPath(int i3, int i16) {
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i16 <= 0) {
            return "";
        }
        com.tencent.mobileqq.vas.vipicon.a aVar = (com.tencent.mobileqq.vas.vipicon.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.a.class);
        if (i3 != 1) {
            if (i3 != 2) {
                f16 = null;
            } else {
                f16 = aVar.e(i16);
            }
        } else {
            f16 = aVar.f(i16);
        }
        if (aVar.isFileExists(i16)) {
            return f16;
        }
        aVar.startDownload(i16);
        return "";
    }

    @Override // com.tencent.mobileqq.vip.IGameCardManager
    public URLDrawable getGameCardDrawable(boolean z16, IGameCardManager.a aVar, IGameCardManager.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), aVar, bVar);
        }
        if (aVar != null && bVar != null) {
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadListener(new a(bVar));
            if (aVar.f312737e) {
                if (((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(aVar.f312734b).isWzryVip()) {
                    aVar.f312738f = ((com.tencent.mobileqq.vas.vipicon.a) QQVasUpdateBusiness.getBusiness(com.tencent.mobileqq.vas.vipicon.a.class)).g(aVar.f312736d, false);
                } else {
                    z17 = false;
                }
            }
            if (!z17) {
                return b(z16, aVar, bVar, apngOptions);
            }
            return a(aVar, bVar, apngOptions);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "GameNameplateManager";
    }

    @Override // com.tencent.mobileqq.vip.IGameCardManager
    public void gotoGameIconSetWeb(Context context, String str, boolean z16, int i3) {
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, str, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (context == null || TextUtils.isEmpty(str) || !checkGameCardAble(z16, i3)) {
            return;
        }
        if (!isSelf(str) && !z16) {
            d16 = d("np_active_url_" + i3);
            if (TextUtils.isEmpty(d16)) {
                d16 = d("np_active_url_def");
            }
        } else {
            d16 = d("np_host_setting_url");
        }
        String str2 = d16;
        if (QLog.isColorLevel()) {
            QLog.d("GameNameplateManager", 2, "new_game_card GameJump " + str + " " + str2);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, str2);
            return;
        }
        Intent intent = new Intent(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        intent.putExtra("portraitOnly", true);
        intent.putExtra("uin", str);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserWithoutAD(context, str2, 256L, intent, false, -1);
    }

    @Override // com.tencent.mobileqq.vip.IGameCardManager
    public void gotoKingIconSetWeb(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            return;
        }
        String d16 = d("np_setting_url");
        if (TextUtils.isEmpty(d16)) {
            d16 = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.PLATEOFKINGDAN);
        }
        String str = d16;
        if (QLog.isColorLevel()) {
            QLog.d("GameNameplateManager", 2, "new_game_card KingJump " + str);
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, str);
            return;
        }
        Intent intent = new Intent(context, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
        intent.setFlags(268435456);
        intent.putExtra(VasWebviewConstants.KEY_VAS_USE_PREWEBVIEW, true);
        VasWebviewUtil.openQQBrowserWithoutAD(context, str, -1L, intent, false, -1);
    }

    @Override // com.tencent.mobileqq.vip.IGameCardManager
    public boolean isSelf(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        AppRuntime app = VasUtil.getApp();
        if (app == null) {
            return false;
        }
        return app.getCurrentUin().equals(str);
    }
}
