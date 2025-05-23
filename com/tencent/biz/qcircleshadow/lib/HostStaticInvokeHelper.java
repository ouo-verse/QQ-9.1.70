package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.turingfd.c;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.webview.swift.cookie.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import cooperation.qzone.QUA;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae$RspBody;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostStaticInvokeHelper {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TAG = "HostStaticInvokeHelper";
    private static final ConcurrentHashMap<Integer, NetHandler> NET_WORK_MAP = new ConcurrentHashMap<>();
    private static final StringBuffer DATE_STR_BUF = new StringBuffer(25);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface InvokeNormalCallBack {
        void onFailed();

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class NetHandler implements INetEventHandler {
        private WeakReference<NetworkChangedObserver> mObserver;

        public NetHandler(NetworkChangedObserver networkChangedObserver) {
            this.mObserver = new WeakReference<>(networkChangedObserver);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            NetworkChangedObserver networkChangedObserver = this.mObserver.get();
            if (networkChangedObserver == null) {
                return;
            }
            networkChangedObserver.onNetworkChanged(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface NetworkChangedObserver {
        void onNetworkChanged(boolean z16);
    }

    public static void addNetworkChangedObserver(NetworkChangedObserver networkChangedObserver) {
        if (networkChangedObserver == null) {
            return;
        }
        NetHandler netHandler = new NetHandler(networkChangedObserver);
        NET_WORK_MAP.put(Integer.valueOf(networkChangedObserver.hashCode()), netHandler);
        AppNetConnInfo.registerNetChangeReceiver(MobileQQ.sMobileQQ, netHandler);
    }

    public static String getAIDTicket() {
        return c.a().c(true).getAIDTicket();
    }

    public static String[] getMimeType(String str) {
        return MimeHelper.getMimeType(str);
    }

    public static String getMsgDateTime(long j3) {
        return en.r(DATE_STR_BUF, j3, true, "yyyy-MM-dd", true);
    }

    public static String getPlayerCookie() {
        return "uin=" + b.e(RFWApplication.getAccountId()) + "; skey=";
    }

    public static String getPluginQua() {
        return QUA.getQUA3();
    }

    public static String getQCircleSchemeFromJumpUtil(String str, String str2) {
        return ((IJumpUtil) QRoute.api(IJumpUtil.class)).getCircleScheme(str, str2);
    }

    public static String getQMessageDateTime(StringBuffer stringBuffer, long j3, boolean z16, String str, boolean z17) {
        return en.r(stringBuffer, j3, z16, str, z17);
    }

    public static long getServerTimeMillis() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    public static Typeface getSystemDefaultFont() {
        return TextHook.getInstance().getSystemDefaultFont();
    }

    public static String getTAIDTicket() {
        return c.a().c(true).getTAIDTicket();
    }

    public static Bundle getTroopProfileExtra(String str) {
        return aq.d(str, "", 0);
    }

    public static String insertMtypeByMsfSdkUtils(String str, String str2) {
        return MsfSdkUtils.insertMtype(str, str2);
    }

    public static boolean isNetworkValid() {
        return AppNetConnInfo.isNetSupport();
    }

    public static boolean isShowGuildTab() {
        return ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTabCached();
    }

    public static void redPointHandlerSendRedpointReq(boolean z16, boolean z17) {
        IRedTouchServer iRedTouchServer = (IRedTouchServer) QCircleServiceImpl.getAppRunTime().getRuntimeService(IRedTouchServer.class, "");
        if (iRedTouchServer != null) {
            QLog.i(TAG, 1, "redPointHandlerSendRedpointReq");
            iRedTouchServer.sendRedpointReq(z16, z17, 10);
        }
    }

    public static void registerAccountCallback(IAccountCallback iAccountCallback) {
        MobileQQ.sMobileQQ.registerAccountCallback(iAccountCallback);
    }

    public static void registerNetworkMonitorReceiver() {
        NetworkMonitorReceiver.getInstance().registerReceiver();
    }

    public static void removeNetworkChangeObserver(NetworkChangedObserver networkChangedObserver) {
        NetHandler remove;
        if (networkChangedObserver == null || (remove = NET_WORK_MAP.remove(Integer.valueOf(networkChangedObserver.hashCode()))) == null) {
            return;
        }
        AppNetConnInfo.unregisterNetEventHandler(remove);
    }

    public static void requestPermission(Context context, BusinessConfig businessConfig, String[] strArr, int i3, QQPermission.BasePermissionsListener basePermissionsListener) {
        if (context instanceof Activity) {
            QQPermissionFactory.getQQPermission((Activity) context, businessConfig).requestPermissions(strArr, i3, basePermissionsListener);
        }
    }

    public static void sendQCircleAccountIdentityRequest(final AccountIdentityCallBack accountIdentityCallBack) {
        AppRuntime waitAppRuntime;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qircle_disable_cmd_qcircle_account_identity", true) && (waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null)) != null && waitAppRuntime.getApp() != null) {
            LoginVerifyServlet.n(waitAppRuntime, new com.tencent.mobileqq.observer.c() { // from class: com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.1
                @Override // com.tencent.mobileqq.observer.c
                public void getAccountIdentitySuccess(cmd0x9ae$RspBody cmd0x9ae_rspbody) {
                    if (cmd0x9ae_rspbody != null) {
                        AccountIdentityCallBack.this.onSuccess(cmd0x9ae_rspbody.bool_has_been_authenticated.get(), cmd0x9ae_rspbody.msg_auth_tips.string_tips_action_url.get());
                    }
                }
            });
        }
    }

    public static void setActivityInputMode(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getWindow() != null) {
                activity.getWindow().setSoftInputMode(16);
            }
        }
    }

    public static void summitHighPriortyJob(final InvokeNormalCallBack invokeNormalCallBack) {
        PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.2
            @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
            public Object run(ThreadPool.JobContext jobContext) {
                InvokeNormalCallBack.this.onSuccess();
                return null;
            }
        }, PriorityThreadPool.Priority.HIGH);
    }

    public static void unregisterAccountCallback(IAccountCallback iAccountCallback) {
        MobileQQ.sMobileQQ.unregisterAccountCallback(iAccountCallback);
    }

    public static boolean validateVideoType(String str) {
        return MimeHelper.validateVideoType(str);
    }
}
