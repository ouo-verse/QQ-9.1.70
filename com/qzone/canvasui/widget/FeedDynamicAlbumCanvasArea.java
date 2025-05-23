package com.qzone.canvasui.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDynamicAlbum;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.vas.ap;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDynamicAlbumCanvasArea extends DittoArea {
    private static final double MAGIC_COLOR_MAX_Y = 153.0d;
    private static Drawable albumIcon;
    static int sMaxHLayerAlpha;
    private long mAnimationStartTime;
    int mBtnAlpha;
    int mBtnAlphaInc;
    final Paint mBtnIcPaint;
    final Path mBtnIcPath;
    final Paint mBtnRectBackgroundPaint;
    final Paint mBtnRectPaint;
    private RectF mBtnStrokeBound;
    final Paint mButtonPaint;
    float mClickPosX;
    int mDescAlpha;
    int mDescAlphaInc;
    int mDescAlphaTarget;
    final Paint mDescPaint;
    float mDownX;
    float mDownY;
    final PicListener mDownloadListener;
    CellDynamicAlbum mDynamicAlbumData;
    Drawable mFirstDrawable;
    private int mFirstUni;
    int mHLayerAlpha;
    int mHLayerAlphaInc;
    final Paint mHLayerPaint;
    final Rect mImageRect;
    boolean mNeedLayout;
    int mPadding;
    int mPicHeight;
    int mPicWidth;
    FeedPictureInfo[] mPictureInfos;
    ImageLoader.Options mPreOpt;
    String mPreUrl;
    Drawable mSecondDrawable;
    private int mSecondUni;
    final Paint mShaderPaint;
    int mTitleAlpha;
    int mTitleAlphaInc;
    final Paint mTitlePaint;
    private boolean switchAnimationEnabled;
    private boolean useNewStyle;
    public static final int sBtnRectFontSize = g.a(1.0f);
    static int globalUniNum = 1;
    static int sMinFrameCnt = 25;
    private static long sSTART_DELAY = 2000;
    private static long sPLAY_INTERNAL = 3000;
    private static long sFADE_DURATION = 350;
    public static final int dp5 = AreaConst.dp5;

    public FeedDynamicAlbumCanvasArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        int i3;
        this.useNewStyle = h.d("QZoneSetting", "showNewDynamicAlbumStyle", true);
        this.switchAnimationEnabled = h.d("QZoneSetting", "dynamicAlbumSwitchAnimation", true);
        this.mDownloadListener = new PicListener();
        Drawable drawable = AreaManager.DEFAULT_BACKGROUND;
        this.mFirstDrawable = drawable;
        this.mSecondDrawable = drawable;
        this.mFirstUni = -1;
        this.mSecondUni = -1;
        this.mClickPosX = -1.0f;
        Path path = new Path();
        this.mBtnIcPath = path;
        Rect rect = new Rect();
        this.mImageRect = rect;
        Paint paint = new Paint();
        this.mDescPaint = paint;
        Paint paint2 = new Paint();
        this.mTitlePaint = paint2;
        Paint paint3 = new Paint();
        this.mBtnIcPaint = paint3;
        Paint paint4 = new Paint();
        this.mButtonPaint = paint4;
        Paint paint5 = new Paint();
        this.mHLayerPaint = paint5;
        Paint paint6 = new Paint();
        this.mBtnRectPaint = paint6;
        Paint paint7 = new Paint();
        this.mBtnRectBackgroundPaint = paint7;
        this.mShaderPaint = new Paint();
        this.mDescAlphaTarget = 192;
        this.mAnimationStartTime = 0L;
        if (this.useNewStyle && albumIcon == null) {
            Drawable g16 = j.g(849);
            albumIcon = g16;
            g16.setBounds(0, 0, AreaConst.dp16, AreaConst.dp13);
        }
        rect.set(0, 0, 0, 0);
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setTextSize(CellDynamicAlbum.sDescFonSize);
        if (this.useNewStyle) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else {
            paint.setTextAlign(Paint.Align.CENTER);
        }
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setTextSize(CellDynamicAlbum.sTitleFontSize);
        if (this.useNewStyle) {
            paint2.setTextAlign(Paint.Align.LEFT);
            paint2.setFakeBoldText(true);
        } else {
            paint2.setTextAlign(Paint.Align.CENTER);
        }
        paint5.setColor(-16777216);
        paint3.setAntiAlias(true);
        paint3.setColor(-1);
        paint4.setAntiAlias(true);
        paint4.setColor(-1);
        if (this.useNewStyle) {
            i3 = CellDynamicAlbum.sNewBtnTextFontSize;
        } else {
            i3 = CellDynamicAlbum.sBtnTextFontSize;
        }
        paint4.setTextSize(i3);
        paint6.setAntiAlias(true);
        paint6.setColor(-1);
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeWidth(sBtnRectFontSize);
        paint7.setAntiAlias(true);
        paint7.setColor(CellDynamicAlbum.sBtnBackgroundColor);
        paint7.setStyle(Paint.Style.FILL);
        path.reset();
        if (this.useNewStyle) {
            int i16 = CellDynamicAlbum.sNewIc2BtnLeftDistance;
            path.moveTo(i16, CellDynamicAlbum.sNewIc2BtnTopDistance);
            int i17 = CellDynamicAlbum.sIcHeight;
            path.lineTo(i16, r1 + i17);
            path.lineTo(i16 + CellDynamicAlbum.sIcWidth, r1 + (i17 / 2));
        } else {
            int i18 = CellDynamicAlbum.sIc2BtnLeftDistance;
            path.moveTo(i18, CellDynamicAlbum.sIc2BtnTopDistance);
            int i19 = CellDynamicAlbum.sIcHeight;
            path.lineTo(i18, r1 + i19);
            path.lineTo(i18 + CellDynamicAlbum.sIcWidth, r1 + (i19 / 2));
        }
        if (sMaxHLayerAlpha <= 0) {
            sMaxHLayerAlpha = 40;
            sMaxHLayerAlpha = (40 * 256) / 100;
        }
        initAnimationData(sMinFrameCnt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int extractBgThemeColor(Bitmap bitmap) {
        List<ap.a> a16 = ap.a(bitmap);
        if (a16 == null || a16.isEmpty()) {
            return 0;
        }
        return a16.get(0).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int filterMagicColor(int i3) {
        if ((Color.red(i3) * 0.299d) + (Color.green(i3) * 0.587d) + (Color.blue(i3) * 0.114d) > MAGIC_COLOR_MAX_Y) {
            return -2013265920;
        }
        return i3 | ((16777215 & i3) - 2013265920);
    }

    static ImageLoader.Options getPicInfoOptions(FeedPictureInfo feedPictureInfo, int i3) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = Integer.valueOf(i3);
        obtain.preferQuality = false;
        obtain.extraProcessor = feedPictureInfo.c();
        obtain.processor = feedPictureInfo.g();
        obtain.clipHeight = feedPictureInfo.f50257t;
        obtain.clipWidth = feedPictureInfo.f50256s;
        if (feedPictureInfo.f50252o) {
            obtain.imageConfig = Bitmap.Config.ARGB_8888;
        }
        if (feedPictureInfo.h().width > 0 && feedPictureInfo.h().height > 0 && g.c(feedPictureInfo.h().width, feedPictureInfo.h().height)) {
            obtain.preferQuality = true;
        }
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processImage(final Drawable drawable, final int i3) {
        HdAsync.with(this).then(new HdAsyncAction(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread)) { // from class: com.qzone.canvasui.widget.FeedDynamicAlbumCanvasArea.2
            @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
            public HdAsyncResult call(Object obj) {
                if (FeedDynamicAlbumCanvasArea.this.useNewStyle && i3 == FeedDynamicAlbumCanvasArea.this.mFirstUni) {
                    Drawable drawable2 = drawable;
                    if (drawable2 instanceof BitmapDrawable) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable2;
                        if (bitmapDrawable.getBitmap() != null) {
                            Bitmap createBitmap = Bitmap.createBitmap(bitmapDrawable.getBitmap());
                            FeedDynamicAlbumCanvasArea feedDynamicAlbumCanvasArea = FeedDynamicAlbumCanvasArea.this;
                            int filterMagicColor = feedDynamicAlbumCanvasArea.filterMagicColor(feedDynamicAlbumCanvasArea.extractBgThemeColor(createBitmap));
                            FeedDynamicAlbumCanvasArea.this.mShaderPaint.setShader(new LinearGradient(0.0f, FeedDynamicAlbumCanvasArea.this.mPicHeight, 0.0f, (int) (r0 * 0.67f), filterMagicColor, 0, Shader.TileMode.CLAMP));
                        }
                    }
                }
                return doNext(true);
            }
        }).then(new HdAsyncAction(Looper.getMainLooper()) { // from class: com.qzone.canvasui.widget.FeedDynamicAlbumCanvasArea.1
            @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
            public HdAsyncResult call(Object obj) {
                if (drawable != null) {
                    if (i3 != FeedDynamicAlbumCanvasArea.this.mFirstUni) {
                        if (i3 == FeedDynamicAlbumCanvasArea.this.mSecondUni) {
                            FeedDynamicAlbumCanvasArea feedDynamicAlbumCanvasArea = FeedDynamicAlbumCanvasArea.this;
                            Drawable drawable2 = drawable;
                            feedDynamicAlbumCanvasArea.mSecondDrawable = drawable2;
                            drawable2.setBounds(0, 0, feedDynamicAlbumCanvasArea.mPicWidth, feedDynamicAlbumCanvasArea.mPicHeight);
                            FeedDynamicAlbumCanvasArea.this.invalidate();
                        }
                    } else {
                        FeedDynamicAlbumCanvasArea feedDynamicAlbumCanvasArea2 = FeedDynamicAlbumCanvasArea.this;
                        Drawable drawable3 = drawable;
                        feedDynamicAlbumCanvasArea2.mFirstDrawable = drawable3;
                        drawable3.setBounds(0, 0, feedDynamicAlbumCanvasArea2.mPicWidth, feedDynamicAlbumCanvasArea2.mPicHeight);
                        FeedDynamicAlbumCanvasArea.this.invalidate();
                    }
                }
                return doNext(true);
            }
        }).call();
    }

    boolean checkClickOutside(float f16, float f17) {
        float f18 = this.mDownX;
        if (f18 >= 0.0f) {
            float f19 = this.mDownY;
            if (f19 >= 0.0f) {
                float f26 = ((f18 - f16) * (f18 - f16)) + ((f19 - f17) * (f19 - f17));
                int i3 = dp5;
                r3 = f26 > ((float) (i3 * i3));
                if (r3) {
                    this.mDownY = -1.0f;
                    this.mDownX = -1.0f;
                }
            }
        }
        return r3;
    }

    boolean drawDescText(Canvas canvas) {
        if (isListViewScrollIdle()) {
            int i3 = this.mDescAlpha;
            if (i3 < this.mDescAlphaTarget) {
                Paint paint = this.mDescPaint;
                int i16 = i3 + this.mDescAlphaInc;
                this.mDescAlpha = i16;
                paint.setAlpha(i16);
            }
            int i17 = this.mDescAlpha;
            int i18 = this.mDescAlphaTarget;
            if (i17 > i18) {
                this.mDescAlpha = i18;
                this.mDescPaint.setAlpha(i18);
            }
        }
        if (this.useNewStyle) {
            canvas.drawText(this.mDynamicAlbumData.mViewDescText, AreaConst.dp39, r1.mNewDescTextTop, this.mDescPaint);
            if (albumIcon != null) {
                int save = canvas.save();
                float f16 = AreaConst.dp16;
                CellDynamicAlbum cellDynamicAlbum = this.mDynamicAlbumData;
                canvas.translate(f16, (cellDynamicAlbum.mNewDescTextTop - cellDynamicAlbum.mDescTextHeight) + AreaConst.f48747dp2);
                albumIcon.draw(canvas);
                canvas.restoreToCount(save);
            }
        } else {
            canvas.drawText(this.mDynamicAlbumData.mViewDescText, r0.mPicWidth / 2, r0.mDescTextTop + (r0.mDescTextHeight / 2), this.mDescPaint);
        }
        return this.mDescAlpha >= this.mDescAlphaTarget;
    }

    boolean drawDynamicAlbumPocess(Canvas canvas) {
        if (!drawImage(canvas) || !drawHLayer(canvas) || !drawTitle(canvas) || !drawDescText(canvas) || !drawPlayButton(canvas)) {
            return false;
        }
        this.mDynamicAlbumData.setFeedPlayed();
        return true;
    }

    boolean drawHLayer(Canvas canvas) {
        if (this.useNewStyle) {
            canvas.drawRect(0.0f, 0.0f, this.mPicWidth, this.mPicHeight, this.mShaderPaint);
            return true;
        }
        if (isListViewScrollIdle()) {
            int i3 = this.mHLayerAlpha;
            if (i3 < sMaxHLayerAlpha) {
                Paint paint = this.mHLayerPaint;
                int i16 = i3 + this.mHLayerAlphaInc;
                this.mHLayerAlpha = i16;
                paint.setAlpha(i16);
            }
            int i17 = this.mHLayerAlpha;
            int i18 = sMaxHLayerAlpha;
            if (i17 > i18) {
                this.mHLayerAlpha = i18;
                this.mHLayerPaint.setAlpha(i18);
            }
        }
        CellDynamicAlbum cellDynamicAlbum = this.mDynamicAlbumData;
        canvas.drawRect(0.0f, 0.0f, cellDynamicAlbum.mPicWidth, cellDynamicAlbum.mPicHeight, this.mHLayerPaint);
        return this.mHLayerAlpha >= sMaxHLayerAlpha;
    }

    boolean drawImage(Canvas canvas) {
        Drawable drawable;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.useNewStyle && this.switchAnimationEnabled && this.mPictureInfos.length != 1) {
            long j3 = this.mAnimationStartTime;
            if (j3 != 0 && (drawable = this.mFirstDrawable) != AreaManager.DEFAULT_BACKGROUND) {
                long j16 = currentTimeMillis - j3;
                long j17 = sSTART_DELAY;
                if (j16 > j17) {
                    long j18 = (currentTimeMillis - j3) - j17;
                    long j19 = sFADE_DURATION;
                    long j26 = sPLAY_INTERNAL;
                    int i3 = (int) (j18 / (j19 + j26));
                    long j27 = j18 % (j26 + j19);
                    if (j27 > j19) {
                        if (i3 % 2 != 1) {
                            drawable = this.mSecondDrawable;
                        }
                        drawable.setAlpha(255);
                        drawable.setBounds(0, 0, this.mPicWidth, this.mPicHeight);
                        drawable.draw(canvas);
                        return drawable != AreaManager.DEFAULT_BACKGROUND;
                    }
                    int i16 = (int) ((j27 / j19) * 255.0d);
                    int i17 = i3 % 2;
                    Drawable drawable2 = i17 == 1 ? drawable : this.mSecondDrawable;
                    if (i17 != 0) {
                        drawable = this.mSecondDrawable;
                    }
                    drawable.setAlpha(255);
                    drawable2.setAlpha(i16);
                    drawable2.setBounds(0, 0, this.mPicWidth, this.mPicHeight);
                    drawable.setBounds(0, 0, this.mPicWidth, this.mPicHeight);
                    drawable.draw(canvas);
                    drawable2.draw(canvas);
                    invalidateDelayed(16L);
                    return true;
                }
                drawable.setBounds(0, 0, this.mPicWidth, this.mPicHeight);
                this.mFirstDrawable.draw(canvas);
                return this.mFirstDrawable != AreaManager.DEFAULT_BACKGROUND;
            }
            this.mAnimationStartTime = currentTimeMillis;
        }
        this.mFirstDrawable.setBounds(0, 0, this.mPicWidth, this.mPicHeight);
        this.mFirstDrawable.draw(canvas);
        return this.mFirstDrawable != AreaManager.DEFAULT_BACKGROUND;
    }

    boolean drawPlayButton(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (isListViewScrollIdle()) {
            int i19 = this.mBtnAlpha;
            if (i19 < 255) {
                this.mBtnIcPaint.setAlpha(i19);
                this.mButtonPaint.setAlpha(this.mBtnAlpha);
                this.mBtnRectPaint.setAlpha(this.mBtnAlpha);
                this.mBtnAlpha += this.mBtnAlphaInc;
            }
            if (this.mBtnAlpha > 255) {
                this.mBtnAlpha = 255;
                this.mBtnIcPaint.setAlpha(255);
                this.mButtonPaint.setAlpha(this.mBtnAlpha);
                this.mBtnRectPaint.setAlpha(this.mBtnAlpha);
            }
        }
        boolean z16 = this.useNewStyle;
        if (z16) {
            i3 = CellDynamicAlbum.sNewBtnWidth;
        } else {
            i3 = CellDynamicAlbum.sBtnWidth;
        }
        if (z16) {
            i16 = CellDynamicAlbum.sNewBtnHeight;
        } else {
            i16 = CellDynamicAlbum.sBtnHeight;
        }
        CellDynamicAlbum cellDynamicAlbum = this.mDynamicAlbumData;
        int i26 = cellDynamicAlbum.mButtonTop;
        int i27 = cellDynamicAlbum.mPicWidth;
        int i28 = (i27 - i3) / 2;
        if (z16) {
            i26 = cellDynamicAlbum.mNewButtonTop;
            i28 = (i27 - i3) - AreaConst.dp16;
        }
        canvas.save();
        canvas.translate(i28, i26);
        if (this.useNewStyle) {
            canvas.drawRect(0.0f, 0.0f, i3, i16, this.mBtnRectBackgroundPaint);
        }
        if (this.useNewStyle) {
            if (this.mBtnStrokeBound == null) {
                this.mBtnStrokeBound = new RectF(0.0f, 0.0f, i3, i16);
            }
            RectF rectF = this.mBtnStrokeBound;
            int i29 = AreaConst.f48747dp2;
            canvas.drawRoundRect(rectF, i29, i29, this.mBtnRectPaint);
        } else {
            canvas.drawRect(0.0f, 0.0f, i3, i16, this.mBtnRectPaint);
        }
        canvas.drawPath(this.mBtnIcPath, this.mBtnIcPaint);
        int ceil = (int) Math.ceil((i16 + this.mDynamicAlbumData.mButtonTextHeight) / 2);
        if (this.useNewStyle) {
            i17 = CellDynamicAlbum.sNewIc2BtnLeftDistance;
            i18 = CellDynamicAlbum.sNewBtnText2IcDistance;
        } else {
            i17 = CellDynamicAlbum.sIc2BtnLeftDistance;
            i18 = CellDynamicAlbum.sBtnText2IcDistance;
        }
        canvas.drawText(this.mDynamicAlbumData.buttonText, i17 + i18 + CellDynamicAlbum.sIcWidth, ceil, this.mButtonPaint);
        canvas.restore();
        return this.mBtnAlpha >= 255;
    }

    boolean drawTitle(Canvas canvas) {
        if (isListViewScrollIdle()) {
            int i3 = this.mTitleAlpha;
            if (i3 < 255) {
                Paint paint = this.mTitlePaint;
                int i16 = i3 + this.mTitleAlphaInc;
                this.mTitleAlpha = i16;
                paint.setAlpha(i16);
            }
            if (this.mTitleAlpha > 255) {
                this.mTitleAlpha = 255;
                this.mTitlePaint.setAlpha(255);
            }
        }
        if (this.useNewStyle) {
            canvas.drawText(this.mDynamicAlbumData.mViewTitle, AreaConst.dp16, r2.mNewTitleTextTop, this.mTitlePaint);
        } else {
            canvas.drawText(this.mDynamicAlbumData.mViewTitle, r0.mPicWidth / 2, r0.mTitleTop + (r0.mTitleHeight / 2), this.mTitlePaint);
        }
        return this.mTitleAlpha >= 255;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public int getType() {
        return 8;
    }

    int getUniNum() {
        int i3 = globalUniNum + 1;
        globalUniNum = i3;
        return i3;
    }

    boolean isListViewScrollIdle() {
        return i.H().g1();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mFirstDrawable == null || this.mDynamicAlbumData == null || this.mPicWidth <= AreaConst.dp25) {
            return;
        }
        canvas.save();
        drawDynamicAlbumPocess(canvas);
        invalidateDelayed(16L);
        canvas.restore();
        if (this.mDynamicAlbumData.feedHasPlayed()) {
            return;
        }
        invalidateDelayed(16L);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(this.mPicWidth, this.mPicHeight);
    }

    public void onStateIdle() {
        if (this.mNeedLayout) {
            requestLayout();
            this.mNeedLayout = false;
        }
        Drawable drawable = this.mFirstDrawable;
        if (drawable == null || drawable == AreaManager.DEFAULT_BACKGROUND) {
            return;
        }
        invalidate();
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInPicArea(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        this.mClickPosX = motionEvent.getX();
        if (motionEvent.getAction() == 0) {
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
        } else if (motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (this.clickListener != null && !checkClickOutside(motionEvent.getX(), motionEvent.getY())) {
                    this.clickListener.onClick(this, null, null);
                }
            } else if (motionEvent.getAction() != 3) {
                motionEvent.getAction();
            }
        }
        this.mClickPosX = -1.0f;
        return true;
    }

    public void setPicInfo(BusinessFeedData businessFeedData, FeedPictureInfo[] feedPictureInfoArr, boolean z16) {
        this.mPictureInfos = feedPictureInfoArr;
        if (feedPictureInfoArr == null || feedPictureInfoArr.length == 0) {
            return;
        }
        if (z16 && (businessFeedData = businessFeedData.getOriginalInfo()) == null) {
            return;
        }
        this.mAnimationStartTime = 0L;
        this.mDynamicAlbumData = businessFeedData.getCellDynamicAlbum();
        int i3 = AreaConst.MARGIN_LEFT;
        if (z16) {
            this.mPadding = 0;
            this.mPicWidth = FeedGlobalEnv.g().getScreenWidth() - (i3 * 2);
        } else if (i.H().s1()) {
            this.mPadding = 0;
            this.mPicWidth = FeedGlobalEnv.g().getScreenWidth();
        } else {
            this.mPadding = i3;
            this.mPicWidth = FeedGlobalEnv.g().getScreenWidth() - (i3 * 2);
        }
        int i16 = this.mPicWidth;
        this.mPicHeight = i16;
        if (i16 < 300) {
            this.mPicHeight = 300;
        }
        if (this.mPicHeight < 300) {
            for (FeedPictureInfo feedPictureInfo : feedPictureInfoArr) {
                PictureUrl h16 = feedPictureInfo.h();
                this.mPicHeight = 300;
                h16.height = 300;
            }
        }
        int uniNum = getUniNum();
        this.mFirstUni = uniNum;
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(this.mPictureInfos[0].h().imageUrl, this.mPictureInfos[0].h().url, this.mDownloadListener, getPicInfoOptions(this.mPictureInfos[0], uniNum));
        if (loadImage == null) {
            this.mFirstDrawable = AreaManager.DEFAULT_BACKGROUND;
        } else {
            processImage(loadImage, this.mFirstUni);
        }
        if (this.useNewStyle && this.switchAnimationEnabled && feedPictureInfoArr.length != 1) {
            int uniNum2 = getUniNum();
            this.mSecondUni = uniNum2;
            Drawable loadImage2 = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(this.mPictureInfos[1].h().imageUrl, this.mPictureInfos[1].h().url, this.mDownloadListener, getPicInfoOptions(this.mPictureInfos[0], uniNum2));
            if (loadImage == null) {
                this.mSecondDrawable = AreaManager.DEFAULT_BACKGROUND;
            } else {
                processImage(loadImage2, this.mSecondUni);
            }
        }
        this.mBtnAlpha = 0;
        this.mDescAlpha = 0;
        this.mTitleAlpha = 0;
        this.mHLayerAlpha = 0;
        if (this.mDynamicAlbumData.feedHasPlayed()) {
            this.mBtnAlpha = 255;
            this.mDescAlpha = this.mDescAlphaTarget;
            this.mTitleAlpha = 255;
            this.mHLayerAlpha = sMaxHLayerAlpha;
        }
        this.mDescPaint.setAlpha(this.mDescAlpha);
        this.mTitlePaint.setAlpha(this.mTitleAlpha);
        this.mBtnIcPaint.setAlpha(this.mBtnAlpha);
        this.mButtonPaint.setAlpha(this.mBtnAlpha);
        this.mBtnRectPaint.setAlpha(this.mBtnAlpha);
        this.mHLayerPaint.setAlpha(this.mHLayerAlpha);
        this.mImageRect.set(0, 0, this.mPicWidth, this.mPicHeight);
        CellDynamicAlbum cellDynamicAlbum = this.mDynamicAlbumData;
        int i17 = cellDynamicAlbum.mPicWidth;
        int i18 = this.mPicWidth;
        if (i17 != i18 || cellDynamicAlbum.mPicHeight != this.mPicHeight) {
            cellDynamicAlbum.calculateDynamicAlbum(i18, this.mPicHeight);
        }
        setPadding(this.mPadding, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class PicListener implements ImageLoader.ImageLoadListener {
        public PicListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            if (options == null || (obj = options.obj) == null || !(obj instanceof Integer) || drawable == null) {
                return;
            }
            FeedDynamicAlbumCanvasArea.this.processImage(drawable, ((Integer) obj).intValue());
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
    }

    @Override // com.tencent.ditto.area.DittoArea
    public Object getData() {
        return 0;
    }

    public void onRecycled() {
        this.mPreOpt = null;
        this.mPreUrl = null;
        this.mDynamicAlbumData = null;
        this.mNeedLayout = false;
        this.mFirstDrawable = null;
        this.mSecondDrawable = null;
        this.mPictureInfos = null;
        this.mPadding = 0;
        this.mPicWidth = 0;
        this.mPicHeight = 0;
        this.mBtnAlpha = 0;
        this.mDescAlpha = 0;
        this.mTitleAlpha = 0;
        this.mHLayerAlpha = 0;
        this.mAnimationStartTime = 0L;
        this.mImageRect.set(0, 0, 0, 0);
        initAnimationData(sMinFrameCnt);
        this.mDescPaint.setAlpha(this.mDescAlpha);
        this.mTitlePaint.setAlpha(this.mTitleAlpha);
        this.mBtnIcPaint.setAlpha(this.mBtnAlpha);
        this.mButtonPaint.setAlpha(this.mBtnAlpha);
        this.mBtnRectPaint.setAlpha(this.mBtnAlpha);
        this.mHLayerPaint.setAlpha(this.mHLayerAlpha);
    }

    void initAnimationData(int i3) {
        int i16 = 255 / i3;
        this.mBtnAlphaInc = i16;
        this.mDescAlphaInc = this.mDescAlphaTarget / i3;
        this.mTitleAlphaInc = i16;
        this.mHLayerAlphaInc = sMaxHLayerAlpha / i3;
    }

    public boolean isInPicArea(float f16, float f17) {
        return f16 > 0.0f && f16 < ((float) this.mPicWidth) && f17 > 0.0f && f17 < ((float) this.mPicHeight);
    }
}
