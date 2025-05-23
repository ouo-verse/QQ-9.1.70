package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotationSetItem {
    public static final int LIST_OFFSET = 4;
    public static final int SIZE_OFFSET = 0;

    @Nonnull
    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        if (i3 == 0) {
            return "annotation_set_item[NO_OFFSET]";
        }
        return String.format("annotation_set_item[0x%x]", Integer.valueOf(i3));
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.AnnotationSetItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "size = %d", Integer.valueOf(readSmallUint));
                for (int i16 = 0; i16 < readSmallUint; i16++) {
                    annotatedBytes.annotate(4, AnnotationItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())), new Object[0]);
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public int getItemAlignment() {
                return 4;
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "annotation_set_item";
            }
        };
    }
}
