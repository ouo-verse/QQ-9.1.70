package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.module.feedcomponent.ui.FeedTextArea;
import com.qzone.module.feedcomponent.ui.FeedTextAreaEx;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.module.feedcomponent.ui.ViewArea;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.widget.particle.ParticleTextSurfaceView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.area.MeasureCacheable;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.widget.DittoTextArea;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RichCanvasTextArea extends DittoTextArea implements ViewArea.OnAreaClickedListener, SubArea.ViewHost, ViewArea.OnAreaLongClickedListener {
    public static final String MAX_LENGTH = "max_length";
    public static final String SHOW_SHADOW_ON_PRESS = "show_shadow_on_press";
    private int ellipsisColor;
    private float ellipsisSize;
    private String ellipsisStr;
    private boolean hasMore;
    private boolean isNeedLineSpace;
    private boolean isShowMore;
    private boolean isShowPackOrUnpack;
    private int mAdditionEllipsizeWidth;
    private int mAnimationPeriod;
    private QzoneBarrageEffectData.BarrageEffectInfo mBarrageInfo;
    private int mColorBackground;
    private ArrayList<Integer> mColors;
    private int mDrawableSpace;
    private String mFontBGUrl;
    private int mFontId;
    private QzoneSuperPersonalFontData.SuperFontInfo mFontInfo;
    private String mFontUrl;
    private int mForntSizeType;
    private boolean mIsSpan;
    private Drawable mLeftDrawable;
    private int mLeftDrawableGravity;
    private int mLinkColor;
    private int mLinkColorBackground;
    private int mMaxLength;
    private int mMaxLines;
    private int mMaxPack;
    private int mMinPack;
    private int mMinlines;
    private int mNativeFontType;
    private OnTextMeasuredListener mOnTextMeasuredListener;
    private int mPackOrUnpackDirect;
    private int mPackShowLine;
    private ParticleTextSurfaceView mParticleTextSurfaceView;
    private int mParticleTextVisibility;
    protected FeedTextAreaEx mTextArea;
    private int mTextColor;
    private int mTextInType;
    private float mTextSize;
    private int maxCommentLine;
    private int oldHeightMeasureSpec;
    private int oldWidthMeasureSpec;
    private boolean showShadowOnPress;
    private QzoneSuperPersonalFontData.SuperFontInfo superFontInfo;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnTextMeasuredListener {
        void onMeasured();
    }

    public RichCanvasTextArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mLinkColor = -1;
        this.mMaxLines = -1;
        this.mMaxLength = -1;
        this.showShadowOnPress = false;
        this.isNeedLineSpace = true;
        this.hasMore = false;
        this.mMinlines = -1;
        this.isShowMore = false;
        this.mPackOrUnpackDirect = 0;
        this.mMaxPack = 0;
        this.mMinPack = 0;
        this.mPackShowLine = 0;
        this.mIsSpan = false;
        this.mTextInType = 0;
        this.isShowPackOrUnpack = false;
        this.mParticleTextVisibility = 0;
        this.mDrawableSpace = (int) (DittoUIEngine.g().getDensity() * 5.0f);
        this.mLeftDrawableGravity = 17;
        this.maxCommentLine = 0;
        this.ellipsisStr = null;
        this.ellipsisSize = Float.NaN;
        this.ellipsisColor = -16777216;
        this.mAdditionEllipsizeWidth = 0;
        this.mColorBackground = 0;
        this.mLinkColorBackground = 0;
    }

    private Integer generateCacheKey() {
        String str;
        Integer num = this.mAreaCacheKey;
        if (num != null) {
            return num;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mText);
        sb5.append("_");
        sb5.append(this.mTextColor);
        sb5.append("_");
        sb5.append(this.mTextSize);
        sb5.append("_");
        sb5.append(this.mMaxLines);
        sb5.append("_");
        sb5.append(this.mFontId);
        sb5.append("_");
        sb5.append(this.mTextBold);
        sb5.append("_");
        sb5.append(this.mFontUrl);
        sb5.append("_");
        sb5.append(this.letterSpace);
        sb5.append("_");
        sb5.append(this.mNativeFontType);
        sb5.append("_");
        sb5.append(this.letterSpace);
        sb5.append("_");
        sb5.append(this.mFontFamily);
        sb5.append("_");
        sb5.append(getAreaMaxCommentLine());
        String str2 = "";
        if (getTag() == null) {
            str = "";
        } else {
            str = "_" + getTag().toString();
        }
        sb5.append(str);
        sb5.append("_");
        sb5.append(FeedGlobalEnv.g().getScreenWidth());
        if (this.mLeftDrawable != null) {
            str2 = "_" + this.mLeftDrawable.hashCode();
        }
        sb5.append(str2);
        return Integer.valueOf(sb5.toString().hashCode());
    }

    private int getAreaMaxCommentLine() {
        if (getTextArea() == null || getTextArea().getTextLayout() == null) {
            return 0;
        }
        return getTextArea().getTextLayout().getMaxCommentLine();
    }

    private FeedTextAreaEx getTextFromCache() {
        return (FeedTextAreaEx) getAreaCache(generateCacheKey(), FeedTextAreaEx.class);
    }

    private void recycleText() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.clearTouchingEvent();
            this.mTextArea.clearClickListener();
            this.mTextArea.recycleTextRes();
            this.mTextArea = null;
        }
    }

    protected FeedTextAreaEx generateAndMeasureText(int i3, int i16) {
        obtainText();
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx.oldWidthMeasureSpec != i3 || feedTextAreaEx.oldHeightMeasureSpec != i16 || this.mMeasureDirty) {
            feedTextAreaEx.measure(i3, i16);
        }
        return this.mTextArea;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        Object obj = this.mHost;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public int getLineCount() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            return feedTextAreaEx.getLineCount();
        }
        return 0;
    }

    public int getLineHeight() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            return feedTextAreaEx.getLineHeight();
        }
        return 0;
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public int getMaxLines() {
        return this.mMaxLines;
    }

    public FeedTextArea getTextArea() {
        return this.mTextArea;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement, com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidate() {
        if (FeedView.isIdle) {
            super.invalidate();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement, com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidateDelayed(long j3) {
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.qzone.canvasui.widget.RichCanvasTextArea.1
            @Override // java.lang.Runnable
            public void run() {
                RichCanvasTextArea.this.invalidate();
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean obtainText() {
        int i3;
        int i16;
        String str;
        Integer generateCacheKey = generateCacheKey();
        FeedTextAreaEx feedTextAreaEx = (FeedTextAreaEx) getAreaCache(generateCacheKey, FeedTextAreaEx.class);
        this.mTextArea = feedTextAreaEx;
        if (feedTextAreaEx == null) {
            String id5 = getId();
            FeedTextAreaEx feedTextAreaEx2 = new FeedTextAreaEx(!TextUtils.isEmpty(id5) ? id5.hashCode() : Integer.MAX_VALUE);
            this.mTextArea = feedTextAreaEx2;
            feedTextAreaEx2.setViewHost(this);
            this.mTextArea.getTextLayout().setMaxCommentLine(this.maxCommentLine);
            addAreaCache(generateCacheKey, this.mTextArea);
            int i17 = this.mColorBackground;
            if (i17 != 0) {
                this.mTextArea.setColorBackground(i17);
            }
            int i18 = this.mLinkColorBackground;
            if (i18 != 0) {
                this.mTextArea.setLinkColorBackground(i18);
            }
            this.mTextArea.setTextColor(this.mTextColor);
            int i19 = this.mLinkColor;
            if (i19 != -1) {
                this.mTextArea.setLinkColor(i19);
            }
            int i26 = this.mMaxLines;
            if (i26 != -1) {
                this.mTextArea.setMaxLine(i26);
            }
            this.mTextArea.setTextSize(this.mTextSize);
            this.mTextArea.setFont(this.mFontId, this.mFontUrl, this.mNativeFontType, this.mFontBGUrl);
            this.mTextArea.setTextBold(this.mTextBold);
            this.mTextArea.setTextGravity(this.mGravity);
            this.mTextArea.setLetterSpacing(this.letterSpace);
            if (!Float.valueOf(this.ellipsisSize).isNaN() && (str = this.ellipsisStr) != null) {
                this.mTextArea.setEllipsisStr(str, this.ellipsisColor, this.ellipsisSize);
            } else {
                String str2 = this.ellipsisStr;
                if (str2 != null) {
                    this.mTextArea.setEllipsisStr(str2);
                }
            }
            setTextEffectInner(this.superFontInfo);
            int i27 = this.mLineSpace;
            if (i27 != 0) {
                this.mTextArea.setLineSpace(i27 * DittoUIEngine.g().getDensity());
            }
            this.mTextArea.setIsNeedLineSpace(Boolean.valueOf(this.isNeedLineSpace));
            this.mTextArea.setShowMore(this.isShowMore);
            this.mTextArea.setHasMore(this.hasMore);
            ArrayList<Integer> arrayList = this.mColors;
            if (arrayList != null && (i16 = this.mAnimationPeriod) != 0) {
                this.mTextArea.setTextColorAnimation(arrayList, i16);
            }
            int i28 = this.mTextInType;
            if (i28 != 0) {
                this.mTextArea.setTextInType(i28);
            }
            setTextEffect(this.mFontInfo, this.mTextArea);
            if (this.mBarrageInfo != null) {
                this.mTextArea.getTextLayout().setBarrageEffect(true, this.mBarrageInfo);
            }
            this.mTextArea.setMinLine(this.mMinlines);
            this.mTextArea.setSummaryPackOrUnpackDirect(this.mPackOrUnpackDirect);
            this.mTextArea.setShowPackOrUnpack(this.isShowPackOrUnpack);
            this.mTextArea.setIsSpan(this.mIsSpan);
            this.mTextArea.setHasPressState(this.showShadowOnPress);
            float f16 = this.shadowDx;
            if (f16 != Float.MIN_VALUE) {
                float f17 = this.shadowDy;
                if (f17 != Float.MIN_VALUE) {
                    float f18 = this.shadowRadius;
                    if (f18 != Float.MIN_VALUE && (i3 = this.shadowBgColor) != 0) {
                        this.mTextArea.setShadowLayer((int) f18, (int) f16, (int) f17, i3);
                    }
                }
            }
            Drawable drawable = this.mLeftDrawable;
            if (drawable != null) {
                if (this.mMaxLines == 1) {
                    this.mTextArea.setLeftDrawable(drawable);
                    this.mTextArea.setLeftDrawableGravity(this.mLeftDrawableGravity);
                    this.mTextArea.setImageSpace(this.mDrawableSpace);
                    this.mTextArea.setData(this.mText, 0);
                } else {
                    this.mTextArea.setDataExtra(this.mText, "none", drawable, drawable.getIntrinsicWidth());
                    this.mTextArea.setImageSpace(this.mDrawableSpace);
                }
            } else {
                this.mTextArea.setData(this.mText, 0);
            }
            if (this.longClickListener != null) {
                this.mTextArea.longClickedListener = this;
            }
            int i29 = this.mAdditionEllipsizeWidth;
            if (i29 > 0) {
                this.mTextArea.setAdditionEllipsizeWidth(i29);
            }
            return false;
        }
        feedTextAreaEx.setTextColor(this.mTextColor);
        int i36 = this.mMaxLines;
        if (i36 != -1) {
            this.mTextArea.setMaxLine(i36);
        }
        int i37 = this.mColorBackground;
        if (i37 != 0) {
            this.mTextArea.setColorBackground(i37);
        }
        int i38 = this.mLinkColorBackground;
        if (i38 != 0) {
            this.mTextArea.setLinkColorBackground(i38);
        }
        this.mTextArea.setAdditionEllipsizeWidth(this.mAdditionEllipsizeWidth);
        int i39 = this.mLinkColor;
        if (i39 != -1) {
            this.mTextArea.setLinkColor(i39);
        }
        if (this.longClickListener != null) {
            this.mTextArea.longClickedListener = this;
        } else {
            this.mTextArea.longClickedListener = null;
        }
        this.mTextArea.setViewHost(this);
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaClickedListener
    public void onAreaClicked(ViewArea viewArea, TextCell textCell) {
        DittoArea.ClickListener clickListener = this.clickListener;
        if (clickListener != null) {
            clickListener.onClick(this, null, textCell);
        }
    }

    @Override // com.tencent.ditto.widget.DittoTextArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        try {
            if (this.mTextArea == null) {
                this.mTextArea = getTextFromCache();
            }
            FeedTextAreaEx feedTextAreaEx = this.mTextArea;
            if (feedTextAreaEx != null) {
                feedTextAreaEx.setViewHost(this);
                this.mTextArea.draw(canvas, null);
                return;
            }
            DittoLog.i(DittoLog.defaultTag, "RichCanvasTextArea has no text cache when onDraw! id:" + getId());
            FeedTextAreaEx generateAndMeasureText = generateAndMeasureText(this.oldWidthMeasureSpec, this.oldHeightMeasureSpec);
            if (generateAndMeasureText != null) {
                generateAndMeasureText.draw(canvas, null);
            }
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "", e16);
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea.OnAreaLongClickedListener
    public void onLongClicked(ViewArea viewArea) {
        DittoArea.LongClickListener longClickListener = this.longClickListener;
        if (longClickListener != null) {
            longClickListener.onLongClick(this, null, viewArea);
        }
    }

    @Override // com.tencent.ditto.widget.DittoTextArea, com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        MeasureCacheable.TextMeasureCacheItem measureCache = getMeasureCache(generateCacheKey(), i3, i16);
        if (measureCache == null || measureCache.measuredWidth <= 0 || measureCache.measureHeight <= 0 || this.mMeasureDirty) {
            FeedTextAreaEx generateAndMeasureText = generateAndMeasureText(i3, i16);
            MeasureCacheable.TextMeasureCacheItem textMeasureCacheItem = new MeasureCacheable.TextMeasureCacheItem();
            textMeasureCacheItem.keyWidthMeasureSpec = i3;
            textMeasureCacheItem.keyHeightMeasureSpec = i16;
            textMeasureCacheItem.measuredWidth = generateAndMeasureText.getMeasuredWidth();
            textMeasureCacheItem.measureHeight = generateAndMeasureText.getMeasuredHeight();
            addMeasureCache(generateCacheKey(), i3, i16, textMeasureCacheItem);
        }
        FeedTextAreaEx generateAndMeasureText2 = generateAndMeasureText(i3, i16);
        setMeasuredDimension(generateAndMeasureText2.getMeasuredWidth(), generateAndMeasureText2.getMeasuredHeight());
        this.oldWidthMeasureSpec = i3;
        this.oldHeightMeasureSpec = i16;
        OnTextMeasuredListener onTextMeasuredListener = this.mOnTextMeasuredListener;
        if (onTextMeasuredListener != null) {
            onTextMeasuredListener.onMeasured();
        }
    }

    public void onStateIdle() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.onStateIdle();
        }
    }

    public void onStateScrolling() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.onStateScrolling();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        DittoArea.LongClickListener longClickListener = this.longClickListener;
        if (longClickListener == null && this.clickListener == null) {
            return false;
        }
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            return feedTextAreaEx.onTouchEvent(motionEvent, this, longClickListener != null);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reset() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.reset();
        }
    }

    public void resetTextAnimation() {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.resetTextAnimation();
        }
    }

    public void setAdditionEllipsizeWidth(int i3) {
        this.mAdditionEllipsizeWidth = i3;
    }

    public void setBarrageInfo(QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo) {
        this.mBarrageInfo = barrageEffectInfo;
    }

    public void setColorBackground(int i3) {
        this.mColorBackground = i3;
    }

    public void setEllipsisStr(String str, int i3, float f16) {
        this.ellipsisStr = str;
        this.ellipsisColor = i3;
        this.ellipsisSize = f16;
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.setEllipsisStr(str, i3, f16);
        }
    }

    public void setEllipsizeStr(String str) {
        this.ellipsisStr = str;
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.setEllipsisStr(str);
        }
    }

    public void setFont(int i3, String str, int i16) {
        setFont(i3, str, i16, null);
    }

    public void setFontInfo(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        this.mFontInfo = superFontInfo;
    }

    public void setHasMore(boolean z16) {
        this.hasMore = this.hasMore;
    }

    public void setIsNeedLineSpace(boolean z16) {
        this.isNeedLineSpace = z16;
    }

    public void setIsShowMore(boolean z16) {
        this.isShowMore = z16;
    }

    public void setIsSpan(boolean z16) {
        this.mIsSpan = z16;
    }

    @Override // com.tencent.ditto.widget.DittoTextArea, com.tencent.ditto.area.DittoArea
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        super.setLayoutAttr(layoutAttrSet);
        if (layoutAttrSet != null) {
            if (layoutAttrSet.hasAttr(SHOW_SHADOW_ON_PRESS)) {
                this.showShadowOnPress = layoutAttrSet.getAttr(SHOW_SHADOW_ON_PRESS, 0) != 0;
            }
            if (layoutAttrSet.hasAttr("max_length")) {
                this.mMaxLength = layoutAttrSet.parseInteger(layoutAttrSet.getAttr("max_length", "-1"));
            }
        }
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setLeftDrawable(Drawable drawable, int i3) {
        if (this.mLeftDrawable != drawable || this.mDrawableSpace != i3) {
            setDirty(true);
        }
        this.mLeftDrawable = drawable;
        this.mDrawableSpace = i3;
    }

    public void setLeftDrawableGravity(int i3) {
        this.mLeftDrawableGravity = i3;
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setLetterSpace(float f16) {
        super.setLetterSpace(f16);
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.setLetterSpacing(f16);
            requestLayout();
        }
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setLineSpace(int i3) {
        this.mLineSpace = i3;
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setLinkColor(int i3) {
        this.mLinkColor = i3;
    }

    public void setLinkColorBackground(int i3) {
        this.mLinkColorBackground = i3;
    }

    public void setMaxCommentLine(int i3) {
        this.maxCommentLine = i3;
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.getTextLayout().setMaxCommentLine(this.maxCommentLine);
        }
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setMaxLines(int i3) {
        this.mMaxLines = i3;
    }

    public void setMaxPack(int i3) {
        this.mMaxPack = i3;
    }

    public void setMinLine(int i3) {
        this.mMinlines = i3;
    }

    public void setMinPack(int i3) {
        this.mMinPack = i3;
    }

    public void setOnTextMeasuredListener(OnTextMeasuredListener onTextMeasuredListener) {
        this.mOnTextMeasuredListener = onTextMeasuredListener;
    }

    public void setPackOrUnpackDirect(int i3) {
        this.mPackOrUnpackDirect = i3;
    }

    public void setParticleTextView(ParticleTextSurfaceView particleTextSurfaceView) {
        this.mParticleTextSurfaceView = particleTextSurfaceView;
    }

    public void setParticleTextVisibility(int i3) {
        this.mParticleTextVisibility = i3;
        setVisibility(i3);
    }

    public void setShowPackOrUnpack(boolean z16) {
        this.isShowPackOrUnpack = z16;
    }

    public void setSummaryPackShowLine(int i3) {
        this.mPackShowLine = i3;
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setText(String str) {
        this.mText = str;
        if (this.mMaxLength != -1) {
            DittoLog.i(DittoLog.defaultTag, str + " text is too long, need cut\uff01max length is " + this.mMaxLength);
            this.mText = DataPreCalculateTool.preCalcRichText(str, this.mMaxLength, this.mTextSize);
        }
        recycleText();
        requestLayout();
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setTextBold(boolean z16) {
        this.mTextBold = z16;
        FeedTextAreaEx textFromCache = getTextFromCache();
        if (textFromCache != null) {
            textFromCache.setTextBold(z16);
        }
        invalidate();
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setTextColor(int i3) {
        this.mTextColor = i3;
        FeedTextAreaEx textFromCache = getTextFromCache();
        if (textFromCache != null) {
            textFromCache.setTextColor(i3);
        }
        invalidate();
    }

    public void setTextColorAnimation(ArrayList<Integer> arrayList, int i3) {
        this.mColors = arrayList;
        this.mAnimationPeriod = i3;
    }

    public void setTextEffect(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        this.superFontInfo = superFontInfo;
    }

    public void setTextEffectInner(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx == null) {
            return;
        }
        if (superFontInfo == null) {
            feedTextAreaEx.setShadowLayer(0, 0, 0, 0);
            feedTextAreaEx.setGradientColor(null, null, null);
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            feedTextAreaEx.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            feedTextAreaEx.setShadowLayer(g.a(superFontInfo.iShadowBlurRadius), g.a(superFontInfo.iShadowOffsetX), g.a(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        } else {
            feedTextAreaEx.setShadowLayer(0, 0, 0, 0);
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            feedTextAreaEx.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        } else {
            feedTextAreaEx.setTextColorAnimation(null, 0);
        }
        if ((superFontInfo.lSparkleFlag & 4) != 0 && (arrayList = superFontInfo.vecGradientColor) != null && arrayList.size() >= 2 && (arrayList2 = superFontInfo.vecGradientPosition) != null && arrayList2.size() >= 2) {
            int size2 = superFontInfo.vecGradientColor.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
            }
            int size3 = superFontInfo.vecGradientPosition.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            int i18 = superFontInfo.iGradientDirection;
            if (i18 != 0) {
                if (i18 == 1) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i18 == 2) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                } else if (i18 == 3) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                }
            }
            feedTextAreaEx.setGradientColor(iArr, fArr, orientation);
            return;
        }
        feedTextAreaEx.setGradientColor(null, null, null);
    }

    public void setTextInType(int i3) {
        this.mTextInType = i3;
    }

    @Override // com.tencent.ditto.widget.DittoTextArea
    public void setTextSize(float f16) {
        this.mTextSize = f16;
    }

    public void updateIsSpan(boolean z16) {
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.setIsSpan(z16);
        }
        this.mMeasureDirty = true;
    }

    public void forceRequestLayout() {
        this.mMeasureDirty = true;
        FeedTextAreaEx feedTextAreaEx = this.mTextArea;
        if (feedTextAreaEx != null) {
            feedTextAreaEx.setContentChanged(true);
        }
        requestLayout();
    }

    public void setFont(int i3, String str, int i16, String str2) {
        this.mFontId = i3;
        this.mFontUrl = str;
        this.mNativeFontType = i16;
        this.mFontBGUrl = str2;
    }

    public void setTextEffect(QzoneSuperPersonalFontData.SuperFontInfo superFontInfo, FeedTextArea feedTextArea) {
        ArrayList<String> arrayList;
        ArrayList<Double> arrayList2;
        ArrayList<String> arrayList3;
        if (superFontInfo == null) {
            feedTextArea.setShadowLayer(0, 0, 0, 0);
            feedTextArea.setGradientColor(null, null, null);
            return;
        }
        if ((superFontInfo.lSparkleFlag & 1) != 0) {
            feedTextArea.setTextColor(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strTextColor));
        }
        if ((superFontInfo.lSparkleFlag & 2) != 0) {
            feedTextArea.setShadowLayer(g.a(superFontInfo.iShadowBlurRadius), g.a(superFontInfo.iShadowOffsetX), g.a(superFontInfo.iShadowOffsetY), QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.strShadowColor));
        } else {
            feedTextArea.setShadowLayer(0, 0, 0, 0);
        }
        if ((superFontInfo.lSparkleFlag & 8) != 0 && (arrayList3 = superFontInfo.vecTextColorAnimation) != null && arrayList3.size() >= 2) {
            ArrayList<Integer> arrayList4 = new ArrayList<>(superFontInfo.vecTextColorAnimation.size());
            int size = superFontInfo.vecTextColorAnimation.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList4.add(Integer.valueOf(QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecTextColorAnimation.get(i3))));
            }
            feedTextArea.setTextColorAnimation(arrayList4, superFontInfo.iTextColorSpanTime * (size - 1));
        } else {
            feedTextArea.setTextColorAnimation(null, 0);
        }
        if ((superFontInfo.lSparkleFlag & 4) != 0 && (arrayList = superFontInfo.vecGradientColor) != null && arrayList.size() >= 2 && (arrayList2 = superFontInfo.vecGradientPosition) != null && arrayList2.size() >= 2) {
            int size2 = superFontInfo.vecGradientColor.size();
            int[] iArr = new int[size2];
            for (int i16 = 0; i16 < size2; i16++) {
                iArr[i16] = QzoneSuperPersonalFontData.SuperFontInfo.parseColor(superFontInfo.vecGradientColor.get(i16));
            }
            int size3 = superFontInfo.vecGradientPosition.size();
            float[] fArr = new float[size3];
            for (int i17 = 0; i17 < size3; i17++) {
                fArr[i17] = superFontInfo.vecGradientPosition.get(i17).floatValue();
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            int i18 = superFontInfo.iGradientDirection;
            if (i18 != 0) {
                if (i18 == 1) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i18 == 2) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                } else if (i18 == 3) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                }
            }
            feedTextArea.setGradientColor(iArr, fArr, orientation);
            return;
        }
        feedTextArea.setGradientColor(null, null, null);
    }

    public void onRecycled() {
        setVisibility(8);
        recycleText();
        this.superFontInfo = null;
        this.isNeedLineSpace = true;
        this.hasMore = false;
        this.mMaxLines = -1;
        this.mMinlines = -1;
        this.isShowMore = false;
        this.mColors = null;
        this.mAnimationPeriod = 0;
        this.mPackOrUnpackDirect = 0;
        this.mMaxPack = 0;
        this.mMinPack = 0;
        this.mPackShowLine = 0;
        this.mIsSpan = false;
        this.mTextInType = 0;
        this.isShowPackOrUnpack = false;
        this.mParticleTextVisibility = 0;
        this.letterSpace = 0.0f;
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public void setVisibility(int i3) {
        if (i3 != 0 || this.mParticleTextVisibility == 0) {
            super.setVisibility(i3);
        }
    }
}
