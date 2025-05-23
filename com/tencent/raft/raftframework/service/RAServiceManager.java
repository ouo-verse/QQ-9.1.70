package com.tencent.raft.raftframework.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.raftframework.IServiceProvider;
import com.tencent.raft.raftframework.constant.RAFTConstants;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import com.tencent.raft.raftframework.service.api.ServiceWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RAServiceManager implements IRAServiceManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RAServiceManager";
    private HashMap<Class<?>, IServiceEntry> mServiceEntryMap;
    private HashMap<String, Object> mSingletonMap;
    private HashMap<String, WeakReference<Object>> mWeakSingletonMap;

    public RAServiceManager(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mServiceEntryMap = new HashMap<>();
        this.mSingletonMap = new HashMap<>();
        this.mWeakSingletonMap = new HashMap<>();
        init(str);
    }

    private Object getFromCache(String str) {
        WeakReference<Object> weakReference;
        if (this.mSingletonMap.containsKey(str)) {
            return this.mSingletonMap.get(str);
        }
        if (this.mWeakSingletonMap.containsKey(str) && (weakReference = this.mWeakSingletonMap.get(str)) != null && weakReference.get() != null) {
            return weakReference.get();
        }
        return null;
    }

    private void init(String str) {
        RLog.d(TAG, "init ...");
        try {
            for (Map.Entry entry : ((Map) Class.forName(str).getDeclaredField("sServicesMap").get(null)).entrySet()) {
                Class<?> cls = (Class) entry.getKey();
                IServiceEntry iServiceEntry = (IServiceEntry) entry.getValue();
                IServiceEntry iServiceEntry2 = this.mServiceEntryMap.get(cls);
                if (iServiceEntry2 == null) {
                    this.mServiceEntryMap.put(cls, iServiceEntry);
                } else if (iServiceEntry2.getPriority() <= iServiceEntry.getPriority()) {
                    this.mServiceEntryMap.put(cls, iServiceEntry);
                }
            }
            RLog.d(TAG, "init success :" + this.mServiceEntryMap);
        } catch (Exception e16) {
            RLog.w(TAG, "init entryMap error :" + e16);
        }
    }

    private void putToCache(String str, ServiceWrapper serviceWrapper) {
        RAFTConstants.Scope scope = serviceWrapper.scope;
        if (scope != RAFTConstants.Scope.SINGLETON && scope != RAFTConstants.Scope.LAZY_SINGLETON) {
            if (scope == RAFTConstants.Scope.WEAK_SINGLETON) {
                this.mWeakSingletonMap.put(str, new WeakReference<>(serviceWrapper.service));
                return;
            }
            return;
        }
        this.mSingletonMap.put(str, serviceWrapper.service);
    }

    @Override // com.tencent.raft.raftframework.service.IRAServiceManager
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mServiceEntryMap.clear();
        this.mSingletonMap.clear();
        this.mWeakSingletonMap.clear();
    }

    @Override // com.tencent.raft.raftframework.service.IRAServiceManager
    public <T> T getService(Class<T> cls, IServiceProvider iServiceProvider) {
        ServiceWrapper createService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls, (Object) iServiceProvider);
        }
        IServiceEntry iServiceEntry = this.mServiceEntryMap.get(cls);
        if (iServiceEntry == null) {
            RLog.w(TAG, "getService error :cannot found entry >> " + cls.getName());
            return null;
        }
        String key = iServiceEntry.getKey();
        T t16 = (T) getFromCache(key);
        if (t16 != null) {
            return t16;
        }
        if (iServiceProvider != null) {
            createService = iServiceProvider.provide();
        } else {
            createService = iServiceEntry.createService();
        }
        putToCache(key, createService);
        return (T) createService.service;
    }
}
