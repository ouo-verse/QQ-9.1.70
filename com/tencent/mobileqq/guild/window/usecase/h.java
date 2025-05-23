package com.tencent.mobileqq.guild.window.usecase;

import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private long f236744a;

    /* renamed from: b, reason: collision with root package name */
    private p f236745b = null;

    private boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f236744a < 900) {
            return true;
        }
        this.f236744a = currentTimeMillis;
        return false;
    }

    public p a(r rVar) {
        if (b()) {
            return this.f236745b;
        }
        if (rVar == null) {
            return null;
        }
        int i3 = 9;
        p pVar = null;
        for (p pVar2 : rVar.f228125a) {
            int i16 = pVar2.f228109q;
            if (i16 > i3 && (pVar2.f228098f == 1 || pVar2.f228101i)) {
                if (!pVar2.f228113u && !pVar2.f228112t) {
                    pVar = pVar2;
                    i3 = i16;
                }
            }
        }
        if (pVar != null) {
            p pVar3 = new p();
            this.f236745b = pVar3;
            pVar3.e(pVar);
        } else {
            this.f236745b = null;
        }
        return pVar;
    }
}
