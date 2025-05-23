package com.tencent.mobileqq.zplan.easteregg;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.zplan.easteregg.v;
import java.util.Map;

/* loaded from: classes34.dex */
public class EasterEggPlayer implements v {

    /* renamed from: d, reason: collision with root package name */
    private v f332830d;

    public EasterEggPlayer(Context context, AttributeSet attributeSet, int i3) {
        b(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public boolean a(v.b bVar) {
        return this.f332830d.a(bVar);
    }

    public void b(Context context, AttributeSet attributeSet, int i3) {
        this.f332830d = new EasterEggPagPlayer(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public void c(Map<Integer, Bitmap> map) {
        this.f332830d.c(map);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public View getPlayerView() {
        return this.f332830d.getPlayerView();
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public boolean prepare(String str) {
        return this.f332830d.prepare(str);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public void setStatusListener(v.a aVar) {
        this.f332830d.setStatusListener(aVar);
    }

    @Override // com.tencent.mobileqq.zplan.easteregg.v
    public void stop() {
        this.f332830d.stop();
    }
}
