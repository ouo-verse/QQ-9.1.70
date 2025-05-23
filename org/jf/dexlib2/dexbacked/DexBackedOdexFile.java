package org.jf.dexlib2.dexbacked;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcodes;
import org.jf.dexlib2.dexbacked.raw.OdexHeaderItem;
import org.jf.dexlib2.dexbacked.util.VariableSizeList;
import org.jf.dexlib2.util.DexUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedOdexFile extends DexBackedDexFile {
    private static final int DEPENDENCY_COUNT_OFFSET = 12;
    private static final int DEPENDENCY_START_OFFSET = 16;
    private final byte[] odexBuf;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class NotAnOdexFile extends RuntimeException {
        public NotAnOdexFile() {
        }

        public NotAnOdexFile(Throwable th5) {
            super(th5);
        }

        public NotAnOdexFile(String str) {
            super(str);
        }

        public NotAnOdexFile(String str, Throwable th5) {
            super(str, th5);
        }
    }

    public DexBackedOdexFile(@Nonnull Opcodes opcodes, @Nonnull byte[] bArr, byte[] bArr2) {
        super(opcodes, bArr2);
        this.odexBuf = bArr;
    }

    @Nonnull
    public static DexBackedOdexFile fromInputStream(@Nonnull Opcodes opcodes, @Nonnull InputStream inputStream) throws IOException {
        DexUtil.verifyOdexHeader(inputStream);
        inputStream.reset();
        byte[] bArr = new byte[40];
        q1.b.e(inputStream, bArr);
        if (OdexHeaderItem.getDexOffset(bArr) > 40) {
            q1.b.g(inputStream, r2 - 40);
        }
        return new DexBackedOdexFile(opcodes, bArr, q1.b.j(inputStream));
    }

    @Nonnull
    public List<String> getDependencies() {
        int dependenciesOffset = OdexHeaderItem.getDependenciesOffset(this.odexBuf) - OdexHeaderItem.getDexOffset(this.odexBuf);
        final DexBuffer dexBuffer = new DexBuffer(getBuffer().buf, 0);
        return new VariableSizeList<String>(getDataBuffer(), dependenciesOffset + 16, dexBuffer.readInt(dependenciesOffset + 12)) { // from class: org.jf.dexlib2.dexbacked.DexBackedOdexFile.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeList
            public String readNextItem(@Nonnull DexReader dexReader, int i3) {
                int readInt = dexReader.readInt();
                int offset = dexReader.getOffset();
                dexReader.moveRelative(readInt + 20);
                try {
                    return new String(dexBuffer.buf, offset, readInt - 1, "US-ASCII");
                } catch (UnsupportedEncodingException e16) {
                    throw new RuntimeException(e16);
                }
            }
        };
    }

    public int getOdexVersion() {
        return OdexHeaderItem.getVersion(this.odexBuf, 0);
    }

    @Override // org.jf.dexlib2.dexbacked.DexBackedDexFile
    public boolean supportsOptimizedOpcodes() {
        return true;
    }
}
