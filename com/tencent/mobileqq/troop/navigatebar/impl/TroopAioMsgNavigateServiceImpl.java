package com.tencent.mobileqq.troop.navigatebar.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsg;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsgCollection;
import com.tencent.mobileqq.troop.navigatebar.e;
import com.tencent.mobileqq.troop.navigatebar.i;
import com.tencent.mobileqq.troop.navigatebar.network.b;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioMsgNavigateServiceImpl implements ITroopAioMsgNavigateService {
    static IPatchRedirector $redirector_ = null;
    private static final String SP_FILE_NAME = "troop_nav_sp";
    private static final String TAG = "TroopAioMsgNavigateServiceImpl";
    private String mLastCookie;
    private b mNavMsgReqObserver;
    private BroadcastReceiver mReceiver;
    private ConcurrentHashMap<String, HashSet<Long>> mRevokeMsgCachedMap;
    private CopyOnWriteArraySet<ITroopAioMsgNavigateService.a> mRevokeNavMsgCallbacks;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAioMsgNavigateServiceImpl.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if (NewIntent.ACTION_LOGOUT.equals(intent.getAction())) {
                com.tencent.mobileqq.troop.navigatebar.expriment.a.f();
            }
        }
    }

    public TroopAioMsgNavigateServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOfflineNavMsgAsync(@NonNull List<TroopAioNavMsgCollection> list) {
        HashSet<Long> hashSet;
        i iVar = new i();
        TroopAioNavigateBarManager b16 = iVar.b();
        int i3 = 0;
        for (TroopAioNavMsgCollection troopAioNavMsgCollection : list) {
            if (troopAioNavMsgCollection.msgList != null) {
                ConcurrentHashMap<String, HashSet<Long>> concurrentHashMap = this.mRevokeMsgCachedMap;
                if (concurrentHashMap == null) {
                    hashSet = null;
                } else {
                    hashSet = concurrentHashMap.get(troopAioNavMsgCollection.troopId);
                }
                if (hashSet != null && !hashSet.isEmpty()) {
                    for (TroopAioNavMsg troopAioNavMsg : troopAioNavMsgCollection.msgList) {
                        if (!hashSet.contains(Long.valueOf(troopAioNavMsg.msgSeq))) {
                            i3++;
                            e.a(b16, troopAioNavMsg);
                        }
                    }
                } else {
                    Iterator<TroopAioNavMsg> it = troopAioNavMsgCollection.msgList.iterator();
                    while (it.hasNext()) {
                        i3++;
                        e.a(b16, it.next());
                    }
                }
            }
        }
        if (i3 > 0) {
            iVar.a();
        }
    }

    private String getSpKeyName() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        return "nv2-" + peekAppRuntime.getCurrentUin();
    }

    private void initAndAddObserver() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        this.mNavMsgReqObserver = new b(peekAppRuntime);
        this.mRevokeMsgCachedMap = new ConcurrentHashMap<>();
        this.mRevokeNavMsgCallbacks = new CopyOnWriteArraySet<>();
        ((AppInterface) peekAppRuntime).addObserver(this.mNavMsgReqObserver);
        if (this.mReceiver == null) {
            this.mReceiver = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        try {
            MobileQQ.sMobileQQ.registerReceiver(this.mReceiver, intentFilter);
        } catch (AssertionError e16) {
            QLog.d(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public String getLastCookie() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return null;
        }
        String spKeyName = getSpKeyName();
        if (TextUtils.isEmpty(spKeyName)) {
            return null;
        }
        if (this.mLastCookie == null) {
            this.mLastCookie = cl.e(BaseApplication.getContext(), SP_FILE_NAME, spKeyName);
        }
        return this.mLastCookie;
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public void notifyTroopRevokeNavMsg(String str, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) list);
        } else {
            if (this.mRevokeNavMsgCallbacks.isEmpty()) {
                return;
            }
            Iterator<ITroopAioMsgNavigateService.a> it = this.mRevokeNavMsgCallbacks.iterator();
            while (it.hasNext()) {
                it.next().a(str, list);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            initAndAddObserver();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mRevokeMsgCachedMap = null;
        b bVar = this.mNavMsgReqObserver;
        if (bVar != null) {
            bVar.e();
        }
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            MobileQQ.sMobileQQ.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public void registerTroopRevokeNavMsgCallback(ITroopAioMsgNavigateService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            if (aVar == null) {
                return;
            }
            if (this.mRevokeNavMsgCallbacks == null) {
                this.mRevokeNavMsgCallbacks = new CopyOnWriteArraySet<>();
            }
            this.mRevokeNavMsgCallbacks.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public void saveLastCookie(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String spKeyName = getSpKeyName();
        if (TextUtils.isEmpty(spKeyName)) {
            return;
        }
        this.mLastCookie = str;
        cl.k(BaseApplication.getContext(), SP_FILE_NAME, spKeyName, str);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public void unRegisterTroopRevokeNavMsgCallback(ITroopAioMsgNavigateService.a aVar) {
        CopyOnWriteArraySet<ITroopAioMsgNavigateService.a> copyOnWriteArraySet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else if (aVar != null && (copyOnWriteArraySet = this.mRevokeNavMsgCallbacks) != null) {
            copyOnWriteArraySet.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public void updateTroopNavMsgCollection(@NonNull List<TroopAioNavMsgCollection> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        QLog.d(TAG, 1, "updateTroopNavMsgCollection, size : ", Integer.valueOf(list.size()));
        if (list.isEmpty() || !com.tencent.mobileqq.troop.navigatebar.expriment.a.c()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(list) { // from class: com.tencent.mobileqq.troop.navigatebar.impl.TroopAioMsgNavigateServiceImpl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f298002d;

            {
                this.f298002d = list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAioMsgNavigateServiceImpl.this, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopAioMsgNavigateServiceImpl.this.addOfflineNavMsgAsync(this.f298002d);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService
    public void updateTroopRevokeMsg(ArrayMap<String, List<Long>> arrayMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayMap);
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null || !com.tencent.mobileqq.troop.navigatebar.expriment.a.c()) {
            return;
        }
        if (this.mRevokeMsgCachedMap == null) {
            this.mRevokeMsgCachedMap = new ConcurrentHashMap<>();
        }
        for (String str : arrayMap.keySet()) {
            HashSet<Long> hashSet = this.mRevokeMsgCachedMap.get(str);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.mRevokeMsgCachedMap.put(str, hashSet);
            }
            hashSet.addAll(arrayMap.get(str));
        }
    }
}
