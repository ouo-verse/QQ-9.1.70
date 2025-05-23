package org.jf.dexlib2.dexbacked.raw;

import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AlignmentUtils;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class SectionAnnotator {

    @Nonnull
    public final DexAnnotator annotator;

    @Nonnull
    public final DexBackedDexFile dexFile;
    public final int itemCount;
    protected Map<Integer, String> itemIdentities = Maps.j();
    public final int itemType;
    public final int sectionOffset;

    public SectionAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        this.annotator = dexAnnotator;
        DexBackedDexFile dexBackedDexFile = dexAnnotator.dexFile;
        this.dexFile = dexBackedDexFile;
        this.itemType = mapItem.getType();
        if (mapItem.getType() >= 4096) {
            this.sectionOffset = mapItem.getOffset() + dexBackedDexFile.getBaseDataOffset();
        } else {
            this.sectionOffset = mapItem.getOffset();
        }
        this.itemCount = mapItem.getItemCount();
    }

    @Nullable
    private String getItemIdentity(int i3) {
        return this.itemIdentities.get(Integer.valueOf(i3));
    }

    protected abstract void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str);

    public void annotateSection(@Nonnull AnnotatedBytes annotatedBytes) {
        annotatedBytes.moveTo(this.sectionOffset);
        annotateSectionInner(annotatedBytes, this.itemCount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void annotateSectionInner(@Nonnull AnnotatedBytes annotatedBytes, int i3) {
        String itemName = getItemName();
        if (i3 > 0) {
            annotatedBytes.annotate(0, "", new Object[0]);
            annotatedBytes.annotate(0, "-----------------------------", new Object[0]);
            annotatedBytes.annotate(0, "%s section", itemName);
            annotatedBytes.annotate(0, "-----------------------------", new Object[0]);
            annotatedBytes.annotate(0, "", new Object[0]);
            for (int i16 = 0; i16 < i3; i16++) {
                annotatedBytes.moveTo(getItemOffset(i16, annotatedBytes.getCursor()));
                String itemIdentity = getItemIdentity(annotatedBytes.getCursor());
                if (itemIdentity != null) {
                    annotatedBytes.annotate(0, "[%d] %s: %s", Integer.valueOf(i16), itemName, itemIdentity);
                } else {
                    annotatedBytes.annotate(0, "[%d] %s", Integer.valueOf(i16), itemName);
                }
                annotatedBytes.indent();
                annotateItem(annotatedBytes, i16, itemIdentity);
                annotatedBytes.deindent();
            }
        }
    }

    public int getItemAlignment() {
        return 1;
    }

    @Nonnull
    public abstract String getItemName();

    protected int getItemOffset(int i3, int i16) {
        return AlignmentUtils.alignOffset(i16, getItemAlignment());
    }

    public void setItemIdentity(int i3, String str) {
        this.itemIdentities.put(Integer.valueOf(i3 + this.dexFile.getBaseDataOffset()), str);
    }
}
