package org.jf.dexlib2.dexbacked.raw.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.CDexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.raw.AnnotationDirectoryItem;
import org.jf.dexlib2.dexbacked.raw.AnnotationItem;
import org.jf.dexlib2.dexbacked.raw.AnnotationSetItem;
import org.jf.dexlib2.dexbacked.raw.AnnotationSetRefList;
import org.jf.dexlib2.dexbacked.raw.CallSiteIdItem;
import org.jf.dexlib2.dexbacked.raw.CdexDebugOffsetTable;
import org.jf.dexlib2.dexbacked.raw.ClassDataItem;
import org.jf.dexlib2.dexbacked.raw.ClassDefItem;
import org.jf.dexlib2.dexbacked.raw.CodeItem;
import org.jf.dexlib2.dexbacked.raw.DebugInfoItem;
import org.jf.dexlib2.dexbacked.raw.EncodedArrayItem;
import org.jf.dexlib2.dexbacked.raw.FieldIdItem;
import org.jf.dexlib2.dexbacked.raw.HeaderItem;
import org.jf.dexlib2.dexbacked.raw.HiddenApiClassDataItem;
import org.jf.dexlib2.dexbacked.raw.ItemType;
import org.jf.dexlib2.dexbacked.raw.MapItem;
import org.jf.dexlib2.dexbacked.raw.MethodHandleItem;
import org.jf.dexlib2.dexbacked.raw.MethodIdItem;
import org.jf.dexlib2.dexbacked.raw.ProtoIdItem;
import org.jf.dexlib2.dexbacked.raw.SectionAnnotator;
import org.jf.dexlib2.dexbacked.raw.StringDataItem;
import org.jf.dexlib2.dexbacked.raw.StringIdItem;
import org.jf.dexlib2.dexbacked.raw.TypeIdItem;
import org.jf.dexlib2.dexbacked.raw.TypeListItem;
import org.jf.dexlib2.util.AnnotatedBytes;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexAnnotator extends AnnotatedBytes {
    private static final Map<Integer, Integer> sectionAnnotationOrder = Maps.j();
    private final Map<Integer, SectionAnnotator> annotators;

    @Nonnull
    public final DexBackedDexFile dexFile;

    static {
        int[] iArr = {4096, 0, 1, 2, 3, 4, 5, 7, 8, 6, 8192, 8193, 8195, 4097, 4098, 4099, 8194, 8196, 8197, 8198, 61440};
        for (int i3 = 0; i3 < 21; i3++) {
            sectionAnnotationOrder.put(Integer.valueOf(iArr[i3]), Integer.valueOf(i3));
        }
    }

    public DexAnnotator(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        super(i3);
        this.annotators = Maps.j();
        this.dexFile = dexBackedDexFile;
        for (MapItem mapItem : dexBackedDexFile.getMapItems()) {
            int type = mapItem.getType();
            if (type != 61440) {
                switch (type) {
                    case 0:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), HeaderItem.makeAnnotator(this, mapItem));
                        break;
                    case 1:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), StringIdItem.makeAnnotator(this, mapItem));
                        break;
                    case 2:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), TypeIdItem.makeAnnotator(this, mapItem));
                        break;
                    case 3:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), ProtoIdItem.makeAnnotator(this, mapItem));
                        break;
                    case 4:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), FieldIdItem.makeAnnotator(this, mapItem));
                        break;
                    case 5:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), MethodIdItem.makeAnnotator(this, mapItem));
                        break;
                    case 6:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), ClassDefItem.makeAnnotator(this, mapItem));
                        break;
                    case 7:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), CallSiteIdItem.makeAnnotator(this, mapItem));
                        break;
                    case 8:
                        this.annotators.put(Integer.valueOf(mapItem.getType()), MethodHandleItem.makeAnnotator(this, mapItem));
                        break;
                    default:
                        switch (type) {
                            case 4096:
                                this.annotators.put(Integer.valueOf(mapItem.getType()), MapItem.makeAnnotator(this, mapItem));
                                break;
                            case 4097:
                                this.annotators.put(Integer.valueOf(mapItem.getType()), TypeListItem.makeAnnotator(this, mapItem));
                                break;
                            case 4098:
                                this.annotators.put(Integer.valueOf(mapItem.getType()), AnnotationSetRefList.makeAnnotator(this, mapItem));
                                break;
                            case 4099:
                                this.annotators.put(Integer.valueOf(mapItem.getType()), AnnotationSetItem.makeAnnotator(this, mapItem));
                                break;
                            default:
                                switch (type) {
                                    case 8192:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), ClassDataItem.makeAnnotator(this, mapItem));
                                        break;
                                    case 8193:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), CodeItem.makeAnnotator(this, mapItem));
                                        break;
                                    case 8194:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), StringDataItem.makeAnnotator(this, mapItem));
                                        break;
                                    case 8195:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), DebugInfoItem.makeAnnotator(this, mapItem));
                                        break;
                                    case 8196:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), AnnotationItem.makeAnnotator(this, mapItem));
                                        break;
                                    case 8197:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), EncodedArrayItem.makeAnnotator(this, mapItem));
                                        break;
                                    case 8198:
                                        this.annotators.put(Integer.valueOf(mapItem.getType()), AnnotationDirectoryItem.makeAnnotator(this, mapItem));
                                        break;
                                    default:
                                        throw new RuntimeException(String.format("Unrecognized item type: 0x%x", Integer.valueOf(mapItem.getType())));
                                }
                        }
                }
            } else {
                this.annotators.put(Integer.valueOf(mapItem.getType()), HiddenApiClassDataItem.makeAnnotator(this, mapItem));
            }
        }
    }

    @Nullable
    public SectionAnnotator getAnnotator(int i3) {
        return this.annotators.get(Integer.valueOf(i3));
    }

    public void writeAnnotations(Writer writer) throws IOException {
        ImmutableList<MapItem> immutableSortedCopy = Ordering.from(new Comparator<MapItem>() { // from class: org.jf.dexlib2.dexbacked.raw.util.DexAnnotator.1
            @Override // java.util.Comparator
            public int compare(MapItem mapItem, MapItem mapItem2) {
                return c.a(((Integer) DexAnnotator.sectionAnnotationOrder.get(Integer.valueOf(mapItem.getType()))).intValue(), ((Integer) DexAnnotator.sectionAnnotationOrder.get(Integer.valueOf(mapItem2.getType()))).intValue());
            }
        }).immutableSortedCopy(this.dexFile.getMapItems());
        try {
            DexBackedDexFile dexBackedDexFile = this.dexFile;
            if (dexBackedDexFile instanceof CDexBackedDexFile) {
                moveTo(dexBackedDexFile.getBaseDataOffset() + ((CDexBackedDexFile) this.dexFile).getDebugInfoOffsetsPos());
                CdexDebugOffsetTable.annotate(this, this.dexFile.getBuffer());
            }
            for (MapItem mapItem : immutableSortedCopy) {
                try {
                    this.annotators.get(Integer.valueOf(mapItem.getType())).annotateSection(this);
                } catch (Exception e16) {
                    System.err.println(String.format("There was an error while dumping the %s section", ItemType.getItemTypeName(mapItem.getType())));
                    e16.printStackTrace(System.err);
                }
            }
        } finally {
            writeAnnotations(writer, this.dexFile.getBuffer().getBuf(), this.dexFile.getBuffer().getBaseOffset());
        }
    }
}
