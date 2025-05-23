package com.tencent.raft.codegenmeta.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RAServiceMetaCenter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RAServiceMetaCenter";
    public Map<String, String> mClassToServiceNameMap;
    public Map<String, RAServiceMeta> mServiceNameToMetaMap;

    public RAServiceMetaCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mClassToServiceNameMap = new ConcurrentHashMap();
            this.mServiceNameToMetaMap = new ConcurrentHashMap();
        }
    }

    public RAServiceMeta getServiceMeta(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RAServiceMeta) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        String str2 = this.mClassToServiceNameMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return this.mServiceNameToMetaMap.get(str2);
    }

    public synchronized void init(List<Map<String, Object>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        if (list != null) {
            for (Map<String, Object> map : list) {
                RAServiceMeta rAServiceMeta = new RAServiceMeta();
                rAServiceMeta.parse(map);
                String serviceKey = rAServiceMeta.getServiceKey();
                this.mServiceNameToMetaMap.put(serviceKey, rAServiceMeta);
                if (!TextUtils.isEmpty(rAServiceMeta.getServiceKey())) {
                    this.mClassToServiceNameMap.put(rAServiceMeta.getServiceKey(), serviceKey);
                }
                Iterator<String> it = rAServiceMeta.interfaces.iterator();
                while (it.hasNext()) {
                    this.mClassToServiceNameMap.put(it.next(), serviceKey);
                }
            }
        }
    }
}
