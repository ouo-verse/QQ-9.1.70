package org.jf.dexlib2.dexbacked.raw;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.VersionMap;
import org.jf.dexlib2.dexbacked.CDexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.raw.util.DexAnnotator;
import org.jf.dexlib2.util.AnnotatedBytes;
import org.jf.util.StringUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HeaderItem {
    public static final int BIG_ENDIAN_TAG = 2018915346;
    public static final int CHECKSUM_DATA_START_OFFSET = 12;
    public static final int CHECKSUM_OFFSET = 8;
    public static final int CLASS_COUNT_OFFSET = 96;
    public static final int CLASS_START_OFFSET = 100;
    public static final int DATA_SIZE_OFFSET = 104;
    public static final int DATA_START_OFFSET = 108;
    public static final int ENDIAN_TAG_OFFSET = 40;
    public static final int FIELD_COUNT_OFFSET = 80;
    public static final int FIELD_START_OFFSET = 84;
    public static final int FILE_SIZE_OFFSET = 32;
    public static final int HEADER_SIZE_OFFSET = 36;
    public static final int ITEM_SIZE = 112;
    public static final int LITTLE_ENDIAN_TAG = 305419896;
    private static final byte[] MAGIC_VALUE = {100, 101, 120, 10, 0, 0, 0, 0};
    public static final int MAP_OFFSET = 52;
    public static final int METHOD_COUNT_OFFSET = 88;
    public static final int METHOD_START_OFFSET = 92;
    public static final int PROTO_COUNT_OFFSET = 72;
    public static final int PROTO_START_OFFSET = 76;
    public static final int SIGNATURE_DATA_START_OFFSET = 32;
    public static final int SIGNATURE_OFFSET = 12;
    public static final int SIGNATURE_SIZE = 20;
    public static final int STRING_COUNT_OFFSET = 56;
    public static final int STRING_START_OFFSET = 60;
    public static final int TYPE_COUNT_OFFSET = 64;
    public static final int TYPE_START_OFFSET = 68;

    @Nonnull
    private DexBackedDexFile dexFile;

    public HeaderItem(@Nonnull DexBackedDexFile dexBackedDexFile) {
        this.dexFile = dexBackedDexFile;
    }

    public static int getEndian(byte[] bArr, int i3) {
        return new DexBuffer(bArr).readInt(i3 + 40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getEndianText(int i3) {
        if (i3 == 305419896) {
            return "Little Endian";
        }
        if (i3 == 2018915346) {
            return "Big Endian";
        }
        return "Invalid";
    }

    public static byte[] getMagicForApi(int i3) {
        return getMagicForDexVersion(VersionMap.mapApiToDexVersion(i3));
    }

    public static byte[] getMagicForDexVersion(int i3) {
        byte[] bArr = (byte[]) MAGIC_VALUE.clone();
        if (i3 >= 0 && i3 <= 999) {
            for (int i16 = 6; i16 >= 4; i16--) {
                bArr[i16] = (byte) ((i3 % 10) + 48);
                i3 /= 10;
            }
            return bArr;
        }
        throw new IllegalArgumentException("dexVersion must be within [0, 999]");
    }

    public static int getVersion(byte[] bArr, int i3) {
        if (!verifyMagic(bArr, i3)) {
            return -1;
        }
        return getVersionUnchecked(bArr, i3);
    }

    private static int getVersionUnchecked(byte[] bArr, int i3) {
        return ((bArr[i3 + 4] - 48) * 100) + ((bArr[i3 + 5] - 48) * 10) + (bArr[i3 + 6] - 48);
    }

    public static boolean isSupportedDexVersion(int i3) {
        if (VersionMap.mapDexVersionToApi(i3) != -1) {
            return true;
        }
        return false;
    }

    @Nonnull
    public static SectionAnnotator makeAnnotator(@Nonnull DexAnnotator dexAnnotator, @Nonnull MapItem mapItem) {
        return new SectionAnnotator(dexAnnotator, mapItem) { // from class: org.jf.dexlib2.dexbacked.raw.HeaderItem.1
            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            protected void annotateItem(@Nonnull AnnotatedBytes annotatedBytes, int i3, @Nullable String str) {
                int cursor = annotatedBytes.getCursor();
                StringBuilder sb5 = new StringBuilder();
                for (int i16 = 0; i16 < 8; i16++) {
                    sb5.append((char) this.dexFile.getBuffer().readUbyte(cursor + i16));
                }
                annotatedBytes.annotate(8, "magic: %s", StringUtils.escapeString(sb5.toString()));
                annotatedBytes.annotate(4, "checksum", new Object[0]);
                annotatedBytes.annotate(20, "signature", new Object[0]);
                annotatedBytes.annotate(4, "file_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                int readInt = this.dexFile.getBuffer().readInt(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "header_size: %d", Integer.valueOf(readInt));
                int readInt2 = this.dexFile.getBuffer().readInt(annotatedBytes.getCursor());
                annotatedBytes.annotate(4, "endian_tag: 0x%x (%s)", Integer.valueOf(readInt2), HeaderItem.getEndianText(readInt2));
                annotatedBytes.annotate(4, "link_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "link_offset: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "map_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "string_ids_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "string_ids_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "type_ids_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "type_ids_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "proto_ids_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "proto_ids_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "field_ids_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "field_ids_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "method_ids_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "method_ids_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "class_defs_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "class_defs_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "data_size: %d", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                annotatedBytes.annotate(4, "data_off: 0x%x", Integer.valueOf(this.dexFile.getBuffer().readInt(annotatedBytes.getCursor())));
                if (this.annotator.dexFile instanceof CDexBackedDexFile) {
                    CdexHeaderItem.annotateCdexHeaderFields(annotatedBytes, this.dexFile.getBuffer());
                }
                if (readInt > 112) {
                    annotatedBytes.annotateTo(readInt, "header padding", new Object[0]);
                }
            }

            @Override // org.jf.dexlib2.dexbacked.raw.SectionAnnotator
            @Nonnull
            public String getItemName() {
                return "header_item";
            }
        };
    }

    public static boolean verifyMagic(byte[] bArr, int i3) {
        if (bArr.length - i3 < 8) {
            return false;
        }
        int i16 = 0;
        while (true) {
            if (i16 < 4) {
                if (bArr[i3 + i16] != MAGIC_VALUE[i16]) {
                    return false;
                }
                i16++;
            } else {
                for (int i17 = 4; i17 < 7; i17++) {
                    byte b16 = bArr[i3 + i17];
                    if (b16 < 48 || b16 > 57) {
                        return false;
                    }
                }
                if (bArr[i3 + 7] != MAGIC_VALUE[7]) {
                    return false;
                }
                return true;
            }
        }
    }

    public int getChecksum() {
        return this.dexFile.getBuffer().readSmallUint(8);
    }

    public int getClassCount() {
        return this.dexFile.getBuffer().readSmallUint(96);
    }

    public int getClassOffset() {
        return this.dexFile.getBuffer().readSmallUint(100);
    }

    public int getFieldCount() {
        return this.dexFile.getBuffer().readSmallUint(80);
    }

    public int getFieldOffset() {
        return this.dexFile.getBuffer().readSmallUint(84);
    }

    public int getHeaderSize() {
        return this.dexFile.getBuffer().readSmallUint(36);
    }

    public int getMapOffset() {
        return this.dexFile.getBuffer().readSmallUint(52);
    }

    public int getMethodCount() {
        return this.dexFile.getBuffer().readSmallUint(88);
    }

    public int getMethodOffset() {
        return this.dexFile.getBuffer().readSmallUint(92);
    }

    public int getProtoCount() {
        return this.dexFile.getBuffer().readSmallUint(72);
    }

    public int getProtoOffset() {
        return this.dexFile.getBuffer().readSmallUint(76);
    }

    @Nonnull
    public byte[] getSignature() {
        return this.dexFile.getBuffer().readByteRange(12, 20);
    }

    public int getStringCount() {
        return this.dexFile.getBuffer().readSmallUint(56);
    }

    public int getStringOffset() {
        return this.dexFile.getBuffer().readSmallUint(60);
    }

    public int getTypeCount() {
        return this.dexFile.getBuffer().readSmallUint(64);
    }

    public int getTypeOffset() {
        return this.dexFile.getBuffer().readSmallUint(68);
    }
}
