package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    private List<ReceiverParameterDescriptor> contextReceiverParameters;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private boolean hasStableParameterNames;
    private boolean hasSynthesizedParameterNames;

    @Nullable
    private FunctionDescriptor initialSignatureDescriptor;
    private boolean isActual;
    private boolean isExpect;
    private boolean isExternal;
    private boolean isHiddenForResolutionEverywhereBesideSupercalls;
    private boolean isHiddenToOvercomeSignatureClash;
    private boolean isInfix;
    private boolean isInline;
    private boolean isOperator;
    private boolean isSuspend;
    private boolean isTailrec;
    private final CallableMemberDescriptor.Kind kind;
    private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    private Modality modality;
    private final FunctionDescriptor original;
    private Collection<? extends FunctionDescriptor> overriddenFunctions;
    private List<TypeParameterDescriptor> typeParameters;
    private KotlinType unsubstitutedReturnType;
    private List<ValueParameterDescriptor> unsubstitutedValueParameters;
    protected Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;
    private DescriptorVisibility visibility;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class CopyConfiguration implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        private Annotations additionalAnnotations;
        protected boolean copyOverrides;

        @Nullable
        protected ReceiverParameterDescriptor dispatchReceiverParameter;
        protected boolean dropOriginalInContainingParts;
        private boolean isHiddenForResolutionEverywhereBesideSupercalls;
        private boolean isHiddenToOvercomeSignatureClash;
        protected boolean justForTypeSubstitution;

        @NotNull
        protected CallableMemberDescriptor.Kind kind;

        @Nullable
        protected Name name;

        @NotNull
        protected List<ReceiverParameterDescriptor> newContextReceiverParameters;

        @Nullable
        protected ReceiverParameterDescriptor newExtensionReceiverParameter;
        private Boolean newHasSynthesizedParameterNames;

        @NotNull
        protected Modality newModality;

        @NotNull
        protected DeclarationDescriptor newOwner;

        @NotNull
        protected KotlinType newReturnType;
        private List<TypeParameterDescriptor> newTypeParameters;

        @NotNull
        protected List<ValueParameterDescriptor> newValueParameterDescriptors;

        @NotNull
        protected DescriptorVisibility newVisibility;

        @Nullable
        protected FunctionDescriptor original;
        protected boolean preserveSourceElement;
        protected boolean signatureChange;

        @NotNull
        protected TypeSubstitution substitution;
        final /* synthetic */ FunctionDescriptorImpl this$0;
        private Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;

        private static /* synthetic */ void $$$reportNull$$$0(int i3) {
            String str;
            int i16;
            switch (i3) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i3) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i16 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    i16 = 3;
                    break;
            }
            Object[] objArr = new Object[i16];
            switch (i3) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i3) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i3) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i3) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(format);
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        public CopyConfiguration(@NotNull FunctionDescriptorImpl functionDescriptorImpl, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @NotNull CallableMemberDescriptor.Kind kind, @NotNull List<ValueParameterDescriptor> list, @Nullable List<ReceiverParameterDescriptor> list2, @NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable KotlinType kotlinType, Name name) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            if (modality == null) {
                $$$reportNull$$$0(2);
            }
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(3);
            }
            if (kind == null) {
                $$$reportNull$$$0(4);
            }
            if (list == null) {
                $$$reportNull$$$0(5);
            }
            if (list2 == null) {
                $$$reportNull$$$0(6);
            }
            if (kotlinType == null) {
                $$$reportNull$$$0(7);
            }
            this.this$0 = functionDescriptorImpl;
            this.original = null;
            this.dispatchReceiverParameter = functionDescriptorImpl.dispatchReceiverParameter;
            this.copyOverrides = true;
            this.signatureChange = false;
            this.preserveSourceElement = false;
            this.dropOriginalInContainingParts = false;
            this.isHiddenToOvercomeSignatureClash = functionDescriptorImpl.isHiddenToOvercomeSignatureClash();
            this.newTypeParameters = null;
            this.additionalAnnotations = null;
            this.isHiddenForResolutionEverywhereBesideSupercalls = functionDescriptorImpl.isHiddenForResolutionEverywhereBesideSupercalls();
            this.userDataMap = new LinkedHashMap();
            this.newHasSynthesizedParameterNames = null;
            this.justForTypeSubstitution = false;
            this.substitution = typeSubstitution;
            this.newOwner = declarationDescriptor;
            this.newModality = modality;
            this.newVisibility = descriptorVisibility;
            this.kind = kind;
            this.newValueParameterDescriptors = list;
            this.newContextReceiverParameters = list2;
            this.newExtensionReceiverParameter = receiverParameterDescriptor;
            this.newReturnType = kotlinType;
            this.name = name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @Nullable
        public FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public <V> FunctionDescriptor.CopyBuilder<FunctionDescriptor> putUserData(@NotNull CallableDescriptor.UserDataKey<V> userDataKey, V v3) {
            if (userDataKey == null) {
                $$$reportNull$$$0(39);
            }
            this.userDataMap.put(userDataKey, v3);
            return this;
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean z16) {
            this.newHasSynthesizedParameterNames = Boolean.valueOf(z16);
            return this;
        }

        @NotNull
        public CopyConfiguration setJustForTypeSubstitution(boolean z16) {
            this.justForTypeSubstitution = z16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder<FunctionDescriptor> setTypeParameters(List list) {
            return setTypeParameters2((List<TypeParameterDescriptor>) list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        public /* bridge */ /* synthetic */ FunctionDescriptor.CopyBuilder<FunctionDescriptor> setValueParameters(List list) {
            return setValueParameters2((List<ValueParameterDescriptor>) list);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations == null) {
                $$$reportNull$$$0(35);
            }
            this.additionalAnnotations = annotations;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setCopyOverrides(boolean z16) {
            this.copyOverrides = z16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.dispatchReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.newExtensionReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                $$$reportNull$$$0(14);
            }
            this.kind = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setModality(@NotNull Modality modality) {
            if (modality == null) {
                $$$reportNull$$$0(10);
            }
            this.newModality = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setName(@NotNull Name name) {
            if (name == null) {
                $$$reportNull$$$0(17);
            }
            this.name = name;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(8);
            }
            this.newOwner = declarationDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setReturnType(@NotNull KotlinType kotlinType) {
            if (kotlinType == null) {
                $$$reportNull$$$0(23);
            }
            this.newReturnType = kotlinType;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSubstitution(@NotNull TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(37);
            }
            this.substitution = typeSubstitution;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: setTypeParameters, reason: avoid collision after fix types in other method */
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setTypeParameters2(@NotNull List<TypeParameterDescriptor> list) {
            if (list == null) {
                $$$reportNull$$$0(21);
            }
            this.newTypeParameters = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        /* renamed from: setValueParameters, reason: avoid collision after fix types in other method */
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setValueParameters2(@NotNull List<ValueParameterDescriptor> list) {
            if (list == null) {
                $$$reportNull$$$0(19);
            }
            this.newValueParameterDescriptors = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(12);
            }
            this.newVisibility = descriptorVisibility;
            return this;
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        switch (i3) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i3) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i16 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i16 = 3;
                break;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i3) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i3) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i3) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(format);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name, sourceElement);
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        if (annotations == null) {
            $$$reportNull$$$0(1);
        }
        if (name == null) {
            $$$reportNull$$$0(2);
        }
        if (kind == null) {
            $$$reportNull$$$0(3);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(4);
        }
        this.visibility = DescriptorVisibilities.UNKNOWN;
        this.isOperator = false;
        this.isInfix = false;
        this.isExternal = false;
        this.isInline = false;
        this.isTailrec = false;
        this.isExpect = false;
        this.isActual = false;
        this.isHiddenToOvercomeSignatureClash = false;
        this.isHiddenForResolutionEverywhereBesideSupercalls = false;
        this.isSuspend = false;
        this.hasStableParameterNames = true;
        this.hasSynthesizedParameterNames = false;
        this.overriddenFunctions = null;
        this.lazyOverriddenFunctionsTask = null;
        this.initialSignatureDescriptor = null;
        this.userDataMap = null;
        this.original = functionDescriptor == null ? this : functionDescriptor;
        this.kind = kind;
    }

    @NotNull
    private SourceElement getSourceToUseForCopy(boolean z16, @Nullable FunctionDescriptor functionDescriptor) {
        SourceElement sourceElement;
        if (z16) {
            if (functionDescriptor == null) {
                functionDescriptor = getOriginal();
            }
            sourceElement = functionDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(27);
        }
        return sourceElement;
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            $$$reportNull$$$0(28);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(29);
        }
        return getSubstitutedValueParameters(functionDescriptor, list, typeSubstitutor, false, false, null);
    }

    private void performOverriddenLazyCalculationIfNeeded() {
        Function0<Collection<FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
        if (function0 != null) {
            this.overriddenFunctions = function0.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
    }

    private void setHiddenForResolutionEverywhereBesideSupercalls(boolean z16) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = z16;
    }

    private void setHiddenToOvercomeSignatureClash(boolean z16) {
        this.isHiddenToOvercomeSignatureClash = z16;
    }

    private void setInitialSignatureDescriptor(@Nullable FunctionDescriptor functionDescriptor) {
        this.initialSignatureDescriptor = functionDescriptor;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d16) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d16);
    }

    @NotNull
    protected abstract FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement sourceElement);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public FunctionDescriptor doSubstitute(@NotNull CopyConfiguration copyConfiguration) {
        Annotations annotations;
        List<TypeParameterDescriptor> list;
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType substitute;
        boolean z16;
        boolean z17;
        FunctionDescriptor functionDescriptor;
        boolean z18;
        boolean z19;
        boolean z26;
        if (copyConfiguration == null) {
            $$$reportNull$$$0(25);
        }
        boolean[] zArr = new boolean[1];
        if (copyConfiguration.additionalAnnotations != null) {
            annotations = AnnotationsKt.composeAnnotations(getAnnotations(), copyConfiguration.additionalAnnotations);
        } else {
            annotations = getAnnotations();
        }
        DeclarationDescriptor declarationDescriptor = copyConfiguration.newOwner;
        FunctionDescriptor functionDescriptor2 = copyConfiguration.original;
        FunctionDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(declarationDescriptor, functionDescriptor2, copyConfiguration.kind, copyConfiguration.name, annotations, getSourceToUseForCopy(copyConfiguration.preserveSourceElement, functionDescriptor2));
        if (copyConfiguration.newTypeParameters != null) {
            list = copyConfiguration.newTypeParameters;
        } else {
            list = getTypeParameters();
        }
        zArr[0] = zArr[0] | (!list.isEmpty());
        ArrayList arrayList = new ArrayList(list.size());
        final TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(list, copyConfiguration.substitution, createSubstitutedCopy, arrayList, zArr);
        if (substituteTypeParameters == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!copyConfiguration.newContextReceiverParameters.isEmpty()) {
            for (ReceiverParameterDescriptor receiverParameterDescriptor2 : copyConfiguration.newContextReceiverParameters) {
                KotlinType substitute2 = substituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
                if (substitute2 == null) {
                    return null;
                }
                arrayList2.add(DescriptorFactory.createContextReceiverParameterForCallable(createSubstitutedCopy, substitute2, receiverParameterDescriptor2.getAnnotations()));
                boolean z27 = zArr[0];
                if (substitute2 != receiverParameterDescriptor2.getType()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                zArr[0] = z26 | z27;
            }
        }
        ReceiverParameterDescriptor receiverParameterDescriptor3 = copyConfiguration.newExtensionReceiverParameter;
        if (receiverParameterDescriptor3 != null) {
            KotlinType substitute3 = substituteTypeParameters.substitute(receiverParameterDescriptor3.getType(), Variance.IN_VARIANCE);
            if (substitute3 == null) {
                return null;
            }
            ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl2 = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute3, copyConfiguration.newExtensionReceiverParameter.getValue()), copyConfiguration.newExtensionReceiverParameter.getAnnotations());
            boolean z28 = zArr[0];
            if (substitute3 != copyConfiguration.newExtensionReceiverParameter.getType()) {
                z19 = true;
            } else {
                z19 = false;
            }
            zArr[0] = z19 | z28;
            receiverParameterDescriptorImpl = receiverParameterDescriptorImpl2;
        } else {
            receiverParameterDescriptorImpl = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor4 = copyConfiguration.dispatchReceiverParameter;
        if (receiverParameterDescriptor4 != null) {
            ReceiverParameterDescriptor substitute4 = receiverParameterDescriptor4.substitute(substituteTypeParameters);
            if (substitute4 == null) {
                return null;
            }
            boolean z29 = zArr[0];
            if (substitute4 != copyConfiguration.dispatchReceiverParameter) {
                z18 = true;
            } else {
                z18 = false;
            }
            zArr[0] = z29 | z18;
            receiverParameterDescriptor = substitute4;
        } else {
            receiverParameterDescriptor = null;
        }
        List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(createSubstitutedCopy, copyConfiguration.newValueParameterDescriptors, substituteTypeParameters, copyConfiguration.dropOriginalInContainingParts, copyConfiguration.preserveSourceElement, zArr);
        if (substitutedValueParameters == null || (substitute = substituteTypeParameters.substitute(copyConfiguration.newReturnType, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        boolean z36 = zArr[0];
        if (substitute != copyConfiguration.newReturnType) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z37 = z36 | z16;
        zArr[0] = z37;
        if (!z37 && copyConfiguration.justForTypeSubstitution) {
            return this;
        }
        createSubstitutedCopy.initialize(receiverParameterDescriptorImpl, receiverParameterDescriptor, arrayList2, arrayList, substitutedValueParameters, substitute, copyConfiguration.newModality, copyConfiguration.newVisibility);
        createSubstitutedCopy.setOperator(this.isOperator);
        createSubstitutedCopy.setInfix(this.isInfix);
        createSubstitutedCopy.setExternal(this.isExternal);
        createSubstitutedCopy.setInline(this.isInline);
        createSubstitutedCopy.setTailrec(this.isTailrec);
        createSubstitutedCopy.setSuspend(this.isSuspend);
        createSubstitutedCopy.setExpect(this.isExpect);
        createSubstitutedCopy.setActual(this.isActual);
        createSubstitutedCopy.setHasStableParameterNames(this.hasStableParameterNames);
        createSubstitutedCopy.setHiddenToOvercomeSignatureClash(copyConfiguration.isHiddenToOvercomeSignatureClash);
        createSubstitutedCopy.setHiddenForResolutionEverywhereBesideSupercalls(copyConfiguration.isHiddenForResolutionEverywhereBesideSupercalls);
        if (copyConfiguration.newHasSynthesizedParameterNames != null) {
            z17 = copyConfiguration.newHasSynthesizedParameterNames.booleanValue();
        } else {
            z17 = this.hasSynthesizedParameterNames;
        }
        createSubstitutedCopy.setHasSynthesizedParameterNames(z17);
        if (!copyConfiguration.userDataMap.isEmpty() || this.userDataMap != null) {
            Map<CallableDescriptor.UserDataKey<?>, Object> map = copyConfiguration.userDataMap;
            Map<CallableDescriptor.UserDataKey<?>, Object> map2 = this.userDataMap;
            if (map2 != null) {
                for (Map.Entry<CallableDescriptor.UserDataKey<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                createSubstitutedCopy.userDataMap = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                createSubstitutedCopy.userDataMap = map;
            }
        }
        if (copyConfiguration.signatureChange || getInitialSignatureDescriptor() != null) {
            if (getInitialSignatureDescriptor() != null) {
                functionDescriptor = getInitialSignatureDescriptor();
            } else {
                functionDescriptor = this;
            }
            createSubstitutedCopy.setInitialSignatureDescriptor(functionDescriptor.substitute(substituteTypeParameters));
        }
        if (copyConfiguration.copyOverrides && !getOriginal().getOverriddenDescriptors().isEmpty()) {
            if (copyConfiguration.substitution.isEmpty()) {
                Function0<Collection<FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
                if (function0 != null) {
                    createSubstitutedCopy.lazyOverriddenFunctionsTask = function0;
                } else {
                    createSubstitutedCopy.setOverriddenDescriptors(getOverriddenDescriptors());
                }
            } else {
                createSubstitutedCopy.lazyOverriddenFunctionsTask = new Function0<Collection<FunctionDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.1
                    @Override // kotlin.jvm.functions.Function0
                    public Collection<FunctionDescriptor> invoke() {
                        SmartList smartList = new SmartList();
                        Iterator<? extends FunctionDescriptor> it = FunctionDescriptorImpl.this.getOverriddenDescriptors().iterator();
                        while (it.hasNext()) {
                            smartList.add(it.next().substitute(substituteTypeParameters));
                        }
                        return smartList;
                    }
                };
            }
        }
        return createSubstitutedCopy;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        List<ReceiverParameterDescriptor> list = this.contextReceiverParameters;
        if (list == null) {
            $$$reportNull$$$0(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            $$$reportNull$$$0(21);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            $$$reportNull$$$0(15);
        }
        return modality;
    }

    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        performOverriddenLazyCalculationIfNeeded();
        Collection<? extends FunctionDescriptor> collection = this.overriddenFunctions;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            $$$reportNull$$$0(14);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Map<CallableDescriptor.UserDataKey<?>, Object> map = this.userDataMap;
        if (map == null) {
            return null;
        }
        return (V) map.get(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list == null) {
            $$$reportNull$$$0(19);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(16);
        }
        return descriptorVisibility;
    }

    public boolean hasStableParameterNames() {
        return this.hasStableParameterNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    @NotNull
    public FunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<ReceiverParameterDescriptor> list, @NotNull List<? extends TypeParameterDescriptor> list2, @NotNull List<ValueParameterDescriptor> list3, @Nullable KotlinType kotlinType, @Nullable Modality modality, @NotNull DescriptorVisibility descriptorVisibility) {
        List<TypeParameterDescriptor> list4;
        List<ValueParameterDescriptor> list5;
        if (list == null) {
            $$$reportNull$$$0(5);
        }
        if (list2 == null) {
            $$$reportNull$$$0(6);
        }
        if (list3 == null) {
            $$$reportNull$$$0(7);
        }
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(8);
        }
        list4 = CollectionsKt___CollectionsKt.toList(list2);
        this.typeParameters = list4;
        list5 = CollectionsKt___CollectionsKt.toList(list3);
        this.unsubstitutedValueParameters = list5;
        this.unsubstitutedReturnType = kotlinType;
        this.modality = modality;
        this.visibility = descriptorVisibility;
        this.extensionReceiverParameter = receiverParameterDescriptor;
        this.dispatchReceiverParameter = receiverParameterDescriptor2;
        this.contextReceiverParameters = list;
        for (int i3 = 0; i3 < list2.size(); i3++) {
            TypeParameterDescriptor typeParameterDescriptor = list2.get(i3);
            if (typeParameterDescriptor.getIndex() != i3) {
                throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i3);
            }
        }
        for (int i16 = 0; i16 < list3.size(); i16++) {
            ValueParameterDescriptor valueParameterDescriptor = list3.get(i16);
            if (valueParameterDescriptor.getIndex() != i16 + 0) {
                throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i16);
            }
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.isActual;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.isExpect;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.isInline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        Iterator<? extends FunctionDescriptor> it = getOriginal().getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            if (it.next().isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.isSuspend;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (newCopyBuilder == null) {
            $$$reportNull$$$0(23);
        }
        return newCopyBuilder;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> userDataKey, Object obj) {
        if (this.userDataMap == null) {
            this.userDataMap = new LinkedHashMap();
        }
        this.userDataMap.put(userDataKey, obj);
    }

    public void setActual(boolean z16) {
        this.isActual = z16;
    }

    public void setExpect(boolean z16) {
        this.isExpect = z16;
    }

    public void setExternal(boolean z16) {
        this.isExternal = z16;
    }

    public void setHasStableParameterNames(boolean z16) {
        this.hasStableParameterNames = z16;
    }

    public void setHasSynthesizedParameterNames(boolean z16) {
        this.hasSynthesizedParameterNames = z16;
    }

    public void setInfix(boolean z16) {
        this.isInfix = z16;
    }

    public void setInline(boolean z16) {
        this.isInline = z16;
    }

    public void setOperator(boolean z16) {
        this.isOperator = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            $$$reportNull$$$0(17);
        }
        this.overriddenFunctions = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                this.isHiddenForResolutionEverywhereBesideSupercalls = true;
                return;
            }
        }
    }

    public void setReturnType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(11);
        }
        this.unsubstitutedReturnType = kotlinType;
    }

    public void setSuspend(boolean z16) {
        this.isSuspend = z16;
    }

    public void setTailrec(boolean z16) {
        this.isTailrec = z16;
    }

    public void setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(10);
        }
        this.visibility = descriptorVisibility;
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor, boolean z16, boolean z17, @Nullable boolean[] zArr) {
        Function0<List<VariableDescriptor>> function0;
        if (list == null) {
            $$$reportNull$$$0(30);
        }
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ValueParameterDescriptor valueParameterDescriptor : list) {
            KotlinType type = valueParameterDescriptor.getType();
            Variance variance = Variance.IN_VARIANCE;
            KotlinType substitute = typeSubstitutor.substitute(type, variance);
            KotlinType varargElementType = valueParameterDescriptor.getVarargElementType();
            KotlinType substitute2 = varargElementType == null ? null : typeSubstitutor.substitute(varargElementType, variance);
            if (substitute == null) {
                return null;
            }
            if ((substitute != valueParameterDescriptor.getType() || varargElementType != substitute2) && zArr != null) {
                zArr[0] = true;
            }
            if (valueParameterDescriptor instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration) {
                final List<VariableDescriptor> destructuringVariables = ((ValueParameterDescriptorImpl.WithDestructuringDeclaration) valueParameterDescriptor).getDestructuringVariables();
                function0 = new Function0<List<VariableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.2
                    @Override // kotlin.jvm.functions.Function0
                    public List<VariableDescriptor> invoke() {
                        return destructuringVariables;
                    }
                };
            } else {
                function0 = null;
            }
            arrayList.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(functionDescriptor, z16 ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), substitute, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), substitute2, z17 ? valueParameterDescriptor.getSource() : SourceElement.NO_SOURCE, function0));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z16) {
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z16).build();
        if (build == null) {
            $$$reportNull$$$0(26);
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public CopyConfiguration newCopyBuilder(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(24);
        }
        return new CopyConfiguration(this, typeSubstitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getContextReceiverParameters(), getExtensionReceiverParameter(), getReturnType(), null);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public FunctionDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
        }
        return typeSubstitutor.isEmpty() ? this : newCopyBuilder(typeSubstitutor).setOriginal((CallableMemberDescriptor) getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.original;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(20);
        }
        return original;
    }
}
