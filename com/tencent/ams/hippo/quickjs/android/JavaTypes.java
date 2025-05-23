package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JavaTypes {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {
        static IPatchRedirector $redirector_;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
            } else {
                this.componentType = JavaTypes.canonicalize(type);
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if ((obj instanceof GenericArrayType) && JavaTypes.equals(this, (GenericArrayType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        @NonNull
        public Type getGenericComponentType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Type) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.componentType;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.componentType.hashCode();
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return JavaTypes.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType {
        static IPatchRedirector $redirector_;

        @Nullable
        private final Type ownerType;
        private final Type rawType;
        final Type[] typeArguments;

        ParameterizedTypeImpl(@Nullable Type type, Type type2, Type... typeArr) {
            Type canonicalize;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, type, type2, typeArr);
                return;
            }
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || JavaTypes.getRawType(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + MsgSummary.STR_COLON + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                canonicalize = null;
            } else {
                canonicalize = JavaTypes.canonicalize(type);
            }
            this.ownerType = canonicalize;
            this.rawType = JavaTypes.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int i3 = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i3 < typeArr2.length) {
                    Type type3 = typeArr2[i3];
                    type3.getClass();
                    JavaTypes.checkNotPrimitive(type3);
                    Type[] typeArr3 = this.typeArguments;
                    typeArr3[i3] = JavaTypes.canonicalize(typeArr3[i3]);
                    i3++;
                } else {
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
            }
            if ((obj instanceof ParameterizedType) && JavaTypes.equals(this, (ParameterizedType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type[] getActualTypeArguments() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Type[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Type) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        @NonNull
        public Type getRawType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Type) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.rawType;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return (((JavaTypes.hashCodeOrZero(this.rawType) * 31) + JavaTypes.hashCodeOrZero(this.ownerType)) * 31) + Arrays.hashCode(this.typeArguments);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb5.append(JavaTypes.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb5.toString();
            }
            sb5.append("<");
            sb5.append(JavaTypes.typeToString(this.typeArguments[0]));
            for (int i3 = 1; i3 < this.typeArguments.length; i3++) {
                sb5.append(", ");
                sb5.append(JavaTypes.typeToString(this.typeArguments[i3]));
            }
            sb5.append(">");
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class WildcardTypeImpl implements WildcardType {
        static IPatchRedirector $redirector_;

        @Nullable
        private final Type lowerBound;
        private final Type upperBound;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) typeArr, (Object) typeArr2);
                return;
            }
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        Type type = typeArr2[0];
                        type.getClass();
                        JavaTypes.checkNotPrimitive(type);
                        if (typeArr[0] == Object.class) {
                            this.lowerBound = JavaTypes.canonicalize(typeArr2[0]);
                            this.upperBound = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    Type type2 = typeArr[0];
                    type2.getClass();
                    JavaTypes.checkNotPrimitive(type2);
                    this.lowerBound = null;
                    this.upperBound = JavaTypes.canonicalize(typeArr[0]);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
            }
            if ((obj instanceof WildcardType) && JavaTypes.equals(this, (WildcardType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        @NonNull
        public Type[] getLowerBounds() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Type[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            Type type = this.lowerBound;
            if (type != null) {
                return new Type[]{type};
            }
            return new Type[0];
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Type[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            Type type = this.lowerBound;
            if (type != null) {
                i3 = type.hashCode() + 31;
            } else {
                i3 = 1;
            }
            return i3 ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            if (this.lowerBound != null) {
                return "? super " + JavaTypes.typeToString(this.lowerBound);
            }
            if (this.upperBound == Object.class) {
                return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            return "? extends " + JavaTypes.typeToString(this.upperBound);
        }
    }

    public JavaTypes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type arrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        if (type instanceof Class) {
            return ((Class) type).getComponentType();
        }
        return null;
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new GenericArrayTypeImpl(canonicalize(cls.getComponentType()));
            }
            return cls;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof ParameterizedTypeImpl) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type instanceof GenericArrayTypeImpl) {
                return type;
            }
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (type instanceof WildcardTypeImpl) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    @Nullable
    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(@Nullable Type type, @Nullable Type type2) {
        Type[] actualTypeArguments;
        Type[] actualTypeArguments2;
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            if (type2 instanceof GenericArrayType) {
                return equals(((Class) type).getComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (parameterizedType instanceof ParameterizedTypeImpl) {
                actualTypeArguments = ((ParameterizedTypeImpl) parameterizedType).typeArguments;
            } else {
                actualTypeArguments = parameterizedType.getActualTypeArguments();
            }
            if (parameterizedType2 instanceof ParameterizedTypeImpl) {
                actualTypeArguments2 = ((ParameterizedTypeImpl) parameterizedType2).typeArguments;
            } else {
                actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            }
            if (equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(actualTypeArguments, actualTypeArguments2)) {
                return true;
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof Class) {
                return equals(((Class) type2).getComponentType(), ((GenericArrayType) type).getGenericComponentType());
            }
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return true;
            }
            return false;
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
            return true;
        }
        return false;
    }

    private static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i3 = 0; i3 < length; i3++) {
                Class<?> cls3 = interfaces[i3];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i3];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i3], interfaces[i3], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (superclass != null && cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class<?> getRawType(Type type) {
        String name;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        }
        if (type == null) {
            name = "null";
        } else {
            name = type.getClass().getName();
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashCodeOrZero(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (obj.equals(objArr[i3])) {
                return i3;
            }
        }
        throw new NoSuchElementException();
    }

    public static ParameterizedType newParameterizedType(Type type, Type... typeArr) {
        return new ParameterizedTypeImpl(null, type, typeArr);
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new ParameterizedTypeImpl(type, type2, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type removeSubtypeWildcard(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Type resolve(Type type, Class<?> cls, Type type2) {
        Type type3;
        boolean z16;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type resolveTypeVariable = resolveTypeVariable(type, cls, typeVariable);
            if (resolveTypeVariable == typeVariable) {
                return resolveTypeVariable;
            }
            type3 = resolveTypeVariable;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type resolve = resolve(type, cls, componentType);
                if (componentType != resolve) {
                    return new GenericArrayTypeImpl(resolve);
                }
                return cls2;
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type resolve2 = resolve(type, cls, genericComponentType);
            if (genericComponentType != resolve2) {
                return new GenericArrayTypeImpl(resolve2);
            }
            return genericArrayType;
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type resolve3 = resolve(type, cls, ownerType);
            if (resolve3 != ownerType) {
                z16 = true;
            } else {
                z16 = false;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i3 = 0; i3 < length; i3++) {
                Type resolve4 = resolve(type, cls, actualTypeArguments[i3]);
                if (resolve4 != actualTypeArguments[i3]) {
                    if (!z16) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z16 = true;
                    }
                    actualTypeArguments[i3] = resolve4;
                }
            }
            if (z16) {
                return new ParameterizedTypeImpl(resolve3, parameterizedType.getRawType(), actualTypeArguments);
            }
            return parameterizedType;
        }
        boolean z17 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z17) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type resolve5 = resolve(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (resolve5 != lowerBounds[0]) {
                    return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{resolve5});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type resolve6 = resolve(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (resolve6 != upperBounds[0]) {
                        return new WildcardTypeImpl(new Type[]{resolve6}, new Type[0]);
                    }
                }
            }
        }
        return type4;
    }

    private static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (genericSupertype instanceof ParameterizedType) {
            return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    public static WildcardType subtypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[0]);
    }

    public static WildcardType supertypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String typeToString(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}
