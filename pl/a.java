package pl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.adapter.feedcomponent.j;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.util.ProcessUtils;
import ef.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u001e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u001f\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010 \u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010!\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0016\u0010$\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\rJ\u0010\u0010'\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010(\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010*\u001a\u00020\u0002R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010.R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010.R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010.R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010.R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010.\u00a8\u00067"}, d2 = {"Lpl/a;", "", "", "g", "itemGap", "defaultCount", "e", h.F, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/util/DisplayMetrics;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "y", "v", HippyTKDListViewAdapter.X, "f", "Landroid/content/Context;", "context", "B", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", "", "b", "u", "t", "p", "o", DomainData.DOMAIN_NAME, "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "c", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", "k", "i", "j", "Ljava/lang/Boolean;", "mIsPadOrFold", "mIsFlip", "I", "mListPadding", "mAlbumColumnCount", "mPhotoColumnCount", "LIST_MAX_WIDTH", "ALBUM_MAX_WIDTH", "mScreenWidthForMobile", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Boolean mIsPadOrFold;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Boolean mIsFlip;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int mListPadding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int mAlbumColumnCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int mPhotoColumnCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int mScreenWidthForMobile;

    /* renamed from: a, reason: collision with root package name */
    public static final a f426446a = new a();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final int LIST_MAX_WIDTH = d.b(575);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final int ALBUM_MAX_WIDTH = d.b(200);

    a() {
    }

    private final int e(int itemGap, int defaultCount) {
        if (mAlbumColumnCount <= 0) {
            int q16 = (q() - itemGap) / (ALBUM_MAX_WIDTH + itemGap);
            mAlbumColumnCount = q16;
            if (q16 < defaultCount) {
                mAlbumColumnCount = defaultCount;
            }
            QLog.d("QZonePadAdaptManager", 1, "calAlbumCount result: " + mAlbumColumnCount);
        }
        return mAlbumColumnCount;
    }

    private final int g() {
        if (mListPadding == 0) {
            int q16 = q();
            int i3 = LIST_MAX_WIDTH;
            if (q16 > i3) {
                mListPadding = (q() - i3) / 2;
            }
        }
        return mListPadding;
    }

    private final int h(int itemGap, int defaultCount) {
        if (mPhotoColumnCount <= 0) {
            int q16 = (q() - itemGap) / (ALBUM_MAX_WIDTH + itemGap);
            mPhotoColumnCount = q16;
            if (q16 < defaultCount) {
                mPhotoColumnCount = defaultCount;
            }
            QLog.d("QZonePadAdaptManager", 1, "calPhotoListColumnCount result: " + mPhotoColumnCount);
        }
        return mPhotoColumnCount;
    }

    private final int m() {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(e.g() * s());
        return roundToInt == 0 ? s() : roundToInt;
    }

    private final int q() {
        return r().heightPixels;
    }

    private final DisplayMetrics r() {
        Object systemService = BaseApplicationImpl.getApplication().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    private final int s() {
        return r().widthPixels;
    }

    public final boolean A() {
        return e.a() == SplitViewState.STATE_FLAT;
    }

    public final boolean B(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return y() && z(context);
    }

    public final int a(Context context, int itemGap, int defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !B(context) ? defaultValue : e(itemGap, defaultValue);
    }

    public final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (B(context)) {
            view.setPadding(g(), 0, g(), 0);
            view.setBackgroundColor(j.m());
        }
    }

    public final FrameLayout.LayoutParams c(Context context, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        layoutParams.width = o(context);
        return layoutParams;
    }

    public final int d(Context context, int itemGap, int defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !B(context) ? defaultValue : h(itemGap, defaultValue);
    }

    public final int f() {
        return (int) (q() * 0.58f);
    }

    public final int i() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (w(context)) {
            return ViewUtils.getScreenHeight() / 2;
        }
        if (x()) {
            return f();
        }
        return o(BaseApplication.getContext());
    }

    public final int j() {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(o(BaseApplication.getContext()) * 0.5625d);
        return roundToInt;
    }

    public final int k(Context context) {
        Resources resources;
        return o(context) - (2 * ((context == null || (resources = context.getResources()) == null) ? 0 : (int) resources.getDimension(R.dimen.f97104)));
    }

    public final int l(Context context) {
        return o(context) - (((int) MobileQQ.sMobileQQ.getResources().getDimension(R.dimen.f9770_)) * 2);
    }

    public final int n(Context context) {
        boolean isInMultiWindowMode;
        Configuration configuration;
        try {
        } catch (Throwable th5) {
            RFWLog.fatal("QZonePadAdaptManager", RFWLog.USR, th5);
        }
        if (y() && context != null) {
            if (Build.VERSION.SDK_INT >= 24 && (context instanceof Activity)) {
                isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
                if (isInMultiWindowMode) {
                    Resources resources = ((Activity) context).getResources();
                    if (resources != null && (configuration = resources.getConfiguration()) != null) {
                        return d.b(configuration.screenHeightDp);
                    }
                    return q();
                }
            }
            return q();
        }
        return q();
    }

    public final int o(Context context) {
        Context topActivity;
        boolean isInMultiWindowMode;
        Configuration configuration;
        try {
            topActivity = !(context instanceof Activity) ? ProcessUtils.getTopActivity() : context;
        } catch (Throwable th5) {
            RFWLog.fatal("QZonePadAdaptManager", RFWLog.USR, th5);
        }
        if ((!y() && !v()) || topActivity == null) {
            if (mScreenWidthForMobile <= 0) {
                int min = Math.min(s(), q());
                mScreenWidthForMobile = min;
                QLog.d("QZonePadAdaptManager", 1, "mScreenWidthForMobile: " + min + ", context: " + context);
            }
            return mScreenWidthForMobile;
        }
        if (A() && (topActivity instanceof SplashActivity)) {
            return m();
        }
        if (Build.VERSION.SDK_INT >= 24 && (topActivity instanceof Activity)) {
            isInMultiWindowMode = ((Activity) topActivity).isInMultiWindowMode();
            if (isInMultiWindowMode) {
                Resources resources = ((Activity) topActivity).getResources();
                if (resources != null && (configuration = resources.getConfiguration()) != null) {
                    return d.b(configuration.screenWidthDp);
                }
                return s();
            }
        }
        return s();
    }

    public final int p(Context context) {
        return q();
    }

    public final int t(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (B(context)) {
            return s();
        }
        return q();
    }

    public final int u(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (B(context)) {
            return LIST_MAX_WIDTH;
        }
        return s();
    }

    public final boolean v() {
        if (mIsFlip == null) {
            mIsFlip = Boolean.valueOf(PadUtil.e(MobileQQ.sMobileQQ.getApplicationContext()));
        }
        Boolean bool = mIsFlip;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean w(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PadUtil.a(context) == DeviceType.FOLD;
    }

    public final boolean x() {
        return PadUtil.a(MobileQQ.sMobileQQ.getApplicationContext()) == DeviceType.TABLET;
    }

    public final boolean y() {
        if (mIsPadOrFold == null) {
            DeviceType a16 = PadUtil.a(MobileQQ.sMobileQQ.getApplicationContext());
            mIsPadOrFold = Boolean.valueOf(a16 == DeviceType.TABLET || a16 == DeviceType.FOLD);
        }
        Boolean bool = mIsPadOrFold;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean z(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Configuration configuration = context.getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }
}
