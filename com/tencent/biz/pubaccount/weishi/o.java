package com.tencent.biz.pubaccount.weishi;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.j;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes32.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.biz.pubaccount.j f81001a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f81002b;

    /* renamed from: c, reason: collision with root package name */
    private URLDrawableDownListener f81003c = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements j.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81005a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ URLImageView f81006b;

        b(String str, URLImageView uRLImageView) {
            this.f81005a = str;
            this.f81006b = uRLImageView;
        }

        @Override // com.tencent.biz.pubaccount.j.a
        public void onPlayFinish() {
            URLDrawable d16 = o.this.d(this.f81005a, true);
            if (d16 == null) {
                return;
            }
            this.f81006b.setImageDrawable(d16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public URLDrawable d(String str, boolean z16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = z16;
        URL c16 = bb.c(str);
        if (c16 == null) {
            return URLDrawable.getDrawable(str, obtain);
        }
        URLDrawable drawable = URLDrawable.getDrawable(c16, obtain);
        if (drawable.getCurrDrawable() instanceof GifDrawable) {
            AbstractGifImage image = ((GifDrawable) drawable.getCurrDrawable()).getImage();
            if (!z16) {
                drawable.setIndividualPause(true);
            } else {
                drawable.setIndividualPause(false);
            }
            image.reset();
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f81002b) {
            c();
        }
    }

    public void c() {
        com.tencent.biz.pubaccount.j jVar = this.f81001a;
        if (jVar != null) {
            jVar.c();
        }
        AbstractGifImage.pauseAll();
    }

    public void f(URLImageView uRLImageView, Drawable drawable, String str, boolean z16, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            uRLImageView.setImageDrawable(drawable);
            return;
        }
        this.f81002b = z17;
        URLDrawable d16 = d(str, z16);
        if (d16 == null) {
            return;
        }
        if (d16.getStatus() == 1) {
            if (d16.getCurrDrawable() instanceof GifDrawable) {
                AbstractGifImage image = ((GifDrawable) d16.getCurrDrawable()).getImage();
                if (image instanceof com.tencent.biz.pubaccount.j) {
                    com.tencent.biz.pubaccount.j jVar = (com.tencent.biz.pubaccount.j) image;
                    this.f81001a = jVar;
                    jVar.d(new b(str, uRLImageView));
                }
            }
            this.f81003c.onLoadSuccessed(uRLImageView, d16);
        } else {
            d16.startDownload();
        }
        uRLImageView.setURLDrawableDownListener(this.f81003c);
        uRLImageView.setImageDrawable(d16);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements URLDrawableDownListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            o.this.e();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            o.this.e();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            o.this.e();
            AbstractGifImage.resumeAll();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }
}
