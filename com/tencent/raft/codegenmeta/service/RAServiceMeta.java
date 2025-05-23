package com.tencent.raft.codegenmeta.service;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.raft.codegenmeta.utils.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RAServiceMeta {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RAServiceMeta";
    public List<ArgsDescription> constructorArgsDesc;
    public String factoryClass;
    public String factoryMethod;
    public List<ArgsDescription> factoryMethodArgsDesc;
    public List<String> interfaces;
    public String itemClass;
    public List<Map<String, Object>> methodInjection;
    public List<Map<String, List<ArgsDescription>>> methods;
    public List<ArgsDescription> properties;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class ArgsDescription {
        static IPatchRedirector $redirector_;
        public String name;
        public String type;

        public ArgsDescription(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.name = str;
                this.type = str2;
            }
        }
    }

    public RAServiceMeta() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.interfaces = new ArrayList();
        this.factoryMethodArgsDesc = new ArrayList();
        this.constructorArgsDesc = new ArrayList();
        this.properties = new ArrayList();
        this.methods = new ArrayList();
    }

    private static Object defaultIfEmpty(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        return obj;
    }

    public static boolean isEmpty(String str) {
        if (str != null && !str.equals("")) {
            return false;
        }
        return true;
    }

    private void parseConstructorArgs(Map<String, Object> map) {
        List list = (List) ((Map) defaultIfEmpty(map.get(Constants.Service.INIT_METHOD), new HashMap())).get("args");
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Map map2 = (Map) list.get(i3);
                String str = (String) map2.keySet().toArray()[0];
                this.constructorArgsDesc.add(new ArgsDescription(str, (String) map2.get(str)));
            }
        }
    }

    private void parseFactory(Map<String, Object> map) {
        List list;
        this.factoryClass = (String) defaultIfEmpty(map.get(Constants.Service.FACTORY_CLASS), null);
        Map map2 = (Map) defaultIfEmpty(map.get(Constants.Service.FACTORY_METHOD), null);
        if (map2 != null) {
            this.factoryMethod = (String) map2.get("name");
        }
        if (map2 != null && (list = (List) map2.get("args")) != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Map map3 = (Map) list.get(i3);
                String str = (String) map3.keySet().toArray()[0];
                this.factoryMethodArgsDesc.add(new ArgsDescription(str, (String) map3.get(str)));
            }
        }
    }

    private void parseInterface(Map<String, Object> map) {
        Object obj = map.get(Constants.Service.INTERFACE);
        if (obj != null) {
            if (obj instanceof List) {
                this.interfaces.addAll((List) obj);
            } else {
                if (obj instanceof String) {
                    this.interfaces.add((String) obj);
                    return;
                }
                throw new IllegalArgumentException("interface parse error :" + obj);
            }
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
            ArrayList arrayList = new ArrayList();
            if (obj2 instanceof List) {
                List list = (List) obj2;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    Map map3 = (Map) list.get(i3);
                    String str2 = (String) map3.keySet().toArray()[0];
                    arrayList.add(new ArgsDescription(str2, (String) map3.get(str2)));
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str, arrayList);
            this.methods.add(hashMap);
        }
    }

    private void parseProperties(Map<String, Object> map) {
        List list = (List) defaultIfEmpty(map.get(Constants.Service.PROPERTIES), null);
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Map map2 = (Map) list.get(i3);
                String str = (String) map2.keySet().toArray()[0];
                this.properties.add(new ArgsDescription(str, (String) map2.get(str)));
            }
        }
    }

    public String getServiceKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!TextUtils.isEmpty(this.itemClass)) {
            return this.itemClass;
        }
        if (!TextUtils.isEmpty(this.factoryClass)) {
            return this.factoryClass;
        }
        return null;
    }

    public void parse(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            return;
        }
        this.itemClass = (String) defaultIfEmpty(map.get(Constants.Service.CLASS), null);
        this.methodInjection = (List) defaultIfEmpty(map.get(Constants.Service.REPLACE_METHOD), null);
        parseInterface(map);
        parseConstructorArgs(map);
        parseFactory(map);
        parseProperties(map);
        parseMethods(map);
    }

    public void parseDeclare(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
            return;
        }
        this.itemClass = (String) defaultIfEmpty(map.get(Constants.Service.CLASS), null);
        this.methodInjection = (List) defaultIfEmpty(map.get(Constants.Service.REPLACE_METHOD), null);
        parseInterface(map);
        parseConstructorArgs(map);
        parseFactory(map);
        parseProperties(map);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "RAServiceMeta{interfaces=" + this.interfaces + ", itemClass='" + this.itemClass + "', factoryClass='" + this.factoryClass + "', factoryMethod='" + this.factoryMethod + "', factoryMethodArgsDesc=" + this.factoryMethodArgsDesc + ", constructorArgsDesc=" + this.constructorArgsDesc + ", properties=" + this.properties + ", methodInjection=" + this.methodInjection + '}';
    }
}
