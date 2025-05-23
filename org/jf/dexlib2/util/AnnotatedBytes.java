package org.jf.dexlib2.util;

import com.google.common.base.n;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.util.ExceptionWithContext;
import org.jf.util.Hex;
import org.jf.util.TwoColumnOutput;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AnnotatedBytes {
    private int cursor;
    private int indentLevel;
    private int outputWidth;

    @Nonnull
    private TreeMap<Integer, AnnotationEndpoint> annotatations = Maps.l();
    private int hexCols = 8;
    private int startLimit = -1;
    private int endLimit = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AnnotationEndpoint {

        @Nonnull
        public final List<AnnotationItem> pointAnnotations;

        @Nullable
        public AnnotationItem rangeAnnotation;

        AnnotationEndpoint() {
            this.pointAnnotations = Lists.h();
            this.rangeAnnotation = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AnnotationItem {
        public final String annotation;
        public final int indentLevel;

        public AnnotationItem(int i3, String str) {
            this.indentLevel = i3;
            this.annotation = str;
        }
    }

    public AnnotatedBytes(int i3) {
        this.outputWidth = i3;
    }

    private String formatAnnotation(int i3, String str) {
        return formatAnnotation(i3, this.annotatations.higherKey(Integer.valueOf(i3)), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void annotate(int i3, @Nonnull String str, Object... objArr) {
        AnnotationItem annotationItem;
        AnnotationEndpoint annotationEndpoint;
        Map.Entry<Integer, AnnotationEndpoint> higherEntry;
        AnnotationItem annotationItem2;
        int i16;
        int i17;
        int i18 = this.startLimit;
        if (i18 != -1 && (i16 = this.endLimit) != -1 && ((i17 = this.cursor) < i18 || i17 >= i16)) {
            throw new ExceptionWithContext("Annotating outside the parent bounds", new Object[0]);
        }
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        int i19 = this.cursor;
        int i26 = i19 + i3;
        AnnotationEndpoint annotationEndpoint2 = this.annotatations.get(Integer.valueOf(i19));
        if (annotationEndpoint2 == null) {
            Map.Entry<Integer, AnnotationEndpoint> lowerEntry = this.annotatations.lowerEntry(Integer.valueOf(this.cursor));
            if (lowerEntry != null && (annotationItem2 = lowerEntry.getValue().rangeAnnotation) != null) {
                int i27 = this.cursor;
                throw new ExceptionWithContext("Cannot add annotation %s, due to existing annotation %s", formatAnnotation(i27, Integer.valueOf(i3 + i27), str), formatAnnotation(lowerEntry.getKey().intValue(), annotationItem2.annotation));
            }
        } else if (i3 > 0 && (annotationItem = annotationEndpoint2.rangeAnnotation) != null) {
            int i28 = this.cursor;
            throw new ExceptionWithContext("Cannot add annotation %s, due to existing annotation %s", formatAnnotation(i28, Integer.valueOf(i3 + i28), str), formatAnnotation(this.cursor, annotationItem.annotation));
        }
        if (i3 > 0 && (higherEntry = this.annotatations.higherEntry(Integer.valueOf(this.cursor))) != null) {
            int intValue = higherEntry.getKey().intValue();
            if (intValue < i26) {
                AnnotationEndpoint value = higherEntry.getValue();
                AnnotationItem annotationItem3 = value.rangeAnnotation;
                if (annotationItem3 == null) {
                    if (value.pointAnnotations.size() > 0) {
                        int i29 = this.cursor;
                        throw new ExceptionWithContext("Cannot add annotation %s, due to existing annotation %s", formatAnnotation(i29, Integer.valueOf(i3 + i29), str), formatAnnotation(intValue, Integer.valueOf(intValue), value.pointAnnotations.get(0).annotation));
                    }
                    int i36 = this.cursor;
                    throw new ExceptionWithContext("Cannot add annotation %s, due to existing annotation endpoint at %d", formatAnnotation(i36, Integer.valueOf(i3 + i36), str), Integer.valueOf(intValue));
                }
                int i37 = this.cursor;
                throw new ExceptionWithContext("Cannot add annotation %s, due to existing annotation %s", formatAnnotation(i37, Integer.valueOf(i3 + i37), str), formatAnnotation(intValue, annotationItem3.annotation));
            }
            if (intValue == i26) {
                annotationEndpoint = higherEntry.getValue();
                if (annotationEndpoint2 == null) {
                    annotationEndpoint2 = new AnnotationEndpoint();
                    this.annotatations.put(Integer.valueOf(this.cursor), annotationEndpoint2);
                }
                if (i3 != 0) {
                    annotationEndpoint2.pointAnnotations.add(new AnnotationItem(this.indentLevel, str));
                } else {
                    annotationEndpoint2.rangeAnnotation = new AnnotationItem(this.indentLevel, str);
                    if (annotationEndpoint == null) {
                        this.annotatations.put(Integer.valueOf(i26), new AnnotationEndpoint());
                    }
                }
                this.cursor += i3;
            }
        }
        annotationEndpoint = null;
        if (annotationEndpoint2 == null) {
        }
        if (i3 != 0) {
        }
        this.cursor += i3;
    }

    public void annotateTo(int i3, @Nonnull String str, Object... objArr) {
        annotate(i3 - this.cursor, str, objArr);
    }

    public void clearLimit() {
        this.startLimit = -1;
        this.endLimit = -1;
    }

    public void deindent() {
        int i3 = this.indentLevel - 1;
        this.indentLevel = i3;
        if (i3 < 0) {
            this.indentLevel = 0;
        }
    }

    public int getAnnotationWidth() {
        int i3 = this.hexCols;
        return this.outputWidth - (((i3 * 2) + 8) + (i3 / 2));
    }

    public int getCursor() {
        return this.cursor;
    }

    public void indent() {
        this.indentLevel++;
    }

    public void moveBy(int i3) {
        this.cursor += i3;
    }

    public void moveTo(int i3) {
        this.cursor = i3;
    }

    public void setLimit(int i3, int i16) {
        this.startLimit = i3;
        this.endLimit = i16;
    }

    public void writeAnnotations(Writer writer, byte[] bArr, int i3) throws IOException {
        int annotationWidth = getAnnotationWidth();
        int i16 = (this.outputWidth - annotationWidth) - 1;
        String c16 = n.c(" ", 1000);
        TwoColumnOutput twoColumnOutput = new TwoColumnOutput(writer, i16, annotationWidth, "|");
        Integer[] numArr = (Integer[]) this.annotatations.keySet().toArray(new Integer[this.annotatations.size()]);
        AnnotationEndpoint[] annotationEndpointArr = (AnnotationEndpoint[]) this.annotatations.values().toArray(new AnnotationEndpoint[this.annotatations.size()]);
        int i17 = 0;
        while (true) {
            String str = "";
            if (i17 >= numArr.length - 1) {
                break;
            }
            int intValue = numArr[i17].intValue();
            int i18 = i17 + 1;
            int intValue2 = numArr[i18].intValue();
            AnnotationEndpoint annotationEndpoint = annotationEndpointArr[i17];
            for (AnnotationItem annotationItem : annotationEndpoint.pointAnnotations) {
                twoColumnOutput.write("", c16.substring(0, annotationItem.indentLevel * 2) + annotationItem.annotation);
            }
            AnnotationItem annotationItem2 = annotationEndpoint.rangeAnnotation;
            if (annotationItem2 != null) {
                str = c16.substring(0, annotationItem2.indentLevel * 2) + annotationItem2.annotation;
            }
            int i19 = intValue + i3;
            twoColumnOutput.write(Hex.dump(bArr, i19, intValue2 - intValue, i19, this.hexCols, 6), str);
            i17 = i18;
        }
        int intValue3 = numArr[numArr.length - 1].intValue();
        if (intValue3 < bArr.length) {
            int i26 = intValue3 + i3;
            twoColumnOutput.write(Hex.dump(bArr, i26, (bArr.length - i3) - intValue3, i26, this.hexCols, 6), "");
        }
    }

    private String formatAnnotation(int i3, Integer num, String str) {
        return num != null ? String.format("[0x%x, 0x%x) \"%s\"", Integer.valueOf(i3), num, str) : String.format("[0x%x, ) \"%s\"", Integer.valueOf(i3), str);
    }
}
