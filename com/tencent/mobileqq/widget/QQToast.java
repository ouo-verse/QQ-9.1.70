package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IUIServiceProxy;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQToast {
    public static final int ICON_DEFAULT = 0;
    public static final int ICON_ERROR = 1;
    public static final int ICON_NONE = -1;
    public static final int ICON_QZONE_DEFAULT = 3;
    public static final int ICON_QZONE_ERROR = 4;
    public static final int ICON_QZONE_SHARE_MOOD = 6;
    public static final int ICON_QZONE_SUCCESS = 5;
    public static final int ICON_SUCCESS = 2;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    public static final String TAG = "QQToast";
    private static boolean mIsNeedShowToast = true;
    private static int sUseCustomToast = 1;
    private static DisplayMetrics systemDisplayMetrics;
    private Context mContext;
    private LayoutInflater mInflater;
    private Resources mResources;
    private static boolean sTestSwitch = az.f316687a;
    private static ToastHandler mHandler = new ToastHandler(Looper.getMainLooper());
    private static BlockingQueue<ShowToastMessage> mToastQueue = new LinkedBlockingQueue();
    private Drawable icon = null;
    private int iconWidth = 0;
    private int iconHeight = 0;
    private int mToastType = 0;
    private FrameLayout mRightLayout = null;
    private CharSequence message = null;
    private int mDuration = 0;
    private int mThemeId = 1000;
    boolean mAutoTextSize = false;
    private long mLastShowedTime = 0;
    private boolean isUserTouched = false;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface IToastValidListener {
        boolean canShowToast();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ProtectedToast extends QFixToast {
        private static final int LONG_DELAY = 3500;
        private static final int SHORT_DELAY = 2000;
        private static Class TNClass;
        private static Method hideMethod;
        private static Field mNextViewField;
        private static WindowManager.LayoutParams params;
        private static Method showMethod;
        public Runnable cancelRunnable;

        public ProtectedToast(Context context) {
            super(context);
            this.cancelRunnable = new Runnable() { // from class: com.tencent.mobileqq.widget.QQToast.ProtectedToast.1
                @Override // java.lang.Runnable
                public void run() {
                    ProtectedToast.this.cancel();
                }
            };
        }

        @Override // android.widget.Toast
        public void cancel() {
            if (QQToast.e()) {
                super.cancel();
                return;
            }
            if (!QQToast.canUseCustomToast()) {
                super.cancel();
                return;
            }
            try {
                if (QLog.isColorLevel()) {
                    QLog.d(QFixToast.TAG, 2, "", "cancel!");
                }
                getView().removeCallbacks(this.cancelRunnable);
                Object tNObj = getTNObj();
                if (hideMethod == null) {
                    Method declaredMethod = TNClass.getDeclaredMethod("hide", new Class[0]);
                    hideMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                hideMethod.invoke(tNObj, new Object[0]);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(QFixToast.TAG, 2, "", th5);
                }
                if (th5 instanceof NoSuchMethodException) {
                    super.cancel();
                }
            }
        }

        @Override // android.widget.Toast
        public void show() {
            long j3;
            try {
                if (getView() != null) {
                    if (!QQToast.canUseCustomToast()) {
                        super.show();
                        return;
                    }
                    Object tNObj = getTNObj();
                    if (tNObj == null) {
                        QLog.e(QFixToast.TAG, 2, "get Toast TN Field Failed");
                        QQToast.sUseCustomToast = 0;
                        super.show();
                        return;
                    }
                    if (QQToast.useIOSLikeUI()) {
                        Field declaredField = tNObj.getClass().getDeclaredField("mParams");
                        declaredField.setAccessible(true);
                        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) declaredField.get(tNObj);
                        params = layoutParams;
                        layoutParams.flags = 40;
                        layoutParams.windowAnimations = R.style.f173934na;
                        try {
                            if (("" + Build.MANUFACTURER).equalsIgnoreCase("SAMSUNG")) {
                                params.getClass().getField("layoutInDisplayCutoutMode").setInt(params, 1);
                            }
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(QFixToast.TAG, 2, QLog.getStackTraceString(e16));
                            }
                        }
                    }
                    TextView textView = (TextView) getView().findViewById(R.id.toast_msg);
                    if (textView != null && textView.getText().length() < 6) {
                        j3 = 900;
                    } else {
                        j3 = 1900;
                    }
                    getView().postDelayed(this.cancelRunnable, j3);
                    if (QLog.isColorLevel()) {
                        QLog.d(QFixToast.TAG, 2, "show");
                    }
                    if (QQToast.e()) {
                        super.show();
                        return;
                    }
                    if (TNClass == null) {
                        TNClass = Class.forName("android.widget.Toast$TN");
                    }
                    if (mNextViewField == null) {
                        Field declaredField2 = TNClass.getDeclaredField("mNextView");
                        mNextViewField = declaredField2;
                        declaredField2.setAccessible(true);
                    }
                    mNextViewField.set(tNObj, getView());
                    if (showMethod == null) {
                        Method declaredMethod = TNClass.getDeclaredMethod("show", new Class[0]);
                        showMethod = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    showMethod.invoke(tNObj, new Object[0]);
                    return;
                }
                throw new RuntimeException("setView must have been called");
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(QFixToast.TAG, 2, "", th5);
                }
                if ((th5 instanceof NoSuchMethodException) || (th5 instanceof NoSuchFieldException)) {
                    super.show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ShowToastMessage {
        private WeakReference<IToastValidListener> mListener;
        private QQToast mToast;

        ShowToastMessage(QQToast qQToast, IToastValidListener iToastValidListener) {
            this.mToast = qQToast;
            this.mListener = new WeakReference<>(iToastValidListener);
        }

        private boolean needToShow() {
            IToastValidListener iToastValidListener = this.mListener.get();
            if (iToastValidListener != null && iToastValidListener.canShowToast()) {
                return true;
            }
            return false;
        }

        @Nullable
        QQToast getToast() {
            if (needToShow()) {
                return this.mToast;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class ToastHandler extends Handler {
        static final int MSG_SHOW_TOAST = 1;
        private static final int TOAST_INTERVAL = 100;
        private long mShowingToastEndTs;

        ToastHandler(Looper looper) {
            super(looper);
            this.mShowingToastEndTs = 0L;
        }

        private void scheduleNextToast(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("QQToast", 2, "scheduleNextToast to " + j3);
            }
            removeMessages(1);
            sendEmptyMessageDelayed(1, j3);
        }

        private void showToastImmediately(ShowToastMessage showToastMessage) {
            boolean z16;
            long j3;
            QQToast toast = showToastMessage.getToast();
            long j16 = 0;
            if (toast != null) {
                toast.show();
                if (toast.mDuration == 0) {
                    j3 = 2000;
                } else {
                    j3 = 3500;
                }
                this.mShowingToastEndTs = System.currentTimeMillis() + j3;
                z16 = true;
            } else {
                z16 = false;
                j3 = 0;
            }
            if (!QQToast.mToastQueue.isEmpty()) {
                if (z16) {
                    j16 = 100 + j3;
                }
                scheduleNextToast(j16);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQToast", 2, "MSG_SHOW_TOAST received");
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = this.mShowingToastEndTs;
                if (currentTimeMillis > j3 + 100) {
                    ShowToastMessage showToastMessage = (ShowToastMessage) QQToast.mToastQueue.poll();
                    if (showToastMessage != null) {
                        showToastImmediately(showToastMessage);
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQToast", 2, "MSG_SHOW_TOAST but no message to show");
                            return;
                        }
                        return;
                    }
                }
                scheduleNextToast((j3 - currentTimeMillis) + 100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Toast f316115d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View.OnTouchListener f316116e;

        a(Toast toast, View.OnTouchListener onTouchListener) {
            this.f316115d = toast;
            this.f316116e = onTouchListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQToast", 2, "start to cancel toast");
                }
                this.f316115d.cancel();
                QQToast.this.isUserTouched = true;
                View.OnTouchListener onTouchListener = this.f316116e;
                if (onTouchListener == null) {
                    return true;
                }
                return onTouchListener.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    public QQToast(Context context) {
        if (context == null) {
            this.mContext = BaseApplication.getContext().getApplicationContext();
        } else {
            this.mContext = context.getApplicationContext();
        }
        this.mResources = this.mContext.getResources();
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public static boolean canUseCustomToast() {
        if (sUseCustomToast == 1) {
            return true;
        }
        return false;
    }

    private int dip2px(float f16) {
        DisplayMetrics displayMetrics = systemDisplayMetrics;
        if (displayMetrics == null) {
            displayMetrics = this.mContext.getResources().getDisplayMetrics();
        }
        return (int) ((f16 * displayMetrics.density) + 0.5f);
    }

    static /* bridge */ /* synthetic */ boolean e() {
        return isRemoveReflectionSwitchOn();
    }

    public static int getIconColor(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return -15550475;
                    }
                    return -7745469;
                }
                return -1;
            }
            return -7745469;
        }
        return -1;
    }

    public static int getIconRes(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return R.drawable.qui_info_filled_feedback_normal;
                    }
                    return R.drawable.qui_tick_filled_feedback_success;
                }
                return R.drawable.qui_caution_filled_feedback_error;
            }
            return R.drawable.qui_tick_filled_feedback_success;
        }
        return R.drawable.qui_caution_filled_feedback_error;
    }

    private void initSystemDisplayMetrics() {
        if (systemDisplayMetrics == null) {
            try {
                systemDisplayMetrics = ((IUIServiceProxy) QRoute.api(IUIServiceProxy.class)).getSystemDisplayMetric();
            } catch (Exception e16) {
                QLog.e("QQToast", 1, "initSystemDisplayMetrics, " + e16);
            }
        }
    }

    public static boolean isMX2() {
        if (Build.BOARD.contains("mx2")) {
            return true;
        }
        return false;
    }

    private static boolean isRemoveReflectionSwitchOn() {
        return true;
    }

    public static QQToast makeText(Context context, int i3, CharSequence charSequence, int i16) {
        return makeText(context, i3, charSequence, i16, 1000);
    }

    private boolean needStatusBarHeightCompat() {
        if (!isMX2() && !DeviceInfoMonitor.getModel().equals("SM-S9110")) {
            return false;
        }
        return true;
    }

    private void printBusinessInfo() {
        QLog.i("QQToast", 1, "show message:" + ((Object) this.message));
        if (QLog.isDevelopLevel()) {
            QLog.i("QQToast", 1, "", new Exception("QQToast show"));
        }
    }

    private void resizeUIBackToNormalMode(View view) {
        if (systemDisplayMetrics == null || view == null) {
            return;
        }
        float f16 = view.getContext().getResources().getDisplayMetrics().density / systemDisplayMetrics.density;
        if (f16 == 1.0f) {
            return;
        }
        resizeUIBackToNormalMode(view, f16);
    }

    public static void setIsNeedShowToast(boolean z16) {
        if (sTestSwitch) {
            mIsNeedShowToast = z16;
        }
    }

    public static void setTestSwitch(boolean z16) {
        sTestSwitch = z16;
    }

    public static void setUseCustomToast(int i3) {
        sUseCustomToast = i3;
    }

    public static boolean useIOSLikeUI() {
        String str = Build.BRAND;
        if (!str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) || !DeviceInfoMonitor.getModel().equals("U20")) {
            if (!str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) || !DeviceInfoMonitor.getModel().equals("M3s")) {
                if (!str.equals("xiaolajiao") || !DeviceInfoMonitor.getModel().equals("HLJ-GM-Q1")) {
                    if (!str.equals("UOOGOU") || !DeviceInfoMonitor.getModel().equals("UOOGOU")) {
                        if (str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) && DeviceInfoMonitor.getModel().equals("SM-A9000")) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public Toast create(int i3) {
        return create(i3, R.layout.b3e, null);
    }

    public int getStatusBarHeight() {
        try {
            return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return (int) ((this.mResources.getDisplayMetrics().density * 25.0f) + 0.5d);
        }
    }

    public int getTitleBarHeight() {
        try {
            return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return (int) ((this.mResources.getDisplayMetrics().density * 44.0f) + 0.5d);
        }
    }

    public boolean isShowing() {
        long j3;
        if (this.mDuration == 0) {
            j3 = 2000;
        } else {
            j3 = 3500;
        }
        if (System.currentTimeMillis() - this.mLastShowedTime <= j3 && !this.isUserTouched) {
            return true;
        }
        return false;
    }

    public void setAutoTextSize() {
        this.mAutoTextSize = true;
    }

    public void setDuration(int i3) {
        this.mDuration = i3;
    }

    public void setRightLinearlayout(FrameLayout frameLayout) {
        this.mRightLayout = frameLayout;
    }

    public void setThemeId(int i3) {
        this.mThemeId = i3;
    }

    public void setToastIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setToastIconWithSize(Drawable drawable, int i3, int i16) {
        this.icon = drawable;
        this.iconWidth = i3;
        this.iconHeight = i16;
    }

    public void setToastMsg(CharSequence charSequence) {
        this.message = charSequence;
    }

    public void setType(int i3) {
        this.mToastType = i3;
    }

    public Toast show() {
        Toast create;
        if (isMX2()) {
            create = create(getStatusBarHeight());
        } else {
            create = create(0);
        }
        printBusinessInfo();
        if (sTestSwitch && !mIsNeedShowToast) {
            return create;
        }
        create.show();
        this.isUserTouched = false;
        this.mLastShowedTime = System.currentTimeMillis();
        return create;
    }

    public void showByQueue(IToastValidListener iToastValidListener) {
        mToastQueue.add(new ShowToastMessage(this, iToastValidListener));
        mHandler.sendEmptyMessage(1);
        if (QLog.isColorLevel()) {
            QLog.d("QQToast", 2, "current queue size is " + mToastQueue.size());
        }
    }

    public Toast showTouchableToast(int i3, int i16, View.OnTouchListener onTouchListener) {
        Toast create = create(i3, i16, onTouchListener);
        if (sTestSwitch && !mIsNeedShowToast) {
            return create;
        }
        create.show();
        this.mLastShowedTime = System.currentTimeMillis();
        this.isUserTouched = false;
        return create;
    }

    public static QQToast makeText(Context context, int i3, CharSequence charSequence, int i16, int i17) {
        QQToast qQToast = new QQToast(context);
        qQToast.setToastIcon(getIconRes(i3));
        qQToast.setType(i3);
        qQToast.setToastMsg(charSequence);
        qQToast.setDuration(i16);
        qQToast.setThemeId(i17);
        return qQToast;
    }

    public Toast create(int i3, int i16, View.OnTouchListener onTouchListener) {
        int titleBarHeight;
        TextView textView;
        ProtectedToast protectedToast = new ProtectedToast(this.mContext);
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        initSystemDisplayMetrics();
        View inflate = this.mInflater.inflate(i16, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.js9);
        findViewById.setElevation(20.0f);
        findViewById.setBackground(ie0.a.f().k(this.mContext, R.color.qui_common_bg_top_light, dip2px(12.0f), this.mThemeId));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.jse);
        FrameLayout frameLayout = this.mRightLayout;
        if (frameLayout != null) {
            linearLayout.addView(frameLayout);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
        Drawable drawable = this.icon;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
            if (this.iconWidth > 0 && this.iconHeight > 0) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = this.iconHeight;
                layoutParams.width = this.iconWidth;
                imageView.setLayoutParams(layoutParams);
            }
        } else {
            imageView.setVisibility(8);
        }
        if (this.message != null) {
            TextView textView2 = (TextView) inflate.findViewById(R.id.toast_msg);
            textView2.setTextSize(2, 16.0f);
            textView2.setTextColor(ie0.a.f().h(this.mContext, R.color.qui_common_text_primary, this.mThemeId));
            textView2.setText(this.message);
            resizeUIBackToNormalMode(textView2);
            textView2.setMaxWidth(dip2px(256.0f));
        }
        if (needStatusBarHeightCompat()) {
            titleBarHeight = getStatusBarHeight();
        } else {
            titleBarHeight = useIOSLikeUI() ? 0 : getTitleBarHeight();
        }
        protectedToast.setGravity(55, 0, titleBarHeight);
        resizeUIBackToNormalMode(findViewById);
        resizeUIBackToNormalMode(imageView);
        protectedToast.setView(inflate);
        protectedToast.setDuration(this.mDuration);
        if (useIOSLikeUI()) {
            if (isNowSimpleUI && (textView = (TextView) inflate.findViewById(R.id.mfl)) != null) {
                textView.setTextColor(this.mResources.getColor(R.color.skin_color_ff3b7fe5));
                textView.setTextSize(2, 16.0f);
                resizeUIBackToNormalMode(textView);
            }
            inflate.setOnTouchListener(new a(protectedToast, onTouchListener));
        }
        return protectedToast;
    }

    public void setToastIcon(int i3) {
        setToastIcon(this.mResources.getDrawable(i3));
    }

    public void setToastMsg(int i3) {
        setToastMsg(this.mResources.getString(i3));
    }

    private void resizeUIBackToNormalMode(View view, float f16) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = Math.round(marginLayoutParams.width / f16);
            marginLayoutParams.height = Math.round(marginLayoutParams.height / f16);
            marginLayoutParams.leftMargin = Math.round(marginLayoutParams.leftMargin / f16);
            marginLayoutParams.rightMargin = Math.round(marginLayoutParams.rightMargin / f16);
            marginLayoutParams.topMargin = Math.round(marginLayoutParams.topMargin / f16);
            marginLayoutParams.bottomMargin = Math.round(marginLayoutParams.bottomMargin / f16);
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(0, textView.getTextSize() / f16);
        }
    }

    public static QQToast makeText(Context context, int i3, int i16, int i17) {
        return makeText(context, i3, i16, i17, 1000);
    }

    public static QQToast makeText(Context context, int i3, int i16, int i17, int i18) {
        QQToast qQToast = new QQToast(context);
        qQToast.setToastIcon(getIconRes(i3));
        qQToast.setType(i3);
        qQToast.setToastMsg(i16);
        qQToast.setDuration(i17);
        qQToast.setThemeId(i18);
        return qQToast;
    }

    public Toast show(int i3) {
        Toast create = create(i3);
        if (sTestSwitch && !mIsNeedShowToast) {
            return create;
        }
        create.show();
        this.mLastShowedTime = System.currentTimeMillis();
        this.isUserTouched = false;
        return create;
    }

    public static QQToast makeText(Context context, CharSequence charSequence, int i3) {
        return makeText(context, 0, charSequence, i3);
    }

    public static QQToast makeText(Context context, CharSequence charSequence, int i3, int i16) {
        return makeText(context, 0, charSequence, i3, i16);
    }

    public static QQToast makeText(Context context, int i3, int i16) {
        return makeText(context, 0, i3, i16);
    }

    public static QQToast makeText(Context context, int i3, String str, FrameLayout frameLayout, int i16) {
        QQToast qQToast = new QQToast(context);
        qQToast.setToastIcon(getIconRes(i3));
        qQToast.setType(i3);
        qQToast.setToastMsg(str);
        qQToast.setDuration(i16);
        qQToast.setRightLinearlayout(frameLayout);
        return qQToast;
    }
}
