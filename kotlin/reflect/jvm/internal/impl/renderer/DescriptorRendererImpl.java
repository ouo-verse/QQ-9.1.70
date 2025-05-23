package kotlin.reflect.jvm.internal.impl.renderer;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {

    @NotNull
    private final Lazy functionTypeAnnotationsRenderer$delegate;

    @NotNull
    private final DescriptorRendererOptionsImpl options;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                try {
                    iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public RenderDeclarationDescriptorVisitor() {
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb5, String str) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()];
            if (i3 == 1) {
                DescriptorRendererImpl.this.renderAccessorModifiers(propertyAccessorDescriptor, sb5);
                sb5.append(str + " for ");
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                descriptorRendererImpl.renderProperty(correspondingProperty, sb5);
                return;
            }
            if (i3 == 2) {
                visitFunctionDescriptor2((FunctionDescriptor) propertyAccessorDescriptor, sb5);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitClassDescriptor(ClassDescriptor classDescriptor, StringBuilder sb5) {
            visitClassDescriptor2(classDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, StringBuilder sb5) {
            visitConstructorDescriptor2(constructorDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitFunctionDescriptor(FunctionDescriptor functionDescriptor, StringBuilder sb5) {
            visitFunctionDescriptor2(functionDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitModuleDeclaration(ModuleDescriptor moduleDescriptor, StringBuilder sb5) {
            visitModuleDeclaration2(moduleDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb5) {
            visitPackageFragmentDescriptor2(packageFragmentDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, StringBuilder sb5) {
            visitPackageViewDescriptor2(packageViewDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, StringBuilder sb5) {
            visitPropertyDescriptor2(propertyDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, StringBuilder sb5) {
            visitPropertyGetterDescriptor2(propertyGetterDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, StringBuilder sb5) {
            visitPropertySetterDescriptor2(propertySetterDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, StringBuilder sb5) {
            visitReceiverParameterDescriptor2(receiverParameterDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb5) {
            visitTypeAliasDescriptor2(typeAliasDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb5) {
            visitTypeParameterDescriptor2(typeParameterDescriptor, sb5);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ Unit visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, StringBuilder sb5) {
            visitValueParameterDescriptor2(valueParameterDescriptor, sb5);
            return Unit.INSTANCE;
        }

        /* renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(@NotNull ClassDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderClass(descriptor, builder);
        }

        /* renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, builder);
        }

        /* renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(@NotNull FunctionDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderFunction(descriptor, builder);
        }

        /* renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(@NotNull ModuleDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderName(descriptor, builder, true);
        }

        /* renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(@NotNull PackageFragmentDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderPackageFragment(descriptor, builder);
        }

        /* renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(@NotNull PackageViewDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderPackageView(descriptor, builder);
        }

        /* renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(@NotNull PropertyDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderProperty(descriptor, builder);
        }

        /* renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(@NotNull PropertyGetterDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            visitPropertyAccessorDescriptor(descriptor, builder, "getter");
        }

        /* renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(@NotNull PropertySetterDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            visitPropertyAccessorDescriptor(descriptor, builder, "setter");
        }

        /* renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(@NotNull ReceiverParameterDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            builder.append(descriptor.getName());
        }

        /* renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(@NotNull TypeAliasDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderTypeAlias(descriptor, builder);
        }

        /* renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(@NotNull TypeParameterDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderTypeParameter(descriptor, builder, true);
        }

        /* renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(@NotNull ValueParameterDescriptor descriptor, @NotNull StringBuilder builder) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(builder, "builder");
            DescriptorRendererImpl.this.renderValueParameter(descriptor, true, builder, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            try {
                iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderingFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            try {
                iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl options) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        options.isLocked();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DescriptorRendererImpl>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DescriptorRendererImpl invoke() {
                DescriptorRenderer withOptions = DescriptorRendererImpl.this.withOptions(new Function1<DescriptorRendererOptions, Unit>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DescriptorRendererOptions descriptorRendererOptions) {
                        invoke2(descriptorRendererOptions);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull DescriptorRendererOptions withOptions2) {
                        List listOf;
                        Set<FqName> plus;
                        Intrinsics.checkNotNullParameter(withOptions2, "$this$withOptions");
                        Set<FqName> excludedTypeAnnotationClasses = withOptions2.getExcludedTypeAnnotationClasses();
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{StandardNames.FqNames.extensionFunctionType, StandardNames.FqNames.contextFunctionTypeParams});
                        plus = SetsKt___SetsKt.plus((Set) excludedTypeAnnotationClasses, (Iterable) listOf);
                        withOptions2.setExcludedTypeAnnotationClasses(plus);
                    }
                });
                Intrinsics.checkNotNull(withOptions, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
                return (DescriptorRendererImpl) withOptions;
            }
        });
        this.functionTypeAnnotationsRenderer$delegate = lazy;
    }

    private final void appendDefinedIn(StringBuilder sb5, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration;
        String renderFqName;
        String name;
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor) && (containingDeclaration = declarationDescriptor.getContainingDeclaration()) != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            sb5.append(" ");
            sb5.append(renderMessage("defined in"));
            sb5.append(" ");
            FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
            if (fqName.isRoot()) {
                renderFqName = "root package";
            } else {
                renderFqName = renderFqName(fqName);
            }
            sb5.append(renderFqName);
            if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                sb5.append(" ");
                sb5.append(renderMessage("in file"));
                sb5.append(" ");
                sb5.append(name);
            }
        }
    }

    private final void appendTypeProjections(StringBuilder sb5, List<? extends TypeProjection> list) {
        CollectionsKt___CollectionsKt.joinTo$default(list, sb5, ", ", null, null, 0, null, new Function1<TypeProjection, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$appendTypeProjections$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull TypeProjection it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.isStarProjection()) {
                    return "*";
                }
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                KotlinType type = it.getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                String renderType = descriptorRendererImpl.renderType(type);
                if (it.getProjectionKind() == Variance.INVARIANT) {
                    return renderType;
                }
                return it.getProjectionKind() + TokenParser.SP + renderType;
            }
        }, 60, null);
    }

    private final String arrow() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return "&rarr;";
            }
            throw new NoWhenBranchMatchedException();
        }
        return escape("->");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0035, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7 + '?', r8) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean differsOnlyInNullability(String str, String str2) {
        String replace$default;
        boolean endsWith$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(str2, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "", false, 4, (Object) null);
        if (!Intrinsics.areEqual(str, replace$default)) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, null);
            if (endsWith$default) {
            }
            if (!Intrinsics.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    private final String escape(String str) {
        return getTextFormat().escape(str);
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String gt() {
        return escape(">");
    }

    private final boolean hasModifiersOrAnnotations(KotlinType kotlinType) {
        if (!FunctionTypesKt.isSuspendFunctionType(kotlinType) && kotlinType.getAnnotations().isEmpty()) {
            return false;
        }
        return true;
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor memberDescriptor) {
        ClassDescriptor classDescriptor;
        if (memberDescriptor instanceof ClassDescriptor) {
            if (((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE) {
                return Modality.ABSTRACT;
            }
            return Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            classDescriptor = (ClassDescriptor) containingDeclaration;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
        Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor.getOverriddenDescriptors(), "this.overriddenDescriptors");
        if ((!r1.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (classDescriptor.getKind() == ClassKind.INTERFACE && !Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.PRIVATE)) {
            Modality modality = callableMemberDescriptor.getModality();
            Modality modality2 = Modality.ABSTRACT;
            if (modality != modality2) {
                return Modality.OPEN;
            }
            return modality2;
        }
        return Modality.FINAL;
    }

    private final boolean isParameterName(AnnotationDescriptor annotationDescriptor) {
        return Intrinsics.areEqual(annotationDescriptor.getFqName(), StandardNames.FqNames.parameterName);
    }

    private final String lt() {
        return escape("<");
    }

    private final boolean overridesSomething(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder sb5, AbbreviatedType abbreviatedType) {
        RenderingFormat textFormat = getTextFormat();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (textFormat == renderingFormat) {
            sb5.append("<font color=\"808080\"><i>");
        }
        sb5.append(" /* = ");
        renderNormalizedTypeAsIs(sb5, abbreviatedType.getExpandedType());
        sb5.append(" */");
        if (getTextFormat() == renderingFormat) {
            sb5.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAccessorModifiers(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb5) {
        renderMemberModifiers(propertyAccessorDescriptor, sb5);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renderAdditionalModifiers(FunctionDescriptor functionDescriptor, StringBuilder sb5) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = false;
        if (functionDescriptor.isOperator()) {
            Collection<? extends FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "functionDescriptor.overriddenDescriptors");
            Collection<? extends FunctionDescriptor> collection = overriddenDescriptors;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((FunctionDescriptor) it.next()).isOperator()) {
                        z18 = false;
                        break;
                    }
                }
            }
            z18 = true;
            if (z18 || getAlwaysRenderModifiers()) {
                z16 = true;
                if (functionDescriptor.isInfix()) {
                    Collection<? extends FunctionDescriptor> overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
                    Intrinsics.checkNotNullExpressionValue(overriddenDescriptors2, "functionDescriptor.overriddenDescriptors");
                    Collection<? extends FunctionDescriptor> collection2 = overriddenDescriptors2;
                    if (!collection2.isEmpty()) {
                        Iterator<T> it5 = collection2.iterator();
                        while (it5.hasNext()) {
                            if (((FunctionDescriptor) it5.next()).isInfix()) {
                                z17 = false;
                                break;
                            }
                        }
                    }
                    z17 = true;
                    if (z17 || getAlwaysRenderModifiers()) {
                        z19 = true;
                    }
                }
                renderModifier(sb5, functionDescriptor.isTailrec(), "tailrec");
                renderSuspendModifier(functionDescriptor, sb5);
                renderModifier(sb5, functionDescriptor.isInline(), CssStyleSet.INLINE_STYLE);
                renderModifier(sb5, z19, "infix");
                renderModifier(sb5, z16, JsonRuleKey.OPERATOR);
            }
        }
        z16 = false;
        if (functionDescriptor.isInfix()) {
        }
        renderModifier(sb5, functionDescriptor.isTailrec(), "tailrec");
        renderSuspendModifier(functionDescriptor, sb5);
        renderModifier(sb5, functionDescriptor.isInline(), CssStyleSet.INLINE_STYLE);
        renderModifier(sb5, z19, "infix");
        renderModifier(sb5, z16, JsonRuleKey.OPERATOR);
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor classDescriptor;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List plus;
        List<String> sorted;
        String str;
        ClassConstructorDescriptor mo1773getUnsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        int collectionSizeOrDefault3;
        Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        List list = null;
        if (getRenderDefaultAnnotationArguments()) {
            classDescriptor = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null && (mo1773getUnsubstitutedPrimaryConstructor = classDescriptor.mo1773getUnsubstitutedPrimaryConstructor()) != null && (valueParameters = mo1773getUnsubstitutedPrimaryConstructor.getValueParameters()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : valueParameters) {
                if (((ValueParameterDescriptor) obj).declaresDefaultValue()) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault3);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ValueParameterDescriptor) it.next()).getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            Name it5 = (Name) obj2;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (!allValueArguments.containsKey(it5)) {
                arrayList3.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            arrayList4.add(((Name) it6.next()).asString() + " = ...");
        }
        Set<Map.Entry<Name, ConstantValue<?>>> entrySet = allValueArguments.entrySet();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it7 = entrySet.iterator();
        while (it7.hasNext()) {
            Map.Entry entry = (Map.Entry) it7.next();
            Name name = (Name) entry.getKey();
            ConstantValue<?> constantValue = (ConstantValue) entry.getValue();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(name.asString());
            sb5.append(" = ");
            if (!list.contains(name)) {
                str = renderConstant(constantValue);
            } else {
                str = MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            sb5.append(str);
            arrayList5.add(sb5.toString());
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5);
        sorted = CollectionsKt___CollectionsKt.sorted(plus);
        return sorted;
    }

    private final void renderAnnotations(StringBuilder sb5, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Set<FqName> excludedAnnotationClasses;
        boolean contains;
        if (!getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            return;
        }
        if (annotated instanceof KotlinType) {
            excludedAnnotationClasses = getExcludedTypeAnnotationClasses();
        } else {
            excludedAnnotationClasses = getExcludedAnnotationClasses();
        }
        Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
        for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
            contains = CollectionsKt___CollectionsKt.contains(excludedAnnotationClasses, annotationDescriptor.getFqName());
            if (!contains && !isParameterName(annotationDescriptor) && (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue())) {
                sb5.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                if (getEachAnnotationOnNewLine()) {
                    sb5.append('\n');
                    Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
                } else {
                    sb5.append(" ");
                }
            }
        }
    }

    static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb5, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(sb5, annotated, annotationUseSiteTarget);
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb5) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb5.append(" /*captured type parameters: ");
            renderTypeParameterList(sb5, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb5.append("*/");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderClass(ClassDescriptor classDescriptor, StringBuilder sb5) {
        boolean z16;
        ClassConstructorDescriptor mo1773getUnsubstitutedPrimaryConstructor;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!getStartFromName()) {
            renderAnnotations$default(this, sb5, classDescriptor, null, 2, null);
            List<ReceiverParameterDescriptor> contextReceivers = classDescriptor.getContextReceivers();
            Intrinsics.checkNotNullExpressionValue(contextReceivers, "klass.contextReceivers");
            renderContextReceivers(contextReceivers, sb5);
            if (!z16) {
                DescriptorVisibility visibility = classDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "klass.visibility");
                renderVisibility(visibility, sb5);
            }
            if ((classDescriptor.getKind() != ClassKind.INTERFACE || classDescriptor.getModality() != Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "klass.modality");
                renderModality(modality, sb5, implicitModalityWithoutExtensions(classDescriptor));
            }
            renderMemberModifiers(classDescriptor, sb5);
            if (getModifiers().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner()) {
                z17 = true;
            } else {
                z17 = false;
            }
            renderModifier(sb5, z17, "inner");
            if (getModifiers().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData()) {
                z18 = true;
            } else {
                z18 = false;
            }
            renderModifier(sb5, z18, "data");
            if (getModifiers().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline()) {
                z19 = true;
            } else {
                z19 = false;
            }
            renderModifier(sb5, z19, CssStyleSet.INLINE_STYLE);
            if (getModifiers().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue()) {
                z26 = true;
            } else {
                z26 = false;
            }
            renderModifier(sb5, z26, "value");
            if (getModifiers().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun()) {
                z27 = true;
            } else {
                z27 = false;
            }
            renderModifier(sb5, z27, "fun");
            renderClassKindPrefix(classDescriptor, sb5);
        }
        if (!DescriptorUtils.isCompanionObject(classDescriptor)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb5);
            }
            renderName(classDescriptor, sb5, true);
        } else {
            renderCompanionObjectName(classDescriptor, sb5);
        }
        if (z16) {
            return;
        }
        List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
        renderTypeParameters(declaredTypeParameters, sb5, false);
        renderCapturedTypeParametersIfRequired(classDescriptor, sb5);
        if (!classDescriptor.getKind().isSingleton() && getClassWithPrimaryConstructor() && (mo1773getUnsubstitutedPrimaryConstructor = classDescriptor.mo1773getUnsubstitutedPrimaryConstructor()) != null) {
            sb5.append(" ");
            renderAnnotations$default(this, sb5, mo1773getUnsubstitutedPrimaryConstructor, null, 2, null);
            DescriptorVisibility visibility2 = mo1773getUnsubstitutedPrimaryConstructor.getVisibility();
            Intrinsics.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
            renderVisibility(visibility2, sb5);
            sb5.append(renderKeyword("constructor"));
            List<ValueParameterDescriptor> valueParameters = mo1773getUnsubstitutedPrimaryConstructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
            renderValueParameters(valueParameters, mo1773getUnsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb5);
        }
        renderSuperTypes(classDescriptor, sb5);
        renderWhereSuffix(declaredTypeParameters, sb5);
    }

    private final void renderClassKindPrefix(ClassDescriptor classDescriptor, StringBuilder sb5) {
        sb5.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor declarationDescriptor, StringBuilder sb5) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                sb5.append("companion object");
            }
            renderSpaceIfNeeded(sb5);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb5.append("of ");
                Name name = containingDeclaration.getName();
                Intrinsics.checkNotNullExpressionValue(name, "containingDeclaration.name");
                sb5.append(renderName(name, false));
            }
        }
        if (getVerbose() || !Intrinsics.areEqual(declarationDescriptor.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb5);
            }
            Name name2 = declarationDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
            sb5.append(renderName(name2, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String renderConstant(ConstantValue<?> constantValue) {
        String removePrefix;
        String joinToString$default;
        if (constantValue instanceof ArrayValue) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(((ArrayValue) constantValue).getValue(), ", ", "{", "}", 0, null, new Function1<ConstantValue<?>, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstant$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull ConstantValue<?> it) {
                    String renderConstant;
                    Intrinsics.checkNotNullParameter(it, "it");
                    renderConstant = DescriptorRendererImpl.this.renderConstant(it);
                    return renderConstant;
                }
            }, 24, null);
            return joinToString$default;
        }
        if (constantValue instanceof AnnotationValue) {
            removePrefix = StringsKt__StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, ((AnnotationValue) constantValue).getValue(), null, 2, null), (CharSequence) "@");
            return removePrefix;
        }
        if (constantValue instanceof KClassValue) {
            KClassValue.Value value = ((KClassValue) constantValue).getValue();
            if (value instanceof KClassValue.Value.LocalClass) {
                return ((KClassValue.Value.LocalClass) value).getType() + "::class";
            }
            if (value instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
                String asString = normalClass.getClassId().asSingleFqName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "classValue.classId.asSingleFqName().asString()");
                int arrayDimensions = normalClass.getArrayDimensions();
                for (int i3 = 0; i3 < arrayDimensions; i3++) {
                    asString = "kotlin.Array<" + asString + Typography.greater;
                }
                return asString + "::class";
            }
            throw new NoWhenBranchMatchedException();
        }
        return constantValue.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderConstructor(ConstructorDescriptor constructorDescriptor, StringBuilder sb5) {
        boolean z16;
        boolean z17;
        ClassConstructorDescriptor mo1773getUnsubstitutedPrimaryConstructor;
        ArrayList arrayList;
        String joinToString$default;
        boolean z18;
        renderAnnotations$default(this, sb5, constructorDescriptor, null, 2, null);
        if (this.options.getRenderDefaultVisibility() || constructorDescriptor.getConstructedClass().getModality() != Modality.SEALED) {
            DescriptorVisibility visibility = constructorDescriptor.getVisibility();
            Intrinsics.checkNotNullExpressionValue(visibility, "constructor.visibility");
            if (renderVisibility(visibility, sb5)) {
                z16 = true;
                renderMemberKind(constructorDescriptor, sb5);
                if (getRenderConstructorKeyword() && constructorDescriptor.isPrimary() && !z16) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    sb5.append(renderKeyword("constructor"));
                }
                ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration, "constructor.containingDeclaration");
                if (getSecondaryConstructorsAsPrimary()) {
                    if (z17) {
                        sb5.append(" ");
                    }
                    renderName(containingDeclaration, sb5, true);
                    List<TypeParameterDescriptor> typeParameters = constructorDescriptor.getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters, "constructor.typeParameters");
                    renderTypeParameters(typeParameters, sb5, false);
                }
                List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "constructor.valueParameters");
                renderValueParameters(valueParameters, constructorDescriptor.hasSynthesizedParameterNames(), sb5);
                if (getRenderConstructorDelegation() && !constructorDescriptor.isPrimary() && (containingDeclaration instanceof ClassDescriptor) && (mo1773getUnsubstitutedPrimaryConstructor = ((ClassDescriptor) containingDeclaration).mo1773getUnsubstitutedPrimaryConstructor()) != null) {
                    List<ValueParameterDescriptor> valueParameters2 = mo1773getUnsubstitutedPrimaryConstructor.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters2, "primaryConstructor.valueParameters");
                    arrayList = new ArrayList();
                    for (Object obj : valueParameters2) {
                        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) obj;
                        if (!valueParameterDescriptor.declaresDefaultValue() && valueParameterDescriptor.getVarargElementType() == null) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            arrayList.add(obj);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        sb5.append(ProgressTracer.SEPARATOR);
                        sb5.append(renderKeyword("this"));
                        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "(", ")", 0, null, new Function1<ValueParameterDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1
                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor2) {
                                return "";
                            }
                        }, 24, null);
                        sb5.append(joinToString$default);
                    }
                }
                if (!getSecondaryConstructorsAsPrimary()) {
                    List<TypeParameterDescriptor> typeParameters2 = constructorDescriptor.getTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(typeParameters2, "constructor.typeParameters");
                    renderWhereSuffix(typeParameters2, sb5);
                    return;
                }
                return;
            }
        }
        z16 = false;
        renderMemberKind(constructorDescriptor, sb5);
        if (getRenderConstructorKeyword()) {
        }
        z17 = true;
        if (z17) {
        }
        ClassifierDescriptorWithTypeParameters containingDeclaration2 = constructorDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "constructor.containingDeclaration");
        if (getSecondaryConstructorsAsPrimary()) {
        }
        List<ValueParameterDescriptor> valueParameters3 = constructorDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters3, "constructor.valueParameters");
        renderValueParameters(valueParameters3, constructorDescriptor.hasSynthesizedParameterNames(), sb5);
        if (getRenderConstructorDelegation()) {
            List<ValueParameterDescriptor> valueParameters22 = mo1773getUnsubstitutedPrimaryConstructor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters22, "primaryConstructor.valueParameters");
            arrayList = new ArrayList();
            while (r0.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
            }
        }
        if (!getSecondaryConstructorsAsPrimary()) {
        }
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> list, StringBuilder sb5) {
        int lastIndex;
        if (!list.isEmpty()) {
            sb5.append("context(");
            int i3 = 0;
            for (ReceiverParameterDescriptor receiverParameterDescriptor : list) {
                int i16 = i3 + 1;
                renderAnnotations(sb5, receiverParameterDescriptor, AnnotationUseSiteTarget.RECEIVER);
                KotlinType type = receiverParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "contextReceiver.type");
                sb5.append(renderForReceiver(type));
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
                if (i3 == lastIndex) {
                    sb5.append(") ");
                } else {
                    sb5.append(", ");
                }
                i3 = i16;
            }
        }
    }

    private final void renderDefaultType(StringBuilder sb5, KotlinType kotlinType) {
        DefinitelyNotNullType definitelyNotNullType;
        renderAnnotations$default(this, sb5, kotlinType, null, 2, null);
        SimpleType simpleType = null;
        if (kotlinType instanceof DefinitelyNotNullType) {
            definitelyNotNullType = (DefinitelyNotNullType) kotlinType;
        } else {
            definitelyNotNullType = null;
        }
        if (definitelyNotNullType != null) {
            simpleType = definitelyNotNullType.getOriginal();
        }
        if (KotlinTypeKt.isError(kotlinType)) {
            if (TypeUtilsKt.isUnresolvedType(kotlinType) && getPresentableUnresolvedTypes()) {
                sb5.append(((ErrorType) kotlinType).getDebugMessage());
            } else if ((kotlinType instanceof ErrorType) && !getInformativeErrorType()) {
                sb5.append(((ErrorType) kotlinType).getDebugMessage());
            } else {
                sb5.append(kotlinType.getConstructor().toString());
            }
            sb5.append(renderTypeArguments(kotlinType.getArguments()));
        } else if (kotlinType instanceof StubTypeForBuilderInference) {
            sb5.append(((StubTypeForBuilderInference) kotlinType).getOriginalTypeVariable().toString());
        } else if (simpleType instanceof StubTypeForBuilderInference) {
            sb5.append(((StubTypeForBuilderInference) simpleType).getOriginalTypeVariable().toString());
        } else {
            renderTypeConstructorAndArguments$default(this, sb5, kotlinType, null, 2, null);
        }
        if (kotlinType.isMarkedNullable()) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            sb5.append(" & Any");
        }
    }

    private final String renderError(String str) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final String renderForReceiver(KotlinType kotlinType) {
        String renderType = renderType(kotlinType);
        if (shouldRenderAsPrettyFunctionType(kotlinType) && !TypeUtils.isNullableType(kotlinType)) {
            return '(' + renderType + ')';
        }
        return renderType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderFunction(FunctionDescriptor functionDescriptor, StringBuilder sb5) {
        String renderType;
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderAnnotations$default(this, sb5, functionDescriptor, null, 2, null);
                List<ReceiverParameterDescriptor> contextReceiverParameters = functionDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "function.contextReceiverParameters");
                renderContextReceivers(contextReceiverParameters, sb5);
                DescriptorVisibility visibility = functionDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "function.visibility");
                renderVisibility(visibility, sb5);
                renderModalityForCallable(functionDescriptor, sb5);
                if (getIncludeAdditionalModifiers()) {
                    renderMemberModifiers(functionDescriptor, sb5);
                }
                renderOverride(functionDescriptor, sb5);
                if (getIncludeAdditionalModifiers()) {
                    renderAdditionalModifiers(functionDescriptor, sb5);
                } else {
                    renderSuspendModifier(functionDescriptor, sb5);
                }
                renderMemberKind(functionDescriptor, sb5);
                if (getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb5.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb5.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb5.append(renderKeyword("fun"));
            sb5.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            renderTypeParameters(typeParameters, sb5, true);
            renderReceiver(functionDescriptor, sb5);
        }
        renderName(functionDescriptor, sb5, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        renderValueParameters(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb5);
        renderReceiverAfterName(functionDescriptor, sb5);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb5.append(MsgSummary.STR_COLON);
            if (returnType == null) {
                renderType = "[NULL]";
            } else {
                renderType = renderType(returnType);
            }
            sb5.append(renderType);
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        renderWhereSuffix(typeParameters2, sb5);
    }

    private final void renderFunctionType(StringBuilder sb5, KotlinType kotlinType) {
        boolean z16;
        boolean z17;
        Name name;
        boolean z18;
        char last;
        int lastIndex;
        int lastIndex2;
        int lastIndex3;
        Object last2;
        int length = sb5.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), sb5, kotlinType, null, 2, null);
        if (sb5.length() != length) {
            z16 = true;
        } else {
            z16 = false;
        }
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        if (!contextReceiverTypesFromFunctionType.isEmpty()) {
            sb5.append("context(");
            lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(contextReceiverTypesFromFunctionType);
            Iterator<KotlinType> it = contextReceiverTypesFromFunctionType.subList(0, lastIndex3).iterator();
            while (it.hasNext()) {
                renderNormalizedType(sb5, it.next());
                sb5.append(", ");
            }
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) contextReceiverTypesFromFunctionType);
            renderNormalizedType(sb5, (KotlinType) last2);
            sb5.append(") ");
        }
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        boolean isMarkedNullable = kotlinType.isMarkedNullable();
        if (!isMarkedNullable && (!z16 || receiverTypeFromFunctionType == null)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            if (isSuspendFunctionType) {
                sb5.insert(length, '(');
            } else {
                if (z16) {
                    last = StringsKt___StringsKt.last(sb5);
                    CharsKt__CharJVMKt.isWhitespace(last);
                    lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
                    if (sb5.charAt(lastIndex - 1) != ')') {
                        lastIndex2 = StringsKt__StringsKt.getLastIndex(sb5);
                        sb5.insert(lastIndex2, "()");
                    }
                }
                sb5.append("(");
            }
        }
        renderModifier(sb5, isSuspendFunctionType, QCircleDaTongConstant.ElementParamValue.SUSPEND);
        if (receiverTypeFromFunctionType != null) {
            if ((shouldRenderAsPrettyFunctionType(receiverTypeFromFunctionType) && !receiverTypeFromFunctionType.isMarkedNullable()) || hasModifiersOrAnnotations(receiverTypeFromFunctionType)) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                sb5.append("(");
            }
            renderNormalizedType(sb5, receiverTypeFromFunctionType);
            if (z18) {
                sb5.append(")");
            }
            sb5.append(".");
        }
        sb5.append("(");
        if (FunctionTypesKt.isBuiltinExtensionFunctionalType(kotlinType) && kotlinType.getArguments().size() <= 1) {
            sb5.append("???");
        } else {
            int i3 = 0;
            for (TypeProjection typeProjection : FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType)) {
                int i16 = i3 + 1;
                if (i3 > 0) {
                    sb5.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                    name = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    name = null;
                }
                if (name != null) {
                    sb5.append(renderName(name, false));
                    sb5.append(MsgSummary.STR_COLON);
                }
                sb5.append(renderTypeProjection(typeProjection));
                i3 = i16;
            }
        }
        sb5.append(") ");
        sb5.append(arrow());
        sb5.append(" ");
        renderNormalizedType(sb5, FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType));
        if (z17) {
            sb5.append(")");
        }
        if (isMarkedNullable) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
    }

    private final void renderInitializer(VariableDescriptor variableDescriptor, StringBuilder sb5) {
        ConstantValue<?> mo1775getCompileTimeInitializer;
        if (getIncludePropertyConstant() && (mo1775getCompileTimeInitializer = variableDescriptor.mo1775getCompileTimeInitializer()) != null) {
            sb5.append(" = ");
            sb5.append(escape(renderConstant(mo1775getCompileTimeInitializer)));
        }
    }

    private final String renderKeyword(String str) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (!getBoldOnlyForNamesInHtml()) {
                    return "<b>" + str + "</b>";
                }
                return str;
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb5) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb5.append("/*");
            sb5.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMemberDescriptor.getKind().name()));
            sb5.append("*/ ");
        }
    }

    private final void renderMemberModifiers(MemberDescriptor memberDescriptor, StringBuilder sb5) {
        boolean z16;
        renderModifier(sb5, memberDescriptor.isExternal(), "external");
        boolean z17 = true;
        if (getModifiers().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect()) {
            z16 = true;
        } else {
            z16 = false;
        }
        renderModifier(sb5, z16, "expect");
        if (!getModifiers().contains(DescriptorRendererModifier.ACTUAL) || !memberDescriptor.isActual()) {
            z17 = false;
        }
        renderModifier(sb5, z17, "actual");
    }

    private final void renderModality(Modality modality, StringBuilder sb5, Modality modality2) {
        if (!getRenderDefaultModality() && modality == modality2) {
            return;
        }
        renderModifier(sb5, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality.name()));
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb5) {
        if (!DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) || callableMemberDescriptor.getModality() != Modality.FINAL) {
            if (getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.getModality() == Modality.OPEN && overridesSomething(callableMemberDescriptor)) {
                return;
            }
            Modality modality = callableMemberDescriptor.getModality();
            Intrinsics.checkNotNullExpressionValue(modality, "callable.modality");
            renderModality(modality, sb5, implicitModalityWithoutExtensions(callableMemberDescriptor));
        }
    }

    private final void renderModifier(StringBuilder sb5, boolean z16, String str) {
        if (z16) {
            sb5.append(renderKeyword(str));
            sb5.append(" ");
        }
    }

    private final void renderNormalizedType(StringBuilder sb5, KotlinType kotlinType) {
        AbbreviatedType abbreviatedType;
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof AbbreviatedType) {
            abbreviatedType = (AbbreviatedType) unwrap;
        } else {
            abbreviatedType = null;
        }
        if (abbreviatedType != null) {
            if (getRenderTypeExpansions()) {
                renderNormalizedTypeAsIs(sb5, abbreviatedType.getExpandedType());
                return;
            }
            renderNormalizedTypeAsIs(sb5, abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                renderAbbreviatedTypeExpansion(sb5, abbreviatedType);
                return;
            }
            return;
        }
        renderNormalizedTypeAsIs(sb5, kotlinType);
    }

    private final void renderNormalizedTypeAsIs(StringBuilder sb5, KotlinType kotlinType) {
        if ((kotlinType instanceof WrappedType) && getDebugMode() && !((WrappedType) kotlinType).isComputed()) {
            sb5.append("<Not computed yet>");
            return;
        }
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            sb5.append(((FlexibleType) unwrap).render(this, this));
        } else if (unwrap instanceof SimpleType) {
            renderSimpleType(sb5, (SimpleType) unwrap);
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb5) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && overridesSomething(callableMemberDescriptor) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            renderModifier(sb5, true, "override");
            if (getVerbose()) {
                sb5.append("/*");
                sb5.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb5.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageFragment(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb5) {
        renderPackageHeader(packageFragmentDescriptor.getFqName(), "package-fragment", sb5);
        if (getDebugMode()) {
            sb5.append(" in ");
            renderName(packageFragmentDescriptor.getContainingDeclaration(), sb5, false);
        }
    }

    private final void renderPackageHeader(FqName fqName, String str, StringBuilder sb5) {
        boolean z16;
        sb5.append(renderKeyword(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            sb5.append(" ");
            sb5.append(renderFqName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageView(PackageViewDescriptor packageViewDescriptor, StringBuilder sb5) {
        renderPackageHeader(packageViewDescriptor.getFqName(), "package", sb5);
        if (getDebugMode()) {
            sb5.append(" in context of ");
            renderName(packageViewDescriptor.getModule(), sb5, false);
        }
    }

    private final void renderPossiblyInnerType(StringBuilder sb5, PossiblyInnerType possiblyInnerType) {
        PossiblyInnerType outerType = possiblyInnerType.getOuterType();
        if (outerType != null) {
            renderPossiblyInnerType(sb5, outerType);
            sb5.append('.');
            Name name = possiblyInnerType.getClassifierDescriptor().getName();
            Intrinsics.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb5.append(renderName(name, false));
        } else {
            TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classi\u2026escriptor.typeConstructor");
            sb5.append(renderTypeConstructor(typeConstructor));
        }
        sb5.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderProperty(PropertyDescriptor propertyDescriptor, StringBuilder sb5) {
        boolean z16;
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderPropertyAnnotations(propertyDescriptor, sb5);
                List<ReceiverParameterDescriptor> contextReceiverParameters = propertyDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "property.contextReceiverParameters");
                renderContextReceivers(contextReceiverParameters, sb5);
                DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "property.visibility");
                renderVisibility(visibility, sb5);
                boolean z17 = false;
                if (getModifiers().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                renderModifier(sb5, z16, "const");
                renderMemberModifiers(propertyDescriptor, sb5);
                renderModalityForCallable(propertyDescriptor, sb5);
                renderOverride(propertyDescriptor, sb5);
                if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z17 = true;
                }
                renderModifier(sb5, z17, "lateinit");
                renderMemberKind(propertyDescriptor, sb5);
            }
            renderValVarPrefix$default(this, propertyDescriptor, sb5, false, 4, null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            renderTypeParameters(typeParameters, sb5, true);
            renderReceiver(propertyDescriptor, sb5);
        }
        renderName(propertyDescriptor, sb5, true);
        sb5.append(MsgSummary.STR_COLON);
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "property.type");
        sb5.append(renderType(type));
        renderReceiverAfterName(propertyDescriptor, sb5);
        renderInitializer(propertyDescriptor, sb5);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        renderWhereSuffix(typeParameters2, sb5);
    }

    private final void renderPropertyAnnotations(PropertyDescriptor propertyDescriptor, StringBuilder sb5) {
        Object single;
        if (!getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            return;
        }
        renderAnnotations$default(this, sb5, propertyDescriptor, null, 2, null);
        FieldDescriptor backingField = propertyDescriptor.getBackingField();
        if (backingField != null) {
            renderAnnotations(sb5, backingField, AnnotationUseSiteTarget.FIELD);
        }
        FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
        if (delegateField != null) {
            renderAnnotations(sb5, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
        }
        if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
            PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
            if (getter != null) {
                renderAnnotations(sb5, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
            }
            PropertySetterDescriptor setter = propertyDescriptor.getSetter();
            if (setter != null) {
                renderAnnotations(sb5, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                single = CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters);
                ValueParameterDescriptor it = (ValueParameterDescriptor) single;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                renderAnnotations(sb5, it, AnnotationUseSiteTarget.SETTER_PARAMETER);
            }
        }
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder sb5) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            renderAnnotations(sb5, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb5.append(renderForReceiver(type));
            sb5.append(".");
        }
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder sb5) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb5.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb5.append(renderType(type));
        }
    }

    private final void renderSimpleType(StringBuilder sb5, SimpleType simpleType) {
        if (!Intrinsics.areEqual(simpleType, TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) && !TypeUtils.isDontCarePlaceholder(simpleType)) {
            if (ErrorUtils.isUninferredTypeVariable(simpleType)) {
                if (getUninferredTypeParameterAsName()) {
                    TypeConstructor constructor = simpleType.getConstructor();
                    Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                    sb5.append(renderError(((ErrorTypeConstructor) constructor).getParam(0)));
                    return;
                }
                sb5.append("???");
                return;
            }
            if (KotlinTypeKt.isError(simpleType)) {
                renderDefaultType(sb5, simpleType);
                return;
            } else if (shouldRenderAsPrettyFunctionType(simpleType)) {
                renderFunctionType(sb5, simpleType);
                return;
            } else {
                renderDefaultType(sb5, simpleType);
                return;
            }
        }
        sb5.append("???");
    }

    private final void renderSpaceIfNeeded(StringBuilder sb5) {
        int length = sb5.length();
        if (length == 0 || sb5.charAt(length - 1) != ' ') {
            sb5.append(TokenParser.SP);
        }
    }

    private final void renderSuperTypes(ClassDescriptor classDescriptor, StringBuilder sb5) {
        if (getWithoutSuperTypes() || KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            return;
        }
        Collection<KotlinType> mo1780getSupertypes = classDescriptor.getTypeConstructor().mo1780getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo1780getSupertypes, "klass.typeConstructor.supertypes");
        if (!mo1780getSupertypes.isEmpty()) {
            if (mo1780getSupertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(mo1780getSupertypes.iterator().next())) {
                renderSpaceIfNeeded(sb5);
                sb5.append(MsgSummary.STR_COLON);
                CollectionsKt___CollectionsKt.joinTo$default(mo1780getSupertypes, sb5, ", ", null, null, 0, null, new Function1<KotlinType, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderSuperTypes$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(KotlinType it) {
                        DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        return descriptorRendererImpl.renderType(it);
                    }
                }, 60, null);
            }
        }
    }

    private final void renderSuspendModifier(FunctionDescriptor functionDescriptor, StringBuilder sb5) {
        renderModifier(sb5, functionDescriptor.isSuspend(), QCircleDaTongConstant.ElementParamValue.SUSPEND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeAlias(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb5) {
        renderAnnotations$default(this, sb5, typeAliasDescriptor, null, 2, null);
        DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        renderVisibility(visibility, sb5);
        renderMemberModifiers(typeAliasDescriptor, sb5);
        sb5.append(renderKeyword("typealias"));
        sb5.append(" ");
        renderName(typeAliasDescriptor, sb5, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        renderTypeParameters(declaredTypeParameters, sb5, false);
        renderCapturedTypeParametersIfRequired(typeAliasDescriptor, sb5);
        sb5.append(" = ");
        sb5.append(renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    private final void renderTypeConstructorAndArguments(StringBuilder sb5, KotlinType kotlinType, TypeConstructor typeConstructor) {
        PossiblyInnerType buildPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
        if (buildPossiblyInnerType == null) {
            sb5.append(renderTypeConstructor(typeConstructor));
            sb5.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            renderPossiblyInnerType(sb5, buildPossiblyInnerType);
        }
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb5, KotlinType kotlinType, TypeConstructor typeConstructor, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(sb5, kotlinType, typeConstructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeParameter(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb5, boolean z16) {
        boolean z17;
        if (z16) {
            sb5.append(lt());
        }
        if (getVerbose()) {
            sb5.append("/*");
            sb5.append(typeParameterDescriptor.getIndex());
            sb5.append("*/ ");
        }
        renderModifier(sb5, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z18 = true;
        if (label.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        renderModifier(sb5, z17, label);
        renderAnnotations$default(this, sb5, typeParameterDescriptor, null, 2, null);
        renderName(typeParameterDescriptor, sb5, z16);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z16) || size == 1) {
            KotlinType upperBound = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(upperBound)) {
                sb5.append(ProgressTracer.SEPARATOR);
                Intrinsics.checkNotNullExpressionValue(upperBound, "upperBound");
                sb5.append(renderType(upperBound));
            }
        } else if (z16) {
            for (KotlinType upperBound2 : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(upperBound2)) {
                    if (z18) {
                        sb5.append(ProgressTracer.SEPARATOR);
                    } else {
                        sb5.append(" & ");
                    }
                    Intrinsics.checkNotNullExpressionValue(upperBound2, "upperBound");
                    sb5.append(renderType(upperBound2));
                    z18 = false;
                }
            }
        }
        if (z16) {
            sb5.append(gt());
        }
    }

    private final void renderTypeParameterList(StringBuilder sb5, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            renderTypeParameter(it.next(), sb5, false);
            if (it.hasNext()) {
                sb5.append(", ");
            }
        }
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> list, StringBuilder sb5, boolean z16) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb5.append(lt());
            renderTypeParameterList(sb5, list);
            sb5.append(gt());
            if (z16) {
                sb5.append(" ");
            }
        }
    }

    private final void renderValVarPrefix(VariableDescriptor variableDescriptor, StringBuilder sb5, boolean z16) {
        String str;
        if (z16 || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            if (variableDescriptor.isVar()) {
                str = "var";
            } else {
                str = TPReportParams.JSON_KEY_VAL;
            }
            sb5.append(renderKeyword(str));
            sb5.append(" ");
        }
    }

    static /* synthetic */ void renderValVarPrefix$default(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb5, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, sb5, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        if (r11 != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderValueParameter(ValueParameterDescriptor valueParameterDescriptor, boolean z16, StringBuilder sb5, boolean z17) {
        boolean z18;
        boolean declaresOrInheritsDefaultValue;
        ClassConstructorDescriptor classConstructorDescriptor;
        boolean z19;
        if (z17) {
            sb5.append(renderKeyword("value-parameter"));
            sb5.append(" ");
        }
        if (getVerbose()) {
            sb5.append("/*");
            sb5.append(valueParameterDescriptor.getIndex());
            sb5.append("*/ ");
        }
        renderAnnotations$default(this, sb5, valueParameterDescriptor, null, 2, null);
        renderModifier(sb5, valueParameterDescriptor.isCrossinline(), "crossinline");
        renderModifier(sb5, valueParameterDescriptor.isNoinline(), "noinline");
        boolean z26 = true;
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            CallableDescriptor containingDeclaration = valueParameterDescriptor.getContainingDeclaration();
            if (containingDeclaration instanceof ClassConstructorDescriptor) {
                classConstructorDescriptor = (ClassConstructorDescriptor) containingDeclaration;
            } else {
                classConstructorDescriptor = null;
            }
            if (classConstructorDescriptor != null && classConstructorDescriptor.isPrimary()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                z18 = true;
                if (z18) {
                    renderModifier(sb5, getActualPropertiesInPrimaryConstructor(), "actual");
                }
                renderVariable(valueParameterDescriptor, z16, sb5, z17, z18);
                if (getDefaultParameterValueRenderer() != null) {
                    if (getDebugMode()) {
                        declaresOrInheritsDefaultValue = valueParameterDescriptor.declaresDefaultValue();
                    } else {
                        declaresOrInheritsDefaultValue = DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor);
                    }
                }
                z26 = false;
                if (!z26) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(" = ");
                    Function1<ValueParameterDescriptor, String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
                    Intrinsics.checkNotNull(defaultParameterValueRenderer);
                    sb6.append(defaultParameterValueRenderer.invoke(valueParameterDescriptor));
                    sb5.append(sb6.toString());
                    return;
                }
                return;
            }
        }
        z18 = false;
        if (z18) {
        }
        renderVariable(valueParameterDescriptor, z16, sb5, z17, z18);
        if (getDefaultParameterValueRenderer() != null) {
        }
        z26 = false;
        if (!z26) {
        }
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> collection, boolean z16, StringBuilder sb5) {
        boolean shouldRenderParameterNames = shouldRenderParameterNames(z16);
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb5);
        int i3 = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i3, size, sb5);
            renderValueParameter(valueParameterDescriptor, shouldRenderParameterNames, sb5, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i3, size, sb5);
            i3++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb5);
    }

    private final void renderVariable(VariableDescriptor variableDescriptor, boolean z16, StringBuilder sb5, boolean z17, boolean z18) {
        ValueParameterDescriptor valueParameterDescriptor;
        KotlinType kotlinType;
        boolean z19;
        KotlinType type = variableDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "variable.type");
        KotlinType kotlinType2 = null;
        if (variableDescriptor instanceof ValueParameterDescriptor) {
            valueParameterDescriptor = (ValueParameterDescriptor) variableDescriptor;
        } else {
            valueParameterDescriptor = null;
        }
        if (valueParameterDescriptor != null) {
            kotlinType2 = valueParameterDescriptor.getVarargElementType();
        }
        if (kotlinType2 == null) {
            kotlinType = type;
        } else {
            kotlinType = kotlinType2;
        }
        if (kotlinType2 != null) {
            z19 = true;
        } else {
            z19 = false;
        }
        renderModifier(sb5, z19, "vararg");
        if (z18 || (z17 && !getStartFromName())) {
            renderValVarPrefix(variableDescriptor, sb5, z18);
        }
        if (z16) {
            renderName(variableDescriptor, sb5, z17);
            sb5.append(MsgSummary.STR_COLON);
        }
        sb5.append(renderType(kotlinType));
        renderInitializer(variableDescriptor, sb5);
        if (getVerbose() && kotlinType2 != null) {
            sb5.append(" /*");
            sb5.append(renderType(type));
            sb5.append("*/");
        }
    }

    private final boolean renderVisibility(DescriptorVisibility descriptorVisibility, StringBuilder sb5) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb5.append(renderKeyword(descriptorVisibility.getInternalDisplayName()));
        sb5.append(" ");
        return true;
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> list, StringBuilder sb5) {
        List<KotlinType> drop;
        if (getWithoutTypeParameters()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
            drop = CollectionsKt___CollectionsKt.drop(upperBounds, 1);
            for (KotlinType it : drop) {
                StringBuilder sb6 = new StringBuilder();
                Name name = typeParameterDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "typeParameter.name");
                sb6.append(renderName(name, false));
                sb6.append(ProgressTracer.SEPARATOR);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                sb6.append(renderType(it));
                arrayList.add(sb6.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb5.append(" ");
            sb5.append(renderKeyword("where"));
            sb5.append(" ");
            CollectionsKt___CollectionsKt.joinTo$default(arrayList, sb5, ", ", null, null, 0, null, null, 124, null);
        }
    }

    private final String replacePrefixes(String str, String str2, String str3, String str4, String str5) {
        boolean startsWith$default;
        boolean startsWith$default2;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, null);
        if (startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str3, str4, false, 2, null);
            if (startsWith$default2) {
                String substring = str.substring(str2.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                String substring2 = str3.substring(str4.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                String str6 = str5 + substring;
                if (Intrinsics.areEqual(substring, substring2)) {
                    return str6;
                }
                if (differsOnlyInNullability(substring, substring2)) {
                    return str6 + '!';
                }
            }
        }
        return null;
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType kotlinType) {
        boolean z16;
        if (!FunctionTypesKt.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        List<TypeProjection> arguments = kotlinType.getArguments();
        if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
            Iterator<T> it = arguments.iterator();
            while (it.hasNext()) {
                if (((TypeProjection) it.next()).isStarProjection()) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        if (!z16) {
            return false;
        }
        return true;
    }

    private final boolean shouldRenderParameterNames(boolean z16) {
        int i3 = WhenMappings.$EnumSwitchMapping$1[getParameterNameRenderingPolicy().ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!z16) {
            return true;
        }
        return false;
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    @NotNull
    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    @NotNull
    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String render(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb5 = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), sb5);
        if (getWithDefinedIn()) {
            appendDefinedIn(sb5, declarationDescriptor);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderAnnotation(@NotNull AnnotationDescriptor annotation, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        StringBuilder sb5 = new StringBuilder();
        sb5.append('@');
        if (annotationUseSiteTarget != null) {
            sb5.append(annotationUseSiteTarget.getRenderName() + ':');
        }
        KotlinType type = annotation.getType();
        sb5.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            List<String> renderAndSortAnnotationArguments = renderAndSortAnnotationArguments(annotation);
            if (getIncludeEmptyAnnotationArguments() || (!renderAndSortAnnotationArguments.isEmpty())) {
                CollectionsKt___CollectionsKt.joinTo$default(renderAndSortAnnotationArguments, sb5, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(type) || (type.getConstructor().mo1779getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            sb5.append(" /* annotation class not found */");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @NotNull
    public String renderClassifierName(@NotNull ClassifierDescriptor klass) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (ErrorUtils.isError(klass)) {
            return klass.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(klass, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderFlexibleType(@NotNull String lowerRendered, @NotNull String upperRendered, @NotNull KotlinBuiltIns builtIns) {
        String substringBefore$default;
        String substringBefore$default2;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (differsOnlyInNullability(lowerRendered, upperRendered)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(upperRendered, "(", false, 2, null);
            if (startsWith$default) {
                return '(' + lowerRendered + ")!";
            }
            return lowerRendered + '!';
        }
        ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
        ClassDescriptor collection = builtIns.getCollection();
        Intrinsics.checkNotNullExpressionValue(collection, "builtIns.collection");
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
        String replacePrefixes = replacePrefixes(lowerRendered, substringBefore$default + "Mutable", upperRendered, substringBefore$default, substringBefore$default + "(Mutable)");
        if (replacePrefixes != null) {
            return replacePrefixes;
        }
        String replacePrefixes2 = replacePrefixes(lowerRendered, substringBefore$default + "MutableMap.MutableEntry", upperRendered, substringBefore$default + "Map.Entry", substringBefore$default + "(Mutable)Map.(Mutable)Entry");
        if (replacePrefixes2 != null) {
            return replacePrefixes2;
        }
        ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
        ClassDescriptor array = builtIns.getArray();
        Intrinsics.checkNotNullExpressionValue(array, "builtIns.array");
        substringBefore$default2 = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), Entry.DATA_TYPE_Array, (String) null, 2, (Object) null);
        String replacePrefixes3 = replacePrefixes(lowerRendered, substringBefore$default2 + escape("Array<"), upperRendered, substringBefore$default2 + escape("Array<out "), substringBefore$default2 + escape("Array<(out) "));
        if (replacePrefixes3 != null) {
            return replacePrefixes3;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderFqName(@NotNull FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        List<Name> pathSegments = fqName.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "fqName.pathSegments()");
        return renderFqName(pathSegments);
    }

    @NotNull
    public String renderMessage(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        int i3 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return "<i>" + message + "</i>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return message;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderName(@NotNull Name name, boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        String escape = escape(RenderingUtilsKt.render(name));
        if (!getBoldOnlyForNamesInHtml() || getTextFormat() != RenderingFormat.HTML || !z16) {
            return escape;
        }
        return "<b>" + escape + "</b>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderType(@NotNull KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        StringBuilder sb5 = new StringBuilder();
        renderNormalizedType(sb5, getTypeNormalizer().invoke(type));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @NotNull
    public String renderTypeArguments(@NotNull List<? extends TypeProjection> typeArguments) {
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(lt());
        appendTypeProjections(sb5, typeArguments);
        sb5.append(gt());
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @NotNull
    public String renderTypeConstructor(@NotNull TypeConstructor typeConstructor) {
        boolean z16;
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor mo1779getDeclarationDescriptor = typeConstructor.mo1779getDeclarationDescriptor();
        boolean z17 = true;
        if (mo1779getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            z16 = true;
        } else {
            z16 = mo1779getDeclarationDescriptor instanceof ClassDescriptor;
        }
        if (!z16) {
            z17 = mo1779getDeclarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z17) {
            return renderClassifierName(mo1779getDeclarationDescriptor);
        }
        if (mo1779getDeclarationDescriptor == null) {
            if (typeConstructor instanceof IntersectionTypeConstructor) {
                return ((IntersectionTypeConstructor) typeConstructor).makeDebugNameForIntersectionType(new Function1<KotlinType, Object>() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderTypeConstructor$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Object invoke(@NotNull KotlinType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it instanceof StubTypeForBuilderInference ? ((StubTypeForBuilderInference) it).getOriginalTypeVariable() : it;
                    }
                });
            }
            return typeConstructor.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + mo1779getDeclarationDescriptor.getClass()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @NotNull
    public String renderTypeProjection(@NotNull TypeProjection typeProjection) {
        List<? extends TypeProjection> listOf;
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb5 = new StringBuilder();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(typeProjection);
        appendTypeProjections(sb5, listOf);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z16) {
        this.options.setDebugMode(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z16) {
        this.options.setReceiverAfterName(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z16) {
        this.options.setRenderCompanionObjectName(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z16) {
        this.options.setStartFromName(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z16) {
        this.options.setVerbose(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z16) {
        this.options.setWithDefinedIn(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z16) {
        this.options.setWithoutSuperTypes(z16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z16) {
        this.options.setWithoutTypeParameters(z16);
    }

    private final String renderFqName(List<Name> list) {
        return escape(RenderingUtilsKt.renderFqName(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderName(DeclarationDescriptor declarationDescriptor, StringBuilder sb5, boolean z16) {
        Name name = declarationDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        sb5.append(renderName(name, z16));
    }
}
