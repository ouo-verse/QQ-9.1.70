package org.jf.dexlib2.dexbacked.raw;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotationItem {
    public static final int ANNOTATION_OFFSET = 1;
    public static final int VISIBILITY_OFFSET = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAnnotationVisibility(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return "invalid visibility";
                }
                return TVKPlayerMsg.PLAYER_CHOICE_SYSTEM;
            }
            return "runtime";
        }
        return "build";
    }

    public static String getReferenceAnnotation(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        try {
            DexReader<? extends DexBuffer> readerAt = dexBackedDexFile.getDataBuffer().readerAt(i3);
            readerAt.readUbyte();
            return String.format("annotation_item[0x%x]: %s", Integer.valueOf(i3), dexBackedDexFile.getTypeSection().get(readerAt.readSmallUleb128()));
        } catch (Exception e16) {
            e16.printStackTrace(System.err);
            return String.format("annotation_item[0x%x]", Integer.valueOf(i3));
        }
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.AnnotationItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int readUbyte = this.dexFile.getBuffer().readUbyte(annotatedBytes.getCursor());
                annotatedBytes.annotate(1, "visibility = %d: %s", Integer.valueOf(readUbyte), AnnotationItem.getAnnotationVisibility(readUbyte));
                EncodedValue.annotateEncodedAnnotation(this.dexFile, annotatedBytes, this.dexFile.getBuffer().readerAt(annotatedBytes.getCursor()));
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "annotation_item";
            }
        };
    }
}
