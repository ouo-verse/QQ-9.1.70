package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes28.dex */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final LazyJavaResolverContext f412748c;

    @NotNull
    private final DeclarationDescriptor containingDeclaration;

    @NotNull
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;

    @NotNull
    private final Map<JavaTypeParameter, Integer> typeParameters;
    private final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(@NotNull LazyJavaResolverContext c16, @NotNull DeclarationDescriptor containingDeclaration, @NotNull JavaTypeParameterListOwner typeParameterOwner, int i3) {
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(typeParameterOwner, "typeParameterOwner");
        this.f412748c = c16;
        this.containingDeclaration = containingDeclaration;
        this.typeParametersIndexOffset = i3;
        this.typeParameters = CollectionsKt.mapToIndex(typeParameterOwner.getTypeParameters());
        this.resolve = c16.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1<JavaTypeParameter, LazyJavaTypeParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaTypeParameterResolver$resolve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final LazyJavaTypeParameterDescriptor invoke(@NotNull JavaTypeParameter typeParameter) {
                Map map;
                LazyJavaResolverContext lazyJavaResolverContext;
                DeclarationDescriptor declarationDescriptor;
                int i16;
                DeclarationDescriptor declarationDescriptor2;
                Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
                map = LazyJavaTypeParameterResolver.this.typeParameters;
                Integer num = (Integer) map.get(typeParameter);
                if (num == null) {
                    return null;
                }
                LazyJavaTypeParameterResolver lazyJavaTypeParameterResolver = LazyJavaTypeParameterResolver.this;
                int intValue = num.intValue();
                lazyJavaResolverContext = lazyJavaTypeParameterResolver.f412748c;
                LazyJavaResolverContext child = ContextKt.child(lazyJavaResolverContext, lazyJavaTypeParameterResolver);
                declarationDescriptor = lazyJavaTypeParameterResolver.containingDeclaration;
                LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(child, declarationDescriptor.getAnnotations());
                i16 = lazyJavaTypeParameterResolver.typeParametersIndexOffset;
                int i17 = i16 + intValue;
                declarationDescriptor2 = lazyJavaTypeParameterResolver.containingDeclaration;
                return new LazyJavaTypeParameterDescriptor(copyWithNewDefaultTypeQualifiers, typeParameter, i17, declarationDescriptor2);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
    @Nullable
    public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor invoke = this.resolve.invoke(javaTypeParameter);
        if (invoke == null) {
            return this.f412748c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
        }
        return invoke;
    }
}
