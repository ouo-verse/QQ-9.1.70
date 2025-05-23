package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troopshare.e;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {
    public static Bitmap b(Window window, Bitmap bitmap) {
        try {
            if (ImmersiveUtils.isSupporImmersive() == 1 && (window.getAttributes().flags & 1024) != 1024) {
                int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
                return Bitmap.createBitmap(bitmap, 0, statusBarHeight, bitmap.getWidth(), bitmap.getHeight() - statusBarHeight, (Matrix) null, false);
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), (Matrix) null, false);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static String c(Bitmap bitmap, String str) {
        String str2;
        str2 = "";
        String str3 = AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS;
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(str3));
        if (!file.exists()) {
            file.mkdirs();
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str3 + str + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis())) + ".png");
        File file2 = new File(sDKPrivatePath);
        if (file2.exists()) {
            return sDKPrivatePath;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    str2 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2) ? sDKPrivatePath : "";
                    IOUtils.closeQuietly(fileOutputStream2);
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    IOUtils.closeQuietly(fileOutputStream);
                    return str2;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x02d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<String, Bitmap> a(String str, int i3, String str2, String str3) {
        String str4;
        String str5;
        Bitmap bitmap;
        Bitmap bitmap2;
        String str6;
        Bitmap bitmap3;
        String str7;
        String str8;
        if (QLog.isDevelopLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->begin time:" + System.currentTimeMillis());
        }
        try {
            Resources resources = BaseApplication.getContext().getResources();
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            int f16 = BaseAIOUtils.f(0.5f, resources);
            int f17 = BaseAIOUtils.f(90.0f, resources);
            int max = Math.max(i3, width);
            int i16 = f16 + height;
            int i17 = f17 + i16;
            Bitmap createBitmap = Bitmap.createBitmap(max, i17, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            if (i3 > width) {
                str4 = "";
                try {
                    paint.setColor(Color.parseColor("#f7f7f9"));
                    bitmap2 = createBitmap;
                    canvas.drawRect(0.0f, 0.0f, i3, height, paint);
                } catch (Exception | OutOfMemoryError unused) {
                    str5 = str4;
                    bitmap = null;
                    if (QLog.isDevelopLevel()) {
                    }
                    return new Pair<>(str5, bitmap);
                }
            } else {
                str4 = "";
                bitmap2 = createBitmap;
            }
            if (width < i3) {
                str6 = "http://";
                canvas.drawBitmap(decodeFile, new Rect(0, 0, width, height), new Rect((i3 - width) / 2, 0, (i3 + width) / 2, height), paint);
            } else {
                canvas.drawBitmap(decodeFile, 0.0f, 0.0f, paint);
                str6 = "http://";
            }
            paint.setColor(Color.parseColor("#DEDFE0"));
            float f18 = max;
            float f19 = i16;
            canvas.drawRect(0.0f, height, f18, f19, paint);
            paint.setColor(-1);
            canvas.drawRect(0.0f, f19, f18, i17, paint);
            paint.setColor(-16777216);
            paint.setTextSize(l.X(2, 18, resources));
            canvas.drawText("QQ\u770b\u70b9", BaseAIOUtils.f(60.0f, resources), BaseAIOUtils.f(42.0f, resources) + i16, paint);
            paint.setColor(Color.parseColor("#777777"));
            paint.setTextSize(l.X(2, 14, resources));
            canvas.drawText(resources.getString(R.string.d6x), BaseAIOUtils.f(60.0f, resources), BaseAIOUtils.f(61.0f, resources) + i16, paint);
            String str9 = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=" + URLEncoder.encode(str2, "UTF-8");
            HashMap hashMap = new HashMap();
            hashMap.put("url", str9);
            String str10 = HttpUtil.shortenUrlBatch(hashMap).get("url");
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->shortenUrl:" + str10);
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            if (!TextUtils.isEmpty(str10) && str10.length() < str9.length()) {
                hashMap2.put("param_errorCode", "0");
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.READINJOY_SHORTEN_URL, true, 0L, 0L, hashMap2, "");
                try {
                    str7 = Uri.parse(str2).getQueryParameter("_wv");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    str7 = str4;
                }
                String str11 = str7 == null ? str4 : str7;
                try {
                    str8 = Uri.parse(str10).getQueryParameter("_wv");
                } catch (Exception e17) {
                    e17.printStackTrace();
                    str8 = str4;
                }
                if (str8 == null) {
                    str8 = str4;
                }
                if (!TextUtils.isEmpty(str11) && TextUtils.isEmpty(str8)) {
                    if (str10.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str10 = str10 + "&_wv=" + str11;
                    } else {
                        str10 = str10 + "?_wv=" + str11;
                    }
                }
                String str12 = str6;
                if (str10.startsWith(str12)) {
                    str10 = str10.replaceFirst(str12, "https://");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->use new qrCode:" + str10);
                }
                bitmap3 = e.C(str10, resources, BaseAIOUtils.f(80.0f, resources), 0, false);
            } else {
                if (TextUtils.isEmpty(str10)) {
                    hashMap2.put("param_errorCode", "1");
                } else if (str10.equals(str9)) {
                    hashMap2.put("param_errorCode", "2");
                } else if (str10.length() >= str9.length()) {
                    hashMap2.put("param_errorCode", "3");
                }
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), StatisticCollector.READINJOY_SHORTEN_URL, false, 0L, 0L, hashMap2, "");
                bitmap3 = null;
            }
            canvas.drawBitmap(bitmap3, (max - BaseAIOUtils.f(5.0f, resources)) - bitmap3.getWidth(), i16 + BaseAIOUtils.f(5.0f, resources), paint);
            Bitmap bitmap4 = bitmap2;
            str5 = c(bitmap4, str3);
            bitmap = bitmap4;
        } catch (Exception | OutOfMemoryError unused2) {
            str4 = "";
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ScreenShotImageUtil", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
        }
        return new Pair<>(str5, bitmap);
    }
}
