package com.qzone.personalize.music.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.qzone.widget.AvatarImageView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes39.dex */
public class MusicPlayerDIYBar extends HomepageMusicPlayerBar implements ImageLoader.ImageLoadListener {

    /* renamed from: c0, reason: collision with root package name */
    private String f49441c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f49442d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f49443e0;

    /* renamed from: f0, reason: collision with root package name */
    private RelativeLayout f49444f0;

    /* renamed from: g0, reason: collision with root package name */
    private AvatarImageView f49445g0;

    /* renamed from: h0, reason: collision with root package name */
    private ObjectAnimator f49446h0;

    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MusicPlayerDIYBar.this.d();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MusicPlayerDIYBar(Context context, long j3) {
        super(context, j3);
        setBackgroundDrawable(null);
    }

    private void T(boolean z16) {
        ObjectAnimator objectAnimator;
        if (this.f49444f0 == null || (objectAnimator = this.f49446h0) == null) {
            return;
        }
        if (z16) {
            objectAnimator.resume();
        } else {
            objectAnimator.pause();
        }
    }

    @Override // com.qzone.personalize.music.ui.HomepageMusicPlayerBar
    protected int G() {
        return R.layout.bk5;
    }

    @Override // com.qzone.personalize.music.ui.HomepageMusicPlayerBar
    protected void L(Context context, long j3) {
        this.L = j3;
        this.P = context;
        this.V = findViewById(R.id.f166645gu4);
        this.W = findViewById(R.id.klo);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f49393i.getLayoutParams();
        layoutParams.addRule(0, R.id.gu6);
        setMinimumHeight(ViewUtils.dip2px(48.0f));
        this.f49393i.setLayoutParams(layoutParams);
        this.D.setVisibility(8);
        this.F.setVisibility(8);
        this.f49443e0 = (TextView) findViewById(R.id.fvi);
        this.f49444f0 = (RelativeLayout) findViewById(R.id.ic6);
        this.f49445g0 = (AvatarImageView) findViewById(R.id.fvh);
        this.f49444f0.setOnClickListener(new a());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f49444f0, BasicAnimation.KeyPath.ROTATION, 0.0f, 359.0f);
        this.f49446h0 = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f49446h0.setDuration(4000L);
        this.f49446h0.setRepeatCount(-1);
        this.f49446h0.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.personalize.music.ui.HomepageMusicPlayerBar, com.qzone.personalize.music.ui.BaseMusicPlayerBar
    public void b() {
        super.b();
        com.qzone.homepage.diy.util.a.d(5);
    }

    @Override // com.qzone.personalize.music.ui.HomepageMusicPlayerBar, com.qzone.personalize.music.ui.BaseMusicPlayerBar
    protected void f() {
        LayoutInflater.from(getContext()).inflate(G(), this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, ar.e(48.0f));
        }
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.personalize.music.ui.BaseMusicPlayerBar
    public void r() {
        SongInfo songInfo;
        SongInfo songInfo2;
        super.r();
        TextView textView = this.f49443e0;
        if (textView != null && (songInfo2 = this.f49391f) != null) {
            textView.setText(songInfo2.F);
        }
        AvatarImageView avatarImageView = this.f49445g0;
        if (avatarImageView == null || (songInfo = this.f49391f) == null) {
            return;
        }
        avatarImageView.k(songInfo.C);
    }

    public void setPlayIconUrl(String str, String str2) {
        this.f49441c0 = str;
        this.f49442d0 = str2;
        Drawable K = K();
        if (K != null) {
            this.f49394m.setImageDrawable(K);
        }
    }

    @Override // com.qzone.personalize.music.ui.HomepageMusicPlayerBar
    protected Drawable I() {
        Drawable loadImage;
        T(false);
        if (TextUtils.isEmpty(this.f49441c0) || (loadImage = ImageLoader.getInstance().loadImage(this.f49441c0, this)) == null) {
            return null;
        }
        return loadImage;
    }

    @Override // com.qzone.personalize.music.ui.HomepageMusicPlayerBar
    protected Drawable K() {
        Drawable loadImage;
        T(true);
        if (TextUtils.isEmpty(this.f49442d0) || (loadImage = ImageLoader.getInstance().loadImage(this.f49442d0, this)) == null) {
            return null;
        }
        return loadImage;
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
        if (drawable != null) {
            this.f49415b0.post(new Runnable() { // from class: com.qzone.personalize.music.ui.MusicPlayerDIYBar.2
                @Override // java.lang.Runnable
                public void run() {
                    Drawable drawable2 = drawable;
                    if (drawable2 != null) {
                        MusicPlayerDIYBar.this.f49394m.setImageDrawable(drawable2);
                    }
                }
            });
        }
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageCanceled(String str, ImageLoader.Options options) {
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageFailed(String str, ImageLoader.Options options) {
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageProgress(String str, float f16, ImageLoader.Options options) {
    }
}
