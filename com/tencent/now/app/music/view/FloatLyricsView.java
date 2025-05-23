package com.tencent.now.app.music.view;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bm3.b;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.storage.StorageCenter;
import com.tencent.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.R;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.now.app.music.viewmodel.MusicLyricsViewModel;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FloatLyricsView extends LinearLayout {
    public static float H;
    public int C;
    public LyricViewDetail D;
    public TextView E;
    private float F;
    private long G;

    /* renamed from: d, reason: collision with root package name */
    private MusicLyricsViewModel f338050d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f338051e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f338052f;

    /* renamed from: h, reason: collision with root package name */
    private a f338053h;

    /* renamed from: i, reason: collision with root package name */
    private float f338054i;

    /* renamed from: m, reason: collision with root package name */
    private float f338055m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        RectF n();
    }

    public FloatLyricsView(Context context) {
        super(context);
        this.C = 0;
        this.F = 0.0f;
        this.G = System.currentTimeMillis();
        c(context);
    }

    private void c(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        View inflate = View.inflate(getContext(), R.layout.fej, this);
        this.D = (LyricViewDetail) inflate.findViewById(R.id.yvt);
        this.E = (TextView) inflate.findViewById(R.id.yvs);
        this.f338050d = new MusicLyricsViewModel(context, this);
        float f16 = StorageCenter.getFloat("FloatLyricsViewTranslationX", 0.0f);
        float f17 = StorageCenter.getFloat("FloatLyricsViewTranslationY", 0.0f);
        setTranslationX(f16);
        setTranslationY(f17);
    }

    private void d() {
        a aVar = this.f338053h;
        if (aVar != null) {
            RectF n3 = aVar.n();
            if (n3.width() <= 0.0f) {
                return;
            }
            if (getMeasuredWidth() <= 0) {
                measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            }
            float translationX = getTranslationX();
            float translationY = getTranslationY();
            if (translationX < 0.0f) {
                setTranslationX(0.0f);
                StorageCenter.putFloat("FloatLyricsViewTranslationX", 0.0f);
            } else if (translationX + getMeasuredWidth() > n3.width()) {
                LogUtil.i("FloatLyricsView", "initUI\u65f6translationX\u8d85\u51fa\u4e86\u7236\u63a7\u4ef6\u7684\u8303\u56f4", new Object[0]);
                float width = n3.width() - getMeasuredWidth();
                setTranslationX(width);
                StorageCenter.putFloat("FloatLyricsViewTranslationX", width);
            }
            if (translationY < 0.0f) {
                setTranslationY(0.0f);
                StorageCenter.putFloat("FloatLyricsViewTranslationY", 0.0f);
            } else if (translationY + getMeasuredHeight() > n3.height()) {
                LogUtil.i("FloatLyricsView", "initUI\u65f6translationY\u8d85\u51fa\u4e86\u7236\u63a7\u4ef6\u7684\u8303\u56f4", new Object[0]);
                float height = n3.height() - getMeasuredHeight();
                setTranslationY(height);
                StorageCenter.putFloat("FloatLyricsViewTranslationY", height);
            }
        }
    }

    private boolean e(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.D.getVisibility() == 0 && this.F == 0.0f && System.currentTimeMillis() - this.G < 200) {
            return true;
        }
        return false;
    }

    private void g(View view) {
        com.tencent.report.a.f364907a.d(view, true, null, "em_qqlive_music_lyricsarea_click", new HashMap());
    }

    public void a(boolean z16) {
        float f16;
        float y16 = getY() + (getHeight() / 2);
        this.f338052f = this.f338053h.n();
        if (z16) {
            f16 = getContext().getResources().getDisplayMetrics().density * 100.0f;
        } else {
            f16 = 0.0f;
        }
        if (y16 > this.f338052f.height() - f16) {
            if (this.f338052f.height() - f16 < 0.0f) {
                LogUtil.i("FloatLyricsView", "screen height too small", new Object[0]);
            } else {
                setTranslationY(((this.f338052f.height() - (getHeight() / 2)) - getTop()) - f16);
                StorageCenter.putFloat("FloatLyricsViewTranslationY", getTranslationY());
            }
        }
    }

    public MusicLyricsViewModel b() {
        return this.f338050d;
    }

    public void f() {
        d();
    }

    public void h() {
        this.f338050d.h();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MusicLyricsViewModel musicLyricsViewModel = this.f338050d;
        if (musicLyricsViewModel != null) {
            musicLyricsViewModel.p();
            this.f338050d.b();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f338051e = true;
            this.F = 0.0f;
            this.G = System.currentTimeMillis();
            this.f338052f = this.f338053h.n();
            this.f338054i = motionEvent.getRawX();
            this.f338055m = motionEvent.getRawY();
            LogUtil.d("FloatLyricsView", "ACTION_DOWN:  getRawX:" + motionEvent.getRawX() + " getRawY:" + motionEvent.getRawY() + " width:" + getWidth() + " height:" + getHeight() + "  rectf:" + this.f338052f, new Object[0]);
            H = getContext().getResources().getDisplayMetrics().density * 30.0f;
            return true;
        }
        if (motionEvent.getAction() == 2 && this.f338051e) {
            float rawX = motionEvent.getRawX() - this.f338054i;
            float rawY = motionEvent.getRawY() - this.f338055m;
            float x16 = getX() + (getWidth() / 2);
            float y16 = getY() + (getHeight() / 2);
            float f16 = x16 + rawX;
            if (f16 < 0.0f) {
                setTranslationX((0 - (getWidth() / 2)) - getLeft());
            } else if (f16 > this.f338052f.width()) {
                setTranslationX((this.f338052f.width() - (getWidth() / 2)) - getLeft());
            } else {
                setTranslationX(getTranslationX() + rawX);
            }
            float f17 = y16 + rawY;
            float f18 = H;
            if (f17 < f18) {
                setTranslationY((f18 - (getHeight() / 2)) - getTop());
            } else if (getY() + getHeight() + rawY > this.f338052f.height()) {
                setTranslationY((this.f338052f.height() - getHeight()) - getTop());
            } else {
                setTranslationY(getTranslationY() + rawY);
            }
            this.f338054i = motionEvent.getRawX();
            this.f338055m = motionEvent.getRawY();
            this.F = rawX + rawY;
            return true;
        }
        this.f338051e = false;
        float x17 = getX() + (getWidth() / 2);
        float y17 = getY() + (getHeight() / 2);
        if (x17 >= 0.0f && x17 <= this.f338052f.width() && y17 >= H && y17 <= this.f338052f.height()) {
            StorageCenter.putFloat("FloatLyricsViewTranslationX", getTranslationX());
            StorageCenter.putFloat("FloatLyricsViewTranslationY", getTranslationY());
            new dm3.a().e("add_music").d("drag_lyric").c();
        } else {
            LogUtil.i("FloatLyricsView", "outBounds! :  getRawX:" + motionEvent.getRawX() + " getRawY:" + motionEvent.getRawY() + " width:" + getWidth() + " height:" + getHeight() + "  rectf:" + this.f338052f, new Object[0]);
        }
        if (e(motionEvent)) {
            g(this.D);
            b.f();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMusicControl(com.tencent.now.app.music.controller.b bVar) {
        this.f338050d.l(bVar);
    }

    public void setMusicPlayMgr(MusicPlayMgr musicPlayMgr) {
        this.f338050d.m(musicPlayMgr);
    }

    public void setNoLyricsMode() {
        this.f338050d.n();
    }

    public void setParentUIControl(a aVar) {
        this.f338053h = aVar;
        d();
    }

    public FloatLyricsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 0;
        this.F = 0.0f;
        this.G = System.currentTimeMillis();
        c(context);
    }

    public FloatLyricsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = 0;
        this.F = 0.0f;
        this.G = System.currentTimeMillis();
        c(context);
    }
}
