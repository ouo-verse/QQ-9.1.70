package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.util.g;
import com.qzone.util.image.d;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.CircleProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.widget.DittoImageArea;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AsyncCanvasImageArea extends DittoImageArea {
    public static final int DEFAULT_FAMOUS_ICON_HEIGHT = g.a(14.0f);
    public static final int DEFAULT_RIGHT_ICON_HEIGHT = g.a(10.0f);
    protected static final String IMAGE_URL = "img_url";
    protected static final String PLACE_HOLDER_RESOURCE_ID = "place_holder";
    private String mCurrUrl;
    private volatile String mErrorMsg;
    private int mIconHeight;
    private Drawable mRightIconDrawable;
    private Drawable placeHolder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CropCircleProcessor extends ImageProcessor {
        private int avatarSize;

        public CropCircleProcessor(int i3) {
            this.avatarSize = i3;
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            int i3 = this.avatarSize;
            return new CircleProcessor().process(new SpecifiedSizeCropByPivotProcessor(i3, i3).process(drawable));
        }
    }

    public AsyncCanvasImageArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.mRightIconDrawable = null;
        this.mIconHeight = DEFAULT_RIGHT_ICON_HEIGHT;
        processAttr();
    }

    private void printLog(String str) {
        if (b.g()) {
            b.a("AsyncCanvasImageArea", str);
        }
    }

    private void processAttr() {
        boolean z16;
        LayoutAttrSet layoutAttrSet = this.mLayoutAttr;
        if (layoutAttrSet != null) {
            boolean z17 = true;
            if (layoutAttrSet.hasAttr(PLACE_HOLDER_RESOURCE_ID)) {
                this.placeHolder = j.g(this.mLayoutAttr.getResourceId(PLACE_HOLDER_RESOURCE_ID));
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mLayoutAttr.hasAttr(IMAGE_URL)) {
                this.mCurrUrl = this.mLayoutAttr.getAttr(IMAGE_URL, (String) null);
            } else {
                z17 = z16;
            }
            if (z17) {
                setAsyncImage(null, this.mCurrUrl, this.placeHolder, null);
            }
        }
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mRightIconDrawable;
        if (drawable != null && drawable.getIntrinsicHeight() != 0) {
            int intrinsicWidth = (this.mRightIconDrawable.getIntrinsicWidth() * this.mIconHeight) / this.mRightIconDrawable.getIntrinsicHeight();
            int i3 = this.mIconHeight;
            int width = getWidth();
            int height = getHeight();
            this.mRightIconDrawable.setBounds(width - intrinsicWidth, height - i3, width, height);
            this.mRightIconDrawable.draw(canvas);
        }
        if (d.f(this.mErrorMsg)) {
            if (d.g(this.mErrorMsg)) {
                String j3 = d.j(this.mErrorMsg);
                if (TextUtils.isEmpty(j3)) {
                    return;
                }
                d.a(canvas, j3, getWidth(), getHeight(), 0);
                return;
            }
            d.b(canvas, getWidth(), getHeight(), this.mErrorMsg, 0);
        }
    }

    public void setAsyncImage(ImageUrl imageUrl, String str, Drawable drawable, ImageLoader.Options options) {
        this.mCurrUrl = str;
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new AreaListener(this, "mCurrUrl"), options);
        if (loadImage != null) {
            setImageDrawable(loadImage);
        } else {
            setImageDrawable(drawable);
        }
    }

    public void setAsyncImageZeroBound(ImageUrl imageUrl, String str, Drawable drawable, ImageLoader.Options options) {
        this.mCurrUrl = str;
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new AreaListener(this, "mCurrUrl"), options);
        if (loadImage != null) {
            Rect bounds = loadImage.getBounds();
            if (bounds == null) {
                return;
            }
            bounds.right = 0;
            printLog("[setAsyncImage] drawable bound right: " + bounds.right);
            loadImage.setBounds(bounds);
            setImageDrawable(loadImage);
            return;
        }
        setImageDrawable(drawable);
    }

    public void setAvatar(long j3, int i3, Drawable drawable) {
        if (j3 > 0) {
            setAvatarUrl(PictureUrl.calculateAvaterImageUrl(i.H().P(Long.valueOf(j3))), i.H().P(Long.valueOf(j3)), i3, drawable);
        }
    }

    public void setAvatarUrl(ImageUrl imageUrl, String str, int i3, Drawable drawable) {
        if (TextUtils.isEmpty(str) && imageUrl == null) {
            return;
        }
        this.mCurrUrl = str;
        ImageLoader.Options options = new ImageLoader.Options();
        options.extraProcessor = new CropCircleProcessor(i3);
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new AreaListener(this, "mCurrUrl"), options);
        if (loadImage != null) {
            setImageDrawable(loadImage);
        } else {
            setImageDrawable(drawable);
        }
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        super.setLayoutAttr(layoutAttrSet);
        processAttr();
    }

    public void setRightCornerIcon(ImageUrl imageUrl, String str) {
        setRightCornerIcon(imageUrl, str, DEFAULT_RIGHT_ICON_HEIGHT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class AreaListener implements ImageLoader.ImageLoadListener {
        String mField;
        WeakReference<AsyncCanvasImageArea> weakArea;

        public AreaListener(AsyncCanvasImageArea asyncCanvasImageArea, String str) {
            this.weakArea = new WeakReference<>(asyncCanvasImageArea);
            this.mField = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            WeakReference<AsyncCanvasImageArea> weakReference;
            AsyncCanvasImageArea asyncCanvasImageArea;
            if (!isFailedToDownload(options) || (weakReference = this.weakArea) == null || (asyncCanvasImageArea = weakReference.get()) == null || !(asyncCanvasImageArea instanceof TagImageArea)) {
                return;
            }
            asyncCanvasImageArea.mErrorMsg = options.errCode;
            asyncCanvasImageArea.invalidate();
        }

        private boolean isFailedToDownload(ImageLoader.Options options) {
            return (options == null || TextUtils.isEmpty(options.errCode)) ? false : true;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            AsyncCanvasImageArea asyncCanvasImageArea;
            if (drawable == null || (asyncCanvasImageArea = this.weakArea.get()) == null || this.mField == null) {
                return;
            }
            if (!isFailedToDownload(options) || !(asyncCanvasImageArea instanceof TagImageArea)) {
                asyncCanvasImageArea.mErrorMsg = "";
            } else {
                asyncCanvasImageArea.mErrorMsg = options.errCode;
            }
            String str2 = this.mField;
            str2.hashCode();
            if (str2.equals("mCurrUrl")) {
                String str3 = asyncCanvasImageArea.mCurrUrl;
                if (str3 == null || !str3.equals(str)) {
                    return;
                }
                asyncCanvasImageArea.setImageDrawable(drawable);
                asyncCanvasImageArea.invalidate();
                return;
            }
            if (str2.equals("mRightIconDrawable")) {
                asyncCanvasImageArea.mRightIconDrawable = drawable;
                asyncCanvasImageArea.invalidate();
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public void setAvatar(User user, int i3, Drawable drawable) {
        if (user == null) {
            return;
        }
        int i16 = user.from;
        if (i16 == 0 || i16 == 1) {
            setAvatarUrl(PictureUrl.calculateAvaterImageUrl(i.H().P(Long.valueOf(user.uin))), i.H().P(Long.valueOf(user.uin)), i3, drawable);
        } else if (i16 == 2 || i16 == 3 || i16 == 4) {
            setAvatarUrl(user.logoImageUrl, user.logo, i3, drawable);
        }
    }

    public void setRightCornerIcon(ImageUrl imageUrl, String str, int i3) {
        if (TextUtils.isEmpty(str) && imageUrl == null) {
            this.mRightIconDrawable = null;
            return;
        }
        if (i3 > 0) {
            this.mIconHeight = i3;
        }
        this.mRightIconDrawable = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new AreaListener(this, "mRightIconDrawable"), new ImageLoader.Options());
        invalidate();
    }

    public void setAsyncImage(ImageUrl imageUrl, String str, Drawable drawable, ImageLoader.Options options, int i3, int i16) {
        this.mCurrUrl = str;
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new AreaListener(this, "mCurrUrl"), options);
        if (loadImage != null) {
            setImageDrawable(loadImage);
        } else {
            setImageDrawable(drawable);
        }
        setDimens(i3, i16);
    }

    public void setAvatarUrl(String str, ImageLoader.Options options, Drawable drawable) {
        ImageUrl calculateAvaterImageUrl;
        if (TextUtils.isEmpty(str) || (calculateAvaterImageUrl = PictureUrl.calculateAvaterImageUrl(str)) == null) {
            return;
        }
        this.mCurrUrl = str;
        Drawable loadImage = ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(calculateAvaterImageUrl, str, new AreaListener(this, "mCurrUrl"), options);
        if (loadImage != null) {
            setImageDrawable(loadImage);
        } else {
            setImageDrawable(drawable);
        }
    }
}
