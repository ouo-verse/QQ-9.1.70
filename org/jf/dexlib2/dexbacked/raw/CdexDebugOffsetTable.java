package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.CDexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CdexDebugOffsetTable {
    @Nonnull
    public static void annotate(@Nonnull DexAnnotator dexAnnotator, DexBuffer dexBuffer) {
        int i3;
        DexReader<? extends DexBuffer> readerAt = dexBuffer.readerAt(dexAnnotator.getCursor());
        SectionAnnotator annotator = dexAnnotator.getAnnotator(8195);
        int size = dexAnnotator.dexFile.getMethodSection().size();
        int i16 = 0;
        while (i16 < size) {
            int i17 = i16 + 16;
            dexAnnotator.annotate(0, "Offset chuck for methods %d-%d", Integer.valueOf(i16), Integer.valueOf(Math.min(i17, size)));
            dexAnnotator.indent();
            int readUbyte = (readerAt.readUbyte() << 8) | readerAt.readUbyte();
            StringBuilder sb5 = new StringBuilder();
            int i18 = 0;
            while (true) {
                if (i18 >= 16) {
                    break;
                }
                sb5.append((readUbyte >> i18) & 1);
                i18++;
            }
            dexAnnotator.annotate(2, "bitmask: 0b%s", sb5.reverse());
            int debugInfoBase = ((CDexBackedDexFile) dexAnnotator.dexFile).getDebugInfoBase();
            int i19 = 0;
            for (i3 = 16; i19 < i3; i3 = 16) {
                if ((readUbyte & 1) != 0) {
                    int readBigUleb128 = readerAt.readBigUleb128();
                    debugInfoBase += readBigUleb128;
                    int i26 = i16 + i19;
                    dexAnnotator.annotateTo(readerAt.getOffset(), "[method_id: %d]: offset_delta: %d  (offset=0x%x)", Integer.valueOf(i26), Integer.valueOf(readBigUleb128), Integer.valueOf(debugInfoBase));
                    annotator.setItemIdentity(debugInfoBase, dexAnnotator.dexFile.getMethodSection().get(i26).toString());
                }
                readUbyte >>= 1;
                i19++;
            }
            dexAnnotator.deindent();
            i16 = i17;
        }
    }
}
