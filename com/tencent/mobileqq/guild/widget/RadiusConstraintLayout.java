package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes14.dex */
public class RadiusConstraintLayout extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private a f236114d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static abstract class a {
        a() {
        }

        public static a b(b bVar) {
            return new c(bVar);
        }

        abstract void a(Canvas canvas);

        abstract void c(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final float f236115a;

        /* renamed from: b, reason: collision with root package name */
        public final float f236116b;

        /* renamed from: c, reason: collision with root package name */
        public final float f236117c;

        /* renamed from: d, reason: collision with root package name */
        public final float f236118d;

        b(float f16, float f17, float f18, float f19) {
            this.f236115a = f16;
            this.f236116b = f17;
            this.f236117c = f18;
            this.f236118d = f19;
        }

        static b a(float f16, float f17, float f18, float f19) {
            return new b(f16, f17, f18, f19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c extends a {

        /* renamed from: b, reason: collision with root package name */
        private b f236120b;

        /* renamed from: a, reason: collision with root package name */
        private final Path f236119a = new Path();

        /* renamed from: c, reason: collision with root package name */
        private final RectF f236121c = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

        c(b bVar) {
            this.f236120b = bVar;
        }

        @Override // com.tencent.mobileqq.guild.widget.RadiusConstraintLayout.a
        void a(Canvas canvas) {
            canvas.clipPath(this.f236119a);
        }

        @Override // com.tencent.mobileqq.guild.widget.RadiusConstraintLayout.a
        void c(int i3, int i16) {
            this.f236121c.set(0.0f, 0.0f, i3, i16);
            this.f236119a.reset();
            Path path = this.f236119a;
            RectF rectF = this.f236121c;
            b bVar = this.f236120b;
            float f16 = bVar.f236115a;
            float f17 = bVar.f236116b;
            float f18 = bVar.f236117c;
            float f19 = bVar.f236118d;
            path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
            this.f236119a.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class d extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final b f236122a;

        d(b bVar) {
            this.f236122a = bVar;
        }

        static d a(b bVar) {
            return new d(bVar);
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            RectF rectF = new RectF(0.0f, 0.0f, view.getMeasuredWidth(), view.getMeasuredHeight());
            Path path = new Path();
            b bVar = this.f236122a;
            float f16 = bVar.f236115a;
            float f17 = bVar.f236116b;
            float f18 = bVar.f236117c;
            float f19 = bVar.f236118d;
            path.addRoundRect(rectF, new float[]{f16, f16, f17, f17, f18, f18, f19, f19}, Path.Direction.CW);
            path.close();
            outline.setConvexPath(path);
        }
    }

    public RadiusConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A0(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.api.j.D3, 0, 0);
        b z06 = z0(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.f236114d = a.b(z06);
        setOutlineProvider(d.a(z06));
        setClipToOutline(true);
    }

    private static b z0(TypedArray typedArray) {
        float dimension = typedArray.getDimension(com.tencent.mobileqq.guild.api.j.G3, 0.0f);
        return b.a(typedArray.getDimension(com.tencent.mobileqq.guild.api.j.H3, dimension), typedArray.getDimension(com.tencent.mobileqq.guild.api.j.I3, dimension), typedArray.getDimension(com.tencent.mobileqq.guild.api.j.E3, dimension), typedArray.getDimension(com.tencent.mobileqq.guild.api.j.F3, dimension));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        this.f236114d.a(canvas);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int save = canvas.save();
        this.f236114d.a(canvas);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f236114d.c(i3, i16);
        invalidate();
    }

    public RadiusConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public RadiusConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        A0(context, attributeSet);
    }
}
