package org.jf.dexlib2.writer;

import java.io.IOException;
import java.lang.CharSequence;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DebugWriter<StringKey extends CharSequence, TypeKey extends CharSequence> {
    private static final int FIRST_SPECIAL = 10;
    private static final int LINE_BASE = -4;
    private static final int LINE_RANGE = 15;
    private int currentAddress;
    private int currentLine;

    @Nonnull
    private final StringSection<StringKey, ?> stringSection;

    @Nonnull
    private final TypeSection<StringKey, TypeKey, ?> typeSection;

    @Nonnull
    private final DexDataWriter writer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DebugWriter(@Nonnull StringSection<StringKey, ?> stringSection, @Nonnull TypeSection<StringKey, TypeKey, ?> typeSection, @Nonnull DexDataWriter dexDataWriter) {
        this.stringSection = stringSection;
        this.typeSection = typeSection;
        this.writer = dexDataWriter;
    }

    private void writeAdvanceLine(int i3) throws IOException {
        int i16 = i3 - this.currentLine;
        if (i16 != 0) {
            this.writer.write(2);
            this.writer.writeSleb128(i16);
            this.currentLine = i3;
        }
    }

    private void writeAdvancePC(int i3) throws IOException {
        int i16 = i3 - this.currentAddress;
        if (i16 > 0) {
            this.writer.write(1);
            this.writer.writeUleb128(i16);
            this.currentAddress = i3;
        }
    }

    private void writeSpecialOpcode(int i3, int i16) throws IOException {
        this.writer.write((byte) ((i16 * 15) + 10 + i3 + 4));
        this.currentLine += i3;
        this.currentAddress += i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset(int i3) {
        this.currentAddress = 0;
        this.currentLine = i3;
    }

    public void writeEndLocal(int i3, int i16) throws IOException {
        writeAdvancePC(i3);
        this.writer.write(5);
        this.writer.writeUleb128(i16);
    }

    public void writeEpilogueBegin(int i3) throws IOException {
        writeAdvancePC(i3);
        this.writer.write(8);
    }

    public void writeLineNumber(int i3, int i16) throws IOException {
        int i17 = i16 - this.currentLine;
        int i18 = i3 - this.currentAddress;
        if (i18 >= 0) {
            if (i17 < -4 || i17 > 10) {
                writeAdvanceLine(i16);
                i17 = 0;
            }
            if ((i17 < 2 && i18 > 16) || (i17 > 1 && i18 > 15)) {
                writeAdvancePC(i3);
                i18 = 0;
            }
            writeSpecialOpcode(i17, i18);
            return;
        }
        throw new ExceptionWithContext("debug info items must have non-decreasing code addresses", new Object[0]);
    }

    public void writePrologueEnd(int i3) throws IOException {
        writeAdvancePC(i3);
        this.writer.write(7);
    }

    public void writeRestartLocal(int i3, int i16) throws IOException {
        writeAdvancePC(i3);
        this.writer.write(6);
        this.writer.writeUleb128(i16);
    }

    public void writeSetSourceFile(int i3, @Nullable StringKey stringkey) throws IOException {
        writeAdvancePC(i3);
        this.writer.write(9);
        this.writer.writeUleb128(this.stringSection.getNullableItemIndex(stringkey) + 1);
    }

    public void writeStartLocal(int i3, int i16, @Nullable StringKey stringkey, @Nullable TypeKey typekey, @Nullable StringKey stringkey2) throws IOException {
        int nullableItemIndex = this.stringSection.getNullableItemIndex(stringkey);
        int nullableItemIndex2 = this.typeSection.getNullableItemIndex(typekey);
        int nullableItemIndex3 = this.stringSection.getNullableItemIndex(stringkey2);
        writeAdvancePC(i3);
        if (nullableItemIndex3 == -1) {
            this.writer.write(3);
            this.writer.writeUleb128(i16);
            this.writer.writeUleb128(nullableItemIndex + 1);
            this.writer.writeUleb128(nullableItemIndex2 + 1);
            return;
        }
        this.writer.write(4);
        this.writer.writeUleb128(i16);
        this.writer.writeUleb128(nullableItemIndex + 1);
        this.writer.writeUleb128(nullableItemIndex2 + 1);
        this.writer.writeUleb128(nullableItemIndex3 + 1);
    }
}
