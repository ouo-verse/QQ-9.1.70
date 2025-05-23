package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;
import org.jf.util.StringUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringDataItem {
    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.StringDataItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                DexReader<? extends DexBuffer> readerAt = this.dexFile.getBuffer().readerAt(annotatedBytes.getCursor());
                int readSmallUleb128 = readerAt.readSmallUleb128();
                annotatedBytes.annotateTo(readerAt.getOffset(), "utf16_size = %d", Integer.valueOf(readSmallUleb128));
                annotatedBytes.annotateTo(readerAt.getOffset() + 1, "data = \"%s\"", StringUtils.escapeString(readerAt.readString(readSmallUleb128)));
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "string_data_item";
            }
        };
    }
}
