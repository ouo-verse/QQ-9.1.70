package com.tencent.mobileqq.vas.inject;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ads.data.AdParam;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.an;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.image.j;
import com.tencent.mobileqq.vas.inject.IVasInject;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.IVasNamePlateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipicon.NamePlateVipType;
import com.tencent.mobileqq.vas.wallpaper.VipWallpaperService;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.vip.api.d;
import com.tencent.mobileqq.vip.api.f;
import com.tencent.mobileqq.vip.api.h;
import com.tencent.mobileqq.vip.api.k;
import com.tencent.mobileqq.vip.n;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$BuyItemReq;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$BuyItemRsp;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$ItemInfo;
import com.tencent.trpcprotocol.tianxuan.commpay.service.QZoneVipPayInfo$PageInfo;
import cooperation.qzone.QUA;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import eipc.EIPCResult;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasInjectImpl implements IVasInject {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements DarkModeManager.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IVasInject.ActionResult f309602a;

        a(IVasInject.ActionResult actionResult) {
            this.f309602a = actionResult;
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            IVasInject.ActionResult actionResult = this.f309602a;
            if (actionResult != null) {
                actionResult.onCancel();
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            IVasInject.ActionResult actionResult = this.f309602a;
            if (actionResult != null) {
                actionResult.onConfirm();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends URLDrawableHandler.Adapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j.a f309604d;

        b(j.a aVar) {
            this.f309604d = aVar;
        }

        @Override // com.tencent.image.URLDrawableHandler.Adapter, com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long j3) {
            this.f309604d.onResult(true);
        }
    }

    private f d(Card card) {
        if (card.isVipOpen(EVIPSPEC.E_SP_BIGCLUB)) {
            return f.b(card.iBigClubVipType);
        }
        if (card.isVipOpen(EVIPSPEC.E_SP_SUPERVIP)) {
            return f.b(card.iSuperVipType);
        }
        if (card.isVipOpen(EVIPSPEC.E_SP_QQVIP)) {
            return f.b(card.iQQVipType);
        }
        return f.f312798b;
    }

    private String e(QZoneVipPayInfo$BuyItemRsp qZoneVipPayInfo$BuyItemRsp, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (qZoneVipPayInfo$BuyItemRsp.payMode.get() == 2) {
                jSONObject.put("productid", qZoneVipPayInfo$BuyItemRsp.monthInfo.productId.get());
                jSONObject.put("app_id", qZoneVipPayInfo$BuyItemRsp.monthInfo.midasAppid.get());
                jSONObject.put("billno", qZoneVipPayInfo$BuyItemRsp.monthInfo.orderId.get());
                jSONObject.put("vip_ma", qZoneVipPayInfo$BuyItemRsp.monthInfo.discountId.get());
                jSONObject.put("monthMode", qZoneVipPayInfo$BuyItemRsp.monthInfo.monthMode.get());
                jSONObject.put("monthVipType", qZoneVipPayInfo$BuyItemRsp.monthInfo.monthVipType.get());
                jSONObject.put("discountType", qZoneVipPayInfo$BuyItemRsp.monthInfo.discountType.get());
                jSONObject.put("serviceType", qZoneVipPayInfo$BuyItemRsp.monthInfo.serviceType.get());
                jSONObject.put("month", qZoneVipPayInfo$BuyItemRsp.monthInfo.monthNum.get());
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str2);
                jSONObject.put("aid", str);
                jSONObject.put("userId", str2);
            } else {
                jSONObject.put("productId", qZoneVipPayInfo$BuyItemRsp.picInfo.productId.get());
                jSONObject.put(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "skey");
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, "uin");
                jSONObject.put(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str2);
                jSONObject.put("aid", str);
                jSONObject.put("zoneId", qZoneVipPayInfo$BuyItemRsp.picInfo.zoneId.get());
                jSONObject.put("tokenUrl", qZoneVipPayInfo$BuyItemRsp.picInfo.midasUrlParams.get());
                jSONObject.put("userId", str2);
                jSONObject.put("offerId", qZoneVipPayInfo$BuyItemRsp.picInfo.midasAppid.get());
                jSONObject.put("numberVisible", false);
                jSONObject.put(AdParam.PF, f(str));
            }
            jSONObject.put("reportData", qZoneVipPayInfo$BuyItemRsp.reportData.get());
        } catch (JSONException e16) {
            QLog.e(IVipPayApi.PAY_TAG, 1, " handle sendMsgForGetPayInfo error" + e16);
        }
        return jSONObject.toString();
    }

    private String f(String str) {
        return IVipPayApi.PF_PREFIX + str + "*" + QUA.getQUA3() + IVipPayApi.PF_SUFFIX;
    }

    private String g() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(qQAppInterface, true, null);
        String string = ThemeSwitchUtil.getPreviousThemeIdVersion(qQAppInterface).getString("themeID");
        if (TextUtils.isEmpty(string)) {
            string = "1000";
        }
        if (isNowThemeIsNight) {
            return "1103";
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(final k kVar, String str, String str2, Activity activity, int i3, boolean z16, Object obj) {
        new EIPCResult().data = new Bundle();
        if (obj == null) {
            return;
        }
        final QZoneVipPayInfo$BuyItemRsp qZoneVipPayInfo$BuyItemRsp = new QZoneVipPayInfo$BuyItemRsp();
        try {
            qZoneVipPayInfo$BuyItemRsp.mergeFrom((byte[]) obj);
            if (qZoneVipPayInfo$BuyItemRsp.code.get() != 0) {
                QLog.e(IVipPayApi.PAY_TAG, 1, " handleGetPayOrPrivilegeInfoError rsp.code is" + qZoneVipPayInfo$BuyItemRsp.code.get());
                kVar.c(qZoneVipPayInfo$BuyItemRsp.code.get(), qZoneVipPayInfo$BuyItemRsp.f381667msg.get());
                return;
            }
            final String e16 = e(qZoneVipPayInfo$BuyItemRsp, str, str2);
            if (qZoneVipPayInfo$BuyItemRsp.payMode.get() == 2) {
                if (kVar instanceof h) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.inject.VasInjectImpl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            ((h) kVar).b(qZoneVipPayInfo$BuyItemRsp.monthInfo.discountId.get(), qZoneVipPayInfo$BuyItemRsp.monthInfo.orderId.get(), e16);
                        }
                    });
                    return;
                }
                return;
            }
            ((IVipPayApi) QRoute.api(IVipPayApi.class)).newPay(e(qZoneVipPayInfo$BuyItemRsp, str, str2), 7, "vip.qq.com", IVipPayApi.METHOD_BUYGOODS, activity, kVar);
        } catch (Exception e17) {
            QLog.e(IVipPayApi.PAY_TAG, 1, " handle sendMsgForGetPayInfo error e" + e17);
            kVar.c(-1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Context context, JSONObject jSONObject, DialogInterface dialogInterface, int i3) {
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, jSONObject.optString("dialog-url", IVasNamePlateUtil.DEFAULT_URL));
        dialogInterface.dismiss();
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean containsKeyword(String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return TroopKeywordManager.e(peekAppRuntime).d(str2, str);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean darkModeUserSetThemeAction(Activity activity, String str, IVasInject.ActionResult actionResult) {
        return DarkModeManager.w(activity, str, new a(actionResult));
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void forceUpdateVasUserData(int i3) {
        if (i3 == 0) {
            new j13.b().b(MobileQQ.sMobileQQ.peekAppRuntime());
        } else if (i3 == 1) {
            new ChatBackgroundAuth().h(Boolean.TRUE);
        } else if (i3 == 2) {
            ((VipSetFunCallHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).Q2(1, null, true);
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public String getChatBackgroundId(String str) {
        return ((ChatBackgroundManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).m(str);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public IVasRecentData.FriendsVipData getVipIconInfo(Card card) {
        IVasRecentData.FriendsVipData friendsVipData = new IVasRecentData.FriendsVipData();
        int i3 = card.nameplateVipType;
        int i16 = 0;
        if (i3 > 0) {
            friendsVipData.setVipType(i3);
            friendsVipData.setGrayNameplateFlag(card.grayNameplateFlag);
            f b16 = f.b(friendsVipData.getVipType());
            if (b16.c()) {
                friendsVipData.setVipLevel(card.iBigClubVipLevel);
                friendsVipData.setNamePlateId((int) card.lBigClubTemplateId);
                if (!TextUtils.isEmpty(card.vipIcons)) {
                    int[] vipIconsArray = d.a().getVipIconsArray(card.vipIcons);
                    int length = vipIconsArray.length;
                    while (i16 < length) {
                        friendsVipData.getCarouselNamePlateIds().add(Integer.valueOf(vipIconsArray[i16]));
                        i16++;
                    }
                }
            } else if (b16.e()) {
                friendsVipData.setVipLevel(card.iSuperVipLevel);
                friendsVipData.setNamePlateId((int) card.lSuperVipTemplateId);
                if (!TextUtils.isEmpty(card.vipIcons)) {
                    int[] vipIconsArray2 = d.a().getVipIconsArray(card.vipIcons);
                    int length2 = vipIconsArray2.length;
                    while (i16 < length2) {
                        friendsVipData.getCarouselNamePlateIds().add(Integer.valueOf(vipIconsArray2[i16]));
                        i16++;
                    }
                }
            } else if (b16.d()) {
                friendsVipData.setVipLevel(card.iSuperVipLevel);
                friendsVipData.setNamePlateId(0);
            }
        } else {
            f d16 = d(card);
            if (d16.c()) {
                friendsVipData.setVipLevel(card.iBigClubVipLevel);
                friendsVipData.setNamePlateId((int) card.lBigClubTemplateId);
            } else if (d16.e()) {
                friendsVipData.setVipLevel(card.iSuperVipLevel);
                friendsVipData.setNamePlateId((int) card.lSuperVipTemplateId);
            } else if (d16.d()) {
                friendsVipData.setVipLevel(card.iSuperVipLevel);
                friendsVipData.setNamePlateId(0);
            }
            friendsVipData.setVipType(d16.f312805a);
        }
        friendsVipData.setVipIconEx(card.nameplateExtId);
        if (QLog.isColorLevel()) {
            VasLogNtReporter.getVipIcon().reportDebug("Card.FriendsVipData[" + card.uin + "] vipDataFlag:" + card.vipDataFlag + " vipStartFlag:" + card.vipStarFlag + " vipType:" + friendsVipData.getVipType() + " vipLevel:" + friendsVipData.getVipLevel() + " namePlateId:" + friendsVipData.getNamePlateId() + " carouselNamePlateIds:" + friendsVipData.getCarouselNamePlateIds() + " diyNamePlateItemId:" + friendsVipData.getDiyNamePlateItemId() + " vipIconEx:" + friendsVipData.getVipIconEx());
        }
        return friendsVipData;
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean isApngSoLoaded() {
        return an.h().isLoaded();
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean isShowColorName() {
        return ((FriendsManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER)).h0();
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean isShowGameIcon() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Card r16 = ((FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(peekAppRuntime.getCurrentUin());
        boolean checkGameCardAble = VasUtil.getService().getGameCardManager().checkGameCardAble(r16.namePlateOfKingDanDisplatSwitch, r16.gameCardId);
        if (!r16.namePlateOfKingDanDisplatSwitch && !checkGameCardAble) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean isShowTroopLiang() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return !((FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(peekAppRuntime.getCurrentAccountUin()).isHidePrettyGroutIdentity;
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean isShowTroopVipIcon() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IVipStatusManager vipStatus = VasUtil.getSignedService(peekAppRuntime).getVipStatus();
        boolean isBigClub = vipStatus.isBigClub();
        boolean isStar = vipStatus.isStar();
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(peekAppRuntime.getCurrentAccountUin());
        if ((isStar && NamePlateVipType.convert(friendsVipData.getVipType()).atLeastSuperVip()) || (isBigClub && NamePlateVipType.convert(friendsVipData.getVipType()).isBigVip())) {
            z16 = true;
        } else {
            z16 = false;
        }
        IBizTroopInfoService iBizTroopInfoService = (IBizTroopInfoService) peekAppRuntime.getRuntimeService(IBizTroopInfoService.class, "");
        if (!z16) {
            return false;
        }
        return iBizTroopInfoService.isShowTroopBigClub();
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public boolean isShowVipIconForSimpleMode() {
        return ff.d();
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void itemLyPay(final String str, final String str2, int i3, int i16, String str3, final Activity activity, final k kVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof AppInterface) && !TextUtils.isEmpty(peekAppRuntime.getCurrentUin())) {
            QZoneVipPayInfo$BuyItemReq qZoneVipPayInfo$BuyItemReq = new QZoneVipPayInfo$BuyItemReq();
            QZoneVipPayInfo$ItemInfo qZoneVipPayInfo$ItemInfo = new QZoneVipPayInfo$ItemInfo();
            qZoneVipPayInfo$ItemInfo.itemExtendInfo.set("");
            qZoneVipPayInfo$ItemInfo.itemId.set(str3);
            qZoneVipPayInfo$ItemInfo.itemSubId.set("");
            qZoneVipPayInfo$ItemInfo.businessType.set(i3);
            qZoneVipPayInfo$ItemInfo.buyNum.set(i16);
            QZoneVipPayInfo$PageInfo qZoneVipPayInfo$PageInfo = new QZoneVipPayInfo$PageInfo();
            qZoneVipPayInfo$PageInfo.aid.set(str2);
            qZoneVipPayInfo$PageInfo.qua.set(QUA.getQUA3());
            qZoneVipPayInfo$BuyItemReq.businessType.set(i3);
            qZoneVipPayInfo$BuyItemReq.clientPlat.set(1);
            qZoneVipPayInfo$BuyItemReq.pageInfo.set(qZoneVipPayInfo$PageInfo);
            qZoneVipPayInfo$BuyItemReq.itemList.add(qZoneVipPayInfo$ItemInfo);
            n.request(IVipPayApi.CMD, qZoneVipPayInfo$BuyItemReq.toByteArray(), new BusinessObserver() { // from class: com.tencent.mobileqq.vas.inject.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i17, boolean z16, Object obj) {
                    VasInjectImpl.this.h(kVar, str2, str, activity, i17, z16, obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void loadApngSo(j.a aVar) {
        an.h().load(new b(aVar));
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public View.OnClickListener newClickListener(String str, String str2) {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
            return ff.j.a.f((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), str, str2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void openUrl(Activity activity, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isLaunchByMiniApp(activity)) {
                ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).openUrl(activity, str);
            } else {
                UiApiPlugin.g0(activity, null, (AppInterface) peekAppRuntime, str, true, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void preloadKuiklyBundle(String str, String str2) {
        if (!((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).isDexPageExist(str, str2)) {
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(str, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void publicAccountTianshuReport(int i3, int i16, String str, String str2) {
        PublicAccountEventReport.b(i3, i16, str, str2);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void quickSwitchDefaultMode(final Function1<JSONObject, Unit> function1) {
        final JSONObject jSONObject = new JSONObject();
        ThemeSwitcher.startSwitch(g(), ThemeReporter.FROM_SIMPLE, new ThemeSwitchCallback() { // from class: com.tencent.mobileqq.vas.inject.VasInjectImpl.2
            @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
            public boolean postSwitch(int i3) {
                int i16;
                if (i3 == 0) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                try {
                    jSONObject.put("result", i16);
                    jSONObject.put("mode", SimpleUIUtil.getCurrentMode(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()));
                    function1.invoke(jSONObject);
                    return true;
                } catch (JSONException unused) {
                    function1.invoke(jSONObject);
                    return false;
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void requestCheckLoveState(String str) {
        new cooperation.vip.manager.a().f(str);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void setShowColorName(boolean z16) {
        ((FriendsManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.FRIENDS_MANAGER)).A0(z16);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void setShowTroopLiang(boolean z16) {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        ((CardHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).p5(z16);
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card r16 = friendsManager.r(qQAppInterface.getCurrentAccountUin());
        if (r16 != null) {
            r16.isHidePrettyGroutIdentity = !z16;
            if (!friendsManager.p0(r16)) {
                QLog.e("setShowTroopLiang", 1, "onGetPrettyOwnerFlag save card flag=" + z16 + " failed");
                return;
            }
            QLog.i("setShowTroopLiang", 1, "onGetPrettyOwnerFlag save card flag=" + z16 + " success");
            return;
        }
        QLog.e("setShowTroopLiang", 1, "onGetPrettyOwnerFlag save card failed because card is null");
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void setShowTroopVipIcon(final Context context, boolean z16) {
        boolean z17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IVipStatusManager vipStatus = VasUtil.getSignedService(peekAppRuntime).getVipStatus();
        boolean isBigClub = vipStatus.isBigClub();
        boolean isStar = vipStatus.isStar();
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(peekAppRuntime.getCurrentAccountUin());
        if ((isStar && NamePlateVipType.convert(friendsVipData.getVipType()).atLeastSuperVip()) || (isBigClub && NamePlateVipType.convert(friendsVipData.getVipType()).isBigVip())) {
            z17 = true;
        } else {
            z17 = false;
        }
        IBizTroopInfoService iBizTroopInfoService = (IBizTroopInfoService) peekAppRuntime.getRuntimeService(IBizTroopInfoService.class, "");
        if (z17) {
            iBizTroopInfoService.setShowTroopBigClub(z16);
            return;
        }
        final JSONObject json = VasLongToggle.NAMEPLATE_SWITCH_CONFIG.getJson();
        String optString = json.optString("message", "\u4ec5\u5927\u4f1a\u5458\u3001SVIP STAR\uff08SVIP 10\uff09\u7528\u6237\u53ef\u5728\u7fa4\u5185\u5c55\u793a\u8eab\u4efd\u94ed\u724c\uff0c\u70b9\u51fb\u524d\u5f80\u94ed\u724c\u9986\u83b7\u53d6\u8eab\u4efd");
        if (VasNormalToggle.BUG_NAMEPLATE_SWICH_TEXT.isEnable(true)) {
            if (isStar) {
                optString = json.optString("message-vipstar", "SVIP star\uff08SVIP 10\uff09\u7528\u6237\u8bbe\u7f6e\u8d85\u7ea7\u4f1a\u5458\u3001\u5927\u4f1a\u5458\u8eab\u4efd\u94ed\u724c\uff08\u5305\u62ec\u4e2a\u6027\u5316\u94ed\u724c\u6837\u5f0f\uff09\uff0c\u53ef\u5728\u7fa4\u5185\u5c55\u793a\uff0c\u53ef\u70b9\u51fb\u524d\u5f80\u94ed\u724c\u9986\u8bbe\u7f6e\u94ed\u724c");
            } else if (isBigClub) {
                optString = json.optString("message-bigvip", "\u5927\u4f1a\u5458\u7528\u6237\u8bbe\u7f6e\u5927\u4f1a\u5458\u8eab\u4efd\u94ed\u724c\uff0c\u53ef\u5728\u7fa4\u5185\u5c55\u793a\uff0c\u53ef\u70b9\u51fb\u524d\u5f80\u94ed\u724c\u9986\u8bbe\u7f6e\u6210\u5927\u4f1a\u5458\u94ed\u724c");
            }
        }
        DialogUtil.createCenterTextDialog(context, 230, json.optString("tittle", "\u4f60\u6682\u672a\u62e5\u6709\u7fa4\u5916\u663e\u94ed\u724c\u8d44\u683c"), optString, json.optString("negative", "\u53d6\u6d88"), json.optString("positive", "\u786e\u8ba4"), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.inject.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VasInjectImpl.i(context, json, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.inject.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        }).show();
        if (isBigClub || isStar) {
            iBizTroopInfoService.setShowTroopBigClub(true);
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void setShowVipIconForSimpleMode(boolean z16) {
        ff.V(z16);
        ((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(115, z16, null);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void startForwardFriendListActivity(Activity activity, IGXHManager.FriendSelectParams friendSelectParams) {
        Intent intent = new Intent(activity, (Class<?>) ForwardFriendListActivity.class);
        intent.putExtra("only_single_selection", friendSelectParams.isSingle);
        intent.putExtra("key_forward_is_show_troop", friendSelectParams.isShowTroop);
        if (!TextUtils.isEmpty(friendSelectParams.troopEnterTitle)) {
            intent.putExtra("extra_troop_entrance_title", friendSelectParams.troopEnterTitle);
        }
        intent.putExtra("key_forward_is_show_guild", friendSelectParams.isShowGuild);
        intent.putExtra("extra_mini_mode", friendSelectParams.isMiniMode);
        intent.putExtra("extra_show_friend_first", friendSelectParams.isShowFriendFirst);
        intent.putExtra("extra_max_num", friendSelectParams.maxNum);
        if (!TextUtils.isEmpty(friendSelectParams.title)) {
            intent.putExtra("extra_forward_title", friendSelectParams.title);
        }
        if (!TextUtils.isEmpty(friendSelectParams.finishText)) {
            intent.putExtra("extra_select_finish_text", friendSelectParams.finishText);
        }
        intent.putExtra("extra_choose_friend", 9);
        intent.putExtra("call_by_forward", false);
        activity.startActivityForResult(intent, friendSelectParams.requestCode);
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public JSONObject wallpaperSetChatBg(Activity activity, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if ("0".equals(str)) {
                VipWallpaperService.f(activity, new VipWallpaperService.c(), null);
                jSONObject.put("result", "0");
                jSONObject.put("msg", "\u6062\u590d\u7cfb\u7edf\u58c1\u7eb8");
            } else {
                String shopBgPath = ChatBackgroundUtil.getShopBgPath(str);
                if (new File(shopBgPath).exists()) {
                    AtomicBoolean atomicBoolean = new AtomicBoolean();
                    VipWallpaperService.f(activity, new VipWallpaperService.c(str, shopBgPath, ""), atomicBoolean);
                    jSONObject.put("result", "0");
                    jSONObject.put("msg", "\u8bbe\u7f6e\u6210\u529f");
                    if (atomicBoolean.get()) {
                        jSONObject.put("isGoOut", true);
                    }
                } else {
                    jSONObject.put("result", "1");
                    jSONObject.put("msg", "\u7d20\u6750\u4e0d\u5b58\u5728");
                }
            }
        } catch (JSONException e16) {
            QLog.e("wallpaperSetChatBg", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.vas.inject.IVasInject
    public void itemLyPay(String str, String str2, String str3, Activity activity, k kVar) {
        itemLyPay(str, str2, 100, 1, str3, activity, kVar);
    }
}
