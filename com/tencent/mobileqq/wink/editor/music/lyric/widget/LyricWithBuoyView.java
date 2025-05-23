package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.b;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricWithBuoyView extends FrameLayout {
    private volatile boolean C;
    private d D;
    private Handler E;
    float F;
    float G;

    /* renamed from: d, reason: collision with root package name */
    public LyricViewDetail f321087d;

    /* renamed from: e, reason: collision with root package name */
    public LyricViewController f321088e;

    /* renamed from: f, reason: collision with root package name */
    public LyricViewInternalDetail f321089f;

    /* renamed from: h, reason: collision with root package name */
    private View f321090h;

    /* renamed from: i, reason: collision with root package name */
    private View f321091i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f321092m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                LyricWithBuoyView.this.c();
            } else if (i3 == 2) {
                LyricWithBuoyView.this.g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        float f321094d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        float f321095e = 0.0f;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && Math.abs(motionEvent.getRawX() - this.f321094d) < 10.0f && Math.abs(motionEvent.getRawY() - this.f321095e) < 10.0f) {
                    if (LyricWithBuoyView.this.D != null) {
                        LyricWithBuoyView.this.D.c();
                    } else {
                        ms.a.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
                    }
                    return true;
                }
                return false;
            }
            this.f321094d = motionEvent.getRawX();
            this.f321095e = motionEvent.getRawY();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ms.a.a("LyricWithBuoyView", "LyricWithBuoyView onClick()");
            if (LyricWithBuoyView.this.D != null) {
                LyricWithBuoyView.this.D.c();
            } else {
                ms.a.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface d {
        void a(int i3);

        void c();
    }

    public LyricWithBuoyView(Context context) {
        this(context, null, 0);
    }

    public static String h(int i3) {
        return new SimpleDateFormat("mm:ss").format(Integer.valueOf(i3));
    }

    public TextView b() {
        return this.f321092m;
    }

    public void c() {
        View view = this.f321091i;
        if (view == null) {
            ms.a.i("LyricWithBuoyView", "handlerHideSelection() mMusicLyricLineView == null.");
        } else {
            view.setVisibility(4);
        }
        LyricViewController lyricViewController = this.f321088e;
        if (lyricViewController != null) {
            lyricViewController.r(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str, String str2, int i3, LyricViewController.c cVar) {
        d73.b b16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            LyricViewController lyricViewController = this.f321088e;
            if (lyricViewController != null) {
                lyricViewController.s();
            }
            d73.b bVar = null;
            if (TextUtils.equals(str2.toUpperCase(), LyricParseHelper.LYRIC_FROMAT_LRC)) {
                b16 = com.tencent.mobileqq.wink.editor.music.lyric.a.b(str, false);
                LyricViewController lyricViewController2 = this.f321088e;
                if (lyricViewController2 != null) {
                    lyricViewController2.p(null, b16, null);
                }
            } else {
                if (TextUtils.equals(str2.toUpperCase(), LyricParseHelper.LYRIC_FROMAT_QRC)) {
                    b16 = com.tencent.mobileqq.wink.editor.music.lyric.a.b(str, true);
                    LyricViewController lyricViewController3 = this.f321088e;
                    if (lyricViewController3 != null) {
                        lyricViewController3.p(b16, null, null);
                    }
                }
                if (bVar == null) {
                    ms.a.a("LyricWithBuoyView", "initLyricView() startTime => " + i3 + ",lyricFormat:" + str2);
                    LyricViewController lyricViewController4 = this.f321088e;
                    if (lyricViewController4 != null) {
                        lyricViewController4.o(false);
                        this.f321088e.n(i3, true);
                        this.f321088e.q(cVar);
                        return;
                    }
                    return;
                }
                return;
            }
            bVar = b16;
            if (bVar == null) {
            }
        } else {
            ms.a.a("LyricWithBuoyView", "initLyricView() lyric info is empty.");
        }
    }

    public void e(int i3) {
        LyricViewController lyricViewController = this.f321088e;
        if (lyricViewController != null) {
            lyricViewController.g(i3);
        }
    }

    public void f(b.a aVar) {
        LyricViewController lyricViewController = this.f321088e;
        if (lyricViewController == null) {
            ms.a.i("LyricWithBuoyView", "registerScrollListener() mLyricViewController == null.");
        } else {
            lyricViewController.m(aVar);
        }
    }

    public void g() {
        View view = this.f321091i;
        if (view == null) {
            ms.a.i("LyricWithBuoyView", "showLyricSelectedLine() mMusicLyricLineView == null.");
        } else if (view.getVisibility() != 0) {
            this.f321091i.setVisibility(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams;
        super.onMeasure(i3, i16);
        int x16 = ((LyricViewInternalDetail) this.f321087d.findViewById(R.id.l36)).x();
        View view = this.f321091i;
        if (view != null) {
            x16 -= view.getHeight();
        }
        View view2 = this.f321091i;
        if (view2 == null) {
            layoutParams = null;
        } else {
            layoutParams = view2.getLayoutParams();
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.leftMargin, x16, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.C) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_MOVE");
                    this.f321092m.setText(h(this.f321088e.f()));
                    invalidate();
                }
            } else {
                Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_UP");
                this.E.sendEmptyMessageDelayed(1, 3000L);
                if (Math.abs(motionEvent.getX() - this.F) < 10.0f && Math.abs(motionEvent.getY() - this.G) < 10.0f) {
                    this.E.removeMessages(2);
                    this.E.sendEmptyMessage(1);
                    long v3 = this.f321089f.v(this.f321088e.e(motionEvent.getY()));
                    d dVar = this.D;
                    if (dVar != null) {
                        dVar.a((int) v3);
                    }
                    Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_UP click time:" + v3);
                }
            }
        } else {
            Log.d("LyricWithBuoyView", "onTouchEvent -> ACTION_DOWN");
            this.E.removeMessages(1);
            this.E.sendEmptyMessageDelayed(2, 100L);
            LyricViewController lyricViewController = this.f321088e;
            if (lyricViewController != null) {
                lyricViewController.r(true);
            }
            this.F = motionEvent.getX();
            this.G = motionEvent.getY();
        }
        this.f321087d.c(motionEvent);
        return true;
    }

    public void setLyric(d73.b bVar, d73.b bVar2, d73.b bVar3) {
        LyricViewController lyricViewController = this.f321088e;
        if (lyricViewController == null) {
            ms.a.i("LyricWithBuoyView", "setLyric() mLyricViewController == null.");
        } else {
            lyricViewController.p(bVar, bVar2, bVar3);
        }
    }

    public void setOnLyricWithBuoyViewOperationListener(d dVar) {
        this.D = dVar;
    }

    public void setSelectedFlag(int i3, boolean z16) {
        LyricViewController lyricViewController = this.f321088e;
        if (lyricViewController != null) {
            lyricViewController.n(i3, true);
            c();
        }
    }

    public LyricWithBuoyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LyricWithBuoyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f321090h = null;
        this.f321091i = null;
        this.f321092m = null;
        this.C = true;
        this.E = new a(Looper.getMainLooper());
        this.F = 0.0f;
        this.G = 0.0f;
        View inflate = LayoutInflater.from(context).inflate(R.layout.i5c, this);
        LyricViewDetail lyricViewDetail = (LyricViewDetail) inflate.findViewById(R.id.tfp);
        this.f321087d = lyricViewDetail;
        this.f321089f = (LyricViewInternalDetail) lyricViewDetail.findViewById(R.id.l36);
        this.f321092m = (TextView) inflate.findViewById(R.id.f109456fv);
        View findViewById = inflate.findViewById(R.id.tfq);
        this.f321090h = findViewById;
        findViewById.setOnTouchListener(new b());
        this.f321090h.setOnClickListener(new c());
        this.f321087d.setIsDealTouchEvent(false);
        this.f321091i = inflate.findViewById(R.id.zka);
        this.f321088e = new LyricViewController(this.f321087d);
    }
}
