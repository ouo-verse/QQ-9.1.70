package com.Vas.ColorFont;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import m.a;
import m.d;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes.dex */
public class FreeTypeLib {

    /* renamed from: a, reason: collision with root package name */
    private int[] f31196a;

    private int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    private int b() {
        String g16 = g();
        if (TextUtils.isEmpty(g16)) {
            return 0;
        }
        String trim = g16.trim();
        if (!Pattern.compile("[0-9]*").matcher(trim).matches()) {
            return 0;
        }
        return Integer.parseInt(trim);
    }

    private int[] c() {
        if (this.f31196a == null) {
            String str = MobileQQ.QQ_PACKAGE_NAME;
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            this.f31196a = new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }
        return this.f31196a;
    }

    private int d() {
        BufferedReader bufferedReader;
        Throwable th5;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        IOException e16;
        FileNotFoundException e17;
        try {
            try {
                fileReader = new FileReader("/proc/meminfo");
            } catch (FileNotFoundException e18) {
                bufferedReader2 = null;
                e17 = e18;
                fileReader = null;
            } catch (IOException e19) {
                bufferedReader2 = null;
                e16 = e19;
                fileReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                fileReader = null;
            }
            try {
                bufferedReader2 = new BufferedReader(fileReader);
            } catch (FileNotFoundException e26) {
                bufferedReader2 = null;
                e17 = e26;
            } catch (IOException e27) {
                bufferedReader2 = null;
                e16 = e27;
            } catch (Throwable th7) {
                bufferedReader = null;
                th5 = th7;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e28) {
                        QLog.e("FreeTypeLib", 1, e28, new Object[0]);
                        throw th5;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th5;
            }
            try {
                String readLine = bufferedReader2.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    d.a("FreeTypeLib", "...fistLine is empty, fistLine:" + readLine);
                    try {
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (IOException e29) {
                        QLog.e("FreeTypeLib", 1, e29, new Object[0]);
                    }
                    return 0;
                }
                String[] split = readLine.split(":");
                if (split.length < 2) {
                    d.a("FreeTypeLib", "...split length<2");
                    try {
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (IOException e36) {
                        QLog.e("FreeTypeLib", 1, e36, new Object[0]);
                    }
                    return 0;
                }
                String trim = split[1].trim();
                if (trim.length() < 2) {
                    d.a("FreeTypeLib", "...after trim length<2 trim:" + trim);
                    try {
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (IOException e37) {
                        QLog.e("FreeTypeLib", 1, e37, new Object[0]);
                    }
                    return 0;
                }
                String trim2 = trim.substring(0, trim.length() - 2).trim();
                if (!Pattern.compile("[0-9]*").matcher(trim2).matches()) {
                    d.a("FreeTypeLib", "...not number  numberStr:" + trim2);
                    try {
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (IOException e38) {
                        QLog.e("FreeTypeLib", 1, e38, new Object[0]);
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(trim2);
                try {
                    bufferedReader2.close();
                    fileReader.close();
                } catch (IOException e39) {
                    QLog.e("FreeTypeLib", 1, e39, new Object[0]);
                }
                return parseInt;
            } catch (FileNotFoundException e46) {
                e17 = e46;
                e17.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e47) {
                        QLog.e("FreeTypeLib", 1, e47, new Object[0]);
                        return 0;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return 0;
            } catch (IOException e48) {
                e16 = e48;
                e16.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e49) {
                        QLog.e("FreeTypeLib", 1, e49, new Object[0]);
                        return 0;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return 0;
            }
        } catch (Throwable th8) {
            th5 = th8;
        }
    }

    private String g() {
        BufferedReader bufferedReader;
        Throwable th5;
        FileReader fileReader;
        String str;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (FileNotFoundException e16) {
                    e = e16;
                    str = null;
                } catch (IOException e17) {
                    e = e17;
                    str = null;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                fileReader = null;
                str = null;
            } catch (IOException e19) {
                e = e19;
                fileReader = null;
                str = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                fileReader = null;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                    } else {
                        String sb6 = sb5.toString();
                        try {
                            bufferedReader.close();
                            fileReader.close();
                            return sb6;
                        } catch (IOException e26) {
                            QLog.e("FreeTypeLib", 1, e26, new Object[0]);
                            return sb6;
                        }
                    }
                }
            } catch (FileNotFoundException e27) {
                e = e27;
                str = null;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e28) {
                        QLog.e("FreeTypeLib", 1, e28, new Object[0]);
                        return str;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return str;
            } catch (IOException e29) {
                e = e29;
                str = null;
                bufferedReader2 = bufferedReader;
                e.printStackTrace();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e36) {
                        QLog.e("FreeTypeLib", 1, e36, new Object[0]);
                        return str;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                return str;
            } catch (Throwable th7) {
                th5 = th7;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e37) {
                        QLog.e("FreeTypeLib", 1, e37, new Object[0]);
                        throw th5;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th5;
            }
        } catch (Throwable th8) {
            bufferedReader = null;
            th5 = th8;
        }
    }

    public native int[] calculateExpressionSize(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7, int[] iArr8, int i16, int i17, int i18, long j3);

    public native int clearCache();

    public native int drawAnimationText(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, Bitmap bitmap, Bitmap bitmap2, int i16, int i17, int i18, int i19, int i26, long j3, int i27, int[] iArr6, int i28);

    public native int drawSpecialEffectsText(int i3, int[] iArr, long j3, int i16, Bitmap bitmap, int[] iArr2);

    public native int drawStrikingText(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, Bitmap bitmap, Bitmap bitmap2, int i16, int i17, int i18, int i19, int i26, long j3, int i27, int[] iArr7, int i28);

    public native int drawText(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, Bitmap bitmap, int i16, int i17, int i18, int i19, int[] iArr6, int i26);

    public void e() {
        int[] c16 = c();
        int d16 = (int) a.d();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int c17 = (int) (m.c() / 1024);
        d.b("FreeTypeLib", "......cpuFrequency:" + d16 + "   maxMemory:" + c17);
        initRender(c16[0], c16[1], 0, Build.VERSION.SDK_INT, Build.VERSION.RELEASE, Build.BRAND, DeviceInfoMonitor.getModel(), availableProcessors, d16, c17);
    }

    public void f() {
        int[] c16 = c();
        int b16 = b();
        initRender(c16[0], c16[1], 0, Build.VERSION.SDK_INT, Build.VERSION.RELEASE, Build.BRAND, DeviceInfoMonitor.getModel(), a(), b16, d());
    }

    public native int[] getBitmapWH(int i3, int[] iArr, int[] iArr2, int[] iArr3, long j3, int[] iArr4);

    public native int getExtraBitmap(int i3, Bitmap bitmap, Bitmap bitmap2, int i16);

    public native int getFontColor(int i3, int i16, int[] iArr);

    public native int getFontVersion(String str);

    public native int getHiBoomViewSize(int i3, int[] iArr, int[] iArr2);

    public native int getTextWidths(int i3, int[] iArr, int i16, int[] iArr2);

    public native int initColorFont(int i3, String str, int[] iArr);

    public native void initRender(int i3, int i16, int i17, int i18, String str, String str2, String str3, int i19, int i26, int i27);

    public native int releaseColorFont(int i3);

    public native int renderExpressionBitmap(int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int i16, int i17, int i18, long j3, int i19, Bitmap bitmap, int[] iArr7, int i26);
}
