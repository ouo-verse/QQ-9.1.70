package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.wink.j;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LyricView extends FrameLayout {
    protected PointF C;
    protected PointF D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    private Handler H;

    /* renamed from: d, reason: collision with root package name */
    protected LyricViewInternalBase f321008d;

    /* renamed from: e, reason: collision with root package name */
    protected LyricViewScroll f321009e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.mobileqq.wink.editor.music.lyric.widget.c f321010f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f321011h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f321012i;

    /* renamed from: m, reason: collision with root package name */
    protected View.OnClickListener f321013m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10) {
                LyricView lyricView = LyricView.this;
                if (Math.abs(lyricView.D.x - lyricView.C.x) < 15.0f) {
                    LyricView lyricView2 = LyricView.this;
                    if (Math.abs(lyricView2.D.y - lyricView2.C.y) < 15.0f) {
                        LyricView.this.getClass();
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f321012i = true;
        this.C = new PointF();
        this.D = new PointF();
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f323168h, 0, 0);
        com.tencent.mobileqq.wink.editor.music.lyric.widget.c cVar = new com.tencent.mobileqq.wink.editor.music.lyric.widget.c();
        this.f321010f = cVar;
        cVar.a(obtainStyledAttributes);
        this.f321011h = obtainStyledAttributes.getBoolean(j.f323352x, false);
        obtainStyledAttributes.recycle();
    }

    public LyricViewInternalBase a() {
        return this.f321008d;
    }

    public LyricViewScroll b() {
        return this.f321009e;
    }

    public boolean c(MotionEvent motionEvent) {
        return this.f321009e.e(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.H.removeMessages(10);
                    }
                } else {
                    this.D.set(x16, y16);
                    if (Math.abs(this.C.x - x16) > 10.0f || Math.abs(this.C.y - y16) > 10.0f) {
                        this.E = false;
                    }
                    if (Math.abs(y16 - this.C.y) > 10.0f) {
                        this.F = false;
                    }
                }
            } else {
                this.H.removeMessages(10);
                if (!this.G && Math.abs(this.C.x - x16) < 10.0f && Math.abs(this.C.y - y16) < 10.0f && (onClickListener = this.f321013m) != null && this.E) {
                    onClickListener.onClick(this);
                }
                if (!this.G) {
                    boolean z16 = this.F;
                }
                this.F = true;
                this.G = false;
                this.C.set(0.0f, 0.0f);
                this.D.set(x16, y16);
                this.E = false;
            }
        } else {
            this.C.set(x16, y16);
            this.D.set(x16, y16);
            this.E = true;
            this.H.sendEmptyMessageDelayed(10, 1000L);
        }
        if (!this.f321012i) {
            return false;
        }
        c(motionEvent);
        return true;
    }

    public void setIsDealTouchEvent(boolean z16) {
        this.f321012i = z16;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f321013m = onClickListener;
    }

    public void setOnLineClickListener(b bVar) {
    }

    public void setOnLyricViewLongClickListener(c cVar) {
    }
}
