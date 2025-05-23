package com.tencent.biz.qrcode.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.config.business.bb;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.qrscan.m;
import com.tencent.mobileqq.qrscan.o;
import com.tencent.mobileqq.qrscan.p;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.BaseQRUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.ThemeImageView;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends BaseQRUtil {

    /* renamed from: a, reason: collision with root package name */
    protected static String f95061a = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";

    /* renamed from: b, reason: collision with root package name */
    private static String f95062b = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";

    /* renamed from: c, reason: collision with root package name */
    private static String f95063c = "^https?://url\\.cn/.+#flyticket";

    /* renamed from: d, reason: collision with root package name */
    protected static String f95064d = ".*(\\+86|086)?\\d{5,12}.*";

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends o {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f95065d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ p f95066e;

        a(int i3, p pVar) {
            this.f95065d = i3;
            this.f95066e = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        @Override // com.tencent.mobileqq.qrscan.o, mqq.observer.BusinessObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            JSONObject jSONObject;
            if (z16 && bundle != null) {
                try {
                    jSONObject = new JSONObject(bundle.getString("result"));
                } catch (Exception unused) {
                }
                if (jSONObject.getInt("r") == 0) {
                    str = jSONObject.getString("url");
                    if (str != null) {
                        URLUtil.addParameter(str, "personal_qrcode_source", String.valueOf(this.f95065d));
                        this.f95066e.a(true, str);
                        return;
                    }
                }
                str = null;
                if (str != null) {
                }
            }
            this.f95066e.a(false, null);
        }
    }

    public static boolean A(String str) {
        if (str == null) {
            return false;
        }
        if (!Pattern.matches(f95062b, str) && !Pattern.matches(f95063c, str)) {
            return false;
        }
        return true;
    }

    public static boolean B() {
        boolean z16;
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        String lowerCase2 = DeviceInfoMonitor.getModel().toLowerCase();
        if ("meizu".equals(lowerCase) && !TextUtils.isEmpty(lowerCase2) && lowerCase2.contains("pro 6 plus")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QRUtils", 2, "isMeizuRubbishDevices device: " + lowerCase + "   model:" + lowerCase2 + "  return:" + z16);
        }
        return z16;
    }

    public static boolean C(String str) {
        return Pattern.matches(f95064d, str);
    }

    public static boolean D(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://qpay.qq.com/qr/") && !str.startsWith("https://qpay.qq.com/qr/")) {
            return false;
        }
        return true;
    }

    public static boolean E(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.matches(f95061a, str);
    }

    public static boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://vac.qq.com/wallet/qrcode.htm") && !str.startsWith("https://vac.qq.com/wallet/qrcode.htm") && !str.startsWith("https://i.qianbao.qq.com/wallet/sqrcode.htm")) {
            return false;
        }
        return true;
    }

    public static boolean G(String str) {
        if (K(str) && (str.contains("ti.qq.com/open_qq") || str.contains("ti.qq.com/new_open_qq"))) {
            return true;
        }
        return false;
    }

    public static boolean H(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("mqqapi://about") && !str.startsWith("mqqapi://onlinestatus") && !str.startsWith(ISchemeApi.SCHEME_ENTER_AVATAR)) {
            return false;
        }
        return true;
    }

    public static boolean I(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.matches(f95063c, str);
    }

    public static boolean J(String str) {
        if (K(str) && (str.startsWith("http:") || str.startsWith("https:") || str.startsWith("www."))) {
            return true;
        }
        return false;
    }

    public static boolean K(String str) {
        if (str == null) {
            return false;
        }
        return android.webkit.URLUtil.isValidUrl(str);
    }

    public static boolean L(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d91.g arkPlatformConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkPlatformConfig();
        if (arkPlatformConfig != null && arkPlatformConfig.c() != null) {
            z16 = arkPlatformConfig.c().f395978h;
        } else {
            z16 = true;
        }
        QLog.d("ScannerUtils", 1, "useNewRule : ", Boolean.valueOf(z16));
        if (z16) {
            return util.isWtLoginUrlV2(str);
        }
        return util.isWtLoginUrlV1(str);
    }

    public static byte[] M(long j3) {
        return new byte[]{(byte) (j3 >>> 56), (byte) (j3 >>> 48), (byte) (j3 >>> 40), (byte) (j3 >>> 32), (byte) (j3 >>> 24), (byte) (j3 >>> 16), (byte) (j3 >>> 8), (byte) j3};
    }

    protected static int N(int i3) {
        if (i3 < 21) {
            return 1;
        }
        if (i3 > 177) {
            return 39;
        }
        return ((i3 - 21) / 4) + 1;
    }

    public static boolean O(QQAppInterface qQAppInterface, int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putInt("my_qr_code_cfg_sp_index", i3);
        if (QLog.isColorLevel()) {
            QLog.i("QRUtils", 2, "saveMyQrBgIndex2Sp().index:" + i3);
        }
        return edit.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.graphics.Bitmap] */
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String P(Context context, String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (bitmap != 0 && !bitmap.isRecycled()) {
            File file = new File(VFSAssistantUtils.getSDKPrivatePath("cache/"));
            file.mkdirs();
            if (file.canWrite()) {
                ?? file2 = new File(file.getAbsolutePath(), str);
                String absolutePath = file2.getAbsolutePath();
                ?? exists = file2.exists();
                if (exists != 0) {
                    file2.delete();
                }
                try {
                    try {
                        try {
                            fileOutputStream = new FileOutputStream((File) file2);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                            } catch (FileNotFoundException e16) {
                                e = e16;
                                bufferedOutputStream = null;
                            } catch (IOException e17) {
                                e = e17;
                                bufferedOutputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                                file2 = 0;
                                exists = fileOutputStream;
                                th = th;
                                if (file2 != 0) {
                                }
                                if (exists == 0) {
                                }
                            }
                        } catch (FileNotFoundException e18) {
                            e = e18;
                            fileOutputStream = null;
                            bufferedOutputStream = null;
                        } catch (IOException e19) {
                            e = e19;
                            fileOutputStream = null;
                            bufferedOutputStream = null;
                        } catch (Throwable th6) {
                            th = th6;
                            exists = 0;
                            file2 = 0;
                        }
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                            bufferedOutputStream.flush();
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                            return absolutePath;
                        } catch (FileNotFoundException e27) {
                            e = e27;
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return null;
                        } catch (IOException e28) {
                            e = e28;
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return null;
                        }
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                } catch (Throwable th7) {
                    th = th7;
                    if (file2 != 0) {
                        try {
                            file2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (exists == 0) {
                        try {
                            exists.close();
                            throw th;
                        } catch (IOException e36) {
                            e36.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    public static boolean Q(QQAppInterface qQAppInterface, int i3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).edit();
        edit.putInt("troop_qr_code_cfg_sp_index", i3);
        if (QLog.isColorLevel()) {
            QLog.i("QRUtils", 2, "saveTroopQrBgIndex2Sp().index:" + i3);
        }
        return edit.commit();
    }

    public static boolean R(QQAppInterface qQAppInterface, String str, int i3) {
        if (qQAppInterface == null || !QVipQidProcessor.get().isQidProfileEnable()) {
            return false;
        }
        SharedPreferences.Editor edit = qQAppInterface.getApp().getSharedPreferences("sp_vip_qid_info", 0).edit();
        edit.putInt("user_qr_card_type" + str, i3);
        return edit.commit();
    }

    public static Bitmap S(View view) {
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        view.clearFocus();
        view.setPressed(false);
        try {
            view.layout(0, 0, view.getWidth(), view.getHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            bitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.destroyDrawingCache();
            return bitmap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return bitmap;
        }
    }

    public static void T(int i3, int i16) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, i3, i16, 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public static void a(View view) {
        View findViewById;
        View findViewById2;
        if (view == null || !SimpleModeHelper.A() || (findViewById = view.findViewById(R.id.f653938t)) == null || (findViewById2 = findViewById.findViewById(R.id.f650037r)) == null) {
            return;
        }
        findViewById2.setBackgroundResource(R.drawable.kbc);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.f61902zd);
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(R.drawable.f161851kv0);
        TextView textView = (TextView) findViewById.findViewById(R.id.f649737o);
        if (textView == null) {
            return;
        }
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.f649837p);
        if (textView2 == null) {
            return;
        }
        textView2.setTextColor(Color.parseColor("#ff999999"));
        TextView textView3 = (TextView) findViewById.findViewById(R.id.f649937q);
        if (textView3 == null) {
            return;
        }
        textView3.setTextColor(Color.parseColor("#ff999999"));
        TextView textView4 = (TextView) view.findViewById(R.id.vu8);
        if (textView4 == null) {
            return;
        }
        textView4.setBackgroundResource(R.drawable.kbi);
        textView4.setTextColor(Color.parseColor("#ff999999"));
    }

    public static void b(View view, View view2, View view3) {
        int i3;
        int i16;
        if (view != null && view2 != null && view3 != null) {
            TextView textView = (TextView) view.findViewById(R.id.f6511382);
            TextView textView2 = (TextView) view2.findViewById(R.id.h1q);
            TextView textView3 = (TextView) view3.findViewById(R.id.f653738r);
            if (textView != null && textView2 != null && textView3 != null) {
                ThemeImageView themeImageView = (ThemeImageView) view.findViewById(R.id.f6509380);
                ThemeImageView themeImageView2 = (ThemeImageView) view2.findViewById(R.id.h1o);
                ThemeImageView themeImageView3 = (ThemeImageView) view3.findViewById(R.id.f653538p);
                if (themeImageView != null && themeImageView2 != null && themeImageView3 != null) {
                    themeImageView.setSupportMaskView(false);
                    themeImageView2.setSupportMaskView(false);
                    themeImageView3.setSupportMaskView(false);
                    if (QQTheme.isNowThemeIsNight()) {
                        i3 = -1;
                        i16 = R.drawable.f161707kp1;
                    } else {
                        i3 = -16777216;
                        i16 = R.drawable.aay;
                    }
                    themeImageView.setColorFilter(i3);
                    themeImageView2.setColorFilter(i3);
                    themeImageView3.setColorFilter(i3);
                    view.setBackgroundResource(i16);
                    view2.setBackgroundResource(i16);
                    view3.setBackgroundResource(i16);
                    textView.setTextColor(i3);
                    textView2.setTextColor(i3);
                    textView3.setTextColor(i3);
                }
            }
        }
    }

    public static void c(View view) {
        View findViewById;
        View findViewById2;
        if (view == null || !SimpleModeHelper.A() || (findViewById = view.findViewById(R.id.f653238m)) == null || (findViewById2 = findViewById.findViewById(R.id.f650137s)) == null) {
            return;
        }
        findViewById2.setBackgroundResource(R.drawable.kbc);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.f61902zd);
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(R.drawable.f161851kv0);
        TextView textView = (TextView) findViewById.findViewById(R.id.f109536g3);
        if (textView == null) {
            return;
        }
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.kbr);
        if (textView2 == null) {
            return;
        }
        textView2.setTextColor(Color.parseColor("#ff999999"));
        TextView textView3 = (TextView) findViewById.findViewById(R.id.f112166n7);
        if (textView3 == null) {
            return;
        }
        textView3.setTextColor(Color.parseColor("#ff999999"));
    }

    public static void d(View view, View view2, View view3) {
        int i3;
        int i16;
        if (view != null && view2 != null) {
            TextView textView = (TextView) view.findViewById(R.id.f6514385);
            TextView textView2 = (TextView) view2.findViewById(R.id.f654238w);
            if (textView != null && textView2 != null) {
                ThemeImageView themeImageView = (ThemeImageView) view.findViewById(R.id.f6512383);
                ThemeImageView themeImageView2 = (ThemeImageView) view2.findViewById(R.id.f654038u);
                if (themeImageView != null && themeImageView2 != null) {
                    if (QQTheme.isNowThemeIsNight()) {
                        i3 = -1;
                        i16 = R.drawable.f161707kp1;
                    } else {
                        i3 = -16777216;
                        i16 = R.drawable.aay;
                    }
                    themeImageView.setSupportMaskView(false);
                    themeImageView2.setSupportMaskView(false);
                    themeImageView.setColorFilter(i3);
                    themeImageView2.setColorFilter(i3);
                    view.setBackgroundResource(i16);
                    view2.setBackgroundResource(i16);
                    textView.setTextColor(i3);
                    textView2.setTextColor(i3);
                    if (view3 != null) {
                        TextView textView3 = (TextView) view3.findViewById(R.id.f6518389);
                        ThemeImageView themeImageView3 = (ThemeImageView) view3.findViewById(R.id.f6516387);
                        if (textView3 != null && themeImageView3 != null) {
                            view3.setBackgroundResource(i16);
                            themeImageView3.setSupportMaskView(false);
                            themeImageView3.setColorFilter(i3);
                            textView3.setTextColor(i3);
                        }
                    }
                }
            }
        }
    }

    private static boolean e(Bitmap bitmap, ArrayList<Rect> arrayList, Canvas canvas, Rect rect) {
        if (B() && rect.width() > 350 && rect.height() > 350 && bitmap != null) {
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, rect.width() / 2, rect.height() / 2, false);
                if (createScaledBitmap != null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("QRUtils", 2, "createScaledBitmap tmp success: w=" + createScaledBitmap.getWidth() + ",h=" + createScaledBitmap.getHeight() + "org w=" + bitmap.getWidth() + ",org h=" + bitmap.getHeight());
                    }
                    bitmap = createScaledBitmap;
                }
            } catch (Throwable th5) {
                QLog.i("QRUtils", 1, "getQRCard error : " + th5.getMessage());
            }
        }
        if (arrayList != null) {
            if (QLog.isColorLevel() && bitmap != null) {
                QLog.w("QRUtils", 2, "size: w=" + bitmap.getWidth() + ",h=" + bitmap.getHeight());
            }
            try {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap, rect.width(), rect.height(), false);
                Canvas canvas2 = new Canvas(createScaledBitmap2);
                Paint paint = new Paint();
                paint.setAlpha(0);
                paint.setAntiAlias(true);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    canvas2.drawRect(new Rect(arrayList.get(i3)), paint);
                }
                canvas.drawBitmap(createScaledBitmap2, (Rect) null, rect, (Paint) null);
                createScaledBitmap2.recycle();
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                return true;
            }
        } else if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
        }
        return false;
    }

    private static void f(Bitmap bitmap, int i3, Canvas canvas, int i16) {
        if (bitmap != null) {
            Paint paint = new Paint();
            int i17 = (i3 - 440) / 2;
            int i18 = i16 + 228;
            Rect rect = new Rect(i17, i18, i17 + 440, i18 + 440);
            paint.setAntiAlias(true);
            canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        }
    }

    private static void g(Bitmap bitmap, int i3, int i16, Canvas canvas) {
        if (bitmap != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QRUtils", 2, " wholeBg.size = " + bitmap.getByteCount());
            }
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, i3, i16);
            paint.setAntiAlias(true);
            canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        }
    }

    private static void h(Bitmap bitmap, int i3, Canvas canvas, int i16) {
        if (bitmap != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            int i17 = (i3 / 2) - 70;
            int i18 = i16 - 66;
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i17, i18, i17 + 140, i18 + 140), paint);
        }
    }

    private static void i(int i3, Canvas canvas, int i16) {
        Paint paint = new Paint();
        RectF rectF = new RectF((i3 / 2) - 70, i16 - 66, r6 + 140, r8 + 140);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(16.0f);
        int parseColor = Color.parseColor("#E6FFFFFF");
        if (SimpleModeHelper.A()) {
            parseColor = Color.parseColor("#262626");
        }
        paint.setColor(parseColor);
        canvas.drawArc(rectF, 182.0f, 176.0f, false, paint);
    }

    private static void j(Context context, String str, int i3, int i16, Canvas canvas, int i17) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int i18 = (i3 / 2) - 68;
        int i19 = i17 + 74;
        if (i19 < 0) {
            i19 = 0;
        }
        Rect rect = new Rect(i18, i19, i18 + 136, i19 + 67);
        if (!TextUtils.isEmpty(str)) {
            try {
                paint.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_ATOP));
            } catch (IllegalArgumentException unused) {
                QLog.d("QRUtils", 1, "logoColor is illegal please check manage info logoColor = " + str);
            }
        }
        canvas.drawBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.npt), (Rect) null, rect, paint);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005b, code lost:
    
        if (r0.measureText(r5) > r2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
    
        r8.drawText(r5, (r7 / 2) - (((int) r0.measureText(r5)) / 2), ((r9 - 66) + 140) + 72, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0038, code lost:
    
        if (r0.measureText(r5) > r2) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
    
        r4 = r4 - 2;
        r5 = r5.substring(0, r4) + "\u2026";
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0053, code lost:
    
        if (r4 <= 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void k(int i3, String str, String str2, int i16, Canvas canvas, int i17) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setTextSize(48.0f);
        paint.setFlags(1);
        paint.setTypeface(Typeface.SANS_SERIF);
        if (str2 != null && !TextUtils.isEmpty(str)) {
            int max = Math.max(2, str.length());
            float f16 = 500;
        }
    }

    private static void l(Bitmap bitmap, int i3, Canvas canvas) {
        if (bitmap != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, i3, (i3 * 550) / QidPagView.DESIGN_PAG_WIDTH), paint);
        }
    }

    private static void m(int i3, String str, int i16, Canvas canvas, int i17, int i18) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setTextSize(28.0f);
        paint.setTypeface(Typeface.SANS_SERIF);
        if (str != null) {
            int i19 = i17 + 228 + 440;
            canvas.drawText(str, (i16 / 2) - (((int) paint.measureText(str)) / 2), i19 + ((i18 - i19) / 2) + 14, paint);
        }
    }

    private static void n(String str, int i3, int i16, Canvas canvas, int i17) {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setTextSize(28.0f);
        paint.setFlags(1);
        paint.setTypeface(Typeface.SANS_SERIF);
        if (str != null) {
            canvas.drawText(str, (i16 / 2) - (((int) paint.measureText(str)) / 2), (i17 - 66) + 140 + 72 + 42, paint);
        }
    }

    public static BitMatrix o(String str, int i3) {
        EnumMap enumMap = new EnumMap(EncodeHintType.class);
        enumMap.put((EnumMap) EncodeHintType.ERROR_CORRECTION, (EncodeHintType) ErrorCorrectionLevel.L);
        String y16 = y(str);
        if (y16 != null) {
            enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) y16);
        }
        if (i3 != -1) {
            enumMap.put((EnumMap) EncodeHintType.QRCODE_VERSION, (EncodeHintType) Integer.valueOf(N(i3)));
        }
        enumMap.put((EnumMap) EncodeHintType.MARGIN, (EncodeHintType) 0);
        try {
            return new QRCodeWriter().encode(str, 0, 0, enumMap);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("QRUtils", 1, "encode error:" + th5.getMessage());
            return null;
        }
    }

    public static Drawable p(Resources resources, int i3) {
        Drawable drawable = resources.getDrawable(i3);
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        return drawable.mutate();
    }

    public static void q(AppRuntime appRuntime, String str, int i3, int i16, p pVar, int i17) {
        m a16 = m.a(i3, str);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + i3);
                return;
            }
            return;
        }
        String e16 = a16.e();
        a aVar = new a(i17, pVar);
        Bundle bundle = new Bundle();
        if (i3 == 2) {
            bundle.putInt(IQRDataApi.PARAM_NO_VERIFY_TOKEN, i16);
        }
        ((IQRDataApi) QRoute.api(IQRDataApi.class)).requestUrlEncode(appRuntime, e16, bundle, aVar);
    }

    public static final Bitmap[] r(Context context, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, ArrayList<Rect> arrayList, int i3, String str, String str2, int i16, String str3, boolean z16, String str4, boolean z17) {
        int i17;
        int i18;
        Bitmap[] bitmapArr = new Bitmap[2];
        int min = Math.min(750, ScreenUtil.getRealWidth(context));
        int min2 = Math.min(1344, ScreenUtil.getRealHeight(context));
        if (QLog.isColorLevel()) {
            QLog.w("QRUtils", 2, "getMyQRCard() shareWidth=" + min + ",shareHeight=" + min2);
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(440, 440, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
            if (createBitmap != null && createBitmap2 != null) {
                if (e(bitmap3, arrayList, new Canvas(createBitmap), new Rect(0, 0, 440, 440))) {
                    return null;
                }
                bitmapArr[0] = createBitmap;
                Canvas canvas = new Canvas(createBitmap2);
                if (QLog.isColorLevel()) {
                    QLog.d("QRUtils", 2, " shareWidth = " + min + " shareHeight = " + min2);
                }
                g(bitmap, min, min2, canvas);
                Paint paint = new Paint();
                int i19 = (min - 550) / 2;
                int i26 = (min2 - 982) / 2;
                int i27 = i26 > 0 ? i26 + 78 : 78;
                int i28 = i27 + 772;
                if (z17) {
                    i28 -= 42;
                }
                int i29 = i28;
                boolean A = SimpleModeHelper.A();
                RectF rectF = new RectF(i19, i27, i19 + 550, i29);
                paint.setAntiAlias(true);
                paint.setColor(Color.parseColor(A ? "#262626" : "#E6FFFFFF"));
                canvas.drawRoundRect(rectF, 32.0f, 32.0f, paint);
                i(min, canvas, i27);
                h(bitmap2, min, canvas, i27);
                if (A) {
                    i18 = Color.parseColor("#999999");
                    i17 = -1;
                } else {
                    i17 = i3;
                    i18 = i16;
                }
                int i36 = i18;
                k(i17, str, str2, min, canvas, i27);
                if (!z17) {
                    int i37 = i27 - 42;
                    f(createBitmap, min, canvas, i37);
                    m(i17, str3, min, canvas, i37, i29);
                } else {
                    n(str2, i36, min, canvas, i27);
                    f(createBitmap, min, canvas, i27);
                    m(i17, str3, min, canvas, i27, i29);
                }
                if (z16) {
                    j(context, str4, min, min2, canvas, i29);
                }
                bitmapArr[1] = createBitmap2;
                return bitmapArr;
            }
            QLog.d("QRUtils", 1, "getMyQRCard() myCode == null || myShare == null");
            return bitmapArr;
        } catch (OutOfMemoryError e16) {
            QLog.w("QRUtils", 1, e16.getMessage());
            return bitmapArr;
        }
    }

    public static bb.a s(QQAppInterface qQAppInterface, bb bbVar, int i3) {
        List<bb.a> list;
        if (bbVar != null && (list = bbVar.f202590a) != null && list.size() > 0) {
            int random = (int) (Math.random() * bbVar.f202590a.size());
            int i16 = 0;
            while (i3 != -1 && random == i3 && i16 < 50) {
                i16++;
                random = (int) (Math.random() * bbVar.f202590a.size());
            }
            return bbVar.f202590a.get(random);
        }
        return null;
    }

    public static int t(QQAppInterface qQAppInterface) {
        int i3 = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt("my_qr_code_cfg_sp_index", -1);
        if (QLog.isColorLevel()) {
            QLog.i("QRUtils", 2, "getMyQrBgIndexFromSp().settingValue:" + i3);
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0110, code lost:
    
        if (r7.measureText(r2) > r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0112, code lost:
    
        r11 = r11 - 2;
        r2 = r2.substring(0, r11) + "\u2026";
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x012b, code lost:
    
        if (r11 <= 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0133, code lost:
    
        if (r7.measureText(r2) > r10) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0135, code lost:
    
        if (r14 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0137, code lost:
    
        r0 = 182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0139, code lost:
    
        r12.drawText(r2, r0, 665.0f, r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap u(Context context, Bitmap bitmap, Bitmap bitmap2, int i3, String str, Bitmap bitmap3, Bitmap bitmap4, int i16, int i17, String str2, Rect rect, ArrayList<Rect> arrayList, int i18) {
        Bitmap bitmap5;
        Canvas canvas;
        boolean z16;
        String str3 = str;
        Bitmap bitmap6 = bitmap4;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(540, 740, Bitmap.Config.ARGB_8888);
            Bitmap decodeResource = i18 != 0 ? BitmapFactory.decodeResource(context.getResources(), i18) : null;
            if (createBitmap == null) {
                return null;
            }
            Canvas canvas2 = new Canvas(createBitmap);
            if (bitmap != null) {
                Paint paint = new Paint();
                bitmap5 = createBitmap;
                Rect rect2 = new Rect(0, 0, 540, 740);
                paint.setAntiAlias(true);
                canvas2.drawBitmap(bitmap, (Rect) null, rect2, paint);
                canvas = canvas2;
            } else {
                bitmap5 = createBitmap;
                Paint paint2 = new Paint();
                paint2.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 600.0f, -657931, -1513240, Shader.TileMode.REPEAT));
                canvas = canvas2;
                canvas2.drawRect(0.0f, 0.0f, 540.0f, 600.0f, paint2);
                paint2.setShader(null);
                paint2.setColor(-2565928);
                canvas.drawLine(0.0f, 600.0f, 540.0f, 600.0f, paint2);
                paint2.setColor(-986896);
                canvas.drawRect(0.0f, 601.0f, 540.0f, 740.0f, paint2);
            }
            if (bitmap2 != null) {
                Paint paint3 = new Paint();
                paint3.setAntiAlias(true);
                canvas.drawBitmap(bitmap2, (Rect) null, new Rect(20, 621, 120, 721), paint3);
            }
            int i19 = 140;
            if (decodeResource != null) {
                Paint paint4 = new Paint();
                paint4.setAntiAlias(true);
                paint4.setFilterBitmap(true);
                canvas.drawBitmap(decodeResource, (Rect) null, new Rect(140, 633, 176, 669), paint4);
                z16 = true;
            } else {
                z16 = false;
            }
            Paint paint5 = new Paint();
            paint5.setTextAlign(Paint.Align.LEFT);
            paint5.setAntiAlias(true);
            paint5.setColor(i3);
            paint5.setTextSize(32.0f);
            paint5.setFlags(1);
            paint5.setTypeface(Typeface.SANS_SERIF);
            int i26 = z16 ? com.tencent.mm.plugin.appbrand.jsapi.coverview.a.CTRL_INDEX : LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT;
            if (str3 != null) {
                int max = Math.max(2, str.length());
                float f16 = i26;
            }
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, (Rect) null, new Rect(0, 0, 540, 600), (Paint) null);
            }
            Rect rect3 = rect != null ? rect : new Rect(70, 100, 470, 500);
            if (B() && rect3.width() > 350 && rect3.height() > 350 && bitmap6 != null) {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap6, rect3.width() / 2, rect3.height() / 2, false);
                    if (createScaledBitmap != null) {
                        if (QLog.isColorLevel()) {
                            QLog.w("QRUtils", 2, "createScaledBitmap tmp success: w=" + createScaledBitmap.getWidth() + ",h=" + createScaledBitmap.getHeight() + "org w=" + bitmap4.getWidth() + ",org h=" + bitmap4.getHeight());
                        }
                        bitmap6 = createScaledBitmap;
                    }
                } catch (Throwable th5) {
                    QLog.i("QRUtils", 2, "getQRCard error : " + th5.getMessage());
                }
            }
            if (arrayList != null) {
                if (QLog.isColorLevel() && bitmap6 != null) {
                    QLog.w("QRUtils", 2, "size: w=" + bitmap6.getWidth() + ",h=" + bitmap6.getHeight());
                }
                try {
                    Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap6, rect3.width(), rect3.height(), false);
                    Canvas canvas3 = new Canvas(createScaledBitmap2);
                    Paint paint6 = new Paint();
                    paint6.setAlpha(0);
                    paint6.setAntiAlias(true);
                    paint6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    for (int i27 = 0; i27 < arrayList.size(); i27++) {
                        canvas3.drawRect(new Rect(arrayList.get(i27)), paint6);
                    }
                    canvas.drawBitmap(createScaledBitmap2, (Rect) null, rect3, (Paint) null);
                    createScaledBitmap2.recycle();
                } catch (OutOfMemoryError e16) {
                    e16.printStackTrace();
                    return null;
                }
            } else if (bitmap6 != null) {
                canvas.drawBitmap(bitmap6, (Rect) null, rect3, (Paint) null);
            }
            try {
                if (i16 == 1) {
                    Paint paint7 = new Paint();
                    paint7.setAntiAlias(true);
                    Rect rect4 = new Rect(217, 247, 323, com.tencent.luggage.wxa.rf.h.CTRL_INDEX);
                    Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.bfs);
                    canvas.drawBitmap(decodeResource2, (Rect) null, rect4, paint7);
                    decodeResource2.recycle();
                } else if (i16 == 2 && bitmap2 != null) {
                    Paint paint8 = new Paint();
                    paint8.setAntiAlias(true);
                    canvas.drawBitmap(bitmap2, (Rect) null, new Rect(217, 247, 323, com.tencent.luggage.wxa.rf.h.CTRL_INDEX), paint8);
                } else if (i16 == 3) {
                    Paint paint9 = new Paint();
                    paint9.setAntiAlias(true);
                    Rect rect5 = new Rect(217, 247, 323, com.tencent.luggage.wxa.rf.h.CTRL_INDEX);
                    Bitmap decodeResource3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.bfs);
                    canvas.drawBitmap(decodeResource3, (Rect) null, rect5, paint9);
                    decodeResource3.recycle();
                } else {
                    if (i16 == 4) {
                        Paint paint10 = new Paint();
                        paint10.setAntiAlias(true);
                        Rect rect6 = new Rect(217, 247, 323, com.tencent.luggage.wxa.rf.h.CTRL_INDEX);
                        Bitmap decodeResource4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.bfs);
                        canvas.drawBitmap(decodeResource4, (Rect) null, rect6, paint10);
                        decodeResource4.recycle();
                    }
                    Paint paint11 = new Paint();
                    paint11.setTextAlign(Paint.Align.LEFT);
                    paint11.setAntiAlias(true);
                    paint11.setColor(i17);
                    paint11.setTextSize(24.0f);
                    paint11.setTypeface(Typeface.SANS_SERIF);
                    canvas.drawText(str2, 140.0f, 706.0f, paint11);
                    return bitmap5;
                }
                Paint paint112 = new Paint();
                paint112.setTextAlign(Paint.Align.LEFT);
                paint112.setAntiAlias(true);
                paint112.setColor(i17);
                paint112.setTextSize(24.0f);
                paint112.setTypeface(Typeface.SANS_SERIF);
                canvas.drawText(str2, 140.0f, 706.0f, paint112);
                return bitmap5;
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
                return null;
            }
        } catch (OutOfMemoryError e18) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.w("QRUtils", 2, e18.getMessage());
            return null;
        }
    }

    public static Bitmap v(Context context, Bitmap bitmap, Bitmap bitmap2) {
        int min = Math.min(750, ScreenUtil.getRealWidth(context));
        int min2 = Math.min(1344, ScreenUtil.getRealHeight(context));
        try {
            Bitmap createBitmap = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
            if (createBitmap == null) {
                QLog.d("QRUtils", 1, "QID_QR,getQidQrCard() myCode == null || myShare == null");
                return createBitmap;
            }
            Canvas canvas = new Canvas(createBitmap);
            g(bitmap, min, min2, canvas);
            l(bitmap2, min, canvas);
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            QLog.w("QRUtils", 1, e16.getMessage());
            return null;
        }
    }

    public static int w(QQAppInterface qQAppInterface) {
        int i3 = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0).getInt("troop_qr_code_cfg_sp_index", -1);
        if (QLog.isColorLevel()) {
            QLog.i("QRUtils", 2, "getTroopQrBgIndexFromSp().settingValue:" + i3);
        }
        return i3;
    }

    public static int x(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null || !QVipQidProcessor.get().isQidProfileEnable()) {
            return 1;
        }
        return qQAppInterface.getApp().getSharedPreferences("sp_vip_qid_info", 0).getInt("user_qr_card_type" + str, 1);
    }

    protected static String y(CharSequence charSequence) {
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (charSequence.charAt(i3) > '\u00ff') {
                return "UTF-8";
            }
        }
        return null;
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http://mqq.tenpay.com/qrhb") && !str.startsWith("https://mqq.tenpay.com/qrhb")) {
            return false;
        }
        return true;
    }
}
