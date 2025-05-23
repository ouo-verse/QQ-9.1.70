package com.tencent.mobileqq.filemanageraux.link;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class b {
    static IPatchRedirector $redirector_;

    public static long a(int i3) {
        long j3;
        if (i3 != 1 && i3 != 2) {
            return -1L;
        }
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        if (i3 == 1) {
            j3 = 604800000;
        } else {
            j3 = 2592000000L;
        }
        return serverTime + j3;
    }

    public static Bitmap b(String str, int i3) {
        int i16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitMatrix o16 = h.o(str, -1);
        if (o16 == null) {
            QLog.w("LinkUtils<FileAssistant>", 2, "getQrCode4Weiyun: encode failed.");
            return null;
        }
        int width = o16.getWidth();
        int height = o16.getHeight();
        int[] iArr = new int[width * height];
        for (int i17 = 0; i17 < height; i17++) {
            int i18 = i17 * width;
            for (int i19 = 0; i19 < width; i19++) {
                int i26 = i18 + i19;
                if (o16.get(i19, i17)) {
                    i16 = -16777216;
                } else {
                    i16 = 16777215;
                }
                iArr[i26] = i16;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        if (width != i3 || height != i3) {
            Bitmap createBitmap2 = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap2).drawBitmap(createBitmap, new Rect(0, 0, width, height), new Rect(0, 0, i3, i3), (Paint) null);
            createBitmap.recycle();
            createBitmap = createBitmap2;
        }
        Bitmap g16 = j.g(BaseApplicationImpl.sApplication.getResources(), R.drawable.bh_);
        if (g16 != null) {
            int width2 = g16.getWidth();
            int height2 = g16.getHeight();
            Canvas canvas = new Canvas(createBitmap);
            int width3 = canvas.getWidth();
            int height3 = canvas.getHeight();
            canvas.drawBitmap(g16, new Rect(0, 0, width2, height2), new Rect((width3 - width2) / 2, (height3 - height2) / 2, (width3 + width2) / 2, (height3 + height2) / 2), (Paint) null);
            g16.recycle();
        }
        return createBitmap;
    }

    public static String c(int i3) {
        if (i3 <= 0) {
            return "";
        }
        Random random = new Random();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return sb5.toString();
    }

    public static String d(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        String j3 = q.j(str);
        if (!".doc".equalsIgnoreCase(j3) && !".docx".equalsIgnoreCase(j3)) {
            if (!".xls".equalsIgnoreCase(j3) && !".xlsx".equalsIgnoreCase(j3)) {
                if (!".ppt".equalsIgnoreCase(j3) && !".pptx".equalsIgnoreCase(j3)) {
                    if (".pdf".equalsIgnoreCase(j3)) {
                        return "4";
                    }
                    if (".txt".equalsIgnoreCase(j3)) {
                        return "5";
                    }
                    if (!".zip".equalsIgnoreCase(j3) && !".rar".equalsIgnoreCase(j3)) {
                        return "7";
                    }
                    return "6";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public static String f(boolean z16) {
        if (z16) {
            return "1";
        }
        return "2";
    }

    public static String g(int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 9) {
                    if (i3 != 10) {
                        if (i3 != 39) {
                            return "";
                        }
                        return "5";
                    }
                    return "4";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    public static boolean h(FileManagerEntity fileManagerEntity, boolean z16) {
        if (z16) {
            return true;
        }
        if (fileManagerEntity == null) {
            return false;
        }
        int fileSrcCloudType = FileManagerUtil.getFileSrcCloudType(fileManagerEntity);
        if (fileSrcCloudType == 2) {
            return !TextUtils.isEmpty(fileManagerEntity.WeiYunFileId);
        }
        if (fileSrcCloudType == 1) {
            if (!TextUtils.isEmpty(fileManagerEntity.Uuid) && !TextUtils.isEmpty(fileManagerEntity.peerUin)) {
                return true;
            }
            return false;
        }
        if (fileSrcCloudType == 4) {
            AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
            if (runtime instanceof QQAppInterface) {
                try {
                    t n3 = TroopFileUtils.n((QQAppInterface) runtime, fileManagerEntity);
                    if (n3 != null) {
                        if (!TextUtils.isEmpty(n3.f294985s)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th5) {
                    QLog.e("LinkUtils<FileAssistant>", 2, "isSupportedShareByWeiyun error", th5);
                }
            }
        }
        return false;
    }

    public static void i(String str, String str2, String str3) {
        String str4;
        String str5;
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if (str3 == null) {
            str5 = "";
        } else {
            str5 = str3;
        }
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, str4, str5, "", "");
    }

    public static void j(int i3, int i16, boolean z16) {
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        QQToast.makeText(baseApplicationImpl, i3, baseApplicationImpl.getResources().getString(i16), z16 ? 1 : 0).show(baseApplicationImpl.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static void k(int i3, String str, boolean z16) {
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        QQToast.makeText(baseApplicationImpl, i3, str, z16 ? 1 : 0).show(baseApplicationImpl.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
