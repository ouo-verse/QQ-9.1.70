package org.jf.dexlib2.writer.builder;

import com.google.common.base.d;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.q;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.writer.TypeListSection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes29.dex */
public class BuilderTypeListPool extends BaseBuilderPool implements TypeListSection<BuilderTypeReference, BuilderTypeList> {

    @Nonnull
    private final ConcurrentMap<List<? extends CharSequence>, BuilderTypeList> internedItems;

    public BuilderTypeListPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderTypeList, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderTypeList>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderTypeListPool.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderTypeList builderTypeList) {
                return builderTypeList.offset;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderTypeList builderTypeList, int i3) {
                int i16 = builderTypeList.offset;
                builderTypeList.offset = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderTypeList internTypeList(@Nullable List<? extends CharSequence> list) {
        if (list != null && list.size() != 0) {
            BuilderTypeList builderTypeList = this.internedItems.get(list);
            if (builderTypeList != null) {
                return builderTypeList;
            }
            BuilderTypeList builderTypeList2 = new BuilderTypeList(ImmutableList.copyOf(q.o(list, new d<CharSequence, BuilderTypeReference>() { // from class: org.jf.dexlib2.writer.builder.BuilderTypeListPool.1
                @Override // com.google.common.base.d
                @Nonnull
                public BuilderTypeReference apply(CharSequence charSequence) {
                    return ((BuilderTypePool) BuilderTypeListPool.this.dexBuilder.typeSection).internType(charSequence.toString());
                }
            })));
            BuilderTypeList putIfAbsent = this.internedItems.putIfAbsent(builderTypeList2, builderTypeList2);
            if (putIfAbsent != null) {
                return putIfAbsent;
            }
            return builderTypeList2;
        }
        return BuilderTypeList.EMPTY;
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    public int getItemOffset(@Nonnull BuilderTypeList builderTypeList) {
        return builderTypeList.offset;
    }

    @Override // org.jf.dexlib2.writer.TypeListSection, org.jf.dexlib2.writer.NullableOffsetSection
    public int getNullableItemOffset(@Nullable BuilderTypeList builderTypeList) {
        if (builderTypeList == null || builderTypeList.size() == 0) {
            return 0;
        }
        return builderTypeList.offset;
    }

    @Override // org.jf.dexlib2.writer.TypeListSection
    @Nonnull
    public Collection<? extends BuilderTypeReference> getTypes(@Nullable BuilderTypeList builderTypeList) {
        return builderTypeList == null ? BuilderTypeList.EMPTY : builderTypeList.types;
    }
}
