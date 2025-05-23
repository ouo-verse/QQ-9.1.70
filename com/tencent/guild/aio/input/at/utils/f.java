package com.tencent.guild.aio.input.at.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.x;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends AtTroopMemberSpan {
    private static final int P = x.a(2.0f);
    private Drawable M;
    private int N;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(Context context, String str, String str2, int i3, Paint paint, int i16, int i17, Drawable drawable) {
        super(context, str, str2, i3, paint, i16, i17, r8, "*");
        int r16;
        if (drawable == null) {
            r16 = 0;
        } else {
            r16 = r(paint);
        }
        this.N = 40;
        this.M = drawable;
        if (drawable != null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int i18 = (int) (fontMetrics.descent - fontMetrics.ascent);
            this.N = i18;
            this.M.setBounds(0, 0, i18, i18);
        }
    }

    private static int r(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return ((int) (fontMetrics.descent - fontMetrics.ascent)) + P;
    }

    @Override // com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan
    protected List<AtTroopMemberSpan.b> b(Paint paint) {
        List<AtTroopMemberSpan.b> c16 = AtTroopMemberSpan.c(this.f111089i, this.f111087f, paint, this.L);
        this.f111088h = AtTroopMemberSpan.l(c16, paint, new Rect());
        return c16;
    }

    @Override // com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        if (this.M != null) {
            canvas.save();
            canvas.translate(f16, (int) (i18 + paint.getFontMetrics().ascent));
            this.M.draw(canvas);
            canvas.restore();
            super.draw(canvas, charSequence, i3, i16, f16 + this.N + P, i17, i18, i19, paint);
            return;
        }
        super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
    }

    public String o() {
        return this.E;
    }

    public String p() {
        return this.F;
    }

    public int q() {
        return this.G;
    }

    public void s(int i3) {
        this.G = i3;
    }
}
