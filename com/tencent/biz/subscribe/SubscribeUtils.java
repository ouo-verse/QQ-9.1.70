package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeUtils {
    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        View view = new View(activity);
        view.setBackgroundColor(1711276032);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static String b(int i3) {
        return c(i3);
    }

    public static String c(long j3) {
        if (j3 >= 10000) {
            return new DecimalFormat(".#").format(j3 / 10000.0d) + "w";
        }
        if (j3 >= 1000) {
            return new DecimalFormat(".#").format(j3 / 1000.0d) + "k";
        }
        return String.valueOf(j3);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0034: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:53), block:B:43:0x0034 */
    public static String d(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String encodeToString;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                } catch (Exception e16) {
                    e = e16;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        return null;
                    } catch (IOException e19) {
                        e19.printStackTrace();
                        return null;
                    }
                }
            } else {
                encodeToString = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            return encodeToString;
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    public static Bitmap e(String str, int i3, int i16, int i17, Bitmap.Config config) {
        if (TextUtils.isEmpty(str) || i3 < 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hashMap.put(EncodeHintType.MARGIN, 2);
            hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            BitMatrix encode = new QRCodeWriter().encode(str, i3, i3, hashMap);
            if (encode == null) {
                return null;
            }
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i18 = 0; i18 < height; i18++) {
                for (int i19 = 0; i19 < width; i19++) {
                    if (encode.get(i19, i18)) {
                        iArr[(i18 * width) + i19] = i16;
                    } else {
                        iArr[(i18 * width) + i19] = i17;
                    }
                }
            }
            return Bitmap.createBitmap(iArr, width, height, config);
        } catch (WriterException e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e("SubscribeUtils", 4, "oom when create qr bitmap", e17);
            return null;
        }
    }

    public static CertifiedAccountMeta$StFeed f(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed2 = new CertifiedAccountMeta$StFeed();
        if (certifiedAccountMeta$StFeed == null) {
            return certifiedAccountMeta$StFeed2;
        }
        try {
            certifiedAccountMeta$StFeed2.mergeFrom(certifiedAccountMeta$StFeed.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountMeta$StFeed2;
    }

    public static void g(File file, String str) {
        h(file, str, b.f95695c);
    }

    public static void h(File file, final String str, final String str2) {
        try {
            final File file2 = new File(file.getPath() + ".zip");
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.biz.subscribe.SubscribeUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = str;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = file2.getPath();
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    QQStoryContext.h();
                    ((IHttpEngineService) QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    QLog.i("DownLoadZipFile", 1, "startDownloadZipFile, url: " + str);
                }

                /* compiled from: P */
                /* renamed from: com.tencent.biz.subscribe.SubscribeUtils$1$a */
                /* loaded from: classes5.dex */
                class a implements INetEngineListener {
                    a() {
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onResp(NetResp netResp) {
                        QLog.i("DownLoadZipFile", 1, "download  onResp url:  resultcode: " + netResp.mHttpCode);
                        try {
                            QLog.d("DownLoadZipFile", 4, "start unzip file to folderPath:" + str2);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            ZipUtils.unZipFile(file2, str2);
                        } catch (Exception e16) {
                            QLog.i("DownLoadZipFile", 1, "unzip file failed" + e16);
                        }
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                    }
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String i(long j3) {
        Date date;
        Object valueOf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5");
        if (j3 == 0) {
            date = new Date();
        } else {
            date = new Date(j3);
        }
        String format = simpleDateFormat.format(date);
        Time time = new Time();
        time.set(j3);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        int i3 = time2.yearDay;
        int i16 = i3 - 1;
        if (time.year == time2.year) {
            int i17 = time.yearDay;
            if (i3 < i17) {
                return format;
            }
            if (i3 == i17) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(time.hour);
                sb5.append(":");
                int i18 = time.minute;
                if (i18 < 10) {
                    valueOf = "0" + time.minute;
                } else {
                    valueOf = Integer.valueOf(i18);
                }
                sb5.append(valueOf);
                return sb5.toString();
            }
            if (i17 == i16) {
                return BaseApplicationImpl.getApplication().getString(R.string.ihd);
            }
            return (time.month + 1) + BaseApplicationImpl.getApplication().getString(R.string.cae) + time.monthDay + BaseApplicationImpl.getApplication().getString(R.string.aiu);
        }
        return format;
    }

    public static String j() {
        return b.b("certified_account_download_pics");
    }

    public static boolean k(long j3, int i3) {
        if ((j3 & (1 << i3)) > 0) {
            return true;
        }
        return false;
    }

    public static boolean l(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed.poster.followState.get() == 1) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        boolean z16;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            z16 = ThemeUtil.isInNightMode((QQAppInterface) runtime);
        } else {
            z16 = false;
        }
        if (runtime instanceof ToolAppRuntime) {
            return ThemeUtil.isInNightMode(runtime);
        }
        return z16;
    }

    public static boolean n(long j3) {
        return k(j3, 4);
    }

    public static boolean o(long j3) {
        return k(j3, 1);
    }

    public static boolean p(long j3) {
        if (o(j3) && n(j3)) {
            return true;
        }
        return false;
    }

    public static boolean q(long j3) {
        return k(j3, 5);
    }

    public static boolean r(int i3) {
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    public static void s(final String str) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.SubscribeUtils.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    URL url = new URL(str);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    hd0.c.k("SubscribeUtils", "report rspCode " + responseCode + "\uff0c request thirdparty" + z16 + " url =" + url);
                } catch (Exception e16) {
                    hd0.c.k("SubscribeUtils", "report exception" + e16.toString());
                    if (QZLog.isColorLevel()) {
                        QZLog.w("SubscribeUtils", 2, e16.toString());
                    }
                }
            }
        }, 0L);
    }
}
