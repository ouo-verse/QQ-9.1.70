package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.module.feedcomponent.view.FeedImageView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedGifView extends FeedImageView implements AutoGifDrawable.AutoGifCallback {
    private AutoGifDrawable autoGifDrawable;
    private String autoGifUrl;
    private boolean canAutoPlayGif;
    private boolean canShowMark;
    public int gifHeight;
    private ImageProcessor gifProcessor;
    public int gifWidth;
    private boolean hasStart;
    private Drawable imgDrawable;
    private boolean isOrderPlay;

    public FeedGifView(Context context) {
        this(context, null);
    }

    public static boolean checkIsGif(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().endsWith(QzoneEmotionUtils.SIGN_ICON_URL_END) || str.endsWith("_qzonegif");
    }

    private void initGif() {
        if (this.canAutoPlayGif && this.autoGifDrawable == null && !TextUtils.isEmpty(this.autoGifUrl)) {
            AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
            this.autoGifDrawable = newAutoGifDrawable;
            newAutoGifDrawable.init(this.autoGifUrl, getGifOptions(), FeedGlobalEnv.getContext(), this);
        }
    }

    private void initGifView(Context context) {
        this.isOrderPlay = i.H().Y() == 2;
        this.canAutoPlayGif = i.H().k() && !this.isOrderPlay;
        this.gifWidth = FeedGlobalEnv.g().getScreenWidth();
        this.gifHeight = FeedGlobalEnv.g().getScreenHeight();
    }

    public FeedImageView.ImageType autoCheckGifType() {
        FeedImageView.ImageType imageType = FeedImageView.ImageType.NORMAL;
        if (checkIsGif(this.autoGifUrl)) {
            imageType = FeedImageView.ImageType.IMAGE_GIF;
        }
        setImageType(imageType);
        return imageType;
    }

    protected void drawGifMark(Canvas canvas) {
        int i3;
        int i16;
        int i17 = this.gifWidth;
        int i18 = AreaConst.dp28;
        if (i17 <= i18 || (i3 = this.gifHeight) <= (i16 = AreaConst.dp15)) {
            return;
        }
        AreaManager.GIF_DRAWABLE.setBounds(i17 - i18, i3 - i16, i17, i3);
        AreaManager.GIF_DRAWABLE.draw(canvas);
    }

    public AutoGifDrawable getGifDrawable() {
        return this.autoGifDrawable;
    }

    public ImageLoader.Options getGifOptions() {
        int i3;
        int i16;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = this;
        if (this.gifWidth > getWidth() && getWidth() > 0) {
            i3 = getWidth();
        } else {
            i3 = this.gifWidth;
        }
        obtain.clipWidth = i3;
        if (this.gifHeight > getHeight() && getHeight() > 0) {
            i16 = getHeight();
        } else {
            i16 = this.gifHeight;
        }
        obtain.clipHeight = i16;
        if (this.gifProcessor == null) {
            this.gifProcessor = new NewGifDrawableSpecifiedRegionProcessor(obtain.clipWidth, obtain.clipHeight, i.H().e0());
        }
        obtain.extraProcessor = this.gifProcessor;
        return obtain;
    }

    public ImageProcessor getGifProcessor() {
        return this.gifProcessor;
    }

    public Drawable getImgDrawable() {
        return this.imgDrawable;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        invalidate();
    }

    public boolean isCanAutoPlayGif() {
        return this.canAutoPlayGif;
    }

    public boolean isCanShowMark() {
        return this.canShowMark;
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        return i.H().g1();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.recycled();
            this.autoGifDrawable = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.view.FeedImageView, com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable realDrawable;
        AutoGifDrawable autoGifDrawable;
        if (this.canAutoPlayGif && (autoGifDrawable = this.autoGifDrawable) != null && autoGifDrawable.draw(canvas, getWidth(), getHeight())) {
            this.mLoaded = false;
            if (!i.H().p1() || (realDrawable = this.autoGifDrawable.getRealDrawable()) == null) {
                return;
            }
            Paint paint = new Paint();
            paint.setColor(j.p());
            canvas.drawRect(realDrawable.getBounds(), paint);
            return;
        }
        this.mLoaded = true;
        if (this.imgDrawable == null) {
            this.imgDrawable = AreaManager.DEFAULT_BACKGROUND;
        }
        Drawable drawable = this.imgDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getHeight());
            j.U(this.imgDrawable);
            this.imgDrawable.draw(canvas);
        }
        if (this.canShowMark && this.mLoaded) {
            this.mMarker.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.module.feedcomponent.view.FeedImageView, com.tencent.component.media.image.view.ExtendImageView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void playGif(boolean z16) {
        if (this.canAutoPlayGif) {
            AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
            if (autoGifDrawable != null) {
                if (z16 && autoGifDrawable.isRunning()) {
                    return;
                }
                if (!z16 && !this.autoGifDrawable.isRunning()) {
                    return;
                }
            }
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            int height = getHeight();
            int top = iArr[1] + getTop();
            boolean z17 = g.a(75.0f) - top < (height * 1) / 3;
            boolean z18 = FeedGlobalEnv.g().getScreenHeight() - top > (height * 2) / 3;
            if (z17 && z18) {
                if (this.mImageType == FeedImageView.ImageType.IMAGE_GIF) {
                    initGif();
                }
                AutoGifDrawable autoGifDrawable2 = this.autoGifDrawable;
                if (autoGifDrawable2 != null) {
                    if (z16) {
                        if (autoGifDrawable2.isRunning()) {
                            return;
                        }
                        this.autoGifDrawable.start();
                        return;
                    } else {
                        if (autoGifDrawable2.isRunning()) {
                            this.autoGifDrawable.stop();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.autoGifDrawable = null;
        }
    }

    public void playGifDirect() {
        if (this.canAutoPlayGif) {
            if (this.mImageType == FeedImageView.ImageType.IMAGE_GIF) {
                initGif();
            }
            AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
            if (autoGifDrawable != null) {
                autoGifDrawable.start();
            }
        }
    }

    public void setAsyncGif(String str, String str2) {
        this.autoGifUrl = str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setAsyncImage(str);
    }

    public void setCanAutoPlayGif(boolean z16) {
        this.canAutoPlayGif = z16;
    }

    public void setCanShowMark(boolean z16) {
        this.canShowMark = z16;
    }

    public void setGifDrawable(AutoGifDrawable autoGifDrawable) {
        this.autoGifDrawable = autoGifDrawable;
    }

    public void setGifProcessor(ImageProcessor imageProcessor) {
        this.gifProcessor = imageProcessor;
    }

    public void setGifWH(int i3, int i16) {
        this.gifWidth = i3;
        this.gifHeight = i16;
    }

    @Override // com.qzone.module.feedcomponent.view.FeedImageView, com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.imgDrawable = drawable;
        super.setImageDrawable(drawable);
    }

    public void setImgDrawable(Drawable drawable) {
        this.imgDrawable = drawable;
    }

    public void stopGif() {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
        }
    }

    public FeedGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imgDrawable = AreaManager.DEFAULT_BACKGROUND;
        this.autoGifDrawable = null;
        this.autoGifUrl = null;
        this.canAutoPlayGif = false;
        this.isOrderPlay = false;
        this.canShowMark = true;
        this.hasStart = false;
        setContentDescription("Gif\u56fe\u7247");
        initGifView(context);
    }

    public void onScrolling() {
        playGif(false);
    }

    public void onStateIdle() {
        playGif(true);
    }

    public void playGif() {
        playGif(true);
    }
}
