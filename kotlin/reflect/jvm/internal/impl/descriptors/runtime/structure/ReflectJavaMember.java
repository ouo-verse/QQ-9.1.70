package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof ReflectJavaMember) && Intrinsics.areEqual(getMember(), ((ReflectJavaMember) obj).getMember())) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    @NotNull
    public AnnotatedElement getElement() {
        Member member = getMember();
        Intrinsics.checkNotNull(member, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) member;
    }

    @NotNull
    public abstract Member getMember();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    @NotNull
    public Name getName() {
        Name name;
        String name2 = getMember().getName();
        if (name2 != null) {
            name = Name.identifier(name2);
        } else {
            name = null;
        }
        if (name == null) {
            return SpecialNames.NO_NAME_PROVIDED;
        }
        return name;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<JavaValueParameter> getValueParameters(@NotNull Type[] parameterTypes, @NotNull Annotation[][] parameterAnnotations, boolean z16) {
        int i3;
        String str;
        boolean z17;
        int lastIndex;
        Object orNull;
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List<String> loadParameterNames = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (loadParameterNames != null) {
            i3 = loadParameterNames.size() - parameterTypes.length;
        } else {
            i3 = 0;
        }
        int length = parameterTypes.length;
        for (int i16 = 0; i16 < length; i16++) {
            ReflectJavaType create = ReflectJavaType.Factory.create(parameterTypes[i16]);
            if (loadParameterNames != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(loadParameterNames, i16 + i3);
                str = (String) orNull;
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i16 + '+' + i3 + " (name=" + getName() + " type=" + create + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            if (z16) {
                lastIndex = ArraysKt___ArraysKt.getLastIndex(parameterTypes);
                if (i16 == lastIndex) {
                    z17 = true;
                    arrayList.add(new ReflectJavaValueParameter(create, parameterAnnotations[i16], str, z17));
                }
            }
            z17 = false;
            arrayList.add(new ReflectJavaValueParameter(create, parameterAnnotations[i16], str, z17));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    @NotNull
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    @NotNull
    public String toString() {
        return getClass().getName() + MsgSummary.STR_COLON + getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    @NotNull
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }
}
