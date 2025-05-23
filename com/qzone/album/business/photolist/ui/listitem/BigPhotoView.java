package com.qzone.album.business.photolist.ui.listitem;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.preview.view.d;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.widget.FeedImageView;
import com.tencent.component.media.image.processor.MergeProcessor;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import x4.a;

/* loaded from: classes39.dex */
public class BigPhotoView extends FrameLayout {
    protected TextView C;
    protected ImageView D;
    protected TextView E;
    protected ImageView F;
    protected int G;
    protected int H;
    protected boolean I;

    /* renamed from: d, reason: collision with root package name */
    protected FeedImageView f43603d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f43604e;

    /* renamed from: f, reason: collision with root package name */
    protected View f43605f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f43606h;

    /* renamed from: i, reason: collision with root package name */
    protected LinearLayout f43607i;

    /* renamed from: m, reason: collision with root package name */
    protected View f43608m;

    public BigPhotoView(Context context) {
        super(context);
        this.I = false;
    }

    public int a() {
        return this.H;
    }

    public int b() {
        return this.G;
    }

    public void c(Context context, int i3, int i16, boolean z16) {
        this.G = i3;
        this.H = i16;
        this.I = z16;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bhp, this);
        FeedImageView feedImageView = (FeedImageView) inflate.findViewById(R.id.haj);
        this.f43603d = feedImageView;
        ViewGroup.LayoutParams layoutParams = feedImageView.getLayoutParams();
        layoutParams.width = this.G;
        layoutParams.height = this.H;
        this.f43603d.setLayoutParams(layoutParams);
        this.f43603d.setAsyncPriority(true);
        this.f43604e = (LinearLayout) inflate.findViewById(R.id.fxs);
        this.f43605f = inflate.findViewById(R.id.fxq);
        this.f43606h = (TextView) inflate.findViewById(R.id.fxr);
        this.f43607i = (LinearLayout) inflate.findViewById(R.id.b3j);
        this.f43608m = inflate.findViewById(R.id.f164848b31);
        this.C = (TextView) inflate.findViewById(R.id.b3e);
        this.F = (ImageView) inflate.findViewById(R.id.a8l);
        this.D = (ImageView) inflate.findViewById(R.id.a8m);
        this.E = (TextView) inflate.findViewById(R.id.a8n);
    }

    public void d() {
        this.f43603d.cancelAsyncLoadImage();
        this.f43603d.setImageDrawable(null);
    }

    public void f(a aVar, Rect rect, PhotoCacheData photoCacheData, int i3, int i16) {
        PictureUrl pictureUrl;
        int i17;
        int i18;
        VideoInfo videoInfo;
        this.G = i3;
        this.H = i16;
        if (photoCacheData.isGif()) {
            if (com.qzone.album.env.common.a.m().j()) {
                this.f43603d.setImageType(0);
                this.f43603d.setNeedGifStream(true);
            } else {
                this.f43603d.setImageType(1);
                this.f43603d.setIconPosition(5);
                this.f43603d.setNeedGifStream(false);
            }
        } else {
            this.f43603d.setImageType(0);
            this.f43603d.setNeedGifStream(false);
        }
        this.f43603d.setVisibility(0);
        this.f43603d.setImageDrawable(null);
        if (photoCacheData.isVideo()) {
            VideoInfo videoInfo2 = photoCacheData.videodata;
            pictureUrl = videoInfo2 != null ? videoInfo2.bigUrl : null;
            this.F.setVisibility(0);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            if (TextUtils.isEmpty(photoCacheData.clientKey) && (videoInfo = photoCacheData.videodata) != null) {
                this.E.setText(VideoInfo.getShownTimeFromNumeric(videoInfo.videoTime));
            } else {
                this.E.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumVideoProcessing", "\u89c6\u9891\u5904\u7406\u4e2d..."));
            }
        } else {
            PictureItem pictureItem = photoCacheData.picItem;
            pictureUrl = pictureItem != null ? pictureItem.bigUrl : null;
            this.F.setVisibility(8);
            this.D.setVisibility(8);
            this.E.setVisibility(8);
        }
        if (pictureUrl != null && (i17 = pictureUrl.width) > 0 && (i18 = pictureUrl.height) > 0) {
            int i19 = (int) (i18 * (this.G / i17));
            this.H = i19;
            if (i19 > aVar.getResources().getDisplayMetrics().heightPixels && !photoCacheData.isVideo()) {
                this.H = aVar.getResources().getDisplayMetrics().heightPixels;
                this.f43603d.setImageType(2);
                this.f43603d.setIconPosition(1);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f43603d.getLayoutParams();
        marginLayoutParams.width = this.G;
        marginLayoutParams.height = this.H;
        marginLayoutParams.leftMargin = rect.left;
        marginLayoutParams.topMargin = rect.top;
        marginLayoutParams.rightMargin = rect.right;
        marginLayoutParams.bottomMargin = rect.bottom;
        this.f43603d.setLayoutParams(marginLayoutParams);
        this.f43603d.setAsyncClipSize(this.G, this.H);
        this.f43603d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (pictureUrl != null) {
            if (photoCacheData.isGif()) {
                this.f43603d.setAsyncImageProcessor(new NewGifDrawableSpecifiedRegionProcessor(this.G, this.H, QzoneConfig.getInstance().getGifDisplayConfig()));
            } else {
                PictureItem pictureItem2 = photoCacheData.picItem;
                if (pictureItem2.pivotXRate != 0.0f || pictureItem2.pivotYRate != 0.0f) {
                    MergeProcessor mergeProcessor = new MergeProcessor();
                    mergeProcessor.addProcessor(new d());
                    int i26 = this.G;
                    int i27 = this.H;
                    PictureItem pictureItem3 = photoCacheData.picItem;
                    mergeProcessor.addProcessor(new SpecifiedSizeCropByPivotProcessor(i26, i27, pictureItem3.pivotXRate, pictureItem3.pivotYRate));
                    this.f43603d.setAsyncImageProcessor(mergeProcessor);
                }
            }
            this.f43603d.setAsyncImage(pictureUrl.url);
            return;
        }
        this.f43603d.setImageDrawable(null);
    }

    public BigPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = false;
    }

    public void e(a aVar, PhotoCacheData photoCacheData) {
        PictureUrl pictureUrl;
        int i3;
        int i16;
        if (photoCacheData == null) {
            this.f43603d.setVisibility(4);
            return;
        }
        if (photoCacheData.isGif()) {
            if (com.qzone.album.env.common.a.m().j()) {
                this.f43603d.setImageType(12);
                this.f43603d.setNeedGifStream(true);
            } else {
                this.f43603d.setImageType(1);
                this.f43603d.setIconPosition(5);
                this.f43603d.setNeedGifStream(false);
            }
        } else {
            this.f43603d.setImageType(0);
            this.f43603d.setNeedGifStream(false);
        }
        this.f43603d.setVisibility(0);
        this.f43603d.setImageDrawable(null);
        this.f43603d.setDefaultImage(R.drawable.fyy);
        if (photoCacheData.picItem != null) {
            if (photoCacheData.isVideo()) {
                pictureUrl = photoCacheData.videodata.bigUrl;
                this.F.setVisibility(0);
                this.D.setVisibility(0);
                this.E.setVisibility(0);
                this.E.setText(VideoInfo.getShownTimeFromNumeric(photoCacheData.videodata.videoTime));
            } else {
                pictureUrl = photoCacheData.picItem.bigUrl;
                this.F.setVisibility(8);
                this.D.setVisibility(8);
                this.E.setVisibility(8);
            }
            if (pictureUrl != null && (i3 = pictureUrl.width) > 0 && (i16 = pictureUrl.height) > 0) {
                this.H = (int) (i16 * (this.G / i3));
                if (aVar != null && aVar.getResources() != null && aVar.getResources().getDisplayMetrics() != null && this.H > aVar.getResources().getDisplayMetrics().heightPixels && !photoCacheData.isVideo()) {
                    this.H = aVar.getResources().getDisplayMetrics().heightPixels;
                    this.f43603d.setImageType(2);
                    this.f43603d.setIconPosition(5);
                }
            }
        } else {
            pictureUrl = null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f43603d.getLayoutParams();
        b.a("BigPhotoView", "mImageHeight:" + this.H);
        layoutParams.width = this.G;
        layoutParams.height = this.H;
        if (aVar != null && aVar.g() != null && aVar.g().isLoveAlbum()) {
            layoutParams.leftMargin = u4.a.z().o(15.0f);
        } else {
            layoutParams.addRule(13);
        }
        this.f43603d.setLayoutParams(layoutParams);
        this.f43603d.setAsyncClipSize(this.G, this.H);
        this.f43603d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (pictureUrl != null) {
            if (photoCacheData.isGif()) {
                this.f43603d.setAsyncImageProcessor(new NewGifDrawableSpecifiedRegionProcessor(this.G, this.H, QzoneConfig.getInstance().getGifDisplayConfig()));
            } else {
                PictureItem pictureItem = photoCacheData.picItem;
                if (pictureItem.pivotXRate != 0.0f || pictureItem.pivotYRate != 0.0f) {
                    MergeProcessor mergeProcessor = new MergeProcessor();
                    mergeProcessor.addProcessor(new d());
                    int i17 = this.G;
                    int i18 = this.H;
                    PictureItem pictureItem2 = photoCacheData.picItem;
                    mergeProcessor.addProcessor(new SpecifiedSizeCropByPivotProcessor(i17, i18, pictureItem2.pivotXRate, pictureItem2.pivotYRate));
                    this.f43603d.setAsyncImageProcessor(mergeProcessor);
                }
            }
            b.a("BigPhotoView", "BigTravelUrl:" + pictureUrl.url);
            this.f43603d.setAsyncImage(pictureUrl.url);
            return;
        }
        this.f43603d.setImageDrawable(null);
    }

    public void g(PhotoCacheData photoCacheData, View.OnClickListener onClickListener) {
        if (photoCacheData == null) {
            return;
        }
        int i3 = photoCacheData.cmtnum;
        if (i3 > 0) {
            if (i3 > 99) {
                this.C.setText("99+");
            } else {
                this.C.setText(photoCacheData.cmtnum + "");
            }
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        this.f43607i.setOnClickListener(onClickListener);
    }

    public void h(a aVar, PhotoCacheData photoCacheData, View.OnClickListener onClickListener) {
        if (photoCacheData == null) {
            return;
        }
        int i3 = photoCacheData.likenum;
        if (i3 > 0) {
            if (i3 > 99) {
                this.f43606h.setText("99+");
            } else {
                this.f43606h.setText(photoCacheData.likenum + "");
            }
            this.f43606h.setVisibility(0);
        } else {
            this.f43606h.setVisibility(8);
        }
        if (photoCacheData.mylike == 1) {
            this.f43605f.setBackgroundDrawable(aVar.getResources().getDrawable(R.drawable.fuj));
        } else {
            this.f43605f.setBackgroundDrawable(aVar.getResources().getDrawable(R.drawable.fuk));
        }
        this.f43604e.setOnClickListener(onClickListener);
    }

    public BigPhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = false;
    }
}
