package com.tencent.mobileqq.vas.ipc;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vastrash.uec.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.host.ILiveEnterGroupHostApi;
import eipc.EIPCResult;
import java.util.ArrayList;

/* loaded from: classes20.dex */
public class VasLiveIPCModule extends QIPCModule {
    public static final String ACTION_CLOSE_DRAWER = "action_close_drawer";
    public static final String ACTION_ENTER_GROUP = "enterGroup";
    public static final String ACTION_FOLLOW_ACCOUNT = "followAccount";
    public static final String ACTION_GET_ACCOUNT_NICK_NAME = "action_get_nick_name";
    public static final String ACTION_REPORT_STAY_TIME = "action_report_stay_time";
    public static final String KEY_ANCHOR_UIN = "anchorUin";
    public static final String KEY_FOLLOW_TYPE = "followType";
    public static final String KEY_GET_ACCOUNT_NICK_NAME = "accountName";
    public static final String KEY_GROUP_UIN = "groupUin";
    public static final String KEY_STAY_INFO = "stayInfo";
    public static final String NAME = "VasLiveIPCModule";
    private static final String TAG = "VasLiveIPCModule";
    private static VasLiveIPCModule sInstance;

    VasLiveIPCModule(String str) {
        super(str);
    }

    private long getAccount() {
        return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    }

    private String getAccountName() {
        String valueOf = String.valueOf(getAccount());
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            return ac.f(qQAppInterface, qQAppInterface.getCurrentAccountUin());
        } catch (Throwable th5) {
            th5.printStackTrace();
            return valueOf;
        }
    }

    public static synchronized VasLiveIPCModule getInstance() {
        VasLiveIPCModule vasLiveIPCModule;
        synchronized (VasLiveIPCModule.class) {
            if (sInstance == null) {
                sInstance = new VasLiveIPCModule("VasLiveIPCModule");
                QIPCClientHelper.getInstance().register(sInstance);
            }
            vasLiveIPCModule = sInstance;
        }
        return vasLiveIPCModule;
    }

    private void handleCloseDrawerAction(int i3, Bundle bundle) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrameHelperActivity.Gi()) {
                    FrameHelperActivity.gj(true, "VasLiveIPCModule");
                    FrameHelperActivity.Zh();
                }
            }
        });
        callbackResult(i3, EIPCResult.createResult(0, null));
    }

    private void handleEnterGroupAction(int i3, Bundle bundle) {
        boolean z16;
        String string = bundle.getString("groupUin");
        TroopManager troopManager = (TroopManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && troopManager.k(string) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((ILiveEnterGroupHostApi) QRoute.api(ILiveEnterGroupHostApi.class)).joinGroup(z16, string, "");
        callbackResult(i3, EIPCResult.createResult(0, null));
    }

    private void handleFollowAccountAction(final int i3, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString(KEY_ANCHOR_UIN);
            int i16 = bundle.getInt(KEY_FOLLOW_TYPE);
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (i16 == 1) {
                IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                iPublicAccountObserver.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.2
                    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
                    public void onFollowPublicAccount(boolean z16, String str) {
                        QLog.i("VasLiveIPCModule", 1, "onFollowPublicAccount issuccess = " + z16);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("ret", !z16 ? 1 : 0);
                        VasLiveIPCModule.this.callbackResult(i3, EIPCResult.createResult(0, bundle2));
                    }
                });
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(qQAppInterface, BaseApplication.getContext(), string, iPublicAccountObserver, false, 0, true);
            } else {
                IPublicAccountObserver iPublicAccountObserver2 = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
                iPublicAccountObserver2.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.mobileqq.vas.ipc.VasLiveIPCModule.3
                    @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
                    public void onUnfollowPublicAccount(boolean z16, String str) {
                        QLog.i("VasLiveIPCModule", 1, "onUnfollowPublicAccount issuccess = " + z16);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("ret", !z16 ? 1 : 0);
                        VasLiveIPCModule.this.callbackResult(i3, EIPCResult.createResult(0, bundle2));
                    }
                });
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(qQAppInterface, BaseApplication.getContext(), string, false, iPublicAccountObserver2, true);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("VasLiveIPCModule", 1, "handleFollowAccountAction exception = " + th5.getMessage());
        }
    }

    private void handleStayTimeInfo(int i3, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        a.b().a((ArrayList) bundle.getSerializable(KEY_STAY_INFO));
        callbackResult(i3, EIPCResult.createResult(0, null));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("VasLiveIPCModule", 2, "action:" + str);
        }
        if (ACTION_GET_ACCOUNT_NICK_NAME.equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(KEY_GET_ACCOUNT_NICK_NAME, getAccountName());
            callbackResult(i3, EIPCResult.createResult(0, bundle2));
            return null;
        }
        if (ACTION_FOLLOW_ACCOUNT.equals(str)) {
            handleFollowAccountAction(i3, bundle);
            return null;
        }
        if (ACTION_ENTER_GROUP.equals(str)) {
            handleEnterGroupAction(i3, bundle);
            return null;
        }
        if (ACTION_CLOSE_DRAWER.equals(str)) {
            handleCloseDrawerAction(i3, bundle);
            return null;
        }
        if (ACTION_REPORT_STAY_TIME.equals(str)) {
            handleStayTimeInfo(i3, bundle);
            return null;
        }
        new EIPCResult().data = bundle;
        return RemoteProxy.onCall(this, str, bundle, i3);
    }
}
