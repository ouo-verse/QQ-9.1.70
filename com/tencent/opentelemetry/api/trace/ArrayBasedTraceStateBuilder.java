package com.tencent.opentelemetry.api.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.internal.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
final class ArrayBasedTraceStateBuilder implements TraceStateBuilder {
    static IPatchRedirector $redirector_ = null;
    private static final ArrayBasedTraceState EMPTY;
    private static final int KEY_MAX_SIZE = 256;
    private static final int MAX_KEY_VALUE_PAIRS = 32;
    private static final int MAX_TENANT_ID_SIZE = 240;
    private static final int MAX_VENDOR_ID_SIZE = 13;
    private static final int VALUE_MAX_SIZE = 256;
    private final List<String> entries;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16675);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            EMPTY = ArrayBasedTraceState.create(Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBasedTraceStateBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.entries = new ArrayList();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceState empty() {
        return EMPTY;
    }

    private static boolean isKeyValid(@Nullable String str) {
        int length;
        if (str == null || str.length() > 256 || str.isEmpty() || isNotLowercaseLetterOrDigit(str.charAt(0))) {
            return false;
        }
        boolean z16 = false;
        for (int i3 = 1; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (isNotLegalKeyCharacter(charAt)) {
                return false;
            }
            if (charAt == '@') {
                if (z16 || i3 > 240 || (length = (str.length() - i3) - 1) > 13 || length == 0) {
                    return false;
                }
                z16 = true;
            }
        }
        if (z16) {
            return true;
        }
        return isNotDigit(str.charAt(0));
    }

    private static boolean isNotDigit(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return false;
        }
        return true;
    }

    private static boolean isNotLegalKeyCharacter(char c16) {
        if (isNotLowercaseLetterOrDigit(c16) && c16 != '_' && c16 != '-' && c16 != '@' && c16 != '*' && c16 != '/') {
            return true;
        }
        return false;
    }

    private static boolean isNotLowercaseLetterOrDigit(char c16) {
        if ((c16 < 'a' || c16 > 'z') && isNotDigit(c16)) {
            return true;
        }
        return false;
    }

    private static boolean isValueValid(@Nullable String str) {
        if (StringUtils.isNullOrEmpty(str) || str.length() > 256 || str.charAt(str.length() - 1) == ' ') {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == ',' || charAt == '=' || charAt < ' ' || charAt > '~') {
                return false;
            }
        }
        return true;
    }

    private void removeEntry(String str) {
        int size = this.entries.size();
        for (int i3 = 0; i3 < size; i3 += 2) {
            if (this.entries.get(i3).equals(str)) {
                this.entries.remove(i3);
                this.entries.remove(i3);
                return;
            }
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceStateBuilder
    public TraceState build() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TraceState) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ArrayBasedTraceState.create(this.entries);
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceStateBuilder
    public TraceStateBuilder put(String str, String str2) {
        List<String> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TraceStateBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        if (isKeyValid(str) && isValueValid(str2) && ((list = this.entries) == null || list.size() < 32)) {
            removeEntry(str);
            this.entries.add(0, str);
            this.entries.add(1, str2);
        }
        return this;
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceStateBuilder
    public TraceStateBuilder remove(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TraceStateBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (str == null) {
            return this;
        }
        removeEntry(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBasedTraceStateBuilder(ArrayBasedTraceState arrayBasedTraceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.entries = new ArrayList(arrayBasedTraceState.getEntries());
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayBasedTraceState);
        }
    }
}
