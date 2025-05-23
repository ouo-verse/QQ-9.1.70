package org.jf.dexlib2.writer.builder;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.writer.CallSiteSection;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;
import org.jf.dexlib2.writer.util.CallSiteUtil;

/* loaded from: classes29.dex */
public class BuilderCallSitePool extends BaseBuilderPool implements CallSiteSection<BuilderCallSiteReference, BuilderEncodedValues.BuilderArrayEncodedValue> {

    @Nonnull
    private final ConcurrentMap<CallSiteReference, BuilderCallSiteReference> internedItems;

    public BuilderCallSitePool(@Nonnull DexBuilder dexBuilder) {
        super(dexBuilder);
        this.internedItems = Maps.i();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<? extends Map.Entry<? extends BuilderCallSiteReference, Integer>> getItems() {
        return new BuilderMapEntryCollection<BuilderCallSiteReference>(this.internedItems.values()) { // from class: org.jf.dexlib2.writer.builder.BuilderCallSitePool.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int getValue(@Nonnull BuilderCallSiteReference builderCallSiteReference) {
                return builderCallSiteReference.index;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.writer.builder.BuilderMapEntryCollection
            public int setValue(@Nonnull BuilderCallSiteReference builderCallSiteReference, int i3) {
                int i16 = builderCallSiteReference.index;
                builderCallSiteReference.index = i3;
                return i16;
            }
        };
    }

    @Nonnull
    public BuilderCallSiteReference internCallSite(@Nonnull CallSiteReference callSiteReference) {
        BuilderCallSiteReference builderCallSiteReference = this.internedItems.get(callSiteReference);
        if (builderCallSiteReference != null) {
            return builderCallSiteReference;
        }
        BuilderCallSiteReference builderCallSiteReference2 = new BuilderCallSiteReference(callSiteReference.getName(), ((BuilderEncodedArrayPool) this.dexBuilder.encodedArraySection).internArrayEncodedValue(CallSiteUtil.getEncodedCallSite(callSiteReference)));
        BuilderCallSiteReference putIfAbsent = this.internedItems.putIfAbsent(builderCallSiteReference2, builderCallSiteReference2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return builderCallSiteReference2;
    }

    @Override // org.jf.dexlib2.writer.CallSiteSection
    public BuilderEncodedValues.BuilderArrayEncodedValue getEncodedCallSite(BuilderCallSiteReference builderCallSiteReference) {
        return builderCallSiteReference.encodedCallSite;
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull BuilderCallSiteReference builderCallSiteReference) {
        return builderCallSiteReference.index;
    }
}
