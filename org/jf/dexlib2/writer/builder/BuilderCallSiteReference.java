package org.jf.dexlib2.writer.builder;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseCallSiteReference;
import org.jf.dexlib2.iface.value.StringEncodedValue;
import org.jf.dexlib2.writer.builder.BuilderEncodedValues;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderCallSiteReference extends BaseCallSiteReference implements BuilderReference {

    @Nonnull
    final BuilderEncodedValues.BuilderArrayEncodedValue encodedCallSite;
    int index = -1;

    @Nonnull
    final String name;

    public BuilderCallSiteReference(@Nonnull String str, @Nonnull BuilderEncodedValues.BuilderArrayEncodedValue builderArrayEncodedValue) {
        this.name = str;
        this.encodedCallSite = builderArrayEncodedValue;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public List<? extends BuilderEncodedValues.BuilderEncodedValue> getExtraArguments() {
        if (this.encodedCallSite.elements.size() <= 3) {
            return ImmutableList.of();
        }
        List<? extends BuilderEncodedValues.BuilderEncodedValue> list = this.encodedCallSite.elements;
        return list.subList(3, list.size());
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public int getIndex() {
        return this.index;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public String getMethodName() {
        return ((StringEncodedValue) this.encodedCallSite.elements.get(1)).getValue();
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.writer.builder.BuilderReference
    public void setIndex(int i3) {
        this.index = i3;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public BuilderMethodHandleReference getMethodHandle() {
        return ((BuilderEncodedValues.BuilderMethodHandleEncodedValue) this.encodedCallSite.elements.get(0)).getValue();
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public BuilderMethodProtoReference getMethodProto() {
        return ((BuilderEncodedValues.BuilderMethodTypeEncodedValue) this.encodedCallSite.elements.get(2)).getValue();
    }
}
