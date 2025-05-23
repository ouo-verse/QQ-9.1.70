package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniToast {
    public static final int ICON_DEFAULT = 0;
    public static final int ICON_ERROR = 1;
    public static final int ICON_NONE = -1;
    public static final int ICON_SUCCESS = 2;
    public static final String TAG = "QQToast";
    public static final int UNDERTHE_STATUS_BAR = 6316128;
    private static ToastHandler mHandler = new ToastHandler(Looper.getMainLooper());
    private static BlockingQueue<WeakReference<MiniToast>> mToastQueue = new LinkedBlockingQueue();
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean mIsShowing;
    private Resources mResources;
    private Toast mShowingToast;
    private long mToastEndTimeInMillisecond;
    boolean mAutoTextSize = false;
    private Drawable icon = null;
    private int mToastType = 0;
    private CharSequence message = null;
    private int mDuration = 0;
    private long mDurationInMillisecond = 2000;
    private long mLastShowedTime = 0;
    private boolean isUserTouched = false;
    private boolean mAdjustBackground = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ProtectedToast extends Toast {
        private static final int SHORT_DELAY = 2000;
        public Runnable cancelRunnable;

        public ProtectedToast(Context context) {
            super(context);
            this.cancelRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.widget.MiniToast.ProtectedToast.1
                @Override // java.lang.Runnable
                public void run() {
                    ProtectedToast.this.cancel();
                }
            };
        }

        @Override // android.widget.Toast
        public void cancel() {
            try {
                ThreadManager.getUIHandler().removeCallbacks(this.cancelRunnable);
                super.cancel();
            } catch (Throwable th5) {
                QMLog.e("QQToast", "cancel exception:" + th5.getMessage());
                super.cancel();
            }
            QMLog.d("QQToast", "cancel!");
        }

        @Override // android.widget.Toast
        public void show() {
            if (getView() != null) {
                try {
                    ThreadManager.getUIHandler().postDelayed(this.cancelRunnable, MiniToast.getDelay((TextView) getView().findViewById(R.id.toast_msg)));
                    super.show();
                } catch (Throwable th5) {
                    QMLog.e("QQToast", "show exception:" + th5.getMessage());
                    super.show();
                }
                QMLog.d("QQToast", "show");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class ToastHandler extends Handler {
        static final int MSG_HIDE_TOAST = 2;
        static final int MSG_SHOW_TOAST = 1;

        private void hideToastImmediately(MiniToast miniToast) {
            if (miniToast != null) {
                miniToast.mIsShowing = false;
                if (miniToast.mShowingToast != null) {
                    miniToast.mShowingToast.cancel();
                }
            }
        }

        private void scheduleHideToast(long j3) {
            QMLog.d("QQToast", "scheduleNextToast to " + j3);
            removeMessages(2);
            sendEmptyMessageDelayed(2, j3);
        }

        private void scheduleShowToast(MiniToast miniToast, long j3) {
            QMLog.d("QQToast", "scheduleNextToast to " + j3);
            removeMessages(1);
            MiniToast.mToastQueue.add(new WeakReference(miniToast));
            sendEmptyMessageDelayed(1, j3);
        }

        private void showToastImmediately(MiniToast miniToast) {
            int i3;
            if (miniToast == null) {
                return;
            }
            if (!miniToast.mIsShowing) {
                miniToast.mToastEndTimeInMillisecond = System.currentTimeMillis() + miniToast.mDurationInMillisecond;
                miniToast.mIsShowing = true;
            }
            miniToast.show();
            if (miniToast.mDuration == 0) {
                i3 = 200;
            } else {
                i3 = 400;
            }
            long j3 = i3;
            if (miniToast.mLastShowedTime + j3 < miniToast.mToastEndTimeInMillisecond) {
                MiniToast.mToastQueue.add(new WeakReference(miniToast));
                scheduleShowToast(miniToast, (miniToast.mLastShowedTime + j3) - System.currentTimeMillis());
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d("QQToast", "MSG_HIDE_TOAST received");
                    }
                    WeakReference weakReference = (WeakReference) MiniToast.mToastQueue.poll();
                    if (weakReference == null) {
                        return;
                    }
                    hideToastImmediately((MiniToast) weakReference.get());
                    return;
                }
                return;
            }
            if (QMLog.isColorLevel()) {
                QMLog.d("QQToast", "MSG_SHOW_TOAST received");
            }
            WeakReference weakReference2 = (WeakReference) MiniToast.mToastQueue.poll();
            if (weakReference2 == null) {
                return;
            }
            showToastImmediately((MiniToast) weakReference2.get());
        }

        ToastHandler(Looper looper) {
            super(looper);
        }
    }

    public MiniToast(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mResources = applicationContext.getResources();
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public static int getBgColor(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (useIOSLikeUI()) {
                    return -1;
                }
                return -452984832;
            }
            if (useIOSLikeUI()) {
                return -1;
            }
            return -452984832;
        }
        if (useIOSLikeUI()) {
            return -103316;
        }
        return -436310932;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getDelay(TextView textView) {
        if (textView != null && textView.getText().length() < 6) {
            return 900L;
        }
        return 1900L;
    }

    public static int getIconColor(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return -15550475;
            }
            return -7745469;
        }
        return -1;
    }

    public static int getIconRes(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return R.drawable.mini_sdk_black_tips_icon_info;
            }
            return R.drawable.mini_sdk_black_tips_icon_success;
        }
        return R.drawable.mini_sdk_black_tips_icon_caution;
    }

    private static int getTextColorType(int i3) {
        if (i3 != 1) {
            return -16777216;
        }
        return -16578533;
    }

    public static boolean isMX2() {
        if (Build.BOARD.contains("mx2")) {
            return true;
        }
        return false;
    }

    private static boolean isMeizuPhone() {
        String phoneModel = DeviceInfoUtil.getPhoneModel();
        String str = Build.BRAND;
        if ((str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) && phoneModel.equals("U20")) || (str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU) && phoneModel.equals("M3s"))) {
            return true;
        }
        return false;
    }

    public static MiniToast makeText(Context context, int i3, CharSequence charSequence, int i16) {
        MiniToast miniToast = new MiniToast(context);
        miniToast.setToastIcon(getIconRes(i3));
        miniToast.setType(i3);
        miniToast.setToastMsg(charSequence);
        miniToast.setDuration(i16);
        return miniToast;
    }

    private void setGravity(int i3, Toast toast) {
        if (useIOSLikeUI()) {
            toast.setGravity(55, 0, 0);
        } else if (i3 == 6316128) {
            toast.setGravity(55, 0, getStatusBarHeight());
        } else {
            toast.setGravity(55, 0, getTitleBarHeight());
        }
    }

    private void setOnTouchListener(final View.OnTouchListener onTouchListener, final Toast toast, View view) {
        if (useIOSLikeUI()) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qqmini.sdk.widget.MiniToast.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        QMLog.d("QQToast", "start to cancel toast");
                        toast.cancel();
                        MiniToast.this.isUserTouched = true;
                        View.OnTouchListener onTouchListener2 = onTouchListener;
                        if (onTouchListener2 == null) {
                            return true;
                        }
                        return onTouchListener2.onTouch(view2, motionEvent);
                    }
                    return false;
                }
            });
        }
    }

    public static boolean useIOSLikeUI() {
        String phoneModel = DeviceInfoUtil.getPhoneModel();
        if (!isMeizuPhone()) {
            String str = Build.BRAND;
            if (!str.equals("xiaolajiao") || !phoneModel.equals("HLJ-GM-Q1")) {
                if (!str.equals("UOOGOU") || !phoneModel.equals("UOOGOU")) {
                    if (!str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) || !phoneModel.equals("SM-A9000")) {
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

    public MiniToast adjustBackgroundView() {
        this.mAdjustBackground = true;
        return this;
    }

    public void cancel() {
        this.mIsShowing = false;
        mHandler.sendEmptyMessage(2);
    }

    public Toast create(int i3) {
        return create(i3, R.layout.mini_sdk_toast_main_layout, null);
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

    public void setAutoTextSize() {
        this.mAutoTextSize = true;
    }

    public void setDuration(int i3) {
        this.mDuration = i3;
    }

    public void setToastIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setToastMsg(CharSequence charSequence) {
        this.message = charSequence;
    }

    public void setType(int i3) {
        this.mToastType = i3;
    }

    public Toast show() {
        if (isMX2()) {
            this.mShowingToast = create(getStatusBarHeight());
        } else {
            this.mShowingToast = create(0);
        }
        if (this.mAdjustBackground) {
            adjustBackgroundView(this.mShowingToast);
        }
        this.mShowingToast.show();
        this.isUserTouched = false;
        this.mLastShowedTime = System.currentTimeMillis();
        return this.mShowingToast;
    }

    private void adjustBackgroundView(Toast toast) {
        View findViewById = toast.getView().findViewById(R.id.toast_background);
        if (findViewById != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.gravity = 1;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public Toast create(int i3, int i16, View.OnTouchListener onTouchListener) {
        ProtectedToast protectedToast = new ProtectedToast(this.mContext);
        View inflate = this.mInflater.inflate(i16, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.toast_background);
        if (findViewById != null) {
            findViewById.setElevation(6.0f);
        }
        if (this.icon != null) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_icon);
            imageView.setImageDrawable(this.icon);
            imageView.setColorFilter(getIconColor(this.mToastType), PorterDuff.Mode.MULTIPLY);
        } else {
            ((ImageView) inflate.findViewById(R.id.toast_icon)).setVisibility(8);
        }
        if (this.message != null) {
            TextView textView = (TextView) inflate.findViewById(R.id.toast_msg);
            textView.setTextColor(getTextColorType(this.mToastType));
            textView.setText(this.message);
            String charSequence = this.message.toString();
            TextPaint paint = textView.getPaint();
            float measureText = paint.measureText(charSequence);
            DisplayMetrics displayMetrics = this.mResources.getDisplayMetrics();
            float f16 = displayMetrics.widthPixels - ((displayMetrics.densityDpi / 160) * 50);
            if (measureText > f16) {
                textView.setTextSize(2, ((textView.getTextSize() * 5.0f) / 6.0f) / displayMetrics.density);
            }
            if (this.mAutoTextSize) {
                float measureText2 = paint.measureText(charSequence);
                if (measureText2 > f16) {
                    textView.setTextSize(2, ((textView.getTextSize() * f16) / measureText2) / displayMetrics.scaledDensity);
                }
            }
        }
        setGravity(i3, protectedToast);
        protectedToast.setView(inflate);
        protectedToast.setDuration(this.mDuration);
        setOnTouchListener(onTouchListener, protectedToast, inflate);
        return protectedToast;
    }

    public void setToastIcon(int i3) {
        setToastIcon(this.mResources.getDrawable(i3));
    }

    public void setToastMsg(int i3) {
        setToastMsg(this.mResources.getString(i3));
    }

    public static MiniToast makeText(Context context, int i3, int i16, int i17) {
        MiniToast miniToast = new MiniToast(context);
        miniToast.setToastIcon(getIconRes(i3));
        miniToast.setType(i3);
        miniToast.setToastMsg(i16);
        miniToast.setDuration(i17);
        return miniToast;
    }

    public static MiniToast makeText(Context context, CharSequence charSequence, int i3) {
        return makeText(context, 0, charSequence, i3);
    }

    public Toast show(int i3) {
        Toast create = create(i3);
        create.show();
        this.mLastShowedTime = System.currentTimeMillis();
        this.isUserTouched = false;
        return create;
    }

    public static MiniToast makeText(Context context, int i3, int i16) {
        return makeText(context, 0, i3, i16);
    }
}
