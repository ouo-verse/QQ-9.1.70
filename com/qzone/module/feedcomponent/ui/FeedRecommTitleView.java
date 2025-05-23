package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedRecommTitleView extends View implements r, FeedChildView {
    private static final String AVATAR_BG_URL = "https://sola.gtimg.cn/aoi/sola/20200827195803_xup3LnlHp1.png";
    private static final int IMAGE_LOADING_TYPE_AVATAR_BG = 4;
    private static final int IMAGE_LOADING_TYPE_FEED_BG = 1;
    private static final int IMAGE_LOADING_TYPE_ICON = 3;
    private static final int IMAGE_LOADING_TYPE_TAG_BG = 2;
    private static final String QCIRCLE_ICON_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/circleTopicIcon.png";
    private static final String RECOMM_FEED_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/circleRecommendFeedsHeadBg.png";
    private static final String RECOMM_TAG_URL = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/circleRecommendContestHeadBg.png";
    private static final String TAG = "FeedRecommTitleView";
    private int SHOW_TYPE_NONE;
    private int SHOW_TYPE_RECOMM_FEED_HEAD;
    private int SHOW_TYPE_RECOMM_TOPIC;
    private boolean isShowRecomFeedHead;
    private Drawable mAvatar;
    private Drawable mAvatarBg;
    private int mAvatarBgSize;
    private Rect mAvatarRect;
    private int mAvatarSize;
    private String mBottomAfterSuffix;
    private String mBottomPreSuffix;
    private Rect mBottomTextBound;
    private String mContestTitle;
    private Drawable mDefAvatar;
    private String mFansCount;
    private BusinessFeedData mFeedData;
    private com.qzone.proxy.feedcomponent.ui.g mFeedElementClickListener;
    private int mFeedPosition;
    private String mFeedsCount;
    private int mIconSize;
    private Paint mPaint;
    private Path mPath;
    private float[] mRadii;
    private Drawable mRecomFeedsBg;
    private Drawable mRecomTagBg;
    private Rect mRect;
    private RectF mRectF;
    private Drawable mShadowDrawable;
    private int mShowType;
    private TextPaint mTextPaint;
    private Rect mTitleBound;
    private Drawable mTopicIcon;
    private String mUserName;
    private String mVisitorCount;
    private static int VIEW_WIDTH = (FeedGlobalEnv.g().getScreenWidth() - AreaConst.MARGIN_LEFT) - AreaConst.MARGIN_RIGHT;
    private static int VIEW_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(71.0f);
    public static FeedViewSection.SectionController controller = new FeedViewSection.SectionController() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommTitleView.1
        @Override // com.qzone.module.feedcomponent.ui.FeedViewSection.SectionController
        public boolean isSectionEmpty(BusinessFeedData businessFeedData, FeedViewSection.FeedViewOptions feedViewOptions) {
            return businessFeedData.isSubFeed || businessFeedData.getRecommHeader() == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().feedsAttr3 == 0;
        }
    };

    public FeedRecommTitleView(Context context) {
        this(context, null);
    }

    private void drawBottomText(Canvas canvas, float f16, float f17, String str) {
        Paint paint = this.mPaint;
        int i3 = AreaConst.dp14;
        paint.setTextSize(i3);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setColor(-16777216);
        this.mPaint.setTextSize(i3);
        this.mPaint.getTextBounds(str, 0, str.length(), this.mBottomTextBound);
        RectF rectF = this.mRectF;
        rectF.left = f16;
        rectF.top = f17;
        rectF.right = f16 + this.mBottomTextBound.width();
        RectF rectF2 = this.mRectF;
        rectF2.bottom = rectF2.top + this.mBottomTextBound.height();
        RectF rectF3 = this.mRectF;
        canvas.drawText(str, rectF3.left, getBaseLine(rectF3, this.mPaint), this.mPaint);
        Paint paint2 = this.mPaint;
        int i16 = AreaConst.dp12;
        paint2.setTextSize(i16);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-8750451);
        Paint paint3 = this.mPaint;
        String str2 = this.mBottomPreSuffix;
        paint3.getTextBounds(str2, 0, str2.length(), this.mBottomTextBound);
        RectF rectF4 = this.mRectF;
        float f18 = rectF4.right;
        int i17 = AreaConst.f48749dp4;
        float f19 = f18 + i17;
        rectF4.left = f19;
        rectF4.right = f19 + this.mBottomTextBound.width();
        String str3 = this.mBottomPreSuffix;
        RectF rectF5 = this.mRectF;
        canvas.drawText(str3, rectF5.left, getBaseLine(rectF5, this.mPaint), this.mPaint);
        this.mPaint.setTextSize(i3);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setColor(-16777216);
        Paint paint4 = this.mPaint;
        String str4 = this.mFeedsCount;
        paint4.getTextBounds(str4, 0, str4.length(), this.mBottomTextBound);
        RectF rectF6 = this.mRectF;
        float f26 = rectF6.right + i16;
        rectF6.left = f26;
        rectF6.right = f26 + this.mBottomTextBound.width();
        String str5 = this.mFeedsCount;
        RectF rectF7 = this.mRectF;
        canvas.drawText(str5, rectF7.left, getBaseLine(rectF7, this.mPaint), this.mPaint);
        this.mPaint.setTextSize(i16);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-8750451);
        Paint paint5 = this.mPaint;
        String str6 = this.mBottomAfterSuffix;
        paint5.getTextBounds(str6, 0, str6.length(), this.mBottomTextBound);
        RectF rectF8 = this.mRectF;
        float f27 = rectF8.right + i17;
        rectF8.left = f27;
        rectF8.right = f27 + this.mBottomTextBound.width();
        String str7 = this.mBottomAfterSuffix;
        RectF rectF9 = this.mRectF;
        canvas.drawText(str7, rectF9.left, getBaseLine(rectF9, this.mPaint), this.mPaint);
    }

    private void drawRecomContestHead(Canvas canvas) {
        int i3 = AreaConst.dp1_5;
        drawShadow(canvas, i3, AreaConst.f48747dp2, i3, 0);
        if (this.mRecomTagBg != null) {
            this.mRectF.set(0.0f, 0.0f, VIEW_WIDTH, VIEW_HEIGHT);
            this.mPath.addRoundRect(this.mRectF, this.mRadii, Path.Direction.CW);
            canvas.clipPath(this.mPath);
            this.mRecomTagBg.setBounds(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
            this.mRecomTagBg.draw(canvas);
        }
        Rect rect = this.mRect;
        int i16 = AreaConst.dp10;
        rect.left = i16;
        int i17 = AreaConst.dp16;
        rect.top = i17;
        int i18 = this.mIconSize;
        rect.right = i16 + i18;
        rect.bottom = i18 + i17;
        if (this.mTopicIcon == null) {
            this.mTopicIcon = com.qzone.adapter.feedcomponent.j.g(977);
        }
        this.mTopicIcon.setBounds(this.mRect);
        this.mTopicIcon.draw(canvas);
        this.mPaint.setTextSize(AreaConst.dp17);
        this.mPaint.setColor(-16777216);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        Paint paint = this.mPaint;
        String str = this.mContestTitle;
        paint.getTextBounds(str, 0, str.length(), this.mTitleBound);
        int i19 = (VIEW_WIDTH - this.mRect.right) - i16;
        if (this.mTitleBound.width() > i19) {
            this.mTextPaint.set(this.mPaint);
            String charSequence = TextUtils.ellipsize(this.mContestTitle, this.mTextPaint, i19, TextUtils.TruncateAt.END).toString();
            this.mContestTitle = charSequence;
            this.mPaint.getTextBounds(charSequence, 0, charSequence.length(), this.mTitleBound);
        }
        RectF rectF = this.mRectF;
        rectF.left = this.mRect.right + AreaConst.f48749dp4;
        rectF.top = (i17 + (this.mIconSize / 2.0f)) - (this.mTitleBound.height() / 2.0f);
        RectF rectF2 = this.mRectF;
        rectF2.right = rectF2.left + this.mTitleBound.width();
        this.mRectF.bottom = i17 + (this.mIconSize / 2.0f) + (this.mTitleBound.height() / 2.0f);
        String str2 = this.mContestTitle;
        RectF rectF3 = this.mRectF;
        canvas.drawText(str2, rectF3.left, getBaseLine(rectF3, this.mPaint), this.mPaint);
        drawRecommTagBottomText(canvas, i16, i17 + this.mIconSize + AreaConst.dp5);
        reportExposure();
    }

    private void drawRecommFeedHeadBottomText(Canvas canvas, float f16, float f17) {
        drawBottomText(canvas, f16, f17, this.mFansCount);
    }

    private void drawRecommFeedsHead(Canvas canvas) {
        String str;
        int i3 = AreaConst.f48746dp1;
        drawShadow(canvas, i3, AreaConst.f48747dp2, i3, 0);
        if (this.mRecomFeedsBg != null) {
            this.mRectF.set(0.0f, 0.0f, VIEW_WIDTH, VIEW_HEIGHT);
            this.mPath.addRoundRect(this.mRectF, this.mRadii, Path.Direction.CW);
            canvas.clipPath(this.mPath);
            this.mRecomFeedsBg.setBounds(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
            this.mRecomFeedsBg.draw(canvas);
        }
        Rect rect = this.mRect;
        int i16 = AreaConst.dp11;
        rect.left = i16;
        rect.top = i16;
        int i17 = this.mAvatarBgSize;
        rect.right = i16 + i17;
        rect.bottom = i17 + i16;
        Drawable drawable = this.mAvatarBg;
        if (drawable != null) {
            drawable.setBounds(rect);
            this.mAvatarBg.draw(canvas);
        }
        Rect rect2 = this.mAvatarRect;
        int i18 = this.mAvatarBgSize;
        int i19 = this.mAvatarSize;
        rect2.left = ((i18 / 2) + i16) - (i19 / 2);
        rect2.top = ((i18 / 2) + i16) - (i19 / 2);
        rect2.right = (i18 / 2) + i16 + (i19 / 2);
        rect2.bottom = i16 + (i18 / 2) + (i19 / 2);
        Drawable drawable2 = this.mAvatar;
        if (drawable2 != null) {
            drawable2.setBounds(rect2);
            this.mAvatar.draw(canvas);
        } else {
            Drawable g16 = com.qzone.adapter.feedcomponent.j.g(PlayerResources.ViewId.CURRUNT_TIME);
            this.mDefAvatar = g16;
            g16.setBounds(this.mAvatarRect);
            this.mDefAvatar.draw(canvas);
        }
        this.mPaint.setTextSize(AreaConst.dp17);
        this.mPaint.setColor(-16777216);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        Paint paint = this.mPaint;
        String str2 = this.mUserName;
        paint.getTextBounds(str2, 0, str2.length(), this.mTitleBound);
        int i26 = (VIEW_WIDTH - this.mRect.right) - AreaConst.dp5;
        if (this.mTitleBound.width() > i26) {
            String charSequence = TextUtils.ellipsize(this.mUserName, new TextPaint(this.mPaint), i26, TextUtils.TruncateAt.END).toString();
            this.mUserName = charSequence;
            this.mPaint.getTextBounds(charSequence, 0, charSequence.length(), this.mTitleBound);
        }
        RectF rectF = this.mRectF;
        rectF.left = AreaConst.dp10 + this.mAvatarBgSize + AreaConst.dp12;
        rectF.top = (VIEW_HEIGHT / 2.0f) - (this.mTitleBound.height() / 2.0f);
        RectF rectF2 = this.mRectF;
        rectF2.right = rectF2.left + this.mTitleBound.width();
        this.mRectF.bottom = (VIEW_HEIGHT / 2.0f) + (this.mTitleBound.height() / 2.0f);
        String str3 = this.mUserName;
        RectF rectF3 = this.mRectF;
        canvas.drawText(str3, rectF3.left, getBaseLine(rectF3, this.mPaint), this.mPaint);
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData != null) {
            if (businessFeedData.getOperationInfoV2() != null && this.mFeedData.getOperationInfoV2().feedReportCookie != null) {
                str = this.mFeedData.getOperationInfoV2().feedReportCookie.get(50);
            } else {
                str = "";
            }
            com.qzone.adapter.feedcomponent.i.H().g(801, 0, 0, "", "", str);
        }
    }

    private void drawRecommTagBottomText(Canvas canvas, float f16, float f17) {
        drawBottomText(canvas, f16, f17, this.mVisitorCount);
    }

    private void forward() {
        BusinessFeedData businessFeedData;
        com.qzone.proxy.feedcomponent.ui.g gVar = this.mFeedElementClickListener;
        if (gVar == null || (businessFeedData = this.mFeedData) == null) {
            return;
        }
        gVar.onClick(this, FeedElement.FEED_QCIRCLE_RECOMMEND_TITLE, this.mFeedPosition, businessFeedData);
        reportClick();
    }

    private void forwardProfile() {
        this.mFeedElementClickListener.onClick(this, FeedElement.FEED_QCIRCLE_RECOMMEND_AVATAR, this.mFeedPosition, this.mFeedData);
    }

    private float getBaseLine(RectF rectF, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return ((((rectF.bottom + rectF.top) - fontMetricsInt.bottom) - fontMetricsInt.top) - 2.0f) / 2.0f;
    }

    private boolean isInRect(float f16, float f17, int i3, int i16, int i17, int i18) {
        return ((float) i3) <= f16 && f16 <= ((float) i17) && ((float) i16) <= f17 && f17 <= ((float) i18);
    }

    private Drawable loadAvatar(long j3) {
        String P = com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(j3));
        return loadAvatar(PictureUrl.calculateAvaterImageUrl(P), P, j3);
    }

    private Drawable loadImage(String str, final int i3) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(null, str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommTitleView.2
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
                com.qzone.proxy.feedcomponent.b.c(FeedRecommTitleView.TAG, "loadImage onImageFailed s:" + str2);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                if (com.qzone.proxy.feedcomponent.b.g()) {
                    com.qzone.proxy.feedcomponent.b.a(FeedRecommTitleView.TAG, "loadImage onImageLoaded s:" + str2);
                }
                int i16 = i3;
                if (i16 == 1) {
                    FeedRecommTitleView.this.mRecomFeedsBg = drawable;
                } else if (i16 == 2) {
                    FeedRecommTitleView.this.mRecomTagBg = drawable;
                } else if (i16 == 3) {
                    FeedRecommTitleView.this.mTopicIcon = drawable;
                } else if (i16 == 4) {
                    FeedRecommTitleView.this.mAvatarBg = drawable;
                }
                FeedRecommTitleView.this.postInvalidate();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        }, obtain);
        if (loadImage != null) {
            if (i3 == 1) {
                this.mRecomFeedsBg = loadImage;
            } else if (i3 == 2) {
                this.mRecomTagBg = loadImage;
            } else if (i3 == 3) {
                this.mTopicIcon = loadImage;
            }
        }
        return ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(null, str, null, obtain);
    }

    private void reportClick() {
        BusinessFeedData businessFeedData;
        String str;
        com.qzone.proxy.feedcomponent.ui.g gVar = this.mFeedElementClickListener;
        if (gVar == null || (businessFeedData = this.mFeedData) == null) {
            return;
        }
        gVar.onClick(this, FeedElement.FEED_QCIRCLE_RECOMMEND_TITLE, this.mFeedPosition, businessFeedData);
        if (this.mFeedData.getOperationInfoV2() != null) {
            Map<Integer, String> map = this.mFeedData.getOperationInfoV2().feedReportCookie;
            if (map != null) {
                str = map.get(50);
            } else {
                str = "";
            }
            com.qzone.adapter.feedcomponent.i.H().g(this.mShowType == this.SHOW_TYPE_RECOMM_FEED_HEAD ? 801 : 804, 1, 1, "", "", str);
        }
    }

    private void reportExposure() {
        String str;
        BusinessFeedData businessFeedData = this.mFeedData;
        if (businessFeedData == null || businessFeedData.getOperationInfoV2() == null) {
            return;
        }
        Map<Integer, String> map = this.mFeedData.getOperationInfoV2().feedReportCookie;
        if (map != null) {
            str = map.get(50);
        } else {
            str = "";
        }
        com.qzone.adapter.feedcomponent.i.H().g(804, 0, 0, "", "", str);
    }

    public void drawShadow(Canvas canvas, int i3, int i16, int i17, int i18) {
        int i19 = VIEW_WIDTH + i3 + i17;
        int i26 = VIEW_HEIGHT + i16 + i18;
        if (this.mShadowDrawable != null) {
            int i27 = AreaConst.f48747dp2;
            this.mShadowDrawable.setBounds(new Rect(-i27, -i27, i19, i26));
            this.mShadowDrawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.mShowType;
        if (i3 == this.SHOW_TYPE_RECOMM_FEED_HEAD) {
            drawRecommFeedsHead(canvas);
        } else if (i3 == this.SHOW_TYPE_RECOMM_TOPIC) {
            drawRecomContestHead(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(VIEW_WIDTH, VIEW_HEIGHT);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (isInRect(x16, y16, this.mAvatarRect)) {
                forwardProfile();
            } else if (isInRect(x16, y16, 0, 0, VIEW_WIDTH, VIEW_HEIGHT)) {
                forward();
            }
        }
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData.getFeedCommInfo() != null) {
            this.mFeedData = businessFeedData;
            this.mShowType = this.SHOW_TYPE_NONE;
            String str = businessFeedData.getRecommHeader().rightBgPic.url;
            if (businessFeedData.getFeedCommInfo().feedsAttr3 == 1) {
                this.mShowType = this.SHOW_TYPE_RECOMM_FEED_HEAD;
                this.mAvatar = loadAvatar(businessFeedData.getUser().uin);
                this.mUserName = businessFeedData.getUser().nickName;
                this.mFansCount = bigNumberFormatTransfer(businessFeedData.getUser().fansCount);
                this.mRecomFeedsBg = loadImage(str, 1);
                this.mAvatarBg = loadImage(AVATAR_BG_URL, 4);
                this.mFeedsCount = bigNumberFormatTransfer(businessFeedData.getUser().uFeedsCount);
            } else if (businessFeedData.getFeedCommInfo().feedsAttr3 == 2) {
                this.mShowType = this.SHOW_TYPE_RECOMM_TOPIC;
                this.mVisitorCount = bigNumberFormatTransfer(businessFeedData.getUser().visitorCount);
                this.mFeedsCount = bigNumberFormatTransfer(businessFeedData.getUser().uFeedsCount);
                this.mContestTitle = businessFeedData.getUser().nickName;
                this.mRecomTagBg = loadImage(str, 2);
                this.mTopicIcon = loadImage(businessFeedData.getUser().logo, 3);
            }
            postInvalidate();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setFeedPosition(int i3) {
        this.mFeedPosition = i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedChildView
    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.mFeedElementClickListener = gVar;
    }

    public FeedRecommTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUserName = "";
        this.mContestTitle = "";
        this.mFansCount = "0";
        this.mVisitorCount = "0";
        this.mFeedsCount = "0";
        this.mBottomPreSuffix = "\u7c89\u4e1d    /";
        this.mBottomAfterSuffix = "\u4f5c\u54c1";
        this.isShowRecomFeedHead = true;
        this.mRadii = new float[]{10.0f, 10.0f, 10.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.SHOW_TYPE_NONE = 0;
        this.SHOW_TYPE_RECOMM_FEED_HEAD = 1;
        this.SHOW_TYPE_RECOMM_TOPIC = 2;
        this.mShowType = 0;
        this.mShadowDrawable = com.qzone.adapter.feedcomponent.j.g(TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
        this.mIconSize = AreaConst.dp20;
        this.mAvatarSize = AreaConst.dp43;
        this.mAvatarBgSize = AreaConst.dp48;
        this.mPaint = new Paint();
        this.mRect = new Rect();
        this.mAvatarRect = new Rect();
        this.mRectF = new RectF();
        this.mTitleBound = new Rect();
        this.mBottomTextBound = new Rect();
        this.mPaint.setTextSize(AreaConst.dp17);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-16777216);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        Paint paint = this.mPaint;
        String str = this.mUserName;
        paint.getTextBounds(str, 0, str.length(), this.mTitleBound);
        this.mTextPaint = new TextPaint(this.mPaint);
        this.mPath = new Path();
    }

    private boolean isInRect(float f16, float f17, Rect rect) {
        return ((float) rect.left) <= f16 && f16 <= ((float) rect.right) && ((float) rect.top) <= f17 && f17 <= ((float) rect.bottom);
    }

    private Drawable loadAvatar(ImageUrl imageUrl, String str, long j3) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = Long.valueOf(j3);
        obtain.extraProcessor = new OvalProcessor();
        int i3 = this.mAvatarSize;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        return ImageLoader.getInstance(FeedGlobalEnv.getApplication()).loadImage(imageUrl, str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.ui.FeedRecommTitleView.3
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
                com.qzone.proxy.feedcomponent.b.c(FeedRecommTitleView.TAG, "loadAvatar onImageFailed s:" + str2);
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                if (com.qzone.proxy.feedcomponent.b.g()) {
                    com.qzone.proxy.feedcomponent.b.a(FeedRecommTitleView.TAG, "loadAvatar onImageLoaded s:" + str2);
                }
                FeedRecommTitleView.this.mAvatar = drawable;
                FeedRecommTitleView.this.postInvalidate();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        }, obtain);
    }

    public static String bigNumberFormatTransfer(long j3) {
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < 1000000) {
            DecimalFormat decimalFormat = new DecimalFormat();
            decimalFormat.setMaximumFractionDigits(1);
            decimalFormat.setGroupingSize(0);
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat.format(j3 / 10000.0d) + "W";
        }
        if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            return (j3 / 10000) + "W";
        }
        return "9999W";
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
