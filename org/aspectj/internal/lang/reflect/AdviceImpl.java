package org.aspectj.internal.lang.reflect;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.PointcutExpression;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AdviceImpl implements Advice {
    private static final String AJC_INTERNAL = "org.aspectj.runtime.internal";
    private final Method adviceMethod;
    private AjType[] exceptionTypes;
    private Type[] genericParameterTypes;
    private boolean hasExtraParam;
    private final AdviceKind kind;
    private AjType[] parameterTypes;
    private PointcutExpression pointcutExpression;

    /* compiled from: P */
    /* renamed from: org.aspectj.internal.lang.reflect.AdviceImpl$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$aspectj$lang$reflect$AdviceKind;

        static {
            int[] iArr = new int[AdviceKind.values().length];
            $SwitchMap$org$aspectj$lang$reflect$AdviceKind = iArr;
            try {
                iArr[AdviceKind.AFTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.AFTER_RETURNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.AFTER_THROWING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.AROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$aspectj$lang$reflect$AdviceKind[AdviceKind.BEFORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdviceImpl(Method method, String str, AdviceKind adviceKind) {
        this.hasExtraParam = false;
        this.kind = adviceKind;
        this.adviceMethod = method;
        this.pointcutExpression = new PointcutExpressionImpl(str);
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AjType getDeclaringType() {
        return AjTypeSystem.getAjType(this.adviceMethod.getDeclaringClass());
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AjType<?>[] getExceptionTypes() {
        if (this.exceptionTypes == null) {
            Class<?>[] exceptionTypes = this.adviceMethod.getExceptionTypes();
            this.exceptionTypes = new AjType[exceptionTypes.length];
            for (int i3 = 0; i3 < exceptionTypes.length; i3++) {
                this.exceptionTypes[i3] = AjTypeSystem.getAjType(exceptionTypes[i3]);
            }
        }
        return this.exceptionTypes;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public Type[] getGenericParameterTypes() {
        if (this.genericParameterTypes == null) {
            Type[] genericParameterTypes = this.adviceMethod.getGenericParameterTypes();
            int i3 = 0;
            int i16 = 0;
            for (Type type : genericParameterTypes) {
                if ((type instanceof Class) && ((Class) type).getPackage().getName().equals(AJC_INTERNAL)) {
                    i16++;
                }
            }
            this.genericParameterTypes = new Type[genericParameterTypes.length - i16];
            while (true) {
                Type[] typeArr = this.genericParameterTypes;
                if (i3 >= typeArr.length) {
                    break;
                }
                Type type2 = genericParameterTypes[i3];
                if (type2 instanceof Class) {
                    typeArr[i3] = AjTypeSystem.getAjType((Class) type2);
                } else {
                    typeArr[i3] = type2;
                }
                i3++;
            }
        }
        return this.genericParameterTypes;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AdviceKind getKind() {
        return this.kind;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public String getName() {
        String name = this.adviceMethod.getName();
        if (name.startsWith("ajc$")) {
            AdviceName adviceName = (AdviceName) this.adviceMethod.getAnnotation(AdviceName.class);
            if (adviceName != null) {
                return adviceName.value();
            }
            return "";
        }
        return name;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public AjType<?>[] getParameterTypes() {
        if (this.parameterTypes == null) {
            Class<?>[] parameterTypes = this.adviceMethod.getParameterTypes();
            int i3 = 0;
            int i16 = 0;
            for (Class<?> cls : parameterTypes) {
                if (cls.getPackage().getName().equals(AJC_INTERNAL)) {
                    i16++;
                }
            }
            this.parameterTypes = new AjType[parameterTypes.length - i16];
            while (true) {
                AjType[] ajTypeArr = this.parameterTypes;
                if (i3 >= ajTypeArr.length) {
                    break;
                }
                ajTypeArr[i3] = AjTypeSystem.getAjType(parameterTypes[i3]);
                i3++;
            }
        }
        return this.parameterTypes;
    }

    @Override // org.aspectj.lang.reflect.Advice
    public PointcutExpression getPointcutExpression() {
        return this.pointcutExpression;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00af, code lost:
    
        if (r10 != 3) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (getName().length() > 0) {
            stringBuffer.append("@AdviceName(\"");
            stringBuffer.append(getName());
            stringBuffer.append("\") ");
        }
        if (getKind() == AdviceKind.AROUND) {
            stringBuffer.append(this.adviceMethod.getGenericReturnType().toString());
            stringBuffer.append(" ");
        }
        int i3 = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind[getKind().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            stringBuffer.append("before(");
                        }
                    } else {
                        stringBuffer.append("around(");
                    }
                } else {
                    stringBuffer.append("after(");
                }
            } else {
                stringBuffer.append("after(");
            }
        } else {
            stringBuffer.append("after(");
        }
        AjType<?>[] parameterTypes = getParameterTypes();
        int length = parameterTypes.length;
        if (this.hasExtraParam) {
            length--;
        }
        int i16 = 0;
        int i17 = 0;
        while (i17 < length) {
            stringBuffer.append(parameterTypes[i17].getName());
            i17++;
            if (i17 < length) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(") ");
        int i18 = AnonymousClass1.$SwitchMap$org$aspectj$lang$reflect$AdviceKind[getKind().ordinal()];
        if (i18 == 2) {
            stringBuffer.append("returning");
            if (this.hasExtraParam) {
                stringBuffer.append("(");
                stringBuffer.append(parameterTypes[length - 1].getName());
                stringBuffer.append(") ");
            }
        }
        stringBuffer.append("throwing");
        if (this.hasExtraParam) {
            stringBuffer.append("(");
            stringBuffer.append(parameterTypes[length - 1].getName());
            stringBuffer.append(") ");
        }
        AjType<?>[] exceptionTypes = getExceptionTypes();
        if (exceptionTypes.length > 0) {
            stringBuffer.append("throws ");
            while (i16 < exceptionTypes.length) {
                stringBuffer.append(exceptionTypes[i16].getName());
                i16++;
                if (i16 < exceptionTypes.length) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(" ");
        }
        stringBuffer.append(MsgSummary.STR_COLON);
        stringBuffer.append(getPointcutExpression().asString());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdviceImpl(Method method, String str, AdviceKind adviceKind, String str2) {
        this(method, str, adviceKind);
        this.hasExtraParam = true;
    }
}
