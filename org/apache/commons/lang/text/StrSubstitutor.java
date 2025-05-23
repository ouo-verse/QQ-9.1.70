package org.apache.commons.lang.text;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private StrMatcher suffixMatcher;
    private StrLookup variableResolver;

    public StrSubstitutor() {
        this((StrLookup) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List list) {
        if (!list.contains(str)) {
            return;
        }
        StrBuilder strBuilder = new StrBuilder(256);
        strBuilder.append("Infinite loop in property interpolation of ");
        strBuilder.append(list.remove(0));
        strBuilder.append(MsgSummary.STR_COLON);
        strBuilder.appendWithSeparators(list, "->");
        throw new IllegalStateException(strBuilder.toString());
    }

    public static String replace(Object obj, Map map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    protected String resolveVariable(String str, StrBuilder strBuilder, int i3, int i16) {
        StrLookup variableResolver = getVariableResolver();
        if (variableResolver == null) {
            return null;
        }
        return variableResolver.lookup(str);
    }

    public void setEnableSubstitutionInVariables(boolean z16) {
        this.enableSubstitutionInVariables = z16;
    }

    public void setEscapeChar(char c16) {
        this.escapeChar = c16;
    }

    public StrSubstitutor setVariablePrefix(char c16) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c16));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.prefixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    }

    public void setVariableResolver(StrLookup strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c16) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c16));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.suffixMatcher = strMatcher;
            return this;
        }
        throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    }

    protected boolean substitute(StrBuilder strBuilder, int i3, int i16) {
        return substitute(strBuilder, i3, i16, null) > 0;
    }

    public StrSubstitutor(Map map) {
        this(StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static String replace(Object obj, Map map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    private int substitute(StrBuilder strBuilder, int i3, int i16, List list) {
        StrMatcher strMatcher;
        StrMatcher strMatcher2;
        boolean z16;
        int isMatch;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar = getEscapeChar();
        boolean z17 = list == null;
        int i17 = i3;
        int i18 = i3 + i16;
        int i19 = 0;
        int i26 = 0;
        char[] cArr = strBuilder.buffer;
        List list2 = list;
        while (i17 < i18) {
            int isMatch2 = variablePrefixMatcher.isMatch(cArr, i17, i3, i18);
            if (isMatch2 != 0) {
                if (i17 > i3) {
                    int i27 = i17 - 1;
                    if (cArr[i27] == escapeChar) {
                        strBuilder.deleteCharAt(i27);
                        i19--;
                        i18--;
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        cArr = strBuilder.buffer;
                        i26 = 1;
                    }
                }
                int i28 = i17 + isMatch2;
                int i29 = i28;
                int i36 = 0;
                while (true) {
                    if (i29 >= i18) {
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        i17 = i29;
                        break;
                    }
                    if (!isEnableSubstitutionInVariables() || (isMatch = variablePrefixMatcher.isMatch(cArr, i29, i3, i18)) == 0) {
                        int isMatch3 = variableSuffixMatcher.isMatch(cArr, i29, i3, i18);
                        if (isMatch3 == 0) {
                            i29++;
                        } else if (i36 == 0) {
                            strMatcher = variablePrefixMatcher;
                            strMatcher2 = variableSuffixMatcher;
                            String str = new String(cArr, i28, (i29 - i17) - isMatch2);
                            if (isEnableSubstitutionInVariables()) {
                                StrBuilder strBuilder2 = new StrBuilder(str);
                                z16 = false;
                                substitute(strBuilder2, 0, strBuilder2.length());
                                str = strBuilder2.toString();
                            } else {
                                z16 = false;
                            }
                            int i37 = i29 + isMatch3;
                            if (list2 == null) {
                                list2 = new ArrayList();
                                list2.add(new String(cArr, i3, i16));
                            }
                            checkCyclicSubstitution(str, list2);
                            list2.add(str);
                            String resolveVariable = resolveVariable(str, strBuilder, i17, i37);
                            if (resolveVariable != null) {
                                int length = resolveVariable.length();
                                strBuilder.replace(i17, i37, resolveVariable);
                                int substitute = substitute(strBuilder, i17, length, list2) + (length - (i37 - i17));
                                i18 += substitute;
                                i19 += substitute;
                                cArr = strBuilder.buffer;
                                i17 = i37 + substitute;
                                i26 = 1;
                            } else {
                                i17 = i37;
                            }
                            list2.remove(list2.size() - 1);
                        } else {
                            i36--;
                            i29 += isMatch3;
                            variablePrefixMatcher = variablePrefixMatcher;
                            variableSuffixMatcher = variableSuffixMatcher;
                        }
                    } else {
                        i36++;
                        i29 += isMatch;
                    }
                }
            } else {
                i17++;
                strMatcher = variablePrefixMatcher;
                strMatcher2 = variableSuffixMatcher;
            }
            variablePrefixMatcher = strMatcher;
            variableSuffixMatcher = strMatcher2;
        }
        return z17 ? i26 : i19;
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i3, int i16) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder append = new StrBuilder(i16).append(stringBuffer, i3, i16);
        if (!substitute(append, 0, i16)) {
            return false;
        }
        stringBuffer.replace(i3, i16 + i3, append.toString());
        return true;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    public StrSubstitutor(Map map, String str, String str2) {
        this(StrLookup.mapLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public StrSubstitutor(Map map, String str, String str2, char c16) {
        this(StrLookup.mapLookup(map), str, str2, c16);
    }

    public StrSubstitutor(StrLookup strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public StrSubstitutor(StrLookup strLookup, String str, String str2, char c16) {
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c16);
    }

    public boolean replaceIn(StrBuilder strBuilder, int i3, int i16) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i3, i16);
    }

    public StrSubstitutor(StrLookup strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c16) {
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c16);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
    }

    public String replace(String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i16).append(str, i3, i16);
        if (!substitute(append, 0, i16)) {
            return str.substring(i3, i16 + i3);
        }
        return append.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public String replace(char[] cArr, int i3, int i16) {
        if (cArr == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i16).append(cArr, i3, i16);
        substitute(append, 0, i16);
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i3, int i16) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i16).append(stringBuffer, i3, i16);
        substitute(append, 0, i16);
        return append.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StrBuilder strBuilder, int i3, int i16) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder append = new StrBuilder(i16).append(strBuilder, i3, i16);
        substitute(append, 0, i16);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder append = new StrBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }
}
