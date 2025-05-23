package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* loaded from: classes29.dex */
public class ProtoIdItem {
    public static final int ITEM_SIZE = 12;
    public static final int PARAMETERS_OFFSET = 8;
    public static final int RETURN_TYPE_OFFSET = 4;
    public static final int SHORTY_OFFSET = 0;

    @Nonnull
    public static String asString(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        int offset = dexBackedDexFile.getProtoSection().getOffset(i3);
        return "(" + TypeListItem.asString(dexBackedDexFile, dexBackedDexFile.getBuffer().readSmallUint(offset + 8)) + ")" + dexBackedDexFile.getTypeSection().get(dexBackedDexFile.getBuffer().readSmallUint(offset + 4));
    }

    public static String[] getProtos(@Nonnull DexBackedDexFile dexBackedDexFile) {
        MapItem mapItemForSection = dexBackedDexFile.getMapItemForSection(3);
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
            return String.format("proto_id_item[%d]: %s", Integer.valueOf(i3), asString(dexBackedDexFile, i3));
        } catch (Exception e16) {
            e16.printStackTrace(System.err);
            return String.format("proto_id_item[%d]", Integer.valueOf(i3));
        }
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.ProtoIdItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                annotatedBytes.annotate(4, "shorty_idx = %s", StringIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "return_type_idx = %s", TypeIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "parameters_off = %s", TypeListItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "proto_id_item";
            }
        };
    }
}
