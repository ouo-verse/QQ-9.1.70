package org.jf.dexlib2.dexbacked.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethodReference extends BaseMethodReference {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int methodIndex;
    private int protoIdItemOffset;

    public DexBackedMethodReference(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.methodIndex = i3;
    }

    private int getProtoIdItemOffset() {
        if (this.protoIdItemOffset == 0) {
            this.protoIdItemOffset = this.dexFile.getProtoSection().getOffset(this.dexFile.getBuffer().readUshort(this.dexFile.getMethodSection().getOffset(this.methodIndex) + 2));
        }
        return this.protoIdItemOffset;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readUshort(this.dexFile.getMethodSection().getOffset(this.methodIndex) + 0));
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(this.dexFile.getMethodSection().getOffset(this.methodIndex) + 4));
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public List<String> getParameterTypes() {
        int readSmallUint = this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 8);
        if (readSmallUint > 0) {
            final int readSmallUint2 = this.dexFile.getDataBuffer().readSmallUint(readSmallUint + 0);
            final int i3 = readSmallUint + 4;
            return new FixedSizeList<String>() { // from class: org.jf.dexlib2.dexbacked.reference.DexBackedMethodReference.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return readSmallUint2;
                }

                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                @Nonnull
                public String readItem(int i16) {
                    return DexBackedMethodReference.this.dexFile.getTypeSection().get(DexBackedMethodReference.this.dexFile.getDataBuffer().readUshort(i3 + (i16 * 2)));
                }
            };
        }
        return ImmutableList.of();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readSmallUint(getProtoIdItemOffset() + 4));
    }

    public int getSize() {
        return 8;
    }

    @Override // org.jf.dexlib2.base.reference.BaseReference, org.jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i3 = this.methodIndex;
        if (i3 >= 0 && i3 < this.dexFile.getMethodSection().size()) {
            return;
        }
        throw new Reference.InvalidReferenceException("method@" + this.methodIndex);
    }
}
