package org.jf.dexlib2.dexbacked.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.reference.DexBackedMethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethodTypeEncodedValue extends BaseMethodTypeEncodedValue {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int methodProtoIndex;

    public DexBackedMethodTypeEncodedValue(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
        this.dexFile = dexBackedDexFile;
        this.methodProtoIndex = dexReader.readSizedSmallUint(i3 + 1);
    }

    @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue
    @Nonnull
    public MethodProtoReference getValue() {
        return new DexBackedMethodProtoReference(this.dexFile, this.methodProtoIndex);
    }
}
