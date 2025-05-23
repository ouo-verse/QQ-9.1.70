package com.tencent.opentelemetry.api.baggage.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.BitSet;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Element {
    static IPatchRedirector $redirector_;
    private static final BitSet EXCLUDED_KEY_CHARS;
    private static final BitSet EXCLUDED_VALUE_CHARS;
    private int end;
    private final BitSet excluded;
    private boolean leadingSpace;
    private boolean readingValue;
    private int start;
    private boolean trailingSpace;
    private String value;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EXCLUDED_KEY_CHARS = new BitSet(128);
        EXCLUDED_VALUE_CHARS = new BitSet(128);
        char[] cArr = {'(', ')', Typography.less, Typography.greater, '@', ',', ';', ':', '\\', '\"', '/', '[', ']', '?', '=', '{', '}'};
        for (int i3 = 0; i3 < 17; i3++) {
            EXCLUDED_KEY_CHARS.set(cArr[i3]);
        }
        char[] cArr2 = {'\"', ',', ';', '\\'};
        for (int i16 = 0; i16 < 4; i16++) {
            EXCLUDED_VALUE_CHARS.set(cArr2[i16]);
        }
    }

    Element(BitSet bitSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bitSet);
        } else {
            this.excluded = bitSet;
            reset(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Element createKeyElement() {
        return new Element(EXCLUDED_KEY_CHARS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Element createValueElement() {
        return new Element(EXCLUDED_VALUE_CHARS);
    }

    private boolean isExcluded(char c16) {
        if (c16 > ' ' && c16 < '\u007f' && !this.excluded.get(c16)) {
            return false;
        }
        return true;
    }

    private static boolean isWhitespace(char c16) {
        if (c16 != ' ' && c16 != '\t') {
            return false;
        }
        return true;
    }

    private void markEnd(int i3) {
        this.end = i3;
        this.readingValue = false;
        this.trailingSpace = true;
    }

    private void markStart(int i3) {
        this.start = i3;
        this.readingValue = true;
        this.leadingSpace = false;
    }

    private void setValue(String str) {
        this.value = str.substring(this.start, this.end);
    }

    private boolean tryNextTokenChar(int i3) {
        if (this.leadingSpace) {
            markStart(i3);
        }
        return !this.trailingSpace;
    }

    private boolean tryNextWhitespace(int i3) {
        if (this.readingValue) {
            markEnd(i3);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getValue() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset(int i3) {
        this.start = i3;
        this.leadingSpace = true;
        this.readingValue = false;
        this.trailingSpace = false;
        this.value = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tryNextChar(char c16, int i3) {
        if (isWhitespace(c16)) {
            return tryNextWhitespace(i3);
        }
        if (isExcluded(c16)) {
            return false;
        }
        return tryNextTokenChar(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tryTerminating(int i3, String str) {
        if (this.readingValue) {
            markEnd(i3);
        }
        if (this.trailingSpace) {
            setValue(str);
            return true;
        }
        return false;
    }
}
