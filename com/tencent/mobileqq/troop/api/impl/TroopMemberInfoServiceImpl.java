package com.tencent.mobileqq.troop.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqnt.ITroopListTempApi;
import com.tencent.qqnt.ITroopMemberTempApi;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberInfoServiceImpl implements ITroopMemberInfoService, IKernelProfileListener {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopMemberInfoService";
    private BroadcastReceiver kernelInitCompleteListener;
    protected ArrayList<TroopInfo> mGetTroopMemberListTroops;
    protected int mRetryGetTroopMemberListCount;
    protected ArrayList<ITroopMemberInfoService.b> mTroopMemberUpdateObserverList;
    private com.tencent.mobileqq.troop.api.observer.b mTroopMngObserver;
    private y profileServiceHolder;
    private Map<Integer, com.tencent.mobileqq.troop.d> troopMemberListCallbackMap;
    protected WeakReference<AppRuntime> weakApp;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberInfoServiceImpl.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                TroopMemberInfoServiceImpl.this.handleOnTroopManagerSuccess(i3, i16, str);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements com.tencent.mobileqq.troop.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f294263a;

        b(String str) {
            this.f294263a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberInfoServiceImpl.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.troop.d
        public void a(Boolean bool, List<Object> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool, (Object) list);
                return;
            }
            TroopMemberInfoServiceImpl.this.troopMemberListCallbackMap.remove(Integer.valueOf(hashCode()));
            if (QLog.isDebugVersion()) {
                QLog.d(TroopMemberInfoServiceImpl.TAG, 4, "[fetchTroopMemberList back] " + TroopMemberInfoServiceImpl.this.debugPrintMemberListMap());
            }
            TroopMemberInfoServiceImpl.this.handleOnUpdateTroopGetMemberList(this.f294263a, bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberInfoServiceImpl.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            AppRuntime appRuntime = TroopMemberInfoServiceImpl.this.weakApp.get();
            if (appRuntime == null) {
                QLog.i(TroopMemberInfoServiceImpl.TAG, 1, "newKernelInitCompleteListener::onReceive, app is null");
                return;
            }
            IQQNTWrapperSession wrapperSession = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getWrapperSession();
            if (appRuntime.isLogin() && wrapperSession != null) {
                TroopMemberInfoServiceImpl.this.subscribeProfileServiceListener();
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("newKernelInitCompleteListener::onReceive, app is login? ");
            sb5.append(appRuntime.isLogin());
            sb5.append(", session is null? ");
            if (wrapperSession == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(TroopMemberInfoServiceImpl.TAG, 1, sb5.toString());
        }
    }

    public TroopMemberInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.weakApp = new WeakReference<>(null);
        this.mTroopMemberUpdateObserverList = new ArrayList<>();
        this.mGetTroopMemberListTroops = null;
        this.mRetryGetTroopMemberListCount = 0;
        this.kernelInitCompleteListener = null;
        this.profileServiceHolder = null;
        this.troopMemberListCallbackMap = new ConcurrentHashMap();
        this.mTroopMngObserver = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String debugPrintMemberListMap() {
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<Integer, com.tencent.mobileqq.troop.d> entry : this.troopMemberListCallbackMap.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append("---");
            sb5.append(entry.getValue());
            sb5.append("\n");
        }
        return sb5.toString();
    }

    private void fetchTroopMemberList(String str, String str2) {
        b bVar = new b(str);
        this.troopMemberListCallbackMap.put(Integer.valueOf(bVar.hashCode()), bVar);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[fetchTroopMemberList] " + debugPrintMemberListMap());
        }
        WeakReference<com.tencent.mobileqq.troop.d> weakReference = new WeakReference<>(bVar);
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberListUseWeakRef(str, true, "TroopMemberInfoService-" + str2, weakReference);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnTroopManagerSuccess(int i3, int i16, String str) {
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime == null) {
            return;
        }
        if (i3 != 2) {
            if (i3 != 4 && i3 != 6) {
                if (i3 != 9) {
                    return;
                }
            } else {
                TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
                if (findTroopInfo != null && com.tencent.mobileqq.troop.api.config.y.c(appRuntime, findTroopInfo, true)) {
                    synchronized (this) {
                        ArrayList<TroopInfo> arrayList = this.mGetTroopMemberListTroops;
                        if (arrayList == null) {
                            ArrayList<TroopInfo> arrayList2 = new ArrayList<>();
                            this.mGetTroopMemberListTroops = arrayList2;
                            arrayList2.add(findTroopInfo);
                            fetchTroopMemberList(str, "joinReq");
                        } else {
                            arrayList.add(findTroopInfo);
                        }
                    }
                    return;
                }
                return;
            }
        }
        ((ITroopMemberInfoService) appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).notifyQuitTroop(str);
        synchronized (this) {
            ArrayList<TroopInfo> arrayList3 = this.mGetTroopMemberListTroops;
            if (arrayList3 != null) {
                Iterator<TroopInfo> it = arrayList3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().troopuin.equals(str)) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnUpdateTroopGetMemberList(String str, boolean z16) {
        boolean z17;
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onUpdateTroopGetMemberList(memberLimit), troopUin:");
            sb5.append(str);
            sb5.append(", mGetTroopMemberListTroops == null:");
            if (this.mGetTroopMemberListTroops == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            sb5.append(z17);
            QLog.i(TAG, 2, sb5.toString());
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        ArrayList<TroopInfo> arrayList2 = this.mGetTroopMemberListTroops;
        if (arrayList2 == null) {
            ((ITroopMemberInfoService) appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate(arrayList);
            return;
        }
        if (arrayList2.size() > 0) {
            TroopInfo troopInfo = this.mGetTroopMemberListTroops.get(0);
            if (!troopInfo.troopuin.equals(str)) {
                return;
            }
            if (!z16) {
                int i3 = this.mRetryGetTroopMemberListCount;
                this.mRetryGetTroopMemberListCount = i3 + 1;
                if (i3 < 3) {
                    fetchTroopMemberList(troopInfo.troopuin, TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "getTroopsMemberList(memberLimit), failed, retry mRetryGetTroopMemberListCount:" + this.mRetryGetTroopMemberListCount + ", troopUin" + troopInfo.troopuin);
                        return;
                    }
                    return;
                }
                ((ITroopMemberInfoService) appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).notifyGetTroopMembersFailed(str);
            } else {
                ((ITroopMemberInfoService) appRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).notifyTroopMembersUpdate(arrayList);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "notifyTroopMembersUpdate, troopUin:" + str);
            }
            handlerUpdateNext();
        }
    }

    private void handlerUpdateNext() {
        synchronized (this) {
            this.mGetTroopMemberListTroops.remove(0);
        }
        if (this.mGetTroopMemberListTroops.size() > 0) {
            TroopInfo troopInfo = this.mGetTroopMemberListTroops.get(0);
            this.mRetryGetTroopMemberListCount = 0;
            fetchTroopMemberList(troopInfo.troopuin, "next");
        } else {
            synchronized (this) {
                this.mGetTroopMemberListTroops = null;
            }
        }
    }

    private BroadcastReceiver newKernelInitCompleteListener() {
        return new c();
    }

    private void notifyChangeMemberRemark(String str, String str2) {
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).c(str, str2);
        }
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
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime == null) {
            return false;
        }
        y profileService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e(TAG, 1, "subscribeProfileServiceListener error, profileService is null!");
            return false;
        }
        this.profileServiceHolder = profileService;
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
        y yVar = this.profileServiceHolder;
        if (yVar != null) {
            yVar.D0(this);
            this.profileServiceHolder = null;
        }
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime == null) {
            return false;
        }
        y profileService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getProfileService();
        if (profileService == null) {
            QLog.e(TAG, 1, "unsubscribeProfileServiceListener error, profileService is null!");
            return false;
        }
        profileService.D0(this);
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public synchronized void addTroopMemberUpdateObserver(ITroopMemberInfoService.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        QLog.i(TAG, 1, "addTroopMemberUpdateObserver, " + bVar);
        this.mTroopMemberUpdateObserverList.add(bVar);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    @Deprecated
    public boolean deleteTroopMember(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? deleteTroopMember(str, str2, true) : ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2)).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public TroopMemberInfo getTroopMemberFromCacheOrFetchAsync(String str, String str2, String str3, ITroopMemberInfoService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 14, this, str, str2, str3, aVar);
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z16 = false;
        }
        Object troopMemberFromCacheOrFetchAsync = ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).getTroopMemberFromCacheOrFetchAsync(str, str2, null, str3, new com.tencent.mobileqq.troop.c(z16, aVar) { // from class: com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.2
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f294253a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ITroopMemberInfoService.a f294254b;

            {
                this.f294253a = z16;
                this.f294254b = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopMemberInfoServiceImpl.this, Boolean.valueOf(z16), aVar);
                }
            }

            @Override // com.tencent.mobileqq.troop.c
            public void a(Object obj) {
                TroopMemberInfo troopMemberInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, obj);
                    return;
                }
                if (obj instanceof TroopMemberInfo) {
                    troopMemberInfo = (TroopMemberInfo) obj;
                } else {
                    troopMemberInfo = null;
                }
                if (this.f294253a) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(troopMemberInfo) { // from class: com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TroopMemberInfo f294256d;

                        {
                            this.f294256d = troopMemberInfo;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) troopMemberInfo);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass2.this.f294254b.a(this.f294256d);
                            }
                        }
                    });
                } else {
                    this.f294254b.a(troopMemberInfo);
                }
            }
        });
        if (troopMemberFromCacheOrFetchAsync instanceof TroopMemberInfo) {
            return (TroopMemberInfo) troopMemberFromCacheOrFetchAsync;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void getTroopMemberInfoAsync(String str, String str2, String str3, ITroopMemberInfoService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, str3, aVar);
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z16 = false;
        }
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoFromDB(str, str2, null, str3, new com.tencent.mobileqq.troop.c(z16, aVar) { // from class: com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f294258a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ITroopMemberInfoService.a f294259b;

            {
                this.f294258a = z16;
                this.f294259b = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopMemberInfoServiceImpl.this, Boolean.valueOf(z16), aVar);
                }
            }

            @Override // com.tencent.mobileqq.troop.c
            public void a(Object obj) {
                TroopMemberInfo troopMemberInfo;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, obj);
                    return;
                }
                if (obj instanceof TroopMemberInfo) {
                    troopMemberInfo = (TroopMemberInfo) obj;
                } else {
                    troopMemberInfo = null;
                }
                if (this.f294258a) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(troopMemberInfo) { // from class: com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.3.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TroopMemberInfo f294261d;

                        {
                            this.f294261d = troopMemberInfo;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) troopMemberInfo);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass3.this.f294259b.a(this.f294261d);
                            }
                        }
                    });
                } else {
                    this.f294259b.a(troopMemberInfo);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void getTroopsMemberList() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.mGetTroopMemberListTroops != null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "getTroopsMemberList(memberLimit), last getTroopsMemberList(int memberLimit) is not finished.");
                return;
            }
            return;
        }
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime == null) {
            return;
        }
        ArrayList<?> sortedJoinedTroopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getSortedJoinedTroopInfoFromCache();
        if (sortedJoinedTroopInfoFromCache == null) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "getTroopsMemberList(memberLimit), troopList is null");
                return;
            }
            return;
        }
        this.mGetTroopMemberListTroops = new ArrayList<>();
        if (sortedJoinedTroopInfoFromCache.size() > 0) {
            i3 = 0;
            i16 = 0;
            for (int i17 = 0; i17 < sortedJoinedTroopInfoFromCache.size(); i17++) {
                TroopInfo troopInfo = (TroopInfo) sortedJoinedTroopInfoFromCache.get(i17);
                if (com.tencent.mobileqq.troop.api.config.y.c(appRuntime, troopInfo, false)) {
                    synchronized (this) {
                        this.mGetTroopMemberListTroops.add(troopInfo);
                        i3++;
                        i16 += troopInfo.wMemberNum;
                    }
                }
            }
            if (this.mGetTroopMemberListTroops.size() > 0) {
                fetchTroopMemberList(this.mGetTroopMemberListTroops.get(0).troopuin, "start");
            } else {
                this.mGetTroopMemberListTroops = null;
            }
        } else {
            this.mGetTroopMemberListTroops = null;
            i3 = 0;
            i16 = 0;
        }
        if (i3 > 0) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("reqUin", appRuntime.getCurrentUin());
            hashMap.put("tpNum", String.valueOf(i3));
            hashMap.put("tpMemNum", String.valueOf(i16));
            hashMap.put("isFirst", String.valueOf(appRuntime.getApp().getSharedPreferences(appRuntime.getCurrentAccountUin(), 0).getInt(ITroopMemberInfoService.IS_FIRST_UPGRADE_TO_500, 0)));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(appRuntime.getCurrentAccountUin(), StatisticCollector.TROOP_MEMBER_SEARCH_UPDATE_REQ, false, 0L, 0L, hashMap, "");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyChangeMember(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).b(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyChangeMemberWithInfo(String str, List<TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) list);
            return;
        }
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).e(str, list);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyFriendRemarkChange(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
        } else {
            notifyChangeMemberRemark(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyGetTroopMembersFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).a(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyKickoutMember(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).f(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyQuitTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).d(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public void notifyTroopMembersUpdate(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList);
            return;
        }
        for (int i3 = 0; i3 < this.mTroopMemberUpdateObserverList.size(); i3++) {
            this.mTroopMemberUpdateObserverList.get(i3).g(arrayList);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        QLog.i(TAG, 1, "TroopMemberInfoServiceImpl onCreate");
        this.weakApp = new WeakReference<>(appRuntime);
        ((AppInterface) appRuntime).addObserver(this.mTroopMngObserver, true);
        if (!subscribeProfileServiceListener()) {
            registerKernelListener();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.troopMemberListCallbackMap.clear();
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "[onDestroy] " + debugPrintMemberListMap());
        }
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime != null) {
            ((AppInterface) appRuntime).removeObserver(this.mTroopMngObserver);
        }
        unregisterKernelListener();
        unsubscribeProfileServiceListener();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) hashMap);
            return;
        }
        com.tencent.mobileqq.util.p.a("Troop::onStrangerRemarkChanged", hashMap);
        for (Map.Entry<String, CoreInfo> entry : hashMap.entrySet()) {
            notifyChangeMemberRemark(String.valueOf(entry.getValue().uin), entry.getValue().remark);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
    public /* synthetic */ void onUserDetailInfoChanged(UserDetailInfo userDetailInfo) {
        be.f(this, userDetailInfo);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    public synchronized void removeTroopMemberUpdateObserver(ITroopMemberInfoService.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
            return;
        }
        QLog.i(TAG, 1, "removeTroopMemberUpdateObserver, " + bVar);
        this.mTroopMemberUpdateObserverList.remove(bVar);
    }

    @Deprecated
    public void saveTroopMemberInfoInLruCache(String str, String str2, TroopMemberInfo troopMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, troopMemberInfo);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService
    @Deprecated
    public boolean deleteTroopMember(String str, String str2, boolean z16) {
        ITroopHandlerService iTroopHandlerService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, str, str2, Boolean.valueOf(z16))).booleanValue();
        }
        AppRuntime appRuntime = this.weakApp.get();
        if (appRuntime == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteTroopMember, troopUin=" + str + ",memberUin=" + str2 + ",updateHeadAndName=" + z16);
        }
        ((ITroopMemberTempApi) QRoute.api(ITroopMemberTempApi.class)).deleteTroopMemberCache(str, str2);
        notifyKickoutMember(str, str2);
        if (z16 && (iTroopHandlerService = (ITroopHandlerService) appRuntime.getRuntimeService(ITroopHandlerService.class, "")) != null) {
            iTroopHandlerService.handleMemberExit(str, str2);
        }
        return true;
    }
}
