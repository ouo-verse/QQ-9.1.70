package org.apache.commons.lang.enums;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.lang.reflect.InvocationTargetException;
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

    private int getValueInOtherClassLoader(Object obj) {
        try {
            return ((Integer) obj.getClass().getMethod(HippyTextInputController.COMMAND_getValue, null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new IllegalStateException("This should not happen");
        }
    }

    @Override // org.apache.commons.lang.enums.Enum, java.lang.Comparable
    public int compareTo(Object obj) {
        int i3;
        int i16;
        if (obj == this) {
            return 0;
        }
        if (obj.getClass() != getClass()) {
            if (obj.getClass().getName().equals(getClass().getName())) {
                i3 = this.iValue;
                i16 = getValueInOtherClassLoader(obj);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Different enum class '");
                stringBuffer.append(ClassUtils.getShortClassName(obj.getClass()));
                stringBuffer.append("'");
                throw new ClassCastException(stringBuffer.toString());
            }
        } else {
            i3 = this.iValue;
            i16 = ((ValuedEnum) obj).iValue;
        }
        return i3 - i16;
    }

    public final int getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.lang.enums.Enum
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
