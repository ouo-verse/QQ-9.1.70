package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;

/* compiled from: P */
/* loaded from: classes29.dex */
public class InterTypeMethodDeclarationImpl extends InterTypeDeclarationImpl implements InterTypeMethodDeclaration {
    private Method baseMethod;
    private AjType<?>[] exceptionTypes;
    private Type[] genericParameterTypes;
    private Type genericReturnType;
    private String name;
    private int parameterAdjustmentFactor;
    private AjType<?>[] parameterTypes;
    private AjType<?> returnType;

    public InterTypeMethodDeclarationImpl(AjType<?> ajType, String str, int i3, String str2, Method method) {
        super(ajType, str, i3);
        this.parameterAdjustmentFactor = 1;
        this.name = str2;
        this.baseMethod = method;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public AjType<?>[] getExceptionTypes() {
        Class<?>[] exceptionTypes = this.baseMethod.getExceptionTypes();
        AjType<?>[] ajTypeArr = new AjType[exceptionTypes.length];
        for (int i3 = 0; i3 < exceptionTypes.length; i3++) {
            ajTypeArr[i3] = AjTypeSystem.getAjType(exceptionTypes[i3]);
        }
        return ajTypeArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public Type[] getGenericParameterTypes() {
        Type[] genericParameterTypes = this.baseMethod.getGenericParameterTypes();
        int length = genericParameterTypes.length;
        int i3 = this.parameterAdjustmentFactor;
        AjType[] ajTypeArr = new AjType[length - i3];
        while (i3 < genericParameterTypes.length) {
            Type type = genericParameterTypes[i3];
            if (type instanceof Class) {
                ajTypeArr[i3 - this.parameterAdjustmentFactor] = AjTypeSystem.getAjType((Class) type);
            } else {
                ajTypeArr[i3 - this.parameterAdjustmentFactor] = type;
            }
            i3++;
        }
        return ajTypeArr;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public Type getGenericReturnType() {
        Type genericReturnType = this.baseMethod.getGenericReturnType();
        if (genericReturnType instanceof Class) {
            return AjTypeSystem.getAjType((Class) genericReturnType);
        }
        return genericReturnType;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public String getName() {
        return this.name;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public AjType<?>[] getParameterTypes() {
        Class<?>[] parameterTypes = this.baseMethod.getParameterTypes();
        int length = parameterTypes.length;
        int i3 = this.parameterAdjustmentFactor;
        AjType<?>[] ajTypeArr = new AjType[length - i3];
        while (i3 < parameterTypes.length) {
            ajTypeArr[i3 - this.parameterAdjustmentFactor] = AjTypeSystem.getAjType(parameterTypes[i3]);
            i3++;
        }
        return ajTypeArr;
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public AjType<?> getReturnType() {
        return AjTypeSystem.getAjType(this.baseMethod.getReturnType());
    }

    @Override // org.aspectj.lang.reflect.InterTypeMethodDeclaration
    public TypeVariable<Method>[] getTypeParameters() {
        return this.baseMethod.getTypeParameters();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Modifier.toString(getModifiers()));
        stringBuffer.append(" ");
        stringBuffer.append(getReturnType().toString());
        stringBuffer.append(" ");
        stringBuffer.append(this.targetTypeName);
        stringBuffer.append(".");
        stringBuffer.append(getName());
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

    public InterTypeMethodDeclarationImpl(AjType<?> ajType, AjType<?> ajType2, Method method, int i3) {
        super(ajType, ajType2, i3);
        this.parameterAdjustmentFactor = 0;
        this.name = method.getName();
        this.baseMethod = method;
    }
}
