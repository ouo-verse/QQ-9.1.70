package com.tencent.biz.richframework.monitor.memory;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWBitmapMonitor implements IRFWBitmapMonitor {
    private static final float DEF_LIMIT_MULTIPLE = 1.5f;
    private static final int INT_NUM_ZERO = 0;
    private static final String TAG = "RFWBitmapMonitor";
    private Map<String, CheckBitmapCallParam> mBitmapCheckMap = new HashMap();
    private BitmapCheckedOption mBitmapCheckedOption;
    private WeakReference<Context> mContextWeakRef;
    private RootGlobalLayoutCallback mRootGlobalLayoutCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CheckBitmapCallParam {
        private boolean isBackgroundNotify;
        private boolean isSourceNotify;
        private Drawable mBackgroundDrawable;
        private Drawable mImageSource;
        private WeakReference<View> mViewRef;

        CheckBitmapCallParam() {
            this.isBackgroundNotify = false;
            this.isSourceNotify = false;
        }

        public Drawable getBackgroundDrawable() {
            return this.mBackgroundDrawable;
        }

        public Drawable getImageSource() {
            return this.mImageSource;
        }

        public WeakReference<View> getViewRef() {
            return this.mViewRef;
        }

        public boolean isBackgroundNotify() {
            return this.isBackgroundNotify;
        }

        public boolean isSourceNotify() {
            return this.isSourceNotify;
        }

        public void setBackgroundDrawable(Drawable drawable) {
            this.mBackgroundDrawable = drawable;
        }

        public void setBackgroundNotify(boolean z16) {
            this.isBackgroundNotify = z16;
        }

        public void setImageSource(Drawable drawable) {
            this.mImageSource = drawable;
        }

        public void setSourceNotify(boolean z16) {
            this.isSourceNotify = z16;
        }

        public void setViewRef(WeakReference<View> weakReference) {
            this.mViewRef = weakReference;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class RootGlobalLayoutCallback implements ViewTreeObserver.OnGlobalLayoutListener {
        private WeakReference<RFWBitmapMonitor> mBitmapMonitorWeak;
        private WeakReference<View> mDecorViewRef;

        public RootGlobalLayoutCallback(RFWBitmapMonitor rFWBitmapMonitor, View view) {
            this.mBitmapMonitorWeak = new WeakReference<>(rFWBitmapMonitor);
            this.mDecorViewRef = new WeakReference<>(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RFWBitmapMonitor rFWBitmapMonitor;
            WeakReference<RFWBitmapMonitor> weakReference = this.mBitmapMonitorWeak;
            View view = null;
            if (weakReference == null) {
                rFWBitmapMonitor = null;
            } else {
                rFWBitmapMonitor = weakReference.get();
            }
            if (rFWBitmapMonitor == null) {
                RFWLog.e(RFWBitmapMonitor.TAG, RFWLog.USR, "[onGlobalLayout] bitmap monitor should not be null.");
                return;
            }
            WeakReference<View> weakReference2 = this.mDecorViewRef;
            if (weakReference2 != null) {
                view = weakReference2.get();
            }
            rFWBitmapMonitor.handlerGlobalLayout(view);
        }
    }

    private void addRootGlobalLayoutChange(View view) {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver(view);
        if (viewTreeObserver == null) {
            RFWLog.e(TAG, RFWLog.USR, "[addRootGlobalLayoutChange] observer should not be null.");
            return;
        }
        RootGlobalLayoutCallback rootGlobalLayoutCallback = new RootGlobalLayoutCallback(this, view);
        this.mRootGlobalLayoutCallback = rootGlobalLayoutCallback;
        viewTreeObserver.addOnGlobalLayoutListener(rootGlobalLayoutCallback);
    }

    public static RFWBitmapMonitor createDefaultMonitor(Context context) {
        RFWBitmapMonitor rFWBitmapMonitor = new RFWBitmapMonitor();
        rFWBitmapMonitor.init(context, new BitmapCheckedOption(1.5f, true));
        return rFWBitmapMonitor;
    }

    private void findAllChildViewBitmap(@NonNull View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            findViewBitmap(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            findViewBitmap(childAt);
            findAllChildViewBitmap(childAt);
        }
    }

    private void findViewBitmap(View view) {
        String valueOf = String.valueOf(view.hashCode());
        CheckBitmapCallParam checkBitmapCallParam = this.mBitmapCheckMap.get(valueOf);
        if (checkBitmapCallParam == null) {
            checkBitmapCallParam = new CheckBitmapCallParam();
        }
        checkBitmapCallParam.setViewRef(new WeakReference<>(view));
        updateLimitMultipleImageToMap(checkBitmapCallParam, view);
        if (checkBitmapCallParam.getBackgroundDrawable() != null || checkBitmapCallParam.getImageSource() != null) {
            this.mBitmapCheckMap.put(valueOf, checkBitmapCallParam);
        }
        printLimitMultipleLog(checkBitmapCallParam);
    }

    private View getRootDecorView() {
        Context context;
        WeakReference<Context> weakReference = this.mContextWeakRef;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (!(context instanceof Activity)) {
            RFWLog.e(TAG, RFWLog.USR, "[getRootDecorView] current context not is activity, obtain root view fail.");
            return null;
        }
        Window window = ((Activity) context).getWindow();
        if (window == null) {
            RFWLog.e(TAG, RFWLog.USR, "[getRootDecorView] window should not be null.");
            return null;
        }
        return window.getDecorView();
    }

    private ViewTreeObserver getViewTreeObserver(View view) {
        if (view == null) {
            RFWLog.e(TAG, RFWLog.USR, "[getViewTreeObserver] decor view should not be null.");
            return null;
        }
        return view.getViewTreeObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerGlobalLayout(View view) {
        if (view != null && view.getVisibility() != 8 && view.getWidth() > 0 && view.getHeight() >= 0) {
            findAllChildViewBitmap(view);
        }
    }

    private boolean isEnabledChecked() {
        BitmapCheckedOption bitmapCheckedOption = this.mBitmapCheckedOption;
        if (bitmapCheckedOption != null && bitmapCheckedOption.isEnabledChecked()) {
            return true;
        }
        return false;
    }

    private boolean isLimitMultipleImage(View view, Drawable drawable) {
        float limitMultiple;
        int i3;
        int i16;
        if (view == null || drawable == null) {
            return false;
        }
        BitmapCheckedOption bitmapCheckedOption = this.mBitmapCheckedOption;
        if (bitmapCheckedOption == null) {
            limitMultiple = 1.5f;
        } else {
            limitMultiple = bitmapCheckedOption.getLimitMultiple();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            i3 = 0;
        } else {
            i3 = layoutParams.width;
        }
        if (layoutParams == null) {
            i16 = 0;
        } else {
            i16 = layoutParams.height;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (i3 <= 0 || i16 <= 0 || intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return false;
        }
        if (intrinsicWidth <= i3 * limitMultiple && intrinsicHeight <= i16 * limitMultiple) {
            return false;
        }
        return true;
    }

    private String obtainMonitorObserverInfo() {
        Context context;
        WeakReference<Context> weakReference = this.mContextWeakRef;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (context == null) {
            return "null";
        }
        return context.toString();
    }

    private void printLimitMultipleLog(CheckBitmapCallParam checkBitmapCallParam) {
        View view;
        if (checkBitmapCallParam == null) {
            RFWLog.e(TAG, RFWLog.USR, "[printLimitMultipleLog] param should not be null.");
            return;
        }
        if (checkBitmapCallParam.getViewRef() == null) {
            view = null;
        } else {
            view = checkBitmapCallParam.getViewRef().get();
        }
        if (view == null) {
            RFWLog.e(TAG, RFWLog.USR, "[printLimitMultipleLog] view should not be null.");
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            RFWLog.e(TAG, RFWLog.USR, "[printLimitMultipleLog] params should not be null.");
            return;
        }
        if (layoutParams.width > 0 && layoutParams.height > 0) {
            Drawable backgroundDrawable = checkBitmapCallParam.getBackgroundDrawable();
            String str = "";
            if (backgroundDrawable != null && !checkBitmapCallParam.isBackgroundNotify()) {
                str = "backgroundDrawable[hashCode: " + backgroundDrawable.hashCode() + ", width:" + backgroundDrawable.getIntrinsicWidth() + ", height: " + backgroundDrawable.getIntrinsicHeight() + "]";
                checkBitmapCallParam.setBackgroundNotify(true);
            }
            Drawable imageSource = checkBitmapCallParam.getImageSource();
            if (imageSource != null && !checkBitmapCallParam.isSourceNotify()) {
                str = str + "imageSource[hashCode: " + imageSource.hashCode() + ", width:" + imageSource.getIntrinsicWidth() + ", height: " + imageSource.getIntrinsicHeight() + "]";
                checkBitmapCallParam.setSourceNotify(true);
            }
            if (!TextUtils.isEmpty(str)) {
                RFWLog.e(TAG, RFWLog.USR, (str + (" | view[width:" + layoutParams.width + ", height: " + layoutParams.height + "]")) + " | view: " + view.toString());
            }
        }
    }

    private void removeRootGlobalLayoutChange(View view) {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver(view);
        if (viewTreeObserver == null) {
            RFWLog.e(TAG, RFWLog.USR, "[removeRootGlobalLayoutChange] observer should not be null.");
            return;
        }
        RootGlobalLayoutCallback rootGlobalLayoutCallback = this.mRootGlobalLayoutCallback;
        if (rootGlobalLayoutCallback == null) {
            RFWLog.e(TAG, RFWLog.USR, "[removeRootGlobalLayoutChange] root global layout ref not be null.");
        } else {
            viewTreeObserver.removeOnGlobalLayoutListener(rootGlobalLayoutCallback);
        }
    }

    private void updateLimitMultipleImageToMap(CheckBitmapCallParam checkBitmapCallParam, View view) {
        Drawable drawable;
        if (checkBitmapCallParam == null) {
            RFWLog.e(TAG, RFWLog.USR, "[checkLimitMultipleImage] param should not be null.");
            return;
        }
        if (view == null) {
            RFWLog.e(TAG, RFWLog.USR, "[checkLimitMultipleImage] element view not be null.");
            return;
        }
        Drawable background = view.getBackground();
        if (background != null && isLimitMultipleImage(view, background)) {
            checkBitmapCallParam.setBackgroundDrawable(background);
        }
        if ((view instanceof ImageView) && (drawable = ((ImageView) view).getDrawable()) != null && isLimitMultipleImage(view, drawable)) {
            checkBitmapCallParam.setImageSource(drawable);
        }
    }

    @Override // com.tencent.biz.richframework.monitor.memory.IRFWBitmapMonitor
    public void init(Context context, BitmapCheckedOption bitmapCheckedOption) {
        this.mContextWeakRef = new WeakReference<>(context);
        this.mBitmapCheckedOption = bitmapCheckedOption;
    }

    @Override // com.tencent.biz.richframework.monitor.memory.IRFWBitmapMonitor
    public void start() {
        Context context;
        if (!isEnabledChecked()) {
            return;
        }
        WeakReference<Context> weakReference = this.mContextWeakRef;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (!(context instanceof Activity)) {
            RFWLog.e(TAG, RFWLog.USR, "[start] current ");
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "[start] start bitmap size checked...[" + obtainMonitorObserverInfo() + "]");
        addRootGlobalLayoutChange(getRootDecorView());
    }

    @Override // com.tencent.biz.richframework.monitor.memory.IRFWBitmapMonitor
    public void stop() {
        if (!isEnabledChecked()) {
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "[stop] stop bitmap size checked...[" + obtainMonitorObserverInfo() + "]");
        removeRootGlobalLayoutChange(getRootDecorView());
    }
}
