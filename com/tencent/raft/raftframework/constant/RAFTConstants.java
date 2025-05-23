package com.tencent.raft.raftframework.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface RAFTConstants {
    public static final String RAFT_VERSION = "com.raft.uas/v1alpha2";

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
        String alias;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13237);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            Scope scope = new Scope("SINGLETON", 0, "Singleton");
            SINGLETON = scope;
            Scope scope2 = new Scope("LAZY_SINGLETON", 1, "LazySingleton");
            LAZY_SINGLETON = scope2;
            Scope scope3 = new Scope("PROTOTYPE", 2, "Prototype");
            PROTOTYPE = scope3;
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
}
