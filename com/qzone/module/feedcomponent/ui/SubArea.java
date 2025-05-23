package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.l;
import com.qzone.module.feedcomponent.ui.ViewArea;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class SubArea implements ViewArea {
    public static final long LONG_CLICK_TRIG_TIME = 600;
    static final int POST_INVALIDATE = 100;
    static final int POST_INVALIDATE_ALL = 102;
    static final int POST_REQUESTLAYOUT = 101;
    protected static Handler longClickHandler = new LongClickHandler(Looper.getMainLooper());
    protected boolean isPressed;
    protected boolean longClickTrig;
    protected int mHeight;
    protected int mWidth;
    protected int mType = -1;
    protected WeakReference<SubAreaShell> rShell = null;
    protected WeakReference<ViewHost> viewHost = null;
    public ViewArea.OnAreaLongClickedListener longClickedListener = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static class LongClickHandler extends l {
        public LongClickHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SubAreaShell subAreaShell;
            Object obj = message.obj;
            if (obj == null) {
                return;
            }
            SubArea subArea = (SubArea) obj;
            switch (message.what) {
                case 100:
                    removeMessages(100);
                    subArea.invalidate();
                    return;
                case 101:
                    removeMessages(101);
                    subArea.requestLayout();
                    return;
                case 102:
                    subArea.invalidate();
                    return;
                default:
                    subArea.longClickTrig = true;
                    WeakReference<SubAreaShell> weakReference = subArea.rShell;
                    if (weakReference != null && (subAreaShell = weakReference.get()) != null) {
                        subAreaShell.onLongClicked(subArea);
                    }
                    ViewArea.OnAreaLongClickedListener onAreaLongClickedListener = subArea.longClickedListener;
                    if (onAreaLongClickedListener != null) {
                        onAreaLongClickedListener.onLongClicked(subArea);
                    }
                    subArea.clearTouchTarget();
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface ViewHost {
        View getAttachedView();

        void invalidate();

        void invalidateDelayed(long j3);

        void requestLayout();
    }

    public abstract boolean draw(Canvas canvas, Paint paint);

    public void drawE(Canvas canvas, Paint paint) {
        draw(canvas, paint);
    }

    public View getAttachedView() {
        ViewHost viewHost;
        SubAreaShell subAreaShell;
        WeakReference<SubAreaShell> weakReference = this.rShell;
        if (weakReference != null && (subAreaShell = weakReference.get()) != null) {
            return subAreaShell.getParent();
        }
        WeakReference<ViewHost> weakReference2 = this.viewHost;
        if (weakReference2 == null || (viewHost = weakReference2.get()) == null) {
            return null;
        }
        return viewHost.getAttachedView();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public Object getData() {
        return null;
    }

    public int getLineCount() {
        return 0;
    }

    public int getMarginTop() {
        return 0;
    }

    public Object getTag() {
        return null;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getType() {
        return this.mType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalidate() {
        ViewHost viewHost;
        SubAreaShell subAreaShell;
        WeakReference<SubAreaShell> weakReference = this.rShell;
        if (weakReference != null && (subAreaShell = weakReference.get()) != null) {
            subAreaShell.invalidate();
        }
        WeakReference<ViewHost> weakReference2 = this.viewHost;
        if (weakReference2 == null || (viewHost = weakReference2.get()) == null) {
            return;
        }
        viewHost.invalidate();
    }

    protected void invalidateDelayed(long j3) {
        ViewHost viewHost;
        SubAreaShell subAreaShell;
        WeakReference<SubAreaShell> weakReference = this.rShell;
        if (weakReference != null && (subAreaShell = weakReference.get()) != null) {
            subAreaShell.invalidateDelayed(j3);
        }
        WeakReference<ViewHost> weakReference2 = this.viewHost;
        if (weakReference2 == null || (viewHost = weakReference2.get()) == null) {
            return;
        }
        viewHost.invalidateDelayed(j3);
    }

    public boolean isLongClickTrig() {
        return this.longClickTrig;
    }

    public boolean isPressed() {
        return this.isPressed;
    }

    public boolean needDrawOnBitmap() {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        return false;
    }

    public void postInvalidate() {
        Handler handler = longClickHandler;
        handler.sendMessage(Message.obtain(handler, 100, this));
    }

    public void postInvalidateAll() {
        Handler handler = longClickHandler;
        handler.sendMessage(Message.obtain(handler, 102, this));
    }

    public void postRequestLayout() {
        Handler handler = longClickHandler;
        handler.sendMessage(Message.obtain(handler, 101, this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestLayout() {
        ViewHost viewHost;
        SubAreaShell subAreaShell;
        WeakReference<SubAreaShell> weakReference = this.rShell;
        if (weakReference != null && (subAreaShell = weakReference.get()) != null) {
            subAreaShell.requestLayout();
        }
        WeakReference<ViewHost> weakReference2 = this.viewHost;
        if (weakReference2 == null || (viewHost = weakReference2.get()) == null) {
            return;
        }
        viewHost.requestLayout();
    }

    public void setLongClickTrig(boolean z16) {
        this.longClickTrig = z16;
    }

    public void setPressed(boolean z16) {
        this.isPressed = z16;
    }

    public void setShell(SubAreaShell subAreaShell) {
        this.rShell = new WeakReference<>(subAreaShell);
    }

    public void setViewHost(ViewHost viewHost) {
        this.viewHost = new WeakReference<>(viewHost);
    }

    public void onLongClick(ViewArea.OnAreaLongClickedListener onAreaLongClickedListener) {
        if (onAreaLongClickedListener != null) {
            onAreaLongClickedListener.onLongClicked(this);
        }
    }

    protected void clearTouchTarget() {
    }

    public void recyleAreaDataHolder(AreaDataHolder areaDataHolder) {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void setMaxWidth(int i3) {
    }

    public void setTag(Object obj) {
    }

    public void setAreaData(int i3, int i16, AreaDataHolder areaDataHolder) {
    }
}
