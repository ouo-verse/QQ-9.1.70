package org.jf.dexlib2.dexbacked.raw;

import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.dexbacked.DexBackedClassDef;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.util.AnnotatedBytes;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HiddenApiClassDataItem {
    public static final int OFFSETS_LIST_OFFSET = 4;
    public static final int OFFSET_ITEM_SIZE = 4;
    public static final int SIZE_OFFSET = 0;

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.HiddenApiClassDataItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int i16;
                int cursor = annotatedBytes.getCursor();
                int i17 = 1;
                int i18 = 4;
                annotatedBytes.annotate(4, "size = 0x%x", Integer.valueOf(this.dexFile.getDataBuffer().readSmallUint(annotatedBytes.getCursor())));
                int i19 = 0;
                for (DexBackedClassDef dexBackedClassDef : this.dexFile.getClasses()) {
                    int i26 = 2;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(i19);
                    objArr[i17] = dexBackedClassDef;
                    annotatedBytes.annotate(0, "[%d] %s", objArr);
                    annotatedBytes.indent();
                    int readSmallUint = this.dexFile.getDataBuffer().readSmallUint(annotatedBytes.getCursor());
                    if (readSmallUint == 0) {
                        Object[] objArr2 = new Object[i17];
                        objArr2[0] = Integer.valueOf(readSmallUint);
                        annotatedBytes.annotate(i18, "offset = 0x%x", objArr2);
                    } else {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(readSmallUint);
                        objArr3[i17] = Integer.valueOf(cursor + readSmallUint);
                        annotatedBytes.annotate(i18, "offset = 0x%x (absolute offset: 0x%x)", objArr3);
                    }
                    int cursor2 = annotatedBytes.getCursor();
                    if (readSmallUint > 0) {
                        annotatedBytes.deindent();
                        annotatedBytes.moveTo(readSmallUint + cursor);
                        DexReader<? extends DexBuffer> readerAt = this.dexFile.getBuffer().readerAt(annotatedBytes.getCursor());
                        Iterator<? extends Field> it = dexBackedClassDef.getStaticFields().iterator();
                        while (it.hasNext()) {
                            Object[] objArr4 = new Object[i17];
                            objArr4[0] = (Field) it.next();
                            annotatedBytes.annotate(0, "%s:", objArr4);
                            annotatedBytes.indent();
                            int readSmallUleb128 = readerAt.readSmallUleb128();
                            int offset = readerAt.getOffset();
                            Object[] objArr5 = new Object[2];
                            objArr5[0] = Integer.valueOf(readSmallUleb128);
                            objArr5[i17] = HiddenApiRestriction.formatHiddenRestrictions(readSmallUleb128);
                            annotatedBytes.annotateTo(offset, "restriction = 0x%x: %s", objArr5);
                            annotatedBytes.deindent();
                        }
                        Iterator<? extends Field> it5 = dexBackedClassDef.getInstanceFields().iterator();
                        while (it5.hasNext()) {
                            Object[] objArr6 = new Object[i17];
                            objArr6[0] = (Field) it5.next();
                            annotatedBytes.annotate(0, "%s:", objArr6);
                            annotatedBytes.indent();
                            int readSmallUleb1282 = readerAt.readSmallUleb128();
                            int offset2 = readerAt.getOffset();
                            Object[] objArr7 = new Object[i26];
                            objArr7[0] = Integer.valueOf(readSmallUleb1282);
                            objArr7[1] = HiddenApiRestriction.formatHiddenRestrictions(readSmallUleb1282);
                            annotatedBytes.annotateTo(offset2, "restriction = 0x%x: %s", objArr7);
                            annotatedBytes.deindent();
                            i17 = 1;
                            i26 = 2;
                        }
                        int i27 = i17;
                        Iterator<? extends Method> it6 = dexBackedClassDef.getDirectMethods().iterator();
                        while (it6.hasNext()) {
                            Object[] objArr8 = new Object[i27];
                            objArr8[0] = (Method) it6.next();
                            annotatedBytes.annotate(0, "%s:", objArr8);
                            annotatedBytes.indent();
                            int readSmallUleb1283 = readerAt.readSmallUleb128();
                            annotatedBytes.annotateTo(readerAt.getOffset(), "restriction = 0x%x: %s", Integer.valueOf(readSmallUleb1283), HiddenApiRestriction.formatHiddenRestrictions(readSmallUleb1283));
                            annotatedBytes.deindent();
                            i27 = 1;
                        }
                        i16 = i27;
                        Iterator<? extends Method> it7 = dexBackedClassDef.getVirtualMethods().iterator();
                        while (it7.hasNext()) {
                            Object[] objArr9 = new Object[i16];
                            objArr9[0] = (Method) it7.next();
                            annotatedBytes.annotate(0, "%s:", objArr9);
                            annotatedBytes.indent();
                            int readSmallUleb1284 = readerAt.readSmallUleb128();
                            int offset3 = readerAt.getOffset();
                            Object[] objArr10 = new Object[2];
                            objArr10[0] = Integer.valueOf(readSmallUleb1284);
                            objArr10[i16] = HiddenApiRestriction.formatHiddenRestrictions(readSmallUleb1284);
                            annotatedBytes.annotateTo(offset3, "restriction = 0x%x: %s", objArr10);
                            annotatedBytes.deindent();
                        }
                        annotatedBytes.indent();
                    } else {
                        i16 = i17;
                    }
                    annotatedBytes.moveTo(cursor2);
                    annotatedBytes.deindent();
                    i19++;
                    i17 = i16;
                    i18 = 4;
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "hiddenapi_class_data_item";
            }
        };
    }
}
