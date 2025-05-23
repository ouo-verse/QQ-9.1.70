package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.ag;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoodleMsgLayout extends BaseDoodleMsgLayout implements e, com.tencent.mobileqq.scribble.b, GifDrawable.OnGIFPlayOnceListener {
    private ImageView C;
    private boolean D;
    private int E;
    private int F;
    private String G;
    private int H;
    private int I;
    private boolean J;
    private WeakReference<c> K;
    private boolean L;
    private boolean M;
    private boolean N;
    private b P;

    /* renamed from: d, reason: collision with root package name */
    private int f178364d;

    /* renamed from: e, reason: collision with root package name */
    private DoodleMsgView f178365e;

    /* renamed from: f, reason: collision with root package name */
    private URLImageView f178366f;

    /* renamed from: h, reason: collision with root package name */
    private URLImageView f178367h;

    /* renamed from: i, reason: collision with root package name */
    private URLImageView f178368i;

    /* renamed from: m, reason: collision with root package name */
    private URLDrawableDownListener f178369m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ DoodleMsgLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            final Bitmap g16 = com.tencent.mobileqq.util.j.g(BaseApplication.getContext().getResources(), R.drawable.common_loading6_0);
            if (g16 != null) {
                ImageCacheHelper.f98636a.i("aio_doodle_progress", g16, Business.AIO);
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass2.this.this$0.C != null) {
                        ag agVar = new ag(g16, 0, false);
                        agVar.setBounds(new Rect(0, 0, Utils.n(19.0f, AnonymousClass2.this.this$0.getResources()), Utils.n(19.0f, AnonymousClass2.this.this$0.getResources())));
                        AnonymousClass2.this.this$0.C.setImageDrawable(agVar);
                    }
                    AnonymousClass2.this.this$0.M = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        boolean f178379a = false;

        /* renamed from: b, reason: collision with root package name */
        boolean f178380b = false;

        /* renamed from: c, reason: collision with root package name */
        String f178381c;

        /* renamed from: d, reason: collision with root package name */
        int f178382d;

        /* renamed from: e, reason: collision with root package name */
        boolean f178383e;

        b() {
        }
    }

    public DoodleMsgLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178364d = 0;
        this.E = 0;
        this.H = 0;
        this.I = 0;
        this.M = false;
        this.N = false;
        this.P = new b();
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgLayout", 2, "changeStateUI:" + this.G + " state:" + i3);
        }
        this.f178364d = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        u(1, false);
                        DoodleMsgView doodleMsgView = this.f178365e;
                        if (doodleMsgView != null) {
                            doodleMsgView.setVisibility(0);
                        }
                        if (this.J) {
                            u(3, false);
                            u(2, true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                u(1, false);
                DoodleMsgView doodleMsgView2 = this.f178365e;
                if (doodleMsgView2 != null) {
                    doodleMsgView2.setVisibility(0);
                    this.f178365e.n();
                }
                u(3, true);
                u(2, false);
                return;
            }
            u(1, true);
            DoodleMsgView doodleMsgView3 = this.f178365e;
            if (doodleMsgView3 != null) {
                doodleMsgView3.setVisibility(4);
            }
            u(2, false);
            u(3, false);
            return;
        }
        u(4, false);
        DoodleMsgView doodleMsgView4 = this.f178365e;
        if (doodleMsgView4 != null) {
            doodleMsgView4.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        o(this.f178364d);
    }

    private void r() {
        QLog.d("DoodleMsgLayout", 2, "init begin");
        if (QQTheme.isNowThemeSimpleNight()) {
            setBackgroundResource(R.drawable.f162431lm1);
        }
        this.f178369m = new a();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158212ah);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158214aj);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.f158213ai);
        int dimensionPixelSize4 = getResources().getDimensionPixelSize(R.dimen.f158211ag);
        int i3 = (int) (min * 0.544f);
        this.H = i3;
        int i16 = (int) ((i3 * 1.0f) / 1.1333333f);
        this.I = i16;
        int i17 = (i3 - dimensionPixelSize) - dimensionPixelSize3;
        int i18 = (i16 - dimensionPixelSize4) - dimensionPixelSize2;
        float f16 = i17;
        float f17 = i18;
        if ((1.0f * f16) / f17 > 1.1333333f) {
            i17 = (int) (f17 * 1.1333333f);
        } else {
            i18 = (int) (f16 / 1.1333333f);
        }
        if (this.f178368i == null) {
            this.f178368i = new URLImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i17, i18);
            layoutParams.addRule(13);
            layoutParams.setMargins(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
            addView(this.f178368i, layoutParams);
            u(3, false);
        }
        if (this.f178366f == null) {
            this.f178366f = new URLImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i17, i18);
            layoutParams2.addRule(13);
            layoutParams2.setMargins(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
            addView(this.f178366f, layoutParams2);
            this.f178366f.setURLDrawableDownListener(this.f178369m);
            u(1, false);
        }
        if (this.f178367h == null) {
            this.f178367h = new URLImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i17, i18);
            layoutParams3.addRule(13);
            layoutParams3.setMargins(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
            addView(this.f178367h, layoutParams3);
            this.f178367h.setURLDrawableDownListener(this.f178369m);
            u(2, false);
        }
        QLog.d("DoodleMsgLayout", 2, "brefor crate DoodleMsgView ");
        if (this.f178365e == null) {
            this.f178365e = new DoodleMsgView(getContext(), null);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i17, i18);
            layoutParams4.addRule(13);
            layoutParams4.setMargins(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
            this.f178365e.setLayoutParams(layoutParams4);
            this.f178365e.setBackgroundColor(getResources().getColor(R.color.ajr));
            addView(this.f178365e);
            this.f178365e.q(this, i17, i18);
        }
        setLayoutParams(new RelativeLayout.LayoutParams(this.H, this.I));
    }

    private void t(int i3) {
        URLImageView uRLImageView;
        if (i3 > 0) {
            this.J = false;
            Drawable j3 = DoodleResHelper.k().j(1, i3, true);
            if (j3 != null && (uRLImageView = this.f178366f) != null) {
                uRLImageView.setImageDrawable(j3);
                ((URLDrawable) j3).setIndividualPause(true);
            }
            Drawable j16 = DoodleResHelper.k().j(2, i3, false);
            URLImageView uRLImageView2 = this.f178368i;
            if (uRLImageView2 != null && j16 != null) {
                uRLImageView2.setImageDrawable(j16);
                ((URLDrawable) j16).startDownload();
            }
            Drawable j17 = DoodleResHelper.k().j(2, i3, true);
            URLImageView uRLImageView3 = this.f178367h;
            if (uRLImageView3 != null && j17 != null) {
                uRLImageView3.setImageDrawable(j17);
                ((URLDrawable) j17).startDownload();
                return;
            }
            return;
        }
        URLImageView uRLImageView4 = this.f178366f;
        if (uRLImageView4 != null) {
            uRLImageView4.setImageDrawable(null);
        }
        URLImageView uRLImageView5 = this.f178368i;
        if (uRLImageView5 != null) {
            uRLImageView5.setImageDrawable(null);
        }
        URLImageView uRLImageView6 = this.f178367h;
        if (uRLImageView6 != null) {
            uRLImageView6.setImageDrawable(null);
        }
        this.J = true;
    }

    private void u(int i3, boolean z16) {
        URLImageView uRLImageView;
        if (i3 == 4) {
            u(1, z16);
            u(2, z16);
            u(3, z16);
            return;
        }
        if (i3 == 1) {
            uRLImageView = this.f178366f;
        } else if (i3 == 2) {
            uRLImageView = this.f178367h;
        } else if (i3 == 3) {
            uRLImageView = this.f178368i;
        } else {
            uRLImageView = null;
        }
        if (uRLImageView != null) {
            if (!z16) {
                uRLImageView.setVisibility(8);
            } else if (this.E > 0) {
                uRLImageView.setVisibility(0);
            } else {
                uRLImageView.setVisibility(4);
            }
        }
    }

    private void v() {
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView != null) {
            doodleMsgView.z();
            this.f178365e = null;
        }
        this.f178366f = null;
        this.f178368i = null;
        this.f178367h = null;
        this.f178369m = null;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.e
    public void a(int i3) {
        c cVar;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgLayout", 2, "onInitState:" + this.G + " state:" + i3);
        }
        WeakReference<c> weakReference = this.K;
        if (weakReference != null) {
            cVar = weakReference.get();
        } else {
            cVar = null;
        }
        if (i3 != -1 && i3 != 4 && (i16 = this.F) != 2) {
            if (i3 == 0 && i16 == 0) {
                if (this.D) {
                    o(3);
                } else {
                    o(0);
                }
                if (cVar != null) {
                    cVar.a(this, 0);
                }
                if (this.L) {
                    play();
                    return;
                }
                return;
            }
            if (cVar != null) {
                cVar.a(this, 1);
            }
            QLog.i("DoodleMsgLayout", 2, "onLoadData end");
            return;
        }
        o(0);
        this.L = false;
        if (i3 != -1 && cVar != null) {
            cVar.a(this, 2);
        }
    }

    @Override // com.tencent.mobileqq.scribble.b
    public void b(View view, int i3, com.tencent.mobileqq.scribble.c cVar, int i16) {
        c cVar2;
        if (cVar != null && view != null && i3 == 2 && cVar.f282547b == this.E) {
            if (QLog.isColorLevel()) {
                QLog.i("DoodleMsgLayout", 2, "handleMessage begin:" + i16);
            }
            if (1 == i16) {
                this.F = 0;
                t(this.E);
            } else if (4 == i16) {
                this.F = 1;
            } else {
                this.F = 2;
            }
            int q16 = q();
            if (q16 == 0) {
                if (this.D) {
                    o(3);
                } else {
                    o(0);
                }
            } else if (q16 == 2 || q16 == -1) {
                o(0);
            }
            WeakReference<c> weakReference = this.K;
            if (weakReference != null) {
                cVar2 = weakReference.get();
            } else {
                cVar2 = null;
            }
            if (cVar2 != null) {
                cVar2.a(this, q16);
                QLog.i("DoodleMsgLayout", 2, "handleMessage end:" + q16);
            }
            if (q16 == 0 && this.L) {
                play();
            }
        }
    }

    @Override // fb1.a
    public void c(boolean z16) {
        DoodleMsgView doodleMsgView;
        this.P.f178379a = z16;
        DoodleMsgView doodleMsgView2 = this.f178365e;
        if (doodleMsgView2 != null) {
            doodleMsgView2.t(z16);
        }
        if (!z16) {
            b bVar = this.P;
            if (bVar.f178380b) {
                if (!s(bVar.f178381c, bVar.f178382d, bVar.f178383e) && (doodleMsgView = this.f178365e) != null) {
                    a(doodleMsgView.p());
                }
                this.P.f178380b = false;
                return;
            }
            return;
        }
        b bVar2 = this.P;
        bVar2.f178382d = this.E;
        bVar2.f178383e = this.D;
        bVar2.f178381c = this.G;
        bVar2.f178380b = true;
    }

    @Override // fb1.a
    public boolean isDataValid() {
        return !TextUtils.isEmpty(this.G);
    }

    @Override // fb1.a
    public boolean isPlaying() {
        int i3 = this.f178364d;
        if (i3 != 0 && i3 != 3) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        v();
        super.onDetachedFromWindow();
        QLog.i("DoodleMsgLayout", 2, NodeProps.ON_DETACHED_FROM_WINDOW);
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.e
    public void onPlayEnd() {
        o(3);
        URLImageView uRLImageView = this.f178367h;
        if (uRLImageView != null) {
            Drawable drawable = uRLImageView.getDrawable();
            if (drawable instanceof URLDrawable) {
                URLDrawable uRLDrawable = (URLDrawable) drawable;
                uRLDrawable.setIndividualPause(false);
                Drawable currDrawable = uRLDrawable.getCurrDrawable();
                if (currDrawable instanceof GifDrawable) {
                    ((GifDrawable) currDrawable).getImage().reset();
                }
            }
        }
        URLImageView uRLImageView2 = this.f178366f;
        if (uRLImageView2 != null) {
            Drawable drawable2 = uRLImageView2.getDrawable();
            if (drawable2 instanceof URLDrawable) {
                ((URLDrawable) drawable2).setIndividualPause(false);
            }
        }
    }

    @Override // com.tencent.image.GifDrawable.OnGIFPlayOnceListener
    public void onPlayOnce() {
        Drawable drawable;
        o(2);
        URLImageView uRLImageView = this.f178366f;
        if (uRLImageView != null && (drawable = uRLImageView.getDrawable()) != null && (drawable instanceof URLDrawable)) {
            URLDrawable uRLDrawable = (URLDrawable) drawable;
            uRLDrawable.setIndividualPause(true);
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            if (currDrawable instanceof GifDrawable) {
                ((GifDrawable) currDrawable).getImage().reset();
            }
        }
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView != null) {
            doodleMsgView.u(100L);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (i3 != 0) {
            stop();
        }
    }

    @Override // fb1.a
    public void play() {
        if (q() != 0) {
            this.L = true;
            return;
        }
        int i3 = this.f178364d;
        if (i3 != 0 || i3 != 3) {
            stop();
        }
        this.L = false;
        if (this.E > 0) {
            URLImageView uRLImageView = this.f178366f;
            if (uRLImageView != null) {
                Drawable drawable = uRLImageView.getDrawable();
                if (drawable != null && (drawable instanceof URLDrawable)) {
                    URLDrawable uRLDrawable = (URLDrawable) drawable;
                    Drawable currDrawable = uRLDrawable.getCurrDrawable();
                    if (currDrawable instanceof GifDrawable) {
                        ((GifDrawable) currDrawable).getImage().reset();
                    }
                    uRLDrawable.setIndividualPause(false);
                    o(1);
                    return;
                }
                o(0);
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final Drawable j3 = DoodleResHelper.k().j(1, DoodleMsgLayout.this.E, true);
                        if (j3 != null) {
                            ((URLDrawable) j3).setIndividualPause(true);
                        }
                        final Drawable j16 = DoodleResHelper.k().j(2, DoodleMsgLayout.this.E, false);
                        if (j16 != null) {
                            ((URLDrawable) j16).startDownload();
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QLog.d("DoodleMsgLayout", 2, "setDoodleContent start update drawable:" + DoodleMsgLayout.this.E);
                                if (j3 != null && DoodleMsgLayout.this.f178366f != null) {
                                    DoodleMsgLayout.this.f178366f.setImageDrawable(j3);
                                }
                                if (DoodleMsgLayout.this.f178368i != null) {
                                    DoodleMsgLayout.this.f178368i.setImageDrawable(j16);
                                }
                                Drawable drawable2 = j3;
                                if (drawable2 != null) {
                                    Drawable currDrawable2 = ((URLDrawable) drawable2).getCurrDrawable();
                                    if (currDrawable2 instanceof GifDrawable) {
                                        ((GifDrawable) currDrawable2).getImage().reset();
                                    }
                                    ((URLDrawable) j3).setIndividualPause(false);
                                }
                                DoodleMsgLayout.this.o(1);
                            }
                        });
                    }
                }, 5, null, true);
                return;
            }
            return;
        }
        o(2);
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView != null) {
            doodleMsgView.u(0L);
        }
    }

    public int q() {
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView == null) {
            return 2;
        }
        int p16 = doodleMsgView.p();
        int i3 = -1;
        if (p16 != -1) {
            if (p16 != 0) {
                i3 = 1;
                if (p16 != 1 && p16 != 2 && p16 != 3) {
                    return 2;
                }
                int i16 = this.F;
                if (i16 != 0 && (i16 == 2 || i16 != 1)) {
                    return 2;
                }
            } else {
                return this.F;
            }
        }
        return i3;
    }

    public boolean s(String str, final int i3, boolean z16) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgLayout", 2, "setDoodleContent :" + str + " GifID:" + i3 + " prepare:" + z16);
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            this.P.f178380b = false;
            this.G = null;
            this.E = 0;
            this.F = 0;
            o(0);
            DoodleMsgView doodleMsgView = this.f178365e;
            if (doodleMsgView != null) {
                doodleMsgView.n();
                this.f178365e.setContent(null, false);
            }
            return false;
        }
        if (this.E == i3 && (str2 = this.G) != null && str2.equals(str)) {
            this.P.f178380b = false;
            if (isPlaying()) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleMsgLayout", 2, "setDoodleContent isplaying, return:");
                }
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DoodleMsgLayout", 2, "setDoodleContent same data, prepare old:" + this.D);
            }
            if (this.E > 0 && this.F == 2) {
                DoodleResHelper.k().p(1, this.E, this, this);
                this.F = 1;
            }
            this.D = z16;
            o(0);
            DoodleMsgView doodleMsgView2 = this.f178365e;
            if (doodleMsgView2 != null) {
                doodleMsgView2.setContent(str, z16);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgLayout", 2, "setDoodleContent old data:" + this.G + " GifID:" + this.E + " prepare:" + this.D);
        }
        b bVar = this.P;
        if (bVar.f178379a) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleMsgLayout", 2, "pending data, return");
            }
            b bVar2 = this.P;
            bVar2.f178381c = str;
            bVar2.f178382d = i3;
            bVar2.f178383e = z16;
            bVar2.f178380b = true;
            o(0);
            DoodleMsgView doodleMsgView3 = this.f178365e;
            if (doodleMsgView3 != null) {
                doodleMsgView3.t(true);
            }
            return true;
        }
        bVar.f178380b = false;
        DoodleMsgView doodleMsgView4 = this.f178365e;
        if (doodleMsgView4 != null) {
            doodleMsgView4.t(false);
        }
        this.G = str;
        this.D = z16;
        if (i3 > 0) {
            if (i3 == this.E) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleMsgLayout", 2, "setDoodleContent use same template:" + this.E + " status:" + this.F + "loopOK:" + this.J);
                }
            } else {
                this.E = i3;
                this.F = 1;
                this.J = false;
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("DoodleMsgLayout", 2, "setDoodleContent start create drawable:" + i3);
                        if (!DoodleResHelper.k().l(1, i3)) {
                            DoodleResHelper k3 = DoodleResHelper.k();
                            int i16 = i3;
                            DoodleMsgLayout doodleMsgLayout = DoodleMsgLayout.this;
                            k3.p(1, i16, doodleMsgLayout, doodleMsgLayout);
                            return;
                        }
                        final Drawable j3 = DoodleResHelper.k().j(2, i3, true);
                        if (j3 != null) {
                            ((URLDrawable) j3).startDownload();
                        }
                        if (i3 != DoodleMsgLayout.this.E) {
                            return;
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QLog.d("DoodleMsgLayout", 2, "setDoodleContent start update drawable:" + i3);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                if (i3 != DoodleMsgLayout.this.E) {
                                    return;
                                }
                                if (DoodleMsgLayout.this.f178366f != null) {
                                    DoodleMsgLayout.this.f178366f.setImageDrawable(null);
                                }
                                if (DoodleMsgLayout.this.f178368i != null) {
                                    DoodleMsgLayout.this.f178368i.setImageDrawable(null);
                                }
                                if (DoodleMsgLayout.this.f178367h != null) {
                                    DoodleMsgLayout.this.f178367h.setImageDrawable(j3);
                                }
                                DoodleMsgLayout.this.F = 0;
                                if (DoodleMsgLayout.this.f178365e != null) {
                                    DoodleMsgLayout doodleMsgLayout2 = DoodleMsgLayout.this;
                                    doodleMsgLayout2.a(doodleMsgLayout2.f178365e.p());
                                }
                                QLog.d("DoodleMsgLayout", 2, "setDoodleContent finish update drawable:" + i3);
                            }
                        });
                        QLog.d("DoodleMsgLayout", 2, "setDoodleContent finish create drawable:" + i3);
                    }
                }, 5, null, true);
            }
        } else {
            this.E = 0;
            this.F = 0;
            t(i3);
        }
        o(0);
        DoodleMsgView doodleMsgView5 = this.f178365e;
        if (doodleMsgView5 != null) {
            doodleMsgView5.setContent(str, z16);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout
    public void setOperateListener(View.OnClickListener onClickListener, View.OnTouchListener onTouchListener, View.OnLongClickListener onLongClickListener, c cVar) {
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView != null) {
            if (onClickListener != null) {
                doodleMsgView.setOnClickListener(onClickListener);
            }
            if (onTouchListener != null) {
                this.f178365e.setOnTouchListener(onTouchListener);
            }
            if (onLongClickListener != null) {
                this.f178365e.setOnLongClickListener(onLongClickListener);
            }
        }
        URLImageView uRLImageView = this.f178366f;
        if (uRLImageView != null) {
            if (onClickListener != null) {
                uRLImageView.setOnClickListener(onClickListener);
            }
            if (onTouchListener != null) {
                this.f178366f.setOnTouchListener(onTouchListener);
            }
            if (onLongClickListener != null) {
                this.f178366f.setOnLongClickListener(onLongClickListener);
            }
        }
        URLImageView uRLImageView2 = this.f178368i;
        if (uRLImageView2 != null) {
            if (onClickListener != null) {
                uRLImageView2.setOnClickListener(onClickListener);
            }
            if (onTouchListener != null) {
                this.f178368i.setOnTouchListener(onTouchListener);
            }
            if (onLongClickListener != null) {
                this.f178368i.setOnLongClickListener(onLongClickListener);
            }
        }
        this.K = new WeakReference<>(cVar);
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout
    public void setTalkBack(String str) {
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView != null) {
            doodleMsgView.setContentDescription(str);
        }
    }

    @Override // fb1.a
    public void stop() {
        this.L = false;
        o(3);
        DoodleMsgView doodleMsgView = this.f178365e;
        if (doodleMsgView != null) {
            doodleMsgView.x();
        }
        URLImageView uRLImageView = this.f178366f;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(null);
        }
        URLImageView uRLImageView2 = this.f178368i;
        if (uRLImageView2 != null) {
            uRLImageView2.setImageDrawable(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.e
    public void onPlayStart() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements URLDrawableDownListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            if (view == DoodleMsgLayout.this.f178367h) {
                DoodleMsgLayout.this.J = true;
                DoodleMsgLayout.this.p();
            } else if (view != DoodleMsgLayout.this.f178366f) {
                URLImageView unused = DoodleMsgLayout.this.f178368i;
            } else {
                ((GifDrawable) uRLDrawable.getCurrDrawable()).setGIFPlayOnceListener(DoodleMsgLayout.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }
}
