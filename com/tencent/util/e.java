package com.tencent.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f383975a;

    /* renamed from: b, reason: collision with root package name */
    private static CallBacker f383976b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f383977c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a extends CallBacker {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Card f383978a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.k f383979b;

        a(Card card, com.tencent.mobileqq.activity.qqsettingme.k kVar) {
            this.f383978a = card;
            this.f383979b = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) card, (Object) kVar);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DrawerCoverUtil", 2, "getCover IVasQuickUpdateService callback");
            }
            e.e(this.f383978a, this.f383979b);
            e.f383976b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends nk3.i {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.k f383980a;

        b(com.tencent.mobileqq.activity.qqsettingme.k kVar) {
            this.f383980a = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar);
            }
        }

        @Override // nk3.i
        public void onResultFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.e("DrawerCoverUtil", 1, "tryRequestZPlanBg failed");
                this.f383980a.onResult("qzone_zplan_bg", false);
            }
        }

        @Override // nk3.i
        public void onResultForSelectImage(@NonNull com.tencent.mobileqq.zplan.model.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            QLog.i("DrawerCoverUtil", 1, "tryRequestZPlanBg success, dayUrl=" + gVar.i() + ", darkUrl=" + gVar.b());
            if (e.i(gVar.i()) || e.l(gVar.i())) {
                this.f383980a.onResult(ProfileCardUtil.u(gVar.i()), false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383975a = new AtomicBoolean(false);
            f383977c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Card card, com.tencent.mobileqq.activity.qqsettingme.k kVar) {
        String u16;
        long j3 = card.lCurrentBgId;
        Boolean bool = ProfileCardManager.f259993h.get(Long.valueOf(j3));
        if (bool != null && bool.booleanValue()) {
            ProfileCardManager.f259993h.remove(Long.valueOf(j3));
        }
        if (j3 != 160 && j3 != 1600 && !ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
            u16 = ProfileCardManager.r(MobileQQ.sMobileQQ.peekAppRuntime().getApp(), card.lCurrentStyleId, card.lCurrentBgId);
        } else {
            u16 = ProfileCardUtil.u(card.strDrawerCardUrl);
        }
        if (QLog.isColorLevel()) {
            QLog.i("DrawerCoverUtil", 2, "afterCardResReady");
        }
        kVar.onResult(u16, false);
    }

    public static boolean f(Card card) {
        long j3 = card.lCurrentBgId;
        if (j3 != 160 && j3 != 1600 && !ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
            return new File(ProfileCardManager.r(MobileQQ.sMobileQQ.peekAppRuntime().getApp(), card.lCurrentStyleId, card.lCurrentBgId)).exists();
        }
        return ProfileCardUtil.M(card.strDrawerCardUrl);
    }

    @Nullable
    public static boolean g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        boolean isZPlanAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZPlanAccessible(1006L, peekAppRuntime.getLongAccountUin());
        boolean isDrawerEntranceSwitchOpen = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isDrawerEntranceSwitchOpen();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (QLog.isColorLevel()) {
            QLog.i("DrawerCoverUtil", 2, String.format("checkShowZPlanBg isProfileCardShowZPlan: %s, isDrawerEntranceSwitchOn: %s, isStudyMode: %s", Boolean.valueOf(isZPlanAccessible), Boolean.valueOf(isDrawerEntranceSwitchOpen), Boolean.valueOf(studyModeSwitch)));
        }
        if (!isDrawerEntranceSwitchOpen || !isZPlanAccessible || studyModeSwitch) {
            return false;
        }
        return true;
    }

    public static boolean h(Card card) {
        ProfileCardTemplate profileCardTemplate;
        boolean isEnable = VasNormalToggle.BUG_118290741.isEnable(true);
        if (!isEnable) {
            profileCardTemplate = ProfileCardTemplateUtil.i(card.lCurrentStyleId, true);
        } else {
            profileCardTemplate = null;
        }
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (QLog.isColorLevel()) {
            QLog.d("DrawerCoverUtil", 2, "[check cardTemplate]lCurrentStyleId:" + card.lCurrentStyleId + " backgroundUrl:" + card.strDrawerCardUrl + " templateRet:" + card.templateRet + " isSimpleUI:" + simpleUISwitch);
        }
        if (simpleUISwitch) {
            return false;
        }
        if (ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
            return true;
        }
        if (card.lCurrentStyleId > 0 && ((profileCardTemplate != null || isEnable) && !TextUtils.isEmpty(card.strDrawerCardUrl) && card.templateRet == 0)) {
            return true;
        }
        return false;
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ProfileCardUtil.M(str);
    }

    public static void j() {
        f383977c = false;
    }

    public static boolean k(Card card) {
        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(card.strDrawerCardUrl, new File(ProfileCardUtil.u(card.strDrawerCardUrl)));
        gVar.S = "profileCardDownload";
        gVar.R = "VIP_profilecard";
        int o16 = DownloaderFactory.o(gVar, MobileQQ.sMobileQQ.peekAppRuntime());
        if (o16 == 0) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("DrawerCoverUtilDrawerCover", 1, "download error:" + o16);
            return false;
        }
        QLog.e("DrawerCoverUtilDrawerCover", 1, "download {" + card.strDrawerCardUrl + "} error:" + o16);
        return false;
    }

    public static boolean l(String str) {
        if (!TextUtils.isEmpty(str)) {
            AtomicBoolean atomicBoolean = f383975a;
            if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
                QLog.i("DrawerCoverUtil", 2, "start download ZPlan background");
                com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, new File(ProfileCardUtil.u(str)));
                gVar.S = "profileCardDownload";
                gVar.R = "VIP_profilecard";
                int o16 = DownloaderFactory.o(gVar, MobileQQ.sMobileQQ.peekAppRuntime());
                atomicBoolean.set(false);
                if (o16 == 0) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("DrawerCoverUtil", 2, "download error:" + o16);
                } else {
                    QLog.e("DrawerCoverUtilDrawerCover", 2, "download {" + str + "} error:" + o16);
                }
            }
        }
        return false;
    }

    public static void m(Card card) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        CardHandler cardHandler = (CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (cardHandler == null) {
            return;
        }
        byte x06 = (byte) ea.x0(qQAppInterface.getApplication(), qQAppInterface.getCurrentAccountUin());
        cardHandler.m3(qQAppInterface.getCurrentAccountUin(), qQAppInterface.getCurrentUin(), 0, card.feedPreviewTime, (byte) 1, 0L, 0L, new byte[]{0}, "", 11837L, 10004, new byte[]{0}, x06);
        if (QLog.isColorLevel()) {
            QLog.d("DrawerCoverUtil", 2, "fetch profilecard info failure from cache,restart to fetch from net");
        }
    }

    public static void n(final com.tencent.mobileqq.activity.qqsettingme.k kVar, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.util.c
            @Override // java.lang.Runnable
            public final void run() {
                e.s(com.tencent.mobileqq.activity.qqsettingme.k.this, z16);
            }
        }, 32, null, false);
    }

    public static void o(Card card, com.tencent.mobileqq.activity.qqsettingme.k kVar) {
        if (!h(card) && !g()) {
            if (QLog.isColorLevel()) {
                QLog.d("DrawerCoverUtil", 2, "getCover card.isNoCover():" + card.isNoCover());
            }
            if (card.isNoCover()) {
                kVar.onResult(null, false);
                return;
            } else {
                kVar.onResult((String) card.getCoverData(0)[0], true);
                return;
            }
        }
        if (!h(card) && g()) {
            if (QLog.isColorLevel()) {
                QLog.d("DrawerCoverUtil", 2, "getCover getZPlanBgUrl");
            }
            p(kVar);
            return;
        }
        if (!f(card)) {
            long j3 = card.lCurrentBgId;
            if (j3 != 160 && j3 != 1600 && !ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DrawerCoverUtil", 2, "getCover IVasQuickUpdateService");
                }
                QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                f383976b = new a(card, kVar);
                ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.k(qQAppInterface, VasUpdateConstants.SCID_CARD_PREFIX + card.lCurrentBgId, f383976b);
                return;
            }
            k(card);
            e(card, kVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DrawerCoverUtil", 2, "getCover afterCardResReady");
        }
        e(card, kVar);
    }

    private static void p(com.tencent.mobileqq.activity.qqsettingme.k kVar) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && g()) {
            com.tencent.mobileqq.zplan.model.g userBackgroundInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserBackgroundInfo(String.valueOf(Long.valueOf(peekAppRuntime.getLongAccountUin())));
            if (userBackgroundInfo != null) {
                if (je0.a.a(peekAppRuntime.getApp())) {
                    str = userBackgroundInfo.b();
                } else {
                    str = userBackgroundInfo.i();
                }
            } else {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.i("DrawerCoverUtil", 2, "getZPlanBgUrl bgUrl:" + str);
            }
            if (!TextUtils.isEmpty(str) && (i(str) || l(str))) {
                kVar.onResult(ProfileCardUtil.u(str), false);
                return;
            } else {
                u(kVar);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("DrawerCoverUtil", 2, "getZPlanBgUrl bgUrl: null");
        }
        kVar.onResult(null, false);
    }

    public static boolean q() {
        return f383977c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(com.tencent.mobileqq.activity.qqsettingme.k kVar, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final Card I = ProfileCardUtil.I(peekAppRuntime, peekAppRuntime.getCurrentAccountUin());
        String str = (String) I.getCoverData(0)[0];
        if (QLog.isColorLevel()) {
            QLog.d("DrawerCoverUtil", 2, "[getCoverData] getCovertUrl from cache,url:" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("DrawerCoverUtil", 2, "card.isNoCover()=" + I.isNoCover());
            }
            if (!h(I) && I.isNoCover() && !g()) {
                kVar.onResult(null, false);
                return;
            } else {
                o(I, kVar);
                return;
            }
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("DrawerCoverUtil", 2, "fetchCoverCardDataFromNet");
            }
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.m(Card.this);
                }
            }, 128, null, false, 3000L);
            kVar.a();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DrawerCoverUtil", 2, "canRequest false");
        }
    }

    public static void t() {
        f383977c = true;
    }

    private static void u(com.tencent.mobileqq.activity.qqsettingme.k kVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            kVar.onResult(null, false);
        } else {
            ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestAddDCBackImage(peekAppRuntime.getLongAccountUin(), 5, null, new b(kVar));
        }
    }
}
