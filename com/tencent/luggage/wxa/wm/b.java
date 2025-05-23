package com.tencent.luggage.wxa.wm;

import android.text.TextUtils;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.om.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.y;
import com.tencent.mobileqq.app.face.util.FaceUtil;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static String a(String str) {
        return "piece" + y.a("" + str.hashCode());
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : y.a(str);
    }

    public static String c(String str) {
        v vVar = new v(g.a(), "music");
        if (!vVar.e()) {
            vVar.w();
        }
        String a16 = a(str);
        v vVar2 = new v(vVar, a16);
        w.a("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", a16, vVar2.f());
        return vVar2.g();
    }

    public static String a(com.tencent.luggage.wxa.rb.d dVar) {
        return a(dVar.f139439a, dVar.f139441c);
    }

    public static String a(int i3, String str) {
        if (i3 == 6) {
            return "6_" + b(str);
        }
        return "0_" + b(str);
    }

    public static String b(String str, boolean z16) {
        if (z16) {
            return y.a(str + FaceUtil.IMG_TEMP) + "-wifi";
        }
        return y.a(str + FaceUtil.IMG_TEMP);
    }

    public static String a(String str, boolean z16) {
        v vVar = new v(g.a(), "music");
        if (!vVar.e()) {
            w.d("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", Boolean.valueOf(vVar.w()), vVar.g());
        }
        String b16 = b(str, z16);
        v vVar2 = new v(vVar, b16);
        w.a("MicroMsg.Music.MusicFileUtil", "music name %s path %s", b16, vVar2.f());
        return vVar2.g();
    }

    public static String a() {
        return com.tencent.luggage.wxa.db.a.e();
    }
}
