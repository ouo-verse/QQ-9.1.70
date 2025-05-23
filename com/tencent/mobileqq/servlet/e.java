package com.tencent.mobileqq.servlet;

import KQQ.PluginInfo;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameFullScreenNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePushMsgService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x11c.MsgBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f286468d;

    /* renamed from: e, reason: collision with root package name */
    private SharedPreferences f286469e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Long> f286470f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Long, b> f286471h;

    /* renamed from: i, reason: collision with root package name */
    private PadFaceManager f286472i;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ScreenshotManager.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f286473a;

        a(int i3) {
            this.f286473a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, i3);
            }
        }

        @Override // com.tencent.gamecenter.common.util.ScreenshotManager.b
        public void a(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("GameCenterManagerImp", 1, "on push code=" + i3 + " cmd=" + this.f286473a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f286475a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f286476b;

        /* renamed from: c, reason: collision with root package name */
        public String f286477c;

        /* renamed from: d, reason: collision with root package name */
        public String f286478d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f286479e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f286480f;

        /* renamed from: g, reason: collision with root package name */
        public int f286481g;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                return;
            }
            this.f286475a = 0L;
            this.f286476b = false;
            this.f286477c = "";
            this.f286478d = "";
            this.f286479e = false;
            this.f286480f = false;
            this.f286481g = 0;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(1024);
            sb5.append("mUnread=" + this.f286475a);
            sb5.append(",mNewMsg=" + this.f286476b);
            sb5.append("mText=" + this.f286477c);
            sb5.append(",mIconPath=" + this.f286478d);
            sb5.append("mRedPoint=" + this.f286479e);
            sb5.append(",mTab=" + this.f286480f);
            sb5.append(",mType=" + this.f286481g);
            return sb5.toString();
        }
    }

    public e(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f286468d = qQAppInterface;
        this.f286469e = qQAppInterface.getApp().getSharedPreferences("gamecenter_prefername", 0);
        d();
        this.f286472i = new PadFaceManager(qQAppInterface);
    }

    private boolean c(String str, int i3) {
        File[] listFiles;
        int parseInt;
        File moduleFile = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleFile(str);
        if (moduleFile == null || (listFiles = moduleFile.listFiles()) == null) {
            return false;
        }
        boolean z16 = false;
        for (File file : listFiles) {
            String name = file.getName();
            if (new File(moduleFile, name).exists() && (parseInt = Integer.parseInt(name)) < i3) {
                QLog.i("GameCenterManagerImp", 2, "handleRemoveHippyBundle delete version: " + parseInt);
                FileUtils.deleteDirectory(((IHippySetting) QRoute.api(IHippySetting.class)).getModuleFile(str, parseInt).getAbsolutePath());
                z16 = true;
            }
        }
        return z16;
    }

    private void d() {
        String[] split;
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "loadGameCenterUnread.");
        }
        this.f286470f = new ArrayList<>();
        this.f286471h = new HashMap<>();
        String account = this.f286468d.getAccount();
        if (!TextUtils.isEmpty(account)) {
            String string = this.f286469e.getString("gc_pluginid" + account, null);
            if (string != null && (split = string.split(ContainerUtils.FIELD_DELIMITER)) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        long parseLong = Long.parseLong(str);
                        if (parseLong > 0) {
                            b bVar = new b();
                            bVar.f286475a = this.f286469e.getLong("gc_unread" + account + "_" + str, 0L);
                            bVar.f286476b = this.f286469e.getBoolean("gc_newmsg" + account + "_" + str, false);
                            bVar.f286479e = this.f286469e.getBoolean("gc_redpoint" + account + "_" + str, false);
                            bVar.f286480f = this.f286469e.getBoolean("gc_tab" + account + "_" + str, false);
                            bVar.f286477c = this.f286469e.getString("gc_text" + account + "_" + str, "");
                            bVar.f286478d = this.f286469e.getString("gc_icon" + account + "_" + str, "");
                            bVar.f286481g = this.f286469e.getInt("gc_type" + account + "_" + str, -1);
                            this.f286470f.add(Long.valueOf(parseLong));
                            this.f286471h.put(Long.valueOf(parseLong), bVar);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private void f() {
        if (this.f286470f != null && this.f286471h != null) {
            String account = this.f286468d.getAccount();
            SharedPreferences.Editor edit = this.f286469e.edit();
            Iterator<Long> it = this.f286470f.iterator();
            String str = "";
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                if (this.f286471h.containsKey(Long.valueOf(longValue))) {
                    if (str.length() > 0) {
                        str = str + ContainerUtils.FIELD_DELIMITER + longValue;
                    } else {
                        str = str + longValue;
                    }
                    b bVar = this.f286471h.get(Long.valueOf(longValue));
                    edit.putLong("gc_unread" + account + "_" + longValue, bVar.f286475a);
                    edit.putBoolean("gc_newmsg" + account + "_" + longValue, bVar.f286476b);
                    edit.putBoolean("gc_redpoint" + account + "_" + longValue, bVar.f286479e);
                    edit.putBoolean("gc_tab" + account + "_" + longValue, bVar.f286480f);
                    edit.putString("gc_text" + account + "_" + longValue, bVar.f286477c);
                    edit.putString("gc_icon" + account + "_" + longValue, bVar.f286478d);
                    edit.putInt("gc_type" + account + "_" + longValue, bVar.f286481g);
                }
            }
            edit.putString("gc_pluginid" + account, str);
            edit.commit();
        }
    }

    public int a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).intValue();
        }
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) this.f286468d.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(str);
        if (appInfoByPath != null && appInfoByPath.iNewFlag.get() != 0) {
            return appInfoByPath.type.get();
        }
        return -1;
    }

    public PadFaceManager b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PadFaceManager) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f286472i;
    }

    public void e(MsgBody msgBody, MsgInfo msgInfo) {
        IQQGameFullScreenNoticeService iQQGameFullScreenNoticeService;
        String str;
        IQQGamePushMsgService iQQGamePushMsgService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) msgBody, (Object) msgInfo);
            return;
        }
        if (msgBody == null) {
            return;
        }
        int i3 = msgBody.uint32_cmd.get();
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, "++++onReceivePushMsg cmd=" + i3);
        }
        switch (i3) {
            case 1:
                ((IQQGameCheckService) this.f286468d.getRuntimeService(IQQGameCheckService.class, "")).handlePreDownloadPush(msgBody.bytes_data.get().toStringUtf8(), "onlineMsg");
                return;
            case 2:
                ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).handlePushConfigCheck(msgBody.bytes_data.get().toStringUtf8());
                return;
            case 3:
                try {
                    int optInt = new JSONObject(msgBody.bytes_data.get().toStringUtf8()).optInt("subCmd");
                    a aVar = new a(optInt);
                    if (optInt == 1) {
                        ScreenshotManager.m().j(aVar);
                    } else if (optInt == 2) {
                        ScreenshotManager.m().i(aVar);
                    } else if (optInt == 3) {
                        ScreenshotManager.m().q(aVar);
                    }
                    return;
                } catch (JSONException e16) {
                    QLog.e("GameCenterManagerImp", 1, "onReceivePushMsg screenshot push e=" + e16.toString());
                    return;
                }
            case 4:
            case 7:
            case 9:
            case 11:
            case 16:
            default:
                return;
            case 5:
                try {
                    com.tencent.mobileqq.gamecenter.data.e.g(this.f286468d, new JSONObject(msgBody.bytes_data.get().toStringUtf8()), msgInfo.lMsgUid);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 6:
                if (this.f286468d != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterManagerImp", 2, "onReceivePushMsg request Hippy");
                    }
                    ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).requestHippyConfig(2);
                    return;
                }
                return;
            case 8:
                try {
                    JSONObject jSONObject = new JSONObject(msgBody.bytes_data.get().toStringUtf8());
                    ((IGameMsgManagerService) this.f286468d.getRuntimeService(IGameMsgManagerService.class, "")).onGameSwitchChange(jSONObject.optString(VirtualAppProxy.KEY_GAME_ID), jSONObject.optInt("switchType"), jSONObject.optInt("value"));
                    return;
                } catch (Throwable th5) {
                    QLog.e("GameCenterManagerImp", 1, th5, new Object[0]);
                    return;
                }
            case 10:
                if (com.tencent.mobileqq.qqexpand.utils.r.b()) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(msgBody.bytes_data.get().toStringUtf8());
                        if (QLog.isColorLevel()) {
                            QLog.i("GameCenterManagerImp", 2, "gamebox auth msg push: " + jSONObject2);
                        }
                        ((IGameMsgBoxRuntimeService) this.f286468d.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).buildGameBoxAuthSummary(jSONObject2);
                        return;
                    } catch (Throwable th6) {
                        QLog.e("GameCenterManagerImp", 1, th6, new Object[0]);
                        return;
                    }
                }
                return;
            case 12:
                try {
                    JSONObject optJSONObject = new JSONObject(msgBody.bytes_data.get().toStringUtf8()).optJSONObject("removeJsBundle");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("bundleName");
                        int optInt2 = optJSONObject.optInt("minVer");
                        if (!TextUtils.isEmpty(optString) && optInt2 >= 1) {
                            boolean c16 = c(optString, optInt2);
                            HashMap hashMap = new HashMap();
                            hashMap.put(4, "20");
                            if (c16) {
                                str = "1";
                            } else {
                                str = "2";
                            }
                            hashMap.put(2, str);
                            hashMap.put(27, String.valueOf(((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(optString)));
                            hl0.a.c(this.f286468d, "9397", "914259", "", "939701", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, hashMap);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    QLog.e("GameCenterManagerImp", 1, e17, new Object[0]);
                    return;
                }
            case 13:
                try {
                    String stringUtf8 = msgBody.bytes_data.get().toStringUtf8();
                    if (QLog.isColorLevel()) {
                        QLog.i("GameCenterManagerImp", 2, "gameappoint fullscreen msg push: " + stringUtf8);
                    }
                    JSONObject jSONObject3 = new JSONObject(msgBody.bytes_data.get().toStringUtf8());
                    AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface != null && (iQQGameFullScreenNoticeService = (IQQGameFullScreenNoticeService) appInterface.getRuntimeService(IQQGameFullScreenNoticeService.class, "")) != null) {
                        iQQGameFullScreenNoticeService.onFullScreenPushReceived(jSONObject3);
                        return;
                    }
                    return;
                } catch (Throwable th7) {
                    QLog.e("GameCenterManagerImp", 1, th7, new Object[0]);
                    return;
                }
            case 14:
                try {
                    AppInterface appInterface2 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (appInterface2 != null) {
                        IYunGameManagerService iYunGameManagerService = (IYunGameManagerService) appInterface2.getRuntimeService(IYunGameManagerService.class, "");
                        if (iYunGameManagerService == null) {
                            QLog.e("GameCenterManagerImp", 2, "[onReceivePushMsg], service is null");
                        } else {
                            iYunGameManagerService.onPushReceive(msgBody.bytes_data.get().toStringUtf8());
                        }
                    }
                    return;
                } catch (Throwable th8) {
                    QLog.e("GameCenterManagerImp", 1, th8, new Object[0]);
                    return;
                }
            case 15:
                ((IQQGameCheckService) this.f286468d.getRuntimeService(IQQGameCheckService.class, "")).handlePreloadPush(msgBody.bytes_data.get().toStringUtf8());
                return;
            case 17:
                ((IQQGameCheckService) this.f286468d.getRuntimeService(IQQGameCheckService.class, "")).handlePreUpdatePush(msgBody.bytes_data.get().toStringUtf8(), "onlineMsg");
                return;
            case 18:
                String stringUtf82 = msgBody.bytes_data.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterManagerImp", 2, "onReceivePushMsg PUSH_GAME_WIDGET_UPDATE, msg=" + stringUtf82);
                }
                ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).onWidgetPushMsgReceived(stringUtf82);
                return;
            case 19:
                try {
                    IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(IGameMsgManagerService.class, "");
                    if (iGameMsgManagerService != null) {
                        iGameMsgManagerService.onReceiveGamePartnerChangePush();
                        return;
                    }
                    return;
                } catch (Exception unused2) {
                    QLog.e("GameCenterManagerImp", 2, "[onReceivePushMsg], update partner list err.");
                    return;
                }
            case 20:
                try {
                    String stringUtf83 = msgBody.bytes_data.get().toStringUtf8();
                    ((IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class)).onMsgForwardToFrontReceived(stringUtf83);
                    IGameMsgManagerService iGameMsgManagerService2 = (IGameMsgManagerService) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(IGameMsgManagerService.class, "");
                    if (iGameMsgManagerService2 != null) {
                        iGameMsgManagerService2.pushMsgForH5(stringUtf83);
                        return;
                    }
                    return;
                } catch (Throwable th9) {
                    QLog.e("GameCenterManagerImp", 1, th9, new Object[0]);
                    return;
                }
            case 21:
                try {
                    if (msgBody.bytes_data.get() != null) {
                        String stringUtf84 = msgBody.bytes_data.get().toStringUtf8();
                        int i16 = msgBody.uint32_timestamp.get();
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        if (peekAppRuntime != null && (iQQGamePushMsgService = (IQQGamePushMsgService) peekAppRuntime.getRuntimeService(IQQGamePushMsgService.class, "all")) != null) {
                            iQQGamePushMsgService.onReceivePushMsg(stringUtf84, i16);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th10) {
                    QLog.e("GameCenterManagerImp", 1, "onReceivePushMsg cmd-21 e:", th10);
                    return;
                }
            case 22:
                String stringUtf85 = msgBody.bytes_data.get().toStringUtf8();
                AppInterface appInterface3 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface3 != null) {
                    IQQGameCheckService iQQGameCheckService = (IQQGameCheckService) appInterface3.getRuntimeService(IQQGameCheckService.class, "");
                    if (iQQGameCheckService == null) {
                        QLog.e("GameCenterManagerImp", 2, "[onReceivePushMsg], IQQGameCheckService is null");
                        return;
                    } else {
                        iQQGameCheckService.handlePreImitatePush(stringUtf85);
                        return;
                    }
                }
                return;
            case 23:
                String stringUtf86 = msgBody.bytes_data.get().toStringUtf8();
                AppInterface appInterface4 = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (appInterface4 != null) {
                    IQQGameCheckService iQQGameCheckService2 = (IQQGameCheckService) appInterface4.getRuntimeService(IQQGameCheckService.class, "");
                    if (iQQGameCheckService2 == null) {
                        QLog.e("GameCenterManagerImp", 2, "[onReceivePushMsg], IQQGameCheckService is null");
                        return;
                    } else {
                        iQQGameCheckService2.handleKeepLivePush(stringUtf86);
                        return;
                    }
                }
                return;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        SharedPreferences sharedPreferences = this.f286468d.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0);
        int i3 = sharedPreferences.getInt("businessinfo_check_update_interval_" + this.f286468d.getCurrentAccountUin(), 600);
        int i16 = sharedPreferences.getInt("businessinfo_last_check_update_timestamp_" + this.f286468d.getCurrentAccountUin(), 0);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (currentTimeMillis - i16 > i3 || currentTimeMillis < i16) {
            ((FriendListHandler) this.f286468d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCheckUpdate(true, 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [mqq.app.AppRuntime, com.tencent.mobileqq.app.QQAppInterface] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.content.Intent, mqq.app.NewIntent] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public boolean h(List<PluginInfo> list) {
        boolean z16;
        char c16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        ?? r75;
        boolean z27;
        boolean z28;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list)).booleanValue();
        }
        int i16 = 1;
        boolean z29 = false;
        if (list != null && list.size() > 0) {
            ?? r76 = -1;
            int i17 = 0;
            ?? r85 = 0;
            while (i17 < list.size()) {
                PluginInfo pluginInfo = list.get(i17);
                if (pluginInfo != null && this.f286471h.get(Long.valueOf(pluginInfo.Id)) != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterManagerImp", i3, "setNewUnread.i=" + i17 + ",plugin:" + pluginInfo.toString());
                    }
                    b bVar = this.f286471h.get(Long.valueOf(pluginInfo.Id));
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterManagerImp", i3, "setNewUnread.i=" + i17 + ",before unreaddata:" + bVar.toString());
                    }
                    long j3 = pluginInfo.Count;
                    if (j3 > 0) {
                        boolean z36 = r76;
                        int i18 = r85;
                        if (bVar.f286475a != j3) {
                            if (pluginInfo.Tab) {
                                i18 = i16;
                                z36 = z29;
                            } else {
                                i18 = i16;
                                z36 = r76;
                            }
                        }
                        bVar.f286475a = j3;
                        String str = pluginInfo.Text;
                        bVar.f286477c = str;
                        bVar.f286476b = z29;
                        bVar.f286479e = z29;
                        if (TextUtils.isEmpty(str)) {
                            bVar.f286481g = i16;
                        } else {
                            bVar.f286481g = 4;
                        }
                        bVar.f286480f = pluginInfo.Tab;
                        z17 = z29;
                        r76 = z36;
                        r85 = i18;
                    } else {
                        boolean z37 = pluginInfo.Flag;
                        if (z37) {
                            if (bVar.f286475a <= 0) {
                                boolean z38 = r76;
                                boolean z39 = r85;
                                if (!bVar.f286476b) {
                                    boolean z46 = r76;
                                    z46 = r76;
                                    if (pluginInfo.Tab && (r76 == -1 || r76 == 4)) {
                                        z46 = true;
                                    }
                                    z39 = true;
                                    z38 = z46;
                                }
                                bVar.f286476b = z37;
                                bVar.f286479e = false;
                                bVar.f286475a = 0L;
                                String str2 = pluginInfo.Text;
                                bVar.f286477c = str2;
                                if (TextUtils.isEmpty(str2)) {
                                    bVar.f286481g = 3;
                                } else {
                                    bVar.f286481g = 6;
                                }
                                bVar.f286480f = pluginInfo.Tab;
                                z28 = z38;
                                z27 = z39;
                                z17 = false;
                                r76 = z28;
                                r85 = z27;
                            }
                            z17 = false;
                        } else {
                            boolean z47 = pluginInfo.RedPoint;
                            z28 = r76;
                            z27 = r85;
                            if (z47) {
                                if (bVar.f286475a <= 0 && (pluginInfo.Id != 769 || !bVar.f286476b)) {
                                    if (!bVar.f286479e) {
                                        if (r76 == -1 && pluginInfo.Tab) {
                                            z18 = z47;
                                            r75 = 4;
                                        } else {
                                            z18 = z47;
                                            r75 = r76;
                                        }
                                        z19 = true;
                                        z26 = r75;
                                    } else {
                                        z18 = z47;
                                        z26 = r76;
                                        z19 = r85;
                                    }
                                    bVar.f286479e = z18;
                                    z17 = false;
                                    bVar.f286476b = false;
                                    bVar.f286475a = 0L;
                                    String str3 = pluginInfo.Text;
                                    bVar.f286477c = str3;
                                    bVar.f286478d = pluginInfo.PicUrl;
                                    if (TextUtils.isEmpty(str3)) {
                                        if (TextUtils.isEmpty(bVar.f286478d)) {
                                            bVar.f286481g = 2;
                                        } else {
                                            bVar.f286481g = 7;
                                        }
                                    } else {
                                        bVar.f286481g = 5;
                                    }
                                    bVar.f286480f = pluginInfo.Tab;
                                    r76 = z26;
                                    r85 = z19;
                                }
                                z17 = false;
                            }
                            z17 = false;
                            r76 = z28;
                            r85 = z27;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GameCenterManagerImp", 2, "setNewUnread.i=" + i17 + ",unreaddata:" + bVar.toString());
                    }
                } else {
                    z17 = z29;
                }
                i17++;
                z29 = z17;
                i3 = 2;
                i16 = 1;
                r76 = r76;
                r85 = r85;
            }
            z16 = z29;
            f();
            if (QLog.isColorLevel()) {
                QLog.d("GameCenterManagerImp", 2, "setNewUnread.changeType=" + r76 + ",ischange:" + r85);
            }
            c16 = r76;
            if (r76 != -1) {
                ?? newIntent = new NewIntent(this.f286468d.getApplication(), f.class);
                newIntent.setAction("gc_refresh_ui");
                newIntent.putExtra("gc_notify_type", r76);
                this.f286468d.startServlet(newIntent);
                c16 = r76;
            } else if (r85 != 0) {
                NewIntent newIntent2 = new NewIntent(this.f286468d.getApplication(), f.class);
                newIntent2.setAction("gc_refresh_ui");
                newIntent2.putExtra("gc_notify_type", 3);
                this.f286468d.startServlet(newIntent2);
                c16 = r76;
            }
        } else {
            z16 = false;
            c16 = '\uffff';
        }
        if (c16 != '\uffff') {
            return true;
        }
        return z16;
    }

    public void i(long j3, boolean z16, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Boolean.valueOf(z16), Long.valueOf(j16));
            return;
        }
        if (this.f286471h.containsKey(Long.valueOf(j3))) {
            b bVar = this.f286471h.get(Long.valueOf(j3));
            bVar.f286476b = z16;
            bVar.f286475a = j16;
            this.f286471h.put(Long.valueOf(j3), bVar);
            f();
            NewIntent newIntent = new NewIntent(this.f286468d.getApplication(), f.class);
            newIntent.setAction("gc_refresh_ui");
            if (j16 <= 0 && !z16) {
                newIntent.putExtra("gc_notify_type", 3);
            } else if (j16 > 0) {
                newIntent.putExtra("gc_notify_type", 0);
            } else {
                newIntent.putExtra("gc_notify_type", 1);
            }
            this.f286468d.startServlet(newIntent);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("GameCenterManagerImp", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }
}
