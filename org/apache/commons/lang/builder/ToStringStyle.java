package org.apache.commons.lang.builder;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.SystemUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    private boolean useFieldNames = true;
    private boolean useClassName = true;
    private boolean useShortClassName = false;
    private boolean useIdentityHashCode = true;
    private String contentStart = "[";
    private String contentEnd = "]";
    private String fieldNameValueSeparator = ContainerUtils.KEY_VALUE_DELIMITER;
    private boolean fieldSeparatorAtStart = false;
    private boolean fieldSeparatorAtEnd = false;
    private String fieldSeparator = ",";
    private String arrayStart = "{";
    private String arraySeparator = ",";
    private boolean arrayContentDetail = true;
    private String arrayEnd = "}";
    private boolean defaultFullDetail = true;
    private String nullText = "<null>";
    private String sizeStartText = "<size=";
    private String sizeEndText = ">";
    private String summaryObjectStartText = "<";
    private String summaryObjectEndText = ">";

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class DefaultToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        DefaultToStringStyle() {
        }

        private Object readResolve() {
            return ToStringStyle.DEFAULT_STYLE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class MultiLineToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        MultiLineToStringStyle() {
            setContentStart("[");
            StringBuffer stringBuffer = new StringBuffer();
            String str = SystemUtils.LINE_SEPARATOR;
            stringBuffer.append(str);
            stringBuffer.append("  ");
            setFieldSeparator(stringBuffer.toString());
            setFieldSeparatorAtStart(true);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append("]");
            setContentEnd(stringBuffer2.toString());
        }

        private Object readResolve() {
            return ToStringStyle.MULTI_LINE_STYLE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class NoFieldNameToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        NoFieldNameToStringStyle() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class ShortPrefixToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        ShortPrefixToStringStyle() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class SimpleToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        SimpleToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return ToStringStyle.SIMPLE_STYLE;
        }
    }

    static Map getRegistry() {
        return (Map) REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Map registry = getRegistry();
        if (registry != null && registry.containsKey(obj)) {
            return true;
        }
        return false;
    }

    static void register(Object obj) {
        if (obj != null) {
            Map registry = getRegistry();
            if (registry == null) {
                registry = new WeakHashMap();
                REGISTRY.set(registry);
            }
            registry.put(obj, null);
        }
    }

    static void unregister(Object obj) {
        Map registry;
        if (obj != null && (registry = getRegistry()) != null) {
            registry.remove(obj);
            if (registry.isEmpty()) {
                REGISTRY.set(null);
            }
        }
    }

    public void append(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (obj == null) {
            appendNullText(stringBuffer, str);
        } else {
            appendInternal(stringBuffer, str, obj, isFullDetail(bool));
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendClassName(StringBuffer stringBuffer, Object obj) {
        if (this.useClassName && obj != null) {
            register(obj);
            if (this.useShortClassName) {
                stringBuffer.append(getShortClassName(obj.getClass()));
            } else {
                stringBuffer.append(obj.getClass().getName());
            }
        }
    }

    protected void appendContentEnd(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentEnd);
    }

    protected void appendContentStart(StringBuffer stringBuffer) {
        stringBuffer.append(this.contentStart);
    }

    protected void appendCyclicObject(StringBuffer stringBuffer, String str, Object obj) {
        ObjectUtils.identityToString(stringBuffer, obj);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    public void appendEnd(StringBuffer stringBuffer, Object obj) {
        if (!this.fieldSeparatorAtEnd) {
            removeLastFieldSeparator(stringBuffer);
        }
        appendContentEnd(stringBuffer);
        unregister(obj);
    }

    protected void appendFieldEnd(StringBuffer stringBuffer, String str) {
        appendFieldSeparator(stringBuffer);
    }

    protected void appendFieldSeparator(StringBuffer stringBuffer) {
        stringBuffer.append(this.fieldSeparator);
    }

    protected void appendFieldStart(StringBuffer stringBuffer, String str) {
        if (this.useFieldNames && str != null) {
            stringBuffer.append(str);
            stringBuffer.append(this.fieldNameValueSeparator);
        }
    }

    protected void appendIdentityHashCode(StringBuffer stringBuffer, Object obj) {
        if (isUseIdentityHashCode() && obj != null) {
            register(obj);
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    protected void appendInternal(StringBuffer stringBuffer, String str, Object obj, boolean z16) {
        if (isRegistered(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            appendCyclicObject(stringBuffer, str, obj);
            return;
        }
        register(obj);
        try {
            if (obj instanceof Collection) {
                if (z16) {
                    appendDetail(stringBuffer, str, (Collection) obj);
                } else {
                    appendSummarySize(stringBuffer, str, ((Collection) obj).size());
                }
            } else if (obj instanceof Map) {
                if (z16) {
                    appendDetail(stringBuffer, str, (Map) obj);
                } else {
                    appendSummarySize(stringBuffer, str, ((Map) obj).size());
                }
            } else if (obj instanceof long[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (long[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (int[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (short[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (byte[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (char[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (double[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (float[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z16) {
                    appendDetail(stringBuffer, str, (boolean[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z16) {
                    appendDetail(stringBuffer, str, (Object[]) obj);
                } else {
                    appendSummary(stringBuffer, str, (Object[]) obj);
                }
            } else if (z16) {
                appendDetail(stringBuffer, str, obj);
            } else {
                appendSummary(stringBuffer, str, obj);
            }
        } finally {
            unregister(obj);
        }
    }

    protected void appendNullText(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.nullText);
    }

    public void appendStart(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            appendClassName(stringBuffer, obj);
            appendIdentityHashCode(stringBuffer, obj);
            appendContentStart(stringBuffer);
            if (this.fieldSeparatorAtStart) {
                appendFieldSeparator(stringBuffer);
            }
        }
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.summaryObjectStartText);
        stringBuffer.append(getShortClassName(obj.getClass()));
        stringBuffer.append(this.summaryObjectEndText);
    }

    protected void appendSummarySize(StringBuffer stringBuffer, String str, int i3) {
        stringBuffer.append(this.sizeStartText);
        stringBuffer.append(i3);
        stringBuffer.append(this.sizeEndText);
    }

    public void appendSuper(StringBuffer stringBuffer, String str) {
        appendToString(stringBuffer, str);
    }

    public void appendToString(StringBuffer stringBuffer, String str) {
        int indexOf;
        int lastIndexOf;
        if (str != null && (indexOf = str.indexOf(this.contentStart) + this.contentStart.length()) != (lastIndexOf = str.lastIndexOf(this.contentEnd)) && indexOf >= 0 && lastIndexOf >= 0) {
            String substring = str.substring(indexOf, lastIndexOf);
            if (this.fieldSeparatorAtStart) {
                removeLastFieldSeparator(stringBuffer);
            }
            stringBuffer.append(substring);
            appendFieldSeparator(stringBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getArrayEnd() {
        return this.arrayEnd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getArraySeparator() {
        return this.arraySeparator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getArrayStart() {
        return this.arrayStart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getContentEnd() {
        return this.contentEnd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getContentStart() {
        return this.contentStart;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFieldSeparator() {
        return this.fieldSeparator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNullText() {
        return this.nullText;
    }

    protected String getShortClassName(Class cls) {
        return ClassUtils.getShortClassName(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSizeEndText() {
        return this.sizeEndText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSizeStartText() {
        return this.sizeStartText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    protected boolean isFullDetail(Boolean bool) {
        if (bool == null) {
            return this.defaultFullDetail;
        }
        return bool.booleanValue();
    }

    protected boolean isShortClassName() {
        return this.useShortClassName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUseClassName() {
        return this.useClassName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.arrayStart);
        int length = Array.getLength(obj);
        for (int i3 = 0; i3 < length; i3++) {
            Object obj2 = Array.get(obj, i3);
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj2 == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj2, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void removeLastFieldSeparator(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        int length2 = this.fieldSeparator.length();
        if (length > 0 && length2 > 0 && length >= length2) {
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    if (stringBuffer.charAt((length - 1) - i3) != this.fieldSeparator.charAt((length2 - 1) - i3)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                stringBuffer.setLength(length - length2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setArrayContentDetail(boolean z16) {
        this.arrayContentDetail = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setArrayEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayEnd = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setArraySeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.arraySeparator = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setArrayStart(String str) {
        if (str == null) {
            str = "";
        }
        this.arrayStart = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentEnd(String str) {
        if (str == null) {
            str = "";
        }
        this.contentEnd = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContentStart(String str) {
        if (str == null) {
            str = "";
        }
        this.contentStart = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDefaultFullDetail(boolean z16) {
        this.defaultFullDetail = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFieldNameValueSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldNameValueSeparator = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFieldSeparator(String str) {
        if (str == null) {
            str = "";
        }
        this.fieldSeparator = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFieldSeparatorAtEnd(boolean z16) {
        this.fieldSeparatorAtEnd = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFieldSeparatorAtStart(boolean z16) {
        this.fieldSeparatorAtStart = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNullText(String str) {
        if (str == null) {
            str = "";
        }
        this.nullText = str;
    }

    protected void setShortClassName(boolean z16) {
        this.useShortClassName = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSizeEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeEndText = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSizeStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.sizeStartText = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSummaryObjectEndText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectEndText = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSummaryObjectStartText(String str) {
        if (str == null) {
            str = "";
        }
        this.summaryObjectStartText = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUseClassName(boolean z16) {
        this.useClassName = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUseFieldNames(boolean z16) {
        this.useFieldNames = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUseIdentityHashCode(boolean z16) {
        this.useIdentityHashCode = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUseShortClassName(boolean z16) {
        this.useShortClassName = z16;
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Collection collection) {
        stringBuffer.append(collection);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Map map) {
        stringBuffer.append(map);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, long j3) {
        stringBuffer.append(j3);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, Object[] objArr) {
        appendSummarySize(stringBuffer, str, objArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, long j3) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, j3);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, int i3) {
        stringBuffer.append(i3);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, long[] jArr) {
        appendSummarySize(stringBuffer, str, jArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, short s16) {
        stringBuffer.append((int) s16);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, int[] iArr) {
        appendSummarySize(stringBuffer, str, iArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, byte b16) {
        stringBuffer.append((int) b16);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, short[] sArr) {
        appendSummarySize(stringBuffer, str, sArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, int i3) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, i3);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, char c16) {
        stringBuffer.append(c16);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, byte[] bArr) {
        appendSummarySize(stringBuffer, str, bArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, double d16) {
        stringBuffer.append(d16);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, char[] cArr) {
        appendSummarySize(stringBuffer, str, cArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, float f16) {
        stringBuffer.append(f16);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, double[] dArr) {
        appendSummarySize(stringBuffer, str, dArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, short s16) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, s16);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, boolean z16) {
        stringBuffer.append(z16);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, float[] fArr) {
        appendSummarySize(stringBuffer, str, fArr.length);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            if (obj == null) {
                appendNullText(stringBuffer, str);
            } else {
                appendInternal(stringBuffer, str, obj, this.arrayContentDetail);
            }
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendSummary(StringBuffer stringBuffer, String str, boolean[] zArr) {
        appendSummarySize(stringBuffer, str, zArr.length);
    }

    public void append(StringBuffer stringBuffer, String str, byte b16) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, b16);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, char c16) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, c16);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < jArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, jArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, double d16) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, d16);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, float f16) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, f16);
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, iArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, boolean z16) {
        appendFieldStart(stringBuffer, str);
        appendDetail(stringBuffer, str, z16);
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, Object[] objArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (objArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, objArr);
        } else {
            appendSummary(stringBuffer, str, objArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < sArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, sArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, bArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, long[] jArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (jArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, jArr);
        } else {
            appendSummary(stringBuffer, str, jArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, cArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, int[] iArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (iArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, iArr);
        } else {
            appendSummary(stringBuffer, str, iArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < dArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, dArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, short[] sArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (sArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, sArr);
        } else {
            appendSummary(stringBuffer, str, sArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < fArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, fArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, byte[] bArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (bArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, bArr);
        } else {
            appendSummary(stringBuffer, str, bArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    protected void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.arrayStart);
        for (int i3 = 0; i3 < zArr.length; i3++) {
            if (i3 > 0) {
                stringBuffer.append(this.arraySeparator);
            }
            appendDetail(stringBuffer, str, zArr[i3]);
        }
        stringBuffer.append(this.arrayEnd);
    }

    public void append(StringBuffer stringBuffer, String str, char[] cArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (cArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, cArr);
        } else {
            appendSummary(stringBuffer, str, cArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, double[] dArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (dArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, dArr);
        } else {
            appendSummary(stringBuffer, str, dArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, float[] fArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (fArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, fArr);
        } else {
            appendSummary(stringBuffer, str, fArr);
        }
        appendFieldEnd(stringBuffer, str);
    }

    public void append(StringBuffer stringBuffer, String str, boolean[] zArr, Boolean bool) {
        appendFieldStart(stringBuffer, str);
        if (zArr == null) {
            appendNullText(stringBuffer, str);
        } else if (isFullDetail(bool)) {
            appendDetail(stringBuffer, str, zArr);
        } else {
            appendSummary(stringBuffer, str, zArr);
        }
        appendFieldEnd(stringBuffer, str);
    }
}
