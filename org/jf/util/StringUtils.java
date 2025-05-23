package org.jf.util;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringUtils {
    public static String escapeString(String str) {
        int length = str.length();
        StringBuilder sb5 = new StringBuilder((length * 3) / 2);
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= ' ' && charAt < '\u007f') {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    sb5.append('\\');
                }
                sb5.append(charAt);
            } else {
                if (charAt <= '\u007f') {
                    if (charAt != '\t') {
                        if (charAt != '\n') {
                            if (charAt == '\r') {
                                sb5.append("\\r");
                            }
                        } else {
                            sb5.append(RedTouch.NEWLINE_CHAR);
                        }
                    } else {
                        sb5.append("\\t");
                    }
                }
                sb5.append("\\u");
                sb5.append(Character.forDigit(charAt >> '\f', 16));
                sb5.append(Character.forDigit((charAt >> '\b') & 15, 16));
                sb5.append(Character.forDigit((charAt >> 4) & 15, 16));
                sb5.append(Character.forDigit(charAt & 15, 16));
            }
        }
        return sb5.toString();
    }

    @Deprecated
    public static void writeEscapedChar(Writer writer, char c16) throws IOException {
        if (c16 >= ' ' && c16 < '\u007f') {
            if (c16 == '\'' || c16 == '\"' || c16 == '\\') {
                writer.write(92);
            }
            writer.write(c16);
            return;
        }
        if (c16 <= '\u007f') {
            if (c16 != '\t') {
                if (c16 != '\n') {
                    if (c16 == '\r') {
                        writer.write("\\r");
                        return;
                    }
                } else {
                    writer.write(RedTouch.NEWLINE_CHAR);
                    return;
                }
            } else {
                writer.write("\\t");
                return;
            }
        }
        writer.write("\\u");
        writer.write(Character.forDigit(c16 >> '\f', 16));
        writer.write(Character.forDigit((c16 >> '\b') & 15, 16));
        writer.write(Character.forDigit((c16 >> 4) & 15, 16));
        writer.write(Character.forDigit(c16 & 15, 16));
    }

    @Deprecated
    public static void writeEscapedString(Writer writer, String str) throws IOException {
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt >= ' ' && charAt < '\u007f') {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    writer.write(92);
                }
                writer.write(charAt);
            } else {
                if (charAt <= '\u007f') {
                    if (charAt != '\t') {
                        if (charAt != '\n') {
                            if (charAt == '\r') {
                                writer.write("\\r");
                            }
                        } else {
                            writer.write(RedTouch.NEWLINE_CHAR);
                        }
                    } else {
                        writer.write("\\t");
                    }
                }
                writer.write("\\u");
                writer.write(Character.forDigit(charAt >> '\f', 16));
                writer.write(Character.forDigit((charAt >> '\b') & 15, 16));
                writer.write(Character.forDigit((charAt >> 4) & 15, 16));
                writer.write(Character.forDigit(charAt & 15, 16));
            }
        }
    }
}
