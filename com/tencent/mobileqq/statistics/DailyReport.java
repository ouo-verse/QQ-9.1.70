package com.tencent.mobileqq.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.opengl.ETC1Util;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.AbiUtil;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.BadgeUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DailyReport extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static int f289895f;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f289896d;

    /* renamed from: e, reason: collision with root package name */
    BaseApplicationImpl f289897e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        public static String a() {
            try {
                ArrayList<String> arrayList = new ArrayList(Arrays.asList(Build.SUPPORTED_ABIS));
                Collections.sort(arrayList);
                StringBuilder sb5 = new StringBuilder();
                for (String str : arrayList) {
                    sb5.append('[');
                    sb5.append(str);
                    sb5.append(']');
                }
                return sb5.toString();
            } catch (Throwable th5) {
                QLog.e("ReportArchInfo", 1, "[acquireHighestArch] ", th5);
                return "";
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289895f = 50000;
        }
    }

    public DailyReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void A() {
        String str;
        String userCurrentThemeId = ThemeUtil.getUserCurrentThemeId(this.f289896d);
        boolean equals = "1103".equals(userCurrentThemeId);
        boolean equals2 = "2920".equals(userCurrentThemeId);
        QQAppInterface qQAppInterface = this.f289896d;
        String str2 = "2";
        if (!equals && !equals2) {
            str = "2";
        } else {
            str = "1";
        }
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            if (!StudyModeManager.t()) {
                str2 = "1";
            } else {
                str2 = "3";
            }
        }
        ReportController.r(qQAppInterface, "dc00898", "", "", "0X800BC38", "0X800BC38", 0, 0, str, str2, userCurrentThemeId, "");
    }

    private void B() {
        VasWebviewUtil.reportVasStatus("0X800498F", "0X800498F", ThemeUtil.getUserCurrentThemeId(this.f289896d), ((ISVIPHandler) this.f289896d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType(), 0);
    }

    private void C(StatisticCollector statisticCollector) {
        int i3;
        boolean z16;
        if (System.currentTimeMillis() % 1000 != 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (SkinEngine.IS_PROBLEM_MIUI) {
            i3 = 89050;
        } else {
            i3 = 89051;
        }
        hashMap.put("param_FailCode", Integer.toString(i3));
        if (BaseApplicationImpl.IS_SUPPORT_THEME && !SkinEngine.IS_PROBLEM_MIUI) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(this.f289896d.getCurrentAccountUin(), "report_skin_engine_enable", z16, 0L, 0L, hashMap, "");
    }

    private void b(String str) {
        int b16 = s.b(this.f289897e, str, "dl_op4dongtai");
        if (b16 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Clk_data_wire_in", 8, b16, 0);
        }
        int b17 = s.b(this.f289897e, str, "dl_op4buddylist");
        if (b17 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Clk_data_wire_in", 21, b17, 0);
        }
        int b18 = s.b(this.f289897e, str, "dl_op4recent");
        if (b18 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Clk_data_wire_in", 22, b18, 0);
        }
        int b19 = s.b(this.f289897e, str, "dl_ckpic");
        if (b19 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Upload_pic", 0, b19, 0);
        }
        int b26 = s.b(this.f289897e, str, "dl_ckvideo");
        if (b26 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Upload_video", 0, b26, 0);
        }
        int b27 = s.b(this.f289897e, str, "dl_ckfile");
        if (b27 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Upload_file", 0, b27, 0);
        }
        int b28 = s.b(this.f289897e, str, "dl_cktxt");
        if (b28 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Upload_text", 0, b28, 0);
        }
        int b29 = s.b(this.f289897e, str, "dl_cktkphoto");
        if (b29 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Upload_photo", 0, b29, 0);
        }
        int b36 = s.b(this.f289897e, str, "dl_copy");
        if (b36 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Long_press_copy", 0, b36, 0);
        }
        int b37 = s.b(this.f289897e, str, "dl_forward");
        if (b37 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Long_press_retran", 0, b37, 0);
        }
        int b38 = s.b(this.f289897e, str, "dl_delete");
        if (b38 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Long_press_delete", 0, b38, 0);
        }
        int b39 = s.b(this.f289897e, str, "dl_save2weiyun");
        if (b39 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Long_press_weiyun", 0, b39, 0);
        }
        int b46 = s.b(this.f289897e, str, "dl_ckadv");
        if (b46 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "data_wire_setting", 0, b46, 0);
        }
        int b47 = s.b(this.f289897e, str, "dl_ckviewrecvfile");
        if (b47 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Chkfiles_data_wire", 0, b47, 0);
        }
        int b48 = s.b(this.f289897e, str, "dl_ckclearmsg");
        if (b48 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Clean_data_wire", 0, b48, 0);
        }
        boolean z16 = this.f289896d.getPreferences().getBoolean("auto_receive_files", false);
        StatisticCollector statisticCollector = StatisticCollector.getInstance(this.f289897e);
        HashMap hashMap = new HashMap();
        hashMap.clear();
        hashMap.put("auto_receive_files", Integer.valueOf(z16 ? 1 : 0));
        statisticCollector.reportOnOff(this.f289896d, str, hashMap);
        int b49 = s.b(this.f289897e, str, "dl_forwardin_text");
        if (b49 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Retran_text", 0, b49, 0);
        }
        int b56 = s.b(this.f289897e, str, "dl_forwardin_image");
        if (b56 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Retran_pic", 0, b56, 0);
        }
        int b57 = s.b(this.f289897e, str, "dl_forwardin_file");
        if (b57 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Retran_file", 0, b57, 0);
        }
        int b58 = s.b(this.f289897e, str, "dl_forwardin_link");
        if (b58 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Retran_link", 0, b58, 0);
        }
        int b59 = s.b(this.f289897e, str, "dl_open_via_qq");
        if (b59 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "Open_via_qq", 0, b59, 0);
        }
        int b65 = s.b(this.f289897e, str, "dl_share_my_pc");
        if (b65 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "share_my_PC", 0, b65, 0);
        }
        int b66 = s.b(this.f289897e, str, "dl_share_frd");
        if (b66 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "data_wire", "share_frd", 0, b66, 0);
        }
        int b67 = s.b(this.f289897e, str, "Clk_disconnect_wp");
        if (b67 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "Wifiphoto", "Clk_disconnect_wp", 0, b67, 0);
        }
        int b68 = s.b(this.f289897e, str, "Clk_wp_back");
        if (b68 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "Wifiphoto", "Clk_wp_back", 0, b68, 0);
        }
        int b69 = s.b(this.f289897e, str, "Open_wp");
        if (b69 > 0) {
            StatisticCollector.getInstance(this.f289897e).reportActionCountCliOper(this.f289896d, str, str, "Wifiphoto", "Open_wp", 0, b69, 0);
        }
    }

    private static String c(Context context) {
        int size;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).getInputMethodList();
            if (inputMethodList == null) {
                size = 0;
            } else {
                size = inputMethodList.size();
            }
            for (int i3 = 0; i3 < size; i3++) {
                stringBuffer.append(inputMethodList.get(i3).loadLabel(context.getPackageManager()));
                stringBuffer.append(';');
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            return stringBuffer.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static void g() {
        boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_state", String.valueOf(readValue));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act2G3G4GSwitch", false, 0L, 0L, hashMap, "");
    }

    private void h() {
        int i3;
        List<EmoticonPackage> syncGetTabEmoticonPackages;
        String currentAccountUin = this.f289896d.getCurrentAccountUin();
        StatisticCollector statisticCollector = StatisticCollector.getInstance(this.f289897e);
        int b16 = s.b(this.f289897e, currentAccountUin, "ep_tab");
        if (b16 > 0) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "ep_tab", 1, b16, 0);
        }
        int b17 = s.b(this.f289897e, currentAccountUin, "ep_mall_in2");
        if (b17 > 0) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "ep_mall_in", 2, b17, 0);
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) this.f289896d.getRuntimeService(IEmoticonManagerService.class);
        if (iEmoticonManagerService != null && (syncGetTabEmoticonPackages = iEmoticonManagerService.syncGetTabEmoticonPackages()) != null) {
            i3 = syncGetTabEmoticonPackages.size();
        } else {
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Ep_amount", Integer.valueOf(i3));
        statisticCollector.reportOnOff(this.f289896d, currentAccountUin, hashMap);
        for (int i16 = 0; i16 < 3; i16++) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "ep_tab2", 0, s.b(this.f289897e, currentAccountUin, "ep_tab2" + i16), 0, i16);
        }
        int b18 = s.b(this.f289897e, currentAccountUin, "Ep_manage");
        if (b18 > 0) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "Ep_manage", 0, b18, 0);
        }
        int b19 = s.b(this.f289897e, currentAccountUin, "Clk_ep_edit");
        if (b19 > 0) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "Clk_ep_edit", 0, b19, 0);
        }
        int b26 = s.b(this.f289897e, currentAccountUin, "Delete_ep");
        if (b26 > 0) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "Delete_ep", 0, b26, 0);
        }
        int b27 = s.b(this.f289897e, currentAccountUin, "Ep_order");
        if (b27 > 0) {
            statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "ep_mall", "Ep_order", 0, b27, 0);
        }
    }

    private void i() {
        Object obj;
        TreeMap treeMap = new TreeMap();
        String a16 = a.a();
        treeMap.put("support_arch", a16);
        String str = "1";
        if (a16.contains(AbiUtil.ARM)) {
            obj = "1";
        } else {
            obj = "0";
        }
        treeMap.put("is_arm", obj);
        if (!a16.contains("arm64-v8a")) {
            str = "0";
        }
        treeMap.put("support_arm64", str);
        QQBeaconReport.report(this.f289896d.getCurrentUin(), "arch_report_32_or_64", treeMap);
        QLog.d("IAutomator", 1, "[reportArchInfo] list: ", a16);
    }

    private void j() {
        ISVIPHandler iSVIPHandler = (ISVIPHandler) this.f289896d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        VasWebviewUtil.reportVasStatus("0X8004990", "0X8004990", String.valueOf(iSVIPHandler.getSelfBubbleId()), iSVIPHandler.getCurrentUserVipType(), 0);
    }

    private void k() {
        String str;
        String m3 = ((ChatBackgroundManager) this.f289896d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).m(null);
        if (m3.equals("custom")) {
            str = "0X8004E10";
        } else {
            str = "0X8004E0F";
        }
        VasWebviewUtil.reportVasStatus(str, str, m3, 0, 0);
    }

    private static void l(String str) {
        int i3;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        if (defaultSharedPreferences.getBoolean("hasReportDeviceProfile", false)) {
            return;
        }
        defaultSharedPreferences.edit().putBoolean("hasReportDeviceProfile", true);
        HashMap<String, String> hashMap = new HashMap<>();
        int min = (int) Math.min(ah.L(), ah.M());
        int n3 = f289895f + (ah.n() * 100);
        if (min <= 240) {
            i3 = n3 + 1;
        } else if (min <= 320) {
            i3 = n3 + 2;
        } else if (min <= 480) {
            i3 = n3 + 3;
        } else if (min <= 640) {
            i3 = n3 + 4;
        } else if (min <= 720) {
            i3 = n3 + 5;
        } else if (min <= 1080) {
            i3 = n3 + 6;
        } else {
            i3 = n3 + 7;
        }
        hashMap.put("param_FailCode", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "reportDeviceProfile", false, 0L, 0L, hashMap, "");
    }

    private void m() {
        String str;
        boolean isEmotionRecSettingOpen = ((IStickerRecManager) this.f289896d.getRuntimeService(IStickerRecManager.class)).isEmotionRecSettingOpen();
        QQAppInterface qQAppInterface = this.f289896d;
        if (isEmotionRecSettingOpen) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(qQAppInterface, "CliStatus", "", "", "0X800A224", "0X800A224", 0, 0, str, "", "", "");
    }

    private void n() {
        boolean isFeatureSupported = ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
        int i3 = 0;
        boolean z16 = this.f289896d.getApp().getSharedPreferences(FontManagerConstants.FONT_OPEN_SWITCH, 0).getBoolean(FontManagerConstants.ISUSEROPENFONTSWITCH + this.f289896d.getAccount(), false);
        if (isFeatureSupported) {
            i3 = 2;
        } else if (z16) {
            i3 = 1;
        }
        VasWebviewUtil.reportVasStatus("font_switch", "switch_on", "0", 0, 0, i3, 0, "", "");
    }

    private void o() {
        HashMap hashMap = new HashMap();
        int d16 = u.d(this.f289897e, this.f289896d.getCurrentAccountUin());
        if (d16 > 0) {
            hashMap.put("Click_grp_asst", Integer.valueOf(d16));
        }
        int e16 = u.e(this.f289897e, this.f289896d.getCurrentAccountUin());
        if (e16 > 0) {
            hashMap.put("grp_setting_asst", Integer.valueOf(e16));
        }
        int f16 = u.f(this.f289897e, this.f289896d.getCurrentAccountUin());
        if (f16 > 0) {
            hashMap.put("grp_setting_msg", Integer.valueOf(f16));
        }
        int i3 = u.i(this.f289897e, this.f289896d.getCurrentAccountUin());
        if (i3 > 0) {
            hashMap.put("grp_msg_equ", Integer.valueOf(i3));
        }
        int g16 = u.g(this.f289897e, this.f289896d.getCurrentAccountUin());
        if (g16 > 0) {
            hashMap.put("grp_msg_dec", Integer.valueOf(g16));
        }
        int h16 = u.h(this.f289897e, this.f289896d.getCurrentAccountUin());
        if (h16 > 0) {
            hashMap.put("grp_msg_inc", Integer.valueOf(h16));
        }
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        QQAppInterface qQAppInterface = this.f289896d;
        statisticCollector.reportCustomSet(qQAppInterface, qQAppInterface.getCurrentAccountUin(), hashMap);
    }

    private void p(StatisticCollector statisticCollector) {
        ActivityManager activityManager = (ActivityManager) BaseApplicationImpl.sApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        HashMap<String, String> hashMap = new HashMap<>();
        int memoryClass = activityManager.getMemoryClass();
        hashMap.put("param_FailCode", Integer.toString(89000 + memoryClass));
        statisticCollector.collectPerformance(this.f289896d.getCurrentAccountUin(), "report_mem_cache_size", false, memoryClass, 0L, hashMap, "");
    }

    private static void q(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        Context applicationContext = qQAppInterface.getApp().getApplicationContext();
        try {
            String string = DeviceInfoMonitor.getString(applicationContext.getContentResolver(), "default_input_method");
            ReportController.o(qQAppInterface, "CliOper", "", qQAppInterface.getCurrentAccountUin(), "Type_input", "Type_input", 0, 0, "", "", string, c(applicationContext));
        } catch (Exception e16) {
            QLog.e("MainActivityReportHelper", 1, "reportIMEInfo fail", e16);
        }
    }

    private void r() {
        HashMap<String, String> a16 = new g().a();
        if (!a16.isEmpty()) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f289896d.getCurrentUin(), "LogFileSizeDailyReport", true, 0L, 0L, a16, "");
        }
    }

    private void s() {
        String str;
        List<EmoticonPackage> syncGetTabEmoticonPackages = ((IEmoticonManagerService) this.f289896d.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages();
        if (syncGetTabEmoticonPackages == null) {
            str = "";
        } else {
            String str2 = "";
            for (int i3 = 0; i3 < syncGetTabEmoticonPackages.size(); i3++) {
                EmoticonPackage emoticonPackage = syncGetTabEmoticonPackages.get(i3);
                int i16 = emoticonPackage.jobType;
                if (3 == i16 || 5 == i16) {
                    if (str2.equals("")) {
                        str2 = emoticonPackage.epId;
                    } else {
                        str2 = str2 + "|" + emoticonPackage.epId;
                    }
                }
            }
            str = str2;
        }
        VasWebviewUtil.reportVasStatus("MbBaoyou", "MbBaoyouID", "0", 0, 0, 0, 0, str, "");
    }

    private void t() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3;
        int i16;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i17;
        int i18;
        if (this.f289896d.getALLGeneralSettingRing() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f289896d.getALLGeneralSettingVibrate() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean isShowMsgContent = this.f289896d.isShowMsgContent();
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.f289896d) == 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this.f289896d) == 0) {
            z19 = false;
        } else {
            z19 = true;
        }
        boolean readValue = SettingCloneUtil.readValue((Context) this.f289896d.getApp(), this.f289896d.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
        boolean groupChannelVibrateOn = QQNotificationManager.getInstance().groupChannelVibrateOn();
        boolean c2cChannelVibrateOn = QQNotificationManager.getInstance().c2cChannelVibrateOn();
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "reportMessageNotificationSettings: invoked. ", " groupChannelVibrateOn: ", Boolean.valueOf(groupChannelVibrateOn), " c2cChannelVibrateOn: ", Boolean.valueOf(c2cChannelVibrateOn));
        }
        QQAppInterface qQAppInterface = this.f289896d;
        if (z17) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800AD3B", "0X800AD3B", i3, 0, "", "", "", "");
        QQAppInterface qQAppInterface2 = this.f289896d;
        if (z19) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800AD3C", "0X800AD3C", i16, 0, "", "", "", "");
        QQAppInterface qQAppInterface3 = this.f289896d;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(qQAppInterface3, "CliStatus", "", "", "0X800A3CF", "0X800A3CF", 0, 0, str, "", "", "");
        QQAppInterface qQAppInterface4 = this.f289896d;
        if (z17) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        ReportController.o(qQAppInterface4, "CliStatus", "", "", "0X800A3D0", "0X800A3D0", 0, 0, str2, "", "", "");
        QQAppInterface qQAppInterface5 = this.f289896d;
        if (isShowMsgContent) {
            str3 = "1";
        } else {
            str3 = "2";
        }
        ReportController.o(qQAppInterface5, "CliStatus", "", "", "0X800A3CE", "0X800A3CE", 0, 0, str3, "", "", "");
        QQAppInterface qQAppInterface6 = this.f289896d;
        if (z19) {
            str4 = "1";
        } else {
            str4 = "2";
        }
        ReportController.o(qQAppInterface6, "CliStatus", "", "", "0X800A3D1", "0X800A3D1", 0, 0, str4, "", "", "");
        QQAppInterface qQAppInterface7 = this.f289896d;
        if (z18) {
            str5 = "1";
        } else {
            str5 = "2";
        }
        ReportController.o(qQAppInterface7, "CliStatus", "", "", "0X800A3D2", "0X800A3D2", 0, 0, str5, "", "", "");
        QQAppInterface qQAppInterface8 = this.f289896d;
        if (readValue) {
            str6 = "1";
        } else {
            str6 = "2";
        }
        ReportController.o(qQAppInterface8, "CliStatus", "", "", "0X800A512", "0X800A512", 0, 0, str6, "", "", "");
        QQAppInterface qQAppInterface9 = this.f289896d;
        if (AutoSaveUtils.g(true)) {
            str7 = "1";
        } else {
            str7 = "2";
        }
        ReportController.o(qQAppInterface9, "CliStatus", "", "", "0X800A6E8", "0X800A6E8", 0, 0, str7, "", "", "");
        QQAppInterface qQAppInterface10 = this.f289896d;
        if (AutoSaveUtils.g(false)) {
            str8 = "1";
        } else {
            str8 = "2";
        }
        ReportController.o(qQAppInterface10, "CliStatus", "", "", "0X800A6E9", "0X800A6E9", 0, 0, str8, "", "", "");
        QQAppInterface qQAppInterface11 = this.f289896d;
        if (groupChannelVibrateOn) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        ReportController.o(qQAppInterface11, "CliOper", "", "", "0X800AC8B", "0X800AC8B", i17, 0, "", "", "", "");
        QQAppInterface qQAppInterface12 = this.f289896d;
        if (c2cChannelVibrateOn) {
            i18 = 1;
        } else {
            i18 = 2;
        }
        ReportController.o(qQAppInterface12, "CliOper", "", "", "0X800AC8C", "0X800AC8C", i18, 0, "", "", "", "");
    }

    private void u() {
        String str;
        PhoneUnityManager phoneUnityManager = (PhoneUnityManager) this.f289896d.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
        if (phoneUnityManager.C) {
            QQAppInterface qQAppInterface = this.f289896d;
            if (phoneUnityManager.g()) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(qQAppInterface, "CliStatus", "", "", "0X8005B8B", "0X8005B8B", 0, 0, str, "", "", "");
        }
    }

    private void v(StatisticCollector statisticCollector) {
        String valueOf;
        if (statisticCollector == null) {
            return;
        }
        try {
            boolean isETC1Supported = ETC1Util.isETC1Supported();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_manufacture", Build.MANUFACTURER);
            hashMap.put("param_model", DeviceInfoMonitor.getModel());
            if (isETC1Supported) {
                valueOf = String.valueOf(1);
            } else {
                valueOf = String.valueOf(0);
            }
            hashMap.put("param_etc1supported", valueOf);
            statisticCollector.collectPerformance(this.f289896d.getCurrentAccountUin(), "arOpenGLSupport", isETC1Supported, 0L, 0L, hashMap, "");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("DailyReport", 2, "reportOpenglSupport", th5);
            }
            statisticCollector.collectPerformance(this.f289896d.getCurrentAccountUin(), "arOpenGLSupport", false, 0L, 0L, null, "");
        }
    }

    private static void x(QQAppInterface qQAppInterface) {
        String str;
        if (qQAppInterface == null) {
            return;
        }
        String b16 = o.b();
        if (qQAppInterface.isLogin()) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.s(qQAppInterface, "0X800AAA1", "0X800AAA1", "0X800AAA1", "", 0, "", b16, str, "", "", "", "", "", "");
    }

    private void y() {
        String currentUin = ((Automator) this.mAutomator).E.getCurrentUin();
        boolean z16 = false;
        if (((Automator) this.mAutomator).E.getApp().getSharedPreferences(QVipStickerProcessor.PREF_STICKER_NAME, 0).getBoolean("sticker_switch_" + currentUin, true) && EmojiStickerManager.g()) {
            z16 = true;
        }
        EmojiStickerManager.f204583t = z16;
        if (z16) {
            VasWebviewUtil.reportCommercialDrainage(this.f289896d.getCurrentUin(), "Stick", "SwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        } else {
            VasWebviewUtil.reportCommercialDrainage(this.f289896d.getCurrentUin(), "Stick", "SwitchOff", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
    }

    private void z() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Map<String, Boolean> t16 = ((TempMsgManager) this.f289896d.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).t();
        QQAppInterface qQAppInterface = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_TROOP).booleanValue()) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(qQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 1, 1, str, "", "", "");
        QQAppInterface qQAppInterface2 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_NEARBY).booleanValue()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ReportController.o(qQAppInterface2, "CliStatus", "", "", "0X800997C", "0X800997C", 2, 2, str2, "", "", "");
        QQAppInterface qQAppInterface3 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_INTEREST).booleanValue()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        ReportController.o(qQAppInterface3, "CliStatus", "", "", "0X800997C", "0X800997C", 3, 3, str3, "", "", "");
        QQAppInterface qQAppInterface4 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_CONTACT).booleanValue()) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        ReportController.o(qQAppInterface4, "CliStatus", "", "", "0X800997C", "0X800997C", 4, 4, str4, "", "", "");
        QQAppInterface qQAppInterface5 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_CONSULT).booleanValue()) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        ReportController.o(qQAppInterface5, "CliStatus", "", "", "0X800997C", "0X800997C", 5, 5, str5, "", "", "");
        QQAppInterface qQAppInterface6 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_CIRCLE).booleanValue()) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        ReportController.o(qQAppInterface6, "CliStatus", "", "", "0X800997C", "0X800997C", 6, 6, str6, "", "", "");
        QQAppInterface qQAppInterface7 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_GAMEBUDDY).booleanValue()) {
            str7 = "1";
        } else {
            str7 = "0";
        }
        ReportController.o(qQAppInterface7, "CliStatus", "", "", "0X800997C", "0X800997C", 7, 7, str7, "", "", "");
        QQAppInterface qQAppInterface8 = this.f289896d;
        if (t16.get(AppConstants.Preferences.TEMP_MSG_SETTING_AUDIO_ROOM).booleanValue()) {
            str8 = "1";
        } else {
            str8 = "0";
        }
        ReportController.o(qQAppInterface8, "CliStatus", "", "", "0X800997C", "0X800997C", 8, 8, str8, "", "", "");
    }

    void D(StatisticCollector statisticCollector) {
        boolean z16;
        if (statisticCollector == null) {
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            WifiManager wifiManager = (WifiManager) BaseApplication.getContext().getSystemService("wifi");
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                z16 = true;
            } else {
                z16 = false;
            }
            hashMap.put("param_nettype", String.valueOf(systemNetwork));
            hashMap.put("param_wifi_switch_on", String.valueOf(z16));
            if (QLog.isColorLevel()) {
                QLog.d("DailyReport", 2, "reportWifiSwitchStatus nettype = " + systemNetwork + ",isWiFiSwitchOn = " + z16);
            }
            statisticCollector.collectPerformance(this.f289896d.getCurrentAccountUin(), "arMapWifiSwitchStatus", true, 0L, 0L, hashMap, "");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("DailyReport", 2, "reportWifiSwitchStatus", th5);
            }
        }
    }

    void E() {
        this.f289897e.getSharedPreferences("mobileQQ", 0);
        u.j(this.f289897e, this.f289896d.getCurrentAccountUin());
        QQAppInterface qQAppInterface = this.f289896d;
        s.d(qQAppInterface, this.f289897e, qQAppInterface.getCurrentAccountUin());
        QQSettingUtil.i(this.f289897e, this.f289896d.getCurrentAccountUin(), 0);
        ThemeUtil.resetThemeSwitchTimes(this.f289896d);
        ((ChatBackgroundManager) this.f289896d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).x(this.f289897e, this.f289896d.getCurrentAccountUin());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        int i3;
        SharedPreferences sharedPreferences;
        Calendar calendar;
        Calendar calendar2;
        Calendar calendar3;
        ExtensionInfo extensionInfo;
        Calendar calendar4;
        String str;
        int i16;
        String str2;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        this.f289896d = ((Automator) this.mAutomator).E;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        this.f289897e = application;
        SharedPreferences sharedPreferences2 = application.getSharedPreferences("mobileQQ", 0);
        long j3 = sharedPreferences2.getLong("LastTimeLogin_" + this.f289896d.getCurrentAccountUin(), 0L);
        long currentTimeMillis = System.currentTimeMillis() - 10;
        Calendar calendar5 = Calendar.getInstance();
        Calendar calendar6 = Calendar.getInstance();
        calendar6.setTimeInMillis(j3);
        calendar6.add(5, 1);
        calendar6.clear(10);
        calendar6.clear(12);
        calendar6.clear(13);
        calendar6.clear(14);
        Calendar calendar7 = Calendar.getInstance();
        calendar7.add(5, 1);
        calendar7.clear(10);
        calendar7.clear(12);
        calendar7.clear(13);
        calendar7.clear(14);
        calendar7.getTimeInMillis();
        int i18 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i18 > 0 && calendar5.after(calendar6)) {
            l(this.f289896d.getCurrentUin());
            q(this.f289896d);
            x(this.f289896d);
            QQSettingUtil.a(this.f289896d);
            QQAppInterface qQAppInterface = this.f289896d;
            NotifyPushSettingFragment.Mi(qQAppInterface, qQAppInterface.getCurrentAccountUin());
            o();
            FileManagerUtil.reportFileAssistans(this.f289896d, this.f289897e);
            String currentAccountUin = this.f289896d.getCurrentAccountUin();
            b(currentAccountUin);
            BaseApplicationImpl baseApplicationImpl = this.f289897e;
            StatisticCollector statisticCollector = StatisticCollector.getInstance(baseApplicationImpl);
            try {
                h();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    i3 = i18;
                    calendar3 = calendar6;
                    QLog.d("DailyReport", 2, "reportAioEmotionData", e16);
                }
            }
            calendar3 = calendar6;
            i3 = i18;
            s();
            k();
            B();
            A();
            j();
            n();
            u();
            y();
            FriendsManager friendsManager = (FriendsManager) this.f289896d.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null) {
                extensionInfo = friendsManager.H(currentAccountUin);
            } else {
                extensionInfo = null;
            }
            sharedPreferences = sharedPreferences2;
            if (extensionInfo != null) {
                calendar4 = calendar5;
                VasWebviewUtil.reportVasStatus("FontStatus", "FontOn", String.valueOf(extensionInfo.uVipFont), 0, 0);
            } else {
                calendar4 = calendar5;
            }
            if (extensionInfo != null) {
                int currentUserVipType = ((ISVIPHandler) this.f289896d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
                if (currentUserVipType == 2) {
                    i17 = 0;
                } else if (currentUserVipType == 3) {
                    i17 = 2;
                } else {
                    i17 = currentUserVipType;
                }
                VasWebviewUtil.reportVasStatus("0X8004A26", "0X8004A26", String.valueOf(extensionInfo.colorRingId), i17, 0);
            }
            int currentUserVipType2 = ((ISVIPHandler) this.f289896d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
            if (extensionInfo != null) {
                VasWebviewUtil.reportVasStatus("0X8005005", "0X8005005", String.valueOf(extensionInfo.commingRingId), currentUserVipType2, 0);
            }
            QQAppInterface qQAppInterface2 = this.f289896d;
            int resIdByUin = VipFunCallUtil.getResIdByUin(qQAppInterface2, qQAppInterface2.getAccount(), 6, true, null);
            if (currentUserVipType2 == 2) {
                currentUserVipType2 = 0;
            } else if (currentUserVipType2 == 3) {
                currentUserVipType2 = 2;
            }
            QQAppInterface qQAppInterface3 = this.f289896d;
            ReportController.o(qQAppInterface3, "CliOper", "", qQAppInterface3.getCurrentAccountUin(), "funcallnew", "setfuncall", 0, 0, String.valueOf(resIdByUin), String.valueOf(currentUserVipType2), String.valueOf(NetworkUtil.getSystemNetwork(null)), "1");
            List<MessageReportData> c16 = s.c(this.f289896d);
            if (c16 != null) {
                for (MessageReportData messageReportData : c16) {
                    if (messageReportData.msgCount > 0) {
                        statisticCollector.reportActionCountMsgOper(this.f289896d, messageReportData.getMsgReport());
                    }
                }
            }
            int d16 = QQSettingUtil.d(baseApplicationImpl, currentAccountUin);
            if (d16 > 0) {
                StatisticCollector statisticCollector2 = StatisticCollector.getInstance(BaseApplication.getContext());
                QQAppInterface qQAppInterface4 = this.f289896d;
                statisticCollector2.reportActionCount(qQAppInterface4, qQAppInterface4.getCurrentAccountUin(), "Setting_Quit", d16);
            }
            int ei5 = NotifyPushSettingFragment.ei(baseApplicationImpl, currentAccountUin, "LED_light");
            HashMap hashMap = new HashMap();
            hashMap.clear();
            hashMap.put("LED_light", Integer.valueOf(ei5));
            statisticCollector.reportOnOff(this.f289896d, currentAccountUin, hashMap);
            if (BadgeUtils.j(this.f289896d.getApplication())) {
                boolean readValue = SettingCloneUtil.readValue((Context) this.f289897e, (String) null, (String) null, BadgeUtilImpl.QQSETTING_SHOW_BADGEUNREAD_KEY, true);
                QQAppInterface qQAppInterface5 = this.f289896d;
                if (readValue) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                ReportController.o(qQAppInterface5, "CliStatus", "", "", "0X8004BE8", "0X8004BE8", 0, 0, str2, "", "", "");
            }
            g();
            int themeSwitchTimes = ThemeUtil.getThemeSwitchTimes(this.f289896d);
            if (themeSwitchTimes > 0) {
                statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "theme_mall", "theme_replace", 0, themeSwitchTimes, 0);
            }
            int j16 = ((ChatBackgroundManager) this.f289896d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).j(this.f289897e, this.f289896d.getCurrentAccountUin());
            if (j16 > 0) {
                statisticCollector.reportActionCountCliOper(this.f289896d, currentAccountUin, "", "background", "bkground_replace", 0, j16, 0);
            }
            Boolean valueOf = Boolean.valueOf(SettingCloneUtil.readValue((Context) this.f289897e, this.f289896d.getCurrentAccountUin(), this.f289897e.getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true));
            QQAppInterface qQAppInterface6 = this.f289896d;
            if (valueOf.booleanValue()) {
                str = "1";
            } else {
                str = "0";
            }
            ReportController.o(qQAppInterface6, "CliStatus", "", "", "0X80040D9", "0X80040D9", 0, 0, str, "", "", "");
            p(statisticCollector);
            C(statisticCollector);
            try {
                HashMap<String, String> hashMap2 = new HashMap<>();
                int isNotificationEnabled = QQAppInterface.isNotificationEnabled();
                hashMap2.put("notifationStat", String.valueOf(isNotificationEnabled));
                hashMap2.put("uinParam", this.f289896d.getCurrentAccountUin());
                String S = ah.S();
                if (S == null) {
                    S = "";
                }
                hashMap2.put("romInfo", S);
                MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f289896d.getApp());
                boolean contains = defaultSharedPreferences.contains(this.f289896d.getCurrentUin() + "_" + AppConstants.Preferences.PUSH_OPEN_NOTIFY_XML);
                int i19 = defaultSharedPreferences.getInt(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT, 0);
                com.tencent.mobileqq.app.msgnotify.a aVar = com.tencent.mobileqq.app.msgnotify.a.f196345a;
                int decodeInt = fromV2.decodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_OPEN), 0);
                int decodeInt2 = fromV2.decodeInt(aVar.i(AppConstants.Preferences.PUSH_MSG_NOTIFY_CANCLE), 0);
                hashMap2.put("hasConfigs", String.valueOf(contains));
                hashMap2.put(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_PUSH_COUNT, String.valueOf(i19));
                hashMap2.put("openCount", String.valueOf(decodeInt));
                hashMap2.put("cancleCount", String.valueOf(decodeInt2));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f289896d.getCurrentAccountUin(), StatisticCollector.MSG_NOTIFICATION_STATS_TAG, true, 0L, 0L, hashMap2, "");
                if (QLog.isColorLevel()) {
                    QLog.d(StatisticCollector.TAG, 2, String.format("msg Notification report value, notifationStat: %d, romInfo: %s", Integer.valueOf(isNotificationEnabled), S));
                }
                ReportController.v((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), "push_value", "", "", "", 1, "", String.valueOf(isNotificationEnabled), String.valueOf(contains), String.valueOf(i19), String.valueOf(decodeInt), String.valueOf(decodeInt2), "", "");
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(StatisticCollector.TAG, 2, "msg Notification report fail err:" + th5.getMessage());
                }
            }
            try {
                z();
                i16 = 1;
            } catch (Exception e17) {
                i16 = 1;
                QLog.i("IAutomator", 1, "reportTempMsgSettingStatus", e17);
            }
            ILebaHelperService iLebaHelperService = (ILebaHelperService) this.f289896d.getRuntimeService(ILebaHelperService.class, "");
            if (iLebaHelperService != null) {
                iLebaHelperService.reportPluginStatus(this.f289896d);
            } else {
                QLog.d("IAutomator", i16, "reportPluginStatus lebaHelperService == null");
            }
            D(statisticCollector);
            v(statisticCollector);
            m();
            r();
            w(statisticCollector);
            com.tencent.av.business.manager.pendant.a.a();
            UniteDownloadDbOperator.e().i(this.f289896d.getCurrentUin());
            E();
            t();
            i();
            ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).reportGameCardStatus(this.f289896d);
            if (QLog.isColorLevel()) {
                QLog.d(StatisticCollector.TAG, 2, "**************report data below:*****************");
            }
            currentTimeMillis = currentTimeMillis;
            sharedPreferences.edit().putLong("LastTimeLogin_" + this.f289896d.getCurrentAccountUin(), currentTimeMillis).commit();
            calendar2 = calendar3;
            calendar = calendar4;
        } else {
            i3 = i18;
            sharedPreferences = sharedPreferences2;
            calendar = calendar5;
            calendar2 = calendar6;
        }
        if (calendar.after(calendar2)) {
            QQAppInterface qQAppInterface7 = this.f289896d;
            ThemeUiPlugin.reportThemeNumAndCurrThemeName(qQAppInterface7, qQAppInterface7.getCurrentAccountUin());
            ChatBackgroundManager chatBackgroundManager = (ChatBackgroundManager) this.f289896d.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
            QQAppInterface qQAppInterface8 = this.f289896d;
            chatBackgroundManager.v(qQAppInterface8, qQAppInterface8.getCurrentAccountUin());
        }
        if (i3 == 0) {
            sharedPreferences.edit().putLong("LastTimeLogin_" + this.f289896d.getCurrentAccountUin(), currentTimeMillis).commit();
            return 7;
        }
        return 7;
    }

    void w(StatisticCollector statisticCollector) {
        long j3;
        int i3;
        if (statisticCollector == null) {
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            boolean b16 = ea.b1();
            int[] a16 = ea.a1();
            long c16 = ea.c1();
            if (!b16 && a16[1] <= 0) {
                CapturePtvTemplateManager.e().h(false);
                ea.g3();
            }
            if (c16 > 0) {
                j3 = (System.currentTimeMillis() - c16) / 1000;
            } else {
                j3 = -1;
            }
            int i16 = a16[0];
            if ((i16 <= 0 && a16[1] <= 0) || i16 > (i3 = a16[1])) {
                return;
            }
            BigDecimal bigDecimal = new BigDecimal((i16 * 1.0f) / i3);
            hashMap.put("filter_download", String.valueOf(a16[0]));
            hashMap.put("filter_total", String.valueOf(a16[1]));
            hashMap.put("filter_ratio", String.valueOf(bigDecimal.setScale(2, 4).floatValue()));
            hashMap.put("filter_spacing", String.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("DailyReport", 2, "reportQQFilterDownloadInfo filter_download = " + a16[0] + ",filter_total = " + a16[1] + ",filter_spacing" + j3);
            }
            statisticCollector.collectPerformance(this.f289896d.getCurrentAccountUin(), "reportQQFilterDownloadInfo", true, 0L, 0L, hashMap, "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f289896d.getCurrentAccountUin(), StatisticCollector.QQ_FILTER_USER_INFO, true, 0L, 0L, hashMap, null);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("DailyReport", 2, "reportWifiSwitchStatus", th5);
            }
        }
    }
}
