package com.qzone.album.ui.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.app.ImageEnvImpl;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AvatarImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;

/* loaded from: classes39.dex */
public class VideoPhotoView extends RelativeLayout {
    protected TextView C;
    protected ImageView D;
    protected TextView E;
    protected boolean F;
    protected int G;
    protected int H;
    protected Context I;
    protected String J;
    protected int K;
    protected int L;
    private View M;
    private AvatarImageView N;
    private TextView P;
    private TextView Q;
    private TextView R;

    /* renamed from: d, reason: collision with root package name */
    protected AsyncImageView f44251d;

    /* renamed from: e, reason: collision with root package name */
    protected AsyncImageView f44252e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f44253f;

    /* renamed from: h, reason: collision with root package name */
    protected LocalPhotoLinearGradientView f44254h;

    /* renamed from: i, reason: collision with root package name */
    protected LocalPhotoLinearGradientView f44255i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f44256m;

    public VideoPhotoView(Context context) {
        super(context);
    }

    private void d(PhotoCacheData photoCacheData) {
        e(this.f44256m, this.C, photoCacheData.cmtnum, false);
        f(this.D, this.E, photoCacheData);
        this.f44253f.setText(com.qzone.album.util.g.j(photoCacheData.videodata.videoTime));
    }

    public void a(Context context, int i3, int i16) {
        this.I = context;
        this.K = i3;
        this.L = i16;
        this.G = i3;
        this.H = (i3 * 598) / 374;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168997bj0, this);
        this.f44251d = (AsyncImageView) inflate.findViewById(R.id.fou);
        this.f44252e = (AsyncImageView) inflate.findViewById(R.id.enh);
        this.f44253f = (TextView) inflate.findViewById(R.id.kuy);
        this.f44254h = (LocalPhotoLinearGradientView) inflate.findViewById(R.id.f164631ad3);
        this.f44255i = (LocalPhotoLinearGradientView) inflate.findViewById(R.id.jto);
        this.R = (TextView) inflate.findViewById(R.id.cos);
        this.f44256m = (ImageView) inflate.findViewById(R.id.f164280ql);
        TextView textView = (TextView) inflate.findViewById(R.id.f164281qm);
        this.C = textView;
        textView.setPadding(0, ar.d(3.0f), 0, 0);
        this.D = (ImageView) inflate.findViewById(R.id.he6);
        TextView textView2 = (TextView) inflate.findViewById(R.id.he7);
        this.E = textView2;
        textView2.setPadding(0, ar.d(3.0f), 0, 0);
        this.M = inflate.findViewById(R.id.cnu);
        this.N = (AvatarImageView) inflate.findViewById(R.id.cns);
        this.P = (TextView) inflate.findViewById(R.id.co_);
        this.Q = (TextView) inflate.findViewById(R.id.cot);
        ViewGroup.LayoutParams layoutParams = this.f44252e.getLayoutParams();
        layoutParams.width = this.G;
        layoutParams.height = this.H;
        this.f44252e.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f44251d.getLayoutParams();
        layoutParams2.width = this.K;
        layoutParams2.height = this.L;
        this.f44251d.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f44254h.getLayoutParams();
        layoutParams3.width = this.K;
        layoutParams3.height = (int) (this.H / 5.7d);
        this.f44254h.setLayoutParams(layoutParams3);
        this.f44254h.setShader(new LinearGradient(0.0f, layoutParams3.height, 0.0f, 0.0f, 838860800, 0, Shader.TileMode.CLAMP));
        ViewGroup.LayoutParams layoutParams4 = this.f44255i.getLayoutParams();
        layoutParams4.width = this.K;
        layoutParams4.height = (int) (this.H / 5.7d);
        this.f44255i.setLayoutParams(layoutParams4);
        this.f44255i.setShader(new LinearGradient(0.0f, layoutParams4.height, 0.0f, 0.0f, 0, 838860800, Shader.TileMode.CLAMP));
    }

    public void c() {
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.f44256m.setVisibility(8);
        this.C.setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void setFriendVideo(boolean z16, long j3, String str, long j16, String str2) {
        View view = this.M;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
            this.N.j(j3);
            this.N.setClickable(false);
            this.N.setFocusableInTouchMode(false);
            this.N.setOnTouchListener(null);
            this.N.setOnClickListener(null);
            this.P.setText(str);
            this.Q.setText(com.qzone.album.util.g.d(j16 * 1000));
            this.R.setText(str2);
            this.f44255i.setVisibility(0);
        }
        this.F = z16;
    }

    public VideoPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoPhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void b(PhotoCacheData photoCacheData) {
        PictureUrl recentVideoCoverUrl;
        if (photoCacheData == null || (recentVideoCoverUrl = photoCacheData.getRecentVideoCoverUrl(NetworkUtil.isWifiConnected(this.I))) == null || TextUtils.isEmpty(recentVideoCoverUrl.url)) {
            return;
        }
        if (recentVideoCoverUrl.url.equals(this.J)) {
            d(photoCacheData);
            return;
        }
        this.f44251d.setImageResource(R.drawable.fyy);
        this.f44252e.setImageResource(R.drawable.fyy);
        this.f44251d.setDefaultImage(R.drawable.fyy);
        if (recentVideoCoverUrl.width >= recentVideoCoverUrl.height) {
            ViewGroup.LayoutParams layoutParams = this.f44251d.getLayoutParams();
            layoutParams.width = this.K;
            layoutParams.height = this.L;
            this.f44251d.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.f44251d.getLayoutParams();
            layoutParams2.width = this.G;
            layoutParams2.height = this.H;
            this.f44251d.setLayoutParams(layoutParams2);
        }
        if (NetworkUtil.isWifiConnected(this.I) && ImageEnvImpl.isSupportAnimWebp()) {
            this.f44251d.setAsyncImage(recentVideoCoverUrl.url);
        } else {
            PictureUrl pictureUrl = photoCacheData.videodata.bigUrl;
            if (pictureUrl != null) {
                this.f44251d.setAsyncImage(pictureUrl.url);
            } else {
                QZLog.e("VideoPhotoView", "photoCacheData.videodata.bigUrl == null");
            }
        }
        if (recentVideoCoverUrl.width >= recentVideoCoverUrl.height) {
            this.f44252e.setAsyncImageProcessor(new a5.a(this.K, this.G, this.H));
            PictureUrl pictureUrl2 = photoCacheData.videodata.bigUrl;
            if (pictureUrl2 != null) {
                this.f44252e.setAsyncImage(pictureUrl2.url);
            } else {
                QZLog.e("VideoPhotoView", "photoCacheData.videodata.bigUrl == null");
            }
            this.f44252e.setVisibility(0);
        } else {
            this.f44252e.setVisibility(8);
        }
        d(photoCacheData);
    }

    public void f(ImageView imageView, TextView textView, PhotoCacheData photoCacheData) {
        if (photoCacheData == null) {
            return;
        }
        if (photoCacheData.likenum > 0) {
            imageView.setVisibility(0);
            textView.setVisibility(0);
            if (photoCacheData.likenum > 99) {
                textView.setText("99+");
                return;
            }
            textView.setText(photoCacheData.likenum + "");
            return;
        }
        imageView.setVisibility(8);
        textView.setVisibility(8);
    }

    protected void e(ImageView imageView, TextView textView, int i3, boolean z16) {
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
}
