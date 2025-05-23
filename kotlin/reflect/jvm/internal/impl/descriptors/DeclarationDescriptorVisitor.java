package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor classDescriptor, D d16);

    R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d16);

    R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d16);

    R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d16);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d16);

    R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d16);

    R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d16);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d16);

    R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d16);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d16);

    R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d16);

    R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d16);

    R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d16);
}
