package com.tencent.luggage.wxa.ad;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import com.tencent.luggage.wxa.tk.j;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends Paint implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public float f121038b;

    /* renamed from: c, reason: collision with root package name */
    public int f121039c;

    /* renamed from: d, reason: collision with root package name */
    public String f121040d;

    /* renamed from: e, reason: collision with root package name */
    public int f121041e;

    /* renamed from: a, reason: collision with root package name */
    public EnumC5993a f121037a = EnumC5993a.NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public float f121042f = Float.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public int f121043g = Integer.MAX_VALUE;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ad.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC5993a {
        NORMAL,
        TOP,
        BOTTOM,
        MIDDLE
    }

    public a() {
        d();
    }

    public a a() {
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Object a16 = j.a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a16 != null && (a16 instanceof Shader)) {
                shader = (Shader) a16;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.a(c());
        return aVar;
    }

    public float b() {
        return this.f121038b;
    }

    public EnumC5993a c() {
        return this.f121037a;
    }

    public Object clone() {
        return super.clone();
    }

    public final void d() {
        this.f121038b = 0.0f;
        this.f121039c = 0;
        this.f121040d = null;
        this.f121041e = 0;
        float f16 = this.f121042f;
        if (f16 == Float.MAX_VALUE) {
            float alpha = getAlpha() / 255.0f;
            this.f121038b = alpha;
            this.f121042f = alpha;
        } else {
            this.f121038b = f16;
        }
        int i3 = this.f121043g;
        if (i3 == Integer.MAX_VALUE) {
            int color = getColor();
            this.f121039c = color;
            this.f121043g = color;
            return;
        }
        this.f121039c = i3;
    }

    public void e() {
        reset();
        d();
    }

    @Override // android.graphics.Paint
    public void reset() {
        super.reset();
        this.f121037a = EnumC5993a.NORMAL;
    }

    @Override // android.graphics.Paint
    public void setColor(int i3) {
        this.f121039c = i3;
        super.setColor((i3 & 16777215) | ((((int) (Color.alpha(i3) * b())) & 255) << 24));
    }

    public a a(a aVar) {
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Object a16 = j.a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a16 != null && (a16 instanceof Shader)) {
                shader = (Shader) a16;
            }
            aVar.setShader(shader);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        aVar.a(c());
        return aVar;
    }

    public void a(EnumC5993a enumC5993a) {
        this.f121037a = enumC5993a;
    }

    public void a(float f16) {
        this.f121038b = f16;
        setColor(this.f121039c);
    }

    public void a(String str) {
        this.f121040d = str;
        setTypeface(Typeface.create(str, this.f121041e));
    }

    public void a(int i3) {
        this.f121041e = i3;
        setTypeface(Typeface.create(this.f121040d, i3));
    }
}
