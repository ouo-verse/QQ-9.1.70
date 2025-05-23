package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.dexbacked.value.DexBackedArrayEncodedValue;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CallSiteIdItem {
    public static final int ITEM_SIZE = 4;

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.CallSiteIdItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                DexBackedDexFile dexBackedDexFile = this.dexFile;
                annotatedBytes.annotate(4, "call_site_id_item[0x%x] = %s", Integer.valueOf(readSmallUint), new DexBackedArrayEncodedValue(dexBackedDexFile, dexBackedDexFile.getDataBuffer().readerAt(readSmallUint)));
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "call_site_id_item";
            }
        };
    }
}
