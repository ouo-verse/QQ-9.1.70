package org.jf.dexlib2.dexbacked.raw;

import com.google.common.base.e;
import com.tenpay.proxy.dlg.location.QbAddrData;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.AccessFlags;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClassDefItem {
    public static final int ACCESS_FLAGS_OFFSET = 4;
    public static final int ANNOTATIONS_OFFSET = 20;
    public static final int CLASS_DATA_OFFSET = 24;
    public static final int CLASS_OFFSET = 0;
    public static final int INTERFACES_OFFSET = 12;
    public static final int ITEM_SIZE = 32;
    public static final int SOURCE_FILE_OFFSET = 16;
    public static final int STATIC_VALUES_OFFSET = 28;
    public static final int SUPERCLASS_OFFSET = 8;

    @Nonnull
    public static String asString(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        return dexBackedDexFile.getTypeSection().get(dexBackedDexFile.getBuffer().readSmallUint(dexBackedDexFile.getClassSection().getOffset(i3) + 0));
    }

    public static String[] getClasses(@Nonnull DexBackedDexFile dexBackedDexFile) {
        MapItem mapItemForSection = dexBackedDexFile.getMapItemForSection(6);
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
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.ClassDefItem.1
            private SectionAnnotator classDataAnnotator = null;

            private void addClassDataIdentity(int i3, String str) {
                SectionAnnotator sectionAnnotator = this.classDataAnnotator;
                if (sectionAnnotator != null) {
                    sectionAnnotator.setItemIdentity(i3, str);
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "class_idx = %s", TypeIdItem.getReferenceAnnotation(this.dexFile, readSmallUint));
                int readInt = this.dexFile.getBuffer().readInt(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "access_flags = 0x%x: %s", Integer.valueOf(readInt), e.g(QbAddrData.DATA_SPLITER).f(AccessFlags.getAccessFlagsForClass(readInt)));
                annotatedBytes.annotate(4, "superclass_idx = %s", TypeIdItem.getOptionalReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readOptionalUint(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "interfaces_off = %s", TypeListItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "source_file_idx = %s", StringIdItem.getOptionalReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readOptionalUint(annotatedBytes.getCursor())));
                int readSmallUint2 = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                if (readSmallUint2 == 0) {
                    annotatedBytes.annotate(4, "annotations_off = annotations_directory_item[NO_OFFSET]", new Object[0]);
                } else {
                    annotatedBytes.annotate(4, "annotations_off = annotations_directory_item[0x%x]", Integer.valueOf(readSmallUint2));
                }
                int readSmallUint3 = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                if (readSmallUint3 == 0) {
                    annotatedBytes.annotate(4, "class_data_off = class_data_item[NO_OFFSET]", new Object[0]);
                } else {
                    annotatedBytes.annotate(4, "class_data_off = class_data_item[0x%x]", Integer.valueOf(readSmallUint3));
                    addClassDataIdentity(readSmallUint3, this.dexFile.getTypeSection().get(readSmallUint));
                }
                int readSmallUint4 = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                if (readSmallUint4 == 0) {
                    annotatedBytes.annotate(4, "static_values_off = encoded_array_item[NO_OFFSET]", new Object[0]);
                } else {
                    annotatedBytes.annotate(4, "static_values_off = encoded_array_item[0x%x]", Integer.valueOf(readSmallUint4));
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateSection(@Nonnull AnnotatedBytes annotatedBytes) {
                this.classDataAnnotator = this.annotator.getAnnotator(8192);
                super.annotateSection(annotatedBytes);
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "class_def_item";
            }
        };
    }
}
