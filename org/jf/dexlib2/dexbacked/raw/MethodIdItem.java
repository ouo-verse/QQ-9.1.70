package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MethodIdItem {
    public static final int CLASS_OFFSET = 0;
    public static final int ITEM_SIZE = 8;
    public static final int NAME_OFFSET = 4;
    public static final int PROTO_OFFSET = 2;

    @Nonnull
    public static String asString(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        int offset = dexBackedDexFile.getMethodSection().getOffset(i3);
        return String.format("%s->%s%s", dexBackedDexFile.getTypeSection().get(dexBackedDexFile.getBuffer().readUshort(offset + 0)), dexBackedDexFile.getStringSection().get(dexBackedDexFile.getBuffer().readSmallUint(offset + 4)), ProtoIdItem.asString(dexBackedDexFile, dexBackedDexFile.getBuffer().readUshort(offset + 2)));
    }

    public static String[] getMethods(@Nonnull DexBackedDexFile dexBackedDexFile) {
        MapItem mapItemForSection = dexBackedDexFile.getMapItemForSection(5);
        if (mapItemForSection == null) {
            return new String[0];
        }
        int itemCount = mapItemForSection.getItemCount();
        String[] strArr = new String[itemCount];
        for (int i3 = 0; i3 < itemCount; i3++) {
            strArr[i3] = asString(dexBackedDexFile, i3);
        }
        return strArr;
    }

    @Nonnull
    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        try {
            return String.format("method_id_item[%d]: %s", Integer.valueOf(i3), asString(dexBackedDexFile, i3));
        } catch (Exception e16) {
            e16.printStackTrace(System.err);
            return String.format("method_id_item[%d]", Integer.valueOf(i3));
        }
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.MethodIdItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                annotatedBytes.annotate(2, "class_idx = %s", TypeIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readUshort(annotatedBytes.getCursor())));
                annotatedBytes.annotate(2, "proto_idx = %s", ProtoIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readUshort(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "name_idx = %s", StringIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "method_id_item";
            }
        };
    }
}
