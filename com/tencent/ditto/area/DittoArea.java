package com.tencent.ditto.area;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.reflect.MustacheParser;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoBitmapCache;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;
import com.tencent.ditto.widget.DittoTextAreaCompat;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoArea extends MeasureCacheable implements DittoElement, DittoType {
    private String areaIdShouldInvokeClick;
    public int borderColor;
    public float[] borderRadius;
    public int borderWidth;
    public ClickListener clickListener;
    private String cmd;
    private int cmdParamKey;
    private String cmdParamType;
    private int[] compassClickKey;
    private int[] compassExposureKey;
    private RectF cornerBound;
    private Path cornerPath;
    private int cornerPathHeight;
    private int cornerPathWidth;
    public int height;

    /* renamed from: id, reason: collision with root package name */
    public String f100544id;
    private boolean ignoreClick;
    private boolean isBgDirty;
    private boolean isBorderDirty;
    public boolean isPressed;
    public LongClickListener longClickListener;
    private float mAlpha;
    public Integer mAreaCacheKey;
    public Drawable mBackground;
    private Integer mBgCacheKey;
    private int mBgColor;
    private Integer mBorderCacheKey;
    public int mBottom;
    public Rect mBound;
    private DittoBitmapCache mCacheBackground;
    private DittoBitmapCache mCacheBorder;
    private String mContentDescription;
    public Animation mCurrentAnimation;
    public boolean mDrawIgnoreVisible;
    public RectF mFBound;
    private Paint mFillPaint;
    private String mGradientDirection;
    private int mGradientEndColor;
    private int mGradientStartColor;
    public int mGravity;
    public DittoHost mHost;
    public LayoutAttrSet mLayoutAttr;
    public int mLeft;
    public Handler mMainHandler;
    public boolean mMeasureDirty;
    public int mMeasuredHeight;
    public int mMeasuredWidth;
    public WeakReference<DittoAreaGroup> mParent;
    private CheckForLongPressRunnable mPendingCheckForLongPress;
    private int mPressedAlpha;
    public int mRight;
    public Drawable mShadowDrawable;
    private Paint mStrokePaint;
    public Object mTag;
    public int mTop;
    private Transformation mTransformation;
    private int mVisibility;
    private WeakReference<Object> mWeakAttachedObject;
    private String onClickUri;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    private DittoValue postClickKey;
    private Rect shadowBound;
    public int shadowSizeBottom;
    public int shadowSizeLeft;
    public int shadowSizeRight;
    public int shadowSizeTop;
    private String silentUri;
    private String silentUriSentToast;
    private int tttReportArea;
    public int width;
    public static LruCache<Integer, Object> mAreaCache = new LruCache<>(2048);
    public static LruCache<Integer, DittoBitmapCache> mBackgroundCache = new LruCache<>(5);
    public static long total = 0;
    public static int setLayoutAttrCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public final class CheckForLongPressRunnable implements Runnable {

        /* renamed from: ev, reason: collision with root package name */
        public MotionEvent f100545ev;

        CheckForLongPressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DittoArea dittoArea = DittoArea.this;
            if (dittoArea.isPressed) {
                dittoArea.isPressed = false;
                dittoArea.performLongClick(this.f100545ev);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ClickListener {
        void onClick(DittoArea dittoArea, @Nullable MotionEvent motionEvent, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface LongClickListener {
        void onLongClick(DittoArea dittoArea, @Nullable MotionEvent motionEvent, Object obj);
    }

    public DittoArea(DittoHost dittoHost) {
        this(dittoHost, null);
    }

    private void checkForLongClick(MotionEvent motionEvent) {
        if (this.mPendingCheckForLongPress == null) {
            this.mPendingCheckForLongPress = new CheckForLongPressRunnable();
        }
        CheckForLongPressRunnable checkForLongPressRunnable = this.mPendingCheckForLongPress;
        checkForLongPressRunnable.f100545ev = motionEvent;
        this.mMainHandler.removeCallbacks(checkForLongPressRunnable);
        this.mMainHandler.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
    }

    private void drawBorder(Canvas canvas, boolean z16, int i3, boolean z17) {
        if (z16) {
            DittoBitmapCache backgroundCache = getBackgroundCache(this.mBorderCacheKey);
            this.mCacheBorder = backgroundCache;
            if (backgroundCache == null || backgroundCache.getBitmap() == null) {
                Paint strokePaint = getStrokePaint();
                strokePaint.setStrokeWidth(this.borderWidth);
                strokePaint.setColor(this.borderColor);
                float f16 = this.borderWidth / 2;
                RectF rectF = new RectF(this.mBound);
                rectF.top += f16;
                rectF.left += f16;
                rectF.right -= f16;
                rectF.bottom -= f16;
                Path path = new Path();
                path.addRoundRect(rectF, this.borderRadius, Path.Direction.CW);
                canvas.drawPath(path, getStrokePaint());
            }
        }
        canvas.restoreToCount(i3);
        if (z17) {
            this.mHost.postInvalidateDelayed(16L);
        }
    }

    private void drawContent(Canvas canvas) {
        boolean z16;
        Drawable drawable = this.mBackground;
        if (drawable == null && this.mBgColor != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.isBgDirty || this.mBgCacheKey == null) {
                this.mBgCacheKey = generateBackgroundCacheKey();
                this.isBgDirty = false;
            }
            try {
                DittoBitmapCache backgroundCache = getBackgroundCache(this.mBgCacheKey);
                this.mCacheBackground = backgroundCache;
                if (this.mBackground == null) {
                    if (backgroundCache == null || backgroundCache.getBitmap() == null) {
                        this.mCacheBackground = new DittoBitmapCache();
                        Paint fillPaint = getFillPaint();
                        fillPaint.setColor(this.mBgColor);
                        fillPaint.setAlpha((int) this.mAlpha);
                        Path path = new Path();
                        path.addRoundRect(new RectF(this.mBound), this.borderRadius, Path.Direction.CW);
                        canvas.drawPath(path, fillPaint);
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th5) {
                DittoLog.e(DittoLog.defaultTag, "draw background exception.", th5);
                return;
            }
        }
        if (drawable != null) {
            drawable.setBounds(this.mBound);
            this.mBackground.setAlpha((int) this.mAlpha);
            this.mBackground.draw(canvas);
        }
    }

    private void drawContentB(Canvas canvas, int i3, boolean z16) {
        boolean z17;
        Path path;
        setGradientBackground(canvas);
        int save = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        if (!hasNoRadius() && (path = this.cornerPath) != null) {
            canvas.clipPath(path);
        } else {
            canvas.clipRect(0, 0, (this.width - getPaddingLeft()) - getPaddingRight(), (this.height - getPaddingTop()) - getPaddingBottom());
        }
        onDraw(canvas);
        canvas.restoreToCount(save);
        if (this.borderWidth != 0 && this.borderColor != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && (this.isBorderDirty || this.mBorderCacheKey == null)) {
            this.mBorderCacheKey = generateBorderCacheKey();
            this.isBorderDirty = false;
        }
        if (getShadowDrawable() != null) {
            canvas.translate(this.paddingLeft - this.shadowSizeLeft, this.paddingTop - this.shadowSizeTop);
            getShadowDrawable().draw(canvas);
            canvas.translate(this.shadowSizeLeft - this.paddingLeft, this.shadowSizeTop - this.paddingTop);
        }
        drawBorder(canvas, z17, i3, z16);
    }

    private void executeCornerPath() {
        if (!hasNoRadius()) {
            if (this.cornerPathHeight != getContentHeight() || this.cornerPathWidth != getContentWidth()) {
                this.cornerPath.reset();
                if (needResetCornerBound()) {
                    this.cornerBound = new RectF(0.0f, 0.0f, getContentWidth(), getContentHeight());
                }
                this.cornerPath.addRoundRect(this.cornerBound, getBorderRadius(), Path.Direction.CW);
                this.cornerPathHeight = getContentHeight();
                this.cornerPathWidth = getContentWidth();
            }
        }
    }

    private Integer generateBackgroundCacheKey() {
        return Integer.valueOf(("canvasArea_background_" + this.mBgColor + "_" + getWidth() + "_" + getHeight() + "_" + this.borderRadius).hashCode());
    }

    private Integer generateBorderCacheKey() {
        return Integer.valueOf(("canvasArea_border_" + this.borderColor + "_" + this.borderWidth + "_" + this.borderRadius + "_" + getWidth() + "_" + getHeight()).hashCode());
    }

    private Paint getFillPaint() {
        if (this.mFillPaint == null) {
            Paint paint = new Paint(1);
            this.mFillPaint = paint;
            paint.setDither(true);
        }
        return this.mFillPaint;
    }

    private Paint getStrokePaint() {
        if (this.mStrokePaint == null) {
            Paint paint = new Paint(1);
            this.mStrokePaint = paint;
            paint.setDither(true);
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
        }
        return this.mStrokePaint;
    }

    private boolean hasNoRadius() {
        for (float f16 : this.borderRadius) {
            if (f16 != 0.0f) {
                return false;
            }
        }
        return true;
    }

    private boolean isActionDownValid() {
        if ((this.ignoreClick || !clickable()) && TextUtils.isEmpty(this.areaIdShouldInvokeClick) && TextUtils.isEmpty(getOnClickUri()) && TextUtils.isEmpty(getSilentUri()) && this.clickListener == null && this.longClickListener == null) {
            return false;
        }
        return true;
    }

    private boolean isUIThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private boolean needResetCornerBound() {
        if (this.cornerBound != null && this.cornerPathHeight == getContentHeight() && this.cornerPathWidth == getContentWidth()) {
            return false;
        }
        return true;
    }

    private void onPressedAlpha(boolean z16) {
        int i3 = this.mPressedAlpha;
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        if (i3 == 0) {
            return;
        }
        if (z16) {
            setAlpha(i3);
        } else {
            setAlpha(255.0f);
        }
        invalidate();
    }

    private void onTouchEventOutside() {
        onPressedAlpha(false);
    }

    private void parseAttr(LayoutAttrSet layoutAttrSet) {
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.Gravity.Gravity)) {
            setGravity(LayoutAttrDefine.Gravity.parse(layoutAttrSet.getAttr(LayoutAttrDefine.Gravity.Gravity, "left")));
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.COMPASS_EXPOSURE_KEY)) {
            this.compassExposureKey = layoutAttrSet.getIntArrayAttr(LayoutAttrDefine.COMPASS_EXPOSURE_KEY);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.COMPASS_CLICK_KEY)) {
            this.compassClickKey = layoutAttrSet.getIntArrayAttr(LayoutAttrDefine.COMPASS_CLICK_KEY);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.TTT_CLICK_REPORT_KEY)) {
            this.tttReportArea = layoutAttrSet.getAttr(LayoutAttrDefine.TTT_CLICK_REPORT_KEY, -1);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.CLICK_URI)) {
            this.onClickUri = layoutAttrSet.getAttr(LayoutAttrDefine.CLICK_URI, "");
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.SILENT_URI)) {
            this.silentUri = layoutAttrSet.getAttr(LayoutAttrDefine.SILENT_URI, "");
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.SILENT_URI_SENT_TOAST)) {
            this.silentUriSentToast = layoutAttrSet.getAttr(LayoutAttrDefine.SILENT_URI_SENT_TOAST, (String) null);
        }
        if (layoutAttrSet.hasAttr("cmd")) {
            this.cmd = layoutAttrSet.getAttr("cmd", (String) null);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.CMD_BUFFER)) {
            this.cmdParamKey = layoutAttrSet.getAttr(LayoutAttrDefine.CMD_BUFFER, Integer.MIN_VALUE);
        }
    }

    private void parseAttr2(LayoutAttrSet layoutAttrSet) {
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.CMD_BUFFER_TYPE)) {
            this.cmdParamType = layoutAttrSet.getAttr(LayoutAttrDefine.CMD_BUFFER_TYPE, (String) null);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.POST_CLICK_KEY_PATH)) {
            this.postClickKey = MustacheParser.parse(layoutAttrSet.getAttr(LayoutAttrDefine.POST_CLICK_KEY_PATH, ""));
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.INVOKE_AREA_CLICK)) {
            this.areaIdShouldInvokeClick = layoutAttrSet.getAttr(LayoutAttrDefine.INVOKE_AREA_CLICK, (String) null);
        }
        if (layoutAttrSet.hasAttr(LayoutAttrDefine.IGNORE_CLICK)) {
            this.ignoreClick = layoutAttrSet.getAttr(LayoutAttrDefine.IGNORE_CLICK, false);
        }
    }

    private boolean performListenerClick(MotionEvent motionEvent) {
        ClickListener clickListener = this.clickListener;
        if (clickListener != null) {
            clickListener.onClick(this, motionEvent, null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performLongClick(MotionEvent motionEvent) {
        LongClickListener longClickListener = this.longClickListener;
        if (longClickListener != null) {
            longClickListener.onLongClick(this, motionEvent, null);
        }
    }

    public static final void removeAreaCache(Integer num) {
        if (num != null) {
            mAreaCache.remove(num);
            MeasureCacheable.removeMeasureCache(num);
        }
    }

    public static final void removeBackgroundCache(Integer num) {
        if (num != null) {
            mBackgroundCache.remove(num);
        }
    }

    private void resetBgColorAndVisible(LayoutAttrSet layoutAttrSet) {
        int i3 = layoutAttrSet.bg_color;
        if (i3 != 0 || (this.borderColor != 0 && this.borderWidth != 0)) {
            setBackgroundColor(i3);
        }
        if (layoutAttrSet.mAttrs.containsKey("visibility")) {
            String attr = layoutAttrSet.getAttr("visibility", NodeProps.VISIBLE);
            if (TextUtils.equals(NodeProps.VISIBLE, attr)) {
                setVisibility(0);
            } else if (TextUtils.equals("gone", attr)) {
                setVisibility(8);
            } else if (TextUtils.equals(QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE, attr)) {
                setVisibility(4);
            }
        }
    }

    private void setGradientBackground(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        if (TextUtils.isEmpty(this.mGradientDirection)) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i18 = 0;
        if ("left-right".equals(this.mGradientDirection)) {
            i16 = width;
            i3 = 0;
            i17 = 0;
        } else {
            if ("right-left".equals(this.mGradientDirection)) {
                i3 = 0;
                i16 = 0;
            } else if ("top-bottom".equals(this.mGradientDirection)) {
                i17 = height;
                i3 = 0;
                i16 = 0;
            } else if ("bottom-top".equals(this.mGradientDirection)) {
                i3 = height;
                i16 = 0;
                i17 = 0;
            } else if ("leftTop-rightBottom".equals(this.mGradientDirection)) {
                i16 = width;
                i17 = height;
                i3 = 0;
            } else if ("leftBottom-rightTop".equals(this.mGradientDirection)) {
                i16 = width;
                i3 = height;
                i17 = 0;
            } else if ("rightTop-leftBottom".equals(this.mGradientDirection)) {
                i17 = height;
                i3 = 0;
                i16 = 0;
                i18 = width;
            } else if ("rightBottom-leftTop".equals(this.mGradientDirection)) {
                i3 = height;
                i16 = 0;
            } else {
                return;
            }
            i17 = i16;
            i18 = width;
        }
        Paint paint = new Paint();
        Path path = new Path();
        paint.setShader(new LinearGradient(i18, i3, i16, i17, this.mGradientStartColor, this.mGradientEndColor, Shader.TileMode.CLAMP));
        path.addRoundRect(new RectF(0.0f, 0.0f, width, height), this.borderRadius, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    public final void addAreaCache(Integer num, Object obj) {
        if (num != null) {
            mAreaCache.put(num, obj);
        }
    }

    public final void addBackgroundCache(Integer num, DittoBitmapCache dittoBitmapCache) {
        if (num != null) {
            mBackgroundCache.put(num, dittoBitmapCache);
        }
    }

    public void clearAllAreaCache() {
        synchronized (mAreaCache) {
            mAreaCache.evictAll();
        }
        synchronized (mBackgroundCache) {
            mBackgroundCache.evictAll();
        }
        this.mHost = null;
        this.mBackground = null;
        this.mShadowDrawable = null;
        this.mCacheBackground = null;
        this.mCacheBorder = null;
        this.mTag = null;
        this.clickListener = null;
        this.longClickListener = null;
    }

    public void clearAnimation() {
        if (this.mCurrentAnimation == null) {
            return;
        }
        this.mCurrentAnimation = null;
        invalidate();
    }

    public void clearRichTextAreaCache() {
        synchronized (mAreaCache) {
            for (Integer num : mAreaCache.snapshot().keySet()) {
                Object obj = mAreaCache.get(num);
                if (obj != null && (obj instanceof DittoTextAreaCompat)) {
                    mAreaCache.remove(num);
                }
            }
        }
    }

    public boolean clickable() {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchTouchEventOutside() {
        onTouchEventOutside();
    }

    @Deprecated
    public void doneInflate() {
        setLayoutAttr(this.mLayoutAttr);
    }

    @Override // com.tencent.ditto.area.DittoElement
    public final void draw(Canvas canvas) {
        if ((this.mVisibility == 0 || this.mDrawIgnoreVisible) && getHeight() > 0 && getWidth() > 0) {
            int save = canvas.save();
            Animation animation = this.mCurrentAnimation;
            boolean z16 = false;
            if (animation != null) {
                if (!animation.isInitialized()) {
                    DittoAreaGroup dittoAreaGroup = this.mParent.get();
                    if (dittoAreaGroup == null) {
                        this.mCurrentAnimation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, 0, 0);
                    } else {
                        this.mCurrentAnimation.initialize(this.mRight - this.mLeft, this.mBottom - this.mTop, dittoAreaGroup.getWidth(), dittoAreaGroup.getHeight());
                    }
                    onAnimationStart();
                }
                if (this.mTransformation == null) {
                    this.mTransformation = new Transformation();
                }
                z16 = this.mCurrentAnimation.getTransformation(System.currentTimeMillis(), this.mTransformation);
                canvas.concat(this.mTransformation.getMatrix());
                if ((this.mTransformation.getTransformationType() & 1) == 1) {
                    canvas.saveLayerAlpha(this.mFBound, (int) (this.mTransformation.getAlpha() * 255.0f), 31);
                }
            }
            drawContent(canvas);
            drawContentB(canvas, save, z16);
        }
    }

    public DittoArea findTarget(float f16, float f17) {
        if (f16 > getLeft() && f16 < getRight() && f17 > getTop() && f17 < getBottom()) {
            return this;
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public float getAlpha() {
        return this.mAlpha;
    }

    public Animation getAnimation() {
        return this.mCurrentAnimation;
    }

    public final <T> T getAreaCache(Integer num, Class<T> cls) {
        if (num == null) {
            return null;
        }
        Object obj = mAreaCache.get(num);
        if (!cls.isInstance(obj)) {
            return null;
        }
        return cls.cast(obj);
    }

    public Object getAttachedObject() {
        WeakReference<Object> weakReference = this.mWeakAttachedObject;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final DittoBitmapCache getBackgroundCache(Integer num) {
        if (num == null) {
            return null;
        }
        return mBackgroundCache.get(num);
    }

    public Drawable getBackgroundDrawable() {
        return this.mBackground;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public float[] getBorderRadius() {
        return this.borderRadius;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getBottom() {
        return this.mBottom;
    }

    public int[] getCompassClickKey() {
        return this.compassClickKey;
    }

    public int[] getCompassExposureKey() {
        return this.compassExposureKey;
    }

    public String getContentDescription() {
        return this.mContentDescription;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getContentHeight() {
        return (getHeight() - this.paddingTop) - this.paddingBottom;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getContentWidth() {
        return (getWidth() - this.paddingLeft) - this.paddingRight;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public Context getContext() {
        return this.mHost.getContext();
    }

    public Object getData() {
        return null;
    }

    public String getGradientDirection() {
        return this.mGradientDirection;
    }

    public int getGradientEndColor() {
        return this.mGradientEndColor;
    }

    public int getGradientStartColor() {
        return this.mGradientStartColor;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getGravity() {
        return this.mGravity;
    }

    public int getHeight() {
        return this.mBottom - this.mTop;
    }

    public DittoHost getHost() {
        return this.mHost;
    }

    public String getId() {
        return this.f100544id;
    }

    public LayoutAttrSet getLayoutAttr() {
        return this.mLayoutAttr;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getLeft() {
        return this.mLeft;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getMarginBottom() {
        return this.mLayoutAttr.bottomMargin;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getMarginLeft() {
        return this.mLayoutAttr.leftMargin;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getMarginRight() {
        return this.mLayoutAttr.rightMargin;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getMarginTop() {
        return this.mLayoutAttr.topMargin;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public String getOnClickUri() {
        return this.onClickUri;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getPaddingRight() {
        return this.paddingRight;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getPaddingTop() {
        return this.paddingTop;
    }

    public DittoArea getParent() {
        WeakReference<DittoAreaGroup> weakReference = this.mParent;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public DittoValue getPostClickKey() {
        return this.postClickKey;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getRight() {
        return this.mRight;
    }

    public Drawable getShadowDrawable() {
        return this.mShadowDrawable;
    }

    public String getSilentUri() {
        return this.silentUri;
    }

    public String getSilentUriSentToast() {
        return this.silentUriSentToast;
    }

    public Object getTag() {
        return this.mTag;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getTop() {
        return this.mTop;
    }

    public int getTttReportArea() {
        return this.tttReportArea;
    }

    public int getType() {
        return 0;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWeight() {
        return this.mLayoutAttr.weight;
    }

    public int getWidth() {
        return this.mRight - this.mLeft;
    }

    public void invalidate() {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.postInvalidate();
        }
    }

    public void invalidateDelayed(long j3) {
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.postInvalidateDelayed(j3);
        }
    }

    @Override // com.tencent.ditto.area.DittoElement
    public final void layout(int i3, int i16, int i17, int i18) {
        Rect rect;
        this.mLeft = i3;
        this.mTop = i16;
        this.mRight = i17;
        this.mBottom = i18;
        this.width = i17 - i3;
        this.height = i18 - i16;
        Rect rect2 = this.mBound;
        if (rect2 == null) {
            this.mBound = new Rect(0, 0, this.width, this.height);
            this.mFBound = new RectF(this.mBound);
        } else if (rect2.height() != this.height || this.mBound.width() != this.width) {
            Rect rect3 = new Rect(0, 0, this.width, this.height);
            this.isBgDirty = true;
            this.isBorderDirty = true;
            Drawable drawable = this.mBackground;
            if (drawable != null) {
                drawable.setBounds(rect3);
            }
            this.mBound = rect3;
            this.mFBound = new RectF(this.mBound);
        }
        int i19 = (((this.width + this.shadowSizeLeft) + this.shadowSizeRight) - this.paddingLeft) - this.paddingRight;
        int i26 = (((this.height + this.shadowSizeTop) + this.shadowSizeBottom) - this.paddingTop) - this.paddingBottom;
        if (this.mShadowDrawable != null && ((rect = this.shadowBound) == null || rect.width() != i19 || this.shadowBound.height() != i26)) {
            Rect rect4 = new Rect(0, 0, i19, i26);
            this.mShadowDrawable.setBounds(rect4);
            this.shadowBound = rect4;
        }
        executeCornerPath();
        onLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.ditto.area.DittoElement
    public final void measure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode == 1073741824) {
            size = (size - getPaddingLeft()) - getPaddingRight();
        }
        if (mode2 == 1073741824) {
            size2 = (size2 - getPaddingTop()) - getPaddingBottom();
        }
        onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    this.isPressed = false;
                    onPressedAlpha(false);
                    this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
                }
            } else if (this.isPressed) {
                this.isPressed = false;
                onPressedAlpha(false);
                this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
                return performClick(motionEvent);
            }
        } else if (isActionDownValid()) {
            this.isPressed = true;
            onPressedAlpha(true);
            if (this.longClickListener != null) {
                checkForLongClick(motionEvent);
            }
            return true;
        }
        return false;
    }

    public boolean performClick(MotionEvent motionEvent) {
        if (!TextUtils.isEmpty(this.areaIdShouldInvokeClick)) {
            this.mHost.invokeAreaClick(this.areaIdShouldInvokeClick, motionEvent);
            return true;
        }
        if (!TextUtils.isEmpty(getOnClickUri())) {
            if (getCompassClickKey() != null) {
                DittoUIEngine.g().getReporter().compassReport(getCompassClickKey());
            }
            getHost().handleUri(getOnClickUri(), this, motionEvent);
            return true;
        }
        if (!TextUtils.isEmpty(getSilentUri())) {
            if (getCompassClickKey() != null) {
                DittoUIEngine.g().getReporter().compassReport(getCompassClickKey());
            }
            getHost().handleSilentUri(getSilentUri(), this, motionEvent);
            return true;
        }
        if (!TextUtils.isEmpty(this.cmd) && !TextUtils.isEmpty(this.cmdParamType) && Integer.MIN_VALUE != this.cmdParamKey) {
            if (getCompassClickKey() != null) {
                DittoUIEngine.g().getReporter().compassReport(getCompassClickKey());
            }
            getHost().handleSilentRequest(this.cmd, this.cmdParamType, this.cmdParamKey, this, motionEvent);
            return true;
        }
        return performListenerClick(motionEvent);
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void requestLayout() {
        if (this.mHost != null) {
            if (isUIThread()) {
                this.mHost.requestLayout();
            } else {
                this.mMainHandler.post(new Runnable() { // from class: com.tencent.ditto.area.DittoArea.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DittoArea.this.mHost.requestLayout();
                    }
                });
            }
        }
    }

    public int resolveSize(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return i3;
            }
        } else if (size >= i3) {
            return i3;
        }
        return size;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void setAlpha(float f16) {
        if (this.mAlpha == f16) {
            return;
        }
        this.isBgDirty = true;
        this.mAlpha = f16;
    }

    public void setAnimation(Animation animation) {
        this.mCurrentAnimation = animation;
        if (animation != null) {
            animation.reset();
        }
    }

    public void setAreaCacheKey(Integer num) {
        this.mAreaCacheKey = num;
    }

    public void setAttachedObject(Object obj) {
        this.mWeakAttachedObject = new WeakReference<>(obj);
    }

    public void setBackgroundColor(@ColorInt int i3) {
        if (this.mBgColor != i3) {
            this.isBgDirty = true;
            this.mBgColor = i3;
            this.mAlpha = Color.alpha(i3);
            invalidate();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
    }

    public void setBorderColor(int i3) {
        if (this.borderColor != i3) {
            this.isBorderDirty = true;
        }
        this.borderColor = i3;
        invalidate();
    }

    public void setBorderRadius(int i3) {
        float f16 = i3;
        setBorderRadius(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
    }

    public void setBorderWidth(int i3) {
        if (this.borderWidth != i3) {
            this.isBorderDirty = true;
        }
        this.borderWidth = i3;
        invalidate();
    }

    public void setContentDescription(String str) {
        String str2 = this.mContentDescription;
        if (str2 == null) {
            if (str == null) {
                return;
            }
        } else if (str2.equals(str)) {
            return;
        }
        this.mContentDescription = str;
        DittoHost dittoHost = this.mHost;
        if (dittoHost != null) {
            dittoHost.onContentDescriptionChanged(this);
        }
    }

    public void setGradientDirection(String str) {
        this.mGradientDirection = str;
    }

    public void setGradientEndColor(int i3) {
        this.mGradientEndColor = i3;
    }

    public void setGradientStartColor(int i3) {
        this.mGradientStartColor = i3;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void setGravity(int i3) {
        if (this.mGravity == i3) {
            return;
        }
        this.mGravity = i3;
    }

    @Deprecated
    public void setHost(DittoHost dittoHost) {
        this.mHost = dittoHost;
    }

    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        DittoHost dittoHost;
        this.mLayoutAttr = layoutAttrSet;
        if (layoutAttrSet != null) {
            this.f100544id = layoutAttrSet.f100546id;
            setPadding(layoutAttrSet.leftPadding, layoutAttrSet.topPadding, layoutAttrSet.rightPadding, layoutAttrSet.bottomPadding);
            parseAttr(layoutAttrSet);
            parseAttr2(layoutAttrSet);
            setBorderWidth(layoutAttrSet.getPostFixedAttr(LayoutAttrDefine.BorderWidth, 0));
            if (layoutAttrSet.hasAttr(LayoutAttrDefine.BorderRadii4)) {
                int i3 = layoutAttrSet.topLeftRadius;
                int i16 = layoutAttrSet.topRightRadius;
                int i17 = layoutAttrSet.bottomRightRadius;
                int i18 = layoutAttrSet.bottomLeftRadius;
                setBorderRadius(new float[]{i3, i3, i16, i16, i17, i17, i18, i18});
            } else {
                setBorderRadius(layoutAttrSet.getPostFixedAttr(LayoutAttrDefine.BorderRadius, 0));
            }
            if (layoutAttrSet.getAttr(LayoutAttrDefine.BorderColor, (String) null) != null) {
                String attr = layoutAttrSet.getAttr(LayoutAttrDefine.BorderColor, (String) null);
                try {
                    setBorderColor(DittoResourcesUtil.parseColor(attr));
                } catch (Throwable th5) {
                    setBorderColor(-1);
                    DittoLog.e(DittoLog.defaultTag, "the text " + attr + " can't be parsed as color string", th5);
                }
            }
            resetBgColorAndVisible(layoutAttrSet);
            setShadowSize(layoutAttrSet.leftShadowSize, layoutAttrSet.topShadowSize, layoutAttrSet.rightShadowSize, layoutAttrSet.bottomShadowSize);
            if (layoutAttrSet.shadowResourceId != 0 && (dittoHost = this.mHost) != null && dittoHost.getContext() != null && this.mHost.getContext().getResources() != null) {
                try {
                    setShadowDrawable(this.mHost.getContext().getResources().getDrawable(layoutAttrSet.shadowResourceId));
                } catch (Exception unused) {
                    DittoLog.e(DittoLog.defaultTag, "can not find drawable by id " + layoutAttrSet.shadowResourceId);
                }
            }
            this.mGradientDirection = layoutAttrSet.gradientDirection;
            this.mGradientStartColor = layoutAttrSet.gradientStartColor;
            this.mGradientEndColor = layoutAttrSet.gradientEndColor;
            this.mPressedAlpha = layoutAttrSet.pressedAlpha;
        }
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void setMargin(int i3, int i16, int i17, int i18) {
        this.mLayoutAttr.setMargin(i3, i16, i17, i18);
    }

    public void setMeasureDirty(boolean z16) {
        this.mMeasureDirty = z16;
    }

    public void setMeasuredDimension(int i3, int i16) {
        this.mMeasuredWidth = i3 + getPaddingLeft() + getPaddingRight();
        this.mMeasuredHeight = i16 + getPaddingTop() + getPaddingBottom();
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void setPadding(int i3, int i16, int i17, int i18) {
        this.paddingLeft = i3;
        this.paddingTop = i16;
        this.paddingRight = i17;
        this.paddingBottom = i18;
        LayoutAttrSet layoutAttrSet = this.mLayoutAttr;
        layoutAttrSet.leftPadding = i3;
        layoutAttrSet.topPadding = i16;
        layoutAttrSet.rightPadding = i17;
        layoutAttrSet.bottomPadding = i18;
    }

    public void setPressedAlpha(int i3) {
        this.mPressedAlpha = i3;
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void setPxMargin(int i3, int i16, int i17, int i18) {
        this.mLayoutAttr.setMargin(i3, i16, i17, i18);
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mShadowDrawable = drawable;
        Rect rect = this.shadowBound;
        if (rect != null) {
            drawable.setBounds(rect);
        }
        invalidate();
    }

    @Override // com.tencent.ditto.area.DittoElement
    public void setShadowSize(int i3, int i16, int i17, int i18) {
        this.shadowSizeLeft = i3;
        this.shadowSizeTop = i16;
        this.shadowSizeRight = i17;
        this.shadowSizeBottom = i18;
        int i19 = (((this.width + i3) + i17) - this.paddingLeft) - this.paddingRight;
        int i26 = (((this.height + i16) + i18) - this.paddingTop) - this.paddingBottom;
        if (this.mShadowDrawable != null) {
            Rect rect = this.shadowBound;
            if (rect == null || rect.width() != i19 || this.shadowBound.height() != i26) {
                Rect rect2 = new Rect(0, 0, i19, i26);
                this.mShadowDrawable.setBounds(rect2);
                this.shadowBound = rect2;
            }
        }
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }

    public void setVisibility(int i3) {
        if (this.mVisibility == i3) {
            return;
        }
        this.mVisibility = i3;
        requestLayout();
    }

    public void startAnimation(Animation animation) {
        animation.setStartTime(-1L);
        setAnimation(animation);
        invalidate();
    }

    public DittoArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        this.mAreaCacheKey = null;
        this.mGravity = 3;
        this.mDrawIgnoreVisible = false;
        this.borderWidth = 0;
        this.borderColor = 0;
        this.borderRadius = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.mVisibility = 0;
        this.mAlpha = 255.0f;
        this.isPressed = false;
        this.mMeasureDirty = false;
        this.mCacheBackground = null;
        this.mCacheBorder = null;
        this.isBgDirty = false;
        this.isBorderDirty = false;
        this.mCurrentAnimation = null;
        this.cmdParamKey = Integer.MIN_VALUE;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.ignoreClick = false;
        this.tttReportArea = -1;
        this.mPressedAlpha = 0;
        this.mHost = dittoHost;
        this.mLayoutAttr = layoutAttrSet;
    }

    public void setBorderRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        float[] fArr2 = new float[8];
        for (int i3 = 0; i3 < 8; i3++) {
            float f16 = fArr[i3];
            fArr2[i3] = f16;
            float[] fArr3 = this.borderRadius;
            if (fArr3 != null && f16 != fArr3[i3] && !this.isBorderDirty) {
                this.isBgDirty = true;
                this.isBorderDirty = true;
            }
        }
        this.borderRadius = fArr2;
        Path path = this.cornerPath;
        if (path == null) {
            this.cornerPath = new Path();
        } else {
            path.reset();
        }
        if (needResetCornerBound()) {
            this.cornerBound = new RectF(0.0f, 0.0f, getContentWidth(), getContentHeight());
        }
        this.cornerPath.addRoundRect(this.cornerBound, getBorderRadius(), Path.Direction.CW);
        this.cornerPathHeight = getContentHeight();
        this.cornerPathWidth = getContentWidth();
        invalidate();
    }

    public void performLongClick(MotionEvent motionEvent, Object obj) {
        LongClickListener longClickListener = this.longClickListener;
        if (longClickListener != null) {
            longClickListener.onLongClick(this, motionEvent, obj);
        }
    }

    private void onAnimationStart() {
    }

    public void onDraw(Canvas canvas) {
    }

    public void onLayout(int i3, int i16, int i17, int i18) {
    }
}
