package com.qzone.preview.photodanmaku.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.qzone.preview.photodanmaku.config.PhotoDanmakuConfig;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuDrawer;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class AbsDanmaku implements Comparable<AbsDanmaku> {
    public static final int DEFAULT_NICK_NAME_TEXT_COLOR = -1;
    public static final int DEFAULT_REPEAT_TIME = 10000;
    public static final int IMAGE_SHAPE_CIRCLE = 1;
    public static final int IMAGE_SHAPE_NORMAL = 0;
    public static final int INVISIBLE = 0;
    public static final int NO_DANMAKU_ID = -1;
    public static final int NO_USER_LOGO_DANMAKU = -10;
    public static final int REPEAT_INTERVAL = 100;
    protected static final String TAG = "AbsDanmaku";
    public static final int TYPE_SCROLL_RL = 1;
    public static final int VISIBLE = 1;
    private static final AtomicLong danmukuIndex = new AtomicLong();
    protected int mAlpha;
    protected String mBackgroundImageUrl;
    protected int mBorderColor;
    protected String mBorderPaintKey;
    protected float mBorderRadio;
    protected float mBorderWidth;
    protected boolean mClickEnable;
    protected Bitmap mDrawCache;
    protected Canvas mDrawCacheCanvas;
    protected volatile boolean mDrawCacheDirty;
    protected boolean mDrawCacheEnable;
    protected a mDuration;
    protected int mFontType;
    protected String mFontUrl;
    protected boolean mHasAntiAlias;
    protected boolean mIsClicked;
    protected boolean mIsPaused;
    protected float mLeftImagePadding;
    protected int mLeftImageShape;
    protected Bitmap mLogoBitmap;
    protected byte mMajorPriority;
    protected int mMarginHorizontal;
    protected int mMarginVertical;
    protected int mMinorPrioriy;
    protected String mNickNameStr;
    protected float mPaddingHorizontal;
    protected float mPaddingVertical;
    public int mPerferredLine;
    protected final PhotoDanmakuConfig mPhotoDanmakuConfig;
    protected final int mScreenHeight;
    protected final int mScreenWidth;
    protected CharSequence mText;
    protected int mTextColor;
    protected float mTextMaxWidth;
    protected String mTextPaintKey;
    protected float mTextSize;
    protected String mTextStr;
    protected float mTextTopModifiedValue;
    protected long mTime;
    protected b mTimer;
    protected long mUserUin;
    protected int mVisibility;
    public int shadowColor;
    public int shadowDx;
    public int shadowDy;
    public int shadowRadius;
    protected QzoneSuperPersonalFontData.SuperFontInfo superFontInfo;
    public boolean isPostImmediatelyDanmaku = false;
    protected final long mIndex = danmukuIndex.incrementAndGet();
    protected long mDanmakuId = -1;
    protected int mNickNameTextColor = -1;
    public boolean hasShadowLayer = false;
    protected int mFontId = -1;
    protected float mPaintWidth = -1.0f;
    protected float mPaintHeight = -1.0f;
    protected float mContentWidth = -1.0f;
    protected float mContentHeight = -1.0f;
    protected int mRepeatTime = 10000;

    public AbsDanmaku(PhotoDanmakuConfig photoDanmakuConfig, a aVar, b bVar) {
        this.mPhotoDanmakuConfig = photoDanmakuConfig;
        this.mDuration = aVar;
        this.mTimer = bVar;
        this.mScreenWidth = photoDanmakuConfig.mScreenWidth;
        this.mScreenHeight = photoDanmakuConfig.mScreenHeight;
        init();
    }

    public void clearDrawCacheCanvas() {
        this.mDrawCacheCanvas.setBitmap(null);
    }

    public float distance(float f16, float f17) {
        return (float) Math.sqrt(Math.pow(getCenterX() - f16, 2.0d) + Math.pow(getCenterY() - f17, 2.0d));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbsDanmaku)) {
            return false;
        }
        AbsDanmaku absDanmaku = (AbsDanmaku) obj;
        long j3 = this.mDanmakuId;
        if (j3 == -1) {
            return false;
        }
        long j16 = absDanmaku.mDanmakuId;
        return j16 != -1 && j3 == j16;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public String getBackgroundImageUrl() {
        return this.mBackgroundImageUrl;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public String getBorderPaintKey() {
        return this.mBorderPaintKey;
    }

    public float getBorderRadio() {
        return this.mBorderRadio;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public abstract float getBottom();

    public float getCenterX() {
        return (getRight() - getLeft()) / 2.0f;
    }

    public float getCenterY() {
        return (getBottom() - getTop()) / 2.0f;
    }

    public abstract float[] getCollisionRectAtTime(long j3);

    public PhotoDanmakuConfig getConfig() {
        return this.mPhotoDanmakuConfig;
    }

    public float getContentHeight() {
        return this.mContentHeight;
    }

    public float getContentLeft() {
        return getLeft() + getMarginHorizontal();
    }

    public float getContentTop() {
        return getTop() + getMarginVertical();
    }

    public float getContentWidth() {
        return this.mContentWidth;
    }

    public Bitmap getDrawCache() {
        return this.mDrawCache;
    }

    public Canvas getDrawCacheCanvas() {
        return this.mDrawCacheCanvas;
    }

    public long getDuration() {
        return this.mDuration.c();
    }

    public long getEndTime() {
        return getTime() + getDuration();
    }

    public int getFontId() {
        return this.mFontId;
    }

    public int getFontType() {
        return this.mFontType;
    }

    public String getFontUrl() {
        return this.mFontUrl;
    }

    public long getIndex() {
        return this.mIndex;
    }

    public abstract float getLeft();

    public float getLeftImagePadding() {
        return this.mLeftImagePadding;
    }

    public Bitmap getLogoBitmap() {
        return this.mLogoBitmap;
    }

    public byte getMajorPriority() {
        return this.mMajorPriority;
    }

    public int getMarginHorizontal() {
        return this.mMarginHorizontal;
    }

    public int getMarginVertical() {
        return this.mMarginVertical;
    }

    public int getMinorPrioriy() {
        return this.mMinorPrioriy;
    }

    public String getNickNameStr() {
        return this.mNickNameStr;
    }

    public int getNickNameTextColor() {
        return this.mNickNameTextColor;
    }

    public float getPaddingHorizontal() {
        return this.mPaddingHorizontal;
    }

    public float getPaddingVertical() {
        return this.mPaddingVertical;
    }

    public float getPaintHeight() {
        return this.mPaintHeight;
    }

    public float getPaintWidth() {
        return this.mPaintWidth;
    }

    public int getPerferredLine(int i3) {
        int i16 = this.mPerferredLine;
        return i16 > i3 ? i3 - 1 : i16;
    }

    public abstract float[] getRectAtTime(long j3);

    public int getRepeatTime() {
        return this.mRepeatTime;
    }

    public abstract float getRight();

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public abstract float getSpeedX();

    public QzoneSuperPersonalFontData.SuperFontInfo getSuperFontInfo() {
        return this.superFontInfo;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public String getTextPaintKey() {
        return this.mTextPaintKey;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public String getTextStr() {
        return this.mTextStr;
    }

    public float getTextTopModifiedValue() {
        return this.mTextTopModifiedValue;
    }

    public long getTime() {
        return this.mTime;
    }

    public b getTimer() {
        return this.mTimer;
    }

    public abstract float getTop();

    public abstract int getType();

    public long getUserUin() {
        return this.mUserUin;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public boolean hasAntiAlias() {
        return this.mHasAntiAlias;
    }

    public int hashCode() {
        return (int) this.mDanmakuId;
    }

    protected void init() {
        setMarginHorizontal(this.mPhotoDanmakuConfig.mMarginHorizontal);
        setMarginVertical(this.mPhotoDanmakuConfig.mMarginVertical);
        setPaddingHorizontal(this.mPhotoDanmakuConfig.mPaddingHorizontal);
        setPaddingVertical(this.mPhotoDanmakuConfig.mPaddingVertical);
        setLeftImagePadding(this.mPhotoDanmakuConfig.mLeftImagePadding);
        setAlpha(this.mPhotoDanmakuConfig.mAlpha);
        setTextSize(this.mPhotoDanmakuConfig.mTextSize);
        setTextColor(this.mPhotoDanmakuConfig.mTextColor);
        setHasAntiAlias(this.mPhotoDanmakuConfig.mHasAntiAlias);
        setDrawCacheEnable(this.mPhotoDanmakuConfig.mDrawCacheEnable);
        setBorderWidth(this.mPhotoDanmakuConfig.mBorderWidth);
        setClickEnable(this.mPhotoDanmakuConfig.mClickEnable);
    }

    public boolean isClickEnable() {
        return this.mClickEnable;
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public boolean isDrawCacheDirty() {
        return this.mDrawCacheDirty;
    }

    public boolean isDrawCacheEnable() {
        return this.mDrawCacheEnable;
    }

    public boolean isMeasured() {
        return this.mPaintWidth >= 0.0f && this.mPaintHeight >= 0.0f;
    }

    public boolean isOutside() {
        b bVar = this.mTimer;
        if (bVar != null) {
            return isOutside(bVar.a());
        }
        return true;
    }

    public boolean isShown() {
        return this.mVisibility == 1;
    }

    public boolean isTimeOut() {
        b bVar = this.mTimer;
        if (bVar != null) {
            return isTimeOut(bVar.a());
        }
        return true;
    }

    public final void layout(PhotoDanmakuDrawer photoDanmakuDrawer, float f16, float f17) {
        onLayout(photoDanmakuDrawer, f16, f17);
    }

    public void onDraw(PhotoDanmakuDrawer photoDanmakuDrawer) {
        photoDanmakuDrawer.k(this);
    }

    protected abstract void onLayout(PhotoDanmakuDrawer photoDanmakuDrawer, float f16, float f17);

    public void onMeasure(PhotoDanmakuDrawer photoDanmakuDrawer) {
        photoDanmakuDrawer.y(this);
    }

    public abstract void onReLayout();

    public final void reLayout() {
        long b16 = this.mTimer.b();
        if (this.mIsPaused) {
            this.mTime += b16;
        }
        onReLayout();
    }

    public long remainTime() {
        return (this.mTime + this.mDuration.c()) - this.mTimer.a();
    }

    public boolean repeat() {
        int i3 = this.mRepeatTime;
        if (i3 - 100 < 0) {
            return false;
        }
        this.mRepeatTime = i3 - 100;
        this.mTime += 100;
        return true;
    }

    public void reset() {
        this.mDuration.b();
        this.mText = null;
        this.mTextStr = null;
        this.mTextSize = 0.0f;
        this.mTextColor = -1;
        this.mUserUin = -1L;
        this.mLeftImagePadding = 0.0f;
        this.mLeftImageShape = 0;
        this.mBackgroundImageUrl = null;
        this.mAlpha = 0;
        this.mMarginVertical = 0;
        this.mMarginHorizontal = 0;
        this.mPaddingHorizontal = 0.0f;
        this.mPaddingVertical = 0.0f;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = -1;
        this.mBorderRadio = 0.0f;
        this.mMajorPriority = (byte) 0;
        this.mMinorPrioriy = 0;
        this.mTextPaintKey = null;
        this.mBorderPaintKey = null;
        this.mTextTopModifiedValue = 0.0f;
        this.mPaintWidth = -1.0f;
        this.mPaintHeight = -1.0f;
        this.mContentWidth = -1.0f;
        this.mContentHeight = -1.0f;
        this.mVisibility = 0;
        this.mHasAntiAlias = false;
        this.mDrawCacheEnable = false;
        this.mDrawCacheDirty = true;
        this.mDrawCache = null;
        this.mRepeatTime = 0;
        this.mIsClicked = false;
        this.mClickEnable = false;
        this.mPerferredLine = 0;
        this.mIsPaused = false;
        init();
    }

    public void setAlpha(int i3) {
        if (this.mAlpha != i3) {
            this.mAlpha = i3;
            this.mTextPaintKey = null;
            this.mBorderPaintKey = null;
            this.mDrawCacheDirty = true;
        }
    }

    public void setBackgroundImageUrl(String str) {
        if (TextUtils.equals(this.mBackgroundImageUrl, str)) {
            return;
        }
        this.mBackgroundImageUrl = str;
        this.mBorderPaintKey = null;
        this.mDrawCacheDirty = true;
    }

    public void setBorderColor(int i3) {
        if (this.mBorderColor != i3) {
            this.mBorderColor = i3;
            this.mBorderPaintKey = null;
            this.mDrawCacheDirty = true;
        }
    }

    public void setBorderPaintKey(String str) {
        this.mBorderPaintKey = str;
    }

    public void setBorderRadio(float f16) {
        this.mBorderRadio = f16;
        this.mDrawCacheDirty = true;
    }

    public void setBorderWidth(float f16) {
        if (this.mBorderWidth != f16) {
            this.mBorderWidth = f16;
            this.mBorderPaintKey = null;
            this.mDrawCacheDirty = true;
        }
    }

    public void setClickEnable(boolean z16) {
        this.mClickEnable = z16;
    }

    public void setClicked(boolean z16) {
        this.mIsClicked = z16;
    }

    public void setContentHeight(float f16) {
        this.mContentHeight = f16;
    }

    public void setContentWidth(float f16) {
        this.mContentWidth = f16;
    }

    public void setDrawCache(Bitmap bitmap) {
        this.mDrawCache = bitmap;
    }

    public void setDrawCacheCanvas(Canvas canvas) {
        this.mDrawCacheCanvas = canvas;
    }

    public void setDrawCacheDirty(boolean z16) {
        this.mDrawCacheDirty = z16;
    }

    public void setDrawCacheEnable(boolean z16) {
        this.mDrawCacheEnable = z16;
    }

    public void setDuration(a aVar) {
        this.mDuration = aVar;
    }

    public void setFontId(int i3) {
        this.mFontId = i3;
    }

    public void setFontType(int i3) {
        this.mFontType = i3;
    }

    public void setFontUrl(String str) {
        this.mFontUrl = str;
    }

    public void setHasAntiAlias(boolean z16) {
        this.mHasAntiAlias = z16;
        this.mDrawCacheDirty = true;
    }

    public void setIsClicked(boolean z16) {
        this.mIsClicked = z16;
    }

    public void setLeftImagePadding(float f16) {
        this.mLeftImagePadding = f16;
        this.mDrawCacheDirty = true;
    }

    public void setLeftImageShape(int i3) {
        if (this.mLeftImageShape != i3) {
            this.mLeftImageShape = i3;
            this.mDrawCacheDirty = true;
        }
    }

    public void setMarginHorizontal(int i3) {
        this.mMarginHorizontal = i3;
        this.mDrawCacheDirty = true;
    }

    public void setMarginVertical(int i3) {
        this.mMarginVertical = i3;
        this.mDrawCacheDirty = true;
    }

    public void setNickNameStr(String str) {
        this.mNickNameStr = str;
        this.mDrawCacheDirty = true;
    }

    public void setNickNameTextColor(int i3) {
        if (this.mNickNameTextColor != i3) {
            this.mNickNameTextColor = i3;
            this.mDrawCacheDirty = true;
        }
    }

    public void setPaddingHorizontal(float f16) {
        this.mPaddingHorizontal = f16;
        this.mDrawCacheDirty = true;
    }

    public void setPaddingVertical(float f16) {
        this.mPaddingVertical = f16;
        this.mDrawCacheDirty = true;
    }

    public void setPaintHeight(float f16) {
        this.mPaintHeight = f16;
    }

    public void setPaintWidth(float f16) {
        this.mPaintWidth = f16;
    }

    public void setRemainTime(long j3) {
        setTime((j3 + this.mTimer.a()) - getDuration());
    }

    public void setShadowLayer(boolean z16, int i3, int i16, int i17, int i18) {
        this.hasShadowLayer = z16;
        if (z16) {
            this.shadowRadius = i3;
            this.shadowDx = i16;
            this.shadowDy = i17;
            this.shadowColor = i18;
        }
    }

    public void setSuperFontInfo(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        this.superFontInfo = superFontInfo;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
        this.mPaintWidth = -1.0f;
        this.mTextPaintKey = null;
        this.mDrawCacheDirty = true;
    }

    public void setTextColor(int i3) {
        if (this.mTextColor != i3) {
            this.mTextColor = i3;
            this.mTextPaintKey = null;
            this.mDrawCacheDirty = true;
        }
    }

    public void setTextPaintKey(String str) {
        this.mTextPaintKey = str;
    }

    public void setTextSize(float f16) {
        if (this.mTextSize != f16) {
            this.mTextSize = f16;
            this.mTextPaintKey = null;
            this.mDrawCacheDirty = true;
        }
    }

    public void setTextStr(String str) {
        this.mTextStr = str;
    }

    public void setTextTopModifiedValue(float f16) {
        this.mTextTopModifiedValue = f16;
    }

    public void setTime(long j3) {
        this.mTime = j3;
    }

    public void setTimer(b bVar) {
        this.mTimer = bVar;
    }

    public void setUserLogoByUin(long j3) {
        if (this.mUserUin != j3) {
            this.mUserUin = j3;
            this.mDrawCacheDirty = true;
        }
    }

    public void setVisibility(boolean z16) {
        if (z16) {
            this.mVisibility = 1;
        } else {
            this.mVisibility = 0;
        }
    }

    public String toString() {
        return "absDanmaku_" + this.mIndex;
    }

    @Override // java.lang.Comparable
    public int compareTo(AbsDanmaku absDanmaku) {
        return n8.b.a(this, absDanmaku);
    }

    public void pause() {
        this.mIsPaused = true;
    }

    public void resume() {
        this.mIsPaused = false;
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.mDrawCacheDirty = true;
        this.mLogoBitmap = bitmap;
    }

    public boolean isOutside(long j3) {
        long j16 = j3 - this.mTime;
        return j16 < 0 || j16 >= this.mDuration.c();
    }

    public boolean isTimeOut(long j3) {
        return j3 - this.mTime >= this.mDuration.c();
    }

    public void setVisibility(int i3) {
        this.mVisibility = i3;
    }

    public boolean repeat(int i3) {
        int i16 = this.mRepeatTime;
        if (i16 - i3 < 0) {
            return false;
        }
        this.mRepeatTime = i16 - i3;
        this.mTime += i3;
        return true;
    }
}
