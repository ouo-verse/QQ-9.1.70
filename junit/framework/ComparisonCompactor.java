package junit.framework;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ComparisonCompactor {
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";
    private static final String ELLIPSIS = "...";
    private String fActual;
    private int fContextLength;
    private String fExpected;
    private int fPrefix;
    private int fSuffix;

    public ComparisonCompactor(int i3, String str, String str2) {
        this.fContextLength = i3;
        this.fExpected = str;
        this.fActual = str2;
    }

    private boolean areStringsEqual() {
        return this.fExpected.equals(this.fActual);
    }

    private String compactString(String str) {
        String str2 = DELTA_START + str.substring(this.fPrefix, (str.length() - this.fSuffix) + 1) + DELTA_END;
        if (this.fPrefix > 0) {
            str2 = computeCommonPrefix() + str2;
        }
        if (this.fSuffix > 0) {
            return str2 + computeCommonSuffix();
        }
        return str2;
    }

    private String computeCommonPrefix() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        if (this.fPrefix > this.fContextLength) {
            str = "...";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix));
        return sb5.toString();
    }

    private String computeCommonSuffix() {
        String str;
        int min = Math.min((this.fExpected.length() - this.fSuffix) + 1 + this.fContextLength, this.fExpected.length());
        StringBuilder sb5 = new StringBuilder();
        String str2 = this.fExpected;
        sb5.append(str2.substring((str2.length() - this.fSuffix) + 1, min));
        if ((this.fExpected.length() - this.fSuffix) + 1 < this.fExpected.length() - this.fContextLength) {
            str = "...";
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }

    private void findCommonPrefix() {
        this.fPrefix = 0;
        int min = Math.min(this.fExpected.length(), this.fActual.length());
        while (true) {
            int i3 = this.fPrefix;
            if (i3 < min && this.fExpected.charAt(i3) == this.fActual.charAt(this.fPrefix)) {
                this.fPrefix++;
            } else {
                return;
            }
        }
    }

    private void findCommonSuffix() {
        int length = this.fExpected.length() - 1;
        int length2 = this.fActual.length() - 1;
        while (true) {
            int i3 = this.fPrefix;
            if (length2 < i3 || length < i3 || this.fExpected.charAt(length) != this.fActual.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.fSuffix = this.fExpected.length() - length;
    }

    public String compact(String str) {
        if (this.fExpected != null && this.fActual != null && !areStringsEqual()) {
            findCommonPrefix();
            findCommonSuffix();
            return Assert.format(str, compactString(this.fExpected), compactString(this.fActual));
        }
        return Assert.format(str, this.fExpected, this.fActual);
    }
}
