package com.tencent.mobileqq.ocr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.dov.edit.api.IStartDovEditPic;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.ocr.view.OcrImageTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.share.api.IShareActivityStartup;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.n;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f254704a;

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.mobileqq.ocr.req.a f254705b;

    /* renamed from: c, reason: collision with root package name */
    public static a f254706c;

    /* renamed from: d, reason: collision with root package name */
    public static a f254707d;

    /* renamed from: e, reason: collision with root package name */
    public static CharSequence f254708e;

    /* renamed from: f, reason: collision with root package name */
    public static CharSequence f254709f;

    /* renamed from: g, reason: collision with root package name */
    public static com.tencent.mobileqq.gallery.picocr.c f254710g;

    /* renamed from: h, reason: collision with root package name */
    public static TranslateResult f254711h;

    /* renamed from: i, reason: collision with root package name */
    static final HashMap<String, Integer> f254712i;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f254713a;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f254714b;

        /* renamed from: c, reason: collision with root package name */
        public HashMap<String, String> f254715c;

        /* renamed from: d, reason: collision with root package name */
        public String f254716d;

        /* renamed from: e, reason: collision with root package name */
        public String f254717e;

        /* renamed from: f, reason: collision with root package name */
        public List<String> f254718f;

        /* renamed from: g, reason: collision with root package name */
        public List<String> f254719g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f254713a = "";
            this.f254716d = "";
            this.f254717e = "";
        }

        public Pair<String, String> a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            for (Map.Entry<String, String> entry : this.f254715c.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(str)) {
                    return new Pair<>(entry.getKey(), entry.getValue());
                }
            }
            return null;
        }

        public boolean b(List<String> list, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list, (Object) str)).booleanValue();
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().trim().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        public String c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            if (!str.equalsIgnoreCase(OcrConfig.CHINESE)) {
                return OcrConfig.CHINESE;
            }
            return OcrConfig.DEFAULT_SUPPORT_LANGUAGE.split("/")[0];
        }

        public String d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            return OcrConfig.getDefaultLanguageName(str);
        }

        public String e() {
            String obj;
            String obj2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ocrLan:");
            sb5.append(this.f254713a);
            sb5.append(", ocrLanOptions:");
            List<String> list = this.f254714b;
            String str = "";
            if (list == null) {
                obj = "";
            } else {
                obj = list.toString();
            }
            sb5.append(obj);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("srcLan:");
            sb7.append(this.f254716d);
            sb7.append(", srcLanOptions:");
            List<String> list2 = this.f254718f;
            if (list2 == null) {
                obj2 = "";
            } else {
                obj2 = list2.toString();
            }
            sb7.append(obj2);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append("dstLan:");
            sb9.append(this.f254717e);
            sb9.append(", dstLanOptions:");
            List<String> list3 = this.f254719g;
            if (list3 != null) {
                str = list3.toString();
            }
            sb9.append(str);
            return sb6 + "\n" + sb8 + "\n" + sb9.toString();
        }

        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else if (!TextUtils.isEmpty(str)) {
                this.f254717e = str;
            }
        }

        public void g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f254716d = str;
                List<String> g16 = d.g(str);
                this.f254719g = g16;
                if (g16 != null) {
                    this.f254717e = g16.get(0);
                }
            }
        }

        public void h(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
                return;
            }
            this.f254713a = aVar.f254713a;
            this.f254714b = aVar.f254714b;
            this.f254715c = aVar.f254715c;
            this.f254716d = aVar.f254716d;
            this.f254717e = aVar.f254717e;
            List<String> list = this.f254718f;
            if (list != null) {
                list.clear();
                this.f254718f.addAll(aVar.f254718f);
            }
            List<String> list2 = this.f254719g;
            if (list2 != null) {
                list2.clear();
                this.f254719g.addAll(aVar.f254719g);
            }
        }

        public void i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f254713a = str;
            this.f254716d = str;
            if (TextUtils.equals(str, OcrConfig.CHINESE)) {
                this.f254717e = "en";
            } else {
                this.f254717e = OcrConfig.CHINESE;
            }
            List<String> list = this.f254718f;
            if (list != null) {
                list.clear();
                this.f254718f.add(this.f254716d);
            }
            List<String> list2 = this.f254719g;
            if (list2 != null) {
                list2.clear();
                this.f254719g.add(this.f254717e);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f254704a = false;
        f254708e = "";
        f254709f = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        f254712i = hashMap;
        hashMap.put(OcrConfig.CHINESE, 1);
        hashMap.put("en", 2);
        hashMap.put(LocaleUtils.L_JAPANESE, 3);
        hashMap.put("jp", 3);
        hashMap.put(LocaleUtils.L_KOREAN, 4);
        hashMap.put("kr", 4);
        hashMap.put("fr", 5);
        hashMap.put("es", 6);
        hashMap.put("it", 7);
        hashMap.put("de", 8);
        hashMap.put(ReportConstant.COSTREPORT_TRANS, 9);
        hashMap.put("ru", 10);
        hashMap.put("pt", 11);
        hashMap.put("vi", 12);
        hashMap.put("id", 13);
        hashMap.put("ms", 14);
        hashMap.put("th", 15);
    }

    public static int a(BitmapFactory.Options options, int i3, int i16) {
        int i17;
        int i18 = options.outHeight;
        int i19 = options.outWidth;
        if (i19 > i3 * 1.2f) {
            int i26 = i18 / 2;
            i17 = 2;
            while ((i19 / 2) / i17 > i3) {
                i17 *= 2;
            }
        } else {
            i17 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.i("OCRPerformUtil", 2, "calculateInSampleSize:" + i17);
        }
        return i17;
    }

    public static String b(TextView textView) {
        if (textView == null) {
            return null;
        }
        int selectionStart = textView.getSelectionStart();
        int selectionEnd = textView.getSelectionEnd();
        String charSequence = textView.getText().toString();
        if (TextUtils.isEmpty(charSequence) || selectionStart >= selectionEnd || selectionStart < 0 || selectionEnd > charSequence.length()) {
            return null;
        }
        String substring = charSequence.substring(selectionStart, selectionEnd);
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformUtil", 2, "collectSelectedText " + substring);
        }
        return substring;
    }

    public static Bitmap c(String str, DisplayMetrics displayMetrics) {
        int exifOrientation;
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int a16 = a(options, i3, i16);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a16;
        Bitmap d16 = com.tencent.mobileqq.gallery.picocr.d.d(str, options, 1, 4);
        if (d16 != null && (exifOrientation = BaseImageUtil.getExifOrientation(str)) != 0 && exifOrientation % 90 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("OCRPerformUtil", 2, "decodeBitmapForOcr rotate:" + exifOrientation);
            }
            int width = d16.getWidth();
            int height = d16.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(exifOrientation, width / 2.0f, height / 2.0f);
            return Bitmap.createBitmap(d16, 0, 0, width, height, matrix, true);
        }
        return d16;
    }

    public static Bitmap d(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            if (QLog.isColorLevel()) {
                QLog.i("OCRPerformUtil", 2, "drawable2Bitmap, drawable is null");
                return null;
            }
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void e(Activity activity, String str) {
        ((IStartDovEditPic) QRoute.api(IStartDovEditPic.class)).enterCropActivity(activity, str);
    }

    public static int f(String str) {
        if (!TextUtils.isEmpty(str)) {
            return f254712i.get(str.trim().toLowerCase()).intValue();
        }
        return 0;
    }

    public static List<String> g(String str) {
        return OcrConfig.getDefaultSupportLanguages(str);
    }

    public static String h(String str) {
        return OcrConfig.getDefaultLanguageName(str);
    }

    public static void i(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("OCRPerformUtil", 2, "forwardContent error, content is empty");
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", -1);
        bundle.putString(AppConstants.Key.FORWARD_TEXT, str);
        Intent intent = new Intent();
        intent.putExtra("isFromShare", true);
        intent.putExtras(bundle);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(activity, intent, 21);
    }

    public static void j(Activity activity, OcrImageTextView ocrImageTextView) {
        if (activity != null && ocrImageTextView != null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(ocrImageTextView.getWidth(), ocrImageTextView.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                ocrImageTextView.layout(ocrImageTextView.getLeft(), ocrImageTextView.getTop(), ocrImageTextView.getRight(), ocrImageTextView.getBottom());
                Drawable background = ocrImageTextView.getBackground();
                if (background != null) {
                    background.draw(canvas);
                }
                ocrImageTextView.draw(canvas);
                String str = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath() + "/" + SystemClock.uptimeMillis() + ".jpg";
                if (QLog.isColorLevel()) {
                    QLog.d("OCRPerformUtil", 2, "forwardDrawable:" + str);
                }
                n.a(createBitmap, str);
                createBitmap.recycle();
                ((IShareActivityStartup) QRoute.api(IShareActivityStartup.class)).gotoShareActivity(activity, str);
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static URLDrawable.URLDrawableOptions k(URLImageView uRLImageView, Drawable drawable) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        if (uRLImageView.getLayoutParams() != null) {
            obtain.mRequestWidth = uRLImageView.getLayoutParams().width;
            obtain.mRequestHeight = uRLImageView.getLayoutParams().height;
        }
        return obtain;
    }

    public static a l(a aVar, String str, List<String> list, HashMap<String, String> hashMap) {
        String lowerCase;
        if (aVar == null) {
            aVar = new a();
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            lowerCase = "";
        } else {
            lowerCase = str.toLowerCase();
        }
        aVar.f254713a = lowerCase;
        if (list != null && !list.isEmpty()) {
            List<String> list2 = aVar.f254714b;
            if (list2 == null) {
                aVar.f254714b = new ArrayList();
            } else {
                list2.clear();
            }
            for (String str3 : list) {
                String h16 = h(str3);
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(h16)) {
                    aVar.f254714b.add(str3.toLowerCase());
                }
            }
        }
        aVar.f254715c = hashMap;
        String str4 = aVar.f254713a;
        aVar.f254716d = str4;
        List<String> g16 = g(str4);
        aVar.f254719g = g16;
        if (g16 != null) {
            str2 = g16.get(0);
        }
        aVar.f254717e = str2;
        aVar.f254718f = g(str2);
        for (String str5 : OcrConfig.DEFAULT_SUPPORT_LANGUAGE.split("/")) {
            List<String> list3 = aVar.f254718f;
            if (list3 != null && !aVar.b(list3, str5)) {
                aVar.f254718f.add(str5);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("OCRPerformUtil", 2, "recordOcrLanInfo:ocrLanHolder:" + aVar.e());
        }
        return aVar;
    }

    public static void m() {
        if (f254705b != null) {
            f254705b = null;
        }
        if (f254706c != null) {
            f254706c = null;
        }
        if (f254707d != null) {
            f254707d = null;
        }
        if (f254710g != null) {
            f254710g = null;
        }
        if (f254711h != null) {
            f254711h = null;
        }
        if (f254708e != null) {
            f254708e = null;
        }
        if (f254709f != null) {
            f254709f = null;
        }
        f254704a = false;
    }

    public static void n(String str, int i3) {
        o(str, str, i3);
    }

    public static void o(String str, String str2, int i3) {
        ReportController.o(null, "dc00898", "", "", str, str2, i3, 0, "", "0", "0", "");
    }

    public static void p(int i3, String str, String str2, String str3, String str4) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_succ_flag", i3 + "");
        hashMap.put("param_md5", str);
        hashMap.put("param_text", str2);
        hashMap.put("param_errMsg", str4);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str3, true, 0L, 0L, hashMap, null);
    }

    public static void q(int i3, String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_succ_flag", i3 + "");
        hashMap.put("param_err_msg", str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, 0L, 0L, hashMap, null);
    }

    public static CharSequence r(ArrayList<com.tencent.mobileqq.gallery.picocr.b> arrayList) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<com.tencent.mobileqq.gallery.picocr.b> it = arrayList.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            com.tencent.mobileqq.gallery.picocr.b next = it.next();
            if (next.f211810d == i3) {
                sb5.append(next.f211807a.trim());
            } else {
                sb5.append("\n\n");
                sb5.append(next.f211807a.trim());
                i3 = next.f211810d;
            }
        }
        return new QQText(sb5.toString(), 8, 16);
    }

    public static int s(Point point, Point point2) {
        int abs = Math.abs(point2.x - point.x);
        int abs2 = Math.abs(point2.y - point.y);
        return (int) Math.ceil(Math.sqrt((abs * abs) + (abs2 * abs2)));
    }
}
