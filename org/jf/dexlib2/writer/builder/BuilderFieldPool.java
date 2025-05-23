package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.immutable.reference.ImmutableFieldReference;
import org.jf.dexlib2.writer.FieldSection;

/* loaded from: classes29.dex */
public class BuilderFieldPool extends BaseBuilderPool implements FieldSection<BuilderStringReference, BuilderTypeReference, BuilderFieldReference, BuilderField> {

    @Nonnull
    private final ConcurrentMap<FieldReference, BuilderFieldReference> internedItems;

    public BuilderFieldPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderFieldReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderFieldReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderFieldPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderFieldReference builderFieldReference) {
                return builderFieldReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderFieldReference builderFieldReference, int i3) {
                int i16 = builderFieldReference.index;
                builderFieldReference.index = i3;
                return i16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public BuilderFieldReference internField(@Nonnull String str, String str2, String str3) {
        return internField(new ImmutableFieldReference(str, str2, str3));
    }

    @Override // org.jf.dexlib2.writer.FieldSection
    @Nonnull
    public BuilderTypeReference getDefiningClass(@Nonnull BuilderFieldReference builderFieldReference) {
        return builderFieldReference.definingClass;
    }

    @Override // org.jf.dexlib2.writer.FieldSection
    public int getFieldIndex(@Nonnull BuilderField builderField) {
        return builderField.fieldReference.getIndex();
    }

    @Override // org.jf.dexlib2.writer.FieldSection
    @Nonnull
    public BuilderTypeReference getFieldType(@Nonnull BuilderFieldReference builderFieldReference) {
        return builderFieldReference.fieldType;
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull BuilderFieldReference builderFieldReference) {
        return builderFieldReference.index;
    }

    @Override // org.jf.dexlib2.writer.FieldSection
    @Nonnull
    public BuilderStringReference getName(@Nonnull BuilderFieldReference builderFieldReference) {
        return builderFieldReference.name;
    }

    @Nonnull
    public BuilderFieldReference internField(@Nonnull FieldReference fieldReference) {
        BuilderFieldReference builderFieldReference = this.internedItems.get(fieldReference);
        if (builderFieldReference != null) {
            return builderFieldReference;
        }
        BuilderFieldReference builderFieldReference2 = new BuilderFieldReference(((BuilderTypePool) this.dexBuilder.typeSection).internType(fieldReference.getDefiningClass()), ((BuilderStringPool) this.dexBuilder.stringSection).internString(fieldReference.getName()), ((BuilderTypePool) this.dexBuilder.typeSection).internType(fieldReference.getType()));
        BuilderFieldReference putIfAbsent = this.internedItems.putIfAbsent(builderFieldReference2, builderFieldReference2);
        return putIfAbsent == null ? builderFieldReference2 : putIfAbsent;
    }
}
