package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.GifDrawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ImageTestUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aw extends BaseImageUtil {
    /* JADX WARN: Can't wrap try/catch for region: R(13:11|12|13|14|(1:16)|17|(3:(1:57)|58|(2:60|(6:62|24|25|26|(1:28)|(1:49)(5:31|32|(1:46)(1:38)|39|(2:41|43)(1:45)))))|23|24|25|26|(0)|(1:49)(1:50)) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c7, code lost:
    
        com.tencent.mobileqq.utils.BaseImageUtil.logImage("compress : compressLargePhoto " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016e, code lost:
    
        if (r13.isRecycled() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0171, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x012e, code lost:
    
        r13.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x012c, code lost:
    
        if (r13.isRecycled() != false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(int i3, Context context, File file, File file2, ImageInfo imageInfo, int i16, int i17, int i18, boolean z16, boolean z17) {
        Bitmap bitmap;
        int i19;
        boolean z18;
        boolean z19;
        boolean z26;
        int i26;
        Throwable th5;
        boolean z27;
        FileOutputStream fileOutputStream;
        boolean z28;
        boolean z29;
        FileOutputStream fileOutputStream2;
        String str = "compress : compressLargePhoto ";
        n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressLargePhoto: long pic; w=" + i18 + ",h=" + i17);
        imageInfo.P = true;
        try {
            bitmap = SafeBitmapFactory.decodeFile(file.getPath());
        } catch (OutOfMemoryError unused) {
            BaseImageUtil.logImage("compress : compressLargePhoto first decode OOM srcFile:" + file);
            if (NetworkUtil.isWifiEnabled(context)) {
                imageInfo.M = true;
                imageInfo.N = false;
                bitmap = null;
            } else {
                b(i3, context, file, file2, imageInfo, i16, i17, i18, z16, z17);
                return;
            }
        }
        long j3 = AppSetting.J;
        if (imageInfo.N && bitmap != null) {
            if (NetworkUtil.isWifiEnabled(context)) {
                i26 = 80;
            } else {
                i26 = 70;
            }
            try {
                try {
                    fileOutputStream2 = new FileOutputStream(file2);
                } catch (Exception unused2) {
                    fileOutputStream = null;
                } catch (OutOfMemoryError unused3) {
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    z27 = false;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                    }
                    if (z27) {
                    }
                    if (!bitmap.isRecycled()) {
                    }
                }
                try {
                    boolean compress = bitmap.compress(Bitmap.CompressFormat.JPEG, i26, fileOutputStream2);
                    imageInfo.f183968d0 = compress;
                    imageInfo.f183971g0 = true;
                    if (compress) {
                        BaseImageUtil.forceSyncFile(fileOutputStream2);
                    }
                } catch (Exception unused4) {
                    fileOutputStream = fileOutputStream2;
                    BaseImageUtil.logImage("compress : compressLargePhoto compress 1 excepiton ");
                    imageInfo.f183971g0 = false;
                    imageInfo.f183969e0 = k();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("compress : compressLargePhoto ");
                            str = e16.getMessage();
                            sb5.append(str);
                            BaseImageUtil.logImage(sb5.toString());
                        }
                    }
                    if (file2 != null) {
                        file2.delete();
                    }
                } catch (OutOfMemoryError unused5) {
                    fileOutputStream = fileOutputStream2;
                    BaseImageUtil.logImage("compress : compressLargePhoto compress  OOM ");
                    try {
                        imageInfo.M = true;
                        imageInfo.f183971g0 = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("compress : compressLargePhoto ");
                                str = e17.getMessage();
                                sb6.append(str);
                                BaseImageUtil.logImage(sb6.toString());
                            }
                        }
                        if (file2 != null) {
                            file2.delete();
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        z27 = true;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                BaseImageUtil.logImage(str + e18.getMessage());
                            }
                        }
                        if (z27 && file2 != null) {
                            file2.delete();
                        }
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                            throw th5;
                        }
                        throw th5;
                    }
                } catch (Throwable th8) {
                    th5 = th8;
                    fileOutputStream = fileOutputStream2;
                    z27 = false;
                    if (fileOutputStream != null) {
                    }
                    if (z27) {
                        file2.delete();
                    }
                    if (!bitmap.isRecycled()) {
                    }
                }
                if (i16 == 1 || i16 == 1001 || i16 == 10002 || i16 == 3000) {
                    if (i16 != 1001 && i16 != 10002) {
                        j3 = ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit();
                    }
                    BaseImageUtil.logImage("compress : compressLargePhoto is not c2c ");
                    if (file2.length() > ((int) j3)) {
                        if (!GifDrawable.isGifFile(file)) {
                            z28 = true;
                            fileOutputStream2.close();
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            if (!z28 && file2 != null) {
                                try {
                                    if (file2.exists() && file2.delete() && file2.createNewFile()) {
                                        z29 = true;
                                    } else {
                                        z29 = false;
                                    }
                                    n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressLargePhoto, compressed file is out of size limt " + file2.length() + ",needRecompress:" + z29);
                                    if (z29) {
                                        imageInfo.N = false;
                                        imageInfo.f183971g0 = false;
                                        imageInfo.M = false;
                                        b(i3, context, file, file2, imageInfo, i16, i17, i18, z16, z17);
                                        return;
                                    }
                                    return;
                                } catch (IOException unused6) {
                                    BaseImageUtil.logImage("compress : compressLargePhoto is out of size limt has exception");
                                    imageInfo.f183971g0 = false;
                                    return;
                                }
                            }
                        }
                    }
                }
                z28 = false;
                fileOutputStream2.close();
                if (!bitmap.isRecycled()) {
                }
                if (!z28) {
                }
            } catch (Throwable th9) {
                th5 = th9;
            }
        } else {
            n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressLargePhoto: org long pic decode fail");
            if ((i16 == 1001 || i16 == 10002) && context != null && (context instanceof BaseActivity) && ((QQAppInterface) ((BaseActivity) context).getAppRuntime()).isLBSFriendNewClient(imageInfo.C)) {
                j3 = ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
            }
            if (i16 == 0 && file.length() > ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
                i19 = 1001;
                z18 = true;
            } else {
                i19 = 1001;
                z18 = false;
            }
            if ((i16 == i19 || i16 == 10002) && file.length() > j3) {
                z19 = true;
            } else {
                z19 = false;
            }
            if ((i16 == 1 || i16 == 3000) && file.length() > ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit()) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (!z18 && !z19 && !z26) {
                imageInfo.f183965a0 = 1;
                imageInfo.N = false;
                if (i16 == 0) {
                    imageInfo.Y = 2;
                }
                n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressLargePhoto first decode OOM,send srcfile:" + file);
                return;
            }
            n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressLargePhoto: first decode OOM,compress&send, srcFile:" + file + ",c2cOverLimit\uff1a" + z18 + ",lbsOverLimit:" + z19 + ",groupOverLimit:" + z26);
            b(i3, context, file, file2, imageInfo, i16, i17, i18, z16, z17);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0267, code lost:
    
        if (r0 == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x022e, code lost:
    
        r11.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x022c, code lost:
    
        if (r0 == false) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0204 A[Catch: all -> 0x0232, IOException -> 0x0235, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0235, blocks: (B:75:0x014b, B:77:0x0154, B:79:0x015a, B:81:0x0166, B:84:0x016d, B:86:0x0172, B:88:0x017a, B:91:0x01a3, B:132:0x01a9, B:93:0x01e5, B:159:0x0204), top: B:74:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x020c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v11, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v12, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v13, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void b(int i3, Context context, File file, File file2, ImageInfo imageInfo, int i16, int i17, int i18, boolean z16, boolean z17) {
        int i19;
        Bitmap bitmap;
        long j3;
        Throwable th5;
        Bitmap bitmap2;
        long j16;
        int i26;
        int i27;
        FileOutputStream fileOutputStream;
        n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressNoLargePhoto w=" + i18 + ",h=" + i17);
        int i28 = 80;
        if (z16 && !NetworkUtil.isWifiEnabled(context)) {
            i28 = 70;
        }
        if (imageInfo.Y == 0) {
            i19 = 960;
        } else {
            i19 = 0;
        }
        FileOutputStream fileOutputStream2 = null;
        Bitmap bitmap3 = i3;
        try {
            try {
                bitmap3 = e(bitmap3, context, file, i19, imageInfo);
            } catch (OutOfMemoryError unused) {
                bitmap3 = 0;
            } catch (Throwable th6) {
                th = th6;
                bitmap3 = 0;
            }
            if (bitmap3 == 0) {
                imageInfo.N = false;
                file2.delete();
                BaseImageUtil.logImage("compress : compressNoLargePhoto decode fail");
                if (bitmap3 != 0 && !bitmap3.isRecycled()) {
                    bitmap3.recycle();
                    return;
                }
                return;
            }
            imageInfo.N = true;
            if (!z17) {
                int width = bitmap3.getWidth();
                int height = bitmap3.getHeight();
                bitmap3 = bitmap3;
                if (width > i19 || height > i19) {
                    bitmap3 = BaseImageUtil.scaleBitmap(bitmap3, i19);
                }
            } else {
                bitmap3 = s(bitmap3, file);
            }
            try {
                if (bitmap3 == 0) {
                    n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressNoLargePhoto scaleAndRotateBitmap fail");
                    imageInfo.f183967c0 = true;
                    if (bitmap3 != 0 && !bitmap3.isRecycled()) {
                        bitmap3.recycle();
                        return;
                    }
                    return;
                }
                try {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                    try {
                        boolean compress = bitmap3.compress(Bitmap.CompressFormat.JPEG, i28, fileOutputStream3);
                        imageInfo.f183968d0 = compress;
                        imageInfo.f183971g0 = true;
                        if (compress) {
                            BaseImageUtil.forceSyncFile(fileOutputStream3);
                        }
                        BaseImageUtil.logImage("compress : compressNoLargePhoto decode 1st : suc=" + imageInfo.f183968d0 + ", size=" + file2.length());
                        try {
                            fileOutputStream3.close();
                        } catch (IOException unused2) {
                        } catch (OutOfMemoryError unused3) {
                            fileOutputStream2 = fileOutputStream3;
                            imageInfo.f183971g0 = false;
                            imageInfo.M = true;
                            BaseImageUtil.logImage("compress : compressNoLargePhoto has  OOM ");
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (bitmap3 != 0) {
                                boolean isRecycled = bitmap3.isRecycled();
                                bitmap = bitmap3;
                                if (isRecycled) {
                                    return;
                                }
                                bitmap.recycle();
                            }
                            return;
                        } catch (Throwable th7) {
                            th = th7;
                            fileOutputStream2 = fileOutputStream3;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (bitmap3 != 0) {
                                if (!bitmap3.isRecycled()) {
                                    bitmap3.recycle();
                                    throw th;
                                }
                                throw th;
                            }
                            throw th;
                        }
                        fileOutputStream2 = fileOutputStream3;
                    } catch (IOException unused6) {
                        fileOutputStream2 = fileOutputStream3;
                        imageInfo.f183971g0 = false;
                        imageInfo.f183969e0 = k();
                        BaseImageUtil.logImage("compress : compressNoLargePhoto 1 compress io exception ");
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (i16 != 1) {
                        }
                        if (i16 == 1001) {
                        }
                        j3 = AppSetting.J;
                        try {
                            int i29 = (int) j3;
                            BaseImageUtil.logImage("compress : compressNoLargePhoto is not C2C  maxSize :" + i29);
                            BaseImageUtil.logImage("compress : is not c2c and dest file size:" + file2.length());
                            try {
                                j16 = i29;
                                if (file2.length() > j16) {
                                    n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressNoLargePhoto: > maxsize need scale");
                                    if (file2.delete()) {
                                        i26 = 1;
                                        bitmap3 = bitmap3;
                                        while (true) {
                                            i27 = i26 + 1;
                                            if (i26 >= 4) {
                                                break;
                                            } else {
                                                break;
                                            }
                                            i26 = i27;
                                            fileOutputStream2 = fileOutputStream;
                                            bitmap3 = bitmap3;
                                        }
                                        if (i27 >= 4) {
                                        }
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                }
                                boolean isRecycled2 = bitmap3.isRecycled();
                                bitmap3 = bitmap3;
                            } catch (IOException unused8) {
                            }
                        } catch (Throwable th8) {
                            th5 = th8;
                            bitmap2 = bitmap3;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        fileOutputStream2 = fileOutputStream3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused9) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused10) {
                }
                if (i16 != 1 || i16 == 1001 || i16 == 10002 || i16 == 3000) {
                    if (i16 == 1001 && i16 != 10002) {
                        j3 = ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit();
                    } else {
                        j3 = AppSetting.J;
                    }
                    int i292 = (int) j3;
                    BaseImageUtil.logImage("compress : compressNoLargePhoto is not C2C  maxSize :" + i292);
                    BaseImageUtil.logImage("compress : is not c2c and dest file size:" + file2.length());
                    j16 = i292;
                    if (file2.length() > j16 && !GifDrawable.isGifFile(file)) {
                        n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressNoLargePhoto: > maxsize need scale");
                        if (file2.delete() && file2.createNewFile()) {
                            i26 = 1;
                            bitmap3 = bitmap3;
                            while (true) {
                                i27 = i26 + 1;
                                if (i26 >= 4 || file2.length() <= j16) {
                                    break;
                                }
                                BaseImageUtil.logImage("compress : compressNoLargePhoto is not C2C  compress count:" + i27 + ",filesize:" + file2.length());
                                int i36 = i19 >> 1;
                                if (i36 == 0) {
                                    i19 = 1;
                                } else {
                                    i19 = i36;
                                }
                                bitmap3 = BaseImageUtil.scaleBitmap(bitmap3, i19);
                                if (bitmap3 == 0) {
                                    imageInfo.f183967c0 = true;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e16) {
                                            BaseImageUtil.logImage("compress : compressNoLargePhoto  " + e16.getMessage());
                                        }
                                    }
                                    if (bitmap3 != 0 && !bitmap3.isRecycled()) {
                                        bitmap3.recycle();
                                    }
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException unused11) {
                                        }
                                    }
                                    if (bitmap3 != 0 && !bitmap3.isRecycled()) {
                                        bitmap3.recycle();
                                        return;
                                    }
                                    return;
                                }
                                fileOutputStream = new FileOutputStream(file2);
                                try {
                                    boolean compress2 = bitmap3.compress(Bitmap.CompressFormat.JPEG, i28, fileOutputStream);
                                    imageInfo.f183968d0 = compress2;
                                    if (compress2) {
                                        BaseImageUtil.forceSyncFile(fileOutputStream);
                                    }
                                    i26 = i27;
                                    fileOutputStream2 = fileOutputStream;
                                    bitmap3 = bitmap3;
                                } catch (IOException unused12) {
                                    fileOutputStream2 = fileOutputStream;
                                    imageInfo.f183971g0 = false;
                                    imageInfo.f183969e0 = k();
                                    BaseImageUtil.logImage("compress : compressNoLargePhoto 2 compress exception ");
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e17) {
                                            BaseImageUtil.logImage("compress : compressNoLargePhoto  " + e17.getMessage());
                                        }
                                    }
                                    if (bitmap3 != 0) {
                                        boolean isRecycled3 = bitmap3.isRecycled();
                                        bitmap3 = bitmap3;
                                    }
                                    if (fileOutputStream2 != null) {
                                    }
                                    if (bitmap3 == 0) {
                                    }
                                } catch (Throwable th10) {
                                    th5 = th10;
                                    fileOutputStream2 = fileOutputStream;
                                    bitmap2 = bitmap3;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e18) {
                                            BaseImageUtil.logImage("compress : compressNoLargePhoto  " + e18.getMessage());
                                        }
                                    }
                                    if (bitmap2 != null) {
                                        if (!bitmap2.isRecycled()) {
                                            bitmap2.recycle();
                                            throw th5;
                                        }
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            }
                            if (i27 >= 4) {
                                n(imageInfo, ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "ImageUtil.compressNoLargePhoto: scale 3 time fail");
                            }
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e19) {
                            BaseImageUtil.logImage("compress : compressNoLargePhoto  " + e19.getMessage());
                        }
                    }
                    boolean isRecycled22 = bitmap3.isRecycled();
                    bitmap3 = bitmap3;
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused13) {
                    }
                }
                if (bitmap3 == 0) {
                    boolean isRecycled4 = bitmap3.isRecycled();
                    bitmap = bitmap3;
                    if (isRecycled4) {
                        return;
                    }
                    bitmap.recycle();
                }
            } catch (Throwable th11) {
                th = th11;
            }
        } catch (Throwable th12) {
            th = th12;
        }
    }

    public static boolean c(int i3, Context context, String str, String str2, boolean z16, ImageInfo imageInfo, int i16) {
        boolean z17;
        boolean z18 = false;
        if (FileUtils.fileExists(str2)) {
            File file = new File(str2);
            if (!BaseImageUtil.isValidPic(str2)) {
                file.delete();
            } else {
                imageInfo.f184139m = file.getPath();
                imageInfo.L = file.length();
                imageInfo.f183971g0 = true;
                imageInfo.N = true;
                if (imageInfo.f183973i0 > 0) {
                    BaseImageUtil.logImage("compress succ with retry : " + imageInfo.f183973i0);
                    o(i3, 8, context, false, null);
                } else {
                    o(i3, 0, context, true, null);
                }
                if (imageInfo.f183973i0 > 0) {
                    z18 = true;
                }
                RichMediaUtil.stopReport("compressPic", z18, "compressPic");
                return true;
            }
        }
        if (i3 == 8) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean d16 = d(i3, context, str, str2, z16, imageInfo, i16, z17);
        if (d16 && !z17) {
            BaseImageUtil.copyExif(str, str2);
        }
        return d16;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static boolean d(int r51, android.content.Context r52, java.lang.String r53, java.lang.String r54, boolean r55, com.tencent.mobileqq.activity.photo.ImageInfo r56, int r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 3843
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.utils.aw.d(int, android.content.Context, java.lang.String, java.lang.String, boolean, com.tencent.mobileqq.activity.photo.ImageInfo, int, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
    
        if (r6 <= 4) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap e(int i3, Context context, File file, int i16, ImageInfo imageInfo) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.Options calculateInSampleSize = BaseImageUtil.calculateInSampleSize(options, file.getPath(), i16);
        if (options.outWidth <= 960 && options.outHeight <= 960) {
            BaseImageUtil.reportSendPhoto(BaseImageUtil.REPORT_SENDPHOTO_NOT_LARGER_960, context, false);
        } else {
            BaseImageUtil.reportSendPhoto(BaseImageUtil.REPORT_SENDPHOTO_NOT_LARGER_960, context, true);
        }
        Bitmap bitmap = null;
        Bitmap bitmap2 = null;
        boolean z16 = false;
        boolean z17 = true;
        while (true) {
            if (bitmap2 == null) {
                int i17 = calculateInSampleSize.inSampleSize;
                if (i17 > 0) {
                }
            }
            if (!z17) {
                bitmap = bitmap2;
                break;
            }
            if (!z17) {
                calculateInSampleSize.inSampleSize *= 2;
            }
            try {
                bitmap2 = SafeBitmapFactory.decodeFile(file.getPath(), calculateInSampleSize);
                z17 = false;
            } catch (OutOfMemoryError unused) {
                BaseImageUtil.logImage("compress : compressNoLargePhoto  getBitmap  OOM " + calculateInSampleSize.inSampleSize);
                int i18 = options.outWidth * options.outHeight;
                if (i18 <= URLDrawableHelper.smallSize && i18 > 0) {
                    ImageTestUtil.dumpFile(((QQAppInterface) ((BaseActivity) context).getAppRuntime()).getCurrentAccountUin());
                }
                if (NetworkUtil.isWifiConnected(context)) {
                    imageInfo.f183965a0 = 1;
                    imageInfo.M = true;
                    if (imageInfo.I == 0) {
                        imageInfo.Y = 2;
                        if (QLog.isColorLevel()) {
                            QLog.d("ImageUtil", 2, "WIFI oom ,c2c send srcfile by raw");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("ImageUtil", 2, "WIFI oom ,not c2c send srcfile by nor");
                    }
                    z16 = true;
                } else {
                    bitmap2 = null;
                    z17 = false;
                    z16 = true;
                }
            }
        }
        if (bitmap == null && z16) {
            imageInfo.M = true;
        }
        return bitmap;
    }

    public static Bitmap f(int i3) {
        if (i3 == 102) {
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            Bitmap f16 = imageCacheHelper.f("static://DefaultDataLineFace");
            if (f16 == null) {
                Bitmap h16 = com.tencent.mobileqq.util.j.h(BaseApplicationImpl.getApplication().getResources(), R.drawable.ogi);
                if (h16 != null) {
                    imageCacheHelper.i("static://DefaultDataLineFace", h16, Business.Conversation);
                    return h16;
                }
                return h16;
            }
            return f16;
        }
        if (i3 == 107) {
            ImageCacheHelper imageCacheHelper2 = ImageCacheHelper.f98636a;
            Bitmap f17 = imageCacheHelper2.f("static://DefaultDataLineFaceIpad");
            if (f17 == null) {
                Bitmap h17 = com.tencent.mobileqq.util.j.h(BaseApplicationImpl.getApplication().getResources(), R.drawable.ogk);
                if (h17 != null) {
                    imageCacheHelper2.i("static://DefaultDataLineFaceIpad", h17, Business.Conversation);
                    return h17;
                }
                return h17;
            }
            return f17;
        }
        if (i3 == 120) {
            ImageCacheHelper imageCacheHelper3 = ImageCacheHelper.f98636a;
            Bitmap f18 = imageCacheHelper3.f("static://DefaultDataLineFacePhone");
            if (f18 == null) {
                Bitmap h18 = com.tencent.mobileqq.util.j.h(BaseApplicationImpl.getApplication().getResources(), R.drawable.ogl);
                if (h18 != null) {
                    imageCacheHelper3.i("static://DefaultDataLineFacePhone", h18, Business.Conversation);
                    return h18;
                }
                return h18;
            }
            return f18;
        }
        return null;
    }

    public static Drawable g(int i3) {
        return new BitmapDrawable(f(i3));
    }

    public static int h(String str) {
        if (com.tencent.mobileqq.activity.photo.incompatiblephoto.b.a(str)) {
            return Utils.getHeifOrientation(str);
        }
        return JpegExifReader.readOrientation(str);
    }

    public static int i(String str) {
        int readOrientation = JpegExifReader.readOrientation(str);
        if (readOrientation == 6) {
            return 1;
        }
        if (readOrientation == 3) {
            return 2;
        }
        if (readOrientation == 8) {
            return 3;
        }
        return 0;
    }

    public static String j(Context context, String str, int i3) {
        return BaseImageUtil.getToSendPicPath(context, str, i3, 0);
    }

    private static boolean k() {
        if ((com.tencent.mobileqq.util.Utils.z() >> 20) < 2) {
            return true;
        }
        return false;
    }

    public static void l(long j3, int i3, int i16, boolean z16, String str, String str2) {
        RichMediaUtil.logUI(i3, z16, i16, String.valueOf(j3), str, str2);
    }

    public static void m(long j3, int i3, boolean z16, String str, String str2) {
        l(j3, i3, 1, z16, str, str2);
    }

    public static void n(ImageInfo imageInfo, String str, String str2) {
        if (imageInfo == null) {
            m(-1L, -1, true, str, "@ImageUtil.log ImageInfo is null@ " + str2);
            return;
        }
        boolean c16 = com.tencent.mobileqq.service.message.remote.a.c(imageInfo.J);
        if (imageInfo.Y == 2) {
            l(imageInfo.f183975k0, imageInfo.I, 131075, c16, str, str2);
        } else {
            m(imageInfo.f183975k0, imageInfo.I, c16, str, str2);
        }
    }

    private static void o(int i3, int i16, Context context, boolean z16, String str) {
        p(i3, i16, context, z16, null, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[Catch: Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:37:0x0014, B:39:0x0018, B:10:0x0027, B:12:0x002f, B:14:0x0042, B:15:0x004e, B:17:0x0052, B:19:0x005a, B:24:0x0079, B:25:0x006b, B:29:0x0088), top: B:36:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void p(int i3, int i16, Context context, boolean z16, String str, String str2) {
        String currentAccountUin;
        String str3;
        String str4;
        ComponentName callingActivity;
        if (i3 >= 0 && i3 <= 7 && i16 >= 0 && i16 <= 9) {
            if (context != null) {
                try {
                    if (context instanceof BaseActivity) {
                        currentAccountUin = ((QQAppInterface) ((BaseActivity) context).getAppRuntime()).getCurrentAccountUin();
                        String str5 = currentAccountUin;
                        HashMap<String, String> hashMap = new HashMap<>();
                        if (!z16) {
                            String valueOf = String.valueOf((i16 * 10) + i3 + 88100);
                            hashMap.put("param_FailCode", valueOf);
                            if (str2 == null) {
                                str4 = ProcessorReport.getExceptionMessage(new RuntimeException(valueOf));
                            } else {
                                str4 = str2;
                            }
                            if ((context instanceof Activity) && (callingActivity = ((Activity) context).getCallingActivity()) != null) {
                                hashMap.put("param_callingActivity", callingActivity.getClassName());
                            }
                            if (i16 == 9 || i16 == 0 || i16 == 5) {
                                hashMap.put("param_sdCardSize", Long.toString(com.tencent.mobileqq.util.Utils.z()));
                            }
                            hashMap.put("param_failMsg", str4);
                        }
                        if (str != null) {
                            str3 = "report_sendphoto_file_error";
                        } else {
                            str3 = str;
                        }
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str5, str3, z16, 0L, 0L, hashMap, "");
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            currentAccountUin = null;
            String str52 = currentAccountUin;
            HashMap<String, String> hashMap2 = new HashMap<>();
            if (!z16) {
            }
            if (str != null) {
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str52, str3, z16, 0L, 0L, hashMap2, "");
        }
    }

    public static boolean q(Context context, String str, int i3, String str2, String str3) {
        if (str2 == null) {
            str2 = BaseImageUtil.TAG_UPLOAD;
        }
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            try {
                if (!FileUtils.fileExists(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.e(str2, 2, str3 + ",filePath not exist,filePath=" + str);
                    }
                    throw new RuntimeException(str3 + " file not exists,path=" + str);
                }
                if (QLog.isColorLevel()) {
                    QLog.e(str2, 2, str3 + ",filePath size is 0,filePath=" + str);
                }
                throw new RuntimeException(str3 + " file size==0,path=" + str);
            } catch (Exception e16) {
                String exceptionMessage = ProcessorReport.getExceptionMessage(e16);
                if (!FileUtils.fileExists(str)) {
                    p(i3, 1, context, false, "report_sendphoto_file_error", exceptionMessage);
                } else {
                    p(i3, 2, context, false, "report_sendphoto_file_error", exceptionMessage);
                }
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(str2, 2, str3 + ",filePath not exist,filePath=" + str);
        }
        o(i3, 0, context, true, "report_sendphoto_file_error");
        return true;
    }

    public static ViewGroup.LayoutParams r(View view) {
        float f16 = view.getContext().getResources().getDisplayMetrics().density / FontSettingManager.systemMetrics.density;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = Math.round(layoutParams2.width / f16);
            layoutParams2.height = Math.round(layoutParams2.height / f16);
            layoutParams2.leftMargin = Math.round(layoutParams2.leftMargin / f16);
            layoutParams2.rightMargin = Math.round(layoutParams2.rightMargin / f16);
            layoutParams2.topMargin = Math.round(layoutParams2.topMargin / f16);
            layoutParams2.bottomMargin = Math.round(layoutParams2.bottomMargin / f16);
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams3.width = Math.round(layoutParams3.width / f16);
            layoutParams3.height = Math.round(layoutParams3.height / f16);
            layoutParams3.leftMargin = Math.round(layoutParams3.leftMargin / f16);
            layoutParams3.rightMargin = Math.round(layoutParams3.rightMargin / f16);
            layoutParams3.topMargin = Math.round(layoutParams3.topMargin / f16);
            layoutParams3.bottomMargin = Math.round(layoutParams3.bottomMargin / f16);
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(ViewUtils.pxTosp(r4.getTextSize()) / f16);
        } else if (view instanceof Button) {
            ((Button) view).setTextSize(ViewUtils.pxTosp(r4.getTextSize()) / f16);
        }
        return layoutParams;
    }

    public static Bitmap s(Bitmap bitmap, File file) {
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float max = BaseImageUtil.MAX_LIMIT / (Math.max(width, height) * 1.0f);
        int exifOrientation = BaseImageUtil.getExifOrientation(file.getPath());
        if (max < 1.0f) {
            try {
                matrix.postScale(max, max);
            } catch (Exception e16) {
                BaseImageUtil.logImage("compress : " + e16.getMessage());
            } catch (OutOfMemoryError unused) {
                BaseImageUtil.logImage("compress :  scaleBitmap OOM");
            }
        }
        if (exifOrientation != 0 && exifOrientation % 90 == 0) {
            matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
        }
        bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (bitmap2 != null) {
            if (!bitmap.isRecycled() && !bitmap.equals(bitmap2)) {
                bitmap.recycle();
            }
            return bitmap2;
        }
        return bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (r12 != 10002) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t(Context context, List<ImageInfo> list, int i3) {
        if (context != null && list != null) {
            boolean z16 = false;
            for (ImageInfo imageInfo : list) {
                if (imageInfo != null && imageInfo.f184139m != null) {
                    File file = new File(imageInfo.f184139m);
                    long c2CPicSizeLimit = ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 1001) {
                                if (i3 != 3000) {
                                }
                            }
                            if (context instanceof BaseActivity) {
                                if (((QQAppInterface) ((BaseActivity) context).getAppRuntime()).isLBSFriendNewClient(imageInfo.C)) {
                                    c2CPicSizeLimit = ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
                                }
                            } else {
                                c2CPicSizeLimit = AppSetting.J;
                            }
                        }
                        c2CPicSizeLimit = ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit();
                    } else {
                        c2CPicSizeLimit = ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
                    }
                    if ((file.length() > c2CPicSizeLimit && !imageInfo.f183979o0) || (imageInfo.M && !NetworkUtil.isWifiConnected(context))) {
                        z16 = true;
                    }
                } else {
                    return;
                }
            }
            if (z16) {
                QQToast.makeText(context, HardCodeUtil.qqStr(R.string.nee), 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        }
    }
}
