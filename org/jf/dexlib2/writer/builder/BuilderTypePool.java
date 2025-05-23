package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.writer.TypeSection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class BuilderTypePool extends BaseBuilderPool implements TypeSection<BuilderStringReference, BuilderTypeReference, BuilderTypeReference> {

    @Nonnull
    private final ConcurrentMap<String, BuilderTypeReference> internedItems;

    public BuilderTypePool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderTypeReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderTypeReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderTypePool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderTypeReference builderTypeReference) {
                return builderTypeReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderTypeReference builderTypeReference, int i3) {
                int i16 = builderTypeReference.index;
                builderTypeReference.index = i3;
                return i16;
            }
        };
    }

    @Nullable
    public BuilderTypeReference internNullableType(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return internType(str);
    }

    @Nonnull
    public BuilderTypeReference internType(@Nonnull String str) {
        BuilderTypeReference builderTypeReference = this.internedItems.get(str);
        if (builderTypeReference != null) {
            return builderTypeReference;
        }
        BuilderTypeReference builderTypeReference2 = new BuilderTypeReference(((BuilderStringPool) this.dexBuilder.stringSection).internString(str));
        BuilderTypeReference putIfAbsent = this.internedItems.putIfAbsent(str, builderTypeReference2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderTypeReference2;
    }

    @Override // org.jf.dexlib2.writer.NullableIndexSection
    public int getNullableItemIndex(@Nullable BuilderTypeReference builderTypeReference) {
        if (builderTypeReference == null) {
            return -1;
        }
        return builderTypeReference.index;
    }

    @Override // org.jf.dexlib2.writer.TypeSection
    @Nonnull
    public BuilderStringReference getString(@Nonnull BuilderTypeReference builderTypeReference) {
        return builderTypeReference.stringReference;
    }

    @Override // org.jf.dexlib2.writer.TypeSection
    public int getItemIndex(@Nonnull BuilderTypeReference builderTypeReference) {
        return builderTypeReference.getIndex();
    }
}
