package com.qzone.widget.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.qzone.widget.particle.ParticleManager;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes37.dex */
public class ParticleTextView extends TextView implements ParticleManager.b {

    /* renamed from: d, reason: collision with root package name */
    ParticleManager f60940d;

    public ParticleTextView(Context context) {
        super(context);
        this.f60940d = new ParticleManager(context);
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleHeight() {
        return getHeight();
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleTextVisibility() {
        return 0;
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public int getParticleWidth() {
        return getWidth();
    }

    public void setAnimationResume() {
        this.f60940d.I();
    }

    public void setConfig(d dVar) {
        this.f60940d.N(dVar);
    }

    public ParticleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60940d = new ParticleManager(context);
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public Bitmap getBitmap() {
        measure(View.MeasureSpec.makeMeasureSpec(ViewUtils.dpToPx(164.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(ViewUtils.dpToPx(36.0f), 1073741824));
        Bitmap createBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        draw(canvas);
        return createBitmap;
    }

    @Override // com.qzone.widget.particle.ParticleManager.b
    public void setParticleTextVisibility(int i3) {
    }
}
