package ld0;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.shortvideo.util.AudioResample;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f414390a;

        /* renamed from: b, reason: collision with root package name */
        public int f414391b;

        /* renamed from: c, reason: collision with root package name */
        public int f414392c;

        a() {
        }

        public void a(byte[] bArr, int i3, int i16) {
            this.f414390a = bArr;
            this.f414391b = i3;
            this.f414392c = i16;
        }
    }

    public static boolean a(List<SlideItemInfo> list) {
        for (SlideItemInfo slideItemInfo : list) {
            if (slideItemInfo.f94290h == 1 && slideItemInfo.H && !b(slideItemInfo)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean b(SlideItemInfo slideItemInfo) {
        FileOutputStream fileOutputStream;
        long j3 = slideItemInfo.D;
        if (j3 <= 0 && slideItemInfo.E <= 0) {
            return true;
        }
        long j16 = slideItemInfo.E;
        if (j16 < j3) {
            return true;
        }
        long j17 = slideItemInfo.C;
        if (j16 > j17) {
            slideItemInfo.E = j17;
        }
        if (j3 <= 0) {
            slideItemInfo.D = 0L;
        }
        if (slideItemInfo.D == 0 && slideItemInfo.E == j17 && slideItemInfo.I == 44100) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SegmentClipUtils", 2, "clipAudioItem[old]: mSampleRate=" + slideItemInfo.I + " hasAudioTrack: " + slideItemInfo.H);
        }
        if (!slideItemInfo.H) {
            slideItemInfo.I = 44100;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SegmentClipUtils", 2, "clipAudioItem[new]: mSampleRate=" + slideItemInfo.I + " hasAudioTrack: " + slideItemInfo.H);
        }
        float f16 = ((float) slideItemInfo.D) * 1.0f;
        long j18 = slideItemInfo.C;
        float f17 = f16 / ((float) j18);
        float f18 = (((float) slideItemInfo.E) * 1.0f) / ((float) j18);
        String str = slideItemInfo.G + ".clip";
        if (q.p(str)) {
            q.d(str);
        }
        File file = new File(slideItemInfo.G);
        long length = file.length();
        if (length % 2 != 0 && QLog.isColorLevel()) {
            QLog.w("SegmentClipUtils", 2, "clipAudioItem[error]:  audioSize=" + length);
        }
        float f19 = (float) length;
        long j19 = f17 * f19;
        long j26 = f19 * f18;
        if (QLog.isColorLevel()) {
            QLog.i("SegmentClipUtils", 2, "clipAudioItem:  startByte=" + j19 + " endByte:" + j26 + " audioSize:" + length);
        }
        long j27 = 2048;
        long j28 = j19 - (j19 % j27);
        long j29 = j26 + (j27 - (j26 % j27));
        if (QLog.isColorLevel()) {
            QLog.i("SegmentClipUtils", 2, "clipAudioItem[aligned]:  startByte=" + j28 + " endByte:" + j29 + " audioSize:" + length);
        }
        long j36 = 0;
        if (j28 <= 0) {
            j28 = 0;
        }
        if (j29 < length) {
            length = j29;
        }
        long j37 = length - j28;
        byte[] bArr = new byte[2048];
        a aVar = new a();
        a aVar2 = new a();
        int round = Math.round(44100.0f / slideItemInfo.I) * 2048;
        aVar2.f414391b = 0;
        aVar2.f414390a = new byte[round];
        aVar2.f414392c = round;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                if (fileInputStream2.skip(j28) != j28) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return false;
                }
                fileOutputStream = new FileOutputStream(str);
                while (j36 < j37) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            int i3 = (int) (j37 - j36);
                            if (read < i3) {
                                if (slideItemInfo.I != 44100) {
                                    aVar.a(bArr, 0, read);
                                    if (e(slideItemInfo.I, 44100, aVar, aVar2)) {
                                        fileOutputStream.write(aVar2.f414390a, aVar2.f414391b, aVar2.f414392c);
                                    }
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            } else if (slideItemInfo.I != 44100) {
                                aVar.a(bArr, 0, i3);
                                if (e(slideItemInfo.I, 44100, aVar, aVar2)) {
                                    fileOutputStream.write(aVar2.f414390a, aVar2.f414391b, aVar2.f414392c);
                                }
                            } else {
                                fileOutputStream.write(bArr, 0, i3);
                            }
                            j36 += read;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            return false;
                        } catch (Throwable th5) {
                            th = th5;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (fileOutputStream == null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused5) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                    }
                }
                slideItemInfo.G = str;
                try {
                    fileInputStream2.close();
                } catch (IOException unused6) {
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException unused7) {
                    return true;
                }
            } catch (Exception e17) {
                e = e17;
                fileOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileOutputStream = null;
            }
        } catch (Exception e18) {
            e = e18;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public static boolean c(List<SlideItemInfo> list) {
        return true;
    }

    private static boolean d(int i3, int i16, a aVar, a aVar2) {
        if (i3 == 48000 && i16 == 44100) {
            int i17 = aVar.f414392c - aVar.f414391b;
            int i18 = i17 / 2;
            int i19 = (int) ((((i3 - i16) * 1.0f) / i3) * i18);
            int i26 = i18 - i19;
            int i27 = i26 / i19;
            long currentTimeMillis = System.currentTimeMillis();
            int i28 = 0;
            int i29 = 0;
            int i36 = 0;
            for (int i37 = 0; i37 < i18; i37++) {
                if (i29 == i27 && i36 < i19) {
                    i36++;
                    i29 = 0;
                } else {
                    byte[] bArr = aVar2.f414390a;
                    int i38 = i28 * 2;
                    byte[] bArr2 = aVar.f414390a;
                    int i39 = i37 * 2;
                    bArr[i38] = bArr2[i39];
                    bArr[i38 + 1] = bArr2[i39 + 1];
                    i28++;
                    i29++;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            aVar2.f414391b = 0;
            aVar2.f414392c = i28 * 2;
            if (QLog.isColorLevel()) {
                QLog.i("SegmentClipUtils", 2, "convert48KTo441KB:  k=" + i28 + " cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms diff:" + i19 + " remain:" + i26 + " inChunkLength:" + i17);
            }
            return true;
        }
        return false;
    }

    private static boolean e(int i3, int i16, a aVar, a aVar2) {
        if (!f(i3, i16, aVar, aVar2)) {
            return g(i3, i16, aVar, aVar2);
        }
        return true;
    }

    private static boolean f(int i3, int i16, a aVar, a aVar2) {
        if (d(i3, i16, aVar, aVar2)) {
            return true;
        }
        try {
            int i17 = aVar.f414392c - aVar.f414391b;
            int i18 = (int) (((i17 * 1.0f) / i3) * i16);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = aVar.f414390a;
            int i19 = aVar.f414392c;
            byte[] bArr2 = aVar2.f414390a;
            int nativeResample = AudioResample.nativeResample(i3, i16, bArr, i19, bArr2, bArr2.length, -1);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("SegmentClipUtils", 2, "convertAudioDataQuick:  sizeOut=" + nativeResample + " cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms quickChunkSize:" + i18 + " result:" + (nativeResample * 2) + " inChunkLength:" + i17);
            }
            if (nativeResample > 0) {
                aVar2.f414391b = 0;
                aVar2.f414392c = nativeResample * 2;
                return true;
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
        return false;
    }

    private static boolean g(int i3, int i16, a aVar, a aVar2) {
        boolean z16;
        int i17 = aVar.f414392c - aVar.f414391b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aVar.f414390a, aVar.f414391b, aVar.f414392c);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    new md0.b(byteArrayInputStream, byteArrayOutputStream, i3, i16, 2, 2, 1, i17, 0.0d, 0, true);
                    int i18 = (int) (((i17 * 1.0f) / i3) * i16);
                    z16 = false;
                    try {
                        aVar2.f414391b = 0;
                        aVar2.f414390a = byteArrayOutputStream.toByteArray();
                        int size = byteArrayOutputStream.size();
                        aVar2.f414392c = size;
                        if (aVar2.f414390a.length == size) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (QLog.isColorLevel()) {
                                QLog.i("SegmentClipUtils", 2, "convertAudioData:  computeChunkSize=" + i18 + " convertDataSize=" + aVar2.f414392c + " cost: " + (currentTimeMillis2 - currentTimeMillis) + " ms chunkLength: " + i17);
                            }
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException unused) {
                            }
                            try {
                                byteArrayOutputStream.close();
                                return true;
                            } catch (IOException unused2) {
                                return true;
                            }
                        }
                        throw new RuntimeException("convertAudioData  size error...");
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused4) {
                        }
                        return z16;
                    }
                } catch (IOException e17) {
                    e = e17;
                    z16 = false;
                }
            } catch (Throwable th5) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException unused5) {
                }
                try {
                    byteArrayOutputStream.close();
                    throw th5;
                } catch (IOException unused6) {
                    throw th5;
                }
            }
        } catch (IOException e18) {
            e = e18;
            z16 = false;
        }
    }
}
