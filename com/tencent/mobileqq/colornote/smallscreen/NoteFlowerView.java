package com.tencent.mobileqq.colornote.smallscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.colornote.smallscreen.k;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NoteFlowerView extends View implements k.a {

    /* renamed from: d, reason: collision with root package name */
    private r[] f201658d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f201659e;

    /* renamed from: f, reason: collision with root package name */
    private q f201660f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f201661h;

    /* renamed from: i, reason: collision with root package name */
    private long f201662i;

    /* renamed from: m, reason: collision with root package name */
    private int f201663m;

    public NoteFlowerView(Context context) {
        this(context, null);
    }

    private void h() {
        r[] rVarArr = this.f201658d;
        if (rVarArr != null && rVarArr.length == this.f201660f.d()) {
            return;
        }
        this.f201658d = new r[this.f201660f.d()];
        int i3 = 0;
        while (true) {
            r[] rVarArr2 = this.f201658d;
            if (i3 < rVarArr2.length) {
                rVarArr2[i3] = new r();
                this.f201658d[i3].f(TypedValue.applyDimension(1, 1.5f, getResources().getDisplayMetrics()));
                k kVar = new k(getContext());
                kVar.h(this);
                kVar.i(this.f201659e);
                this.f201658d[i3].e(kVar);
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.k.a
    public /* synthetic */ void a(Drawable drawable) {
        j.a(this, drawable);
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.k.a
    public /* synthetic */ void b(Drawable drawable, Throwable th5) {
        j.b(this, drawable, th5);
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.k.a
    public void c(int i3) {
        if (!this.f201660f.h() && this.f201660f.e() >= 5) {
            this.f201663m = 0;
            postInvalidate();
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.k.a
    public /* synthetic */ void d(Drawable drawable, int i3) {
        j.c(this, drawable, i3);
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.k.a
    public void e(@NonNull Drawable drawable) {
        postInvalidate();
    }

    public void f(ColorNote colorNote) {
        if (colorNote == null) {
            return;
        }
        if (this.f201660f.e() < this.f201660f.d()) {
            this.f201658d[this.f201660f.e()].c(colorNote.mPicUrl, DefaultItemBuilder.i(colorNote));
        }
        this.f201660f.a();
        if (!this.f201660f.h()) {
            this.f201660f.s();
            this.f201661h = true;
        } else {
            this.f201660f.t();
        }
        this.f201663m = 0;
        postInvalidateDelayed(100L);
    }

    public int g() {
        return this.f201660f.d();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        if (this.f201661h) {
            this.f201660f.j();
            this.f201661h = false;
        }
        if (QLog.isColorLevel()) {
            if (this.f201663m == 0) {
                this.f201662i = System.currentTimeMillis();
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                QLog.d("NoteFlowerView", 2, "time cost: " + (currentTimeMillis - this.f201662i) + "ms");
                this.f201662i = currentTimeMillis;
            }
        }
        this.f201663m++;
        this.f201660f.k();
        ea1.f[] b16 = this.f201660f.b();
        for (int i3 = 0; i3 < this.f201660f.e(); i3++) {
            this.f201658d[i3].b(canvas, b16[i3]);
        }
        canvas.restore();
        if (QLog.isColorLevel()) {
            QLog.d("NoteFlowerView", 2, "onDraw cost: " + (System.currentTimeMillis() - this.f201662i) + "ms");
        }
        if (this.f201660f.h()) {
            postInvalidateDelayed(16L);
        } else if (QLog.isColorLevel()) {
            QLog.d("NoteFlowerView", 2, "total draw count: " + this.f201663m);
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.k.a
    public void onLoadSuccess(Drawable drawable) {
        if (!this.f201660f.h() && this.f201660f.e() < 5) {
            this.f201663m = 0;
            postInvalidate();
        }
    }

    public void setColorNotes(List<ColorNote> list) {
        this.f201660f.t();
        if (list == null) {
            this.f201660f.q(0);
        } else {
            int size = list.size();
            if (size > this.f201660f.d()) {
                size = this.f201660f.d();
            }
            this.f201660f.q(size);
            for (int i3 = 0; i3 < size; i3++) {
                ColorNote colorNote = list.get(i3);
                this.f201658d[(size - i3) - 1].c(colorNote.mPicUrl, DefaultItemBuilder.i(colorNote));
            }
        }
        this.f201663m = 0;
        invalidate();
    }

    public void setMaxColorNoteCount(int i3) {
        this.f201660f.r(i3);
        h();
    }

    public NoteFlowerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoteFlowerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f201661h = false;
        this.f201662i = 0L;
        this.f201663m = 0;
        this.f201659e = AppCompatResources.getDrawable(getContext(), R.drawable.f160830com);
        this.f201660f = new q(getContext());
        h();
    }
}
