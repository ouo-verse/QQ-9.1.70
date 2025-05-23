package com.tencent.luggage.wxa.yq;

import com.tencent.luggage.wxa.ar.b0;
import com.tencent.luggage.wxa.ar.c0;
import com.tencent.luggage.wxa.ar.d0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebDecompressor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class o {
    public static boolean a(String str, int i3, int i16, int i17) {
        x0.d("XWebPatchHelper", "doPatch, patchZipPath:" + str + ", currentVersion:" + i3 + ", newVersion:" + i16 + ", patchType:" + i17);
        if (!new File(str).exists()) {
            x0.c("XWebPatchHelper", "doPatch, no patch zip file");
            return false;
        }
        if (!XWebDecompressor.decompressDownloadByPatchType(str, u0.o(i16), i17)) {
            x0.c("XWebPatchHelper", "doPatch, decompress error");
            n0.a(37L, 1);
            return false;
        }
        ArrayList a16 = d0.a(i16, i17);
        if (a16 == null) {
            x0.c("XWebPatchHelper", "doPatch, patchFileConfigList = null");
            n0.a(38L, 1);
            return false;
        }
        if (!w.a(u0.j(i3), u0.j(i16), false)) {
            x0.c("XWebPatchHelper", "doPatch, copy all extracted file from current version error");
            n0.a(39L, 1);
            return false;
        }
        x0.d("XWebPatchHelper", "doPatch, copy all extracted file finished");
        if (!a(a16, i16)) {
            return false;
        }
        x0.d("XWebPatchHelper", "doPatch, add files finished");
        if (!b(a16, i16)) {
            return false;
        }
        x0.d("XWebPatchHelper", "doPatch, remove files finished");
        if (!a(a16, i16, i3)) {
            return false;
        }
        x0.d("XWebPatchHelper", "doPatch, patch files finished");
        return true;
    }

    public static boolean b(ArrayList arrayList, int i3) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (c0Var.e()) {
                arrayList2.add(c0Var);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            c0 c0Var2 = (c0) it5.next();
            if (!w.b(u0.a(i3, c0Var2.f121626e))) {
                x0.c("XWebPatchHelper", "doPatchRemoveFile, delete file error:" + c0Var2);
                n0.a(41L, 1);
            } else {
                x0.d("XWebPatchHelper", "doPatchRemoveFile, delete file:" + c0Var2);
            }
        }
        return true;
    }

    public static boolean a(ArrayList arrayList, int i3) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (c0Var.c()) {
                arrayList2.add(c0Var);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            c0 c0Var2 = (c0) it5.next();
            if (!w.a(u0.b(i3, c0Var2.f121626e), u0.a(i3, c0Var2.f121626e))) {
                x0.c("XWebPatchHelper", "doPatchAddFile, add file error:" + c0Var2);
                n0.a(40L, 1);
                return false;
            }
            x0.d("XWebPatchHelper", "doPatchAddFile, add file:" + c0Var2);
        }
        return true;
    }

    public static boolean a(ArrayList arrayList, int i3, int i16) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c0 c0Var = (c0) it.next();
            if (c0Var.d()) {
                arrayList2.add(c0Var);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            c0 c0Var2 = (c0) it5.next();
            if (c0Var2.a()) {
                if (b0.a(c0Var2.f121627f).a(u0.a(i16, c0Var2.f121626e), u0.b(i3, c0Var2.f121623b), u0.a(i3, c0Var2.f121626e)) < 0) {
                    x0.c("XWebPatchHelper", "doPatchModifyFile, patch error file:" + c0Var2);
                    return false;
                }
                x0.d("XWebPatchHelper", "doPatchModifyFile, patch file:" + c0Var2);
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            c0 c0Var3 = (c0) it6.next();
            if (c0Var3.b()) {
                if (b0.a(c0Var3.f121627f).a(u0.e(i16), u0.b(i3, c0Var3.f121623b), u0.e(i3)) >= 0) {
                    return true;
                }
                x0.c("XWebPatchHelper", "doPatchModifyFile, apk patch error file:" + c0Var3);
                return false;
            }
        }
        return true;
    }
}
