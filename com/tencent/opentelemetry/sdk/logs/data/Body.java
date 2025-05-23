package com.tencent.opentelemetry.sdk.logs.data;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface Body {
    public static final IPatchRedirector $redirector_ = null;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class Type {
        private static final /* synthetic */ Type[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Type EMPTY;
        public static final Type STRING;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10518);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Type type = new Type(PatternUtils.NO_MATCH, 0);
            EMPTY = type;
            Type type2 = new Type("STRING", 1);
            STRING = type2;
            $VALUES = new Type[]{type, type2};
        }

        Type(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    String asString();

    Type getType();
}
