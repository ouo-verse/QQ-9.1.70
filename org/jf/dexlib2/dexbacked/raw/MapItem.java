package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MapItem {
    public static final int ITEM_SIZE = 12;
    public static final int OFFSET_OFFSET = 8;
    public static final int SIZE_OFFSET = 4;
    public static final int TYPE_OFFSET = 0;
    private final DexBackedDexFile dexFile;
    private final int offset;

    public MapItem(DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.offset = i3;
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.MapItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readUshort = this.dexFile.getBuffer().readUshort(annotatedBytes.getCursor());
                annotatedBytes.annotate(2, "type = 0x%x: %s", Integer.valueOf(readUshort), ItemType.getItemTypeName(readUshort));
                annotatedBytes.annotate(2, "unused", new Object[0]);
                annotatedBytes.annotate(4, "size = %d", Integer.valueOf(this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "offset = 0x%x", Integer.valueOf(this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public void annotateSection(@Nonnull AnnotatedBytes annotatedBytes) {
                annotatedBytes.moveTo(this.sectionOffset);
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "size = %d", Integer.valueOf(readSmallUint));
                super.annotateSectionInner(annotatedBytes, readSmallUint);
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "map_item";
            }
        };
    }

    public int getItemCount() {
        return this.dexFile.getDataBuffer().readSmallUint(this.offset + 4);
    }

    @Nonnull
    public String getName() {
        return ItemType.getItemTypeName(getType());
    }

    public int getOffset() {
        return this.dexFile.getDataBuffer().readSmallUint(this.offset + 8);
    }

    public int getType() {
        return this.dexFile.getDataBuffer().readUshort(this.offset + 0);
    }
}
