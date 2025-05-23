package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;
import org.jf.util.StringUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringIdItem {
    public static final int ITEM_SIZE = 4;

    @Nonnull
    public static String getOptionalReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        return getOptionalReferenceAnnotation(dexBackedDexFile, i3, false);
    }

    @Nonnull
    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        return getReferenceAnnotation(dexBackedDexFile, i3, false);
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.StringIdItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                try {
                    annotatedBytes.annotate(4, "string_data_item[0x%x]: \"%s\"", Integer.valueOf(readSmallUint), StringUtils.escapeString(this.dexFile.getStringSection().get(i3)));
                } catch (Exception e16) {
                    System.err.print("Error while resolving string value at index: ");
                    System.err.print(i3);
                    e16.printStackTrace(System.err);
                    annotatedBytes.annotate(4, "string_id_item[0x%x]", Integer.valueOf(readSmallUint));
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "string_id_item";
            }
        };
    }

    public static String getOptionalReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, boolean z16) {
        return i3 == -1 ? "string_id_item[NO_INDEX]" : getReferenceAnnotation(dexBackedDexFile, i3, z16);
    }

    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, boolean z16) {
        try {
            String str = dexBackedDexFile.getStringSection().get(i3);
            if (z16) {
                str = String.format("\"%s\"", StringUtils.escapeString(str));
            }
            return String.format("string_id_item[%d]: %s", Integer.valueOf(i3), str);
        } catch (Exception e16) {
            e16.printStackTrace(System.err);
            return String.format("string_id_item[%d]", Integer.valueOf(i3));
        }
    }
}
