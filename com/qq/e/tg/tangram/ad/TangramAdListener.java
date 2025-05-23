package com.qq.e.tg.tangram.ad;

import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.AdError;
import com.qq.e.tg.tangram.module.TangramAd;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface TangramAdListener extends ADListener {
    void onADLoaded(List<TangramAd> list);

    void onADStatusChanged(TangramAd tangramAd);

    void onNoAd(AdError adError);
}
