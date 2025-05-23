package org.apache.commons.lang;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringEscapeUtils {
    private static final char CSV_QUOTE = '\"';
    private static final String CSV_QUOTE_STR = String.valueOf('\"');
    private static final char CSV_DELIMITER = ',';
    private static final char[] CSV_SEARCH_CHARS = {CSV_DELIMITER, '\"', '\r', '\n'};

    public static String escapeCsv(String str) {
        if (StringUtils.containsNone(str, CSV_SEARCH_CHARS)) {
            return str;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            escapeCsv(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public static String escapeHtml(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter((int) (str.length() * 1.5d));
            escapeHtml(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public static String escapeJava(String str) {
        return escapeJavaStyleString(str, false, false);
    }

    public static String escapeJavaScript(String str) {
        return escapeJavaStyleString(str, true, true);
    }

    private static String escapeJavaStyleString(String str, boolean z16, boolean z17) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length() * 2);
            escapeJavaStyleString(stringWriter, str, z16, z17);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public static String escapeSql(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.replace(str, "'", "''");
    }

    public static void escapeXml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (str == null) {
            return;
        }
        Entities.XML.escape(writer, str);
    }

    private static String hex(char c16) {
        return Integer.toHexString(c16).toUpperCase(Locale.ENGLISH);
    }

    public static String unescapeCsv(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            unescapeCsv(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public static String unescapeHtml(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter((int) (str.length() * 1.5d));
            unescapeHtml(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public static String unescapeJava(String str) {
        if (str == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length());
            unescapeJava(stringWriter, str);
            return stringWriter.toString();
        } catch (IOException e16) {
            throw new UnhandledException(e16);
        }
    }

    public static String unescapeJavaScript(String str) {
        return unescapeJava(str);
    }

    public static void unescapeXml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (str == null) {
            return;
        }
        Entities.XML.unescape(writer, str);
    }

    public static void escapeJava(Writer writer, String str) throws IOException {
        escapeJavaStyleString(writer, str, false, false);
    }

    public static void escapeJavaScript(Writer writer, String str) throws IOException {
        escapeJavaStyleString(writer, str, true, true);
    }

    public static void unescapeJavaScript(Writer writer, String str) throws IOException {
        unescapeJava(writer, str);
    }

    public static String escapeXml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.XML.escape(str);
    }

    public static String unescapeXml(String str) {
        if (str == null) {
            return null;
        }
        return Entities.XML.unescape(str);
    }

    public static void escapeHtml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (str == null) {
            return;
        }
        Entities.HTML40.escape(writer, str);
    }

    private static void escapeJavaStyleString(Writer writer, String str, boolean z16, boolean z17) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (str == null) {
            return;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt > '\u0fff') {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\\u");
                stringBuffer.append(hex(charAt));
                writer.write(stringBuffer.toString());
            } else if (charAt > '\u00ff') {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("\\u0");
                stringBuffer2.append(hex(charAt));
                writer.write(stringBuffer2.toString());
            } else if (charAt > '\u007f') {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("\\u00");
                stringBuffer3.append(hex(charAt));
                writer.write(stringBuffer3.toString());
            } else if (charAt < ' ') {
                switch (charAt) {
                    case '\b':
                        writer.write(92);
                        writer.write(98);
                        break;
                    case '\t':
                        writer.write(92);
                        writer.write(116);
                        break;
                    case '\n':
                        writer.write(92);
                        writer.write(110);
                        break;
                    case 11:
                    default:
                        if (charAt > 15) {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("\\u00");
                            stringBuffer4.append(hex(charAt));
                            writer.write(stringBuffer4.toString());
                            break;
                        } else {
                            StringBuffer stringBuffer5 = new StringBuffer();
                            stringBuffer5.append("\\u000");
                            stringBuffer5.append(hex(charAt));
                            writer.write(stringBuffer5.toString());
                            break;
                        }
                    case '\f':
                        writer.write(92);
                        writer.write(102);
                        break;
                    case '\r':
                        writer.write(92);
                        writer.write(114);
                        break;
                }
            } else if (charAt == '\"') {
                writer.write(92);
                writer.write(34);
            } else if (charAt == '\'') {
                if (z16) {
                    writer.write(92);
                }
                writer.write(39);
            } else if (charAt == '/') {
                if (z17) {
                    writer.write(92);
                }
                writer.write(47);
            } else if (charAt != '\\') {
                writer.write(charAt);
            } else {
                writer.write(92);
                writer.write(92);
            }
        }
    }

    public static void unescapeCsv(Writer writer, String str) throws IOException {
        if (str == null) {
            return;
        }
        if (str.length() < 2) {
            writer.write(str);
            return;
        }
        if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
            String substring = str.substring(1, str.length() - 1);
            if (StringUtils.containsAny(substring, CSV_SEARCH_CHARS)) {
                StringBuffer stringBuffer = new StringBuffer();
                String str2 = CSV_QUOTE_STR;
                stringBuffer.append(str2);
                stringBuffer.append(str2);
                str = StringUtils.replace(substring, stringBuffer.toString(), str2);
            }
            writer.write(str);
            return;
        }
        writer.write(str);
    }

    public static void unescapeHtml(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null.");
        }
        if (str == null) {
            return;
        }
        Entities.HTML40.unescape(writer, str);
    }

    public static void unescapeJava(Writer writer, String str) throws IOException {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }
        if (str == null) {
            return;
        }
        int length = str.length();
        StrBuilder strBuilder = new StrBuilder(4);
        boolean z16 = false;
        boolean z17 = false;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (z17) {
                strBuilder.append(charAt);
                if (strBuilder.length() == 4) {
                    try {
                        writer.write((char) Integer.parseInt(strBuilder.toString(), 16));
                        strBuilder.setLength(0);
                        z16 = false;
                        z17 = false;
                    } catch (NumberFormatException e16) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Unable to parse unicode value: ");
                        stringBuffer.append(strBuilder);
                        throw new NestableRuntimeException(stringBuffer.toString(), e16);
                    }
                } else {
                    continue;
                }
            } else if (z16) {
                if (charAt == '\"') {
                    writer.write(34);
                } else if (charAt == '\'') {
                    writer.write(39);
                } else if (charAt == '\\') {
                    writer.write(92);
                } else if (charAt == 'b') {
                    writer.write(8);
                } else if (charAt == 'f') {
                    writer.write(12);
                } else if (charAt == 'n') {
                    writer.write(10);
                } else if (charAt == 'r') {
                    writer.write(13);
                } else if (charAt == 't') {
                    writer.write(9);
                } else if (charAt != 'u') {
                    writer.write(charAt);
                } else {
                    z16 = false;
                    z17 = true;
                }
                z16 = false;
            } else if (charAt == '\\') {
                z16 = true;
            } else {
                writer.write(charAt);
            }
        }
        if (z16) {
            writer.write(92);
        }
    }

    public static void escapeCsv(Writer writer, String str) throws IOException {
        if (StringUtils.containsNone(str, CSV_SEARCH_CHARS)) {
            if (str != null) {
                writer.write(str);
                return;
            }
            return;
        }
        writer.write(34);
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '\"') {
                writer.write(34);
            }
            writer.write(charAt);
        }
        writer.write(34);
    }
}
