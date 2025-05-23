package org.aspectj.internal.lang.reflect;

import java.lang.reflect.Method;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.Pointcut;
import org.aspectj.lang.reflect.PointcutExpression;

/* loaded from: classes29.dex */
public class PointcutImpl implements Pointcut {
    private final Method baseMethod;
    private final AjType declaringType;
    private final String name;
    private String[] parameterNames;

    /* renamed from: pc, reason: collision with root package name */
    private final PointcutExpression f423554pc;

    /* JADX INFO: Access modifiers changed from: protected */
    public PointcutImpl(String str, String str2, Method method, AjType ajType, String str3) {
        this.parameterNames = new String[0];
        this.name = str;
        this.f423554pc = new PointcutExpressionImpl(str2);
        this.baseMethod = method;
        this.declaringType = ajType;
        this.parameterNames = splitOnComma(str3);
    }

    private String[] splitOnComma(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int countTokens = stringTokenizer.countTokens();
        String[] strArr = new String[countTokens];
        for (int i3 = 0; i3 < countTokens; i3++) {
            strArr[i3] = stringTokenizer.nextToken().trim();
        }
        return strArr;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public AjType getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public int getModifiers() {
        return this.baseMethod.getModifiers();
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public String getName() {
        return this.name;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public String[] getParameterNames() {
        return this.parameterNames;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public AjType<?>[] getParameterTypes() {
        Class<?>[] parameterTypes = this.baseMethod.getParameterTypes();
        int length = parameterTypes.length;
        AjType<?>[] ajTypeArr = new AjType[length];
        for (int i3 = 0; i3 < length; i3++) {
            ajTypeArr[i3] = AjTypeSystem.getAjType(parameterTypes[i3]);
        }
        return ajTypeArr;
    }

    @Override // org.aspectj.lang.reflect.Pointcut
    public PointcutExpression getPointcutExpression() {
        return this.f423554pc;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getName());
        stringBuffer.append("(");
        AjType<?>[] parameterTypes = getParameterTypes();
        int i3 = 0;
        while (i3 < parameterTypes.length) {
            stringBuffer.append(parameterTypes[i3].getName());
            String[] strArr = this.parameterNames;
            if (strArr != null && strArr[i3] != null) {
                stringBuffer.append(" ");
                stringBuffer.append(this.parameterNames[i3]);
            }
            i3++;
            if (i3 < parameterTypes.length) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(") : ");
        stringBuffer.append(getPointcutExpression().asString());
        return stringBuffer.toString();
    }
}
