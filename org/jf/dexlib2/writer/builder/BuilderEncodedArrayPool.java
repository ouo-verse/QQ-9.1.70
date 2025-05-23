package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.writer.EncodedArraySection;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;

/* loaded from: classes29.dex */
public class BuilderEncodedArrayPool extends BaseBuilderPool implements EncodedArraySection<BuilderEncodedValues.BuilderArrayEncodedValue, BuilderEncodedValues.BuilderEncodedValue> {

    @Nonnull
    private final ConcurrentMap<ArrayEncodedValue, BuilderEncodedValues.BuilderArrayEncodedValue> internedItems;

    public BuilderEncodedArrayPool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderEncodedValues.BuilderArrayEncodedValue, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderEncodedValues.BuilderArrayEncodedValue>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderEncodedArrayPool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
                return builderArrayEncodedValue.offset;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue, int i3) {
                int i16 = builderArrayEncodedValue.offset;
                builderArrayEncodedValue.offset = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderEncodedValues.BuilderArrayEncodedValue internArrayEncodedValue(@Nonnull ArrayEncodedValue arrayEncodedValue) {
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue = this.internedItems.get(arrayEncodedValue);
        if (builderArrayEncodedValue != null) {
            return builderArrayEncodedValue;
        }
        BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue2 = (BuilderEncodedValues.BuilderArrayEncodedValue) this.dexBuilder.internEncodedValue(arrayEncodedValue);
        BuilderEncodedValues.BuilderArrayEncodedValue putIfAbsent = this.internedItems.putIfAbsent(builderArrayEncodedValue2, builderArrayEncodedValue2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderArrayEncodedValue2;
    }

    @Override // org.jf.dexlib2.writer.EncodedArraySection
    public List<? extends BuilderEncodedValues.BuilderEncodedValue> getEncodedValueList(BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
        return builderArrayEncodedValue.elements;
    }

    @Override // org.jf.dexlib2.writer.OffsetSection
    public int getItemOffset(@Nonnull BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
        return builderArrayEncodedValue.offset;
    }
}
