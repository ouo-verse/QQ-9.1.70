package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildLiveBlurURLImageView extends AppCompatImageView {

    /* renamed from: m, reason: collision with root package name */
    private static final Bitmap.Config f227001m = Bitmap.Config.ARGB_8888;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends h12.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f227007d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f227008e;

        a(int i3, int i16) {
            this.f227007d = i3;
            this.f227008e = i16;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            GuildLiveBlurURLImageView.this.r(uRLDrawable, this.f227007d, this.f227008e);
        }
    }

    public GuildLiveBlurURLImageView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final URLDrawable uRLDrawable, final int i3, final int i16) {
        if (getContext() == null) {
            return;
        }
        if (i3 == 0) {
            setImageDrawableOnUiThread(uRLDrawable, i16);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildLiveBlurURLImageView.this.setImageDrawableOnUiThread(h12.c.f(GuildLiveBlurURLImageView.this.getResources(), uRLDrawable, GuildLiveBlurURLImageView.f227001m, i3), i16);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Drawable drawable, int i3) {
        if (drawable != null) {
            drawable.setAlpha(i3);
        }
        setImageDrawable(drawable);
    }

    public void p(String str, String str2, int i3) {
        q(str, str2, i3, 255);
    }

    public void q(String str, String str2, int i3, int i16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (!TextUtils.isEmpty(str2)) {
            URLDrawable drawable = URLDrawable.getDrawable(str2, (URLDrawable.URLDrawableOptions) null);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
        } else {
            obtain.mLoadingDrawable = null;
            obtain.mFailedDrawable = null;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        int status = drawable2.getStatus();
        if (status != 1 && status != 4) {
            drawable2.setURLDrawableListener(new a(i3, i16));
            drawable2.restartDownload();
            t(drawable2, 0);
            return;
        }
        r(drawable2, i3, i16);
    }

    public void setImageDrawableOnUiThread(@Nullable final Drawable drawable, final int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            t(drawable, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    GuildLiveBlurURLImageView.this.t(drawable, i3);
                }
            });
        }
    }

    public GuildLiveBlurURLImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildLiveBlurURLImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
