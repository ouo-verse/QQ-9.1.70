package org.apache.commons.lang.text;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.Validate;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExtendedMessageFormat extends MessageFormat {
    private static final String DUMMY_PATTERN = "";
    private static final char END_FE = '}';
    private static final String ESCAPED_QUOTE = "''";
    private static final int HASH_SEED = 31;
    private static final char QUOTE = '\'';
    private static final char START_FE = '{';
    private static final char START_FMT = ',';
    private static final long serialVersionUID = -2362048321261811743L;
    private final Map registry;
    private String toPattern;

    public ExtendedMessageFormat(String str) {
        this(str, Locale.getDefault());
    }

    private StrBuilder appendQuotedString(String str, ParsePosition parsePosition, StrBuilder strBuilder, boolean z16) {
        int index = parsePosition.getIndex();
        char[] charArray = str.toCharArray();
        if (z16 && charArray[index] == '\'') {
            next(parsePosition);
            if (strBuilder == null) {
                return null;
            }
            return strBuilder.append(QUOTE);
        }
        int i3 = index;
        for (int index2 = parsePosition.getIndex(); index2 < str.length(); index2++) {
            if (z16 && str.substring(index2).startsWith(ESCAPED_QUOTE)) {
                strBuilder.append(charArray, i3, parsePosition.getIndex() - i3).append(QUOTE);
                parsePosition.setIndex(index2 + 2);
                i3 = parsePosition.getIndex();
            } else if (charArray[parsePosition.getIndex()] != '\'') {
                next(parsePosition);
            } else {
                next(parsePosition);
                if (strBuilder == null) {
                    return null;
                }
                return strBuilder.append(charArray, i3, parsePosition.getIndex() - i3);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unterminated quoted string at position ");
        stringBuffer.append(index);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    private boolean containsElements(Collection collection) {
        if (collection != null && collection.size() != 0) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Format getFormat(String str) {
        String str2;
        if (this.registry != null) {
            int indexOf = str.indexOf(44);
            if (indexOf > 0) {
                String trim = str.substring(0, indexOf).trim();
                str2 = str.substring(indexOf + 1).trim();
                str = trim;
            } else {
                str2 = null;
            }
            FormatFactory formatFactory = (FormatFactory) this.registry.get(str);
            if (formatFactory != null) {
                return formatFactory.getFormat(str, str2, getLocale());
            }
        }
        return null;
    }

    private void getQuotedString(String str, ParsePosition parsePosition, boolean z16) {
        appendQuotedString(str, parsePosition, null, z16);
    }

    private String insertFormats(String str, ArrayList arrayList) {
        if (!containsElements(arrayList)) {
            return str;
        }
        StrBuilder strBuilder = new StrBuilder(str.length() * 2);
        ParsePosition parsePosition = new ParsePosition(0);
        int i3 = -1;
        int i16 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt != '\'') {
                if (charAt != '{') {
                    if (charAt == '}') {
                        i16--;
                    }
                    strBuilder.append(charAt);
                    next(parsePosition);
                } else {
                    i16++;
                    if (i16 == 1) {
                        i3++;
                        strBuilder.append(START_FE).append(readArgumentIndex(str, next(parsePosition)));
                        String str2 = (String) arrayList.get(i3);
                        if (str2 != null) {
                            strBuilder.append(START_FMT).append(str2);
                        }
                    }
                }
            } else {
                appendQuotedString(str, parsePosition, strBuilder, false);
            }
        }
        return strBuilder.toString();
    }

    private ParsePosition next(ParsePosition parsePosition) {
        parsePosition.setIndex(parsePosition.getIndex() + 1);
        return parsePosition;
    }

    private String parseFormatDescription(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        int index2 = parsePosition.getIndex();
        int i3 = 1;
        while (parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (charAt != '\'') {
                if (charAt != '{') {
                    if (charAt == '}' && i3 - 1 == 0) {
                        return str.substring(index2, parsePosition.getIndex());
                    }
                } else {
                    i3++;
                }
            } else {
                getQuotedString(str, parsePosition, false);
            }
            next(parsePosition);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unterminated format element at position ");
        stringBuffer.append(index);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    private int readArgumentIndex(String str, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        seekNonWs(str, parsePosition);
        StrBuilder strBuilder = new StrBuilder();
        boolean z16 = false;
        while (!z16 && parsePosition.getIndex() < str.length()) {
            char charAt = str.charAt(parsePosition.getIndex());
            if (Character.isWhitespace(charAt)) {
                seekNonWs(str, parsePosition);
                charAt = str.charAt(parsePosition.getIndex());
                if (charAt != ',' && charAt != '}') {
                    z16 = true;
                    next(parsePosition);
                }
            }
            if ((charAt == ',' || charAt == '}') && strBuilder.length() > 0) {
                try {
                    return Integer.parseInt(strBuilder.toString());
                } catch (NumberFormatException unused) {
                }
            }
            boolean z17 = !Character.isDigit(charAt);
            strBuilder.append(charAt);
            z16 = z17;
            next(parsePosition);
        }
        if (z16) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid format argument index at position ");
            stringBuffer.append(index);
            stringBuffer.append(MsgSummary.STR_COLON);
            stringBuffer.append(str.substring(index, parsePosition.getIndex()));
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Unterminated format element at position ");
        stringBuffer2.append(index);
        throw new IllegalArgumentException(stringBuffer2.toString());
    }

    private void seekNonWs(String str, ParsePosition parsePosition) {
        char[] charArray = str.toCharArray();
        do {
            int isMatch = StrMatcher.splitMatcher().isMatch(charArray, parsePosition.getIndex());
            parsePosition.setIndex(parsePosition.getIndex() + isMatch);
            if (isMatch <= 0) {
                return;
            }
        } while (parsePosition.getIndex() < str.length());
    }

    @Override // java.text.MessageFormat
    public final void applyPattern(String str) {
        String str2;
        Format format;
        boolean z16;
        if (this.registry == null) {
            super.applyPattern(str);
            this.toPattern = super.toPattern();
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StrBuilder strBuilder = new StrBuilder(str.length());
        int i3 = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        char[] charArray = str.toCharArray();
        int i16 = 0;
        while (parsePosition.getIndex() < str.length()) {
            char c16 = charArray[parsePosition.getIndex()];
            boolean z17 = true;
            if (c16 != '\'') {
                if (c16 == '{') {
                    i16++;
                    seekNonWs(str, parsePosition);
                    int index = parsePosition.getIndex();
                    strBuilder.append(START_FE).append(readArgumentIndex(str, next(parsePosition)));
                    seekNonWs(str, parsePosition);
                    String str3 = null;
                    if (charArray[parsePosition.getIndex()] == ',') {
                        str2 = parseFormatDescription(str, next(parsePosition));
                        format = getFormat(str2);
                        if (format == null) {
                            strBuilder.append(START_FMT).append(str2);
                        }
                    } else {
                        str2 = null;
                        format = null;
                    }
                    arrayList.add(format);
                    if (format != null) {
                        str3 = str2;
                    }
                    arrayList2.add(str3);
                    if (arrayList.size() == i16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Validate.isTrue(z16);
                    if (arrayList2.size() != i16) {
                        z17 = false;
                    }
                    Validate.isTrue(z17);
                    if (charArray[parsePosition.getIndex()] != '}') {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Unreadable format element at position ");
                        stringBuffer.append(index);
                        throw new IllegalArgumentException(stringBuffer.toString());
                    }
                }
                strBuilder.append(charArray[parsePosition.getIndex()]);
                next(parsePosition);
            } else {
                appendQuotedString(str, parsePosition, strBuilder, true);
            }
        }
        super.applyPattern(strBuilder.toString());
        this.toPattern = insertFormats(super.toPattern(), arrayList2);
        if (containsElements(arrayList)) {
            Format[] formats = getFormats();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Format format2 = (Format) it.next();
                if (format2 != null) {
                    formats[i3] = format2;
                }
                i3++;
            }
            super.setFormats(formats);
        }
    }

    @Override // java.text.MessageFormat
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !super.equals(obj) || ObjectUtils.notEqual(getClass(), obj.getClass())) {
            return false;
        }
        ExtendedMessageFormat extendedMessageFormat = (ExtendedMessageFormat) obj;
        if (!ObjectUtils.notEqual(this.toPattern, extendedMessageFormat.toPattern) && !ObjectUtils.notEqual(this.registry, extendedMessageFormat.registry)) {
            return true;
        }
        return false;
    }

    @Override // java.text.MessageFormat
    public int hashCode() {
        return (((super.hashCode() * 31) + ObjectUtils.hashCode(this.registry)) * 31) + ObjectUtils.hashCode(this.toPattern);
    }

    @Override // java.text.MessageFormat
    public void setFormat(int i3, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatByArgumentIndex(int i3, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public String toPattern() {
        return this.toPattern;
    }

    public ExtendedMessageFormat(String str, Locale locale) {
        this(str, locale, null);
    }

    public ExtendedMessageFormat(String str, Map map) {
        this(str, Locale.getDefault(), map);
    }

    public ExtendedMessageFormat(String str, Locale locale, Map map) {
        super("");
        setLocale(locale);
        this.registry = map;
        applyPattern(str);
    }
}
