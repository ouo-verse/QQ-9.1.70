package com.tencent.mtt.hippy.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.uimanager.e;
import com.tencent.mtt.hippy.uimanager.m;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyViewGroup extends HippyImageView implements e {
    private static final int LAYER_TYPE_NOT_SET = -1;
    private static final String TAG = "HippyViewGroup";
    boolean isHandlePullUp;
    private boolean mDisallowIntercept;
    float mDownX;
    float mDownY;
    private final m mDrawingOrderHelper;
    private int mOldLayerType;
    private String mOverflow;
    private Path mOverflowPath;
    private RectF mOverflowRect;
    private ViewConfiguration mViewConfiguration;

    public HippyViewGroup(Context context) {
        super(context);
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.isHandlePullUp = false;
        this.mDisallowIntercept = false;
        this.mDrawingOrderHelper = new m(this);
        this.mOldLayerType = -1;
        setScaleType(AsyncImageView.ScaleType.ORIGIN);
    }

    private void restoreLayerType() {
        int i3 = this.mOldLayerType;
        if (i3 > -1) {
            setLayerType(i3, null);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        super.addView(view, i3);
        this.mDrawingOrderHelper.a(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        Path path;
        String str = this.mOverflow;
        if (str != null) {
            str.hashCode();
            if (!str.equals("hidden")) {
                if (str.equals(NodeProps.VISIBLE) && (path = this.mOverflowPath) != null) {
                    path.rewind();
                }
            } else if (this.mBGDrawable != null) {
                float width = getWidth();
                float height = getHeight();
                if (this.mBGDrawable.getBorderWidthArray() != null && this.mBGDrawable.getBorderWidthArray()[0] != 0.0f) {
                    float f19 = this.mBGDrawable.getBorderWidthArray()[0];
                    f17 = f19 + 0.0f;
                    width -= f19;
                    height -= f19;
                    f16 = f17;
                } else {
                    f16 = 0.0f;
                    f17 = 0.0f;
                }
                if (this.mBGDrawable.getBorderRadiusArray() != null) {
                    f18 = this.mBGDrawable.getBorderRadiusArray()[0];
                } else {
                    f18 = 0.0f;
                }
                if (f18 > 0.0f) {
                    if (this.mOverflowPath == null) {
                        this.mOverflowPath = new Path();
                    }
                    this.mOverflowPath.rewind();
                    if (this.mOverflowRect == null) {
                        this.mOverflowRect = new RectF();
                    }
                    this.mOverflowRect.set(f17, f16, width, height);
                    this.mOverflowPath.addRoundRect(this.mOverflowRect, f18, f18, Path.Direction.CW);
                    try {
                        canvas.clipPath(this.mOverflowPath);
                    } catch (Throwable unused) {
                    }
                }
            }
            restoreLayerType();
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        return this.mDrawingOrderHelper.a(i3, i16);
    }

    public int getZIndexMappedChildIndex(int i3) {
        if (this.mDrawingOrderHelper.a()) {
            return this.mDrawingOrderHelper.a(getChildCount(), i3);
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        NativeGestureDispatcher nativeGestureDispatcher;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.isHandlePullUp = false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        NativeGestureDispatcher nativeGestureDispatcher2 = this.mGestureDispatcher;
        if (nativeGestureDispatcher2 != null) {
            onInterceptTouchEvent |= nativeGestureDispatcher2.needHandle(NodeProps.ON_INTERCEPT_TOUCH_EVENT);
        }
        if (!onInterceptTouchEvent && (nativeGestureDispatcher = this.mGestureDispatcher) != null && nativeGestureDispatcher.needHandle(NodeProps.ON_INTERCEPT_PULL_UP_EVENT)) {
            if (action == 2 && !this.isHandlePullUp) {
                if (this.mViewConfiguration == null) {
                    this.mViewConfiguration = new ViewConfiguration();
                }
                float x16 = motionEvent.getX() - this.mDownX;
                float y16 = motionEvent.getY() - this.mDownY;
                if (y16 < 0.0f && Math.abs(x16) < Math.abs(y16) && Math.abs(y16) > this.mViewConfiguration.getScaledTouchSlop()) {
                    this.mGestureDispatcher.handle(NodeProps.ON_TOUCH_DOWN, this.mDownX, this.mDownY);
                    this.isHandlePullUp = true;
                }
            }
            return this.isHandlePullUp;
        }
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0 && this.mDisallowIntercept) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        this.mDrawingOrderHelper.b(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.views.list.HippyRecycler
    public void resetProps() {
        HippyViewGroupController.removeViewZIndex(this);
        this.mOverflow = null;
        setClipChildren(true);
    }

    public void setDisallowIntercept(boolean z16) {
        this.mDisallowIntercept = z16;
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        setOverflow(str, this);
    }

    @Override // com.tencent.mtt.hippy.uimanager.e
    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.b();
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.a());
        invalidate();
    }

    public static void setOverflow(String str, @NonNull ViewGroup viewGroup) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("hidden")) {
            z16 = true;
        } else {
            if (!str.equals(NodeProps.VISIBLE)) {
                LogUtils.w(TAG, "setOverflow: Unknown overflow type =" + str);
                return;
            }
            z16 = false;
        }
        viewGroup.setClipChildren(z16);
        viewGroup.invalidate();
    }
}
