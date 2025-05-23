package com.tencent.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class FastScroller {
    static IPatchRedirector $redirector_ = null;
    private static final int[] ATTRS;
    private static final int[] DEFAULT_STATES;
    private static final int FADE_TIMEOUT = 1500;
    private static int MIN_PAGES = 0;
    private static final int OVERLAY_AT_THUMB = 1;
    private static final int OVERLAY_FLOATING = 0;
    private static final int OVERLAY_POSITION = 5;
    private static final int PENDING_DRAG_DELAY = 180;
    private static final int[] PRESSED_STATES;
    private static final int PREVIEW_BACKGROUND_LEFT = 3;
    private static final int PREVIEW_BACKGROUND_RIGHT = 4;
    private static final int STATE_DRAGGING = 3;
    private static final int STATE_ENTER = 1;
    private static final int STATE_EXIT = 4;
    private static final int STATE_NONE = 0;
    private static final int STATE_VISIBLE = 2;
    private static final String TAG = "FastScroller";
    private static final int TEXT_COLOR = 0;
    private static final int THUMB_DRAWABLE = 1;
    private static final int TRACK_DRAWABLE = 2;
    private boolean mAlwaysShow;
    private boolean mChangedBounds;
    private final Runnable mDeferStartDrag;
    private boolean mDrawOverlay;
    private Handler mHandler;
    float mInitialTouchY;
    private int mItemCount;
    AbsListView mList;
    BaseAdapter mListAdapter;
    private int mListOffset;
    private boolean mLongList;
    private boolean mMatchDragPosition;
    private Drawable mOverlayDrawable;
    private Drawable mOverlayDrawableLeft;
    private Drawable mOverlayDrawableRight;
    private RectF mOverlayPos;
    private int mOverlayPosition;
    private int mOverlaySize;
    private Paint mPaint;
    boolean mPendingDrag;
    private int mPosition;
    private int mScaledTouchSlop;
    boolean mScrollCompleted;
    private ScrollFade mScrollFade;
    private SectionIndexer mSectionIndexer;
    private String mSectionText;
    private Object[] mSections;
    private int mState;
    private Drawable mThumbDrawable;
    int mThumbH;
    int mThumbW;
    int mThumbY;
    private final Rect mTmpRect;
    private Drawable mTrackDrawable;
    private int mVisibleItem;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ScrollFade implements Runnable {
        static IPatchRedirector $redirector_ = null;
        static final int ALPHA_MAX = 208;
        static final long FADE_DURATION = 200;
        long mFadeDuration;
        long mStartTime;

        public ScrollFade() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FastScroller.this);
            }
        }

        int getAlpha() {
            if (FastScroller.this.getState() != 4) {
                return 208;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.mStartTime;
            long j16 = this.mFadeDuration;
            if (uptimeMillis > j3 + j16) {
                return 0;
            }
            return (int) (208 - (((uptimeMillis - j3) * 208) / j16));
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (FastScroller.this.getState() != 4) {
                startFade();
            } else if (getAlpha() > 0) {
                FastScroller.this.mList.invalidate();
            } else {
                FastScroller.this.setState(0);
            }
        }

        void startFade() {
            this.mFadeDuration = FADE_DURATION;
            this.mStartTime = SystemClock.uptimeMillis();
            FastScroller.this.setState(4);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40268);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        MIN_PAGES = 4;
        PRESSED_STATES = new int[]{R.attr.state_pressed};
        DEFAULT_STATES = new int[0];
        ATTRS = new int[]{R.attr.fastScrollTextColor, R.attr.fastScrollThumbDrawable, R.attr.fastScrollTrackDrawable, R.attr.fastScrollPreviewBackgroundLeft, R.attr.fastScrollPreviewBackgroundRight, R.attr.fastScrollOverlayPosition};
    }

    public FastScroller(Context context, AbsListView absListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) absListView);
            return;
        }
        this.mItemCount = -1;
        this.mHandler = new Handler();
        this.mTmpRect = new Rect();
        this.mDeferStartDrag = new Runnable() { // from class: com.tencent.widget.FastScroller.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FastScroller.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                FastScroller fastScroller = FastScroller.this;
                if (fastScroller.mList.mIsAttached) {
                    fastScroller.beginDrag();
                    int height = FastScroller.this.mList.getHeight();
                    FastScroller fastScroller2 = FastScroller.this;
                    int i3 = (int) fastScroller2.mInitialTouchY;
                    int i16 = fastScroller2.mThumbH;
                    int i17 = (i3 - i16) + 10;
                    if (i17 < 0) {
                        i17 = 0;
                    } else if (i17 + i16 > height) {
                        i17 = height - i16;
                    }
                    fastScroller2.mThumbY = i17;
                    fastScroller2.scrollTo(i17 / (height - i16));
                }
                FastScroller.this.mPendingDrag = false;
            }
        };
        this.mList = absListView;
        init(context);
    }

    private void cancelFling() {
        MotionEvent obtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.mList.onTouchEvent(obtain);
        obtain.recycle();
    }

    private int getThumbPositionForListPosition(int i3, int i16, int i17) {
        float paddingTop;
        if (this.mSectionIndexer == null || this.mListAdapter == null) {
            getSectionsFromIndexer();
        }
        if (this.mSectionIndexer != null && this.mMatchDragPosition) {
            int i18 = this.mListOffset;
            int i19 = i3 - i18;
            if (i19 < 0) {
                return 0;
            }
            int i26 = i17 - i18;
            int height = this.mList.getHeight() - this.mThumbH;
            int sectionForPosition = this.mSectionIndexer.getSectionForPosition(i19);
            int positionForSection = this.mSectionIndexer.getPositionForSection(sectionForPosition);
            int positionForSection2 = this.mSectionIndexer.getPositionForSection(sectionForPosition + 1);
            int length = this.mSections.length;
            int i27 = positionForSection2 - positionForSection;
            if (this.mList.getChildAt(0) == null) {
                paddingTop = 0.0f;
            } else {
                paddingTop = i19 + ((this.mList.getPaddingTop() - r1.getTop()) / r1.getHeight());
            }
            int i28 = (int) (((sectionForPosition + ((paddingTop - positionForSection) / i27)) / length) * height);
            if (i19 > 0 && i19 + i16 == i26) {
                View childAt = this.mList.getChildAt(i16 - 1);
                return (int) (i28 + ((height - i28) * (((this.mList.getHeight() - this.mList.getPaddingBottom()) - childAt.getTop()) / childAt.getHeight())));
            }
            return i28;
        }
        return ((this.mList.getHeight() - this.mThumbH) * i3) / (i17 - i16);
    }

    @TargetApi(11)
    private void init(Context context) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(ATTRS);
        boolean z16 = true;
        try {
            useThumbDrawable(context, obtainStyledAttributes.getDrawable(1));
            this.mTrackDrawable = obtainStyledAttributes.getDrawable(2);
            this.mOverlayDrawableLeft = obtainStyledAttributes.getDrawable(3);
            this.mOverlayDrawableRight = obtainStyledAttributes.getDrawable(4);
            int i3 = 0;
            this.mOverlayPosition = obtainStyledAttributes.getInt(5, 0);
            this.mScrollCompleted = true;
            getSectionsFromIndexer();
            this.mOverlaySize = context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.f158789oy);
            this.mOverlayPos = new RectF();
            this.mScrollFade = new ScrollFade();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            this.mPaint.setTextSize(this.mOverlaySize / 2);
            this.mPaint.setColor(obtainStyledAttributes.getColorStateList(0).getDefaultColor());
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.mList.getWidth() > 0 && this.mList.getHeight() > 0) {
                onSizeChanged(this.mList.getWidth(), this.mList.getHeight(), 0, 0);
            }
            this.mState = 0;
            refreshDrawableState();
            obtainStyledAttributes.recycle();
            this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            if (context.getApplicationInfo().targetSdkVersion < 11) {
                z16 = false;
            }
            this.mMatchDragPosition = z16;
            if (VersionUtils.isHoneycomb()) {
                i3 = this.mList.getVerticalScrollbarPosition();
            }
            setScrollbarPosition(i3);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    private void refreshDrawableState() {
        int[] iArr;
        if (this.mState == 3) {
            iArr = PRESSED_STATES;
        } else {
            iArr = DEFAULT_STATES;
        }
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null && drawable.isStateful()) {
            this.mThumbDrawable.setState(iArr);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            this.mTrackDrawable.setState(iArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if (r1 != 2) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void resetThumbPos() {
        int width = this.mList.getWidth();
        int i3 = this.mPosition;
        if (i3 != 0) {
            if (i3 == 1) {
                this.mThumbDrawable.setBounds(0, 0, this.mThumbW, this.mThumbH);
            }
            this.mThumbDrawable.setAlpha(208);
        }
        this.mThumbDrawable.setBounds(width - this.mThumbW, 0, width, this.mThumbH);
        this.mThumbDrawable.setAlpha(208);
    }

    private void useThumbDrawable(Context context, Drawable drawable) {
        this.mThumbDrawable = drawable;
        if (drawable instanceof NinePatchDrawable) {
            this.mThumbW = context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.f158791p0);
            this.mThumbH = context.getResources().getDimensionPixelSize(com.tencent.mobileqq.R.dimen.f158790oz);
        } else {
            this.mThumbW = drawable.getIntrinsicWidth();
            this.mThumbH = drawable.getIntrinsicHeight();
        }
        this.mChangedBounds = true;
    }

    void beginDrag() {
        setState(3);
        if (this.mListAdapter == null && this.mList != null) {
            getSectionsFromIndexer();
        }
        AbsListView absListView = this.mList;
        if (absListView != null) {
            absListView.requestDisallowInterceptTouchEvent(true);
            this.mList.reportScrollStateChange(1);
            cancelFling();
        }
    }

    void cancelPendingDrag() {
        this.mList.removeCallbacks(this.mDeferStartDrag);
        this.mPendingDrag = false;
    }

    public void draw(Canvas canvas) {
        int i3;
        int min;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) canvas);
            return;
        }
        if (this.mState == 0) {
            return;
        }
        int i17 = this.mThumbY;
        int width = this.mList.getWidth();
        ScrollFade scrollFade = this.mScrollFade;
        if (this.mState == 4) {
            i3 = scrollFade.getAlpha();
            if (i3 < 104) {
                this.mThumbDrawable.setAlpha(i3 * 2);
            }
            int i18 = this.mPosition;
            if (i18 != 0) {
                if (i18 != 1) {
                    if (i18 != 2) {
                        i16 = 0;
                    }
                } else {
                    int i19 = this.mThumbW;
                    i16 = (-i19) + ((i19 * i3) / 208);
                }
                this.mThumbDrawable.setBounds(i16, 0, this.mThumbW + i16, this.mThumbH);
                this.mChangedBounds = true;
            }
            i16 = width - ((this.mThumbW * i3) / 208);
            this.mThumbDrawable.setBounds(i16, 0, this.mThumbW + i16, this.mThumbH);
            this.mChangedBounds = true;
        } else {
            i3 = -1;
        }
        if (this.mTrackDrawable != null) {
            Rect bounds = this.mThumbDrawable.getBounds();
            int i26 = bounds.left;
            int i27 = (bounds.bottom - bounds.top) / 2;
            int intrinsicWidth = this.mTrackDrawable.getIntrinsicWidth();
            int i28 = (i26 + (this.mThumbW / 2)) - (intrinsicWidth / 2);
            this.mTrackDrawable.setBounds(i28, i27, intrinsicWidth + i28, this.mList.getHeight() - i27);
            this.mTrackDrawable.draw(canvas);
        }
        canvas.translate(0.0f, i17);
        this.mThumbDrawable.draw(canvas);
        canvas.translate(0.0f, -i17);
        int i29 = this.mState;
        if (i29 == 3 && this.mDrawOverlay) {
            if (this.mOverlayPosition == 1) {
                if (this.mPosition != 1) {
                    min = Math.max(0, (this.mThumbDrawable.getBounds().left - this.mThumbW) - this.mOverlaySize);
                } else {
                    min = Math.min(this.mThumbDrawable.getBounds().right + this.mThumbW, this.mList.getWidth() - this.mOverlaySize);
                }
                int max = Math.max(0, Math.min(i17 + ((this.mThumbH - this.mOverlaySize) / 2), this.mList.getHeight() - this.mOverlaySize));
                RectF rectF = this.mOverlayPos;
                float f16 = min;
                rectF.left = f16;
                int i36 = this.mOverlaySize;
                float f17 = i36 + f16;
                rectF.right = f17;
                float f18 = max;
                rectF.top = f18;
                float f19 = i36 + f18;
                rectF.bottom = f19;
                Drawable drawable = this.mOverlayDrawable;
                if (drawable != null) {
                    drawable.setBounds((int) f16, (int) f18, (int) f17, (int) f19);
                }
            }
            Drawable drawable2 = this.mOverlayDrawable;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
            Paint paint = this.mPaint;
            float descent = paint.descent();
            RectF rectF2 = this.mOverlayPos;
            Rect rect = this.mTmpRect;
            Drawable drawable3 = this.mOverlayDrawable;
            if (drawable3 != null) {
                drawable3.getPadding(rect);
            }
            canvas.drawText(this.mSectionText, (((int) (rectF2.left + rectF2.right)) / 2) - ((rect.right - rect.left) / 2), (((((int) (rectF2.bottom + rectF2.top)) / 2) + (this.mOverlaySize / 4)) - descent) - ((rect.bottom - rect.top) / 2), paint);
            return;
        }
        if (i29 == 4) {
            if (i3 == 0) {
                setState(0);
            } else if (this.mTrackDrawable != null) {
                AbsListView absListView = this.mList;
                absListView.invalidate(width - this.mThumbW, 0, width, absListView.getHeight());
            } else {
                this.mList.invalidate(width - this.mThumbW, i17, width, this.mThumbH + i17);
            }
        }
    }

    SectionIndexer getSectionIndexer() {
        return this.mSectionIndexer;
    }

    Object[] getSections() {
        if (this.mListAdapter == null && this.mList != null) {
            getSectionsFromIndexer();
        }
        return this.mSections;
    }

    void getSectionsFromIndexer() {
        ListAdapter adapter = this.mList.getAdapter();
        this.mSectionIndexer = null;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            this.mListOffset = headerViewListAdapter.getHeadersCount();
            adapter = headerViewListAdapter.getWrappedAdapter();
        }
        if (adapter instanceof ExpandableListConnector) {
            ExpandableListAdapter adapter2 = ((ExpandableListConnector) adapter).getAdapter();
            if (adapter2 instanceof SectionIndexer) {
                SectionIndexer sectionIndexer = (SectionIndexer) adapter2;
                this.mSectionIndexer = sectionIndexer;
                this.mListAdapter = (BaseAdapter) adapter;
                this.mSections = sectionIndexer.getSections();
                return;
            }
            return;
        }
        if (adapter instanceof SectionIndexer) {
            this.mListAdapter = (BaseAdapter) adapter;
            SectionIndexer sectionIndexer2 = (SectionIndexer) adapter;
            this.mSectionIndexer = sectionIndexer2;
            Object[] sections = sectionIndexer2.getSections();
            this.mSections = sections;
            if (sections == null) {
                this.mSections = new String[]{" "};
                return;
            }
            return;
        }
        this.mListAdapter = (BaseAdapter) adapter;
        this.mSections = new String[]{" "};
    }

    public int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mState;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mThumbW;
    }

    public boolean isAlwaysShowEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mAlwaysShow;
    }

    boolean isPointInside(float f16, float f17) {
        boolean z16;
        if (this.mPosition == 1 ? f16 < this.mThumbW : f16 > this.mList.getWidth() - this.mThumbW) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.mTrackDrawable == null) {
            if (f17 < this.mThumbY || f17 > r5 + this.mThumbH) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isVisible() {
        if (this.mState != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                cancelPendingDrag();
                return false;
            }
            return false;
        }
        if (this.mState > 0 && isPointInside(motionEvent.getX(), motionEvent.getY())) {
            if (!this.mList.isInScrollingContainer()) {
                beginDrag();
                return true;
            }
            this.mInitialTouchY = motionEvent.getY();
            startPendingDrag();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onItemCountChanged(int i3, int i16) {
        if (this.mAlwaysShow) {
            this.mLongList = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        boolean z16;
        if (this.mItemCount != i17 && i16 > 0) {
            this.mItemCount = i17;
            if (i17 / i16 >= MIN_PAGES) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mLongList = z16;
        }
        if (this.mAlwaysShow) {
            this.mLongList = true;
        }
        if (!this.mLongList) {
            if (this.mState != 0) {
                setState(0);
                return;
            }
            return;
        }
        if (i17 - i16 > 0 && this.mState != 3) {
            this.mThumbY = getThumbPositionForListPosition(i3, i16, i17);
            if (this.mChangedBounds) {
                resetThumbPos();
                this.mChangedBounds = false;
            }
        }
        this.mScrollCompleted = true;
        if (i3 == this.mVisibleItem) {
            return;
        }
        this.mVisibleItem = i3;
        if (this.mState != 3) {
            setState(2);
            if (!this.mAlwaysShow) {
                this.mHandler.postDelayed(this.mScrollFade, 1500L);
            }
        }
    }

    public void onSectionsChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mListAdapter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mPosition != 1) {
                drawable.setBounds(i3 - this.mThumbW, 0, i3, this.mThumbH);
            } else {
                drawable.setBounds(0, 0, this.mThumbW, this.mThumbH);
            }
        }
        if (this.mOverlayPosition == 0) {
            RectF rectF = this.mOverlayPos;
            int i19 = this.mOverlaySize;
            float f16 = (i3 - i19) / 2;
            rectF.left = f16;
            float f17 = i19 + f16;
            rectF.right = f17;
            float f18 = i16 / 10;
            rectF.top = f18;
            float f19 = i19 + f18;
            rectF.bottom = f19;
            Drawable drawable2 = this.mOverlayDrawable;
            if (drawable2 != null) {
                drawable2.setBounds((int) f16, (int) f18, (int) f17, (int) f19);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        int i16;
        int i17 = 0;
        if (this.mState == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (isPointInside(motionEvent.getX(), motionEvent.getY())) {
                if (!this.mList.isInScrollingContainer()) {
                    beginDrag();
                    return true;
                }
                this.mInitialTouchY = motionEvent.getY();
                startPendingDrag();
            }
        } else if (action == 1) {
            if (this.mPendingDrag) {
                beginDrag();
                AbsListView absListView = this.mList;
                if (absListView != null) {
                    i16 = absListView.getHeight();
                } else {
                    i16 = 0;
                }
                int y16 = (int) motionEvent.getY();
                int i18 = this.mThumbH;
                int i19 = (y16 - i18) + 10;
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 + i18 > i16) {
                    i19 = i16 - i18;
                }
                this.mThumbY = i19;
                scrollTo(i19 / (i16 - i18));
                cancelPendingDrag();
            }
            if (this.mState == 3) {
                AbsListView absListView2 = this.mList;
                if (absListView2 != null) {
                    absListView2.requestDisallowInterceptTouchEvent(false);
                    this.mList.reportScrollStateChange(0);
                    setState(2);
                }
                Handler handler = this.mHandler;
                handler.removeCallbacks(this.mScrollFade);
                if (!this.mAlwaysShow) {
                    handler.postDelayed(this.mScrollFade, 1000L);
                }
                AbsListView absListView3 = this.mList;
                if (absListView3 != null) {
                    absListView3.invalidate();
                }
                return true;
            }
        } else if (action == 2) {
            if (this.mPendingDrag && Math.abs(motionEvent.getY() - this.mInitialTouchY) > this.mScaledTouchSlop) {
                setState(3);
                if (this.mListAdapter == null && this.mList != null) {
                    getSectionsFromIndexer();
                }
                AbsListView absListView4 = this.mList;
                if (absListView4 != null) {
                    absListView4.requestDisallowInterceptTouchEvent(true);
                    this.mList.reportScrollStateChange(1);
                    cancelFling();
                    cancelPendingDrag();
                }
            }
            if (this.mState == 3) {
                AbsListView absListView5 = this.mList;
                if (absListView5 != null) {
                    i3 = absListView5.getHeight();
                } else {
                    i3 = 0;
                }
                int y17 = (int) motionEvent.getY();
                int i26 = this.mThumbH;
                int i27 = (y17 - i26) + 10;
                if (i27 >= 0) {
                    if (i27 + i26 > i3) {
                        i17 = i3 - i26;
                    } else {
                        i17 = i27;
                    }
                }
                if (Math.abs(this.mThumbY - i17) < 2) {
                    return true;
                }
                this.mThumbY = i17;
                if (this.mScrollCompleted) {
                    scrollTo(i17 / (i3 - this.mThumbH));
                }
                return true;
            }
        } else if (action == 3) {
            cancelPendingDrag();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void scrollTo(float f16) {
        int i3;
        int i16;
        int i17;
        float f17;
        int i18;
        AbsListView absListView;
        AbsListView absListView2 = this.mList;
        boolean z16 = true;
        if (absListView2 == null) {
            QLog.i(TAG, 1, "mList is null, return directly");
            return;
        }
        int count = absListView2.getCount();
        this.mScrollCompleted = false;
        float f18 = count;
        float f19 = (1.0f / f18) / 8.0f;
        Object[] objArr = this.mSections;
        if (objArr != null && objArr.length > 1) {
            int length = objArr.length;
            float f26 = length;
            int i19 = (int) (f16 * f26);
            if (i19 >= length) {
                i19 = length - 1;
            }
            int positionForSection = this.mSectionIndexer.getPositionForSection(i19);
            int i26 = i19 + 1;
            if (i19 < length - 1) {
                i16 = this.mSectionIndexer.getPositionForSection(i26);
            } else {
                i16 = count;
            }
            int i27 = i19;
            if (i16 == positionForSection) {
                int i28 = positionForSection;
                do {
                    if (i27 > 0) {
                        i27--;
                        i28 = this.mSectionIndexer.getPositionForSection(i27);
                        if (i28 != positionForSection) {
                        }
                    } else {
                        i27 = i19;
                    }
                    positionForSection = i28;
                } while (i27 != 0);
                i27 = i19;
                positionForSection = i28;
                i3 = 0;
                i17 = i26 + 1;
                while (i17 < length && this.mSectionIndexer.getPositionForSection(i17) == i16) {
                    i17++;
                    i26++;
                }
                f17 = i27 / f26;
                float f27 = i26 / f26;
                if (i27 == i19 || f16 - f17 >= f19) {
                    positionForSection += (int) (((i16 - positionForSection) * (f16 - f17)) / (f27 - f17));
                }
                i18 = count - 1;
                if (positionForSection > i18) {
                    positionForSection = i18;
                }
                absListView = this.mList;
                if (!(absListView instanceof ExpandableListView)) {
                    ExpandableListView expandableListView = (ExpandableListView) absListView;
                    expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(positionForSection + this.mListOffset)), 0);
                } else if (absListView instanceof ListView) {
                    ((ListView) absListView).setSelectionFromTop(positionForSection + this.mListOffset, 0);
                } else {
                    absListView.setSelection(positionForSection + this.mListOffset);
                }
            }
            i3 = i27;
            i17 = i26 + 1;
            while (i17 < length) {
                i17++;
                i26++;
            }
            f17 = i27 / f26;
            float f272 = i26 / f26;
            if (i27 == i19) {
            }
            positionForSection += (int) (((i16 - positionForSection) * (f16 - f17)) / (f272 - f17));
            i18 = count - 1;
            if (positionForSection > i18) {
            }
            absListView = this.mList;
            if (!(absListView instanceof ExpandableListView)) {
            }
        } else {
            int i29 = (int) (f18 * f16);
            int i36 = count - 1;
            if (i29 > i36) {
                i29 = i36;
            }
            AbsListView absListView3 = this.mList;
            if (absListView3 instanceof ExpandableListView) {
                ExpandableListView expandableListView2 = (ExpandableListView) absListView3;
                expandableListView2.setSelectionFromTop(expandableListView2.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i29 + this.mListOffset)), 0);
            } else if (absListView3 instanceof ListView) {
                ((ListView) absListView3).setSelectionFromTop(i29 + this.mListOffset, 0);
            } else {
                absListView3.setSelection(i29 + this.mListOffset);
            }
            i3 = -1;
        }
        if (i3 >= 0) {
            String obj = objArr[i3].toString();
            this.mSectionText = obj;
            if ((obj.length() == 1 && obj.charAt(0) == ' ') || i3 >= objArr.length) {
                z16 = false;
            }
            this.mDrawOverlay = z16;
            return;
        }
        this.mDrawOverlay = false;
    }

    public void setAlwaysShow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        this.mAlwaysShow = z16;
        if (z16) {
            this.mHandler.removeCallbacks(this.mScrollFade);
            setState(2);
        } else if (this.mState == 2) {
            this.mHandler.postDelayed(this.mScrollFade, 1500L);
        }
    }

    public void setScrollbarPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.mPosition = i3;
        if (i3 != 1) {
            this.mOverlayDrawable = this.mOverlayDrawableRight;
        } else {
            this.mOverlayDrawable = this.mOverlayDrawableLeft;
        }
    }

    public void setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        int width = this.mList.getWidth();
                        AbsListView absListView = this.mList;
                        int i16 = width - this.mThumbW;
                        int i17 = this.mThumbY;
                        absListView.invalidate(i16, i17, width, this.mThumbH + i17);
                    }
                }
            } else if (this.mState != 2) {
                resetThumbPos();
            }
            this.mHandler.removeCallbacks(this.mScrollFade);
        } else {
            this.mHandler.removeCallbacks(this.mScrollFade);
            this.mList.invalidate();
        }
        this.mState = i3;
        refreshDrawableState();
    }

    void startPendingDrag() {
        this.mPendingDrag = true;
        this.mList.postDelayed(this.mDeferStartDrag, 180L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        setState(0);
    }
}
