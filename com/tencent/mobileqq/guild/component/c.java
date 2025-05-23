package com.tencent.mobileqq.guild.component;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private a f215855a;

    /* renamed from: b, reason: collision with root package name */
    private final View f215856b;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static abstract class a {
        a() {
        }

        public static a b(b bVar) {
            return new C7704c(bVar);
        }

        abstract void a(Canvas canvas);

        abstract void c(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f215857a;

        /* renamed from: b, reason: collision with root package name */
        public final float f215858b;

        /* renamed from: c, reason: collision with root package name */
        public final float f215859c;

        /* renamed from: d, reason: collision with root package name */
        public final float f215860d;

        b(float f16, float f17, float f18, float f19) {
            this.f215857a = f16;
            this.f215858b = f17;
            this.f215859c = f18;
            this.f215860d = f19;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(float f16, float f17, float f18, float f19) {
            return new b(f16, f17, f18, f19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.component.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C7704c extends a {

        /* renamed from: b, reason: collision with root package name */
        private b f215862b;

        /* renamed from: a, reason: collision with root package name */
        private final Path f215861a = new Path();

        /* renamed from: c, reason: collision with root package name */
        private final RectF f215863c = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

        C7704c(b bVar) {
            this.f215862b = bVar;
        }

        private void d() {
            this.f215861a.reset();
            Path path = this.f215861a;
            RectF rectF = this.f215863c;
            b bVar = this.f215862b;
            float f16 = bVar.f215857a;
            float f17 = bVar.f215858b;
            float f18 = bVar.f215859c;
            float f19 = bVar.f215860d;
            path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
            this.f215861a.close();
        }

        @Override // com.tencent.mobileqq.guild.component.c.a
        void a(Canvas canvas) {
            canvas.clipPath(this.f215861a);
        }

        @Override // com.tencent.mobileqq.guild.component.c.a
        void c(int i3, int i16) {
            this.f215863c.set(0.0f, 0.0f, i3, i16);
            d();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class d extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final b f215864a;

        d(b bVar) {
            this.f215864a = bVar;
        }

        static d a(b bVar) {
            return new d(bVar);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            RectF rectF = new RectF(0.0f, 0.0f, view.getMeasuredWidth(), view.getMeasuredHeight());
            Path path = new Path();
            b bVar = this.f215864a;
            float f16 = bVar.f215857a;
            float f17 = bVar.f215858b;
            float f18 = bVar.f215859c;
            float f19 = bVar.f215860d;
            path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
            path.close();
            outline.setConvexPath(path);
        }
    }

    public c(View view) {
        this.f215856b = view;
    }

    public void a(Canvas canvas) {
        this.f215855a.a(canvas);
    }

    public void b(b bVar) {
        this.f215855a = a.b(bVar);
        this.f215856b.setOutlineProvider(d.a(bVar));
        this.f215856b.setClipToOutline(true);
    }

    public void c(int i3, int i16, int i17, int i18) {
        this.f215855a.c(i3, i16);
        this.f215856b.invalidate();
    }
}
