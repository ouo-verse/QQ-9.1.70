package com.tencent.luan.ioc;

import com.tencent.luan.core.LuanLog;
import com.tencent.luan.core.Utility;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.index.IndexInjectAnalysisService;
import com.tencent.luan.ioc.index.IndexInjectInfoService;
import com.tencent.luan.ioc.reflect.ReflectInjectAnalysisService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LuanInjectService implements InjectService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "LuanInjectService";
    static final String VERSION_NAME = "0.4.4";
    private final boolean debugMode;
    private final IndexInjectAnalysisService indexAnalyst;
    final Map<String, InjectConstructor<?>> nameInjectConstructorMap;
    private final Map<String, Class<?>> nameTypeMap;
    private final Set<Class<?>> providerTypes;
    private final ReflectInjectAnalysisService reflectAnalyst;
    private final Map<Class<?>, InjectConstructor<?>> typeInjectConstructorMap;
    private final Map<Class<?>, List<InjectMethod>> typeInjectMethodsMap;

    /* synthetic */ LuanInjectService(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) builder, (Object) anonymousClass1);
    }

    private Map<String, InjectConstructor<?>> collectNamedTypeConstructors(Map<String, InjectConstructor<?>> map) {
        for (Map.Entry<String, Class<?>> entry : this.nameTypeMap.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), getInjectConstructor(entry.getValue()));
            }
        }
        return map;
    }

    private void collectProvideMethods(Map<Class<?>, InjectConstructor<?>> map, Map<String, InjectConstructor<?>> map2) {
        List<ProvideMethod<?>> list;
        for (Class<?> cls : this.providerTypes) {
            if (this.indexAnalyst.isValid()) {
                list = this.indexAnalyst.getProvideMethods(cls);
            } else {
                list = null;
            }
            if (list == null && this.reflectAnalyst.isValid()) {
                list = this.reflectAnalyst.getProvideMethods(cls);
            }
            if (list != null && !list.isEmpty()) {
                if (this.debugMode) {
                    LuanLog.d(TAG, "addProvider: " + cls.getName() + " which has " + list.size() + " provide methods");
                }
                for (ProvideMethod<?> provideMethod : list) {
                    InjectParam provideParam = provideMethod.provideParam();
                    if (provideParam.name.isEmpty()) {
                        map.put(provideParam.type, provideMethod);
                    } else {
                        map2.put(provideParam.name, provideMethod);
                    }
                }
            } else {
                LuanLog.i(TAG, "addProvider: this type has no provide method " + cls.getName());
            }
        }
    }

    public static String getVersionName() {
        return VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String typeNamed(Class<?> cls) {
        Named named = (Named) cls.getAnnotation(Named.class);
        if (named == null) {
            return "";
        }
        return named.value();
    }

    public <T> T get(Class<T> cls, String str, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, this, cls, str, objArr);
        }
        if (cls != null) {
            if (this.debugMode) {
                LuanLog.d(TAG, "get type " + cls.getName() + " with name " + str);
            }
            LuanInjector luanInjector = new LuanInjector(null, this);
            if (Utility.isEmpty(str)) {
                return (T) luanInjector.get((Class<?>) cls, objArr);
            }
            return (T) luanInjector.get(str, objArr);
        }
        throw new NullPointerException("type for get object cannot be null");
    }

    public Builder getCloneBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Builder) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new Builder(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InjectConstructor<?> getInjectConstructor(Class<?> cls) {
        InjectConstructor<?> injectConstructor = this.typeInjectConstructorMap.get(cls);
        if (injectConstructor == null) {
            if (this.indexAnalyst.isValid()) {
                injectConstructor = this.indexAnalyst.getInjectConstructor(cls);
            }
            if (injectConstructor == null && this.reflectAnalyst.isValid()) {
                injectConstructor = this.reflectAnalyst.getInjectConstructor(cls);
            }
            if (injectConstructor != null) {
                this.typeInjectConstructorMap.put(cls, injectConstructor);
            } else {
                throw new InjectException("failed to create object " + cls.getName());
            }
        }
        return injectConstructor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<InjectMethod> getInjectMethods(Class<?> cls) {
        List<InjectMethod> list = this.typeInjectMethodsMap.get(cls);
        if (list == null) {
            if (this.indexAnalyst.isValid()) {
                list = this.indexAnalyst.getInjectMethods(cls);
            }
            if (list == null && this.reflectAnalyst.isValid()) {
                list = this.reflectAnalyst.getInjectMethods(cls);
            }
            if (list == null) {
                LuanLog.i(TAG, "getInjectMethods: this type has no inject method " + cls.getName());
                list = Collections.emptyList();
            }
            this.typeInjectMethodsMap.put(cls, list);
        }
        return list;
    }

    @Override // com.tencent.luan.ioc.InjectService
    public void inject(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        if (obj != null) {
            if (this.debugMode) {
                LuanLog.d(TAG, "start to inject " + obj.getClass().getName());
            }
            new LuanInjector(obj, this).inject();
            return;
        }
        throw new NullPointerException("injected object cannot be null");
    }

    public boolean isDebugMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.debugMode;
    }

    public boolean isReflectValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.reflectAnalyst.isValid();
    }

    public LuanInjectService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.typeInjectMethodsMap = new ConcurrentHashMap();
        this.debugMode = false;
        this.reflectAnalyst = new ReflectInjectAnalysisService(null);
        this.indexAnalyst = new IndexInjectAnalysisService(Collections.emptyList());
        this.nameTypeMap = Collections.emptyMap();
        this.providerTypes = Collections.emptySet();
        this.typeInjectConstructorMap = new ConcurrentHashMap();
        this.nameInjectConstructorMap = Collections.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private boolean debugMode;
        private List<IndexInjectInfoService> indexInjectInfoServices;
        private ClassLoader loader;
        private Map<String, Class<?>> nameTypeMap;
        private Set<Class<?>> providerTypes;
        private boolean reflectValid;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.loader = null;
            this.debugMode = false;
            this.reflectValid = true;
            this.indexInjectInfoServices = new LinkedList();
            this.nameTypeMap = new HashMap();
            this.providerTypes = new LinkedHashSet();
        }

        public Builder addIndexInfo(IndexInjectInfoService indexInjectInfoService) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) indexInjectInfoService);
            }
            Utility.makeSureNotNull(indexInjectInfoService, "indexInfo");
            this.indexInjectInfoServices.add(indexInjectInfoService);
            return this;
        }

        public Builder addIndexInfos(Iterable<IndexInjectInfoService> iterable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) iterable);
            }
            Iterator<IndexInjectInfoService> it = iterable.iterator();
            while (it.hasNext()) {
                addIndexInfo(it.next());
            }
            return this;
        }

        public Builder addNamedType(Class<?> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) cls);
            }
            Utility.makeSureNotNull(cls, "namedType");
            String typeNamed = LuanInjectService.typeNamed(cls);
            if (typeNamed.isEmpty()) {
                LuanLog.d(LuanInjectService.TAG, "addNamedType: this class " + cls.getName() + " is not named or named empty string, ignored");
            } else {
                Class<?> put = this.nameTypeMap.put(typeNamed, cls);
                if (put != null) {
                    LuanLog.d(LuanInjectService.TAG, "addNamedType: " + put.getName() + " with the name of " + typeNamed + " is override by " + cls.getName());
                }
            }
            return this;
        }

        public Builder addNamedTypes(Iterable<Class<?>> iterable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) iterable);
            }
            Iterator<Class<?>> it = iterable.iterator();
            while (it.hasNext()) {
                addNamedType(it.next());
            }
            return this;
        }

        public Builder addProviderType(Class<?> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) cls);
            }
            Utility.makeSureNotNull(cls, "providerType");
            this.providerTypes.add(cls);
            return this;
        }

        public Builder addProviderTypes(Iterable<Class<?>> iterable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) iterable);
            }
            Iterator<Class<?>> it = iterable.iterator();
            while (it.hasNext()) {
                addProviderType(it.next());
            }
            return this;
        }

        public LuanInjectService create() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (LuanInjectService) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return new LuanInjectService(this, null);
        }

        public Builder setClassLoader(ClassLoader classLoader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) classLoader);
            }
            this.loader = classLoader;
            return this;
        }

        public Builder setDebugMode(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.debugMode = z16;
            return this;
        }

        public Builder setReflectValid(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.reflectValid = z16;
            return this;
        }

        public Builder(LuanInjectService luanInjectService) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) luanInjectService);
                return;
            }
            this.loader = null;
            this.debugMode = false;
            this.reflectValid = true;
            this.indexInjectInfoServices = new LinkedList();
            this.nameTypeMap = new HashMap();
            this.providerTypes = new LinkedHashSet();
            Utility.makeSureNotNull(luanInjectService, "injectService");
            this.loader = luanInjectService.reflectAnalyst.getLoader();
            this.debugMode = luanInjectService.debugMode;
            this.reflectValid = luanInjectService.reflectAnalyst.isValid();
            this.indexInjectInfoServices.addAll(luanInjectService.indexAnalyst.getIndexInfos());
            this.nameTypeMap.putAll(luanInjectService.nameTypeMap);
            this.providerTypes.addAll(luanInjectService.providerTypes);
        }
    }

    LuanInjectService(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) builder);
            return;
        }
        this.typeInjectMethodsMap = new ConcurrentHashMap();
        this.debugMode = builder.debugMode;
        ReflectInjectAnalysisService reflectInjectAnalysisService = new ReflectInjectAnalysisService(builder.loader);
        this.reflectAnalyst = reflectInjectAnalysisService;
        reflectInjectAnalysisService.setValid(builder.reflectValid);
        this.indexAnalyst = new IndexInjectAnalysisService(Collections.unmodifiableList(builder.indexInjectInfoServices));
        this.nameTypeMap = Collections.unmodifiableMap(new HashMap(builder.nameTypeMap));
        this.providerTypes = Collections.unmodifiableSet(new LinkedHashSet(builder.providerTypes));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        collectProvideMethods(hashMap, hashMap2);
        this.typeInjectConstructorMap = new ConcurrentHashMap(hashMap);
        this.nameInjectConstructorMap = Collections.unmodifiableMap(collectNamedTypeConstructors(hashMap2));
    }
}
