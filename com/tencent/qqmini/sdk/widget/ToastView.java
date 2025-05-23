package com.tencent.qqmini.sdk.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ToastView {
    public static final int DEFAULT_DURATION = 1500;
    public static final String ICON_DEFAULT = "default";
    public static final String ICON_LOADING = "loading";
    public static final String ICON_NONE = "none";
    public static final String ICON_SUCCESS = "success";
    public static final String ICON_WARN = "warn";
    public static final int MODE_LOADING = 1;
    public static final int MODE_TOAST = 0;
    public static final String TAG = "ToastView";
    private Context mContext;
    private LayoutInflater mInflater;
    private WeakReference<ViewGroup> mParentView;
    private Resources mResources;
    private ObjectAnimator objectAnimator;
    private View toastLayout;
    private Drawable icon = null;
    private CharSequence message = null;
    private int mDuration = 1500;
    private Runnable hideJob = new Runnable() { // from class: com.tencent.qqmini.sdk.widget.ToastView.1
        @Override // java.lang.Runnable
        public void run() {
            ToastView.this.hide();
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public ToastView(Context context, ViewGroup viewGroup) {
        this.mContext = context.getApplicationContext();
        this.mResources = context.getResources();
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mParentView = new WeakReference<>(viewGroup);
    }

    private void create(int i3, String str, boolean z16) {
        int i16;
        boolean z17;
        if (isToastModeLoading(i3, str)) {
            i16 = R.layout.mini_sdk_loading_toast;
        } else {
            i16 = R.layout.mini_sdk_toast_main_layout;
        }
        if (isToastModeLoading(i3, str) && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        View inflate = this.mInflater.inflate(i16, (ViewGroup) null);
        this.toastLayout = inflate;
        inflate.setClickable(z17);
        TextView textView = (TextView) this.toastLayout.findViewById(R.id.toast_msg);
        ImageView imageView = (ImageView) this.toastLayout.findViewById(R.id.toast_icon);
        if (i3 == 1) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, BasicAnimation.KeyPath.ROTATION, 0.0f, 360.0f);
            this.objectAnimator = ofFloat;
            ofFloat.setInterpolator(new LinearInterpolator());
            this.objectAnimator.setDuration(2000L);
            this.objectAnimator.setRepeatMode(1);
            this.objectAnimator.setRepeatCount(-1);
        }
        if (this.icon != null) {
            imageView.setVisibility(0);
            imageView.setImageDrawable(this.icon);
            textView.setMaxLines(1);
        } else {
            imageView.setVisibility(8);
            textView.setGravity(17);
            if (isToastModeLoading(i3, str)) {
                textView.setMaxLines(1);
            } else {
                textView.setEms(18);
                textView.setMaxLines(2);
            }
        }
        if (TextUtils.isEmpty(this.message)) {
            textView.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = 17;
                layoutParams2.topMargin = 0;
                imageView.setLayoutParams(layoutParams2);
            }
        } else {
            if (!isToastModeLoading(i3, str)) {
                textView.setTextColor(getTextColorType(str));
            }
            textView.setText(this.message);
        }
        this.toastLayout.setX(0.0f);
        this.toastLayout.setY(getStatusBarHeight());
    }

    public static int getIconRes(String str) {
        if ("success".equals(str)) {
            return R.drawable.mini_sdk_black_tips_icon_success;
        }
        if ("warn".equals(str)) {
            return R.drawable.mini_sdk_black_tips_icon_caution;
        }
        if (ICON_LOADING.equals(str)) {
            return R.drawable.mini_sdk_loading_toast_img;
        }
        return R.drawable.mini_sdk_black_tips_icon_info;
    }

    private static int getTextColorType(String str) {
        if ("warn".equals(str)) {
            return -16578533;
        }
        "success".equals(str);
        return -16777216;
    }

    private boolean isToastModeLoading(int i3, String str) {
        if (i3 == 1) {
            return true;
        }
        if (i3 == 0 && ICON_LOADING.equals(str)) {
            return true;
        }
        return false;
    }

    private void setDuration(int i3) {
        this.mDuration = i3;
    }

    private void setToastIcon(Drawable drawable) {
        this.icon = drawable;
    }

    private void setToastMsg(CharSequence charSequence) {
        this.message = charSequence;
    }

    public int getStatusBarHeight() {
        try {
            return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception unused) {
            return (int) ((this.mResources.getDisplayMetrics().density * 25.0f) + 0.5d);
        }
    }

    public void hide() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.hideJob);
        }
        WeakReference<ViewGroup> weakReference = this.mParentView;
        if (weakReference != null && weakReference.get() != null && this.toastLayout != null) {
            this.mParentView.get().removeView(this.toastLayout);
        }
        ObjectAnimator objectAnimator = this.objectAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.objectAnimator = null;
        }
        this.icon = null;
    }

    public void onViewDestroy() {
        this.mContext = null;
        this.mParentView = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    public void show(int i3, String str, String str2, CharSequence charSequence, int i16, boolean z16) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "show iconType=" + str + ",localIconPath=" + str2 + ",msg=" + ((Object) charSequence) + ",duration=" + i16 + ",mask=" + z16);
        }
        hide();
        if (!TextUtils.isEmpty(str2)) {
            setToastIcon(new BitmapDrawable(str2));
        } else {
            setToastIcon(getIconRes(str));
        }
        setToastMsg(charSequence);
        setDuration(i16);
        create(i3, str, z16);
        show(i3);
    }

    public boolean shown() {
        View view = this.toastLayout;
        if (view == null || view.getParent() == null) {
            return false;
        }
        return true;
    }

    public void updateMsg(String str) {
        if (this.toastLayout == null) {
            return;
        }
        setToastMsg(str);
        TextView textView = (TextView) this.toastLayout.findViewById(R.id.toast_msg);
        if (TextUtils.isEmpty(this.message)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(this.message);
        }
    }

    private void setToastIcon(int i3) {
        if (i3 != 0) {
            setToastIcon(this.mResources.getDrawable(i3));
        }
    }

    private void show(int i3) {
        WeakReference<ViewGroup> weakReference = this.mParentView;
        if (weakReference != null && weakReference.get() != null && this.toastLayout != null && this.mHandler != null) {
            this.mParentView.get().addView(this.toastLayout, new ViewGroup.LayoutParams(-1, -1));
            int i16 = this.mDuration;
            if (i16 >= 0) {
                this.mHandler.postDelayed(this.hideJob, i16);
            } else if (i3 == 0) {
                this.mHandler.post(this.hideJob);
            }
        }
        ObjectAnimator objectAnimator = this.objectAnimator;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }
}
