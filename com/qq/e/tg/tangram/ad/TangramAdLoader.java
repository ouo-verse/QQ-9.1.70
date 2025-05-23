package com.qq.e.tg.tangram.ad;

import com.qq.e.comm.pi.TADLDI;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class TangramAdLoader {

    /* renamed from: a, reason: collision with root package name */
    private TADLDI f40885a;

    public TangramAdLoader(TADLDI tadldi) {
        this.f40885a = tadldi;
    }

    public final void asyncLoad(TAdRequest tAdRequest, TangramAdListener tangramAdListener) {
        if (tAdRequest != null && tangramAdListener != null && tAdRequest.isValid()) {
            TADLDI tadldi = this.f40885a;
            if (tadldi != null) {
                tadldi.asyncLoad(tAdRequest, tangramAdListener);
                return;
            }
            return;
        }
        GDTLogger.e("loading params is not valid!");
    }
}
