package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TypeIdItem {
    public static final int ITEM_SIZE = 4;

    @Nonnull
    public static String getOptionalReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        if (i3 == -1) {
            return "type_id_item[NO_INDEX]";
        }
        return getReferenceAnnotation(dexBackedDexFile, i3);
    }

    @Nonnull
    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        try {
            return String.format("type_id_item[%d]: %s", Integer.valueOf(i3), dexBackedDexFile.getTypeSection().get(i3));
        } catch (Exception e16) {
            e16.printStackTrace(System.err);
            return String.format("type_id_item[%d]", Integer.valueOf(i3));
        }
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.TypeIdItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                annotatedBytes.annotate(4, StringIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())), new Object[0]);
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "type_id_item";
            }
        };
    }
}
