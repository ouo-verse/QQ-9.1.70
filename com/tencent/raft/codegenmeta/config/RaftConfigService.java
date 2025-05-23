package com.tencent.raft.codegenmeta.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RaftConfigService implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RaftConfigService";
    private static final long serialVersionUID = 1000;
    public String className;
    public Map<String, Object> constructorArgs;
    public String factoryClass;
    public String factoryMethod;
    public Map<String, Object> factoryMethodArgs;
    public Constants.ConfigFrom from;
    public List<Map<String, Map<String, Object>>> methods;
    public Map<String, Object> properties;
    public Constants.Scope scope;

    public RaftConfigService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.factoryMethodArgs = null;
        this.constructorArgs = null;
        this.properties = null;
        this.methods = null;
    }

    private void handleArgs(Map<String, Object> map, Map<String, Object> map2) {
        if (map2 == null) {
            return;
        }
        String str = (String) map2.keySet().toArray()[0];
        Object obj = map2.get(str);
        if (obj instanceof HashMap) {
            Map<String, Object> map3 = (Map) ((Map) obj).get("service");
            if (map3 != null) {
                RaftConfigService raftConfigService = new RaftConfigService();
                raftConfigService.parse(map3);
                map.put(str, raftConfigService);
                return;
            }
            return;
        }
        map.put(str, obj);
    }

    private Object handleValueWithDefault(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        return obj;
    }

    private void parseConstructorArgs(Map<String, Object> map) {
        Object obj = map.get(Constants.Service.INIT_METHOD);
        if (!(obj instanceof HashMap)) {
            return;
        }
        Object obj2 = ((Map) obj).get("args");
        if (!(obj2 instanceof List)) {
            return;
        }
        List list = (List) obj2;
        this.constructorArgs = new HashMap(1);
        for (int i3 = 0; i3 < list.size(); i3++) {
            handleArgs(this.constructorArgs, (Map) list.get(i3));
        }
    }

    private void parseFactory(Map<String, Object> map) {
        this.factoryClass = (String) handleValueWithDefault(map.get(Constants.Service.FACTORY_CLASS), null);
        Object obj = map.get(Constants.Service.FACTORY_METHOD);
        if (!(obj instanceof HashMap)) {
            return;
        }
        HashMap hashMap = (HashMap) obj;
        this.factoryMethod = (String) hashMap.get("name");
        Object obj2 = hashMap.get("args");
        if (!(obj2 instanceof List)) {
            return;
        }
        List list = (List) obj2;
        this.factoryMethodArgs = new HashMap(1);
        for (int i3 = 0; i3 < list.size(); i3++) {
            handleArgs(this.factoryMethodArgs, (Map) list.get(i3));
        }
    }

    private void parseMethods(Map<String, Object> map) {
        Object obj = map.get(Constants.Service.METHODS);
        if (!(obj instanceof List)) {
            return;
        }
        for (Map map2 : (List) obj) {
            String str = (String) map2.get("name");
            Object obj2 = map2.get("args");
            HashMap hashMap = new HashMap(1);
            if (obj2 instanceof List) {
                List list = (List) obj2;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    handleArgs(hashMap, (Map) list.get(i3));
                }
            }
            if (this.methods == null) {
                this.methods = new ArrayList();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, hashMap);
            this.methods.add(hashMap2);
        }
    }

    private void parseProperties(Map<String, Object> map) {
        Object obj = map.get(Constants.Service.PROPERTIES);
        if (!(obj instanceof List)) {
            return;
        }
        List list = (List) obj;
        this.properties = new HashMap(1);
        for (int i3 = 0; i3 < list.size(); i3++) {
            handleArgs(this.properties, (Map) list.get(i3));
        }
    }

    public String getServiceKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!TextUtils.isEmpty(this.className)) {
            return this.className;
        }
        if (!TextUtils.isEmpty(this.factoryClass)) {
            return this.factoryClass;
        }
        return null;
    }

    public void parse(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            return;
        }
        this.className = (String) handleValueWithDefault(map.get(Constants.Service.CLASS), null);
        this.from = Constants.ConfigFrom.CONFIG_YAML;
        this.scope = Constants.Scope.parse((String) handleValueWithDefault(map.get("scope"), Constants.Scope.PROTOTYPE.getAlias()));
        parseConstructorArgs(map);
        parseFactory(map);
        parseProperties(map);
        parseMethods(map);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "RaftConfigService{from='" + this.from + "', className='" + this.className + "', scope=" + this.scope + ", factoryClass='" + this.factoryClass + "', factoryMethod='" + this.factoryMethod + "', factoryMethodArgs=" + this.factoryMethodArgs + ", constructorArgs=" + this.constructorArgs + ", properties=" + this.properties + ", methods=" + this.methods + '}';
    }
}
