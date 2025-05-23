package com.tencent.opentelemetry.api.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public final class StringUtils {
    static IPatchRedirector $redirector_;

    StringUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isNullOrEmpty(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean isPrintableChar(char c16) {
        if (c16 >= ' ' && c16 <= '~') {
            return true;
        }
        return false;
    }

    public static boolean isPrintableString(String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!isPrintableChar(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static String padLeft(String str, int i3) {
        return padStart(str, i3, '0');
    }

    private static String padStart(String str, int i3, char c16) {
        Objects.requireNonNull(str);
        if (str.length() >= i3) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(i3);
        for (int length = str.length(); length < i3; length++) {
            sb5.append(c16);
        }
        sb5.append(str);
        return sb5.toString();
    }
}
