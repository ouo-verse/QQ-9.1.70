package com.qzone.canvasui.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoImageArea;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasGifArea extends DittoImageArea implements AutoGifDrawable.AutoGifCallback {
    AutoGifDrawable autoGifDrawable;
    private boolean isNeedDrawMongLayer;
    private String mCurrUrl;
    private int mHeight;
    private int mWidth;
    private int plusNum;

    public CanvasGifArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.isNeedDrawMongLayer = false;
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

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public void invalidateGifView() {
        invalidate();
    }

    @Override // com.tencent.component.media.image.drawable.AutoGifDrawable.AutoGifCallback
    public boolean isListViewScrollIdle() {
        return i.H().g1();
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            try {
                autoGifDrawable.draw(canvas, getWidth(), getHeight());
            } catch (Exception e16) {
                b.d("CanvasGifArea", "CanvasGifArea draw exception.", e16);
            }
        }
        if (this.isNeedDrawMongLayer) {
            drawMonglayer(canvas);
        }
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void playGif() {
        playGif(false);
    }

    public void recycle() {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.recycled();
            this.autoGifDrawable = null;
        }
    }

    public void resetGif() {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.reset();
        }
    }

    public void seedToFrame(int i3) {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable == null || !(autoGifDrawable.getRealDrawable() instanceof NewGifDrawable)) {
            return;
        }
        ((NewGifDrawable) this.autoGifDrawable.getRealDrawable()).seekToFrame(i3);
    }

    public void setGifImage(String str, int i3, int i16, boolean z16) {
        setGifImage(str, i3, i16, z16, (AutoGifDrawable.GifDownloadCallBackListener) null);
    }

    public void setGifPlayListener(NewGifDrawable.GifPlayListener gifPlayListener) {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.setGifPlayListener(gifPlayListener);
        }
    }

    public void setMongLayer(int i3, boolean z16) {
        this.isNeedDrawMongLayer = z16;
        this.plusNum = i3;
    }

    public void stopGif() {
        AutoGifDrawable autoGifDrawable = this.autoGifDrawable;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
        }
    }

    public void playGif(boolean z16) {
        View containerView;
        AutoGifDrawable autoGifDrawable;
        DittoHost dittoHost = this.mHost;
        if (dittoHost == null || (containerView = dittoHost.getContainerView()) == null) {
            return;
        }
        int[] iArr = new int[2];
        containerView.getLocationOnScreen(iArr);
        int[] locationToViewHost = DittoAreaView.getLocationToViewHost(this);
        int height = getHeight();
        int i3 = iArr[1] + locationToViewHost[1];
        boolean z17 = g.a(75.0f) - i3 < (height * 1) / 3;
        boolean z18 = FeedGlobalEnv.g().getScreenHeight() - i3 > (height * 2) / 3;
        if (z17 && z18 && (autoGifDrawable = this.autoGifDrawable) != null) {
            if (z16) {
                autoGifDrawable.restart();
            } else {
                autoGifDrawable.start();
            }
        }
    }

    public void setGifImage(ImageUrl imageUrl, String str, int i3, int i16, boolean z16) {
        setGifImage(imageUrl, str, i3, i16, z16, null);
    }

    public void setGifImage(String str, int i3, int i16, boolean z16, AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener) {
        setGifImage(null, str, i3, i16, z16, gifDownloadCallBackListener);
    }

    public void setGifImage(ImageUrl imageUrl, String str, int i3, int i16, boolean z16, AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener) {
        this.mCurrUrl = str;
        this.mWidth = i3;
        this.mHeight = i16;
        this.autoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.clipWidth = i3;
        obtain.clipHeight = i16;
        obtain.imageConfig = Bitmap.Config.ARGB_8888;
        obtain.preferQuality = true;
        obtain.needCache = z16;
        if (imageUrl != null) {
            this.autoGifDrawable.init(imageUrl, obtain, getContext(), this, gifDownloadCallBackListener);
        } else {
            this.autoGifDrawable.init(this.mCurrUrl, obtain, getContext(), this, gifDownloadCallBackListener);
        }
    }

    public void setGifImage(String str, int i3, int i16) {
        setGifImage(str, i3, i16, true);
    }

    public void setGifImage(ImageUrl imageUrl, String str, int i3, int i16) {
        setGifImage(imageUrl, str, i3, i16, true);
    }
}
