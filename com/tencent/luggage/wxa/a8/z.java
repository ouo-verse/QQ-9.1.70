package com.tencent.luggage.wxa.a8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z implements com.tencent.luggage.wxa.ag.i {

    /* renamed from: c, reason: collision with root package name */
    private static final String f120964c = "MicroMsg.AppBrand.XWebVideoContainerChannel4AudioPlay";

    /* renamed from: d, reason: collision with root package name */
    private static com.tencent.luggage.wxa.ag.e f120965d = new a();

    /* renamed from: e, reason: collision with root package name */
    private static WeakReference<byte[]> f120966e = null;

    /* renamed from: a, reason: collision with root package name */
    protected final String f120967a = "MicroMsg.AppBrand.XWebVideoContainerChannel4AudioPlay#" + hashCode();

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final j f120968b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ag.e {
        @Override // com.tencent.luggage.wxa.ag.e
        public boolean a() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends c {
        public b(Context context) {
            super(context);
        }

        @Override // com.tencent.luggage.wxa.a8.z.c
        public View a(Context context) {
            com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.nl.b.class));
            com.tencent.luggage.wxa.tn.w.f(z.this.f120967a, "createAudioPlayView, gifCoverViewFactory is null");
            return null;
        }

        @Override // com.tencent.luggage.wxa.a8.z.c
        public Space b(Context context) {
            Space space = new Space(context);
            space.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 19.0f));
            return space;
        }
    }

    public z(j jVar) {
        this.f120968b = jVar;
    }

    @Override // com.tencent.luggage.wxa.ag.i
    public void a(View view) {
    }

    @Override // com.tencent.luggage.wxa.ag.i
    public void b(View view, Runnable runnable) {
        com.tencent.luggage.wxa.tn.w.d(this.f120967a, "transferFrom, view: " + view);
        if (runnable != null) {
            com.tencent.luggage.wxa.tn.w.d(this.f120967a, "transferFrom, run afterTransferFromTask");
            runnable.run();
        }
    }

    @Override // com.tencent.luggage.wxa.ag.i
    public View a(Context context) {
        return new b(context);
    }

    @Override // com.tencent.luggage.wxa.ag.i
    public com.tencent.luggage.wxa.ag.e a() {
        return f120965d;
    }

    @Override // com.tencent.luggage.wxa.ag.i
    public void b(View view) {
        com.tencent.luggage.wxa.tn.w.d(this.f120967a, "onPlayEndWorkaround, view: " + view);
    }

    @Override // com.tencent.luggage.wxa.ag.i
    public void a(View view, Runnable runnable) {
        com.tencent.luggage.wxa.tn.w.d(this.f120967a, "transferTo, view: " + view);
        if (runnable != null) {
            com.tencent.luggage.wxa.tn.w.d(this.f120967a, "transferTo, run afterTransferToTask");
            runnable.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public abstract class c extends LinearLayout implements com.tencent.luggage.wxa.ag.g {

        /* renamed from: a, reason: collision with root package name */
        public final Space f120970a;

        /* renamed from: b, reason: collision with root package name */
        public final View f120971b;

        /* renamed from: c, reason: collision with root package name */
        public final Space f120972c;

        public c(Context context) {
            super(context);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            setOrientation(0);
            ColorDrawable colorDrawable = new ColorDrawable(Color.argb(127, 0, 0, 0));
            if (!a(this, colorDrawable)) {
                setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(Color.parseColor("#F7F7F7")), colorDrawable}));
            }
            setGravity(16);
            Space b16 = b(context);
            this.f120970a = b16;
            addView(b16);
            View a16 = a(context);
            this.f120971b = a16;
            if (a16 == null) {
                com.tencent.luggage.wxa.tn.w.f(z.this.f120967a, "createVideoContainerView, audioPlayView is null");
            } else {
                addView(a16);
            }
            Space b17 = b(context);
            this.f120972c = b17;
            addView(b17);
        }

        public abstract View a(Context context);

        @Override // com.tencent.luggage.wxa.ag.g
        public void a(com.tencent.luggage.wxa.ag.f fVar) {
            com.tencent.luggage.wxa.tn.w.d(z.this.f120967a, "onModeConfirmed, mode: " + fVar);
            if (com.tencent.luggage.wxa.ag.f.PORTRAIT == fVar) {
                ((LinearLayout.LayoutParams) this.f120970a.getLayoutParams()).weight = 75.0f;
                ((LinearLayout.LayoutParams) this.f120972c.getLayoutParams()).weight = 75.0f;
                ((LinearLayout.LayoutParams) this.f120971b.getLayoutParams()).weight = 48.0f;
            }
        }

        public abstract Space b(Context context);

        public final boolean a(ViewGroup viewGroup, Drawable drawable) {
            l lVar = (l) z.this.f120968b.getAddOn(l.class);
            if (lVar == null) {
                com.tencent.luggage.wxa.tn.w.f(z.this.f120967a, "setBackground4AudioPlayViewContainer, videoPlayerAddOnGetSnapshot is null");
                return false;
            }
            Bitmap snapshotCached = lVar.getSnapshotCached();
            if (snapshotCached == null) {
                com.tencent.luggage.wxa.tn.w.f(z.this.f120967a, "setBackground4AudioPlayViewContainer, bitmap is null");
                return false;
            }
            com.tencent.luggage.wxa.tn.w.d(z.this.f120967a, "setBackground4AudioPlayViewContainer, real set");
            viewGroup.setBackground(new LayerDrawable(new Drawable[]{new BitmapDrawable(viewGroup.getResources(), com.tencent.luggage.wxa.tn.d.a(snapshotCached, 50)), drawable}));
            return true;
        }
    }
}
