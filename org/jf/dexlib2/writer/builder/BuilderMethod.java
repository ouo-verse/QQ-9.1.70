package org.jf.dexlib2.writer.builder;

import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderMethod extends BaseMethodReference implements Method {
    final int accessFlags;

    @Nonnull
    final BuilderAnnotationSet annotations;

    @Nonnull
    final Set<HiddenApiRestriction> hiddenApiRestrictions;

    @Nullable
    final MethodImplementation methodImplementation;

    @Nonnull
    final BuilderMethodReference methodReference;

    @Nonnull
    final List<? extends BuilderMethodParameter> parameters;
    int annotationSetRefListOffset = 0;
    int codeItemOffset = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BuilderMethod(@Nonnull BuilderMethodReference builderMethodReference, @Nonnull List<? extends BuilderMethodParameter> list, int i3, @Nonnull BuilderAnnotationSet builderAnnotationSet, @Nonnull Set<HiddenApiRestriction> set, @Nullable MethodImplementation methodImplementation) {
        this.methodReference = builderMethodReference;
        this.parameters = list;
        this.accessFlags = i3;
        this.annotations = builderAnnotationSet;
        this.hiddenApiRestrictions = set;
        this.methodImplementation = methodImplementation;
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.methodReference.definingClass.getType();
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nullable
    public MethodImplementation getImplementation() {
        return this.methodImplementation;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.methodReference.name.getString();
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nonnull
    public List<? extends BuilderMethodParameter> getParameters() {
        return this.parameters;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return this.methodReference.proto.returnType.getType();
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public BuilderAnnotationSet getAnnotations() {
        return this.annotations;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public BuilderTypeList getParameterTypes() {
        return this.methodReference.proto.parameterTypes;
    }
}
