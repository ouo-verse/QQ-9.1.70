package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DebugInfoItem {
    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.DebugInfoItem.1
            /* JADX WARN: Code restructure failed: missing block: B:40:0x0276, code lost:
            
                r10.annotateTo(r11.getOffset(), "DBG_END_SEQUENCE", new java.lang.Object[0]);
                r10.deindent();
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x0285, code lost:
            
                return;
             */
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                DexReader<? extends DexBuffer> readerAt = this.dexFile.getBuffer().readerAt(annotatedBytes.getCursor());
                int readBigUleb128 = readerAt.readBigUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "line_start = %d", Long.valueOf(readBigUleb128 & 4294967295L));
                int readSmallUleb128 = readerAt.readSmallUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "parameters_size = %d", Integer.valueOf(readSmallUleb128));
                if (readSmallUleb128 > 0) {
                    annotatedBytes.annotate(0, "parameters:", new Object[0]);
                    annotatedBytes.indent();
                    for (int i16 = 0; i16 < readSmallUleb128; i16++) {
                        annotatedBytes.annotateTo(readerAt.getOffset(), "%s", StringIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1, true));
                    }
                    annotatedBytes.deindent();
                }
                annotatedBytes.annotate(0, "debug opcodes:", new Object[0]);
                annotatedBytes.indent();
                int i17 = 0;
                while (true) {
                    int readUbyte = readerAt.readUbyte();
                    switch (readUbyte) {
                        case 0:
                            break;
                        case 1:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_ADVANCE_PC", new Object[0]);
                            annotatedBytes.indent();
                            int readSmallUleb1282 = readerAt.readSmallUleb128();
                            i17 += readSmallUleb1282;
                            annotatedBytes.annotateTo(readerAt.getOffset(), "addr_diff = +0x%x: 0x%x", Integer.valueOf(readSmallUleb1282), Integer.valueOf(i17));
                            annotatedBytes.deindent();
                            break;
                        case 2:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_ADVANCE_LINE", new Object[0]);
                            annotatedBytes.indent();
                            int readSleb128 = readerAt.readSleb128();
                            readBigUleb128 += readSleb128;
                            annotatedBytes.annotateTo(readerAt.getOffset(), "line_diff = +%d: %d", Integer.valueOf(Math.abs(readSleb128)), Integer.valueOf(readBigUleb128));
                            annotatedBytes.deindent();
                            break;
                        case 3:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_START_LOCAL", new Object[0]);
                            annotatedBytes.indent();
                            annotatedBytes.annotateTo(readerAt.getOffset(), "register_num = v%d", Integer.valueOf(readerAt.readSmallUleb128()));
                            annotatedBytes.annotateTo(readerAt.getOffset(), "name_idx = %s", StringIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1, true));
                            annotatedBytes.annotateTo(readerAt.getOffset(), "type_idx = %s", TypeIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1));
                            annotatedBytes.deindent();
                            break;
                        case 4:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_START_LOCAL_EXTENDED", new Object[0]);
                            annotatedBytes.indent();
                            annotatedBytes.annotateTo(readerAt.getOffset(), "register_num = v%d", Integer.valueOf(readerAt.readSmallUleb128()));
                            annotatedBytes.annotateTo(readerAt.getOffset(), "name_idx = %s", StringIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1, true));
                            annotatedBytes.annotateTo(readerAt.getOffset(), "type_idx = %s", TypeIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1));
                            annotatedBytes.annotateTo(readerAt.getOffset(), "sig_idx = %s", StringIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1, true));
                            annotatedBytes.deindent();
                            break;
                        case 5:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_END_LOCAL", new Object[0]);
                            annotatedBytes.indent();
                            annotatedBytes.annotateTo(readerAt.getOffset(), "register_num = v%d", Integer.valueOf(readerAt.readSmallUleb128()));
                            annotatedBytes.deindent();
                            break;
                        case 6:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_RESTART_LOCAL", new Object[0]);
                            annotatedBytes.indent();
                            annotatedBytes.annotateTo(readerAt.getOffset(), "register_num = v%d", Integer.valueOf(readerAt.readSmallUleb128()));
                            annotatedBytes.deindent();
                            break;
                        case 7:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_SET_PROLOGUE_END", new Object[0]);
                            break;
                        case 8:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_SET_EPILOGUE_BEGIN", new Object[0]);
                            break;
                        case 9:
                            annotatedBytes.annotateTo(readerAt.getOffset(), "DBG_SET_FILE", new Object[0]);
                            annotatedBytes.indent();
                            annotatedBytes.annotateTo(readerAt.getOffset(), "name_idx = %s", StringIdItem.getOptionalReferenceAnnotation(this.dexFile, readerAt.readSmallUleb128() - 1));
                            annotatedBytes.deindent();
                            break;
                        default:
                            int i18 = readUbyte - 10;
                            int i19 = i18 / 15;
                            int i26 = (i18 % 15) - 4;
                            i17 += i19;
                            readBigUleb128 += i26;
                            annotatedBytes.annotateTo(readerAt.getOffset(), "address_diff = +0x%x:0x%x, line_diff = +%d:%d, ", Integer.valueOf(i19), Integer.valueOf(i17), Integer.valueOf(i26), Integer.valueOf(readBigUleb128));
                            break;
                    }
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "debug_info_item";
            }
        };
    }
}
