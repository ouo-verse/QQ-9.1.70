package com.qzone.album.business.photolist.ui.listitem;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.i;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.widget.FeedImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzone.picload.c;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import common.config.service.QzoneConfig;
import g4.d;

/* loaded from: classes39.dex */
public class PhotoView extends RelativeLayout {
    protected ImageView C;
    protected TextView D;
    protected RelativeLayout E;
    protected NumberCheckBox F;
    protected CheckBox G;
    protected int H;
    protected int I;
    private boolean J;
    private long K;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f43645d;

    /* renamed from: e, reason: collision with root package name */
    public FeedImageView f43646e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f43647f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f43648h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f43649i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f43650m;

    public PhotoView(Context context) {
        super(context);
        this.J = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_LIST_VISIBLE_STATISTIC, 1) > 0;
        this.K = 0L;
    }

    private int a(x4.a aVar, PhotoCacheData photoCacheData) {
        if (aVar.p().indexOf(photoCacheData.getBigUrl()) + 1 == 0) {
            for (int i3 = 0; i3 < aVar.p().size(); i3++) {
                if (i.a(aVar.p().get(i3)).startsWith(i.a(photoCacheData.getBigUrl()))) {
                    return i3 + 1;
                }
            }
            return 0;
        }
        return aVar.p().indexOf(photoCacheData.getBigUrl()) + 1;
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.a().i(Option.obtain().setUrl(str).setTargetView(this.f43645d).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(this.H).setRequestHeight(this.I).setLoadingDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.fyy, null)).setFailedDrawableId(R.drawable.fux), new a());
    }

    public ImageView b() {
        return this.f43645d;
    }

    public void c(Context context, int i3, int i16) {
        this.H = i3;
        this.I = i16;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bim, this);
        this.f43645d = (ImageView) inflate.findViewById(R.id.fou);
        this.f43646e = (FeedImageView) inflate.findViewById(R.id.v2x);
        this.f43647f = (ImageView) inflate.findViewById(R.id.kva);
        this.f43648h = (TextView) inflate.findViewById(R.id.kuy);
        this.f43649i = (ImageView) inflate.findViewById(R.id.kpu);
        this.f43650m = (ImageView) inflate.findViewById(R.id.f164273qc);
        this.C = (ImageView) inflate.findViewById(R.id.f164278qi);
        this.D = (TextView) inflate.findViewById(R.id.f164274qd);
        this.E = (RelativeLayout) inflate.findViewById(R.id.fq8);
        this.F = (NumberCheckBox) inflate.findViewById(R.id.fq9);
        this.G = (CheckBox) inflate.findViewById(R.id.fol);
        ViewGroup.LayoutParams layoutParams = this.f43645d.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f43645d.setLayoutParams(layoutParams);
        this.f43645d.setVisibility(0);
        this.f43646e.setVisibility(8);
    }

    public void g() {
        b().setVisibility(0);
        this.E.setVisibility(8);
        this.f43648h.setVisibility(8);
        this.f43647f.setVisibility(8);
        this.f43649i.setVisibility(8);
        this.f43650m.setVisibility(8);
        this.D.setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    public void setCheckBoxTag(Object obj) {
        this.G.setTag(obj);
    }

    public void setClickBoxImgVisibility(int i3) {
        this.E.setVisibility(i3);
    }

    public void setGone() {
        b().setVisibility(4);
        this.E.setVisibility(8);
        this.f43648h.setVisibility(8);
        this.f43647f.setVisibility(8);
        this.f43649i.setVisibility(8);
        this.f43650m.setVisibility(8);
        this.D.setVisibility(8);
    }

    public void setNumberCheckBoxTag(Object obj) {
        this.F.setTag(obj);
    }

    public void setCBClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.F.setOnClickListener(onClickListener);
            this.G.setOnClickListener(onClickListener);
            this.E.setOnClickListener(onClickListener);
        }
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_LIST_VISIBLE_STATISTIC, 1) > 0;
        this.K = 0L;
    }

    protected void h(ImageView imageView, TextView textView, int i3, boolean z16) {
        if (!z16 && i3 > 0) {
            imageView.setVisibility(0);
            textView.setVisibility(0);
            if (i3 > 99) {
                textView.setText("99+");
                return;
            } else {
                textView.setText(Integer.toString(i3));
                return;
            }
        }
        imageView.setVisibility(8);
        textView.setVisibility(8);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_LIST_VISIBLE_STATISTIC, 1) > 0;
        this.K = 0L;
    }

    public void f(x4.a aVar, boolean z16, PhotoCacheData photoCacheData, PhotoCacheData photoCacheData2, boolean z17, boolean z18) {
        PictureUrl pictureUrl;
        int i3;
        VideoInfo videoInfo;
        if (photoCacheData == null) {
            if (z16) {
                this.f43645d.setImageDrawable(null);
                d(d.f401217b[photoCacheData2.group]);
                this.f43645d.setVisibility(0);
            } else {
                this.f43645d.setVisibility(8);
                this.f43646e.setVisibility(8);
            }
            this.E.setVisibility(8);
            this.f43648h.setVisibility(8);
            this.f43647f.setVisibility(8);
            this.f43649i.setVisibility(8);
            this.f43650m.setVisibility(8);
            this.D.setVisibility(8);
            this.C.setVisibility(8);
        } else {
            boolean j3 = com.qzone.album.env.common.a.m().j();
            this.f43645d.setVisibility(0);
            this.f43645d.setImageDrawable(null);
            h(this.f43650m, this.D, photoCacheData.cmtnum, z17);
            if (photoCacheData.isVideo()) {
                this.f43645d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                pictureUrl = photoCacheData.getVideoCoverUrl();
                if (!photoCacheData.isFakePhoto() && (videoInfo = photoCacheData.videodata) != null) {
                    this.f43648h.setText(VideoInfo.getShownTimeFromNumeric(videoInfo.videoTime));
                } else {
                    this.f43648h.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumVideoProcessing", "\u89c6\u9891\u5904\u7406\u4e2d..."));
                }
                if (!aVar.m()) {
                    this.f43648h.setVisibility(0);
                    this.f43647f.setVisibility(0);
                    this.f43649i.setVisibility(0);
                } else {
                    this.f43648h.setVisibility(8);
                    this.f43647f.setVisibility(8);
                    this.f43649i.setVisibility(8);
                }
            } else {
                if (photoCacheData.picItem == null) {
                    pictureUrl = null;
                } else if (photoCacheData.isGif() && j3) {
                    pictureUrl = photoCacheData.picItem.bigUrl;
                } else {
                    pictureUrl = photoCacheData.picItem.currentUrl;
                }
                this.f43645d.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f43646e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f43648h.setVisibility(8);
                this.f43647f.setVisibility(8);
            }
            if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                d(pictureUrl.url);
            } else {
                this.f43645d.setImageDrawable(null);
                this.f43646e.setImageDrawable(null);
            }
            if (z17) {
                this.E.setVisibility(0);
                if (z18) {
                    this.F.setVisibility(0);
                    this.G.setVisibility(8);
                } else {
                    this.F.setVisibility(8);
                    this.G.setVisibility(0);
                }
                if (photoCacheData.isChecked) {
                    if (z18) {
                        this.F.setCheckedNumber(a(aVar, photoCacheData));
                    } else {
                        this.G.setChecked(true);
                    }
                } else if (z18) {
                    this.F.setChecked(false);
                } else {
                    this.G.setChecked(false);
                }
                this.f43645d.setClickable(false);
                this.f43646e.setClickable(false);
                if (photoCacheData.lloc == null) {
                    photoCacheData.lloc = "";
                }
            } else {
                this.E.setVisibility(8);
            }
            PictureItem pictureItem = photoCacheData.picItem;
            if (pictureItem != null) {
                if (((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama() && ((i3 = pictureItem.flag) == 32 || i3 == 16)) {
                    this.C.setVisibility(0);
                } else {
                    this.C.setVisibility(8);
                }
            }
        }
        if (b().getVisibility() == 0) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    public void e() {
    }

    public void setGoneForLovers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
        }
    }
}
