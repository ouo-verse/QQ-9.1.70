package com.tencent.rfw.barrage.data;

import android.view.View;
import tz3.i;
import uz3.k;
import vz3.e;
import vz3.h;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWViewBarrage extends d {
    private k.a K;
    private boolean L;

    public RFWViewBarrage(i iVar) {
        super(iVar);
        this.L = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(View view) {
        if (view == null) {
            wz3.b.a("RFWBaseBarrage", "[performClick] target view should not be null.");
        } else {
            view.performClick();
        }
    }

    public k.a H0() {
        return this.K;
    }

    public boolean I0() {
        return this.L;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public int J() {
        return -2147483647;
    }

    public void K0(boolean z16) {
        this.L = z16;
    }

    public void L0(k.a aVar) {
        this.K = aVar;
    }

    @Override // com.tencent.rfw.barrage.data.a
    public e a0(h hVar) {
        k.a aVar = this.K;
        if (aVar == null) {
            wz3.b.a("RFWBaseBarrage", "[onClick] view holder should not be null.");
            return super.a0(hVar);
        }
        final View e16 = aVar.e(hVar);
        if (e16 == null) {
            wz3.b.a("RFWBaseBarrage", "[onClick] target view should not be null.");
            return super.a0(hVar);
        }
        wz3.c.a().b(new Runnable() { // from class: com.tencent.rfw.barrage.data.RFWViewBarrage.1
            @Override // java.lang.Runnable
            public void run() {
                RFWViewBarrage.this.J0(e16);
            }
        });
        return new e(e16.getId());
    }

    @Override // com.tencent.rfw.barrage.data.a
    public void g0() {
        super.g0();
        this.L = false;
    }
}
