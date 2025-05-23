package com.tencent.now.app.music.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.now.app.common.widget.apng.APngImageView;
import com.tencent.now.app.music.controller.b;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.viewmodel.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicSettingView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private c f338063d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f338064e;

    /* renamed from: f, reason: collision with root package name */
    public APngImageView f338065f;

    /* renamed from: h, reason: collision with root package name */
    public MusicLoadingCircleView f338066h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f338067i;

    public MusicSettingView(Context context) {
        super(context);
        this.f338067i = false;
        c(context);
    }

    private void c(Context context) {
        View inflate = View.inflate(context, R.layout.fel, this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.zkg);
        this.f338064e = imageView;
        imageView.setClickable(false);
        this.f338064e.setFocusable(false);
        APngImageView aPngImageView = (APngImageView) inflate.findViewById(R.id.zkc);
        this.f338065f = aPngImageView;
        aPngImageView.setClickable(false);
        this.f338065f.setFocusable(false);
        MusicLoadingCircleView musicLoadingCircleView = (MusicLoadingCircleView) inflate.findViewById(R.id.twx);
        this.f338066h = musicLoadingCircleView;
        musicLoadingCircleView.setClickable(false);
        this.f338066h.setFocusable(false);
        this.f338063d = new c(getContext(), this);
    }

    public void a(int i3) {
        this.f338067i = true;
        c cVar = this.f338063d;
        if (cVar != null) {
            cVar.h(i3);
        }
    }

    public c b() {
        return this.f338063d;
    }

    public void d() {
        this.f338063d.g();
    }

    public void e() {
        this.f338063d.k();
    }

    public void f(float f16) {
        this.f338063d.m(f16);
    }

    public void g(MusicItem musicItem) {
        this.f338063d.n(musicItem);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f338063d;
        if (cVar != null) {
            cVar.l();
        }
    }

    public void setMusicControl(b bVar) {
        this.f338063d.i(bVar);
    }

    public MusicSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338067i = false;
        c(context);
    }

    public MusicSettingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338067i = false;
        c(context);
    }
}
