package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CircleVideoDrawableView extends CircleBubbleImageView implements VideoDrawable.OnAudioPlayOnceListener {
    public URLDrawable R;
    public String S;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public CircleVideoDrawableView(Context context) {
        super(context);
    }

    @Override // com.tencent.image.VideoDrawable.OnAudioPlayOnceListener
    public void onFinish() {
        if (QLog.isColorLevel()) {
            QLog.d("BlessPTVActivity", 2, " onFinish ");
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        if (uRLDrawable == this.R) {
            setURLDrawable(uRLDrawable);
        } else {
            super.onLoadFialed(uRLDrawable, th5);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.item.ChatThumbView, com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    @TargetApi(11)
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        if (uRLDrawable == this.R) {
            setURLDrawable(uRLDrawable);
        }
        super.onLoadSuccessed(uRLDrawable);
        Drawable currDrawable = this.R.getCurrDrawable();
        if (currDrawable != null && (currDrawable instanceof VideoDrawable)) {
            VideoDrawable videoDrawable = (VideoDrawable) currDrawable;
            videoDrawable.resetAndPlayAudioOnce();
            videoDrawable.setOnAudioPlayOnceListener(this);
        }
    }

    @Override // com.tencent.mobileqq.widget.CircleBubbleImageView, com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        super.setImageDrawable(drawable);
    }

    public void setURLDrawable(URLDrawable uRLDrawable) {
        URLDrawable uRLDrawable2 = this.R;
        if (uRLDrawable2 != null) {
            uRLDrawable2.setURLDrawableListener(null);
            Drawable currDrawable = this.R.getCurrDrawable();
            if (currDrawable != null && (currDrawable instanceof VideoDrawable)) {
                VideoDrawable videoDrawable = (VideoDrawable) currDrawable;
                videoDrawable.stopAudio();
                videoDrawable.setOnAudioPlayOnceListener(null);
            }
        }
        uRLDrawable.setURLDrawableListener(this);
        setImageDrawable(uRLDrawable);
        this.R = uRLDrawable;
        Drawable currDrawable2 = uRLDrawable.getCurrDrawable();
        if (currDrawable2 != null && (currDrawable2 instanceof VideoDrawable)) {
            ((VideoDrawable) currDrawable2).setOnAudioPlayOnceListener(this);
        }
    }

    public void setVideoPath(String str) {
        this.S = str;
    }

    public void setVideoListener(a aVar) {
    }
}
