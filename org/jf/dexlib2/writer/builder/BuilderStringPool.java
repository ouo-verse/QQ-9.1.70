package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.writer.StringSection;

/* loaded from: classes29.dex */
class BuilderStringPool implements StringSection<BuilderStringReference, BuilderStringReference> {

    @Nonnull
    private final ConcurrentMap<String, BuilderStringReference> internedItems = Maps.i();

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderStringReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderStringReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderStringPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderStringReference builderStringReference) {
                return builderStringReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderStringReference builderStringReference, int i3) {
                int i16 = builderStringReference.index;
                builderStringReference.index = i3;
                return i16;
            }
        };
    }

    @Override // org.jf.dexlib2.writer.StringSection
    public boolean hasJumboIndexes() {
        if (this.internedItems.size() > 65536) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public BuilderStringReference internNullableString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return internString(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nonnull
    public BuilderStringReference internString(@Nonnull String str) {
        BuilderStringReference builderStringReference = this.internedItems.get(str);
        if (builderStringReference != null) {
            return builderStringReference;
        }
        BuilderStringReference builderStringReference2 = new BuilderStringReference(str);
        BuilderStringReference putIfAbsent = this.internedItems.putIfAbsent(str, builderStringReference2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderStringReference2;
    }

    @Override // org.jf.dexlib2.writer.NullableIndexSection
    public int getNullableItemIndex(@Nullable BuilderStringReference builderStringReference) {
        if (builderStringReference == null) {
            return -1;
        }
        return builderStringReference.index;
    }

    @Override // org.jf.dexlib2.writer.StringSection
    public int getItemIndex(@Nonnull BuilderStringReference builderStringReference) {
        return builderStringReference.index;
    }
}
