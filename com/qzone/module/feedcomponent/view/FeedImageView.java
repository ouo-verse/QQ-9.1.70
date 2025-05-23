package com.qzone.module.feedcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.view.Markable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.component.media.image.view.AsyncImageable;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedImageView extends AsyncImageView implements Markable {
    static AsyncImageable.AsyncImageListener defaultListener = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.module.feedcomponent.view.FeedImageView.1
        @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
            if (asyncImageable instanceof FeedImageView) {
                ((FeedImageView) asyncImageable).setImageDrawable(null);
            }
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    };
    float mDenisty;
    ImageType mImageType;
    boolean mLoaded;
    Markable.Marker mMarker;
    int mPaddingXOffset;
    int mPaddingYOffset;

    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.view.FeedImageView$3, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType;

        static {
            int[] iArr = new int[ImageType.values().length];
            $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType = iArr;
            try {
                iArr[ImageType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[ImageType.IMAGE_GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[ImageType.IMAGE_GOLDEN_CUDGEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[ImageType.MUSIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[ImageType.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[ImageType.LEFT_THUMB_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[ImageType.LEFT_THUMB_AUDIO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum ImageType {
        NORMAL,
        IMAGE_GIF,
        IMAGE_GOLDEN_CUDGEL,
        VIDEO,
        MUSIC,
        AUDIO,
        LEFT_THUMB_VIDEO,
        LEFT_THUMB_AUDIO,
        LEFT_THUMB_QQMUSIC
    }

    public FeedImageView(Context context) {
        this(context, null);
        setDefaultListener();
    }

    Drawable getColorDrawable(int i3) {
        return new ColorDrawable(getResources().getColor(i3));
    }

    Drawable getDrawable(int i3) {
        return getResources().getDrawable(i3);
    }

    public ImageType getImageType() {
        return this.mImageType;
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void getMarkerSize(int[] iArr) {
        this.mMarker.getMarkerSize(iArr);
    }

    void init(Context context, AttributeSet attributeSet) {
        this.mDenisty = getResources().getDisplayMetrics().density;
        this.mMarker = new Markable.Marker(this, attributeSet);
        float f16 = this.mDenisty;
        this.mPaddingXOffset = (int) (2.0f * f16);
        this.mPaddingYOffset = (int) (f16 * 1.0f);
        setInternalAsyncImageListener(new AsyncImageable.AsyncImageListener() { // from class: com.qzone.module.feedcomponent.view.FeedImageView.2
            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
                FeedImageView.this.mLoaded = false;
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                FeedImageView.this.mLoaded = true;
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
                FeedImageView.this.mLoaded = false;
            }

            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f17) {
            }
        });
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public boolean isMarkerVisible() {
        return this.mMarker.isMarkerVisible();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mLoaded) {
            this.mMarker.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.mMarker.updateMarkerLayout();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mMarker.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.component.media.image.view.AsyncImageView, com.tencent.component.media.image.view.AsyncImageable
    public void setAsyncImage(String str, String... strArr) {
        super.setAsyncImage(str, strArr);
    }

    void setDefaultListener() {
        setAsyncImageListener(defaultListener);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarker(int i3) {
        this.mMarker.setMarker(i3);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerMatrix(Matrix matrix) {
        this.mMarker.setMarkerMatrix(matrix);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerPaddingOffset(int i3, int i16) {
        this.mMarker.setMarkerPaddingOffset(i3, i16);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerPosition(int i3) {
        this.mMarker.setMarkerPosition(i3);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerScaleType(int i3) {
        this.mMarker.setMarkerScaleType(i3);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerSize(int i3, int i16) {
        this.mMarker.setMarkerSize(i3, i16);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerVisible(boolean z16) {
        this.mMarker.setMarkerVisible(z16);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarkerVisibleWhenSelected(boolean z16) {
        this.mMarker.setMarkerVisibleWhenSelected(z16);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setOnMarkerClickListener(Markable.OnMarkerClickListener onMarkerClickListener) {
        this.mMarker.setOnMarkerClickListener(onMarkerClickListener);
    }

    @Override // com.qzone.module.feedcomponent.view.Markable
    public void setMarker(Drawable drawable) {
        this.mMarker.setMarker(drawable);
    }

    public FeedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageType = ImageType.NORMAL;
        init(context, attributeSet);
        setDefaultListener();
        setContentDescription("\u56fe\u7247");
    }

    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (drawable != null && isHardwareAccelerated()) {
            if (drawable instanceof SpecifiedDrawable) {
                SpecifiedDrawable specifiedDrawable = (SpecifiedDrawable) drawable;
                intrinsicWidth = specifiedDrawable.getOrginalWidth();
                intrinsicHeight = specifiedDrawable.getOriginalHeight();
            } else {
                intrinsicWidth = drawable.getIntrinsicWidth();
                intrinsicHeight = drawable.getIntrinsicHeight();
            }
            int layerType = getLayerType();
            if (intrinsicWidth > 2048 || intrinsicHeight > 2048) {
                if (layerType != 1) {
                    setLayerType(1, null);
                }
            } else if (layerType == 1) {
                setLayerType(0, null);
            }
        }
        super.setImageDrawable(drawable);
    }

    public void setImageType(ImageType imageType) {
        if (imageType == null) {
            imageType = ImageType.NORMAL;
        }
        this.mImageType = imageType;
        switch (AnonymousClass3.$SwitchMap$com$qzone$module$feedcomponent$view$FeedImageView$ImageType[imageType.ordinal()]) {
            case 1:
                setGifMark(false);
                return;
            case 2:
                setGifMark(true);
                return;
            case 3:
                setMarkerVisible(true);
                setMarker(j.h(PlayerResources.ViewId.CONTROLLER_PROGRESS));
                setMarkerPosition(4);
                setMarkerPaddingOffset(this.mPaddingXOffset, this.mPaddingYOffset);
                return;
            case 4:
            case 5:
                setMarkerVisible(true);
                setMarker(j.h(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT));
                setMarkerPosition(1);
                return;
            case 6:
                setMarkerVisible(true);
                setMarker(j.h(PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT));
                setMarkerPosition(1);
                return;
            case 7:
                setMarkerVisible(true);
                setMarker(j.h(PlayerResources.ViewId.EXTENDED_VIEW_NAME_PLUS_HEAD));
                setMarkerPosition(1);
                return;
            default:
                return;
        }
    }

    protected void setGifMark(boolean z16) {
        if (z16) {
            setMarkerVisible(true);
            setMarker(j.h(555));
            setMarkerPosition(4);
            setMarkerPaddingOffset(this.mPaddingXOffset, this.mPaddingYOffset);
            return;
        }
        setMarkerVisible(false);
        setMarker((Drawable) null);
    }

    public void setProgressGraghVisibility(boolean z16) {
    }
}
