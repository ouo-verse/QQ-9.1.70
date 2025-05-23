package com.tencent.now.app.common.widget.apng;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.File;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes22.dex */
public class APngImageView extends ImageView implements ThreadCenter.HandlerKeyable {
    private DisplayImageOptions C;

    /* renamed from: d, reason: collision with root package name */
    private boolean f337929d;

    /* renamed from: e, reason: collision with root package name */
    private b f337930e;

    /* renamed from: f, reason: collision with root package name */
    private String f337931f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f337932h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f337933i;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f337934m;

    public APngImageView(Context context) {
        super(context);
        this.f337929d = false;
        this.f337933i = new Runnable() { // from class: com.tencent.now.app.common.widget.apng.APngImageView.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(APngImageView.this.f337931f)) {
                    return;
                }
                try {
                    File file = ImageLoader.getInstance().getDiskCache().get(APngImageView.this.f337931f);
                    APngImageView.this.f337931f = null;
                    APngImageView.this.f337930e = new b(file, APngImageView.this.getResources());
                    APngImageView aPngImageView = APngImageView.this;
                    ThreadCenter.postUITask(aPngImageView, aPngImageView.f337934m);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        this.f337934m = new Runnable() { // from class: com.tencent.now.app.common.widget.apng.APngImageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (APngImageView.this.f337930e != null) {
                    APngImageView aPngImageView = APngImageView.this;
                    aPngImageView.k(aPngImageView.f337930e);
                    APngImageView.this.f337930e = null;
                }
            }
        };
    }

    private DisplayImageOptions j() {
        if (this.C == null) {
            this.C = new DisplayImageOptions.Builder().cacheOnDisk(true).considerExifParams(false).build();
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(b bVar) {
        super.setImageDrawable(bVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        this.f337929d = false;
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.f337929d = true;
        try {
            Runnable runnable = this.f337932h;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 16);
            }
            ThreadCenter.clear(this);
        } catch (Exception e16) {
            LogUtil.e("APngImageView", "onDetachedFromWindow error:" + e16, new Object[0]);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageUrl(uri.toString(), false);
    }

    public void setImageUrl(String str, boolean z16) {
        setImageAlpha(0);
        if (z16) {
            ImageLoader.getInstance().getMemoryCache().remove(str);
        }
        ImageLoader.getInstance().loadImage(str, j(), new a(z16));
    }

    public APngImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f337929d = false;
        this.f337933i = new Runnable() { // from class: com.tencent.now.app.common.widget.apng.APngImageView.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(APngImageView.this.f337931f)) {
                    return;
                }
                try {
                    File file = ImageLoader.getInstance().getDiskCache().get(APngImageView.this.f337931f);
                    APngImageView.this.f337931f = null;
                    APngImageView.this.f337930e = new b(file, APngImageView.this.getResources());
                    APngImageView aPngImageView = APngImageView.this;
                    ThreadCenter.postUITask(aPngImageView, aPngImageView.f337934m);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        this.f337934m = new Runnable() { // from class: com.tencent.now.app.common.widget.apng.APngImageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (APngImageView.this.f337930e != null) {
                    APngImageView aPngImageView = APngImageView.this;
                    aPngImageView.k(aPngImageView.f337930e);
                    APngImageView.this.f337930e = null;
                }
            }
        };
    }

    public APngImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f337929d = false;
        this.f337933i = new Runnable() { // from class: com.tencent.now.app.common.widget.apng.APngImageView.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(APngImageView.this.f337931f)) {
                    return;
                }
                try {
                    File file = ImageLoader.getInstance().getDiskCache().get(APngImageView.this.f337931f);
                    APngImageView.this.f337931f = null;
                    APngImageView.this.f337930e = new b(file, APngImageView.this.getResources());
                    APngImageView aPngImageView = APngImageView.this;
                    ThreadCenter.postUITask(aPngImageView, aPngImageView.f337934m);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        this.f337934m = new Runnable() { // from class: com.tencent.now.app.common.widget.apng.APngImageView.2
            @Override // java.lang.Runnable
            public void run() {
                if (APngImageView.this.f337930e != null) {
                    APngImageView aPngImageView = APngImageView.this;
                    aPngImageView.k(aPngImageView.f337930e);
                    APngImageView.this.f337930e = null;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements ImageLoadingListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f337935a;

        a(boolean z16) {
            this.f337935a = z16;
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (APngImageView.this.f337929d) {
                return;
            }
            APngImageView.this.setImageAlpha(255);
            if (this.f337935a) {
                APngImageView.this.f337931f = str;
                ThreadCenter.postLogicTask(APngImageView.this.f337933i);
                APngImageView aPngImageView = APngImageView.this;
                aPngImageView.f337932h = ThreadManagerV2.executeDelay(aPngImageView.f337933i, 16, null, true, 0L);
                ThreadManagerV2.excute(APngImageView.this.f337933i, 16, null, true);
                return;
            }
            APngImageView.this.setImageBitmap(bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            LogUtil.e("APngImageView", "error:" + str, new Object[0]);
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }
    }
}
