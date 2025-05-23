package com.qzone.homepage.diy;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.widget.AsyncImageView;
import cooperation.qzone.util.QZLog;
import cooperation.vip.widget.ScaleVideoView;
import fd0.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LocalVideoView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ScaleVideoView f47511d;

    /* renamed from: e, reason: collision with root package name */
    private AsyncImageView f47512e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f47513f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements a.e {
        a() {
        }

        @Override // fd0.a.e
        public void a(fd0.a aVar) {
            aVar.setVolume(0.0f, 0.0f);
            aVar.start();
            aVar.setLooping(LocalVideoView.this.f47513f);
        }
    }

    public LocalVideoView(Context context) {
        super(context);
        this.f47513f = true;
        b(context);
    }

    private void b(Context context) {
        AsyncImageView asyncImageView = new AsyncImageView(context);
        this.f47512e = asyncImageView;
        asyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.f47512e.setLayoutParams(layoutParams);
        addView(this.f47512e);
        this.f47511d = new ScaleVideoView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13, -1);
        this.f47511d.setOnPreparedListener(new a());
        this.f47511d.setLayoutParams(layoutParams2);
        addView(this.f47511d);
    }

    public void c() {
        ScaleVideoView scaleVideoView = this.f47511d;
        if (scaleVideoView != null) {
            scaleVideoView.pause();
        }
    }

    public void d() {
        ScaleVideoView scaleVideoView = this.f47511d;
        if (scaleVideoView != null) {
            scaleVideoView.start();
        }
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("DIYLocalVideoView", 2, " start video play url = " + str);
        }
        this.f47511d.setVideoURI(Uri.parse(str));
        this.f47511d.start();
    }

    public void setLoop(boolean z16) {
        this.f47513f = z16;
    }

    public void setVideoFrame(String str) {
        if (this.f47512e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f47512e.setAsyncImage(str);
    }

    public LocalVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47513f = true;
        b(context);
    }

    public LocalVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f47513f = true;
        b(context);
    }
}
