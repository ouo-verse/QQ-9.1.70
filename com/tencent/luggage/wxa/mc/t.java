package com.tencent.luggage.wxa.mc;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/luggage/wxa/mc/t;", "Lcom/tencent/luggage/wxa/eo/d;", "Lcom/tencent/luggage/wxa/mc/l;", "", WadlProxyConsts.PARAM_FILENAME, "", "a", "l", "<init>", "()V", tl.h.F, "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class t extends com.tencent.luggage.wxa.eo.d implements l {

    /* renamed from: i, reason: collision with root package name */
    public static final String f134365i = "MicroMsg.Luggage.StandaloneWxaPkgPublicStorageRefCountService";

    /* renamed from: j, reason: collision with root package name */
    public static final String f134366j = "StandaloneWxaPkgPublicStorageRefCountService";

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:
    
        if (r1 == true) goto L11;
     */
    @Override // com.tencent.luggage.wxa.mc.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String fileName) {
        boolean z16;
        int i3;
        Set of5;
        boolean z17;
        if (fileName != null) {
            z16 = true;
            if (fileName.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (!z16) {
            com.tencent.luggage.wxa.tn.w.f(f134365i, "filename is empty when add ref");
            return false;
        }
        com.tencent.luggage.wxa.o3.j a16 = com.tencent.luggage.wxa.o3.l.f136139a.a();
        if (a16 != null) {
            i3 = a16.h();
        } else {
            i3 = 0;
        }
        String uin = com.tencent.luggage.wxa.y8.h.a(i3);
        com.tencent.luggage.wxa.tn.f0 f16 = com.tencent.luggage.wxa.tn.f0.f(f134366j);
        Set d16 = f16.d(fileName);
        if (d16 == null) {
            of5 = SetsKt__SetsJVMKt.setOf(uin);
            return f16.a(fileName, of5);
        }
        if (d16.isEmpty()) {
            com.tencent.luggage.wxa.tn.w.f(f134365i, "ref count = 0!, file name: " + fileName);
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        if (!d16.add(uin)) {
            return false;
        }
        return f16.a(fileName, d16);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @Override // com.tencent.luggage.wxa.mc.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(String fileName) {
        boolean z16;
        int i3;
        boolean z17;
        if (fileName != null) {
            if (fileName.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (z16) {
                    com.tencent.luggage.wxa.tn.w.f(f134365i, "filename is empty when remove ref");
                    return false;
                }
                com.tencent.luggage.wxa.o3.j a16 = com.tencent.luggage.wxa.o3.l.f136139a.a();
                if (a16 != null) {
                    i3 = a16.h();
                } else {
                    i3 = 0;
                }
                String a17 = com.tencent.luggage.wxa.y8.h.a(i3);
                com.tencent.luggage.wxa.tn.f0 f16 = com.tencent.luggage.wxa.tn.f0.f(f134366j);
                Set d16 = f16.d(fileName);
                if (d16 == null) {
                    return false;
                }
                if (d16.isEmpty()) {
                    f16.remove(fileName);
                    return true;
                }
                if (!d16.remove(a17)) {
                    return false;
                }
                if (d16.isEmpty()) {
                    f16.remove(fileName);
                    return true;
                }
                return f16.a(fileName, d16);
            }
        }
        z16 = false;
        if (z16) {
        }
    }
}
