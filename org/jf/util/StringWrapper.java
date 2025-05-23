package org.jf.util;

import java.io.PrintStream;
import java.text.BreakIterator;
import java.util.Iterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringWrapper {
    private static String[] addString(@Nonnull String[] strArr, String str, int i3) {
        if (i3 >= strArr.length) {
            strArr = enlargeArray(strArr, (int) Math.ceil((strArr.length + 1) * 1.5d));
        }
        strArr[i3] = str;
        return strArr;
    }

    private static String[] enlargeArray(String[] strArr, int i3) {
        String[] strArr2 = new String[i3];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public static void printWrappedString(@Nonnull PrintStream printStream, @Nonnull String str, int i3) {
        Iterator<String> it = wrapStringOnBreaks(str, i3).iterator();
        while (it.hasNext()) {
            printStream.println(it.next());
        }
    }

    public static String[] wrapString(@Nonnull String str, int i3, @Nullable String[] strArr) {
        int i16;
        if (strArr == null) {
            strArr = new String[(int) (((str.length() / i3) * 1.5d) + 1.0d)];
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i17 < str.length()) {
            if (str.charAt(i17) == '\n') {
                i16 = i19 + 1;
                strArr = addString(strArr, str.substring(i18, i17), i19);
                i18 = i17 + 1;
            } else if (i17 - i18 == i3) {
                i16 = i19 + 1;
                strArr = addString(strArr, str.substring(i18, i17), i19);
                i18 = i17;
            } else {
                i17++;
            }
            i19 = i16;
            i17++;
        }
        if (i18 != i17 || i17 == 0) {
            strArr = addString(strArr, str.substring(i18), i19, strArr.length + 1);
            i19++;
        }
        if (i19 < strArr.length) {
            strArr[i19] = null;
        }
        return strArr;
    }

    public static Iterable<String> wrapStringOnBreaks(@Nonnull final String str, final int i3) {
        final BreakIterator lineInstance = BreakIterator.getLineInstance();
        lineInstance.setText(str);
        return new Iterable<String>() { // from class: org.jf.util.StringWrapper.1
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return new Iterator<String>() { // from class: org.jf.util.StringWrapper.1.1
                    private String nextLine;
                    private int currentLineStart = 0;
                    private boolean nextLineSet = false;

                    private void calculateNext() {
                        int last;
                        String str2;
                        int i16;
                        int i17 = this.currentLineStart;
                        do {
                            i17 = lineInstance.following(i17);
                            if (i17 == -1) {
                                last = lineInstance.last();
                                if (last <= this.currentLineStart) {
                                    this.nextLine = null;
                                    this.nextLineSet = true;
                                    return;
                                }
                            } else {
                                int i18 = i17 - this.currentLineStart;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (i18 > i3) {
                                    last = lineInstance.preceding(i17);
                                    int i19 = this.currentLineStart;
                                    if (last <= i19) {
                                        last = i3 + i19;
                                    }
                                } else {
                                    str2 = str;
                                    i16 = i17 - 1;
                                }
                            }
                            this.nextLine = str.substring(this.currentLineStart, last);
                            this.nextLineSet = true;
                            this.currentLineStart = last;
                            return;
                        } while (str2.charAt(i16) != '\n');
                        this.nextLine = str.substring(this.currentLineStart, i16);
                        this.nextLineSet = true;
                        this.currentLineStart = i17;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (!this.nextLineSet) {
                            calculateNext();
                        }
                        if (this.nextLine != null) {
                            return true;
                        }
                        return false;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public String next() {
                        String str2 = this.nextLine;
                        this.nextLine = null;
                        this.nextLineSet = false;
                        return str2;
                    }
                };
            }
        };
    }

    private static String[] addString(@Nonnull String[] strArr, String str, int i3, int i16) {
        if (i3 >= strArr.length) {
            strArr = enlargeArray(strArr, i16);
        }
        strArr[i3] = str;
        return strArr;
    }
}
