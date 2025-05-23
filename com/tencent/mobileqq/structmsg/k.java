package com.tencent.mobileqq.structmsg;

import android.R;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.StateSet;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k {
    static IPatchRedirector $redirector_;

    public static final byte[] a(byte[] bArr) {
        return b(bArr, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        com.tencent.qphone.base.util.QLog.d("StructMsg", 2, r10.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final byte[] b(byte[] bArr, boolean z16) {
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[0];
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        try {
            try {
                try {
                    if (z16 != 0) {
                        byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 1);
                        try {
                            byteArrayOutputStream.write(1);
                        } catch (Exception e17) {
                            e16 = e17;
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsg", 2, e16.getMessage());
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e18) {
                                    e = e18;
                                }
                            }
                            deflater.end();
                            return bArr;
                        } catch (OutOfMemoryError e19) {
                            e = e19;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsg", 2, e.getMessage());
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (IOException e26) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("StructMsg", 2, e26.getMessage());
                                    }
                                }
                            }
                            bArr = bArr2;
                            deflater.end();
                            return bArr;
                        }
                    } else {
                        byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                    }
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    byte[] bArr3 = new byte[1024];
                    while (!deflater.finished()) {
                        byteArrayOutputStream2.write(bArr3, 0, deflater.deflate(bArr3));
                    }
                    bArr = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e27) {
                        e = e27;
                    }
                } catch (Exception e28) {
                    ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                    e16 = e28;
                    byteArrayOutputStream = byteArrayOutputStream3;
                } catch (OutOfMemoryError e29) {
                    e = e29;
                }
                deflater.end();
                return bArr;
            } catch (Throwable th5) {
                th = th5;
                if (byteArrayOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream2 = z16;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e36) {
                    if (QLog.isColorLevel()) {
                        QLog.d("StructMsg", 2, e36.getMessage());
                    }
                }
            }
            throw th;
        }
    }

    public static StateListDrawable c(Resources resources, int i3, float[] fArr) {
        GradientDrawable[] gradientDrawableArr = new GradientDrawable[2];
        int red = Color.red(i3);
        int green = Color.green(i3);
        int blue = Color.blue(i3);
        for (int i16 = 0; i16 < 2; i16++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawableArr[i16] = gradientDrawable;
            gradientDrawable.setShape(0);
            int i17 = i16 << 5;
            red -= i17;
            if (red < 0) {
                red = 0;
            }
            green -= i17;
            if (green < 0) {
                green = 0;
            }
            blue -= i17;
            if (blue < 0) {
                blue = 0;
            }
            gradientDrawableArr[i16].setColor(Color.rgb(red, green, blue));
            if (fArr != null) {
                gradientDrawableArr[i16].setCornerRadii(fArr);
            } else {
                gradientDrawableArr[i16].setCornerRadius(BaseAIOUtils.f(4.0f, resources));
            }
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, gradientDrawableArr[1]);
        stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawableArr[0]);
        return stateListDrawable;
    }

    public static int d(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static long e(String str) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static int f(int i3) {
        String str = "#000000";
        if (i3 != Color.parseColor("#000000")) {
            str = "#808080";
            if (i3 != Color.parseColor("#808080") && i3 != Color.parseColor("#606060")) {
                str = null;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return g(str);
        }
        return i3;
    }

    public static int g(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("#000000".equals(str)) {
            str2 = "#FFFFFF";
        } else if (!"#808080".equals(str) && !"#606060".equals(str)) {
            str2 = str;
        } else {
            str2 = "#999999";
        }
        try {
            return Color.parseColor(str2);
        } catch (IllegalArgumentException e16) {
            QLog.d("StructMsg", 1, "getNightColor err of " + str + ", " + e16);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        com.tencent.qphone.base.util.QLog.d("StructMsg", 2, r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ac, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] h(byte[] bArr) {
        IOException iOException;
        byte[] bArr2 = bArr;
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr2.length);
        try {
            try {
                byte[] bArr3 = new byte[1024];
                long uptimeMillis = SystemClock.uptimeMillis();
                while (!j(inflater)) {
                    byteArrayOutputStream.write(bArr3, 0, inflater.inflate(bArr3));
                    if (SystemClock.uptimeMillis() - uptimeMillis > 15000) {
                        if (QLog.isColorLevel()) {
                            QLog.w("StructMsg", 2, "decompress struct msg time out");
                        }
                        ReportController.o(null, "dc00898", "", "", "0X8009845", "0X8009845", 0, 1, "", "", "", "");
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("StructMsg", 2, e16.getMessage());
                            }
                        }
                        return bArr2;
                    }
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e17) {
                    iOException = e17;
                }
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d("StructMsg", 2, e18.getMessage());
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e19) {
                    iOException = e19;
                }
            }
            inflater.end();
            return bArr2;
        } finally {
        }
    }

    public static byte[] i(byte[] bArr, int i3) {
        int length = bArr.length;
        if (i3 == -1) {
            int i16 = length - 1;
            byte[] bArr2 = new byte[i16];
            if (bArr[0] == 1) {
                System.arraycopy(bArr, 1, bArr2, 0, i16);
                return h(bArr2);
            }
            System.arraycopy(bArr, 1, bArr2, 0, i16);
            return bArr2;
        }
        byte[] bArr3 = new byte[length];
        if (i3 == 1) {
            System.arraycopy(bArr, 0, bArr3, 0, length);
            return h(bArr3);
        }
        System.arraycopy(bArr, 0, bArr3, 0, length);
        return bArr3;
    }

    private static boolean j(Inflater inflater) {
        if (!inflater.finished() && inflater.getRemaining() > 0) {
            return false;
        }
        return true;
    }
}
