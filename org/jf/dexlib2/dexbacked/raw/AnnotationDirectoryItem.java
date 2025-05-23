package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotationDirectoryItem {
    public static final int ANNOTATED_METHOD_SIZE_OFFSET = 8;
    public static final int ANNOTATED_PARAMETERS_SIZE = 12;
    public static final int CLASS_ANNOTATIONS_OFFSET = 0;
    public static final int FIELD_SIZE_OFFSET = 4;

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.AnnotationDirectoryItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                annotatedBytes.annotate(4, "class_annotations_off = %s", AnnotationSetItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                int readSmallUint = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "fields_size = %d", Integer.valueOf(readSmallUint));
                int readSmallUint2 = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "annotated_methods_size = %d", Integer.valueOf(readSmallUint2));
                int readSmallUint3 = this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "annotated_parameters_size = %d", Integer.valueOf(readSmallUint3));
                if (readSmallUint > 0) {
                    annotatedBytes.annotate(0, "field_annotations:", new Object[0]);
                    annotatedBytes.indent();
                    for (int i16 = 0; i16 < readSmallUint; i16++) {
                        annotatedBytes.annotate(0, "field_annotation[%d]", Integer.valueOf(i16));
                        annotatedBytes.indent();
                        annotatedBytes.annotate(4, "%s", FieldIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                        annotatedBytes.annotate(4, "%s", AnnotationSetItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
                if (readSmallUint2 > 0) {
                    annotatedBytes.annotate(0, "method_annotations:", new Object[0]);
                    annotatedBytes.indent();
                    for (int i17 = 0; i17 < readSmallUint2; i17++) {
                        annotatedBytes.annotate(0, "method_annotation[%d]", Integer.valueOf(i17));
                        annotatedBytes.indent();
                        annotatedBytes.annotate(4, "%s", MethodIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                        annotatedBytes.annotate(4, "%s", AnnotationSetItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
                if (readSmallUint3 > 0) {
                    annotatedBytes.annotate(0, "parameter_annotations:", new Object[0]);
                    annotatedBytes.indent();
                    for (int i18 = 0; i18 < readSmallUint3; i18++) {
                        annotatedBytes.annotate(0, "parameter_annotation[%d]", Integer.valueOf(i18));
                        annotatedBytes.indent();
                        annotatedBytes.annotate(4, "%s", MethodIdItem.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                        annotatedBytes.annotate(4, "%s", AnnotationSetRefList.getReferenceAnnotation(this.dexFile, this.dexFile.getBuffer().readSmallUint(annotatedBytes.getCursor())));
                        annotatedBytes.deindent();
                    }
                    annotatedBytes.deindent();
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            public int getItemAlignment() {
                return 4;
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "annotation_directory_item";
            }
        };
    }
}
