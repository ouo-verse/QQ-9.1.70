package com.tencent.raft.codegenmeta.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RaftConfigsMeta {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RaftConfigsMeta";
    private final Map<String, RaftConfigService> mConfigServices;
    private Map<String, Object> mDeclareBasics;
    private Map<String, Object> mDeclareCloud;
    private final LinkedHashMap<String, RaftConfigService> mDeclaresServices;

    public RaftConfigsMeta() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mConfigServices = new HashMap(64);
        this.mDeclaresServices = new LinkedHashMap<>(32);
        this.mDeclareBasics = new HashMap(32);
        this.mDeclareCloud = new HashMap(32);
    }

    private Map<String, Object> findMethodArgMap(RaftConfigService raftConfigService, String str) {
        Iterator<Map<String, Map<String, Object>>> it = raftConfigService.methods.iterator();
        Map<String, Object> map = null;
        while (it.hasNext()) {
            for (Map.Entry<String, Map<String, Object>> entry : it.next().entrySet()) {
                if (entry.getKey().equals(str)) {
                    map = entry.getValue();
                }
            }
        }
        return map;
    }

    private void initConfigServices(Map<String, Object> map) {
        List<Map<String, Object>> list;
        Map map2 = (Map) map.get(Constants.Configs.CONFIGS);
        if (map2 != null && (list = (List) map2.get("services")) != null) {
            for (Map<String, Object> map3 : list) {
                RaftConfigService raftConfigService = new RaftConfigService();
                raftConfigService.parse(map3);
                RaftConfigService raftConfigService2 = this.mConfigServices.get(raftConfigService.getServiceKey());
                if (raftConfigService2 != null && raftConfigService2.from == Constants.ConfigFrom.ANNOTATION) {
                    mergeArgFromAnnotation(raftConfigService2, raftConfigService);
                }
                this.mConfigServices.put(raftConfigService.getServiceKey(), raftConfigService);
            }
        }
    }

    private void initDeclares(Map<String, Object> map) {
        Map map2 = (Map) map.get(Constants.Configs.DECLARE);
        if (map2 != null) {
            Map<String, Object> map3 = (Map) map2.get(Constants.Configs.BASICS);
            Map<String, Object> map4 = (Map) map2.get(Constants.Configs.CLOUD);
            Map map5 = (Map) map2.get("services");
            if (map5 != null) {
                for (String str : map5.keySet()) {
                    Object obj = map5.get(str);
                    RaftConfigService raftConfigService = new RaftConfigService();
                    raftConfigService.parse((Map) obj);
                    this.mDeclaresServices.put(str, raftConfigService);
                }
            }
            if (map3 != null) {
                this.mDeclareBasics = map3;
            }
            if (map4 != null) {
                this.mDeclareCloud = map4;
            }
        }
    }

    private void replaceArgValueWithAnnotation(Map<String, Object> map, Map<String, Object> map2) {
        if (map != null && map2 != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object obj = map2.get(entry.getKey());
                if (obj != null) {
                    entry.setValue(obj);
                }
            }
        }
    }

    public synchronized Map<String, Object> getAllDeclareConstant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.mDeclareBasics);
        hashMap.putAll(this.mDeclareCloud);
        return hashMap;
    }

    public synchronized Map<String, RaftConfigService> getAllDeclareService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mDeclaresServices;
    }

    public synchronized RaftConfigService getConfigService(String str) {
        Map<String, RaftConfigService> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RaftConfigService) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (map = this.mConfigServices) != null) {
            return map.get(str);
        }
        return null;
    }

    public synchronized Object getDeclareBasic(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        Map<String, Object> map = this.mDeclareBasics;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Object getDeclareCloud(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        Map<String, Object> map = this.mDeclareCloud;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized RaftConfigService getDeclareService(String str) {
        LinkedHashMap<String, RaftConfigService> linkedHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RaftConfigService) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (linkedHashMap = this.mDeclaresServices) != null) {
            return linkedHashMap.get(str);
        }
        return null;
    }

    public void init(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        if (map != null) {
            initDeclares(map);
            initConfigServices(map);
            RLog.d(TAG, "init success! services:" + this.mConfigServices.size());
        }
    }

    public void mergeArgFromAnnotation(RaftConfigService raftConfigService, RaftConfigService raftConfigService2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) raftConfigService, (Object) raftConfigService2);
            return;
        }
        if (raftConfigService != null && raftConfigService2 != null) {
            Constants.Scope scope = raftConfigService.scope;
            if (scope != null) {
                raftConfigService2.scope = scope;
            }
            replaceArgValueWithAnnotation(raftConfigService2.constructorArgs, raftConfigService.constructorArgs);
            replaceArgValueWithAnnotation(raftConfigService2.factoryMethodArgs, raftConfigService.constructorArgs);
            replaceArgValueWithAnnotation(raftConfigService2.properties, raftConfigService.constructorArgs);
            List<Map<String, Map<String, Object>>> list = raftConfigService2.methods;
            if (list != null && raftConfigService.methods != null) {
                Iterator<Map<String, Map<String, Object>>> it = list.iterator();
                while (it.hasNext()) {
                    for (Map.Entry<String, Map<String, Object>> entry : it.next().entrySet()) {
                        replaceArgValueWithAnnotation(entry.getValue(), findMethodArgMap(raftConfigService, entry.getKey()));
                    }
                }
            }
        }
    }

    public synchronized void updateServiceByAnnotation(RaftConfigService raftConfigService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) raftConfigService);
            return;
        }
        Map<String, RaftConfigService> map = this.mConfigServices;
        if (map == null) {
            return;
        }
        map.put(raftConfigService.getServiceKey(), raftConfigService);
    }
}
