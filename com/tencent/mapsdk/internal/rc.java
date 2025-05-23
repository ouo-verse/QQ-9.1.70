package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rc implements DiskCache.a {

    /* renamed from: a, reason: collision with root package name */
    private final int f150009a = 128;

    /* renamed from: b, reason: collision with root package name */
    private String f150010b;

    public rc(String str) {
        this.f150010b = str;
    }

    private static byte[] a(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((65280 & i3) >> 8), (byte) ((16711680 & i3) >> 16), (byte) ((i3 & (-16777216)) >> 24)};
    }

    private static int b(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT);
    }

    @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.a
    public final File a(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(this.f150010b)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (!TextUtils.isEmpty(substring)) {
                str2 = str2 + File.separator + substring;
            }
            str = str.substring(lastIndexOf + 1);
        }
        int[] a16 = a(str);
        if (a16 == null) {
            return new File(str2, str);
        }
        String str3 = str2 + a(a16[0], a16[1], a16[2]);
        if (!a(str3, a16[0], a16[1], bArr)) {
            return new File(str2, str);
        }
        return new File(str3 + ".dat");
    }

    @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.a
    public final byte[] a(String str, File file) {
        String str2 = this.f150010b;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf >= 0) {
            String substring = str.substring(0, lastIndexOf);
            if (!TextUtils.isEmpty(substring)) {
                str2 = str2 + File.separator + substring;
            }
            str = str.substring(lastIndexOf + 1);
        }
        int[] a16 = a(str);
        if (a16 == null) {
            return null;
        }
        return a(str2 + a(a16[0], a16[1], a16[2]), a16[0], a16[1]);
    }

    @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.a
    public final boolean a(File file) {
        return kt.b(new File(this.f150010b));
    }

    private static int[] a(String str) {
        String[] split = str.split("-");
        if (split.length < 3) {
            return null;
        }
        int[] iArr = new int[3];
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                iArr[i3] = Integer.parseInt(split[i3]);
            } catch (NumberFormatException e16) {
                LogUtil.b(Log.getStackTraceString(e16));
                return null;
            }
        }
        return iArr;
    }

    private static boolean a(String str, int i3, int i16, byte[] bArr) {
        int length;
        RandomAccessFile randomAccessFile;
        long j3;
        long j16;
        if (bArr == null || (length = bArr.length) <= 0) {
            return false;
        }
        String[] strArr = {str + ".idx", str + ".dat"};
        File file = new File(strArr[1]);
        if (!file.exists() && !kt.a(file)) {
            return false;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rws");
        } catch (Exception unused) {
            randomAccessFile = null;
        }
        if (randomAccessFile == null) {
            return false;
        }
        byte[] a16 = a(length);
        a(a16);
        try {
            try {
                j3 = randomAccessFile.length();
                try {
                    randomAccessFile.seek(j3);
                    randomAccessFile.write(a16);
                    randomAccessFile.write(bArr);
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                j3 = 0;
            }
            ku.a(randomAccessFile);
            File file2 = new File(strArr[0]);
            if (!file2.exists() && !kt.a(file2)) {
                return false;
            }
            try {
                randomAccessFile2 = new RandomAccessFile(file2, "rws");
            } catch (Exception unused4) {
            }
            if (randomAccessFile == null) {
                return false;
            }
            try {
                j16 = randomAccessFile.length();
            } catch (Exception unused5) {
                j16 = 0;
            }
            if (j16 == 0) {
                byte[] bArr2 = new byte[65536];
                Arrays.fill(bArr2, (byte) -1);
                try {
                    randomAccessFile.write(bArr2);
                } catch (Exception unused6) {
                }
            }
            long a17 = a(i3, i16);
            if (a17 < 0) {
                return false;
            }
            try {
                randomAccessFile.seek(a17 * 4);
            } catch (Exception unused7) {
            }
            byte[] a18 = a((int) j3);
            a(a18);
            try {
                randomAccessFile.write(a18);
            } catch (Exception unused8) {
            } catch (Throwable th5) {
                throw th5;
            }
            return true;
        } finally {
            ku.a(randomAccessFile);
        }
    }

    private static byte[] a(String str, int i3, int i16) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        String[] strArr = {str + ".idx", str + ".dat"};
        File file = new File(strArr[0]);
        RandomAccessFile randomAccessFile3 = null;
        if (file.exists() && file.length() != 0) {
            long a16 = a(i3, i16);
            if (a16 < 0) {
                return null;
            }
            byte[] bArr = new byte[4];
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (Exception unused) {
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                randomAccessFile.seek(a16 * 4);
                randomAccessFile.read(bArr, 0, 4);
                ku.a(randomAccessFile);
                a(bArr);
                int b16 = b(bArr);
                if (b16 < 0) {
                    return null;
                }
                File file2 = new File(strArr[1]);
                if (!file2.exists()) {
                    return null;
                }
                try {
                    randomAccessFile2 = new RandomAccessFile(file2, "r");
                } catch (Exception unused2) {
                    randomAccessFile2 = null;
                }
                try {
                    randomAccessFile2.seek(b16);
                    randomAccessFile2.read(bArr, 0, 4);
                    a(bArr);
                    int b17 = b(bArr);
                    if (b17 <= 0) {
                        return null;
                    }
                    try {
                        byte[] bArr2 = new byte[b17];
                        randomAccessFile2.read(bArr2, 0, b17);
                        return bArr2;
                    } catch (Throwable th6) {
                        try {
                            LogUtil.c("\u8bfb\u53d6\u74e6\u7247\u7f13\u5b58\u7684\u5927\u5c0f\u5f02\u5e38", th6);
                            return null;
                        } finally {
                            ku.a(randomAccessFile2);
                        }
                    }
                } catch (Exception unused3) {
                    return null;
                }
            } catch (Exception unused4) {
                ku.a(randomAccessFile);
                return null;
            } catch (Throwable th7) {
                th = th7;
                randomAccessFile3 = randomAccessFile;
                ku.a(randomAccessFile3);
                throw th;
            }
        }
        return null;
    }

    private static String a(int i3, int i16, int i17) {
        StringBuilder sb5 = new StringBuilder();
        int i18 = i3 / 128;
        int i19 = i16 / 128;
        sb5.append(File.separatorChar);
        sb5.append("glGrid");
        sb5.append(File.separatorChar);
        sb5.append(i17);
        sb5.append(File.separatorChar);
        sb5.append(i18 / 10);
        sb5.append(File.separatorChar);
        sb5.append(i19 / 10);
        sb5.append(File.separatorChar);
        sb5.append(i17);
        sb5.append("_");
        sb5.append(i18);
        sb5.append("_");
        sb5.append(i19);
        return sb5.toString();
    }

    private static void a(byte[] bArr) {
        if (bArr == null || bArr.length != 4) {
            return;
        }
        byte b16 = bArr[0];
        bArr[0] = bArr[3];
        bArr[3] = b16;
        byte b17 = bArr[1];
        bArr[1] = bArr[2];
        bArr[2] = b17;
    }

    private static long a(int i3, int i16) {
        return ((i3 % 128) * 128) + (i16 % 128);
    }
}
