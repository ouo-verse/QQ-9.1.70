package com.qzone.module.feedcomponent.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.adapter.feedcomponent.r;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;

/* loaded from: classes39.dex */
public class SinglePlayPicArea extends SubArea implements r, AutoGifDrawable.AutoGifCallback, com.qzone.proxy.feedcomponent.widget.d {
    static final int DEFAULT_PIC_HEIGHT;
    static final int DEFAULT_PIC_WIDTH;
    static int globalUniNum;
    protected int feedPosition;
    AutoGifDrawable gifDrawable;
    BusinessFeedData mFeedData;
    PicText mPicText;
    PictureItem mPictureInfo;
    protected com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;
    ImageUrl preImageUrl;
    ImageLoader.Options preOpt;
    String preUrl;
    final PicListener downloadListener = new PicListener();
    int mUni = -1;
    Drawable singleDrawable = AreaManager.DEFAULT_BACKGROUND;
    int picHeight = DEFAULT_PIC_HEIGHT;
    int picWidth = DEFAULT_PIC_WIDTH;
    private boolean isPlaying = false;
    private int progress = 0;
    AudioMediaPlayer.c progressListener = new AudioMediaPlayer.c() { // from class: com.qzone.module.feedcomponent.ui.SinglePlayPicArea.1
        @Override // com.qzone.proxy.feedcomponent.widget.AudioMediaPlayer.c
        public void onProgress(int i3, int i16) {
            SinglePlayPicArea.this.progress = i3;
            if (i16 - i3 < 1) {
                SinglePlayPicArea.this.progress = 0;
            }
        }
    };

    static {
        int commentWidth = (AreaConst.getCommentWidth() - AreaConst.FEED_INTERVAL) / 2;
        DEFAULT_PIC_WIDTH = commentWidth;
        DEFAULT_PIC_HEIGHT = (commentWidth * 200) / 270;
        globalUniNum = 1;
    }

    public SinglePlayPicArea() {
        this.mType = 20;
    }

    private boolean canPlayGif() {
        PictureItem pictureItem;
        PictureUrl pictureUrl;
        return (!com.qzone.adapter.feedcomponent.i.H().k() || (pictureItem = this.mPictureInfo) == null || !pictureItem.isAutoPlayGif || (pictureUrl = pictureItem.bigUrl) == null || TextUtils.isEmpty(pictureUrl.url)) ? false : true;
    }

    public static ImageLoader.Options getPicInfoImageLoaderOption(PictureItem pictureItem) {
        int i3 = DEFAULT_PIC_WIDTH;
        int i16 = DEFAULT_PIC_HEIGHT;
        if (pictureItem != null && pictureItem.getCurrentUrl() != null && pictureItem.getCurrentUrl().width > 0) {
            i16 = (int) (((pictureItem.getCurrentUrl().height * i3) * 1.0f) / pictureItem.getCurrentUrl().width);
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.clipHeight = i16;
        obtain.clipWidth = i3;
        obtain.preferQuality = false;
        obtain.extraProcessor = new NormalFeedImageProcessor(i3, i16, 0.5f, 0.0f);
        return obtain;
    }

    static int getUniNum() {
        int i3 = globalUniNum + 1;
        globalUniNum = i3;
        return i3;
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean draw(Canvas canvas, Paint paint) {
        if (this.gifDrawable == null || !canPlayGif() || !this.gifDrawable.draw(canvas, this.picWidth, this.picHeight)) {
            Drawable drawable = this.singleDrawable;
            if (drawable == null) {
                return true;
            }
            drawable.setBounds(0, 0, this.picWidth, this.picHeight);
            com.qzone.adapter.feedcomponent.j.U(this.singleDrawable);
            this.singleDrawable.draw(canvas);
        }
        PicText picText = this.mPicText;
        if (picText != null && !TextUtils.isEmpty(picText.playurl)) {
            int i3 = AreaConst.dp40;
            int i16 = AreaConst.dp10;
            int i17 = (this.picHeight - i16) - i3;
            if (this.isPlaying) {
                Drawable drawable2 = AreaManager.QQ_MUSIC_STOP;
                drawable2.setBounds(i16, i17, i16 + i3, i3 + i17);
                drawable2.draw(canvas);
            } else {
                Drawable drawable3 = AreaManager.QQ_MUSIC_PLAY;
                drawable3.setBounds(i16, i17, i16 + i3, i3 + i17);
                drawable3.draw(canvas);
            }
        }
        return true;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getHeight() {
        return this.picHeight;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.d
    public String getUniKey() {
        PicText picText = this.mPicText;
        if (picText != null) {
            return picText.playurl;
        }
        return null;
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public int getWidth() {
        return this.picWidth;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        invalidate();
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        return com.qzone.adapter.feedcomponent.i.H().g1();
    }

    public void onPause() {
        AutoGifDrawable autoGifDrawable = this.gifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
        }
        stopPlay();
    }

    public void onPlayIconClicked() {
        com.qzone.proxy.feedcomponent.ui.g gVar;
        PicText picText = this.mPicText;
        if (picText == null || TextUtils.isEmpty(picText.playurl) || (gVar = this.onFeedElementClickListener) == null) {
            return;
        }
        FeedElement feedElement = FeedElement.FRIEND_PLAY_MUSIC;
        int i3 = this.feedPosition;
        PicText picText2 = this.mPicText;
        gVar.onClick(null, feedElement, i3, new Object[]{picText2.playurl, this, picText2});
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
        if (!com.qzone.adapter.feedcomponent.i.H().g1() && this.preOpt != null) {
            ImageLoader.getInstance(FeedGlobalEnv.getContext()).cancel(this.preUrl, this.downloadListener, this.preOpt);
        }
        this.preOpt = null;
        this.preUrl = null;
        this.preImageUrl = null;
        this.singleDrawable = null;
        this.mPictureInfo = null;
        AutoGifDrawable autoGifDrawable = this.gifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
            this.gifDrawable = null;
        }
        stopPlay();
    }

    public void onStateIdle() {
        if (this.singleDrawable == AreaManager.DEFAULT_BACKGROUND && this.preOpt != null) {
            Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(this.preImageUrl, this.preUrl, this.downloadListener, this.preOpt);
            this.singleDrawable = loadImage;
            if (loadImage != null) {
                this.picHeight = loadImage.getIntrinsicHeight();
                int intrinsicWidth = this.singleDrawable.getIntrinsicWidth();
                this.picWidth = intrinsicWidth;
                int min = Math.min(intrinsicWidth, AreaConst.getDefaultWidth());
                this.picHeight = (this.picHeight * min) / this.picWidth;
                this.picWidth = min;
            } else {
                this.singleDrawable = AreaManager.DEFAULT_BACKGROUND;
            }
        }
        Drawable drawable = this.singleDrawable;
        if (drawable != null && drawable != AreaManager.DEFAULT_BACKGROUND) {
            invalidate();
        }
        View attachedView = getAttachedView();
        if (attachedView != null && canPlayGif()) {
            int[] iArr = new int[2];
            attachedView.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            boolean z16 = com.qzone.proxy.feedcomponent.util.g.a(75.0f) - i3 < (this.picHeight * 1) / 3;
            boolean z17 = FeedGlobalEnv.g().getScreenHeight() - i3 > (this.picHeight * 2) / 3;
            if (z16 && z17) {
                AutoGifDrawable autoGifDrawable = this.gifDrawable;
                if (autoGifDrawable != null) {
                    autoGifDrawable.start();
                    return;
                }
                AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
                this.gifDrawable = newAutoGifDrawable;
                PictureItem pictureItem = this.mPictureInfo;
                String str = pictureItem.bigUrl.url;
                ImageLoader.Options picInfoImageLoaderOption = getPicInfoImageLoaderOption(pictureItem);
                FeedGlobalEnv.g();
                newAutoGifDrawable.init(str, picInfoImageLoaderOption, FeedGlobalEnv.getContext(), this);
                return;
            }
        }
        AutoGifDrawable autoGifDrawable2 = this.gifDrawable;
        if (autoGifDrawable2 != null) {
            autoGifDrawable2.stop();
        }
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea
    public boolean onTouchEvent(MotionEvent motionEvent, SubAreaShell subAreaShell, boolean z16) {
        if (!isInPicArea(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
            if (motionEvent.getAction() == 1) {
                if (subAreaShell != null) {
                    subAreaShell.onAreaClicked(this, null);
                }
            } else if (motionEvent.getAction() != 3) {
                motionEvent.getAction();
            }
        }
        return true;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.d
    public void play() {
        if (this.isPlaying) {
            return;
        }
        this.isPlaying = true;
        postInvalidate();
    }

    public void setFeedPosition(int i3) {
        this.feedPosition = i3;
    }

    public void setOnFeedElementClickListener(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    public void setPicInfo(PictureItem pictureItem, PicText picText, BusinessFeedData businessFeedData) {
        int i3 = DEFAULT_PIC_WIDTH;
        int i16 = DEFAULT_PIC_HEIGHT;
        this.mPictureInfo = pictureItem;
        this.mFeedData = businessFeedData;
        if (pictureItem != null && pictureItem.getCurrentUrl() != null && pictureItem.getCurrentUrl().width > 0) {
            i16 = (int) (((pictureItem.getCurrentUrl().height * i3) * 1.0f) / pictureItem.getCurrentUrl().width);
        }
        this.picHeight = i16;
        this.picWidth = i3;
        ImageLoader.Options picInfoImageLoaderOption = getPicInfoImageLoaderOption(pictureItem);
        int uniNum = getUniNum();
        this.mUni = uniNum;
        picInfoImageLoaderOption.obj = Integer.valueOf(uniNum);
        ImageUrl imageUrl = null;
        String str = (pictureItem == null || pictureItem.getCurrentUrl() == null) ? null : pictureItem.getCurrentUrl().url;
        if (pictureItem != null && pictureItem.getCurrentUrl() != null) {
            imageUrl = pictureItem.getCurrentUrl().imageUrl;
        }
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, this.downloadListener, picInfoImageLoaderOption);
        this.singleDrawable = loadImage;
        if (loadImage == null) {
            this.singleDrawable = AreaManager.DEFAULT_BACKGROUND;
        }
        this.preUrl = str;
        this.preImageUrl = imageUrl;
        this.preOpt = picInfoImageLoaderOption;
        this.mPicText = picText;
        if (canPlayGif()) {
            if (this.gifDrawable == null) {
                this.gifDrawable = AutoGifDrawable.newAutoGifDrawable();
            }
            AutoGifDrawable autoGifDrawable = this.gifDrawable;
            String str2 = this.mPictureInfo.bigUrl.url;
            FeedGlobalEnv.g();
            autoGifDrawable.init(str2, picInfoImageLoaderOption, FeedGlobalEnv.getContext(), this);
        }
        this.isPlaying = com.qzone.adapter.feedcomponent.i.H().U0(picText);
        setMaxWidth(this.picWidth - AreaConst.dp10);
    }

    public boolean shouldPlay(float f16, float f17) {
        PicText picText;
        if (f16 > AreaConst.dp10) {
            if (f16 < AreaConst.dp50) {
                int i3 = this.picHeight;
                if (f17 > i3 - r1 && f17 < i3 - r0 && (picText = this.mPicText) != null && !TextUtils.isEmpty(picText.playurl)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.d
    public void stop() {
        if (this.isPlaying) {
            this.isPlaying = false;
            invalidate();
        }
    }

    public void stopPlay() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread() && this == AudioMediaPlayer.a().c()) {
            AudioMediaPlayer.a().n();
            AudioMediaPlayer.a().f();
        }
    }

    /* loaded from: classes39.dex */
    public class PicListener implements ImageLoader.ImageLoadListener {
        public PicListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            if (options == null || (obj = options.obj) == null || !(obj instanceof Integer) || drawable == null || SinglePlayPicArea.this.mUni != ((Integer) obj).intValue()) {
                return;
            }
            SinglePlayPicArea singlePlayPicArea = SinglePlayPicArea.this;
            singlePlayPicArea.singleDrawable = drawable;
            AreaManager.mainHanlder.obtainMessage(1, singlePlayPicArea).sendToTarget();
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

    boolean isInPicArea(float f16, float f17) {
        return f16 > 0.0f && f16 < ((float) this.picWidth) && f17 > 0.0f && f17 < ((float) this.picHeight);
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void clearTouchingEvent() {
    }

    public void reset() {
    }

    public void resetState() {
    }

    @Override // com.qzone.module.feedcomponent.ui.ViewArea
    public void measure(int i3, int i16) {
    }
}
