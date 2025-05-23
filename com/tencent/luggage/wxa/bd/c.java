package com.tencent.luggage.wxa.bd;

import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements a {
    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 6) {
            return false;
        }
        return a(path, com.tencent.luggage.wxa.tk.g.a(jSONArray, 0), com.tencent.luggage.wxa.tk.g.a(jSONArray, 1), com.tencent.luggage.wxa.tk.g.a(jSONArray, 2), (float) jSONArray.optDouble(3), (float) jSONArray.optDouble(4), jSONArray.optBoolean(5));
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public String getMethod() {
        return "arcTo";
    }

    @Override // com.tencent.luggage.wxa.bd.a
    public boolean a(Path path, com.tencent.luggage.wxa.yc.a aVar) {
        com.tencent.luggage.wxa.yc.e eVar = (com.tencent.luggage.wxa.yc.e) com.tencent.luggage.wxa.tk.d.a(aVar);
        if (eVar == null) {
            return false;
        }
        return a(path, eVar.f145515b, eVar.f145516c, eVar.f145517d, eVar.f145518e, eVar.f145519f, eVar.f145520g);
    }

    public final boolean a(Path path, float f16, float f17, float f18, float f19, float f26, boolean z16) {
        float f27;
        float f28;
        float f29;
        float f36 = f16 - f18;
        float f37 = f17 - f18;
        float f38 = f16 + f18;
        float f39 = f17 + f18;
        float degrees = (float) Math.toDegrees(f19);
        float degrees2 = (float) Math.toDegrees(f26);
        float f46 = (float) (360.0d / (f18 * 6.283185307179586d));
        if (z16) {
            if (degrees - degrees2 >= 360.0f) {
                f29 = -360.0f;
            } else {
                f27 = degrees % 360.0f;
                f28 = degrees2 % 360.0f;
                if (f27 < 0.0f) {
                    f27 += 360.0f;
                }
                if (f28 < 0.0f) {
                    f28 += 360.0f;
                }
                if (f28 >= f27) {
                    f29 = (f28 - f27) - 360.0f;
                }
                f29 = f28 - f27;
            }
        } else if (degrees2 - degrees >= 360.0f) {
            f29 = 360.0f;
        } else {
            f27 = degrees % 360.0f;
            f28 = degrees2 % 360.0f;
            if (f27 < 0.0f) {
                f27 += 360.0f;
            }
            if (f28 < 0.0f) {
                f28 += 360.0f;
            }
            if (f28 < f27) {
                f28 += 360.0f;
            }
            f29 = f28 - f27;
        }
        float f47 = f29 % 360.0f;
        if (f47 <= f46 && f47 >= (-f46)) {
            path.arcTo(new RectF(f36, f37, f38, f39), degrees, f29, false);
            path.addArc(new RectF(f36, f37, f38, f39), degrees, f29);
            return true;
        }
        path.arcTo(new RectF(f36, f37, f38, f39), degrees, f29, false);
        return true;
    }
}
