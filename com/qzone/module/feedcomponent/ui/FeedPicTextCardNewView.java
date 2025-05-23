package com.qzone.module.feedcomponent.ui;

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
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes39.dex */
public class FeedPicTextCardNewView extends View implements r, FeedChildView {
    private static final float STROKE_WUDTH = 0.0f;
    public static final String TAG = "FeedPicTextCardNewView";
    private static final String TITLE_COLOR = "#989EB4";
    private LinearGradient mBgGradient;
    private com.qzone.proxy.feedcomponent.ui.g mFeedElementClickListener;
    private int mFeedPosition;
    private Rect mGrayBgRect;
    private boolean mIsExposure;
    private boolean mIsForward;
    private boolean mIsForwardFeedExposure;
    private boolean mIsQCircleRecommFeed;
    private boolean mIsQcircleShareFeed;
    private Drawable mLeftIconDrawable;
    private Rect mLeftIconRect;
    private int mLeftIconSize;
    private boolean mNeedRoundCorner;
    private Paint mPaint;
    private Path mPath;
    private float[] mRadii;
    private RectF mRectF;
    private float mRestWidth;
    private Drawable mRightIconDrawable;
    private Rect mRightIconRect;
    private int mRightIconSize;
    private String mRightText;
    private Rect mRightTextRect;
    private Rect mRightTextRound;
    private Drawable mShadowDrawable;
    private int mTextColor;
    private TextPaint mTextPaint;
    private int mTextSize;
    private String mTitleText;
    private Rect mTitleTextBound;
    private Rect mTitleTextRect;
    private int mViewHeight;
    private int mViewWidth;
    private static final int TAIL_WIDTH = (FeedGlobalEnv.g().getScreenWidth() - AreaConst.MARGIN_LEFT) - AreaConst.MARGIN_RIGHT;
    private static final int TAIL_HEIGHT = AreaConst.dp32;
    private static final int TAIL_BOTTOM_GAP = AreaConst.dp7;
    public static FeedViewSection.SectionController PicTextCardController = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardNewView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData.getCellBottomRecomm() == null || !businessFeedData.isNewTailStyle();
        }
    };

    public FeedPicTextCardNewView(Context context) {
        this(context, null);
    }

    private void drawBackGround(Canvas canvas) {
        if (this.mIsQcircleShareFeed || this.mBgGradient == null) {
            return;
        }
        if (this.mIsQCircleRecommFeed) {
            int i3 = AreaConst.dp5;
            drawShadow(canvas, i3, 0, i3, AreaConst.f48748dp3);
        }
        this.mPaint.setShader(this.mBgGradient);
        if (this.mNeedRoundCorner) {
            this.mRectF.set(AreaConst.MARGIN_LEFT, 0.0f, TAIL_WIDTH + r1, TAIL_HEIGHT);
            this.mPath.addRoundRect(this.mRectF, this.mRadii, Path.Direction.CW);
            canvas.clipPath(this.mPath);
        }
        canvas.drawRect(AreaConst.MARGIN_LEFT, 0.0f, TAIL_WIDTH + r0, TAIL_HEIGHT, this.mPaint);
        this.mPaint.setShader(null);
    }

    private void drawGrayBackGround(Canvas canvas) {
        this.mGrayBgRect.set(0, 0, this.mViewWidth, this.mViewHeight);
        this.mPaint.setColor(-657670);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.mGrayBgRect, this.mPaint);
    }

    private void drawLeftIcon(Canvas canvas) {
        if (this.mLeftIconDrawable == null) {
            return;
        }
        int i3 = this.mLeftIconSize;
        int i16 = TAIL_HEIGHT;
        if (i3 > i16) {
            this.mLeftIconRect.left = getPaddingLeft() + AreaConst.MARGIN_LEFT;
            this.mLeftIconRect.top = getPaddingTop();
            this.mLeftIconRect.right = getPaddingLeft() + i16;
            this.mLeftIconRect.bottom = i16 - getPaddingBottom();
        } else {
            this.mLeftIconRect.left = getPaddingLeft() + AreaConst.dp7 + AreaConst.MARGIN_LEFT;
            Rect rect = this.mLeftIconRect;
            int i17 = this.mLeftIconSize;
            rect.top = (i16 / 2) - (i17 / 2);
            rect.right = rect.left + i17;
            rect.bottom = (i16 / 2) + (i17 / 2);
        }
        setLeftIconForQcircleShareFeed();
        this.mLeftIconDrawable.setBounds(this.mLeftIconRect);
        this.mLeftIconDrawable.draw(canvas);
    }

    private void drawRightIcon(Canvas canvas) {
        if (this.mRightIconDrawable == null) {
            return;
        }
        int i3 = this.mRightIconSize;
        int i16 = TAIL_HEIGHT;
        if (i3 > i16) {
            Rect rect = this.mRightIconRect;
            int i17 = this.mViewWidth;
            int i18 = AreaConst.MARGIN_RIGHT;
            rect.left = ((i17 - i18) - getPaddingRight()) - i16;
            this.mRightIconRect.top = getPaddingTop();
            this.mRightIconRect.right = (this.mViewWidth - getPaddingRight()) - i18;
            this.mRightIconRect.bottom = i16 - getPaddingBottom();
        } else {
            Rect rect2 = this.mRightIconRect;
            int i19 = this.mViewWidth;
            int i26 = AreaConst.MARGIN_RIGHT;
            int i27 = (i19 - i26) - i3;
            int i28 = AreaConst.dp7;
            rect2.left = (i27 - i28) - getPaddingRight();
            Rect rect3 = this.mRightIconRect;
            rect3.top = (i16 / 2) - (this.mRightIconSize / 2);
            rect3.right = ((this.mViewWidth - i26) - i28) - getPaddingRight();
            this.mRightIconRect.bottom = (i16 / 2) + (this.mRightIconSize / 2);
        }
        this.mRightIconDrawable.setBounds(this.mRightIconRect);
        this.mRightIconDrawable.draw(canvas);
        if (this.mIsQcircleShareFeed) {
            this.mRightIconDrawable.setAlpha(0);
        }
    }

    private void drawRightText(Canvas canvas) {
        if (this.mRightText == null) {
            return;
        }
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setStrokeWidth(0.5f);
        TextPaint textPaint = this.mTextPaint;
        String str = this.mRightText;
        textPaint.getTextBounds(str, 0, str.length(), this.mRightTextRound);
        Rect rect = this.mRightTextRect;
        int width = this.mRightIconRect.left - this.mRightTextRound.width();
        int i3 = AreaConst.dp6;
        rect.left = width - i3;
        Rect rect2 = this.mRightTextRect;
        int i16 = TAIL_HEIGHT;
        rect2.top = (i16 / 2) - (this.mRightTextRound.height() / 2);
        Rect rect3 = this.mRightTextRect;
        rect3.right = this.mRightIconRect.left - i3;
        rect3.bottom = (i16 / 2) + (this.mRightTextRound.height() / 2);
        String str2 = this.mRightText;
        Rect rect4 = this.mRightTextRect;
        canvas.drawText(str2, rect4.left, getBaseLine(rect4, this.mTextPaint), this.mTextPaint);
    }

    private void drawTitleText(Canvas canvas) {
        TextPaint textPaint;
        if (TextUtils.isEmpty(this.mTitleText)) {
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            textPaint = new TextPaint();
            textPaint.setTextSize(this.mTextSize);
            textPaint.setColor(this.mTextColor);
            textPaint.setAntiAlias(true);
            textPaint.setDither(true);
        } else {
            textPaint = this.mTextPaint;
            textPaint.setTextSize(this.mTextSize);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            textPaint.setColor(this.mTextColor);
            textPaint.setAntiAlias(true);
            textPaint.setDither(true);
            textPaint.setStrokeWidth(0.5f);
        }
        if (this.mIsQcircleShareFeed) {
            textPaint.setColor(Color.parseColor(TITLE_COLOR));
        }
        String str = this.mTitleText;
        textPaint.getTextBounds(str, 0, str.length(), this.mTitleTextBound);
        Rect rect = this.mTitleTextRect;
        rect.left = this.mLeftIconRect.right + AreaConst.dp6;
        int i3 = TAIL_HEIGHT;
        rect.top = (i3 / 2) - (this.mTitleTextBound.height() / 2);
        Rect rect2 = this.mTitleTextRect;
        rect2.right = this.mRightTextRect.left;
        rect2.bottom = (i3 / 2) + (this.mTitleTextBound.height() / 2);
        this.mRestWidth = (this.mRightTextRect.left - this.mLeftIconRect.right) - r3;
        setTtileTextPisitionForQcircleShareFeed(textPaint);
        float width = this.mTitleTextBound.width();
        float f16 = this.mRestWidth;
        if (width > f16) {
            this.mTitleText = TextUtils.ellipsize(this.mTitleText, textPaint, f16, TextUtils.TruncateAt.END).toString();
        }
        String str2 = this.mTitleText;
        Rect rect3 = this.mTitleTextRect;
        canvas.drawText(str2, rect3.left, getBaseLine(rect3, textPaint), textPaint);
    }

    private int getBaseLine(Rect rect, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return ((((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) - 2) / 2;
    }

    private String getBottomIconUrl(CellBottomRecomm cellBottomRecomm) {
        PictureUrl pictureUrl;
        String str;
        PictureItem pictureItem = cellBottomRecomm.picinfo;
        if (pictureItem == null || (pictureUrl = pictureItem.currentUrl) == null || (str = pictureUrl.url) == null) {
            return null;
        }
        return str;
    }

    private void initPaint() {
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.mGrayBgRect = new Rect();
        this.mLeftIconRect = new Rect();
        this.mTitleTextRect = new Rect();
        this.mRightTextRect = new Rect();
        this.mRightIconRect = new Rect();
        this.mTitleTextBound = new Rect();
        this.mRightTextRound = new Rect();
        this.mTextPaint = new TextPaint(this.mPaint);
    }

    private void setLeftIconForQcircleShareFeed() {
        Rect rect;
        if (!this.mIsQcircleShareFeed || (rect = this.mLeftIconRect) == null) {
            return;
        }
        rect.left = getPaddingLeft() + AreaConst.MARGIN_LEFT + AreaConst.f48747dp2;
        Rect rect2 = this.mLeftIconRect;
        rect2.right = rect2.left + this.mLeftIconSize;
    }

    private void setTtileTextPisitionForQcircleShareFeed(TextPaint textPaint) {
        Rect rect;
        Rect rect2;
        if (!this.mIsQcircleShareFeed || (rect = this.mTitleTextRect) == null || (rect2 = this.mLeftIconRect) == null || textPaint == null) {
            return;
        }
        int i3 = rect2.right;
        rect.left = i3;
        rect.right = i3 + this.mTitleTextBound.width();
        this.mRestWidth = FeedGlobalEnv.g().getScreenWidth() - this.mLeftIconRect.right;
        textPaint.setStrokeWidth(0.0f);
    }

    public void drawShadow(Canvas canvas, int i3, int i16, int i17, int i18) {
        int i19 = TAIL_WIDTH + i3 + i17;
        int i26 = TAIL_HEIGHT + i16 + i18;
        Drawable drawable = this.mShadowDrawable;
        if (drawable != null) {
            drawable.setBounds(AreaConst.dp6, 0, i19, i26);
            this.mShadowDrawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackGround(canvas);
        drawLeftIcon(canvas);
        drawRightIcon(canvas);
        drawRightText(canvas);
        drawTitleText(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        this.mViewWidth = FeedGlobalEnv.g().getScreenWidth();
        if (this.mIsForward) {
            this.mViewHeight = TAIL_HEIGHT + TAIL_BOTTOM_GAP;
        } else {
            this.mViewHeight = TAIL_HEIGHT;
        }
        if (this.mIsQcircleShareFeed) {
            this.mViewHeight = AreaConst.dp24;
            if (this.mTitleTextBound != null) {
                this.mViewWidth = getPaddingLeft() + AreaConst.MARGIN_LEFT + AreaConst.f48747dp2 + this.mLeftIconSize + this.mTitleTextBound.width();
            }
        }
        setMeasuredDimension(this.mViewWidth, this.mViewHeight);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        initData(businessFeedData);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    public void setIsForward(boolean z16) {
        this.mIsForward = z16;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mFeedElementClickListener = gVar;
    }

    public FeedPicTextCardNewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedPicTextCardNewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mBgGradient = null;
        int i16 = AreaConst.dp12;
        this.mTextSize = i16;
        this.mTextColor = -16578534;
        this.mLeftIconSize = AreaConst.dp18;
        this.mRightIconDrawable = com.qzone.adapter.feedcomponent.j.g(976);
        this.mRightIconSize = i16;
        this.mShadowDrawable = com.qzone.adapter.feedcomponent.j.g(729);
        this.mNeedRoundCorner = false;
        this.mIsForward = false;
        this.mIsQCircleRecommFeed = false;
        this.mIsQcircleShareFeed = false;
        this.mRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 10.0f, 10.0f, 10.0f, 10.0f};
        this.mIsForwardFeedExposure = false;
        this.mIsExposure = false;
        initPaint();
    }

    private void initData(final BusinessFeedData businessFeedData) {
        if (businessFeedData.getCellBottomRecomm() == null) {
            com.qzone.proxy.feedcomponent.b.c(TAG, "initContentPara error: feedData.getCellBottomRecomm() == null");
            return;
        }
        boolean isQCircleShareCardFeed = businessFeedData.isQCircleShareCardFeed();
        this.mIsQcircleShareFeed = isQCircleShareCardFeed;
        if (isQCircleShareCardFeed) {
            this.mLeftIconSize = AreaConst.dp14;
        }
        CellBottomRecomm cellBottomRecomm = businessFeedData.getCellBottomRecomm();
        if (!TextUtils.isEmpty(cellBottomRecomm.title)) {
            this.mTitleText = cellBottomRecomm.title;
        }
        String bottomIconUrl = getBottomIconUrl(cellBottomRecomm);
        if (!TextUtils.isEmpty(bottomIconUrl)) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            int i3 = this.mLeftIconSize;
            obtain.clipHeight = i3;
            obtain.clipWidth = i3;
            obtain.useMainThread = true;
            Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(null, bottomIconUrl, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardNewView.2
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                    FeedPicTextCardNewView.this.mLeftIconDrawable = drawable;
                    FeedPicTextCardNewView.this.postInvalidate();
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                }
            }, obtain);
            if (loadImage != null) {
                this.mLeftIconDrawable = loadImage;
            }
        }
        if (!TextUtils.isEmpty(cellBottomRecomm.buttontext)) {
            this.mRightText = cellBottomRecomm.buttontext;
        } else {
            this.mRightText = "";
        }
        if (com.qzone.adapter.feedcomponent.i.H().p1()) {
            this.mBgGradient = new LinearGradient(0.0f, 0.0f, TAIL_WIDTH, TAIL_HEIGHT, new int[]{-14737633, -14737633}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
            this.mTextColor = -1;
            this.mRightIconDrawable = com.qzone.adapter.feedcomponent.j.g(754);
        } else if (!businessFeedData.isQCircleShareCardFeed() && !businessFeedData.isQCircleRecommFeed()) {
            this.mBgGradient = new LinearGradient(0.0f, 0.0f, TAIL_WIDTH, TAIL_HEIGHT, new int[]{-657670, -657670}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            this.mBgGradient = new LinearGradient(0.0f, 0.0f, TAIL_WIDTH, TAIL_HEIGHT, new int[]{-1643777, -5907}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
        }
        this.mNeedRoundCorner = businessFeedData.isQCircleRecommFeed();
        this.mIsQCircleRecommFeed = businessFeedData.isQCircleRecommFeed();
        requestLayout();
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.module.feedcomponent.ui.FeedPicTextCardNewView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (FeedPicTextCardNewView.this.mFeedElementClickListener != null) {
                    com.qzone.proxy.feedcomponent.ui.g gVar = FeedPicTextCardNewView.this.mFeedElementClickListener;
                    FeedPicTextCardNewView feedPicTextCardNewView = FeedPicTextCardNewView.this;
                    gVar.onClick(feedPicTextCardNewView, FeedElement.FEED_PIC_TEXT_CARD_VIEW_CLICK_EVENT_TAG, feedPicTextCardNewView.mFeedPosition, businessFeedData);
                    com.qzone.adapter.feedcomponent.i.H().f(805, 4, 2);
                    com.qzone.adapter.feedcomponent.i.H().f(803, 1, 2);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        if (!this.mIsForwardFeedExposure) {
            com.qzone.adapter.feedcomponent.i.H().f(805, 1, 0);
        }
        if (this.mIsExposure) {
            return;
        }
        com.qzone.adapter.feedcomponent.i.H().f(803, 1, 1);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateIdle() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void onStateScrolling() {
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setAlpha(int i3) {
    }
}
