package com.tencent.luggage.wxa.s8;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.s8.j;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements IMBFontHandler {

    /* renamed from: a, reason: collision with root package name */
    public e f140158a;

    /* renamed from: b, reason: collision with root package name */
    public f f140159b;

    /* renamed from: c, reason: collision with root package name */
    public g f140160c;

    /* renamed from: d, reason: collision with root package name */
    public j f140161d;

    /* renamed from: e, reason: collision with root package name */
    public b f140162e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f140163f = false;

    public void a(b bVar) {
        this.f140162e = bVar;
        f fVar = this.f140159b;
        if (fVar != null) {
            fVar.a(bVar);
        }
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public boolean checkAndFlushClearSignal() {
        boolean z16 = this.f140163f;
        this.f140163f = false;
        return z16;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public int[] checkAndFlushDirtySignal() {
        e eVar = this.f140158a;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public FloatBuffer drawText(String str) {
        this.f140160c.a(this.f140161d);
        FloatBuffer b16 = this.f140160c.b(str);
        if (b16 == null) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.f140161d);
            a();
            b16 = this.f140160c.b(str);
        }
        if (b16 == null) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFontManagerImpl", "drawText() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.f140161d);
            return null;
        }
        return b16;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public void enableStroke(boolean z16) {
        this.f140161d.f140167d = z16;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public Bitmap getBitmapAtlas() {
        e eVar = this.f140158a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public float getTextLineHeight(String str) {
        g gVar;
        if (str == null || str.length() == 0 || this.f140159b == null || (gVar = this.f140160c) == null) {
            return 0.0f;
        }
        gVar.a(this.f140161d);
        return this.f140160c.a(str);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public void init(int i3, int i16) {
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFontManagerImpl", "init() called with: m_atlasWidth = [" + i3 + "], m_atlasHeight = [" + i16 + "]", new Object[0]);
        this.f140158a = new e(i3, i16);
        this.f140159b = new f(this.f140162e);
        this.f140160c = new g(this.f140158a, null);
        this.f140161d = new j(null, "normal", 20.0f, false, 0.0f, j.a.NORMAL);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public String loadFont(String str) {
        return this.f140159b.c(str);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public byte[] loadFontData(String str) {
        return this.f140162e.a(str);
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public float measureText(String str) {
        this.f140160c.a(this.f140161d);
        float d16 = this.f140160c.d(str);
        if (d16 == -1.0f) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. first time, clear and retry; text = [%s]; mCurrentState = [%s]", str, this.f140161d);
            a();
            d16 = this.f140160c.d(str);
        }
        if (d16 == -1.0f) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFontManagerImpl", "measure() load result is null. atlas may be full. second time, just returned; text = [%s]; mCurrentState = [%s]", str, this.f140161d);
            return 0.0f;
        }
        return d16;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public void release() {
        e eVar = this.f140158a;
        if (eVar != null) {
            eVar.e();
            this.f140158a = null;
        }
        f fVar = this.f140159b;
        if (fVar != null) {
            fVar.a();
            this.f140159b = null;
        }
        g gVar = this.f140160c;
        if (gVar != null) {
            gVar.b();
            this.f140160c = null;
        }
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public void setStrokeWidth(float f16) {
        this.f140161d.f140168e = f16;
    }

    @Override // com.tencent.magicbrush.handler.glfont.IMBFontHandler
    public void useFont(String str, String str2, float f16, boolean z16, boolean z17) {
        j.a a16 = j.a.a(z16, z17);
        this.f140161d.f140164a = this.f140159b.a(str, a16, str2);
        j jVar = this.f140161d;
        jVar.f140165b = str2;
        jVar.f140166c = f16;
        jVar.f140169f = a16;
    }

    public final void a() {
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFontManagerImpl", "FontManager clear", new Object[0]);
        e eVar = this.f140158a;
        if (eVar != null) {
            eVar.b();
        }
        g gVar = this.f140160c;
        if (gVar != null) {
            gVar.a();
        }
        this.f140163f = true;
    }
}
