package org.apache.httpcore.message;

import org.apache.httpcore.HeaderElement;
import org.apache.httpcore.NameValuePair;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class BasicHeaderValueFormatter implements HeaderValueFormatter {

    @Deprecated
    public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
    public static final BasicHeaderValueFormatter INSTANCE = new BasicHeaderValueFormatter();
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    public static String formatElements(HeaderElement[] headerElementArr, boolean z16, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatElements(null, headerElementArr, z16).toString();
    }

    public static String formatHeaderElement(HeaderElement headerElement, boolean z16, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatHeaderElement(null, headerElement, z16).toString();
    }

    public static String formatNameValuePair(NameValuePair nameValuePair, boolean z16, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatNameValuePair(null, nameValuePair, z16).toString();
    }

    public static String formatParameters(NameValuePair[] nameValuePairArr, boolean z16, HeaderValueFormatter headerValueFormatter) {
        if (headerValueFormatter == null) {
            headerValueFormatter = INSTANCE;
        }
        return headerValueFormatter.formatParameters(null, nameValuePairArr, z16).toString();
    }

    protected void doFormatValue(CharArrayBuffer charArrayBuffer, String str, boolean z16) {
        if (!z16) {
            for (int i3 = 0; i3 < str.length() && !z16; i3++) {
                z16 = isSeparator(str.charAt(i3));
            }
        }
        if (z16) {
            charArrayBuffer.append('\"');
        }
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (isUnsafe(charAt)) {
                charArrayBuffer.append('\\');
            }
            charArrayBuffer.append(charAt);
        }
        if (z16) {
            charArrayBuffer.append('\"');
        }
    }

    protected int estimateElementsLen(HeaderElement[] headerElementArr) {
        if (headerElementArr == null || headerElementArr.length < 1) {
            return 0;
        }
        int length = (headerElementArr.length - 1) * 2;
        for (HeaderElement headerElement : headerElementArr) {
            length += estimateHeaderElementLen(headerElement);
        }
        return length;
    }

    protected int estimateHeaderElementLen(HeaderElement headerElement) {
        if (headerElement == null) {
            return 0;
        }
        int length = headerElement.getName().length();
        String value = headerElement.getValue();
        if (value != null) {
            length += value.length() + 3;
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount > 0) {
            for (int i3 = 0; i3 < parameterCount; i3++) {
                length += estimateNameValuePairLen(headerElement.getParameter(i3)) + 2;
            }
        }
        return length;
    }

    protected int estimateNameValuePairLen(NameValuePair nameValuePair) {
        if (nameValuePair == null) {
            return 0;
        }
        int length = nameValuePair.getName().length();
        String value = nameValuePair.getValue();
        if (value != null) {
            return length + value.length() + 3;
        }
        return length;
    }

    protected int estimateParametersLen(NameValuePair[] nameValuePairArr) {
        if (nameValuePairArr == null || nameValuePairArr.length < 1) {
            return 0;
        }
        int length = (nameValuePairArr.length - 1) * 2;
        for (NameValuePair nameValuePair : nameValuePairArr) {
            length += estimateNameValuePairLen(nameValuePair);
        }
        return length;
    }

    protected boolean isSeparator(char c16) {
        if (" ;,:@()<>\\\"/[]?={}\t".indexOf(c16) >= 0) {
            return true;
        }
        return false;
    }

    protected boolean isUnsafe(char c16) {
        if ("\"\\".indexOf(c16) >= 0) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer charArrayBuffer, HeaderElement[] headerElementArr, boolean z16) {
        Args.notNull(headerElementArr, "Header element array");
        int estimateElementsLen = estimateElementsLen(headerElementArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateElementsLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateElementsLen);
        }
        for (int i3 = 0; i3 < headerElementArr.length; i3++) {
            if (i3 > 0) {
                charArrayBuffer.append(", ");
            }
            formatHeaderElement(charArrayBuffer, headerElementArr[i3], z16);
        }
        return charArrayBuffer;
    }

    @Override // org.apache.httpcore.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer charArrayBuffer, HeaderElement headerElement, boolean z16) {
        Args.notNull(headerElement, "Header element");
        int estimateHeaderElementLen = estimateHeaderElementLen(headerElement);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateHeaderElementLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateHeaderElementLen);
        }
        charArrayBuffer.append(headerElement.getName());
        String value = headerElement.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            doFormatValue(charArrayBuffer, value, z16);
        }
        int parameterCount = headerElement.getParameterCount();
        if (parameterCount > 0) {
            for (int i3 = 0; i3 < parameterCount; i3++) {
                charArrayBuffer.append("; ");
                formatNameValuePair(charArrayBuffer, headerElement.getParameter(i3), z16);
            }
        }
        return charArrayBuffer;
    }

    @Override // org.apache.httpcore.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer charArrayBuffer, NameValuePair nameValuePair, boolean z16) {
        Args.notNull(nameValuePair, "Name / value pair");
        int estimateNameValuePairLen = estimateNameValuePairLen(nameValuePair);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateNameValuePairLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateNameValuePairLen);
        }
        charArrayBuffer.append(nameValuePair.getName());
        String value = nameValuePair.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            doFormatValue(charArrayBuffer, value, z16);
        }
        return charArrayBuffer;
    }

    @Override // org.apache.httpcore.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer charArrayBuffer, NameValuePair[] nameValuePairArr, boolean z16) {
        Args.notNull(nameValuePairArr, "Header parameter array");
        int estimateParametersLen = estimateParametersLen(nameValuePairArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(estimateParametersLen);
        } else {
            charArrayBuffer.ensureCapacity(estimateParametersLen);
        }
        for (int i3 = 0; i3 < nameValuePairArr.length; i3++) {
            if (i3 > 0) {
                charArrayBuffer.append("; ");
            }
            formatNameValuePair(charArrayBuffer, nameValuePairArr[i3], z16);
        }
        return charArrayBuffer;
    }
}
