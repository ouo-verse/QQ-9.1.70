package com.qq.e.comm.plugin.base.ad.clickcomponent.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.base.media.video.i;
import com.qq.e.comm.plugin.base.widget.b;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.ba;
import com.qq.e.comm.plugin.k.n;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.nativ.MediaView;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h extends FrameLayout implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.qq.e.comm.plugin.base.widget.b f38737a;

    /* renamed from: b, reason: collision with root package name */
    private g f38738b;

    /* renamed from: c, reason: collision with root package name */
    private MediaView f38739c;

    /* renamed from: d, reason: collision with root package name */
    private final a f38740d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f38741e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f38742f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38743g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f38744h;

    /* renamed from: i, reason: collision with root package name */
    private int f38745i;

    /* renamed from: j, reason: collision with root package name */
    private int f38746j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f38747k;

    /* renamed from: l, reason: collision with root package name */
    private com.qq.e.comm.plugin.stat.b f38748l;

    /* renamed from: m, reason: collision with root package name */
    private long f38749m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f38750n;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<h> f38752a;

        public a(Looper looper, WeakReference<h> weakReference) {
            super(looper);
            this.f38752a = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<h> weakReference;
            int i3 = message.what;
            if (i3 != 10) {
                if (i3 == 11 && (weakReference = this.f38752a) != null && weakReference.get() != null && this.f38752a.get().f38741e) {
                    this.f38752a.get().c();
                    return;
                }
                return;
            }
            WeakReference<h> weakReference2 = this.f38752a;
            if (weakReference2 != null && weakReference2.get() != null && !this.f38752a.get().f38741e) {
                this.f38752a.get().b();
            }
        }
    }

    public h(Context context, ViewGroup viewGroup) {
        super(context);
        this.f38741e = false;
        this.f38742f = true;
        this.f38743g = false;
        this.f38744h = false;
        com.qq.e.comm.plugin.base.widget.b bVar = new com.qq.e.comm.plugin.base.widget.b(viewGroup, this);
        this.f38737a = bVar;
        bVar.a(ak.a(context, 12), ak.a(context, 12), n.f(context), ak.a(context, 12));
        this.f38740d = new a(Looper.getMainLooper(), new WeakReference(this));
        this.f38750n = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f38737a.b(this, motionEvent);
                }
            } else if (!this.f38737a.c(this, motionEvent)) {
                g gVar = this.f38738b;
                if (gVar != null) {
                    gVar.d(true);
                    if (this.f38738b.f38706d != null) {
                        this.f38738b.f38706d.a(false);
                    }
                }
            } else {
                this.f38744h = true;
            }
        } else {
            g gVar2 = this.f38738b;
            if (gVar2 != null) {
                gVar2.d(false);
                if (this.f38738b.f38706d != null) {
                    this.f38738b.f38706d.a(true);
                }
            }
            this.f38737a.a(this, motionEvent);
        }
        GDTLogger.d("VideoFloatingWrapper onInterceptTouchEvent " + motionEvent.getAction());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        GDTLogger.d("VideoFloatingWrapper show");
        g gVar = this.f38738b;
        if (gVar == null) {
            return;
        }
        if (this.f38743g) {
            GDTLogger.d("user had closed float video");
            return;
        }
        ViewGroup b16 = gVar.b();
        if (b16 != null && this.f38738b.z() != null) {
            MediaView z16 = this.f38738b.z();
            this.f38739c = z16;
            b16.removeView(z16);
        }
        MediaView mediaView = this.f38739c;
        if (mediaView != null) {
            ba.a(mediaView);
            addView(this.f38739c, 0, new FrameLayout.LayoutParams(-1, -1));
            this.f38738b.c(12);
            com.qq.e.comm.plugin.base.media.video.b bVar = this.f38738b.f38705c;
            if (bVar != null) {
                bVar.d();
            }
            this.f38738b.t();
            if (this.f38747k == null) {
                ImageView imageView = new ImageView(getContext());
                this.f38747k = imageView;
                imageView.setImageBitmap(i.a(getContext()));
                this.f38747k.setOnClickListener(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.base.ad.clickcomponent.e.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        h.this.f38743g = true;
                        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
                        cVar.a("cost_time", Long.valueOf((System.currentTimeMillis() - h.this.f38749m) / 1000));
                        cVar.a("floatingViewOriginX", Float.valueOf(h.this.getX()));
                        cVar.a("floatingViewOriginY", Float.valueOf(h.this.getY()));
                        StatTracer.trackEvent(1502002, 0, h.this.f38748l, cVar);
                        h.this.c();
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 20), ak.a(getContext(), 20));
                layoutParams.gravity = 53;
                layoutParams.setMargins(0, ak.a(getContext(), 2), ak.a(getContext(), 2), 0);
                this.f38747k.setLayoutParams(layoutParams);
                addView(this.f38747k, layoutParams);
            }
        }
        if (this.f38742f) {
            StatTracer.trackEvent(gdt_analysis_event.EVENT_JUMP_OLYMPIC_INTER_PAGE, 0, this.f38748l, (com.qq.e.comm.plugin.stat.c) null);
            this.f38742f = false;
        }
        this.f38741e = true;
        this.f38749m = System.currentTimeMillis();
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        GDTLogger.d("VideoFloatingWrapper dismiss");
        if (this.f38738b == null) {
            return;
        }
        MediaView mediaView = this.f38739c;
        if (mediaView != null) {
            removeView(mediaView);
            if (this.f38750n) {
                this.f38738b.c();
            }
            ViewGroup b16 = this.f38738b.b();
            if (b16 != null) {
                this.f38738b.c(7);
                if (this.f38738b.a() != 0) {
                    try {
                        ba.a(this.f38739c);
                        b16.addView(this.f38739c, 0, new RelativeLayout.LayoutParams(-1, this.f38738b.a()));
                    } catch (Throwable th5) {
                        GDTLogger.e(th5.getMessage());
                    }
                }
            }
        }
        this.f38744h = false;
        this.f38741e = false;
        setVisibility(8);
    }

    public void a(g gVar) {
        this.f38738b = gVar;
    }

    public void a(com.qq.e.comm.plugin.stat.b bVar) {
        this.f38748l = bVar;
    }

    @Override // com.qq.e.comm.plugin.base.widget.b.a
    public void a(View view) {
        GDTLogger.d("dragStart");
    }

    @Override // com.qq.e.comm.plugin.base.widget.b.a
    public void a(View view, int i3, int i16, int i17, int i18) {
        GDTLogger.d(HippyPagerPageChangeListener.DRAGGING);
        this.f38745i = i3;
        this.f38746j = i16;
    }

    public void a(int i3) {
        Message obtain = Message.obtain();
        obtain.what = i3;
        this.f38740d.sendMessage(obtain);
    }

    public boolean a() {
        return this.f38744h;
    }

    @Override // com.qq.e.comm.plugin.base.widget.b.a
    public void b(View view) {
        GDTLogger.d("dragEnd");
        if (equals(view)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(getMeasuredWidth(), getMeasuredHeight());
            layoutParams.setMargins(this.f38745i, this.f38746j - n.f(getContext()), 0, 0);
            setLayoutParams(layoutParams);
        }
    }
}
