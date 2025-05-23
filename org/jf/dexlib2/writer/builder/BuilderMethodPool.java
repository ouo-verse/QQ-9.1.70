package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.writer.MethodSection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class BuilderMethodPool extends BaseBuilderPool implements MethodSection<BuilderStringReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderMethodReference, BuilderMethod> {

    @Nonnull
    private final ConcurrentMap<MethodReference, BuilderMethodReference> internedItems;

    /* loaded from: classes29.dex */
    private static class MethodKey extends BaseMethodReference {

        @Nonnull
        private final String definingClass;

        @Nonnull
        private final String name;

        @Nonnull
        private final List<? extends CharSequence> parameterTypes;

        @Nonnull
        private final String returnType;

        public MethodKey(@Nonnull String str, @Nonnull String str2, @Nonnull List<? extends CharSequence> list, @Nonnull String str3) {
            this.definingClass = str;
            this.name = str2;
            this.parameterTypes = list;
            this.returnType = str3;
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getDefiningClass() {
            return this.definingClass;
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
        @Nonnull
        public String getName() {
            return this.name;
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference
        @Nonnull
        public List<? extends CharSequence> getParameterTypes() {
            return this.parameterTypes;
        }

        @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
        @Nonnull
        public String getReturnType() {
            return this.returnType;
        }
    }

    public BuilderMethodPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderMethodReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderMethodPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderMethodReference builderMethodReference) {
                return builderMethodReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderMethodReference builderMethodReference, int i3) {
                int i16 = builderMethodReference.index;
                builderMethodReference.index = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderMethodReference internMethod(@Nonnull MethodReference methodReference) {
        BuilderMethodReference builderMethodReference = this.internedItems.get(methodReference);
        if (builderMethodReference != null) {
            return builderMethodReference;
        }
        BuilderMethodReference builderMethodReference2 = new BuilderMethodReference(((BuilderTypePool) this.dexBuilder.typeSection).internType(methodReference.getDefiningClass()), ((BuilderStringPool) this.dexBuilder.stringSection).internString(methodReference.getName()), ((BuilderProtoPool) this.dexBuilder.protoSection).internMethodProto(methodReference));
        BuilderMethodReference putIfAbsent = this.internedItems.putIfAbsent(builderMethodReference2, builderMethodReference2);
        return putIfAbsent == null ? builderMethodReference2 : putIfAbsent;
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public BuilderTypeReference getDefiningClass(@Nonnull BuilderMethodReference builderMethodReference) {
        return builderMethodReference.definingClass;
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull BuilderMethodReference builderMethodReference) {
        return builderMethodReference.index;
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    public int getMethodIndex(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.methodReference.index;
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public BuilderMethodReference getMethodReference(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.methodReference;
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public BuilderStringReference getName(@Nonnull BuilderMethodReference builderMethodReference) {
        return builderMethodReference.name;
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public BuilderMethodProtoReference getPrototype(@Nonnull BuilderMethodReference builderMethodReference) {
        return builderMethodReference.proto;
    }

    @Override // org.jf.dexlib2.writer.MethodSection
    @Nonnull
    public BuilderMethodProtoReference getPrototype(@Nonnull BuilderMethod builderMethod) {
        return builderMethod.methodReference.proto;
    }

    @Nonnull
    public BuilderMethodReference internMethod(@Nonnull String str, @Nonnull String str2, @Nonnull List<? extends CharSequence> list, @Nonnull String str3) {
        return internMethod(new MethodKey(str, str2, list, str3));
    }
}
