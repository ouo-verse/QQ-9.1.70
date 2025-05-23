package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import er1.UnreadDotType;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildUIUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Long f235393a = 0L;

    /* renamed from: b, reason: collision with root package name */
    public static final int f235394b = f(18.0f);

    /* renamed from: c, reason: collision with root package name */
    public static final int f235395c = f(34.0f);

    /* renamed from: d, reason: collision with root package name */
    public static final int f235396d = f(5.0f);

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Context> f235398a;

        /* renamed from: b, reason: collision with root package name */
        private QQProgressDialog f235399b = null;

        a(@NonNull Context context) {
            this.f235398a = new WeakReference<>(context);
        }

        public void a() {
            QQProgressDialog qQProgressDialog = this.f235399b;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            this.f235399b = null;
        }

        public void b() {
            Context context = this.f235398a.get();
            if (!(context instanceof Activity)) {
                return;
            }
            if (this.f235399b == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(context, ViewUtils.dpToPx(44.0f));
                this.f235399b = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.f1517118f);
                this.f235399b.setBackAndSearchFilter(false);
            }
            this.f235399b.showProgerss(true);
        }
    }

    public static boolean A(Context context) {
        if (context == null || !AppSetting.t(context) || com.tencent.mobileqq.pad.e.a() != SplitViewState.STATE_FLAT) {
            return false;
        }
        return true;
    }

    public static void B(View view, float f16) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin = C(marginLayoutParams.topMargin, f16);
            marginLayoutParams.bottomMargin = C(marginLayoutParams.bottomMargin, f16);
            marginLayoutParams.leftMargin = C(marginLayoutParams.leftMargin, f16);
            marginLayoutParams.rightMargin = C(marginLayoutParams.rightMargin, f16);
            view.setLayoutParams(marginLayoutParams);
        }
        view.setPadding(C(view.getPaddingLeft(), f16), C(view.getPaddingTop(), f16), C(view.getPaddingRight(), f16), C(view.getPaddingBottom(), f16));
        view.getLayoutParams().height = C(view.getLayoutParams().height, f16);
        if (view instanceof ViewGroup) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                B(viewGroup.getChildAt(i3), f16);
                i3++;
            }
        } else {
            view.getLayoutParams().width = C(view.getLayoutParams().width, f16);
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(2, (textView.getTextSize() / FontSettingManager.systemMetrics.scaledDensity) * f16);
        }
    }

    private static int C(int i3, float f16) {
        if (i3 <= 0) {
            return i3;
        }
        return (int) (i3 * f16);
    }

    public static a D(Context context) {
        return new a(context);
    }

    public static String E(String str, int i3) {
        Matcher matcher = Pattern.compile("\\w*[0-9]+\\?").matcher(str);
        if (matcher.find()) {
            if (i3 == 40) {
                return matcher.replaceFirst("40?");
            }
            if (i3 == 100) {
                return matcher.replaceFirst("100?");
            }
            if (i3 == 140) {
                return matcher.replaceFirst("140?");
            }
            return str;
        }
        return str;
    }

    private static void F(@DrawableRes int i3, @DrawableRes int i16, @DrawableRes int i17, List<View> list, int i18) {
        int i19;
        for (int i26 = 0; i26 < i18; i26++) {
            View view = list.get(i26);
            if (i26 == 0) {
                i19 = i3;
            } else if (i26 == i18 - 1) {
                i19 = i17;
            } else {
                i19 = i16;
            }
            view.setBackgroundResource(i19);
        }
    }

    public static void G(@DrawableRes int i3, @DrawableRes int i16, @DrawableRes int i17, @DrawableRes int i18, ViewGroup viewGroup) {
        int childCount;
        List<View> u16;
        int size;
        if (viewGroup == null || (childCount = viewGroup.getChildCount()) <= 0 || H(i18, viewGroup, childCount) || (size = (u16 = u(viewGroup, childCount)).size()) <= 0 || H(i18, u16.get(0), size) || I(i3, i17, u16)) {
            return;
        }
        F(i3, i16, i17, u16, size);
    }

    private static boolean H(@DrawableRes int i3, View view, int i16) {
        if (i16 == 1) {
            if (view.getVisibility() == 0) {
                view.setBackgroundResource(i3);
            }
            return true;
        }
        return false;
    }

    private static boolean I(@DrawableRes int i3, @DrawableRes int i16, List<View> list) {
        if (list.size() != 2) {
            return false;
        }
        list.get(0).setBackgroundResource(i3);
        list.get(1).setBackgroundResource(i16);
        return true;
    }

    public static void J(Activity activity, boolean z16, boolean z17) {
        if (activity != null && activity.getWindow() != null) {
            K(activity.getWindow(), z16, z17);
        }
    }

    public static void K(Window window, boolean z16, boolean z17) {
        int i3;
        if (!z16) {
            i3 = 5380;
        } else {
            i3 = 5376;
        }
        if (!z17) {
            i3 = i3 | 2 | 2048;
        }
        if (window != null) {
            window.getDecorView().setSystemUiVisibility(i3);
        }
    }

    public static void L(Activity activity, int i3) {
        M(activity, i3, true);
    }

    public static void M(Activity activity, int i3, boolean z16) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        if (z16) {
            window.setNavigationBarColor(i3);
        }
    }

    public static void N(boolean z16, View view) {
        float f16;
        view.setEnabled(z16);
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        view.setAlpha(f16);
    }

    public static void O(ViewGroup viewGroup) {
        boolean z16;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i16 < childCount) {
                if (viewGroup.getChildAt(i16).getVisibility() == 0) {
                    z16 = true;
                    break;
                }
                i16++;
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
    }

    public static void P(GuildDragTextView guildDragTextView, long j3, UnreadDotType unreadDotType) {
        String valueOf;
        if (j3 <= 0) {
            QLog.e("Guild.comm.QQGuildUIUtil", 1, "showUnreadCountDot error: count = " + j3);
            guildDragTextView.setVisibility(8);
            return;
        }
        unreadDotType.getDotBackground().a(guildDragTextView);
        guildDragTextView.setTextColor(guildDragTextView.getResources().getColorStateList(unreadDotType.getTextColor()));
        if (j3 > 99) {
            valueOf = "99+";
        } else {
            valueOf = String.valueOf(j3);
        }
        guildDragTextView.setText(valueOf);
        guildDragTextView.setTypeface(TypefaceProvider.c(guildDragTextView.getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
        guildDragTextView.setVisibility(0);
    }

    public static void Q(Context context, int i3) {
        QQToast.makeText(context, -1, context.getResources().getString(i3), 1).show();
    }

    public static void R(View view, int[] iArr) {
        Drawable background = view.getBackground();
        if (background != null && (background instanceof GradientDrawable)) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setColors(iArr);
            view.setBackground(gradientDrawable);
        }
    }

    public static void S(@NonNull View view) {
        Resources resources = view.getResources();
        int color = resources.getColor(R.color.bon);
        R(view, new int[]{color, resources.getColor(R.color.guild_member_place_holder_light), color});
    }

    public static void T(long j3) {
        ((Vibrator) ch.i().getSystemService("vibrator")).vibrate(j3);
    }

    public static void a(Fragment fragment) {
        if ((fragment instanceof DialogFragment) && fragment.isAdded()) {
            Window window = ((DialogFragment) fragment).getDialog().getWindow();
            if ((window.getAttributes().flags & 2) == 0) {
                window.addFlags(2);
            }
        }
    }

    public static void b(Fragment fragment) {
        if (fragment instanceof DialogFragment) {
            ((DialogFragment) fragment).getDialog().getWindow().clearFlags(2);
        }
    }

    public static void c(final Activity activity, int i3) {
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.util.QQGuildUIUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    activity.finish();
                }
            }
        }, i3);
    }

    public static void d(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof DragFrameLayout) {
            viewGroup = (ViewGroup) childAt;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if (childAt2 instanceof TopGestureLayout) {
            ((TopGestureLayout) childAt2).setInterceptTouchFlag(false);
        }
    }

    public static int e(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static int f(float f16) {
        if (f16 == 0.0f) {
            return 0;
        }
        float f17 = FontSettingManager.customMetrics.density;
        if (f17 <= 0.0f) {
            f17 = ch.i().getResources().getDisplayMetrics().density;
            QLog.e("Guild.comm.QQGuildUIUtil", 1, "FontSettingManager.customMetrics.density is error, system density:", Float.valueOf(f17));
        }
        return (int) ((f16 * f17) + 0.5f);
    }

    public static String g(TextView textView, String str, int i3) {
        int measuredWidth = textView.getMeasuredWidth();
        if (textView.getMaxLines() > 1) {
            measuredWidth = (measuredWidth - f(10.0f)) * textView.getMaxLines();
        }
        TextPaint paint = textView.getPaint();
        float f16 = measuredWidth - i3;
        if (f16 < paint.measureText(str)) {
            return (String) TextUtils.ellipsize(str, paint, f16, TextUtils.TruncateAt.END);
        }
        return str;
    }

    @Deprecated
    public static int h(@ColorRes int i3) {
        return ch.i().getResources().getColor(i3);
    }

    public static int i(Context context, @ColorRes int i3) {
        return context.getResources().getColor(i3);
    }

    public static Bitmap j(boolean z16) {
        String str;
        int i3;
        if (!z16) {
            str = "static://DefaultFace_square";
            i3 = R.drawable.coo;
        } else {
            str = "static://DefaultFace";
            i3 = R.drawable.f160830com;
        }
        String str2 = str;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str2);
        if (f16 == null) {
            f16 = com.tencent.mobileqq.util.j.h(BaseApplication.getContext().getResources(), i3);
            if (f16 != null) {
                imageCacheHelper.k(str2, f16, Business.Guild, Priority.High, null);
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.comm.QQGuildUIUtil", 2, "getDefaultFaceBitmap, bitmap=" + f16);
            }
        }
        return f16;
    }

    public static BitmapDrawable k(boolean z16) {
        return new BitmapDrawable(j(z16));
    }

    public static int l(@DimenRes int i3) {
        return ch.i().getResources().getDimensionPixelSize(i3);
    }

    public static Drawable m(@DrawableRes int i3) {
        return ch.i().getDrawable(i3);
    }

    public static String n(String str, String str2, AppInterface appInterface) {
        return o(str, str2, appInterface, 0);
    }

    public static String o(String str, String str2, AppInterface appInterface, int i3) {
        if (appInterface == null) {
            QLog.w("Guild.comm.QQGuildUIUtil", 1, "appInterface is null");
            return "";
        }
        String fullGuildUserUserAvatarUrl = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getFullGuildUserUserAvatarUrl(str, str2, i3);
        if (fullGuildUserUserAvatarUrl == null) {
            QLog.w("Guild.comm.QQGuildUIUtil", 1, "getFullAvatarUrl fullAvatarUrl is null");
            return "";
        }
        return fullGuildUserUserAvatarUrl;
    }

    public static com.tencent.mobileqq.activity.richmedia.i p(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new com.tencent.mobileqq.activity.richmedia.i(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static int q() {
        int i3;
        Resources resources = MobileQQ.sMobileQQ.getApplicationContext().getResources();
        if (resources == null) {
            return 0;
        }
        if (resources.getConfiguration().orientation == 2) {
            i3 = resources.getDisplayMetrics().heightPixels;
        } else {
            i3 = resources.getDisplayMetrics().widthPixels;
        }
        return (int) (i3 / resources.getDisplayMetrics().density);
    }

    public static String r(@StringRes int i3) {
        return ch.i().getString(i3);
    }

    public static String s(@StringRes int i3, Object... objArr) {
        return ch.i().getString(i3, objArr);
    }

    public static int t() {
        return MobileQQ.sMobileQQ.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    private static List<View> u(ViewGroup viewGroup, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < i3; i16++) {
            if (viewGroup.getChildAt(i16).getVisibility() == 0) {
                arrayList.add(viewGroup.getChildAt(i16));
            }
        }
        return arrayList;
    }

    public static boolean v() {
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = currentTimeMillis - f235393a.longValue();
        if (longValue > 0 && longValue < 500) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.comm.QQGuildUIUtil", 2, "time:" + currentTimeMillis + ", mLastClickTIme:" + f235393a + ", timeDiff:" + longValue);
                return true;
            }
            return true;
        }
        f235393a = Long.valueOf(currentTimeMillis);
        return false;
    }

    public static boolean w() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    public static boolean x(Context context) {
        if (context == null) {
            return false;
        }
        String configuration = context.getResources().getConfiguration().toString();
        if (!configuration.contains("hw-magic-windows") && !configuration.contains("hwMultiwindow-magic") && !configuration.contains("miui-magic-windows")) {
            return false;
        }
        return true;
    }

    public static boolean y() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    public static boolean z() {
        if (!y() && !w()) {
            return false;
        }
        return true;
    }
}
