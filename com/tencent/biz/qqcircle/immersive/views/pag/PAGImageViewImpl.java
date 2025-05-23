package com.tencent.biz.qqcircle.immersive.views.pag;

import a80.b;
import a80.f;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.pag.PAGImageViewImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

/* loaded from: classes4.dex */
public class PAGImageViewImpl extends PAGImageView implements b {
    private boolean H;
    private double I;

    public PAGImageViewImpl(Context context) {
        super(context);
        this.H = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        setScaleMode(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        setProgress(this.I);
    }

    @Override // a80.b
    public void a(f fVar) {
        super.addListener(fVar);
    }

    @Override // a80.b
    public void b(@NonNull FrameLayout frameLayout) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: a80.d
            @Override // java.lang.Runnable
            public final void run() {
                PAGImageViewImpl.this.m();
            }
        });
        setVisibility(8);
        frameLayout.addView(this);
    }

    @Override // a80.b
    public void c(f fVar) {
        super.removeListener(fVar);
    }

    @Override // org.libpag.PAGImageView, a80.b
    public boolean flush() {
        try {
            return super.flush();
        } catch (Exception e16) {
            RFWLog.d("PAGImageViewImpl", RFWLog.USR, "flush error:" + e16);
            return false;
        }
    }

    @Override // android.view.View, a80.b
    public ViewGroup.LayoutParams getLayoutParams() {
        return super.getLayoutParams();
    }

    @Override // org.libpag.PAGImageView, a80.b
    public boolean isPlaying() {
        return super.isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.libpag.PAGImageView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.H) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: a80.c
                @Override // java.lang.Runnable
                public final void run() {
                    PAGImageViewImpl.this.n();
                }
            });
        }
    }

    @Override // org.libpag.PAGImageView, a80.b
    public void play() {
        super.play();
    }

    @Override // a80.b
    public void setComposition(PAGFile pAGFile) {
        super.setComposition((PAGComposition) pAGFile);
    }

    @Override // a80.b
    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
    }

    @Override // a80.b
    public void setProgress(double d16) {
        try {
            this.I = d16;
            if (numFrames() <= 0) {
                return;
            }
            setCurrentFrame((int) ((r1 - 1) * Math.max(Math.min(d16, 1.0d), 0.0d)));
            flush();
        } catch (Exception e16) {
            RFWLog.d("PAGImageViewImpl", RFWLog.USR, "setProgress error:" + e16);
        }
    }

    @Override // org.libpag.PAGImageView, a80.b
    public void setRepeatCount(int i3) {
        super.setRepeatCount(i3);
    }

    @Override // org.libpag.PAGImageView, a80.b
    public void setScaleMode(int i3) {
        super.setScaleMode(i3);
    }

    @Override // a80.b
    public void setStaticImageMode(boolean z16) {
        this.H = z16;
    }

    @Override // android.view.View, a80.b
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // a80.b
    public void stop() {
        try {
            super.pause();
        } catch (Exception e16) {
            RFWLog.d("PAGImageViewImpl", RFWLog.USR, "stop error:" + e16);
        }
    }

    @Override // org.libpag.PAGImageView
    public void setComposition(PAGComposition pAGComposition) {
        super.setComposition(pAGComposition);
    }

    public PAGImageViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = false;
    }

    public PAGImageViewImpl(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = false;
    }
}
