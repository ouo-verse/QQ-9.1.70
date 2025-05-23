package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSImageView;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Drawable f239083a;

    /* renamed from: b, reason: collision with root package name */
    private static final Rect f239084b = new Rect();

    public static Drawable d(Context context) {
        if (f239083a == null) {
            f239083a = context.getResources().getDrawable(R.drawable.d7y);
        }
        return f239083a;
    }

    public static String e(int i3) {
        String format;
        String format2;
        String format3;
        int i16 = i3 / 3600;
        int i17 = i3 / 60;
        if (i16 > 0) {
            i17 -= i16 * 60;
        }
        int i18 = i3 % 60;
        if (i17 >= 10) {
            format = String.valueOf(i17);
        } else {
            format = String.format("0%d", Integer.valueOf(i17));
        }
        if (i18 >= 10) {
            format2 = String.valueOf(i18);
        } else {
            format2 = String.format("0%d", Integer.valueOf(i18));
        }
        if (i16 > 0) {
            if (i16 >= 10) {
                format3 = String.valueOf(i16);
            } else {
                format3 = String.format("0%d", Integer.valueOf(i16));
            }
            return String.format("%s:%s:%s", format3, format, format2);
        }
        return String.format("%s:%s", format, format2);
    }

    public static Pair<Integer, Integer> f() {
        int i3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf((int) (i3 * 0.562f)));
    }

    public static Pair<Integer, Integer> g() {
        Resources resources = BaseApplicationImpl.getApplication().getResources();
        return new Pair<>(Integer.valueOf((resources.getDisplayMetrics().widthPixels - BaseAIOUtils.f(3.0f, resources)) / 3), Integer.valueOf(resources.getDimensionPixelSize(R.dimen.asj)));
    }

    public static float h(int i3, int i16) {
        int i17 = i(i3, i16);
        if (i17 == 1) {
            return 0.5625f;
        }
        return i17 == 2 ? 1.333f : 1.0f;
    }

    public static int i(int i3, int i16) {
        return 1;
    }

    private static boolean j(Context context) {
        String a16;
        BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
        if (baseActivity == null) {
            return false;
        }
        QQAppInterface qQAppInterface = baseActivity.app;
        if (qQAppInterface != null) {
            a16 = qQAppInterface.getCurrentAccountUin();
        } else {
            a16 = b.a();
        }
        return SettingCloneUtil.readValue((Context) baseActivity, a16, (String) null, AppConstants.QQSETTING_KANDIAN_DOWNLOAD_PIC_IN_WIFI_ONLY, false);
    }

    public static boolean k(Context context, URL url) {
        return (!j(context) || NetworkUtil.isWifiConnected(context) || ImageManager.get().isLocalFileExist(url)) ? false : true;
    }

    public static void a(KandianUrlImageView kandianUrlImageView, URL url, Context context) {
        b(kandianUrlImageView, url, context, false);
    }

    public static void c(PTSImageView pTSImageView, URL url, Context context) {
        if (url == null) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_UI, 2, "configImage url is empty! use default preload image");
            }
            pTSImageView.setImageDrawable(d(context));
            return;
        }
        pTSImageView.setImagePlaceHolder(d(context)).setImage(url);
    }

    public static void b(KandianUrlImageView kandianUrlImageView, URL url, Context context, boolean z16) {
        if (url == null) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_UI, 2, "configImage url is empty! use default preload image");
            }
            kandianUrlImageView.setImageResource(R.drawable.d7y);
        } else {
            if (k(context, url)) {
                if (!z16) {
                    kandianUrlImageView.setImageResource(R.drawable.d7y);
                    return;
                } else {
                    kandianUrlImageView.setImageDrawable(new ColorDrawable(context.getResources().getColor(R.color.black)));
                    return;
                }
            }
            if (!z16) {
                if (kandianUrlImageView.isRound()) {
                    kandianUrlImageView.setImagePlaceHolder(context.getResources().getDrawable(R.drawable.crc)).setImage(url);
                    return;
                } else {
                    kandianUrlImageView.setImagePlaceHolder(context.getResources().getDrawable(R.drawable.d7y)).setImage(url);
                    return;
                }
            }
            kandianUrlImageView.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black)));
            kandianUrlImageView.setImagePlaceHolder(new ColorDrawable(context.getResources().getColor(R.color.black))).setImage(url);
        }
    }
}
