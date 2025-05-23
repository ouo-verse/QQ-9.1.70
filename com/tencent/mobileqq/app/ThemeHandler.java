package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.vasbubble.BubbleTextColorManage;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.mobileqq.vas.theme.QUIResourcesTransform;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.INormalNightModeHandler;
import com.tencent.mobileqq.vas.theme.api.IThemeFileCheck;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.NormalNightModeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.theme.ThemeAuth$DiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth$ReqBody;
import com.tencent.pb.theme.ThemeAuth$RspBody;
import com.tencent.pb.theme.ThemeAuth$RspDiyThemeDetail;
import com.tencent.pb.theme.ThemeAuth$RspDiyThemeInfo;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x1ReqAuth;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x1RspAuth;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x2ReqCheck;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x3ReqSet;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x3RspSet;
import com.tencent.pb.theme.ThemeAuth$ThemeFileInfo;
import com.tencent.pb.theme.ThemeAuth$diyThemeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.theme.SkinEngine;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThemeHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private static String D;
    public Bundle C;

    /* renamed from: d, reason: collision with root package name */
    AtomicBoolean f195122d;

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f195123e;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f195124f;

    /* renamed from: h, reason: collision with root package name */
    private AppInterface f195125h;

    /* renamed from: i, reason: collision with root package name */
    AtomicBoolean f195126i;

    /* renamed from: m, reason: collision with root package name */
    public ThemeDiyStyleLogic.StyleCallBack f195127m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MyThemeSwitchCallback extends ThemeSwitchCallback {
        static IPatchRedirector $redirector_;

        MyThemeSwitchCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.ThemeSwitchCallback, com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
        public boolean beforeSwitch(ThemeLocator themeLocator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) themeLocator)).booleanValue();
            }
            if (!themeLocator.getThemeId().equals(ThemeUtil.getCurrentThemeId())) {
                QQToast.makeText(MobileQQ.sMobileQQ.peekAppRuntime().getApplication(), HardCodeUtil.qqStr(R.string.u4j), 4000).show();
                VasLogReporter.getTheme().report("Toast:" + HardCodeUtil.qqStr(R.string.u4j));
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements QueryItemCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ThemeLocator f195129d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f195130e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f195131f;

        a(ThemeLocator themeLocator, Context context, Bundle bundle) {
            this.f195129d = themeLocator;
            this.f195130e = context;
            this.f195131f = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ThemeHandler.this, themeLocator, context, bundle);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback
        public void onQueryItemVer(int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                return;
            }
            QLog.e("Theme.ThemeHandler", 1, "onQueryItemVer: " + i3 + "," + str + "," + str2);
            if (i3 == 0) {
                this.f195129d.init(this.f195130e, str, str2);
                this.f195131f.putString("themePath", this.f195129d.getUnzipPath());
                ThemeHandler.this.R2(this.f195131f);
            } else {
                this.f195131f.putString("themeId", "1000");
                this.f195131f.remove("themePath");
                ThemeHandler.this.R2(this.f195131f);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69990);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            D = null;
        }
    }

    ThemeHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195122d = new AtomicBoolean(false);
        this.f195123e = new AtomicBoolean(true);
        this.f195126i = new AtomicBoolean(false);
        this.f195124f = qQAppInterface;
        this.f195125h = qQAppInterface;
    }

    private HashMap<String, String> F2(String str) {
        ArrayList<String> childFiles = FileUtils.getChildFiles(str);
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < 3 && i3 < childFiles.size(); i3++) {
            int nextInt = new Random().nextInt(childFiles.size() - 1);
            String str2 = childFiles.get(nextInt);
            String substring = str2.substring(str2.substring(0, str2.lastIndexOf(47)).lastIndexOf(47) + 1);
            if (substring != null && substring.length() > 0 && !hashMap.containsKey(substring)) {
                String encryptFile = FileUtils.encryptFile(str2, KeyPropertiesCompact.DIGEST_MD5);
                if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "Theme getRandomFileMd5 file=" + str2 + ",key=" + substring + ",md5=" + encryptFile + ", files=" + childFiles.size() + ", index=" + nextInt);
                }
                if (encryptFile != null && encryptFile.length() > 0) {
                    hashMap.put(substring, encryptFile);
                }
            }
        }
        return hashMap;
    }

    private int G2(ToServiceMsg toServiceMsg, int i3) throws InvalidProtocolBufferMicroException {
        if (-1 == i3) {
            ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
            themeAuth$ReqBody.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
            i3 = themeAuth$ReqBody.uint32_sub_cmd.get();
        }
        if (1 == i3) {
            ThemeUtil.getUinThemePreferences(this.f195125h).edit().putLong("authTime", 0L).commit();
        }
        return i3;
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            com.tencent.relation.common.handler.d.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, false);
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            if (mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                try {
                    oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    com.tencent.relation.common.handler.d.c().onReceive(toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, true);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    com.tencent.relation.common.handler.d.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, true);
                    return;
                }
            }
            com.tencent.relation.common.handler.d.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, true);
        } catch (InvalidProtocolBufferMicroException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("Theme.ThemeHandler", 2, String.format("handleReq0x5eb  e=%s", e17.toString()));
            }
            com.tencent.relation.common.handler.d.c().onReceive(toServiceMsg, fromServiceMsg, obj, null, true);
        }
    }

    public static void K2(int i3, int i16, String str, int i17, BaseActivity baseActivity) {
        if (i3 == 1) {
            baseActivity.startActivity(new Intent(baseActivity, (Class<?>) GeneralSettingActivity.class));
            return;
        }
        Intent intent = new Intent(baseActivity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("individuation_url_type", VasWebviewConstants.REPORT_FROM_INDIVIDUATION_SET);
        String marketUrl = IndividuationUrlHelper.getMarketUrl(baseActivity, "theme", IndividuationUrlHelper.AdTag.INDIVIDUATION_THEME_ADTAG);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(marketUrl);
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (marketUrl.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(str2);
        String str3 = sb5.toString() + "dialog_source=other&authresult=" + i16;
        if (!TextUtils.isEmpty(str)) {
            if (str3.contains("id=[id]")) {
                str3 = str3.replace("[id]", str);
            } else {
                str3 = str3 + "&id=" + str;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Theme.ThemeHandler", 2, "theme market url: " + str3);
        }
        VasWebviewUtil.openQQBrowserWithoutAD(baseActivity, VasWebviewUtil.addEntryParamToUrl(str3, 54), 32L, intent, true, -1);
    }

    private void L2(String str, String str2) {
        if (ThemeReporter.FROM_AUTH.equalsIgnoreCase(str2)) {
            if (!DarkModeManager.c(str, str2)) {
                M2(str, str2);
                return;
            } else {
                if (!ThemeUtil.isFixTheme(str)) {
                    ThemeSwitchUtil.setPreviousThemeIdVersion(this.f195124f, str, "20000000");
                    return;
                }
                return;
            }
        }
        M2(str, str2);
    }

    private void N2(String str) {
        boolean a16 = com.tencent.relation.common.config.toggle.b.a(7);
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 1, String.format("reqGetNormalNightModeSwitch.normalNightReqMerge = %b", Boolean.valueOf(a16)));
        }
        if (!a16 && NormalNightModeUtil.getNormalNightModeFeatureSwitch()) {
            ((INormalNightModeHandler) QRoute.api(INormalNightModeHandler.class)).reqGetNormalNightModeSwitch(this.f195124f, str);
        }
    }

    private void O2(String str, int i3, int i16, int i17, int i18) {
        Bundle bundle = new Bundle();
        bundle.putString("theme_id", str);
        bundle.putInt("simple_theme_id", i3);
        bundle.putInt("simple_open", i16);
        bundle.putInt("study_switch", i17);
        bundle.putInt("kid_switch", i18);
        String currentAccountUin = this.f195124f.getCurrentAccountUin();
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, String.format("req0x5ebForTheme uin=%s", currentAccountUin));
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = com.tencent.relation.common.handler.d.c().get0x5ebReqBody(bundle, new oidb_0x5eb$ReqBody());
        if (oidb_0x5eb_reqbody == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Theme.ThemeHandler", 1, "null == reqBody");
                return;
            }
            return;
        }
        try {
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.f195124f.getCurrentAccountUin())));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, String.format("req0x5ebForTheme uin=%s body.uint32_simple_ui_switch:%s", currentAccountUin, String.valueOf(oidb_0x5eb_reqbody.uint32_simple_ui_switch.get())));
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(ThemeConstants.CMD_REQ_GET_0X5EB_FOR_THEME, 1515, 22, oidb_0x5eb_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("uin", currentAccountUin);
        makeOIDBPkg.extraData.putAll(com.tencent.relation.common.handler.d.c().getRequestExtraData());
        sendPbReq(makeOIDBPkg);
    }

    private void P2(String str, int i3, int i16, int i17, int i18) {
        boolean z16;
        boolean z17;
        O2(str, i3, i16, i17, i18);
        boolean z18 = false;
        if (i16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QQAppInterface qQAppInterface = this.f195124f;
        if (i17 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i18 == 1) {
            z18 = true;
        }
        SimpleUIHandler.L2(z16, i3, qQAppInterface, z17, z18);
        N2(str);
    }

    private boolean Q2(ToServiceMsg toServiceMsg, ThemeAuth$RspBody themeAuth$RspBody, boolean z16) throws InvalidProtocolBufferMicroException {
        String valueOf;
        int i3;
        Bundle bundle;
        String qqStr = HardCodeUtil.qqStr(R.string.u4l);
        int i16 = 4;
        if (z16) {
            ThemeAuth$SubCmd0x3RspSet themeAuth$SubCmd0x3RspSet = themeAuth$RspBody.msg_subcmd0x3_rsp_set.get();
            i3 = themeAuth$SubCmd0x3RspSet.int32_result.get();
            valueOf = String.valueOf(themeAuth$SubCmd0x3RspSet.uint32_theme_id.get());
            qqStr = themeAuth$SubCmd0x3RspSet.str_diy_theme_err_msg.get();
        } else {
            ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
            themeAuth$ReqBody.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
            valueOf = String.valueOf(themeAuth$ReqBody.msg_subcmd0x3_req_set.get().uint32_theme_id.get());
            i3 = ErrorCode.WX_TTS_ERROR_TEXT_TO_GBK;
        }
        VasLogReporter.getTheme().report("handleThemeAuth Set result:" + i3 + ", themeId:" + valueOf);
        if (this.f195127m != null && (bundle = this.C) != null) {
            bundle.putString("message", qqStr);
            this.C.putInt(ThemeConstants.BUNDLE_KEY_RESULT_INT, i3);
            if (!TextUtils.isEmpty(valueOf) && valueOf.equals(this.C.getString("themeId"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("Theme.ThemeHandler", 2, "handleThemeAuth set back themeId=" + valueOf + ", result=" + i3);
                }
                ThemeDiyStyleLogic.StyleCallBack styleCallBack = this.f195127m;
                if (i3 != 0) {
                    i16 = 8;
                }
                styleCallBack.callback(16, i16, this.C, null);
                this.C = null;
                this.f195127m = null;
                this.f195126i.set(true);
                return false;
            }
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:themeId has changed themeId=" + valueOf + ", rbThemeid=" + this.C.getString("themeId"));
            return false;
        }
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Set result:null == service || null == reqbundle, result:" + i3);
        this.C = null;
        this.f195127m = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f3 A[Catch: Exception -> 0x0276, TryCatch #1 {Exception -> 0x0276, blocks: (B:26:0x01a3, B:28:0x01f3, B:29:0x020f, B:31:0x0218, B:33:0x021e, B:36:0x0244, B:39:0x025c, B:59:0x0172, B:61:0x017f, B:64:0x0186, B:66:0x018c, B:67:0x0193, B:69:0x0198), top: B:58:0x0172 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R2(Bundle bundle) {
        String str;
        String str2;
        int i3;
        int i16;
        SharedPreferences uinThemePreferences;
        String string;
        ThemeAuth$SubCmd0x1ReqAuth themeAuth$SubCmd0x1ReqAuth;
        ThemeAuth$SubCmd0x1ReqAuth themeAuth$SubCmd0x1ReqAuth2;
        String str3;
        File file;
        ThemeUtil.ThemeInfo themeInfo;
        int i17;
        AppInterface appInterface = this.f195125h;
        if (appInterface == null) {
            QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
            return;
        }
        MobileQQ application = appInterface.getApplication();
        String string2 = bundle.getString("themeId");
        String string3 = bundle.getString("themePath");
        try {
            ThemeAuth$SubCmd0x1ReqAuth themeAuth$SubCmd0x1ReqAuth3 = new ThemeAuth$SubCmd0x1ReqAuth();
            themeAuth$SubCmd0x1ReqAuth3.uint32_op_type.set(1);
            themeAuth$SubCmd0x1ReqAuth3.uint32_theme_id.set(Integer.parseInt(string2));
            themeAuth$SubCmd0x1ReqAuth3.str_theme_version.set("20000000");
            themeAuth$SubCmd0x1ReqAuth3.str_theme_density_type.set(ThemeUtil.getThemeDensity(BaseApplication.getContext()));
            uinThemePreferences = ThemeUtil.getUinThemePreferences(this.f195125h);
            string = uinThemePreferences.getString("currentThemeId_6.3.5", null);
            themeAuth$SubCmd0x1ReqAuth = themeAuth$SubCmd0x1ReqAuth3;
            QLog.d("Theme.ThemeHandler", 1, "Theme Auth themeId=" + string2 + MttLoader.QQBROWSER_PARAMS_VERSION + "20000000, userThemeId=" + string + ",currentThemeResPath=" + string3 + ", oldTime=" + uinThemePreferences.getLong("themeSetTimeKey", 0L));
        } catch (Exception e16) {
            e = e16;
            str = "20000000";
        }
        if (!"1000".equals(string2)) {
            HashMap<String, String> F2 = F2(string3);
            if (F2.size() < 3) {
                QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth fileMD5 size error:size=" + F2.size());
            }
            Iterator<Map.Entry<String, String>> it = F2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "Theme file Info,Filepath=" + next.getKey() + ",FileMd5=" + next.getValue());
                }
                ThemeAuth$ThemeFileInfo themeAuth$ThemeFileInfo = new ThemeAuth$ThemeFileInfo();
                Iterator<Map.Entry<String, String>> it5 = it;
                themeAuth$ThemeFileInfo.str_file_path.set(next.getKey());
                themeAuth$ThemeFileInfo.str_file_md5.set(next.getValue());
                ThemeAuth$SubCmd0x1ReqAuth themeAuth$SubCmd0x1ReqAuth4 = themeAuth$SubCmd0x1ReqAuth;
                themeAuth$SubCmd0x1ReqAuth4.rpt_msg_topic_file_info.add(themeAuth$ThemeFileInfo);
                themeAuth$SubCmd0x1ReqAuth = themeAuth$SubCmd0x1ReqAuth4;
                it = it5;
            }
            themeAuth$SubCmd0x1ReqAuth2 = themeAuth$SubCmd0x1ReqAuth;
            uinThemePreferences.edit().putLong("authTime", 0L).commit();
        } else {
            themeAuth$SubCmd0x1ReqAuth2 = themeAuth$SubCmd0x1ReqAuth;
            if (!TextUtils.isEmpty(string)) {
                if ("1000".equals(string)) {
                }
            }
            long j3 = uinThemePreferences.getLong("authTime", 0L);
            str = "20000000";
            str3 = string3;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis <= j3 + 7200000 && !StudyModeManager.t()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Theme.ThemeHandler", 2, "sendThemeAuth nowTime <= authTime + 2h");
                    }
                    DarkModeManager.p(true);
                    return;
                }
                uinThemePreferences.edit().putLong("authTime", currentTimeMillis).commit();
                ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
                themeAuth$ReqBody.uint32_sub_cmd.set(1);
                themeAuth$ReqBody.int32_plat_id.set(109);
                themeAuth$ReqBody.str_qq_version.set(AppSetting.f99554n);
                themeAuth$ReqBody.uint32_qq_version.set(Integer.parseInt(AppSetting.f99542b));
                themeAuth$ReqBody.msg_subcmd0x1_req_auth.set(themeAuth$SubCmd0x1ReqAuth2);
                themeAuth$ReqBody.setHasFlag(true);
                ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195125h.getCurrentAccountUin(), ThemeConstants.CMD_THEME_AUTH);
                toServiceMsg.putWupBuffer(themeAuth$ReqBody.toByteArray());
                toServiceMsg.extraData.putAll(bundle);
                if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "Theme Auth send request, themeID=" + string2 + ", userThemeId=" + string);
                }
                super.sendPbReq(toServiceMsg);
                if (!"1000".equals(string2) && !TextUtils.isEmpty(str3)) {
                    file = new File(str3);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    themeInfo = ThemeUtil.getThemeInfo(application, string2);
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    if (themeInfo == null) {
                        i17 = 1;
                    } else {
                        i17 = -1;
                    }
                    ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME_SP_SPEED, ThemeReporter.FROM_AUTH, 153, -1, i17, String.valueOf(currentTimeMillis3), "6653", com.tencent.mobileqq.msf.core.auth.k.f247491e, "");
                    if (file.isDirectory() || themeInfo == null) {
                        QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + str3);
                    }
                }
                str2 = str;
                i3 = 1;
            } catch (Exception e17) {
                e = e17;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Theme Auth send Exception:");
                sb5.append(e.getMessage());
                sb5.append(", themeId=");
                sb5.append(string2);
                sb5.append(", version=");
                str2 = str;
                sb5.append(str2);
                String sb6 = sb5.toString();
                i3 = 1;
                QLog.e("Theme.ThemeHandler", 1, sb6);
                if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
                }
                int systemNetwork = NetworkUtil.getSystemNetwork(null);
                if (BaseApplicationImpl.IS_SUPPORT_THEME) {
                }
                ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_ENGINE, 157, systemNetwork, i16, string2, str2, "1", "");
            }
            if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
                QLog.e("Theme.ThemeHandler", i3, "sendThemeAuth ERROR_CODE_ISNOT_SUPPORT_THEME.");
            }
            int systemNetwork2 = NetworkUtil.getSystemNetwork(null);
            if (BaseApplicationImpl.IS_SUPPORT_THEME) {
                i16 = i3;
            } else {
                i16 = -40;
            }
            ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_ENGINE, 157, systemNetwork2, i16, string2, str2, "1", "");
        }
        str = "20000000";
        str3 = string3;
        ThemeAuth$ReqBody themeAuth$ReqBody2 = new ThemeAuth$ReqBody();
        themeAuth$ReqBody2.uint32_sub_cmd.set(1);
        themeAuth$ReqBody2.int32_plat_id.set(109);
        themeAuth$ReqBody2.str_qq_version.set(AppSetting.f99554n);
        themeAuth$ReqBody2.uint32_qq_version.set(Integer.parseInt(AppSetting.f99542b));
        themeAuth$ReqBody2.msg_subcmd0x1_req_auth.set(themeAuth$SubCmd0x1ReqAuth2);
        themeAuth$ReqBody2.setHasFlag(true);
        ToServiceMsg toServiceMsg2 = new ToServiceMsg("mobileqq.service", this.f195125h.getCurrentAccountUin(), ThemeConstants.CMD_THEME_AUTH);
        toServiceMsg2.putWupBuffer(themeAuth$ReqBody2.toByteArray());
        toServiceMsg2.extraData.putAll(bundle);
        if (QLog.isColorLevel()) {
        }
        super.sendPbReq(toServiceMsg2);
        if (!"1000".equals(string2)) {
            file = new File(str3);
            long currentTimeMillis22 = System.currentTimeMillis();
            themeInfo = ThemeUtil.getThemeInfo(application, string2);
            long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis22;
            if (themeInfo == null) {
            }
            ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME_SP_SPEED, ThemeReporter.FROM_AUTH, 153, -1, i17, String.valueOf(currentTimeMillis32), "6653", com.tencent.mobileqq.msf.core.auth.k.f247491e, "");
            if (file.isDirectory()) {
            }
            QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth fileNum Error:, themeInfo == null || currentThemeResPath:" + str3);
        }
        str2 = str;
        i3 = 1;
        if (!BaseApplicationImpl.IS_SUPPORT_THEME) {
        }
        int systemNetwork22 = NetworkUtil.getSystemNetwork(null);
        if (BaseApplicationImpl.IS_SUPPORT_THEME) {
        }
        ThemeReporter.reportTheme(null, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_ENGINE, 157, systemNetwork22, i16, string2, str2, "1", "");
    }

    private void S2(int i3, int i16, String str, String str2, String str3, ThemeAuth$DiyThemeDetail themeAuth$DiyThemeDetail) {
        String str4;
        int i17;
        int i18;
        MobileQQ mobileQQ;
        int i19;
        boolean z16;
        String str5;
        int i26;
        String str6;
        String str7;
        String str8;
        MobileQQ application = this.f195125h.getApplication();
        SharedPreferences sharedPreferences = ThemeBackground.getSharedPreferences(application, this.f195125h.getAccount(), 0);
        if (i3 == 2 && !ChatBackgroundUtil.getChatBackgroundPath(application, this.f195125h.getAccount(), null).equals("null")) {
            return;
        }
        if (TextUtils.isEmpty(str) && themeAuth$DiyThemeDetail != null) {
            str4 = themeAuth$DiyThemeDetail.str_bg_url.get();
        } else {
            str4 = str;
        }
        int i27 = i16;
        if (1 > i27 && themeAuth$DiyThemeDetail != null) {
            i27 = themeAuth$DiyThemeDetail.uin32_id.get();
        }
        int i28 = i27;
        if (QLog.isColorLevel()) {
            QLog.d("Theme.ThemeHandler", 2, "update sv ThemeBackground, page=" + i3 + ", id=" + i28 + ", url=" + str4);
        }
        if (!TextUtils.isEmpty(str4)) {
            String string = sharedPreferences.getString(str3 + "_id", "");
            String string2 = sharedPreferences.getString(str3 + ThemeConstants.THEME_DIY_BG_URL_SUFFIX, "");
            if (("" + i28).equals(string) && !TextUtils.isEmpty(string2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Theme.ThemeHandler", 2, "updateThemeBackgroundPic, bgType=" + str3 + ", notChange=" + z16 + ", localId=" + string + ", id=" + i28 + ", url=" + str4 + ", page=" + i3);
            }
            if (z16) {
                return;
            }
            if (themeAuth$DiyThemeDetail != null) {
                str5 = themeAuth$DiyThemeDetail.str_name.get();
            } else {
                str5 = "" + i28;
            }
            String str9 = str5;
            if (themeAuth$DiyThemeDetail != null) {
                i26 = themeAuth$DiyThemeDetail.uin32_feetype.get();
            } else {
                i26 = 1;
            }
            if (themeAuth$DiyThemeDetail != null) {
                str6 = themeAuth$DiyThemeDetail.str_bg_thumbnail_url.get();
            } else {
                str6 = null;
            }
            String shopBgPath = ChatBackgroundUtil.getShopBgPath("" + i28);
            i18 = 1;
            String str10 = str4;
            ThemeBackground.setThemeBackgroundPic(application, str3, this.f195125h.getAccount(), shopBgPath, str4, "" + i28, str9, i26, str6, true);
            if (!str3.equals(str2)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                i17 = i28;
                sb5.append(i17);
                String shopBgPath2 = ChatBackgroundUtil.getShopBgPath(sb5.toString());
                str7 = shopBgPath;
                str8 = null;
                mobileQQ = application;
                ThemeBackground.setThemeBackgroundPic(application, str2, this.f195125h.getAccount(), shopBgPath2, str10, "" + i17, str9, i26, str6, true);
            } else {
                str7 = shopBgPath;
                mobileQQ = application;
                i17 = i28;
                str8 = null;
            }
            if (i3 == 2) {
                ChatBackgroundUtil.setChatBackground(mobileQQ, this.f195124f.getAccount(), str8, str7);
            }
        } else {
            i17 = i28;
            i18 = 1;
            mobileQQ = application;
        }
        if ("100".equals(String.valueOf(i17)) || "0".equals(String.valueOf(i17))) {
            if (themeAuth$DiyThemeDetail != null) {
                i19 = themeAuth$DiyThemeDetail.uin32_feetype.get();
            } else {
                i19 = i18;
            }
            ThemeBackground.setThemeBackgroundPic(mobileQQ, str3, this.f195125h.getAccount(), "", "", "", "", i19, null, true);
        }
    }

    private void V2(int i3, String str, String str2, ThemeAuth$SubCmd0x1RspAuth themeAuth$SubCmd0x1RspAuth) {
        String str3;
        String str4;
        String valueOf = String.valueOf(themeAuth$SubCmd0x1RspAuth.uint32_theme_id.get());
        int i16 = themeAuth$SubCmd0x1RspAuth.uint32_concise_id.get();
        int i17 = themeAuth$SubCmd0x1RspAuth.uint32_concise_switch.get();
        int i18 = themeAuth$SubCmd0x1RspAuth.uint32_study_switch.get();
        int i19 = themeAuth$SubCmd0x1RspAuth.uint32_young_switch.get();
        if (i17 == 1) {
            str3 = String.valueOf(i16);
        } else {
            str3 = valueOf;
        }
        SimpleModeHelper.f307332f = str3;
        P2(valueOf, i16, i17, i18, i19);
        VasLogReporter.getTheme().report("native set fail - authFailed themeId:" + valueOf + " ret:" + i3 + " simpleOpen | studyOpen | kidOpen:" + (i16 | i18 | i19));
        int i26 = 3;
        if (3 == i3 && !"1000".equals(str)) {
            boolean z16 = false;
            ThemeUtil.setErrorThemeId(this.f195125h.getApplication(), str, false);
            ThemeUtil.getUserCurrentThemeVersion(this.f195125h);
            boolean skinRootPath = SkinEngine.getInstances().setSkinRootPath(this.f195125h.getApplication(), null);
            QUIResourcesTransform.getInstance().onThemeUpdate("1000", null);
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, set default theme");
            if (skinRootPath) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.ThemeHandler.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThemeHandler.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        QQToast.makeText(ThemeHandler.this.f195125h.getApplication(), HardCodeUtil.qqStr(R.string.u4k), 4000).show();
                        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, QQToast.makeText: set default theme");
                        VasLogReporter.getTheme().report("handleThemeAuth Error, set default theme. Toast:" + HardCodeUtil.qqStr(R.string.u4k));
                    }
                });
            }
            ThemeUtil.ThemeInfo themeInfo = ThemeUtil.getThemeInfo(this.f195125h.getApplication(), str);
            if (themeInfo != null) {
                themeInfo.status = "1";
                ThemeUtil.setThemeInfo(this.f195125h.getApplication(), themeInfo);
                if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth error, set theme status=ThemeUtil.THEME_STATUS_DOWNLOAD_END, reqthemeId=" + str);
                }
            }
            try {
                String basePath = ThemeLocator.getLocator(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + valueOf).getBasePath(this.f195125h.getApplication());
                if (!I2() || !VasToggle.THEME_FILE_CHECK_NEW_ENABLE.isEnable(true)) {
                    z16 = true;
                }
                FileUtils.delete(basePath, z16);
                QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth no right, delete: " + basePath);
                return;
            } catch (Exception e16) {
                QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth delete Error, msg=" + e16.getMessage());
                return;
            }
        }
        if (i3 != 4) {
            ThemeUtil.setWeekLoopTheme(this.f195125h, null, null, 0L);
        }
        boolean skinRootPath2 = SkinEngine.getInstances().setSkinRootPath(this.f195125h.getApplication(), null);
        QUIResourcesTransform.getInstance().onThemeUpdate("1000", null);
        QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth vip Error, set default theme");
        if (i3 != 1 && i3 != 2) {
            if (i3 != 10 && i3 != 11) {
                if (i3 != 6) {
                    i26 = 4;
                }
            } else {
                i26 = 2;
            }
        } else {
            i26 = 1;
        }
        if (skinRootPath2) {
            ReportController.o(null, "CliOper", "", "", "theme", "0X8007234", 0, 0, String.valueOf(i26), "", "", "");
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = HardCodeUtil.qqStr(R.string.u4i);
        } else {
            str4 = str2;
        }
        if (skinRootPath2) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString("expireMsg", str4);
            bundle.putString("themeId", str);
            bundle.putInt("authResult", i3);
            bundle.putInt("expireType", i26);
            bundle.putInt("sSimpleOpen", i17);
            obtain.obj = bundle;
            if (i17 != 1) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(obtain) { // from class: com.tencent.mobileqq.app.ThemeHandler.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Message f195128d;

                    {
                        this.f195128d = obtain;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThemeHandler.this, (Object) obtain);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            BannerManager.l().O(ThemeOverdueBannerProcessor.f185275d, 2, this.f195128d);
                        }
                    }
                }, 4000L);
            } else {
                BannerManager.l().O(ThemeOverdueBannerProcessor.f185275d, 2, obtain);
            }
        }
        if (ThemeBackground.getMarkOfAioBgFromDiy(this.f195125h.getApplication(), AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, this.f195125h.getAccount())) {
            ChatBackgroundUtil.setChatBackground(this.f195125h.getApplication(), this.f195124f.getAccount(), null, "null");
            ThemeBackground.clear(this.f195125h.getApplication(), AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, this.f195124f.getAccount());
        }
        ThemeBackground.clear(this.f195125h.getApplication(), AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG, this.f195124f.getAccount());
        ThemeBackground.clear(this.f195125h.getApplication(), AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, this.f195124f.getAccount());
        ThemeBackground.clear(this.f195125h.getApplication(), AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH_PNG, this.f195124f.getAccount());
        ThemeBackground.clear(this.f195125h.getApplication(), AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH_PNG, this.f195124f.getAccount());
    }

    private boolean W2(ToServiceMsg toServiceMsg, ThemeAuth$SubCmd0x1RspAuth themeAuth$SubCmd0x1RspAuth, String str, String str2) {
        String str3;
        String valueOf = String.valueOf(themeAuth$SubCmd0x1RspAuth.uint32_theme_id.get());
        String str4 = themeAuth$SubCmd0x1RspAuth.str_version.get();
        String str5 = themeAuth$SubCmd0x1RspAuth.str_download_url.get();
        int i3 = themeAuth$SubCmd0x1RspAuth.uint32_concise_id.get();
        int i16 = themeAuth$SubCmd0x1RspAuth.uint32_concise_switch.get();
        int i17 = themeAuth$SubCmd0x1RspAuth.uint32_study_switch.get();
        int i18 = themeAuth$SubCmd0x1RspAuth.uint32_young_switch.get();
        int i19 = themeAuth$SubCmd0x1RspAuth.int32_suit_id.get();
        StringBuilder sb5 = new StringBuilder("native auth - authSuccess");
        sb5.append(" themeId:");
        sb5.append(valueOf);
        sb5.append(" simpleOpen | studyOpen | kidOpen:");
        sb5.append(i16 + "|" + i17 + "|" + i18);
        VasLogReporter.getTheme().report(sb5.toString());
        if (QLog.isColorLevel() || (str2 != null && !str.equals(valueOf))) {
            QLog.d("Theme.ThemeHandler", 2, "authHandler get themeId=" + valueOf + ",ver=" + str4 + ",Url=" + str5 + ", seriesId=" + i19 + ", reqthemeId:" + str + ", reqVersion:" + str2 + ", sSimpleThemeId:" + i3 + ", sSimpleOpen:" + i16);
        }
        if (i16 == 1) {
            str3 = String.valueOf(i3);
        } else {
            str3 = valueOf;
        }
        SimpleModeHelper.f307332f = str3;
        P2(valueOf, i3, i16, i17, i18);
        if ("999".equals(valueOf) || "1000".equals(valueOf)) {
            str4 = "20000000";
        }
        if (TextUtils.isEmpty(str4) || "0".equals(valueOf)) {
            str4 = String.valueOf(200);
        }
        String string = toServiceMsg.extraData.getString("oldEnginePath", null);
        String skinRootPath = SkinEngine.getInstances().getSkinRootPath();
        QLog.e("Theme.ThemeHandler", 1, "engine path old is : " + string + " new is " + skinRootPath);
        if (!TextUtils.isEmpty(skinRootPath) && !skinRootPath.equals(string)) {
            QLog.e("Theme.ThemeHandler", 1, "engine init during auth, resend auth");
            sendThemeAuth();
            return true;
        }
        if (i19 <= 0) {
            QLog.e("Theme.ThemeHandler", 1, "clear weekTheme because seriesId=" + i19);
            ThemeUtil.setWeekLoopTheme(this.f195125h, null, null, 0L);
        }
        if (i19 > 0) {
            String weekLoopTheme = ThemeUtil.getWeekLoopTheme(this.f195124f);
            if (!TextUtils.isEmpty(weekLoopTheme)) {
                L2(weekLoopTheme, ThemeReporter.FROM_WEEKLOOP);
                BubbleTextColorManage.d().h();
                return false;
            }
        }
        if (!"0".equals(valueOf) && !TextUtils.isEmpty(str4) && !this.f195126i.get()) {
            if (themeAuth$SubCmd0x1RspAuth.uint32_diy_theme_flag.get() == 1) {
                ThemeAuth$RspDiyThemeInfo themeAuth$RspDiyThemeInfo = themeAuth$SubCmd0x1RspAuth.rsp_diy_theme_info.get();
                ThemeAuth$RspDiyThemeDetail themeAuth$RspDiyThemeDetail = themeAuth$SubCmd0x1RspAuth.rsp_diy_theme_detail.get();
                S2(0, themeAuth$RspDiyThemeInfo.uin32_drawer_tab_id.get(), themeAuth$RspDiyThemeInfo.str_drawer_tab_url.get(), AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH, AppConstants.Preferences.THEME_DIY_BG_SETTING_PATH_PNG, themeAuth$RspDiyThemeDetail.drawer_tab_detail.get());
                S2(1, themeAuth$RspDiyThemeInfo.uin32_message_tab_id.get(), themeAuth$RspDiyThemeInfo.str_message_tab_url.get(), AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH, AppConstants.Preferences.THEME_DIY_BG_MESSAGE_PATH_PNG, themeAuth$RspDiyThemeDetail.message_tab_detail.get());
                S2(2, themeAuth$RspDiyThemeInfo.uin32_aio_tab_id.get(), themeAuth$RspDiyThemeInfo.str_aio_tab_url.get(), AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, AppConstants.Preferences.THEME_DIY_BG_AIO_PATH, themeAuth$RspDiyThemeDetail.aio_tab_detail.get());
                S2(3, themeAuth$RspDiyThemeInfo.uin32_friend_tab_id.get(), themeAuth$RspDiyThemeInfo.str_friend_tab_url.get(), AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH, AppConstants.Preferences.THEME_DIY_BG_FRIEND_PATH_PNG, themeAuth$RspDiyThemeDetail.friend_tab_detail.get());
                S2(4, themeAuth$RspDiyThemeInfo.uin32_dynamic_tab_id.get(), themeAuth$RspDiyThemeInfo.str_dynamic_tab_url.get(), AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH, AppConstants.Preferences.THEME_DIY_BG_DYNAMIC_PATH_PNG, themeAuth$RspDiyThemeDetail.dynamic_tab_detail.get());
            }
            L2(valueOf, ThemeReporter.FROM_AUTH);
        } else {
            sendThemeVersionCheck(null, null, true);
        }
        BubbleTextColorManage.d().h();
        return false;
    }

    private void X2(ThemeAuth$RspBody themeAuth$RspBody) {
        int i3 = themeAuth$RspBody.msg_subcmd0x2_rsp_check.get().int32_result.get();
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "handleThemeVersionCheck:" + i3);
        }
        String account = this.f195125h.getAccount();
        if (!TextUtils.isEmpty(account)) {
            SharedPreferences sharedPreferences = this.f195125h.getApplication().getSharedPreferences(account, 0);
            if (i3 == 6) {
                sharedPreferences.edit().putBoolean("need_check_theme_ver", true).commit();
            }
            if (sharedPreferences.getBoolean("need_check_theme_ver", false)) {
                sharedPreferences.edit().putBoolean("need_check_theme_ver", false).commit();
            }
        }
        if (i3 == 0) {
            Message obtain = Message.obtain();
            obtain.obj = D;
            BannerManager.l().O(ThemeVersionUpdateBannerProcessor.f185276d, 2, obtain);
            ReportController.o(this.f195124f, "CliOper", "", "", "0X8005B9E", "0X8005B9E", 0, 0, "", "", "", "");
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.ThemeHandler.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThemeHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        BannerManager.l().O(ThemeVersionUpdateBannerProcessor.f185276d, 0, null);
                    }
                }
            }, 90000L);
        }
    }

    protected boolean I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ((IFeatureRuntimeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("vas_theme_zip_auth", false);
    }

    protected boolean J2(String str) {
        String string;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        QZipFile qZipFile = null;
        try {
            try {
                IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFeatureRuntimeService.class, "all");
                if (I2() && (string = iFeatureRuntimeService.getString("vas_theme_zip_auth", "10")) != null && !string.isEmpty()) {
                    int parseInt = Integer.parseInt(string);
                    String basePath = ThemeLocator.getLocator(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + str).getBasePath(this.f195125h.getApplication());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(basePath);
                    String str2 = File.separator;
                    sb5.append(str2);
                    sb5.append(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX);
                    sb5.append(str);
                    sb5.append(".zip");
                    String sb6 = sb5.toString();
                    if (!new File(sb6).exists()) {
                        return true;
                    }
                    QZipFile qZipFile2 = new QZipFile(basePath + str2 + ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + str + ".zip");
                    try {
                        int size = qZipFile2.size();
                        String str3 = basePath + str2 + ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + str + str2 + FileUtils.encryptFile(sb6, KeyPropertiesCompact.DIGEST_MD5);
                        if (!new File(str3).exists()) {
                            try {
                                qZipFile2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                            return true;
                        }
                        long fileAmount = FileUtils.getFileAmount(str3);
                        QLog.e("Theme.ThemeHandler", 1, "isThemeCompressSucceed:zipFileSize=" + size + ", unzipFileCount=" + fileAmount + ",limit=" + parseInt);
                        if (size - fileAmount <= parseInt) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            VasLogReporter.getTheme().report("native set fail - unCompress");
                        }
                        try {
                            qZipFile2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        return z16;
                    } catch (Exception e18) {
                        e = e18;
                        qZipFile = qZipFile2;
                        QLog.e("Theme.ThemeHandler", 1, e, new Object[0]);
                        if (qZipFile != null) {
                            try {
                                qZipFile.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        qZipFile = qZipFile2;
                        if (qZipFile != null) {
                            try {
                                qZipFile.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e27) {
            e = e27;
        }
        return true;
    }

    public void M2(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(this.f195124f, false, null);
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (simpleUISwitch) {
            VasLogReporter.getTheme().report("native set fail - simple_ui:" + str);
            QLog.d("Theme.ThemeHandler", 1, "onGetServerTheme: " + str + ", isSimpleUI: " + simpleUISwitch + ", " + str2);
            return;
        }
        if (isNowThemeIsNight) {
            ThemeSwitcher.startSwitch("1103", str2, null);
        } else if (!ElderModeManager.j()) {
            U2(str, str2);
        }
        QLog.d("Theme.ThemeHandler", 1, "onGetServerTheme: " + str + ", isNowNight: " + isNowThemeIsNight + ", " + str2);
        if (!ThemeUtil.isFixTheme(str)) {
            ThemeSwitchUtil.setPreviousThemeIdVersion(this.f195124f, str, "20000000");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0098 A[Catch: Exception -> 0x0163, TryCatch #0 {Exception -> 0x0163, blocks: (B:15:0x005f, B:18:0x008a, B:20:0x0098, B:21:0x009b, B:23:0x00ab, B:24:0x0110, B:26:0x015c, B:30:0x010b, B:35:0x0083, B:32:0x007d), top: B:14:0x005f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab A[Catch: Exception -> 0x0163, TryCatch #0 {Exception -> 0x0163, blocks: (B:15:0x005f, B:18:0x008a, B:20:0x0098, B:21:0x009b, B:23:0x00ab, B:24:0x0110, B:26:0x015c, B:30:0x010b, B:35:0x0083, B:32:0x007d), top: B:14:0x005f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x015c A[Catch: Exception -> 0x0163, TRY_LEAVE, TryCatch #0 {Exception -> 0x0163, blocks: (B:15:0x005f, B:18:0x008a, B:20:0x0098, B:21:0x009b, B:23:0x00ab, B:24:0x0110, B:26:0x015c, B:30:0x010b, B:35:0x0083, B:32:0x007d), top: B:14:0x005f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b A[Catch: Exception -> 0x0163, TryCatch #0 {Exception -> 0x0163, blocks: (B:15:0x005f, B:18:0x008a, B:20:0x0098, B:21:0x009b, B:23:0x00ab, B:24:0x0110, B:26:0x015c, B:30:0x010b, B:35:0x0083, B:32:0x007d), top: B:14:0x005f, inners: #1 }] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T2(String str, String str2, String str3, Bundle bundle, ThemeDiyStyleLogic.StyleCallBack styleCallBack) {
        int parseInt;
        Bundle bundle2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, bundle, styleCallBack);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "setSVTheme, themeId=" + str + ", version=" + str2 + ", seriesIdStr=" + str3);
        }
        if (!TextUtils.isEmpty(str) && bundle != null) {
            try {
                bundle.putString("themeId", str);
                this.f195127m = styleCallBack;
                this.C = bundle;
                ThemeAuth$SubCmd0x3ReqSet themeAuth$SubCmd0x3ReqSet = new ThemeAuth$SubCmd0x3ReqSet();
                themeAuth$SubCmd0x3ReqSet.uint32_theme_id.set(Integer.parseInt(str));
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        parseInt = Integer.parseInt(str3);
                    } catch (Exception e16) {
                        QLog.d("Theme.ThemeHandler", 1, "setSVTheme, parse seriesIdStr exception", e16);
                    }
                    themeAuth$SubCmd0x3ReqSet.uint32_suit_id.set(parseInt);
                    bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                    if (bundle2 != null) {
                        bundle.putAll(bundle2);
                    }
                    if (!ThemeReporter.FROM_DIY.equals(bundle.getString("key_from"))) {
                        ThemeAuth$diyThemeInfo themeAuth$diyThemeInfo = new ThemeAuth$diyThemeInfo();
                        themeAuth$diyThemeInfo.uin32_drawer_tab_id.set(Integer.parseInt(bundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_DRAWER)));
                        themeAuth$diyThemeInfo.uin32_message_tab_id.set(Integer.parseInt(bundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_MESSAGE)));
                        themeAuth$diyThemeInfo.uin32_aio_tab_id.set(Integer.parseInt(bundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_AIO)));
                        themeAuth$diyThemeInfo.uin32_freind_tab_id.set(Integer.parseInt(bundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_FRIEND)));
                        themeAuth$diyThemeInfo.uin32_dynamics_tab_id.set(Integer.parseInt(bundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_DYNAMIC)));
                        themeAuth$SubCmd0x3ReqSet.diy_theme_info.set(themeAuth$diyThemeInfo);
                        themeAuth$SubCmd0x3ReqSet.uint32_diy_theme_flag.set(1);
                    } else {
                        themeAuth$SubCmd0x3ReqSet.uint32_diy_theme_flag.set(0);
                    }
                    ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
                    themeAuth$ReqBody.uint32_sub_cmd.set(3);
                    themeAuth$ReqBody.int32_plat_id.set(109);
                    themeAuth$ReqBody.str_qq_version.set(AppSetting.f99554n);
                    themeAuth$ReqBody.uint32_qq_version.set(Integer.parseInt(AppSetting.f99542b));
                    themeAuth$ReqBody.msg_subcmd0x3_req_set.set(themeAuth$SubCmd0x3ReqSet);
                    themeAuth$ReqBody.setHasFlag(true);
                    ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195125h.getCurrentAccountUin(), ThemeConstants.CMD_THEME_AUTH);
                    toServiceMsg.putWupBuffer(themeAuth$ReqBody.toByteArray());
                    super.sendPbReq(toServiceMsg);
                    if (!QLog.isColorLevel()) {
                        QLog.i("Theme.ThemeHandler", 2, "setSVTheme sendPbReq ok");
                        return;
                    }
                    return;
                }
                parseInt = 0;
                themeAuth$SubCmd0x3ReqSet.uint32_suit_id.set(parseInt);
                bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                if (bundle2 != null) {
                }
                if (!ThemeReporter.FROM_DIY.equals(bundle.getString("key_from"))) {
                }
                ThemeAuth$ReqBody themeAuth$ReqBody2 = new ThemeAuth$ReqBody();
                themeAuth$ReqBody2.uint32_sub_cmd.set(3);
                themeAuth$ReqBody2.int32_plat_id.set(109);
                themeAuth$ReqBody2.str_qq_version.set(AppSetting.f99554n);
                themeAuth$ReqBody2.uint32_qq_version.set(Integer.parseInt(AppSetting.f99542b));
                themeAuth$ReqBody2.msg_subcmd0x3_req_set.set(themeAuth$SubCmd0x3ReqSet);
                themeAuth$ReqBody2.setHasFlag(true);
                ToServiceMsg toServiceMsg2 = new ToServiceMsg("mobileqq.service", this.f195125h.getCurrentAccountUin(), ThemeConstants.CMD_THEME_AUTH);
                toServiceMsg2.putWupBuffer(themeAuth$ReqBody2.toByteArray());
                super.sendPbReq(toServiceMsg2);
                if (!QLog.isColorLevel()) {
                }
            } catch (Exception e17) {
                QLog.e("Theme.ThemeHandler", 2, "setSVTheme Exception:" + e17.toString());
            }
        } else {
            QLog.e("Theme.ThemeHandler", 2, "setSVTheme Error themeId == null");
        }
    }

    void U2(String str, String str2) {
        ThemeSwitcher.startSwitch(str, str2, new MyThemeSwitchCallback());
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x023d A[Catch: Exception -> 0x0374, TRY_LEAVE, TryCatch #1 {Exception -> 0x0374, blocks: (B:20:0x006e, B:22:0x0075, B:23:0x007c, B:25:0x0084, B:26:0x008c, B:32:0x009a, B:36:0x00c9, B:39:0x0108, B:40:0x0157, B:56:0x01eb, B:59:0x023d, B:62:0x0246, B:64:0x024c, B:65:0x026b, B:67:0x02a4, B:69:0x0332, B:73:0x02ac, B:76:0x02e0, B:78:0x0310, B:79:0x0262, B:81:0x0337, B:86:0x01c5, B:90:0x013c, B:92:0x0142, B:94:0x0353, B:98:0x035a, B:100:0x035e), top: B:19:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0332 A[Catch: Exception -> 0x0374, TryCatch #1 {Exception -> 0x0374, blocks: (B:20:0x006e, B:22:0x0075, B:23:0x007c, B:25:0x0084, B:26:0x008c, B:32:0x009a, B:36:0x00c9, B:39:0x0108, B:40:0x0157, B:56:0x01eb, B:59:0x023d, B:62:0x0246, B:64:0x024c, B:65:0x026b, B:67:0x02a4, B:69:0x0332, B:73:0x02ac, B:76:0x02e0, B:78:0x0310, B:79:0x0262, B:81:0x0337, B:86:0x01c5, B:90:0x013c, B:92:0x0142, B:94:0x0353, B:98:0x035a, B:100:0x035e), top: B:19:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0337 A[Catch: Exception -> 0x0374, TryCatch #1 {Exception -> 0x0374, blocks: (B:20:0x006e, B:22:0x0075, B:23:0x007c, B:25:0x0084, B:26:0x008c, B:32:0x009a, B:36:0x00c9, B:39:0x0108, B:40:0x0157, B:56:0x01eb, B:59:0x023d, B:62:0x0246, B:64:0x024c, B:65:0x026b, B:67:0x02a4, B:69:0x0332, B:73:0x02ac, B:76:0x02e0, B:78:0x0310, B:79:0x0262, B:81:0x0337, B:86:0x01c5, B:90:0x013c, B:92:0x0142, B:94:0x0353, B:98:0x035a, B:100:0x035e), top: B:19:0x006e }] */
    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16;
        String str;
        boolean z17;
        ThemeLocator themeId;
        boolean z18;
        HashMap<String, String> hashMap;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (ThemeConstants.CMD_REQ_GET_0X5EB_FOR_THEME.equals(serviceCmd)) {
            H2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!ThemeConstants.CMD_THEME_AUTH.equals(serviceCmd)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Theme.ThemeHandler", 2, "onReceive~ handleThemeAuth res.isSuccess=" + fromServiceMsg.isSuccess() + ",data=" + PkgTools.toHexStr((byte[]) obj));
        }
        try {
            ThemeAuth$RspBody themeAuth$RspBody = new ThemeAuth$RspBody();
            if (obj != null) {
                themeAuth$RspBody.mergeFrom((byte[]) obj);
            }
            if (themeAuth$RspBody.uint32_sub_cmd.has()) {
                i3 = themeAuth$RspBody.uint32_sub_cmd.get();
            } else {
                i3 = -1;
            }
            if (fromServiceMsg.isSuccess() && obj != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = G2(toServiceMsg, i3);
                QLog.e("Theme.ThemeHandler", 1, "onReceive Error: isSuccess=false, data=" + PkgTools.toHexStr((byte[]) obj) + ", subCmd=" + i3);
                if (3 != i3) {
                    return;
                }
            }
            if (1 == i3) {
                ThemeAuth$SubCmd0x1RspAuth themeAuth$SubCmd0x1RspAuth = themeAuth$RspBody.msg_subcmd0x1_rsp_auth.get();
                int i16 = themeAuth$SubCmd0x1RspAuth.int32_result.get();
                ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
                themeAuth$ReqBody.mergeFrom(toServiceMsg.getWupBuffer(), 4, toServiceMsg.getWupBuffer().length - 4);
                ThemeAuth$SubCmd0x1ReqAuth themeAuth$SubCmd0x1ReqAuth = themeAuth$ReqBody.msg_subcmd0x1_req_auth.get();
                String valueOf = String.valueOf(themeAuth$SubCmd0x1ReqAuth.uint32_theme_id.get());
                String str2 = themeAuth$SubCmd0x1ReqAuth.str_theme_version.get();
                if (i16 != 0) {
                    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, error, ret:" + i16 + ", reqthemeId:" + valueOf + ", reqVersion:" + str2);
                    new HashMap().put("authResult", String.valueOf(i16));
                } else if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "handleThemeAuth, authResult=" + i16);
                }
                ThemeReporter.reportTheme(this.f195124f, ThemeReporter.SUBACTION_THEME, ThemeReporter.FROM_AUTH, 157, NetworkUtil.getSystemNetwork(null), 0 - i16, valueOf, str2, "1", "");
                try {
                    hashMap = new HashMap<>();
                    hashMap.put("param_themeId", valueOf);
                    str = str2;
                } catch (Exception e16) {
                    e = e16;
                    str = str2;
                }
                try {
                    hashMap.put("param_themeVersion", str);
                    hashMap.put("param_FailCode", String.valueOf(i16));
                    StatisticCollector statisticCollector = StatisticCollector.getInstance(this.f195125h.getApplication());
                    String account = this.f195125h.getAccount();
                    if (i16 == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    statisticCollector.collectPerformance(account, "VipThemeAuthHandleError", z19, 1L, 0L, hashMap, "", false);
                } catch (Exception e17) {
                    e = e17;
                    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth, StatisticCollector error=" + e.toString());
                    if (i16 < 1) {
                    }
                    if (i16 != 0) {
                    }
                }
                if (i16 < 1 && i16 != 5 && i16 != 14 && i16 <= 20) {
                    ThemeUtil.getUinThemePreferences(this.f195125h).edit().putInt("themeAuthResult", i16).commit();
                    ThemeUtil.setCurrentThemeIdVersion(this.f195125h, "1000", "0");
                    String str3 = themeAuth$RspBody.msg_subcmd0x1_rsp_auth.str_err_msg.get();
                    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Error, authResult=" + i16 + ", reqthemeId:" + valueOf + ", err_msg=" + str3);
                    V2(i16, valueOf, str3, themeAuth$SubCmd0x1RspAuth);
                    return;
                }
                if (i16 != 0) {
                    if (J2(valueOf)) {
                        if (ThemeUpdateBusiness.isSupportNewScid()) {
                            themeId = ThemeLocator.getLocator(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + valueOf);
                        } else {
                            themeId = new ThemeLocator().setThemeId(valueOf);
                        }
                        themeId.init(this.f195125h.getApplication(), themeId.getCfgScid(), "");
                        themeId.init(this.f195125h.getApplication(), themeId.getCfgScid(), FileUtils.encryptFile(themeId.getZipPath(), KeyPropertiesCompact.DIGEST_MD5));
                        int isCheckThemeFileValid = ((IThemeFileCheck) QRoute.api(IThemeFileCheck.class)).isCheckThemeFileValid(themeId.getZipPath(), themeId.getUnzipPath());
                        if (isCheckThemeFileValid == 0) {
                            W2(toServiceMsg, themeAuth$SubCmd0x1RspAuth, valueOf, str);
                            z17 = false;
                        } else if (isCheckThemeFileValid == 2) {
                            boolean z26 = !((IThemeFileCheck) QRoute.api(IThemeFileCheck.class)).unCompressZip(themeId.getZipPath(), themeId.getUnzipPath());
                            VasLogReportProxy theme = VasLogReporter.getTheme();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("crc check fail ");
                            sb5.append(themeId.getZipPath());
                            sb5.append(", unCompress : ");
                            if (!z26) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            sb5.append(z18);
                            theme.report(sb5.toString(), VasLogReportProxy.LEVEL.HIGHEST);
                            QLog.e("Theme.ThemeHandler", 1, "theme " + valueOf + " crc check fail: " + themeId.getZipPath());
                            z17 = z26;
                        } else {
                            VasLogReporter.getTheme().report("zip file not exist " + themeId.getZipPath(), VasLogReportProxy.LEVEL.HIGHEST);
                        }
                        if (!z17) {
                            V2(3, valueOf, "", themeAuth$SubCmd0x1RspAuth);
                            return;
                        }
                        return;
                    }
                    z17 = true;
                    if (!z17) {
                    }
                } else {
                    QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth unknow type ret=" + i16);
                    sendThemeVersionCheck(null, null, true);
                }
            } else {
                if (2 == i3) {
                    X2(themeAuth$RspBody);
                    return;
                }
                if (3 == i3) {
                    Q2(toServiceMsg, themeAuth$RspBody, z16);
                    return;
                }
                QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth subCmd error, subCmd:" + i3);
            }
        } catch (Exception e18) {
            QLog.e("Theme.ThemeHandler", 1, "handleThemeAuth Exception=" + e18.getMessage());
        }
    }

    public void sendThemeAuth() {
        String str;
        JSONObject jSONObject;
        ThemeUtil.ThemeInfo themeInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        AppInterface appInterface = this.f195125h;
        if (appInterface == null) {
            QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth mApp == null");
            return;
        }
        MobileQQ application = appInterface.getApplication();
        SharedPreferences themePreferences = ThemeUtil.getThemePreferences(application);
        if (1 > themePreferences.getInt(ThemeConstants.THEME_SP_KEY_VERSION, 0)) {
            SharedPreferences.Editor edit = themePreferences.edit();
            try {
                String string = themePreferences.getString("userDownloadTheme", "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = new JSONObject(string);
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String valueOf = String.valueOf(keys.next());
                        if (!TextUtils.isEmpty(valueOf) && !"1000".equals(valueOf) && !"999".equals(valueOf) && (jSONObject = jSONObject2.getJSONObject(valueOf)) != null) {
                            String optString = jSONObject.optString("version");
                            ThemeUtil.ThemeInfo themeInfo2 = ThemeUtil.getThemeInfo(application, valueOf);
                            if (themeInfo2 == null) {
                                themeInfo = new ThemeUtil.ThemeInfo();
                                themeInfo.themeId = valueOf;
                                themeInfo.isVoiceTheme = jSONObject.optBoolean(RemoteMessageConst.Notification.SOUND);
                                themeInfo.fileNum = jSONObject.optInt("fileNum");
                            } else {
                                themeInfo = themeInfo2;
                            }
                            themeInfo.version = optString;
                            themeInfo.zipVer = Integer.parseInt(optString);
                            themeInfo.status = "1";
                            ThemeUtil.setThemeInfo(application, themeInfo);
                        }
                    }
                    edit.remove("userDownloadTheme");
                }
            } catch (Exception e16) {
                QLog.e("Theme.ThemeHandler", 2, "sendThemeAuth themeUpdate error:" + e16.getMessage());
            }
            edit.putInt(ThemeConstants.THEME_SP_KEY_VERSION, 1).commit();
        }
        Bundle currentThemeInfo = ThemeUtil.getCurrentThemeInfo();
        currentThemeInfo.putString("oldEnginePath", currentThemeInfo.getString("themePath"));
        QLog.d("Theme.ThemeHandler", 1, "sendThemeAuth init: , skThemeId:" + currentThemeInfo.getString("themeId") + ", skVersion:" + currentThemeInfo.getString("version") + ", qqVersion:" + AppSetting.f99551k);
        String string2 = currentThemeInfo.getString("themeId");
        if (TextUtils.isEmpty(string2)) {
            currentThemeInfo.putString("themeId", "1000");
            string2 = "1000";
        }
        if (ThemeUtil.isFixTheme(string2)) {
            String string3 = ThemeSwitchUtil.getPreviousThemeIdVersion(this.f195124f).getString("themeID");
            QLog.e("Theme.ThemeHandler", 1, "sendThemeAuth isThemeSimpleUI:" + string2 + " pre:" + string3);
            if (TextUtils.isEmpty(string3)) {
                str = "1000";
            } else {
                str = string3;
            }
            currentThemeInfo.putString("themeId", str);
            if ("1000".equals(string3)) {
                currentThemeInfo.remove("themePath");
            } else if ("999".equals(string3)) {
                currentThemeInfo.putString("themePath", ThemeLocator.getLocator(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + str).getDIYLocator().getUnzipPath());
            } else {
                ThemeLocator locator = ThemeLocator.getLocator(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX + string3);
                ((IVasQuickUpdateService) this.f195124f.getRuntimeService(IVasQuickUpdateService.class, "")).queryItemVersion(3, locator.getCfgScid(), true, false, 0L, new a(locator, application, currentThemeInfo));
                return;
            }
        }
        R2(currentThemeInfo);
    }

    public void sendThemeVersionCheck(String str, String str2, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (!z16) {
            this.f195122d.set(true);
            return;
        }
        if (!this.f195122d.get()) {
            return;
        }
        this.f195122d.set(false);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Bundle currentThemeInfo = ThemeUtil.getCurrentThemeInfo();
            String string = currentThemeInfo.getString("themeId");
            str2 = currentThemeInfo.getString("version");
            str = string;
        }
        if (!TextUtils.isEmpty(str) && !"1000".equals(str) && !"999".equals(str) && !TextUtils.isEmpty(str2)) {
            D = str;
            try {
                int parseInt = Integer.parseInt(str2) % 10000;
                String themeDensity = ThemeUtil.getThemeDensity(this.f195125h.getApp());
                if (QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO.equals(themeDensity)) {
                    i3 = parseInt - 1000;
                } else if (tl.h.F.equals(themeDensity)) {
                    i3 = parseInt - 2000;
                } else {
                    i3 = parseInt - 3000;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "ver = " + i3);
                }
                ThemeAuth$SubCmd0x2ReqCheck themeAuth$SubCmd0x2ReqCheck = new ThemeAuth$SubCmd0x2ReqCheck();
                themeAuth$SubCmd0x2ReqCheck.str_theme_version.set(String.valueOf(i3));
                themeAuth$SubCmd0x2ReqCheck.uint32_theme_id.set(Integer.parseInt(str));
                ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
                themeAuth$ReqBody.uint32_sub_cmd.set(2);
                themeAuth$ReqBody.int32_plat_id.set(109);
                themeAuth$ReqBody.str_qq_version.set(AppSetting.f99554n);
                themeAuth$ReqBody.uint32_qq_version.set(Integer.parseInt(AppSetting.f99542b));
                themeAuth$ReqBody.msg_subcmd0x2_req_check.set(themeAuth$SubCmd0x2ReqCheck);
                themeAuth$ReqBody.setHasFlag(true);
                ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f195125h.getCurrentAccountUin(), ThemeConstants.CMD_THEME_AUTH);
                toServiceMsg.putWupBuffer(themeAuth$ReqBody.toByteArray());
                super.sendPbReq(toServiceMsg);
                if (QLog.isColorLevel()) {
                    QLog.i("Theme.ThemeHandler", 2, "ThemeVersion Check sent,cur_ver = " + i3);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Theme.ThemeHandler", 2, "Exception:" + e16.toString());
                }
            }
        }
    }
}
