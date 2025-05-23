package org.jf.dexlib2.dexbacked;

import java.io.UnsupportedEncodingException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.dexbacked.raw.CdexHeaderItem;
import org.jf.dexlib2.util.DexUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CDexBackedDexFile extends DexBackedDexFile {
    public CDexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull byte[] bArr, int i3, boolean z16) {
        super(opcodes, bArr, i3, z16);
    }

    public static boolean isCdex(byte[] bArr, int i3) {
        if (i3 + 4 > bArr.length) {
            return false;
        }
        try {
            byte[] bytes = "cdex".getBytes("US-ASCII");
            if (bArr[i3] != bytes[0] || bArr[i3 + 1] != bytes[1] || bArr[i3 + 2] != bytes[2] || bArr[i3 + 3] != bytes[3]) {
                return false;
            }
            return true;
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
    public DexBackedMethodImplementation createMethodImplementation(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexBackedMethod dexBackedMethod, int i3) {
        return new CDexBackedMethodImplementation(dexBackedDexFile, dexBackedMethod, i3);
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
    public int getBaseDataOffset() {
        return getBuffer().readSmallUint(108);
    }

    public int getDebugInfoBase() {
        return getBuffer().readSmallUint(124);
    }

    public int getDebugInfoOffsetsPos() {
        return getBuffer().readSmallUint(116);
    }

    public int getDebugInfoOffsetsTableOffset() {
        return getBuffer().readSmallUint(120);
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
    protected Opcodes getDefaultOpcodes(int i3) {
        return Opcodes.forApi(28);
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
    protected int getVersion(byte[] bArr, int i3, boolean z16) {
        if (z16) {
            return DexUtil.verifyCdexHeader(bArr, i3);
        }
        return CdexHeaderItem.getVersion(bArr, i3);
    }

    public CDexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull DexBuffer dexBuffer) {
        super(opcodes, dexBuffer);
    }

    public CDexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull byte[] bArr, int i3) {
        super(opcodes, bArr, i3);
    }

    public CDexBackedDexFile(@Nullable Opcodes opcodes, @Nonnull byte[] bArr) {
        super(opcodes, bArr);
    }
}
