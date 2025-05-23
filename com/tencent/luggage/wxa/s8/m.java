package com.tencent.luggage.wxa.s8;

import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f140193a = new m();

    public final String a(String fileName) {
        RandomAccessFile randomAccessFile;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            randomAccessFile = new RandomAccessFile(fileName, "r");
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
        try {
            String a16 = a(randomAccessFile);
            try {
                randomAccessFile.close();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.p8.f.a("TTFParser", e16, "ttfparse error", new Object[0]);
            }
            return a16;
        } catch (Throwable th6) {
            th = th6;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e17) {
                    com.tencent.luggage.wxa.p8.f.a("TTFParser", e17, "ttfparse error", new Object[0]);
                }
            }
            throw th;
        }
    }

    public final String a(RandomAccessFile randomAccessFile) {
        boolean z16;
        boolean equals;
        short readShort = randomAccessFile.readShort();
        short readShort2 = randomAccessFile.readShort();
        short readShort3 = randomAccessFile.readShort();
        if (readShort == 1 && readShort2 == 0) {
            randomAccessFile.seek(12L);
            byte[] bArr = new byte[4];
            int i3 = 0;
            short s16 = 0;
            while (i3 < readShort3) {
                randomAccessFile.read(bArr);
                String str = new String(bArr, Charsets.UTF_8);
                randomAccessFile.readInt();
                int readInt = randomAccessFile.readInt();
                randomAccessFile.readInt();
                equals = StringsKt__StringsJVMKt.equals("name", str, true);
                if (equals) {
                    z16 = true;
                } else if (str.length() == 0) {
                    z16 = false;
                } else {
                    i3++;
                    s16 = readInt;
                }
                s16 = readInt;
                break;
            }
            z16 = false;
            if (!z16) {
                return null;
            }
            randomAccessFile.seek(s16);
            randomAccessFile.readShort();
            short readShort4 = randomAccessFile.readShort();
            short readShort5 = randomAccessFile.readShort();
            String str2 = null;
            String str3 = null;
            for (int i16 = 0; i16 < readShort4; i16++) {
                randomAccessFile.readShort();
                randomAccessFile.readShort();
                randomAccessFile.readShort();
                short readShort6 = randomAccessFile.readShort();
                int readShort7 = randomAccessFile.readShort();
                short readShort8 = randomAccessFile.readShort();
                long filePointer = randomAccessFile.getFilePointer();
                if (readShort7 <= 0 || readShort7 >= 32767) {
                    return null;
                }
                if (readShort6 == 1 || readShort6 == 6) {
                    randomAccessFile.seek(readShort8 + s16 + readShort5);
                    byte[] bArr2 = new byte[readShort7];
                    randomAccessFile.read(bArr2);
                    randomAccessFile.seek(filePointer);
                    if (readShort6 == 1) {
                        Charset forName = Charset.forName("utf-16");
                        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"utf-16\")");
                        str2 = new String(bArr2, forName);
                    } else if (readShort6 == 6) {
                        Charset forName2 = Charset.forName("utf-16");
                        Intrinsics.checkNotNullExpressionValue(forName2, "forName(\"utf-16\")");
                        str3 = new String(bArr2, forName2);
                    }
                }
            }
            if (str2 != null) {
                return str2;
            }
            if (str3 != null) {
                return str3;
            }
        }
        return null;
    }
}
