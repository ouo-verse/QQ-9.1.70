package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeKingCardProcessor;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class QQSettingMeKingCardProcessor extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private static String f184700m;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.f> f184701i;

    /* renamed from: j, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.b> f184702j;

    /* renamed from: k, reason: collision with root package name */
    private String f184703k;

    /* renamed from: l, reason: collision with root package name */
    private int f184704l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeKingCardProcessor$3, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeKingCardProcessor.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit b(Integer num, String str) {
            QLog.e("QQSettingMeBaseProcessor", 1, "code: " + num + " msg: " + str);
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            IConfigProxy iConfigProxy = VasNormalToggle.VAS_KUIKLY_TRAFFIC_OFFICIAL_WEBSITE;
            if (iConfigProxy.isEnable(false)) {
                String str = URLUtil.getArgumentsFromURL(iConfigProxy.getJson().optString("qq_traffic_official_web_url")).get("bundle_name");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).preloadKuiklyResByTag(iConfigProxy.getJson().optLong("timestamp", 0L), str, new Function2() { // from class: com.tencent.mobileqq.activity.qqsettingme.af
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit b16;
                        b16 = QQSettingMeKingCardProcessor.AnonymousClass3.b((Integer) obj, (String) obj2);
                        return b16;
                    }
                });
            }
        }
    }

    /* loaded from: classes10.dex */
    class a implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.f> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184705d;

        a(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184705d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeKingCardProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            } else {
                this.f184705d.F(fVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184707d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184707d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeKingCardProcessor.this, (Object) aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(com.tencent.mobileqq.qqsettingme.a aVar, com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
            aVar.k().K.setValue(bVar);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onChanged(final com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            this.f184707d.z(bVar);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final com.tencent.mobileqq.qqsettingme.a aVar = this.f184707d;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.ae
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeKingCardProcessor.b.b(com.tencent.mobileqq.qqsettingme.a.this, bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements TianShuGetAdvCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeKingCardProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), getAdsRsp);
            } else if (z16 && getAdsRsp != null) {
                QQSettingMeKingCardProcessor.f184700m = (String) TianShuManager.getInstance().parseGetAdsRsp(getAdsRsp, 76).get("information");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f184700m = "";
        }
    }

    public QQSettingMeKingCardProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184701i = new MutableLiveData<>();
        this.f184702j = new MutableLiveData<>();
        this.f184703k = "";
        this.f184704l = 0;
    }

    private static void A(CharSequence charSequence) {
        QQSettingMeBizBean c16;
        if (!((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3() && (c16 = com.tencent.mobileqq.qqsettingme.a.c("d_vip_card")) != null && !TextUtils.isEmpty(charSequence)) {
            c16.x(charSequence);
        }
    }

    private void B() {
        MenumItem menumItem = com.tencent.mobileqq.vip.o.a().d((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).get(5);
        if (menumItem == null) {
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.b bVar = new com.tencent.mobileqq.activity.qqsettingme.bean.b();
        bVar.f184875a = com.tencent.mobileqq.vip.o.a().f(5);
        if (!TextUtils.isEmpty(menumItem.title)) {
            QQText c16 = com.tencent.av.chatroom.c.c(menumItem.title, 16);
            bVar.f184876b = c16;
            A(c16);
        }
        if (!TextUtils.isEmpty(menumItem.icon)) {
            bVar.f184877c = VasApngUtil.getApngURLDrawable(menumItem.icon, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
        }
        this.f184702j.postValue(bVar);
    }

    private void C() {
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g("d_vip_card");
        if (g16 == null || !g16.hasRedTouch()) {
            return;
        }
        f184700m = "";
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 76;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        TianShuManager.getInstance().requestAdv(arrayList, new c());
    }

    @NotNull
    private String u(String str, VasMMKVProxy vasMMKVProxy) {
        String decodeString = vasMMKVProxy.decodeString("drawerUrl", "");
        if (TextUtils.isEmpty(decodeString)) {
            QLog.e("QQSettingMeBaseProcessor", 1, "cuKingCard url = null");
        }
        return decodeString + str;
    }

    @NonNull
    private com.tencent.mobileqq.activity.qqsettingme.bean.f v() {
        if (this.f184701i.getValue() == null) {
            return new com.tencent.mobileqq.activity.qqsettingme.bean.f();
        }
        return this.f184701i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(AppRuntime appRuntime, int i3) {
        ReportController.o(appRuntime, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i3, 0, String.valueOf(i3), this.f184703k, v().f184891e, "");
    }

    private void y() {
        ThreadManagerV2.excute(new AnonymousClass3(), 16, null, false);
    }

    private void z(String str, boolean z16) {
        String str2;
        IVipTraceDetailReport.FROM from;
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (!VasUtils.b() && qBaseActivity != null) {
            IConfigProxy iConfigProxy = VasNormalToggle.VAS_KUIKLY_TRAFFIC_OFFICIAL_WEBSITE;
            if (iConfigProxy.isEnable(false)) {
                String optString = iConfigProxy.getJson().optString("qq_traffic_official_web_url");
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        optString = optString + "&url=" + URLEncoder.encode(str, "utf-8");
                        IVipTraceDetailReport a16 = com.tencent.mobileqq.vip.api.e.a();
                        if (z16) {
                            from = IVipTraceDetailReport.FROM.DRAWER_KINGCARD_WITH_REDTOUCH;
                        } else {
                            from = IVipTraceDetailReport.FROM.DRAWER_KINGCARD_NO_REDTOUCH;
                        }
                        str2 = a16.buildTraceDetailUrl(optString, from);
                    } catch (UnsupportedEncodingException e16) {
                        QLog.i("QQSettingMeBaseProcessor", 1, "encode error: " + e16);
                        str2 = optString;
                    }
                    this.f184704l = 2;
                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(qBaseActivity, str2, null);
                    return;
                }
                return;
            }
            this.f184704l = 1;
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(qBaseActivity, str);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        super.d(aVar);
        this.f184701i.observe(this.f259743d, new a(aVar));
        this.f184702j.observe(this.f259743d, new b(aVar));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.f v3 = v();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        VasMMKVProxy kingCard = VasMMKV.getKingCard(peekAppRuntime.getCurrentAccountUin());
        boolean z16 = false;
        boolean decodeBool = kingCard.decodeBool("drawerEnable", false);
        v3.f184890d = com.tencent.mobileqq.vip.o.a().h((QQAppInterface) peekAppRuntime, 32);
        v3.f184888b = kingCard.decodeString("drawerText", "");
        v3.f184889c = kingCard.decodeString("drawerUrl", "");
        v3.f184891e = kingCard.decodeString("sDrawerTextRuleID", "");
        if (decodeBool && !TextUtils.isEmpty(v3.f184888b) && !TextUtils.isEmpty(v3.f184889c)) {
            z16 = true;
        }
        v3.f184887a = z16;
        if (z16) {
            this.f184703k = kingCard.decodeString("drawerTextID", "");
        } else {
            this.f184703k = "";
        }
        A(v3.f184888b);
        this.f184701i.setValue(v3);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appInfo, Boolean.valueOf(z16));
        } else {
            super.j(appInfo, z16);
            C();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            B();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        B();
        e();
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final int J2 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), false);
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_card", Boolean.FALSE);
        if (i3 != null && i3.getVisibility() == 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.ad
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeKingCardProcessor.this.x(peekAppRuntime, J2);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            B();
            y();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:8|(1:49)(1:12)|13|(2:15|(1:17))(2:46|(1:48))|18|(2:20|(5:22|23|(1:25)|26|(8:28|29|(1:31)(1:40)|32|33|34|35|36)(1:41)))|45|29|(0)(0)|32|33|34|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011e, code lost:
    
        com.tencent.qphone.base.util.QLog.i("QQSettingMeBaseProcessor", 1, "exception", r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(View view) {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD));
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
            str = MobileReportManager.getStringReport2H5(appInfoByPath);
            iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, 31);
            z16 = true;
        } else {
            z16 = false;
            str = "";
        }
        VasMMKVProxy kingCard = VasMMKV.getKingCard(peekAppRuntime.getCurrentAccountUin());
        if (TianshuRedTouch.INSTANCE.j()) {
            if (com.tencent.mobileqq.qqsettingme.a.e("d_vip_card") == null) {
                return;
            }
        } else if (com.tencent.mobileqq.qqsettingme.a.g("d_vip_card") == null) {
            return;
        }
        if (z16) {
            QLog.i("QQSettingMeBaseProcessor", 1, "open redtouch url");
            String str3 = appInfoByPath.buffer.get();
            if (!TextUtils.isEmpty(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    JSONObject optJSONObject = jSONObject.optJSONObject("msg").optJSONObject(jSONObject.optString("ad_id"));
                    str2 = optJSONObject.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                    if (TextUtils.isEmpty(str2)) {
                        str2 = optJSONObject.optString("content");
                    }
                    QLog.i("QQSettingMeBaseProcessor", 1, "retouch url = " + str2);
                } catch (Exception e16) {
                    QLog.e("QQSettingMeBaseProcessor", 1, "data error", e16);
                }
                if (TextUtils.isEmpty(str2)) {
                    QLog.w("QQSettingMeBaseProcessor", 1, "no link buffer = " + str3);
                } else {
                    if (str2.isEmpty()) {
                        z(u("", kingCard), true);
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(view.getContext(), str2);
                    } else {
                        z(u(str, kingCard), z16);
                    }
                    int J2 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), z16);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("jump", this.f184704l);
                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8C0", "0X800A8C0", J2, 0, String.valueOf(J2), this.f184703k, v().f184891e, jSONObject2.toString());
                }
            }
        }
        str2 = "";
        if (str2.isEmpty()) {
        }
        int J22 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), z16);
        JSONObject jSONObject22 = new JSONObject();
        jSONObject22.put("jump", this.f184704l);
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8C0", "0X800A8C0", J22, 0, String.valueOf(J22), this.f184703k, v().f184891e, jSONObject22.toString());
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_vip_card";
    }
}
