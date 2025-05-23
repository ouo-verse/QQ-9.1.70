package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.reference.ImmutableMethodProtoReference;
import org.jf.dexlib2.util.MethodUtil;
import org.jf.dexlib2.writer.ProtoSection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class BuilderProtoPool extends BaseBuilderPool implements ProtoSection<BuilderStringReference, BuilderTypeReference, BuilderMethodProtoReference, BuilderTypeList> {

    @Nonnull
    private final ConcurrentMap<MethodProtoReference, BuilderMethodProtoReference> internedItems;

    public BuilderProtoPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderMethodProtoReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderMethodProtoReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderProtoPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
                return builderMethodProtoReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderMethodProtoReference builderMethodProtoReference, int i3) {
                int i16 = builderMethodProtoReference.index;
                builderMethodProtoReference.index = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderMethodProtoReference internMethodProto(@Nonnull MethodProtoReference methodProtoReference) {
        BuilderMethodProtoReference builderMethodProtoReference = this.internedItems.get(methodProtoReference);
        if (builderMethodProtoReference != null) {
            return builderMethodProtoReference;
        }
        BuilderMethodProtoReference builderMethodProtoReference2 = new BuilderMethodProtoReference(((BuilderStringPool) this.dexBuilder.stringSection).internString(MethodUtil.getShorty(methodProtoReference.getParameterTypes(), methodProtoReference.getReturnType())), ((BuilderTypeListPool) this.dexBuilder.typeListSection).internTypeList(methodProtoReference.getParameterTypes()), ((BuilderTypePool) this.dexBuilder.typeSection).internType(methodProtoReference.getReturnType()));
        BuilderMethodProtoReference putIfAbsent = this.internedItems.putIfAbsent(builderMethodProtoReference2, builderMethodProtoReference2);
        return putIfAbsent == null ? builderMethodProtoReference2 : putIfAbsent;
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.getIndex();
    }

    @Override // org.jf.dexlib2.writer.ProtoSection
    @Nullable
    public BuilderTypeList getParameters(@Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.parameterTypes;
    }

    @Override // org.jf.dexlib2.writer.ProtoSection
    @Nonnull
    public BuilderTypeReference getReturnType(@Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.returnType;
    }

    @Override // org.jf.dexlib2.writer.ProtoSection
    @Nonnull
    public BuilderStringReference getShorty(@Nonnull BuilderMethodProtoReference builderMethodProtoReference) {
        return builderMethodProtoReference.shorty;
    }

    @Nonnull
    public BuilderMethodProtoReference internMethodProto(@Nonnull MethodReference methodReference) {
        return internMethodProto(new ImmutableMethodProtoReference(methodReference.getParameterTypes(), methodReference.getReturnType()));
    }
}
