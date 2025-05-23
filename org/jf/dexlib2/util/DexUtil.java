package org.jf.dexlib2.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBackedOdexFile;
import org.jf.dexlib2.dexbacked.raw.CdexHeaderItem;
import org.jf.dexlib2.dexbacked.raw.HeaderItem;
import org.jf.dexlib2.dexbacked.raw.OdexHeaderItem;
import q1.b;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexUtil {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidFile extends RuntimeException {
        public InvalidFile() {
        }

        public InvalidFile(String str) {
            super(str);
        }

        public InvalidFile(String str, Throwable th5) {
            super(str, th5);
        }

        public InvalidFile(Throwable th5) {
            super(th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class UnsupportedFile extends RuntimeException {
        public UnsupportedFile() {
        }

        public UnsupportedFile(String str) {
            super(str);
        }

        public UnsupportedFile(String str, Throwable th5) {
            super(str, th5);
        }

        public UnsupportedFile(Throwable th5) {
            super(th5);
        }
    }

    public static int verifyCdexHeader(@Nonnull byte[] bArr, int i3) {
        int version = CdexHeaderItem.getVersion(bArr, i3);
        if (version == -1) {
            StringBuilder sb5 = new StringBuilder("Not a valid cdex magic value:");
            for (int i16 = 0; i16 < 8; i16++) {
                sb5.append(String.format(" %02x", Byte.valueOf(bArr[i3 + i16])));
            }
            throw new DexBackedDexFile.NotADexFile(sb5.toString());
        }
        if (CdexHeaderItem.isSupportedCdexVersion(version)) {
            int endian = HeaderItem.getEndian(bArr, i3);
            if (endian != 2018915346) {
                if (endian == 305419896) {
                    return version;
                }
                throw new InvalidFile(String.format("Invalid endian tag: 0x%x", Integer.valueOf(endian)));
            }
            throw new UnsupportedFile("Big endian dex files are not supported");
        }
        throw new UnsupportedFile(String.format("Dex version %03d is not supported", Integer.valueOf(version)));
    }

    public static int verifyDexHeader(@Nonnull InputStream inputStream) throws IOException {
        if (inputStream.markSupported()) {
            inputStream.mark(44);
            byte[] bArr = new byte[44];
            try {
                try {
                    b.e(inputStream, bArr);
                    inputStream.reset();
                    return verifyDexHeader(bArr, 0);
                } catch (EOFException unused) {
                    throw new DexBackedDexFile.NotADexFile("File is too short");
                }
            } catch (Throwable th5) {
                inputStream.reset();
                throw th5;
            }
        }
        throw new IllegalArgumentException("InputStream must support mark");
    }

    public static void verifyOdexHeader(@Nonnull InputStream inputStream) throws IOException {
        if (inputStream.markSupported()) {
            inputStream.mark(8);
            byte[] bArr = new byte[8];
            try {
                try {
                    b.e(inputStream, bArr);
                    inputStream.reset();
                    verifyOdexHeader(bArr, 0);
                    return;
                } catch (EOFException unused) {
                    throw new DexBackedOdexFile.NotAnOdexFile("File is too short");
                }
            } catch (Throwable th5) {
                inputStream.reset();
                throw th5;
            }
        }
        throw new IllegalArgumentException("InputStream must support mark");
    }

    public static int verifyDexHeader(@Nonnull byte[] bArr, int i3) {
        int version = HeaderItem.getVersion(bArr, i3);
        if (version == -1) {
            StringBuilder sb5 = new StringBuilder("Not a valid dex magic value:");
            for (int i16 = 0; i16 < 8; i16++) {
                sb5.append(String.format(" %02x", Byte.valueOf(bArr[i16])));
            }
            throw new DexBackedDexFile.NotADexFile(sb5.toString());
        }
        if (HeaderItem.isSupportedDexVersion(version)) {
            int endian = HeaderItem.getEndian(bArr, i3);
            if (endian == 2018915346) {
                throw new UnsupportedFile("Big endian dex files are not supported");
            }
            if (endian == 305419896) {
                return version;
            }
            throw new InvalidFile(String.format("Invalid endian tag: 0x%x", Integer.valueOf(endian)));
        }
        throw new UnsupportedFile(String.format("Dex version %03d is not supported", Integer.valueOf(version)));
    }

    public static void verifyOdexHeader(@Nonnull byte[] bArr, int i3) {
        int version = OdexHeaderItem.getVersion(bArr, i3);
        if (version == -1) {
            StringBuilder sb5 = new StringBuilder("Not a valid odex magic value:");
            for (int i16 = 0; i16 < 8; i16++) {
                sb5.append(String.format(" %02x", Byte.valueOf(bArr[i16])));
            }
            throw new DexBackedOdexFile.NotAnOdexFile(sb5.toString());
        }
        if (!OdexHeaderItem.isSupportedOdexVersion(version)) {
            throw new UnsupportedFile(String.format("Odex version %03d is not supported", Integer.valueOf(version)));
        }
    }
}
