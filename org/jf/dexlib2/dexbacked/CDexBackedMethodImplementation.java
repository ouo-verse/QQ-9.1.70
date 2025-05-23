package org.jf.dexlib2.dexbacked;

import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.raw.CodeItem;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CDexBackedMethodImplementation extends DexBackedMethodImplementation {
    public CDexBackedMethodImplementation(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexBackedMethod dexBackedMethod, int i3) {
        super(dexBackedDexFile, dexBackedMethod, i3);
    }

    private int getPreheaderFlags() {
        return this.dexFile.getDataBuffer().readUshort(this.codeOffset + CodeItem.CDEX_INSTRUCTIONS_SIZE_AND_PREHEADER_FLAGS_OFFSET) & CodeItem.CDEX_PREHEADER_FLAGS_MASK;
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedMethodImplementation
    protected int getDebugOffset() {
        CDexBackedDexFile cDexBackedDexFile = (CDexBackedDexFile) this.dexFile;
        int i3 = this.method.methodIndex;
        int i16 = (i3 / 16) * 4;
        int i17 = i3 % 16;
        int debugInfoOffsetsPos = cDexBackedDexFile.getDebugInfoOffsetsPos();
        DexReader<? extends DexBuffer> readerAt = cDexBackedDexFile.getDataBuffer().readerAt(debugInfoOffsetsPos + cDexBackedDexFile.getDataBuffer().readSmallUint(cDexBackedDexFile.getDebugInfoOffsetsTableOffset() + debugInfoOffsetsPos + i16));
        int readUbyte = (readerAt.readUbyte() << 8) + readerAt.readUbyte();
        if (((1 << i17) & readUbyte) == 0) {
            return 0;
        }
        int bitCount = Integer.bitCount((65535 >> (16 - i17)) & readUbyte);
        int debugInfoBase = cDexBackedDexFile.getDebugInfoBase();
        for (int i18 = 0; i18 < bitCount; i18++) {
            debugInfoBase += readerAt.readBigUleb128();
        }
        return debugInfoBase + readerAt.readBigUleb128();
    }

    public int getInsCount() {
        int i3;
        int readUshort = (this.dexFile.getDataBuffer().readUshort(this.codeOffset) >> CodeItem.CDEX_INS_COUNT_SHIFT) & 15;
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INS_COUNT) != 0) {
            if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) != 0) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_REGISTER_COUNT) != 0) {
                i3++;
            }
            return readUshort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - (i3 * 2));
        }
        return readUshort;
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedMethodImplementation
    protected int getInstructionsSize() {
        int readUshort = this.dexFile.getDataBuffer().readUshort(this.codeOffset + CodeItem.CDEX_INSTRUCTIONS_SIZE_AND_PREHEADER_FLAGS_OFFSET) >> CodeItem.CDEX_INSTRUCTIONS_SIZE_SHIFT;
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) != 0) {
            return readUshort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - 2) + (this.dexFile.getDataBuffer().readUshort(this.codeOffset - 4) << 16);
        }
        return readUshort;
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedMethodImplementation
    protected int getInstructionsStartOffset() {
        return this.codeOffset + 4;
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedMethodImplementation, org.jf.dexlib2.iface.MethodImplementation
    public int getRegisterCount() {
        int i3;
        int readUshort = ((this.dexFile.getDataBuffer().readUshort(this.codeOffset) >> CodeItem.CDEX_REGISTER_COUNT_SHIFT) & 15) + getInsCount();
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_REGISTER_COUNT) != 0) {
            if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) > 0) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            return readUshort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - (i3 * 2));
        }
        return readUshort;
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedMethodImplementation
    protected int getTriesSize() {
        int readUshort = (this.dexFile.getDataBuffer().readUshort(this.codeOffset) >> CodeItem.CDEX_TRIES_SIZE_SHIFT) & 15;
        if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_TRIES_COUNT) != 0) {
            int bitCount = Integer.bitCount(getPreheaderFlags());
            if ((getPreheaderFlags() & CodeItem.CDEX_PREHEADER_FLAG_INSTRUCTIONS_SIZE) != 0) {
                bitCount++;
            }
            return readUshort + this.dexFile.getDataBuffer().readUshort(this.codeOffset - (bitCount * 2));
        }
        return readUshort;
    }
}
