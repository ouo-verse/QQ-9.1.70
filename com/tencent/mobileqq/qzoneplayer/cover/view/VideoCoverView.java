package com.tencent.mobileqq.qzoneplayer.cover.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.util.image.d;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.qzoneplayer.cover.data.VideoData;
import com.tencent.mobileqq.qzoneplayer.cover.ui.AbsBaseView;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideo;
import com.tencent.mobileqq.qzoneplayer.video.FeedAutoVideoFull;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.PictureUrl;
import com.tencent.mobileqq.qzoneplayer.video.VideoPlayInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class VideoCoverView extends AbsBaseView {

    /* renamed from: c0, reason: collision with root package name */
    private static int f279340c0 = 1;

    /* renamed from: d0, reason: collision with root package name */
    private static final ColorDrawable f279341d0 = new ColorDrawable(Color.parseColor("#000000"));

    /* renamed from: e0, reason: collision with root package name */
    private static ColorDrawable f279342e0 = null;
    protected int C;
    protected int D;
    protected int E;
    private int F;
    private int G;
    private int H;
    protected ImageLoader.Options I;
    protected String J;
    protected HashMap<String, a> K;
    protected final PicListener L;
    public int M;
    protected Drawable N;
    protected String P;
    protected int Q;
    protected VideoPlayInfo R;
    protected BaseVideo S;
    protected View T;
    protected String U;
    protected OnCoverSizeChangeListener V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f279343a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f279344b0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f279345e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f279346f;

    /* renamed from: h, reason: collision with root package name */
    protected int f279347h;

    /* renamed from: i, reason: collision with root package name */
    protected int f279348i;

    /* renamed from: m, reason: collision with root package name */
    protected int f279349m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f279355a = 0;

        /* renamed from: b, reason: collision with root package name */
        ImageLoader.Options f279356b = null;

        /* renamed from: c, reason: collision with root package name */
        String f279357c = null;

        public a() {
        }
    }

    public VideoCoverView(Context context) {
        this(context, null);
    }

    protected static int j() {
        int i3 = f279340c0 + 1;
        f279340c0 = i3;
        return i3;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.cover.ui.AbsBaseView
    protected synchronized void a() {
        VideoData.BaseVideoCoverData baseVideoCoverData;
        int i3;
        int i16;
        String str;
        ImageUrl imageUrl;
        ImageProcessor imageProcessor;
        int i17;
        int i18;
        int i19;
        if (this.f279343a0) {
            PlayerUtils.log(4, "BaseVideoCoverView", "onUpdate mPos=" + this.W);
        }
        VideoData videoData = this.f279331d;
        if (videoData != null && (baseVideoCoverData = videoData.baseVideoCoverData) != null) {
            PictureUrl pictureUrl = baseVideoCoverData.picUrl;
            final String str2 = baseVideoCoverData.timeDes;
            final VideoPlayInfo videoPlayInfo = baseVideoCoverData.videoPlayInfo;
            onRecycled();
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverView.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoCoverView videoCoverView = VideoCoverView.this;
                    videoCoverView.P = str2;
                    videoCoverView.Q = 0;
                    videoCoverView.R = videoPlayInfo;
                }
            });
            if (this.f279346f) {
                i3 = FeedVideoEnv.externalFunc.getCommentWidth_Rec();
                i16 = (int) ((i3 * 9.0f) / 16.0f);
            } else {
                i3 = 0;
                i16 = 0;
            }
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            int j3 = j();
            this.D = j3;
            if (pictureUrl != null) {
                str = pictureUrl.url;
                imageUrl = pictureUrl.imgUrl;
            } else {
                str = null;
                imageUrl = null;
            }
            obtain.obj = Integer.valueOf(j3);
            int i26 = i();
            if (!this.f279345e) {
                if (k()) {
                    imageProcessor = new RoundCornerProcessor(g());
                } else {
                    imageProcessor = videoPlayInfo.processor;
                }
                obtain.extraProcessor = imageProcessor;
                if (pictureUrl != null && (videoPlayInfo.width == 0 || videoPlayInfo.height == 0)) {
                    int i27 = pictureUrl.width;
                    if (i27 != 0 && (i17 = pictureUrl.height) != 0) {
                        obtain.clipWidth = i27;
                        obtain.clipHeight = i17;
                    }
                    obtain.clipWidth = i26;
                    obtain.clipHeight = i26;
                } else if (this.f279346f) {
                    int i28 = videoPlayInfo.width;
                    int i29 = videoPlayInfo.height;
                    if (i28 >= i29) {
                        obtain.clipHeight = (int) ((i3 * i29) / i28);
                        obtain.clipWidth = i3;
                    } else {
                        obtain.clipWidth = (i28 * i16) / i29;
                        obtain.clipHeight = i16;
                    }
                    this.G = obtain.clipWidth;
                    this.H = obtain.clipHeight;
                } else {
                    obtain.clipWidth = videoPlayInfo.width;
                    obtain.clipHeight = videoPlayInfo.height;
                }
            } else if (pictureUrl != null && (i18 = pictureUrl.width) != 0 && (i19 = pictureUrl.height) != 0) {
                BaseVideo baseVideo = this.S;
                if (baseVideo != null) {
                    baseVideo.setVideoOriginalSize(i18, i19);
                }
                float f16 = i18 < i19 ? (((i19 - i18) / 3.0f) + (i18 / 2.0f)) / i19 : 0.5f;
                int min = Math.min(i18, i19);
                obtain.extraProcessor = new NormalFeedImageProcessor(min, min, 0.5f, f16);
                obtain.clipWidth = min;
                obtain.clipHeight = min;
            } else {
                obtain.extraProcessor = new NormalFeedImageProcessor(i26, i26);
                obtain.clipWidth = i26;
                obtain.clipHeight = i26;
            }
            obtain.preferQuality = false;
            if (str != null) {
                if (this.K.get(str) == null) {
                    Drawable loadImage = ImageLoader.getInstance(null).loadImage(imageUrl, str, this.L, obtain);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("preloadcover mPos=");
                    sb5.append(this.W);
                    sb5.append("[");
                    sb5.append(obtain.clipWidth);
                    sb5.append(",");
                    sb5.append(obtain.clipHeight);
                    sb5.append("], usecache=");
                    sb5.append(loadImage != null);
                    PlayerUtils.log(4, "BaseVideoCoverView", sb5.toString());
                    this.J = str;
                    this.I = obtain;
                    if (loadImage != null) {
                        this.N = loadImage;
                        this.K.remove(str);
                    } else {
                        a aVar = new a();
                        aVar.f279356b = obtain;
                        aVar.f279357c = str;
                        aVar.f279355a = this.M;
                        this.K.put(str, aVar);
                    }
                }
            } else {
                PlayerUtils.log(6, "BaseVideoCoverView", "signUrl is null");
            }
            Drawable drawable = this.N;
            if (drawable == null) {
                this.N = h();
                if (!this.f279346f) {
                    i3 = obtain.clipWidth;
                    i16 = obtain.clipHeight;
                }
            } else if (!this.f279346f) {
                i16 = drawable.getIntrinsicHeight();
                i3 = this.N.getIntrinsicWidth();
            }
            if (this.f279345e) {
                i3 = this.F;
                i16 = i3;
            }
            l(i3, i16);
            forceLayout();
        }
    }

    protected void f(Canvas canvas) {
        if (this.f279343a0) {
            PlayerUtils.log(4, "BaseVideoCoverView", "drawCover pos=" + this.W);
        }
        if (this.N == null) {
            PlayerUtils.log(5, "BaseVideoCoverView", "drawCover singleDrawable is null");
            if (this.f279344b0) {
                canvas.save();
                f279342e0.setBounds(0, 0, this.f279349m, this.C);
                f279342e0.draw(canvas);
                canvas.restore();
                return;
            }
            return;
        }
        if (this.f279346f) {
            canvas.save();
            ColorDrawable colorDrawable = f279341d0;
            colorDrawable.setBounds(0, 0, this.f279349m, this.C);
            colorDrawable.draw(canvas);
            canvas.translate((this.f279349m - this.G) / 2, (this.C - this.H) / 2);
            Drawable drawable = this.N;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.G, this.H);
                this.N.draw(canvas);
            }
            canvas.restore();
        } else {
            synchronized (this) {
                if (this.f279344b0) {
                    canvas.save();
                    f279342e0.setBounds(0, 0, this.f279349m, this.C);
                    f279342e0.draw(canvas);
                    canvas.restore();
                    return;
                }
                if (this.N != null && canvas != null) {
                    if (this.f279349m == 0 || this.C == 0) {
                        PlayerUtils.log(4, "BaseVideoCoverView", "illegal cover width height mPos" + this.W);
                    }
                    this.N.setBounds(0, 0, this.f279349m, this.C);
                    this.N.draw(canvas);
                }
            }
        }
        if (d.f(this.U)) {
            if (d.g(this.U)) {
                String j3 = d.j(this.U);
                if (TextUtils.isEmpty(j3)) {
                    return;
                }
                int i3 = this.C;
                d.a(canvas, j3, i3, i3, 0);
                return;
            }
            d.b(canvas, this.f279349m, this.C, this.U, 0);
        }
    }

    protected int g() {
        return 0;
    }

    public int getPicHeight() {
        return this.f279347h;
    }

    public int getPicWidth() {
        return this.f279348i;
    }

    protected Drawable h() {
        return FeedVideoEnv.DEFAULT_BACKGROUND;
    }

    public int i() {
        int i3;
        if (o() && FeedVideoEnv.externalFunc.isPicBigMode()) {
            i3 = FeedVideoEnv.SCREEN_WIDTH;
        } else {
            i3 = FeedVideoEnv.DEFAULT_WIDTH;
        }
        int i16 = this.E;
        return i16 == 0 ? i3 : i16;
    }

    protected boolean k() {
        return false;
    }

    protected void l(int i3, int i16) {
        int i17 = i();
        if (!this.f279345e) {
            this.f279348i = i17;
            this.f279347h = (int) ((i17 / i3) * i16);
        } else {
            this.f279348i = i3;
            this.f279347h = i16;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverView.2
            @Override // java.lang.Runnable
            public void run() {
                VideoCoverView.this.requestLayout();
            }
        });
        setRelativeHeight(this.f279347h);
    }

    public void m(String str) {
        HashMap<String, a> hashMap = this.K;
        if (hashMap == null || hashMap.get(str) == null) {
            return;
        }
        a aVar = this.K.get(str);
        if (aVar.f279357c == null || aVar.f279356b == null) {
            return;
        }
        ImageLoader.getInstance(null).cancel(aVar.f279357c, this.L, aVar.f279356b);
        this.K.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i3) {
        this.W = i3;
    }

    protected boolean o() {
        VideoData.BaseVideoCoverData baseVideoCoverData;
        VideoPlayInfo videoPlayInfo;
        VideoData videoData = this.f279331d;
        return videoData == null || (baseVideoCoverData = videoData.baseVideoCoverData) == null || (videoPlayInfo = baseVideoCoverData.videoPlayInfo) == null || TextUtils.isEmpty(videoPlayInfo.getDisplayRemark());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        BaseVideo baseVideo = this.S;
        if (baseVideo == null || !baseVideo.isShowCoverImage()) {
            return;
        }
        f(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            int i17 = this.f279348i;
            this.f279349m = i17;
            int i18 = this.f279347h;
            this.C = i18;
            OnCoverSizeChangeListener onCoverSizeChangeListener = this.V;
            if (onCoverSizeChangeListener != null) {
                onCoverSizeChangeListener.onChangeSize(i17, i18);
            }
            setMeasuredDimension(this.f279348i, this.f279347h);
        } else {
            this.f279349m = View.getDefaultSize(this.f279348i, i3);
            int defaultSize = View.getDefaultSize(this.f279347h, i16);
            this.C = defaultSize;
            OnCoverSizeChangeListener onCoverSizeChangeListener2 = this.V;
            if (onCoverSizeChangeListener2 != null) {
                onCoverSizeChangeListener2.onChangeSize(this.f279349m, defaultSize);
            }
            setMeasuredDimension(View.getDefaultSize(this.f279348i, i3), View.getDefaultSize(this.f279347h, i16));
        }
        if (this.f279343a0) {
            PlayerUtils.log(4, "BaseVideoCoverView", "onMeasure setCoverWidthHeight mPos=" + this.W + " [" + this.f279349m + "," + this.C + "]");
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.Recycleable
    public synchronized void onRecycled() {
        String str = this.J;
        if (str != null) {
            m(str);
        }
        this.f279331d = null;
        this.I = null;
        this.J = null;
        this.N = null;
        this.P = null;
    }

    public void setBaseVideo(BaseVideo baseVideo) {
        this.S = baseVideo;
    }

    public void setLikeFriendVideo(boolean z16) {
        this.f279346f = z16;
    }

    public void setMaxWidth(int i3) {
        this.E = i3;
    }

    public void setOnCoverSizeChangeListener(OnCoverSizeChangeListener onCoverSizeChangeListener) {
        this.V = onCoverSizeChangeListener;
    }

    public void setRelativeHeight(final int i3) {
        BaseVideo baseVideo = this.S;
        if (baseVideo == null || !(baseVideo instanceof FeedAutoVideoFull)) {
            return;
        }
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams;
                View view = VideoCoverView.this.T;
                if (view == null || (layoutParams = view.getLayoutParams()) == null) {
                    return;
                }
                int i16 = layoutParams.height;
                int i17 = i3;
                if (i16 != i17) {
                    layoutParams.width = -1;
                    layoutParams.height = i17;
                    VideoCoverView.this.T.setLayoutParams(layoutParams);
                }
            }
        });
    }

    public void setRelativeView(View view) {
        this.T = view;
    }

    public void setVideoPicMixMode(boolean z16) {
        this.f279345e = z16;
    }

    public void setVideoPicMixModeClipSize(int i3) {
        this.F = i3;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class PicListener implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<VideoCoverView> f279353d;

        public PicListener(VideoCoverView videoCoverView) {
            this.f279353d = new WeakReference<>(videoCoverView);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            WeakReference<VideoCoverView> weakReference;
            final VideoCoverView videoCoverView;
            if (options == null || (weakReference = this.f279353d) == null || (videoCoverView = weakReference.get()) == null) {
                return;
            }
            videoCoverView.U = options.errCode;
            PlayerUtils.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.qzoneplayer.cover.view.VideoCoverView.PicListener.1
                @Override // java.lang.Runnable
                public void run() {
                    videoCoverView.invalidate();
                }
            });
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            Object obj;
            WeakReference<VideoCoverView> weakReference;
            VideoCoverView videoCoverView;
            if (options == null || (obj = options.obj) == null || !(obj instanceof Integer) || drawable == null || (weakReference = this.f279353d) == null || (videoCoverView = weakReference.get()) == null) {
                return;
            }
            if (!TextUtils.isEmpty(options.errCode)) {
                videoCoverView.U = options.errCode;
            } else {
                videoCoverView.U = null;
            }
            if (videoCoverView.D == ((Integer) options.obj).intValue()) {
                videoCoverView.N = drawable;
                if (!videoCoverView.f279345e) {
                    if (videoCoverView.f279346f) {
                        return;
                    }
                    videoCoverView.l(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    return;
                }
                videoCoverView.l(videoCoverView.F, videoCoverView.F);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public VideoCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f279345e = false;
        this.f279346f = false;
        this.D = -1;
        this.K = new HashMap<>();
        this.M = 1;
        this.N = h();
        this.W = -1;
        this.f279343a0 = false;
        this.f279344b0 = false;
        this.L = new PicListener(this);
        if (this.f279344b0) {
            f279342e0 = new ColorDrawable(Color.parseColor("#ffff0000"));
        }
    }

    public void reset() {
        this.E = 0;
        this.f279347h = 0;
        this.f279348i = 0;
        this.C = 0;
        this.f279349m = 0;
        this.R = null;
        this.f279331d = null;
        if (this.f279343a0) {
            PlayerUtils.log(4, "BaseVideoCoverView", "reset mPos=" + this.W);
        }
    }
}
