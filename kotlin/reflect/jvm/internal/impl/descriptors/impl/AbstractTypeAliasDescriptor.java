package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class AbstractTypeAliasDescriptor extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;

    @NotNull
    private final AbstractTypeAliasDescriptor$typeConstructor$1 typeConstructor;

    @NotNull
    private final DescriptorVisibility visibilityImpl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1] */
    public AbstractTypeAliasDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations, @NotNull Name name, @NotNull SourceElement sourceElement, @NotNull DescriptorVisibility visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics.checkNotNullParameter(visibilityImpl, "visibilityImpl");
        this.visibilityImpl = visibilityImpl;
        this.typeConstructor = new TypeConstructor() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            @NotNull
            public KotlinBuiltIns getBuiltIns() {
                return DescriptorUtilsKt.getBuiltIns(mo1779getDeclarationDescriptor());
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            @NotNull
            public List<TypeParameterDescriptor> getParameters() {
                return AbstractTypeAliasDescriptor.this.getTypeConstructorTypeParameters();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            @NotNull
            /* renamed from: getSupertypes */
            public Collection<KotlinType> mo1780getSupertypes() {
                Collection<KotlinType> mo1780getSupertypes = mo1779getDeclarationDescriptor().getUnderlyingType().getConstructor().mo1780getSupertypes();
                Intrinsics.checkNotNullExpressionValue(mo1780getSupertypes, "declarationDescriptor.un\u2026pe.constructor.supertypes");
                return mo1780getSupertypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public boolean isDenotable() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            @NotNull
            public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            }

            @NotNull
            public String toString() {
                return "[typealias " + mo1779getDeclarationDescriptor().getName().asString() + ']';
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            @NotNull
            /* renamed from: getDeclarationDescriptor */
            public TypeAliasDescriptor mo1779getDeclarationDescriptor() {
                return AbstractTypeAliasDescriptor.this;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor, D d16) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitTypeAliasDescriptor(this, d16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final SimpleType computeDefaultType() {
        MemberScope memberScope;
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null || (memberScope = classDescriptor.getUnsubstitutedMemberScope()) == null) {
            memberScope = MemberScope.Empty.INSTANCE;
        }
        SimpleType makeUnsubstitutedType = TypeUtils.makeUnsubstitutedType(this, memberScope, new Function1<KotlinTypeRefiner, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$computeDefaultType$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
                ClassifierDescriptor refineDescriptor = kotlinTypeRefiner.refineDescriptor(AbstractTypeAliasDescriptor.this);
                if (refineDescriptor != null) {
                    return refineDescriptor.getDefaultType();
                }
                return null;
            }
        });
        Intrinsics.checkNotNullExpressionValue(makeUnsubstitutedType, "@OptIn(TypeRefinement::c\u2026s)?.defaultType\n        }");
        return makeUnsubstitutedType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.declaredTypeParametersImpl;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
            return null;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        return Modality.FINAL;
    }

    @NotNull
    protected abstract StorageManager getStorageManager();

    @NotNull
    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        List emptyList;
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (ClassConstructorDescriptor it : constructors) {
            TypeAliasConstructorDescriptorImpl.Companion companion = TypeAliasConstructorDescriptorImpl.Companion;
            StorageManager storageManager = getStorageManager();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            TypeAliasConstructorDescriptor createIfAvailable = companion.createIfAvailable(storageManager, this, it);
            if (createIfAvailable != null) {
                arrayList.add(createIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        return this.visibilityImpl;
    }

    public final void initialize(@NotNull List<? extends TypeParameterDescriptor> declaredTypeParameters) {
        Intrinsics.checkNotNullParameter(declaredTypeParameters, "declaredTypeParameters");
        this.declaredTypeParametersImpl = declaredTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return TypeUtils.contains(getUnderlyingType(), new Function1<UnwrappedType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$isInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(UnwrappedType type) {
                Intrinsics.checkNotNullExpressionValue(type, "type");
                boolean z16 = false;
                if (!KotlinTypeKt.isError(type)) {
                    AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = AbstractTypeAliasDescriptor.this;
                    ClassifierDescriptor mo1779getDeclarationDescriptor = type.getConstructor().mo1779getDeclarationDescriptor();
                    if ((mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) && !Intrinsics.areEqual(((TypeParameterDescriptor) mo1779getDeclarationDescriptor).getContainingDeclaration(), abstractTypeAliasDescriptor)) {
                        z16 = true;
                    }
                }
                return Boolean.valueOf(z16);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    @NotNull
    public String toString() {
        return "typealias " + getName().asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public TypeAliasDescriptor getOriginal() {
        DeclarationDescriptorWithSource original = super.getOriginal();
        Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (TypeAliasDescriptor) original;
    }
}
