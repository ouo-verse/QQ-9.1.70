package org.jf.dexlib2.dexbacked.raw;

import com.google.common.base.e;
import com.tenpay.proxy.dlg.location.QbAddrData;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClassDataItem {
    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.ClassDataItem.1
            private SectionAnnotator codeItemAnnotator = null;

            private void addCodeItemIdentity(int i3, String str) {
                SectionAnnotator sectionAnnotator = this.codeItemAnnotator;
                if (sectionAnnotator != null) {
                    sectionAnnotator.setItemIdentity(i3, str);
                }
            }

            private int annotateEncodedField(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
                int readLargeUleb128 = dexReader.readLargeUleb128();
                int i16 = i3 + readLargeUleb128;
                annotatedBytes.annotateTo(dexReader.getOffset(), "field_idx_diff = %d: %s", Integer.valueOf(readLargeUleb128), FieldIdItem.getReferenceAnnotation(dexBackedDexFile, i16));
                int readSmallUleb128 = dexReader.readSmallUleb128();
                annotatedBytes.annotateTo(dexReader.getOffset(), "access_flags = 0x%x: %s", Integer.valueOf(readSmallUleb128), e.g(QbAddrData.DATA_SPLITER).f(AccessFlags.getAccessFlagsForField(readSmallUleb128)));
                return i16;
            }

            private int annotateEncodedMethod(@Nonnull AnnotatedBytes annotatedBytes, @Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader, int i3) {
                int readLargeUleb128 = dexReader.readLargeUleb128();
                int i16 = i3 + readLargeUleb128;
                annotatedBytes.annotateTo(dexReader.getOffset(), "method_idx_diff = %d: %s", Integer.valueOf(readLargeUleb128), MethodIdItem.getReferenceAnnotation(dexBackedDexFile, i16));
                int readSmallUleb128 = dexReader.readSmallUleb128();
                annotatedBytes.annotateTo(dexReader.getOffset(), "access_flags = 0x%x: %s", Integer.valueOf(readSmallUleb128), e.g(QbAddrData.DATA_SPLITER).f(AccessFlags.getAccessFlagsForMethod(readSmallUleb128)));
                int readSmallUleb1282 = dexReader.readSmallUleb128();
                if (readSmallUleb1282 == 0) {
                    annotatedBytes.annotateTo(dexReader.getOffset(), "code_off = code_item[NO_OFFSET]", new Object[0]);
                } else {
                    annotatedBytes.annotateTo(dexReader.getOffset(), "code_off = code_item[0x%x]", Integer.valueOf(readSmallUleb1282));
                    addCodeItemIdentity(readSmallUleb1282, MethodIdItem.asString(dexBackedDexFile, i16));
                }
                return i16;
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                DexReader<? extends DexBuffer> readerAt = this.dexFile.getBuffer().readerAt(annotatedBytes.getCursor());
                int readSmallUleb128 = readerAt.readSmallUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "static_fields_size = %d", Integer.valueOf(readSmallUleb128));
                int readSmallUleb1282 = readerAt.readSmallUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "instance_fields_size = %d", Integer.valueOf(readSmallUleb1282));
                int readSmallUleb1283 = readerAt.readSmallUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "direct_methods_size = %d", Integer.valueOf(readSmallUleb1283));
                int readSmallUleb1284 = readerAt.readSmallUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "virtual_methods_size = %d", Integer.valueOf(readSmallUleb1284));
                if (readSmallUleb128 > 0) {
                    annotatedBytes.annotate(0, "static_fields:", new Object[0]);
                    annotatedBytes.indent();
                    int i16 = 0;
                    for (int i17 = 0; i17 < readSmallUleb128; i17++) {
                        annotatedBytes.annotate(0, "static_field[%d]", Integer.valueOf(i17));
                        annotatedBytes.indent();
                        i16 = annotateEncodedField(annotatedBytes, this.dexFile, readerAt, i16);
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
                if (readSmallUleb1282 > 0) {
                    annotatedBytes.annotate(0, "instance_fields:", new Object[0]);
                    annotatedBytes.indent();
                    int i18 = 0;
                    for (int i19 = 0; i19 < readSmallUleb1282; i19++) {
                        annotatedBytes.annotate(0, "instance_field[%d]", Integer.valueOf(i19));
                        annotatedBytes.indent();
                        i18 = annotateEncodedField(annotatedBytes, this.dexFile, readerAt, i18);
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
                if (readSmallUleb1283 > 0) {
                    annotatedBytes.annotate(0, "direct_methods:", new Object[0]);
                    annotatedBytes.indent();
                    int i26 = 0;
                    for (int i27 = 0; i27 < readSmallUleb1283; i27++) {
                        annotatedBytes.annotate(0, "direct_method[%d]", Integer.valueOf(i27));
                        annotatedBytes.indent();
                        i26 = annotateEncodedMethod(annotatedBytes, this.dexFile, readerAt, i26);
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
                if (readSmallUleb1284 > 0) {
                    annotatedBytes.annotate(0, "virtual_methods:", new Object[0]);
                    annotatedBytes.indent();
                    int i28 = 0;
                    for (int i29 = 0; i29 < readSmallUleb1284; i29++) {
                        annotatedBytes.annotate(0, "virtual_method[%d]", Integer.valueOf(i29));
                        annotatedBytes.indent();
                        i28 = annotateEncodedMethod(annotatedBytes, this.dexFile, readerAt, i28);
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateSection(@Nonnull AnnotatedBytes annotatedBytes) {
                this.codeItemAnnotator = this.annotator.getAnnotator(8193);
                super.annotateSection(annotatedBytes);
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "class_data_item";
            }
        };
    }
}
