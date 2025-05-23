package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InterTypeConstructorDeclarationImpl extends InterTypeDeclarationImpl implements InterTypeConstructorDeclaration {
    private Method baseMethod;

    public InterTypeConstructorDeclarationImpl(AjType<?> ajType, String str, int i3, Method method) {
        super(ajType, str, i3);
        this.baseMethod = method;
    }

    @Override // org.aspectj.lang.reflect.InterTypeConstructorDeclaration
    public AjType<?>[] getExceptionTypes() {
        Class<?>[] exceptionTypes = this.baseMethod.getExceptionTypes();
        AjType<?>[] ajTypeArr = new AjType[exceptionTypes.length];
        for (int i3 = 0; i3 < exceptionTypes.length; i3++) {
            ajTypeArr[i3] = AjTypeSystem.getAjType(exceptionTypes[i3]);
        }
        return ajTypeArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.aspectj.lang.reflect.InterTypeConstructorDeclaration
    public Type[] getGenericParameterTypes() {
        Type[] genericParameterTypes = this.baseMethod.getGenericParameterTypes();
        AjType[] ajTypeArr = new AjType[genericParameterTypes.length - 1];
        for (int i3 = 1; i3 < genericParameterTypes.length; i3++) {
            Type type = genericParameterTypes[i3];
            if (type instanceof Class) {
                ajTypeArr[i3 - 1] = AjTypeSystem.getAjType((Class) type);
            } else {
                ajTypeArr[i3 - 1] = type;
            }
        }
        return ajTypeArr;
    }

    @Override // org.aspectj.lang.reflect.InterTypeConstructorDeclaration
    public AjType<?>[] getParameterTypes() {
        Class<?>[] parameterTypes = this.baseMethod.getParameterTypes();
        AjType<?>[] ajTypeArr = new AjType[parameterTypes.length - 1];
        for (int i3 = 1; i3 < parameterTypes.length; i3++) {
            ajTypeArr[i3 - 1] = AjTypeSystem.getAjType(parameterTypes[i3]);
        }
        return ajTypeArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Modifier.toString(getModifiers()));
        stringBuffer.append(" ");
        stringBuffer.append(this.targetTypeName);
        stringBuffer.append(".new");
        stringBuffer.append("(");
        AjType<?>[] parameterTypes = getParameterTypes();
        for (int i3 = 0; i3 < parameterTypes.length - 1; i3++) {
            stringBuffer.append(parameterTypes[i3].toString());
            stringBuffer.append(", ");
        }
        if (parameterTypes.length > 0) {
            stringBuffer.append(parameterTypes[parameterTypes.length - 1].toString());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
