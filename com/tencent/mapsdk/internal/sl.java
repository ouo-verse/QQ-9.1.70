package com.tencent.mapsdk.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ZoomControls;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.bm;
import com.tencent.mapsdk.internal.ew;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sl extends eu {

    /* renamed from: a, reason: collision with root package name */
    public Context f150307a;

    /* renamed from: b, reason: collision with root package name */
    public ZoomControls f150308b;

    /* renamed from: e, reason: collision with root package name */
    tr f150311e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f150312f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f150313g;

    /* renamed from: h, reason: collision with root package name */
    Bitmap f150314h;

    /* renamed from: i, reason: collision with root package name */
    Bitmap f150315i;

    /* renamed from: j, reason: collision with root package name */
    Bitmap f150316j;

    /* renamed from: k, reason: collision with root package name */
    Bitmap f150317k;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f150320n;

    /* renamed from: c, reason: collision with root package name */
    public sk f150309c = null;

    /* renamed from: l, reason: collision with root package name */
    private ew.b f150318l = ew.b.RIGHT_BOTTOM;

    /* renamed from: d, reason: collision with root package name */
    public bm.a f150310d = null;

    /* renamed from: m, reason: collision with root package name */
    private int f150319m = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sl$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f150324a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f150325b;

        public AnonymousClass4(boolean z16, boolean z17) {
            this.f150324a = z16;
            this.f150325b = z17;
        }

        @Override // java.lang.Runnable
        public final void run() {
            sl.this.f150308b.setIsZoomInEnabled(this.f150324a);
            sl.this.f150308b.setIsZoomOutEnabled(this.f150325b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.sl$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f150327a;

        static {
            int[] iArr = new int[ew.b.values().length];
            f150327a = iArr;
            try {
                iArr[ew.b.LEFT_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150327a[ew.b.CENTER_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f150327a[ew.b.RIGHT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f150327a[ew.b.LEFT_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f150327a[ew.b.CENTER_TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f150327a[ew.b.RIGHT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public sl(Context context, tr trVar) {
        this.f150307a = context;
        this.f150311e = trVar;
    }

    private void e() {
        if (this.f150320n != null && this.f150308b != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.f150320n.indexOfChild(this.f150308b) < 0) {
                this.f150320n.addView(this.f150308b, layoutParams);
            } else {
                this.f150320n.updateViewLayout(this.f150308b, layoutParams);
            }
        }
    }

    private void f() {
        tr trVar;
        if (this.f150320n != null && this.f150309c != null && (trVar = this.f150311e) != null && trVar.e_ != 0) {
            a(((ne) trVar.d_).m());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (this.f150320n.indexOfChild(this.f150309c) < 0) {
                ZoomControls zoomControls = this.f150308b;
                if (zoomControls != null && this.f150320n.indexOfChild(zoomControls) >= 0) {
                    this.f150320n.removeViewInLayout(this.f150308b);
                    this.f150320n.addView(this.f150309c, layoutParams);
                    this.f150320n.addView(this.f150308b, layoutParams);
                    return;
                }
                this.f150320n.addView(this.f150309c, layoutParams);
                return;
            }
            this.f150320n.updateViewLayout(this.f150309c, layoutParams);
        }
    }

    private boolean g() {
        ZoomControls zoomControls = this.f150308b;
        if (zoomControls == null || zoomControls.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private FrameLayout.LayoutParams h() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int a16 = km.a(this.f150307a, 5);
        switch (AnonymousClass5.f150327a[this.f150318l.ordinal()]) {
            case 1:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = a16 * 2;
                layoutParams.leftMargin = a16;
                return layoutParams;
            case 2:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = a16;
                return layoutParams;
            case 3:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = a16 * 6;
                layoutParams.rightMargin = a16;
                return layoutParams;
            case 4:
                layoutParams.gravity = 51;
                layoutParams.topMargin = a16;
                layoutParams.leftMargin = a16;
                return layoutParams;
            case 5:
                layoutParams.gravity = 49;
                layoutParams.topMargin = a16;
                return layoutParams;
            case 6:
                layoutParams.gravity = 53;
                layoutParams.topMargin = a16;
                layoutParams.rightMargin = a16;
                return layoutParams;
            default:
                LogUtil.d("Unknown position:" + this.f150318l);
                return layoutParams;
        }
    }

    @Override // com.tencent.mapsdk.internal.fp
    public final void b(int i3, int i16) {
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final ew.b d() {
        return this.f150318l;
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final boolean a(ViewGroup viewGroup, Bundle bundle) {
        if (viewGroup == null) {
            return false;
        }
        LinearLayout linearLayout = this.f150320n;
        if (linearLayout == null || linearLayout.getParent() != viewGroup) {
            LinearLayout linearLayout2 = new LinearLayout(this.f150307a);
            this.f150320n = linearLayout2;
            linearLayout2.setOrientation(1);
            viewGroup.addView(this.f150320n);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int a16 = km.a(this.f150307a, 5);
        switch (AnonymousClass5.f150327a[this.f150318l.ordinal()]) {
            case 1:
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = a16 * 2;
                layoutParams.leftMargin = a16;
                break;
            case 2:
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = a16;
                break;
            case 3:
                layoutParams.gravity = 85;
                layoutParams.bottomMargin = a16 * 6;
                layoutParams.rightMargin = a16;
                break;
            case 4:
                layoutParams.gravity = 51;
                layoutParams.topMargin = a16;
                layoutParams.leftMargin = a16;
                break;
            case 5:
                layoutParams.gravity = 49;
                layoutParams.topMargin = a16;
                break;
            case 6:
                layoutParams.gravity = 53;
                layoutParams.topMargin = a16;
                layoutParams.rightMargin = a16;
                break;
            default:
                LogUtil.d("Unknown position:" + this.f150318l);
                break;
        }
        this.f150320n.setGravity(layoutParams.gravity);
        this.f150320n.setLayoutParams(layoutParams);
        if (this.f150313g && this.f150308b == null) {
            a(this.f150307a);
        } else {
            e();
        }
        if (this.f150312f && this.f150309c == null) {
            b(this.f150307a);
        } else {
            f();
        }
        a(v.b(bundle != null ? bundle.getInt(bm.f147892a, -1) : -1));
        this.f150320n.requestLayout();
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void c() {
        sk skVar = this.f150309c;
        if (skVar != null) {
            skVar.setClickable(false);
            Drawable background = skVar.getBackground();
            if (background != null) {
                background.setCallback(null);
            }
            skVar.setBackgroundDrawable(null);
        }
    }

    public final void b(Context context) {
        this.f150309c = new sk(context);
        Bitmap b16 = hn.b(hn.b(this.f150307a, "location_enable.png"));
        this.f150309c.setScaleType(ImageView.ScaleType.CENTER);
        this.f150309c.setImageBitmap(b16);
        this.f150309c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mapsdk.internal.sl.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                bm.a aVar = sl.this.f150310d;
                if (aVar != null) {
                    aVar.a();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        f();
    }

    private void c(boolean z16) {
        this.f150312f = z16;
        if (z16 && this.f150309c == null) {
            b(this.f150307a);
        }
        sk skVar = this.f150309c;
        if (skVar != null) {
            skVar.setVisibility(z16 ? 0 : 8);
        }
    }

    private void b(boolean z16) {
        this.f150313g = z16;
        if (z16 && this.f150308b == null) {
            a(this.f150307a);
        }
        ZoomControls zoomControls = this.f150308b;
        if (zoomControls != null) {
            zoomControls.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.tencent.mapsdk.internal.eu
    public final View[] b() {
        return new View[]{this.f150308b, this.f150309c};
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void a(ew.b bVar) {
        if (this.f150318l != bVar) {
            this.f150318l = bVar;
            a(this.f150311e.ab(), (Bundle) null);
        }
    }

    @SuppressLint({"ResourceType"})
    public final void a(Context context) {
        try {
            ZoomControls zoomControls = new ZoomControls(context);
            this.f150308b = zoomControls;
            zoomControls.setId(View.generateViewId());
            this.f150308b.setOnZoomInClickListener(new View.OnClickListener() { // from class: com.tencent.mapsdk.internal.sl.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ((VectorMap) sl.this.f150311e.e_).f151351o.f149398k.a((Runnable) null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            this.f150308b.setOnZoomOutClickListener(new View.OnClickListener() { // from class: com.tencent.mapsdk.internal.sl.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    ((VectorMap) sl.this.f150311e.e_).f151351o.f149398k.b((Runnable) null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            e();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void a(boolean z16) {
        if (this.f150309c == null) {
            return;
        }
        if (z16) {
            Bitmap bitmap = this.f150316j;
            if (bitmap == null || bitmap.isRecycled()) {
                this.f150316j = hn.b(hn.b(this.f150307a, "location_state_dark_normal.png"));
            }
            Bitmap bitmap2 = this.f150317k;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.f150317k = hn.b(hn.b(this.f150307a, "location_state_dark_selected.png"));
            }
        } else {
            Bitmap bitmap3 = this.f150314h;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                this.f150314h = hn.b(hn.b(this.f150307a, "location_state_normal.png"));
            }
            Bitmap bitmap4 = this.f150315i;
            if (bitmap4 == null || bitmap4.isRecycled()) {
                this.f150315i = hn.b(hn.b(this.f150307a, "location_state_selected.png"));
            }
        }
        this.f150309c.a(this.f150307a, z16 ? this.f150316j : this.f150314h, z16 ? this.f150317k : this.f150315i);
        this.f150309c.setVisibility(this.f150312f ? 0 : 8);
    }

    private void a(bm.a aVar) {
        this.f150310d = aVar;
    }

    private void a(boolean z16, boolean z17) {
        if (this.f150308b != null) {
            kp.a(new AnonymousClass4(z16, z17));
        }
    }

    @Override // com.tencent.mapsdk.internal.eu, com.tencent.mapsdk.internal.ew
    public final Rect a() {
        Rect rect = new Rect();
        ZoomControls zoomControls = this.f150308b;
        if (zoomControls != null && this.f150309c != null) {
            rect.bottom = Math.min(zoomControls.getBottom(), this.f150309c.getBottom());
            rect.right = Math.max(this.f150308b.getRight(), this.f150309c.getRight());
            rect.left = Math.min(this.f150308b.getLeft(), this.f150309c.getLeft());
            rect.top = Math.min(this.f150308b.getTop(), this.f150309c.getTop());
        }
        return rect;
    }
}
