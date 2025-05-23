package com.tencent.intervideo.nowproxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.CustomInterface.CustomizedPushSetting;
import com.tencent.intervideo.nowproxy.CustomInterface.ShareMenuList;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.OnHostLoginCallback;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.common.NowThreadPool;
import com.tencent.intervideo.nowproxy.common.PluginActivityLifecycleCallback;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.common.login.NowLoginInfo;
import com.tencent.intervideo.nowproxy.common.roomparam.RoomParam;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedChannel;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDns;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoader;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLoading;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedLog;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedRecord;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedReport;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedToast;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil;
import com.tencent.intervideo.nowproxy.qqshare.CustomizedShareForQQ;
import com.tencent.intervideo.nowproxy.whitelist.WelfareTaskCallback;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.net.URLEncoder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NowLive {
    static IPatchRedirector $redirector_;
    static NowRoomEntry sEntry;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sEntry = new NowRoomEntry();
        }
    }

    public NowLive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cancelRun() {
        SdkBizAbilityImpl.getInstance().notifyLoadingCancel();
        getNowRoomEntry().resetLoadingStatus();
    }

    public static void closeRoom(Bundle bundle, ActionCallback actionCallback) {
        if (bundle != null) {
            bundle.putLong("actionSeq", SdkBizAbilityImpl.getInstance().putActionCallback(actionCallback));
            sEntry.closeRoom(bundle);
        }
    }

    public static void doAction(String str) {
        sEntry.doAction(str, null, null);
    }

    public static void doActionWithExtra(String str, Bundle bundle) {
        sEntry.doAction(str, bundle);
    }

    public static CustomizedPhoneAuth getCustomizedPhoneAuth() {
        return ExtSdkBizAbilityImpl.getInstance().getCustomizedPhoneAuth();
    }

    public static boolean getFreeFlow() {
        return CustomInterfaceLogic.getsInstance().getFreeFlow();
    }

    public static void getLiveOverPluginState(CustomizedPluginState customizedPluginState) {
        ExtSdkBizAbilityImpl.getInstance().setCustomizedPluginState(customizedPluginState);
        sEntry.getLiveOverPluginState();
    }

    public static LoginObserver getLoginObserver() {
        return SdkBizAbilityImpl.getInstance().getLoginObserver();
    }

    public static NowRoomEntry getNowRoomEntry() {
        return sEntry;
    }

    public static boolean isInitData() {
        return sEntry.isInitData();
    }

    public static void killPluginProcess() {
        sEntry.killPluginProcess();
    }

    public static void login(LoginData loginData) {
        sEntry.setLoginData(loginData, false);
    }

    public static void logout() {
        sEntry.logout();
        killPluginProcess();
    }

    public static InitData makeInitData(String str, String str2) {
        InitData initData = new InitData();
        initData.mAppID = str;
        initData.mSourceVersion = str2;
        return initData;
    }

    public static void onGetNowTicket(int i3, int i16, NowLoginInfo nowLoginInfo) {
        OnHostLoginCallback onHostLoginCallback = ExtSdkBizAbilityImpl.getInstance().getOnHostLoginCallback();
        if (onHostLoginCallback != null) {
            if (i16 == 0) {
                onHostLoginCallback.onNowLoginTicketChanged(nowLoginInfo);
            } else {
                onHostLoginCallback.onGetNowLoginTicketError(2, "");
            }
        }
    }

    public static void onJumpToApp(int i3, int i16) {
        sEntry.onJumpApp(i3, i16);
    }

    public static void onQueryPhoneAuthState(int i3) {
        sEntry.onQueryPhoneAuthState(i3);
    }

    public static boolean openRoom(long j3) {
        doAction(URLEncoder.encode("action=openroom&roomid=" + j3 + "&fromid=1&first=2&enter_record_if_finish=0"), null);
        return true;
    }

    public static boolean preLogin(Bundle bundle) {
        return sEntry.preLogin(bundle);
    }

    public static void preinstall(Bundle bundle) {
        sEntry.preinstall(bundle);
    }

    public static void preload(Bundle bundle) {
        sEntry.preload(bundle);
    }

    public static void preloadPartKey(Bundle bundle) {
        sEntry.preloadParKey(bundle);
    }

    public static void pushMessage(Bundle bundle) {
        sEntry.pushMessage(bundle);
    }

    public static void registerActivityLifecycleCallback(PluginActivityLifecycleCallback pluginActivityLifecycleCallback) {
        ExtSdkBizAbilityImpl.getInstance().setActivityLifecycleCallback(pluginActivityLifecycleCallback);
    }

    public static void reportHostNowEntry() {
        sEntry.reportHostNowEntry();
    }

    public static void reportNowEntry(String str) {
        String str2;
        String str3 = "";
        Intent parseSchemeUrl = NowSchemeUtil.parseSchemeUrl(str);
        if (parseSchemeUrl == null) {
            return;
        }
        long j3 = 0;
        int i3 = 2;
        try {
            j3 = Long.parseLong(parseSchemeUrl.getStringExtra("roomid"));
            String stringExtra = parseSchemeUrl.getStringExtra("listname");
            str2 = parseSchemeUrl.getStringExtra("fromid");
            try {
                str3 = parseSchemeUrl.getStringExtra("vid");
                String stringExtra2 = parseSchemeUrl.getStringExtra(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
                if (stringExtra2 != null) {
                    try {
                        if (stringExtra2.length() > 0) {
                            i3 = Integer.valueOf(stringExtra2).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(stringExtra)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(stringExtra);
                    new ListNameData(arrayList, 0);
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            str2 = "";
        }
        String str4 = str2;
        int i16 = i3;
        long j16 = j3;
        Bundle extras = parseSchemeUrl.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        Bundle bundle = extras;
        bundle.putAll(RoomParam.getEnterRoomParam(j16, str3, str4, i16));
        sEntry.reportNowEntry(j16, str4, i16, bundle);
    }

    public static void sendServerPushMessage(Bundle bundle) {
        sEntry.sendServerPushMessage(bundle);
    }

    public static void setCoreActionCallback(CoreActionCallback coreActionCallback) {
        CustomInterfaceLogic.getsInstance().setCoreActionCallback(coreActionCallback);
    }

    public static void setCustomChannel(CustomizedChannel customizedChannel) {
        SdkBaseAbilityImpl.getsInstance().setCustomizedChannel(customizedChannel);
    }

    public static void setCustomizeReport(CustomizedReport customizedReport) {
        CustomInterfaceLogic.getsInstance().setCustomizeReport(customizedReport);
    }

    public static void setCustomizedCoverImg(CustomizedCoverImg customizedCoverImg) {
        CustomInterfaceLogic.getsInstance().setCustomCoverImg(customizedCoverImg);
    }

    public static void setCustomizedDns(CustomizedDns customizedDns) {
        CustomInterfaceLogic.getsInstance().setCustomDns(customizedDns);
    }

    public static void setCustomizedDownloader(CustomizedDownloader customizedDownloader) {
        CustomInterfaceLogic.getsInstance().setCustomizedDownloader(customizedDownloader);
    }

    public static void setCustomizedLoader(CustomizedLoader customizedLoader) {
        SdkBaseAbilityImpl.getsInstance().setCustomizedLoader(customizedLoader);
    }

    public static void setCustomizedLoading(CustomizedLoading customizedLoading) {
        SdkBaseAbilityImpl.getsInstance().setCustomizedLoading(customizedLoading);
    }

    public static void setCustomizedLog(CustomizedLog customizedLog) {
        CustomInterfaceLogic.getsInstance().setCustomizedLog(customizedLog);
        HostLog.sInstance.setCustomizedLog(customizedLog);
    }

    public static void setCustomizedOpenLiveHall(CustomizedOpenLiveHall customizedOpenLiveHall) {
        ExtSdkBizAbilityImpl.getInstance().setCustomizedOpenLiveHall(customizedOpenLiveHall);
    }

    public static void setCustomizedOpenWxMiniProgram(CustomizedOpenWxMiniProgram customizedOpenWxMiniProgram) {
        CustomInterfaceLogic.getsInstance().setCustomizedOpenWxMiniProgram(customizedOpenWxMiniProgram);
    }

    public static void setCustomizedPay(CustomizedPayment customizedPayment) {
        CustomInterfaceLogic.getsInstance().setCustomizedPay(customizedPayment);
    }

    public static void setCustomizedPhoneAuth(CustomizedPhoneAuth customizedPhoneAuth) {
        ExtSdkBizAbilityImpl.getInstance().setCustomizedPhoneAuth(customizedPhoneAuth);
    }

    public static void setCustomizedPluginState(CustomizedPluginState customizedPluginState) {
        ExtSdkBizAbilityImpl.getInstance().setCustomizedPluginState(customizedPluginState);
    }

    public static void setCustomizedPushSetting(CustomizedPushSetting customizedPushSetting) {
        CustomInterfaceLogic.getsInstance().setCustomizedPushSetting(customizedPushSetting);
    }

    public static void setCustomizedRecord(CustomizedRecord customizedRecord) {
        SdkBizAbilityImpl.getInstance().setCustomRecord(customizedRecord);
    }

    public static void setCustomizedShare(CustomizedShare customizedShare) {
        CustomInterfaceLogic.getsInstance().setCustomizedShare(customizedShare);
    }

    public static void setCustomizedShareForQQ(CustomizedShareForQQ customizedShareForQQ) {
        SdkBizAbilityImpl.getInstance().setCustomShareForQQ(customizedShareForQQ);
    }

    public static void setCustomizedTicket(CustomizedTicket customizedTicket) {
        SdkBaseAbilityImpl.getsInstance().setmCustomizedTiket(customizedTicket);
    }

    public static void setCustomizedToast(CustomizedToast customizedToast) {
        CustomInterfaceLogic.getsInstance().setCustomizedToast(customizedToast);
    }

    public static void setCustomizedWebView(CustomizedWebView customizedWebView) {
        CustomInterfaceLogic.getsInstance().setCustomisedWebview(customizedWebView);
    }

    public static void setFreeFlow(boolean z16) {
        CustomInterfaceLogic.getsInstance().setFreeFlow(z16);
    }

    public static void setLoginObserver(LoginObserver loginObserver) {
        sEntry.setLoginObserver(loginObserver);
        SdkBizAbilityImpl.getInstance().setLoginObserver(loginObserver);
    }

    public static void setOnHostLoginCallback(OnHostLoginCallback onHostLoginCallback) {
        ExtSdkBizAbilityImpl.getInstance().setOnHostLoginCallback(onHostLoginCallback);
    }

    public static void setQQKandianInterface(QQKandianInterface qQKandianInterface) {
        SdkBizAbilityImpl.getInstance().setQQKandianInterface(qQKandianInterface);
    }

    public static void setShadowImp(IShadow iShadow) {
        SdkBaseAbilityImpl.getsInstance().setShadowImpl(iShadow);
    }

    public static void setThreadPoolProvider(NowThreadPool.ThreadPoolProvider threadPoolProvider) {
        NowThreadPool.setThreadPoolProvider(threadPoolProvider);
        SdkBizAbilityImpl.getInstance().setThreadPoolProvider(threadPoolProvider);
    }

    public static void setWelfareTaskCallback(WelfareTaskCallback welfareTaskCallback) {
        CustomInterfaceLogic.getsInstance().setWelfareTaskCallback(welfareTaskCallback);
    }

    public static void start(Context context, InitData initData) {
        sEntry.init(context, initData);
    }

    public static void startNowSubProcess(Context context) {
        sEntry.initNowSubProcess(context);
    }

    public static void stop() {
        sEntry.exit();
        killPluginProcess();
    }

    public static void updateFreeFlow(boolean z16) {
        setFreeFlow(z16);
        sEntry.updateFreeFlow(z16);
    }

    public static void updateLoginData(LoginData loginData) {
        sEntry.updateLoginData(loginData, false);
    }

    public static void doAction(String str, ActionCallback actionCallback) {
        sEntry.doAction(str, null, actionCallback);
    }

    public static void doActionWithExtra(String str, Bundle bundle, ActionCallback actionCallback) {
        sEntry.doAction(str, bundle, actionCallback);
    }

    public static void login(LoginData loginData, boolean z16) {
        sEntry.setLoginData(loginData, z16);
    }

    public static boolean openRoom(ListNameData listNameData, long j3, String str, String str2, int i3, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        bundle2.putAll(RoomParam.getEnterRoomParam(j3, str, str2, i3));
        return sEntry.openroom(listNameData, j3, str, str2, i3, bundle2);
    }

    public static void setCustomizedShare(ShareMenuList shareMenuList, CustomizedShare customizedShare) {
        CustomInterfaceLogic.getsInstance().setCustomizedShare(shareMenuList, customizedShare);
    }

    public static void updateLoginData(LoginData loginData, boolean z16) {
        sEntry.updateLoginData(loginData, z16);
    }

    public static void setCustomizedSubscribe(CustomizedSubscribe customizedSubscribe) {
    }
}
