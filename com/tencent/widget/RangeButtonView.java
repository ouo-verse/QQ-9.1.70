package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQUIAppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RangeButtonView extends View {
    static IPatchRedirector $redirector_;
    private int currentPosition;
    private boolean enableTalkBack;
    private boolean isTitleUp2Line;
    private List<String> mContentDesc;
    private OnChangeListener mListener;
    private RangeButtonTouchHelper mTouchHelper;
    private TextPaint paint;
    RangeButtonParams params;
    private TitleDrawer tDrawer;
    private Bitmap thumbBmp;
    private ThumbDrawer thumbDrawer;
    private List<Title> titles;
    private UnitBar unitBar;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnChangeListener {
        void onChange(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class RangeButtonParams {
        static IPatchRedirector $redirector_;
        public int alignType;
        public float barLeftPadding;
        public float barRightPadding;
        public int lineColor;
        public float lineHeight;
        public float lineOffset;
        public float lineWeight;
        public int thumbSrcId;
        public int titleColor;
        public float titleTopPadding;
        public int unitCount;

        RangeButtonParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RangeButtonView.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class RangeButtonTouchHelper extends ExploreByTouchHelper {
        static IPatchRedirector $redirector_;

        public RangeButtonTouchHelper(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RangeButtonView.this, (Object) view);
            }
        }

        public Rect getBoundsForIndex(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Rect) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            Point point = RangeButtonView.this.unitBar.getUnitPoints().get(i3);
            int thumbHeight = RangeButtonView.this.thumbDrawer.getThumbHeight() / 2;
            int i16 = point.x;
            int i17 = point.y;
            return new Rect(i16 - thumbHeight, i17 - thumbHeight, i16 + thumbHeight, i17 + thumbHeight);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).intValue();
            }
            RangeButtonView rangeButtonView = RangeButtonView.this;
            return rangeButtonView.resetThumbPosition((int) f16, (int) f17, rangeButtonView.unitBar.getUintSpace() / 2, RangeButtonView.this.thumbDrawer.getThumbHeight() / 2, false);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
                return;
            }
            for (int i3 = 0; i3 < RangeButtonView.this.titles.size(); i3++) {
                list.add(Integer.valueOf(i3));
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), bundle)).booleanValue();
            }
            if (i16 != 16 || RangeButtonView.this.unitBar == null || RangeButtonView.this.thumbDrawer == null) {
                return false;
            }
            if (i3 != RangeButtonView.this.currentPosition && i3 != -1) {
                if (RangeButtonView.this.mListener != null) {
                    RangeButtonView.this.mListener.onChange(RangeButtonView.this.currentPosition, i3);
                }
                RangeButtonView.this.currentPosition = i3;
                RangeButtonView.this.invalidate();
            }
            return true;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) accessibilityEvent);
            } else if (RangeButtonView.this.mContentDesc != null && RangeButtonView.this.mContentDesc.size() > i3) {
                accessibilityEvent.setContentDescription((CharSequence) RangeButtonView.this.mContentDesc.get(i3));
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) accessibilityNodeInfoCompat);
                return;
            }
            if (RangeButtonView.this.mContentDesc != null && RangeButtonView.this.mContentDesc.size() > i3) {
                String str = (String) RangeButtonView.this.mContentDesc.get(i3);
                if (i3 == RangeButtonView.this.currentPosition) {
                    str = str + HardCodeUtil.qqStr(R.string.shl);
                }
                accessibilityNodeInfoCompat.setContentDescription(str);
            }
            accessibilityNodeInfoCompat.addAction(16);
            accessibilityNodeInfoCompat.setBoundsInParent(getBoundsForIndex(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ThumbDrawer {
        static IPatchRedirector $redirector_;
        public Bitmap bitmap;
        public int left;
        public int top;

        public ThumbDrawer(int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            } else {
                this.bitmap = bitmap;
                calculatePosition(i3, i16);
            }
        }

        public void calculatePosition(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            int width = this.bitmap.getWidth();
            int height = this.bitmap.getHeight();
            this.left = i3 - (width / 2);
            this.top = i16 - (height / 2);
        }

        public void draw(Canvas canvas, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas, (Object) paint);
            } else {
                canvas.drawBitmap(this.bitmap, this.left, this.top, paint);
            }
        }

        public int getThumbHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            Bitmap bitmap = this.bitmap;
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getHeight();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class TitleDrawer {
        static IPatchRedirector $redirector_;
        private List<Title> titles;

        public TitleDrawer(List<Title> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RangeButtonView.this, (Object) list);
            } else {
                this.titles = list;
            }
        }

        public void drawTitles(Canvas canvas, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas, (Object) paint);
                return;
            }
            List<Title> list = this.titles;
            if (list == null) {
                return;
            }
            Iterator<Title> it = list.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas, paint, RangeButtonView.this.params);
            }
        }

        public void setTitlePoints(ArrayList<Integer> arrayList, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList, i3);
                return;
            }
            if (this.titles == null) {
                return;
            }
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                Title title = this.titles.get(i16);
                title.point = new Point(arrayList.get(i16).intValue() - (title.getTextWidth() >> 1), i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class UnitBar {
        static IPatchRedirector $redirector_;
        private int centerY;
        private int endX;
        private float height;
        private int startX;
        private int unitNum;
        private ArrayList<Point> unitPoints;

        public UnitBar(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.unitPoints = new ArrayList<>();
            this.startX = i3;
            this.endX = i16;
            this.centerY = i17;
            this.unitNum = i18;
            this.unitPoints = calculatePoints(i3, i16, i17, i18);
        }

        public ArrayList<Point> calculatePoints(int i3, int i16, int i17, int i18) {
            int i19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (ArrayList) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            }
            ArrayList<Point> arrayList = new ArrayList<>(i18);
            int i26 = (int) ((i16 - i3) / (i18 - 1.0f));
            for (int i27 = 0; i27 < i18; i27++) {
                if (i27 == 0) {
                    i19 = 0;
                } else {
                    i19 = i26;
                }
                Point point = new Point(i3 + i19, i17);
                arrayList.add(point);
                i3 = point.x;
            }
            return arrayList;
        }

        public void drawBar(Canvas canvas, Paint paint, RangeButtonParams rangeButtonParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, canvas, paint, rangeButtonParams);
                return;
            }
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            paint.setColor(rangeButtonParams.lineColor);
            paint.setStrokeWidth(rangeButtonParams.lineWeight);
            float f16 = this.startX;
            int i3 = this.centerY;
            canvas.drawLine(f16, i3, this.endX, i3, paint);
            Iterator<Point> it = this.unitPoints.iterator();
            while (it.hasNext()) {
                Point next = it.next();
                int i16 = next.x;
                int i17 = next.y;
                float f17 = this.height;
                canvas.drawLine(i16, i17 - (f17 / 2.0f), i16, i17 + (f17 / 2.0f), paint);
            }
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
        }

        public int getCenterY() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.centerY;
        }

        public float getHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
            }
            return this.height;
        }

        public int getUintSpace() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (int) ((this.endX - this.startX) / (this.unitNum - 1.0f));
        }

        public int getUnitNum() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.unitNum;
        }

        public ArrayList<Point> getUnitPoints() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.unitPoints;
        }

        public void setHeight(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            } else {
                this.height = f16;
            }
        }

        public void setUnitNum(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.unitNum = i3;
            }
        }
    }

    public RangeButtonView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    private float calculateMaxTextHeight() {
        if (this.titles != null) {
            TextPaint textPaint = new TextPaint();
            Iterator<Title> it = this.titles.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                textPaint.setTextSize(it.next().textSize);
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                if (i3 - Math.abs(fontMetrics.top) < 0.0f) {
                    i3 = (int) Math.abs(fontMetrics.top);
                }
            }
            return i3;
        }
        return dp2px(120.0f);
    }

    private float calculateMinViewHeight() {
        float f16;
        float calculateMaxTextHeight = calculateMaxTextHeight();
        RangeButtonParams rangeButtonParams = this.params;
        float f17 = calculateMaxTextHeight + rangeButtonParams.lineOffset;
        float f18 = rangeButtonParams.lineHeight;
        Bitmap bitmap = this.thumbBmp;
        if (bitmap != null) {
            f16 = bitmap.getHeight();
        } else {
            f16 = 0.0f;
        }
        return f17 + Math.max(f18, f16);
    }

    private float dp2px(float f16) {
        return TypedValue.applyDimension(1, f16, getResources().getDisplayMetrics());
    }

    public static float measureTextWidth(String str, float f16) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f16);
        return textPaint.measureText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int resetThumbPosition(int i3, int i16, int i17, int i18, boolean z16) {
        ArrayList<Point> unitPoints = this.unitBar.getUnitPoints();
        for (int i19 = 0; i19 < unitPoints.size(); i19++) {
            Point point = unitPoints.get(i19);
            int i26 = point.y;
            int i27 = i26 + i18;
            if (i16 < i26 - i18 || i16 > i27) {
                break;
            }
            int i28 = point.x;
            int i29 = i28 + i17;
            if (i3 > i28 - i17 && i3 < i29) {
                if (z16) {
                    this.thumbDrawer.calculatePosition(i28, i26);
                }
                return i19;
            }
        }
        return -1;
    }

    public void clearTitleDrawer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.tDrawer = null;
            requestLayout();
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if ((QQUIAppSetting.enableTalkBack() || this.enableTalkBack) && this.mTouchHelper.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int getThumbPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.currentPosition;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.tDrawer == null) {
            this.params.unitCount = this.titles.size();
            int paddingLeft = (int) (getPaddingLeft() + this.params.barLeftPadding);
            int width = (int) ((getWidth() - this.params.barRightPadding) - getPaddingRight());
            if (this.isTitleUp2Line) {
                RangeButtonParams rangeButtonParams = this.params;
                i3 = (int) (rangeButtonParams.titleTopPadding + rangeButtonParams.lineOffset + calculateMaxTextHeight());
            } else {
                float f16 = this.params.titleTopPadding;
                if (this.thumbBmp == null) {
                    height = 0.0f;
                } else {
                    height = r3.getHeight() / 2.0f;
                }
                i3 = (int) (f16 + height);
            }
            UnitBar unitBar = new UnitBar(paddingLeft, width, i3, this.params.unitCount);
            this.unitBar = unitBar;
            unitBar.setHeight(this.params.lineHeight);
            ArrayList<Point> unitPoints = this.unitBar.getUnitPoints();
            ArrayList<Integer> arrayList = new ArrayList<>(unitPoints.size());
            Iterator<Point> it = unitPoints.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().x));
            }
            Point point = this.unitBar.getUnitPoints().get(this.currentPosition);
            Bitmap bitmap = this.thumbBmp;
            if (bitmap != null) {
                this.thumbDrawer = new ThumbDrawer(point.x, point.y, bitmap);
            }
            TitleDrawer titleDrawer = new TitleDrawer(this.titles);
            this.tDrawer = titleDrawer;
            if (this.isTitleUp2Line) {
                titleDrawer.setTitlePoints(arrayList, (int) (this.params.titleTopPadding + calculateMaxTextHeight()));
            } else {
                int max = (int) Math.max(this.thumbDrawer.getThumbHeight(), this.unitBar.getHeight());
                TitleDrawer titleDrawer2 = this.tDrawer;
                RangeButtonParams rangeButtonParams2 = this.params;
                titleDrawer2.setTitlePoints(arrayList, (int) (rangeButtonParams2.titleTopPadding + max + rangeButtonParams2.lineOffset));
            }
        }
        this.tDrawer.drawTitles(canvas, this.paint);
        this.unitBar.drawBar(canvas, this.paint, this.params);
        this.thumbDrawer.draw(canvas, this.paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int calculateMinViewHeight = (int) calculateMinViewHeight();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i17 = size;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(calculateMinViewHeight, size2);
        } else if (mode2 != 1073741824) {
            size2 = (int) (calculateMinViewHeight + getPaddingTop() + this.params.titleTopPadding);
        }
        setMeasuredDimension(i17, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action == 0 || action == 1 || action == 2 || action == 3) {
            UnitBar unitBar = this.unitBar;
            if (unitBar != null && this.thumbDrawer != null) {
                int resetThumbPosition = resetThumbPosition((int) x16, (int) y16, unitBar.getUintSpace() / 2, this.thumbDrawer.getThumbHeight() / 2, true);
                int i3 = this.currentPosition;
                if (resetThumbPosition != i3 && resetThumbPosition != -1) {
                    OnChangeListener onChangeListener = this.mListener;
                    if (onChangeListener != null) {
                        onChangeListener.onChange(i3, resetThumbPosition);
                    }
                    this.currentPosition = resetThumbPosition;
                    invalidate();
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void setContentDescList(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        } else {
            this.mContentDesc = list;
        }
    }

    public void setOnChangerListener(OnChangeListener onChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onChangeListener);
        } else {
            this.mListener = onChangeListener;
        }
    }

    public void setThumbPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        this.currentPosition = i3;
        UnitBar unitBar = this.unitBar;
        if (unitBar == null) {
            return;
        }
        Point point = unitBar.getUnitPoints().get(i3);
        this.thumbDrawer.calculatePosition(point.x, point.y);
        invalidate();
    }

    public void setTitleColor(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.params.titleColor = i3;
        }
    }

    public void setTitleData(List<Title> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.titles = list;
        }
    }

    public void setTitleUp2Line(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isTitleUp2Line = z16;
        }
    }

    public void startEnableTalkback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        RangeButtonTouchHelper rangeButtonTouchHelper = new RangeButtonTouchHelper(this);
        this.mTouchHelper = rangeButtonTouchHelper;
        ViewCompat.setAccessibilityDelegate(this, rangeButtonTouchHelper);
        ViewCompat.setImportantForAccessibility(this, 1);
        this.enableTalkBack = true;
    }

    public RangeButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }

    public RangeButtonView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.isTitleUp2Line = true;
        this.currentPosition = 0;
        this.enableTalkBack = false;
        this.params = new RangeButtonParams();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.J6, 0, 0);
        this.params.barLeftPadding = obtainStyledAttributes.getDimension(jj2.b.K6, dp2px(26.0f));
        this.params.barRightPadding = obtainStyledAttributes.getDimension(jj2.b.L6, dp2px(26.0f));
        this.params.titleTopPadding = obtainStyledAttributes.getDimension(jj2.b.S6, dp2px(8.0f));
        this.params.titleColor = obtainStyledAttributes.getColor(jj2.b.R6, android.R.color.background_dark);
        this.params.lineOffset = obtainStyledAttributes.getDimension(jj2.b.O6, dp2px(24.0f));
        this.params.lineColor = obtainStyledAttributes.getColor(jj2.b.M6, android.R.color.background_dark);
        this.params.lineHeight = obtainStyledAttributes.getDimension(jj2.b.N6, dp2px(8.0f));
        this.params.lineWeight = obtainStyledAttributes.getDimension(jj2.b.P6, dp2px(1.0f));
        this.params.thumbSrcId = obtainStyledAttributes.getResourceId(jj2.b.Q6, R.drawable.h_4);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.paint = textPaint;
        textPaint.setAntiAlias(true);
        this.thumbBmp = BitmapFactory.decodeResource(getResources(), this.params.thumbSrcId);
        if (QQUIAppSetting.enableTalkBack()) {
            RangeButtonTouchHelper rangeButtonTouchHelper = new RangeButtonTouchHelper(this);
            this.mTouchHelper = rangeButtonTouchHelper;
            ViewCompat.setAccessibilityDelegate(this, rangeButtonTouchHelper);
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Title {
        static IPatchRedirector $redirector_;
        Point point;
        String text;
        float textSize;

        public Title(String str, float f16, Point point) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Float.valueOf(f16), point);
                return;
            }
            this.text = str;
            this.textSize = f16;
            this.point = point;
        }

        public void draw(Canvas canvas, Paint paint, RangeButtonParams rangeButtonParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, paint, rangeButtonParams);
                return;
            }
            if (this.point == null) {
                return;
            }
            paint.setTextSize(this.textSize);
            int color = paint.getColor();
            paint.setColor(rangeButtonParams.titleColor);
            String str = this.text;
            Point point = this.point;
            canvas.drawText(str, point.x, point.y, paint);
            paint.setColor(color);
        }

        public float getTextSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
            }
            return this.textSize;
        }

        public int getTextWidth() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return (int) RangeButtonView.measureTextWidth(this.text, this.textSize);
        }

        public Title(String str, float f16) {
            this(str, f16, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Float.valueOf(f16));
        }
    }
}
