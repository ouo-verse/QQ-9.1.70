package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.l;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.text.TextCell;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SubAreaShell implements ViewArea, ViewShell, ViewArea.OnAreaClickedListener, ViewArea.OnAreaLongClickedListener {
    static final int MAX_POOL_SIZE = 100;
    static Paint sDebugPaint;
    SubArea area;
    OnAreaClickListener clickListener;
    OnAreaLongClickListener longClickListener;
    int mLeft;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    int mTop;
    static final ConcurrentLinkedQueue<SubAreaShell> mCacheList = new ConcurrentLinkedQueue<>();
    protected static Handler mHanlder = new l(Looper.getMainLooper());
    protected static final boolean LOWER_ICE_CREAM = false;
    WeakReference<View> mParent = new WeakReference<>(null);
    private boolean enableShellClicked = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnAreaClickListener {
        void onAreaClicked(SubAreaShell subAreaShell, TextCell textCell);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnAreaLongClickListener {
        void onLongClicked(SubAreaShell subAreaShell);
    }

    SubAreaShell() {
    }

    public static void clearAreaList(ArrayList<SubAreaShell> arrayList) {
        Iterator<SubAreaShell> it = arrayList.iterator();
        while (it.hasNext()) {
            recycle(it.next());
        }
        arrayList.clear();
    }

    static Paint getShellDebugPaint() {
        if (sDebugPaint == null) {
            Paint paint = new Paint();
            sDebugPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            sDebugPaint.setColor(-16776961);
        }
        return sDebugPaint;
    }

    public static void loadPool() {
        for (int size = 100 - mCacheList.size(); size > 0; size--) {
            mCacheList.add(new SubAreaShell());
        }
    }

    public static SubAreaShell obtain(SubArea subArea) {
        SubAreaShell poll = mCacheList.poll();
        if (poll == null) {
            poll = new SubAreaShell();
        }
        poll.setArea(subArea);
        return poll;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
        SubArea subArea = this.area;
        if (subArea != null) {
            subArea.clearTouchingEvent();
        }
    }

    public void draw(Canvas canvas, Paint paint) {
        try {
            canvas.save();
            canvas.translate(this.mPaddingLeft, this.mPaddingTop);
            SubArea subArea = this.area;
            if (subArea != null && !subArea.draw(canvas, paint)) {
                canvas.restore();
                mHanlder.postDelayed(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.SubAreaShell.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SubAreaShell.this.invalidate();
                    }
                }, 800L);
                return;
            }
            canvas.restore();
            if (FeedGlobalEnv.g().isViewDebugMode()) {
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getShellDebugPaint());
            }
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.d("Feed", "exception when draw subArea.", e16);
        }
    }

    public boolean drawE(Canvas canvas, Paint paint) {
        boolean z16;
        canvas.save();
        canvas.translate(this.mPaddingLeft, this.mPaddingTop);
        if (!com.qzone.adapter.feedcomponent.i.H().V()) {
            this.area.drawE(canvas, paint);
            z16 = true;
        } else {
            this.area.draw(canvas, paint);
            z16 = false;
        }
        canvas.restore();
        if (FeedGlobalEnv.g().isViewDebugMode()) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getShellDebugPaint());
        }
        return z16;
    }

    public SubArea getArea() {
        return this.area;
    }

    public int getBottom() {
        return getTop() + getHeight();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public Object getData() {
        return this.area.getData();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        SubArea subArea = this.area;
        if (subArea == null) {
            return 0;
        }
        return subArea.getHeight() + this.mPaddingBottom + this.mPaddingTop;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public View getParent() {
        return this.mParent.get();
    }

    public Rect getRect() {
        return new Rect(this.mLeft, this.mTop, getRight(), getBottom());
    }

    public int getRight() {
        return getLeft() + getWidth();
    }

    public SubArea getSubArea() {
        return this.area;
    }

    public int getTop() {
        return this.mTop;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getType() {
        return this.area.getType();
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        SubArea subArea = this.area;
        if (subArea == null) {
            return 0;
        }
        return subArea.getWidth() + this.mPaddingLeft + this.mPaddingRight;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewShell
    public void invalidate() {
        View view = this.mParent.get();
        if (view != null) {
            if (LOWER_ICE_CREAM) {
                view.invalidate();
            } else {
                view.invalidate(0, getTop(), view.getWidth(), getBottom());
            }
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewShell
    public void invalidateDelayed(long j3) {
        View view = this.mParent.get();
        if (view != null) {
            if (j3 <= 0) {
                invalidate();
            } else {
                view.postInvalidateDelayed(j3);
            }
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
        SubArea subArea = this.area;
        if (subArea != null) {
            subArea.measure(i3, i16);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaClickedListener
    public void onAreaClicked(ViewArea viewArea, TextCell textCell) {
        OnAreaClickListener onAreaClickListener = this.clickListener;
        if (onAreaClickListener != null) {
            onAreaClickListener.onAreaClicked(this, textCell);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaLongClickedListener
    public void onLongClicked(ViewArea viewArea) {
        OnAreaLongClickListener onAreaLongClickListener = this.longClickListener;
        if (onAreaLongClickListener != null) {
            onAreaLongClickListener.onLongClicked(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (!this.enableShellClicked && (x16 < this.mPaddingLeft || y16 < this.mPaddingTop)) {
            return false;
        }
        motionEvent.offsetLocation(this.mPaddingLeft * (-1), this.mPaddingTop * (-1));
        return this.area.onTouchEvent(motionEvent, this, this.longClickListener != null);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewShell
    public void requestLayout() {
        View view = this.mParent.get();
        if (view != null) {
            view.requestLayout();
        }
    }

    void reset() {
        SubArea subArea = this.area;
        if (subArea != null) {
            subArea.rShell = null;
            this.area = null;
        }
        this.mTop = 0;
        this.mLeft = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mParent = new WeakReference<>(null);
        this.clickListener = null;
        this.longClickListener = null;
        this.enableShellClicked = false;
    }

    void setArea(SubArea subArea) {
        this.area = subArea;
        subArea.setShell(this);
    }

    public void setLeft(int i3) {
        this.mLeft = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void setMaxWidth(int i3) {
        SubArea subArea = this.area;
        if (subArea != null) {
            subArea.setMaxWidth(i3);
        }
    }

    public void setOnClickListener(OnAreaClickListener onAreaClickListener) {
        this.clickListener = onAreaClickListener;
    }

    public void setOnLongClickListener(OnAreaLongClickListener onAreaLongClickListener) {
        this.longClickListener = onAreaLongClickListener;
    }

    public void setPaddingBottom(int i3) {
        this.mPaddingBottom = i3;
    }

    public void setPaddingLeft(int i3) {
        this.mPaddingLeft = i3;
    }

    public void setPaddingRight(int i3) {
        this.mPaddingRight = i3;
    }

    public void setPaddingTop(int i3) {
        this.mPaddingTop = i3;
    }

    public void setParent(View view) {
        this.mParent = new WeakReference<>(view);
    }

    public void setTop(int i3) {
        this.mTop = i3;
    }

    public void enableShellClick() {
        this.enableShellClicked = true;
    }

    public static void clearAreaList(LinkedList<SubAreaShell> linkedList) {
        Iterator<SubAreaShell> it = linkedList.iterator();
        while (it.hasNext()) {
            recycle(it.next());
        }
        linkedList.clear();
    }

    public static void recycle(SubAreaShell subAreaShell) {
        if (subAreaShell == null) {
            return;
        }
        subAreaShell.reset();
        ConcurrentLinkedQueue<SubAreaShell> concurrentLinkedQueue = mCacheList;
        if (concurrentLinkedQueue.size() < 100) {
            concurrentLinkedQueue.add(subAreaShell);
        }
    }

    public void draw(Canvas canvas, Paint paint, int i3, int i16) {
        canvas.save();
        canvas.translate(this.mPaddingLeft + i3, this.mPaddingTop + i16);
        this.area.draw(canvas, paint);
        canvas.restore();
        if (FeedGlobalEnv.g().isViewDebugMode()) {
            Paint shellDebugPaint = getShellDebugPaint();
            canvas.save();
            canvas.translate(this.mPaddingLeft + i3, this.mPaddingTop + i16);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), shellDebugPaint);
            canvas.restore();
        }
    }
}
