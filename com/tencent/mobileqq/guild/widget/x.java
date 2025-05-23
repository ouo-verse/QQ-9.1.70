package com.tencent.mobileqq.guild.widget;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: P */
/* loaded from: classes14.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private a f236643a;

    /* renamed from: b, reason: collision with root package name */
    private final View f236644b;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    static abstract class a {
        a() {
        }

        public static a b(b bVar) {
            return new c(bVar);
        }

        abstract void a(Canvas canvas);

        abstract void c(float f16);

        abstract void d(float f16, float f17, float f18, float f19);

        abstract void e(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f236645a;

        /* renamed from: b, reason: collision with root package name */
        public final float f236646b;

        /* renamed from: c, reason: collision with root package name */
        public final float f236647c;

        /* renamed from: d, reason: collision with root package name */
        public final float f236648d;

        b(float f16, float f17, float f18, float f19) {
            this.f236645a = f16;
            this.f236646b = f17;
            this.f236647c = f18;
            this.f236648d = f19;
        }

        static b a(float f16) {
            return new b(f16, f16, f16, f16);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b b(float f16, float f17, float f18, float f19) {
            return new b(f16, f17, f18, f19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c extends a {

        /* renamed from: b, reason: collision with root package name */
        private b f236650b;

        /* renamed from: a, reason: collision with root package name */
        private final Path f236649a = new Path();

        /* renamed from: c, reason: collision with root package name */
        private final RectF f236651c = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

        c(b bVar) {
            this.f236650b = bVar;
        }

        private void f() {
            this.f236649a.reset();
            Path path = this.f236649a;
            RectF rectF = this.f236651c;
            b bVar = this.f236650b;
            float f16 = bVar.f236645a;
            float f17 = bVar.f236646b;
            float f18 = bVar.f236647c;
            float f19 = bVar.f236648d;
            path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
            this.f236649a.close();
        }

        @Override // com.tencent.mobileqq.guild.widget.x.a
        void a(Canvas canvas) {
            canvas.clipPath(this.f236649a);
        }

        @Override // com.tencent.mobileqq.guild.widget.x.a
        void c(float f16) {
            this.f236650b = b.a(f16);
            f();
        }

        @Override // com.tencent.mobileqq.guild.widget.x.a
        void d(float f16, float f17, float f18, float f19) {
            this.f236650b = b.b(f16, f17, f18, f19);
            f();
        }

        @Override // com.tencent.mobileqq.guild.widget.x.a
        void e(int i3, int i16) {
            this.f236651c.set(0.0f, 0.0f, i3, i16);
            f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    static class d extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final b f236652a;

        d(b bVar) {
            this.f236652a = bVar;
        }

        static d a(float f16) {
            return new d(b.a(f16));
        }

        static d b(float f16, float f17, float f18, float f19) {
            return new d(b.b(f16, f17, f18, f19));
        }

        static d c(b bVar) {
            return new d(bVar);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            RectF rectF = new RectF(0.0f, 0.0f, view.getMeasuredWidth(), view.getMeasuredHeight());
            Path path = new Path();
            b bVar = this.f236652a;
            float f16 = bVar.f236645a;
            float f17 = bVar.f236646b;
            float f18 = bVar.f236647c;
            float f19 = bVar.f236648d;
            path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
            path.close();
            outline.setConvexPath(path);
        }
    }

    public x(View view) {
        this.f236644b = view;
    }

    public void a(Canvas canvas) {
        this.f236643a.a(canvas);
    }

    public void b(b bVar) {
        this.f236643a = a.b(bVar);
        this.f236644b.setOutlineProvider(d.c(bVar));
        this.f236644b.setClipToOutline(true);
    }

    public void c(int i3, int i16, int i17, int i18) {
        this.f236643a.e(i3, i16);
        this.f236644b.invalidate();
    }

    public void d(float f16) {
        this.f236643a.c(f16);
        this.f236644b.setOutlineProvider(d.a(f16));
        this.f236644b.invalidate();
    }

    public void e(float f16, float f17, float f18, float f19) {
        this.f236643a.d(f16, f17, f18, f19);
        this.f236644b.setOutlineProvider(d.b(f16, f17, f18, f19));
        this.f236644b.invalidate();
    }
}
