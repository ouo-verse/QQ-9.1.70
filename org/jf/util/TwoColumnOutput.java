package org.jf.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TwoColumnOutput {
    private String[] leftLines;
    private final int leftWidth;
    private final Writer out;
    private String[] rightLines;
    private final int rightWidth;
    private final String spacer;

    public TwoColumnOutput(@Nonnull Writer writer, int i3, int i16, @Nonnull String str) {
        this.leftLines = null;
        this.rightLines = null;
        if (i3 < 1) {
            throw new IllegalArgumentException("leftWidth < 1");
        }
        if (i16 >= 1) {
            this.out = writer;
            this.leftWidth = i3;
            this.rightWidth = i16;
            this.spacer = str;
            return;
        }
        throw new IllegalArgumentException("rightWidth < 1");
    }

    private static void writeSpaces(Writer writer, int i3) throws IOException {
        while (i3 > 0) {
            writer.write(32);
            i3--;
        }
    }

    public void write(String str, String str2) throws IOException {
        String str3;
        int i3;
        this.leftLines = StringWrapper.wrapString(str, this.leftWidth, this.leftLines);
        String[] wrapString = StringWrapper.wrapString(str2, this.rightWidth, this.rightLines);
        this.rightLines = wrapString;
        int length = this.leftLines.length;
        int length2 = wrapString.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length && i16 >= length2) {
                return;
            }
            String str4 = null;
            if (i16 < length) {
                str3 = this.leftLines[i16];
                if (str3 == null) {
                    length = i16;
                }
            } else {
                str3 = null;
            }
            if (i16 < length2 && (str4 = this.rightLines[i16]) == null) {
                length2 = i16;
            }
            if (str3 != null || str4 != null) {
                if (str3 != null) {
                    this.out.write(str3);
                    i3 = str3.length();
                } else {
                    i3 = 0;
                }
                int i17 = this.leftWidth - i3;
                if (i17 > 0) {
                    writeSpaces(this.out, i17);
                }
                this.out.write(this.spacer);
                if (str4 != null) {
                    this.out.write(str4);
                }
                this.out.write(10);
            }
            i16++;
        }
    }

    public TwoColumnOutput(OutputStream outputStream, int i3, int i16, String str) {
        this(new OutputStreamWriter(outputStream), i3, i16, str);
    }
}
