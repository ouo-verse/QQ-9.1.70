package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TagImageArea extends AsyncCanvasImageArea {
    private boolean isNeedDrawMongLayer;
    private boolean isNeedShowPlayButton;
    private String mAudioUrl;
    private Rect mBounds;
    private Drawable mCustomFlagDrawable;
    private FeedPictureInfo mPictureInfo;
    private long mQQMusicId;
    private int plusNum;
    public static final Drawable IMAGE_VIDEO = j.g(643);
    public static final Drawable QQ_MUSIC_STOP = j.g(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON);
    public static final Drawable QQ_MUSIC_PLAY = j.g(567);

    public TagImageArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.isNeedDrawMongLayer = false;
        this.isNeedShowPlayButton = true;
    }

    private void drawMonglayer(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(1711276032);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
        int i3 = AreaConst.dp18;
        paint.setColor(-1);
        paint.setTextSize(CanvasMultiGifArea.DEFAULT_NUM_TEXTSIZE);
        int height = ((int) (((getHeight() - paint.descent()) - paint.ascent()) / 2.0f)) + AreaConst.f48746dp1;
        String num = Integer.toString(this.plusNum);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.top);
        int measureText = (int) paint.measureText(num);
        canvas.drawText(num, (((getWidth() - measureText) / 2) - AreaConst.dp8) + i3, height, paint);
        int width = ((getWidth() - measureText) / 2) - AreaConst.dp10;
        int i16 = (height - AreaConst.f48747dp2) - (ceil / 2);
        AreaManager.MULTIPICTURE_ARROW.setBounds(width, i16, width + i3, i3 + i16);
        AreaManager.MULTIPICTURE_ARROW.draw(canvas);
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        FeedPictureInfo feedPictureInfo = this.mPictureInfo;
        if (feedPictureInfo == null) {
            return;
        }
        FeedPictureInfo.ImageType d16 = feedPictureInfo.d();
        if (d16 == FeedPictureInfo.ImageType.LEFT_THUMB_QQMUSIC) {
            if (this.mQQMusicId == i.H().t0()) {
                drawCenterTag(canvas, QQ_MUSIC_STOP);
            } else {
                drawCenterTag(canvas, QQ_MUSIC_PLAY);
            }
        } else if (d16 == FeedPictureInfo.ImageType.LEFT_THUMB_OUTAUDIO) {
            if (!TextUtils.isEmpty(this.mAudioUrl) && this.mAudioUrl.equals(i.H().u0())) {
                drawCenterTag(canvas, QQ_MUSIC_STOP);
            } else {
                drawCenterTag(canvas, QQ_MUSIC_PLAY);
            }
        } else if (d16 != FeedPictureInfo.ImageType.MUSIC && d16 != FeedPictureInfo.ImageType.LEFT_THUMB_AUDIO) {
            if ((d16 == FeedPictureInfo.ImageType.VIDEO || d16 == FeedPictureInfo.ImageType.LEFT_THUMB_VIDEO) && this.isNeedShowPlayButton) {
                drawCenterTag(canvas, IMAGE_VIDEO);
            }
        } else {
            drawCenterTag(canvas, QQ_MUSIC_PLAY);
        }
        Drawable drawable = this.mCustomFlagDrawable;
        if (drawable != null) {
            drawable.setBounds(this.mBounds);
            this.mCustomFlagDrawable.draw(canvas);
        }
        if (this.isNeedDrawMongLayer) {
            drawMonglayer(canvas);
        }
    }

    public void setIfShowPlayButton(boolean z16) {
        this.isNeedShowPlayButton = z16;
    }

    public void setImage(FeedPictureInfo feedPictureInfo, long j3, String str, Drawable drawable, ImageLoader.Options options) {
        this.mPictureInfo = feedPictureInfo;
        this.mQQMusicId = j3;
        this.mAudioUrl = str;
        if (feedPictureInfo == null || feedPictureInfo.h() == null || feedPictureInfo.h().url == null) {
            return;
        }
        setAsyncImage(feedPictureInfo.h().imageUrl, feedPictureInfo.h().url, drawable, options);
    }

    public void setImageFlag(ImageUrl imageUrl, String str, ImageLoader.Options options, final Rect rect) {
        Drawable loadImage;
        if ((TextUtils.isEmpty(str) && imageUrl == null) || (loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.canvasui.widget.TagImageArea.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options2) {
                if (drawable != null) {
                    TagImageArea.this.mCustomFlagDrawable = drawable;
                    TagImageArea.this.mBounds = rect;
                    TagImageArea.this.invalidate();
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options2) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options2) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options2) {
            }
        }, options)) == null) {
            return;
        }
        this.mCustomFlagDrawable = loadImage;
        this.mBounds = rect;
        invalidate();
    }

    public void setMongLayer(int i3, boolean z16) {
        this.isNeedDrawMongLayer = z16;
        this.plusNum = i3;
    }

    @Override // com.tencent.ditto.widget.DittoImageArea
    public void onRecycled() {
        this.mCustomFlagDrawable = null;
        this.mBounds = null;
    }

    private void drawCenterTag(Canvas canvas, Drawable drawable) {
        if (drawable == null || drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int width = (getWidth() - intrinsicWidth) / 2;
        int height = (getHeight() - intrinsicHeight) / 2;
        drawable.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
        drawable.draw(canvas);
    }
}
