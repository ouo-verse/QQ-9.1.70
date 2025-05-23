package com.tencent.mobileqq.kandian.biz.gifvideo.base.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.utils.f;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GifView extends FrameLayout {
    private static final int MAXTRYCOUNTS = 2;
    private static final String TAG = "gifvideo.GifView";
    private static Drawable mLoadingDrawable;
    private Context mContext;
    private NativeReadInjoyImageView mCoverImageView;
    protected String mCoverUrl;
    private int mGifHeight;
    private URLImageView mGifImageView;
    private String mGifUrl;
    private int mGifWidth;
    private boolean mIsBigImg;
    private NativeReadInjoyImageView mStaticZImageView;
    int mTryCounts;
    private boolean needGifUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements URLDrawable.DownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239384d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239385e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f239386f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239387h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239388i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ URLDrawable f239389m;

        a(AtomicLong atomicLong, AtomicLong atomicLong2, long j3, AtomicLong atomicLong3, AtomicLong atomicLong4, URLDrawable uRLDrawable) {
            this.f239384d = atomicLong;
            this.f239385e = atomicLong2;
            this.f239386f = j3;
            this.f239387h = atomicLong3;
            this.f239388i = atomicLong4;
            this.f239389m = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int i3) {
            if (GifView.this.shouldTryLoad()) {
                if (GifView.this.mIsBigImg) {
                    GifView.this.reloadBigImg();
                } else {
                    this.f239389m.restartDownload();
                }
                QLog.d(GifView.TAG, 1, "onLoadFialed! mIsBigImg=" + GifView.this.mIsBigImg + " w=" + GifView.this.mGifWidth + " h=" + GifView.this.mGifHeight);
                GifView gifView = GifView.this;
                gifView.mTryCounts = gifView.mTryCounts + 1;
            }
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            this.f239384d.set(System.currentTimeMillis());
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long j3) {
            this.f239385e.set(System.currentTimeMillis() - this.f239386f);
            this.f239387h.set(System.currentTimeMillis() - this.f239384d.get());
            this.f239388i.set(j3);
            QLog.d(GifView.TAG, 1, "gif download success");
        }
    }

    public GifView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsBigImg = false;
        this.mTryCounts = 1;
        this.needGifUrl = false;
        init();
    }

    private static Drawable getLoadingDrawable() {
        if (mLoadingDrawable == null) {
            mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.d7y);
        }
        return mLoadingDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideGifAnim() {
        this.mCoverImageView.setVisibility(4);
    }

    private void init() {
        this.mContext = getContext();
        this.mGifImageView = new URLImageView(this.mContext);
        this.mCoverImageView = new NativeReadInjoyImageView(this.mContext);
        this.mStaticZImageView = new NativeReadInjoyImageView(this.mContext);
        this.mGifImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mCoverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mStaticZImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.mGifImageView, -1, -1);
        addView(this.mCoverImageView, -1, -1);
        addView(this.mStaticZImageView, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadBigImg() {
        int i3 = this.mGifWidth;
        int i16 = this.mTryCounts;
        displayGif(i3 >> i16, this.mGifHeight >> i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldTryLoad() {
        return this.mTryCounts <= 2;
    }

    private void useURLDrawable(String str) throws MalformedURLException {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = this.mGifWidth;
        obtain.mRequestHeight = this.mGifHeight;
        Context context = this.mContext;
        if (context != null && context.getResources() != null) {
            obtain.mLoadingDrawable = this.mContext.getResources().getDrawable(R.drawable.d7y);
        }
        this.mStaticZImageView.setImageDrawable(URLDrawable.getDrawable(new URL(str), obtain));
    }

    private boolean willBitmapCut() {
        QLog.d(TAG, 2, "mGifHeight: + " + this.mGifHeight + " mGifWidth: " + this.mGifWidth);
        return this.mGifHeight >= 2048 || this.mGifWidth >= 2048;
    }

    public void displayCover() {
        this.mCoverImageView.setVisibility(0);
        this.mCoverImageView.setAlpha(1.0f);
    }

    public void displayGif() {
        displayGif(-1, -1);
    }

    public boolean isPlaying() {
        NativeReadInjoyImageView nativeReadInjoyImageView = this.mCoverImageView;
        return (nativeReadInjoyImageView == null || nativeReadInjoyImageView.getVisibility() == 0) ? false : true;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        displayCover();
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
        NativeReadInjoyImageView nativeReadInjoyImageView = this.mCoverImageView;
        if (nativeReadInjoyImageView == null || str == null) {
            return;
        }
        try {
            f.a(nativeReadInjoyImageView, new URL(this.mCoverUrl), getContext());
        } catch (MalformedURLException e16) {
            QLog.d(TAG, 2, e16.getMessage());
        }
    }

    public void setGifHeight(int i3) {
        this.mGifHeight = i3;
    }

    public void setGifUrl(String str) {
        if (this.needGifUrl && str != null && !str.contains("fmt=gif")) {
            setStaticImageUrl(str);
            this.mGifImageView.setURLDrawableDownListener(null);
            this.mStaticZImageView.setVisibility(0);
            this.mGifImageView.setVisibility(8);
            this.mCoverImageView.setVisibility(8);
            return;
        }
        this.mStaticZImageView.setVisibility(8);
        this.mGifImageView.setVisibility(0);
        this.mCoverImageView.setVisibility(0);
        this.mGifUrl = str;
    }

    public void setGifWidth(int i3) {
        this.mGifWidth = i3;
    }

    public void setIsBigImg(boolean z16) {
        this.mIsBigImg = z16;
    }

    public void setNeedGifUrl(boolean z16) {
        this.needGifUrl = z16;
    }

    public void setScaleType(int i3) {
        NativeReadInjoyImageView nativeReadInjoyImageView = this.mCoverImageView;
        if (nativeReadInjoyImageView != null) {
            nativeReadInjoyImageView.setScaleType(ImageBase.IMAGE_SCALE_TYPE.get(i3, ImageView.ScaleType.CENTER_CROP));
        }
        URLImageView uRLImageView = this.mGifImageView;
        if (uRLImageView != null) {
            uRLImageView.setScaleType(ImageBase.IMAGE_SCALE_TYPE.get(i3, ImageView.ScaleType.CENTER_CROP));
        }
    }

    public void setStaticImageUrl(String str) {
        if (this.mStaticZImageView == null || str == null) {
            return;
        }
        try {
            if (willBitmapCut()) {
                useURLDrawable(str);
            } else {
                f.a(this.mStaticZImageView, new URL(str), getContext());
            }
        } catch (MalformedURLException e16) {
            QLog.d(TAG, 2, e16.getMessage());
        }
    }

    private void initBigImgParams() {
        this.mTryCounts = 1;
        this.mIsBigImg = false;
    }

    public void displayGif(int i3, int i16) {
        if (TextUtils.isEmpty(this.mGifUrl) || this.mGifImageView.getVisibility() != 0) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = getLoadingDrawable();
        obtain.mFailedDrawable = getLoadingDrawable();
        if (i16 > 0 && i3 > 0) {
            obtain.mRequestHeight = i16;
            obtain.mRequestWidth = i3;
        }
        URLDrawable drawable = URLDrawable.getDrawable(this.mGifUrl, obtain);
        if (drawable.getStatus() == 1) {
            hideGifAnim();
        }
        handleDrawableLoadListener(drawable);
        this.mGifImageView.setImageDrawable(drawable);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBigImg = false;
        this.mTryCounts = 1;
        this.needGifUrl = false;
        init();
    }

    private void handleDrawableLoadListener(URLDrawable uRLDrawable) {
        if (uRLDrawable == null) {
            return;
        }
        AtomicLong atomicLong = new AtomicLong(0L);
        AtomicLong atomicLong2 = new AtomicLong(0L);
        long currentTimeMillis = System.currentTimeMillis();
        AtomicLong atomicLong3 = new AtomicLong(currentTimeMillis);
        AtomicLong atomicLong4 = new AtomicLong(0L);
        uRLDrawable.setDownloadListener(new a(atomicLong3, atomicLong, currentTimeMillis, atomicLong2, atomicLong4, uRLDrawable));
        if (this.mGifImageView != null) {
            this.mGifImageView.setURLDrawableDownListener(new b(currentTimeMillis, atomicLong3, atomicLong, atomicLong4, atomicLong2, new StringBuilder(), uRLDrawable));
        }
    }

    public GifView(Context context) {
        super(context);
        this.mIsBigImg = false;
        this.mTryCounts = 1;
        this.needGifUrl = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements URLDrawableDownListener {
        final /* synthetic */ URLDrawable C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f239390d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239391e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239392f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239393h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AtomicLong f239394i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ StringBuilder f239395m;

        b(long j3, AtomicLong atomicLong, AtomicLong atomicLong2, AtomicLong atomicLong3, AtomicLong atomicLong4, StringBuilder sb5, URLDrawable uRLDrawable) {
            this.f239390d = j3;
            this.f239391e = atomicLong;
            this.f239392f = atomicLong2;
            this.f239393h = atomicLong3;
            this.f239394i = atomicLong4;
            this.f239395m = sb5;
            this.C = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            if (GifView.this.shouldTryLoad()) {
                if (GifView.this.mIsBigImg) {
                    GifView.this.reloadBigImg();
                } else {
                    this.C.restartDownload();
                }
                QLog.d(GifView.TAG, 1, "onLoadFialed! mIsBigImg=" + GifView.this.mIsBigImg + " w=" + GifView.this.mGifWidth + " h=" + GifView.this.mGifHeight + " progress: " + ((Object) this.f239395m));
                GifView gifView = GifView.this;
                gifView.mTryCounts = gifView.mTryCounts + 1;
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            this.f239395m.append(System.currentTimeMillis() + " " + i3 + " ");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.f239390d;
            long j16 = this.f239391e.get() != 0 ? currentTimeMillis - this.f239391e.get() : j3;
            int i3 = this.f239392f.longValue() == 0 ? 1 : 0;
            QLog.d(GifView.TAG, 2, "gif status: " + i3 + " file size: " + this.f239393h + " download time: " + this.f239392f + " load time: " + j3);
            QLog.d(GifView.TAG, 2, "gif status: " + i3 + " file size: " + this.f239393h + " download time2: " + this.f239394i + " load time2: " + j16);
            GifView.this.hideGifAnim();
            QLog.d(GifView.TAG, 1, "onLoadSuccess! mIsBigImg=" + GifView.this.mIsBigImg + " w=" + GifView.this.mGifWidth + " h=" + GifView.this.mGifHeight + " progress: " + ((Object) this.f239395m));
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }
    }
}
