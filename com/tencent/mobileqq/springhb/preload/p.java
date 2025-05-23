package com.tencent.mobileqq.springhb.preload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.entry.worker.DemoteLevel;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0029 A[Catch: Exception -> 0x004a, OutOfMemoryError -> 0x0087, TryCatch #3 {Exception -> 0x004a, OutOfMemoryError -> 0x0087, blocks: (B:8:0x0017, B:10:0x001f, B:15:0x0029, B:32:0x0033), top: B:7:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00f2 A[Catch: Exception -> 0x0101, TryCatch #2 {Exception -> 0x0101, blocks: (B:22:0x00e7, B:24:0x00f2, B:25:0x00f5, B:27:0x00fb), top: B:21:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb A[Catch: Exception -> 0x0101, TRY_LEAVE, TryCatch #2 {Exception -> 0x0101, blocks: (B:22:0x00e7, B:24:0x00f2, B:25:0x00f5, B:27:0x00fb), top: B:21:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap c(String str, int i3, int i16, int i17, int i18, boolean z16) {
        File file;
        DemoteLevel c16;
        int i19;
        Bitmap decodeResource;
        Bitmap bitmap = null;
        if (TextUtils.isEmpty(str) && i3 < 0) {
            return null;
        }
        boolean z17 = false;
        boolean z18 = true;
        try {
            c16 = com.tencent.mobileqq.springhb.entry.worker.b.f289157a.c();
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(601, e16, new String[0]);
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpringHb_SpringResBitmapHelper", 2, "decodeBitmap Exception:" + e16.toString() + ",filePath:" + str);
            }
        } catch (OutOfMemoryError e17) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null) {
                ((ISpringHbReportApi) peekAppRuntime2.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(601, e17, i16 + "", str, i3 + "");
            }
            if (QLog.isColorLevel()) {
                QLog.d("SpringHb_SpringResBitmapHelper", 2, "decodeBitmap OOM|path:" + str);
            }
            z18 = false;
            z17 = true;
        }
        if (z16 && c16 != DemoteLevel.LV1) {
            i19 = 2;
            if (i16 != 1) {
                decodeResource = com.tencent.open.base.b.d(str, i17 / i19, i18 / i19, false);
            } else {
                if (i16 == 2) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = i19;
                    decodeResource = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i3, options);
                }
                z18 = false;
                if (bitmap == null && !z17 && !z18) {
                    try {
                        file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("SpringHb_SpringResBitmapHelper", 2, "decodeBitmap| file.delete()");
                        }
                    } catch (Exception unused) {
                    }
                }
                return bitmap;
            }
            bitmap = decodeResource;
            z18 = false;
            if (bitmap == null) {
                file = new File(str);
                if (file.exists()) {
                }
                if (QLog.isColorLevel()) {
                }
            }
            return bitmap;
        }
        i19 = 1;
        if (i16 != 1) {
        }
        bitmap = decodeResource;
        z18 = false;
        if (bitmap == null) {
        }
        return bitmap;
    }

    private static Bitmap d(String str, int i3, int i16, int i17) {
        return e(str, i3, i16, i17, true);
    }

    private static Bitmap e(String str, int i3, int i16, int i17, boolean z16) {
        Bitmap bitmap;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            try {
                bitmap = c(str, -1, 1, i16, i17, z16);
            } catch (Throwable th5) {
                try {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(104, th5, new String[0]);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("SpringHb_SpringResBitmapHelper", 2, "getBitmap, exception=" + th5.getMessage(), th5);
                    }
                    bitmap = null;
                } catch (Exception e16) {
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime2 != null) {
                        ((ISpringHbReportApi) peekAppRuntime2.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(105, e16, new String[0]);
                    }
                    if (!QLog.isColorLevel()) {
                        return null;
                    }
                    QLog.d("SpringHb_SpringResBitmapHelper", 2, "getBitmap error ", e16);
                    return null;
                }
            }
            return bitmap;
        }
        return g(i3, i16, i17, z16);
    }

    public static Bitmap f(final String str, final int i3, SpringRes.b bVar, final int i16, final int i17) {
        final WeakReference weakReference;
        boolean z16;
        String n3 = com.tencent.mobileqq.qwallet.preload.a.n(str);
        if (!TextUtils.isEmpty(n3) && new File(n3).exists()) {
            z16 = true;
        } else {
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.filePos = 0;
            downloadParam.url = str;
            if (bVar == null) {
                weakReference = null;
            } else {
                weakReference = new WeakReference(bVar);
            }
            com.tencent.mobileqq.qwallet.preload.a.h().getResPath(downloadParam, new IPreloadService.c() { // from class: com.tencent.mobileqq.springhb.preload.n
                @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
                public final void onResult(int i18, IPreloadService.PathResult pathResult) {
                    p.i(i3, i16, i17, weakReference, str, i18, pathResult);
                }
            });
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringResBitmapHelper", 2, "getPreloadBitmap end defaultResName[" + i3 + "], hasFile=" + z16 + " path=" + n3);
        }
        if (!z16) {
            n3 = "";
        }
        return d(n3, i3, i16, i17);
    }

    private static Bitmap g(int i3, int i16, int i17, boolean z16) {
        if (i3 < 0) {
            return null;
        }
        try {
            return c("", i3, 2, i16, i17, z16);
        } catch (Exception e16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(107, e16, new String[0]);
            }
            QLog.e("SpringHb_SpringResBitmapHelper", 2, "getDefaultIconBitmap error", e16);
            return null;
        } catch (OutOfMemoryError e17) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null) {
                ((ISpringHbReportApi) peekAppRuntime2.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(106, e17, String.valueOf(i3));
            }
            QLog.e("SpringHb_SpringResBitmapHelper", 2, "getDefaultIconBitmap error", e17);
            return null;
        }
    }

    public static Bitmap h(String str, int i3, int i16, int i17, boolean z16) {
        return e(str, i3, i16, i17, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(int i3, int i16, int i17, WeakReference weakReference, String str, int i18, IPreloadService.PathResult pathResult) {
        boolean z16;
        boolean z17;
        Bitmap bitmap;
        boolean z18 = true;
        if (i18 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (pathResult != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((z16 & z17) && !StringUtil.isEmpty(pathResult.filePath)) {
            bitmap = d(pathResult.filePath, i3, i16, i17);
        } else {
            bitmap = null;
            z18 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SpringHb_SpringResBitmapHelper", 2, "getPreloadBitmap defaultResName=[" + i3 + "] onResult=" + i18 + " " + pathResult);
        }
        k(weakReference, z18, str, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(WeakReference weakReference, boolean z16, String str, Object obj) {
        SpringRes.b bVar;
        if (weakReference != null) {
            try {
                bVar = (SpringRes.b) weakReference.get();
            } catch (Exception e16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(110, e16, new String[0]);
                }
                QLog.e("SpringHb_SpringResBitmapHelper", 1, e16.getMessage(), e16);
                return;
            }
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a(z16, str, obj);
        }
    }

    public static void k(final WeakReference<SpringRes.b> weakReference, final boolean z16, final String str, final Object obj) {
        QLog.i("SpringHb_SpringResBitmapHelper", 1, "notifyDownloadCallback suc=" + z16 + ", url=" + str + ", result=" + obj);
        if (weakReference != null && weakReference.get() != null) {
            ThreadManager.getUIHandler().postAtTime(new Runnable() { // from class: com.tencent.mobileqq.springhb.preload.o
                @Override // java.lang.Runnable
                public final void run() {
                    p.j(WeakReference.this, z16, str, obj);
                }
            }, SystemClock.uptimeMillis());
        }
    }
}
