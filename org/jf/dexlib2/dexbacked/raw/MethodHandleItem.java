package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.MethodHandleType;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MethodHandleItem {
    public static final int ITEM_SIZE = 8;
    public static final int MEMBER_ID_OFFSET = 4;
    public static final int METHOD_HANDLE_TYPE_OFFSET = 0;

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.MethodHandleItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                String referenceAnnotation;
                int readUshort = this.dexFile.getBuffer().readUshort(annotatedBytes.getCursor());
                annotatedBytes.annotate(2, "type = %s", MethodHandleType.toString(readUshort));
                annotatedBytes.annotate(2, "unused", new Object[0]);
                int readUshort2 = this.dexFile.getBuffer().readUshort(annotatedBytes.getCursor());
                switch (readUshort) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        referenceAnnotation = FieldIdItem.getReferenceAnnotation(this.dexFile, readUshort2);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        referenceAnnotation = MethodIdItem.getReferenceAnnotation(this.dexFile, readUshort2);
                        break;
                    default:
                        throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(readUshort));
                }
                annotatedBytes.annotate(2, "field_or_method_id = %s", referenceAnnotation);
                annotatedBytes.annotate(2, "unused", new Object[0]);
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "method_handle_item";
            }
        };
    }
}
