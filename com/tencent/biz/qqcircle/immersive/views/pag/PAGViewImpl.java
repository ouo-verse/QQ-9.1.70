package com.tencent.biz.qqcircle.immersive.views.pag;

import a80.b;
import a80.f;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.pag.PAGViewImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.thread.RFWThreadManager;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* loaded from: classes4.dex */
public class PAGViewImpl extends PAGView implements b {
    public PAGViewImpl(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        setScaleMode(3);
    }

    @Override // a80.b
    public void a(f fVar) {
        super.addListener(fVar);
    }

    @Override // a80.b
    public void b(@NonNull FrameLayout frameLayout) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: a80.j
            @Override // java.lang.Runnable
            public final void run() {
                PAGViewImpl.this.i();
            }
        });
        setVisibility(8);
        frameLayout.addView(this);
    }

    @Override // a80.b
    public void c(f fVar) {
        super.removeListener(fVar);
    }

    @Override // org.libpag.PAGView, a80.b
    public boolean flush() {
        return super.flush();
    }

    @Override // android.view.View, a80.b
    public ViewGroup.LayoutParams getLayoutParams() {
        return super.getLayoutParams();
    }

    @Override // org.libpag.PAGView, a80.b
    public boolean isPlaying() {
        return super.isPlaying();
    }

    @Override // org.libpag.PAGView, a80.b
    public void play() {
        super.play();
    }

    @Override // a80.b
    public void setComposition(PAGFile pAGFile) {
        super.setComposition((PAGComposition) pAGFile);
    }

    @Override // a80.b
    public void setLayoutParams(FrameLayout.LayoutParams layoutParams) {
        try {
            super.setLayoutParams((ViewGroup.LayoutParams) layoutParams);
        } catch (Exception e16) {
            RFWLog.d("PAGViewImpl", RFWLog.USR, "setLayoutParams error:" + e16);
        }
    }

    @Override // org.libpag.PAGView, a80.b
    public void setProgress(double d16) {
        super.setProgress(d16);
        flush();
    }

    @Override // org.libpag.PAGView, a80.b
    public void setRepeatCount(int i3) {
        super.setRepeatCount(i3);
    }

    @Override // org.libpag.PAGView, a80.b
    public void setScaleMode(int i3) {
        super.setScaleMode(i3);
    }

    @Override // android.view.View, a80.b
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    @Override // org.libpag.PAGView, a80.b
    public void stop() {
        super.stop();
    }

    public PAGViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // org.libpag.PAGView
    public void setComposition(PAGComposition pAGComposition) {
        super.setComposition(pAGComposition);
    }

    @Override // a80.b
    public void setStaticImageMode(boolean z16) {
    }
}
