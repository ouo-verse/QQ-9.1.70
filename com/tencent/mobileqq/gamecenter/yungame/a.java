package com.tencent.mobileqq.gamecenter.yungame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, Long> f213565a = new LruCache<>(10);

    public static String a(String str, boolean z16) {
        String[] split;
        String str2;
        String str3 = "";
        try {
            split = new URI(str).getQuery().split(ContainerUtils.FIELD_DELIMITER);
        } catch (Exception e16) {
            QLog.e("Utils", 1, "[addParamToKuiklyUrl] error:" + e16);
        }
        if (split != null && split.length != 0) {
            String str4 = "";
            for (int i3 = 0; i3 < split.length; i3++) {
                if (i3 == 0) {
                    str4 = str4 + split[i3];
                } else {
                    str4 = str4 + ContainerUtils.FIELD_DELIMITER + split[i3];
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            sb5.append("&is_landscape=");
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            sb5.append(str2);
            str3 = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1) + sb5.toString();
            QLog.e("Utils", 1, "[addParamToKuiklyUrl] newUrl:" + str3);
            return str3;
        }
        return "";
    }

    public static String b(String str, boolean z16) {
        URI uri;
        String host;
        String str2;
        String str3 = "";
        try {
            uri = new URI(str);
            host = uri.getHost();
        } catch (Exception e16) {
            QLog.e("Utils", 1, "[addParamToUrl] error:" + e16);
        }
        if ("hippy".equalsIgnoreCase(host)) {
            String[] split = uri.getQuery().split(ContainerUtils.FIELD_DELIMITER);
            if (split != null && split.length != 0) {
                String str4 = "";
                for (int i3 = 0; i3 < split.length; i3++) {
                    if (i3 == 0) {
                        str4 = str4 + split[i3];
                    } else {
                        str4 = str4 + ContainerUtils.FIELD_DELIMITER + split[i3];
                    }
                }
                str2 = str.substring(0, str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1) + URLEncoder.encode(str4 + "&isLandscapeScreen=" + z16, "UTF-8");
            }
            return "";
        }
        if ("kuikly".equalsIgnoreCase(host)) {
            str2 = str + "&is_landscape=" + z16;
        }
        QLog.e("Utils", 1, "[addParamToUrl] newUrl:" + str3);
        return str3;
        str3 = str2;
        QLog.e("Utils", 1, "[addParamToUrl] newUrl:" + str3);
        return str3;
    }

    @SuppressLint({"WrongConstant"})
    public static PopupWindow c(Context context, CharSequence charSequence, boolean z16, String str, View.OnClickListener onClickListener) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.i8t, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_msg);
        textView.setText(charSequence);
        textView.setTextAlignment(2);
        if (z16) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.f112846p1);
            textView2.setText(str);
            textView2.setVisibility(0);
            inflate.setOnClickListener(onClickListener);
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        if (z16) {
            popupWindow.setOutsideTouchable(false);
            popupWindow.setTouchable(true);
            popupWindow.setFocusable(false);
        }
        return popupWindow;
    }

    public static final int d(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static int[] e(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i16 = displayMetrics.heightPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            i3 = point.x;
            i16 = point.y;
        } catch (Exception e16) {
            QLog.e("Utils", 1, e16, new Object[0]);
        }
        iArr[0] = i3;
        iArr[1] = i16;
        return iArr;
    }

    public static boolean f(@NonNull String str) {
        LruCache<String, Long> lruCache = f213565a;
        Long l3 = lruCache.get(str);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l3 != null && Math.abs(valueOf.longValue() - l3.longValue()) < 800) {
            return true;
        }
        lruCache.put(str, valueOf);
        return false;
    }

    private static boolean g(String str) {
        if (!TextUtils.isEmpty(str) && (str.endsWith(".jpg") || str.endsWith(".jpeg") || str.endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap h(String str) {
        HttpURLConnection httpURLConnection;
        ?? r16 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Exception e16) {
                e = e16;
                httpURLConnection = null;
            } catch (Throwable th5) {
                th = th5;
                if (r16 != 0) {
                }
                throw th;
            }
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                httpURLConnection.disconnect();
                return decodeStream;
            } catch (Exception e17) {
                e = e17;
                QLog.e("Utils", 1, e, new Object[0]);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            r16 = str;
            if (r16 != 0) {
                r16.disconnect();
            }
            throw th;
        }
    }

    public static void i(String str, boolean z16, ImageView imageView) {
        boolean z17;
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            if (!g(str)) {
                z17 = true;
            } else {
                z17 = false;
            }
            obtain.mUseApngImage = z17;
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (z16) {
                imageView.setBackground(drawable);
            } else {
                imageView.setImageDrawable(drawable);
            }
        } catch (Throwable th5) {
            QLog.e("Utils", 1, th5, new Object[0]);
        }
    }

    public static d j(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        d dVar = new d(activity, R.style.f173860au0);
        dVar.setContentView(R.layout.eak);
        dVar.W(str);
        dVar.P(str2);
        dVar.Q(str3, onClickListener);
        dVar.S(str4, onClickListener2);
        dVar.show();
        return dVar;
    }

    public static void k(WeakReference<Context> weakReference, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if (weakReference.get() == null) {
            return;
        }
        e eVar = new e(weakReference.get(), R.style.f173860au0);
        eVar.setContentView(R.layout.i8u);
        eVar.N(str);
        eVar.O(str2, onClickListener);
        eVar.setCanceledOnTouchOutside(false);
        eVar.show();
    }
}
