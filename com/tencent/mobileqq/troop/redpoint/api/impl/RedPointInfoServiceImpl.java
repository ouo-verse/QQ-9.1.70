package com.tencent.mobileqq.troop.redpoint.api.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.redpoint.a;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.mobileqq.troop.redpoint.b;
import com.tencent.mobileqq.troop.redpoint.c;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class RedPointInfoServiceImpl implements IRedPointInfoService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RedPointInfoServiceImpl";
    private HashSet<a> listeners;
    private AppRuntime mApp;
    private ConcurrentHashMap<String, b> mRedPointInfoCache;

    public RedPointInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.listeners = new HashSet<>();
            this.mRedPointInfoCache = new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRedPointInfoChanged(String str, String str2, b bVar, HashSet<Integer> hashSet) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && bVar != null && hashSet != null && !hashSet.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyRedPointInfoChanged : uin = " + str + ", uinType = " + str2 + ", changedIdSet = " + hashSet.toString());
            }
            HashSet<a> hashSet2 = this.listeners;
            if (hashSet2 != null) {
                Iterator<a> it = hashSet2.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a(1, new Object[]{str, str2, bVar, hashSet});
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void addRedPointListener(c cVar) {
        HashSet<a> hashSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addRedPointListener");
        }
        if (cVar != null && (hashSet = this.listeners) != null && !hashSet.contains(cVar)) {
            this.listeners.add(cVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void cleanRedPointInfoById(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cleanRedPointInfoById : uin = " + str + ", uinType = " + str2 + ", redId = " + i3);
        }
        updateRedPointInfo(str, str2, i3, 0);
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void cleanRedPointInfoByIds(String str, String str2, List<Integer> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, list);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cleanRedPointInfoByIds : uin = " + str + ", uinType = " + str2 + ", redPointIdList = " + list.toString());
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), 0);
            }
            updateRedPointInfos(str, str2, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public b getRedPointInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getRedPointInfo : uin = " + str + ", uinType = " + str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + str2;
            if (!this.mRedPointInfoCache.containsKey(str3)) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getRedPointInfo : mRedPointInfoCache ContainKey :" + str3);
            }
            return this.mRedPointInfoCache.get(str3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getRedPointInfo args error!");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void notifyRedPointViewClick(String str, String str2, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, view);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && view != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyRedPointViewClick : uin = " + str + ", uinType = " + str2);
            }
            HashSet<a> hashSet = this.listeners;
            if (hashSet != null) {
                Iterator<a> it = hashSet.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null) {
                        next.a(2, new Object[]{str, str2, view});
                    }
                }
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        HashSet<a> hashSet = this.listeners;
        if (hashSet != null) {
            hashSet.clear();
        }
        this.mRedPointInfoCache.clear();
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void removeRedPointListener(c cVar) {
        HashSet<a> hashSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addRedPointListener");
        }
        if (cVar != null && (hashSet = this.listeners) != null && hashSet.contains(cVar)) {
            this.listeners.remove(cVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void updateRedPointInfo(String str, String str2, int i3, int i16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateRedPointInfo : uin = " + str + ", uinType = " + str2 + ", unReadNum = " + i16);
            }
            String str3 = str + str2;
            if (this.mRedPointInfoCache.get(str3) == null) {
                b bVar2 = new b();
                bVar2.f298268a = str;
                bVar2.f298269b = str2;
                bVar = bVar2;
                z16 = false;
            } else {
                bVar = this.mRedPointInfoCache.get(str3);
            }
            boolean c16 = bVar.c(i3, i16);
            if (z16) {
                if (bVar.b()) {
                    this.mRedPointInfoCache.remove(str3);
                }
            } else if (!bVar.b()) {
                this.mRedPointInfoCache.put(str3, bVar);
            }
            if (c16) {
                ThreadManager.getUIHandler().post(new Runnable(i3, str, str2, bVar) { // from class: com.tencent.mobileqq.troop.redpoint.api.impl.RedPointInfoServiceImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f298260d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f298261e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f298262f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ b f298263h;

                    {
                        this.f298260d = i3;
                        this.f298261e = str;
                        this.f298262f = str2;
                        this.f298263h = bVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, RedPointInfoServiceImpl.this, Integer.valueOf(i3), str, str2, bVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        HashSet<Integer> hashSet = new HashSet<Integer>() { // from class: com.tencent.mobileqq.troop.redpoint.api.impl.RedPointInfoServiceImpl.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }
                        };
                        hashSet.add(Integer.valueOf(this.f298260d));
                        RedPointInfoServiceImpl.this.notifyRedPointInfoChanged(this.f298261e, this.f298262f, this.f298263h, hashSet);
                    }
                });
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateRedPointInfo uin error!");
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService
    public void updateRedPointInfos(String str, String str2, HashMap<Integer, Integer> hashMap) {
        b bVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, hashMap);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hashMap != null && !hashMap.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateRedPointInfos : uin = " + str + ", uinType = " + str2 + ",redPointIdMap = " + hashMap.toString());
            }
            String str3 = str + str2;
            if (this.mRedPointInfoCache.get(str3) == null) {
                bVar = new b();
                bVar.f298268a = str;
                bVar.f298269b = str2;
                z16 = false;
            } else {
                bVar = this.mRedPointInfoCache.get(str3);
                z16 = true;
            }
            b bVar2 = bVar;
            boolean d16 = bVar2.d(hashMap);
            if (z16) {
                if (bVar2.b()) {
                    this.mRedPointInfoCache.remove(str3);
                }
            } else if (!bVar2.b()) {
                this.mRedPointInfoCache.put(str3, bVar2);
            }
            if (d16) {
                ThreadManager.getUIHandler().post(new Runnable(hashMap, str, str2, bVar2) { // from class: com.tencent.mobileqq.troop.redpoint.api.impl.RedPointInfoServiceImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ HashMap f298264d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f298265e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f298266f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ b f298267h;

                    {
                        this.f298264d = hashMap;
                        this.f298265e = str;
                        this.f298266f = str2;
                        this.f298267h = bVar2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, RedPointInfoServiceImpl.this, hashMap, str, str2, bVar2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        HashSet<Integer> hashSet = new HashSet<Integer>() { // from class: com.tencent.mobileqq.troop.redpoint.api.impl.RedPointInfoServiceImpl.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }
                        };
                        Iterator it = this.f298264d.entrySet().iterator();
                        while (it.hasNext()) {
                            hashSet.add((Integer) ((Map.Entry) it.next()).getKey());
                        }
                        RedPointInfoServiceImpl.this.notifyRedPointInfoChanged(this.f298265e, this.f298266f, this.f298267h, hashSet);
                    }
                });
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateRedPointInfos troopUin error!");
        }
    }
}
