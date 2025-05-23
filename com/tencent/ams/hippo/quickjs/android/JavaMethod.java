package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JavaMethod {
    static IPatchRedirector $redirector_;
    public final int modifiers;
    public final String name;
    public final Type[] parameterTypes;
    public final Type returnType;

    public JavaMethod(Type type, String str, Type[] typeArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, type, str, typeArr, Integer.valueOf(i3));
            return;
        }
        this.returnType = canonicalize(type);
        this.name = str;
        this.parameterTypes = new Type[typeArr.length];
        for (int i16 = 0; i16 < typeArr.length; i16++) {
            this.parameterTypes[i16] = canonicalize(typeArr[i16]);
        }
        this.modifiers = i3;
    }

    private static Type canonicalize(Type type) {
        return JavaTypes.removeSubtypeWildcard(JavaTypes.canonicalize(type));
    }

    @Nullable
    public static JavaMethod create(Type type, Method method) {
        Class<?> rawType = JavaTypes.getRawType(type);
        Type resolve = JavaTypes.resolve(type, rawType, method.getGenericReturnType());
        if (resolve instanceof TypeVariable) {
            return null;
        }
        String name = method.getName();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        int length = genericParameterTypes.length;
        Type[] typeArr = new Type[length];
        for (int i3 = 0; i3 < length; i3++) {
            Type resolve2 = JavaTypes.resolve(type, rawType, genericParameterTypes[i3]);
            typeArr[i3] = resolve2;
            if (resolve2 instanceof TypeVariable) {
                return null;
            }
        }
        return new JavaMethod(resolve, name, typeArr, method.getModifiers());
    }

    private static String getTypeSignature(Type type) {
        if (type instanceof GenericArrayType) {
            return "[" + getTypeSignature(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (type == Void.TYPE) {
                return "V";
            }
            if (type == Boolean.TYPE) {
                return "Z";
            }
            if (type == Byte.TYPE) {
                return "B";
            }
            if (type == Character.TYPE) {
                return BdhLogUtil.LogTag.Tag_Conn;
            }
            if (type == Short.TYPE) {
                return ExifInterface.LATITUDE_SOUTH;
            }
            if (type == Integer.TYPE) {
                return "I";
            }
            if (type == Long.TYPE) {
                return "J";
            }
            if (type == Float.TYPE) {
                return UserInfo.SEX_FEMALE;
            }
            if (type == Double.TYPE) {
                return "D";
            }
        }
        String name = JavaTypes.getRawType(type).getName();
        StringBuilder sb5 = new StringBuilder(name.length() + 2);
        sb5.append("L");
        for (int i3 = 0; i3 < name.length(); i3++) {
            char charAt = name.charAt(i3);
            if (charAt == '.') {
                charAt = '/';
            }
            sb5.append(charAt);
        }
        sb5.append(";");
        return sb5.toString();
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof JavaMethod)) {
            return false;
        }
        JavaMethod javaMethod = (JavaMethod) obj;
        if (!this.returnType.equals(javaMethod.returnType) || !this.name.equals(javaMethod.name) || !Arrays.equals(this.parameterTypes, javaMethod.parameterTypes)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSignature() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        for (Type type : this.parameterTypes) {
            sb5.append(getTypeSignature(type));
        }
        sb5.append(")");
        sb5.append(getTypeSignature(this.returnType));
        return sb5.toString();
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return ((((0 + this.returnType.hashCode()) * 31) + this.name.hashCode()) * 31) + Arrays.hashCode(this.parameterTypes);
    }

    public boolean isStatic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if ((this.modifiers & 8) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.returnType);
        sb5.append(" ");
        sb5.append(this.name);
        sb5.append("(");
        for (int i3 = 0; i3 < this.parameterTypes.length; i3++) {
            if (i3 != 0) {
                sb5.append(", ");
            }
            sb5.append(this.parameterTypes[i3]);
        }
        sb5.append(")");
        return sb5.toString();
    }
}
