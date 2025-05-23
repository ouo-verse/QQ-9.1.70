package com.tencent.mobileqq.editor.composite.step;

import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static int a(int i3, int i16) {
        int i17 = i3 % i16;
        if (i17 != 0) {
            return i3 + (i16 - i17);
        }
        return i3;
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0173: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:125:? (LINE:372), block:B:117:0x0173 */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(String str, String str2, float f16, float f17) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (f16 >= 0.0f) {
            float f18 = 1.0f;
            if (f16 <= 1.0f && f17 >= 0.0f && f17 <= 1.0f && f16 <= f17 && (f16 != f17 || f16 == 0.0f)) {
                File file = new File(str);
                int length = (int) file.length();
                if (file.exists() && length > 0) {
                    FileInputStream fileInputStream2 = null;
                    AudioEncoder.a c16 = AudioEncoder.c(str, null, 0);
                    if (f17 != 0.0f) {
                        f18 = f17;
                    }
                    float f19 = length;
                    int a16 = a((int) (f19 * f16), c16.f288229d);
                    int a17 = a((int) (f19 * f18), c16.f288229d);
                    hd0.c.a("AudioDataUtil", "clipAudioFile begin startPosition=" + a16 + " endPosition=" + a17);
                    int i3 = a17 - a16;
                    byte[] bArr = new byte[20480];
                    try {
                        try {
                            File file2 = new File(str2);
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                            }
                            file2.createNewFile();
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                FileInputStream fileInputStream3 = new FileInputStream(file);
                                if (a16 != 0) {
                                    try {
                                        fileInputStream3.skip(a16);
                                    } catch (IOException e16) {
                                        e = e16;
                                        fileInputStream2 = fileInputStream3;
                                        e.printStackTrace();
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (IOException e17) {
                                                e17.printStackTrace();
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            try {
                                                fileOutputStream.close();
                                                return 960001;
                                            } catch (IOException e18) {
                                                e18.printStackTrace();
                                                return 960001;
                                            }
                                        }
                                        return 960001;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileInputStream2 = fileInputStream3;
                                        hd0.c.g("AudioDataUtil", "AudioTrack Playback Failed");
                                        th.printStackTrace();
                                        if (fileInputStream2 != null) {
                                            try {
                                                fileInputStream2.close();
                                            } catch (IOException e19) {
                                                e19.printStackTrace();
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            try {
                                                fileOutputStream.close();
                                                return 960001;
                                            } catch (IOException e26) {
                                                e26.printStackTrace();
                                                return 960001;
                                            }
                                        }
                                        return 960001;
                                    }
                                }
                                long j3 = 0;
                                while (true) {
                                    try {
                                        int read = fileInputStream3.read(bArr, 0, 20480);
                                        if (read != -1) {
                                            long j16 = read + j3;
                                            fileInputStream = fileInputStream3;
                                            long j17 = i3;
                                            if (j16 > j17) {
                                                fileOutputStream.write(bArr, 0, (int) (j17 - j3));
                                                break;
                                            }
                                            try {
                                                fileOutputStream.write(bArr, 0, read);
                                                fileInputStream3 = fileInputStream;
                                                j3 = j16;
                                            } catch (IOException e27) {
                                                e = e27;
                                                fileInputStream2 = fileInputStream;
                                                e.printStackTrace();
                                                if (fileInputStream2 != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                fileInputStream2 = fileInputStream;
                                                hd0.c.g("AudioDataUtil", "AudioTrack Playback Failed");
                                                th.printStackTrace();
                                                if (fileInputStream2 != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                            }
                                        } else {
                                            fileInputStream = fileInputStream3;
                                            break;
                                        }
                                    } catch (IOException e28) {
                                        e = e28;
                                        fileInputStream = fileInputStream3;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        fileInputStream = fileInputStream3;
                                    }
                                }
                                fileOutputStream.flush();
                                try {
                                    fileInputStream.close();
                                } catch (IOException e29) {
                                    e29.printStackTrace();
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e36) {
                                    e36.printStackTrace();
                                }
                                hd0.c.a("AudioDataUtil", "clipAudioFile time cost=" + (System.currentTimeMillis() - currentTimeMillis));
                                return 0;
                            } catch (IOException e37) {
                                e = e37;
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (IOException e38) {
                            e = e38;
                            fileOutputStream = null;
                        } catch (Throwable th9) {
                            th = th9;
                            fileOutputStream = null;
                        }
                    } finally {
                    }
                } else {
                    hd0.c.i("AudioDataUtil", "clipAudioFile file not exist. startPercent=%s, endPercent=%s, musicFileLength=%s", Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(length));
                    return P2VGlobalConfig.OUTPUT_VIDEO_BIT_RATE;
                }
            }
        }
        hd0.c.i("AudioDataUtil", "param error. startPercent=%s, endPercent=%s", Float.valueOf(f16), Float.valueOf(f17));
        return 960002;
    }

    public static int c(byte[] bArr, int i3, byte[] bArr2, int i16) {
        int min = Math.min(bArr.length - i3, i16 * 2);
        for (int i17 = 0; i17 < min / 2; i17 += 2) {
            int i18 = (i17 * 2) + i3;
            bArr2[i17] = bArr[i18];
            bArr2[i17 + 1] = bArr[i18 + 1];
        }
        return min;
    }

    public static int d(byte[] bArr, int i3, byte[] bArr2, int i16) {
        int i17 = (i16 * 3) / 2;
        if (i17 % 2 == 1) {
            i17--;
        }
        int min = Math.min(bArr.length - i3, i17);
        int i18 = 0;
        while (true) {
            int i19 = (i18 * 3) / 2;
            if (i19 < min) {
                int i26 = (i19 + i3) - ((i18 / 2) % 2);
                bArr2[i18] = bArr[i26];
                bArr2[i18 + 1] = bArr[i26 + 1];
                i18 += 2;
            } else {
                return min;
            }
        }
    }

    public static int e(byte[] bArr, int i3, byte[] bArr2, int i16) {
        int length = (bArr.length - i3) - i16;
        if (length < 0) {
            length = 0;
        }
        int min = Math.min(bArr.length - length, i16);
        for (int i17 = 0; i17 < min - 1; i17 += 2) {
            int i18 = (length + min) - i17;
            bArr2[i17] = bArr[i18 - 2];
            bArr2[i17 + 1] = bArr[i18 - 1];
        }
        return min;
    }

    public static int f(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        int min = Math.min(bArr.length - i3, i16 / i17);
        for (int i18 = 0; i18 < min - 1; i18 += 2) {
            for (int i19 = 0; i19 < i17; i19++) {
                int i26 = (i18 * i17) + (i19 * 2);
                int i27 = i3 + i18;
                bArr2[i26] = bArr[i27];
                bArr2[i26 + 1] = bArr[i27 + 1];
            }
        }
        return min;
    }
}
