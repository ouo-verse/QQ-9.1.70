package com.tencent.raft.raftframework.declare;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.raftframework.log.RLog;
import com.tencent.raft.raftframework.service.api.IServiceEntry;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RADeclareManager implements IRADeclareManager {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RADeclareManager";
    private Map<String, String> mDeclareConstants;
    private Map<String, Object> mDeclareServiceCache;
    private Map<String, IServiceEntry> mServiceEntryMap;

    public RADeclareManager(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mDeclareServiceCache = new HashMap();
        this.mServiceEntryMap = new HashMap();
        this.mDeclareConstants = new HashMap();
        init(str);
    }

    private void init(String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (Map.Entry entry : ((Map) cls.getDeclaredField("sDeclareMap").get(null)).entrySet()) {
                String str2 = (String) entry.getKey();
                IServiceEntry iServiceEntry = (IServiceEntry) entry.getValue();
                IServiceEntry iServiceEntry2 = this.mServiceEntryMap.get(str2);
                if (iServiceEntry2 == null) {
                    this.mServiceEntryMap.put(str2, iServiceEntry);
                } else if (iServiceEntry2.getPriority() < iServiceEntry.getPriority()) {
                    this.mServiceEntryMap.put(str2, iServiceEntry);
                }
            }
            for (Map.Entry entry2 : ((Map) cls.getDeclaredField("sConstantMap").get(null)).entrySet()) {
                String str3 = (String) entry2.getKey();
                String str4 = (String) entry2.getValue();
                if (!this.mDeclareConstants.containsKey(str3)) {
                    this.mDeclareConstants.put(str3, str4);
                }
            }
            RLog.d(TAG, "init success :" + this.mServiceEntryMap);
        } catch (Exception e16) {
            RLog.w(TAG, "init entryMap error :" + e16);
        }
    }

    @Override // com.tencent.raft.raftframework.declare.IRADeclareManager
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mDeclareServiceCache.clear();
        this.mServiceEntryMap.clear();
        this.mDeclareConstants.clear();
    }

    @Override // com.tencent.raft.raftframework.declare.IRADeclareManager
    public String getDeclareConstant(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return this.mDeclareConstants.get(str);
    }

    @Override // com.tencent.raft.raftframework.declare.IRADeclareManager
    public Object getDeclareService(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (this.mDeclareServiceCache.containsKey(str)) {
            return this.mDeclareServiceCache.get(str);
        }
        IServiceEntry iServiceEntry = this.mServiceEntryMap.get(str);
        if (iServiceEntry == null) {
            RLog.w(TAG, "cannot found declare >> " + str);
            return null;
        }
        Object obj = iServiceEntry.createService().service;
        this.mDeclareServiceCache.put(str, obj);
        return obj;
    }
}
