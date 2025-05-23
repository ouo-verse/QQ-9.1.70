package org.jf.dexlib2.dexbacked.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodProtoReference;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.iface.reference.Reference;

/* loaded from: classes29.dex */
public class DexBackedMethodProtoReference extends BaseMethodProtoReference {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int protoIndex;

    public DexBackedMethodProtoReference(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.protoIndex = i3;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    @Nonnull
    public List<String> getParameterTypes() {
        int readSmallUint = this.dexFile.getBuffer().readSmallUint(this.dexFile.getProtoSection().getOffset(this.protoIndex) + 8);
        if (readSmallUint > 0) {
            final int readSmallUint2 = this.dexFile.getDataBuffer().readSmallUint(readSmallUint + 0);
            final int i3 = readSmallUint + 4;
            return new FixedSizeList<String>() { // from class: org.jf.dexlib2.dexbacked.reference.DexBackedMethodProtoReference.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return readSmallUint2;
                }

                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                @Nonnull
                public String readItem(int i16) {
                    return DexBackedMethodProtoReference.this.dexFile.getTypeSection().get(DexBackedMethodProtoReference.this.dexFile.getDataBuffer().readUshort(i3 + (i16 * 2)));
                }
            };
        }
        return ImmutableList.of();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    @Nonnull
    public String getReturnType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(this.dexFile.getProtoSection().getOffset(this.protoIndex) + 4));
    }

    public int getSize() {
        List<String> parameterTypes = getParameterTypes();
        if (parameterTypes.isEmpty()) {
            return 12;
        }
        return 12 + (parameterTypes.size() * 2) + 4;
    }

    @Override // org.jf.dexlib2.base.reference.BaseReference, org.jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i3 = this.protoIndex;
        if (i3 >= 0 && i3 < this.dexFile.getProtoSection().size()) {
            return;
        }
        throw new Reference.InvalidReferenceException("proto@" + this.protoIndex);
    }
}
