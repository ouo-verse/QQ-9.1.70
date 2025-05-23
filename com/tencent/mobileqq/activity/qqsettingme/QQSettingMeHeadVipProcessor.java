package com.tencent.mobileqq.activity.qqsettingme;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.bussiness.diamondwall.AnimatorHandler;
import com.tencent.mobileqq.profilecard.component.ProfileCardComponentConstant;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconBusiness;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.IVasQQSettingMe;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.QVipMedalView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.mobilereport.MobileReportManager;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.PAGView;

/* loaded from: classes10.dex */
public class QQSettingMeHeadVipProcessor extends com.tencent.mobileqq.processor.c implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    public static String f184676p;

    /* renamed from: h, reason: collision with root package name */
    public boolean f184677h;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.g> f184678i;

    /* renamed from: j, reason: collision with root package name */
    public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> f184679j;

    /* renamed from: k, reason: collision with root package name */
    public MutableLiveData<BusinessInfoCheckUpdate.AppInfo> f184680k;

    /* renamed from: l, reason: collision with root package name */
    private QQValuePagView f184681l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f184682m;

    /* renamed from: n, reason: collision with root package name */
    private final VipGrayConfigHelper.VipGrayConfigListener f184683n;

    /* renamed from: o, reason: collision with root package name */
    private final SVIPObserver f184684o;

    /* loaded from: classes10.dex */
    class a implements VipGrayConfigHelper.VipGrayConfigListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeHeadVipProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.VipGrayConfigHelper.VipGrayConfigListener
        public void jsonParseOver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMeBaseProcessor", 2, "enterWordListener");
                }
                QQSettingMeHeadVipProcessor.this.e();
            }
        }
    }

    /* loaded from: classes10.dex */
    class b extends SVIPObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeHeadVipProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onChangeSimpleModeNamePlateSwitch(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                QQSettingMeHeadVipProcessor.this.e();
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onVipStatusChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "updateLevelAndVip from mVipInfoChangedObserver");
            }
            QQSettingMeHeadVipProcessor.this.e();
        }
    }

    /* loaded from: classes10.dex */
    class c implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.g> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184694d;

        c(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184694d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeHeadVipProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            this.f184694d.D(gVar);
            this.f184694d.G(gVar);
            QQSettingMeHeadVipProcessor.this.D(gVar);
            this.f184694d.k().G.postValue(gVar);
        }
    }

    /* loaded from: classes10.dex */
    class d implements Observer<BusinessInfoCheckUpdate.AppInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184696d;

        d(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184696d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeHeadVipProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfo);
            } else {
                this.f184696d.B(appInfo);
                this.f184696d.k().H.postValue(appInfo);
            }
        }
    }

    /* loaded from: classes10.dex */
    class e implements Observer<BusinessInfoCheckUpdate.AppInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184698d;

        e(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184698d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeHeadVipProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(BusinessInfoCheckUpdate.AppInfo appInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfo);
            } else {
                this.f184698d.C(appInfo);
                this.f184698d.k().I.postValue(appInfo);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69020);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f184676p = "https://ti.qq.com/qqlevel/index?_wv=3&_wwv=1&tab=7&source=28";
        }
    }

    public QQSettingMeHeadVipProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184678i = new MutableLiveData<>(new com.tencent.mobileqq.activity.qqsettingme.bean.g());
        this.f184679j = new MutableLiveData<>();
        this.f184680k = new MutableLiveData<>();
        this.f184683n = new a();
        this.f184684o = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        ThreadManagerV2.excute(new Runnable(localRedTouchManager, localRedTouchManager.j(10015), localRedTouchManager.j(10016)) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ LocalRedTouchManager f184689d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RedTouchItem f184690e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ RedTouchItem f184691f;

            {
                this.f184689d = localRedTouchManager;
                this.f184690e = r7;
                this.f184691f = r8;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQSettingMeHeadVipProcessor.this, localRedTouchManager, r7, r8);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                boolean z16 = false;
                if (((IUtil) QRoute.api(IUtil.class)).checkMedalRedPointConfig(peekAppRuntime) && (this.f184689d.d(this.f184690e, false) || this.f184689d.d(this.f184691f, false))) {
                    z16 = true;
                }
                if (z16) {
                    int h16 = this.f184689d.h();
                    if (h16 != 3) {
                        if (h16 != 4) {
                            if (h16 != 5) {
                                str = null;
                            } else {
                                str = "0X80073B8";
                            }
                        } else {
                            str = "0X8007397";
                        }
                    } else {
                        str = "0X8007392";
                    }
                    String str2 = str;
                    if (str2 != null) {
                        ReportController.o(peekAppRuntime, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                }
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ((IVasQQSettingMe) QRoute.api(IVasQQSettingMe.class)).reqAccountJumpUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:165|(11:167|101|102|103|104|105|(5:107|(3:109|(1:111)(1:125)|112)(2:126|(3:128|(1:130)(1:132)|131)(8:133|134|(5:138|(1:140)(1:142)|141|114|(1:116))|143|(1:145)(1:147)|146|114|(0)))|113|114|(0))(2:148|(1:150)(2:151|(1:153)(3:154|(1:158)|159)))|117|(1:124)(1:121)|122|123)|100|101|102|103|104|105|(0)(0)|117|(1:119)|124|122|123) */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x064b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x064f, code lost:
    
        com.tencent.qphone.base.util.QLog.e(r1, r5, "updateMyVipInfo: ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x064d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x064e, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x058c A[Catch: Exception -> 0x064d, TRY_ENTER, TryCatch #0 {Exception -> 0x064d, blocks: (B:103:0x057a, B:107:0x058c, B:109:0x0590, B:111:0x059c, B:112:0x05a7, B:125:0x05a3, B:126:0x05ab, B:128:0x05af, B:130:0x05bb, B:131:0x05c6, B:132:0x05c2), top: B:102:0x057a }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0612 A[Catch: Exception -> 0x064b, TryCatch #1 {Exception -> 0x064b, blocks: (B:114:0x0608, B:116:0x0612, B:134:0x05ca, B:138:0x05d5, B:140:0x05e1, B:141:0x05ec, B:142:0x05e8, B:143:0x05ef, B:145:0x05fb, B:146:0x0606, B:147:0x0602, B:148:0x061b, B:150:0x0620, B:151:0x0627, B:153:0x062b, B:154:0x0632, B:158:0x063d, B:159:0x0644), top: B:105:0x058a }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x061b A[Catch: Exception -> 0x064b, TryCatch #1 {Exception -> 0x064b, blocks: (B:114:0x0608, B:116:0x0612, B:134:0x05ca, B:138:0x05d5, B:140:0x05e1, B:141:0x05ec, B:142:0x05e8, B:143:0x05ef, B:145:0x05fb, B:146:0x0606, B:147:0x0602, B:148:0x061b, B:150:0x0620, B:151:0x0627, B:153:0x062b, B:154:0x0632, B:158:0x063d, B:159:0x0644), top: B:105:0x058a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0411 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x04be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C() throws JSONException {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str2;
        boolean z26;
        QBaseActivity qBaseActivity;
        String str3;
        int i3;
        boolean z27;
        n23.a c16;
        boolean z28;
        String string;
        String string2;
        String string3;
        String string4;
        boolean z29;
        VipInfoHandler vipInfoHandler;
        int b16;
        if (QLog.isColorLevel()) {
            VasLogNtReporter.getVipIcon().reportDebug("updateDataInner and ui for settingme");
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.g t16 = t();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            return;
        }
        FriendsManager friendsManager = (FriendsManager) peekAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        t16.f184893b = ProfileCardUtil.I(peekAppRuntime, currentUin);
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeBaseProcessor", 2, "updateLevelAndVip card info: bSuperVipOpen= " + ((int) t16.f184893b.bSuperVipOpen) + ", bQQVipOpen = " + ((int) t16.f184893b.bQQVipOpen) + ", VipLevel = " + t16.f184893b.iQQVipLevel + ", QQLevel = " + t16.f184893b.iQQLevel + ", gameId = " + t16.f184893b.namePlateOfKingGameId + ", gameLoginTime = " + t16.f184893b.namePlateOfKingLoginTime + ", lLoginDays = " + t16.f184893b.lLoginDays + ", allowPeopleSee = " + t16.f184893b.allowPeopleSee);
        }
        if (t16.f184893b != null && friendsManager != null) {
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(currentUin), "QQSettingMeBaseProcessor");
            if (vasSimpleInfoWithUid != null) {
                Card card = t16.f184893b;
                EVIPSPEC evipspec = EVIPSPEC.E_SP_QQVIP;
                card.bQQVipOpen = com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec) ? (byte) 1 : (byte) 0;
                Card card2 = t16.f184893b;
                EVIPSPEC evipspec2 = EVIPSPEC.E_SP_SUPERVIP;
                card2.bSuperVipOpen = com.tencent.mobileqq.vip.r.c(vasSimpleInfoWithUid, evipspec2) ? (byte) 1 : (byte) 0;
                t16.f184893b.iQQVipType = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec);
                Card card3 = t16.f184893b;
                if (card3.bSuperVipOpen == 1) {
                    b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec2);
                } else {
                    b16 = com.tencent.mobileqq.vip.r.b(vasSimpleInfoWithUid, evipspec);
                }
                card3.iQQVipLevel = b16;
                Card card4 = t16.f184893b;
                card4.nameplateVipType = vasSimpleInfoWithUid.nameplateVipType;
                card4.grayNameplateFlag = vasSimpleInfoWithUid.grayNameplateFlag;
                card4.nameplateExtId = vasSimpleInfoWithUid.bigClubExtTemplateId;
                card4.vipIcons = vasSimpleInfoWithUid.vipIcons;
                QLog.i("QQSettingMeBaseProcessor", 1, "updateDataInner friend nameplateVipType = " + vasSimpleInfoWithUid.nameplateVipType);
            } else {
                QLog.d("QQSettingMeBaseProcessor", 1, "updateLevelAndVip f= null");
            }
            if (vasSimpleInfoWithUid != null && !TextUtils.isEmpty(vasSimpleInfoWithUid.medalsInfo)) {
                try {
                    t16.f184894c = MedalList.parse(vasSimpleInfoWithUid.medalsInfo);
                    if (QLog.isColorLevel() && t16.f184894c != null) {
                        QLog.d("QVipSettingMe.", 1, "medal list parse result=" + t16.f184894c.convert());
                    }
                } catch (JSONException e16) {
                    QLog.e("QQSettingMeBaseProcessor", 1, "mMedalList convert fail :" + e16);
                }
            } else {
                t16.f184894c = null;
                QLog.e("QQSettingMeBaseProcessor", 1, "mMedalList is null!");
            }
            if (t16.f184894c == null && (vipInfoHandler = (VipInfoHandler) ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)) != null) {
                t16.f184894c = MedalList.parse(vipInfoHandler.G2());
                QLog.i("QQSettingMeBaseProcessor", 1, "mMedalList convert from cache!");
            }
            Card card5 = t16.f184893b;
            if (card5.bSuperVipOpen == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            t16.f184895d = z16;
            if (card5.bQQVipOpen == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            t16.f184896e = z17;
            if (card5.bBigClubVipOpen == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            t16.f184897f = z18;
            t16.f184898g = card5.uCurMulType;
            t16.f184899h = card5.iQQVipLevel;
            QLog.e("QQSettingMeBaseProcessor", 1, "updateLevelAndVip bSuperVipOpen=", Boolean.valueOf(z16), ",bQQVipOpen=", Boolean.valueOf(t16.f184896e), ",VipLevel=", Integer.valueOf(t16.f184899h), ",QQLevel=", Integer.valueOf(t16.f184893b.iQQLevel), ",isDiy=", Boolean.valueOf(t16.f184900i), ",nameplateVipType=", Integer.valueOf(t16.f184893b.nameplateVipType), ",curMulType =", Long.valueOf(t16.f184893b.uCurMulType));
            boolean g16 = ff.j.g(t16.f184893b.nameplateVipType);
            t16.f184900i = g16;
            t16.f184901j = null;
            t16.f184902k = 0;
            if (g16) {
                QLog.i("QQSettingMeBaseProcessor", 1, "use diy, nameplateVipType = " + t16.f184893b.nameplateVipType);
                Card card6 = t16.f184893b;
                t16.f184901j = ff.j.e(peekAppRuntime, card6.uin, com.tencent.mobileqq.vip.api.f.b(card6.nameplateVipType), ff.j.h(t16.f184893b.grayNameplateFlag));
                t16.f184902k = ff.j.c(com.tencent.mobileqq.vip.api.f.b(t16.f184893b.nameplateVipType));
            }
            if (!t16.f184900i) {
                long j3 = t16.f184898g;
                if (j3 != 1 && j3 != 2) {
                    int i16 = R.drawable.bhl;
                    if (j3 != 3 && j3 != 4) {
                        if (j3 == 6) {
                            if (t16.f184897f) {
                                short r16 = ff.r(peekAppRuntime, currentUin, false);
                                t16.f184905n = r16;
                                if ((r16 >> 8) == 3) {
                                    if ((r16 & 15) == 1) {
                                        short s16 = ff.s(peekAppRuntime, currentUin, EVIPSPEC.E_SP_BIGCLUB);
                                        IVipIconUtils a16 = com.tencent.mobileqq.vip.api.c.a();
                                        Card card7 = t16.f184893b;
                                        t16.f184901j = new String[]{a16.getVipIconUrl((s16 >> 8) | ((s16 & 15) << 8), card7.iBigClubVipLevel, card7.lBigClubTemplateId, false)};
                                        t16.f184902k = R.drawable.bhn;
                                    } else {
                                        short s17 = ff.s(peekAppRuntime, currentUin, EVIPSPEC.E_SP_BIGCLUB);
                                        IVipIconUtils a17 = com.tencent.mobileqq.vip.api.c.a();
                                        Card card8 = t16.f184893b;
                                        t16.f184901j = new String[]{a17.getVipIconUrl((s17 >> 8) | ((s17 & 15) << 8), card8.iBigClubVipLevel, card8.lBigClubTemplateId, false)};
                                        t16.f184902k = R.drawable.bhl;
                                    }
                                    z19 = true;
                                    str2 = null;
                                    z26 = z19;
                                    if (!t16.f184900i) {
                                    }
                                    if (t16.f184901j != null) {
                                    }
                                    qBaseActivity = this.f259741b.get();
                                    if (qBaseActivity == null) {
                                    }
                                } else {
                                    str2 = "occur error: curMulType=" + t16.f184898g + " but bBigClubVipOpen userStatus=" + ((int) t16.f184905n);
                                }
                            } else {
                                str2 = "occur error: curMulType=" + t16.f184898g + " but bBigClubVipOpen is false";
                            }
                            z26 = false;
                            if (!t16.f184900i) {
                            }
                            if (t16.f184901j != null) {
                            }
                            qBaseActivity = this.f259741b.get();
                            if (qBaseActivity == null) {
                            }
                        }
                    } else if (t16.f184895d) {
                        short s18 = ff.s(peekAppRuntime, t16.f184893b.uin, EVIPSPEC.E_SP_SUPERVIP);
                        int i17 = s18 & 15;
                        if (i17 == 1) {
                            z29 = true;
                        } else {
                            z29 = false;
                        }
                        t16.f184901j = new String[]{com.tencent.mobileqq.vip.api.c.a().getVipIconUrl((s18 >> 8) | (i17 << 8), t16.f184899h, t16.f184893b.lSuperVipTemplateId, false)};
                        if (z29) {
                            i16 = R.drawable.bhn;
                        }
                        t16.f184902k = i16;
                        z19 = true;
                        str2 = null;
                        z26 = z19;
                        if (!t16.f184900i) {
                        }
                        if (t16.f184901j != null) {
                        }
                        qBaseActivity = this.f259741b.get();
                        if (qBaseActivity == null) {
                        }
                    } else {
                        str2 = "occur error: curMulType=" + t16.f184898g + " but bSuperVipOpen is false";
                        z26 = false;
                        if (!t16.f184900i) {
                        }
                        if (t16.f184901j != null) {
                        }
                        qBaseActivity = this.f259741b.get();
                        if (qBaseActivity == null) {
                        }
                    }
                } else {
                    if (t16.f184896e) {
                        short s19 = ff.s(peekAppRuntime, t16.f184893b.uin, EVIPSPEC.E_SP_QQVIP);
                        t16.f184901j = new String[]{com.tencent.mobileqq.vip.api.c.a().getVipIconUrl((s19 >> 8) | ((s19 & 15) << 8), t16.f184899h, t16.f184893b.lSuperVipTemplateId, false)};
                        t16.f184902k = R.drawable.bhm;
                        z19 = true;
                        str2 = null;
                        z26 = z19;
                        if (!t16.f184900i && !z26) {
                            if (TextUtils.isEmpty(str2)) {
                                QLog.e("QQSettingMeBaseProcessor", 1, str2);
                            } else {
                                QLog.e("QQSettingMeBaseProcessor", 1, "it have not handle curMulType=" + t16.f184898g);
                            }
                            if (!t16.f184895d) {
                                short s26 = ff.s(peekAppRuntime, t16.f184893b.uin, EVIPSPEC.E_SP_SUPERVIP);
                                t16.f184901j = new String[]{com.tencent.mobileqq.vip.api.c.a().getVipIconUrl((s26 >> 8) | ((s26 & 15) << 8), t16.f184899h, t16.f184893b.lSuperVipTemplateId, false)};
                                t16.f184902k = R.drawable.bhn;
                            } else if (t16.f184896e) {
                                short s27 = ff.s(peekAppRuntime, t16.f184893b.uin, EVIPSPEC.E_SP_QQVIP);
                                t16.f184901j = new String[]{com.tencent.mobileqq.vip.api.c.a().getVipIconUrl((s27 >> 8) | ((s27 & 15) << 8), t16.f184899h, t16.f184893b.lSuperVipTemplateId, false)};
                                t16.f184902k = R.drawable.bhm;
                            }
                        }
                        if (t16.f184901j != null && t16.f184902k != 0) {
                            ff.j.b.c((QQAppInterface) peekAppRuntime, t16.f184893b.uin, "VIA_SETTINGME").d();
                        }
                        qBaseActivity = this.f259741b.get();
                        if (qBaseActivity == null) {
                            return;
                        }
                        t16.f184903l = 0;
                        MedalList medalList = t16.f184894c;
                        if (medalList == null || medalList.infoList.size() <= 0) {
                            str3 = "QQSettingMeBaseProcessor";
                            if (QLog.isColorLevel()) {
                                i3 = 1;
                                QLog.d("QVipSettingMe.", 1, "medal list is null");
                                t16.f184904m = t16.f184893b.mQQLevelType;
                                SharedPreferences preferences = peekAppRuntime.getPreferences();
                                Resources resources = qBaseActivity.getResources();
                                t16.f184892a = resources.getString(R.string.fse);
                                z27 = LocaleManager.isLocaleCN();
                                if (!z27) {
                                    if (t16.f184895d) {
                                        if (!TextUtils.isEmpty(VipGrayConfigHelper.getsInstance().svipStr)) {
                                            string4 = VipGrayConfigHelper.getsInstance().svipStr;
                                        } else {
                                            string4 = resources.getString(R.string.fsg);
                                        }
                                        t16.f184892a = string4;
                                    } else if (t16.f184896e) {
                                        if (!TextUtils.isEmpty(VipGrayConfigHelper.getsInstance().vipStr)) {
                                            string3 = VipGrayConfigHelper.getsInstance().vipStr;
                                        } else {
                                            string3 = resources.getString(R.string.fsh);
                                        }
                                        t16.f184892a = string3;
                                    } else {
                                        z27 = false;
                                        z27 = false;
                                        int i18 = preferences.getInt(AppConstants.Preferences.KEY_SELFVIP_GROWTHVALUE, 0);
                                        if (t16.f184899h <= 0 && i18 <= 0) {
                                            if (!TextUtils.isEmpty(VipGrayConfigHelper.getsInstance().notVipStr)) {
                                                string2 = VipGrayConfigHelper.getsInstance().notVipStr;
                                            } else {
                                                string2 = resources.getString(R.string.fse);
                                            }
                                            t16.f184892a = string2;
                                            if (t16.f184892a.length() > 8) {
                                                t16.f184892a = t16.f184892a.substring(z27 ? 1 : 0, 8);
                                            }
                                        }
                                        if (!TextUtils.isEmpty(VipGrayConfigHelper.getsInstance().outDateVipStr)) {
                                            string = VipGrayConfigHelper.getsInstance().outDateVipStr;
                                        } else {
                                            string = resources.getString(R.string.fsf);
                                        }
                                        t16.f184892a = string;
                                        if (t16.f184892a.length() > 8) {
                                        }
                                    }
                                    z27 = false;
                                    if (t16.f184892a.length() > 8) {
                                    }
                                } else {
                                    z27 = false;
                                    z27 = false;
                                    z27 = false;
                                    z27 = false;
                                    if (t16.f184895d) {
                                        t16.f184892a = resources.getString(R.string.fsg);
                                    } else if (t16.f184896e) {
                                        t16.f184892a = resources.getString(R.string.fsh);
                                    } else {
                                        int i19 = preferences.getInt(AppConstants.Preferences.KEY_SELFVIP_GROWTHVALUE, 0);
                                        if (t16.f184899h <= 0 && i19 <= 0) {
                                            t16.f184892a = resources.getString(R.string.fse);
                                        }
                                        t16.f184892a = resources.getString(R.string.fsf);
                                    }
                                }
                                t16.f184906o = com.tencent.mobileqq.vip.o.a().h((QQAppInterface) peekAppRuntime, 4);
                                VipGrayConfigHelper vipGrayConfigHelper = VipGrayConfigHelper.getsInstance();
                                String currentUin2 = peekAppRuntime.getCurrentUin();
                                boolean z36 = t16.f184895d;
                                Card card9 = t16.f184893b;
                                t16.f184907p = vipGrayConfigHelper.showNamePlateOfKing(currentUin2, z36, card9.namePlateOfKingLoginTime, card9.namePlateOfKingDanDisplatSwitch, card9.gameCardId);
                                c16 = m23.b.b().c(peekAppRuntime.getCurrentUin());
                                if (c16 == null && c16.f418039f == 0) {
                                    z28 = i3;
                                } else {
                                    z28 = z27;
                                }
                                t16.f184908q = z28;
                                this.f184678i.postValue(t16);
                                return;
                            }
                            i3 = 1;
                            t16.f184904m = t16.f184893b.mQQLevelType;
                            SharedPreferences preferences2 = peekAppRuntime.getPreferences();
                            Resources resources2 = qBaseActivity.getResources();
                            t16.f184892a = resources2.getString(R.string.fse);
                            z27 = LocaleManager.isLocaleCN();
                            if (!z27) {
                            }
                            t16.f184906o = com.tencent.mobileqq.vip.o.a().h((QQAppInterface) peekAppRuntime, 4);
                            VipGrayConfigHelper vipGrayConfigHelper2 = VipGrayConfigHelper.getsInstance();
                            String currentUin22 = peekAppRuntime.getCurrentUin();
                            boolean z362 = t16.f184895d;
                            Card card92 = t16.f184893b;
                            t16.f184907p = vipGrayConfigHelper2.showNamePlateOfKing(currentUin22, z362, card92.namePlateOfKingLoginTime, card92.namePlateOfKingDanDisplatSwitch, card92.gameCardId);
                            c16 = m23.b.b().c(peekAppRuntime.getCurrentUin());
                            if (c16 == null) {
                            }
                            z28 = z27;
                            t16.f184908q = z28;
                            this.f184678i.postValue(t16);
                            return;
                        }
                        t16.f184903l = (t16.f184894c.infoList.size() * UIUtils.b(qBaseActivity, 26.0f)) - UIUtils.b(qBaseActivity, 6.0f);
                        if (QLog.isColorLevel()) {
                            QLog.d("QVipSettingMe.", 1, "width =" + t16.f184903l + "update medal:" + t16.f184894c.convert());
                        }
                        if (this.f184677h) {
                            str3 = "QQSettingMeBaseProcessor";
                            i3 = 1;
                            t16.f184904m = t16.f184893b.mQQLevelType;
                            SharedPreferences preferences22 = peekAppRuntime.getPreferences();
                            Resources resources22 = qBaseActivity.getResources();
                            t16.f184892a = resources22.getString(R.string.fse);
                            z27 = LocaleManager.isLocaleCN();
                            if (!z27) {
                            }
                            t16.f184906o = com.tencent.mobileqq.vip.o.a().h((QQAppInterface) peekAppRuntime, 4);
                            VipGrayConfigHelper vipGrayConfigHelper22 = VipGrayConfigHelper.getsInstance();
                            String currentUin222 = peekAppRuntime.getCurrentUin();
                            boolean z3622 = t16.f184895d;
                            Card card922 = t16.f184893b;
                            t16.f184907p = vipGrayConfigHelper22.showNamePlateOfKing(currentUin222, z3622, card922.namePlateOfKingLoginTime, card922.namePlateOfKingDanDisplatSwitch, card922.gameCardId);
                            c16 = m23.b.b().c(peekAppRuntime.getCurrentUin());
                            if (c16 == null) {
                            }
                            z28 = z27;
                            t16.f184908q = z28;
                            this.f184678i.postValue(t16);
                            return;
                        }
                        this.f184677h = true;
                        str3 = "QQSettingMeBaseProcessor";
                        ReportController.o(peekAppRuntime, "dc00898", "", "", "qvip", "0X800A126", 0, 0, String.valueOf(VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), false)), "", "", "");
                        i3 = 1;
                        t16.f184904m = t16.f184893b.mQQLevelType;
                        SharedPreferences preferences222 = peekAppRuntime.getPreferences();
                        Resources resources222 = qBaseActivity.getResources();
                        t16.f184892a = resources222.getString(R.string.fse);
                        z27 = LocaleManager.isLocaleCN();
                        if (!z27) {
                        }
                        t16.f184906o = com.tencent.mobileqq.vip.o.a().h((QQAppInterface) peekAppRuntime, 4);
                        VipGrayConfigHelper vipGrayConfigHelper222 = VipGrayConfigHelper.getsInstance();
                        String currentUin2222 = peekAppRuntime.getCurrentUin();
                        boolean z36222 = t16.f184895d;
                        Card card9222 = t16.f184893b;
                        t16.f184907p = vipGrayConfigHelper222.showNamePlateOfKing(currentUin2222, z36222, card9222.namePlateOfKingLoginTime, card9222.namePlateOfKingDanDisplatSwitch, card9222.gameCardId);
                        c16 = m23.b.b().c(peekAppRuntime.getCurrentUin());
                        if (c16 == null) {
                        }
                        z28 = z27;
                        t16.f184908q = z28;
                        this.f184678i.postValue(t16);
                        return;
                    }
                    str2 = "occur error: curMulType=" + t16.f184898g + " but bQQVipOpen is false";
                    z26 = false;
                    if (!t16.f184900i) {
                        if (TextUtils.isEmpty(str2)) {
                        }
                        if (!t16.f184895d) {
                        }
                    }
                    if (t16.f184901j != null) {
                        ff.j.b.c((QQAppInterface) peekAppRuntime, t16.f184893b.uin, "VIA_SETTINGME").d();
                    }
                    qBaseActivity = this.f259741b.get();
                    if (qBaseActivity == null) {
                    }
                }
            }
            z19 = false;
            str2 = null;
            z26 = z19;
            if (!t16.f184900i) {
            }
            if (t16.f184901j != null) {
            }
            qBaseActivity = this.f259741b.get();
            if (qBaseActivity == null) {
            }
        } else if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateLevelAndVip error card ");
            if (t16.f184893b != null) {
                str = "not null";
            } else {
                str = "null";
            }
            sb5.append(str);
            QLog.d("QQSettingMeBaseProcessor", 2, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(com.tencent.mobileqq.activity.qqsettingme.bean.g gVar) {
        if (QLog.isColorLevel()) {
            QLog.i("QQSettingMeBaseProcessor", 2, "updateMyVipInfo svip= " + gVar.f184895d + ",vip=" + gVar.f184896e + ",vipLevel=" + gVar.f184899h);
        }
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_identity", Boolean.FALSE);
        QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c("d_vip_identity");
        if (i3 != null && c16 != null) {
            TextView textView = (TextView) i3.findViewById(R.id.umj);
            URLImageView uRLImageView = (URLImageView) i3.findViewById(R.id.umf);
            CharSequence d16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.d("d_vip_identity", gVar.f184892a);
            int i16 = 0;
            if (!gVar.f184906o) {
                textView.setText(d16);
                if (AppSetting.f99565y) {
                    AccessibilityUtil.c(i3, d16, Button.class.getName());
                }
                try {
                    uRLImageView.setImageDrawable(cn.f(BaseApplication.getContext().getResources().getDrawable(c16.j())));
                } catch (Exception e16) {
                    QLog.e("QQSettingMeBaseProcessor", 1, "setDrawableForMenu, ", c16.n(), ", ", e16);
                }
            }
            if (!TextUtils.isEmpty(gVar.f184892a) && !TextUtils.equals(gVar.f184892a, "\u5f00\u901a\u4f1a\u5458")) {
                try {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    VipMMKV.getVipTittle(peekAppRuntime.getApplication()).edit().putString("vipTitleSpKey_" + peekAppRuntime.getCurrentAccountUin() + "_" + LocaleManager.getLocaleId(), gVar.f184892a);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQSettingMeBaseProcessor", 2, "vipText = " + gVar.f184892a);
                    }
                } catch (Exception e17) {
                    QLog.e("QQSettingMeBaseProcessor", 1, "updateMyVipInfo, exception e = ", e17);
                }
            }
            if (com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_vip_identity"))) {
                i16 = 8;
            }
            i3.setVisibility(i16);
        }
    }

    @NonNull
    private com.tencent.mobileqq.activity.qqsettingme.bean.g t() {
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.g> mutableLiveData = this.f184678i;
        if (mutableLiveData == null) {
            return new com.tencent.mobileqq.activity.qqsettingme.bean.g();
        }
        return mutableLiveData.getValue();
    }

    private String u(String str, int i3) {
        return MobileReportManager.getNewReportInfo(str, ((IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(i3)));
    }

    private String v(String str, String str2) {
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        if (!iFeatureRuntimeService.isFeatureSwitchEnable(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, false)) {
            QLog.e("QQSettingMeBaseProcessor", 1, "getToggleUrl, toggle is not enable.");
            return "";
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject(ProfileCardComponentConstant.TOGGLE_SWITCH_QQ_VALUE, "");
        if (jSONObject == null) {
            QLog.e("QQSettingMeBaseProcessor", 1, "getToggleUrl, jsonObject == null");
            return str2;
        }
        if (TextUtils.isEmpty(jSONObject.toString())) {
            QLog.e("QQSettingMeBaseProcessor", 1, "getToggleUrl, jsonObject is empty.");
            return str2;
        }
        return jSONObject.optString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String x(boolean z16, String str) {
        if (z16) {
            String u16 = u(str, BusinessInfoCheckUpdateItem.UIAPPID_LEVEL_ICON);
            if (!TextUtils.isEmpty(u16)) {
                str = str + u16;
            }
        } else {
            str = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(str, IVipTraceDetailReport.FROM.QQSETTINGS_LEVEL);
        }
        return str + "&isVasTheme=1";
    }

    private boolean y(String str, Context context) {
        if (!TextUtils.isEmpty(str) && str.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            com.tencent.mobileqq.utils.ax c16 = com.tencent.mobileqq.utils.bi.c((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, str);
            if (c16 != null) {
                c16.b();
                return true;
            }
            QLog.e("QQSettingMeBaseProcessor", 1, "openByJumpParser, parse mqqAPI url failed.");
        }
        return false;
    }

    private boolean z(String str) {
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null || !TextUtils.isEmpty(str)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQSettingMeBaseProcessor", 2, "jumpToProfile");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AllInOne allInOne = new AllInOne(peekAppRuntime.getCurrentAccountUin(), 0);
        allInOne.lastActivity = 1;
        allInOne.profileEntryType = 8;
        ProfileUtils.openProfileCardForResult(qBaseActivity, allInOne, 1009);
        ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).checkToCleanSettingMeRedPointGuide((QQAppInterface) peekAppRuntime);
        QLog.e("QVipSettingMe.", 1, "medal list have no jump url ,so use the default");
        return true;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void a() {
        PAGView pAGView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQValuePagView qQValuePagView = this.f184681l;
        if (qQValuePagView != null && (qQValuePagView.api().getCurrentView() instanceof PAGView) && (pAGView = (PAGView) this.f184681l.api().getCurrentView()) != null) {
            pAGView.stop();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Card card = t().f184893b;
        if (card != null && ((QQLevelIconBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(QQLevelIconBusiness.class)).isFileExists(card.mQQLevelType)) {
            int i3 = card.mQQLevelType;
            if (i3 == 0) {
                i3 = 99999;
            }
            ReportController.o(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A778", i3, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        AppRuntime appRuntime2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
            return;
        }
        if (this.f184682m) {
            WeakReference<AppRuntime> weakReference = this.f259740a;
            if (weakReference == null) {
                appRuntime2 = null;
            } else {
                appRuntime2 = weakReference.get();
            }
            if (appRuntime2 != null) {
                ((QQAppInterface) appRuntime2).removeObserver(this.f184684o);
                VipGrayConfigHelper.getsInstance().unRegisterListener(this.f184683n);
            } else {
                QLog.e("QQSettingMeBaseProcessor", 1, "fillData appRef.get is null");
            }
            if (appRuntime != null) {
                ((QQAppInterface) appRuntime).addObserver(this.f184684o, true);
                VipGrayConfigHelper.getsInstance().registerListener(this.f184683n);
            }
        }
        this.f259740a = new WeakReference<>(appRuntime);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f184682m = false;
        View findViewById = aVar.f274439h.findViewById(R.id.unw);
        if (findViewById instanceof QQValuePagView) {
            this.f184681l = (QQValuePagView) findViewById;
        }
        this.f184678i.observe(this.f259743d, new c(aVar));
        this.f184679j.observe(this.f259743d, new d(aVar));
        this.f184680k.observe(this.f259743d, new e(aVar));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeHeadVipProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        try {
                            QQSettingMeHeadVipProcessor.this.C();
                            QQSettingMeHeadVipProcessor.this.B();
                            return;
                        } catch (Throwable th5) {
                            QLog.e("QQSettingMeBaseProcessor", 1, "update level and vip fail :" + th5);
                            return;
                        }
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.j
    public Card g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Card) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return t().f184893b;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_LEVEL_ICON));
        BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SVIP_ICON));
        if (this.f259745f) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(appInfoByPath, appInfoByPath2, z16) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f184685d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ BusinessInfoCheckUpdate.AppInfo f184686e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f184687f;

                {
                    this.f184685d = appInfoByPath;
                    this.f184686e = appInfoByPath2;
                    this.f184687f = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QQSettingMeHeadVipProcessor.this, appInfoByPath, appInfoByPath2, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    am.a(peekAppRuntime, this.f184685d, ((com.tencent.mobileqq.processor.c) QQSettingMeHeadVipProcessor.this).f259744e);
                    QQSettingMeHeadVipProcessor.this.f184679j.setValue(this.f184685d);
                    am.a(peekAppRuntime, this.f184686e, ((com.tencent.mobileqq.processor.c) QQSettingMeHeadVipProcessor.this).f259744e);
                    QQSettingMeHeadVipProcessor.this.f184680k.setValue(this.f184686e);
                    if (this.f184687f) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeHeadVipProcessor.7.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                    QQSettingMeHeadVipProcessor.this.A();
                                } else {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                }
                            }
                        }, 16, null, false);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        Card card;
        String str;
        final boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (view.getId() == R.id.unz) {
            String v3 = v(ProfileCardComponentConstant.TOGGLE_KEY_QQ_DIAMOND_HOST_URL, ProfileCardComponentConstant.DEFAULT_QQ_DIAMOND_HOST_URL);
            if (TextUtils.isEmpty(v3)) {
                QLog.e("QQSettingMeBaseProcessor", 1, "getToggleUrl(vipMedal) is empty.");
                if (t().f184894c != null) {
                    str2 = t().f184894c.jumpUrl;
                }
                v3 = str2;
            }
            if (z(v3)) {
                return;
            }
            IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SVIP_ICON));
            if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                String u16 = u(v3, BusinessInfoCheckUpdateItem.UIAPPID_SVIP_ICON);
                if (!TextUtils.isEmpty(u16)) {
                    v3 = v3 + u16;
                }
            } else {
                v3 = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(v3, IVipTraceDetailReport.FROM.QQSETTINGS_DIAMOND);
            }
            if (y(v3, view.getContext())) {
                return;
            }
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(qBaseActivity, v3);
            } else {
                Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", v3);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("hide_more_button", true);
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                qBaseActivity.startActivity(intent);
            }
            if (z17) {
                iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_SVIP_ICON, 31);
            }
            int J2 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), false);
            if (view instanceof QVipMedalView) {
                if (AnimatorHandler.playing) {
                    ((QVipMedalView) view).d("0X800B2B5", J2);
                } else {
                    ((QVipMedalView) view).d("0X800B2B4", J2);
                }
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "qvip", "0X800A127", 0, 0, String.valueOf(J2), "", "", "");
            return;
        }
        if (view.getId() == R.id.f165032uo0) {
            IRedTouchManager iRedTouchManager2 = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
            BusinessInfoCheckUpdate.AppInfo appInfoByPath2 = iRedTouchManager2.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_LEVEL_ICON));
            if (appInfoByPath2 != null && appInfoByPath2.iNewFlag.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!((IVasWebUrl) QRoute.api(IVasWebUrl.class)).gotoLevelPage(view.getContext(), new Function1() { // from class: com.tencent.mobileqq.activity.qqsettingme.aa
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    String x16;
                    x16 = QQSettingMeHeadVipProcessor.this.x(z16, (String) obj);
                    return x16;
                }
            })) {
                SharedPreferences sharedPreferences = peekAppRuntime.getApplication().getSharedPreferences(peekAppRuntime.getCurrentAccountUin(), 0);
                String accountJumpUrl = ((IVasQQSettingMe) QRoute.api(IVasQQSettingMe.class)).getAccountJumpUrl();
                if (TextUtils.isEmpty(accountJumpUrl)) {
                    accountJumpUrl = v(ProfileCardComponentConstant.TOGGLE_KEY_QQ_VALUE_HOST_URL, ProfileCardComponentConstant.DEFAULT_QQ_VALUE_HOST_URL);
                }
                if (TextUtils.isEmpty(accountJumpUrl)) {
                    QLog.e("QQSettingMeBaseProcessor", 1, "getToggleUrl(qqLevel) is empty.");
                    accountJumpUrl = sharedPreferences.getString(AppConstants.Preferences.VIP_MEDAL_LVL_JUMP_URL, null);
                }
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    accountJumpUrl = f184676p;
                }
                if (z(accountJumpUrl)) {
                    return;
                }
                if (z16) {
                    String u17 = u(accountJumpUrl, BusinessInfoCheckUpdateItem.UIAPPID_LEVEL_ICON);
                    if (!TextUtils.isEmpty(u17)) {
                        accountJumpUrl = accountJumpUrl + u17;
                    }
                } else {
                    accountJumpUrl = com.tencent.mobileqq.vip.api.e.a().buildTraceDetailUrl(accountJumpUrl, IVipTraceDetailReport.FROM.QQSETTINGS_LEVEL);
                }
                ff.y(0, IProfileCardConst.VIP_QQ_FROM_DRAWER, "geren", accountJumpUrl, view.getContext());
            }
            if (z16) {
                iRedTouchManager2.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_LEVEL_ICON, 31);
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B179", "0X800B179", 0, 0, String.valueOf(VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), false)), "", "", "");
            return;
        }
        if (view.getId() == R.id.umm) {
            if (!((IVasWebUrl) QRoute.api(IVasWebUrl.class)).gotoLevelPage(view.getContext(), null)) {
                Intent intent2 = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("uin", peekAppRuntime.getCurrentAccountUin());
                intent2.putExtra("url", IProfileCardConst.DRAWER_LEVEL_URL);
                intent2.putExtra("hide_more_button", true);
                qBaseActivity.startActivity(intent2);
            }
            ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A9C3", "0X800A9C3", 0, 0, "", "", "", "");
            return;
        }
        if (view.getId() == R.id.unw) {
            ((QQValuePagView) view).u("setting", peekAppRuntime.getCurrentAccountUin());
            return;
        }
        if (view.getId() == R.id.uo7) {
            Card card2 = t().f184893b;
            if (card2 != null) {
                ff.f0(qBaseActivity, card2.nameplateExtId);
                ff.S("0X800B923", card2.nameplateExtId);
                return;
            }
            return;
        }
        if (view.getId() == R.id.unn && (card = t().f184893b) != null) {
            IGameCardManager gameCardManager = VasUtil.getService().getGameCardManager();
            gameCardManager.gotoGameIconSetWeb(qBaseActivity, card.uin, card.namePlateOfKingDanDisplatSwitch, card.gameCardId);
            if (gameCardManager.isSelf(card.uin)) {
                str = "owner";
            } else {
                str = IGameCardManager.VISITOR;
            }
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(card.gameCardId), "4", SearchConstants.PLATFORM, IGameCardManager.DRAWER, str, 102, 1, System.currentTimeMillis());
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (this.f184682m && peekAppRuntime != null) {
            ((QQAppInterface) peekAppRuntime).removeObserver(this.f184684o);
            VipGrayConfigHelper.getsInstance().unRegisterListener(this.f184683n);
        }
        this.f184681l = null;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onPause();
            this.f184677h = false;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            e();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        PAGView pAGView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!this.f184682m) {
            ((QQAppInterface) peekAppRuntime).addObserver(this.f184684o, true);
            VipGrayConfigHelper.getsInstance().registerListener(this.f184683n);
            this.f184682m = true;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        QQValuePagView qQValuePagView = this.f184681l;
        if (qQValuePagView != null) {
            qQValuePagView.B(currentAccountUin, "setting", false);
            if ((this.f184681l.api().getCurrentView() instanceof PAGView) && (pAGView = (PAGView) this.f184681l.api().getCurrentView()) != null) {
                pAGView.play();
            }
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_head_vip";
    }
}
