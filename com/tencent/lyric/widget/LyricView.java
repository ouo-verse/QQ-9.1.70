package com.tencent.lyric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class LyricView extends FrameLayout {
    static IPatchRedirector $redirector_;
    protected PointF C;
    protected PointF D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    private Handler H;

    /* renamed from: d, reason: collision with root package name */
    protected LyricViewInternalBase f147106d;

    /* renamed from: e, reason: collision with root package name */
    protected LyricViewScroll f147107e;

    /* renamed from: f, reason: collision with root package name */
    protected d f147108f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f147109h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f147110i;

    /* renamed from: m, reason: collision with root package name */
    protected View.OnClickListener f147111m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LyricView.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
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
    /* loaded from: classes9.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f147110i = true;
        this.C = new PointF();
        this.D = new PointF();
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = new a(Looper.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b51.a.f27923a, 0, 0);
        d dVar = new d();
        this.f147108f = dVar;
        dVar.a(obtainStyledAttributes);
        this.f147109h = obtainStyledAttributes.getBoolean(b51.a.B, false);
        obtainStyledAttributes.recycle();
    }

    public LyricViewInternalBase a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LyricViewInternalBase) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147106d;
    }

    public LyricViewScroll b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LyricViewScroll) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f147107e;
    }

    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f147107e.e(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
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
                if (!this.G && Math.abs(this.C.x - x16) < 10.0f && Math.abs(this.C.y - y16) < 10.0f && (onClickListener = this.f147111m) != null && this.E) {
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
        if (!this.f147110i) {
            return false;
        }
        c(motionEvent);
        return true;
    }

    public void setIsDealTouchEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f147110i = z16;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) onClickListener);
        } else {
            this.f147111m = onClickListener;
        }
    }

    public void setOnLineClickListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
        }
    }

    public void setOnLyricViewLongClickListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar);
        }
    }
}
