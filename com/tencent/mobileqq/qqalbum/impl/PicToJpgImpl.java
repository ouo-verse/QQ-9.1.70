package com.tencent.mobileqq.qqalbum.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.Utils;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qqalbum.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/* loaded from: classes16.dex */
public class PicToJpgImpl implements IPicToJpg {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_TYPE_HEIF = "heif";

    public PicToJpgImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean compressQuality(String str, Bitmap bitmap, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, bitmap, Integer.valueOf(i3), str2)).booleanValue();
        }
        return ((IPicUtil) QRoute.api(IPicUtil.class)).compressQuality(str, bitmap, i3, str2, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:8|(1:10)(2:48|(1:50)(2:51|(1:53)(3:54|(1:56)(1:57)|(4:16|(1:18)(1:32)|19|(4:21|23|24|25)(3:29|30|31))(2:14|15))))|11|(0)|16|(0)(0)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
    
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f A[Catch: all -> 0x0077, Exception -> 0x0079, TRY_ENTER, TryCatch #1 {Exception -> 0x0079, blocks: (B:18:0x004f, B:19:0x005c, B:21:0x0066, B:32:0x0056), top: B:16:0x004d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[Catch: all -> 0x0077, Exception -> 0x0079, TRY_LEAVE, TryCatch #1 {Exception -> 0x0079, blocks: (B:18:0x004f, B:19:0x005c, B:21:0x0066, B:32:0x0056), top: B:16:0x004d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073 A[Catch: IOException -> 0x0083, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0083, blocks: (B:29:0x0073, B:38:0x007f, B:18:0x004f, B:19:0x005c, B:21:0x0066, B:32:0x0056), top: B:16:0x004d, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056 A[Catch: all -> 0x0077, Exception -> 0x0079, TryCatch #1 {Exception -> 0x0079, blocks: (B:18:0x004f, B:19:0x005c, B:21:0x0066, B:32:0x0056), top: B:16:0x004d, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String fileType(Object obj) {
        FileDescriptor fileDescriptor;
        File file;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
        FileInputStream fileInputStream = null;
        try {
            if (obj instanceof String) {
                file = new File((String) obj);
            } else if (obj instanceof URL) {
                file = new File(((URL) obj).getFile());
            } else if (obj instanceof URI) {
                file = new File((URI) obj);
            } else {
                if (obj instanceof FileDescriptor) {
                    fileDescriptor = (FileDescriptor) obj;
                    file = null;
                } else {
                    fileDescriptor = null;
                    file = null;
                }
                if (file != null && fileDescriptor == null) {
                    return FileUtils.unKnownFileTypeMark;
                }
                if (file == null) {
                    fileInputStream = new FileInputStream(file);
                } else {
                    fileInputStream = new FileInputStream(fileDescriptor);
                }
                bArr = new byte[2];
                if (fileInputStream.read(bArr) == -1) {
                    String estimateFileType = FileUtils.estimateFileType(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return estimateFileType;
                }
                fileInputStream.close();
                return FileUtils.unKnownFileTypeMark;
            }
            if (file == null) {
            }
            bArr = new byte[2];
            if (fileInputStream.read(bArr) == -1) {
            }
        } catch (Throwable th5) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            throw th5;
        }
        fileDescriptor = null;
        if (file != null) {
        }
    }

    public Matrix getMatrixByOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Matrix) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        Matrix matrix = new Matrix();
        switch (i3) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return matrix;
            case 3:
                matrix.setRotate(180.0f);
                return matrix;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return matrix;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return matrix;
            case 6:
                matrix.setRotate(90.0f);
                return matrix;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return matrix;
            case 8:
                matrix.setRotate(-90.0f);
                return matrix;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(1:10)(2:51|(1:53)(2:54|(1:56)(4:57|(1:59)(1:60)|12|(9:16|(1:18)(2:45|46)|19|20|(1:22)|(1:24)|26|27|28)(1:15))))|16|(0)(0)|19|20|(0)|(0)|26|27|28) */
    /* JADX WARN: Can't wrap try/catch for region: R(14:8|(1:10)(2:51|(1:53)(2:54|(1:56)(4:57|(1:59)(1:60)|12|(9:16|(1:18)(2:45|46)|19|20|(1:22)|(1:24)|26|27|28)(1:15))))|11|12|(0)|16|(0)(0)|19|20|(0)|(0)|26|27|28) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        r1 = r5;
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0087, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008a, code lost:
    
        if (r1 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        r1 = r5;
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0090, code lost:
    
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0096, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0078, code lost:
    
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        r5 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[Catch: all -> 0x0084, Exception -> 0x0086, TRY_ENTER, TryCatch #2 {all -> 0x0084, blocks: (B:18:0x0052, B:33:0x0087, B:45:0x0058), top: B:16:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064 A[Catch: all -> 0x007c, Exception -> 0x0080, TryCatch #6 {Exception -> 0x0080, all -> 0x007c, blocks: (B:20:0x005e, B:22:0x0064, B:24:0x006b), top: B:19:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b A[Catch: all -> 0x007c, Exception -> 0x0080, TRY_LEAVE, TryCatch #6 {Exception -> 0x0080, all -> 0x007c, blocks: (B:20:0x005e, B:22:0x0064, B:24:0x006b), top: B:19:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0058 A[Catch: all -> 0x0084, Exception -> 0x0086, TRY_LEAVE, TryCatch #2 {all -> 0x0084, blocks: (B:18:0x0052, B:33:0x0087, B:45:0x0058), top: B:16:0x0050 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0078 -> B:27:0x008f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getOrientation(Object obj) {
        FileDescriptor fileDescriptor;
        File file;
        int i3;
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, obj)).intValue();
        }
        FileInputStream fileInputStream2 = null;
        ExifInterface exifInterface = null;
        FileInputStream fileInputStream3 = null;
        try {
            if (obj instanceof String) {
                file = new File((String) obj);
            } else if (obj instanceof URL) {
                file = new File(((URL) obj).getFile());
            } else if (obj instanceof URI) {
                file = new File((URI) obj);
            } else {
                if (obj instanceof FileDescriptor) {
                    fileDescriptor = (FileDescriptor) obj;
                    file = null;
                } else {
                    fileDescriptor = null;
                    file = null;
                }
                i3 = 0;
                if (file != null && fileDescriptor == null) {
                    return 0;
                }
                if (file == null) {
                    fileInputStream = new FileInputStream(file);
                } else {
                    fileInputStream = new FileInputStream(fileDescriptor);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    exifInterface = new ExifInterface(fileInputStream);
                }
                if (exifInterface != null) {
                    i3 = exifInterface.getAttributeInt("Orientation", 1);
                }
                fileInputStream.close();
                return i3;
            }
            if (file == null) {
            }
            if (Build.VERSION.SDK_INT >= 24) {
            }
            if (exifInterface != null) {
            }
            fileInputStream.close();
            return i3;
        } catch (Throwable th5) {
            th = th5;
        }
        fileDescriptor = null;
        i3 = 0;
        if (file != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[Catch: all -> 0x0089, IOException -> 0x008b, TRY_ENTER, TryCatch #5 {IOException -> 0x008b, blocks: (B:18:0x0052, B:19:0x005f, B:20:0x0068, B:22:0x006d, B:38:0x0059), top: B:16:0x0050, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d A[Catch: all -> 0x0089, IOException -> 0x008b, TRY_LEAVE, TryCatch #5 {IOException -> 0x008b, blocks: (B:18:0x0052, B:19:0x005f, B:20:0x0068, B:22:0x006d, B:38:0x0059), top: B:16:0x0050, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059 A[Catch: all -> 0x0089, IOException -> 0x008b, TryCatch #5 {IOException -> 0x008b, blocks: (B:18:0x0052, B:19:0x005f, B:20:0x0068, B:22:0x006d, B:38:0x0059), top: B:16:0x0050, outer: #2 }] */
    @Override // com.tencent.mobileqq.qqalbum.IPicToJpg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isHeif(Object obj) {
        FileDescriptor fileDescriptor;
        File file;
        int i3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, obj)).booleanValue();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (obj instanceof String) {
                    file = new File((String) obj);
                } else if (obj instanceof URL) {
                    file = new File(((URL) obj).getFile());
                } else if (obj instanceof URI) {
                    file = new File((URI) obj);
                } else {
                    if (obj instanceof FileDescriptor) {
                        fileDescriptor = (FileDescriptor) obj;
                        file = null;
                    } else {
                        fileDescriptor = null;
                        file = null;
                    }
                    if (file != null && fileDescriptor == null) {
                        return false;
                    }
                    if (file == null) {
                        fileInputStream = new FileInputStream(file);
                    } else {
                        fileInputStream = new FileInputStream(fileDescriptor);
                    }
                    byte[] bArr2 = new byte[Utils.HEIF_SIGNATURE.length];
                    fileInputStream.read(bArr2);
                    i3 = 0;
                    while (true) {
                        bArr = Utils.HEIF_SIGNATURE;
                        if (i3 >= bArr.length) {
                            if (bArr2[i3] != bArr[i3]) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                                return false;
                            }
                            i3++;
                        } else {
                            try {
                                fileInputStream.close();
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                            return true;
                        }
                    }
                }
                if (file == null) {
                }
                byte[] bArr22 = new byte[Utils.HEIF_SIGNATURE.length];
                fileInputStream.read(bArr22);
                i3 = 0;
                while (true) {
                    bArr = Utils.HEIF_SIGNATURE;
                    if (i3 >= bArr.length) {
                    }
                    i3++;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
                if (fileInputStream == null) {
                    return false;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (Exception e19) {
                    e19.printStackTrace();
                    return false;
                }
            }
        } catch (Throwable th5) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            throw th5;
        }
        fileDescriptor = null;
        if (file != null) {
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IPicToJpg
    public boolean picToJpg(a aVar) {
        String fileType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar == null) {
            return false;
        }
        if (isHeif(aVar.f262095a)) {
            fileType = "heif";
        } else {
            fileType = fileType(aVar.f262095a);
        }
        fileType.hashCode();
        if (!fileType.equals("heif") && !fileType.equals("webp")) {
            return false;
        }
        return transToJpg(aVar);
    }

    public boolean transToJpg(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int orientation = getOrientation(aVar.f262095a);
            Matrix matrixByOrientation = getMatrixByOrientation(orientation);
            if (QLog.isColorLevel()) {
                QLog.d(IPicToJpg.TAG, 2, "generate " + IPicToJpg.TAG + ",sourcePath:" + aVar.f262095a + ",targetPath:" + aVar.f262096b + ",orientation:" + orientation);
            }
            Bitmap safeDecode = SafeBitmapFactory.safeDecode(aVar.f262095a, options);
            if (safeDecode != null && matrixByOrientation != null) {
                safeDecode = Bitmap.createBitmap(safeDecode, 0, 0, safeDecode.getWidth(), safeDecode.getHeight(), matrixByOrientation, true);
            }
            return compressQuality(aVar.f262096b, safeDecode, aVar.f262097c, IPicToJpg.TAG);
        }
        return false;
    }
}
