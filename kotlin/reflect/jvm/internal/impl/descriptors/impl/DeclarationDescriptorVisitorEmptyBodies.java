package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DeclarationDescriptorVisitorEmptyBodies<R, D> implements DeclarationDescriptorVisitor<R, D> {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitClassDescriptor(ClassDescriptor classDescriptor, D d16) {
        return visitDeclarationDescriptor(classDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d16) {
        return visitFunctionDescriptor(constructorDescriptor, d16);
    }

    public R visitDeclarationDescriptor(DeclarationDescriptor declarationDescriptor, D d16) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d16) {
        return visitDeclarationDescriptor(functionDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d16) {
        return visitDeclarationDescriptor(moduleDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d16) {
        return visitDeclarationDescriptor(packageFragmentDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d16) {
        return visitDeclarationDescriptor(packageViewDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d16) {
        return visitVariableDescriptor(propertyDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d16) {
        return visitFunctionDescriptor(propertyGetterDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d16) {
        return visitFunctionDescriptor(propertySetterDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d16) {
        return visitDeclarationDescriptor(receiverParameterDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d16) {
        return visitDeclarationDescriptor(typeAliasDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d16) {
        return visitDeclarationDescriptor(typeParameterDescriptor, d16);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d16) {
        return visitVariableDescriptor(valueParameterDescriptor, d16);
    }

    public R visitVariableDescriptor(VariableDescriptor variableDescriptor, D d16) {
        return visitDeclarationDescriptor(variableDescriptor, d16);
    }
}
