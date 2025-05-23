package com.tencent.av.opengl.texture;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.n;
import com.tencent.av.ui.GLVideoView;
import com.tencent.mobileqq.utils.ah;
import pv.f;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends YUVTexture {
    public static int P = 480;
    private static boolean Q = false;
    private static boolean R = false;
    private static int S = 1;
    private static String T;
    private rv.b N;
    private GLVideoView O;

    public d(Context context, GLVideoView gLVideoView, String str, long j3) {
        super(context, str, j3);
        this.N = null;
        this.O = gLVideoView;
    }

    private static void f0(Context context) {
        if (Q) {
            return;
        }
        Q = true;
        if (T == null) {
            T = ah.P();
        }
        mv.b a16 = mv.b.a();
        R = false;
        if (a16 != null && a16.f417646a == 1) {
            P = a16.f417647b;
            S = a16.f417648c;
            String str = a16.f417649d;
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(T)) {
                    String[] split = str.split("\\.");
                    String[] split2 = T.split("\\.");
                    for (int i3 = 0; i3 < 3 && i3 < split.length && i3 < split2.length; i3++) {
                        if (Integer.valueOf(split2[i3]).intValue() > Integer.valueOf(split[i3]).intValue()) {
                            R = true;
                            return;
                        } else if (Integer.valueOf(split2[i3]).intValue() < Integer.valueOf(split[i3]).intValue()) {
                            R = false;
                            return;
                        } else {
                            if (i3 == 2) {
                                R = true;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.av.opengl.texture.a
    public void A() {
        super.A();
        rv.b bVar = this.N;
        if (bVar != null) {
            bVar.i();
        }
        Q = false;
    }

    @Override // com.tencent.av.opengl.texture.YUVTexture, com.tencent.av.opengl.texture.a
    public qv.b[] s(ov.a aVar) {
        boolean z16;
        int max = Math.max(l(), k());
        f0(this.f74080q);
        if (R && N() <= P && max > (((ov.b) aVar).B() / 3) * 2 && N() < max && N() != 0 && this.O.j().size() == 0 && n.e().f().f73035i == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.N == null) {
                this.N = rv.b.c();
            }
            super.r(aVar);
            if (super.c() != null) {
                ov.b bVar = (ov.b) aVar;
                this.N.a(aVar, N(), M(), bVar.B(), bVar.A(), c()[0], c()[1], c()[2], this.f74082s, this.D, S);
            }
            return f.b(0).c();
        }
        return super.s(aVar);
    }
}
