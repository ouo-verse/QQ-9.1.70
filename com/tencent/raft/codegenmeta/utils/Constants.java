package com.tencent.raft.codegenmeta.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface Constants {
    public static final String DEFAULT_GLOBAL_CONFIG_TARGET = "DefaultGlobalTarget";
    public static final String GEN_FILE_PACKAGE_NAME = "com.tencent.raft.generate";
    public static final String KEY_BUILD_INDEX_FILE_PATH = "RAFT_BUILD_INDEX_FILE_PATH";
    public static final String KEY_FILE_ANNOTATION_CONFIG_PATH = "RAFT_FILE_ANNOTATION_CONFIG_PATH";
    public static final String KEY_INDEX_FILE_SEPARATOR = ":";
    public static final String KEY_INDEX_TYPE_ANNOTATION_SLICE = "ANNOTATION_SLICE";
    public static final String KEY_INDEX_TYPE_YML_INFO_GEN = "YML_INFO_GEN";
    public static final String KEY_JSON_APP_DEPEND_MODULE = "RAFT_JSON_APP_DEPEND_MODULE";
    public static final String KEY_MODULE_NAME = "RAFT_MODULE_ID";
    public static final String KEY_OPTION_FALSE = "FALSE";
    public static final String KEY_OPTION_TRUE = "TRUE";
    public static final String KEY_PROJECT_ABS_PATH = "RAFT_PROJECT_ABS_PATH";
    public static final String KEY_PROJECT_IS_APP = "RAFT_PROJECT_IS_APP";
    public static final String KEY_RAFT_GEN_DIR_PATH = "RAFT_GEN_DIR_PATH";
    public static final String KEY_ROOT_PROJECT_ABS_PATH = "RAFT_ROOT_PROJECT_ABS_PATH";
    public static final String NAME_OF_AUTO_WIRED = "RAFT$$AutoWired$$";
    public static final String NAME_OF_BEAN_TARGET = "RAFT$$Target$$";
    public static final String PACKAGE_OF_GENERATE_FILE = "com.tencent.raft.codegenerator.generator.annotation";
    public static final String PACKAGE_OF_GENERATE_YAML_FILE = "com.tencent.raft.codegenerator.generator.yaml";
    public static final String PREFIX_OF_LOGGER = "RAFT::Compiler ";
    public static final String PROJECT = "RAFT";
    public static final String RAFT_BUILD_INDEX_FILE = ".index.raft";
    public static final String RAFT_YAML_FILE = "com_raft.yaml";
    public static final String SCOPE_LazySingleton = "LazySingleton";
    public static final String SCOPE_Prototype = "Prototype";
    public static final String SCOPE_Singleton = "Singleton";
    public static final String SCOPE_WeakSingleton = "WeakSingleton";
    public static final String SEPARATOR = "$$";
    public static final String SERVICE_ENTRY_CLASS = "IServiceEntry";
    public static final String SERVICE_ENTRY_PACKAGE = "com.tencent.raft.raftframework.service.api";
    public static final String TAG = "RAFT::";
    public static final String WARNING_TIPS = " IT WAS GENERATED BY RAFT. DO NOT EDIT THIS FILE!!!";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class ConfigFrom {
        private static final /* synthetic */ ConfigFrom[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ConfigFrom ANNOTATION;
        public static final ConfigFrom CONFIG_YAML;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16287);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ConfigFrom configFrom = new ConfigFrom("CONFIG_YAML", 0);
            CONFIG_YAML = configFrom;
            ConfigFrom configFrom2 = new ConfigFrom("ANNOTATION", 1);
            ANNOTATION = configFrom2;
            $VALUES = new ConfigFrom[]{configFrom, configFrom2};
        }

        ConfigFrom(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ConfigFrom valueOf(String str) {
            return (ConfigFrom) Enum.valueOf(ConfigFrom.class, str);
        }

        public static ConfigFrom[] values() {
            return (ConfigFrom[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Configs {
        public static final String BASICS = "basics";
        public static final String CLOUD = "cloud";
        public static final String COMPONENTS = "components";
        public static final String CONFIGS = "configs";
        public static final String DECLARE = "declares";
        public static final String DECLARES_REF = "$declares.";
        public static final String DECLARES_REF_BASIC = "$declares.basics";
        public static final String DECLARES_REF_CLOUD = "$declares.cloud";
        public static final String SERVICE = "service";
        public static final String SERVICES = "services";
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Raft {
        public static final String API_VERSION = "apiVersion";
        public static final String COMPONENTS = "components";
        public static final String DESCRIPTION = "description";
        public static final String EXPORTS = "exports";
        public static final String IMPORTS = "imports";
        public static final String KIND = "kind";
        public static final String NAME = "name";
        public static final String PACKAGES = "packages";
        public static final String PLATFORM = "platform";
        public static final String SERVICES = "services";
        public static final String TASKS = "tasks";
        public static final String VERSION = "version";
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class Scope {
        private static final /* synthetic */ Scope[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Scope LAZY_SINGLETON;
        public static final Scope PROTOTYPE;
        public static final Scope SINGLETON;
        public static final Scope WEAK_SINGLETON;
        final String alias;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16279);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            Scope scope = new Scope("SINGLETON", 0, "Singleton");
            SINGLETON = scope;
            Scope scope2 = new Scope("PROTOTYPE", 1, "Prototype");
            PROTOTYPE = scope2;
            Scope scope3 = new Scope("LAZY_SINGLETON", 2, "LazySingleton");
            LAZY_SINGLETON = scope3;
            Scope scope4 = new Scope("WEAK_SINGLETON", 3, "WeakSingleton");
            WEAK_SINGLETON = scope4;
            $VALUES = new Scope[]{scope, scope2, scope3, scope4};
        }

        Scope(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
            } else {
                this.alias = str2;
            }
        }

        public static Scope parse(String str) {
            for (Scope scope : values()) {
                if (scope.getAlias().equals(str)) {
                    return scope;
                }
            }
            return PROTOTYPE;
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }

        public String getAlias() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.alias;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface Service {
        public static final String ARGS = "args";
        public static final String CLASS = "class";
        public static final String CONFIG_NAME_SPACE = "namespace";
        public static final String DESCRIPTION = "description";
        public static final String FACTORY_CLASS = "factory-class";
        public static final String FACTORY_METHOD = "factory-method";
        public static final String INIT_METHOD = "init-method";
        public static final String INTERFACE = "interface";
        public static final String METHODS = "methods";
        public static final String NAME = "name";
        public static final String PROPERTIES = "properties";
        public static final String REPLACE_METHOD = "replaced-method";
        public static final String SCOPE = "scope";
    }
}
