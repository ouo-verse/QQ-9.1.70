package com.qzone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.R;
import java.util.List;

/* loaded from: classes37.dex */
public class PhotoCarouselView extends ViewSwitcher {
    private Animation C;
    private Animation D;
    private Context E;
    private List<ImageInfo> F;
    private Runnable G;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f60438d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncImageView f60439e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60440f;

    /* renamed from: h, reason: collision with root package name */
    private int f60441h;

    /* renamed from: i, reason: collision with root package name */
    private long f60442i;

    /* renamed from: m, reason: collision with root package name */
    private long f60443m;

    public PhotoCarouselView(Context context) {
        super(context);
        this.f60442i = 1000L;
        this.f60443m = 2000L;
        this.G = new Runnable() { // from class: com.qzone.widget.PhotoCarouselView.1
            @Override // java.lang.Runnable
            public void run() {
                PhotoCarouselView.this.d();
            }
        };
        this.E = context;
    }

    private void b(Context context) {
        this.f60438d = new AsyncImageView(context);
        this.f60439e = new AsyncImageView(context);
        this.f60438d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f60439e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f60438d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f60439e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f60438d);
        addView(this.f60439e);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f154548b2);
        this.C = loadAnimation;
        loadAnimation.setDuration(this.f60442i - 5);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.f154550b4);
        this.D = loadAnimation2;
        loadAnimation2.setDuration(this.f60442i);
        setInAnimation(this.C);
        setOutAnimation(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<ImageInfo> list = this.F;
        if (list != null && list.size() > 1 && this.f60441h < this.F.size() && this.f60440f) {
            int i3 = this.f60441h;
            if (i3 % 2 == 1) {
                this.f60438d.setAsyncImage(this.F.get(i3).mPath);
            } else {
                this.f60439e.setAsyncImage(this.F.get(i3).mPath);
            }
            setDisplayedChild((this.f60441h % 2) + 1);
            if (this.f60441h != com.qzone.publish.ui.publishmodule.d.v() && this.f60441h != this.F.size() - 1) {
                postDelayed(this.G, this.f60443m + this.f60442i);
            } else {
                this.f60438d.setAsyncImage(this.F.get(0).mPath);
                this.f60439e.setAsyncImage(this.F.get(0).mPath);
            }
            this.f60441h++;
            return;
        }
        List<ImageInfo> list2 = this.F;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.f60438d.setAsyncImage(this.F.get(0).mPath);
    }

    public void c(long j3) {
        if (this.f60438d == null) {
            b(this.E);
        }
        this.f60440f = true;
        setVisibility(0);
        postDelayed(this.G, j3);
    }

    public void setImageInfos(List<ImageInfo> list) {
        this.F = list;
    }

    public PhotoCarouselView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60442i = 1000L;
        this.f60443m = 2000L;
        this.G = new Runnable() { // from class: com.qzone.widget.PhotoCarouselView.1
            @Override // java.lang.Runnable
            public void run() {
                PhotoCarouselView.this.d();
            }
        };
        this.E = context;
    }
}
