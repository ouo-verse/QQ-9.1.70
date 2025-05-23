package com.tencent.mobileqq.search.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IUserRemarkService;
import com.tencent.mobileqq.util.p;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UserRemarkServiceImpl implements IUserRemarkService, IKernelProfileListener {
    private static final String TAG = "UserRemarkServiceImpl";
    private AppRuntime app;
    private final ThreadLocal<ArrayList<String>> threadUid = new b();
    private final ConcurrentHashMap<String, CoreInfo> strangerRemarksLookup = new ConcurrentHashMap<>();
    private BroadcastReceiver kernelInitCompleteListener = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16;
            if (UserRemarkServiceImpl.this.app == null) {
                QLog.i(UserRemarkServiceImpl.TAG, 1, "newKernelInitCompleteListener::onReceive, app is null");
                return;
            }
            IQQNTWrapperSession wrapperSession = ((IKernelService) UserRemarkServiceImpl.this.app.getRuntimeService(IKernelService.class, "")).getWrapperSession();
            if (UserRemarkServiceImpl.this.app.isLogin() && wrapperSession != null) {
                UserRemarkServiceImpl.this.subscribeProfileServiceListener();
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("newKernelInitCompleteListener::onReceive, app is login? ");
            sb5.append(UserRemarkServiceImpl.this.app.isLogin());
            sb5.append(", session is null? ");
            if (wrapperSession == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(UserRemarkServiceImpl.TAG, 1, sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class b extends ThreadLocal<ArrayList<String>> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<String> initialValue() {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
    }

    private BroadcastReceiver newKernelInitCompleteListener() {
        return new a();
    }

    private void registerKernelListener() {
        try {
            IntentFilter intentFilter = new IntentFilter("com.tencent.mobileqq.action.ON_KERNEL_INIT_COMPLETE");
            BaseApplication context = BaseApplication.getContext();
            BroadcastReceiver newKernelInitCompleteListener = newKernelInitCompleteListener();
            this.kernelInitCompleteListener = newKernelInitCompleteListener;
            context.registerReceiver(newKernelInitCompleteListener, intentFilter);
            QLog.i(TAG, 1, "register KernelInitCompleteListener");
        } catch (Exception e16) {
            QLog.i(TAG, 1, "registerReceiver", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean subscribeProfileServiceListener() {
        y profileService = ((IKernelService) this.app.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e(TAG, 1, "subscribeProfileServiceListener error, profileService is null!");
            return false;
        }
        profileService.r0(this);
        return true;
    }

    private void unregisterKernelListener() {
        try {
            if (this.kernelInitCompleteListener != null) {
                BaseApplication.getContext().unregisterReceiver(this.kernelInitCompleteListener);
                QLog.i(TAG, 1, "unregister KernelInitCompleteListener");
            } else {
                QLog.i(TAG, 1, "unregister KernelInitCompleteListener, no need unregister");
            }
            this.kernelInitCompleteListener = null;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "unregisterKernelListener", e16);
        }
    }

    private boolean unsubscribeProfileServiceListener() {
        y profileService = ((IKernelService) this.app.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e(TAG, 1, "unsubscribeProfileServiceListener error, profileService is null!");
            return false;
        }
        profileService.D0(this);
        return true;
    }

    @Override // com.tencent.mobileqq.search.api.IUserRemarkService
    public List<CoreInfo> getExistStrangerRemarks() {
        return new ArrayList(this.strangerRemarksLookup.values());
    }

    @Override // com.tencent.mobileqq.search.api.IUserRemarkService
    public String getStrangerRemarkByUid(String str) {
        AppRuntime appRuntime;
        ArrayList<String> arrayList;
        CoreInfo coreInfo;
        if (!TextUtils.isEmpty(str) && (appRuntime = this.app) != null) {
            y profileService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getProfileService();
            if (profileService == null || (arrayList = this.threadUid.get()) == null) {
                return "";
            }
            arrayList.set(0, str);
            HashMap<String, CoreInfo> coreInfo2 = profileService.getCoreInfo("UserRemarkServiceImpl::getStrangerRemarkByUid", arrayList);
            if (coreInfo2 == null || (coreInfo = coreInfo2.get(str)) == null || TextUtils.isEmpty(coreInfo.remark)) {
                return "";
            }
            return coreInfo.remark;
        }
        QLog.w(TAG, 1, "getStrangerRemarkByUid(" + str + ") check args fail, return empty!");
        return "";
    }

    @Override // com.tencent.mobileqq.search.api.IUserRemarkService
    public String getStrangerRemarkByUin(String str) {
        AppRuntime appRuntime;
        y profileService;
        ArrayList<String> arrayList;
        CoreInfo coreInfo;
        if (str == null || (appRuntime = this.app) == null || (profileService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getProfileService()) == null) {
            return "";
        }
        CoreInfo coreInfo2 = this.strangerRemarksLookup.get(str);
        if (coreInfo2 == null) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            if (TextUtils.isEmpty(uidFromUin) || (arrayList = this.threadUid.get()) == null) {
                return "";
            }
            arrayList.set(0, uidFromUin);
            HashMap<String, CoreInfo> coreInfo3 = profileService.getCoreInfo(TAG, arrayList);
            if (coreInfo3 == null || (coreInfo = coreInfo3.get(uidFromUin)) == null || TextUtils.isEmpty(coreInfo.remark)) {
                return "";
            }
            return coreInfo.remark;
        }
        return coreInfo2.remark;
    }

    @Override // com.tencent.mobileqq.search.api.IUserRemarkService
    public Map<String, String> getStrangerRemarksByUids(List<String> list) {
        AppRuntime appRuntime;
        if (list != null && !list.isEmpty() && (appRuntime = this.app) != null) {
            y profileService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getProfileService();
            if (profileService == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            HashMap<String, CoreInfo> coreInfo = profileService.getCoreInfo("UserRemarkServiceImpl::getStrangerRemarksByUids", new ArrayList<>(list));
            if (coreInfo == null) {
                return Collections.emptyMap();
            }
            for (Map.Entry<String, CoreInfo> entry : coreInfo.entrySet()) {
                if (entry.getValue() == null) {
                    String str = "getStrangerRemarksByUids " + entry.getKey() + " NPE";
                    s.e(TAG, str, new NullPointerException(str));
                } else {
                    hashMap.put(entry.getValue().uid, entry.getValue().remark);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 1, "UserRemarkServiceImpl::onCreate");
        this.app = appRuntime;
        if (!subscribeProfileServiceListener()) {
            registerKernelListener();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        if (this.app != null) {
            unregisterKernelListener();
            unsubscribeProfileServiceListener();
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onProfileSimpleChanged(HashMap hashMap) {
        be.a(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onSelfStatusChanged(StatusInfo statusInfo) {
        be.b(this, statusInfo);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
        be.c(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onStatusUpdate(HashMap hashMap) {
        be.d(this, hashMap);
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public void onStrangerRemarkChanged(HashMap<String, CoreInfo> hashMap) {
        p.a("UserRemarkServiceImpl::onStrangerRemarkChanged", hashMap);
        for (Map.Entry<String, CoreInfo> entry : hashMap.entrySet()) {
            this.strangerRemarksLookup.put(String.valueOf(entry.getValue().uin), entry.getValue());
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onUserDetailInfoChanged(UserDetailInfo userDetailInfo) {
        be.f(this, userDetailInfo);
    }
}
