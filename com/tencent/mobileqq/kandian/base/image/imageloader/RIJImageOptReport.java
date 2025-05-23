package com.tencent.mobileqq.kandian.base.image.imageloader;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RIJImageOptReport {

    /* renamed from: a, reason: collision with root package name */
    public static int f239044a;

    /* renamed from: b, reason: collision with root package name */
    public static long f239045b;

    /* renamed from: c, reason: collision with root package name */
    public static long f239046c;

    /* renamed from: d, reason: collision with root package name */
    public static long f239047d;

    /* renamed from: e, reason: collision with root package name */
    public static long f239048e;

    /* renamed from: f, reason: collision with root package name */
    public static long f239049f;

    /* renamed from: g, reason: collision with root package name */
    public static long f239050g;

    /* renamed from: h, reason: collision with root package name */
    public static IRIJImageOptReport f239051h;

    private static int c(String str) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        if (argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY) != null) {
            try {
                return Integer.parseInt(argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY));
            } catch (NumberFormatException e16) {
                QLog.e("RIJImageOptReport", 2, "urlString: " + str + "  busiType:" + argumentsFromURL.get(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY), e16);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(com.tencent.mobileqq.kandian.base.image.b bVar) {
        if (!((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).isReportOn() || bVar == null || bVar.f239011h == 0) {
            return false;
        }
        return true;
    }

    public static void e(int i3, com.tencent.mobileqq.kandian.base.image.b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.f239019p = i3;
    }

    public static void f(int i3, com.tencent.mobileqq.kandian.base.image.b bVar) {
        if (bVar != null) {
            if (i3 == 1) {
                bVar.f239011h = System.currentTimeMillis();
                return;
            }
            if (bVar.f239011h != 0) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 6) {
                                    QLog.d("RIJImageOptReport", 1, "unknown type: " + i3 + " " + bVar);
                                    return;
                                }
                                bVar.f239018o = System.currentTimeMillis();
                                return;
                            }
                            bVar.f239017n = System.currentTimeMillis();
                            return;
                        }
                        bVar.f239014k = System.currentTimeMillis();
                        return;
                    }
                    bVar.f239013j = System.currentTimeMillis();
                    return;
                }
                bVar.f239012i = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(com.tencent.mobileqq.kandian.base.image.b bVar) {
        long j3;
        String str;
        boolean z16;
        long j16 = bVar.f239013j;
        long j17 = j16 - bVar.f239012i;
        long j18 = bVar.f239014k - j16;
        long j19 = bVar.f239015l;
        long j26 = bVar.f239016m;
        long j27 = bVar.f239017n;
        if (j27 > 0) {
            j3 = bVar.f239018o - j27;
        } else {
            j3 = 0;
        }
        long j28 = bVar.f239018o - bVar.f239011h;
        int i3 = bVar.f239019p;
        int i16 = bVar.f239020q;
        long j29 = bVar.f239023t;
        URL url = bVar.f239004a;
        if (url == null) {
            str = "";
        } else {
            str = url.toString();
        }
        int c16 = c(str);
        String str2 = str;
        String str3 = bVar.f239022s;
        String str4 = bVar.f239021r;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("subThreadWaitTime", j17 + "");
        hashMap.put("threadPoolWaitTime", j18 + "");
        hashMap.put("threadWaitTime", (j17 + j18) + "");
        hashMap.put("downloadAndWriteFileTime", j19 + "");
        hashMap.put("decodeTime", j26 + "");
        hashMap.put("mainThreadWaitTime", j3 + "");
        hashMap.put("cacheType", i3 + "");
        hashMap.put("errMsg", str4);
        hashMap.put("contentType", str3);
        hashMap.put("fileSize", Long.valueOf(j29));
        hashMap.put("urlStr", str2);
        hashMap.put(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, Integer.valueOf(c16));
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        if (activeNetIpFamily != 2 && activeNetIpFamily != 3) {
            z16 = false;
        } else {
            z16 = true;
        }
        hashMap.put("ipv6", Boolean.valueOf(z16));
        IRIJImageOptReport iRIJImageOptReport = f239051h;
        if (iRIJImageOptReport != null) {
            iRIJImageOptReport.reportQualityDataDimension(i16, 6, j28, hashMap);
        }
        if (QLog.isColorLevel()) {
            int i17 = f239044a + 1;
            f239044a = i17;
            f239045b += j28;
            f239046c += j18;
            f239047d += j3;
            f239048e += j19;
            f239049f += j26;
            f239050g += j29;
            if (i17 == 100) {
                QLog.d("RIJImageOptReport", 2, "average  total: " + (((float) f239045b) / f239044a) + " size: " + (f239050g / f239044a) + " threapool: " + (((float) f239046c) / f239044a) + " mainthread: " + (((float) f239047d) / f239044a) + " downloadAndWriteFileTime: " + (((float) f239048e) / f239044a) + " decodeTime: " + (((float) f239049f) / f239044a));
                f239044a = 0;
                f239045b = 0L;
                f239046c = 0L;
                f239047d = 0L;
                f239048e = 0L;
                f239049f = 0L;
                f239050g = 0L;
            }
        }
    }

    public static void h(final com.tencent.mobileqq.kandian.base.image.b bVar, boolean z16, final String str) {
        f(6, bVar);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport.1
            @Override // java.lang.Runnable
            public void run() {
                if (RIJImageOptReport.d(com.tencent.mobileqq.kandian.base.image.b.this)) {
                    com.tencent.mobileqq.kandian.base.image.b bVar2 = com.tencent.mobileqq.kandian.base.image.b.this;
                    bVar2.f239021r = str;
                    RIJImageOptReport.g(bVar2);
                }
            }
        });
    }

    public static void i(com.tencent.mobileqq.kandian.base.image.b bVar) {
        IRIJImageOptReport iRIJImageOptReport = f239051h;
        if (iRIJImageOptReport != null) {
            iRIJImageOptReport.reportSlowImageRequest(bVar);
        }
    }
}
