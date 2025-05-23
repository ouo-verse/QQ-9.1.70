package com.qzone.misc.localphoto.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.qzone.album.util.c;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneImageSwitchView extends ViewSwitcher {
    private long C;
    private Animation D;
    private Animation E;
    private long F;
    private Runnable G;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView[] f48379d;

    /* renamed from: e, reason: collision with root package name */
    private int f48380e;

    /* renamed from: f, reason: collision with root package name */
    private int f48381f;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<String> f48382h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48383i;

    /* renamed from: m, reason: collision with root package name */
    private long f48384m;

    public QZoneImageSwitchView(Context context) {
        super(context);
        this.f48380e = 1;
        this.f48381f = 1;
        this.f48382h = new ArrayList<>();
        this.f48383i = false;
        this.f48384m = 2000L;
        this.C = 3000L;
        this.F = 350L;
        this.G = new Runnable() { // from class: com.qzone.misc.localphoto.ui.QZoneImageSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneImageSwitchView.this.f48383i) {
                    QZoneImageSwitchView.this.e();
                    QZoneImageSwitchView qZoneImageSwitchView = QZoneImageSwitchView.this;
                    qZoneImageSwitchView.postDelayed(qZoneImageSwitchView.G, QZoneImageSwitchView.this.C);
                }
            }
        };
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f48382h.isEmpty() || this.f48382h.size() == 1) {
            return;
        }
        int size = this.f48381f % this.f48382h.size();
        ArrayList<String> arrayList = this.f48382h;
        this.f48381f = size + 1;
        String str = arrayList.get(size);
        int i3 = this.f48380e % 2;
        this.f48380e = i3;
        this.f48379d[i3].setAsyncImage(str);
        this.f48379d[this.f48380e].setVisibility(0);
        int i16 = this.f48380e;
        this.f48380e = i16 + 1;
        setDisplayedChild(i16);
    }

    @Override // android.view.View
    public void clearAnimation() {
        this.f48379d[0].clearAnimation();
        this.f48379d[1].clearAnimation();
    }

    public void f() {
        this.f48379d[0].cancelAsyncLoadImageWithoutListener();
        this.f48379d[1].cancelAsyncLoadImageWithoutListener();
    }

    public void setAdjustViewBounds(boolean z16) {
        this.f48379d[0].setAdjustViewBounds(z16);
        this.f48379d[1].setAdjustViewBounds(z16);
    }

    public void setAnimation(Animation animation, Animation animation2) {
        this.D = animation;
        this.E = animation2;
        setInAnimation(animation);
        setOutAnimation(this.E);
    }

    public void setAnimationDuration(long j3) {
        this.F = j3;
        this.D.setDuration(j3);
        this.D.setDuration(this.F);
    }

    public void setAsyncClipSize(int i3, int i16) {
        this.f48379d[0].setAsyncClipSize(i3, i16);
        this.f48379d[1].setAsyncClipSize(i3, i16);
    }

    public void setAsyncImage(String str) {
        this.f48379d[0].setAsyncImage(str);
        this.f48379d[1].setAsyncImage(str);
    }

    public void setAsyncImageProcessor(ImageProcessor imageProcessor) {
        this.f48379d[0].setAsyncImageProcessor(imageProcessor);
        this.f48379d[1].setAsyncImageProcessor(imageProcessor);
    }

    public void setCornerRadius(float f16) {
        this.f48379d[0].setCornerRadius(f16);
        this.f48379d[1].setCornerRadius(f16);
    }

    public void setData(List<String> list) {
        i();
        this.f48382h.clear();
        this.f48382h.addAll(list);
    }

    public void setDefaultAndFailedImage() {
        c.b(this.f48379d[0]);
        c.b(this.f48379d[1]);
    }

    public void setDefaultImage(int i3) {
        this.f48379d[0].setDefaultImage(i3);
        this.f48379d[1].setDefaultImage(i3);
    }

    public void setInitImage(String str) {
        this.f48379d[0].setAsyncImage(str);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.f48379d[0].setScaleType(scaleType);
        this.f48379d[1].setScaleType(scaleType);
    }

    public void g() {
        AsyncImageView[] asyncImageViewArr = new AsyncImageView[2];
        this.f48379d = asyncImageViewArr;
        asyncImageViewArr[0] = new AsyncImageView(getContext());
        this.f48379d[1] = new AsyncImageView(getContext());
        this.f48379d[0].setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f48379d[1].setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f48379d[0].setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f48379d[1].setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f48379d[0]);
        addView(this.f48379d[1]);
        setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154548b2), AnimationUtils.loadAnimation(getContext(), R.anim.f154550b4));
    }

    public void h() {
        this.f48383i = true;
        postDelayed(this.G, this.f48384m);
    }

    public void i() {
        this.f48383i = false;
        removeCallbacks(this.G);
        clearAnimation();
    }

    @Override // android.widget.ViewSwitcher
    public void reset() {
        this.f48380e = 1;
        this.f48381f = 1;
        setDisplayedChild(0);
    }

    public void setStartDelay(int i3) {
        this.f48384m = i3;
    }

    public QZoneImageSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f48380e = 1;
        this.f48381f = 1;
        this.f48382h = new ArrayList<>();
        this.f48383i = false;
        this.f48384m = 2000L;
        this.C = 3000L;
        this.F = 350L;
        this.G = new Runnable() { // from class: com.qzone.misc.localphoto.ui.QZoneImageSwitchView.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneImageSwitchView.this.f48383i) {
                    QZoneImageSwitchView.this.e();
                    QZoneImageSwitchView qZoneImageSwitchView = QZoneImageSwitchView.this;
                    qZoneImageSwitchView.postDelayed(qZoneImageSwitchView.G, QZoneImageSwitchView.this.C);
                }
            }
        };
        g();
    }
}
