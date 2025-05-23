package com.tencent.aelight.camera.aebase;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {
    public static void a(String str, int i3, int i16, String str2) {
        try {
            BitmapUtils.saveBitmap2PNG(e(str, i3, i16, false), str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("Util", 4, "saveBitmapRawBytesToFile exception, msg = " + e16.getMessage());
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            QLog.d("Util", 4, "saveBitmapRawBytesToFile error, msg = " + e17.getMessage());
        }
    }

    private static PointF c(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF.x;
        float f17 = pointF3.x;
        float f18 = pointF.y;
        float f19 = pointF3.y;
        float f26 = (f16 * f17) + (f18 * f19);
        float f27 = pointF2.x;
        float f28 = pointF2.y;
        return new PointF(((f26 - (f16 * f27)) - (f18 * f28)) / ((f16 * f16) + (f18 * f18)), ((((f19 * f16) - (f17 * f18)) - (f28 * f16)) + (f27 * f18)) / ((f16 * f16) + (f18 * f18)));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    private static byte[] d(File file) {
        FileInputStream fileInputStream;
        ?? isFile = file.isFile();
        FileInputStream fileInputStream2 = null;
        try {
            if (isFile != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                    return byteArray;
                } catch (IOException e19) {
                    e = e19;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    return null;
                }
            }
            QLog.d("Util", 4, "file not found, path = " + file.getAbsolutePath());
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = isFile;
        }
    }

    public static Bitmap e(String str, int i3, int i16, boolean z16) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
            bitmap.setPremultiplied(z16);
            byte[] d16 = d(new File(str));
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            if (d16 != null) {
                allocate.put(d16);
            }
            allocate.position(0);
            bitmap.copyPixelsFromBuffer(allocate);
        } catch (Exception e16) {
            QLog.d("Util", 4, "readRawBytesToBitmap exception, msg = " + e16.getMessage());
        } catch (OutOfMemoryError unused) {
            QLog.d("Util", 4, "readRawBytesToBitmap OOM");
        }
        return bitmap;
    }

    public static void f(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
                    bitmap.copyPixelsToBuffer(allocate);
                    File file = new File(str);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(allocate.array());
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e16) {
                        fileOutputStream = fileOutputStream2;
                        e = e16;
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e17) {
                        fileOutputStream = fileOutputStream2;
                        e = e17;
                        e.printStackTrace();
                        QLog.d("Util", 4, "saveBitmapRawBytesToFile exception, msg = " + e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (OutOfMemoryError e18) {
                        fileOutputStream = fileOutputStream2;
                        e = e18;
                        e.printStackTrace();
                        QLog.d("Util", 4, "saveBitmapRawBytesToFile error, msg = " + e.getMessage());
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        fileOutputStream = fileOutputStream2;
                        th = th5;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e26) {
                    e = e26;
                } catch (Exception e27) {
                    e = e27;
                } catch (OutOfMemoryError e28) {
                    e = e28;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e29) {
            e29.printStackTrace();
        }
    }

    private static PointF g(PointF pointF, PointF pointF2, PointF pointF3) {
        float f16 = pointF2.x;
        float f17 = pointF3.x;
        float f18 = pointF.x;
        float f19 = pointF3.y;
        float f26 = pointF.y;
        return new PointF((f16 + (f17 * f18)) - (f19 * f26), pointF2.y + (f17 * f26) + (f19 * f18));
    }

    public static boolean b(List<PointF> list, int i3, int i16, float[] fArr) {
        PointF pointF = new PointF(list.get(53).x - list.get(43).x, list.get(53).y - list.get(43).y);
        PointF pointF2 = new PointF((list.get(53).x + list.get(43).x) * 0.5f, (list.get(53).y + list.get(43).y) * 0.5f);
        if (pointF.x < 0.01d && pointF.y < 0.01d) {
            return false;
        }
        float f16 = 99999.0f;
        float f17 = 99999.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        for (int i17 = 0; i17 < 83; i17++) {
            PointF c16 = c(pointF, pointF2, new PointF(list.get(i17).x, list.get(i17).y));
            float f26 = c16.y;
            if (f26 < f17) {
                f17 = f26;
            }
            if (f26 > f19) {
                f19 = f26;
            }
            float f27 = c16.x;
            if (f27 < f16) {
                f16 = f27;
            }
            if (f27 > f18) {
                f18 = f27;
            }
        }
        PointF g16 = g(pointF, pointF2, new PointF((f16 + f18) * 0.5f, (f17 + f19) * 0.5f));
        float max = Math.max(f18 - f16, f19 - f17) * 0.5f;
        PointF g17 = g(pointF, pointF2, new PointF(max, 0.0f));
        PointF pointF3 = new PointF(g17.x - pointF2.x, g17.y - pointF2.y);
        PointF g18 = g(pointF, pointF2, new PointF(0.0f, max));
        PointF pointF4 = new PointF(g18.x - pointF2.x, g18.y - pointF2.y);
        PointF pointF5 = new PointF(g16.x, g16.y);
        PointF pointF6 = new PointF(pointF3.x, pointF3.y);
        PointF pointF7 = new PointF(pointF4.x, pointF4.y);
        float f28 = pointF5.x;
        float f29 = pointF6.x;
        float f36 = pointF7.x;
        float f37 = i3;
        fArr[0] = ((f28 - f29) + f36) / f37;
        float f38 = pointF5.y;
        float f39 = pointF6.y;
        float f46 = pointF7.y;
        float f47 = i16;
        fArr[1] = 1.0f - (((f38 - f39) + f46) / f47);
        fArr[2] = ((f28 - f29) - f36) / f37;
        fArr[3] = 1.0f - (((f38 - f39) - f46) / f47);
        fArr[4] = ((f28 + f29) - f36) / f37;
        fArr[5] = 1.0f - (((f38 + f39) - f46) / f47);
        fArr[6] = ((f28 + f29) + f36) / f37;
        fArr[7] = 1.0f - (((f38 + f39) + f46) / f47);
        return true;
    }
}
