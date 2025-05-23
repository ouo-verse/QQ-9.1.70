package com.tencent.libra.request.size;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SizeDeterminer {
    private static final int PENDING_SIZE = 0;
    private static final int SIZE_ORIGINAL = Integer.MIN_VALUE;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("SizeDeterminer");

    @Nullable
    @VisibleForTesting
    static Integer maxDisplayLength;
    private final List<SizeReadyCallback> cbs = new ArrayList();

    @Nullable
    private SizeDeterminerLayoutListener layoutListener;
    private final WeakReference<View> viewRef;
    boolean waitForLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
        private final WeakReference<SizeDeterminer> sizeDeterminerRef;

        SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
            this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
            if (sizeDeterminer != null) {
                sizeDeterminer.checkCurrentDimens();
                return true;
            }
            return true;
        }
    }

    public SizeDeterminer(@NonNull View view) {
        this.viewRef = new WeakReference<>(view);
    }

    private static int getMaxDisplayLength(@NonNull Context context) {
        if (maxDisplayLength == null) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            maxDisplayLength = Integer.valueOf(Math.max(point.x, point.y));
        }
        return maxDisplayLength.intValue();
    }

    private int getTargetDimen(int i3, int i16, int i17) {
        int i18 = i16 - i17;
        if (i18 > 0) {
            return i18;
        }
        View view = this.viewRef.get();
        if (this.waitForLayout && view != null && view.isLayoutRequested()) {
            return 0;
        }
        int i19 = i3 - i17;
        if (i19 > 0) {
            return i19;
        }
        if (view == null || view.isLayoutRequested() || i16 != -2) {
            return 0;
        }
        RFWLog.d(TAG, RFWLog.DEV, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        return getMaxDisplayLength(view.getContext());
    }

    private int getTargetHeight() {
        View view = this.viewRef.get();
        int i3 = 0;
        if (view == null) {
            return 0;
        }
        int paddingTop = view.getPaddingTop() + view.getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i3 = layoutParams.height;
        }
        return getTargetDimen(view.getHeight(), i3, paddingTop);
    }

    private int getTargetWidth() {
        View view = this.viewRef.get();
        int i3 = 0;
        if (view == null) {
            return 0;
        }
        int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i3 = layoutParams.width;
        }
        return getTargetDimen(view.getWidth(), i3, paddingLeft);
    }

    private boolean isDimensionValid(int i3) {
        if (i3 <= 0 && i3 != Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean isViewStateAndSizeValid(int i3, int i16) {
        if (isDimensionValid(i3) && isDimensionValid(i16)) {
            return true;
        }
        return false;
    }

    private void notifyCbs(int i3, int i16) {
        Iterator it = new ArrayList(this.cbs).iterator();
        while (it.hasNext()) {
            ((SizeReadyCallback) it.next()).onSizeReady(i3, i16);
        }
    }

    void checkCurrentDimens() {
        if (this.cbs.isEmpty()) {
            return;
        }
        int targetWidth = getTargetWidth();
        int targetHeight = getTargetHeight();
        if (!isViewStateAndSizeValid(targetWidth, targetHeight)) {
            return;
        }
        notifyCbs(targetWidth, targetHeight);
        clearCallbacksAndListener();
    }

    void clearCallbacksAndListener() {
        View view = this.viewRef.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
            }
        }
        this.layoutListener = null;
        this.cbs.clear();
    }

    @UiThread
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        int targetWidth = getTargetWidth();
        int targetHeight = getTargetHeight();
        if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
            sizeReadyCallback.onSizeReady(targetWidth, targetHeight);
            return;
        }
        if (!this.cbs.contains(sizeReadyCallback)) {
            this.cbs.add(sizeReadyCallback);
        }
        View view = this.viewRef.get();
        if (this.layoutListener == null && view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
            this.layoutListener = sizeDeterminerLayoutListener;
            viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
        }
    }

    void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.cbs.remove(sizeReadyCallback);
    }
}
