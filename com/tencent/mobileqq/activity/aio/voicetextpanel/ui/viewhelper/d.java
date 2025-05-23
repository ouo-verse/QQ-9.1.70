package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private VoiceTextPanel f180238a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f180239b;

    /* renamed from: c, reason: collision with root package name */
    private FrameLayout f180240c;

    /* renamed from: d, reason: collision with root package name */
    private VoiceTextEditScrollerView f180241d;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public void a(int i3, int i16, int i17, int i18) {
        this.f180241d.n(i18, i16, i17 - i3, i17, 1, 100, this.f180238a);
    }

    public void b(int i3, int i16, int i17) {
        VoiceTextEditScrollerView voiceTextEditScrollerView = this.f180241d;
        voiceTextEditScrollerView.n(voiceTextEditScrollerView.getTop(), i3, i16, i17, 0, 200, this.f180241d);
        this.f180239b.setVisibility(8);
    }

    public int c() {
        return this.f180239b.getVisibility();
    }

    public int d() {
        return this.f180241d.getTop();
    }

    public void e() {
        this.f180241d.setListener(this.f180238a.r());
    }

    public void f(VoiceTextPanel voiceTextPanel) {
        this.f180238a = voiceTextPanel;
        this.f180239b = (RelativeLayout) voiceTextPanel.findViewById(R.id.d3z);
        FrameLayout frameLayout = (FrameLayout) voiceTextPanel.findViewById(R.id.enc);
        this.f180240c = frameLayout;
        frameLayout.setOnTouchListener(new a());
        this.f180241d = (VoiceTextEditScrollerView) voiceTextPanel.findViewById(R.id.content);
    }

    public void g(int i3, int i16, int i17, int i18, int i19) {
        this.f180241d.setPanelActionDownPos(i16, i18);
    }

    public void h() {
        this.f180241d.setListener(null);
        n(0);
    }

    public void i() {
        this.f180239b.setVisibility(8);
        this.f180241d.setSlideEnable(false);
    }

    public void j() {
        this.f180239b.setVisibility(0);
        this.f180241d.setSlideEnable(true);
    }

    public void k() {
        this.f180239b.setVisibility(8);
    }

    public void l(boolean z16) {
        this.f180241d.setSlideEnable(z16);
    }

    public void m(int i3) {
        this.f180241d.setMaxHeight(i3);
    }

    public void n(int i3) {
        VoiceTextEditScrollerView voiceTextEditScrollerView = this.f180241d;
        voiceTextEditScrollerView.setPadding(voiceTextEditScrollerView.getLeft(), i3, this.f180241d.getPaddingRight(), this.f180241d.getPaddingBottom());
    }
}
