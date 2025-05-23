package com.tencent.guild.aio.input.at.quickAt.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.quickAt.ui.a;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ThemeLabelTextView extends TextView implements a.InterfaceC1191a {

    /* renamed from: d, reason: collision with root package name */
    a f111022d;

    public ThemeLabelTextView(Context context) {
        super(context);
        a();
    }

    protected void a() {
        setSupportMaskView(false);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        a aVar = this.f111022d;
        if (aVar != null) {
            aVar.c(canvas, this);
        } else {
            super.draw(canvas);
        }
    }

    public void setMaskShape(int i3) {
        a aVar = this.f111022d;
        if (aVar != null) {
            aVar.d(i3);
        }
    }

    public void setSupportMaskView(boolean z16) {
        if (z16) {
            if (this.f111022d == null) {
                this.f111022d = new a();
            }
            this.f111022d.e(true);
            this.f111022d.f();
            setMaskShape(a.f111025k);
            return;
        }
        a aVar = this.f111022d;
        if (aVar != null) {
            aVar.e(false);
        }
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.a.InterfaceC1191a
    public void superOnDraw(Canvas canvas) {
        super.draw(canvas);
    }

    public ThemeLabelTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ThemeLabelTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
