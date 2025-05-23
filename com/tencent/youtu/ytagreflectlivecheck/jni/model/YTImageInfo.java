package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTImageInfo {
    static IPatchRedirector $redirector_;
    public String checksum;
    public ArrayList<Float> five_points;
    public String image;

    public YTImageInfo(YTActReflectImage yTActReflectImage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) yTActReflectImage);
            return;
        }
        this.image = new String(Base64.encode(yTActReflectImage.image, 2));
        this.checksum = yTActReflectImage.checksum;
        ArrayList<Float> arrayList = new ArrayList<>();
        this.five_points = arrayList;
        float[] fArr = yTActReflectImage.xys;
        if (fArr != null) {
            arrayList.add(Float.valueOf(fArr[176]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[177]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[178]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[179]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[64]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[65]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[90]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[91]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[102]));
            this.five_points.add(Float.valueOf(yTActReflectImage.xys[103]));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[Catch: Exception -> 0x0050, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:14:0x002a, B:26:0x004c), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0051 -> B:15:0x0054). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void createFileWithByte(String str, byte[] bArr) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Exception e16;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e17) {
                e = e17;
                bufferedOutputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                if (fileOutputStream2 != null) {
                }
                if (bufferedOutputStream != null) {
                }
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e18) {
                e = e18;
                bufferedOutputStream = null;
                e16 = e;
                e16.printStackTrace();
                if (fileOutputStream != null) {
                }
                if (bufferedOutputStream == null) {
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream = null;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                }
                if (bufferedOutputStream != null) {
                }
            }
            try {
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th7) {
                    th = th7;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            throw th;
                        } catch (Exception e27) {
                            e27.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception e28) {
                e16 = e28;
                e16.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                }
                if (bufferedOutputStream == null) {
                    bufferedOutputStream.close();
                }
            }
        } catch (Exception e36) {
            e36.printStackTrace();
        }
    }
}
