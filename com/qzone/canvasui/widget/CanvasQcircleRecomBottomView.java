package com.qzone.canvasui.widget;

import NS_MOBILE_FEEDS.multiple_count;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.image.SafeBitmapFactory;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasQcircleRecomBottomView extends View {
    public static final String FEED_QCIRCLE_DIVIDE_DOT_ICON_URL = "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/850/feed/feed_icon_dot.png";
    public static final String FEED_QCIRCLE_PUSHCOUNT_ICON_URL = "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/8417/general_image/image/feed_icon_pushamount.png";
    private int bottomDivideMargin;
    private int bottomImgMargin;
    private int bottomTextMargin;
    private int faceNum;
    private BusinessFeedData feedData;
    private boolean isOnVideoLayer;
    private String likeNum;
    private Drawable mDotDrawable;
    private Drawable mDrawable;
    private CopyOnWriteArrayList<Drawable> mFaceDrawable;
    private Drawable mMaskDrawable;
    private Paint mPaint;
    private RectF mRectF;
    private Rect mTextBottomBound;
    private String pushNum;

    public CanvasQcircleRecomBottomView(Context context, BusinessFeedData businessFeedData, boolean z16) {
        super(context);
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        this.mTextBottomBound = new Rect();
        this.mFaceDrawable = new CopyOnWriteArrayList<>(new Drawable[]{null, null, null});
        this.likeNum = "0";
        this.pushNum = "0";
        this.faceNum = 0;
        this.feedData = businessFeedData;
        this.isOnVideoLayer = z16;
        initBottomActionArea();
    }

    private float getBaseLine(RectF rectF, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return ((((rectF.bottom + rectF.top) - fontMetricsInt.bottom) - fontMetricsInt.top) - 2.0f) / 2.0f;
    }

    public void draw(Canvas canvas, int i3, int i16) {
        Drawable drawable;
        float f16;
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData == null || !businessFeedData.isQCircleRecommFeed() || this.mDrawable == null || this.mDotDrawable == null || (drawable = this.mMaskDrawable) == null) {
            return;
        }
        drawable.setBounds(0, i3 - AreaConst.dp44, i16, i3);
        this.mMaskDrawable.draw(canvas);
        if ("0".equals(this.pushNum)) {
            f16 = 0.0f;
        } else {
            Drawable drawable2 = this.mDrawable;
            int i17 = AreaConst.dp7;
            int i18 = this.bottomImgMargin;
            int i19 = AreaConst.dp20;
            drawable2.setBounds(i17, (i3 - i18) - i19, AreaConst.dp8 + i19, i3 - i18);
            this.mDrawable.draw(canvas);
            Paint paint = this.mPaint;
            String str = this.pushNum;
            paint.getTextBounds(str, 0, str.length(), this.mTextBottomBound);
            RectF rectF = this.mRectF;
            int i26 = this.mDrawable.getBounds().right;
            int i27 = AreaConst.f48748dp3;
            rectF.left = i26 + i27;
            RectF rectF2 = this.mRectF;
            rectF2.right = rectF2.left + this.mTextBottomBound.width();
            this.mRectF.top = (i3 - this.bottomTextMargin) - this.mTextBottomBound.height();
            RectF rectF3 = this.mRectF;
            rectF3.bottom = i3 - this.bottomTextMargin;
            canvas.drawText(this.pushNum, rectF3.left, getBaseLine(rectF3, this.mPaint), this.mPaint);
            f16 = this.mRectF.right;
            if (!"0".equals(this.likeNum)) {
                int round = Math.round(f16) + i17;
                Drawable drawable3 = this.mDotDrawable;
                int i28 = this.bottomDivideMargin;
                drawable3.setBounds(round, (i3 - i28) - i27, AreaConst.f48747dp2 + round, i3 - i28);
                this.mDotDrawable.draw(canvas);
                f16 = this.mDotDrawable.getBounds().right;
            }
        }
        if ("0".equals(this.likeNum)) {
            return;
        }
        for (int min = Math.min(this.faceNum, 3) - 1; min >= 0; min--) {
            if (this.mFaceDrawable.get(min) != null) {
                int round2 = Math.round(f16) + AreaConst.dp7 + (AreaConst.dp12 * min);
                Drawable drawable4 = this.mFaceDrawable.get(min);
                int i29 = this.bottomImgMargin;
                int i36 = AreaConst.dp20;
                drawable4.setBounds(round2, (i3 - i29) - i36, i36 + round2, i3 - i29);
                this.mFaceDrawable.get(min).draw(canvas);
            }
        }
        if (this.faceNum > 0) {
            f16 = f16 + AreaConst.dp7 + (AreaConst.dp12 * r0) + AreaConst.dp8;
        }
        Paint paint2 = this.mPaint;
        String str2 = this.likeNum;
        paint2.getTextBounds(str2, 0, str2.length(), this.mTextBottomBound);
        RectF rectF4 = this.mRectF;
        float f17 = f16 + AreaConst.f48747dp2;
        rectF4.left = f17;
        rectF4.right = f17 + this.mTextBottomBound.width();
        this.mRectF.top = (i3 - this.bottomTextMargin) - this.mTextBottomBound.height();
        RectF rectF5 = this.mRectF;
        rectF5.bottom = i3 - this.bottomTextMargin;
        canvas.drawText(this.likeNum, rectF5.left, getBaseLine(rectF5, this.mPaint), this.mPaint);
    }

    public void initBottomActionArea() {
        final ArrayList<String> arrayList;
        String str;
        ArrayList<multiple_count> arrayList2;
        BusinessFeedData businessFeedData = this.feedData;
        if (businessFeedData == null || !businessFeedData.isQCircleRecommFeed()) {
            return;
        }
        if (!this.isOnVideoLayer) {
            this.bottomTextMargin = AreaConst.dp16;
            this.bottomImgMargin = AreaConst.dp13;
            this.bottomDivideMargin = AreaConst.dp21;
        } else {
            this.bottomTextMargin = AreaConst.dp8;
            this.bottomImgMargin = AreaConst.dp5;
            this.bottomDivideMargin = AreaConst.dp13;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        int i3 = AreaConst.dp20;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(AreaConst.dp15);
        this.mPaint.setStrokeWidth(0.55f);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        if (this.feedData.getCellCount() == null || (arrayList2 = this.feedData.getCellCount().mulcount) == null) {
            arrayList = null;
            str = null;
        } else {
            arrayList = null;
            str = null;
            for (multiple_count multiple_countVar : arrayList2) {
                int i16 = multiple_countVar.type;
                if (i16 == 5) {
                    arrayList = multiple_countVar.icon;
                    this.likeNum = bigNumberFormatTranfer(multiple_countVar.num);
                } else if (i16 == 4) {
                    ArrayList<String> arrayList3 = multiple_countVar.icon;
                    if (arrayList3 != null && arrayList3.size() > 1) {
                        str = multiple_countVar.icon.get(1);
                    } else {
                        str = FEED_QCIRCLE_PUSHCOUNT_ICON_URL;
                    }
                    this.pushNum = bigNumberFormatTranfer(multiple_countVar.num);
                }
            }
        }
        this.mMaskDrawable = j.g(979);
        this.mDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(PictureUrl.calculateImageUrl(str), null, new ImageLoader.ImageLoadListener() { // from class: com.qzone.canvasui.widget.CanvasQcircleRecomBottomView.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                CanvasQcircleRecomBottomView.this.mDrawable = drawable;
                CanvasQcircleRecomBottomView.this.mDrawable.invalidateSelf();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        }, obtain);
        ImageLoader.Options obtain2 = ImageLoader.Options.obtain();
        obtain2.clipHeight = AreaConst.f48749dp4;
        obtain2.clipWidth = AreaConst.f48748dp3;
        this.mDotDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(PictureUrl.calculateImageUrl(FEED_QCIRCLE_DIVIDE_DOT_ICON_URL), null, new ImageLoader.ImageLoadListener() { // from class: com.qzone.canvasui.widget.CanvasQcircleRecomBottomView.2
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                CanvasQcircleRecomBottomView.this.mDotDrawable = drawable;
                CanvasQcircleRecomBottomView.this.mDotDrawable.invalidateSelf();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        }, obtain2);
        if (arrayList != null) {
            this.faceNum = arrayList.size();
            for (int min = Math.min(arrayList.size(), 3) - 1; min >= 0; min--) {
                Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(PictureUrl.calculateImageUrl(arrayList.get(min)), String.valueOf(min), new ImageLoader.ImageLoadListener() { // from class: com.qzone.canvasui.widget.CanvasQcircleRecomBottomView.3
                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                        int indexOf = arrayList.indexOf(str2);
                        if (indexOf >= 0) {
                            CanvasQcircleRecomBottomView.this.mFaceDrawable.set(indexOf, drawable);
                            ((Drawable) CanvasQcircleRecomBottomView.this.mFaceDrawable.get(indexOf)).invalidateSelf();
                        }
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageCanceled(String str2, ImageLoader.Options options) {
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageFailed(String str2, ImageLoader.Options options) {
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
                    }
                }, obtain);
                if (loadImage != null) {
                    this.mFaceDrawable.set(min, loadImage);
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        draw(canvas, canvas.getHeight(), canvas.getWidth());
    }

    public void resetFeedData(BusinessFeedData businessFeedData, boolean z16) {
        if (this.feedData != businessFeedData) {
            this.feedData = businessFeedData;
            this.isOnVideoLayer = z16;
            initBottomActionArea();
        }
    }

    private static String bigNumberFormatTranfer(long j3) {
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

    public CanvasQcircleRecomBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mRectF = new RectF();
        this.mTextBottomBound = new Rect();
        this.mFaceDrawable = new CopyOnWriteArrayList<>(new Drawable[]{null, null, null});
        this.likeNum = "0";
        this.pushNum = "0";
        this.faceNum = 0;
    }
}
