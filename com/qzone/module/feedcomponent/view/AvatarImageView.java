package com.qzone.module.feedcomponent.view;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.canvasui.widget.AsyncCanvasImageArea;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.MergeProcessor;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.view.AsyncImageView;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AvatarImageView extends AsyncImageView {
    static final int AVATAR_EXTERNAL_CAPACITY = 500;
    static final String AVATAR_FILE_CACHE_NAME = "avatar";
    static final int AVATAR_INTERNAL_CAPACITY = 300;
    int mAvatarMask;
    int mDefaultAvatar;
    List<ImageProcessor> mExtraProcessors;
    private int mIconHeight;
    ImageProcessor mProcessor;
    private Drawable mRightIconDrawable;
    static final int DEFAULT_AVATAR = j.h(PlayerResources.ViewId.CURRUNT_TIME);
    static final RoundCornerProcessor DEFAULT_ROUND_CORNER_PROCESSOR = new RoundCornerProcessor(5.0f);
    static final OvalProcessor DEFAULT_OVAL_PROCESSOR = new OvalProcessor();
    static HashMap<Integer, Drawable> ovalResourcesDrawableMap = new HashMap<>();
    static final ImageLoader.Options sOptions = new ImageLoader.Options();

    public AvatarImageView(Context context) {
        super(context);
        this.mExtraProcessors = new ArrayList();
        this.mRightIconDrawable = null;
        this.mIconHeight = AsyncCanvasImageArea.DEFAULT_RIGHT_ICON_HEIGHT;
        init();
    }

    static void removeAvatarCache(Context context, long j3, short s16) {
        String P = i.H().P(Long.valueOf(j3));
        if (P == null) {
            return;
        }
        ImageLoader.getInstance(context).clear(P);
        ImageLoader.getInstance(context).removeImageFile(P);
    }

    public void addExtraProcessor(ImageProcessor imageProcessor) {
        this.mExtraProcessors.add(imageProcessor);
        setAsyncImageProcessor(combineExtraProcessor(this.mProcessor));
        handleProcessorChange();
    }

    ImageProcessor combineExtraProcessor(ImageProcessor imageProcessor) {
        if (this.mExtraProcessors.size() <= 0) {
            return imageProcessor;
        }
        MergeProcessor mergeProcessor = new MergeProcessor();
        mergeProcessor.addProcessor(imageProcessor);
        Iterator<ImageProcessor> it = this.mExtraProcessors.iterator();
        while (it.hasNext()) {
            mergeProcessor.addProcessor(it.next());
        }
        return mergeProcessor;
    }

    void handleProcessorChange() {
        int i3 = this.mDefaultAvatar;
        if (i3 != 0) {
            setDefaultAvatar(0);
            setDefaultAvatar(i3);
        }
        int i16 = this.mAvatarMask;
        if (i16 != 0) {
            setAvatarMask(0);
            setAvatarMask(i16);
        }
    }

    void init() {
        setOval();
        setDefaultAvatar(DEFAULT_AVATAR);
        setAvatarMask(j.h(703));
        setAsyncPreferQuality(true);
        setAsyncAlwaysLoad(true);
    }

    public void loadAvatar(long j3, short s16, long j16) {
        String O = i.H().O(j3, s16, String.valueOf(j16));
        if (!TextUtils.isEmpty(O)) {
            b.e("AvatarImageView", "load avatar url " + O);
        }
        loadAvatar(O);
    }

    public void loadDefaultAvatar() {
        int i3 = this.mDefaultAvatar;
        if (i3 != 0) {
            ImageProcessor combineExtraProcessor = combineExtraProcessor(this.mProcessor);
            if (combineExtraProcessor != null) {
                if (combineExtraProcessor == DEFAULT_OVAL_PROCESSOR) {
                    Drawable drawable = ovalResourcesDrawableMap.get(Integer.valueOf(i3));
                    if (drawable == null) {
                        drawable = combineExtraProcessor.process(getResources().getDrawable(i3));
                        ovalResourcesDrawableMap.put(Integer.valueOf(i3), drawable);
                    }
                    setImageDrawable(drawable);
                    return;
                }
                setImageDrawable(combineExtraProcessor.process(getResources().getDrawable(i3)));
                return;
            }
            setImageResource(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.view.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        resetBounds();
        super.onDraw(canvas);
        Drawable drawable = this.mRightIconDrawable;
        if (drawable == null || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        int intrinsicWidth = (this.mRightIconDrawable.getIntrinsicWidth() * this.mIconHeight) / this.mRightIconDrawable.getIntrinsicHeight();
        int i3 = this.mIconHeight;
        int width = getWidth();
        int height = getHeight();
        this.mRightIconDrawable.setBounds(width - intrinsicWidth, height - i3, width, height);
        this.mRightIconDrawable.draw(canvas);
    }

    public void removeAvatar() {
        String asyncImage = getAsyncImage();
        if (asyncImage != null) {
            ImageLoader.getInstance(getContext()).clear(asyncImage);
            ImageLoader.getInstance(getContext()).removeImageFile(asyncImage);
        }
        setAsyncImage(null);
    }

    protected void resetBounds() {
        if (getDrawable() != null) {
            int intrinsicWidth = getDrawable().getIntrinsicWidth();
            int intrinsicHeight = getDrawable().getIntrinsicHeight();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (intrinsicWidth > 0 && intrinsicHeight > 0 && ImageView.ScaleType.FIT_XY != getScaleType()) {
                getDrawable().setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            } else {
                getDrawable().setBounds(0, 0, width, height);
            }
        }
    }

    public void setAvatarMask(int i3) {
        if (this.mAvatarMask != i3) {
            ImageProcessor combineExtraProcessor = combineExtraProcessor(this.mProcessor);
            Drawable drawable = i3 != 0 ? getResources().getDrawable(i3) : null;
            if (drawable != null && combineExtraProcessor != null) {
                if (combineExtraProcessor == DEFAULT_OVAL_PROCESSOR) {
                    Drawable drawable2 = ovalResourcesDrawableMap.get(Integer.valueOf(i3));
                    if (drawable2 == null) {
                        Drawable process = combineExtraProcessor.process(drawable);
                        ovalResourcesDrawableMap.put(Integer.valueOf(i3), process);
                        drawable = process;
                    } else {
                        drawable = drawable2;
                    }
                } else {
                    drawable = combineExtraProcessor.process(drawable);
                }
            }
            if (drawable == null) {
                setForeground((Drawable) null);
            } else {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
                setForeground(stateListDrawable);
            }
            this.mAvatarMask = i3;
        }
    }

    public void setDefaultAvatar(int i3) {
        if (this.mDefaultAvatar != i3) {
            ImageProcessor combineExtraProcessor = combineExtraProcessor(this.mProcessor);
            if (i3 != 0 && combineExtraProcessor != null) {
                if (combineExtraProcessor == DEFAULT_OVAL_PROCESSOR) {
                    Drawable drawable = ovalResourcesDrawableMap.get(Integer.valueOf(i3));
                    if (drawable == null) {
                        drawable = combineExtraProcessor.process(getResources().getDrawable(i3));
                        ovalResourcesDrawableMap.put(Integer.valueOf(i3), drawable);
                    }
                    setAsyncDefaultImage(drawable);
                } else {
                    setAsyncDefaultImage(combineExtraProcessor.process(getResources().getDrawable(i3)));
                }
            } else {
                setAsyncDefaultImage(i3);
            }
            this.mDefaultAvatar = i3;
        }
    }

    public void setOval() {
        ImageProcessor imageProcessor = this.mProcessor;
        OvalProcessor ovalProcessor = DEFAULT_OVAL_PROCESSOR;
        this.mProcessor = ovalProcessor;
        setAsyncImageProcessor(ovalProcessor);
        if (imageProcessor != this.mProcessor) {
            handleProcessorChange();
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
        this.mRightIconDrawable = ImageLoader.getInstance(getContext()).loadImage(imageUrl, str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.module.feedcomponent.view.AvatarImageView.1
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, Drawable drawable, ImageLoader.Options options) {
                AvatarImageView.this.mRightIconDrawable = drawable;
                AvatarImageView.this.postInvalidate();
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
        }, null);
        postInvalidate();
    }

    public void setRoundCornerRadius(float f16) {
        ImageProcessor imageProcessor = this.mProcessor;
        if (f16 <= 0.0f) {
            this.mProcessor = null;
        } else {
            RoundCornerProcessor roundCornerProcessor = DEFAULT_ROUND_CORNER_PROCESSOR;
            if (f16 == roundCornerProcessor.getRadius()) {
                this.mProcessor = roundCornerProcessor;
            } else {
                ImageProcessor imageProcessor2 = this.mProcessor;
                if (imageProcessor2 != null && (imageProcessor2 instanceof RoundCornerProcessor) && imageProcessor2 != roundCornerProcessor) {
                    ((RoundCornerProcessor) imageProcessor2).setRadius(f16);
                } else {
                    this.mProcessor = new RoundCornerProcessor(f16);
                }
            }
        }
        setAsyncImageProcessor(this.mProcessor);
        if (imageProcessor != this.mProcessor) {
            handleProcessorChange();
        }
    }

    public void loadAvatar(long j3, short s16) {
        String O = i.H().O(j3, s16, null);
        if (!TextUtils.isEmpty(O)) {
            b.e("AvatarImageView", "load avatar url " + O);
        }
        loadAvatar(O);
    }

    public AvatarImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExtraProcessors = new ArrayList();
        this.mRightIconDrawable = null;
        this.mIconHeight = AsyncCanvasImageArea.DEFAULT_RIGHT_ICON_HEIGHT;
        init();
    }

    public void loadAvatar(long j3) {
        loadAvatar(i.H().P(Long.valueOf(j3)));
    }

    public AvatarImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mExtraProcessors = new ArrayList();
        this.mRightIconDrawable = null;
        this.mIconHeight = AsyncCanvasImageArea.DEFAULT_RIGHT_ICON_HEIGHT;
        init();
    }

    public void loadAvatar(String str) {
        PictureUrl.calculateAvaterImageUrl(str);
        setAsyncImage(str);
    }
}
