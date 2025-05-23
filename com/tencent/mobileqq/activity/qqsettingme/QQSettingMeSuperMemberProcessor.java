package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import MQQ.PayRuleCfg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasTabFactory;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.config.business.QVipHippyConfig;
import com.tencent.mobileqq.vas.config.business.QVipHippyProcessor;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.util.URLUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class QQSettingMeSuperMemberProcessor extends q implements l {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f184746q;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.o> f184747i;

    /* renamed from: j, reason: collision with root package name */
    public MutableLiveData<String> f184748j;

    /* renamed from: k, reason: collision with root package name */
    public MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.b> f184749k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f184750l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f184751m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f184752n;

    /* renamed from: o, reason: collision with root package name */
    private int f184753o;

    /* renamed from: p, reason: collision with root package name */
    private final BroadcastReceiver f184754p;

    /* loaded from: classes10.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (QLog.isColorLevel() && intent != null) {
                QLog.d("QQSettingMeBaseProcessor", 2, "UpdateVipInfoReceiver: intent=" + intent.toString());
            }
            if (intent != null && intent.getBooleanExtra(QQBrowserActivity.KEY_PAY_ACTION_RESULT, false)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMeBaseProcessor", 2, "UpdateVipInfoReceiver: need update ");
                }
                QQSettingMeSuperMemberProcessor.this.X();
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements Observer<com.tencent.mobileqq.activity.qqsettingme.bean.o> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184757d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184757d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar);
                return;
            }
            if (oVar.f184939e) {
                QQSettingMeSuperMemberProcessor.this.Y(oVar);
            } else {
                QQSettingMeSuperMemberProcessor.this.M();
            }
            this.f184757d.R(oVar);
            QQSettingMeViewModel k3 = this.f184757d.k();
            if (k3 != null) {
                k3.J.postValue(oVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    class c implements Observer<String> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "updateVipText sp vipText = " + str);
            }
            View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_identity", Boolean.FALSE);
            if (!TextUtils.isEmpty(str) && i3 != null) {
                QQSettingMeSuperMemberProcessor.Z(str);
                TextView textView = (TextView) i3.findViewById(R.id.umj);
                CharSequence d16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.d("d_vip_identity", str);
                if (textView != null) {
                    textView.setText(d16);
                }
                AccessibilityUtil.c(i3, d16, Button.class.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.o f184760d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f184761e;

        d(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar, TextView textView) {
            this.f184760d = oVar;
            this.f184761e = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQSettingMeSuperMemberProcessor.this, oVar, textView);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler updateSuperMemberItemView onLoadFialed: ", th5);
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
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQSettingMeBaseProcessor", 2, "VipInfoHandler onLoadSuccessed: " + this.f184760d.f184938d.iconUrl);
            }
            try {
                this.f184761e.setText(this.f184760d.f184938d.iconText);
                this.f184761e.setTextColor(Color.parseColor(this.f184760d.f184938d.iconTextCol));
            } catch (Exception e16) {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler setTextColor: " + this.f184760d.f184938d.iconTextCol, e16);
                this.f184761e.setTextColor(-16777216);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69075);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f184746q = com.tencent.mobileqq.vas.ar.b("kenaiyu", "2025-02-14", "vas_bug_redtouch_update").isEnable(true);
        }
    }

    public QQSettingMeSuperMemberProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184747i = new MutableLiveData<>(new com.tencent.mobileqq.activity.qqsettingme.bean.o());
        this.f184748j = new MutableLiveData<>();
        this.f184749k = new MutableLiveData<>();
        this.f184752n = true;
        this.f184753o = 0;
        this.f184754p = new a();
    }

    private void H(String str) {
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_identity", Boolean.FALSE);
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        if (companion.j() && i3 != null && i3.getVisibility() == 0) {
            Boolean valueOf = Boolean.valueOf(companion.a(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP)));
            IElementDynamicParams b16 = new m().b(valueOf.booleanValue(), com.tencent.mobileqq.activity.qqsettingme.utils.b.c("d_vip_identity"), "d_vip_identity");
            if (b16 != null) {
                VideoReport.setElementDynamicParams(i3, b16);
            }
            VideoReport.setElementId(i3, "em_drawer_super_member");
            HashMap hashMap = new HashMap();
            hashMap.put("is_red_tips_em", Integer.valueOf(valueOf.booleanValue() ? 1 : 0));
            VideoReport.reportEvent(str, i3, hashMap);
        }
    }

    private String J() {
        if (!QVipHippyConfig.ENABLE_CONFIG) {
            return h().f184936b;
        }
        String str = QVipHippyProcessor.a().configUrl;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        QLog.e("QQSettingMeBaseProcessor", 1, "get config fail,url is null");
        return h().f184936b;
    }

    private View.OnClickListener K(final com.tencent.mobileqq.activity.qqsettingme.bean.o oVar) {
        final QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.qqsettingme.aw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQSettingMeSuperMemberProcessor.O(com.tencent.mobileqq.activity.qqsettingme.bean.o.this, qBaseActivity, view);
            }
        };
    }

    private void L(String str) {
        QBaseActivity qBaseActivity;
        boolean z16;
        String str2;
        Pair<VasTabFactory.ABTest, Map<String, String>> pair;
        if (VasUtils.b() || (qBaseActivity = this.f259741b.get()) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String J = J();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP));
        StringBuilder sb5 = new StringBuilder();
        int systemNetwork = NetworkUtil.getSystemNetwork(peekAppRuntime.getApp().getApplicationContext());
        if (!J.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(J);
            sb5.append("?platform=1&type=20001&networkInfo=");
            sb5.append(systemNetwork);
        } else {
            sb5.append(J);
            sb5.append("&platform=1&type=20001&networkInfo=");
            sb5.append(systemNetwork);
        }
        String wrapperRedTouchUrl = iRedTouchManager.wrapperRedTouchUrl(sb5.toString(), appInfoByPath);
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0 && appInfoByPath.type.get() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (str != null) {
            str2 = wrapperRedTouchUrl + str;
        } else {
            str2 = wrapperRedTouchUrl;
        }
        IConfigProxy iConfigProxy = VasNormalToggle.VAS_KUIKLY_SVIP_OFFICIAL_WEBSITE;
        String optString = iConfigProxy.getJson().optString("qq_vip_official_web_url", "");
        String str3 = com.tencent.mobileqq.vip.o.a().c((QQAppInterface) peekAppRuntime, "key_svip_item_my_vip_").jumpurl_tab_expid;
        if (!TextUtils.isEmpty(str3)) {
            pair = VasTabFactory.c("kenaiyu", "2025-03-20", str3);
        } else {
            pair = null;
        }
        if (pair != null && (pair.getFirst().getIsContrast() || pair.getFirst().getIsExperiment())) {
            String str4 = pair.getSecond().get("url");
            this.f184753o = 2;
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(qBaseActivity, str4);
        } else if (iConfigProxy.isEnable(true) && ((IVipInfoUtils) QRoute.api(IVipInfoUtils.class)).getQQSettingVipHomeType(peekAppRuntime.getCurrentAccountUin()) == 1 && !TextUtils.isEmpty(optString) && optString.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
            try {
                optString = optString + "&url=" + URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e16) {
                QLog.i("QQSettingMeBaseProcessor", 1, "encode error: " + e16);
            }
            this.f184753o = 2;
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(qBaseActivity, optString, null);
        } else if (VasUtil.getTempApi().isCanOpenQQVipHippyPage()) {
            this.f184753o = 1;
            VasUtil.getTempApi().openQQVipHippyPage(str2);
            VasUtil.getTempApi().fetchHippyDTReportIndex(str2, peekAppRuntime);
        } else {
            this.f184753o = 3;
            if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
                Bundle bundle = new Bundle();
                bundle.putString(QQBrowserActivity.BROADCAST_ACTION_KEY, QQBrowserActivity.ACTION_UPDATE_VIP_INFO);
                bundle.putBoolean(QCircleScheme.AttrDetail.HAS_RED_DOT, z16);
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(qBaseActivity, str2, bundle);
            } else {
                Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra(QQBrowserActivity.BROADCAST_ACTION_KEY, QQBrowserActivity.ACTION_UPDATE_VIP_INFO);
                intent.putExtra("startOpenPageTime", currentTimeMillis);
                intent.putExtra("portraitOnly", true);
                intent.putExtra("uin", peekAppRuntime.getCurrentAccountUin());
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("hide_more_button", true);
                intent.putExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, z16);
                intent.putExtra("leftBtnText", qBaseActivity.getResources().getString(R.string.account));
                VasWebviewUtil.openQQBrowserWithoutAD(qBaseActivity, str2, 256L, intent, false, -1);
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler gotoOpenCenterBrowser");
            }
        }
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
            iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP, 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_identity", Boolean.FALSE);
        if (i3 == null) {
            return;
        }
        TextView textView = (TextView) i3.findViewById(R.id.umh);
        textView.setText("");
        textView.setBackgroundDrawable(null);
    }

    private void N() {
        com.tencent.mobileqq.activity.qqsettingme.bean.o I = I();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!TextUtils.isEmpty(I.f184937c) && !I.f184937c.equals(peekAppRuntime.getCurrentAccountUin())) {
            QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler payRuleUin changed");
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar, QBaseActivity qBaseActivity, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        PayRuleCfg payRuleCfg = oVar.f184938d;
        if (payRuleCfg != null) {
            if (payRuleCfg.clickHide == 1) {
                payRuleCfg.enable = 0;
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler click clear enable");
                VipInfoHandler.U2(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), oVar.f184938d);
            }
            ReportController.n(null, "dc00898", "", "", "", "0X800A633", VipInfoHandler.I2(oVar.f184938d), 1, 0, "1", oVar.f184938d.advId, "", "");
            VipInfoHandler.b3(102, oVar.f184938d.advId);
            if (!TextUtils.isEmpty(oVar.f184938d.iconJumpUrl)) {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler click iconJumpUrl: " + oVar.f184938d.iconJumpUrl);
                Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent.putExtra("url", oVar.f184938d.iconJumpUrl);
                intent.putExtra("isShowAd", false);
                qBaseActivity.startActivity(intent);
            } else {
                int i16 = oVar.f184938d.clubType;
                if (i16 != 1 && i16 != 2) {
                    if (i16 != 3) {
                        QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler unknown clubType=" + oVar.f184938d.clubType);
                    } else {
                        i3 = 12;
                    }
                } else {
                    i3 = 11;
                }
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler click type: " + oVar.f184938d.clubType);
                VasH5PayUtil.openH5Pay(qBaseActivity, oVar.f184938d.aid, "CJCLUBT", 3, false, false, "", URLEncoder.encode("jsbridge://vipclub/paySuccess?p={\"type\":" + i3 + "}"), true, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(com.tencent.mobileqq.qqsettingme.a aVar, com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
        QQSettingMeViewModel k3 = aVar.k();
        if (k3 != null) {
            k3.K.setValue(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Q(final com.tencent.mobileqq.qqsettingme.a aVar, final com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
        Z(bVar.f184876b);
        aVar.z(bVar);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.at
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeSuperMemberProcessor.P(com.tencent.mobileqq.qqsettingme.a.this, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int J2 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), RedTouch.hasRedTouch(((IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP))));
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8C3", "0X800A8C3", J2, 0, String.valueOf(J2), "", "", "");
        MobileReportManager.getInstance().qqSetingMeReport(1, 101, String.valueOf(J2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit S(Integer num, String str) {
        QLog.e("QQSettingMeBaseProcessor", 1, "code: " + num + " msg: " + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T() {
        IConfigProxy iConfigProxy = VasNormalToggle.VAS_KUIKLY_SVIP_OFFICIAL_WEBSITE;
        if (iConfigProxy.isEnable(true)) {
            String str = URLUtil.getArgumentsFromURL(iConfigProxy.getJson().optString("qq_vip_official_web_url")).get("bundle_name");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ((IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class)).preloadKuiklyResByTag(iConfigProxy.getJson().optLong("timestamp", 0L), str, new Function2() { // from class: com.tencent.mobileqq.activity.qqsettingme.av
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit S;
                    S = QQSettingMeSuperMemberProcessor.S((Integer) obj, (String) obj2);
                    return S;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        if (!this.f184751m) {
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        long j3 = QVipConfigManager.getLong(peekAppRuntime, QVipConfigManager.KEY_LONG_SETTING_ME_LAST_REQUEST_SUCCESS_TIME, 0L);
        int integer = QVipConfigManager.getInteger(peekAppRuntime, QVipConfigManager.KEY_INTEGER_SETTING_ME_VIP_SYNC_FREQ, 0);
        if (NetConnInfoCenter.getServerTime() - j3 <= integer) {
            QLog.e("QVipSettingMe.QQSettingMeBaseProcessor", 1, "ignore the vip info request because current time=" + NetConnInfoCenter.getServerTime() + " requestTimestamp=" + j3 + " and updateFrequency=" + integer);
            return false;
        }
        QLog.e("QVipSettingMe.QQSettingMeBaseProcessor", 1, "need the vip info request because current time=" + NetConnInfoCenter.getServerTime() + " requestTimestamp=" + j3 + " and updateFrequency=" + integer);
        return true;
    }

    private void V() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (com.tencent.mobileqq.vip.o.a().h((QQAppInterface) peekAppRuntime, 4)) {
            return;
        }
        this.f184748j.setValue(VipMMKV.getVipTittle(peekAppRuntime.getApplication()).getString("vipTitleSpKey_" + peekAppRuntime.getCurrentAccountUin() + "_" + LocaleManager.getLocaleId(), ""));
    }

    private void W() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.au
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeSuperMemberProcessor.T();
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (VasToggle.BUG_102518313.isEnable(true)) {
            h().f184936b = VasMMKV.getCommon(peekAppRuntime.getCurrentAccountUin()).decodeString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
        } else {
            SharedPreferences sharedPreferences = peekAppRuntime.getApplication().getSharedPreferences(peekAppRuntime.getCurrentAccountUin(), 4);
            h().f184936b = sharedPreferences.getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                boolean z17;
                long j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    boolean U = QQSettingMeSuperMemberProcessor.this.U();
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    String currentAccountUin = peekAppRuntime2.getCurrentAccountUin();
                    TicketManager ticketManager = (TicketManager) peekAppRuntime2.getManager(2);
                    long j16 = QVipConfigManager.getLong(peekAppRuntime2, QVipConfigManager.KEY_LONG_SETTING_ME_GET_VIP_INFO_SEQUENCE, 1562146740L);
                    if (QLog.isColorLevel()) {
                        QLog.d("QVipSettingMe.", 2, "updateVipInfo request:" + j16);
                    }
                    long j17 = QVipConfigManager.getLong(peekAppRuntime2, QVipConfigManager.KEY_LONG_SETTING_ME_VIP_MEDAL_LIST_RECORD, 0L);
                    if (cooperation.vip.manager.i.r().z() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if ((j17 & 1) == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 != z16) {
                        QLog.e("QVipSettingMe.", 1, "updateVipInfo request immediate");
                        j3 = 1562146741;
                        U = true;
                    } else {
                        j3 = j16;
                    }
                    if (!U) {
                        return;
                    }
                    VipInfoHandler vipInfoHandler = (VipInfoHandler) ((QQAppInterface) peekAppRuntime2).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
                    VasLogNtReporter.getVipIcon().reportDebug("enter settingme and request vipinfo data");
                    if (!QQSettingMeSuperMemberProcessor.this.f184752n || !VasNormalToggle.BUG_LIANG_REQUEST.isEnable(true)) {
                        QQSettingMeSuperMemberProcessor.this.f184752n = false;
                        vipInfoHandler.W2(VasSkey.getSkey(ticketManager, currentAccountUin), currentAccountUin, j3, "vip_drawer");
                    } else {
                        QQSettingMeSuperMemberProcessor.this.f184752n = false;
                        vipInfoHandler.W2(VasSkey.getSkey(ticketManager, currentAccountUin), currentAccountUin, 1562146740L, "vip_drawer");
                    }
                    if (VasNormalToggle.BUG_LIANG_REQUEST.isEnable(true)) {
                        vipInfoHandler.X2(currentAccountUin);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar) {
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_identity", Boolean.FALSE);
        if (!TextUtils.isEmpty(oVar.f184938d.iconText) && !TextUtils.isEmpty(oVar.f184938d.iconUrl) && i3 != null) {
            TextView textView = (TextView) i3.findViewById(R.id.umh);
            textView.setOnClickListener(K(oVar));
            d dVar = new d(oVar, textView);
            try {
                URL url = new URL(oVar.f184938d.iconUrl);
                Bundle bundle = new Bundle();
                bundle.putInt("key_density", 320);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mUseApngImage = true;
                obtain.mExtraInfo = bundle;
                ColorDrawable colorDrawable = new ColorDrawable(0);
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                textView.setBackgroundDrawable(drawable);
                if (drawable.getStatus() == 1) {
                    dVar.onLoadSuccessed(drawable);
                } else {
                    textView.setText("");
                    drawable.setURLDrawableListener(dVar);
                    if (drawable.getStatus() == 2) {
                        drawable.restartDownload();
                    }
                }
                return;
            } catch (MalformedURLException e16) {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler showPayButton: ", e16);
                return;
            }
        }
        QLog.e("QQSettingMeBaseProcessor", 1, "showPayButton: iconText or iconUrl is empty or itemView is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(CharSequence charSequence) {
        QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c("d_vip_identity");
        if (c16 != null && !TextUtils.isEmpty(charSequence)) {
            c16.x(charSequence);
        }
    }

    private void a0() {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MenumItem menumItem = com.tencent.mobileqq.vip.o.a().d((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).get(2);
                if (menumItem == null) {
                    return;
                }
                com.tencent.mobileqq.activity.qqsettingme.bean.b bVar = new com.tencent.mobileqq.activity.qqsettingme.bean.b();
                bVar.f184875a = com.tencent.mobileqq.vip.o.a().f(2);
                if (!TextUtils.isEmpty(menumItem.title)) {
                    bVar.f184876b = com.tencent.av.chatroom.c.c(menumItem.title, 16);
                }
                if (!TextUtils.isEmpty(menumItem.icon)) {
                    bVar.f184877c = VasApngUtil.getApngURLDrawable(menumItem.icon, new int[]{1}, com.tencent.mobileqq.urldrawable.b.f306350a, null, null);
                }
                QQSettingMeSuperMemberProcessor.this.f184749k.postValue(bVar);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread() && com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-04-15", "vas_bug_122960667").isEnable(true)) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        } else {
            runnable.run();
        }
    }

    public com.tencent.mobileqq.activity.qqsettingme.bean.o I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.activity.qqsettingme.bean.o) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f184747i.getValue();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(final com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        this.f184751m = false;
        this.f184747i.observe(this.f259743d, new b(aVar));
        this.f184749k.observe(this.f259743d, new Observer() { // from class: com.tencent.mobileqq.activity.qqsettingme.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeSuperMemberProcessor.Q(com.tencent.mobileqq.qqsettingme.a.this, (com.tencent.mobileqq.activity.qqsettingme.bean.b) obj);
            }
        });
        this.f184748j.observe(this.f259743d, new c());
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.o oVar = new com.tencent.mobileqq.activity.qqsettingme.bean.o();
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String currentUin = peekAppRuntime.getCurrentUin();
            oVar.f184937c = currentUin;
            PayRuleCfg H2 = VipInfoHandler.H2(currentUin);
            oVar.f184938d = H2;
            boolean Q2 = VipInfoHandler.Q2((QQAppInterface) peekAppRuntime, H2, this.f184750l);
            oVar.f184939e = Q2;
            PayRuleCfg payRuleCfg = oVar.f184938d;
            if (payRuleCfg == null) {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler getPayRule is null");
            } else {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler getPayRule ", payRuleCfg.iconText, " needShowPayButton=", Boolean.valueOf(Q2), " url=", oVar.f184938d.iconUrl, " exposed:", Boolean.valueOf(this.f184750l));
            }
            if (oVar.f184939e && !this.f184750l) {
                this.f184750l = true;
                ReportController.n(null, "dc00898", "", "", "", "0X800A632", VipInfoHandler.I2(oVar.f184938d), 1, 0, "1", oVar.f184938d.advId, "", "");
                VipInfoHandler.b3(101, oVar.f184938d.advId);
            }
            if (QLog.isColorLevel()) {
                IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
                oVar.f184935a = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP));
                QLog.d("QQSettingMeBaseProcessor", 2, "VipInfoHandler vipAppinfo: " + iRedTouchManager.appToString(oVar.f184935a));
            }
            BusinessInfoCheckUpdate.AppInfo appInfo = oVar.f184935a;
            if ((appInfo != null && appInfo.iNewFlag.get() == 1) || oVar.f184939e) {
                QLog.e("QQSettingMeBaseProcessor", 1, "VipInfoHandler PreloadWebService updateVipItemView");
                try {
                    qBaseActivity.startService(new Intent(qBaseActivity, (Class<?>) PreloadWebService.class));
                } catch (Throwable th5) {
                    QLog.e("QQSettingMeBaseProcessor", 2, "PreloadWebService", th5);
                }
            }
        } catch (Exception e16) {
            QLog.e("QQSettingMeBaseProcessor", 1, "updateVipItemView: ", e16);
        }
        this.f184747i.setValue(oVar);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.l
    @NonNull
    public com.tencent.mobileqq.activity.qqsettingme.bean.o h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.qqsettingme.bean.o) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f184747i.getValue() == null) {
            return new com.tencent.mobileqq.activity.qqsettingme.bean.o();
        }
        return this.f184747i.getValue();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, appInfo, Boolean.valueOf(z16));
            return;
        }
        am.b(appInfo);
        com.tencent.mobileqq.activity.qqsettingme.bean.o h16 = h();
        h16.f184935a = appInfo;
        if (!this.f259745f) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(h16) { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.o f184755d;

            {
                this.f184755d = h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this, (Object) h16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    if (TianshuRedTouch.INSTANCE.j()) {
                        return;
                    }
                    am.a(MobileQQ.sMobileQQ.peekAppRuntime(), this.f184755d.f184935a, ((com.tencent.mobileqq.processor.c) QQSettingMeSuperMemberProcessor.this).f259744e);
                    QQSettingMeSuperMemberProcessor.this.f184747i.setValue(this.f184755d);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity != null && this.f184751m) {
            try {
                qBaseActivity.unregisterReceiver(this.f184754p);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("QQSettingMeBaseProcessor", 2, e16.toString());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            a0();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        if (!this.f184751m) {
            try {
                qBaseActivity.registerReceiver(this.f184754p, new IntentFilter(QQBrowserActivity.ACTION_UPDATE_VIP_INFO));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQSettingMeBaseProcessor", 2, "initUpdateVipInfoReceiver:" + e16);
                }
            }
            if (TextUtils.isEmpty(VipGrayConfigHelper.getsInstance().vipStr)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeSuperMemberProcessor.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQSettingMeBaseProcessor", 2, "init parse config json");
                        }
                        VipGrayConfigHelper.getsInstance().parseJson(MobileQQ.sMobileQQ.peekAppRuntime());
                    }
                }, 16, null, true);
            }
            this.f184751m = true;
        }
        this.f184750l = false;
        N();
        a0();
        X();
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_vip_identity", Boolean.FALSE);
        if (i3 != null && i3.getVisibility() == 0) {
            H("imp");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.as
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeSuperMemberProcessor.R();
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        V();
        a0();
        W();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d6  */
    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(View view) {
        boolean hasRedTouch;
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QQSettingMeBaseProcessor", 2, "enter vip");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRedTouchManager iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        if (companion.j()) {
            if (com.tencent.mobileqq.qqsettingme.a.e("d_vip_identity") == null) {
                return;
            } else {
                hasRedTouch = com.tencent.mobileqq.qqsettingme.a.e("d_vip_identity").Q();
            }
        } else if (com.tencent.mobileqq.qqsettingme.a.g("d_vip_identity") == null) {
            return;
        } else {
            hasRedTouch = com.tencent.mobileqq.qqsettingme.a.g("d_vip_identity").hasRedTouch();
        }
        if (f184746q) {
            hasRedTouch = companion.a(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP));
        }
        int J2 = VipInfoHandler.J2((QQAppInterface) peekAppRuntime, peekAppRuntime.getCurrentUin(), hasRedTouch);
        if (hasRedTouch) {
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_SECOND_VIP));
            String str = appInfoByPath.buffer.get();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("ad_id");
                    String string2 = jSONObject.getString(SsoReporter.POS_ID_KEY);
                    JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONObject.optString("msg")).optString(jSONObject.optString("_show_mission")));
                    if (jSONObject2.optString("src").equals("vipActPopupsAds")) {
                        String optString = jSONObject2.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                        if (!optString.isEmpty()) {
                            if (com.tencent.mobileqq.vas.ab.a.f307905a.a().getFirst() == ABTest.B) {
                                try {
                                    L(ContainerUtils.FIELD_DELIMITER + ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).getTraceDetailInfo(new IVipTraceDetailReport.b(VasWebConstants.REPORT_ORIGIN, "101", string, "5")));
                                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(view.getContext(), ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(optString, new IVipTraceDetailReport.b("vab_red", string2, string, "5"), true));
                                    z17 = true;
                                } catch (Exception e16) {
                                    e = e16;
                                    z16 = true;
                                    i16 = 0;
                                    QLog.e("QQSettingMeBaseProcessor", 1, e, new Object[i16]);
                                    z17 = z16;
                                    if (!z17) {
                                    }
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("jump", this.f184753o);
                                    ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8BE", "0X800A8BE", J2, 0, String.valueOf(J2), "", "", jSONObject3.toString());
                                    ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
                                    MobileReportManager.getInstance().qqSetingMeReport(1, 102, String.valueOf(J2));
                                    i3 = com.tencent.mobileqq.qqsettingme.a.f274434i;
                                    if (i3 <= 0) {
                                    }
                                }
                            }
                        }
                    }
                    z17 = false;
                } catch (Exception e17) {
                    e = e17;
                    i16 = 0;
                    z16 = false;
                }
            } else {
                z17 = false;
            }
            if (!z17) {
                L(MobileReportManager.getNewReportInfo(appInfoByPath));
            }
        } else {
            L(MobileReportManager.getNewDefaultReportInfo(VasWebConstants.REPORT_ORIGIN, "1"));
        }
        JSONObject jSONObject32 = new JSONObject();
        try {
            jSONObject32.put("jump", this.f184753o);
        } catch (JSONException e18) {
            QLog.i("QQSettingMeBaseProcessor", 1, "exception", e18);
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800A8BE", "0X800A8BE", J2, 0, String.valueOf(J2), "", "", jSONObject32.toString());
        ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
        MobileReportManager.getInstance().qqSetingMeReport(1, 102, String.valueOf(J2));
        i3 = com.tencent.mobileqq.qqsettingme.a.f274434i;
        if (i3 <= 0) {
            DrawerFrame.f185113z0 = 2;
        } else {
            DrawerFrame.f185113z0 = i3;
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_vip_identity";
    }
}
