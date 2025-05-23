package com.tencent.mobileqq.qwallet.ipc.impl;

import Wallet.AcsMsg;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.qwallet.temp.IConditionSearchManager;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.profilecard.api.IProfileOpenApi;
import com.tencent.mobileqq.qcircle.api.data.SerializableMap;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class QWalletIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static QWalletIPCModule f278491d;

    /* loaded from: classes16.dex */
    class a implements IConditionSearchManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f278494a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f278495b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f278496c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IConditionSearchManager f278497d;

        a(Bundle bundle, int i3, ResultReceiver resultReceiver, IConditionSearchManager iConditionSearchManager) {
            this.f278494a = bundle;
            this.f278495b = i3;
            this.f278496c = resultReceiver;
            this.f278497d = iConditionSearchManager;
        }

        @Override // com.qwallet.temp.IConditionSearchManager.a
        public void onGetConfig(int i3, boolean z16) {
            int i16;
            this.f278494a.putInt("updateResult", this.f278495b);
            Bundle bundle = this.f278494a;
            if (z16) {
                i16 = 1;
            } else {
                i16 = -1;
            }
            bundle.putInt("isUpdateSuccess", i16);
            this.f278496c.send(1, this.f278494a);
            this.f278497d.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements IPreloadService.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f278499a;

        b(ResultReceiver resultReceiver) {
            this.f278499a = resultReceiver;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int i3, IPreloadService.PathResult pathResult) {
            if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadUrls" + pathResult);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("result_code", i3);
            bundle.putSerializable("path_result", pathResult);
            this.f278499a.send(0, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements IPreloadService.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f278501a;

        c(int i3) {
            this.f278501a = i3;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
        public void onResult(int i3, IPreloadService.PathResult pathResult) {
            Bundle bundle = new Bundle();
            bundle.putInt("result_code", i3);
            bundle.putSerializable("path_result", pathResult);
            QWalletIPCModule.this.callbackResult(this.f278501a, EIPCResult.createSuccessResult(bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements IPreloadService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f278503a;

        d(int i3) {
            this.f278503a = i3;
        }

        @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.d
        public void onResult(int i3, HashMap<String, IPreloadService.PathResult> hashMap) {
            Bundle bundle = new Bundle();
            bundle.putInt("result_code", i3);
            bundle.putSerializable("path_result", hashMap);
            QWalletIPCModule.this.callbackResult(this.f278503a, EIPCResult.createSuccessResult(bundle));
        }
    }

    QWalletIPCModule() {
        super("QWalletIPCModule");
    }

    private EIPCResult f(BaseQQAppInterface baseQQAppInterface, Bundle bundle, int i3) {
        switch (bundle.getInt("oper_type", -1)) {
            case 9:
                Bundle bundle2 = new Bundle();
                IQQActivateFriendService iQQActivateFriendService = (IQQActivateFriendService) baseQQAppInterface.getRuntimeService(IQQActivateFriendService.class);
                if (iQQActivateFriendService != null) {
                    bundle2.putBoolean("res", iQQActivateFriendService.getSwitchValue(true));
                } else {
                    bundle2.putBoolean("res", true);
                }
                return EIPCResult.createSuccessResult(bundle2);
            case 10:
                boolean z16 = bundle.getBoolean("req_param");
                IQQActivateFriendService iQQActivateFriendService2 = (IQQActivateFriendService) baseQQAppInterface.getRuntimeService(IQQActivateFriendService.class);
                if (iQQActivateFriendService2 != null) {
                    iQQActivateFriendService2.setSwtichValue(z16, true);
                }
                return null;
            case 11:
                AcsMsg acsMsg = (AcsMsg) bundle.getSerializable("req_param");
                IQQReminderAlarmService iQQReminderAlarmService = (IQQReminderAlarmService) baseQQAppInterface.getRuntimeService(IQQReminderAlarmService.class, "");
                if (iQQReminderAlarmService != null && acsMsg != null) {
                    iQQReminderAlarmService.setAlarmTimer(acsMsg);
                }
                return null;
            case 12:
                AcsMsg acsMsg2 = (AcsMsg) bundle.getSerializable("req_param");
                if (acsMsg2 != null) {
                    SharedPreferences sharedPreferences = baseQQAppInterface.getApp().getSharedPreferences(((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getPrefActivateFriends() + baseQQAppInterface.getCurrentAccountUin(), 0);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().remove(acsMsg2.msg_id + baseQQAppInterface.getCurrentAccountUin()).apply();
                    }
                    IQQReminderAlarmService iQQReminderAlarmService2 = (IQQReminderAlarmService) baseQQAppInterface.getRuntimeService(IQQReminderAlarmService.class, "");
                    if (iQQReminderAlarmService2 != null) {
                        iQQReminderAlarmService2.cancelAlarmById(((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getQQNotifyHelperKey(acsMsg2).hashCode());
                    }
                }
                return null;
            case 13:
                AcsMsg acsMsg3 = (AcsMsg) bundle.getSerializable("req_param");
                if (baseQQAppInterface != null && acsMsg3 != null) {
                    com.tencent.mobileqq.reminder.db.d.a(baseQQAppInterface).removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 9002, acsMsg3.msg_id.hashCode());
                    ((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).refreshAppBadge(baseQQAppInterface);
                }
                return null;
            default:
                return null;
        }
    }

    private EIPCResult g(BaseQQAppInterface baseQQAppInterface, Bundle bundle, int i3) {
        List<String> asList;
        if (bundle == null) {
            return null;
        }
        int i16 = bundle.getInt("method_type", -1);
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        return null;
                    }
                    IPreloadService.PathResult m3 = com.tencent.mobileqq.qwallet.preload.a.m((DownloadParam) bundle.getSerializable("download_params"));
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("path_result", m3);
                    return EIPCResult.createSuccessResult(bundle2);
                }
                ((IPreloadService) baseQQAppInterface.getRuntimeService(IPreloadService.class, "")).getResPath((LinkedList<DownloadParam>) bundle.getSerializable("download_params"), new d(i3));
                return null;
            }
            String[] stringArray = bundle.getStringArray("url");
            if (stringArray == null) {
                asList = null;
            } else {
                asList = Arrays.asList(stringArray);
            }
            ((IPreloadService) baseQQAppInterface.getRuntimeService(IPreloadService.class, "")).downloadUrls(asList, new b((ResultReceiver) bundle.getParcelable("receiver")));
            return null;
        }
        ((IPreloadService) baseQQAppInterface.getRuntimeService(IPreloadService.class, "")).getResPath((DownloadParam) bundle.getSerializable("download_params"), new c(i3));
        return null;
    }

    private EIPCResult h() {
        Bundle bundle = new Bundle();
        bundle.putString("res", HexUtil.bytes2HexStr(NetConnInfoCenter.GUID));
        return EIPCResult.createSuccessResult(bundle);
    }

    public static QWalletIPCModule i() {
        if (f278491d == null) {
            synchronized (QWalletIPCModule.class) {
                if (f278491d == null) {
                    f278491d = new QWalletIPCModule();
                }
            }
        }
        return f278491d;
    }

    private void j(Bundle bundle, final int i3) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("getStrangersNick_in_uinList");
        final HashMap hashMap = new HashMap();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        HashMap<String, String> nick = ((IProfileOpenApi) QRoute.api(IProfileOpenApi.class)).getNick(stringArrayList, "QWalletIPCModule", new IProfileOpenApi.ProfileServiceCallback() { // from class: com.tencent.mobileqq.qwallet.ipc.impl.c
            @Override // com.tencent.mobileqq.profilecard.api.IProfileOpenApi.ProfileServiceCallback
            public final void onResult(int i16, String str, Bundle bundle2) {
                QWalletIPCModule.this.k(atomicBoolean, hashMap, i3, i16, str, bundle2);
            }
        });
        hashMap.putAll(nick);
        if (atomicBoolean.get()) {
            EIPCResult eIPCResult = new EIPCResult();
            Bundle bundle2 = new Bundle();
            SerializableMap serializableMap = new SerializableMap();
            if (nick.size() == stringArrayList.size()) {
                serializableMap.setMap(hashMap);
            }
            bundle2.putInt("getStrangersNick_retCode", 0);
            bundle2.putSerializable("getStrangersNick_nickMap", serializableMap);
            eIPCResult.data = bundle2;
            callbackResult(i3, eIPCResult);
            return;
        }
        atomicBoolean.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(AtomicBoolean atomicBoolean, HashMap hashMap, int i3, int i16, String str, Bundle bundle) {
        if (i16 != 0 && atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(IProfileOpenApi.ProfileServiceCallback.PROFILE_NICK_MAP);
        HashMap hashMap2 = new HashMap();
        if (serializable instanceof SerializableMap) {
            SerializableMap serializableMap = (SerializableMap) serializable;
            if (serializableMap.getMap() instanceof HashMap) {
                hashMap2 = (HashMap) serializableMap.getMap();
            }
        }
        hashMap.putAll(hashMap2);
        SerializableMap serializableMap2 = new SerializableMap();
        serializableMap2.setMap(hashMap);
        EIPCResult eIPCResult = new EIPCResult();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("getStrangersNick_retCode", i16);
        bundle2.putString("getStrangersNick_retMsg", str);
        bundle2.putSerializable("getStrangersNick_nickMap", serializableMap2);
        eIPCResult.data = bundle2;
        callbackResult(i3, eIPCResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(ResultReceiver resultReceiver, String str, int i3, String str2, ResourceInfo resourceInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadModule" + str2 + "|" + resourceInfo + "|" + System.currentTimeMillis());
        }
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putInt("result", i3);
        bundle.putString("path", str2);
        bundle.putSerializable(IPreloadServiceProxy.KEY_RESINFO, resourceInfo);
        resultReceiver.send(0, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(Bundle bundle, AppRuntime appRuntime, String str) {
        String string = bundle.getString(IPreloadServiceProxy.KEY_DOWNLOAD_CONFIG_STR);
        String string2 = bundle.getString("id");
        final ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("receiver");
        IPreloadService.a aVar = new IPreloadService.a() { // from class: com.tencent.mobileqq.qwallet.ipc.impl.e
            @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.a
            public final void onDownloadResFinished(String str2, int i3, String str3, ResourceInfo resourceInfo) {
                QWalletIPCModule.l(resultReceiver, str2, i3, str3, resourceInfo);
            }
        };
        IPreloadService iPreloadService = (IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "");
        if ("downloadModule".equals(str)) {
            iPreloadService.downloadModule(string2, string, aVar);
        } else if ("downloadRes".equals(str)) {
            iPreloadService.downloadRes(string2, string, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(Bundle bundle, final int i3, AppRuntime appRuntime) {
        String string = bundle.getString("id");
        ResultReceiver resultReceiver = new ResultReceiver(null) { // from class: com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle2) {
                Bundle bundle3 = new Bundle();
                if (bundle2 != null) {
                    bundle3.putString("path", bundle2.getString("path"));
                }
                EIPCResult eIPCResult = new EIPCResult();
                eIPCResult.data = bundle3;
                QWalletIPCModule.this.callbackResult(i3, eIPCResult);
            }
        };
        IPreloadService iPreloadService = (IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "");
        if (iPreloadService != null) {
            iPreloadService.getFilePathByResID(string, resultReceiver);
        } else {
            resultReceiver.send(-7, new Bundle());
        }
    }

    private void o(final String str, final Bundle bundle, int i3, final AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "onCall downloadModule:" + System.currentTimeMillis());
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ipc.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                QWalletIPCModule.m(bundle, appRuntime, str);
            }
        }, 5, null, true);
        callbackResult(i3, null);
    }

    private void p(final Bundle bundle, final int i3, final AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "onCall getFilePathByResID");
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ipc.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                QWalletIPCModule.this.n(bundle, i3, appRuntime);
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.qipc.QIPCModule
    public void onAccountChange() {
        super.onAccountChange();
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCModule", 2, "action = " + str + ", params = " + bundle);
        }
        AppRuntime appRuntime = QWalletHelperImpl.getAppRuntime();
        if (!(appRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        if ("getFilePathByResID".equals(str)) {
            p(bundle, i3, appRuntime);
        } else if (!"downloadModule".equals(str) && !"downloadRes".equals(str)) {
            if ("getVideoResPathByMID".equals(str)) {
                String videoResPathByID = ((IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "")).getVideoResPathByID(bundle.getString("mid"));
                f.a("QWalletIPCModule", "onCall getVideoResPathByMID:" + videoResPathByID);
                Bundle bundle2 = new Bundle();
                bundle2.putString("path", videoResPathByID);
                return EIPCResult.createSuccessResult(bundle2);
            }
            if ("getResourceByResID".equals(str)) {
                IPreloadResource resourceByResID = ((IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "")).getResourceByResID(bundle.getString(IPreloadServiceProxy.KEY_RESID));
                f.a("QWalletIPCModule", "onCall getResourceByResID:" + resourceByResID);
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable(IPreloadServiceProxy.KEY_RESINFO, resourceByResID);
                return EIPCResult.createSuccessResult(bundle3);
            }
            if ("getResInfoByResID".equals(str)) {
                ResourceInfo resInfoByResId = ((IPreloadService) appRuntime.getRuntimeService(IPreloadService.class, "")).getResInfoByResId(bundle.getString(IPreloadServiceProxy.KEY_RESID));
                f.a("QWalletIPCModule", "onCall ACTION_GET_RESINFO_BY_RESID:" + resInfoByResId);
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable(IPreloadServiceProxy.KEY_RESINFO, resInfoByResId);
                return EIPCResult.createSuccessResult(bundle4);
            }
            if ("getResIDByBusinessID".equals(str)) {
                bundle.getString("bid");
                bundle.getString("uin");
                Bundle bundle5 = new Bundle();
                bundle5.putString(IPreloadServiceProxy.KEY_RESID, null);
                return EIPCResult.createSuccessResult(bundle5);
            }
            if ("getConditionSearchManager".equals(str)) {
                ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("receiver");
                IConditionSearchManager iConditionSearchManager = (IConditionSearchManager) baseQQAppInterface.getRuntimeService(IConditionSearchManager.class);
                f.a("QWalletIPCModule", "ConditionSearchManager " + iConditionSearchManager.toString());
                int checkUpdate = iConditionSearchManager.checkUpdate();
                if (checkUpdate != iConditionSearchManager.resultOk()) {
                    int update = iConditionSearchManager.update(checkUpdate, true);
                    f.a("QWalletIPCModule", "ConditionSearchManager | update result = " + update);
                    Bundle bundle6 = new Bundle();
                    if (iConditionSearchManager.isUpdateOk(update)) {
                        iConditionSearchManager.addListener(new a(bundle6, update, resultReceiver, iConditionSearchManager));
                    }
                    bundle6.putInt("isUpdateSuccess", 0);
                    bundle6.putInt("updateResult", update);
                    resultReceiver.send(checkUpdate, bundle6);
                } else {
                    resultReceiver.send(iConditionSearchManager.resultOk(), new Bundle());
                }
                return null;
            }
            if ("ComIPCUtilsImpl".equals(str)) {
                try {
                    return f(baseQQAppInterface, bundle, i3);
                } catch (Throwable th5) {
                    if (-1 == i3) {
                        return EIPCResult.createExceptionResult(th5);
                    }
                    callbackResult(i3, EIPCResult.createExceptionResult(th5));
                    return null;
                }
            }
            if ("preloadCommon".equals(str)) {
                return g(baseQQAppInterface, bundle, i3);
            }
            if ("getGuid".equals(str)) {
                return h();
            }
            if ("getStrangersNick".equals(str)) {
                j(bundle, i3);
                return null;
            }
        } else {
            o(str, bundle, i3, appRuntime);
        }
        return null;
    }
}
