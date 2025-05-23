package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TypeListItem {
    public static final int LIST_OFFSET = 4;
    public static final int SIZE_OFFSET = 0;

    @Nonnull
    public static String asString(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        if (i3 == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int readSmallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i3);
        for (int i16 = 0; i16 < readSmallUint; i16++) {
            sb5.append(dexBackedDexFile.getTypeSection().get(dexBackedDexFile.getDataBuffer().readUshort(i3 + 4 + (i16 * 2))));
        }
        return sb5.toString();
    }

    @Nonnull
    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        if (i3 == 0) {
            return "type_list_item[NO_OFFSET]";
        }
        try {
            return String.format("type_list_item[0x%x]: %s", Integer.valueOf(i3), asString(dexBackedDexFile, i3));
        } catch (Exception e16) {
            e16.printStackTrace(System.err);
            return String.format("type_list_item[0x%x]", Integer.valueOf(i3));
        }
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.TypeListItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "size: %d", Integer.valueOf(readSmallUint));
                for (int i16 = 0; i16 < readSmallUint; i16++) {
                    annotatedBytes.annotate(2, TypeIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readUshort(annotatedBytes.getCursor())), new Object[0]);
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public int getItemAlignment() {
                return 4;
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "type_list";
            }
        };
    }
}
