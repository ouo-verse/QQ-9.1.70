package j91;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.ark.image.ChooseImageInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends QIPCModule {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f409666e;

    /* renamed from: f, reason: collision with root package name */
    public static int f409667f;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC10577a f409668d;

    /* compiled from: P */
    /* renamed from: j91.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC10577a {
        void a(String str);
    }

    public a(String str) {
        super(str);
        this.f409668d = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:(20:105|(1:8)|9|(1:11)|(1:15)|16|17|18|19|20|21|22|23|24|(1:26)|27|(3:29|(1:31)|32)|33|34|35)(1:104))(1:5)|17|18|19|20|21|22|23|24|(0)|27|(0)|33|34|35) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x00e3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r19 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0146, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ArkApp.ChooseImageIPCModule", 1, "compress image", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x014c, code lost:
    
        if (r19 != null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0151, code lost:
    
        if (r9 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0159, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x015c, code lost:
    
        r1 = r1;
        r2 = r2;
        r8 = r8;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0160, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0162, code lost:
    
        r13 = new java.io.File(r1).length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x016b, code lost:
    
        if (r8 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x016d, code lost:
    
        r17 = r8.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0171, code lost:
    
        r4 = 6;
        r1 = java.lang.Integer.valueOf(r2.outHeight);
        r2 = 7;
        r0 = java.lang.String.format("compress image {origin :%s,length=%d, size[%d,%d]}==>{dest :%s,length=%d, size[%d,%d]}", new java.lang.Object[]{r1, java.lang.Long.valueOf(r13), java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(r6), r21, java.lang.Long.valueOf(r17), java.lang.Integer.valueOf(r2.outWidth), r1});
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a6, code lost:
    
        com.tencent.qphone.base.util.QLog.d("ArkApp.ChooseImageIPCModule", 2, r0);
        r1 = r1;
        r2 = r2;
        r8 = r8;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014e, code lost:
    
        r19.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d9, code lost:
    
        r19 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e4, code lost:
    
        com.tencent.qphone.base.util.QLog.e("ArkApp.ChooseImageIPCModule", 1, "compress oom", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ea, code lost:
    
        if (r19 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ef, code lost:
    
        if (r9 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f7, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00fa, code lost:
    
        r1 = r1;
        r2 = r2;
        r8 = r8;
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00fe, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0100, code lost:
    
        r13 = new java.io.File(r1).length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0109, code lost:
    
        if (r8 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x010b, code lost:
    
        r17 = r8.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x010f, code lost:
    
        r4 = 6;
        r1 = java.lang.Integer.valueOf(r2.outHeight);
        r2 = 7;
        r0 = java.lang.String.format("compress image {origin :%s,length=%d, size[%d,%d]}==>{dest :%s,length=%d, size[%d,%d]}", new java.lang.Object[]{r1, java.lang.Long.valueOf(r13), java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(r6), r21, java.lang.Long.valueOf(r17), java.lang.Integer.valueOf(r2.outWidth), r1});
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ec, code lost:
    
        r19.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d4, code lost:
    
        r19 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01aa, code lost:
    
        if (r19 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01af, code lost:
    
        if (r9 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b7, code lost:
    
        r9.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c0, code lost:
    
        r13 = new java.io.File(r1).length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c9, code lost:
    
        if (r8 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cb, code lost:
    
        r17 = r8.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cf, code lost:
    
        r8 = new java.lang.Object[8];
        r8[r4] = r1;
        r8[r7] = java.lang.Long.valueOf(r13);
        r8[2] = java.lang.Integer.valueOf(r5);
        r8[3] = java.lang.Integer.valueOf(r6);
        r8[4] = r21;
        r8[5] = java.lang.Long.valueOf(r17);
        r8[6] = java.lang.Integer.valueOf(r2.outWidth);
        r8[7] = java.lang.Integer.valueOf(r2.outHeight);
        com.tencent.qphone.base.util.QLog.d("ArkApp.ChooseImageIPCModule", 2, java.lang.String.format("compress image {origin :%s,length=%d, size[%d,%d]}==>{dest :%s,length=%d, size[%d,%d]}", r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0207, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ac, code lost:
    
        r19.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0145, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(String str, String str2, Bitmap.CompressFormat compressFormat, int i3, BitmapFactory.Options options) {
        int i16;
        float f16;
        Bitmap decodeFile;
        int rotateDegree;
        Bitmap bitmap;
        ?? isColorLevel;
        String str3 = str;
        BitmapFactory.Options options2 = options;
        char c16 = 0;
        options2.inJustDecodeBounds = false;
        int i17 = options2.outWidth;
        int i18 = options2.outHeight;
        ?? r75 = 1;
        r75 = 1;
        r75 = 1;
        r75 = 1;
        r75 = 1;
        try {
            if (i17 > i18 && i17 > 960.0f) {
                f16 = i17;
            } else if (i17 < i18 && i18 > 960.0f) {
                f16 = i18;
            } else {
                i16 = 1;
                if (i16 <= 0) {
                    i16 = 1;
                }
                options2.inSampleSize = i16;
                decodeFile = BitmapFactory.decodeFile(str3, options2);
                File createNewFile = BaseImageUtil.createNewFile(str2);
                rotateDegree = BaseImageUtil.getRotateDegree(str);
                if (QLog.isColorLevel()) {
                    QLog.e("ArkApp.ChooseImageIPCModule", 1, "compress image get rotation rotateDegree = ", Integer.valueOf(rotateDegree));
                }
                if (rotateDegree != 0 && rotateDegree % 90 == 0) {
                    decodeFile = h(decodeFile, rotateDegree);
                }
                bitmap = decodeFile;
                long j3 = 0;
                BufferedOutputStream bufferedOutputStream = null;
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(createNewFile));
                boolean compress = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                bufferedOutputStream2.close();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                isColorLevel = QLog.isColorLevel();
                String str4 = str3;
                ?? r26 = options2;
                File file = createNewFile;
                Bitmap bitmap2 = isColorLevel;
                if (isColorLevel != 0) {
                    ?? file2 = new File(str3);
                    long length = file2.length();
                    if (createNewFile != null) {
                        j3 = createNewFile.length();
                    }
                    c16 = 6;
                    Integer valueOf = Integer.valueOf(options2.outHeight);
                    r26 = 7;
                    ?? r85 = {str3, Long.valueOf(length), Integer.valueOf(i17), Integer.valueOf(i18), str2, Long.valueOf(j3), Integer.valueOf(options2.outWidth), valueOf};
                    String format = String.format("compress image {origin :%s,length=%d, size[%d,%d]}==>{dest :%s,length=%d, size[%d,%d]}", r85);
                    QLog.d("ArkApp.ChooseImageIPCModule", 2, format);
                    str4 = format;
                    file = r85;
                    bitmap2 = file2;
                }
                r75 = compress;
                str3 = str4;
                options2 = r26;
                createNewFile = file;
                bitmap = bitmap2;
                return r75;
            }
            BufferedOutputStream bufferedOutputStream22 = new BufferedOutputStream(new FileOutputStream(createNewFile));
            boolean compress2 = bitmap.compress(compressFormat, i3, bufferedOutputStream22);
            bufferedOutputStream22.close();
            if (!bitmap.isRecycled()) {
            }
            isColorLevel = QLog.isColorLevel();
            String str42 = str3;
            ?? r262 = options2;
            File file3 = createNewFile;
            Bitmap bitmap22 = isColorLevel;
            if (isColorLevel != 0) {
            }
            r75 = compress2;
            str3 = str42;
            options2 = r262;
            createNewFile = file3;
            bitmap = bitmap22;
            return r75;
        } catch (Throwable th5) {
            th = th5;
        }
        i16 = (int) (f16 / 960.0f);
        if (i16 <= 0) {
        }
        options2.inSampleSize = i16;
        decodeFile = BitmapFactory.decodeFile(str3, options2);
        File createNewFile2 = BaseImageUtil.createNewFile(str2);
        rotateDegree = BaseImageUtil.getRotateDegree(str);
        if (QLog.isColorLevel()) {
        }
        if (rotateDegree != 0) {
            decodeFile = h(decodeFile, rotateDegree);
        }
        bitmap = decodeFile;
        long j36 = 0;
        BufferedOutputStream bufferedOutputStream3 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(ArrayList<String> arrayList, String str, boolean z16, String str2) {
        boolean z17;
        boolean e16;
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int i3 = f409667f + 1;
            f409667f = i3;
            if (i3 >= 100 || i3 < 0) {
                f409667f = 0;
            }
            String format = String.format("tmp_%d_%02d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(f409667f));
            String str3 = str + "/" + format;
            BitmapFactory.Options options = BitmapUtils.getOptions();
            String f16 = f(next, options);
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            if (!"jpg".equalsIgnoreCase(f16) && !MimeHelper.IMAGE_SUBTYPE_JPEG.equalsIgnoreCase(f16)) {
                if ("png".equalsIgnoreCase(f16)) {
                    compressFormat = Bitmap.CompressFormat.PNG;
                } else {
                    z17 = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("ArkApp.ChooseImageIPCModule", 2, String.format("image size origin[%d,%d]", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)));
                    }
                    if (!z16) {
                        String str4 = str3 + "_compress";
                        if (z17) {
                            if (c(next, str4, compressFormat, 80, options)) {
                                e16 = FileUtils.rename(str4, str3);
                            } else {
                                FileUtils.deleteFile(str4);
                                e16 = e(next, str3, compressFormat);
                            }
                        } else {
                            e16 = e(next, str3, compressFormat);
                        }
                    } else {
                        e16 = e(next, str3, compressFormat);
                    }
                    if (!e16) {
                        long length = new File(str3).length();
                        ChooseImageInfo chooseImageInfo = new ChooseImageInfo();
                        chooseImageInfo.path = str2 + format;
                        chooseImageInfo.format = f16;
                        chooseImageInfo.size = length;
                        jSONArray.mo162put(JSONUtils.a(chooseImageInfo));
                        if (QLog.isColorLevel()) {
                            QLog.d("ArkApp.ChooseImageIPCModule", 2, String.format("copy Image success ![%s]->[%s].", next, str3));
                        }
                    } else {
                        QLog.e("ArkApp.ChooseImageIPCModule", 1, String.format("copy Image fail! [%s]->[%s].", next, str3));
                    }
                }
            } else {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
            z17 = true;
            if (QLog.isColorLevel()) {
            }
            if (!z16) {
            }
            if (!e16) {
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ChooseImageIPCModule", 1, "copy Image imageinfo=", jSONArray2);
        }
        return jSONArray2;
    }

    public static boolean e(String str, String str2, Bitmap.CompressFormat compressFormat) {
        File file = new File(str);
        boolean z16 = false;
        if (!file.exists()) {
            return false;
        }
        int rotateDegree = BaseImageUtil.getRotateDegree(str);
        if (rotateDegree != 0 && rotateDegree % 90 == 0 && (Bitmap.CompressFormat.JPEG == compressFormat || Bitmap.CompressFormat.PNG == compressFormat)) {
            Bitmap bitmap = null;
            try {
                try {
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                        bitmap = h(BitmapFactory.decodeStream(bufferedInputStream), rotateDegree);
                        FileOutputStream fileOutputStream = new FileOutputStream(str2);
                        z16 = bitmap.compress(compressFormat, 90, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        if (bitmap.isRecycled()) {
                            return z16;
                        }
                    } catch (IOException e16) {
                        QLog.d("ArkApp.ChooseImageIPCModule", 1, "IOException:", e16);
                        if (bitmap == null || bitmap.isRecycled()) {
                            return z16;
                        }
                    } catch (OutOfMemoryError e17) {
                        QLog.d("ArkApp.ChooseImageIPCModule", 1, "OutOfMemoryError:", e17);
                        if (bitmap == null || bitmap.isRecycled()) {
                            return z16;
                        }
                    }
                } catch (FileNotFoundException e18) {
                    QLog.d("ArkApp.ChooseImageIPCModule", 1, "FileNotFoundException:", e18);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return z16;
                    }
                }
                bitmap.recycle();
                return z16;
            } catch (Throwable th5) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                throw th5;
            }
        }
        try {
            return FileUtils.copyFile(file, FileUtils.createFile(str2));
        } catch (IOException e19) {
            QLog.d("ArkApp.ChooseImageIPCModule", 1, "copy fail from " + str + " to " + str2 + " " + e19.getMessage());
            return false;
        }
    }

    public static String f(String str, BitmapFactory.Options options) {
        int indexOf;
        options.inJustDecodeBounds = true;
        try {
            try {
                try {
                    BitmapFactory.decodeFile(str, options);
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ArkApp.ChooseImageIPCModule", 2, "", e16);
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("ArkApp.ChooseImageIPCModule", 2, "", e17);
                }
            }
        } catch (OutOfMemoryError e18) {
            QLog.e("ArkApp.ChooseImageIPCModule", 1, "OutOfMemoryError", e18);
        }
        if (options.outWidth > 0 && options.outHeight > 0 && options.outMimeType == null) {
            return "webp";
        }
        String str2 = options.outMimeType;
        if (str2 != null && (indexOf = str2.indexOf(47)) != -1) {
            return options.outMimeType.substring(indexOf + 1);
        }
        return "png";
    }

    public static a g() {
        if (f409666e == null) {
            synchronized (a.class) {
                if (f409666e == null) {
                    f409666e = new a("ChooseImageIPCModule");
                }
            }
        }
        return f409666e;
    }

    public static Bitmap h(Bitmap bitmap, int i3) {
        if (i3 != 0 && bitmap != null) {
            Bitmap bitmap2 = null;
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate(i3, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                bitmap.recycle();
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.ChooseImageIPCModule", 2, "rotateBitmap rotate = ", Integer.valueOf(i3));
                }
            } catch (Exception e16) {
                QLog.d("ArkApp.ChooseImageIPCModule", 1, "rotateBitmap Exception:", e16);
            } catch (OutOfMemoryError e17) {
                QLog.d("ArkApp.ChooseImageIPCModule", 1, "rotateBitmap OutOfMemoryError:", e17);
            }
            return bitmap2;
        }
        return bitmap;
    }

    public void b(String str, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        QIPCClientHelper.getInstance().callServer("ChooseImageIPCModule", str, bundle, eIPCResultCallback);
    }

    public void i(InterfaceC10577a interfaceC10577a) {
        this.f409668d = interfaceC10577a;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        String str2;
        QLog.i("ArkApp.ChooseImageIPCModule", 1, "chooseimage action = " + str + ", callbackid=" + i3);
        BaseApplicationImpl.getApplication().getRuntime();
        if ("callbackArk".equals(str)) {
            if (bundle != null) {
                str2 = bundle.getString("bundle_key_info");
            } else {
                str2 = null;
            }
            InterfaceC10577a interfaceC10577a = this.f409668d;
            if (interfaceC10577a != null) {
                interfaceC10577a.a(str2);
            }
        }
        if ("callReportUrlCheck".equals(str) && bundle != null) {
            bundle.getString("reportContent");
        }
        "callDisableReport".equals(str);
        return null;
    }
}
