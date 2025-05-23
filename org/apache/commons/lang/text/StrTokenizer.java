package org.apache.commons.lang.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StrTokenizer implements ListIterator, Cloneable {
    private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE;
    private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
    private char[] chars;
    private StrMatcher delimMatcher;
    private boolean emptyAsNull;
    private boolean ignoreEmptyTokens;
    private StrMatcher ignoredMatcher;
    private StrMatcher quoteMatcher;
    private int tokenPos;
    private String[] tokens;
    private StrMatcher trimmerMatcher;

    static {
        StrTokenizer strTokenizer = new StrTokenizer();
        CSV_TOKENIZER_PROTOTYPE = strTokenizer;
        strTokenizer.setDelimiterMatcher(StrMatcher.commaMatcher());
        strTokenizer.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer.setEmptyTokenAsNull(false);
        strTokenizer.setIgnoreEmptyTokens(false);
        StrTokenizer strTokenizer2 = new StrTokenizer();
        TSV_TOKENIZER_PROTOTYPE = strTokenizer2;
        strTokenizer2.setDelimiterMatcher(StrMatcher.tabMatcher());
        strTokenizer2.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer2.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer2.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer2.setEmptyTokenAsNull(false);
        strTokenizer2.setIgnoreEmptyTokens(false);
    }

    public StrTokenizer() {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    private void addToken(List list, String str) {
        if (str == null || str.length() == 0) {
            if (isIgnoreEmptyTokens()) {
                return;
            }
            if (isEmptyTokenAsNull()) {
                str = null;
            }
        }
        list.add(str);
    }

    private void checkTokenized() {
        if (this.tokens == null) {
            char[] cArr = this.chars;
            if (cArr == null) {
                List list = tokenize(null, 0, 0);
                this.tokens = (String[]) list.toArray(new String[list.size()]);
            } else {
                List list2 = tokenize(cArr, 0, cArr.length);
                this.tokens = (String[]) list2.toArray(new String[list2.size()]);
            }
        }
    }

    private static StrTokenizer getCSVClone() {
        return (StrTokenizer) CSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getCSVInstance() {
        return getCSVClone();
    }

    private static StrTokenizer getTSVClone() {
        return (StrTokenizer) TSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getTSVInstance() {
        return getTSVClone();
    }

    private boolean isQuote(char[] cArr, int i3, int i16, int i17, int i18) {
        for (int i19 = 0; i19 < i18; i19++) {
            int i26 = i3 + i19;
            if (i26 >= i16 || cArr[i26] != cArr[i17 + i19]) {
                return false;
            }
        }
        return true;
    }

    private int readNextToken(char[] cArr, int i3, int i16, StrBuilder strBuilder, List list) {
        while (i3 < i16) {
            int max = Math.max(getIgnoredMatcher().isMatch(cArr, i3, i3, i16), getTrimmerMatcher().isMatch(cArr, i3, i3, i16));
            if (max == 0 || getDelimiterMatcher().isMatch(cArr, i3, i3, i16) > 0 || getQuoteMatcher().isMatch(cArr, i3, i3, i16) > 0) {
                break;
            }
            i3 += max;
        }
        if (i3 >= i16) {
            addToken(list, "");
            return -1;
        }
        int isMatch = getDelimiterMatcher().isMatch(cArr, i3, i3, i16);
        if (isMatch > 0) {
            addToken(list, "");
            return i3 + isMatch;
        }
        int isMatch2 = getQuoteMatcher().isMatch(cArr, i3, i3, i16);
        if (isMatch2 > 0) {
            return readWithQuotes(cArr, i3 + isMatch2, i16, strBuilder, list, i3, isMatch2);
        }
        return readWithQuotes(cArr, i3, i16, strBuilder, list, 0, 0);
    }

    private int readWithQuotes(char[] cArr, int i3, int i16, StrBuilder strBuilder, List list, int i17, int i18) {
        boolean z16;
        strBuilder.clear();
        if (i18 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        int i19 = i3;
        int i26 = 0;
        while (i19 < i16) {
            if (z17) {
                int i27 = i26;
                int i28 = i19;
                if (isQuote(cArr, i19, i16, i17, i18)) {
                    int i29 = i28 + i18;
                    if (isQuote(cArr, i29, i16, i17, i18)) {
                        strBuilder.append(cArr, i28, i18);
                        i19 = i28 + (i18 * 2);
                        i26 = strBuilder.size();
                    } else {
                        i26 = i27;
                        i19 = i29;
                        z17 = false;
                    }
                } else {
                    i19 = i28 + 1;
                    strBuilder.append(cArr[i28]);
                    i26 = strBuilder.size();
                }
            } else {
                int i36 = i26;
                int i37 = i19;
                int isMatch = getDelimiterMatcher().isMatch(cArr, i37, i3, i16);
                if (isMatch > 0) {
                    addToken(list, strBuilder.substring(0, i36));
                    return i37 + isMatch;
                }
                if (i18 > 0 && isQuote(cArr, i37, i16, i17, i18)) {
                    i19 = i37 + i18;
                    i26 = i36;
                    z17 = true;
                } else {
                    int isMatch2 = getIgnoredMatcher().isMatch(cArr, i37, i3, i16);
                    if (isMatch2 <= 0) {
                        isMatch2 = getTrimmerMatcher().isMatch(cArr, i37, i3, i16);
                        if (isMatch2 > 0) {
                            strBuilder.append(cArr, i37, isMatch2);
                        } else {
                            i19 = i37 + 1;
                            strBuilder.append(cArr[i37]);
                            i26 = strBuilder.size();
                        }
                    }
                    i19 = i37 + isMatch2;
                    i26 = i36;
                }
            }
        }
        addToken(list, strBuilder.substring(0, i26));
        return -1;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    public Object clone() {
        try {
            return cloneReset();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    Object cloneReset() throws CloneNotSupportedException {
        StrTokenizer strTokenizer = (StrTokenizer) super.clone();
        char[] cArr = strTokenizer.chars;
        if (cArr != null) {
            strTokenizer.chars = (char[]) cArr.clone();
        }
        strTokenizer.reset();
        return strTokenizer;
    }

    public String getContent() {
        char[] cArr = this.chars;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public StrMatcher getDelimiterMatcher() {
        return this.delimMatcher;
    }

    public StrMatcher getIgnoredMatcher() {
        return this.ignoredMatcher;
    }

    public StrMatcher getQuoteMatcher() {
        return this.quoteMatcher;
    }

    public String[] getTokenArray() {
        checkTokenized();
        return (String[]) this.tokens.clone();
    }

    public List getTokenList() {
        checkTokenized();
        ArrayList arrayList = new ArrayList(this.tokens.length);
        int i3 = 0;
        while (true) {
            String[] strArr = this.tokens;
            if (i3 < strArr.length) {
                arrayList.add(strArr[i3]);
                i3++;
            } else {
                return arrayList;
            }
        }
    }

    public StrMatcher getTrimmerMatcher() {
        return this.trimmerMatcher;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        checkTokenized();
        if (this.tokenPos < this.tokens.length) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        checkTokenized();
        if (this.tokenPos > 0) {
            return true;
        }
        return false;
    }

    public boolean isEmptyTokenAsNull() {
        return this.emptyAsNull;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.ignoreEmptyTokens;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (hasNext()) {
            String[] strArr = this.tokens;
            int i3 = this.tokenPos;
            this.tokenPos = i3 + 1;
            return strArr[i3];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.tokenPos;
    }

    public String nextToken() {
        if (hasNext()) {
            String[] strArr = this.tokens;
            int i3 = this.tokenPos;
            this.tokenPos = i3 + 1;
            return strArr[i3];
        }
        return null;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (hasPrevious()) {
            String[] strArr = this.tokens;
            int i3 = this.tokenPos - 1;
            this.tokenPos = i3;
            return strArr[i3];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.tokenPos - 1;
    }

    public String previousToken() {
        if (hasPrevious()) {
            String[] strArr = this.tokens;
            int i3 = this.tokenPos - 1;
            this.tokenPos = i3;
            return strArr[i3];
        }
        return null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public StrTokenizer reset() {
        this.tokenPos = 0;
        this.tokens = null;
        return this;
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public StrTokenizer setDelimiterChar(char c16) {
        return setDelimiterMatcher(StrMatcher.charMatcher(c16));
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            this.delimMatcher = StrMatcher.noneMatcher();
        } else {
            this.delimMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setDelimiterString(String str) {
        return setDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    public StrTokenizer setEmptyTokenAsNull(boolean z16) {
        this.emptyAsNull = z16;
        return this;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean z16) {
        this.ignoreEmptyTokens = z16;
        return this;
    }

    public StrTokenizer setIgnoredChar(char c16) {
        return setIgnoredMatcher(StrMatcher.charMatcher(c16));
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.ignoredMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setQuoteChar(char c16) {
        return setQuoteMatcher(StrMatcher.charMatcher(c16));
    }

    public StrTokenizer setQuoteMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.quoteMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.trimmerMatcher = strMatcher;
        }
        return this;
    }

    public int size() {
        checkTokenized();
        return this.tokens.length;
    }

    public String toString() {
        if (this.tokens == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StrTokenizer");
        stringBuffer.append(getTokenList());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List tokenize(char[] cArr, int i3, int i16) {
        if (cArr != null && i16 != 0) {
            StrBuilder strBuilder = new StrBuilder();
            ArrayList arrayList = new ArrayList();
            int i17 = i3;
            while (i17 >= 0 && i17 < i16) {
                i17 = readNextToken(cArr, i17, i16, strBuilder, arrayList);
                if (i17 >= i16) {
                    addToken(arrayList, "");
                }
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    public static StrTokenizer getCSVInstance(String str) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(str);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(String str) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(str);
        return tSVClone;
    }

    public StrTokenizer reset(String str) {
        reset();
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
        return this;
    }

    public static StrTokenizer getCSVInstance(char[] cArr) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(cArr);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(char[] cArr) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(cArr);
        return tSVClone;
    }

    public StrTokenizer reset(char[] cArr) {
        reset();
        this.chars = cArr;
        return this;
    }

    public StrTokenizer(String str) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
    }

    public StrTokenizer(String str, char c16) {
        this(str);
        setDelimiterChar(c16);
    }

    public StrTokenizer(String str, String str2) {
        this(str);
        setDelimiterString(str2);
    }

    public StrTokenizer(String str, StrMatcher strMatcher) {
        this(str);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(String str, char c16, char c17) {
        this(str, c16);
        setQuoteChar(c17);
    }

    public StrTokenizer(String str, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(str, strMatcher);
        setQuoteMatcher(strMatcher2);
    }

    public StrTokenizer(char[] cArr) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = cArr;
    }

    public StrTokenizer(char[] cArr, char c16) {
        this(cArr);
        setDelimiterChar(c16);
    }

    public StrTokenizer(char[] cArr, String str) {
        this(cArr);
        setDelimiterString(str);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher) {
        this(cArr);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(char[] cArr, char c16, char c17) {
        this(cArr, c16);
        setQuoteChar(c17);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(cArr, strMatcher);
        setQuoteMatcher(strMatcher2);
    }
}
