package com.tencent.luggage.wxa.s8;

import android.graphics.Typeface;
import android.os.Build;
import com.tencent.luggage.wxa.s8.j;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f140136a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public HashMap f140137b = new a();

    /* renamed from: c, reason: collision with root package name */
    public b f140138c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends HashMap {
        public a() {
            put(PTSNodeTextBase.WEIGHT_LIGHTER, 100);
            put("normal", 400);
            put("bold", 700);
            put("bolder", 700);
            put("100", 100);
            put("200", 200);
            put(IndividuationPlugin.Business_Font, 300);
            put(IndividuationPlugin.Business_Pendant, 400);
            put("500", 500);
            put(IndividuationPlugin.Business_Theme, 600);
            put(IndividuationPlugin.Business_Profilecard, 700);
            put(IndividuationPlugin.Business_Suit, 800);
            put("900", 900);
        }
    }

    public f(b bVar) {
        this.f140138c = bVar;
    }

    public int a(String str) {
        if (!com.tencent.luggage.wxa.w8.h.b(str) && this.f140137b.containsKey(str)) {
            return ((Integer) this.f140137b.get(str)).intValue();
        }
        return 400;
    }

    public String b(String str) {
        if (com.tencent.luggage.wxa.w8.h.b(str)) {
            return null;
        }
        if (!str.endsWith("ttf") && com.tencent.luggage.wxa.s8.a.a() != null) {
            com.tencent.luggage.wxa.s8.a.a().a(1);
        }
        try {
            return m.f140193a.a(str);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.p8.f.a("MicroMsg.MBFont", e16, "ttf parse error, path: %s", str);
            return null;
        }
    }

    public String c(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        b bVar = this.f140138c;
        if (bVar == null) {
            com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFont", "[MBFontHandler] FaceProvider is null", new Object[0]);
            return null;
        }
        String b16 = bVar.b(str);
        Typeface loadFont = this.f140138c.loadFont(b16);
        if (loadFont == null) {
            return null;
        }
        String b17 = b(b16);
        if (com.tencent.luggage.wxa.w8.h.b(b17)) {
            if (com.tencent.luggage.wxa.s8.a.a() != null) {
                com.tencent.luggage.wxa.s8.a.a().a(0);
            }
            b17 = "font" + loadFont.hashCode();
        }
        com.tencent.luggage.wxa.p8.f.c("MicroMsg.MBFont", "familyName:" + b17, new Object[0]);
        this.f140136a.put(b17, loadFont);
        return b17;
    }

    public void a(b bVar) {
        this.f140138c = bVar;
    }

    public Typeface a(String str, j.a aVar, String str2) {
        Typeface create;
        if (aVar == null) {
            aVar = j.a.NORMAL;
        }
        if (com.tencent.luggage.wxa.w8.h.b(str2) && Build.VERSION.SDK_INT >= 28) {
            create = Typeface.create(Typeface.create(str, aVar.f140175a), a(str2), aVar.c());
            return create;
        }
        if (str != null && str.length() != 0) {
            Typeface typeface = (Typeface) this.f140136a.get(str);
            if (typeface != null) {
                int style = typeface.getStyle();
                int i3 = aVar.f140175a;
                return style != i3 ? Typeface.create(typeface, i3) : typeface;
            }
            return Typeface.create(str, aVar.f140175a);
        }
        return Typeface.create((String) null, aVar.f140175a);
    }

    public void a() {
        HashMap hashMap = this.f140136a;
        if (hashMap != null) {
            hashMap.clear();
            this.f140136a = null;
        }
    }
}
