package org.apache.commons.lang.p020enum;

import com.huawei.hms.framework.common.ContainerUtils;
import org.apache.commons.lang.ClassUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ValuedEnum extends Enum {
    private static final long serialVersionUID = -7129650521543789085L;
    private final int iValue;

    protected ValuedEnum(String str, int i3) {
        super(str);
        this.iValue = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Enum getEnum(Class cls, int i3) {
        if (cls != null) {
            for (ValuedEnum valuedEnum : Enum.getEnumList(cls)) {
                if (valuedEnum.getValue() == i3) {
                    return valuedEnum;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("The Enum Class must not be null");
    }

    @Override // org.apache.commons.lang.p020enum.Enum, java.lang.Comparable
    public int compareTo(Object obj) {
        return this.iValue - ((ValuedEnum) obj).iValue;
    }

    public final int getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.lang.p020enum.Enum
    public String toString() {
        if (this.iToString == null) {
            String shortClassName = ClassUtils.getShortClassName(getEnumClass());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(shortClassName);
            stringBuffer.append("[");
            stringBuffer.append(getName());
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
