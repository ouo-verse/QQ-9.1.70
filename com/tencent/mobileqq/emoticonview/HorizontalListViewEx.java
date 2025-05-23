package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonTabAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class HorizontalListViewEx extends HorizontalListView {
    static IPatchRedirector $redirector_;
    private static LayoutInflater inflater;
    private static List<View> tabCacheViews;
    private int mIndicatorRoundRectX;
    protected int mIndicatorStartX;
    private boolean mIsAnimTabIndicatoring;
    private boolean mIsInGuildLiveRoom;
    private boolean mIsTabAnimateEnable;
    private int mOldSelectedAdapterIndex;
    private Paint mRectPaint;
    private RectF mRoundRect;
    private int mScreenWidth;
    private int mTabWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49609);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            tabCacheViews = Collections.synchronizedList(new ArrayList());
        }
    }

    public HorizontalListViewEx(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mOldSelectedAdapterIndex = -1;
        this.mIsTabAnimateEnable = false;
        this.mIndicatorStartX = 0;
        this.mIsAnimTabIndicatoring = false;
    }

    private void clearAllSelectedState() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getTag() != null) {
                EmoticonTabAdapter.ViewHolder viewHolder = (EmoticonTabAdapter.ViewHolder) childAt.getTag();
                childAt.setSelected(false);
                viewHolder.tabImage.setSelected(false);
            }
        }
    }

    public static View consumeView() {
        List<View> list = tabCacheViews;
        if (list != null && list.size() > 0) {
            return tabCacheViews.remove(0);
        }
        return null;
    }

    public static void destroyCacheView() {
        List<View> list = tabCacheViews;
        if (list != null) {
            list.clear();
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
        this.mRectPaint.setColor(getResources().getColor(R.color.qui_common_fill_standard_primary));
        this.mRoundRect = new RectF();
        this.mIndicatorRoundRectX = ViewUtils.dip2px(9.0f);
    }

    public static void produceTabView(int i3) {
        if (inflater == null) {
            inflater = (LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater");
        }
        for (int i16 = 0; i16 < i3; i16++) {
            View view = null;
            try {
                view = inflater.inflate(R.layout.h86, (ViewGroup) null, false);
            } catch (Resources.NotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("HorizontalListViewEx", 2, "NotFoundException;err info:" + e16.getMessage());
                }
            } catch (InflateException unused) {
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("HorizontalListViewEx", 2, "OutOfMemoryError;err info:" + e17.getMessage());
                }
            }
            if (view != null) {
                tabCacheViews.add(view);
            }
        }
    }

    protected void animTabIndicator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mOldSelectedAdapterIndex != this.mCurrentlySelectedAdapterIndex && getChildCount() > 0) {
            View child = getChild(this.mOldSelectedAdapterIndex);
            if (child != null) {
                this.mIndicatorStartX = child.getLeft();
            } else if (this.mOldSelectedAdapterIndex < getFirstVisiblePosition()) {
                this.mIndicatorStartX = -this.mTabWidth;
            } else if (this.mOldSelectedAdapterIndex > getLastVisiblePosition()) {
                this.mIndicatorStartX = this.mScreenWidth - this.mTabWidth;
            }
            View selectedView = getSelectedView();
            if (selectedView != null) {
                clearAllSelectedState();
                int i3 = this.mIndicatorStartX;
                int left = selectedView.getLeft();
                ValueAnimator ofInt = ValueAnimator.ofInt(i3, left);
                ofInt.setDuration(200L);
                this.mIsAnimTabIndicatoring = true;
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(selectedView, left) { // from class: com.tencent.mobileqq.emoticonview.HorizontalListViewEx.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$endX;
                    final /* synthetic */ View val$nextView;

                    {
                        this.val$nextView = selectedView;
                        this.val$endX = left;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, HorizontalListViewEx.this, selectedView, Integer.valueOf(left));
                        }
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) valueAnimator);
                            return;
                        }
                        HorizontalListViewEx.this.mIndicatorStartX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        HorizontalListViewEx.this.mIndicatorStartX += this.val$nextView.getLeft() - this.val$endX;
                        if (HorizontalListViewEx.this.mIndicatorStartX == this.val$nextView.getLeft()) {
                            HorizontalListViewEx.this.mIsAnimTabIndicatoring = false;
                        }
                        HorizontalListViewEx.this.invalidate();
                    }
                });
                ofInt.start();
                return;
            }
        }
        this.mIsAnimTabIndicatoring = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0 && getParent() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d(HorizontalListView.TAG, 4, "dispatch touchEvent down");
            }
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public void onDraw(Canvas canvas) {
        View childAt;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.mIsTabAnimateEnable && this.mIsAnimTabIndicatoring) {
            View selectedView = getSelectedView();
            if (!(selectedView instanceof ViewGroup) || (childAt = ((ViewGroup) selectedView).getChildAt(0)) == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams()) == null) {
                return;
            }
            this.mRoundRect.set(this.mIndicatorStartX, marginLayoutParams.topMargin, r2 + this.mTabWidth, getMeasuredHeight() - marginLayoutParams.bottomMargin);
            RectF rectF = this.mRoundRect;
            int i3 = this.mIndicatorRoundRectX;
            canvas.drawRoundRect(rectF, i3, i3, this.mRectPaint);
            return;
        }
        int childCount = getChildCount();
        if (getAdapter() != null) {
            EmoticonTabAdapter emoticonTabAdapter = (EmoticonTabAdapter) getAdapter();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = getChildAt(i16);
                Object item = emoticonTabAdapter.getItem(this.mLeftViewAdapterIndex + i16);
                if (childAt2.getTag() != null) {
                    EmoticonTabAdapter.ViewHolder viewHolder = (EmoticonTabAdapter.ViewHolder) childAt2.getTag();
                    if (childAt2 == getSelectedView()) {
                        childAt2.setSelected(true);
                        viewHolder.tabImage.setSelected(true);
                        if (item != null) {
                            childAt2.setContentDescription(((EmoticonTabAdapter.EmoticonTabItem) item).description);
                        }
                    } else {
                        childAt2.setSelected(false);
                        viewHolder.tabImage.setSelected(false);
                        if (item != null) {
                            childAt2.setContentDescription(((EmoticonTabAdapter.EmoticonTabItem) item).description);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.widget.HorizontalListView
    public void resetCurrentX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        int i16 = i3 * this.mTabWidth;
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = ViewUtils.getScreenWidth();
        }
        int i17 = i16 - (measuredWidth - this.mTabWidth);
        if (i17 < 0) {
            i17 = 0;
        }
        this.mCurrentX = i17;
    }

    public int scrollBy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        int i16 = this.mNextX;
        int i17 = i16 + i3;
        if (i17 < 0) {
            return -1;
        }
        if (i17 > this.mMaxX) {
            return 1;
        }
        this.mScroller.startScroll(i16, 0, i3, 0, 20);
        setCurrentScrollState(4098);
        requestLayout();
        return 0;
    }

    public void setIsInGuildLiveRoom(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mIsInGuildLiveRoom = z16;
        }
    }

    @Override // com.tencent.widget.HorizontalListView, android.widget.AdapterView
    public void setSelection(int i3) {
        int i16;
        int right;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        super.setSelection(i3);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && i3 < listAdapter.getCount() && i3 >= 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (i3 > lastVisiblePosition && lastVisiblePosition != -1) {
                int i17 = this.mTabWidth;
                int i18 = (i3 + 1) * i17;
                i16 = (i18 - this.mNextX) - ((this.mScreenWidth - i17) - i17);
                if (HorizontalListView.DEBUG && QLog.isDevelopLevel()) {
                    QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + i3 + ",lastPosition:" + lastVisiblePosition + ",tabPosition:" + i18 + ",mNextX:" + this.mNextX + ",deltaX:" + i16 + ",mScreenWidth" + this.mScreenWidth);
                }
            } else if (i3 < firstVisiblePosition && firstVisiblePosition != -1) {
                int i19 = this.mTabWidth * i3;
                i16 = i19 - this.mNextX;
                if (HorizontalListView.DEBUG && QLog.isDevelopLevel()) {
                    QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + i3 + ",firstPosition:" + firstVisiblePosition + ",tabPosition:" + i19 + ",mNextX:" + this.mNextX + ",deltaX:" + i16 + ",mScreenWidth" + this.mScreenWidth);
                }
            } else {
                i16 = 0;
                if (i3 == firstVisiblePosition) {
                    int[] iArr = new int[2];
                    getChildAt(0).getLocationOnScreen(iArr);
                    right = iArr[0] - getLeft();
                    if (HorizontalListView.DEBUG && QLog.isDevelopLevel()) {
                        QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + i3 + ",location:" + iArr[0] + ",mNextX:" + this.mNextX + ",deltaX:" + right);
                    }
                } else if (i3 == lastVisiblePosition) {
                    int[] iArr2 = new int[2];
                    getChildAt(getChildCount() - 1).getLocationOnScreen(iArr2);
                    right = (iArr2[0] + this.mTabWidth) - getRight();
                    if (right < 0) {
                        right = 0;
                    }
                    if (HorizontalListView.DEBUG && QLog.isDevelopLevel()) {
                        QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + i3 + ",location:" + iArr2[0] + ",mNextX:" + this.mNextX + ",deltaX:" + right);
                    }
                } else if (HorizontalListView.DEBUG && QLog.isDevelopLevel()) {
                    QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + i3 + ",mNextX:" + this.mNextX);
                }
                i16 = right;
            }
            if (i16 != 0) {
                scrollBy(i16);
            } else if (firstVisiblePosition == -1 && lastVisiblePosition == -1) {
                ViewCompat.postOnAnimation(this, new Runnable() { // from class: com.tencent.mobileqq.emoticonview.HorizontalListViewEx.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HorizontalListViewEx.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            HorizontalListViewEx.this.requestLayout();
                        }
                    }
                });
            } else {
                requestLayout();
            }
            if (this.mIsTabAnimateEnable) {
                animTabIndicator();
                this.mOldSelectedAdapterIndex = this.mCurrentlySelectedAdapterIndex;
            }
        }
    }

    public void setSkinColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.mIsInGuildLiveRoom) {
            this.mRectPaint.setColor(Color.parseColor("#2F3033"));
        } else {
            this.mRectPaint.setColor(getResources().getColor(R.color.qui_common_fill_standard_primary));
        }
    }

    public void setTabAnimateEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mIsTabAnimateEnable = z16;
        }
    }

    public HorizontalListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mOldSelectedAdapterIndex = -1;
        this.mIsTabAnimateEnable = false;
        this.mIndicatorStartX = 0;
        this.mIsAnimTabIndicatoring = false;
        this.mTabWidth = com.tencent.mobileqq.EmotionUtils.a(39.0f, context.getResources());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        initPaint();
    }
}
